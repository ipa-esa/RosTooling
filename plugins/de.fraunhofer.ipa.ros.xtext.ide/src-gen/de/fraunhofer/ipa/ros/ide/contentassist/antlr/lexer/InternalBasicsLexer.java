package de.fraunhofer.ipa.ros.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBasicsLexer extends Lexer {
    public static final int Float32_1=15;
    public static final int Node=78;
    public static final int RULE_DATE_TIME=104;
    public static final int Uint64_1=25;
    public static final int String=43;
    public static final int Int16=60;
    public static final int Float32=28;
    public static final int Goal=75;
    public static final int Bool=72;
    public static final int Uint16=54;
    public static final int Boolean=26;
    public static final int Sub=64;
    public static final int Uint8=66;
    public static final int RULE_ID=105;
    public static final int Lifecycle=12;
    public static final int RULE_DIGIT=94;
    public static final int GlobalNamespace=6;
    public static final int Int16_1=32;
    public static final int Header=42;
    public static final int RULE_INT=107;
    public static final int Byte=73;
    public static final int RULE_ML_COMMENT=114;
    public static final int LeftSquareBracket=90;
    public static final int Pluginslots=9;
    public static final int Ac=70;
    public static final int Base64=40;
    public static final int Pluginbases=8;
    public static final int Comma=86;
    public static final int As=71;
    public static final int RULE_MESSAGE_ASIGMENT=108;
    public static final int LeftSquareBracketRightSquareBracket=85;
    public static final int Int32=61;
    public static final int Char=74;
    public static final int RightCurlyBracket=93;
    public static final int RULE_DECINT=97;
    public static final int Uint32=55;
    public static final int Plugins=21;
    public static final int FullStop=87;
    public static final int RULE_HOUR=102;
    public static final int Int8=76;
    public static final int Default=18;
    public static final int Int8_1=50;
    public static final int CommercialAt=89;
    public static final int Uint16_1=23;
    public static final int Sc=79;
    public static final int Type=82;
    public static final int Float64=29;
    public static final int Int32_1=33;
    public static final int Parameter=13;
    public static final int RULE_BINARY=95;
    public static final int String_1=53;
    public static final int Active_in=11;
    public static final int String_2=22;
    public static final int Header_1=31;
    public static final int Ss=80;
    public static final int RULE_DAY=99;
    public static final int RULE_BEGIN=109;
    public static final int RULE_BOOLEAN=96;
    public static final int RelativeNamespace=4;
    public static final int RULE_YEAR=101;
    public static final int Result=51;
    public static final int Name=77;
    public static final int RULE_MIN_SEC=103;
    public static final int Implements=10;
    public static final int Char_1=48;
    public static final int ParameterAny=7;
    public static final int List=69;
    public static final int RightSquareBracket=91;
    public static final int PrivateNamespace=5;
    public static final int GraphName=14;
    public static final int Byte_1=47;
    public static final int Float64_1=16;
    public static final int Duration=19;
    public static final int Uint32_1=24;
    public static final int Double=41;
    public static final int Type_1=65;
    public static final int Value=67;
    public static final int Class=49;
    public static final int Uint64=56;
    public static final int Action=45;
    public static final int RULE_END=110;
    public static final int Message=36;
    public static final int Value_1=57;
    public static final int Loader=35;
    public static final int Time=81;
    public static final int RULE_STRING=106;
    public static final int Bool_1=46;
    public static final int Any=83;
    public static final int Struct=44;
    public static final int RULE_SL_COMMENT=111;
    public static final int Slots=52;
    public static final int Uint8_1=39;
    public static final int Format=30;
    public static final int RULE_DOUBLE=98;
    public static final int Feedback=20;
    public static final int RULE_ROS_CONVENTION_A=112;
    public static final int RULE_ROS_CONVENTION_PARAM=113;
    public static final int Colon=88;
    public static final int Pub=63;
    public static final int EOF=-1;
    public static final int Multiple=17;
    public static final int Ns=84;
    public static final int RULE_WS=115;
    public static final int Int64_1=34;
    public static final int LeftCurlyBracket=92;
    public static final int Service=38;
    public static final int RULE_ANY_OTHER=116;
    public static final int Base=59;
    public static final int Date=68;
    public static final int Integer=27;
    public static final int Array=58;
    public static final int Int64=62;
    public static final int Param=37;
    public static final int RULE_MONTH=100;

    // delegates
    // delegators

    public InternalBasicsLexer() {;} 
    public InternalBasicsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBasicsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBasicsLexer.g"; }

    // $ANTLR start "RelativeNamespace"
    public final void mRelativeNamespace() throws RecognitionException {
        try {
            int _type = RelativeNamespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:14:19: ( 'RelativeNamespace' )
            // InternalBasicsLexer.g:14:21: 'RelativeNamespace'
            {
            match("RelativeNamespace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RelativeNamespace"

    // $ANTLR start "PrivateNamespace"
    public final void mPrivateNamespace() throws RecognitionException {
        try {
            int _type = PrivateNamespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:16:18: ( 'PrivateNamespace' )
            // InternalBasicsLexer.g:16:20: 'PrivateNamespace'
            {
            match("PrivateNamespace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PrivateNamespace"

    // $ANTLR start "GlobalNamespace"
    public final void mGlobalNamespace() throws RecognitionException {
        try {
            int _type = GlobalNamespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:18:17: ( 'GlobalNamespace' )
            // InternalBasicsLexer.g:18:19: 'GlobalNamespace'
            {
            match("GlobalNamespace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GlobalNamespace"

    // $ANTLR start "ParameterAny"
    public final void mParameterAny() throws RecognitionException {
        try {
            int _type = ParameterAny;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:20:14: ( 'ParameterAny' )
            // InternalBasicsLexer.g:20:16: 'ParameterAny'
            {
            match("ParameterAny"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ParameterAny"

    // $ANTLR start "Pluginbases"
    public final void mPluginbases() throws RecognitionException {
        try {
            int _type = Pluginbases;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:22:13: ( 'pluginbases:' )
            // InternalBasicsLexer.g:22:15: 'pluginbases:'
            {
            match("pluginbases:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pluginbases"

    // $ANTLR start "Pluginslots"
    public final void mPluginslots() throws RecognitionException {
        try {
            int _type = Pluginslots;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:24:13: ( 'pluginslots:' )
            // InternalBasicsLexer.g:24:15: 'pluginslots:'
            {
            match("pluginslots:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pluginslots"

    // $ANTLR start "Implements"
    public final void mImplements() throws RecognitionException {
        try {
            int _type = Implements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:26:12: ( 'implements:' )
            // InternalBasicsLexer.g:26:14: 'implements:'
            {
            match("implements:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Implements"

    // $ANTLR start "Active_in"
    public final void mActive_in() throws RecognitionException {
        try {
            int _type = Active_in;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:28:11: ( 'active_in:' )
            // InternalBasicsLexer.g:28:13: 'active_in:'
            {
            match("active_in:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Active_in"

    // $ANTLR start "Lifecycle"
    public final void mLifecycle() throws RecognitionException {
        try {
            int _type = Lifecycle;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:30:11: ( 'lifecycle:' )
            // InternalBasicsLexer.g:30:13: 'lifecycle:'
            {
            match("lifecycle:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Lifecycle"

    // $ANTLR start "Parameter"
    public final void mParameter() throws RecognitionException {
        try {
            int _type = Parameter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:32:11: ( 'parameter:' )
            // InternalBasicsLexer.g:32:13: 'parameter:'
            {
            match("parameter:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Parameter"

    // $ANTLR start "GraphName"
    public final void mGraphName() throws RecognitionException {
        try {
            int _type = GraphName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:34:11: ( 'GraphName' )
            // InternalBasicsLexer.g:34:13: 'GraphName'
            {
            match("GraphName"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GraphName"

    // $ANTLR start "Float32_1"
    public final void mFloat32_1() throws RecognitionException {
        try {
            int _type = Float32_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:36:11: ( 'float32[]' )
            // InternalBasicsLexer.g:36:13: 'float32[]'
            {
            match("float32[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Float32_1"

    // $ANTLR start "Float64_1"
    public final void mFloat64_1() throws RecognitionException {
        try {
            int _type = Float64_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:38:11: ( 'float64[]' )
            // InternalBasicsLexer.g:38:13: 'float64[]'
            {
            match("float64[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Float64_1"

    // $ANTLR start "Multiple"
    public final void mMultiple() throws RecognitionException {
        try {
            int _type = Multiple;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:40:10: ( 'multiple:' )
            // InternalBasicsLexer.g:40:12: 'multiple:'
            {
            match("multiple:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Multiple"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:42:9: ( 'default:' )
            // InternalBasicsLexer.g:42:11: 'default:'
            {
            match("default:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Default"

    // $ANTLR start "Duration"
    public final void mDuration() throws RecognitionException {
        try {
            int _type = Duration;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:44:10: ( 'duration' )
            // InternalBasicsLexer.g:44:12: 'duration'
            {
            match("duration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Duration"

    // $ANTLR start "Feedback"
    public final void mFeedback() throws RecognitionException {
        try {
            int _type = Feedback;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:46:10: ( 'feedback' )
            // InternalBasicsLexer.g:46:12: 'feedback'
            {
            match("feedback"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Feedback"

    // $ANTLR start "Plugins"
    public final void mPlugins() throws RecognitionException {
        try {
            int _type = Plugins;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:48:9: ( 'plugins:' )
            // InternalBasicsLexer.g:48:11: 'plugins:'
            {
            match("plugins:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Plugins"

    // $ANTLR start "String_2"
    public final void mString_2() throws RecognitionException {
        try {
            int _type = String_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:50:10: ( 'string[]' )
            // InternalBasicsLexer.g:50:12: 'string[]'
            {
            match("string[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String_2"

    // $ANTLR start "Uint16_1"
    public final void mUint16_1() throws RecognitionException {
        try {
            int _type = Uint16_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:52:10: ( 'uint16[]' )
            // InternalBasicsLexer.g:52:12: 'uint16[]'
            {
            match("uint16[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint16_1"

    // $ANTLR start "Uint32_1"
    public final void mUint32_1() throws RecognitionException {
        try {
            int _type = Uint32_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:54:10: ( 'uint32[]' )
            // InternalBasicsLexer.g:54:12: 'uint32[]'
            {
            match("uint32[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint32_1"

    // $ANTLR start "Uint64_1"
    public final void mUint64_1() throws RecognitionException {
        try {
            int _type = Uint64_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:56:10: ( 'uint64[]' )
            // InternalBasicsLexer.g:56:12: 'uint64[]'
            {
            match("uint64[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint64_1"

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:58:9: ( 'Boolean' )
            // InternalBasicsLexer.g:58:11: 'Boolean'
            {
            match("Boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Boolean"

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:60:9: ( 'Integer' )
            // InternalBasicsLexer.g:60:11: 'Integer'
            {
            match("Integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Float32"
    public final void mFloat32() throws RecognitionException {
        try {
            int _type = Float32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:62:9: ( 'float32' )
            // InternalBasicsLexer.g:62:11: 'float32'
            {
            match("float32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Float32"

    // $ANTLR start "Float64"
    public final void mFloat64() throws RecognitionException {
        try {
            int _type = Float64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:64:9: ( 'float64' )
            // InternalBasicsLexer.g:64:11: 'float64'
            {
            match("float64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Float64"

    // $ANTLR start "Format"
    public final void mFormat() throws RecognitionException {
        try {
            int _type = Format;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:66:8: ( 'format:' )
            // InternalBasicsLexer.g:66:10: 'format:'
            {
            match("format:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Format"

    // $ANTLR start "Header_1"
    public final void mHeader_1() throws RecognitionException {
        try {
            int _type = Header_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:68:10: ( 'header:' )
            // InternalBasicsLexer.g:68:12: 'header:'
            {
            match("header:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Header_1"

    // $ANTLR start "Int16_1"
    public final void mInt16_1() throws RecognitionException {
        try {
            int _type = Int16_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:70:9: ( 'int16[]' )
            // InternalBasicsLexer.g:70:11: 'int16[]'
            {
            match("int16[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int16_1"

    // $ANTLR start "Int32_1"
    public final void mInt32_1() throws RecognitionException {
        try {
            int _type = Int32_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:72:9: ( 'int32[]' )
            // InternalBasicsLexer.g:72:11: 'int32[]'
            {
            match("int32[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int32_1"

    // $ANTLR start "Int64_1"
    public final void mInt64_1() throws RecognitionException {
        try {
            int _type = Int64_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:74:9: ( 'int64[]' )
            // InternalBasicsLexer.g:74:11: 'int64[]'
            {
            match("int64[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int64_1"

    // $ANTLR start "Loader"
    public final void mLoader() throws RecognitionException {
        try {
            int _type = Loader;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:76:8: ( 'loader:' )
            // InternalBasicsLexer.g:76:10: 'loader:'
            {
            match("loader:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Loader"

    // $ANTLR start "Message"
    public final void mMessage() throws RecognitionException {
        try {
            int _type = Message;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:78:9: ( 'message' )
            // InternalBasicsLexer.g:78:11: 'message'
            {
            match("message"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Message"

    // $ANTLR start "Param"
    public final void mParam() throws RecognitionException {
        try {
            int _type = Param;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:80:7: ( 'param->' )
            // InternalBasicsLexer.g:80:9: 'param->'
            {
            match("param->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Param"

    // $ANTLR start "Service"
    public final void mService() throws RecognitionException {
        try {
            int _type = Service;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:82:9: ( 'service' )
            // InternalBasicsLexer.g:82:11: 'service'
            {
            match("service"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Service"

    // $ANTLR start "Uint8_1"
    public final void mUint8_1() throws RecognitionException {
        try {
            int _type = Uint8_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:84:9: ( 'uint8[]' )
            // InternalBasicsLexer.g:84:11: 'uint8[]'
            {
            match("uint8[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint8_1"

    // $ANTLR start "Base64"
    public final void mBase64() throws RecognitionException {
        try {
            int _type = Base64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:86:8: ( 'Base64' )
            // InternalBasicsLexer.g:86:10: 'Base64'
            {
            match("Base64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Base64"

    // $ANTLR start "Double"
    public final void mDouble() throws RecognitionException {
        try {
            int _type = Double;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:88:8: ( 'Double' )
            // InternalBasicsLexer.g:88:10: 'Double'
            {
            match("Double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Double"

    // $ANTLR start "Header"
    public final void mHeader() throws RecognitionException {
        try {
            int _type = Header;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:90:8: ( 'Header' )
            // InternalBasicsLexer.g:90:10: 'Header'
            {
            match("Header"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Header"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:92:8: ( 'String' )
            // InternalBasicsLexer.g:92:10: 'String'
            {
            match("String"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Struct"
    public final void mStruct() throws RecognitionException {
        try {
            int _type = Struct;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:94:8: ( 'Struct' )
            // InternalBasicsLexer.g:94:10: 'Struct'
            {
            match("Struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Struct"

    // $ANTLR start "Action"
    public final void mAction() throws RecognitionException {
        try {
            int _type = Action;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:96:8: ( 'action' )
            // InternalBasicsLexer.g:96:10: 'action'
            {
            match("action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Action"

    // $ANTLR start "Bool_1"
    public final void mBool_1() throws RecognitionException {
        try {
            int _type = Bool_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:98:8: ( 'bool[]' )
            // InternalBasicsLexer.g:98:10: 'bool[]'
            {
            match("bool[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bool_1"

    // $ANTLR start "Byte_1"
    public final void mByte_1() throws RecognitionException {
        try {
            int _type = Byte_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:100:8: ( 'byte[]' )
            // InternalBasicsLexer.g:100:10: 'byte[]'
            {
            match("byte[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Byte_1"

    // $ANTLR start "Char_1"
    public final void mChar_1() throws RecognitionException {
        try {
            int _type = Char_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:102:8: ( 'char[]' )
            // InternalBasicsLexer.g:102:10: 'char[]'
            {
            match("char[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Char_1"

    // $ANTLR start "Class"
    public final void mClass() throws RecognitionException {
        try {
            int _type = Class;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:104:7: ( 'class:' )
            // InternalBasicsLexer.g:104:9: 'class:'
            {
            match("class:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Class"

    // $ANTLR start "Int8_1"
    public final void mInt8_1() throws RecognitionException {
        try {
            int _type = Int8_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:106:8: ( 'int8[]' )
            // InternalBasicsLexer.g:106:10: 'int8[]'
            {
            match("int8[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int8_1"

    // $ANTLR start "Result"
    public final void mResult() throws RecognitionException {
        try {
            int _type = Result;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:108:8: ( 'result' )
            // InternalBasicsLexer.g:108:10: 'result'
            {
            match("result"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Result"

    // $ANTLR start "Slots"
    public final void mSlots() throws RecognitionException {
        try {
            int _type = Slots;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:110:7: ( 'slots:' )
            // InternalBasicsLexer.g:110:9: 'slots:'
            {
            match("slots:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Slots"

    // $ANTLR start "String_1"
    public final void mString_1() throws RecognitionException {
        try {
            int _type = String_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:112:10: ( 'string' )
            // InternalBasicsLexer.g:112:12: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String_1"

    // $ANTLR start "Uint16"
    public final void mUint16() throws RecognitionException {
        try {
            int _type = Uint16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:114:8: ( 'uint16' )
            // InternalBasicsLexer.g:114:10: 'uint16'
            {
            match("uint16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint16"

    // $ANTLR start "Uint32"
    public final void mUint32() throws RecognitionException {
        try {
            int _type = Uint32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:116:8: ( 'uint32' )
            // InternalBasicsLexer.g:116:10: 'uint32'
            {
            match("uint32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint32"

    // $ANTLR start "Uint64"
    public final void mUint64() throws RecognitionException {
        try {
            int _type = Uint64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:118:8: ( 'uint64' )
            // InternalBasicsLexer.g:118:10: 'uint64'
            {
            match("uint64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint64"

    // $ANTLR start "Value_1"
    public final void mValue_1() throws RecognitionException {
        try {
            int _type = Value_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:120:9: ( 'value:' )
            // InternalBasicsLexer.g:120:11: 'value:'
            {
            match("value:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Value_1"

    // $ANTLR start "Array"
    public final void mArray() throws RecognitionException {
        try {
            int _type = Array;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:122:7: ( 'Array' )
            // InternalBasicsLexer.g:122:9: 'Array'
            {
            match("Array"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Array"

    // $ANTLR start "Base"
    public final void mBase() throws RecognitionException {
        try {
            int _type = Base;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:124:6: ( 'base:' )
            // InternalBasicsLexer.g:124:8: 'base:'
            {
            match("base:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Base"

    // $ANTLR start "Int16"
    public final void mInt16() throws RecognitionException {
        try {
            int _type = Int16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:126:7: ( 'int16' )
            // InternalBasicsLexer.g:126:9: 'int16'
            {
            match("int16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int16"

    // $ANTLR start "Int32"
    public final void mInt32() throws RecognitionException {
        try {
            int _type = Int32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:128:7: ( 'int32' )
            // InternalBasicsLexer.g:128:9: 'int32'
            {
            match("int32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int32"

    // $ANTLR start "Int64"
    public final void mInt64() throws RecognitionException {
        try {
            int _type = Int64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:130:7: ( 'int64' )
            // InternalBasicsLexer.g:130:9: 'int64'
            {
            match("int64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int64"

    // $ANTLR start "Pub"
    public final void mPub() throws RecognitionException {
        try {
            int _type = Pub;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:132:5: ( 'pub->' )
            // InternalBasicsLexer.g:132:7: 'pub->'
            {
            match("pub->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pub"

    // $ANTLR start "Sub"
    public final void mSub() throws RecognitionException {
        try {
            int _type = Sub;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:134:5: ( 'sub->' )
            // InternalBasicsLexer.g:134:7: 'sub->'
            {
            match("sub->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sub"

    // $ANTLR start "Type_1"
    public final void mType_1() throws RecognitionException {
        try {
            int _type = Type_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:136:8: ( 'type:' )
            // InternalBasicsLexer.g:136:10: 'type:'
            {
            match("type:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Type_1"

    // $ANTLR start "Uint8"
    public final void mUint8() throws RecognitionException {
        try {
            int _type = Uint8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:138:7: ( 'uint8' )
            // InternalBasicsLexer.g:138:9: 'uint8'
            {
            match("uint8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint8"

    // $ANTLR start "Value"
    public final void mValue() throws RecognitionException {
        try {
            int _type = Value;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:140:7: ( 'value' )
            // InternalBasicsLexer.g:140:9: 'value'
            {
            match("value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Value"

    // $ANTLR start "Date"
    public final void mDate() throws RecognitionException {
        try {
            int _type = Date;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:142:6: ( 'Date' )
            // InternalBasicsLexer.g:142:8: 'Date'
            {
            match("Date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Date"

    // $ANTLR start "List"
    public final void mList() throws RecognitionException {
        try {
            int _type = List;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:144:6: ( 'List' )
            // InternalBasicsLexer.g:144:8: 'List'
            {
            match("List"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "List"

    // $ANTLR start "Ac"
    public final void mAc() throws RecognitionException {
        try {
            int _type = Ac;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:146:4: ( 'ac->' )
            // InternalBasicsLexer.g:146:6: 'ac->'
            {
            match("ac->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ac"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:148:4: ( 'as->' )
            // InternalBasicsLexer.g:148:6: 'as->'
            {
            match("as->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:150:6: ( 'bool' )
            // InternalBasicsLexer.g:150:8: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bool"

    // $ANTLR start "Byte"
    public final void mByte() throws RecognitionException {
        try {
            int _type = Byte;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:152:6: ( 'byte' )
            // InternalBasicsLexer.g:152:8: 'byte'
            {
            match("byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Byte"

    // $ANTLR start "Char"
    public final void mChar() throws RecognitionException {
        try {
            int _type = Char;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:154:6: ( 'char' )
            // InternalBasicsLexer.g:154:8: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Char"

    // $ANTLR start "Goal"
    public final void mGoal() throws RecognitionException {
        try {
            int _type = Goal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:156:6: ( 'goal' )
            // InternalBasicsLexer.g:156:8: 'goal'
            {
            match("goal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Goal"

    // $ANTLR start "Int8"
    public final void mInt8() throws RecognitionException {
        try {
            int _type = Int8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:158:6: ( 'int8' )
            // InternalBasicsLexer.g:158:8: 'int8'
            {
            match("int8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int8"

    // $ANTLR start "Name"
    public final void mName() throws RecognitionException {
        try {
            int _type = Name;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:160:6: ( 'name' )
            // InternalBasicsLexer.g:160:8: 'name'
            {
            match("name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Name"

    // $ANTLR start "Node"
    public final void mNode() throws RecognitionException {
        try {
            int _type = Node;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:162:6: ( 'node' )
            // InternalBasicsLexer.g:162:8: 'node'
            {
            match("node"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Node"

    // $ANTLR start "Sc"
    public final void mSc() throws RecognitionException {
        try {
            int _type = Sc;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:164:4: ( 'sc->' )
            // InternalBasicsLexer.g:164:6: 'sc->'
            {
            match("sc->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sc"

    // $ANTLR start "Ss"
    public final void mSs() throws RecognitionException {
        try {
            int _type = Ss;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:166:4: ( 'ss->' )
            // InternalBasicsLexer.g:166:6: 'ss->'
            {
            match("ss->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ss"

    // $ANTLR start "Time"
    public final void mTime() throws RecognitionException {
        try {
            int _type = Time;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:168:6: ( 'time' )
            // InternalBasicsLexer.g:168:8: 'time'
            {
            match("time"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Time"

    // $ANTLR start "Type"
    public final void mType() throws RecognitionException {
        try {
            int _type = Type;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:170:6: ( 'type' )
            // InternalBasicsLexer.g:170:8: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Type"

    // $ANTLR start "Any"
    public final void mAny() throws RecognitionException {
        try {
            int _type = Any;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:172:5: ( 'Any' )
            // InternalBasicsLexer.g:172:7: 'Any'
            {
            match("Any"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Any"

    // $ANTLR start "Ns"
    public final void mNs() throws RecognitionException {
        try {
            int _type = Ns;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:174:4: ( 'ns:' )
            // InternalBasicsLexer.g:174:6: 'ns:'
            {
            match("ns:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ns"

    // $ANTLR start "LeftSquareBracketRightSquareBracket"
    public final void mLeftSquareBracketRightSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracketRightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:176:37: ( '[]' )
            // InternalBasicsLexer.g:176:39: '[]'
            {
            match("[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracketRightSquareBracket"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:178:7: ( ',' )
            // InternalBasicsLexer.g:178:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:180:10: ( '.' )
            // InternalBasicsLexer.g:180:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:182:7: ( ':' )
            // InternalBasicsLexer.g:182:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:184:14: ( '@' )
            // InternalBasicsLexer.g:184:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommercialAt"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:186:19: ( '[' )
            // InternalBasicsLexer.g:186:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:188:20: ( ']' )
            // InternalBasicsLexer.g:188:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:190:18: ( '{' )
            // InternalBasicsLexer.g:190:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:192:19: ( '}' )
            // InternalBasicsLexer.g:192:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:194:21: ( '0' .. '9' )
            // InternalBasicsLexer.g:194:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_BINARY"
    public final void mRULE_BINARY() throws RecognitionException {
        try {
            int _type = RULE_BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:196:13: ( ( '0b' | '0B' ) ( '0' | '1' )+ )
            // InternalBasicsLexer.g:196:15: ( '0b' | '0B' ) ( '0' | '1' )+
            {
            // InternalBasicsLexer.g:196:15: ( '0b' | '0B' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='0') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='b') ) {
                    alt1=1;
                }
                else if ( (LA1_1=='B') ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalBasicsLexer.g:196:16: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:196:21: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            // InternalBasicsLexer.g:196:27: ( '0' | '1' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='1')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBasicsLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARY"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:198:14: ( ( 'true' | 'false' ) )
            // InternalBasicsLexer.g:198:16: ( 'true' | 'false' )
            {
            // InternalBasicsLexer.g:198:16: ( 'true' | 'false' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='t') ) {
                alt3=1;
            }
            else if ( (LA3_0=='f') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalBasicsLexer.g:198:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:198:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:200:13: ( ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* ) )
            // InternalBasicsLexer.g:200:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            {
            // InternalBasicsLexer.g:200:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.'||(LA6_0>='0' && LA6_0<='9')||LA6_0=='E'||LA6_0=='e') ) {
                alt6=1;
            }
            else if ( (LA6_0=='-') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBasicsLexer.g:200:16: ( RULE_DIGIT )*
                    {
                    // InternalBasicsLexer.g:200:16: ( RULE_DIGIT )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:200:16: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:200:28: '-' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    // InternalBasicsLexer.g:200:32: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:200:32: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBasicsLexer.g:200:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalBasicsLexer.g:200:46: '.' ( RULE_DECINT )*
                    {
                    match('.'); 
                    // InternalBasicsLexer.g:200:50: ( RULE_DECINT )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='-'||(LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:200:50: RULE_DECINT
                    	    {
                    	    mRULE_DECINT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:200:63: ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )*
                    {
                    // InternalBasicsLexer.g:200:63: ( '.' ( RULE_DIGIT )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalBasicsLexer.g:200:64: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // InternalBasicsLexer.g:200:68: ( RULE_DIGIT )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalBasicsLexer.g:200:68: RULE_DIGIT
                            	    {
                            	    mRULE_DIGIT(); 

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // InternalBasicsLexer.g:200:92: ( '-' | '+' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='+'||LA10_0=='-') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalBasicsLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    // InternalBasicsLexer.g:200:103: ( RULE_DIGIT )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:200:103: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_DECINT"
    public final void mRULE_DECINT() throws RecognitionException {
        try {
            int _type = RULE_DECINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:202:13: ( ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* ) )
            // InternalBasicsLexer.g:202:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
            {
            // InternalBasicsLexer.g:202:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
            int alt15=3;
            switch ( input.LA(1) ) {
            case '0':
                {
                alt15=1;
                }
                break;
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt15=2;
                }
                break;
            case '-':
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalBasicsLexer.g:202:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:202:20: '1' .. '9' ( RULE_DIGIT )*
                    {
                    matchRange('1','9'); 
                    // InternalBasicsLexer.g:202:29: ( RULE_DIGIT )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:202:29: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // InternalBasicsLexer.g:202:41: '-' '0' .. '9' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    matchRange('0','9'); 
                    // InternalBasicsLexer.g:202:54: ( RULE_DIGIT )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:202:54: RULE_DIGIT
                    	    {
                    	    mRULE_DIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECINT"

    // $ANTLR start "RULE_DAY"
    public final void mRULE_DAY() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:204:19: ( ( '1' .. '9' | '1' .. '3' '0' .. '9' ) )
            // InternalBasicsLexer.g:204:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
            {
            // InternalBasicsLexer.g:204:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>='1' && LA16_0<='3')) ) {
                int LA16_1 = input.LA(2);

                if ( ((LA16_1>='0' && LA16_1<='9')) ) {
                    alt16=2;
                }
                else {
                    alt16=1;}
            }
            else if ( ((LA16_0>='4' && LA16_0<='9')) ) {
                alt16=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalBasicsLexer.g:204:22: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:204:31: '1' .. '3' '0' .. '9'
                    {
                    matchRange('1','3'); 
                    matchRange('0','9'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DAY"

    // $ANTLR start "RULE_MONTH"
    public final void mRULE_MONTH() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:206:21: ( ( '1' .. '9' | '1' '0' .. '2' ) )
            // InternalBasicsLexer.g:206:23: ( '1' .. '9' | '1' '0' .. '2' )
            {
            // InternalBasicsLexer.g:206:23: ( '1' .. '9' | '1' '0' .. '2' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='1') ) {
                int LA17_1 = input.LA(2);

                if ( ((LA17_1>='0' && LA17_1<='2')) ) {
                    alt17=2;
                }
                else {
                    alt17=1;}
            }
            else if ( ((LA17_0>='2' && LA17_0<='9')) ) {
                alt17=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalBasicsLexer.g:206:24: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:206:33: '1' '0' .. '2'
                    {
                    match('1'); 
                    matchRange('0','2'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_MONTH"

    // $ANTLR start "RULE_YEAR"
    public final void mRULE_YEAR() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:208:20: ( '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalBasicsLexer.g:208:22: '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9'
            {
            matchRange('0','2'); 
            matchRange('0','9'); 
            matchRange('0','9'); 
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_YEAR"

    // $ANTLR start "RULE_HOUR"
    public final void mRULE_HOUR() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:210:20: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) )
            // InternalBasicsLexer.g:210:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
            {
            // InternalBasicsLexer.g:210:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>='0' && LA18_0<='1')) ) {
                alt18=1;
            }
            else if ( (LA18_0=='2') ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalBasicsLexer.g:210:23: '0' .. '1' '0' .. '9'
                    {
                    matchRange('0','1'); 
                    matchRange('0','9'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:210:41: '2' '0' .. '3'
                    {
                    match('2'); 
                    matchRange('0','3'); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_HOUR"

    // $ANTLR start "RULE_MIN_SEC"
    public final void mRULE_MIN_SEC() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:212:23: ( '0' .. '5' '0' .. '9' )
            // InternalBasicsLexer.g:212:25: '0' .. '5' '0' .. '9'
            {
            matchRange('0','5'); 
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_MIN_SEC"

    // $ANTLR start "RULE_DATE_TIME"
    public final void mRULE_DATE_TIME() throws RecognitionException {
        try {
            int _type = RULE_DATE_TIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:214:16: ( RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC )
            // InternalBasicsLexer.g:214:18: RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC
            {
            mRULE_YEAR(); 
            match('-'); 
            mRULE_MONTH(); 
            match('-'); 
            mRULE_DAY(); 
            match('T'); 
            mRULE_HOUR(); 
            match(':'); 
            mRULE_MIN_SEC(); 
            match(':'); 
            mRULE_MIN_SEC(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DATE_TIME"

    // $ANTLR start "RULE_MESSAGE_ASIGMENT"
    public final void mRULE_MESSAGE_ASIGMENT() throws RecognitionException {
        try {
            int _type = RULE_MESSAGE_ASIGMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:216:23: ( ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT ) )
            // InternalBasicsLexer.g:216:25: ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
            {
            // InternalBasicsLexer.g:216:25: ( RULE_ID | RULE_STRING )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>='A' && LA19_0<='Z')||(LA19_0>='^' && LA19_0<='_')||(LA19_0>='a' && LA19_0<='z')) ) {
                alt19=1;
            }
            else if ( (LA19_0=='\"'||LA19_0=='\'') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalBasicsLexer.g:216:26: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:216:34: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;

            }

            match('='); 
            // InternalBasicsLexer.g:216:51: ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '^':
            case '_':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt20=1;
                }
                break;
            case '\"':
            case '\'':
                {
                alt20=2;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt20=3;
                }
                break;
            case '-':
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalBasicsLexer.g:216:52: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:216:60: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;
                case 3 :
                    // InternalBasicsLexer.g:216:72: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;
                case 4 :
                    // InternalBasicsLexer.g:216:81: '-' RULE_INT
                    {
                    match('-'); 
                    mRULE_INT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MESSAGE_ASIGMENT"

    // $ANTLR start "RULE_BEGIN"
    public final void mRULE_BEGIN() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:218:21: ()
            // InternalBasicsLexer.g:218:23: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEGIN"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            // InternalBasicsLexer.g:220:19: ()
            // InternalBasicsLexer.g:220:21: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:222:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalBasicsLexer.g:222:19: '#' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match('#'); 
            // InternalBasicsLexer.g:222:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBasicsLexer.g:222:23: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_ROS_CONVENTION_A"
    public final void mRULE_ROS_CONVENTION_A() throws RecognitionException {
        try {
            int _type = RULE_ROS_CONVENTION_A;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:224:23: ( ( '/' RULE_ID | RULE_ID '/' )* )
            // InternalBasicsLexer.g:224:25: ( '/' RULE_ID | RULE_ID '/' )*
            {
            // InternalBasicsLexer.g:224:25: ( '/' RULE_ID | RULE_ID '/' )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='/') ) {
                    alt22=1;
                }
                else if ( ((LA22_0>='A' && LA22_0<='Z')||(LA22_0>='^' && LA22_0<='_')||(LA22_0>='a' && LA22_0<='z')) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBasicsLexer.g:224:26: '/' RULE_ID
            	    {
            	    match('/'); 
            	    mRULE_ID(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalBasicsLexer.g:224:38: RULE_ID '/'
            	    {
            	    mRULE_ID(); 
            	    match('/'); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ROS_CONVENTION_A"

    // $ANTLR start "RULE_ROS_CONVENTION_PARAM"
    public final void mRULE_ROS_CONVENTION_PARAM() throws RecognitionException {
        try {
            int _type = RULE_ROS_CONVENTION_PARAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:226:27: ( ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )* )
            // InternalBasicsLexer.g:226:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
            {
            // InternalBasicsLexer.g:226:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
            loop23:
            do {
                int alt23=4;
                switch ( input.LA(1) ) {
                case '/':
                    {
                    alt23=1;
                    }
                    break;
                case '\"':
                case '\'':
                    {
                    alt23=2;
                    }
                    break;
                case '~':
                    {
                    alt23=3;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // InternalBasicsLexer.g:226:30: '/' RULE_STRING
            	    {
            	    match('/'); 
            	    mRULE_STRING(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalBasicsLexer.g:226:46: RULE_STRING '/'
            	    {
            	    mRULE_STRING(); 
            	    match('/'); 

            	    }
            	    break;
            	case 3 :
            	    // InternalBasicsLexer.g:226:62: '~' RULE_STRING
            	    {
            	    match('~'); 
            	    mRULE_STRING(); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ROS_CONVENTION_PARAM"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:228:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBasicsLexer.g:228:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBasicsLexer.g:228:11: ( '^' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='^') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBasicsLexer.g:228:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalBasicsLexer.g:228:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBasicsLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:230:10: ( ( '0' .. '9' )+ )
            // InternalBasicsLexer.g:230:12: ( '0' .. '9' )+
            {
            // InternalBasicsLexer.g:230:12: ( '0' .. '9' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>='0' && LA26_0<='9')) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBasicsLexer.g:230:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:232:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBasicsLexer.g:232:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBasicsLexer.g:232:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0=='\"') ) {
                alt29=1;
            }
            else if ( (LA29_0=='\'') ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalBasicsLexer.g:232:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBasicsLexer.g:232:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop27:
                    do {
                        int alt27=3;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0=='\\') ) {
                            alt27=1;
                        }
                        else if ( ((LA27_0>='\u0000' && LA27_0<='!')||(LA27_0>='#' && LA27_0<='[')||(LA27_0>=']' && LA27_0<='\uFFFF')) ) {
                            alt27=2;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:232:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBasicsLexer.g:232:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:232:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBasicsLexer.g:232:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop28:
                    do {
                        int alt28=3;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0=='\\') ) {
                            alt28=1;
                        }
                        else if ( ((LA28_0>='\u0000' && LA28_0<='&')||(LA28_0>='(' && LA28_0<='[')||(LA28_0>=']' && LA28_0<='\uFFFF')) ) {
                            alt28=2;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:232:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBasicsLexer.g:232:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:234:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBasicsLexer.g:234:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalBasicsLexer.g:234:24: ( options {greedy=false; } : . )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0=='*') ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1=='/') ) {
                        alt30=2;
                    }
                    else if ( ((LA30_1>='\u0000' && LA30_1<='.')||(LA30_1>='0' && LA30_1<='\uFFFF')) ) {
                        alt30=1;
                    }


                }
                else if ( ((LA30_0>='\u0000' && LA30_0<=')')||(LA30_0>='+' && LA30_0<='\uFFFF')) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBasicsLexer.g:234:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:236:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBasicsLexer.g:236:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBasicsLexer.g:236:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>='\t' && LA31_0<='\n')||LA31_0=='\r'||LA31_0==' ') ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBasicsLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:238:16: ( . )
            // InternalBasicsLexer.g:238:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalBasicsLexer.g:1:8: ( RelativeNamespace | PrivateNamespace | GlobalNamespace | ParameterAny | Pluginbases | Pluginslots | Implements | Active_in | Lifecycle | Parameter | GraphName | Float32_1 | Float64_1 | Multiple | Default | Duration | Feedback | Plugins | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Format | Header_1 | Int16_1 | Int32_1 | Int64_1 | Loader | Message | Param | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Class | Int8_1 | Result | Slots | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Int16 | Int32 | Int64 | Pub | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt32=105;
        alt32 = dfa32.predict(input);
        switch (alt32) {
            case 1 :
                // InternalBasicsLexer.g:1:10: RelativeNamespace
                {
                mRelativeNamespace(); 

                }
                break;
            case 2 :
                // InternalBasicsLexer.g:1:28: PrivateNamespace
                {
                mPrivateNamespace(); 

                }
                break;
            case 3 :
                // InternalBasicsLexer.g:1:45: GlobalNamespace
                {
                mGlobalNamespace(); 

                }
                break;
            case 4 :
                // InternalBasicsLexer.g:1:61: ParameterAny
                {
                mParameterAny(); 

                }
                break;
            case 5 :
                // InternalBasicsLexer.g:1:74: Pluginbases
                {
                mPluginbases(); 

                }
                break;
            case 6 :
                // InternalBasicsLexer.g:1:86: Pluginslots
                {
                mPluginslots(); 

                }
                break;
            case 7 :
                // InternalBasicsLexer.g:1:98: Implements
                {
                mImplements(); 

                }
                break;
            case 8 :
                // InternalBasicsLexer.g:1:109: Active_in
                {
                mActive_in(); 

                }
                break;
            case 9 :
                // InternalBasicsLexer.g:1:119: Lifecycle
                {
                mLifecycle(); 

                }
                break;
            case 10 :
                // InternalBasicsLexer.g:1:129: Parameter
                {
                mParameter(); 

                }
                break;
            case 11 :
                // InternalBasicsLexer.g:1:139: GraphName
                {
                mGraphName(); 

                }
                break;
            case 12 :
                // InternalBasicsLexer.g:1:149: Float32_1
                {
                mFloat32_1(); 

                }
                break;
            case 13 :
                // InternalBasicsLexer.g:1:159: Float64_1
                {
                mFloat64_1(); 

                }
                break;
            case 14 :
                // InternalBasicsLexer.g:1:169: Multiple
                {
                mMultiple(); 

                }
                break;
            case 15 :
                // InternalBasicsLexer.g:1:178: Default
                {
                mDefault(); 

                }
                break;
            case 16 :
                // InternalBasicsLexer.g:1:186: Duration
                {
                mDuration(); 

                }
                break;
            case 17 :
                // InternalBasicsLexer.g:1:195: Feedback
                {
                mFeedback(); 

                }
                break;
            case 18 :
                // InternalBasicsLexer.g:1:204: Plugins
                {
                mPlugins(); 

                }
                break;
            case 19 :
                // InternalBasicsLexer.g:1:212: String_2
                {
                mString_2(); 

                }
                break;
            case 20 :
                // InternalBasicsLexer.g:1:221: Uint16_1
                {
                mUint16_1(); 

                }
                break;
            case 21 :
                // InternalBasicsLexer.g:1:230: Uint32_1
                {
                mUint32_1(); 

                }
                break;
            case 22 :
                // InternalBasicsLexer.g:1:239: Uint64_1
                {
                mUint64_1(); 

                }
                break;
            case 23 :
                // InternalBasicsLexer.g:1:248: Boolean
                {
                mBoolean(); 

                }
                break;
            case 24 :
                // InternalBasicsLexer.g:1:256: Integer
                {
                mInteger(); 

                }
                break;
            case 25 :
                // InternalBasicsLexer.g:1:264: Float32
                {
                mFloat32(); 

                }
                break;
            case 26 :
                // InternalBasicsLexer.g:1:272: Float64
                {
                mFloat64(); 

                }
                break;
            case 27 :
                // InternalBasicsLexer.g:1:280: Format
                {
                mFormat(); 

                }
                break;
            case 28 :
                // InternalBasicsLexer.g:1:287: Header_1
                {
                mHeader_1(); 

                }
                break;
            case 29 :
                // InternalBasicsLexer.g:1:296: Int16_1
                {
                mInt16_1(); 

                }
                break;
            case 30 :
                // InternalBasicsLexer.g:1:304: Int32_1
                {
                mInt32_1(); 

                }
                break;
            case 31 :
                // InternalBasicsLexer.g:1:312: Int64_1
                {
                mInt64_1(); 

                }
                break;
            case 32 :
                // InternalBasicsLexer.g:1:320: Loader
                {
                mLoader(); 

                }
                break;
            case 33 :
                // InternalBasicsLexer.g:1:327: Message
                {
                mMessage(); 

                }
                break;
            case 34 :
                // InternalBasicsLexer.g:1:335: Param
                {
                mParam(); 

                }
                break;
            case 35 :
                // InternalBasicsLexer.g:1:341: Service
                {
                mService(); 

                }
                break;
            case 36 :
                // InternalBasicsLexer.g:1:349: Uint8_1
                {
                mUint8_1(); 

                }
                break;
            case 37 :
                // InternalBasicsLexer.g:1:357: Base64
                {
                mBase64(); 

                }
                break;
            case 38 :
                // InternalBasicsLexer.g:1:364: Double
                {
                mDouble(); 

                }
                break;
            case 39 :
                // InternalBasicsLexer.g:1:371: Header
                {
                mHeader(); 

                }
                break;
            case 40 :
                // InternalBasicsLexer.g:1:378: String
                {
                mString(); 

                }
                break;
            case 41 :
                // InternalBasicsLexer.g:1:385: Struct
                {
                mStruct(); 

                }
                break;
            case 42 :
                // InternalBasicsLexer.g:1:392: Action
                {
                mAction(); 

                }
                break;
            case 43 :
                // InternalBasicsLexer.g:1:399: Bool_1
                {
                mBool_1(); 

                }
                break;
            case 44 :
                // InternalBasicsLexer.g:1:406: Byte_1
                {
                mByte_1(); 

                }
                break;
            case 45 :
                // InternalBasicsLexer.g:1:413: Char_1
                {
                mChar_1(); 

                }
                break;
            case 46 :
                // InternalBasicsLexer.g:1:420: Class
                {
                mClass(); 

                }
                break;
            case 47 :
                // InternalBasicsLexer.g:1:426: Int8_1
                {
                mInt8_1(); 

                }
                break;
            case 48 :
                // InternalBasicsLexer.g:1:433: Result
                {
                mResult(); 

                }
                break;
            case 49 :
                // InternalBasicsLexer.g:1:440: Slots
                {
                mSlots(); 

                }
                break;
            case 50 :
                // InternalBasicsLexer.g:1:446: String_1
                {
                mString_1(); 

                }
                break;
            case 51 :
                // InternalBasicsLexer.g:1:455: Uint16
                {
                mUint16(); 

                }
                break;
            case 52 :
                // InternalBasicsLexer.g:1:462: Uint32
                {
                mUint32(); 

                }
                break;
            case 53 :
                // InternalBasicsLexer.g:1:469: Uint64
                {
                mUint64(); 

                }
                break;
            case 54 :
                // InternalBasicsLexer.g:1:476: Value_1
                {
                mValue_1(); 

                }
                break;
            case 55 :
                // InternalBasicsLexer.g:1:484: Array
                {
                mArray(); 

                }
                break;
            case 56 :
                // InternalBasicsLexer.g:1:490: Base
                {
                mBase(); 

                }
                break;
            case 57 :
                // InternalBasicsLexer.g:1:495: Int16
                {
                mInt16(); 

                }
                break;
            case 58 :
                // InternalBasicsLexer.g:1:501: Int32
                {
                mInt32(); 

                }
                break;
            case 59 :
                // InternalBasicsLexer.g:1:507: Int64
                {
                mInt64(); 

                }
                break;
            case 60 :
                // InternalBasicsLexer.g:1:513: Pub
                {
                mPub(); 

                }
                break;
            case 61 :
                // InternalBasicsLexer.g:1:517: Sub
                {
                mSub(); 

                }
                break;
            case 62 :
                // InternalBasicsLexer.g:1:521: Type_1
                {
                mType_1(); 

                }
                break;
            case 63 :
                // InternalBasicsLexer.g:1:528: Uint8
                {
                mUint8(); 

                }
                break;
            case 64 :
                // InternalBasicsLexer.g:1:534: Value
                {
                mValue(); 

                }
                break;
            case 65 :
                // InternalBasicsLexer.g:1:540: Date
                {
                mDate(); 

                }
                break;
            case 66 :
                // InternalBasicsLexer.g:1:545: List
                {
                mList(); 

                }
                break;
            case 67 :
                // InternalBasicsLexer.g:1:550: Ac
                {
                mAc(); 

                }
                break;
            case 68 :
                // InternalBasicsLexer.g:1:553: As
                {
                mAs(); 

                }
                break;
            case 69 :
                // InternalBasicsLexer.g:1:556: Bool
                {
                mBool(); 

                }
                break;
            case 70 :
                // InternalBasicsLexer.g:1:561: Byte
                {
                mByte(); 

                }
                break;
            case 71 :
                // InternalBasicsLexer.g:1:566: Char
                {
                mChar(); 

                }
                break;
            case 72 :
                // InternalBasicsLexer.g:1:571: Goal
                {
                mGoal(); 

                }
                break;
            case 73 :
                // InternalBasicsLexer.g:1:576: Int8
                {
                mInt8(); 

                }
                break;
            case 74 :
                // InternalBasicsLexer.g:1:581: Name
                {
                mName(); 

                }
                break;
            case 75 :
                // InternalBasicsLexer.g:1:586: Node
                {
                mNode(); 

                }
                break;
            case 76 :
                // InternalBasicsLexer.g:1:591: Sc
                {
                mSc(); 

                }
                break;
            case 77 :
                // InternalBasicsLexer.g:1:594: Ss
                {
                mSs(); 

                }
                break;
            case 78 :
                // InternalBasicsLexer.g:1:597: Time
                {
                mTime(); 

                }
                break;
            case 79 :
                // InternalBasicsLexer.g:1:602: Type
                {
                mType(); 

                }
                break;
            case 80 :
                // InternalBasicsLexer.g:1:607: Any
                {
                mAny(); 

                }
                break;
            case 81 :
                // InternalBasicsLexer.g:1:611: Ns
                {
                mNs(); 

                }
                break;
            case 82 :
                // InternalBasicsLexer.g:1:614: LeftSquareBracketRightSquareBracket
                {
                mLeftSquareBracketRightSquareBracket(); 

                }
                break;
            case 83 :
                // InternalBasicsLexer.g:1:650: Comma
                {
                mComma(); 

                }
                break;
            case 84 :
                // InternalBasicsLexer.g:1:656: FullStop
                {
                mFullStop(); 

                }
                break;
            case 85 :
                // InternalBasicsLexer.g:1:665: Colon
                {
                mColon(); 

                }
                break;
            case 86 :
                // InternalBasicsLexer.g:1:671: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 87 :
                // InternalBasicsLexer.g:1:684: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 88 :
                // InternalBasicsLexer.g:1:702: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 89 :
                // InternalBasicsLexer.g:1:721: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 90 :
                // InternalBasicsLexer.g:1:738: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 91 :
                // InternalBasicsLexer.g:1:756: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 92 :
                // InternalBasicsLexer.g:1:768: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 93 :
                // InternalBasicsLexer.g:1:781: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 94 :
                // InternalBasicsLexer.g:1:793: RULE_DECINT
                {
                mRULE_DECINT(); 

                }
                break;
            case 95 :
                // InternalBasicsLexer.g:1:805: RULE_DATE_TIME
                {
                mRULE_DATE_TIME(); 

                }
                break;
            case 96 :
                // InternalBasicsLexer.g:1:820: RULE_MESSAGE_ASIGMENT
                {
                mRULE_MESSAGE_ASIGMENT(); 

                }
                break;
            case 97 :
                // InternalBasicsLexer.g:1:842: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 98 :
                // InternalBasicsLexer.g:1:858: RULE_ROS_CONVENTION_A
                {
                mRULE_ROS_CONVENTION_A(); 

                }
                break;
            case 99 :
                // InternalBasicsLexer.g:1:880: RULE_ROS_CONVENTION_PARAM
                {
                mRULE_ROS_CONVENTION_PARAM(); 

                }
                break;
            case 100 :
                // InternalBasicsLexer.g:1:906: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 101 :
                // InternalBasicsLexer.g:1:914: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 102 :
                // InternalBasicsLexer.g:1:923: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 103 :
                // InternalBasicsLexer.g:1:935: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 104 :
                // InternalBasicsLexer.g:1:951: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 105 :
                // InternalBasicsLexer.g:1:959: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA12_eotS =
        "\1\uffff\1\5\1\uffff\2\5\1\uffff\2\5";
    static final String DFA12_eofS =
        "\10\uffff";
    static final String DFA12_minS =
        "\1\56\1\60\1\uffff\2\60\1\uffff\2\60";
    static final String DFA12_maxS =
        "\2\145\1\uffff\2\145\1\uffff\2\145";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA12_specialS =
        "\10\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1\26\uffff\1\2\37\uffff\1\2",
            "\1\3\11\4\13\uffff\1\2\37\uffff\1\2",
            "",
            "\1\3\11\4\13\uffff\1\2\37\uffff\1\2",
            "\1\6\11\7\13\uffff\1\2\37\uffff\1\2",
            "",
            "\1\6\11\7\13\uffff\1\2\37\uffff\1\2",
            "\1\6\11\7\13\uffff\1\2\37\uffff\1\2"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "200:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )";
        }
    }
    static final String DFA32_eotS =
        "\1\57\33\65\1\155\1\uffff\1\160\5\uffff\2\170\1\157\1\62\1\170\1\62\1\65\2\62\1\uffff\1\62\1\uffff\1\62\2\uffff\2\65\2\uffff\65\65\13\uffff\1\u00c0\1\uffff\1\170\1\157\2\170\1\65\2\uffff\1\u00c4\2\uffff\1\u00c4\4\uffff\13\65\2\uffff\16\65\2\uffff\21\65\1\u00f4\7\65\1\uffff\1\u00c0\1\uffff\2\170\3\uffff\7\65\1\uffff\4\65\1\u010a\16\65\1\uffff\6\65\1\u0123\3\65\1\u0128\1\u012a\1\65\1\u012d\4\65\1\uffff\1\u0133\1\u0134\1\u0135\1\u0136\1\u0137\1\u0138\1\u0139\1\u00c0\1\170\10\65\1\u0146\1\u0148\1\u014a\2\uffff\7\65\1\u0135\12\65\1\u015e\5\65\1\uffff\3\65\7\uffff\2\65\1\u016a\1\u016b\10\uffff\1\u00c0\1\uffff\7\65\1\uffff\1\65\6\uffff\1\65\1\u0176\12\65\1\u0182\1\65\1\uffff\1\u0185\1\u0187\1\u0189\2\uffff\1\65\1\u018b\2\65\1\u018e\1\u018f\1\u0190\1\u0191\1\uffff\1\u0192\3\uffff\12\65\1\uffff\1\65\1\uffff\1\u01a0\1\u01a2\1\65\1\uffff\1\65\1\u01a5\2\65\2\uffff\1\u01a8\6\uffff\1\u01a9\1\uffff\1\u01aa\6\uffff\7\65\1\uffff\4\65\4\uffff\1\u01b6\1\65\2\uffff\1\u01b8\3\uffff\4\65\1\u01bd\6\65\3\uffff\4\65\1\uffff\2\65\1\uffff\1\65\2\uffff\6\65\1\uffff\2\65\1\u01d3\1\65\2\uffff\2\65\1\uffff\6\65\1\u01dd\1\65\1\u01df\1\uffff\1\u01e0\2\uffff";
    static final String DFA32_eofS =
        "\u01e1\uffff";
    static final String DFA32_minS =
        "\1\0\33\57\1\135\1\uffff\1\55\5\uffff\2\56\1\57\2\56\1\101\1\57\2\0\1\uffff\1\42\1\uffff\1\42\2\uffff\2\57\2\uffff\11\57\2\55\16\57\2\55\32\57\13\uffff\1\56\1\uffff\1\56\1\57\2\56\1\57\2\0\1\57\2\0\1\57\4\uffff\7\57\1\55\3\57\2\uffff\15\57\1\55\2\uffff\31\57\1\uffff\1\56\1\uffff\2\56\1\0\1\uffff\1\0\7\57\1\uffff\23\57\1\uffff\22\57\1\uffff\7\57\2\55\6\57\1\55\4\57\2\uffff\30\57\1\uffff\3\57\7\uffff\4\57\10\uffff\1\56\1\uffff\7\57\1\uffff\1\57\6\uffff\16\57\1\uffff\3\57\2\uffff\10\57\1\uffff\1\57\3\uffff\12\57\1\uffff\1\57\1\uffff\3\57\1\uffff\4\57\2\uffff\1\57\6\uffff\1\57\1\uffff\1\57\6\uffff\7\57\1\uffff\4\57\4\uffff\2\57\2\uffff\1\57\3\uffff\13\57\3\uffff\4\57\1\uffff\2\57\1\uffff\1\57\2\uffff\6\57\1\uffff\4\57\2\uffff\2\57\1\uffff\11\57\1\uffff\1\57\2\uffff";
    static final String DFA32_maxS =
        "\1\uffff\33\172\1\135\1\uffff\1\145\5\uffff\2\145\1\172\2\145\2\172\2\uffff\1\uffff\1\172\1\uffff\1\47\2\uffff\2\172\2\uffff\65\172\13\uffff\1\145\1\uffff\1\145\1\172\2\145\1\172\2\uffff\1\75\2\uffff\1\75\4\uffff\13\172\2\uffff\16\172\2\uffff\31\172\1\uffff\1\145\1\uffff\2\145\1\uffff\1\uffff\1\uffff\7\172\1\uffff\23\172\1\uffff\22\172\1\uffff\7\172\2\145\13\172\2\uffff\30\172\1\uffff\3\172\7\uffff\4\172\10\uffff\1\145\1\uffff\7\172\1\uffff\1\172\6\uffff\16\172\1\uffff\3\172\2\uffff\10\172\1\uffff\1\172\3\uffff\12\172\1\uffff\1\172\1\uffff\3\172\1\uffff\4\172\2\uffff\1\172\6\uffff\1\172\1\uffff\1\172\6\uffff\7\172\1\uffff\4\172\4\uffff\2\172\2\uffff\1\172\3\uffff\13\172\3\uffff\4\172\1\uffff\2\172\1\uffff\1\172\2\uffff\6\172\1\uffff\4\172\2\uffff\2\172\1\uffff\11\172\1\uffff\1\172\2\uffff";
    static final String DFA32_acceptS =
        "\35\uffff\1\123\1\uffff\1\125\1\126\1\130\1\131\1\132\11\uffff\1\141\1\uffff\1\142\1\uffff\1\150\1\151\2\uffff\1\144\1\140\65\uffff\1\122\1\127\1\123\1\135\1\124\1\125\1\126\1\130\1\131\1\132\1\133\1\uffff\1\136\13\uffff\1\141\1\147\1\143\1\150\13\uffff\1\103\1\104\16\uffff\1\114\1\115\31\uffff\1\121\1\uffff\1\145\3\uffff\1\146\10\uffff\1\74\23\uffff\1\75\22\uffff\1\120\24\uffff\1\57\1\111\30\uffff\1\101\3\uffff\1\53\1\105\1\54\1\106\1\70\1\55\1\107\4\uffff\1\76\1\117\1\116\1\134\1\102\1\110\1\112\1\113\1\uffff\1\137\7\uffff\1\42\1\uffff\1\35\1\71\1\36\1\72\1\37\1\73\16\uffff\1\61\3\uffff\1\44\1\77\10\uffff\1\56\1\uffff\1\66\1\100\1\67\12\uffff\1\52\1\uffff\1\40\3\uffff\1\33\4\uffff\1\23\1\62\1\uffff\1\24\1\63\1\25\1\64\1\26\1\65\1\uffff\1\45\1\uffff\1\34\1\46\1\47\1\50\1\51\1\60\7\uffff\1\22\4\uffff\1\14\1\31\1\15\1\32\2\uffff\1\41\1\17\1\uffff\1\43\1\27\1\30\13\uffff\1\21\1\16\1\20\4\uffff\1\13\2\uffff\1\12\1\uffff\1\10\1\11\6\uffff\1\7\4\uffff\1\5\1\6\2\uffff\1\4\11\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA32_specialS =
        "\1\5\52\uffff\1\7\1\3\121\uffff\1\10\1\6\1\uffff\1\0\1\2\100\uffff\1\4\1\uffff\1\1\u011b\uffff}>";
    static final String[] DFA32_transitionS = {
            "\11\62\2\61\2\62\1\61\22\62\1\61\1\62\1\53\1\55\3\62\1\54\4\62\1\35\1\47\1\36\1\56\1\44\2\45\7\50\1\37\5\62\1\40\1\27\1\15\1\52\1\20\1\46\1\52\1\3\1\21\1\16\2\52\1\31\3\52\1\2\1\52\1\1\1\22\7\52\1\34\1\62\1\41\1\51\1\52\1\62\1\6\1\23\1\24\1\12\1\46\1\10\1\32\1\17\1\5\2\52\1\7\1\11\1\33\1\52\1\4\1\52\1\25\1\13\1\30\1\14\1\26\4\52\1\42\1\62\1\43\1\60\uff81\62",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\63\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\70\20\64\1\67\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\71\5\64\1\72\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\74\12\64\1\73\10\64\1\75\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\76\1\77\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\100\17\64\1\101\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\102\5\64\1\103\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\107\3\64\1\105\6\64\1\104\2\64\1\106\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\111\17\64\1\110\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\112\17\64\1\113\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\120\1\64\1\115\6\64\1\116\6\64\1\121\1\114\1\117\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\122\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\124\15\64\1\123\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\125\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\126\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\130\15\64\1\127\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\131\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\132\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\135\15\64\1\133\11\64\1\134\1\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\136\3\64\1\137\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\140\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\141\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\143\3\64\1\142\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\145\10\64\1\146\6\64\1\144\1\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\147\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\150\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\151\15\64\1\152\3\64\1\153\7\64",
            "\1\154",
            "",
            "\1\157\2\uffff\12\157\13\uffff\1\157\37\uffff\1\157",
            "",
            "",
            "",
            "",
            "",
            "\1\157\1\uffff\12\167\10\uffff\1\166\2\uffff\1\157\34\uffff\1\166\2\uffff\1\157",
            "\1\157\1\uffff\12\171\13\uffff\1\157\37\uffff\1\157",
            "\1\57\12\172\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\157\1\uffff\12\173\13\uffff\1\157\37\uffff\1\157",
            "\1\157\1\uffff\12\174\13\uffff\1\157\37\uffff\1\157",
            "\32\175\4\uffff\1\175\1\uffff\32\175",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\42\177\1\u0080\71\177\1\176\uffa3\177",
            "\47\u0082\1\u0083\64\u0082\1\u0081\uffa3\u0082",
            "",
            "\1\u0086\4\uffff\1\u0086\2\uffff\1\u0085\26\uffff\32\57\3\uffff\2\57\1\uffff\32\57",
            "",
            "\1\u0086\4\uffff\1\u0086",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u0088\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u0089\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u008a\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u008b\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u008c\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u008d\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u008e\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\64\1\u008f\30\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u0090\12\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0091\6\64",
            "\1\u0093\1\uffff\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0092\6\64",
            "\1\u0094\1\uffff\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\5\64\1\u0095\24\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0096\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u0097\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0098\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u0099\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u009a\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u009b\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u009c\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\5\64\1\u009d\24\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u009e\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u009f\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00a0\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u00a1\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\64\1\u00a2\30\64",
            "\1\u00a3\1\uffff\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u00a4\1\uffff\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u00a5\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u00a6\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00a7\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00a8\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00a9\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00aa\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00ab\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00ac\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00ad\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u00ae\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00af\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00b0\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00b1\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00b2\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00b3\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00b4\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00b5\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\30\64\1\u00b6\1\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u00b7\12\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u00b8\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00b9\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00ba\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00bb\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u00bc\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u00bd\26\64",
            "\1\57\12\64\1\u00be\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157\1\uffff\12\u00bf\13\uffff\1\157\37\uffff\1\157",
            "",
            "\1\157\1\uffff\12\u00c1\13\uffff\1\157\37\uffff\1\157",
            "\1\57\12\172\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\157\1\uffff\12\u00c2\13\uffff\1\157\37\uffff\1\157",
            "\1\157\1\uffff\12\174\13\uffff\1\157\37\uffff\1\157",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\0\u00c3",
            "\42\177\1\u0080\71\177\1\176\uffa3\177",
            "\1\u0086\15\uffff\1\66",
            "\0\u00c5",
            "\47\u0082\1\u0083\64\u0082\1\u0081\uffa3\u0082",
            "\1\u0086\15\uffff\1\66",
            "",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00c6\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\25\64\1\u00c7\4\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00c8\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\64\1\u00c9\30\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u00ca\12\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\6\64\1\u00cb\23\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00cc\31\64",
            "\1\u00cd\1\uffff\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00ce\16\64",
            "\1\57\1\64\1\u00cf\1\64\1\u00d0\2\64\1\u00d1\1\64\1\u00d2\1\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u00d3\21\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00d4\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u00d5\26\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00d6\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u00d7\26\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u00d8\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00d9\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00da\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00db\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00dc\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00dd\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u00de\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\25\64\1\u00df\4\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00e0\6\64",
            "\1\u00e1\1\uffff\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00e2\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00e3\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00e4\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00e5\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u00e6\26\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\64\1\u00e7\30\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00e8\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\3\64\1\u00e9\26\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u00ea\13\64\1\u00eb\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00ec\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00ed\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00ee\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u00ef\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u00f0\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00f1\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u00f2\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00f3\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00f5\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00f6\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00f7\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00f8\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u00f9\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00fa\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u00fb\25\64",
            "",
            "\1\157\1\uffff\12\u00fc\13\uffff\1\157\37\uffff\1\157",
            "",
            "\1\157\1\uffff\12\u00fd\13\uffff\1\157\37\uffff\1\157",
            "\1\157\1\uffff\12\u00c2\13\uffff\1\157\37\uffff\1\157",
            "\42\177\1\u0080\71\177\1\176\uffa3\177",
            "",
            "\47\u0082\1\u0083\64\u0082\1\u0081\uffa3\u0082",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u00fe\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u00ff\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u0100\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0101\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\7\64\1\u0102\22\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u0103\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u0104\15\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0105\25\64",
            "\1\57\6\64\1\u0106\3\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\2\64\1\u0107\7\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\4\64\1\u0108\5\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0109\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u010c\6\64\1\u010b\4\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u010d\27\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u010e\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u010f\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\64\1\u0110\30\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0111\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0112\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u0113\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0114\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\24\64\1\u0115\5\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0116\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u0117\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u0118\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u0119\7\64",
            "",
            "\1\57\1\64\1\u011a\1\64\1\u011b\2\64\1\u011c\1\64\1\u011d\1\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u011e\25\64",
            "\1\57\6\64\1\u011f\3\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\6\64\1\u0120\23\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0121\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u0122\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0124\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u0125\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u0126\27\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0127\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0129\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\1\u012b\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u012c\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u012e\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u012f\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0130\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\30\64\1\u0131\1\64",
            "",
            "\1\57\12\64\1\u0132\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\u013b\1\157\1\uffff\12\u013a\13\uffff\1\157\37\uffff\1\157",
            "\1\u013b\1\157\1\uffff\12\174\13\uffff\1\157\37\uffff\1\157",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u013c\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u013d\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u013e\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u013f\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\15\64\1\u0140\14\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u0141\14\64",
            "\1\u0143\1\uffff\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0142\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u0144\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0145\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0147\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0149\3\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u014b\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u014c\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\30\64\1\u014d\1\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u014e\10\64",
            "\1\57\3\64\1\u014f\2\64\1\u0150\3\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0151\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0152\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u0153\12\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\6\64\1\u0154\23\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u0155\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u0156\21\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\6\64\1\u0157\23\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u0158\27\64",
            "\1\57\12\64\1\u0159\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\6\64\1\u015a\3\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\2\64\1\u015b\7\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\4\64\1\u015c\5\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u015d\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u015f\31\64",
            "\1\57\4\64\1\u0160\5\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0161\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u0162\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0163\25\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u0164\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\6\64\1\u0165\23\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0166\6\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\64\1\u0167\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0168\6\64",
            "\1\57\12\64\1\u0169\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157\1\uffff\12\u013a\13\uffff\1\157\37\uffff\1\157",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\25\64\1\u016c\4\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u016d\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u016e\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\15\64\1\u016f\14\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0170\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\64\1\u0171\20\64\1\u0172\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u0173\6\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0174\25\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\u0175\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u0177\27\64",
            "\1\57\12\64\1\u0178\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\2\64\1\u0179\7\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\4\64\1\u017a\5\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u017b\27\64",
            "\1\57\12\64\1\u017c\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u017d\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u017e\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u017f\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u0180\13\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0181\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0183\25\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0184\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0186\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u0188\3\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u018a\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u018c\10\64",
            "\1\57\12\64\1\u018d\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0193\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\15\64\1\u0194\14\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u0195\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0196\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u0197\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u0198\31\64",
            "\1\57\12\64\1\u019a\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u0199\16\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u019b\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u019c\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\10\64\1\u019d\21\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\13\64\1\u019e\16\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u019f\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\1\u01a1\3\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\12\64\1\u01a3\17\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01a4\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\1\u01a6\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u01a7\14\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\15\64\1\u01ab\14\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u01ac\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u01ad\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u01ae\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01af\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u01b0\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\16\64\1\u01b1\13\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\21\64\1\u01b2\10\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u01b3\6\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u01b4\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01b5\25\64",
            "",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\1\u01b7\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u01b9\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u01ba\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\1\u01bb\31\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01bc\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01be\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\23\64\1\u01bf\6\64",
            "\1\57\12\64\1\u01c0\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u01c1\7\64",
            "\1\57\12\64\1\u01c2\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\1\u01c3\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\14\64\1\u01c4\15\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01c5\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\15\64\1\u01c6\14\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u01c7\7\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u01c8\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u01c9\7\64",
            "",
            "\1\57\12\64\1\u01ca\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01cb\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u01cc\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\30\64\1\u01cd\1\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u01ce\12\64",
            "\1\57\12\64\1\u01cf\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\1\u01d0\2\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\22\64\1\u01d1\7\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u01d2\12\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u01d4\31\64",
            "",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\17\64\1\u01d5\12\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u01d6\31\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u01d7\27\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\1\u01d8\31\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u01d9\27\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01da\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\2\64\1\u01db\27\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01dc\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\4\64\1\u01de\25\64",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( RelativeNamespace | PrivateNamespace | GlobalNamespace | ParameterAny | Pluginbases | Pluginslots | Implements | Active_in | Lifecycle | Parameter | GraphName | Float32_1 | Float64_1 | Multiple | Default | Duration | Feedback | Plugins | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Format | Header_1 | Int16_1 | Int32_1 | Int64_1 | Loader | Message | Param | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Class | Int8_1 | Result | Slots | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Int16 | Int32 | Int64 | Pub | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_129 = input.LA(1);

                        s = -1;
                        if ( ((LA32_129>='\u0000' && LA32_129<='\uFFFF')) ) {s = 197;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_197 = input.LA(1);

                        s = -1;
                        if ( (LA32_197=='\'') ) {s = 131;}

                        else if ( (LA32_197=='\\') ) {s = 129;}

                        else if ( ((LA32_197>='\u0000' && LA32_197<='&')||(LA32_197>='(' && LA32_197<='[')||(LA32_197>=']' && LA32_197<='\uFFFF')) ) {s = 130;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_130 = input.LA(1);

                        s = -1;
                        if ( (LA32_130=='\'') ) {s = 131;}

                        else if ( (LA32_130=='\\') ) {s = 129;}

                        else if ( ((LA32_130>='\u0000' && LA32_130<='&')||(LA32_130>='(' && LA32_130<='[')||(LA32_130>=']' && LA32_130<='\uFFFF')) ) {s = 130;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_44 = input.LA(1);

                        s = -1;
                        if ( (LA32_44=='\\') ) {s = 129;}

                        else if ( ((LA32_44>='\u0000' && LA32_44<='&')||(LA32_44>='(' && LA32_44<='[')||(LA32_44>=']' && LA32_44<='\uFFFF')) ) {s = 130;}

                        else if ( (LA32_44=='\'') ) {s = 131;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_195 = input.LA(1);

                        s = -1;
                        if ( (LA32_195=='\"') ) {s = 128;}

                        else if ( (LA32_195=='\\') ) {s = 126;}

                        else if ( ((LA32_195>='\u0000' && LA32_195<='!')||(LA32_195>='#' && LA32_195<='[')||(LA32_195>=']' && LA32_195<='\uFFFF')) ) {s = 127;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_0 = input.LA(1);

                        s = -1;
                        if ( (LA32_0=='R') ) {s = 1;}

                        else if ( (LA32_0=='P') ) {s = 2;}

                        else if ( (LA32_0=='G') ) {s = 3;}

                        else if ( (LA32_0=='p') ) {s = 4;}

                        else if ( (LA32_0=='i') ) {s = 5;}

                        else if ( (LA32_0=='a') ) {s = 6;}

                        else if ( (LA32_0=='l') ) {s = 7;}

                        else if ( (LA32_0=='f') ) {s = 8;}

                        else if ( (LA32_0=='m') ) {s = 9;}

                        else if ( (LA32_0=='d') ) {s = 10;}

                        else if ( (LA32_0=='s') ) {s = 11;}

                        else if ( (LA32_0=='u') ) {s = 12;}

                        else if ( (LA32_0=='B') ) {s = 13;}

                        else if ( (LA32_0=='I') ) {s = 14;}

                        else if ( (LA32_0=='h') ) {s = 15;}

                        else if ( (LA32_0=='D') ) {s = 16;}

                        else if ( (LA32_0=='H') ) {s = 17;}

                        else if ( (LA32_0=='S') ) {s = 18;}

                        else if ( (LA32_0=='b') ) {s = 19;}

                        else if ( (LA32_0=='c') ) {s = 20;}

                        else if ( (LA32_0=='r') ) {s = 21;}

                        else if ( (LA32_0=='v') ) {s = 22;}

                        else if ( (LA32_0=='A') ) {s = 23;}

                        else if ( (LA32_0=='t') ) {s = 24;}

                        else if ( (LA32_0=='L') ) {s = 25;}

                        else if ( (LA32_0=='g') ) {s = 26;}

                        else if ( (LA32_0=='n') ) {s = 27;}

                        else if ( (LA32_0=='[') ) {s = 28;}

                        else if ( (LA32_0==',') ) {s = 29;}

                        else if ( (LA32_0=='.') ) {s = 30;}

                        else if ( (LA32_0==':') ) {s = 31;}

                        else if ( (LA32_0=='@') ) {s = 32;}

                        else if ( (LA32_0==']') ) {s = 33;}

                        else if ( (LA32_0=='{') ) {s = 34;}

                        else if ( (LA32_0=='}') ) {s = 35;}

                        else if ( (LA32_0=='0') ) {s = 36;}

                        else if ( ((LA32_0>='1' && LA32_0<='2')) ) {s = 37;}

                        else if ( (LA32_0=='E'||LA32_0=='e') ) {s = 38;}

                        else if ( (LA32_0=='-') ) {s = 39;}

                        else if ( ((LA32_0>='3' && LA32_0<='9')) ) {s = 40;}

                        else if ( (LA32_0=='^') ) {s = 41;}

                        else if ( (LA32_0=='C'||LA32_0=='F'||(LA32_0>='J' && LA32_0<='K')||(LA32_0>='M' && LA32_0<='O')||LA32_0=='Q'||(LA32_0>='T' && LA32_0<='Z')||LA32_0=='_'||(LA32_0>='j' && LA32_0<='k')||LA32_0=='o'||LA32_0=='q'||(LA32_0>='w' && LA32_0<='z')) ) {s = 42;}

                        else if ( (LA32_0=='\"') ) {s = 43;}

                        else if ( (LA32_0=='\'') ) {s = 44;}

                        else if ( (LA32_0=='#') ) {s = 45;}

                        else if ( (LA32_0=='/') ) {s = 46;}

                        else if ( (LA32_0=='~') ) {s = 48;}

                        else if ( ((LA32_0>='\t' && LA32_0<='\n')||LA32_0=='\r'||LA32_0==' ') ) {s = 49;}

                        else if ( ((LA32_0>='\u0000' && LA32_0<='\b')||(LA32_0>='\u000B' && LA32_0<='\f')||(LA32_0>='\u000E' && LA32_0<='\u001F')||LA32_0=='!'||(LA32_0>='$' && LA32_0<='&')||(LA32_0>='(' && LA32_0<='+')||(LA32_0>=';' && LA32_0<='?')||LA32_0=='\\'||LA32_0=='`'||LA32_0=='|'||(LA32_0>='\u007F' && LA32_0<='\uFFFF')) ) {s = 50;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_127 = input.LA(1);

                        s = -1;
                        if ( (LA32_127=='\"') ) {s = 128;}

                        else if ( (LA32_127=='\\') ) {s = 126;}

                        else if ( ((LA32_127>='\u0000' && LA32_127<='!')||(LA32_127>='#' && LA32_127<='[')||(LA32_127>=']' && LA32_127<='\uFFFF')) ) {s = 127;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_43 = input.LA(1);

                        s = -1;
                        if ( (LA32_43=='\\') ) {s = 126;}

                        else if ( ((LA32_43>='\u0000' && LA32_43<='!')||(LA32_43>='#' && LA32_43<='[')||(LA32_43>=']' && LA32_43<='\uFFFF')) ) {s = 127;}

                        else if ( (LA32_43=='\"') ) {s = 128;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_126 = input.LA(1);

                        s = -1;
                        if ( ((LA32_126>='\u0000' && LA32_126<='\uFFFF')) ) {s = 195;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}