package de.fraunhofer.ipa.ros.ide.launch;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ServerLauncher {

	private static final Logger LOGGER = Logger.getLogger(ServerLauncher.class.getName());

	public static void main(String[] args) throws InterruptedException, IOException {
		LOGGER.setLevel(Level.FINE);
		for (Handler h : Logger.getLogger("").getHandlers()) {
    		h.setLevel(Level.FINE);
		}
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.fine("Starting Xtext Language Server for ROS on port 5008");
		}
		Injector injector = Guice.createInjector(new ServerModule());
		LanguageServerImpl languageServer = injector.getInstance(LanguageServerImpl.class);
		Function<MessageConsumer, MessageConsumer> wrapper = consumer -> message ->{
			if (LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("Message received: " + message);
			}
			consumer.consume(message);
		};
		Launcher<LanguageClient> launcher = createSocketLauncher(languageServer, LanguageClient.class,
				new InetSocketAddress("localhost", 5008), Executors.newCachedThreadPool(), wrapper);
		if (launcher == null) {
			LOGGER.severe("Failed to create socket launcher");
			return;
		}
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info("Client connected, starting listening loop...");
		}	
		languageServer.connect(launcher.getRemoteProxy());
		Future<?> future = launcher.startListening();
		while (!future.isDone()) {
			Thread.sleep(10_000L);
			if (LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("Language server is running...");
			}
		}
		LOGGER.info("Language server stopped.");
	}

	static <T> Launcher<T> createSocketLauncher(Object localService, Class<T> remoteInterface,
			SocketAddress socketAddress, ExecutorService executorService,
			Function<MessageConsumer, MessageConsumer> wrapper) throws IOException {
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.fine("Waiting for client connection on " + socketAddress + "...");
		}
		AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open().bind(socketAddress);
		AsynchronousSocketChannel socketChannel;
		try {
			socketChannel = serverSocket.accept().get();
			if (LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("Client connected from " + socketChannel.getRemoteAddress());
			}
			// OutputStream loggingOutputStream = new LoggingOutputStream(Channels.newOutputStream(socketChannel));
			return Launcher.createIoLauncher(localService, remoteInterface, Channels.newInputStream(socketChannel),
					Channels.newOutputStream(socketChannel), executorService, wrapper);
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.log(Level.SEVERE, "Failed to accept client connection", e);
			// e.printStackTrace();
		}
		return null;
	}

	//     // Custom OutputStream to log outgoing messages (responses)
    // private static class LoggingOutputStream extends FilterOutputStream {
	// 	private final java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();

    //     public LoggingOutputStream(OutputStream out) {
    //         super(out);
    //     }

    //     @Override
	// 	public void write(int b) throws IOException {
	// 		buffer.write(b);  // Accumulate single bytes
	// 	}

	// 	@Override
	// 	public void write(byte[] b, int off, int len) throws IOException {
	// 		buffer.write(b, off, len);  // Accumulate byte arrays
	// 	}

	// 	@Override
	// 	public void flush() throws IOException {
	// 		if (LOGGER.isLoggable(Level.FINE) && buffer.size() > 0) {
	// 			String message = buffer.toString(StandardCharsets.UTF_8);
	// 			LOGGER.fine("Message sent: " + message);
	// 			buffer.reset();  // Clear buffer after logging
	// 		}
	// 		super.flush();  // Flush the underlying stream
	// 	}

	// 	@Override
	// 	public void close() throws IOException {
	// 		flush();  // Ensure any remaining data is logged before closing
	// 		super.close();
	// 	}
    // }
}

