package de.fraunhofer.ipa.ros.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRosLexer extends Lexer {
    public static final int Float32_1=22;
    public static final int Node=89;
    public static final int RULE_DATE_TIME=115;
    public static final int Uint64_1=34;
    public static final int Serviceclients=8;
    public static final int String=52;
    public static final int Int16=68;
    public static final int Float32=37;
    public static final int Goal=86;
    public static final int Actionservers=11;
    public static final int Bool=83;
    public static final int Msgs=71;
    public static final int Uint16=61;
    public static final int Boolean=35;
    public static final int ExternalDependency=4;
    public static final int Sub=75;
    public static final int Uint8=77;
    public static final int Parameters=18;
    public static final int RULE_ID=116;
    public static final int Actions=25;
    public static final int RULE_DIGIT=105;
    public static final int GlobalNamespace=7;
    public static final int Node_1=72;
    public static final int Int16_1=40;
    public static final int Header=51;
    public static final int RULE_INT=118;
    public static final int Byte=84;
    public static final int RULE_ML_COMMENT=125;
    public static final int LeftSquareBracket=101;
    public static final int Pluginslots=15;
    public static final int Ac=81;
    public static final int Base64=49;
    public static final int Comma=97;
    public static final int As=82;
    public static final int RULE_MESSAGE_ASIGMENT=119;
    public static final int LeftSquareBracketRightSquareBracket=96;
    public static final int Int32=69;
    public static final int Char=85;
    public static final int Publishers=19;
    public static final int Srvs=74;
    public static final int RightCurlyBracket=104;
    public static final int RULE_DECINT=108;
    public static final int Uint32=62;
    public static final int Plugins=29;
    public static final int FromGitRepo=14;
    public static final int FullStop=98;
    public static final int RULE_HOUR=113;
    public static final int Int8=87;
    public static final int Default=26;
    public static final int Int8_1=58;
    public static final int CommercialAt=100;
    public static final int Uint16_1=32;
    public static final int Sc=90;
    public static final int Type=93;
    public static final int Float64=38;
    public static final int Int32_1=41;
    public static final int Parameter=20;
    public static final int RULE_BINARY=106;
    public static final int String_1=60;
    public static final int Subscribers=16;
    public static final int String_2=31;
    public static final int Ss=91;
    public static final int Actionclients=10;
    public static final int RULE_DAY=110;
    public static final int RULE_BEGIN=120;
    public static final int RULE_BOOLEAN=107;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=9;
    public static final int RULE_YEAR=112;
    public static final int Result=59;
    public static final int Name=88;
    public static final int RULE_MIN_SEC=114;
    public static final int Implements=17;
    public static final int Char_1=57;
    public static final int ParameterAny=13;
    public static final int List=80;
    public static final int Dependencies=12;
    public static final int RightSquareBracket=102;
    public static final int PrivateNamespace=6;
    public static final int GraphName=21;
    public static final int Byte_1=56;
    public static final int Float64_1=23;
    public static final int Duration=27;
    public static final int Uint32_1=33;
    public static final int Double=50;
    public static final int Type_1=76;
    public static final int Value=78;
    public static final int Class=67;
    public static final int Library=43;
    public static final int Uint64=63;
    public static final int Action=54;
    public static final int RULE_END=121;
    public static final int Message=44;
    public static final int Value_1=64;
    public static final int Time=92;
    public static final int RULE_STRING=117;
    public static final int Bool_1=55;
    public static final int Any=94;
    public static final int Struct=53;
    public static final int RULE_SL_COMMENT=122;
    public static final int Uint8_1=48;
    public static final int Format=39;
    public static final int RULE_DOUBLE=109;
    public static final int Feedback=28;
    public static final int RULE_ROS_CONVENTION_A=123;
    public static final int RULE_ROS_CONVENTION_PARAM=124;
    public static final int Colon=99;
    public static final int Pub=73;
    public static final int EOF=-1;
    public static final int Multiple=24;
    public static final int Ns=95;
    public static final int RULE_WS=126;
    public static final int Int64_1=42;
    public static final int Request=46;
    public static final int LeftCurlyBracket=103;
    public static final int Service=47;
    public static final int RULE_ANY_OTHER=127;
    public static final int Base=66;
    public static final int Date=79;
    public static final int Response=30;
    public static final int Integer=36;
    public static final int Array=65;
    public static final int Int64=70;
    public static final int Param=45;
    public static final int RULE_MONTH=111;

    // delegates
    // delegators

    public InternalRosLexer() {;} 
    public InternalRosLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalRosLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalRosLexer.g"; }

    // $ANTLR start "ExternalDependency"
    public final void mExternalDependency() throws RecognitionException {
        try {
            int _type = ExternalDependency;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:14:20: ( 'ExternalDependency' )
            // InternalRosLexer.g:14:22: 'ExternalDependency'
            {
            match("ExternalDependency"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExternalDependency"

    // $ANTLR start "RelativeNamespace"
    public final void mRelativeNamespace() throws RecognitionException {
        try {
            int _type = RelativeNamespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:16:19: ( 'RelativeNamespace' )
            // InternalRosLexer.g:16:21: 'RelativeNamespace'
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
            // InternalRosLexer.g:18:18: ( 'PrivateNamespace' )
            // InternalRosLexer.g:18:20: 'PrivateNamespace'
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
            // InternalRosLexer.g:20:17: ( 'GlobalNamespace' )
            // InternalRosLexer.g:20:19: 'GlobalNamespace'
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

    // $ANTLR start "Serviceclients"
    public final void mServiceclients() throws RecognitionException {
        try {
            int _type = Serviceclients;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:22:16: ( 'serviceclients:' )
            // InternalRosLexer.g:22:18: 'serviceclients:'
            {
            match("serviceclients:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Serviceclients"

    // $ANTLR start "Serviceservers"
    public final void mServiceservers() throws RecognitionException {
        try {
            int _type = Serviceservers;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:24:16: ( 'serviceservers:' )
            // InternalRosLexer.g:24:18: 'serviceservers:'
            {
            match("serviceservers:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Serviceservers"

    // $ANTLR start "Actionclients"
    public final void mActionclients() throws RecognitionException {
        try {
            int _type = Actionclients;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:26:15: ( 'actionclients:' )
            // InternalRosLexer.g:26:17: 'actionclients:'
            {
            match("actionclients:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Actionclients"

    // $ANTLR start "Actionservers"
    public final void mActionservers() throws RecognitionException {
        try {
            int _type = Actionservers;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:28:15: ( 'actionservers:' )
            // InternalRosLexer.g:28:17: 'actionservers:'
            {
            match("actionservers:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Actionservers"

    // $ANTLR start "Dependencies"
    public final void mDependencies() throws RecognitionException {
        try {
            int _type = Dependencies;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:30:14: ( 'dependencies:' )
            // InternalRosLexer.g:30:16: 'dependencies:'
            {
            match("dependencies:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Dependencies"

    // $ANTLR start "ParameterAny"
    public final void mParameterAny() throws RecognitionException {
        try {
            int _type = ParameterAny;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:32:14: ( 'ParameterAny' )
            // InternalRosLexer.g:32:16: 'ParameterAny'
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

    // $ANTLR start "FromGitRepo"
    public final void mFromGitRepo() throws RecognitionException {
        try {
            int _type = FromGitRepo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:34:13: ( 'fromGitRepo:' )
            // InternalRosLexer.g:34:15: 'fromGitRepo:'
            {
            match("fromGitRepo:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FromGitRepo"

    // $ANTLR start "Pluginslots"
    public final void mPluginslots() throws RecognitionException {
        try {
            int _type = Pluginslots;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:36:13: ( 'pluginslots:' )
            // InternalRosLexer.g:36:15: 'pluginslots:'
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

    // $ANTLR start "Subscribers"
    public final void mSubscribers() throws RecognitionException {
        try {
            int _type = Subscribers;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:38:13: ( 'subscribers:' )
            // InternalRosLexer.g:38:15: 'subscribers:'
            {
            match("subscribers:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Subscribers"

    // $ANTLR start "Implements"
    public final void mImplements() throws RecognitionException {
        try {
            int _type = Implements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:40:12: ( 'implements:' )
            // InternalRosLexer.g:40:14: 'implements:'
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

    // $ANTLR start "Parameters"
    public final void mParameters() throws RecognitionException {
        try {
            int _type = Parameters;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:42:12: ( 'parameters:' )
            // InternalRosLexer.g:42:14: 'parameters:'
            {
            match("parameters:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Parameters"

    // $ANTLR start "Publishers"
    public final void mPublishers() throws RecognitionException {
        try {
            int _type = Publishers;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:44:12: ( 'publishers:' )
            // InternalRosLexer.g:44:14: 'publishers:'
            {
            match("publishers:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Publishers"

    // $ANTLR start "Parameter"
    public final void mParameter() throws RecognitionException {
        try {
            int _type = Parameter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:46:11: ( 'parameter:' )
            // InternalRosLexer.g:46:13: 'parameter:'
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
            // InternalRosLexer.g:48:11: ( 'GraphName' )
            // InternalRosLexer.g:48:13: 'GraphName'
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
            // InternalRosLexer.g:50:11: ( 'float32[]' )
            // InternalRosLexer.g:50:13: 'float32[]'
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
            // InternalRosLexer.g:52:11: ( 'float64[]' )
            // InternalRosLexer.g:52:13: 'float64[]'
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
            // InternalRosLexer.g:54:10: ( 'multiple:' )
            // InternalRosLexer.g:54:12: 'multiple:'
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

    // $ANTLR start "Actions"
    public final void mActions() throws RecognitionException {
        try {
            int _type = Actions;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:56:9: ( 'actions:' )
            // InternalRosLexer.g:56:11: 'actions:'
            {
            match("actions:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Actions"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:58:9: ( 'default:' )
            // InternalRosLexer.g:58:11: 'default:'
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
            // InternalRosLexer.g:60:10: ( 'duration' )
            // InternalRosLexer.g:60:12: 'duration'
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
            // InternalRosLexer.g:62:10: ( 'feedback' )
            // InternalRosLexer.g:62:12: 'feedback'
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
            // InternalRosLexer.g:64:9: ( 'plugins:' )
            // InternalRosLexer.g:64:11: 'plugins:'
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

    // $ANTLR start "Response"
    public final void mResponse() throws RecognitionException {
        try {
            int _type = Response;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:66:10: ( 'response' )
            // InternalRosLexer.g:66:12: 'response'
            {
            match("response"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Response"

    // $ANTLR start "String_2"
    public final void mString_2() throws RecognitionException {
        try {
            int _type = String_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:68:10: ( 'string[]' )
            // InternalRosLexer.g:68:12: 'string[]'
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
            // InternalRosLexer.g:70:10: ( 'uint16[]' )
            // InternalRosLexer.g:70:12: 'uint16[]'
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
            // InternalRosLexer.g:72:10: ( 'uint32[]' )
            // InternalRosLexer.g:72:12: 'uint32[]'
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
            // InternalRosLexer.g:74:10: ( 'uint64[]' )
            // InternalRosLexer.g:74:12: 'uint64[]'
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
            // InternalRosLexer.g:76:9: ( 'Boolean' )
            // InternalRosLexer.g:76:11: 'Boolean'
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
            // InternalRosLexer.g:78:9: ( 'Integer' )
            // InternalRosLexer.g:78:11: 'Integer'
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
            // InternalRosLexer.g:80:9: ( 'float32' )
            // InternalRosLexer.g:80:11: 'float32'
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
            // InternalRosLexer.g:82:9: ( 'float64' )
            // InternalRosLexer.g:82:11: 'float64'
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
            // InternalRosLexer.g:84:8: ( 'format:' )
            // InternalRosLexer.g:84:10: 'format:'
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

    // $ANTLR start "Int16_1"
    public final void mInt16_1() throws RecognitionException {
        try {
            int _type = Int16_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:86:9: ( 'int16[]' )
            // InternalRosLexer.g:86:11: 'int16[]'
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
            // InternalRosLexer.g:88:9: ( 'int32[]' )
            // InternalRosLexer.g:88:11: 'int32[]'
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
            // InternalRosLexer.g:90:9: ( 'int64[]' )
            // InternalRosLexer.g:90:11: 'int64[]'
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

    // $ANTLR start "Library"
    public final void mLibrary() throws RecognitionException {
        try {
            int _type = Library;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:92:9: ( 'library' )
            // InternalRosLexer.g:92:11: 'library'
            {
            match("library"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Library"

    // $ANTLR start "Message"
    public final void mMessage() throws RecognitionException {
        try {
            int _type = Message;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:94:9: ( 'message' )
            // InternalRosLexer.g:94:11: 'message'
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
            // InternalRosLexer.g:96:7: ( 'param->' )
            // InternalRosLexer.g:96:9: 'param->'
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

    // $ANTLR start "Request"
    public final void mRequest() throws RecognitionException {
        try {
            int _type = Request;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:98:9: ( 'request' )
            // InternalRosLexer.g:98:11: 'request'
            {
            match("request"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Request"

    // $ANTLR start "Service"
    public final void mService() throws RecognitionException {
        try {
            int _type = Service;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:100:9: ( 'service' )
            // InternalRosLexer.g:100:11: 'service'
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
            // InternalRosLexer.g:102:9: ( 'uint8[]' )
            // InternalRosLexer.g:102:11: 'uint8[]'
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
            // InternalRosLexer.g:104:8: ( 'Base64' )
            // InternalRosLexer.g:104:10: 'Base64'
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
            // InternalRosLexer.g:106:8: ( 'Double' )
            // InternalRosLexer.g:106:10: 'Double'
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
            // InternalRosLexer.g:108:8: ( 'Header' )
            // InternalRosLexer.g:108:10: 'Header'
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
            // InternalRosLexer.g:110:8: ( 'String' )
            // InternalRosLexer.g:110:10: 'String'
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
            // InternalRosLexer.g:112:8: ( 'Struct' )
            // InternalRosLexer.g:112:10: 'Struct'
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
            // InternalRosLexer.g:114:8: ( 'action' )
            // InternalRosLexer.g:114:10: 'action'
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
            // InternalRosLexer.g:116:8: ( 'bool[]' )
            // InternalRosLexer.g:116:10: 'bool[]'
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
            // InternalRosLexer.g:118:8: ( 'byte[]' )
            // InternalRosLexer.g:118:10: 'byte[]'
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
            // InternalRosLexer.g:120:8: ( 'char[]' )
            // InternalRosLexer.g:120:10: 'char[]'
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

    // $ANTLR start "Int8_1"
    public final void mInt8_1() throws RecognitionException {
        try {
            int _type = Int8_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:122:8: ( 'int8[]' )
            // InternalRosLexer.g:122:10: 'int8[]'
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
            // InternalRosLexer.g:124:8: ( 'result' )
            // InternalRosLexer.g:124:10: 'result'
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

    // $ANTLR start "String_1"
    public final void mString_1() throws RecognitionException {
        try {
            int _type = String_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:126:10: ( 'string' )
            // InternalRosLexer.g:126:12: 'string'
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
            // InternalRosLexer.g:128:8: ( 'uint16' )
            // InternalRosLexer.g:128:10: 'uint16'
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
            // InternalRosLexer.g:130:8: ( 'uint32' )
            // InternalRosLexer.g:130:10: 'uint32'
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
            // InternalRosLexer.g:132:8: ( 'uint64' )
            // InternalRosLexer.g:132:10: 'uint64'
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
            // InternalRosLexer.g:134:9: ( 'value:' )
            // InternalRosLexer.g:134:11: 'value:'
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
            // InternalRosLexer.g:136:7: ( 'Array' )
            // InternalRosLexer.g:136:9: 'Array'
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
            // InternalRosLexer.g:138:6: ( 'base:' )
            // InternalRosLexer.g:138:8: 'base:'
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

    // $ANTLR start "Class"
    public final void mClass() throws RecognitionException {
        try {
            int _type = Class;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:140:7: ( 'class' )
            // InternalRosLexer.g:140:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Class"

    // $ANTLR start "Int16"
    public final void mInt16() throws RecognitionException {
        try {
            int _type = Int16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:142:7: ( 'int16' )
            // InternalRosLexer.g:142:9: 'int16'
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
            // InternalRosLexer.g:144:7: ( 'int32' )
            // InternalRosLexer.g:144:9: 'int32'
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
            // InternalRosLexer.g:146:7: ( 'int64' )
            // InternalRosLexer.g:146:9: 'int64'
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

    // $ANTLR start "Msgs"
    public final void mMsgs() throws RecognitionException {
        try {
            int _type = Msgs;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:148:6: ( 'msgs:' )
            // InternalRosLexer.g:148:8: 'msgs:'
            {
            match("msgs:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Msgs"

    // $ANTLR start "Node_1"
    public final void mNode_1() throws RecognitionException {
        try {
            int _type = Node_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:150:8: ( 'node:' )
            // InternalRosLexer.g:150:10: 'node:'
            {
            match("node:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Node_1"

    // $ANTLR start "Pub"
    public final void mPub() throws RecognitionException {
        try {
            int _type = Pub;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:152:5: ( 'pub->' )
            // InternalRosLexer.g:152:7: 'pub->'
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

    // $ANTLR start "Srvs"
    public final void mSrvs() throws RecognitionException {
        try {
            int _type = Srvs;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:154:6: ( 'srvs:' )
            // InternalRosLexer.g:154:8: 'srvs:'
            {
            match("srvs:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Srvs"

    // $ANTLR start "Sub"
    public final void mSub() throws RecognitionException {
        try {
            int _type = Sub;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRosLexer.g:156:5: ( 'sub->' )
            // InternalRosLexer.g:156:7: 'sub->'
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
            // InternalRosLexer.g:158:8: ( 'type:' )
            // InternalRosLexer.g:158:10: 'type:'
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
            // InternalRosLexer.g:160:7: ( 'uint8' )
            // InternalRosLexer.g:160:9: 'uint8'
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
            // InternalRosLexer.g:162:7: ( 'value' )
            // InternalRosLexer.g:162:9: 'value'
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
            // InternalRosLexer.g:164:6: ( 'Date' )
            // InternalRosLexer.g:164:8: 'Date'
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
            // InternalRosLexer.g:166:6: ( 'List' )
            // InternalRosLexer.g:166:8: 'List'
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
            // InternalRosLexer.g:168:4: ( 'ac->' )
            // InternalRosLexer.g:168:6: 'ac->'
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
            // InternalRosLexer.g:170:4: ( 'as->' )
            // InternalRosLexer.g:170:6: 'as->'
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
            // InternalRosLexer.g:172:6: ( 'bool' )
            // InternalRosLexer.g:172:8: 'bool'
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
            // InternalRosLexer.g:174:6: ( 'byte' )
            // InternalRosLexer.g:174:8: 'byte'
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
            // InternalRosLexer.g:176:6: ( 'char' )
            // InternalRosLexer.g:176:8: 'char'
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
            // InternalRosLexer.g:178:6: ( 'goal' )
            // InternalRosLexer.g:178:8: 'goal'
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
            // InternalRosLexer.g:180:6: ( 'int8' )
            // InternalRosLexer.g:180:8: 'int8'
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
            // InternalRosLexer.g:182:6: ( 'name' )
            // InternalRosLexer.g:182:8: 'name'
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
            // InternalRosLexer.g:184:6: ( 'node' )
            // InternalRosLexer.g:184:8: 'node'
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
            // InternalRosLexer.g:186:4: ( 'sc->' )
            // InternalRosLexer.g:186:6: 'sc->'
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
            // InternalRosLexer.g:188:4: ( 'ss->' )
            // InternalRosLexer.g:188:6: 'ss->'
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
            // InternalRosLexer.g:190:6: ( 'time' )
            // InternalRosLexer.g:190:8: 'time'
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
            // InternalRosLexer.g:192:6: ( 'type' )
            // InternalRosLexer.g:192:8: 'type'
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
            // InternalRosLexer.g:194:5: ( 'Any' )
            // InternalRosLexer.g:194:7: 'Any'
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
            // InternalRosLexer.g:196:4: ( 'ns:' )
            // InternalRosLexer.g:196:6: 'ns:'
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
            // InternalRosLexer.g:198:37: ( '[]' )
            // InternalRosLexer.g:198:39: '[]'
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
            // InternalRosLexer.g:200:7: ( ',' )
            // InternalRosLexer.g:200:9: ','
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
            // InternalRosLexer.g:202:10: ( '.' )
            // InternalRosLexer.g:202:12: '.'
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
            // InternalRosLexer.g:204:7: ( ':' )
            // InternalRosLexer.g:204:9: ':'
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
            // InternalRosLexer.g:206:14: ( '@' )
            // InternalRosLexer.g:206:16: '@'
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
            // InternalRosLexer.g:208:19: ( '[' )
            // InternalRosLexer.g:208:21: '['
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
            // InternalRosLexer.g:210:20: ( ']' )
            // InternalRosLexer.g:210:22: ']'
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
            // InternalRosLexer.g:212:18: ( '{' )
            // InternalRosLexer.g:212:20: '{'
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
            // InternalRosLexer.g:214:19: ( '}' )
            // InternalRosLexer.g:214:21: '}'
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
            // InternalRosLexer.g:216:21: ( '0' .. '9' )
            // InternalRosLexer.g:216:23: '0' .. '9'
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
            // InternalRosLexer.g:218:13: ( ( '0b' | '0B' ) ( '0' | '1' )+ )
            // InternalRosLexer.g:218:15: ( '0b' | '0B' ) ( '0' | '1' )+
            {
            // InternalRosLexer.g:218:15: ( '0b' | '0B' )
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
                    // InternalRosLexer.g:218:16: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:218:21: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            // InternalRosLexer.g:218:27: ( '0' | '1' )+
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
            	    // InternalRosLexer.g:
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
            // InternalRosLexer.g:220:14: ( ( 'true' | 'false' ) )
            // InternalRosLexer.g:220:16: ( 'true' | 'false' )
            {
            // InternalRosLexer.g:220:16: ( 'true' | 'false' )
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
                    // InternalRosLexer.g:220:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:220:24: 'false'
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
            // InternalRosLexer.g:222:13: ( ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* ) )
            // InternalRosLexer.g:222:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            {
            // InternalRosLexer.g:222:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* )
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
                    // InternalRosLexer.g:222:16: ( RULE_DIGIT )*
                    {
                    // InternalRosLexer.g:222:16: ( RULE_DIGIT )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalRosLexer.g:222:16: RULE_DIGIT
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
                    // InternalRosLexer.g:222:28: '-' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    // InternalRosLexer.g:222:32: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalRosLexer.g:222:32: RULE_DIGIT
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

            // InternalRosLexer.g:222:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalRosLexer.g:222:46: '.' ( RULE_DECINT )*
                    {
                    match('.'); 
                    // InternalRosLexer.g:222:50: ( RULE_DECINT )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='-'||(LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalRosLexer.g:222:50: RULE_DECINT
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
                    // InternalRosLexer.g:222:63: ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )*
                    {
                    // InternalRosLexer.g:222:63: ( '.' ( RULE_DIGIT )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalRosLexer.g:222:64: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // InternalRosLexer.g:222:68: ( RULE_DIGIT )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalRosLexer.g:222:68: RULE_DIGIT
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

                    // InternalRosLexer.g:222:92: ( '-' | '+' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='+'||LA10_0=='-') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalRosLexer.g:
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

                    // InternalRosLexer.g:222:103: ( RULE_DIGIT )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalRosLexer.g:222:103: RULE_DIGIT
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
            // InternalRosLexer.g:224:13: ( ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* ) )
            // InternalRosLexer.g:224:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
            {
            // InternalRosLexer.g:224:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
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
                    // InternalRosLexer.g:224:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:224:20: '1' .. '9' ( RULE_DIGIT )*
                    {
                    matchRange('1','9'); 
                    // InternalRosLexer.g:224:29: ( RULE_DIGIT )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalRosLexer.g:224:29: RULE_DIGIT
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
                    // InternalRosLexer.g:224:41: '-' '0' .. '9' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    matchRange('0','9'); 
                    // InternalRosLexer.g:224:54: ( RULE_DIGIT )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalRosLexer.g:224:54: RULE_DIGIT
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
            // InternalRosLexer.g:226:19: ( ( '1' .. '9' | '1' .. '3' '0' .. '9' ) )
            // InternalRosLexer.g:226:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
            {
            // InternalRosLexer.g:226:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
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
                    // InternalRosLexer.g:226:22: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:226:31: '1' .. '3' '0' .. '9'
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
            // InternalRosLexer.g:228:21: ( ( '1' .. '9' | '1' '0' .. '2' ) )
            // InternalRosLexer.g:228:23: ( '1' .. '9' | '1' '0' .. '2' )
            {
            // InternalRosLexer.g:228:23: ( '1' .. '9' | '1' '0' .. '2' )
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
                    // InternalRosLexer.g:228:24: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:228:33: '1' '0' .. '2'
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
            // InternalRosLexer.g:230:20: ( '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalRosLexer.g:230:22: '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9'
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
            // InternalRosLexer.g:232:20: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) )
            // InternalRosLexer.g:232:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
            {
            // InternalRosLexer.g:232:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
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
                    // InternalRosLexer.g:232:23: '0' .. '1' '0' .. '9'
                    {
                    matchRange('0','1'); 
                    matchRange('0','9'); 

                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:232:41: '2' '0' .. '3'
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
            // InternalRosLexer.g:234:23: ( '0' .. '5' '0' .. '9' )
            // InternalRosLexer.g:234:25: '0' .. '5' '0' .. '9'
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
            // InternalRosLexer.g:236:16: ( RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC )
            // InternalRosLexer.g:236:18: RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC
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
            // InternalRosLexer.g:238:23: ( ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT ) )
            // InternalRosLexer.g:238:25: ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
            {
            // InternalRosLexer.g:238:25: ( RULE_ID | RULE_STRING )
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
                    // InternalRosLexer.g:238:26: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:238:34: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;

            }

            match('='); 
            // InternalRosLexer.g:238:51: ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
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
                    // InternalRosLexer.g:238:52: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalRosLexer.g:238:60: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;
                case 3 :
                    // InternalRosLexer.g:238:72: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;
                case 4 :
                    // InternalRosLexer.g:238:81: '-' RULE_INT
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
            // InternalRosLexer.g:240:21: ()
            // InternalRosLexer.g:240:23: 
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
            // InternalRosLexer.g:242:19: ()
            // InternalRosLexer.g:242:21: 
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
            // InternalRosLexer.g:244:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalRosLexer.g:244:19: '#' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match('#'); 
            // InternalRosLexer.g:244:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalRosLexer.g:244:23: ~ ( ( '\\n' | '\\r' ) )
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
            // InternalRosLexer.g:246:23: ( ( '/' RULE_ID | RULE_ID '/' )* )
            // InternalRosLexer.g:246:25: ( '/' RULE_ID | RULE_ID '/' )*
            {
            // InternalRosLexer.g:246:25: ( '/' RULE_ID | RULE_ID '/' )*
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
            	    // InternalRosLexer.g:246:26: '/' RULE_ID
            	    {
            	    match('/'); 
            	    mRULE_ID(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalRosLexer.g:246:38: RULE_ID '/'
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
            // InternalRosLexer.g:248:27: ( ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )* )
            // InternalRosLexer.g:248:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
            {
            // InternalRosLexer.g:248:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
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
            	    // InternalRosLexer.g:248:30: '/' RULE_STRING
            	    {
            	    match('/'); 
            	    mRULE_STRING(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalRosLexer.g:248:46: RULE_STRING '/'
            	    {
            	    mRULE_STRING(); 
            	    match('/'); 

            	    }
            	    break;
            	case 3 :
            	    // InternalRosLexer.g:248:62: '~' RULE_STRING
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
            // InternalRosLexer.g:250:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalRosLexer.g:250:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalRosLexer.g:250:11: ( '^' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='^') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRosLexer.g:250:11: '^'
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

            // InternalRosLexer.g:250:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalRosLexer.g:
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
            // InternalRosLexer.g:252:10: ( ( '0' .. '9' )+ )
            // InternalRosLexer.g:252:12: ( '0' .. '9' )+
            {
            // InternalRosLexer.g:252:12: ( '0' .. '9' )+
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
            	    // InternalRosLexer.g:252:13: '0' .. '9'
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
            // InternalRosLexer.g:254:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalRosLexer.g:254:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalRosLexer.g:254:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalRosLexer.g:254:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalRosLexer.g:254:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalRosLexer.g:254:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRosLexer.g:254:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalRosLexer.g:254:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalRosLexer.g:254:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalRosLexer.g:254:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRosLexer.g:254:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalRosLexer.g:256:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalRosLexer.g:256:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalRosLexer.g:256:24: ( options {greedy=false; } : . )*
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
            	    // InternalRosLexer.g:256:52: .
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
            // InternalRosLexer.g:258:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalRosLexer.g:258:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalRosLexer.g:258:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalRosLexer.g:
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
            // InternalRosLexer.g:260:16: ( . )
            // InternalRosLexer.g:260:18: .
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
        // InternalRosLexer.g:1:8: ( ExternalDependency | RelativeNamespace | PrivateNamespace | GlobalNamespace | Serviceclients | Serviceservers | Actionclients | Actionservers | Dependencies | ParameterAny | FromGitRepo | Pluginslots | Subscribers | Implements | Parameters | Publishers | Parameter | GraphName | Float32_1 | Float64_1 | Multiple | Actions | Default | Duration | Feedback | Plugins | Response | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Format | Int16_1 | Int32_1 | Int64_1 | Library | Message | Param | Request | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Int8_1 | Result | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Class | Int16 | Int32 | Int64 | Msgs | Node_1 | Pub | Srvs | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt32=116;
        alt32 = dfa32.predict(input);
        switch (alt32) {
            case 1 :
                // InternalRosLexer.g:1:10: ExternalDependency
                {
                mExternalDependency(); 

                }
                break;
            case 2 :
                // InternalRosLexer.g:1:29: RelativeNamespace
                {
                mRelativeNamespace(); 

                }
                break;
            case 3 :
                // InternalRosLexer.g:1:47: PrivateNamespace
                {
                mPrivateNamespace(); 

                }
                break;
            case 4 :
                // InternalRosLexer.g:1:64: GlobalNamespace
                {
                mGlobalNamespace(); 

                }
                break;
            case 5 :
                // InternalRosLexer.g:1:80: Serviceclients
                {
                mServiceclients(); 

                }
                break;
            case 6 :
                // InternalRosLexer.g:1:95: Serviceservers
                {
                mServiceservers(); 

                }
                break;
            case 7 :
                // InternalRosLexer.g:1:110: Actionclients
                {
                mActionclients(); 

                }
                break;
            case 8 :
                // InternalRosLexer.g:1:124: Actionservers
                {
                mActionservers(); 

                }
                break;
            case 9 :
                // InternalRosLexer.g:1:138: Dependencies
                {
                mDependencies(); 

                }
                break;
            case 10 :
                // InternalRosLexer.g:1:151: ParameterAny
                {
                mParameterAny(); 

                }
                break;
            case 11 :
                // InternalRosLexer.g:1:164: FromGitRepo
                {
                mFromGitRepo(); 

                }
                break;
            case 12 :
                // InternalRosLexer.g:1:176: Pluginslots
                {
                mPluginslots(); 

                }
                break;
            case 13 :
                // InternalRosLexer.g:1:188: Subscribers
                {
                mSubscribers(); 

                }
                break;
            case 14 :
                // InternalRosLexer.g:1:200: Implements
                {
                mImplements(); 

                }
                break;
            case 15 :
                // InternalRosLexer.g:1:211: Parameters
                {
                mParameters(); 

                }
                break;
            case 16 :
                // InternalRosLexer.g:1:222: Publishers
                {
                mPublishers(); 

                }
                break;
            case 17 :
                // InternalRosLexer.g:1:233: Parameter
                {
                mParameter(); 

                }
                break;
            case 18 :
                // InternalRosLexer.g:1:243: GraphName
                {
                mGraphName(); 

                }
                break;
            case 19 :
                // InternalRosLexer.g:1:253: Float32_1
                {
                mFloat32_1(); 

                }
                break;
            case 20 :
                // InternalRosLexer.g:1:263: Float64_1
                {
                mFloat64_1(); 

                }
                break;
            case 21 :
                // InternalRosLexer.g:1:273: Multiple
                {
                mMultiple(); 

                }
                break;
            case 22 :
                // InternalRosLexer.g:1:282: Actions
                {
                mActions(); 

                }
                break;
            case 23 :
                // InternalRosLexer.g:1:290: Default
                {
                mDefault(); 

                }
                break;
            case 24 :
                // InternalRosLexer.g:1:298: Duration
                {
                mDuration(); 

                }
                break;
            case 25 :
                // InternalRosLexer.g:1:307: Feedback
                {
                mFeedback(); 

                }
                break;
            case 26 :
                // InternalRosLexer.g:1:316: Plugins
                {
                mPlugins(); 

                }
                break;
            case 27 :
                // InternalRosLexer.g:1:324: Response
                {
                mResponse(); 

                }
                break;
            case 28 :
                // InternalRosLexer.g:1:333: String_2
                {
                mString_2(); 

                }
                break;
            case 29 :
                // InternalRosLexer.g:1:342: Uint16_1
                {
                mUint16_1(); 

                }
                break;
            case 30 :
                // InternalRosLexer.g:1:351: Uint32_1
                {
                mUint32_1(); 

                }
                break;
            case 31 :
                // InternalRosLexer.g:1:360: Uint64_1
                {
                mUint64_1(); 

                }
                break;
            case 32 :
                // InternalRosLexer.g:1:369: Boolean
                {
                mBoolean(); 

                }
                break;
            case 33 :
                // InternalRosLexer.g:1:377: Integer
                {
                mInteger(); 

                }
                break;
            case 34 :
                // InternalRosLexer.g:1:385: Float32
                {
                mFloat32(); 

                }
                break;
            case 35 :
                // InternalRosLexer.g:1:393: Float64
                {
                mFloat64(); 

                }
                break;
            case 36 :
                // InternalRosLexer.g:1:401: Format
                {
                mFormat(); 

                }
                break;
            case 37 :
                // InternalRosLexer.g:1:408: Int16_1
                {
                mInt16_1(); 

                }
                break;
            case 38 :
                // InternalRosLexer.g:1:416: Int32_1
                {
                mInt32_1(); 

                }
                break;
            case 39 :
                // InternalRosLexer.g:1:424: Int64_1
                {
                mInt64_1(); 

                }
                break;
            case 40 :
                // InternalRosLexer.g:1:432: Library
                {
                mLibrary(); 

                }
                break;
            case 41 :
                // InternalRosLexer.g:1:440: Message
                {
                mMessage(); 

                }
                break;
            case 42 :
                // InternalRosLexer.g:1:448: Param
                {
                mParam(); 

                }
                break;
            case 43 :
                // InternalRosLexer.g:1:454: Request
                {
                mRequest(); 

                }
                break;
            case 44 :
                // InternalRosLexer.g:1:462: Service
                {
                mService(); 

                }
                break;
            case 45 :
                // InternalRosLexer.g:1:470: Uint8_1
                {
                mUint8_1(); 

                }
                break;
            case 46 :
                // InternalRosLexer.g:1:478: Base64
                {
                mBase64(); 

                }
                break;
            case 47 :
                // InternalRosLexer.g:1:485: Double
                {
                mDouble(); 

                }
                break;
            case 48 :
                // InternalRosLexer.g:1:492: Header
                {
                mHeader(); 

                }
                break;
            case 49 :
                // InternalRosLexer.g:1:499: String
                {
                mString(); 

                }
                break;
            case 50 :
                // InternalRosLexer.g:1:506: Struct
                {
                mStruct(); 

                }
                break;
            case 51 :
                // InternalRosLexer.g:1:513: Action
                {
                mAction(); 

                }
                break;
            case 52 :
                // InternalRosLexer.g:1:520: Bool_1
                {
                mBool_1(); 

                }
                break;
            case 53 :
                // InternalRosLexer.g:1:527: Byte_1
                {
                mByte_1(); 

                }
                break;
            case 54 :
                // InternalRosLexer.g:1:534: Char_1
                {
                mChar_1(); 

                }
                break;
            case 55 :
                // InternalRosLexer.g:1:541: Int8_1
                {
                mInt8_1(); 

                }
                break;
            case 56 :
                // InternalRosLexer.g:1:548: Result
                {
                mResult(); 

                }
                break;
            case 57 :
                // InternalRosLexer.g:1:555: String_1
                {
                mString_1(); 

                }
                break;
            case 58 :
                // InternalRosLexer.g:1:564: Uint16
                {
                mUint16(); 

                }
                break;
            case 59 :
                // InternalRosLexer.g:1:571: Uint32
                {
                mUint32(); 

                }
                break;
            case 60 :
                // InternalRosLexer.g:1:578: Uint64
                {
                mUint64(); 

                }
                break;
            case 61 :
                // InternalRosLexer.g:1:585: Value_1
                {
                mValue_1(); 

                }
                break;
            case 62 :
                // InternalRosLexer.g:1:593: Array
                {
                mArray(); 

                }
                break;
            case 63 :
                // InternalRosLexer.g:1:599: Base
                {
                mBase(); 

                }
                break;
            case 64 :
                // InternalRosLexer.g:1:604: Class
                {
                mClass(); 

                }
                break;
            case 65 :
                // InternalRosLexer.g:1:610: Int16
                {
                mInt16(); 

                }
                break;
            case 66 :
                // InternalRosLexer.g:1:616: Int32
                {
                mInt32(); 

                }
                break;
            case 67 :
                // InternalRosLexer.g:1:622: Int64
                {
                mInt64(); 

                }
                break;
            case 68 :
                // InternalRosLexer.g:1:628: Msgs
                {
                mMsgs(); 

                }
                break;
            case 69 :
                // InternalRosLexer.g:1:633: Node_1
                {
                mNode_1(); 

                }
                break;
            case 70 :
                // InternalRosLexer.g:1:640: Pub
                {
                mPub(); 

                }
                break;
            case 71 :
                // InternalRosLexer.g:1:644: Srvs
                {
                mSrvs(); 

                }
                break;
            case 72 :
                // InternalRosLexer.g:1:649: Sub
                {
                mSub(); 

                }
                break;
            case 73 :
                // InternalRosLexer.g:1:653: Type_1
                {
                mType_1(); 

                }
                break;
            case 74 :
                // InternalRosLexer.g:1:660: Uint8
                {
                mUint8(); 

                }
                break;
            case 75 :
                // InternalRosLexer.g:1:666: Value
                {
                mValue(); 

                }
                break;
            case 76 :
                // InternalRosLexer.g:1:672: Date
                {
                mDate(); 

                }
                break;
            case 77 :
                // InternalRosLexer.g:1:677: List
                {
                mList(); 

                }
                break;
            case 78 :
                // InternalRosLexer.g:1:682: Ac
                {
                mAc(); 

                }
                break;
            case 79 :
                // InternalRosLexer.g:1:685: As
                {
                mAs(); 

                }
                break;
            case 80 :
                // InternalRosLexer.g:1:688: Bool
                {
                mBool(); 

                }
                break;
            case 81 :
                // InternalRosLexer.g:1:693: Byte
                {
                mByte(); 

                }
                break;
            case 82 :
                // InternalRosLexer.g:1:698: Char
                {
                mChar(); 

                }
                break;
            case 83 :
                // InternalRosLexer.g:1:703: Goal
                {
                mGoal(); 

                }
                break;
            case 84 :
                // InternalRosLexer.g:1:708: Int8
                {
                mInt8(); 

                }
                break;
            case 85 :
                // InternalRosLexer.g:1:713: Name
                {
                mName(); 

                }
                break;
            case 86 :
                // InternalRosLexer.g:1:718: Node
                {
                mNode(); 

                }
                break;
            case 87 :
                // InternalRosLexer.g:1:723: Sc
                {
                mSc(); 

                }
                break;
            case 88 :
                // InternalRosLexer.g:1:726: Ss
                {
                mSs(); 

                }
                break;
            case 89 :
                // InternalRosLexer.g:1:729: Time
                {
                mTime(); 

                }
                break;
            case 90 :
                // InternalRosLexer.g:1:734: Type
                {
                mType(); 

                }
                break;
            case 91 :
                // InternalRosLexer.g:1:739: Any
                {
                mAny(); 

                }
                break;
            case 92 :
                // InternalRosLexer.g:1:743: Ns
                {
                mNs(); 

                }
                break;
            case 93 :
                // InternalRosLexer.g:1:746: LeftSquareBracketRightSquareBracket
                {
                mLeftSquareBracketRightSquareBracket(); 

                }
                break;
            case 94 :
                // InternalRosLexer.g:1:782: Comma
                {
                mComma(); 

                }
                break;
            case 95 :
                // InternalRosLexer.g:1:788: FullStop
                {
                mFullStop(); 

                }
                break;
            case 96 :
                // InternalRosLexer.g:1:797: Colon
                {
                mColon(); 

                }
                break;
            case 97 :
                // InternalRosLexer.g:1:803: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 98 :
                // InternalRosLexer.g:1:816: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 99 :
                // InternalRosLexer.g:1:834: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 100 :
                // InternalRosLexer.g:1:853: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 101 :
                // InternalRosLexer.g:1:870: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 102 :
                // InternalRosLexer.g:1:888: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 103 :
                // InternalRosLexer.g:1:900: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 104 :
                // InternalRosLexer.g:1:913: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 105 :
                // InternalRosLexer.g:1:925: RULE_DECINT
                {
                mRULE_DECINT(); 

                }
                break;
            case 106 :
                // InternalRosLexer.g:1:937: RULE_DATE_TIME
                {
                mRULE_DATE_TIME(); 

                }
                break;
            case 107 :
                // InternalRosLexer.g:1:952: RULE_MESSAGE_ASIGMENT
                {
                mRULE_MESSAGE_ASIGMENT(); 

                }
                break;
            case 108 :
                // InternalRosLexer.g:1:974: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 109 :
                // InternalRosLexer.g:1:990: RULE_ROS_CONVENTION_A
                {
                mRULE_ROS_CONVENTION_A(); 

                }
                break;
            case 110 :
                // InternalRosLexer.g:1:1012: RULE_ROS_CONVENTION_PARAM
                {
                mRULE_ROS_CONVENTION_PARAM(); 

                }
                break;
            case 111 :
                // InternalRosLexer.g:1:1038: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 112 :
                // InternalRosLexer.g:1:1046: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 113 :
                // InternalRosLexer.g:1:1055: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 114 :
                // InternalRosLexer.g:1:1067: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 115 :
                // InternalRosLexer.g:1:1083: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 116 :
                // InternalRosLexer.g:1:1091: RULE_ANY_OTHER
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
            return "222:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )";
        }
    }
    static final String DFA32_eotS =
        "\1\57\1\64\32\71\1\160\1\uffff\1\162\5\uffff\2\172\1\64\1\62\1\172\1\62\1\71\2\62\1\uffff\1\62\1\uffff\1\62\2\uffff\1\71\1\uffff\1\64\1\71\1\uffff\1\71\1\uffff\65\71\12\uffff\1\u00c4\1\uffff\3\172\1\71\2\uffff\1\u00c8\2\uffff\1\u00c8\4\uffff\12\71\2\uffff\1\71\2\uffff\42\71\1\u00fe\2\71\1\uffff\5\71\1\u00c4\1\uffff\2\172\3\uffff\10\71\1\uffff\16\71\1\uffff\4\71\1\u0123\14\71\1\u0133\3\71\1\u0138\1\u013a\1\71\1\u013d\3\71\1\uffff\1\u0142\1\u0143\1\u0145\1\u0146\1\u0147\1\u0148\1\u0149\1\u00c4\1\172\11\71\1\uffff\10\71\1\u0147\4\71\1\u0164\1\u0166\1\u0168\2\uffff\2\71\1\uffff\6\71\1\u0172\5\71\1\uffff\3\71\7\uffff\1\u017b\1\u017d\1\u017e\11\uffff\1\u00c4\1\uffff\10\71\1\u0188\1\u018b\12\71\1\uffff\2\71\6\uffff\3\71\1\u019b\1\71\1\u019e\1\u01a0\1\u01a2\2\uffff\1\71\1\u01a4\2\71\1\u01a7\1\u01a8\1\u01a9\1\u01aa\4\uffff\6\71\1\u01b3\1\71\2\uffff\2\71\1\uffff\4\71\1\u01bd\1\u01bf\1\71\1\uffff\5\71\1\u01c7\1\71\1\uffff\1\u01c9\6\uffff\1\u01ca\1\uffff\1\u01cb\1\u01cc\4\uffff\10\71\1\uffff\3\71\1\uffff\1\71\1\uffff\1\u01d9\1\71\4\uffff\1\u01db\1\71\1\uffff\4\71\1\uffff\1\u01e1\4\uffff\5\71\1\u01e7\6\71\1\uffff\1\71\1\uffff\4\71\2\uffff\5\71\1\uffff\11\71\1\uffff\17\71\3\uffff\3\71\1\u0214\3\71\1\uffff\3\71\2\uffff\3\71\1\uffff\5\71\1\uffff\6\71\2\uffff\3\71\1\u022c\2\uffff\2\71\1\u022f\1\uffff\1\71\1\u0231\1\uffff\1\u0232\2\uffff";
    static final String DFA32_eofS =
        "\u0233\uffff";
    static final String DFA32_minS =
        "\1\0\33\57\1\135\1\uffff\1\55\5\uffff\2\56\1\57\2\56\1\101\1\57\2\0\1\uffff\1\42\1\uffff\1\42\2\uffff\1\57\1\uffff\2\57\1\uffff\1\57\1\uffff\10\57\4\55\51\57\12\uffff\1\56\1\uffff\3\56\1\57\2\0\1\57\2\0\1\57\4\uffff\7\57\1\55\2\57\2\uffff\1\57\2\uffff\12\57\1\55\32\57\1\uffff\5\57\1\56\1\uffff\2\56\1\0\1\uffff\1\0\10\57\1\uffff\16\57\1\uffff\34\57\1\uffff\7\57\2\55\11\57\1\uffff\12\57\1\55\5\57\2\uffff\2\57\1\uffff\14\57\1\uffff\3\57\7\uffff\3\57\11\uffff\1\56\1\uffff\24\57\1\uffff\2\57\6\uffff\10\57\2\uffff\10\57\4\uffff\10\57\2\uffff\2\57\1\uffff\7\57\1\uffff\7\57\1\uffff\1\57\6\uffff\1\57\1\uffff\2\57\4\uffff\10\57\1\uffff\3\57\1\uffff\1\57\1\uffff\2\57\4\uffff\2\57\1\uffff\4\57\1\uffff\1\57\4\uffff\14\57\1\uffff\1\57\1\uffff\4\57\2\uffff\5\57\1\uffff\11\57\1\uffff\17\57\3\uffff\7\57\1\uffff\3\57\2\uffff\3\57\1\uffff\5\57\1\uffff\6\57\2\uffff\4\57\2\uffff\3\57\1\uffff\2\57\1\uffff\1\57\2\uffff";
    static final String DFA32_maxS =
        "\1\uffff\33\172\1\135\1\uffff\1\145\5\uffff\2\145\1\172\2\145\2\172\2\uffff\1\uffff\1\172\1\uffff\1\47\2\uffff\1\172\1\uffff\2\172\1\uffff\1\172\1\uffff\65\172\12\uffff\1\145\1\uffff\3\145\1\172\2\uffff\1\75\2\uffff\1\75\4\uffff\12\172\2\uffff\1\172\2\uffff\45\172\1\uffff\5\172\1\145\1\uffff\2\145\1\uffff\1\uffff\1\uffff\10\172\1\uffff\16\172\1\uffff\34\172\1\uffff\7\172\2\145\11\172\1\uffff\20\172\2\uffff\2\172\1\uffff\14\172\1\uffff\3\172\7\uffff\3\172\11\uffff\1\145\1\uffff\24\172\1\uffff\2\172\6\uffff\10\172\2\uffff\10\172\4\uffff\10\172\2\uffff\2\172\1\uffff\7\172\1\uffff\7\172\1\uffff\1\172\6\uffff\1\172\1\uffff\2\172\4\uffff\10\172\1\uffff\3\172\1\uffff\1\172\1\uffff\2\172\4\uffff\2\172\1\uffff\4\172\1\uffff\1\172\4\uffff\14\172\1\uffff\1\172\1\uffff\4\172\2\uffff\5\172\1\uffff\11\172\1\uffff\17\172\3\uffff\7\172\1\uffff\3\172\2\uffff\3\172\1\uffff\5\172\1\uffff\6\172\2\uffff\4\172\2\uffff\3\172\1\uffff\2\172\1\uffff\1\172\2\uffff";
    static final String DFA32_acceptS =
        "\35\uffff\1\136\1\uffff\1\140\1\141\1\143\1\144\1\145\11\uffff\1\154\1\uffff\1\155\1\uffff\1\163\1\164\1\uffff\1\150\2\uffff\1\153\1\uffff\1\157\65\uffff\1\135\1\142\1\136\1\137\1\140\1\141\1\143\1\144\1\145\1\146\1\uffff\1\151\12\uffff\1\154\1\162\1\156\1\163\12\uffff\1\127\1\130\1\uffff\1\116\1\117\45\uffff\1\134\6\uffff\1\160\3\uffff\1\161\11\uffff\1\110\16\uffff\1\106\34\uffff\1\133\22\uffff\1\107\20\uffff\1\67\1\124\2\uffff\1\104\14\uffff\1\114\3\uffff\1\64\1\120\1\65\1\121\1\77\1\66\1\122\3\uffff\1\105\1\126\1\125\1\111\1\132\1\131\1\147\1\115\1\123\1\uffff\1\152\24\uffff\1\52\2\uffff\1\45\1\101\1\46\1\102\1\47\1\103\10\uffff\1\55\1\112\10\uffff\1\100\1\75\1\113\1\76\10\uffff\1\34\1\71\2\uffff\1\63\7\uffff\1\44\7\uffff\1\70\1\uffff\1\35\1\72\1\36\1\73\1\37\1\74\1\uffff\1\56\2\uffff\1\57\1\60\1\61\1\62\10\uffff\1\54\3\uffff\1\26\1\uffff\1\27\2\uffff\1\23\1\42\1\24\1\43\2\uffff\1\32\4\uffff\1\51\1\uffff\1\53\1\40\1\41\1\50\14\uffff\1\30\1\uffff\1\31\4\uffff\1\25\1\33\5\uffff\1\22\11\uffff\1\21\17\uffff\1\17\1\20\1\16\7\uffff\1\15\3\uffff\1\13\1\14\3\uffff\1\12\5\uffff\1\11\6\uffff\1\7\1\10\4\uffff\1\5\1\6\3\uffff\1\4\2\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA32_specialS =
        "\1\7\52\uffff\1\5\1\0\122\uffff\1\1\1\3\1\uffff\1\4\1\10\103\uffff\1\2\1\uffff\1\6\u0169\uffff}>";
    static final String[] DFA32_transitionS = {
            "\11\62\2\61\2\62\1\61\22\62\1\61\1\62\1\53\1\55\3\62\1\54\4\62\1\35\1\47\1\36\1\56\1\44\2\45\7\50\1\37\5\62\1\40\1\27\1\16\1\52\1\21\1\1\1\52\1\4\1\22\1\17\2\52\1\32\3\52\1\3\1\52\1\2\1\23\7\52\1\34\1\62\1\41\1\51\1\52\1\62\1\6\1\24\1\25\1\7\1\46\1\10\1\33\1\52\1\12\2\52\1\20\1\13\1\30\1\52\1\11\1\52\1\14\1\5\1\31\1\15\1\26\4\52\1\42\1\62\1\43\1\60\uff81\62",
            "\1\57\12\65\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\27\66\1\63\2\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\70\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\73\20\66\1\72\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\74\5\66\1\75\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\102\1\66\1\76\14\66\1\101\1\103\1\100\1\77\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\104\17\66\1\105\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\106\17\66\1\107\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\114\3\66\1\112\6\66\1\111\2\66\1\113\2\66\1\110\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\116\12\66\1\115\10\66\1\117\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\120\1\121\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\123\15\66\1\124\1\66\1\122\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\125\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\126\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\130\15\66\1\127\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\131\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\132\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\134\15\66\1\133\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\135\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\136\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\141\15\66\1\137\11\66\1\140\1\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\7\66\1\142\3\66\1\143\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\144\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\146\3\66\1\145\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\150\15\66\1\147\3\66\1\151\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\153\10\66\1\154\6\66\1\152\1\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\155\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\156\13\66",
            "\1\157",
            "",
            "\1\64\2\uffff\12\64\13\uffff\1\64\37\uffff\1\64",
            "",
            "",
            "",
            "",
            "",
            "\1\64\1\uffff\12\171\10\uffff\1\170\2\uffff\1\64\34\uffff\1\170\2\uffff\1\64",
            "\1\64\1\uffff\12\173\13\uffff\1\64\37\uffff\1\64",
            "\1\57\12\65\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\64\1\uffff\12\174\13\uffff\1\64\37\uffff\1\64",
            "\1\64\1\uffff\12\175\13\uffff\1\64\37\uffff\1\64",
            "\32\176\4\uffff\1\176\1\uffff\32\176",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\42\u0080\1\u0081\71\u0080\1\177\uffa3\u0080",
            "\47\u0083\1\u0084\64\u0083\1\u0082\uffa3\u0083",
            "",
            "\1\u0087\4\uffff\1\u0087\2\uffff\1\u0086\26\uffff\32\57\3\uffff\2\57\1\uffff\32\57",
            "",
            "\1\u0087\4\uffff\1\u0087",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0089\6\66",
            "",
            "\1\57\12\65\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u008a\16\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u008b\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u008c\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u008d\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u008e\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u008f\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u0090\30\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0091\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\25\66\1\u0092\4\66",
            "\1\u0093\1\uffff\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0094\1\uffff\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0096\1\uffff\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0095\6\66",
            "\1\u0097\1\uffff\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\5\66\1\u0099\11\66\1\u0098\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u009a\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u009b\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u009c\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u009d\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u009e\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u009f\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00a0\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00a1\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u00a2\30\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u00a3\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00a4\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00a5\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00a6\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u00a7\23\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\20\66\1\u00a9\1\66\1\u00a8\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00aa\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u00ab\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00ac\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00ad\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u00ae\30\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00af\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00b0\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00b1\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00b2\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u00b3\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00b4\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00b5\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00b6\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00b7\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00b8\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00b9\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\30\66\1\u00ba\1\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00bb\26\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u00bc\15\66",
            "\1\57\12\66\1\u00bd\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u00be\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u00bf\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00c0\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00c1\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00c2\31\66",
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
            "\1\64\1\uffff\12\u00c3\13\uffff\1\64\37\uffff\1\64",
            "",
            "\1\64\1\uffff\12\u00c5\13\uffff\1\64\37\uffff\1\64",
            "\1\64\1\uffff\12\u00c6\13\uffff\1\64\37\uffff\1\64",
            "\1\64\1\uffff\12\175\13\uffff\1\64\37\uffff\1\64",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\0\u00c7",
            "\42\u0080\1\u0081\71\u0080\1\177\uffa3\u0080",
            "\1\u0087\15\uffff\1\67",
            "\0\u00c9",
            "\47\u0083\1\u0084\64\u0083\1\u0082\uffa3\u0083",
            "\1\u0087\15\uffff\1\67",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00ca\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00cb\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\25\66\1\u00cc\4\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00cd\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u00ce\30\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u00cf\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\25\66\1\u00d0\4\66",
            "\1\u00d2\1\uffff\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00d1\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00d3\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00d4\7\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00d5\21\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00d6\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00d7\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00d8\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u00d9\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00da\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00db\26\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u00dc\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00dd\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u00de\23\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00df\31\66",
            "\1\u00e1\1\uffff\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00e0\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00e2\16\66",
            "\1\57\1\66\1\u00e3\1\66\1\u00e4\2\66\1\u00e5\1\66\1\u00e6\1\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00e7\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00e8\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00e9\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u00ea\4\66\1\u00eb\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00ec\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00ed\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00ee\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00ef\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00f0\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00f1\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u00f2\30\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00f3\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00f4\26\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00f5\13\66\1\u00f6\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00f7\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00f8\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00f9\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00fa\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u00fb\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00fc\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u00fd\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00ff\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0100\25\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0101\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0102\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0103\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0104\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0105\16\66",
            "\1\64\1\uffff\12\u0106\13\uffff\1\64\37\uffff\1\64",
            "",
            "\1\64\1\uffff\12\u0107\13\uffff\1\64\37\uffff\1\64",
            "\1\64\1\uffff\12\u00c6\13\uffff\1\64\37\uffff\1\64",
            "\42\u0080\1\u0081\71\u0080\1\177\uffa3\u0080",
            "",
            "\47\u0083\1\u0084\64\u0083\1\u0082\uffa3\u0083",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0108\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0109\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u010a\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u010b\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u010c\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\7\66\1\u010d\22\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u010e\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u010f\27\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0110\14\66",
            "\1\57\12\66\1\u0111\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u0112\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0113\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u0114\5\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0115\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\6\66\1\u0116\23\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0117\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u0118\30\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u0119\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u011a\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u011b\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u011c\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u011d\21\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u011e\25\66",
            "\1\57\6\66\1\u011f\3\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\2\66\1\u0120\7\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\4\66\1\u0121\5\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0122\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u0124\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u0125\31\66",
            "\1\57\12\66\1\u0126\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u0127\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0128\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0129\25\66",
            "\1\57\1\66\1\u012a\1\66\1\u012b\2\66\1\u012c\1\66\1\u012d\1\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u012e\25\66",
            "\1\57\6\66\1\u012f\3\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u0130\23\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u0131\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0132\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0134\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0135\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u0136\27\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0137\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0139\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\1\u013b\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u013c\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u013e\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u013f\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\30\66\1\u0140\1\66",
            "",
            "\1\57\12\66\1\u0141\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\1\u0144\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u014b\1\64\1\uffff\12\u014a\13\uffff\1\64\37\uffff\1\64",
            "\1\u014b\1\64\1\uffff\12\175\13\uffff\1\64\37\uffff\1\64",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u014c\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u014d\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u014e\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u014f\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0150\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\15\66\1\u0151\14\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u0152\27\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0153\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u0154\23\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0155\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u0156\26\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0157\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u0158\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u0159\21\66",
            "\1\57\3\66\1\u015a\2\66\1\u015b\3\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u015c\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u015d\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u015e\14\66",
            "\1\u0160\1\uffff\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u015f\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0161\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u0162\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0163\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0165\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0167\3\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u0169\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u016a\23\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u016b\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u016c\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u016d\7\66",
            "\1\57\6\66\1\u016e\3\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\2\66\1\u016f\7\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\4\66\1\u0170\5\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0171\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u0173\31\66",
            "\1\57\4\66\1\u0174\5\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0175\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0176\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0177\25\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0178\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\u0179\23\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u017a\6\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\1\u017c\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\64\1\uffff\12\u014a\13\uffff\1\64\37\uffff\1\64",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u017f\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\25\66\1\u0180\4\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0181\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0182\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\15\66\1\u0183\14\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u0184\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0185\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u0186\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u0187\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u0189\17\66\1\u018a\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u018c\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u018d\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u018e\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u018f\6\66",
            "\1\57\2\66\1\u0190\7\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\4\66\1\u0191\5\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u0192\27\66",
            "\1\57\12\66\1\u0193\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0194\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0195\6\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\7\66\1\u0196\22\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0197\25\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0198\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0199\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u019a\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u019c\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u019d\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u019f\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u01a1\3\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u01a3\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u01a5\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\30\66\1\u01a6\1\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u01ab\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01ac\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\15\66\1\u01ad\14\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01ae\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u01af\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u01b0\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u01b1\17\66\1\u01b2\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u01b4\30\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u01b5\16\66",
            "\1\57\12\66\1\u01b7\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01b6\25\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u01b8\14\66",
            "\1\57\12\66\1\u01b9\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u01ba\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\21\66\1\u01bb\10\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u01bc\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\1\u01be\3\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\12\66\1\u01c0\17\66",
            "",
            "\1\57\12\66\1\u01c2\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u01c1\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01c3\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01c4\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u01c5\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01c6\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01c8\25\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\3\66\1\u01cd\26\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\15\66\1\u01ce\14\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u01cf\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u01d0\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u01d1\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01d2\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u01d3\16\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01d4\25\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01d5\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u01d6\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u01d7\10\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u01d8\27\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01da\25\66",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u01dc\13\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u01dd\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u01de\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u01df\6\66",
            "\1\57\12\66\1\u01e0\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01e2\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u01e3\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u01e4\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\1\u01e5\31\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01e6\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u01e8\21\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u01e9\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u01ea\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01eb\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\25\66\1\u01ec\4\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u01ed\21\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u01ee\12\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u01ef\6\66",
            "\1\57\12\66\1\u01f1\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u01f0\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u01f2\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u01f3\7\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u01f4\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u01f5\15\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01f6\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u01f7\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u01f8\7\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01f9\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\25\66\1\u01fa\4\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u01fb\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u01fc\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01fd\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u01fe\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u01ff\13\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0200\7\66",
            "\1\57\12\66\1\u0201\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\57\12\66\1\u0202\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\1\u0203\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0204\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0205\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0206\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\30\66\1\u0207\1\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u0208\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0209\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u020a\25\66",
            "\1\57\12\66\1\u020b\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u020c\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u020d\10\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u020e\7\66",
            "\1\57\12\66\1\u020f\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\1\u0210\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0211\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0212\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u0213\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u0215\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0216\6\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0217\10\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0218\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0219\7\66",
            "\1\57\12\66\1\u021a\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u021b\26\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u021c\12\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u021d\31\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u021e\27\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u021f\7\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u0220\7\66",
            "\1\57\12\66\1\u0221\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\1\u0222\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0223\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\1\u0224\31\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u0225\27\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0226\25\66",
            "\1\57\12\66\1\u0227\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\57\12\66\1\u0228\2\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u0229\14\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u022a\27\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u022b\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u022d\27\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u022e\25\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\30\66\1\u0230\1\66",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\57\12\66\3\uffff\1\67\3\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
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
            return "1:1: Tokens : ( ExternalDependency | RelativeNamespace | PrivateNamespace | GlobalNamespace | Serviceclients | Serviceservers | Actionclients | Actionservers | Dependencies | ParameterAny | FromGitRepo | Pluginslots | Subscribers | Implements | Parameters | Publishers | Parameter | GraphName | Float32_1 | Float64_1 | Multiple | Actions | Default | Duration | Feedback | Plugins | Response | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Format | Int16_1 | Int32_1 | Int64_1 | Library | Message | Param | Request | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Int8_1 | Result | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Class | Int16 | Int32 | Int64 | Msgs | Node_1 | Pub | Srvs | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_44 = input.LA(1);

                        s = -1;
                        if ( (LA32_44=='\\') ) {s = 130;}

                        else if ( ((LA32_44>='\u0000' && LA32_44<='&')||(LA32_44>='(' && LA32_44<='[')||(LA32_44>=']' && LA32_44<='\uFFFF')) ) {s = 131;}

                        else if ( (LA32_44=='\'') ) {s = 132;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_127 = input.LA(1);

                        s = -1;
                        if ( ((LA32_127>='\u0000' && LA32_127<='\uFFFF')) ) {s = 199;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_199 = input.LA(1);

                        s = -1;
                        if ( (LA32_199=='\"') ) {s = 129;}

                        else if ( (LA32_199=='\\') ) {s = 127;}

                        else if ( ((LA32_199>='\u0000' && LA32_199<='!')||(LA32_199>='#' && LA32_199<='[')||(LA32_199>=']' && LA32_199<='\uFFFF')) ) {s = 128;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_128 = input.LA(1);

                        s = -1;
                        if ( (LA32_128=='\"') ) {s = 129;}

                        else if ( (LA32_128=='\\') ) {s = 127;}

                        else if ( ((LA32_128>='\u0000' && LA32_128<='!')||(LA32_128>='#' && LA32_128<='[')||(LA32_128>=']' && LA32_128<='\uFFFF')) ) {s = 128;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_130 = input.LA(1);

                        s = -1;
                        if ( ((LA32_130>='\u0000' && LA32_130<='\uFFFF')) ) {s = 201;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_43 = input.LA(1);

                        s = -1;
                        if ( (LA32_43=='\\') ) {s = 127;}

                        else if ( ((LA32_43>='\u0000' && LA32_43<='!')||(LA32_43>='#' && LA32_43<='[')||(LA32_43>=']' && LA32_43<='\uFFFF')) ) {s = 128;}

                        else if ( (LA32_43=='\"') ) {s = 129;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_201 = input.LA(1);

                        s = -1;
                        if ( (LA32_201=='\'') ) {s = 132;}

                        else if ( (LA32_201=='\\') ) {s = 130;}

                        else if ( ((LA32_201>='\u0000' && LA32_201<='&')||(LA32_201>='(' && LA32_201<='[')||(LA32_201>=']' && LA32_201<='\uFFFF')) ) {s = 131;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_0 = input.LA(1);

                        s = -1;
                        if ( (LA32_0=='E') ) {s = 1;}

                        else if ( (LA32_0=='R') ) {s = 2;}

                        else if ( (LA32_0=='P') ) {s = 3;}

                        else if ( (LA32_0=='G') ) {s = 4;}

                        else if ( (LA32_0=='s') ) {s = 5;}

                        else if ( (LA32_0=='a') ) {s = 6;}

                        else if ( (LA32_0=='d') ) {s = 7;}

                        else if ( (LA32_0=='f') ) {s = 8;}

                        else if ( (LA32_0=='p') ) {s = 9;}

                        else if ( (LA32_0=='i') ) {s = 10;}

                        else if ( (LA32_0=='m') ) {s = 11;}

                        else if ( (LA32_0=='r') ) {s = 12;}

                        else if ( (LA32_0=='u') ) {s = 13;}

                        else if ( (LA32_0=='B') ) {s = 14;}

                        else if ( (LA32_0=='I') ) {s = 15;}

                        else if ( (LA32_0=='l') ) {s = 16;}

                        else if ( (LA32_0=='D') ) {s = 17;}

                        else if ( (LA32_0=='H') ) {s = 18;}

                        else if ( (LA32_0=='S') ) {s = 19;}

                        else if ( (LA32_0=='b') ) {s = 20;}

                        else if ( (LA32_0=='c') ) {s = 21;}

                        else if ( (LA32_0=='v') ) {s = 22;}

                        else if ( (LA32_0=='A') ) {s = 23;}

                        else if ( (LA32_0=='n') ) {s = 24;}

                        else if ( (LA32_0=='t') ) {s = 25;}

                        else if ( (LA32_0=='L') ) {s = 26;}

                        else if ( (LA32_0=='g') ) {s = 27;}

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

                        else if ( (LA32_0=='e') ) {s = 38;}

                        else if ( (LA32_0=='-') ) {s = 39;}

                        else if ( ((LA32_0>='3' && LA32_0<='9')) ) {s = 40;}

                        else if ( (LA32_0=='^') ) {s = 41;}

                        else if ( (LA32_0=='C'||LA32_0=='F'||(LA32_0>='J' && LA32_0<='K')||(LA32_0>='M' && LA32_0<='O')||LA32_0=='Q'||(LA32_0>='T' && LA32_0<='Z')||LA32_0=='_'||LA32_0=='h'||(LA32_0>='j' && LA32_0<='k')||LA32_0=='o'||LA32_0=='q'||(LA32_0>='w' && LA32_0<='z')) ) {s = 42;}

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
                    case 8 : 
                        int LA32_131 = input.LA(1);

                        s = -1;
                        if ( (LA32_131=='\'') ) {s = 132;}

                        else if ( (LA32_131=='\\') ) {s = 130;}

                        else if ( ((LA32_131>='\u0000' && LA32_131<='&')||(LA32_131>='(' && LA32_131<='[')||(LA32_131>=']' && LA32_131<='\uFFFF')) ) {s = 131;}

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