package de.fraunhofer.ipa.ros.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBasicsLexer extends Lexer {
    public static final int Node=64;
    public static final int RULE_DATE_TIME=90;
    public static final int String=33;
    public static final int Int16=46;
    public static final int Float32=22;
    public static final int Goal=61;
    public static final int Bool=58;
    public static final int Uint16=40;
    public static final int Boolean=20;
    public static final int Sub=50;
    public static final int Uint8=52;
    public static final int RULE_ID=91;
    public static final int Lifecycle=12;
    public static final int RULE_DIGIT=80;
    public static final int GlobalNamespace=6;
    public static final int Header=32;
    public static final int RULE_INT=93;
    public static final int Byte=59;
    public static final int RULE_ML_COMMENT=100;
    public static final int LeftSquareBracket=76;
    public static final int Pluginslots=9;
    public static final int Ac=56;
    public static final int Base64=30;
    public static final int Pluginbases=8;
    public static final int Comma=72;
    public static final int As=57;
    public static final int RULE_MESSAGE_ASIGMENT=94;
    public static final int Int32=47;
    public static final int Char=60;
    public static final int LessThanSignEqualsSign=71;
    public static final int RightCurlyBracket=79;
    public static final int RULE_DECINT=83;
    public static final int Uint32=41;
    public static final int Plugins=19;
    public static final int FullStop=73;
    public static final int RULE_HOUR=88;
    public static final int Int8=62;
    public static final int Default=16;
    public static final int CommercialAt=75;
    public static final int Sc=65;
    public static final int Type=68;
    public static final int Float64=23;
    public static final int Parameter=13;
    public static final int RULE_BINARY=81;
    public static final int String_1=39;
    public static final int Active_in=11;
    public static final int Header_1=25;
    public static final int Ss=66;
    public static final int RULE_DAY=85;
    public static final int RULE_BEGIN=95;
    public static final int RULE_BOOLEAN=82;
    public static final int RelativeNamespace=4;
    public static final int RULE_YEAR=87;
    public static final int Result=37;
    public static final int Name=63;
    public static final int RULE_MIN_SEC=89;
    public static final int Implements=10;
    public static final int ParameterAny=7;
    public static final int List=55;
    public static final int RightSquareBracket=77;
    public static final int PrivateNamespace=5;
    public static final int GraphName=14;
    public static final int Duration=17;
    public static final int Double=31;
    public static final int Type_1=51;
    public static final int Value=53;
    public static final int Class=36;
    public static final int Uint64=42;
    public static final int Action=35;
    public static final int RULE_END=96;
    public static final int Message=27;
    public static final int Value_1=43;
    public static final int Loader=26;
    public static final int Time=67;
    public static final int RULE_STRING=92;
    public static final int Any=69;
    public static final int Struct=34;
    public static final int RULE_SL_COMMENT=97;
    public static final int Slots=38;
    public static final int Format=24;
    public static final int RULE_DOUBLE=84;
    public static final int Feedback=18;
    public static final int RULE_ROS_CONVENTION_A=98;
    public static final int RULE_ROS_CONVENTION_PARAM=99;
    public static final int Colon=74;
    public static final int Pub=49;
    public static final int EOF=-1;
    public static final int Multiple=15;
    public static final int Ns=70;
    public static final int RULE_WS=101;
    public static final int LeftCurlyBracket=78;
    public static final int Service=29;
    public static final int RULE_ANY_OTHER=102;
    public static final int Base=45;
    public static final int Date=54;
    public static final int Integer=21;
    public static final int Array=44;
    public static final int Int64=48;
    public static final int Param=28;
    public static final int RULE_MONTH=86;

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

    // $ANTLR start "Multiple"
    public final void mMultiple() throws RecognitionException {
        try {
            int _type = Multiple;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:36:10: ( 'multiple:' )
            // InternalBasicsLexer.g:36:12: 'multiple:'
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
            // InternalBasicsLexer.g:38:9: ( 'default:' )
            // InternalBasicsLexer.g:38:11: 'default:'
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
            // InternalBasicsLexer.g:40:10: ( 'duration' )
            // InternalBasicsLexer.g:40:12: 'duration'
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
            // InternalBasicsLexer.g:42:10: ( 'feedback' )
            // InternalBasicsLexer.g:42:12: 'feedback'
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
            // InternalBasicsLexer.g:44:9: ( 'plugins:' )
            // InternalBasicsLexer.g:44:11: 'plugins:'
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

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:46:9: ( 'Boolean' )
            // InternalBasicsLexer.g:46:11: 'Boolean'
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
            // InternalBasicsLexer.g:48:9: ( 'Integer' )
            // InternalBasicsLexer.g:48:11: 'Integer'
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
            // InternalBasicsLexer.g:50:9: ( 'float32' )
            // InternalBasicsLexer.g:50:11: 'float32'
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
            // InternalBasicsLexer.g:52:9: ( 'float64' )
            // InternalBasicsLexer.g:52:11: 'float64'
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
            // InternalBasicsLexer.g:54:8: ( 'format:' )
            // InternalBasicsLexer.g:54:10: 'format:'
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
            // InternalBasicsLexer.g:56:10: ( 'header:' )
            // InternalBasicsLexer.g:56:12: 'header:'
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

    // $ANTLR start "Loader"
    public final void mLoader() throws RecognitionException {
        try {
            int _type = Loader;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:58:8: ( 'loader:' )
            // InternalBasicsLexer.g:58:10: 'loader:'
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
            // InternalBasicsLexer.g:60:9: ( 'message' )
            // InternalBasicsLexer.g:60:11: 'message'
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
            // InternalBasicsLexer.g:62:7: ( 'param->' )
            // InternalBasicsLexer.g:62:9: 'param->'
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
            // InternalBasicsLexer.g:64:9: ( 'service' )
            // InternalBasicsLexer.g:64:11: 'service'
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

    // $ANTLR start "Base64"
    public final void mBase64() throws RecognitionException {
        try {
            int _type = Base64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:66:8: ( 'Base64' )
            // InternalBasicsLexer.g:66:10: 'Base64'
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
            // InternalBasicsLexer.g:68:8: ( 'Double' )
            // InternalBasicsLexer.g:68:10: 'Double'
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
            // InternalBasicsLexer.g:70:8: ( 'Header' )
            // InternalBasicsLexer.g:70:10: 'Header'
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
            // InternalBasicsLexer.g:72:8: ( 'String' )
            // InternalBasicsLexer.g:72:10: 'String'
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
            // InternalBasicsLexer.g:74:8: ( 'Struct' )
            // InternalBasicsLexer.g:74:10: 'Struct'
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
            // InternalBasicsLexer.g:76:8: ( 'action' )
            // InternalBasicsLexer.g:76:10: 'action'
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

    // $ANTLR start "Class"
    public final void mClass() throws RecognitionException {
        try {
            int _type = Class;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:78:7: ( 'class:' )
            // InternalBasicsLexer.g:78:9: 'class:'
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

    // $ANTLR start "Result"
    public final void mResult() throws RecognitionException {
        try {
            int _type = Result;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:80:8: ( 'result' )
            // InternalBasicsLexer.g:80:10: 'result'
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
            // InternalBasicsLexer.g:82:7: ( 'slots:' )
            // InternalBasicsLexer.g:82:9: 'slots:'
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
            // InternalBasicsLexer.g:84:10: ( 'string' )
            // InternalBasicsLexer.g:84:12: 'string'
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
            // InternalBasicsLexer.g:86:8: ( 'uint16' )
            // InternalBasicsLexer.g:86:10: 'uint16'
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
            // InternalBasicsLexer.g:88:8: ( 'uint32' )
            // InternalBasicsLexer.g:88:10: 'uint32'
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
            // InternalBasicsLexer.g:90:8: ( 'uint64' )
            // InternalBasicsLexer.g:90:10: 'uint64'
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
            // InternalBasicsLexer.g:92:9: ( 'value:' )
            // InternalBasicsLexer.g:92:11: 'value:'
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
            // InternalBasicsLexer.g:94:7: ( 'Array' )
            // InternalBasicsLexer.g:94:9: 'Array'
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
            // InternalBasicsLexer.g:96:6: ( 'base:' )
            // InternalBasicsLexer.g:96:8: 'base:'
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
            // InternalBasicsLexer.g:98:7: ( 'int16' )
            // InternalBasicsLexer.g:98:9: 'int16'
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
            // InternalBasicsLexer.g:100:7: ( 'int32' )
            // InternalBasicsLexer.g:100:9: 'int32'
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
            // InternalBasicsLexer.g:102:7: ( 'int64' )
            // InternalBasicsLexer.g:102:9: 'int64'
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
            // InternalBasicsLexer.g:104:5: ( 'pub->' )
            // InternalBasicsLexer.g:104:7: 'pub->'
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
            // InternalBasicsLexer.g:106:5: ( 'sub->' )
            // InternalBasicsLexer.g:106:7: 'sub->'
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
            // InternalBasicsLexer.g:108:8: ( 'type:' )
            // InternalBasicsLexer.g:108:10: 'type:'
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
            // InternalBasicsLexer.g:110:7: ( 'uint8' )
            // InternalBasicsLexer.g:110:9: 'uint8'
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
            // InternalBasicsLexer.g:112:7: ( 'value' )
            // InternalBasicsLexer.g:112:9: 'value'
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
            // InternalBasicsLexer.g:114:6: ( 'Date' )
            // InternalBasicsLexer.g:114:8: 'Date'
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
            // InternalBasicsLexer.g:116:6: ( 'List' )
            // InternalBasicsLexer.g:116:8: 'List'
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
            // InternalBasicsLexer.g:118:4: ( 'ac->' )
            // InternalBasicsLexer.g:118:6: 'ac->'
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
            // InternalBasicsLexer.g:120:4: ( 'as->' )
            // InternalBasicsLexer.g:120:6: 'as->'
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
            // InternalBasicsLexer.g:122:6: ( 'bool' )
            // InternalBasicsLexer.g:122:8: 'bool'
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
            // InternalBasicsLexer.g:124:6: ( 'byte' )
            // InternalBasicsLexer.g:124:8: 'byte'
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
            // InternalBasicsLexer.g:126:6: ( 'char' )
            // InternalBasicsLexer.g:126:8: 'char'
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
            // InternalBasicsLexer.g:128:6: ( 'goal' )
            // InternalBasicsLexer.g:128:8: 'goal'
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
            // InternalBasicsLexer.g:130:6: ( 'int8' )
            // InternalBasicsLexer.g:130:8: 'int8'
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
            // InternalBasicsLexer.g:132:6: ( 'name' )
            // InternalBasicsLexer.g:132:8: 'name'
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
            // InternalBasicsLexer.g:134:6: ( 'node' )
            // InternalBasicsLexer.g:134:8: 'node'
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
            // InternalBasicsLexer.g:136:4: ( 'sc->' )
            // InternalBasicsLexer.g:136:6: 'sc->'
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
            // InternalBasicsLexer.g:138:4: ( 'ss->' )
            // InternalBasicsLexer.g:138:6: 'ss->'
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
            // InternalBasicsLexer.g:140:6: ( 'time' )
            // InternalBasicsLexer.g:140:8: 'time'
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
            // InternalBasicsLexer.g:142:6: ( 'type' )
            // InternalBasicsLexer.g:142:8: 'type'
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
            // InternalBasicsLexer.g:144:5: ( 'Any' )
            // InternalBasicsLexer.g:144:7: 'Any'
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
            // InternalBasicsLexer.g:146:4: ( 'ns:' )
            // InternalBasicsLexer.g:146:6: 'ns:'
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

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:148:24: ( '<=' )
            // InternalBasicsLexer.g:148:26: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:150:7: ( ',' )
            // InternalBasicsLexer.g:150:9: ','
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
            // InternalBasicsLexer.g:152:10: ( '.' )
            // InternalBasicsLexer.g:152:12: '.'
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
            // InternalBasicsLexer.g:154:7: ( ':' )
            // InternalBasicsLexer.g:154:9: ':'
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
            // InternalBasicsLexer.g:156:14: ( '@' )
            // InternalBasicsLexer.g:156:16: '@'
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
            // InternalBasicsLexer.g:158:19: ( '[' )
            // InternalBasicsLexer.g:158:21: '['
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
            // InternalBasicsLexer.g:160:20: ( ']' )
            // InternalBasicsLexer.g:160:22: ']'
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
            // InternalBasicsLexer.g:162:18: ( '{' )
            // InternalBasicsLexer.g:162:20: '{'
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
            // InternalBasicsLexer.g:164:19: ( '}' )
            // InternalBasicsLexer.g:164:21: '}'
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
            // InternalBasicsLexer.g:166:21: ( '0' .. '9' )
            // InternalBasicsLexer.g:166:23: '0' .. '9'
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
            // InternalBasicsLexer.g:168:13: ( ( '0b' | '0B' ) ( '0' | '1' )+ )
            // InternalBasicsLexer.g:168:15: ( '0b' | '0B' ) ( '0' | '1' )+
            {
            // InternalBasicsLexer.g:168:15: ( '0b' | '0B' )
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
                    // InternalBasicsLexer.g:168:16: '0b'
                    {
                    match("0b"); 


                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:168:21: '0B'
                    {
                    match("0B"); 


                    }
                    break;

            }

            // InternalBasicsLexer.g:168:27: ( '0' | '1' )+
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
            // InternalBasicsLexer.g:170:14: ( ( 'true' | 'false' ) )
            // InternalBasicsLexer.g:170:16: ( 'true' | 'false' )
            {
            // InternalBasicsLexer.g:170:16: ( 'true' | 'false' )
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
                    // InternalBasicsLexer.g:170:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:170:24: 'false'
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
            // InternalBasicsLexer.g:172:13: ( ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* ) )
            // InternalBasicsLexer.g:172:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* ) ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            {
            // InternalBasicsLexer.g:172:15: ( ( RULE_DIGIT )* | '-' ( RULE_DIGIT )* )
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
                    // InternalBasicsLexer.g:172:16: ( RULE_DIGIT )*
                    {
                    // InternalBasicsLexer.g:172:16: ( RULE_DIGIT )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:172:16: RULE_DIGIT
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
                    // InternalBasicsLexer.g:172:28: '-' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    // InternalBasicsLexer.g:172:32: ( RULE_DIGIT )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:172:32: RULE_DIGIT
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

            // InternalBasicsLexer.g:172:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalBasicsLexer.g:172:46: '.' ( RULE_DECINT )*
                    {
                    match('.'); 
                    // InternalBasicsLexer.g:172:50: ( RULE_DECINT )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='-'||(LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:172:50: RULE_DECINT
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
                    // InternalBasicsLexer.g:172:63: ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )*
                    {
                    // InternalBasicsLexer.g:172:63: ( '.' ( RULE_DIGIT )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalBasicsLexer.g:172:64: '.' ( RULE_DIGIT )*
                            {
                            match('.'); 
                            // InternalBasicsLexer.g:172:68: ( RULE_DIGIT )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // InternalBasicsLexer.g:172:68: RULE_DIGIT
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

                    // InternalBasicsLexer.g:172:92: ( '-' | '+' )?
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

                    // InternalBasicsLexer.g:172:103: ( RULE_DIGIT )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:172:103: RULE_DIGIT
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
            // InternalBasicsLexer.g:174:13: ( ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* ) )
            // InternalBasicsLexer.g:174:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
            {
            // InternalBasicsLexer.g:174:15: ( '0' | '1' .. '9' ( RULE_DIGIT )* | '-' '0' .. '9' ( RULE_DIGIT )* )
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
                    // InternalBasicsLexer.g:174:16: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:174:20: '1' .. '9' ( RULE_DIGIT )*
                    {
                    matchRange('1','9'); 
                    // InternalBasicsLexer.g:174:29: ( RULE_DIGIT )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:174:29: RULE_DIGIT
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
                    // InternalBasicsLexer.g:174:41: '-' '0' .. '9' ( RULE_DIGIT )*
                    {
                    match('-'); 
                    matchRange('0','9'); 
                    // InternalBasicsLexer.g:174:54: ( RULE_DIGIT )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBasicsLexer.g:174:54: RULE_DIGIT
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
            // InternalBasicsLexer.g:176:19: ( ( '1' .. '9' | '1' .. '3' '0' .. '9' ) )
            // InternalBasicsLexer.g:176:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
            {
            // InternalBasicsLexer.g:176:21: ( '1' .. '9' | '1' .. '3' '0' .. '9' )
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
                    // InternalBasicsLexer.g:176:22: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:176:31: '1' .. '3' '0' .. '9'
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
            // InternalBasicsLexer.g:178:21: ( ( '1' .. '9' | '1' '0' .. '2' ) )
            // InternalBasicsLexer.g:178:23: ( '1' .. '9' | '1' '0' .. '2' )
            {
            // InternalBasicsLexer.g:178:23: ( '1' .. '9' | '1' '0' .. '2' )
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
                    // InternalBasicsLexer.g:178:24: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:178:33: '1' '0' .. '2'
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
            // InternalBasicsLexer.g:180:20: ( '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9' )
            // InternalBasicsLexer.g:180:22: '0' .. '2' '0' .. '9' '0' .. '9' '0' .. '9'
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
            // InternalBasicsLexer.g:182:20: ( ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' ) )
            // InternalBasicsLexer.g:182:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
            {
            // InternalBasicsLexer.g:182:22: ( '0' .. '1' '0' .. '9' | '2' '0' .. '3' )
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
                    // InternalBasicsLexer.g:182:23: '0' .. '1' '0' .. '9'
                    {
                    matchRange('0','1'); 
                    matchRange('0','9'); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:182:41: '2' '0' .. '3'
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
            // InternalBasicsLexer.g:184:23: ( '0' .. '5' '0' .. '9' )
            // InternalBasicsLexer.g:184:25: '0' .. '5' '0' .. '9'
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
            // InternalBasicsLexer.g:186:16: ( RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC )
            // InternalBasicsLexer.g:186:18: RULE_YEAR '-' RULE_MONTH '-' RULE_DAY 'T' RULE_HOUR ':' RULE_MIN_SEC ':' RULE_MIN_SEC
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
            // InternalBasicsLexer.g:188:23: ( ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT ) )
            // InternalBasicsLexer.g:188:25: ( RULE_ID | RULE_STRING ) '=' ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
            {
            // InternalBasicsLexer.g:188:25: ( RULE_ID | RULE_STRING )
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
                    // InternalBasicsLexer.g:188:26: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:188:34: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;

            }

            match('='); 
            // InternalBasicsLexer.g:188:51: ( RULE_ID | RULE_STRING | RULE_INT | '-' RULE_INT )
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
                    // InternalBasicsLexer.g:188:52: RULE_ID
                    {
                    mRULE_ID(); 

                    }
                    break;
                case 2 :
                    // InternalBasicsLexer.g:188:60: RULE_STRING
                    {
                    mRULE_STRING(); 

                    }
                    break;
                case 3 :
                    // InternalBasicsLexer.g:188:72: RULE_INT
                    {
                    mRULE_INT(); 

                    }
                    break;
                case 4 :
                    // InternalBasicsLexer.g:188:81: '-' RULE_INT
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
            // InternalBasicsLexer.g:190:21: ()
            // InternalBasicsLexer.g:190:23: 
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
            // InternalBasicsLexer.g:192:19: ()
            // InternalBasicsLexer.g:192:21: 
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
            // InternalBasicsLexer.g:194:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* )
            // InternalBasicsLexer.g:194:19: '#' (~ ( ( '\\n' | '\\r' ) ) )*
            {
            match('#'); 
            // InternalBasicsLexer.g:194:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBasicsLexer.g:194:23: ~ ( ( '\\n' | '\\r' ) )
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
            // InternalBasicsLexer.g:196:23: ( ( '/' RULE_ID | RULE_ID '/' )* )
            // InternalBasicsLexer.g:196:25: ( '/' RULE_ID | RULE_ID '/' )*
            {
            // InternalBasicsLexer.g:196:25: ( '/' RULE_ID | RULE_ID '/' )*
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
            	    // InternalBasicsLexer.g:196:26: '/' RULE_ID
            	    {
            	    match('/'); 
            	    mRULE_ID(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalBasicsLexer.g:196:38: RULE_ID '/'
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
            // InternalBasicsLexer.g:198:27: ( ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )* )
            // InternalBasicsLexer.g:198:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
            {
            // InternalBasicsLexer.g:198:29: ( '/' RULE_STRING | RULE_STRING '/' | '~' RULE_STRING )*
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
            	    // InternalBasicsLexer.g:198:30: '/' RULE_STRING
            	    {
            	    match('/'); 
            	    mRULE_STRING(); 

            	    }
            	    break;
            	case 2 :
            	    // InternalBasicsLexer.g:198:46: RULE_STRING '/'
            	    {
            	    mRULE_STRING(); 
            	    match('/'); 

            	    }
            	    break;
            	case 3 :
            	    // InternalBasicsLexer.g:198:62: '~' RULE_STRING
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
            // InternalBasicsLexer.g:200:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBasicsLexer.g:200:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBasicsLexer.g:200:11: ( '^' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='^') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBasicsLexer.g:200:11: '^'
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

            // InternalBasicsLexer.g:200:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // InternalBasicsLexer.g:202:10: ( ( '0' .. '9' )+ )
            // InternalBasicsLexer.g:202:12: ( '0' .. '9' )+
            {
            // InternalBasicsLexer.g:202:12: ( '0' .. '9' )+
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
            	    // InternalBasicsLexer.g:202:13: '0' .. '9'
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
            // InternalBasicsLexer.g:204:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBasicsLexer.g:204:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBasicsLexer.g:204:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // InternalBasicsLexer.g:204:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBasicsLexer.g:204:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // InternalBasicsLexer.g:204:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBasicsLexer.g:204:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // InternalBasicsLexer.g:204:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBasicsLexer.g:204:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // InternalBasicsLexer.g:204:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBasicsLexer.g:204:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // InternalBasicsLexer.g:206:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBasicsLexer.g:206:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalBasicsLexer.g:206:24: ( options {greedy=false; } : . )*
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
            	    // InternalBasicsLexer.g:206:52: .
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
            // InternalBasicsLexer.g:208:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBasicsLexer.g:208:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBasicsLexer.g:208:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // InternalBasicsLexer.g:210:16: ( . )
            // InternalBasicsLexer.g:210:18: .
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
        // InternalBasicsLexer.g:1:8: ( RelativeNamespace | PrivateNamespace | GlobalNamespace | ParameterAny | Pluginbases | Pluginslots | Implements | Active_in | Lifecycle | Parameter | GraphName | Multiple | Default | Duration | Feedback | Plugins | Boolean | Integer | Float32 | Float64 | Format | Header_1 | Loader | Message | Param | Service | Base64 | Double | Header | String | Struct | Action | Class | Result | Slots | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Int16 | Int32 | Int64 | Pub | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LessThanSignEqualsSign | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt32=91;
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
                // InternalBasicsLexer.g:1:149: Multiple
                {
                mMultiple(); 

                }
                break;
            case 13 :
                // InternalBasicsLexer.g:1:158: Default
                {
                mDefault(); 

                }
                break;
            case 14 :
                // InternalBasicsLexer.g:1:166: Duration
                {
                mDuration(); 

                }
                break;
            case 15 :
                // InternalBasicsLexer.g:1:175: Feedback
                {
                mFeedback(); 

                }
                break;
            case 16 :
                // InternalBasicsLexer.g:1:184: Plugins
                {
                mPlugins(); 

                }
                break;
            case 17 :
                // InternalBasicsLexer.g:1:192: Boolean
                {
                mBoolean(); 

                }
                break;
            case 18 :
                // InternalBasicsLexer.g:1:200: Integer
                {
                mInteger(); 

                }
                break;
            case 19 :
                // InternalBasicsLexer.g:1:208: Float32
                {
                mFloat32(); 

                }
                break;
            case 20 :
                // InternalBasicsLexer.g:1:216: Float64
                {
                mFloat64(); 

                }
                break;
            case 21 :
                // InternalBasicsLexer.g:1:224: Format
                {
                mFormat(); 

                }
                break;
            case 22 :
                // InternalBasicsLexer.g:1:231: Header_1
                {
                mHeader_1(); 

                }
                break;
            case 23 :
                // InternalBasicsLexer.g:1:240: Loader
                {
                mLoader(); 

                }
                break;
            case 24 :
                // InternalBasicsLexer.g:1:247: Message
                {
                mMessage(); 

                }
                break;
            case 25 :
                // InternalBasicsLexer.g:1:255: Param
                {
                mParam(); 

                }
                break;
            case 26 :
                // InternalBasicsLexer.g:1:261: Service
                {
                mService(); 

                }
                break;
            case 27 :
                // InternalBasicsLexer.g:1:269: Base64
                {
                mBase64(); 

                }
                break;
            case 28 :
                // InternalBasicsLexer.g:1:276: Double
                {
                mDouble(); 

                }
                break;
            case 29 :
                // InternalBasicsLexer.g:1:283: Header
                {
                mHeader(); 

                }
                break;
            case 30 :
                // InternalBasicsLexer.g:1:290: String
                {
                mString(); 

                }
                break;
            case 31 :
                // InternalBasicsLexer.g:1:297: Struct
                {
                mStruct(); 

                }
                break;
            case 32 :
                // InternalBasicsLexer.g:1:304: Action
                {
                mAction(); 

                }
                break;
            case 33 :
                // InternalBasicsLexer.g:1:311: Class
                {
                mClass(); 

                }
                break;
            case 34 :
                // InternalBasicsLexer.g:1:317: Result
                {
                mResult(); 

                }
                break;
            case 35 :
                // InternalBasicsLexer.g:1:324: Slots
                {
                mSlots(); 

                }
                break;
            case 36 :
                // InternalBasicsLexer.g:1:330: String_1
                {
                mString_1(); 

                }
                break;
            case 37 :
                // InternalBasicsLexer.g:1:339: Uint16
                {
                mUint16(); 

                }
                break;
            case 38 :
                // InternalBasicsLexer.g:1:346: Uint32
                {
                mUint32(); 

                }
                break;
            case 39 :
                // InternalBasicsLexer.g:1:353: Uint64
                {
                mUint64(); 

                }
                break;
            case 40 :
                // InternalBasicsLexer.g:1:360: Value_1
                {
                mValue_1(); 

                }
                break;
            case 41 :
                // InternalBasicsLexer.g:1:368: Array
                {
                mArray(); 

                }
                break;
            case 42 :
                // InternalBasicsLexer.g:1:374: Base
                {
                mBase(); 

                }
                break;
            case 43 :
                // InternalBasicsLexer.g:1:379: Int16
                {
                mInt16(); 

                }
                break;
            case 44 :
                // InternalBasicsLexer.g:1:385: Int32
                {
                mInt32(); 

                }
                break;
            case 45 :
                // InternalBasicsLexer.g:1:391: Int64
                {
                mInt64(); 

                }
                break;
            case 46 :
                // InternalBasicsLexer.g:1:397: Pub
                {
                mPub(); 

                }
                break;
            case 47 :
                // InternalBasicsLexer.g:1:401: Sub
                {
                mSub(); 

                }
                break;
            case 48 :
                // InternalBasicsLexer.g:1:405: Type_1
                {
                mType_1(); 

                }
                break;
            case 49 :
                // InternalBasicsLexer.g:1:412: Uint8
                {
                mUint8(); 

                }
                break;
            case 50 :
                // InternalBasicsLexer.g:1:418: Value
                {
                mValue(); 

                }
                break;
            case 51 :
                // InternalBasicsLexer.g:1:424: Date
                {
                mDate(); 

                }
                break;
            case 52 :
                // InternalBasicsLexer.g:1:429: List
                {
                mList(); 

                }
                break;
            case 53 :
                // InternalBasicsLexer.g:1:434: Ac
                {
                mAc(); 

                }
                break;
            case 54 :
                // InternalBasicsLexer.g:1:437: As
                {
                mAs(); 

                }
                break;
            case 55 :
                // InternalBasicsLexer.g:1:440: Bool
                {
                mBool(); 

                }
                break;
            case 56 :
                // InternalBasicsLexer.g:1:445: Byte
                {
                mByte(); 

                }
                break;
            case 57 :
                // InternalBasicsLexer.g:1:450: Char
                {
                mChar(); 

                }
                break;
            case 58 :
                // InternalBasicsLexer.g:1:455: Goal
                {
                mGoal(); 

                }
                break;
            case 59 :
                // InternalBasicsLexer.g:1:460: Int8
                {
                mInt8(); 

                }
                break;
            case 60 :
                // InternalBasicsLexer.g:1:465: Name
                {
                mName(); 

                }
                break;
            case 61 :
                // InternalBasicsLexer.g:1:470: Node
                {
                mNode(); 

                }
                break;
            case 62 :
                // InternalBasicsLexer.g:1:475: Sc
                {
                mSc(); 

                }
                break;
            case 63 :
                // InternalBasicsLexer.g:1:478: Ss
                {
                mSs(); 

                }
                break;
            case 64 :
                // InternalBasicsLexer.g:1:481: Time
                {
                mTime(); 

                }
                break;
            case 65 :
                // InternalBasicsLexer.g:1:486: Type
                {
                mType(); 

                }
                break;
            case 66 :
                // InternalBasicsLexer.g:1:491: Any
                {
                mAny(); 

                }
                break;
            case 67 :
                // InternalBasicsLexer.g:1:495: Ns
                {
                mNs(); 

                }
                break;
            case 68 :
                // InternalBasicsLexer.g:1:498: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 69 :
                // InternalBasicsLexer.g:1:521: Comma
                {
                mComma(); 

                }
                break;
            case 70 :
                // InternalBasicsLexer.g:1:527: FullStop
                {
                mFullStop(); 

                }
                break;
            case 71 :
                // InternalBasicsLexer.g:1:536: Colon
                {
                mColon(); 

                }
                break;
            case 72 :
                // InternalBasicsLexer.g:1:542: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 73 :
                // InternalBasicsLexer.g:1:555: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 74 :
                // InternalBasicsLexer.g:1:573: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 75 :
                // InternalBasicsLexer.g:1:592: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 76 :
                // InternalBasicsLexer.g:1:609: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 77 :
                // InternalBasicsLexer.g:1:627: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 78 :
                // InternalBasicsLexer.g:1:639: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 79 :
                // InternalBasicsLexer.g:1:652: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 80 :
                // InternalBasicsLexer.g:1:664: RULE_DECINT
                {
                mRULE_DECINT(); 

                }
                break;
            case 81 :
                // InternalBasicsLexer.g:1:676: RULE_DATE_TIME
                {
                mRULE_DATE_TIME(); 

                }
                break;
            case 82 :
                // InternalBasicsLexer.g:1:691: RULE_MESSAGE_ASIGMENT
                {
                mRULE_MESSAGE_ASIGMENT(); 

                }
                break;
            case 83 :
                // InternalBasicsLexer.g:1:713: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 84 :
                // InternalBasicsLexer.g:1:729: RULE_ROS_CONVENTION_A
                {
                mRULE_ROS_CONVENTION_A(); 

                }
                break;
            case 85 :
                // InternalBasicsLexer.g:1:751: RULE_ROS_CONVENTION_PARAM
                {
                mRULE_ROS_CONVENTION_PARAM(); 

                }
                break;
            case 86 :
                // InternalBasicsLexer.g:1:777: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 87 :
                // InternalBasicsLexer.g:1:785: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 88 :
                // InternalBasicsLexer.g:1:794: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 89 :
                // InternalBasicsLexer.g:1:806: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 90 :
                // InternalBasicsLexer.g:1:822: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 91 :
                // InternalBasicsLexer.g:1:830: RULE_ANY_OTHER
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
            return "172:45: ( '.' ( RULE_DECINT )* | ( '.' ( RULE_DIGIT )* )? ( 'E' | 'e' ) ( '-' | '+' )? ( RULE_DIGIT )* )";
        }
    }
    static final String DFA32_eotS =
        "\1\60\33\66\1\63\1\uffff\1\157\6\uffff\2\171\1\160\1\63\1\171\1\63\1\66\2\63\1\uffff\1\63\1\uffff\1\63\2\uffff\2\66\2\uffff\65\66\13\uffff\1\u00c1\1\uffff\1\171\1\160\2\171\1\66\2\uffff\1\u00c5\2\uffff\1\u00c5\4\uffff\13\66\2\uffff\22\66\2\uffff\12\66\1\u00f2\12\66\1\uffff\1\u00c1\1\uffff\2\171\3\uffff\7\66\1\uffff\4\66\1\u010a\22\66\1\uffff\1\66\1\u011f\4\66\1\u0124\4\66\1\uffff\1\66\1\u012d\1\u012e\1\u0130\1\u0131\1\u0132\1\u0133\1\u0134\1\u0135\1\u0136\1\u00c1\1\171\10\66\1\u0142\1\u0143\1\u0144\1\uffff\13\66\1\u0132\10\66\1\uffff\4\66\1\uffff\4\66\1\u0161\1\u0163\1\u0164\14\uffff\1\u00c1\7\66\1\uffff\1\66\3\uffff\1\66\1\u016f\13\66\1\u017b\3\66\1\uffff\1\u017f\1\u0180\1\u0181\1\u0182\1\u0183\1\uffff\1\u0184\1\u0185\1\u0186\1\u0187\4\uffff\12\66\1\uffff\1\66\1\uffff\1\66\1\u0195\3\66\1\u0199\1\u019a\1\uffff\1\u019b\1\uffff\1\u019c\1\uffff\1\u019d\11\uffff\7\66\1\uffff\5\66\2\uffff\1\u01aa\1\u01ab\5\uffff\4\66\1\u01b0\6\66\3\uffff\4\66\1\uffff\2\66\1\uffff\1\66\2\uffff\6\66\1\uffff\2\66\1\u01c6\1\66\2\uffff\2\66\1\uffff\6\66\1\u01d0\1\66\1\u01d2\1\uffff\1\u01d3\2\uffff";
    static final String DFA32_eofS =
        "\u01d4\uffff";
    static final String DFA32_minS =
        "\1\0\33\57\1\75\1\uffff\1\55\6\uffff\2\56\1\57\2\56\1\101\1\57\2\0\1\uffff\1\42\1\uffff\1\42\2\uffff\2\57\2\uffff\11\57\2\55\22\57\2\55\26\57\13\uffff\1\56\1\uffff\1\56\1\57\2\56\1\57\2\0\1\57\2\0\1\57\4\uffff\7\57\1\55\3\57\2\uffff\21\57\1\55\2\uffff\25\57\1\uffff\1\56\1\uffff\2\56\1\0\1\uffff\1\0\7\57\1\uffff\27\57\1\uffff\13\57\1\uffff\12\57\2\55\6\57\1\55\4\57\1\uffff\24\57\1\uffff\4\57\1\uffff\7\57\14\uffff\1\56\7\57\1\uffff\1\57\3\uffff\21\57\1\uffff\5\57\1\uffff\4\57\4\uffff\12\57\1\uffff\1\57\1\uffff\7\57\1\uffff\1\57\1\uffff\1\57\1\uffff\1\57\11\uffff\7\57\1\uffff\5\57\2\uffff\2\57\5\uffff\13\57\3\uffff\4\57\1\uffff\2\57\1\uffff\1\57\2\uffff\6\57\1\uffff\4\57\2\uffff\2\57\1\uffff\11\57\1\uffff\1\57\2\uffff";
    static final String DFA32_maxS =
        "\1\uffff\33\172\1\75\1\uffff\1\145\6\uffff\2\145\1\172\2\145\2\172\2\uffff\1\uffff\1\172\1\uffff\1\47\2\uffff\2\172\2\uffff\65\172\13\uffff\1\145\1\uffff\1\145\1\172\2\145\1\172\2\uffff\1\75\2\uffff\1\75\4\uffff\13\172\2\uffff\22\172\2\uffff\25\172\1\uffff\1\145\1\uffff\2\145\1\uffff\1\uffff\1\uffff\7\172\1\uffff\27\172\1\uffff\13\172\1\uffff\12\172\2\145\13\172\1\uffff\24\172\1\uffff\4\172\1\uffff\7\172\14\uffff\1\145\7\172\1\uffff\1\172\3\uffff\21\172\1\uffff\5\172\1\uffff\4\172\4\uffff\12\172\1\uffff\1\172\1\uffff\7\172\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\11\uffff\7\172\1\uffff\5\172\2\uffff\2\172\5\uffff\13\172\3\uffff\4\172\1\uffff\2\172\1\uffff\1\172\2\uffff\6\172\1\uffff\4\172\2\uffff\2\172\1\uffff\11\172\1\uffff\1\172\2\uffff";
    static final String DFA32_acceptS =
        "\35\uffff\1\105\1\uffff\1\107\1\110\1\111\1\112\1\113\1\114\11\uffff\1\123\1\uffff\1\124\1\uffff\1\132\1\133\2\uffff\1\126\1\122\65\uffff\1\104\1\105\1\106\1\117\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\uffff\1\120\13\uffff\1\123\1\131\1\125\1\132\13\uffff\1\65\1\66\22\uffff\1\76\1\77\25\uffff\1\103\1\uffff\1\127\3\uffff\1\130\10\uffff\1\56\27\uffff\1\57\13\uffff\1\102\27\uffff\1\73\24\uffff\1\63\4\uffff\1\71\7\uffff\1\52\1\67\1\70\1\60\1\101\1\100\1\116\1\64\1\72\1\74\1\75\1\121\10\uffff\1\31\1\uffff\1\53\1\54\1\55\21\uffff\1\43\5\uffff\1\41\4\uffff\1\61\1\50\1\62\1\51\12\uffff\1\40\1\uffff\1\27\7\uffff\1\25\1\uffff\1\33\1\uffff\1\26\1\uffff\1\44\1\34\1\35\1\36\1\37\1\42\1\45\1\46\1\47\7\uffff\1\20\5\uffff\1\30\1\15\2\uffff\1\23\1\24\1\21\1\22\1\32\13\uffff\1\14\1\16\1\17\4\uffff\1\13\2\uffff\1\12\1\uffff\1\10\1\11\6\uffff\1\7\4\uffff\1\5\1\6\2\uffff\1\4\11\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA32_specialS =
        "\1\0\53\uffff\1\3\1\10\121\uffff\1\4\1\2\1\uffff\1\5\1\7\100\uffff\1\1\1\uffff\1\6\u010d\uffff}>";
    static final String[] DFA32_transitionS = {
            "\11\63\2\62\2\63\1\62\22\63\1\62\1\63\1\54\1\56\3\63\1\55\4\63\1\35\1\50\1\36\1\57\1\45\2\46\7\51\1\37\1\63\1\34\3\63\1\40\1\26\1\13\1\53\1\17\1\47\1\53\1\3\1\20\1\14\2\53\1\31\3\53\1\2\1\53\1\1\1\21\7\53\1\41\1\63\1\42\1\52\1\53\1\63\1\6\1\27\1\22\1\11\1\47\1\12\1\32\1\15\1\5\2\53\1\7\1\10\1\33\1\53\1\4\1\53\1\23\1\16\1\30\1\24\1\25\4\53\1\43\1\63\1\44\1\61\uff81\63",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\64\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\71\20\65\1\70\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\72\5\65\1\73\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\75\12\65\1\74\10\65\1\76\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\77\1\100\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\101\17\65\1\102\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\103\5\65\1\104\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\106\17\65\1\105\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\107\17\65\1\110\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\114\3\65\1\111\6\65\1\112\2\65\1\113\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\116\15\65\1\115\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\117\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\120\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\125\1\65\1\121\6\65\1\122\6\65\1\126\1\123\1\124\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\130\15\65\1\127\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\131\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\132\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\7\65\1\134\3\65\1\133\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\135\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\136\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\137\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\141\3\65\1\140\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\142\15\65\1\143\11\65\1\144\1\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\146\10\65\1\147\6\65\1\145\1\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\150\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\151\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\152\15\65\1\153\3\65\1\154\7\65",
            "\1\155",
            "",
            "\1\160\2\uffff\12\160\13\uffff\1\160\37\uffff\1\160",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\160\1\uffff\12\170\10\uffff\1\167\2\uffff\1\160\34\uffff\1\167\2\uffff\1\160",
            "\1\160\1\uffff\12\172\13\uffff\1\160\37\uffff\1\160",
            "\1\60\12\173\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\160\1\uffff\12\174\13\uffff\1\160\37\uffff\1\160",
            "\1\160\1\uffff\12\175\13\uffff\1\160\37\uffff\1\160",
            "\32\176\4\uffff\1\176\1\uffff\32\176",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\42\u0080\1\u0081\71\u0080\1\177\uffa3\u0080",
            "\47\u0083\1\u0084\64\u0083\1\u0082\uffa3\u0083",
            "",
            "\1\u0087\4\uffff\1\u0087\2\uffff\1\u0086\26\uffff\32\60\3\uffff\2\60\1\uffff\32\60",
            "",
            "\1\u0087\4\uffff\1\u0087",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u0089\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u008a\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u008b\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u008c\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u008d\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\u008e\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u008f\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\65\1\u0090\30\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\17\65\1\u0091\12\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u0092\6\65",
            "\1\u0094\1\uffff\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u0093\6\65",
            "\1\u0095\1\uffff\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\5\65\1\u0096\24\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u0097\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u0098\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u0099\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\5\65\1\u009a\24\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u009b\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u009c\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u009d\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u009e\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u009f\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u00a0\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u00a1\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00a2\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00a3\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u00a4\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u00a5\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u00a6\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\65\1\u00a7\30\65",
            "\1\u00a8\1\uffff\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u00a9\1\uffff\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\u00aa\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00ab\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00ac\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u00ad\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00ae\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00af\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u00b0\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u00b1\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u00b2\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u00b3\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\30\65\1\u00b4\1\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u00b5\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u00b6\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00b7\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\17\65\1\u00b8\12\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u00b9\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\u00ba\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u00bb\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00bc\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u00bd\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\3\65\1\u00be\26\65",
            "\1\60\12\65\1\u00bf\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
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
            "\1\160\1\uffff\12\u00c0\13\uffff\1\160\37\uffff\1\160",
            "",
            "\1\160\1\uffff\12\u00c2\13\uffff\1\160\37\uffff\1\160",
            "\1\60\12\173\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\160\1\uffff\12\u00c3\13\uffff\1\160\37\uffff\1\160",
            "\1\160\1\uffff\12\175\13\uffff\1\160\37\uffff\1\160",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\0\u00c4",
            "\42\u0080\1\u0081\71\u0080\1\177\uffa3\u0080",
            "\1\u0087\15\uffff\1\67",
            "\0\u00c6",
            "\47\u0083\1\u0084\64\u0083\1\u0082\uffa3\u0083",
            "\1\u0087\15\uffff\1\67",
            "",
            "",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00c7\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\25\65\1\u00c8\4\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00c9\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\65\1\u00ca\30\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\17\65\1\u00cb\12\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\6\65\1\u00cc\23\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00cd\31\65",
            "\1\u00ce\1\uffff\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u00cf\16\65",
            "\1\60\1\65\1\u00d0\1\65\1\u00d1\2\65\1\u00d2\1\65\1\u00d3\1\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u00d4\21\65",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00d5\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\3\65\1\u00d6\26\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00d7\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u00d8\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00d9\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00da\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\3\65\1\u00db\26\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00dc\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u00dd\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u00de\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u00df\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00e0\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00e1\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\3\65\1\u00e2\26\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\25\65\1\u00e3\4\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00e4\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u00e5\21\65",
            "\1\u00e6\1\uffff\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\65\1\u00e7\30\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00e8\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\3\65\1\u00e9\26\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u00ea\13\65\1\u00eb\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u00ec\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u00ed\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\u00ee\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00ef\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\u00f0\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u00f1\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f3\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u00f4\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f5\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f6\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f7\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f8\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00f9\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u00fa\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00fb\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00fc\25\65",
            "",
            "\1\160\1\uffff\12\u00fd\13\uffff\1\160\37\uffff\1\160",
            "",
            "\1\160\1\uffff\12\u00fe\13\uffff\1\160\37\uffff\1\160",
            "\1\160\1\uffff\12\u00c3\13\uffff\1\160\37\uffff\1\160",
            "\42\u0080\1\u0081\71\u0080\1\177\uffa3\u0080",
            "",
            "\47\u0083\1\u0084\64\u0083\1\u0082\uffa3\u0083",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u00ff\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u0100\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u0101\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u0102\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\7\65\1\u0103\22\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u0104\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u0105\15\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0106\25\65",
            "\1\60\6\65\1\u0107\3\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\2\65\1\u0108\7\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\4\65\1\u0109\5\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u010c\6\65\1\u010b\4\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u010d\27\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u010e\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u010f\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u0110\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\u0111\5\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u0112\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\65\1\u0113\30\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u0114\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u0115\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0116\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0117\25\65",
            "\1\60\6\65\1\u0118\3\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\6\65\1\u0119\23\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u011a\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u011b\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u011c\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u011d\14\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u011e\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0120\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u0121\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u0122\27\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u0123\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u0125\16\65",
            "\1\60\1\65\1\u0126\1\65\1\u0127\2\65\1\u0128\1\65\1\u0129\1\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u012a\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\30\65\1\u012b\1\65",
            "",
            "\1\60\12\65\1\u012c\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\1\u012f\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\u0137\1\160\1\uffff\12\u0138\13\uffff\1\160\37\uffff\1\160",
            "\1\u0137\1\160\1\uffff\12\175\13\uffff\1\160\37\uffff\1\160",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u0139\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u013a\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u013b\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u013c\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\15\65\1\u013d\14\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u013e\14\65",
            "\1\u0140\1\uffff\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u013f\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u0141\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0145\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u0146\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\30\65\1\u0147\1\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u0148\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\17\65\1\u0149\12\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\6\65\1\u014a\23\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u014b\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u014c\21\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u014d\31\65",
            "\1\60\3\65\1\u014e\2\65\1\u014f\3\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u0150\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u0151\31\65",
            "\1\60\4\65\1\u0152\5\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0153\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u0154\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u0155\27\65",
            "\1\60\12\65\1\u0156\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\6\65\1\u0157\23\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0158\25\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u0159\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\6\65\1\u015a\23\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u015b\6\65",
            "\1\60\12\65\1\u015c\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u015d\6\65",
            "\1\60\6\65\1\u015e\3\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\2\65\1\u015f\7\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\4\65\1\u0160\5\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\1\u0162\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
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
            "",
            "\1\160\1\uffff\12\u0138\13\uffff\1\160\37\uffff\1\160",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\25\65\1\u0165\4\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0166\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u0167\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\15\65\1\u0168\14\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u0169\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\65\1\u016a\20\65\1\u016b\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u016c\6\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u016d\25\65",
            "",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\u016e\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u0170\27\65",
            "\1\60\12\65\1\u0171\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u0172\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0173\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u0174\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u0175\13\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u0176\27\65",
            "\1\60\2\65\1\u0177\7\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\4\65\1\u0178\5\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\1\u0179\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u017a\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u017c\10\65",
            "\1\60\12\65\1\u017d\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u017e\25\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0188\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\15\65\1\u0189\14\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u018a\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u018b\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u018c\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u018d\31\65",
            "\1\60\12\65\1\u018f\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u018e\16\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0190\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u0191\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\10\65\1\u0192\21\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u0193\16\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u0194\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\1\u0196\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u0197\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\12\65\1\u0198\17\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\15\65\1\u019e\14\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u019f\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u01a0\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u01a1\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01a2\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u01a3\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\16\65\1\u01a4\13\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\21\65\1\u01a5\10\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u01a6\6\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u01a7\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01a8\25\65",
            "\1\60\12\65\1\u01a9\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u01ac\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u01ad\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\1\u01ae\31\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01af\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01b1\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\23\65\1\u01b2\6\65",
            "\1\60\12\65\1\u01b3\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u01b4\7\65",
            "\1\60\12\65\1\u01b5\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\1\u01b6\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\14\65\1\u01b7\15\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01b8\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\15\65\1\u01b9\14\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u01ba\7\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u01bb\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u01bc\7\65",
            "",
            "\1\60\12\65\1\u01bd\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01be\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u01bf\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\30\65\1\u01c0\1\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\17\65\1\u01c1\12\65",
            "\1\60\12\65\1\u01c2\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\1\u01c3\2\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\22\65\1\u01c4\7\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\17\65\1\u01c5\12\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u01c7\31\65",
            "",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\17\65\1\u01c8\12\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u01c9\31\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u01ca\27\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\1\u01cb\31\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u01cc\27\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01cd\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\2\65\1\u01ce\27\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01cf\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u01d1\25\65",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\60\12\65\3\uffff\1\67\3\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
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
            return "1:1: Tokens : ( RelativeNamespace | PrivateNamespace | GlobalNamespace | ParameterAny | Pluginbases | Pluginslots | Implements | Active_in | Lifecycle | Parameter | GraphName | Multiple | Default | Duration | Feedback | Plugins | Boolean | Integer | Float32 | Float64 | Format | Header_1 | Loader | Message | Param | Service | Base64 | Double | Header | String | Struct | Action | Class | Result | Slots | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Base | Int16 | Int32 | Int64 | Pub | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LessThanSignEqualsSign | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_0 = input.LA(1);

                        s = -1;
                        if ( (LA32_0=='R') ) {s = 1;}

                        else if ( (LA32_0=='P') ) {s = 2;}

                        else if ( (LA32_0=='G') ) {s = 3;}

                        else if ( (LA32_0=='p') ) {s = 4;}

                        else if ( (LA32_0=='i') ) {s = 5;}

                        else if ( (LA32_0=='a') ) {s = 6;}

                        else if ( (LA32_0=='l') ) {s = 7;}

                        else if ( (LA32_0=='m') ) {s = 8;}

                        else if ( (LA32_0=='d') ) {s = 9;}

                        else if ( (LA32_0=='f') ) {s = 10;}

                        else if ( (LA32_0=='B') ) {s = 11;}

                        else if ( (LA32_0=='I') ) {s = 12;}

                        else if ( (LA32_0=='h') ) {s = 13;}

                        else if ( (LA32_0=='s') ) {s = 14;}

                        else if ( (LA32_0=='D') ) {s = 15;}

                        else if ( (LA32_0=='H') ) {s = 16;}

                        else if ( (LA32_0=='S') ) {s = 17;}

                        else if ( (LA32_0=='c') ) {s = 18;}

                        else if ( (LA32_0=='r') ) {s = 19;}

                        else if ( (LA32_0=='u') ) {s = 20;}

                        else if ( (LA32_0=='v') ) {s = 21;}

                        else if ( (LA32_0=='A') ) {s = 22;}

                        else if ( (LA32_0=='b') ) {s = 23;}

                        else if ( (LA32_0=='t') ) {s = 24;}

                        else if ( (LA32_0=='L') ) {s = 25;}

                        else if ( (LA32_0=='g') ) {s = 26;}

                        else if ( (LA32_0=='n') ) {s = 27;}

                        else if ( (LA32_0=='<') ) {s = 28;}

                        else if ( (LA32_0==',') ) {s = 29;}

                        else if ( (LA32_0=='.') ) {s = 30;}

                        else if ( (LA32_0==':') ) {s = 31;}

                        else if ( (LA32_0=='@') ) {s = 32;}

                        else if ( (LA32_0=='[') ) {s = 33;}

                        else if ( (LA32_0==']') ) {s = 34;}

                        else if ( (LA32_0=='{') ) {s = 35;}

                        else if ( (LA32_0=='}') ) {s = 36;}

                        else if ( (LA32_0=='0') ) {s = 37;}

                        else if ( ((LA32_0>='1' && LA32_0<='2')) ) {s = 38;}

                        else if ( (LA32_0=='E'||LA32_0=='e') ) {s = 39;}

                        else if ( (LA32_0=='-') ) {s = 40;}

                        else if ( ((LA32_0>='3' && LA32_0<='9')) ) {s = 41;}

                        else if ( (LA32_0=='^') ) {s = 42;}

                        else if ( (LA32_0=='C'||LA32_0=='F'||(LA32_0>='J' && LA32_0<='K')||(LA32_0>='M' && LA32_0<='O')||LA32_0=='Q'||(LA32_0>='T' && LA32_0<='Z')||LA32_0=='_'||(LA32_0>='j' && LA32_0<='k')||LA32_0=='o'||LA32_0=='q'||(LA32_0>='w' && LA32_0<='z')) ) {s = 43;}

                        else if ( (LA32_0=='\"') ) {s = 44;}

                        else if ( (LA32_0=='\'') ) {s = 45;}

                        else if ( (LA32_0=='#') ) {s = 46;}

                        else if ( (LA32_0=='/') ) {s = 47;}

                        else if ( (LA32_0=='~') ) {s = 49;}

                        else if ( ((LA32_0>='\t' && LA32_0<='\n')||LA32_0=='\r'||LA32_0==' ') ) {s = 50;}

                        else if ( ((LA32_0>='\u0000' && LA32_0<='\b')||(LA32_0>='\u000B' && LA32_0<='\f')||(LA32_0>='\u000E' && LA32_0<='\u001F')||LA32_0=='!'||(LA32_0>='$' && LA32_0<='&')||(LA32_0>='(' && LA32_0<='+')||LA32_0==';'||(LA32_0>='=' && LA32_0<='?')||LA32_0=='\\'||LA32_0=='`'||LA32_0=='|'||(LA32_0>='\u007F' && LA32_0<='\uFFFF')) ) {s = 51;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_196 = input.LA(1);

                        s = -1;
                        if ( (LA32_196=='\"') ) {s = 129;}

                        else if ( (LA32_196=='\\') ) {s = 127;}

                        else if ( ((LA32_196>='\u0000' && LA32_196<='!')||(LA32_196>='#' && LA32_196<='[')||(LA32_196>=']' && LA32_196<='\uFFFF')) ) {s = 128;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_128 = input.LA(1);

                        s = -1;
                        if ( (LA32_128=='\"') ) {s = 129;}

                        else if ( (LA32_128=='\\') ) {s = 127;}

                        else if ( ((LA32_128>='\u0000' && LA32_128<='!')||(LA32_128>='#' && LA32_128<='[')||(LA32_128>=']' && LA32_128<='\uFFFF')) ) {s = 128;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_44 = input.LA(1);

                        s = -1;
                        if ( (LA32_44=='\\') ) {s = 127;}

                        else if ( ((LA32_44>='\u0000' && LA32_44<='!')||(LA32_44>='#' && LA32_44<='[')||(LA32_44>=']' && LA32_44<='\uFFFF')) ) {s = 128;}

                        else if ( (LA32_44=='\"') ) {s = 129;}

                        else s = 51;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_127 = input.LA(1);

                        s = -1;
                        if ( ((LA32_127>='\u0000' && LA32_127<='\uFFFF')) ) {s = 196;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_130 = input.LA(1);

                        s = -1;
                        if ( ((LA32_130>='\u0000' && LA32_130<='\uFFFF')) ) {s = 198;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_198 = input.LA(1);

                        s = -1;
                        if ( (LA32_198=='\'') ) {s = 132;}

                        else if ( (LA32_198=='\\') ) {s = 130;}

                        else if ( ((LA32_198>='\u0000' && LA32_198<='&')||(LA32_198>='(' && LA32_198<='[')||(LA32_198>=']' && LA32_198<='\uFFFF')) ) {s = 131;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_131 = input.LA(1);

                        s = -1;
                        if ( (LA32_131=='\'') ) {s = 132;}

                        else if ( (LA32_131=='\\') ) {s = 130;}

                        else if ( ((LA32_131>='\u0000' && LA32_131<='&')||(LA32_131>='(' && LA32_131<='[')||(LA32_131>=']' && LA32_131<='\uFFFF')) ) {s = 131;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_45 = input.LA(1);

                        s = -1;
                        if ( (LA32_45=='\\') ) {s = 130;}

                        else if ( ((LA32_45>='\u0000' && LA32_45<='&')||(LA32_45>='(' && LA32_45<='[')||(LA32_45>=']' && LA32_45<='\uFFFF')) ) {s = 131;}

                        else if ( (LA32_45=='\'') ) {s = 132;}

                        else s = 51;

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