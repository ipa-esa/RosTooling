package de.fraunhofer.ipa.ros1.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRos1Lexer extends Lexer {
    public static final int Float32_1=23;
    public static final int Node=90;
    public static final int RULE_DATE_TIME=116;
    public static final int Uint64_1=35;
    public static final int Serviceclients=8;
    public static final int String=53;
    public static final int Int16=69;
    public static final int Float32=38;
    public static final int Goal=87;
    public static final int Actionservers=11;
    public static final int Bool=84;
    public static final int Msgs=72;
    public static final int Uint16=62;
    public static final int Boolean=36;
    public static final int ExternalDependency=4;
    public static final int Sub=76;
    public static final int Uint8=78;
    public static final int Parameters=18;
    public static final int RULE_ID=117;
    public static final int Actions=26;
    public static final int RULE_DIGIT=106;
    public static final int GlobalNamespace=7;
    public static final int Artifacts=20;
    public static final int Node_1=73;
    public static final int Int16_1=41;
    public static final int Header=52;
    public static final int RULE_INT=119;
    public static final int Byte=85;
    public static final int RULE_ML_COMMENT=126;
    public static final int LeftSquareBracket=102;
    public static final int Pluginslots=15;
    public static final int Ac=82;
    public static final int Base64=50;
    public static final int Comma=98;
    public static final int As=83;
    public static final int RULE_MESSAGE_ASIGMENT=120;
    public static final int LeftSquareBracketRightSquareBracket=97;
    public static final int Int32=70;
    public static final int Char=86;
    public static final int Publishers=19;
    public static final int Srvs=75;
    public static final int RightCurlyBracket=105;
    public static final int RULE_DECINT=109;
    public static final int Uint32=63;
    public static final int Plugins=30;
    public static final int FromGitRepo=14;
    public static final int FullStop=99;
    public static final int RULE_HOUR=114;
    public static final int Int8=88;
    public static final int Default=27;
    public static final int Int8_1=59;
    public static final int CommercialAt=101;
    public static final int Uint16_1=33;
    public static final int Sc=91;
    public static final int Type=94;
    public static final int Float64=39;
    public static final int Int32_1=42;
    public static final int Parameter=21;
    public static final int RULE_BINARY=107;
    public static final int String_1=61;
    public static final int Subscribers=16;
    public static final int String_2=32;
    public static final int Ss=92;
    public static final int Actionclients=10;
    public static final int RULE_DAY=111;
    public static final int RULE_BEGIN=121;
    public static final int RULE_BOOLEAN=108;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=9;
    public static final int RULE_YEAR=113;
    public static final int Result=60;
    public static final int Name=89;
    public static final int RULE_MIN_SEC=115;
    public static final int Implements=17;
    public static final int Char_1=58;
    public static final int ParameterAny=13;
    public static final int List=81;
    public static final int Dependencies=12;
    public static final int RightSquareBracket=103;
    public static final int PrivateNamespace=6;
    public static final int GraphName=22;
    public static final int Byte_1=57;
    public static final int Float64_1=24;
    public static final int Duration=28;
    public static final int Uint32_1=34;
    public static final int Double=51;
    public static final int Type_1=77;
    public static final int Value=79;
    public static final int Class=68;
    public static final int Library=44;
    public static final int Uint64=64;
    public static final int Action=55;
    public static final int RULE_END=122;
    public static final int Message=45;
    public static final int Value_1=65;
    public static final int Time=93;
    public static final int RULE_STRING=118;
    public static final int Bool_1=56;
    public static final int Any=95;
    public static final int Struct=54;
    public static final int RULE_SL_COMMENT=123;
    public static final int Uint8_1=49;
    public static final int Format=40;
    public static final int RULE_DOUBLE=110;
    public static final int Feedback=29;
    public static final int RULE_ROS_CONVENTION_A=124;
    public static final int RULE_ROS_CONVENTION_PARAM=125;
    public static final int Colon=100;
    public static final int Pub=74;
    public static final int EOF=-1;
    public static final int Multiple=25;
    public static final int Ns=96;
    public static final int RULE_WS=127;
    public static final int Int64_1=43;
    public static final int Request=47;
    public static final int LeftCurlyBracket=104;
    public static final int Service=48;
    public static final int RULE_ANY_OTHER=128;
    public static final int Base=67;
    public static final int Date=80;
    public static final int Response=31;
    public static final int Integer=37;
    public static final int Array=66;
    public static final int Int64=71;
    public static final int Param=46;
    public static final int RULE_MONTH=112;

    // delegates
    // delegators

    public InternalRos1Lexer() {;} 
    public InternalRos1Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalRos1Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalRos1Lexer.g"; }

    // $ANTLR start "ExternalDependency"
    public final void mExternalDependency() throws RecognitionException {
        try {
            int _type = ExternalDependency;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRos1Lexer.g:14:20: ( 'ExternalDependency' )
            // InternalRos1Lexer.g:14:22: 'ExternalDependency'
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
            // InternalRos1Lexer.g:16:19: ( 'RelativeNamespace' )
            // InternalRos1Lexer.g:16:21: 'RelativeNamespace'
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
            // InternalRos1Lexer.g:18:18: ( 'PrivateNamespace' )
            // InternalRos1Lexer.g:18:20: 'PrivateNamespace'
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
            // InternalRos1Lexer.g:20:17: ( 'GlobalNamespace' )
            // InternalRos1Lexer.g:20:19: 'GlobalNamespace'
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
            // InternalRos1Lexer.g:22:16: ( 'serviceclients:' )
            // InternalRos1Lexer.g:22:18: 'serviceclients:'
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
            // InternalRos1Lexer.g:24:16: ( 'serviceservers:' )
            // InternalRos1Lexer.g:24:18: 'serviceservers:'
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
            // InternalRos1Lexer.g:26:15: ( 'actionclients:' )
            // InternalRos1Lexer.g:26:17: 'actionclients:'
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
            // InternalRos1Lexer.g:28:15: ( 'actionservers:' )
            // InternalRos1Lexer.g:28:17: 'actionservers:'
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
            // InternalRos1Lexer.g:30:14: ( 'dependencies:' )
            // InternalRos1Lexer.g:30:16: 'dependencies:'
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
            // InternalRos1Lexer.g:32:14: ( 'ParameterAny' )
            // InternalRos1Lexer.g:32:16: 'ParameterAny'
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
            // InternalRos1Lexer.g:34:13: ( 'fromGitRepo:' )
            // InternalRos1Lexer.g:34:15: 'fromGitRepo:'
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
            // InternalRos1Lexer.g:36:13: ( 'pluginslots:' )
            // InternalRos1Lexer.g:36:15: 'pluginslots:'
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
            // InternalRos1Lexer.g:38:13: ( 'subscribers:' )
            // InternalRos1Lexer.g:38:15: 'subscribers:'
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
            // InternalRos1Lexer.g:40:12: ( 'implements:' )
            // InternalRos1Lexer.g:40:14: 'implements:'
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
            // InternalRos1Lexer.g:42:12: ( 'parameters:' )
            // InternalRos1Lexer.g:42:14: 'parameters:'
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
            // InternalRos1Lexer.g:44:12: ( 'publishers:' )
            // InternalRos1Lexer.g:44:14: 'publishers:'
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

    // $ANTLR start "Artifacts"
    public final void mArtifacts() throws RecognitionException {
        try {
            int _type = Artifacts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRos1Lexer.g:46:11: ( 'artifacts:' )
            // InternalRos1Lexer.g:46:13: 'artifacts:'
            {
            match("artifacts:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Artifacts"

    // $ANTLR start "Parameter"
    public final void mParameter() throws RecognitionException {
        try {
            int _type = Parameter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalRos1Lexer.g:48:11: ( 'parameter:' )
            // InternalRos1Lexer.g:48:13: 'parameter:'
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
            // InternalRos1Lexer.g:50:11: ( 'GraphName' )
            // InternalRos1Lexer.g:50:13: 'GraphName'
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
            // InternalRos1Lexer.g:52:11: ( 'float32[]' )
            // InternalRos1Lexer.g:52:13: 'float32[]'
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
            // InternalRos1Lexer.g:54:11: ( 'float64[]' )
            // InternalRos1Lexer.g:54:13: 'float64[]'
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
            // InternalRos1Lexer.g:56:10: ( 'multiple:' )
            // InternalRos1Lexer.g:56:12: 'multiple:'
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
            // InternalRos1Lexer.g:58:9: ( 'actions:' )
            // InternalRos1Lexer.g:58:11: 'actions:'
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
            // InternalRos1Lexer.g:60:9: ( 'default:' )
            // InternalRos1Lexer.g:60:11: 'default:'
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
            // InternalRos1Lexer.g:62:10: ( 'duration' )
            // InternalRos1Lexer.g:62:12: 'duration'
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
            // InternalRos1Lexer.g:64:10: ( 'feedback' )
            // InternalRos1Lexer.g:64:12: 'feedback'
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
            // InternalRos1Lexer.g:66:9: ( 'plugins:' )
            // InternalRos1Lexer.g:66:11: 'plugins:'
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
            // InternalRos1Lexer.g:68:10: ( 'response' )
            // InternalRos1Lexer.g:68:12: 'response'
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
            // InternalRos1Lexer.g:70:10: ( 'string[]' )
            // InternalRos1Lexer.g:70:12: 'string[]'
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
            // InternalRos1Lexer.g:72:10: ( 'uint16[]' )
            // InternalRos1Lexer.g:72:12: 'uint16[]'
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
            // InternalRos1Lexer.g:74:10: ( 'uint32[]' )
            // InternalRos1Lexer.g:74:12: 'uint32[]'
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
            // InternalRos1Lexer.g:76:10: ( 'uint64[]' )
            // InternalRos1Lexer.g:76:12: 'uint64[]'
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
            // InternalRos1Lexer.g:78:9: ( 'Boolean' )
            // InternalRos1Lexer.g:78:11: 'Boolean'
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
            // InternalRos1Lexer.g:80:9: ( 'Integer' )
            // InternalRos1Lexer.g:80:11: 'Integer'
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
            // InternalRos1Lexer.g:82:9: ( 'float32' )
            // InternalRos1Lexer.g:82:11: 'float32'
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
            // InternalRos1Lexer.g:84:9: ( 'float64' )
            // InternalRos1Lexer.g:84:11: 'float64'
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
            // InternalRos1Lexer.g:86:8: ( 'format:' )
            // InternalRos1Lexer.g:86:10: 'format:'
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
            // InternalRos1Lexer.g:88:9: ( 'int16[]' )
            // InternalRos1Lexer.g:88:11: 'int16[]'
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
            // InternalRos1Lexer.g:90:9: ( 'int32[]' )
            // InternalRos1Lexer.g:90:11: 'int32[]'
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
            // InternalRos1Lexer.g:92:9: ( 'int64[]' )
            // InternalRos1Lexer.g:92:11: 'int64[]'
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
            // InternalRos1Lexer.g:94:9: ( 'library' )
            // InternalRos1Lexer.g:94:11: 'library'
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
            // InternalRos1Lexer.g:96:9: ( 'message' )
            // InternalRos1Lexer.g:96:11: 'message'
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
            // InternalRos1Lexer.g:98:7: ( 'param->' )
            // InternalRos1Lexer.g:98:9: 'param->'
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
            // InternalRos1Lexer.g:100:9: ( 'request' )
            // InternalRos1Lexer.g:100:11: 'request'
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
            // InternalRos1Lexer.g:102:9: ( 'service' )
            // InternalRos1Lexer.g:102:11: 'service'
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
            // InternalRos1Lexer.g:104:9: ( 'uint8[]' )
            // InternalRos1Lexer.g:104:11: 'uint8[]'
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
            // InternalRos1Lexer.g:106:8: ( 'Base64' )
            // InternalRos1Lexer.g:106:10: 'Base64'
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
            // InternalRos1Lexer.g:108:8: ( 'Double' )
            // InternalRos1Lexer.g:108:10: 'Double'
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
            // InternalRos1Lexer.g:110:8: ( 'Header' )
            // InternalRos1Lexer.g:110:10: 'Header'
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
            // InternalRos1Lexer.g:112:8: ( 'String' )
            // InternalRos1Lexer.g:112:10: 'String'
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
            // InternalRos1Lexer.g:114:8: ( 'Struct' )
            // InternalRos1Lexer.g:114:10: 'Struct'
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
            // InternalRos1Lexer.g:116:8: ( 'action' )
            // InternalRos1Lexer.g:116:10: 'action'
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
            // InternalRos1Lexer.g:118:8: ( 'bool[]' )
            // InternalRos1Lexer.g:118:10: 'bool[]'
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
            // InternalRos1Lexer.g:120:8: ( 'byte[]' )
            // InternalRos1Lexer.g:120:10: 'byte[]'
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
            // InternalRos1Lexer.g:122:8: ( 'char[]' )
            // InternalRos1Lexer.g:122:10: 'char[]'
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
            // InternalRos1Lexer.g:124:8: ( 'int8[]' )
            // InternalRos1Lexer.g:124:10: 'int8[]'
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
            // InternalRos1Lexer.g:126:8: ( 'result' )
            // InternalRos1Lexer.g:126:10: 'result'
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
            // InternalRos1Lexer.g:128:10: ( 'string' )
            // InternalRos1Lexer.g:128:12: 'string'
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
            // InternalRos1Lexer.g:130:8: ( 'uint16' )
            // InternalRos1Lexer.g:130:10: 'uint16'
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
            // InternalRos1Lexer.g:132:8: ( 'uint32' )
            // InternalRos1Lexer.g:132:10: 'uint32'
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
            // InternalRos1Lexer.g:134:8: ( 'uint64' )
            // InternalRos1Lexer.g:134:10: 'uint64'
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
            // InternalRos1Lexer.g:136:9: ( 'value:' )
            // InternalRos1Lexer.g:136:11: 'value:'
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
            // InternalRos1Lexer.g:138:7: ( 'Array' )
            // InternalRos1Lexer.g:138:9: 'Array'
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
            // InternalRos1Lexer.g:140:6: ( 'base:' )
            // InternalRos1Lexer.g:140:8: 'base:'
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
            // InternalRos1Lexer.g:142:7: ( 'class' )
            // InternalRos1Lexer.g:142:9: 'class'
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
            // InternalRos1Lexer.g:144:7: ( 'int16' )
            // InternalRos1Lexer.g:144:9: 'int16'
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
            // InternalRos1Lexer.g:146:7: ( 'int32' )
            // InternalRos1Lexer.g:146:9: 'int32'
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
            // InternalRos1Lexer.g:148:7: ( 'int64' )
            // InternalRos1Lexer.g:148:9: 'int64'
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
            // InternalRos1Lexer.g:150:6: ( 'msgs:' )
            // InternalRos1Lexer.g:150:8: 'msgs:'
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
            // InternalRos1Lexer.g:152:8: ( 'node:' )
            // InternalRos1Lexer.g:152:10: 'node:'
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
            // InternalRos1Lexer.g:154:5: ( 'pub->' )
            // InternalRos1Lexer.g:154:7: 'pub->'
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
            // InternalRos1Lexer.g:156:6: ( 'srvs:' )
            // InternalRos1Lexer.g:156:8: 'srvs:'
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
            // InternalRos1Lexer.g:158:5: ( 'sub->' )
            // InternalRos1Lexer.g:158:7: 'sub->'
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
            // InternalRos1Lexer.g:160:8: ( 'type:' )
            // InternalRos1Lexer.g:160:10: 'type:'
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
            // InternalRos1Lexer.g:162:7: ( 'uint8' )
            // InternalRos1Lexer.g:162:9: 'uint8'
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
            // InternalRos1Lexer.g:164:7: ( 'value' )
            // InternalRos1Lexer.g:164:9: 'value'
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
            // InternalRos1Lexer.g:166:6: ( 'Date' )
            // InternalRos1Lexer.g:166:8: 'Date'
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
            // InternalRos1Lexer.g:168:6: ( 'List' )
            // InternalRos1Lexer.g:168:8: 'List'
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
            // InternalRos1Lexer.g:170:4: ( 'ac->' )
            // InternalRos1Lexer.g:170:6: 'ac->'
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
            // InternalRos1Lexer.g:172:4: ( 'as->' )
            // InternalRos1Lexer.g:172:6: 'as->'
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
            // InternalRos1Lexer.g:174:6: ( 'bool' )
            // InternalRos1Lexer.g:174:8: 'bool'
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
            // InternalRos1Lexer.g:176:6: ( 'byte' )
            // InternalRos1Lexer.g:176:8: 'byte'
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
            // InternalRos1Lexer.g:178:6: ( 'char' )
            // InternalRos1Lexer.g:178:8: 'char'
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
            // InternalRos1Lexer.g:180:6: ( 'goal' )
            // InternalRos1Lexer.g:180:8: 'goal'
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
            // InternalRos1Lexer.g:182:6: ( 'int8' )
            // InternalRos1Lexer.g:182:8: 'int8'
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
            // InternalRos1Lexer.g:184:6: ( 'name' )
            // InternalRos1Lexer.g:184:8: 'name'
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
            // InternalRos1Lexer.g:186:6: ( 'node' )
            // InternalRos1Lexer.g:186:8: 'node'
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
            // InternalRos1Lexer.g:188:4: ( 'sc->' )
            // InternalRos1Lexer.g:188:6: 'sc->'
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
            // InternalRos1Lexer.g:190:4: ( 'ss->' )
            // InternalRos1Lexer.g:190:6: 'ss->'
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
            // InternalRos1Lexer.g:192:6: ( 'time' )
            // InternalRos1Lexer.g:192:8: 'time'
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
            // InternalRos1Lexer.g:194:6: ( 'type' )
            // InternalRos1Lexer.g:194:8: 'type'
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
            // InternalRos1Lexer.g:196:5: ( 'Any' )
            // InternalRos1Lexer.g:196:7: 'Any'
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
            // InternalRos1Lexer.g:198:4: ( 'ns:' )
            // InternalRos1Lexer.g:198:6: 'ns:'
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
            // InternalRos1Lexer.g:200:37: ( '[]' )
            // InternalRos1Lexer.g:200:39: '[]'
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
            // InternalRos1Lexer.g:202:7: ( ',' )
            // InternalRos1Lexer.g:202:9: ','
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
            // InternalRos1Lexer.g:204:10: ( '.' )
            // InternalRos1Lexer.g:204:12: '.'
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
            // InternalRos1Lexer.g:206:7: ( ':' )
            // InternalRos1Lexer.g:206:9: ':'
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
            // InternalRos1Lexer.g:208:14: ( '@' )
            // InternalRos1Lexer.g:208:16: '@'
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
            // InternalRos1Lexer.g:210:19: ( '[' )
            // InternalRos1Lexer.g:210:21: '['
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
            // InternalRos1Lexer.g:212:20: ( ']' )
            // InternalRos1Lexer.g:212:22: ']'
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
            // InternalRos1Lexer.g:214:18: ( '{' )
            // InternalRos1Lexer.g:214:20: '{'
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
            // InternalRos1Lexer.g:216:19: ( '}' )
            // InternalRos1Lexer.g:216:21: '}'
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
            // InternalRos1Lexer.g:218:21: ( '0' .. '9' )
            // InternalRos1Lexer.g:218:23: '0' .. '9'
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
            // InternalRos1Lexer.g:220:13: ( ( '0b' | '0B' ) ( '0' | '1' )+ )
            // InternalRos1Lexer.g:220:15: ( '0b' | '0B' ) ( '0' | '1' )+
            {
            // InternalRos1Lexer.g:220:15: ( '0b' | '0B' )
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
                    // InternalRos1Lexer.g:220:16: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:220:21: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            // InternalRos1Lexer.g:220:27: ( '0' | '1' )+
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
            	    // InternalRos1Lexer.g:
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
            // InternalRos1Lexer.g:222:14: ( ( 'true' | 'false' ) )
            // InternalRos1Lexer.g:222:16: ( 'true' | 'false' )
            {
            // InternalRos1Lexer.g:222:16: ( 'true' | 'false' )
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
                    // InternalRos1Lexer.g:222:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:222:24: 'false'
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
            // InternalRos1Lexer.g:224:13: ( ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* ) )
            // InternalRos1Lexer.g:224:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            {
            // InternalRos1Lexer.g:224:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* )
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
                    // InternalRos1Lexer.g:224:16: ( RULE_DIGIT )*
                    {
                    // InternalRos1Lexer.g:224:16: ( RULE_DIGIT )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalRos1Lexer.g:224:16: RULE_DIGIT
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
                    // InternalRos1Lexer.g:224:28: '-' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    // InternalRos1Lexer.g:224:32: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalRos1Lexer.g:224:32: RULE_DIGIT
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

            // InternalRos1Lexer.g:224:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalRos1Lexer.g:224:46: '.' ( RULE_DECINT )*
                    {
                    match('.'); 
                    // InternalRos1Lexer.g:224:50: ( RULE_DECINT )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='-'||(LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalRos1Lexer.g:224:50: RULE_DECINT
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
                    // InternalRos1Lexer.g:224:63: ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )*
                    {
                    // InternalRos1Lexer.g:224:63: ( '.' ( RULE_DIGIT )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalRos1Lexer.g:224:64: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // InternalRos1Lexer.g:224:68: ( RULE_DIGIT )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalRos1Lexer.g:224:68: RULE_DIGIT
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

                    // InternalRos1Lexer.g:224:92: ( '-' | '+' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='+'||LA10_0=='-') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalRos1Lexer.g:
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

                    // InternalRos1Lexer.g:224:103: ( RULE_DIGIT )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalRos1Lexer.g:224:103: RULE_DIGIT
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
            // InternalRos1Lexer.g:226:13: ( ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* ) )
            // InternalRos1Lexer.g:226:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
            {
            // InternalRos1Lexer.g:226:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
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
                    // InternalRos1Lexer.g:226:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:226:20: '1' .. '9' ( RULE_DIGIT )*
                    {
                    matchRange('1','9'); 
                    // InternalRos1Lexer.g:226:29: ( RULE_DIGIT )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalRos1Lexer.g:226:29: RULE_DIGIT
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
                    // InternalRos1Lexer.g:226:41: '-' '0' .. '9' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    matchRange('0','9'); 
                    // InternalRos1Lexer.g:226:54: ( RULE_DIGIT )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalRos1Lexer.g:226:54: RULE_DIGIT
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
            // InternalRos1Lexer.g:228:19: ( ( '1' .. '9' | '1' .. '3' '0' .. '9' ) )
            // InternalRos1Lexer.g:228:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
            {
            // InternalRos1Lexer.g:228:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
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
                    // InternalRos1Lexer.g:228:22: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:228:31: '1' .. '3' '0' .. '9'
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
            // InternalRos1Lexer.g:230:21: ( ( '1' .. '9' | '1' '0' .. '2' ) )
            // InternalRos1Lexer.g:230:23: ( '1' .. '9' | '1' '0' .. '2' )
            {
            // InternalRos1Lexer.g:230:23: ( '1' .. '9' | '1' '0' .. '2' )
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
                    // InternalRos1Lexer.g:230:24: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:230:33: '1' '0' .. '2'
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
            // InternalRos1Lexer.g:232:20: ( '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalRos1Lexer.g:232:22: '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9'
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
            // InternalRos1Lexer.g:234:20: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) )
            // InternalRos1Lexer.g:234:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
            {
            // InternalRos1Lexer.g:234:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
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
                    // InternalRos1Lexer.g:234:23: '0' .. '1' '0' .. '9'
                    {
                    matchRange('0','1'); 
                    matchRange('0','9'); 

                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:234:41: '2' '0' .. '3'
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
            // InternalRos1Lexer.g:236:23: ( '0' .. '5' '0' .. '9' )
            // InternalRos1Lexer.g:236:25: '0' .. '5' '0' .. '9'
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
            // InternalRos1Lexer.g:238:16: ( RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC )
            // InternalRos1Lexer.g:238:18: RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC
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
            // InternalRos1Lexer.g:240:23: ( ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT ) )
            // InternalRos1Lexer.g:240:25: ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
            {
            // InternalRos1Lexer.g:240:25: ( RULE_ID | RULE_STRING )
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
                    // InternalRos1Lexer.g:240:26: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:240:34: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;

            }

            match('='); 
            // InternalRos1Lexer.g:240:51: ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
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
                    // InternalRos1Lexer.g:240:52: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalRos1Lexer.g:240:60: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;
                case 3 :
                    // InternalRos1Lexer.g:240:72: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;
                case 4 :
                    // InternalRos1Lexer.g:240:81: '-' RULE_INT
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
            // InternalRos1Lexer.g:242:21: ()
            // InternalRos1Lexer.g:242:23: 
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
            // InternalRos1Lexer.g:244:19: ()
            // InternalRos1Lexer.g:244:21: 
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
            // InternalRos1Lexer.g:246:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalRos1Lexer.g:246:19: '#' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match('#'); 
            // InternalRos1Lexer.g:246:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalRos1Lexer.g:246:23: ~ ( ( '\\n' | '\\r' ) )
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
            // InternalRos1Lexer.g:248:23: ( ( '/' RULE_ID | RULE_ID '/' )* )
            // InternalRos1Lexer.g:248:25: ( '/' RULE_ID | RULE_ID '/' )*
            {
            // InternalRos1Lexer.g:248:25: ( '/' RULE_ID | RULE_ID '/' )*
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
            	    // InternalRos1Lexer.g:248:26: '/' RULE_ID
            	    {
            	    match('/'); 
            	    mRULE_ID(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalRos1Lexer.g:248:38: RULE_ID '/'
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
            // InternalRos1Lexer.g:250:27: ( ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )* )
            // InternalRos1Lexer.g:250:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
            {
            // InternalRos1Lexer.g:250:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
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
            	    // InternalRos1Lexer.g:250:30: '/' RULE_STRING
            	    {
            	    match('/'); 
            	    mRULE_STRING(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalRos1Lexer.g:250:46: RULE_STRING '/'
            	    {
            	    mRULE_STRING(); 
            	    match('/'); 

            	    }
            	    break;
            	case 3 :
            	    // InternalRos1Lexer.g:250:62: '~' RULE_STRING
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
            // InternalRos1Lexer.g:252:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalRos1Lexer.g:252:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalRos1Lexer.g:252:11: ( '^' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='^') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRos1Lexer.g:252:11: '^'
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

            // InternalRos1Lexer.g:252:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='9')||(LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||(LA25_0>='a' && LA25_0<='z')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalRos1Lexer.g:
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
            // InternalRos1Lexer.g:254:10: ( ( '0' .. '9' )+ )
            // InternalRos1Lexer.g:254:12: ( '0' .. '9' )+
            {
            // InternalRos1Lexer.g:254:12: ( '0' .. '9' )+
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
            	    // InternalRos1Lexer.g:254:13: '0' .. '9'
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
            // InternalRos1Lexer.g:256:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalRos1Lexer.g:256:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalRos1Lexer.g:256:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalRos1Lexer.g:256:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalRos1Lexer.g:256:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalRos1Lexer.g:256:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRos1Lexer.g:256:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalRos1Lexer.g:256:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalRos1Lexer.g:256:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalRos1Lexer.g:256:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRos1Lexer.g:256:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalRos1Lexer.g:258:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalRos1Lexer.g:258:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalRos1Lexer.g:258:24: ( options {greedy=false; } : . )*
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
            	    // InternalRos1Lexer.g:258:52: .
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
            // InternalRos1Lexer.g:260:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalRos1Lexer.g:260:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalRos1Lexer.g:260:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            	    // InternalRos1Lexer.g:
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
            // InternalRos1Lexer.g:262:16: ( . )
            // InternalRos1Lexer.g:262:18: .
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
        // InternalRos1Lexer.g:1:8: ( ExternalDependency | RelativeNamespace | PrivateNamespace | GlobalNamespace | Serviceclients | Serviceservers | Actionclients | Actionservers | Dependencies | ParameterAny | FromGitRepo | Pluginslots | Subscribers | Implements | Parameters | Publishers | Artifacts | Parameter | GraphName | Float32_1 | Float64_1 | Multiple | Actions | Default | Duration | Feedback | Plugins | Response | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Format | Int16_1 | Int32_1 | Int64_1 | Library | Message | Param | Request | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Int8_1 | Result | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Class | Int16 | Int32 | Int64 | Msgs | Node_1 | Pub | Srvs | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt32=117;
        alt32 = dfa32.predict(input);
        switch (alt32) {
            case 1 :
                // InternalRos1Lexer.g:1:10: ExternalDependency
                {
                mExternalDependency(); 

                }
                break;
            case 2 :
                // InternalRos1Lexer.g:1:29: RelativeNamespace
                {
                mRelativeNamespace(); 

                }
                break;
            case 3 :
                // InternalRos1Lexer.g:1:47: PrivateNamespace
                {
                mPrivateNamespace(); 

                }
                break;
            case 4 :
                // InternalRos1Lexer.g:1:64: GlobalNamespace
                {
                mGlobalNamespace(); 

                }
                break;
            case 5 :
                // InternalRos1Lexer.g:1:80: Serviceclients
                {
                mServiceclients(); 

                }
                break;
            case 6 :
                // InternalRos1Lexer.g:1:95: Serviceservers
                {
                mServiceservers(); 

                }
                break;
            case 7 :
                // InternalRos1Lexer.g:1:110: Actionclients
                {
                mActionclients(); 

                }
                break;
            case 8 :
                // InternalRos1Lexer.g:1:124: Actionservers
                {
                mActionservers(); 

                }
                break;
            case 9 :
                // InternalRos1Lexer.g:1:138: Dependencies
                {
                mDependencies(); 

                }
                break;
            case 10 :
                // InternalRos1Lexer.g:1:151: ParameterAny
                {
                mParameterAny(); 

                }
                break;
            case 11 :
                // InternalRos1Lexer.g:1:164: FromGitRepo
                {
                mFromGitRepo(); 

                }
                break;
            case 12 :
                // InternalRos1Lexer.g:1:176: Pluginslots
                {
                mPluginslots(); 

                }
                break;
            case 13 :
                // InternalRos1Lexer.g:1:188: Subscribers
                {
                mSubscribers(); 

                }
                break;
            case 14 :
                // InternalRos1Lexer.g:1:200: Implements
                {
                mImplements(); 

                }
                break;
            case 15 :
                // InternalRos1Lexer.g:1:211: Parameters
                {
                mParameters(); 

                }
                break;
            case 16 :
                // InternalRos1Lexer.g:1:222: Publishers
                {
                mPublishers(); 

                }
                break;
            case 17 :
                // InternalRos1Lexer.g:1:233: Artifacts
                {
                mArtifacts(); 

                }
                break;
            case 18 :
                // InternalRos1Lexer.g:1:243: Parameter
                {
                mParameter(); 

                }
                break;
            case 19 :
                // InternalRos1Lexer.g:1:253: GraphName
                {
                mGraphName(); 

                }
                break;
            case 20 :
                // InternalRos1Lexer.g:1:263: Float32_1
                {
                mFloat32_1(); 

                }
                break;
            case 21 :
                // InternalRos1Lexer.g:1:273: Float64_1
                {
                mFloat64_1(); 

                }
                break;
            case 22 :
                // InternalRos1Lexer.g:1:283: Multiple
                {
                mMultiple(); 

                }
                break;
            case 23 :
                // InternalRos1Lexer.g:1:292: Actions
                {
                mActions(); 

                }
                break;
            case 24 :
                // InternalRos1Lexer.g:1:300: Default
                {
                mDefault(); 

                }
                break;
            case 25 :
                // InternalRos1Lexer.g:1:308: Duration
                {
                mDuration(); 

                }
                break;
            case 26 :
                // InternalRos1Lexer.g:1:317: Feedback
                {
                mFeedback(); 

                }
                break;
            case 27 :
                // InternalRos1Lexer.g:1:326: Plugins
                {
                mPlugins(); 

                }
                break;
            case 28 :
                // InternalRos1Lexer.g:1:334: Response
                {
                mResponse(); 

                }
                break;
            case 29 :
                // InternalRos1Lexer.g:1:343: String_2
                {
                mString_2(); 

                }
                break;
            case 30 :
                // InternalRos1Lexer.g:1:352: Uint16_1
                {
                mUint16_1(); 

                }
                break;
            case 31 :
                // InternalRos1Lexer.g:1:361: Uint32_1
                {
                mUint32_1(); 

                }
                break;
            case 32 :
                // InternalRos1Lexer.g:1:370: Uint64_1
                {
                mUint64_1(); 

                }
                break;
            case 33 :
                // InternalRos1Lexer.g:1:379: Boolean
                {
                mBoolean(); 

                }
                break;
            case 34 :
                // InternalRos1Lexer.g:1:387: Integer
                {
                mInteger(); 

                }
                break;
            case 35 :
                // InternalRos1Lexer.g:1:395: Float32
                {
                mFloat32(); 

                }
                break;
            case 36 :
                // InternalRos1Lexer.g:1:403: Float64
                {
                mFloat64(); 

                }
                break;
            case 37 :
                // InternalRos1Lexer.g:1:411: Format
                {
                mFormat(); 

                }
                break;
            case 38 :
                // InternalRos1Lexer.g:1:418: Int16_1
                {
                mInt16_1(); 

                }
                break;
            case 39 :
                // InternalRos1Lexer.g:1:426: Int32_1
                {
                mInt32_1(); 

                }
                break;
            case 40 :
                // InternalRos1Lexer.g:1:434: Int64_1
                {
                mInt64_1(); 

                }
                break;
            case 41 :
                // InternalRos1Lexer.g:1:442: Library
                {
                mLibrary(); 

                }
                break;
            case 42 :
                // InternalRos1Lexer.g:1:450: Message
                {
                mMessage(); 

                }
                break;
            case 43 :
                // InternalRos1Lexer.g:1:458: Param
                {
                mParam(); 

                }
                break;
            case 44 :
                // InternalRos1Lexer.g:1:464: Request
                {
                mRequest(); 

                }
                break;
            case 45 :
                // InternalRos1Lexer.g:1:472: Service
                {
                mService(); 

                }
                break;
            case 46 :
                // InternalRos1Lexer.g:1:480: Uint8_1
                {
                mUint8_1(); 

                }
                break;
            case 47 :
                // InternalRos1Lexer.g:1:488: Base64
                {
                mBase64(); 

                }
                break;
            case 48 :
                // InternalRos1Lexer.g:1:495: Double
                {
                mDouble(); 

                }
                break;
            case 49 :
                // InternalRos1Lexer.g:1:502: Header
                {
                mHeader(); 

                }
                break;
            case 50 :
                // InternalRos1Lexer.g:1:509: String
                {
                mString(); 

                }
                break;
            case 51 :
                // InternalRos1Lexer.g:1:516: Struct
                {
                mStruct(); 

                }
                break;
            case 52 :
                // InternalRos1Lexer.g:1:523: Action
                {
                mAction(); 

                }
                break;
            case 53 :
                // InternalRos1Lexer.g:1:530: Bool_1
                {
                mBool_1(); 

                }
                break;
            case 54 :
                // InternalRos1Lexer.g:1:537: Byte_1
                {
                mByte_1(); 

                }
                break;
            case 55 :
                // InternalRos1Lexer.g:1:544: Char_1
                {
                mChar_1(); 

                }
                break;
            case 56 :
                // InternalRos1Lexer.g:1:551: Int8_1
                {
                mInt8_1(); 

                }
                break;
            case 57 :
                // InternalRos1Lexer.g:1:558: Result
                {
                mResult(); 

                }
                break;
            case 58 :
                // InternalRos1Lexer.g:1:565: String_1
                {
                mString_1(); 

                }
                break;
            case 59 :
                // InternalRos1Lexer.g:1:574: Uint16
                {
                mUint16(); 

                }
                break;
            case 60 :
                // InternalRos1Lexer.g:1:581: Uint32
                {
                mUint32(); 

                }
                break;
            case 61 :
                // InternalRos1Lexer.g:1:588: Uint64
                {
                mUint64(); 

                }
                break;
            case 62 :
                // InternalRos1Lexer.g:1:595: Value_1
                {
                mValue_1(); 

                }
                break;
            case 63 :
                // InternalRos1Lexer.g:1:603: Array
                {
                mArray(); 

                }
                break;
            case 64 :
                // InternalRos1Lexer.g:1:609: Base
                {
                mBase(); 

                }
                break;
            case 65 :
                // InternalRos1Lexer.g:1:614: Class
                {
                mClass(); 

                }
                break;
            case 66 :
                // InternalRos1Lexer.g:1:620: Int16
                {
                mInt16(); 

                }
                break;
            case 67 :
                // InternalRos1Lexer.g:1:626: Int32
                {
                mInt32(); 

                }
                break;
            case 68 :
                // InternalRos1Lexer.g:1:632: Int64
                {
                mInt64(); 

                }
                break;
            case 69 :
                // InternalRos1Lexer.g:1:638: Msgs
                {
                mMsgs(); 

                }
                break;
            case 70 :
                // InternalRos1Lexer.g:1:643: Node_1
                {
                mNode_1(); 

                }
                break;
            case 71 :
                // InternalRos1Lexer.g:1:650: Pub
                {
                mPub(); 

                }
                break;
            case 72 :
                // InternalRos1Lexer.g:1:654: Srvs
                {
                mSrvs(); 

                }
                break;
            case 73 :
                // InternalRos1Lexer.g:1:659: Sub
                {
                mSub(); 

                }
                break;
            case 74 :
                // InternalRos1Lexer.g:1:663: Type_1
                {
                mType_1(); 

                }
                break;
            case 75 :
                // InternalRos1Lexer.g:1:670: Uint8
                {
                mUint8(); 

                }
                break;
            case 76 :
                // InternalRos1Lexer.g:1:676: Value
                {
                mValue(); 

                }
                break;
            case 77 :
                // InternalRos1Lexer.g:1:682: Date
                {
                mDate(); 

                }
                break;
            case 78 :
                // InternalRos1Lexer.g:1:687: List
                {
                mList(); 

                }
                break;
            case 79 :
                // InternalRos1Lexer.g:1:692: Ac
                {
                mAc(); 

                }
                break;
            case 80 :
                // InternalRos1Lexer.g:1:695: As
                {
                mAs(); 

                }
                break;
            case 81 :
                // InternalRos1Lexer.g:1:698: Bool
                {
                mBool(); 

                }
                break;
            case 82 :
                // InternalRos1Lexer.g:1:703: Byte
                {
                mByte(); 

                }
                break;
            case 83 :
                // InternalRos1Lexer.g:1:708: Char
                {
                mChar(); 

                }
                break;
            case 84 :
                // InternalRos1Lexer.g:1:713: Goal
                {
                mGoal(); 

                }
                break;
            case 85 :
                // InternalRos1Lexer.g:1:718: Int8
                {
                mInt8(); 

                }
                break;
            case 86 :
                // InternalRos1Lexer.g:1:723: Name
                {
                mName(); 

                }
                break;
            case 87 :
                // InternalRos1Lexer.g:1:728: Node
                {
                mNode(); 

                }
                break;
            case 88 :
                // InternalRos1Lexer.g:1:733: Sc
                {
                mSc(); 

                }
                break;
            case 89 :
                // InternalRos1Lexer.g:1:736: Ss
                {
                mSs(); 

                }
                break;
            case 90 :
                // InternalRos1Lexer.g:1:739: Time
                {
                mTime(); 

                }
                break;
            case 91 :
                // InternalRos1Lexer.g:1:744: Type
                {
                mType(); 

                }
                break;
            case 92 :
                // InternalRos1Lexer.g:1:749: Any
                {
                mAny(); 

                }
                break;
            case 93 :
                // InternalRos1Lexer.g:1:753: Ns
                {
                mNs(); 

                }
                break;
            case 94 :
                // InternalRos1Lexer.g:1:756: LeftSquareBracketRightSquareBracket
                {
                mLeftSquareBracketRightSquareBracket(); 

                }
                break;
            case 95 :
                // InternalRos1Lexer.g:1:792: Comma
                {
                mComma(); 

                }
                break;
            case 96 :
                // InternalRos1Lexer.g:1:798: FullStop
                {
                mFullStop(); 

                }
                break;
            case 97 :
                // InternalRos1Lexer.g:1:807: Colon
                {
                mColon(); 

                }
                break;
            case 98 :
                // InternalRos1Lexer.g:1:813: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 99 :
                // InternalRos1Lexer.g:1:826: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 100 :
                // InternalRos1Lexer.g:1:844: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 101 :
                // InternalRos1Lexer.g:1:863: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 102 :
                // InternalRos1Lexer.g:1:880: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 103 :
                // InternalRos1Lexer.g:1:898: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 104 :
                // InternalRos1Lexer.g:1:910: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 105 :
                // InternalRos1Lexer.g:1:923: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 106 :
                // InternalRos1Lexer.g:1:935: RULE_DECINT
                {
                mRULE_DECINT(); 

                }
                break;
            case 107 :
                // InternalRos1Lexer.g:1:947: RULE_DATE_TIME
                {
                mRULE_DATE_TIME(); 

                }
                break;
            case 108 :
                // InternalRos1Lexer.g:1:962: RULE_MESSAGE_ASIGMENT
                {
                mRULE_MESSAGE_ASIGMENT(); 

                }
                break;
            case 109 :
                // InternalRos1Lexer.g:1:984: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 110 :
                // InternalRos1Lexer.g:1:1000: RULE_ROS_CONVENTION_A
                {
                mRULE_ROS_CONVENTION_A(); 

                }
                break;
            case 111 :
                // InternalRos1Lexer.g:1:1022: RULE_ROS_CONVENTION_PARAM
                {
                mRULE_ROS_CONVENTION_PARAM(); 

                }
                break;
            case 112 :
                // InternalRos1Lexer.g:1:1048: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 113 :
                // InternalRos1Lexer.g:1:1056: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 114 :
                // InternalRos1Lexer.g:1:1065: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 115 :
                // InternalRos1Lexer.g:1:1077: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 116 :
                // InternalRos1Lexer.g:1:1093: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 117 :
                // InternalRos1Lexer.g:1:1101: RULE_ANY_OTHER
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
            return "224:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )";
        }
    }
    static final String DFA32_eotS =
        "\1\57\1\65\32\71\1\161\1\uffff\1\163\5\uffff\2\173\1\65\1\62\1\173\1\62\1\71\2\62\1\uffff\1\62\1\uffff\1\62\2\uffff\1\71\1\65\2\uffff\2\71\1\uffff\66\71\12\uffff\1\u00c6\1\uffff\3\173\1\71\2\uffff\1\u00ca\2\uffff\1\u00ca\4\uffff\12\71\2\uffff\1\71\1\uffff\1\71\1\uffff\42\71\1\u0101\2\71\1\uffff\5\71\1\u00c6\1\uffff\2\173\3\uffff\10\71\1\uffff\17\71\1\uffff\4\71\1\u0127\14\71\1\u0137\3\71\1\u013c\1\u013e\1\71\1\u0141\3\71\1\uffff\1\u0146\1\u0147\1\u0149\1\u014a\1\u014b\1\u014c\1\u014d\1\u00c6\1\173\11\71\1\uffff\11\71\1\u014b\4\71\1\u0169\1\u016b\1\u016d\2\uffff\2\71\1\uffff\6\71\1\u0177\5\71\1\uffff\3\71\7\uffff\1\u0180\1\u0182\1\u0183\11\uffff\1\u00c6\1\uffff\10\71\1\u018d\1\u0190\13\71\1\uffff\2\71\6\uffff\3\71\1\u01a1\1\71\1\u01a4\1\u01a6\1\u01a8\2\uffff\1\71\1\u01aa\2\71\1\u01ad\1\u01ae\1\u01af\1\u01b0\4\uffff\6\71\1\u01b9\1\71\2\uffff\2\71\1\uffff\5\71\1\u01c4\1\u01c6\1\71\1\uffff\5\71\1\u01ce\1\71\1\uffff\1\u01d0\6\uffff\1\u01d1\1\uffff\1\u01d2\1\u01d3\4\uffff\10\71\1\uffff\3\71\1\uffff\2\71\1\uffff\1\u01e1\1\71\4\uffff\1\u01e3\1\71\1\uffff\4\71\1\uffff\1\u01e9\4\uffff\5\71\1\u01ef\7\71\1\uffff\1\71\1\uffff\4\71\2\uffff\5\71\1\uffff\5\71\1\uffff\4\71\1\uffff\17\71\3\uffff\3\71\1\u021d\3\71\1\uffff\3\71\2\uffff\3\71\1\uffff\5\71\1\uffff\6\71\2\uffff\3\71\1\u0235\2\uffff\2\71\1\u0238\1\uffff\1\71\1\u023a\1\uffff\1\u023b\2\uffff";
    static final String DFA32_eofS =
        "\u023c\uffff";
    static final String DFA32_minS =
        "\1\0\33\57\1\135\1\uffff\1\55\5\uffff\2\56\1\57\2\56\1\101\1\57\2\0\1\uffff\1\42\1\uffff\1\42\2\uffff\2\57\2\uffff\2\57\1\uffff\10\57\3\55\1\57\1\55\51\57\12\uffff\1\56\1\uffff\3\56\1\57\2\0\1\57\2\0\1\57\4\uffff\7\57\1\55\2\57\2\uffff\1\57\1\uffff\1\57\1\uffff\12\57\1\55\32\57\1\uffff\5\57\1\56\1\uffff\2\56\1\0\1\uffff\1\0\10\57\1\uffff\17\57\1\uffff\34\57\1\uffff\7\57\2\55\11\57\1\uffff\13\57\1\55\5\57\2\uffff\2\57\1\uffff\14\57\1\uffff\3\57\7\uffff\3\57\11\uffff\1\56\1\uffff\25\57\1\uffff\2\57\6\uffff\10\57\2\uffff\10\57\4\uffff\10\57\2\uffff\2\57\1\uffff\10\57\1\uffff\7\57\1\uffff\1\57\6\uffff\1\57\1\uffff\2\57\4\uffff\10\57\1\uffff\3\57\1\uffff\2\57\1\uffff\2\57\4\uffff\2\57\1\uffff\4\57\1\uffff\1\57\4\uffff\15\57\1\uffff\1\57\1\uffff\4\57\2\uffff\5\57\1\uffff\5\57\1\uffff\4\57\1\uffff\17\57\3\uffff\7\57\1\uffff\3\57\2\uffff\3\57\1\uffff\5\57\1\uffff\6\57\2\uffff\4\57\2\uffff\3\57\1\uffff\2\57\1\uffff\1\57\2\uffff";
    static final String DFA32_maxS =
        "\1\uffff\33\172\1\135\1\uffff\1\145\5\uffff\2\145\1\172\2\145\2\172\2\uffff\1\uffff\1\172\1\uffff\1\47\2\uffff\2\172\2\uffff\2\172\1\uffff\66\172\12\uffff\1\145\1\uffff\3\145\1\172\2\uffff\1\75\2\uffff\1\75\4\uffff\12\172\2\uffff\1\172\1\uffff\1\172\1\uffff\45\172\1\uffff\5\172\1\145\1\uffff\2\145\1\uffff\1\uffff\1\uffff\10\172\1\uffff\17\172\1\uffff\34\172\1\uffff\7\172\2\145\11\172\1\uffff\21\172\2\uffff\2\172\1\uffff\14\172\1\uffff\3\172\7\uffff\3\172\11\uffff\1\145\1\uffff\25\172\1\uffff\2\172\6\uffff\10\172\2\uffff\10\172\4\uffff\10\172\2\uffff\2\172\1\uffff\10\172\1\uffff\7\172\1\uffff\1\172\6\uffff\1\172\1\uffff\2\172\4\uffff\10\172\1\uffff\3\172\1\uffff\2\172\1\uffff\2\172\4\uffff\2\172\1\uffff\4\172\1\uffff\1\172\4\uffff\15\172\1\uffff\1\172\1\uffff\4\172\2\uffff\5\172\1\uffff\5\172\1\uffff\4\172\1\uffff\17\172\3\uffff\7\172\1\uffff\3\172\2\uffff\3\172\1\uffff\5\172\1\uffff\6\172\2\uffff\4\172\2\uffff\3\172\1\uffff\2\172\1\uffff\1\172\2\uffff";
    static final String DFA32_acceptS =
        "\35\uffff\1\137\1\uffff\1\141\1\142\1\144\1\145\1\146\11\uffff\1\155\1\uffff\1\156\1\uffff\1\164\1\165\2\uffff\1\151\1\154\2\uffff\1\160\66\uffff\1\136\1\143\1\137\1\140\1\141\1\142\1\144\1\145\1\146\1\147\1\uffff\1\152\12\uffff\1\155\1\163\1\157\1\164\12\uffff\1\130\1\131\1\uffff\1\117\1\uffff\1\120\45\uffff\1\135\6\uffff\1\161\3\uffff\1\162\11\uffff\1\111\17\uffff\1\107\34\uffff\1\134\22\uffff\1\110\21\uffff\1\70\1\125\2\uffff\1\105\14\uffff\1\115\3\uffff\1\65\1\121\1\66\1\122\1\100\1\67\1\123\3\uffff\1\106\1\127\1\126\1\112\1\133\1\132\1\150\1\116\1\124\1\uffff\1\153\25\uffff\1\53\2\uffff\1\46\1\102\1\47\1\103\1\50\1\104\10\uffff\1\56\1\113\10\uffff\1\101\1\76\1\114\1\77\10\uffff\1\35\1\72\2\uffff\1\64\10\uffff\1\45\7\uffff\1\71\1\uffff\1\36\1\73\1\37\1\74\1\40\1\75\1\uffff\1\57\2\uffff\1\60\1\61\1\62\1\63\10\uffff\1\55\3\uffff\1\27\2\uffff\1\30\2\uffff\1\24\1\43\1\25\1\44\2\uffff\1\33\4\uffff\1\52\1\uffff\1\54\1\41\1\42\1\51\15\uffff\1\31\1\uffff\1\32\4\uffff\1\26\1\34\5\uffff\1\23\5\uffff\1\21\4\uffff\1\22\17\uffff\1\17\1\20\1\16\7\uffff\1\15\3\uffff\1\13\1\14\3\uffff\1\12\5\uffff\1\11\6\uffff\1\7\1\10\4\uffff\1\5\1\6\3\uffff\1\4\2\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA32_specialS =
        "\1\10\52\uffff\1\2\1\5\123\uffff\1\3\1\7\1\uffff\1\4\1\1\104\uffff\1\6\1\uffff\1\0\u0170\uffff}>";
    static final String[] DFA32_transitionS = {
            "\11\62\2\61\2\62\1\61\22\62\1\61\1\62\1\53\1\55\3\62\1\54\4\62\1\35\1\47\1\36\1\56\1\44\2\45\7\50\1\37\5\62\1\40\1\27\1\16\1\52\1\21\1\1\1\52\1\4\1\22\1\17\2\52\1\32\3\52\1\3\1\52\1\2\1\23\7\52\1\34\1\62\1\41\1\51\1\52\1\62\1\6\1\24\1\25\1\7\1\46\1\10\1\33\1\52\1\12\2\52\1\20\1\13\1\30\1\52\1\11\1\52\1\14\1\5\1\31\1\15\1\26\4\52\1\42\1\62\1\43\1\60\uff81\62",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\27\67\1\63\2\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\70\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\73\20\67\1\72\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\74\5\67\1\75\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\102\1\67\1\76\14\67\1\101\1\103\1\100\1\77\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\104\16\67\1\105\1\106\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\107\17\67\1\110\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\115\3\67\1\113\6\67\1\112\2\67\1\114\2\67\1\111\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\117\12\67\1\116\10\67\1\120\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\121\1\122\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\124\15\67\1\125\1\67\1\123\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\126\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\127\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\131\15\67\1\130\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\132\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\133\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\135\15\67\1\134\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\136\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\137\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\142\15\67\1\140\11\67\1\141\1\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\7\67\1\143\3\67\1\144\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\145\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\147\3\67\1\146\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\151\15\67\1\150\3\67\1\152\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\154\10\67\1\155\6\67\1\153\1\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\156\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\157\13\67",
            "\1\160",
            "",
            "\1\65\2\uffff\12\65\13\uffff\1\65\37\uffff\1\65",
            "",
            "",
            "",
            "",
            "",
            "\1\65\1\uffff\12\172\10\uffff\1\171\2\uffff\1\65\34\uffff\1\171\2\uffff\1\65",
            "\1\65\1\uffff\12\174\13\uffff\1\65\37\uffff\1\65",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\65\1\uffff\12\175\13\uffff\1\65\37\uffff\1\65",
            "\1\65\1\uffff\12\176\13\uffff\1\65\37\uffff\1\65",
            "\32\177\4\uffff\1\177\1\uffff\32\177",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\42\u0081\1\u0082\71\u0081\1\u0080\uffa3\u0081",
            "\47\u0084\1\u0085\64\u0084\1\u0083\uffa3\u0084",
            "",
            "\1\u0088\4\uffff\1\u0088\2\uffff\1\u0087\26\uffff\32\57\3\uffff\2\57\1\uffff\32\57",
            "",
            "\1\u0088\4\uffff\1\u0088",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u008a\6\67",
            "\1\57\12\64\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u008b\16\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u008c\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u008d\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u008e\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u008f\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u0090\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u0091\30\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u0092\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\25\67\1\u0093\4\67",
            "\1\u0094\1\uffff\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0095\1\uffff\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0097\1\uffff\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0096\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0098\6\67",
            "\1\u0099\1\uffff\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\5\67\1\u009b\11\67\1\u009a\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u009c\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u009d\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u009e\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u009f\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u00a0\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u00a1\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\24\67\1\u00a2\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u00a3\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u00a4\30\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u00a5\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u00a6\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u00a7\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00a8\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\6\67\1\u00a9\23\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\20\67\1\u00ab\1\67\1\u00aa\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u00ac\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u00ad\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00ae\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u00af\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u00b0\30\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\24\67\1\u00b1\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u00b2\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00b3\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u00b4\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u00b5\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u00b6\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00b7\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00b8\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00b9\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u00ba\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u00bb\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\30\67\1\u00bc\1\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u00bd\26\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u00be\15\67",
            "\1\57\12\67\1\u00bf\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u00c0\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u00c1\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\24\67\1\u00c2\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00c3\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00c4\31\67",
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
            "\1\65\1\uffff\12\u00c5\13\uffff\1\65\37\uffff\1\65",
            "",
            "\1\65\1\uffff\12\u00c7\13\uffff\1\65\37\uffff\1\65",
            "\1\65\1\uffff\12\u00c8\13\uffff\1\65\37\uffff\1\65",
            "\1\65\1\uffff\12\176\13\uffff\1\65\37\uffff\1\65",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\0\u00c9",
            "\42\u0081\1\u0082\71\u0081\1\u0080\uffa3\u0081",
            "\1\u0088\15\uffff\1\66",
            "\0\u00cb",
            "\47\u0084\1\u0085\64\u0084\1\u0083\uffa3\u0084",
            "\1\u0088\15\uffff\1\66",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u00cc\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00cd\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\25\67\1\u00ce\4\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00cf\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u00d0\30\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u00d1\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\25\67\1\u00d2\4\67",
            "\1\u00d4\1\uffff\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00d3\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u00d5\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00d6\7\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u00d7\21\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u00d8\21\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u00d9\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00da\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00db\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u00dc\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00dd\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u00de\26\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u00df\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00e0\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\6\67\1\u00e1\23\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u00e2\31\67",
            "\1\u00e4\1\uffff\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u00e3\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u00e5\16\67",
            "\1\57\1\67\1\u00e6\1\67\1\u00e7\2\67\1\u00e8\1\67\1\u00e9\1\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u00ea\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00eb\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00ec\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u00ed\4\67\1\u00ee\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\24\67\1\u00ef\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u00f0\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u00f1\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u00f2\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u00f3\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u00f4\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u00f5\30\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u00f6\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u00f7\26\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u00f8\13\67\1\u00f9\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u00fa\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u00fb\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u00fc\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u00fd\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u00fe\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\24\67\1\u00ff\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0100\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0102\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0103\25\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0104\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0105\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0106\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0107\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u0108\16\67",
            "\1\65\1\uffff\12\u0109\13\uffff\1\65\37\uffff\1\65",
            "",
            "\1\65\1\uffff\12\u010a\13\uffff\1\65\37\uffff\1\65",
            "\1\65\1\uffff\12\u00c8\13\uffff\1\65\37\uffff\1\65",
            "\42\u0081\1\u0082\71\u0081\1\u0080\uffa3\u0081",
            "",
            "\47\u0084\1\u0085\64\u0084\1\u0083\uffa3\u0084",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u010b\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u010c\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u010d\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u010e\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u010f\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\7\67\1\u0110\22\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u0111\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u0112\27\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0113\14\67",
            "\1\57\12\67\1\u0114\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u0115\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\5\67\1\u0116\24\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0117\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\24\67\1\u0118\5\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0119\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\6\67\1\u011a\23\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u011b\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u011c\30\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u011d\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u011e\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u011f\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u0120\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u0121\21\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0122\25\67",
            "\1\57\6\67\1\u0123\3\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\2\67\1\u0124\7\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\4\67\1\u0125\5\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u0126\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u0128\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0129\31\67",
            "\1\57\12\67\1\u012a\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u012b\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u012c\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u012d\25\67",
            "\1\57\1\67\1\u012e\1\67\1\u012f\2\67\1\u0130\1\67\1\u0131\1\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0132\25\67",
            "\1\57\6\67\1\u0133\3\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\6\67\1\u0134\23\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0135\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u0136\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0138\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0139\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u013a\27\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u013b\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u013d\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\1\u013f\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u0140\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0142\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0143\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\30\67\1\u0144\1\67",
            "",
            "\1\57\12\67\1\u0145\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\1\u0148\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u014f\1\65\1\uffff\12\u014e\13\uffff\1\65\37\uffff\1\65",
            "\1\u014f\1\65\1\uffff\12\176\13\uffff\1\65\37\uffff\1\65",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0150\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u0151\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0152\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0153\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u0154\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\15\67\1\u0155\14\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u0156\27\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u0157\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\6\67\1\u0158\23\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0159\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u015a\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u015b\26\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u015c\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u015d\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u015e\21\67",
            "\1\57\3\67\1\u015f\2\67\1\u0160\3\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0161\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0162\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0163\14\67",
            "\1\u0165\1\uffff\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0164\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0166\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u0167\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u0168\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u016a\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u016c\3\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u016e\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\6\67\1\u016f\23\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0170\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0171\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0172\7\67",
            "\1\57\6\67\1\u0173\3\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\2\67\1\u0174\7\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\4\67\1\u0175\5\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u0176\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0178\31\67",
            "\1\57\4\67\1\u0179\5\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u017a\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u017b\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u017c\25\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u017d\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\6\67\1\u017e\23\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u017f\6\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\1\u0181\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\65\1\uffff\12\u014e\13\uffff\1\65\37\uffff\1\65",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0184\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\25\67\1\u0185\4\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0186\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0187\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\15\67\1\u0188\14\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0189\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u018a\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u018b\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u018c\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u018e\17\67\1\u018f\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u0191\27\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0192\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0193\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u0194\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0195\6\67",
            "\1\57\2\67\1\u0196\7\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\4\67\1\u0197\5\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u0198\27\67",
            "\1\57\12\67\1\u0199\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u019a\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u019b\6\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\7\67\1\u019c\22\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u019d\25\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u019e\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u019f\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u01a0\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u01a2\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u01a3\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u01a5\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u01a7\3\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u01a9\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u01ab\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\30\67\1\u01ac\1\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u01b1\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01b2\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\15\67\1\u01b3\14\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01b4\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u01b5\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u01b6\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u01b7\17\67\1\u01b8\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\67\1\u01ba\30\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u01bb\16\67",
            "\1\57\12\67\1\u01bd\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01bc\25\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u01be\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u01bf\14\67",
            "\1\57\12\67\1\u01c0\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u01c1\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\21\67\1\u01c2\10\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u01c3\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\1\u01c5\3\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\12\67\1\u01c7\17\67",
            "",
            "\1\57\12\67\1\u01c9\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u01c8\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01ca\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01cb\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u01cc\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01cd\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01cf\25\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\3\67\1\u01d4\26\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\15\67\1\u01d5\14\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u01d6\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u01d7\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u01d8\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01d9\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\13\67\1\u01da\16\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01db\25\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01dc\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u01dd\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u01de\10\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u01df\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u01e0\27\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01e2\25\67",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u01e4\13\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u01e5\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u01e6\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u01e7\6\67",
            "\1\57\12\67\1\u01e8\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01ea\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u01eb\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u01ec\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\1\u01ed\31\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01ee\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u01f0\21\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u01f1\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u01f2\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01f3\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\25\67\1\u01f4\4\67",
            "\1\57\12\67\1\u01f5\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\10\67\1\u01f6\21\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u01f7\12\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u01f8\6\67",
            "\1\57\12\67\1\u01fa\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u01f9\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u01fb\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u01fc\7\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u01fd\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\14\67\1\u01fe\15\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u01ff\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0200\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0201\7\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0202\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\25\67\1\u0203\4\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0204\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0205\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0206\25\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0207\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\16\67\1\u0208\13\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0209\7\67",
            "\1\57\12\67\1\u020a\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\57\12\67\1\u020b\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\1\u020c\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u020d\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u020e\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u020f\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\30\67\1\u0210\1\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u0211\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0212\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0213\25\67",
            "\1\57\12\67\1\u0214\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u0215\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u0216\10\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0217\7\67",
            "\1\57\12\67\1\u0218\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\1\u0219\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u021a\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u021b\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u021c\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u021e\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\23\67\1\u021f\6\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\21\67\1\u0220\10\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0221\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0222\7\67",
            "\1\57\12\67\1\u0223\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\3\67\1\u0224\26\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\17\67\1\u0225\12\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u0226\31\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u0227\27\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0228\7\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\22\67\1\u0229\7\67",
            "\1\57\12\67\1\u022a\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\1\u022b\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u022c\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\1\u022d\31\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u022e\27\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u022f\25\67",
            "\1\57\12\67\1\u0230\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\57\12\67\1\u0231\2\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\15\67\1\u0232\14\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u0233\27\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0234\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\2\67\1\u0236\27\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\4\67\1\u0237\25\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\30\67\1\u0239\1\67",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\57\12\67\3\uffff\1\66\3\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
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
            return "1:1: Tokens : ( ExternalDependency | RelativeNamespace | PrivateNamespace | GlobalNamespace | Serviceclients | Serviceservers | Actionclients | Actionservers | Dependencies | ParameterAny | FromGitRepo | Pluginslots | Subscribers | Implements | Parameters | Publishers | Artifacts | Parameter | GraphName | Float32_1 | Float64_1 | Multiple | Actions | Default | Duration | Feedback | Plugins | Response | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Format | Int16_1 | Int32_1 | Int64_1 | Library | Message | Param | Request | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Int8_1 | Result | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Class | Int16 | Int32 | Int64 | Msgs | Node_1 | Pub | Srvs | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_203 = input.LA(1);

                        s = -1;
                        if ( (LA32_203=='\'') ) {s = 133;}

                        else if ( (LA32_203=='\\') ) {s = 131;}

                        else if ( ((LA32_203>='\u0000' && LA32_203<='&')||(LA32_203>='(' && LA32_203<='[')||(LA32_203>=']' && LA32_203<='\uFFFF')) ) {s = 132;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_132 = input.LA(1);

                        s = -1;
                        if ( (LA32_132=='\'') ) {s = 133;}

                        else if ( (LA32_132=='\\') ) {s = 131;}

                        else if ( ((LA32_132>='\u0000' && LA32_132<='&')||(LA32_132>='(' && LA32_132<='[')||(LA32_132>=']' && LA32_132<='\uFFFF')) ) {s = 132;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_43 = input.LA(1);

                        s = -1;
                        if ( (LA32_43=='\\') ) {s = 128;}

                        else if ( ((LA32_43>='\u0000' && LA32_43<='!')||(LA32_43>='#' && LA32_43<='[')||(LA32_43>=']' && LA32_43<='\uFFFF')) ) {s = 129;}

                        else if ( (LA32_43=='\"') ) {s = 130;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_128 = input.LA(1);

                        s = -1;
                        if ( ((LA32_128>='\u0000' && LA32_128<='\uFFFF')) ) {s = 201;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_131 = input.LA(1);

                        s = -1;
                        if ( ((LA32_131>='\u0000' && LA32_131<='\uFFFF')) ) {s = 203;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_44 = input.LA(1);

                        s = -1;
                        if ( (LA32_44=='\\') ) {s = 131;}

                        else if ( ((LA32_44>='\u0000' && LA32_44<='&')||(LA32_44>='(' && LA32_44<='[')||(LA32_44>=']' && LA32_44<='\uFFFF')) ) {s = 132;}

                        else if ( (LA32_44=='\'') ) {s = 133;}

                        else s = 50;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_201 = input.LA(1);

                        s = -1;
                        if ( (LA32_201=='\"') ) {s = 130;}

                        else if ( (LA32_201=='\\') ) {s = 128;}

                        else if ( ((LA32_201>='\u0000' && LA32_201<='!')||(LA32_201>='#' && LA32_201<='[')||(LA32_201>=']' && LA32_201<='\uFFFF')) ) {s = 129;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_129 = input.LA(1);

                        s = -1;
                        if ( (LA32_129=='\"') ) {s = 130;}

                        else if ( (LA32_129=='\\') ) {s = 128;}

                        else if ( ((LA32_129>='\u0000' && LA32_129<='!')||(LA32_129>='#' && LA32_129<='[')||(LA32_129>=']' && LA32_129<='\uFFFF')) ) {s = 129;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
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
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}