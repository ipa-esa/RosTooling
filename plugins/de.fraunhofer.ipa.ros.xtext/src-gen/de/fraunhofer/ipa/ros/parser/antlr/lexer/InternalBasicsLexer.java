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
    public static final int Float32_1=9;
    public static final int Node=64;
    public static final int RULE_DATE_TIME=90;
    public static final int Uint64_1=17;
    public static final int String=32;
    public static final int Int16=46;
    public static final int Float32=20;
    public static final int Goal=61;
    public static final int Bool=58;
    public static final int Uint16=41;
    public static final int Boolean=18;
    public static final int Sub=50;
    public static final int Uint8=52;
    public static final int RULE_ID=91;
    public static final int RULE_DIGIT=80;
    public static final int GlobalNamespace=6;
    public static final int Int16_1=22;
    public static final int Header=31;
    public static final int RULE_INT=93;
    public static final int Byte=59;
    public static final int RULE_ML_COMMENT=100;
    public static final int LeftSquareBracket=76;
    public static final int Ac=56;
    public static final int Base64=29;
    public static final int Comma=72;
    public static final int As=57;
    public static final int RULE_MESSAGE_ASIGMENT=94;
    public static final int LeftSquareBracketRightSquareBracket=71;
    public static final int Int32=47;
    public static final int Char=60;
    public static final int RightCurlyBracket=79;
    public static final int RULE_DECINT=83;
    public static final int Uint32=42;
    public static final int FullStop=73;
    public static final int RULE_HOUR=88;
    public static final int Int8=62;
    public static final int Default=11;
    public static final int Int8_1=38;
    public static final int CommercialAt=75;
    public static final int Uint16_1=15;
    public static final int Sc=65;
    public static final int Type=68;
    public static final int Float64=21;
    public static final int Int32_1=23;
    public static final int RULE_BINARY=81;
    public static final int String_1=40;
    public static final int String_2=14;
    public static final int Ss=66;
    public static final int RULE_DAY=85;
    public static final int RULE_BEGIN=95;
    public static final int RULE_BOOLEAN=82;
    public static final int RelativeNamespace=4;
    public static final int RULE_YEAR=87;
    public static final int Result=39;
    public static final int Name=63;
    public static final int RULE_MIN_SEC=89;
    public static final int Char_1=37;
    public static final int ParameterAny=7;
    public static final int List=55;
    public static final int RightSquareBracket=77;
    public static final int PrivateNamespace=5;
    public static final int GraphName=8;
    public static final int Byte_1=36;
    public static final int Float64_1=10;
    public static final int Duration=12;
    public static final int Uint32_1=16;
    public static final int Double=30;
    public static final int Type_1=51;
    public static final int Value=53;
    public static final int Uint64=43;
    public static final int Action=34;
    public static final int RULE_END=96;
    public static final int Message=25;
    public static final int Value_1=44;
    public static final int Time=67;
    public static final int RULE_STRING=92;
    public static final int Bool_1=35;
    public static final int Any=69;
    public static final int Struct=33;
    public static final int RULE_SL_COMMENT=97;
    public static final int Uint8_1=28;
    public static final int RULE_DOUBLE=84;
    public static final int Feedback=13;
    public static final int RULE_ROS_CONVENTION_A=98;
    public static final int RULE_ROS_CONVENTION_PARAM=99;
    public static final int Colon=74;
    public static final int Pub=49;
    public static final int EOF=-1;
    public static final int Ns=70;
    public static final int RULE_WS=101;
    public static final int Int64_1=24;
    public static final int LeftCurlyBracket=78;
    public static final int Service=27;
    public static final int RULE_ANY_OTHER=102;
    public static final int Date=54;
    public static final int Integer=19;
    public static final int Array=45;
    public static final int Int64=48;
    public static final int Param=26;
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

    // $ANTLR start "GraphName"
    public final void mGraphName() throws RecognitionException {
        try {
            int _type = GraphName;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:22:11: ( 'GraphName' )
            // InternalBasicsLexer.g:22:13: 'GraphName'
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
            // InternalBasicsLexer.g:24:11: ( 'float32[]' )
            // InternalBasicsLexer.g:24:13: 'float32[]'
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
            // InternalBasicsLexer.g:26:11: ( 'float64[]' )
            // InternalBasicsLexer.g:26:13: 'float64[]'
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

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:28:9: ( 'default:' )
            // InternalBasicsLexer.g:28:11: 'default:'
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
            // InternalBasicsLexer.g:30:10: ( 'duration' )
            // InternalBasicsLexer.g:30:12: 'duration'
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
            // InternalBasicsLexer.g:32:10: ( 'feedback' )
            // InternalBasicsLexer.g:32:12: 'feedback'
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

    // $ANTLR start "String_2"
    public final void mString_2() throws RecognitionException {
        try {
            int _type = String_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:34:10: ( 'string[]' )
            // InternalBasicsLexer.g:34:12: 'string[]'
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
            // InternalBasicsLexer.g:36:10: ( 'uint16[]' )
            // InternalBasicsLexer.g:36:12: 'uint16[]'
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
            // InternalBasicsLexer.g:38:10: ( 'uint32[]' )
            // InternalBasicsLexer.g:38:12: 'uint32[]'
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
            // InternalBasicsLexer.g:40:10: ( 'uint64[]' )
            // InternalBasicsLexer.g:40:12: 'uint64[]'
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
            // InternalBasicsLexer.g:42:9: ( 'Boolean' )
            // InternalBasicsLexer.g:42:11: 'Boolean'
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
            // InternalBasicsLexer.g:44:9: ( 'Integer' )
            // InternalBasicsLexer.g:44:11: 'Integer'
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
            // InternalBasicsLexer.g:46:9: ( 'float32' )
            // InternalBasicsLexer.g:46:11: 'float32'
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
            // InternalBasicsLexer.g:48:9: ( 'float64' )
            // InternalBasicsLexer.g:48:11: 'float64'
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

    // $ANTLR start "Int16_1"
    public final void mInt16_1() throws RecognitionException {
        try {
            int _type = Int16_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:50:9: ( 'int16[]' )
            // InternalBasicsLexer.g:50:11: 'int16[]'
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
            // InternalBasicsLexer.g:52:9: ( 'int32[]' )
            // InternalBasicsLexer.g:52:11: 'int32[]'
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
            // InternalBasicsLexer.g:54:9: ( 'int64[]' )
            // InternalBasicsLexer.g:54:11: 'int64[]'
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

    // $ANTLR start "Message"
    public final void mMessage() throws RecognitionException {
        try {
            int _type = Message;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:56:9: ( 'message' )
            // InternalBasicsLexer.g:56:11: 'message'
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
            // InternalBasicsLexer.g:58:7: ( 'param->' )
            // InternalBasicsLexer.g:58:9: 'param->'
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
            // InternalBasicsLexer.g:60:9: ( 'service' )
            // InternalBasicsLexer.g:60:11: 'service'
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
            // InternalBasicsLexer.g:62:9: ( 'uint8[]' )
            // InternalBasicsLexer.g:62:11: 'uint8[]'
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
            // InternalBasicsLexer.g:64:8: ( 'Base64' )
            // InternalBasicsLexer.g:64:10: 'Base64'
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
            // InternalBasicsLexer.g:66:8: ( 'Double' )
            // InternalBasicsLexer.g:66:10: 'Double'
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
            // InternalBasicsLexer.g:68:8: ( 'Header' )
            // InternalBasicsLexer.g:68:10: 'Header'
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
            // InternalBasicsLexer.g:70:8: ( 'String' )
            // InternalBasicsLexer.g:70:10: 'String'
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
            // InternalBasicsLexer.g:72:8: ( 'Struct' )
            // InternalBasicsLexer.g:72:10: 'Struct'
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
            // InternalBasicsLexer.g:74:8: ( 'action' )
            // InternalBasicsLexer.g:74:10: 'action'
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
            // InternalBasicsLexer.g:76:8: ( 'bool[]' )
            // InternalBasicsLexer.g:76:10: 'bool[]'
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
            // InternalBasicsLexer.g:78:8: ( 'byte[]' )
            // InternalBasicsLexer.g:78:10: 'byte[]'
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
            // InternalBasicsLexer.g:80:8: ( 'char[]' )
            // InternalBasicsLexer.g:80:10: 'char[]'
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
            // InternalBasicsLexer.g:82:8: ( 'int8[]' )
            // InternalBasicsLexer.g:82:10: 'int8[]'
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
            // InternalBasicsLexer.g:84:8: ( 'result' )
            // InternalBasicsLexer.g:84:10: 'result'
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
            // InternalBasicsLexer.g:86:10: ( 'string' )
            // InternalBasicsLexer.g:86:12: 'string'
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
            // InternalBasicsLexer.g:88:8: ( 'uint16' )
            // InternalBasicsLexer.g:88:10: 'uint16'
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
            // InternalBasicsLexer.g:90:8: ( 'uint32' )
            // InternalBasicsLexer.g:90:10: 'uint32'
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
            // InternalBasicsLexer.g:92:8: ( 'uint64' )
            // InternalBasicsLexer.g:92:10: 'uint64'
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
            // InternalBasicsLexer.g:94:9: ( 'value:' )
            // InternalBasicsLexer.g:94:11: 'value:'
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
            // InternalBasicsLexer.g:96:7: ( 'Array' )
            // InternalBasicsLexer.g:96:9: 'Array'
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

    // $ANTLR start "LeftSquareBracketRightSquareBracket"
    public final void mLeftSquareBracketRightSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracketRightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBasicsLexer.g:148:37: ( '[]' )
            // InternalBasicsLexer.g:148:39: '[]'
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
        // InternalBasicsLexer.g:1:8: ( RelativeNamespace | PrivateNamespace | GlobalNamespace | ParameterAny | GraphName | Float32_1 | Float64_1 | Default | Duration | Feedback | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Int16_1 | Int32_1 | Int64_1 | Message | Param | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Int8_1 | Result | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Int16 | Int32 | Int64 | Pub | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER )
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
                // InternalBasicsLexer.g:1:74: GraphName
                {
                mGraphName(); 

                }
                break;
            case 6 :
                // InternalBasicsLexer.g:1:84: Float32_1
                {
                mFloat32_1(); 

                }
                break;
            case 7 :
                // InternalBasicsLexer.g:1:94: Float64_1
                {
                mFloat64_1(); 

                }
                break;
            case 8 :
                // InternalBasicsLexer.g:1:104: Default
                {
                mDefault(); 

                }
                break;
            case 9 :
                // InternalBasicsLexer.g:1:112: Duration
                {
                mDuration(); 

                }
                break;
            case 10 :
                // InternalBasicsLexer.g:1:121: Feedback
                {
                mFeedback(); 

                }
                break;
            case 11 :
                // InternalBasicsLexer.g:1:130: String_2
                {
                mString_2(); 

                }
                break;
            case 12 :
                // InternalBasicsLexer.g:1:139: Uint16_1
                {
                mUint16_1(); 

                }
                break;
            case 13 :
                // InternalBasicsLexer.g:1:148: Uint32_1
                {
                mUint32_1(); 

                }
                break;
            case 14 :
                // InternalBasicsLexer.g:1:157: Uint64_1
                {
                mUint64_1(); 

                }
                break;
            case 15 :
                // InternalBasicsLexer.g:1:166: Boolean
                {
                mBoolean(); 

                }
                break;
            case 16 :
                // InternalBasicsLexer.g:1:174: Integer
                {
                mInteger(); 

                }
                break;
            case 17 :
                // InternalBasicsLexer.g:1:182: Float32
                {
                mFloat32(); 

                }
                break;
            case 18 :
                // InternalBasicsLexer.g:1:190: Float64
                {
                mFloat64(); 

                }
                break;
            case 19 :
                // InternalBasicsLexer.g:1:198: Int16_1
                {
                mInt16_1(); 

                }
                break;
            case 20 :
                // InternalBasicsLexer.g:1:206: Int32_1
                {
                mInt32_1(); 

                }
                break;
            case 21 :
                // InternalBasicsLexer.g:1:214: Int64_1
                {
                mInt64_1(); 

                }
                break;
            case 22 :
                // InternalBasicsLexer.g:1:222: Message
                {
                mMessage(); 

                }
                break;
            case 23 :
                // InternalBasicsLexer.g:1:230: Param
                {
                mParam(); 

                }
                break;
            case 24 :
                // InternalBasicsLexer.g:1:236: Service
                {
                mService(); 

                }
                break;
            case 25 :
                // InternalBasicsLexer.g:1:244: Uint8_1
                {
                mUint8_1(); 

                }
                break;
            case 26 :
                // InternalBasicsLexer.g:1:252: Base64
                {
                mBase64(); 

                }
                break;
            case 27 :
                // InternalBasicsLexer.g:1:259: Double
                {
                mDouble(); 

                }
                break;
            case 28 :
                // InternalBasicsLexer.g:1:266: Header
                {
                mHeader(); 

                }
                break;
            case 29 :
                // InternalBasicsLexer.g:1:273: String
                {
                mString(); 

                }
                break;
            case 30 :
                // InternalBasicsLexer.g:1:280: Struct
                {
                mStruct(); 

                }
                break;
            case 31 :
                // InternalBasicsLexer.g:1:287: Action
                {
                mAction(); 

                }
                break;
            case 32 :
                // InternalBasicsLexer.g:1:294: Bool_1
                {
                mBool_1(); 

                }
                break;
            case 33 :
                // InternalBasicsLexer.g:1:301: Byte_1
                {
                mByte_1(); 

                }
                break;
            case 34 :
                // InternalBasicsLexer.g:1:308: Char_1
                {
                mChar_1(); 

                }
                break;
            case 35 :
                // InternalBasicsLexer.g:1:315: Int8_1
                {
                mInt8_1(); 

                }
                break;
            case 36 :
                // InternalBasicsLexer.g:1:322: Result
                {
                mResult(); 

                }
                break;
            case 37 :
                // InternalBasicsLexer.g:1:329: String_1
                {
                mString_1(); 

                }
                break;
            case 38 :
                // InternalBasicsLexer.g:1:338: Uint16
                {
                mUint16(); 

                }
                break;
            case 39 :
                // InternalBasicsLexer.g:1:345: Uint32
                {
                mUint32(); 

                }
                break;
            case 40 :
                // InternalBasicsLexer.g:1:352: Uint64
                {
                mUint64(); 

                }
                break;
            case 41 :
                // InternalBasicsLexer.g:1:359: Value_1
                {
                mValue_1(); 

                }
                break;
            case 42 :
                // InternalBasicsLexer.g:1:367: Array
                {
                mArray(); 

                }
                break;
            case 43 :
                // InternalBasicsLexer.g:1:373: Int16
                {
                mInt16(); 

                }
                break;
            case 44 :
                // InternalBasicsLexer.g:1:379: Int32
                {
                mInt32(); 

                }
                break;
            case 45 :
                // InternalBasicsLexer.g:1:385: Int64
                {
                mInt64(); 

                }
                break;
            case 46 :
                // InternalBasicsLexer.g:1:391: Pub
                {
                mPub(); 

                }
                break;
            case 47 :
                // InternalBasicsLexer.g:1:395: Sub
                {
                mSub(); 

                }
                break;
            case 48 :
                // InternalBasicsLexer.g:1:399: Type_1
                {
                mType_1(); 

                }
                break;
            case 49 :
                // InternalBasicsLexer.g:1:406: Uint8
                {
                mUint8(); 

                }
                break;
            case 50 :
                // InternalBasicsLexer.g:1:412: Value
                {
                mValue(); 

                }
                break;
            case 51 :
                // InternalBasicsLexer.g:1:418: Date
                {
                mDate(); 

                }
                break;
            case 52 :
                // InternalBasicsLexer.g:1:423: List
                {
                mList(); 

                }
                break;
            case 53 :
                // InternalBasicsLexer.g:1:428: Ac
                {
                mAc(); 

                }
                break;
            case 54 :
                // InternalBasicsLexer.g:1:431: As
                {
                mAs(); 

                }
                break;
            case 55 :
                // InternalBasicsLexer.g:1:434: Bool
                {
                mBool(); 

                }
                break;
            case 56 :
                // InternalBasicsLexer.g:1:439: Byte
                {
                mByte(); 

                }
                break;
            case 57 :
                // InternalBasicsLexer.g:1:444: Char
                {
                mChar(); 

                }
                break;
            case 58 :
                // InternalBasicsLexer.g:1:449: Goal
                {
                mGoal(); 

                }
                break;
            case 59 :
                // InternalBasicsLexer.g:1:454: Int8
                {
                mInt8(); 

                }
                break;
            case 60 :
                // InternalBasicsLexer.g:1:459: Name
                {
                mName(); 

                }
                break;
            case 61 :
                // InternalBasicsLexer.g:1:464: Node
                {
                mNode(); 

                }
                break;
            case 62 :
                // InternalBasicsLexer.g:1:469: Sc
                {
                mSc(); 

                }
                break;
            case 63 :
                // InternalBasicsLexer.g:1:472: Ss
                {
                mSs(); 

                }
                break;
            case 64 :
                // InternalBasicsLexer.g:1:475: Time
                {
                mTime(); 

                }
                break;
            case 65 :
                // InternalBasicsLexer.g:1:480: Type
                {
                mType(); 

                }
                break;
            case 66 :
                // InternalBasicsLexer.g:1:485: Any
                {
                mAny(); 

                }
                break;
            case 67 :
                // InternalBasicsLexer.g:1:489: Ns
                {
                mNs(); 

                }
                break;
            case 68 :
                // InternalBasicsLexer.g:1:492: LeftSquareBracketRightSquareBracket
                {
                mLeftSquareBracketRightSquareBracket(); 

                }
                break;
            case 69 :
                // InternalBasicsLexer.g:1:528: Comma
                {
                mComma(); 

                }
                break;
            case 70 :
                // InternalBasicsLexer.g:1:534: FullStop
                {
                mFullStop(); 

                }
                break;
            case 71 :
                // InternalBasicsLexer.g:1:543: Colon
                {
                mColon(); 

                }
                break;
            case 72 :
                // InternalBasicsLexer.g:1:549: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 73 :
                // InternalBasicsLexer.g:1:562: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 74 :
                // InternalBasicsLexer.g:1:580: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 75 :
                // InternalBasicsLexer.g:1:599: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 76 :
                // InternalBasicsLexer.g:1:616: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 77 :
                // InternalBasicsLexer.g:1:634: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 78 :
                // InternalBasicsLexer.g:1:646: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 79 :
                // InternalBasicsLexer.g:1:659: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 80 :
                // InternalBasicsLexer.g:1:671: RULE_DECINT
                {
                mRULE_DECINT(); 

                }
                break;
            case 81 :
                // InternalBasicsLexer.g:1:683: RULE_DATE_TIME
                {
                mRULE_DATE_TIME(); 

                }
                break;
            case 82 :
                // InternalBasicsLexer.g:1:698: RULE_MESSAGE_ASIGMENT
                {
                mRULE_MESSAGE_ASIGMENT(); 

                }
                break;
            case 83 :
                // InternalBasicsLexer.g:1:720: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 84 :
                // InternalBasicsLexer.g:1:736: RULE_ROS_CONVENTION_A
                {
                mRULE_ROS_CONVENTION_A(); 

                }
                break;
            case 85 :
                // InternalBasicsLexer.g:1:758: RULE_ROS_CONVENTION_PARAM
                {
                mRULE_ROS_CONVENTION_PARAM(); 

                }
                break;
            case 86 :
                // InternalBasicsLexer.g:1:784: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 87 :
                // InternalBasicsLexer.g:1:792: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 88 :
                // InternalBasicsLexer.g:1:801: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 89 :
                // InternalBasicsLexer.g:1:813: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 90 :
                // InternalBasicsLexer.g:1:829: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 91 :
                // InternalBasicsLexer.g:1:837: RULE_ANY_OTHER
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
        "\1\55\31\63\1\141\1\uffff\1\144\5\uffff\2\154\1\143\1\60\1\154\1\60\1\63\2\60\1\uffff\1\60\1\uffff\1\60\2\uffff\2\63\2\uffff\53\63\13\uffff\1\u00aa\1\uffff\1\154\1\143\2\154\1\63\2\uffff\1\u00ae\2\uffff\1\u00ae\4\uffff\15\63\2\uffff\15\63\2\uffff\6\63\1\u00d4\7\63\1\uffff\1\u00aa\1\uffff\2\154\3\uffff\14\63\1\uffff\7\63\1\u00f5\2\63\1\uffff\1\63\1\u00f9\4\63\1\u00ff\1\u0101\1\u0103\3\63\1\uffff\1\u0108\1\u0109\1\u010a\1\u010b\1\u010c\1\u010d\1\u010e\1\u00aa\1\154\7\63\1\u010a\7\63\1\u0121\3\63\1\u0126\1\u0128\1\u012a\2\uffff\3\63\1\uffff\4\63\6\uffff\1\63\1\u0134\1\u0135\11\uffff\1\u00aa\12\63\1\u0141\1\63\1\u0144\1\u0146\1\u0148\2\uffff\1\63\1\u014a\1\63\6\uffff\1\63\1\uffff\1\u014d\1\u014e\1\u014f\1\u0150\1\u0151\1\u0152\3\uffff\5\63\1\u0159\1\u015b\3\63\2\uffff\1\u015f\6\uffff\1\u0160\1\uffff\1\u0161\1\u0162\6\uffff\5\63\4\uffff\1\u0168\1\uffff\1\u0169\4\uffff\4\63\1\u016e\2\uffff\4\63\1\uffff\6\63\1\u0179\3\63\1\uffff\6\63\1\u0183\1\63\1\u0185\1\uffff\1\u0186\2\uffff";
    static final String DFA32_eofS =
        "\u0187\uffff";
    static final String DFA32_minS =
        "\1\0\31\57\1\135\1\uffff\1\55\5\uffff\2\56\1\57\2\56\1\101\1\57\2\0\1\uffff\1\42\1\uffff\1\42\2\uffff\2\57\2\uffff\14\57\2\55\14\57\2\55\17\57\13\uffff\1\56\1\uffff\1\56\1\57\2\56\1\57\2\0\1\57\2\0\1\57\4\uffff\14\57\1\55\2\uffff\7\57\1\55\5\57\2\uffff\16\57\1\uffff\1\56\1\uffff\2\56\1\0\1\uffff\1\0\14\57\1\uffff\12\57\1\uffff\14\57\1\uffff\7\57\2\55\26\57\2\uffff\1\57\1\55\1\57\1\uffff\4\57\6\uffff\3\57\11\uffff\1\56\17\57\2\uffff\3\57\6\uffff\1\57\1\uffff\6\57\3\uffff\12\57\2\uffff\1\57\6\uffff\1\57\1\uffff\2\57\6\uffff\5\57\4\uffff\1\57\1\uffff\1\57\4\uffff\5\57\2\uffff\4\57\1\uffff\12\57\1\uffff\11\57\1\uffff\1\57\2\uffff";
    static final String DFA32_maxS =
        "\1\uffff\31\172\1\135\1\uffff\1\145\5\uffff\2\145\1\172\2\145\2\172\2\uffff\1\uffff\1\172\1\uffff\1\47\2\uffff\2\172\2\uffff\53\172\13\uffff\1\145\1\uffff\1\145\1\172\2\145\1\172\2\uffff\1\75\2\uffff\1\75\4\uffff\15\172\2\uffff\15\172\2\uffff\16\172\1\uffff\1\145\1\uffff\2\145\1\uffff\1\uffff\1\uffff\14\172\1\uffff\12\172\1\uffff\14\172\1\uffff\7\172\2\145\26\172\2\uffff\3\172\1\uffff\4\172\6\uffff\3\172\11\uffff\1\145\17\172\2\uffff\3\172\6\uffff\1\172\1\uffff\6\172\3\uffff\12\172\2\uffff\1\172\6\uffff\1\172\1\uffff\2\172\6\uffff\5\172\4\uffff\1\172\1\uffff\1\172\4\uffff\5\172\2\uffff\4\172\1\uffff\12\172\1\uffff\11\172\1\uffff\1\172\2\uffff";
    static final String DFA32_acceptS =
        "\33\uffff\1\105\1\uffff\1\107\1\110\1\112\1\113\1\114\11\uffff\1\123\1\uffff\1\124\1\uffff\1\132\1\133\2\uffff\1\126\1\122\53\uffff\1\104\1\111\1\105\1\117\1\106\1\107\1\110\1\112\1\113\1\114\1\115\1\uffff\1\120\13\uffff\1\123\1\131\1\125\1\132\15\uffff\1\76\1\77\15\uffff\1\65\1\66\16\uffff\1\103\1\uffff\1\127\3\uffff\1\130\15\uffff\1\57\12\uffff\1\56\14\uffff\1\102\37\uffff\1\43\1\73\3\uffff\1\63\4\uffff\1\40\1\67\1\41\1\70\1\42\1\71\3\uffff\1\60\1\101\1\100\1\116\1\64\1\72\1\74\1\75\1\121\20\uffff\1\31\1\61\3\uffff\1\23\1\53\1\24\1\54\1\25\1\55\1\uffff\1\27\6\uffff\1\51\1\62\1\52\12\uffff\1\13\1\45\1\uffff\1\14\1\46\1\15\1\47\1\16\1\50\1\uffff\1\32\2\uffff\1\33\1\34\1\35\1\36\1\37\1\44\5\uffff\1\6\1\21\1\7\1\22\1\uffff\1\10\1\uffff\1\30\1\17\1\20\1\26\5\uffff\1\12\1\11\4\uffff\1\5\12\uffff\1\4\11\uffff\1\3\1\uffff\1\2\1\1";
    static final String DFA32_specialS =
        "\1\0\50\uffff\1\6\1\1\107\uffff\1\4\1\10\1\uffff\1\5\1\3\66\uffff\1\7\1\uffff\1\2\u00d7\uffff}>";
    static final String[] DFA32_transitionS = {
            "\11\60\2\57\2\60\1\57\22\60\1\57\1\60\1\51\1\53\3\60\1\52\4\60\1\33\1\45\1\34\1\54\1\42\2\43\7\46\1\35\5\60\1\36\1\25\1\10\1\50\1\15\1\44\1\50\1\3\1\16\1\11\2\50\1\27\3\50\1\2\1\50\1\1\1\17\7\50\1\32\1\60\1\37\1\47\1\50\1\60\1\20\1\21\1\22\1\5\1\44\1\4\1\30\1\50\1\12\3\50\1\13\1\31\1\50\1\14\1\50\1\23\1\6\1\26\1\7\1\24\4\50\1\40\1\60\1\41\1\56\uff81\60",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\61\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\66\20\62\1\65\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\67\5\62\1\70\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\73\3\62\1\72\6\62\1\71\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\74\17\62\1\75\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\101\1\62\1\77\15\62\1\102\1\76\1\100\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\103\21\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\105\15\62\1\104\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\106\14\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\107\14\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\110\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\111\23\62\1\112\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\114\15\62\1\113\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\115\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\116\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\117\17\62\1\120\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\121\11\62\1\122\1\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\7\62\1\123\22\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\124\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\125\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\127\3\62\1\126\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\131\10\62\1\132\6\62\1\130\1\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\133\21\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\134\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\135\15\62\1\136\3\62\1\137\7\62",
            "\1\140",
            "",
            "\1\143\2\uffff\12\143\13\uffff\1\143\37\uffff\1\143",
            "",
            "",
            "",
            "",
            "",
            "\1\143\1\uffff\12\153\10\uffff\1\152\2\uffff\1\143\34\uffff\1\152\2\uffff\1\143",
            "\1\143\1\uffff\12\155\13\uffff\1\143\37\uffff\1\143",
            "\1\55\12\156\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\143\1\uffff\12\157\13\uffff\1\143\37\uffff\1\143",
            "\1\143\1\uffff\12\160\13\uffff\1\143\37\uffff\1\143",
            "\32\161\4\uffff\1\161\1\uffff\32\161",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\42\163\1\164\71\163\1\162\uffa3\163",
            "\47\166\1\167\64\166\1\165\uffa3\166",
            "",
            "\1\172\4\uffff\1\172\2\uffff\1\171\26\uffff\32\55\3\uffff\2\55\1\uffff\32\55",
            "",
            "\1\172\4\uffff\1\172",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\174\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\175\21\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\176\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\177\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u0080\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\u0081\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0082\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u0083\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\5\62\1\u0084\24\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u0085\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u0086\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u0087\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\62\1\u0088\30\62",
            "\1\u0089\1\uffff\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u008a\1\uffff\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\u008b\14\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\u008c\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u008d\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u008e\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u008f\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u0090\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u0091\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\62\1\u0092\30\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\24\62\1\u0093\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u0094\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u0095\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u0096\10\62",
            "\1\u0098\1\uffff\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u0097\6\62",
            "\1\u0099\1\uffff\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\u009a\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u009b\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u009c\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u009d\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u009e\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u009f\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\30\62\1\u00a0\1\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\17\62\1\u00a1\12\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u00a2\15\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\24\62\1\u00a3\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u00a4\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00a5\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u00a6\15\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\3\62\1\u00a7\26\62",
            "\1\55\12\62\1\u00a8\2\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
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
            "\1\143\1\uffff\12\u00a9\13\uffff\1\143\37\uffff\1\143",
            "",
            "\1\143\1\uffff\12\u00ab\13\uffff\1\143\37\uffff\1\143",
            "\1\55\12\156\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\143\1\uffff\12\u00ac\13\uffff\1\143\37\uffff\1\143",
            "\1\143\1\uffff\12\160\13\uffff\1\143\37\uffff\1\143",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\0\u00ad",
            "\42\163\1\164\71\163\1\162\uffa3\163",
            "\1\172\15\uffff\1\64",
            "\0\u00af",
            "\47\166\1\167\64\166\1\165\uffa3\166",
            "\1\172\15\uffff\1\64",
            "",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00b0\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\25\62\1\u00b1\4\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00b2\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\62\1\u00b3\30\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\17\62\1\u00b4\12\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00b5\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\3\62\1\u00b6\26\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u00b7\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00b8\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00b9\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\u00ba\21\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\25\62\1\u00bb\4\62",
            "\1\u00bc\1\uffff\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u00bd\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u00be\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00bf\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00c0\25\62",
            "\1\55\1\62\1\u00c1\1\62\1\u00c2\2\62\1\u00c3\1\62\1\u00c4\1\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u00c5\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00c6\31\62",
            "\1\u00c7\1\uffff\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\62\1\u00c8\30\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00c9\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\3\62\1\u00ca\26\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\u00cb\13\62\1\u00cc\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\u00cd\21\62",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u00ce\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00cf\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u00d0\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\24\62\1\u00d1\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\24\62\1\u00d2\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00d3\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00d5\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00d6\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00d7\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u00d8\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u00d9\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00da\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00db\25\62",
            "",
            "\1\143\1\uffff\12\u00dc\13\uffff\1\143\37\uffff\1\143",
            "",
            "\1\143\1\uffff\12\u00dd\13\uffff\1\143\37\uffff\1\143",
            "\1\143\1\uffff\12\u00ac\13\uffff\1\143\37\uffff\1\143",
            "\42\163\1\164\71\163\1\162\uffa3\163",
            "",
            "\47\166\1\167\64\166\1\165\uffa3\166",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u00de\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00df\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u00e0\15\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00e1\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\7\62\1\u00e2\22\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u00e3\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\62\1\u00e4\30\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00e5\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\24\62\1\u00e6\5\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u00e7\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\u00e8\14\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\u00e9\21\62",
            "",
            "\1\55\1\62\1\u00ea\1\62\1\u00eb\2\62\1\u00ec\1\62\1\u00ed\1\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00ee\25\62",
            "\1\55\6\62\1\u00ef\3\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\6\62\1\u00f0\23\62",
            "\1\55\6\62\1\u00f1\3\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\2\62\1\u00f2\7\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\4\62\1\u00f3\5\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u00f4\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u00f6\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u00f7\15\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u00f8\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00fa\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\u00fb\14\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\u00fc\27\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\u00fd\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u00fe\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0100\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0102\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u0104\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0105\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\30\62\1\u0106\1\62",
            "",
            "\1\55\12\62\1\u0107\2\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u010f\1\143\1\uffff\12\u0110\13\uffff\1\143\37\uffff\1\143",
            "\1\u010f\1\143\1\uffff\12\160\13\uffff\1\143\37\uffff\1\143",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\u0111\21\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u0112\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0113\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u0114\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\15\62\1\u0115\14\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\3\62\1\u0116\2\62\1\u0117\3\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u0118\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\13\62\1\u0119\16\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\10\62\1\u011a\21\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\6\62\1\u011b\23\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\u011c\27\62",
            "\1\55\6\62\1\u011d\3\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\2\62\1\u011e\7\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\4\62\1\u011f\5\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0120\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u0122\31\62",
            "\1\55\4\62\1\u0123\5\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0124\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0125\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0127\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0129\3\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\6\62\1\u012b\23\62",
            "\1\u012c\1\uffff\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u012d\25\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u012e\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\6\62\1\u012f\23\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u0130\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\u0131\14\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u0132\6\62",
            "\1\55\12\62\1\u0133\2\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\143\1\uffff\12\u0110\13\uffff\1\143\37\uffff\1\143",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\25\62\1\u0136\4\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0137\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u0138\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\15\62\1\u0139\14\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u013a\31\62",
            "\1\55\2\62\1\u013b\7\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\4\62\1\u013c\5\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\u013d\27\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\23\62\1\u013e\6\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\u013f\13\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0140\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0142\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0143\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0145\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0147\3\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\u0149\14\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u014b\10\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u014c\25\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0153\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\15\62\1\u0154\14\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0155\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u0156\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u0157\15\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u0158\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\1\u015a\3\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\12\62\1\u015c\17\62",
            "\1\55\12\62\1\u015d\2\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\u015e\14\62",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\15\62\1\u0163\14\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u0164\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u0165\10\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u0166\15\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0167\25\62",
            "",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u016a\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u016b\15\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\1\u016c\31\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u016d\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\14\62\1\u016f\15\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0170\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\15\62\1\u0171\14\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u0172\7\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0173\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u0174\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\30\62\1\u0175\1\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\17\62\1\u0176\12\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u0177\7\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\17\62\1\u0178\12\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u017a\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\17\62\1\u017b\12\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u017c\31\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\u017d\27\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\1\u017e\31\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\u017f\27\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0180\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\u0181\27\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0182\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u0184\25\62",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\55\12\62\3\uffff\1\64\3\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
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
            return "1:1: Tokens : ( RelativeNamespace | PrivateNamespace | GlobalNamespace | ParameterAny | GraphName | Float32_1 | Float64_1 | Default | Duration | Feedback | String_2 | Uint16_1 | Uint32_1 | Uint64_1 | Boolean | Integer | Float32 | Float64 | Int16_1 | Int32_1 | Int64_1 | Message | Param | Service | Uint8_1 | Base64 | Double | Header | String | Struct | Action | Bool_1 | Byte_1 | Char_1 | Int8_1 | Result | String_1 | Uint16 | Uint32 | Uint64 | Value_1 | Array | Int16 | Int32 | Int64 | Pub | Sub | Type_1 | Uint8 | Value | Date | List | Ac | As | Bool | Byte | Char | Goal | Int8 | Name | Node | Sc | Ss | Time | Type | Any | Ns | LeftSquareBracketRightSquareBracket | Comma | FullStop | Colon | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_BINARY | RULE_BOOLEAN | RULE_DOUBLE | RULE_DECINT | RULE_DATE_TIME | RULE_MESSAGE_ASIGMENT | RULE_SL_COMMENT | RULE_ROS_CONVENTION_A | RULE_ROS_CONVENTION_PARAM | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_WS | RULE_ANY_OTHER );";
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

                        else if ( (LA32_0=='f') ) {s = 4;}

                        else if ( (LA32_0=='d') ) {s = 5;}

                        else if ( (LA32_0=='s') ) {s = 6;}

                        else if ( (LA32_0=='u') ) {s = 7;}

                        else if ( (LA32_0=='B') ) {s = 8;}

                        else if ( (LA32_0=='I') ) {s = 9;}

                        else if ( (LA32_0=='i') ) {s = 10;}

                        else if ( (LA32_0=='m') ) {s = 11;}

                        else if ( (LA32_0=='p') ) {s = 12;}

                        else if ( (LA32_0=='D') ) {s = 13;}

                        else if ( (LA32_0=='H') ) {s = 14;}

                        else if ( (LA32_0=='S') ) {s = 15;}

                        else if ( (LA32_0=='a') ) {s = 16;}

                        else if ( (LA32_0=='b') ) {s = 17;}

                        else if ( (LA32_0=='c') ) {s = 18;}

                        else if ( (LA32_0=='r') ) {s = 19;}

                        else if ( (LA32_0=='v') ) {s = 20;}

                        else if ( (LA32_0=='A') ) {s = 21;}

                        else if ( (LA32_0=='t') ) {s = 22;}

                        else if ( (LA32_0=='L') ) {s = 23;}

                        else if ( (LA32_0=='g') ) {s = 24;}

                        else if ( (LA32_0=='n') ) {s = 25;}

                        else if ( (LA32_0=='[') ) {s = 26;}

                        else if ( (LA32_0==',') ) {s = 27;}

                        else if ( (LA32_0=='.') ) {s = 28;}

                        else if ( (LA32_0==':') ) {s = 29;}

                        else if ( (LA32_0=='@') ) {s = 30;}

                        else if ( (LA32_0==']') ) {s = 31;}

                        else if ( (LA32_0=='{') ) {s = 32;}

                        else if ( (LA32_0=='}') ) {s = 33;}

                        else if ( (LA32_0=='0') ) {s = 34;}

                        else if ( ((LA32_0>='1' && LA32_0<='2')) ) {s = 35;}

                        else if ( (LA32_0=='E'||LA32_0=='e') ) {s = 36;}

                        else if ( (LA32_0=='-') ) {s = 37;}

                        else if ( ((LA32_0>='3' && LA32_0<='9')) ) {s = 38;}

                        else if ( (LA32_0=='^') ) {s = 39;}

                        else if ( (LA32_0=='C'||LA32_0=='F'||(LA32_0>='J' && LA32_0<='K')||(LA32_0>='M' && LA32_0<='O')||LA32_0=='Q'||(LA32_0>='T' && LA32_0<='Z')||LA32_0=='_'||LA32_0=='h'||(LA32_0>='j' && LA32_0<='l')||LA32_0=='o'||LA32_0=='q'||(LA32_0>='w' && LA32_0<='z')) ) {s = 40;}

                        else if ( (LA32_0=='\"') ) {s = 41;}

                        else if ( (LA32_0=='\'') ) {s = 42;}

                        else if ( (LA32_0=='#') ) {s = 43;}

                        else if ( (LA32_0=='/') ) {s = 44;}

                        else if ( (LA32_0=='~') ) {s = 46;}

                        else if ( ((LA32_0>='\t' && LA32_0<='\n')||LA32_0=='\r'||LA32_0==' ') ) {s = 47;}

                        else if ( ((LA32_0>='\u0000' && LA32_0<='\b')||(LA32_0>='\u000B' && LA32_0<='\f')||(LA32_0>='\u000E' && LA32_0<='\u001F')||LA32_0=='!'||(LA32_0>='$' && LA32_0<='&')||(LA32_0>='(' && LA32_0<='+')||(LA32_0>=';' && LA32_0<='?')||LA32_0=='\\'||LA32_0=='`'||LA32_0=='|'||(LA32_0>='\u007F' && LA32_0<='\uFFFF')) ) {s = 48;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_42 = input.LA(1);

                        s = -1;
                        if ( (LA32_42=='\\') ) {s = 117;}

                        else if ( ((LA32_42>='\u0000' && LA32_42<='&')||(LA32_42>='(' && LA32_42<='[')||(LA32_42>=']' && LA32_42<='\uFFFF')) ) {s = 118;}

                        else if ( (LA32_42=='\'') ) {s = 119;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_175 = input.LA(1);

                        s = -1;
                        if ( (LA32_175=='\'') ) {s = 119;}

                        else if ( (LA32_175=='\\') ) {s = 117;}

                        else if ( ((LA32_175>='\u0000' && LA32_175<='&')||(LA32_175>='(' && LA32_175<='[')||(LA32_175>=']' && LA32_175<='\uFFFF')) ) {s = 118;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_118 = input.LA(1);

                        s = -1;
                        if ( (LA32_118=='\'') ) {s = 119;}

                        else if ( (LA32_118=='\\') ) {s = 117;}

                        else if ( ((LA32_118>='\u0000' && LA32_118<='&')||(LA32_118>='(' && LA32_118<='[')||(LA32_118>=']' && LA32_118<='\uFFFF')) ) {s = 118;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_114 = input.LA(1);

                        s = -1;
                        if ( ((LA32_114>='\u0000' && LA32_114<='\uFFFF')) ) {s = 173;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_117 = input.LA(1);

                        s = -1;
                        if ( ((LA32_117>='\u0000' && LA32_117<='\uFFFF')) ) {s = 175;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_41 = input.LA(1);

                        s = -1;
                        if ( (LA32_41=='\\') ) {s = 114;}

                        else if ( ((LA32_41>='\u0000' && LA32_41<='!')||(LA32_41>='#' && LA32_41<='[')||(LA32_41>=']' && LA32_41<='\uFFFF')) ) {s = 115;}

                        else if ( (LA32_41=='\"') ) {s = 116;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_173 = input.LA(1);

                        s = -1;
                        if ( (LA32_173=='\"') ) {s = 116;}

                        else if ( (LA32_173=='\\') ) {s = 114;}

                        else if ( ((LA32_173>='\u0000' && LA32_173<='!')||(LA32_173>='#' && LA32_173<='[')||(LA32_173>=']' && LA32_173<='\uFFFF')) ) {s = 115;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_115 = input.LA(1);

                        s = -1;
                        if ( (LA32_115=='\"') ) {s = 116;}

                        else if ( (LA32_115=='\\') ) {s = 114;}

                        else if ( ((LA32_115>='\u0000' && LA32_115<='!')||(LA32_115>='#' && LA32_115<='[')||(LA32_115>=']' && LA32_115<='\uFFFF')) ) {s = 115;}

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