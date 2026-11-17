package de.fraunhofer.ipa.ros.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.fraunhofer.ipa.ros.services.BasicsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBasicsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "ParameterAny", "GraphName", "Float32_1", "Float64_1", "Default", "Duration", "Feedback", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Float32", "Float64", "Int16_1", "Int32_1", "Int64_1", "Message", "Param", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Int8_1", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Int16", "Int32", "Int64", "Pub", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
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


        public InternalBasicsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBasicsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBasicsParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBasicsParser.g"; }


    	private BasicsGrammarAccess grammarAccess;
    	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
    	
    	{
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("CommercialAt", "'@'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("LeftCurlyBracket", "'{'");
    		tokenNameToValue.put("RightCurlyBracket", "'}'");
    		tokenNameToValue.put("LeftSquareBracketRightSquareBracket", "'[]'");
    		tokenNameToValue.put("Any", "'Any'");
    		tokenNameToValue.put("Ns", "'ns:'");
    		tokenNameToValue.put("Date", "'Date'");
    		tokenNameToValue.put("List", "'List'");
    		tokenNameToValue.put("Ac", "'ac->'");
    		tokenNameToValue.put("As", "'as->'");
    		tokenNameToValue.put("Bool", "'bool'");
    		tokenNameToValue.put("Byte", "'byte'");
    		tokenNameToValue.put("Char", "'char'");
    		tokenNameToValue.put("Goal", "'goal'");
    		tokenNameToValue.put("Int8", "'int8'");
    		tokenNameToValue.put("Name", "'name'");
    		tokenNameToValue.put("Node", "'node'");
    		tokenNameToValue.put("Sc", "'sc->'");
    		tokenNameToValue.put("Ss", "'ss->'");
    		tokenNameToValue.put("Time", "'time'");
    		tokenNameToValue.put("Type", "'type'");
    		tokenNameToValue.put("Array", "'Array'");
    		tokenNameToValue.put("Int16", "'int16'");
    		tokenNameToValue.put("Int32", "'int32'");
    		tokenNameToValue.put("Int64", "'int64'");
    		tokenNameToValue.put("Pub", "'pub->'");
    		tokenNameToValue.put("Sub", "'sub->'");
    		tokenNameToValue.put("Type_1", "'type:'");
    		tokenNameToValue.put("Uint8", "'uint8'");
    		tokenNameToValue.put("Value", "'value'");
    		tokenNameToValue.put("Base64", "'Base64'");
    		tokenNameToValue.put("Double", "'Double'");
    		tokenNameToValue.put("Header", "'Header'");
    		tokenNameToValue.put("String", "'String'");
    		tokenNameToValue.put("Struct", "'Struct'");
    		tokenNameToValue.put("Action", "'action'");
    		tokenNameToValue.put("Bool_1", "'bool[]'");
    		tokenNameToValue.put("Byte_1", "'byte[]'");
    		tokenNameToValue.put("Char_1", "'char[]'");
    		tokenNameToValue.put("Int8_1", "'int8[]'");
    		tokenNameToValue.put("Result", "'result'");
    		tokenNameToValue.put("String_1", "'string'");
    		tokenNameToValue.put("Uint16", "'uint16'");
    		tokenNameToValue.put("Uint32", "'uint32'");
    		tokenNameToValue.put("Uint64", "'uint64'");
    		tokenNameToValue.put("Value_1", "'value:'");
    		tokenNameToValue.put("Boolean", "'Boolean'");
    		tokenNameToValue.put("Integer", "'Integer'");
    		tokenNameToValue.put("Float32", "'float32'");
    		tokenNameToValue.put("Float64", "'float64'");
    		tokenNameToValue.put("Int16_1", "'int16[]'");
    		tokenNameToValue.put("Int32_1", "'int32[]'");
    		tokenNameToValue.put("Int64_1", "'int64[]'");
    		tokenNameToValue.put("Message", "'message'");
    		tokenNameToValue.put("Param", "'param->'");
    		tokenNameToValue.put("Service", "'service'");
    		tokenNameToValue.put("Uint8_1", "'uint8[]'");
    		tokenNameToValue.put("Default", "'default:'");
    		tokenNameToValue.put("Duration", "'duration'");
    		tokenNameToValue.put("Feedback", "'feedback'");
    		tokenNameToValue.put("String_2", "'string[]'");
    		tokenNameToValue.put("Uint16_1", "'uint16[]'");
    		tokenNameToValue.put("Uint32_1", "'uint32[]'");
    		tokenNameToValue.put("Uint64_1", "'uint64[]'");
    		tokenNameToValue.put("GraphName", "'GraphName'");
    		tokenNameToValue.put("Float32_1", "'float32[]'");
    		tokenNameToValue.put("Float64_1", "'float64[]'");
    		tokenNameToValue.put("ParameterAny", "'ParameterAny'");
    		tokenNameToValue.put("GlobalNamespace", "'GlobalNamespace'");
    		tokenNameToValue.put("PrivateNamespace", "'PrivateNamespace'");
    		tokenNameToValue.put("RelativeNamespace", "'RelativeNamespace'");
    	}

    	public void setGrammarAccess(BasicsGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		String result = tokenNameToValue.get(tokenName);
    		if (result == null)
    			result = tokenName;
    		return result;
    	}



    // $ANTLR start "entryRuleNamespace"
    // InternalBasicsParser.g:131:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // InternalBasicsParser.g:132:1: ( ruleNamespace EOF )
            // InternalBasicsParser.g:133:1: ruleNamespace EOF
            {
             before(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_1);
            ruleNamespace();

            state._fsp--;

             after(grammarAccess.getNamespaceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalBasicsParser.g:140:1: ruleNamespace : ( ( rule__Namespace__Alternatives ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:144:2: ( ( ( rule__Namespace__Alternatives ) ) )
            // InternalBasicsParser.g:145:2: ( ( rule__Namespace__Alternatives ) )
            {
            // InternalBasicsParser.g:145:2: ( ( rule__Namespace__Alternatives ) )
            // InternalBasicsParser.g:146:3: ( rule__Namespace__Alternatives )
            {
             before(grammarAccess.getNamespaceAccess().getAlternatives()); 
            // InternalBasicsParser.g:147:3: ( rule__Namespace__Alternatives )
            // InternalBasicsParser.g:147:4: rule__Namespace__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Namespace__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNamespaceAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleGraphName"
    // InternalBasicsParser.g:156:1: entryRuleGraphName : ruleGraphName EOF ;
    public final void entryRuleGraphName() throws RecognitionException {
        try {
            // InternalBasicsParser.g:157:1: ( ruleGraphName EOF )
            // InternalBasicsParser.g:158:1: ruleGraphName EOF
            {
             before(grammarAccess.getGraphNameRule()); 
            pushFollow(FOLLOW_1);
            ruleGraphName();

            state._fsp--;

             after(grammarAccess.getGraphNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGraphName"


    // $ANTLR start "ruleGraphName"
    // InternalBasicsParser.g:165:1: ruleGraphName : ( GraphName ) ;
    public final void ruleGraphName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:169:2: ( ( GraphName ) )
            // InternalBasicsParser.g:170:2: ( GraphName )
            {
            // InternalBasicsParser.g:170:2: ( GraphName )
            // InternalBasicsParser.g:171:3: GraphName
            {
             before(grammarAccess.getGraphNameAccess().getGraphNameKeyword()); 
            match(input,GraphName,FOLLOW_2); 
             after(grammarAccess.getGraphNameAccess().getGraphNameKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGraphName"


    // $ANTLR start "entryRuleGlobalNamespace"
    // InternalBasicsParser.g:181:1: entryRuleGlobalNamespace : ruleGlobalNamespace EOF ;
    public final void entryRuleGlobalNamespace() throws RecognitionException {
        try {
            // InternalBasicsParser.g:182:1: ( ruleGlobalNamespace EOF )
            // InternalBasicsParser.g:183:1: ruleGlobalNamespace EOF
            {
             before(grammarAccess.getGlobalNamespaceRule()); 
            pushFollow(FOLLOW_1);
            ruleGlobalNamespace();

            state._fsp--;

             after(grammarAccess.getGlobalNamespaceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGlobalNamespace"


    // $ANTLR start "ruleGlobalNamespace"
    // InternalBasicsParser.g:190:1: ruleGlobalNamespace : ( ( rule__GlobalNamespace__Group__0 ) ) ;
    public final void ruleGlobalNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:194:2: ( ( ( rule__GlobalNamespace__Group__0 ) ) )
            // InternalBasicsParser.g:195:2: ( ( rule__GlobalNamespace__Group__0 ) )
            {
            // InternalBasicsParser.g:195:2: ( ( rule__GlobalNamespace__Group__0 ) )
            // InternalBasicsParser.g:196:3: ( rule__GlobalNamespace__Group__0 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup()); 
            // InternalBasicsParser.g:197:3: ( rule__GlobalNamespace__Group__0 )
            // InternalBasicsParser.g:197:4: rule__GlobalNamespace__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGlobalNamespaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGlobalNamespace"


    // $ANTLR start "entryRuleRelativeNamespace_Impl"
    // InternalBasicsParser.g:206:1: entryRuleRelativeNamespace_Impl : ruleRelativeNamespace_Impl EOF ;
    public final void entryRuleRelativeNamespace_Impl() throws RecognitionException {
        try {
            // InternalBasicsParser.g:207:1: ( ruleRelativeNamespace_Impl EOF )
            // InternalBasicsParser.g:208:1: ruleRelativeNamespace_Impl EOF
            {
             before(grammarAccess.getRelativeNamespace_ImplRule()); 
            pushFollow(FOLLOW_1);
            ruleRelativeNamespace_Impl();

            state._fsp--;

             after(grammarAccess.getRelativeNamespace_ImplRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelativeNamespace_Impl"


    // $ANTLR start "ruleRelativeNamespace_Impl"
    // InternalBasicsParser.g:215:1: ruleRelativeNamespace_Impl : ( ( rule__RelativeNamespace_Impl__Group__0 ) ) ;
    public final void ruleRelativeNamespace_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:219:2: ( ( ( rule__RelativeNamespace_Impl__Group__0 ) ) )
            // InternalBasicsParser.g:220:2: ( ( rule__RelativeNamespace_Impl__Group__0 ) )
            {
            // InternalBasicsParser.g:220:2: ( ( rule__RelativeNamespace_Impl__Group__0 ) )
            // InternalBasicsParser.g:221:3: ( rule__RelativeNamespace_Impl__Group__0 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup()); 
            // InternalBasicsParser.g:222:3: ( rule__RelativeNamespace_Impl__Group__0 )
            // InternalBasicsParser.g:222:4: rule__RelativeNamespace_Impl__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelativeNamespace_ImplAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelativeNamespace_Impl"


    // $ANTLR start "entryRulePrivateNamespace"
    // InternalBasicsParser.g:231:1: entryRulePrivateNamespace : rulePrivateNamespace EOF ;
    public final void entryRulePrivateNamespace() throws RecognitionException {
        try {
            // InternalBasicsParser.g:232:1: ( rulePrivateNamespace EOF )
            // InternalBasicsParser.g:233:1: rulePrivateNamespace EOF
            {
             before(grammarAccess.getPrivateNamespaceRule()); 
            pushFollow(FOLLOW_1);
            rulePrivateNamespace();

            state._fsp--;

             after(grammarAccess.getPrivateNamespaceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrivateNamespace"


    // $ANTLR start "rulePrivateNamespace"
    // InternalBasicsParser.g:240:1: rulePrivateNamespace : ( ( rule__PrivateNamespace__Group__0 ) ) ;
    public final void rulePrivateNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:244:2: ( ( ( rule__PrivateNamespace__Group__0 ) ) )
            // InternalBasicsParser.g:245:2: ( ( rule__PrivateNamespace__Group__0 ) )
            {
            // InternalBasicsParser.g:245:2: ( ( rule__PrivateNamespace__Group__0 ) )
            // InternalBasicsParser.g:246:3: ( rule__PrivateNamespace__Group__0 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup()); 
            // InternalBasicsParser.g:247:3: ( rule__PrivateNamespace__Group__0 )
            // InternalBasicsParser.g:247:4: rule__PrivateNamespace__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPrivateNamespaceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrivateNamespace"


    // $ANTLR start "entryRuleParameterType"
    // InternalBasicsParser.g:256:1: entryRuleParameterType : ruleParameterType EOF ;
    public final void entryRuleParameterType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:257:1: ( ruleParameterType EOF )
            // InternalBasicsParser.g:258:1: ruleParameterType EOF
            {
             before(grammarAccess.getParameterTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterType();

            state._fsp--;

             after(grammarAccess.getParameterTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // InternalBasicsParser.g:265:1: ruleParameterType : ( ( rule__ParameterType__Alternatives ) ) ;
    public final void ruleParameterType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:269:2: ( ( ( rule__ParameterType__Alternatives ) ) )
            // InternalBasicsParser.g:270:2: ( ( rule__ParameterType__Alternatives ) )
            {
            // InternalBasicsParser.g:270:2: ( ( rule__ParameterType__Alternatives ) )
            // InternalBasicsParser.g:271:3: ( rule__ParameterType__Alternatives )
            {
             before(grammarAccess.getParameterTypeAccess().getAlternatives()); 
            // InternalBasicsParser.g:272:3: ( rule__ParameterType__Alternatives )
            // InternalBasicsParser.g:272:4: rule__ParameterType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ParameterType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParameterTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleParameterValue"
    // InternalBasicsParser.g:281:1: entryRuleParameterValue : ruleParameterValue EOF ;
    public final void entryRuleParameterValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:282:1: ( ruleParameterValue EOF )
            // InternalBasicsParser.g:283:1: ruleParameterValue EOF
            {
             before(grammarAccess.getParameterValueRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterValue();

            state._fsp--;

             after(grammarAccess.getParameterValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterValue"


    // $ANTLR start "ruleParameterValue"
    // InternalBasicsParser.g:290:1: ruleParameterValue : ( ( rule__ParameterValue__Alternatives ) ) ;
    public final void ruleParameterValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:294:2: ( ( ( rule__ParameterValue__Alternatives ) ) )
            // InternalBasicsParser.g:295:2: ( ( rule__ParameterValue__Alternatives ) )
            {
            // InternalBasicsParser.g:295:2: ( ( rule__ParameterValue__Alternatives ) )
            // InternalBasicsParser.g:296:3: ( rule__ParameterValue__Alternatives )
            {
             before(grammarAccess.getParameterValueAccess().getAlternatives()); 
            // InternalBasicsParser.g:297:3: ( rule__ParameterValue__Alternatives )
            // InternalBasicsParser.g:297:4: rule__ParameterValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ParameterValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParameterValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterValue"


    // $ANTLR start "entryRuleParameterListType"
    // InternalBasicsParser.g:306:1: entryRuleParameterListType : ruleParameterListType EOF ;
    public final void entryRuleParameterListType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:307:1: ( ruleParameterListType EOF )
            // InternalBasicsParser.g:308:1: ruleParameterListType EOF
            {
             before(grammarAccess.getParameterListTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterListType();

            state._fsp--;

             after(grammarAccess.getParameterListTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterListType"


    // $ANTLR start "ruleParameterListType"
    // InternalBasicsParser.g:315:1: ruleParameterListType : ( ( rule__ParameterListType__Group__0 ) ) ;
    public final void ruleParameterListType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:319:2: ( ( ( rule__ParameterListType__Group__0 ) ) )
            // InternalBasicsParser.g:320:2: ( ( rule__ParameterListType__Group__0 ) )
            {
            // InternalBasicsParser.g:320:2: ( ( rule__ParameterListType__Group__0 ) )
            // InternalBasicsParser.g:321:3: ( rule__ParameterListType__Group__0 )
            {
             before(grammarAccess.getParameterListTypeAccess().getGroup()); 
            // InternalBasicsParser.g:322:3: ( rule__ParameterListType__Group__0 )
            // InternalBasicsParser.g:322:4: rule__ParameterListType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterListTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterListType"


    // $ANTLR start "entryRuleParameterStructType"
    // InternalBasicsParser.g:331:1: entryRuleParameterStructType : ruleParameterStructType EOF ;
    public final void entryRuleParameterStructType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:332:1: ( ruleParameterStructType EOF )
            // InternalBasicsParser.g:333:1: ruleParameterStructType EOF
            {
             before(grammarAccess.getParameterStructTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterStructType();

            state._fsp--;

             after(grammarAccess.getParameterStructTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterStructType"


    // $ANTLR start "ruleParameterStructType"
    // InternalBasicsParser.g:340:1: ruleParameterStructType : ( ( rule__ParameterStructType__Group__0 ) ) ;
    public final void ruleParameterStructType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:344:2: ( ( ( rule__ParameterStructType__Group__0 ) ) )
            // InternalBasicsParser.g:345:2: ( ( rule__ParameterStructType__Group__0 ) )
            {
            // InternalBasicsParser.g:345:2: ( ( rule__ParameterStructType__Group__0 ) )
            // InternalBasicsParser.g:346:3: ( rule__ParameterStructType__Group__0 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getGroup()); 
            // InternalBasicsParser.g:347:3: ( rule__ParameterStructType__Group__0 )
            // InternalBasicsParser.g:347:4: rule__ParameterStructType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterStructType"


    // $ANTLR start "entryRuleParameterIntegerType"
    // InternalBasicsParser.g:356:1: entryRuleParameterIntegerType : ruleParameterIntegerType EOF ;
    public final void entryRuleParameterIntegerType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:357:1: ( ruleParameterIntegerType EOF )
            // InternalBasicsParser.g:358:1: ruleParameterIntegerType EOF
            {
             before(grammarAccess.getParameterIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterIntegerType();

            state._fsp--;

             after(grammarAccess.getParameterIntegerTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterIntegerType"


    // $ANTLR start "ruleParameterIntegerType"
    // InternalBasicsParser.g:365:1: ruleParameterIntegerType : ( ( rule__ParameterIntegerType__Group__0 ) ) ;
    public final void ruleParameterIntegerType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:369:2: ( ( ( rule__ParameterIntegerType__Group__0 ) ) )
            // InternalBasicsParser.g:370:2: ( ( rule__ParameterIntegerType__Group__0 ) )
            {
            // InternalBasicsParser.g:370:2: ( ( rule__ParameterIntegerType__Group__0 ) )
            // InternalBasicsParser.g:371:3: ( rule__ParameterIntegerType__Group__0 )
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getGroup()); 
            // InternalBasicsParser.g:372:3: ( rule__ParameterIntegerType__Group__0 )
            // InternalBasicsParser.g:372:4: rule__ParameterIntegerType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterIntegerType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterIntegerTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterIntegerType"


    // $ANTLR start "entryRuleParameterStringType"
    // InternalBasicsParser.g:381:1: entryRuleParameterStringType : ruleParameterStringType EOF ;
    public final void entryRuleParameterStringType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:382:1: ( ruleParameterStringType EOF )
            // InternalBasicsParser.g:383:1: ruleParameterStringType EOF
            {
             before(grammarAccess.getParameterStringTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterStringType();

            state._fsp--;

             after(grammarAccess.getParameterStringTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterStringType"


    // $ANTLR start "ruleParameterStringType"
    // InternalBasicsParser.g:390:1: ruleParameterStringType : ( ( rule__ParameterStringType__Group__0 ) ) ;
    public final void ruleParameterStringType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:394:2: ( ( ( rule__ParameterStringType__Group__0 ) ) )
            // InternalBasicsParser.g:395:2: ( ( rule__ParameterStringType__Group__0 ) )
            {
            // InternalBasicsParser.g:395:2: ( ( rule__ParameterStringType__Group__0 ) )
            // InternalBasicsParser.g:396:3: ( rule__ParameterStringType__Group__0 )
            {
             before(grammarAccess.getParameterStringTypeAccess().getGroup()); 
            // InternalBasicsParser.g:397:3: ( rule__ParameterStringType__Group__0 )
            // InternalBasicsParser.g:397:4: rule__ParameterStringType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStringType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStringTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterStringType"


    // $ANTLR start "entryRuleParameterDoubleType"
    // InternalBasicsParser.g:406:1: entryRuleParameterDoubleType : ruleParameterDoubleType EOF ;
    public final void entryRuleParameterDoubleType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:407:1: ( ruleParameterDoubleType EOF )
            // InternalBasicsParser.g:408:1: ruleParameterDoubleType EOF
            {
             before(grammarAccess.getParameterDoubleTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterDoubleType();

            state._fsp--;

             after(grammarAccess.getParameterDoubleTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterDoubleType"


    // $ANTLR start "ruleParameterDoubleType"
    // InternalBasicsParser.g:415:1: ruleParameterDoubleType : ( ( rule__ParameterDoubleType__Group__0 ) ) ;
    public final void ruleParameterDoubleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:419:2: ( ( ( rule__ParameterDoubleType__Group__0 ) ) )
            // InternalBasicsParser.g:420:2: ( ( rule__ParameterDoubleType__Group__0 ) )
            {
            // InternalBasicsParser.g:420:2: ( ( rule__ParameterDoubleType__Group__0 ) )
            // InternalBasicsParser.g:421:3: ( rule__ParameterDoubleType__Group__0 )
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getGroup()); 
            // InternalBasicsParser.g:422:3: ( rule__ParameterDoubleType__Group__0 )
            // InternalBasicsParser.g:422:4: rule__ParameterDoubleType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterDoubleType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterDoubleTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterDoubleType"


    // $ANTLR start "entryRuleParameterBooleanType"
    // InternalBasicsParser.g:431:1: entryRuleParameterBooleanType : ruleParameterBooleanType EOF ;
    public final void entryRuleParameterBooleanType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:432:1: ( ruleParameterBooleanType EOF )
            // InternalBasicsParser.g:433:1: ruleParameterBooleanType EOF
            {
             before(grammarAccess.getParameterBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterBooleanType();

            state._fsp--;

             after(grammarAccess.getParameterBooleanTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterBooleanType"


    // $ANTLR start "ruleParameterBooleanType"
    // InternalBasicsParser.g:440:1: ruleParameterBooleanType : ( ( rule__ParameterBooleanType__Group__0 ) ) ;
    public final void ruleParameterBooleanType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:444:2: ( ( ( rule__ParameterBooleanType__Group__0 ) ) )
            // InternalBasicsParser.g:445:2: ( ( rule__ParameterBooleanType__Group__0 ) )
            {
            // InternalBasicsParser.g:445:2: ( ( rule__ParameterBooleanType__Group__0 ) )
            // InternalBasicsParser.g:446:3: ( rule__ParameterBooleanType__Group__0 )
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getGroup()); 
            // InternalBasicsParser.g:447:3: ( rule__ParameterBooleanType__Group__0 )
            // InternalBasicsParser.g:447:4: rule__ParameterBooleanType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBooleanType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterBooleanTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterBooleanType"


    // $ANTLR start "entryRuleParameterBase64Type"
    // InternalBasicsParser.g:456:1: entryRuleParameterBase64Type : ruleParameterBase64Type EOF ;
    public final void entryRuleParameterBase64Type() throws RecognitionException {
        try {
            // InternalBasicsParser.g:457:1: ( ruleParameterBase64Type EOF )
            // InternalBasicsParser.g:458:1: ruleParameterBase64Type EOF
            {
             before(grammarAccess.getParameterBase64TypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterBase64Type();

            state._fsp--;

             after(grammarAccess.getParameterBase64TypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterBase64Type"


    // $ANTLR start "ruleParameterBase64Type"
    // InternalBasicsParser.g:465:1: ruleParameterBase64Type : ( ( rule__ParameterBase64Type__Group__0 ) ) ;
    public final void ruleParameterBase64Type() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:469:2: ( ( ( rule__ParameterBase64Type__Group__0 ) ) )
            // InternalBasicsParser.g:470:2: ( ( rule__ParameterBase64Type__Group__0 ) )
            {
            // InternalBasicsParser.g:470:2: ( ( rule__ParameterBase64Type__Group__0 ) )
            // InternalBasicsParser.g:471:3: ( rule__ParameterBase64Type__Group__0 )
            {
             before(grammarAccess.getParameterBase64TypeAccess().getGroup()); 
            // InternalBasicsParser.g:472:3: ( rule__ParameterBase64Type__Group__0 )
            // InternalBasicsParser.g:472:4: rule__ParameterBase64Type__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBase64Type__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterBase64TypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterBase64Type"


    // $ANTLR start "entryRuleParameterArrayType"
    // InternalBasicsParser.g:481:1: entryRuleParameterArrayType : ruleParameterArrayType EOF ;
    public final void entryRuleParameterArrayType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:482:1: ( ruleParameterArrayType EOF )
            // InternalBasicsParser.g:483:1: ruleParameterArrayType EOF
            {
             before(grammarAccess.getParameterArrayTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterArrayType();

            state._fsp--;

             after(grammarAccess.getParameterArrayTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterArrayType"


    // $ANTLR start "ruleParameterArrayType"
    // InternalBasicsParser.g:490:1: ruleParameterArrayType : ( ( rule__ParameterArrayType__Group__0 ) ) ;
    public final void ruleParameterArrayType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:494:2: ( ( ( rule__ParameterArrayType__Group__0 ) ) )
            // InternalBasicsParser.g:495:2: ( ( rule__ParameterArrayType__Group__0 ) )
            {
            // InternalBasicsParser.g:495:2: ( ( rule__ParameterArrayType__Group__0 ) )
            // InternalBasicsParser.g:496:3: ( rule__ParameterArrayType__Group__0 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getGroup()); 
            // InternalBasicsParser.g:497:3: ( rule__ParameterArrayType__Group__0 )
            // InternalBasicsParser.g:497:4: rule__ParameterArrayType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterArrayTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterArrayType"


    // $ANTLR start "entryRuleParameterList"
    // InternalBasicsParser.g:506:1: entryRuleParameterList : ruleParameterList EOF ;
    public final void entryRuleParameterList() throws RecognitionException {
        try {
            // InternalBasicsParser.g:507:1: ( ruleParameterList EOF )
            // InternalBasicsParser.g:508:1: ruleParameterList EOF
            {
             before(grammarAccess.getParameterListRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterList();

            state._fsp--;

             after(grammarAccess.getParameterListRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalBasicsParser.g:515:1: ruleParameterList : ( ( rule__ParameterList__Group__0 ) ) ;
    public final void ruleParameterList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:519:2: ( ( ( rule__ParameterList__Group__0 ) ) )
            // InternalBasicsParser.g:520:2: ( ( rule__ParameterList__Group__0 ) )
            {
            // InternalBasicsParser.g:520:2: ( ( rule__ParameterList__Group__0 ) )
            // InternalBasicsParser.g:521:3: ( rule__ParameterList__Group__0 )
            {
             before(grammarAccess.getParameterListAccess().getGroup()); 
            // InternalBasicsParser.g:522:3: ( rule__ParameterList__Group__0 )
            // InternalBasicsParser.g:522:4: rule__ParameterList__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterListAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameterAny"
    // InternalBasicsParser.g:531:1: entryRuleParameterAny : ruleParameterAny EOF ;
    public final void entryRuleParameterAny() throws RecognitionException {
        try {
            // InternalBasicsParser.g:532:1: ( ruleParameterAny EOF )
            // InternalBasicsParser.g:533:1: ruleParameterAny EOF
            {
             before(grammarAccess.getParameterAnyRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterAny();

            state._fsp--;

             after(grammarAccess.getParameterAnyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterAny"


    // $ANTLR start "ruleParameterAny"
    // InternalBasicsParser.g:540:1: ruleParameterAny : ( ( rule__ParameterAny__Group__0 ) ) ;
    public final void ruleParameterAny() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:544:2: ( ( ( rule__ParameterAny__Group__0 ) ) )
            // InternalBasicsParser.g:545:2: ( ( rule__ParameterAny__Group__0 ) )
            {
            // InternalBasicsParser.g:545:2: ( ( rule__ParameterAny__Group__0 ) )
            // InternalBasicsParser.g:546:3: ( rule__ParameterAny__Group__0 )
            {
             before(grammarAccess.getParameterAnyAccess().getGroup()); 
            // InternalBasicsParser.g:547:3: ( rule__ParameterAny__Group__0 )
            // InternalBasicsParser.g:547:4: rule__ParameterAny__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterAny__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAnyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterAny"


    // $ANTLR start "entryRuleParameterString"
    // InternalBasicsParser.g:556:1: entryRuleParameterString : ruleParameterString EOF ;
    public final void entryRuleParameterString() throws RecognitionException {
        try {
            // InternalBasicsParser.g:557:1: ( ruleParameterString EOF )
            // InternalBasicsParser.g:558:1: ruleParameterString EOF
            {
             before(grammarAccess.getParameterStringRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterString();

            state._fsp--;

             after(grammarAccess.getParameterStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterString"


    // $ANTLR start "ruleParameterString"
    // InternalBasicsParser.g:565:1: ruleParameterString : ( ( rule__ParameterString__ValueAssignment ) ) ;
    public final void ruleParameterString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:569:2: ( ( ( rule__ParameterString__ValueAssignment ) ) )
            // InternalBasicsParser.g:570:2: ( ( rule__ParameterString__ValueAssignment ) )
            {
            // InternalBasicsParser.g:570:2: ( ( rule__ParameterString__ValueAssignment ) )
            // InternalBasicsParser.g:571:3: ( rule__ParameterString__ValueAssignment )
            {
             before(grammarAccess.getParameterStringAccess().getValueAssignment()); 
            // InternalBasicsParser.g:572:3: ( rule__ParameterString__ValueAssignment )
            // InternalBasicsParser.g:572:4: rule__ParameterString__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ParameterString__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterStringAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterString"


    // $ANTLR start "entryRuleParameterBase64"
    // InternalBasicsParser.g:581:1: entryRuleParameterBase64 : ruleParameterBase64 EOF ;
    public final void entryRuleParameterBase64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:582:1: ( ruleParameterBase64 EOF )
            // InternalBasicsParser.g:583:1: ruleParameterBase64 EOF
            {
             before(grammarAccess.getParameterBase64Rule()); 
            pushFollow(FOLLOW_1);
            ruleParameterBase64();

            state._fsp--;

             after(grammarAccess.getParameterBase64Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterBase64"


    // $ANTLR start "ruleParameterBase64"
    // InternalBasicsParser.g:590:1: ruleParameterBase64 : ( ( rule__ParameterBase64__ValueAssignment ) ) ;
    public final void ruleParameterBase64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:594:2: ( ( ( rule__ParameterBase64__ValueAssignment ) ) )
            // InternalBasicsParser.g:595:2: ( ( rule__ParameterBase64__ValueAssignment ) )
            {
            // InternalBasicsParser.g:595:2: ( ( rule__ParameterBase64__ValueAssignment ) )
            // InternalBasicsParser.g:596:3: ( rule__ParameterBase64__ValueAssignment )
            {
             before(grammarAccess.getParameterBase64Access().getValueAssignment()); 
            // InternalBasicsParser.g:597:3: ( rule__ParameterBase64__ValueAssignment )
            // InternalBasicsParser.g:597:4: rule__ParameterBase64__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBase64__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterBase64Access().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterBase64"


    // $ANTLR start "entryRuleParameterInteger"
    // InternalBasicsParser.g:606:1: entryRuleParameterInteger : ruleParameterInteger EOF ;
    public final void entryRuleParameterInteger() throws RecognitionException {
        try {
            // InternalBasicsParser.g:607:1: ( ruleParameterInteger EOF )
            // InternalBasicsParser.g:608:1: ruleParameterInteger EOF
            {
             before(grammarAccess.getParameterIntegerRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterInteger();

            state._fsp--;

             after(grammarAccess.getParameterIntegerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterInteger"


    // $ANTLR start "ruleParameterInteger"
    // InternalBasicsParser.g:615:1: ruleParameterInteger : ( ( rule__ParameterInteger__ValueAssignment ) ) ;
    public final void ruleParameterInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:619:2: ( ( ( rule__ParameterInteger__ValueAssignment ) ) )
            // InternalBasicsParser.g:620:2: ( ( rule__ParameterInteger__ValueAssignment ) )
            {
            // InternalBasicsParser.g:620:2: ( ( rule__ParameterInteger__ValueAssignment ) )
            // InternalBasicsParser.g:621:3: ( rule__ParameterInteger__ValueAssignment )
            {
             before(grammarAccess.getParameterIntegerAccess().getValueAssignment()); 
            // InternalBasicsParser.g:622:3: ( rule__ParameterInteger__ValueAssignment )
            // InternalBasicsParser.g:622:4: rule__ParameterInteger__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ParameterInteger__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterIntegerAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterInteger"


    // $ANTLR start "entryRuleParameterDouble"
    // InternalBasicsParser.g:631:1: entryRuleParameterDouble : ruleParameterDouble EOF ;
    public final void entryRuleParameterDouble() throws RecognitionException {
        try {
            // InternalBasicsParser.g:632:1: ( ruleParameterDouble EOF )
            // InternalBasicsParser.g:633:1: ruleParameterDouble EOF
            {
             before(grammarAccess.getParameterDoubleRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterDouble();

            state._fsp--;

             after(grammarAccess.getParameterDoubleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterDouble"


    // $ANTLR start "ruleParameterDouble"
    // InternalBasicsParser.g:640:1: ruleParameterDouble : ( ( rule__ParameterDouble__ValueAssignment ) ) ;
    public final void ruleParameterDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:644:2: ( ( ( rule__ParameterDouble__ValueAssignment ) ) )
            // InternalBasicsParser.g:645:2: ( ( rule__ParameterDouble__ValueAssignment ) )
            {
            // InternalBasicsParser.g:645:2: ( ( rule__ParameterDouble__ValueAssignment ) )
            // InternalBasicsParser.g:646:3: ( rule__ParameterDouble__ValueAssignment )
            {
             before(grammarAccess.getParameterDoubleAccess().getValueAssignment()); 
            // InternalBasicsParser.g:647:3: ( rule__ParameterDouble__ValueAssignment )
            // InternalBasicsParser.g:647:4: rule__ParameterDouble__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ParameterDouble__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterDoubleAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterDouble"


    // $ANTLR start "entryRuleParameterBoolean"
    // InternalBasicsParser.g:656:1: entryRuleParameterBoolean : ruleParameterBoolean EOF ;
    public final void entryRuleParameterBoolean() throws RecognitionException {
        try {
            // InternalBasicsParser.g:657:1: ( ruleParameterBoolean EOF )
            // InternalBasicsParser.g:658:1: ruleParameterBoolean EOF
            {
             before(grammarAccess.getParameterBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterBoolean();

            state._fsp--;

             after(grammarAccess.getParameterBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterBoolean"


    // $ANTLR start "ruleParameterBoolean"
    // InternalBasicsParser.g:665:1: ruleParameterBoolean : ( ( rule__ParameterBoolean__ValueAssignment ) ) ;
    public final void ruleParameterBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:669:2: ( ( ( rule__ParameterBoolean__ValueAssignment ) ) )
            // InternalBasicsParser.g:670:2: ( ( rule__ParameterBoolean__ValueAssignment ) )
            {
            // InternalBasicsParser.g:670:2: ( ( rule__ParameterBoolean__ValueAssignment ) )
            // InternalBasicsParser.g:671:3: ( rule__ParameterBoolean__ValueAssignment )
            {
             before(grammarAccess.getParameterBooleanAccess().getValueAssignment()); 
            // InternalBasicsParser.g:672:3: ( rule__ParameterBoolean__ValueAssignment )
            // InternalBasicsParser.g:672:4: rule__ParameterBoolean__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBoolean__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterBooleanAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterBoolean"


    // $ANTLR start "entryRuleParameterStruct"
    // InternalBasicsParser.g:681:1: entryRuleParameterStruct : ruleParameterStruct EOF ;
    public final void entryRuleParameterStruct() throws RecognitionException {
        try {
            // InternalBasicsParser.g:682:1: ( ruleParameterStruct EOF )
            // InternalBasicsParser.g:683:1: ruleParameterStruct EOF
            {
             before(grammarAccess.getParameterStructRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterStruct();

            state._fsp--;

             after(grammarAccess.getParameterStructRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterStruct"


    // $ANTLR start "ruleParameterStruct"
    // InternalBasicsParser.g:690:1: ruleParameterStruct : ( ( rule__ParameterStruct__Group__0 ) ) ;
    public final void ruleParameterStruct() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:694:2: ( ( ( rule__ParameterStruct__Group__0 ) ) )
            // InternalBasicsParser.g:695:2: ( ( rule__ParameterStruct__Group__0 ) )
            {
            // InternalBasicsParser.g:695:2: ( ( rule__ParameterStruct__Group__0 ) )
            // InternalBasicsParser.g:696:3: ( rule__ParameterStruct__Group__0 )
            {
             before(grammarAccess.getParameterStructAccess().getGroup()); 
            // InternalBasicsParser.g:697:3: ( rule__ParameterStruct__Group__0 )
            // InternalBasicsParser.g:697:4: rule__ParameterStruct__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterStruct"


    // $ANTLR start "entryRuleParameterDate"
    // InternalBasicsParser.g:706:1: entryRuleParameterDate : ruleParameterDate EOF ;
    public final void entryRuleParameterDate() throws RecognitionException {
        try {
            // InternalBasicsParser.g:707:1: ( ruleParameterDate EOF )
            // InternalBasicsParser.g:708:1: ruleParameterDate EOF
            {
             before(grammarAccess.getParameterDateRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterDate();

            state._fsp--;

             after(grammarAccess.getParameterDateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterDate"


    // $ANTLR start "ruleParameterDate"
    // InternalBasicsParser.g:715:1: ruleParameterDate : ( ( rule__ParameterDate__ValueAssignment ) ) ;
    public final void ruleParameterDate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:719:2: ( ( ( rule__ParameterDate__ValueAssignment ) ) )
            // InternalBasicsParser.g:720:2: ( ( rule__ParameterDate__ValueAssignment ) )
            {
            // InternalBasicsParser.g:720:2: ( ( rule__ParameterDate__ValueAssignment ) )
            // InternalBasicsParser.g:721:3: ( rule__ParameterDate__ValueAssignment )
            {
             before(grammarAccess.getParameterDateAccess().getValueAssignment()); 
            // InternalBasicsParser.g:722:3: ( rule__ParameterDate__ValueAssignment )
            // InternalBasicsParser.g:722:4: rule__ParameterDate__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ParameterDate__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getParameterDateAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterDate"


    // $ANTLR start "entryRuleParameterStructMember"
    // InternalBasicsParser.g:731:1: entryRuleParameterStructMember : ruleParameterStructMember EOF ;
    public final void entryRuleParameterStructMember() throws RecognitionException {
        try {
            // InternalBasicsParser.g:732:1: ( ruleParameterStructMember EOF )
            // InternalBasicsParser.g:733:1: ruleParameterStructMember EOF
            {
             before(grammarAccess.getParameterStructMemberRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterStructMember();

            state._fsp--;

             after(grammarAccess.getParameterStructMemberRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterStructMember"


    // $ANTLR start "ruleParameterStructMember"
    // InternalBasicsParser.g:740:1: ruleParameterStructMember : ( ( rule__ParameterStructMember__Group__0 ) ) ;
    public final void ruleParameterStructMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:744:2: ( ( ( rule__ParameterStructMember__Group__0 ) ) )
            // InternalBasicsParser.g:745:2: ( ( rule__ParameterStructMember__Group__0 ) )
            {
            // InternalBasicsParser.g:745:2: ( ( rule__ParameterStructMember__Group__0 ) )
            // InternalBasicsParser.g:746:3: ( rule__ParameterStructMember__Group__0 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getGroup()); 
            // InternalBasicsParser.g:747:3: ( rule__ParameterStructMember__Group__0 )
            // InternalBasicsParser.g:747:4: rule__ParameterStructMember__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructMemberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterStructMember"


    // $ANTLR start "entryRuleParameterStructTypeMember"
    // InternalBasicsParser.g:756:1: entryRuleParameterStructTypeMember : ruleParameterStructTypeMember EOF ;
    public final void entryRuleParameterStructTypeMember() throws RecognitionException {
        try {
            // InternalBasicsParser.g:757:1: ( ruleParameterStructTypeMember EOF )
            // InternalBasicsParser.g:758:1: ruleParameterStructTypeMember EOF
            {
             before(grammarAccess.getParameterStructTypeMemberRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterStructTypeMember();

            state._fsp--;

             after(grammarAccess.getParameterStructTypeMemberRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterStructTypeMember"


    // $ANTLR start "ruleParameterStructTypeMember"
    // InternalBasicsParser.g:765:1: ruleParameterStructTypeMember : ( ( rule__ParameterStructTypeMember__Group__0 ) ) ;
    public final void ruleParameterStructTypeMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:769:2: ( ( ( rule__ParameterStructTypeMember__Group__0 ) ) )
            // InternalBasicsParser.g:770:2: ( ( rule__ParameterStructTypeMember__Group__0 ) )
            {
            // InternalBasicsParser.g:770:2: ( ( rule__ParameterStructTypeMember__Group__0 ) )
            // InternalBasicsParser.g:771:3: ( rule__ParameterStructTypeMember__Group__0 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getGroup()); 
            // InternalBasicsParser.g:772:3: ( rule__ParameterStructTypeMember__Group__0 )
            // InternalBasicsParser.g:772:4: rule__ParameterStructTypeMember__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructTypeMember__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructTypeMemberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterStructTypeMember"


    // $ANTLR start "entryRuleBase64Binary"
    // InternalBasicsParser.g:781:1: entryRuleBase64Binary : ruleBase64Binary EOF ;
    public final void entryRuleBase64Binary() throws RecognitionException {
        try {
            // InternalBasicsParser.g:782:1: ( ruleBase64Binary EOF )
            // InternalBasicsParser.g:783:1: ruleBase64Binary EOF
            {
             before(grammarAccess.getBase64BinaryRule()); 
            pushFollow(FOLLOW_1);
            ruleBase64Binary();

            state._fsp--;

             after(grammarAccess.getBase64BinaryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBase64Binary"


    // $ANTLR start "ruleBase64Binary"
    // InternalBasicsParser.g:790:1: ruleBase64Binary : ( RULE_BINARY ) ;
    public final void ruleBase64Binary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:794:2: ( ( RULE_BINARY ) )
            // InternalBasicsParser.g:795:2: ( RULE_BINARY )
            {
            // InternalBasicsParser.g:795:2: ( RULE_BINARY )
            // InternalBasicsParser.g:796:3: RULE_BINARY
            {
             before(grammarAccess.getBase64BinaryAccess().getBINARYTerminalRuleCall()); 
            match(input,RULE_BINARY,FOLLOW_2); 
             after(grammarAccess.getBase64BinaryAccess().getBINARYTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBase64Binary"


    // $ANTLR start "entryRuleboolean0"
    // InternalBasicsParser.g:806:1: entryRuleboolean0 : ruleboolean0 EOF ;
    public final void entryRuleboolean0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:807:1: ( ruleboolean0 EOF )
            // InternalBasicsParser.g:808:1: ruleboolean0 EOF
            {
             before(grammarAccess.getBoolean0Rule()); 
            pushFollow(FOLLOW_1);
            ruleboolean0();

            state._fsp--;

             after(grammarAccess.getBoolean0Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleboolean0"


    // $ANTLR start "ruleboolean0"
    // InternalBasicsParser.g:815:1: ruleboolean0 : ( RULE_BOOLEAN ) ;
    public final void ruleboolean0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:819:2: ( ( RULE_BOOLEAN ) )
            // InternalBasicsParser.g:820:2: ( RULE_BOOLEAN )
            {
            // InternalBasicsParser.g:820:2: ( RULE_BOOLEAN )
            // InternalBasicsParser.g:821:3: RULE_BOOLEAN
            {
             before(grammarAccess.getBoolean0Access().getBOOLEANTerminalRuleCall()); 
            match(input,RULE_BOOLEAN,FOLLOW_2); 
             after(grammarAccess.getBoolean0Access().getBOOLEANTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleboolean0"


    // $ANTLR start "entryRuleDouble0"
    // InternalBasicsParser.g:831:1: entryRuleDouble0 : ruleDouble0 EOF ;
    public final void entryRuleDouble0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:832:1: ( ruleDouble0 EOF )
            // InternalBasicsParser.g:833:1: ruleDouble0 EOF
            {
             before(grammarAccess.getDouble0Rule()); 
            pushFollow(FOLLOW_1);
            ruleDouble0();

            state._fsp--;

             after(grammarAccess.getDouble0Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDouble0"


    // $ANTLR start "ruleDouble0"
    // InternalBasicsParser.g:840:1: ruleDouble0 : ( RULE_DOUBLE ) ;
    public final void ruleDouble0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:844:2: ( ( RULE_DOUBLE ) )
            // InternalBasicsParser.g:845:2: ( RULE_DOUBLE )
            {
            // InternalBasicsParser.g:845:2: ( RULE_DOUBLE )
            // InternalBasicsParser.g:846:3: RULE_DOUBLE
            {
             before(grammarAccess.getDouble0Access().getDOUBLETerminalRuleCall()); 
            match(input,RULE_DOUBLE,FOLLOW_2); 
             after(grammarAccess.getDouble0Access().getDOUBLETerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDouble0"


    // $ANTLR start "entryRuleInteger0"
    // InternalBasicsParser.g:856:1: entryRuleInteger0 : ruleInteger0 EOF ;
    public final void entryRuleInteger0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:857:1: ( ruleInteger0 EOF )
            // InternalBasicsParser.g:858:1: ruleInteger0 EOF
            {
             before(grammarAccess.getInteger0Rule()); 
            pushFollow(FOLLOW_1);
            ruleInteger0();

            state._fsp--;

             after(grammarAccess.getInteger0Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInteger0"


    // $ANTLR start "ruleInteger0"
    // InternalBasicsParser.g:865:1: ruleInteger0 : ( RULE_DECINT ) ;
    public final void ruleInteger0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:869:2: ( ( RULE_DECINT ) )
            // InternalBasicsParser.g:870:2: ( RULE_DECINT )
            {
            // InternalBasicsParser.g:870:2: ( RULE_DECINT )
            // InternalBasicsParser.g:871:3: RULE_DECINT
            {
             before(grammarAccess.getInteger0Access().getDECINTTerminalRuleCall()); 
            match(input,RULE_DECINT,FOLLOW_2); 
             after(grammarAccess.getInteger0Access().getDECINTTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInteger0"


    // $ANTLR start "entryRuleDateTime0"
    // InternalBasicsParser.g:881:1: entryRuleDateTime0 : ruleDateTime0 EOF ;
    public final void entryRuleDateTime0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:882:1: ( ruleDateTime0 EOF )
            // InternalBasicsParser.g:883:1: ruleDateTime0 EOF
            {
             before(grammarAccess.getDateTime0Rule()); 
            pushFollow(FOLLOW_1);
            ruleDateTime0();

            state._fsp--;

             after(grammarAccess.getDateTime0Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDateTime0"


    // $ANTLR start "ruleDateTime0"
    // InternalBasicsParser.g:890:1: ruleDateTime0 : ( RULE_DATE_TIME ) ;
    public final void ruleDateTime0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:894:2: ( ( RULE_DATE_TIME ) )
            // InternalBasicsParser.g:895:2: ( RULE_DATE_TIME )
            {
            // InternalBasicsParser.g:895:2: ( RULE_DATE_TIME )
            // InternalBasicsParser.g:896:3: RULE_DATE_TIME
            {
             before(grammarAccess.getDateTime0Access().getDATE_TIMETerminalRuleCall()); 
            match(input,RULE_DATE_TIME,FOLLOW_2); 
             after(grammarAccess.getDateTime0Access().getDATE_TIMETerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDateTime0"


    // $ANTLR start "entryRuleAbstractType"
    // InternalBasicsParser.g:906:1: entryRuleAbstractType : ruleAbstractType EOF ;
    public final void entryRuleAbstractType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:907:1: ( ruleAbstractType EOF )
            // InternalBasicsParser.g:908:1: ruleAbstractType EOF
            {
             before(grammarAccess.getAbstractTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractType();

            state._fsp--;

             after(grammarAccess.getAbstractTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractType"


    // $ANTLR start "ruleAbstractType"
    // InternalBasicsParser.g:915:1: ruleAbstractType : ( ( rule__AbstractType__Alternatives ) ) ;
    public final void ruleAbstractType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:919:2: ( ( ( rule__AbstractType__Alternatives ) ) )
            // InternalBasicsParser.g:920:2: ( ( rule__AbstractType__Alternatives ) )
            {
            // InternalBasicsParser.g:920:2: ( ( rule__AbstractType__Alternatives ) )
            // InternalBasicsParser.g:921:3: ( rule__AbstractType__Alternatives )
            {
             before(grammarAccess.getAbstractTypeAccess().getAlternatives()); 
            // InternalBasicsParser.g:922:3: ( rule__AbstractType__Alternatives )
            // InternalBasicsParser.g:922:4: rule__AbstractType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractType"


    // $ANTLR start "entryRulebool"
    // InternalBasicsParser.g:931:1: entryRulebool : rulebool EOF ;
    public final void entryRulebool() throws RecognitionException {
        try {
            // InternalBasicsParser.g:932:1: ( rulebool EOF )
            // InternalBasicsParser.g:933:1: rulebool EOF
            {
             before(grammarAccess.getBoolRule()); 
            pushFollow(FOLLOW_1);
            rulebool();

            state._fsp--;

             after(grammarAccess.getBoolRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulebool"


    // $ANTLR start "rulebool"
    // InternalBasicsParser.g:940:1: rulebool : ( ( rule__Bool__Group__0 ) ) ;
    public final void rulebool() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:944:2: ( ( ( rule__Bool__Group__0 ) ) )
            // InternalBasicsParser.g:945:2: ( ( rule__Bool__Group__0 ) )
            {
            // InternalBasicsParser.g:945:2: ( ( rule__Bool__Group__0 ) )
            // InternalBasicsParser.g:946:3: ( rule__Bool__Group__0 )
            {
             before(grammarAccess.getBoolAccess().getGroup()); 
            // InternalBasicsParser.g:947:3: ( rule__Bool__Group__0 )
            // InternalBasicsParser.g:947:4: rule__Bool__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Bool__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBoolAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulebool"


    // $ANTLR start "entryRuleint8"
    // InternalBasicsParser.g:956:1: entryRuleint8 : ruleint8 EOF ;
    public final void entryRuleint8() throws RecognitionException {
        try {
            // InternalBasicsParser.g:957:1: ( ruleint8 EOF )
            // InternalBasicsParser.g:958:1: ruleint8 EOF
            {
             before(grammarAccess.getInt8Rule()); 
            pushFollow(FOLLOW_1);
            ruleint8();

            state._fsp--;

             after(grammarAccess.getInt8Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint8"


    // $ANTLR start "ruleint8"
    // InternalBasicsParser.g:965:1: ruleint8 : ( ( rule__Int8__Group__0 ) ) ;
    public final void ruleint8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:969:2: ( ( ( rule__Int8__Group__0 ) ) )
            // InternalBasicsParser.g:970:2: ( ( rule__Int8__Group__0 ) )
            {
            // InternalBasicsParser.g:970:2: ( ( rule__Int8__Group__0 ) )
            // InternalBasicsParser.g:971:3: ( rule__Int8__Group__0 )
            {
             before(grammarAccess.getInt8Access().getGroup()); 
            // InternalBasicsParser.g:972:3: ( rule__Int8__Group__0 )
            // InternalBasicsParser.g:972:4: rule__Int8__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int8__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt8Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint8"


    // $ANTLR start "entryRuleuint8"
    // InternalBasicsParser.g:981:1: entryRuleuint8 : ruleuint8 EOF ;
    public final void entryRuleuint8() throws RecognitionException {
        try {
            // InternalBasicsParser.g:982:1: ( ruleuint8 EOF )
            // InternalBasicsParser.g:983:1: ruleuint8 EOF
            {
             before(grammarAccess.getUint8Rule()); 
            pushFollow(FOLLOW_1);
            ruleuint8();

            state._fsp--;

             after(grammarAccess.getUint8Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint8"


    // $ANTLR start "ruleuint8"
    // InternalBasicsParser.g:990:1: ruleuint8 : ( ( rule__Uint8__Group__0 ) ) ;
    public final void ruleuint8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:994:2: ( ( ( rule__Uint8__Group__0 ) ) )
            // InternalBasicsParser.g:995:2: ( ( rule__Uint8__Group__0 ) )
            {
            // InternalBasicsParser.g:995:2: ( ( rule__Uint8__Group__0 ) )
            // InternalBasicsParser.g:996:3: ( rule__Uint8__Group__0 )
            {
             before(grammarAccess.getUint8Access().getGroup()); 
            // InternalBasicsParser.g:997:3: ( rule__Uint8__Group__0 )
            // InternalBasicsParser.g:997:4: rule__Uint8__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint8__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint8Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint8"


    // $ANTLR start "entryRuleint16"
    // InternalBasicsParser.g:1006:1: entryRuleint16 : ruleint16 EOF ;
    public final void entryRuleint16() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1007:1: ( ruleint16 EOF )
            // InternalBasicsParser.g:1008:1: ruleint16 EOF
            {
             before(grammarAccess.getInt16Rule()); 
            pushFollow(FOLLOW_1);
            ruleint16();

            state._fsp--;

             after(grammarAccess.getInt16Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint16"


    // $ANTLR start "ruleint16"
    // InternalBasicsParser.g:1015:1: ruleint16 : ( ( rule__Int16__Group__0 ) ) ;
    public final void ruleint16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1019:2: ( ( ( rule__Int16__Group__0 ) ) )
            // InternalBasicsParser.g:1020:2: ( ( rule__Int16__Group__0 ) )
            {
            // InternalBasicsParser.g:1020:2: ( ( rule__Int16__Group__0 ) )
            // InternalBasicsParser.g:1021:3: ( rule__Int16__Group__0 )
            {
             before(grammarAccess.getInt16Access().getGroup()); 
            // InternalBasicsParser.g:1022:3: ( rule__Int16__Group__0 )
            // InternalBasicsParser.g:1022:4: rule__Int16__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int16__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt16Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint16"


    // $ANTLR start "entryRuleuint16"
    // InternalBasicsParser.g:1031:1: entryRuleuint16 : ruleuint16 EOF ;
    public final void entryRuleuint16() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1032:1: ( ruleuint16 EOF )
            // InternalBasicsParser.g:1033:1: ruleuint16 EOF
            {
             before(grammarAccess.getUint16Rule()); 
            pushFollow(FOLLOW_1);
            ruleuint16();

            state._fsp--;

             after(grammarAccess.getUint16Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint16"


    // $ANTLR start "ruleuint16"
    // InternalBasicsParser.g:1040:1: ruleuint16 : ( ( rule__Uint16__Group__0 ) ) ;
    public final void ruleuint16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1044:2: ( ( ( rule__Uint16__Group__0 ) ) )
            // InternalBasicsParser.g:1045:2: ( ( rule__Uint16__Group__0 ) )
            {
            // InternalBasicsParser.g:1045:2: ( ( rule__Uint16__Group__0 ) )
            // InternalBasicsParser.g:1046:3: ( rule__Uint16__Group__0 )
            {
             before(grammarAccess.getUint16Access().getGroup()); 
            // InternalBasicsParser.g:1047:3: ( rule__Uint16__Group__0 )
            // InternalBasicsParser.g:1047:4: rule__Uint16__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint16__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint16Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint16"


    // $ANTLR start "entryRuleint32"
    // InternalBasicsParser.g:1056:1: entryRuleint32 : ruleint32 EOF ;
    public final void entryRuleint32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1057:1: ( ruleint32 EOF )
            // InternalBasicsParser.g:1058:1: ruleint32 EOF
            {
             before(grammarAccess.getInt32Rule()); 
            pushFollow(FOLLOW_1);
            ruleint32();

            state._fsp--;

             after(grammarAccess.getInt32Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint32"


    // $ANTLR start "ruleint32"
    // InternalBasicsParser.g:1065:1: ruleint32 : ( ( rule__Int32__Group__0 ) ) ;
    public final void ruleint32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1069:2: ( ( ( rule__Int32__Group__0 ) ) )
            // InternalBasicsParser.g:1070:2: ( ( rule__Int32__Group__0 ) )
            {
            // InternalBasicsParser.g:1070:2: ( ( rule__Int32__Group__0 ) )
            // InternalBasicsParser.g:1071:3: ( rule__Int32__Group__0 )
            {
             before(grammarAccess.getInt32Access().getGroup()); 
            // InternalBasicsParser.g:1072:3: ( rule__Int32__Group__0 )
            // InternalBasicsParser.g:1072:4: rule__Int32__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int32__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt32Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint32"


    // $ANTLR start "entryRuleuint32"
    // InternalBasicsParser.g:1081:1: entryRuleuint32 : ruleuint32 EOF ;
    public final void entryRuleuint32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1082:1: ( ruleuint32 EOF )
            // InternalBasicsParser.g:1083:1: ruleuint32 EOF
            {
             before(grammarAccess.getUint32Rule()); 
            pushFollow(FOLLOW_1);
            ruleuint32();

            state._fsp--;

             after(grammarAccess.getUint32Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint32"


    // $ANTLR start "ruleuint32"
    // InternalBasicsParser.g:1090:1: ruleuint32 : ( ( rule__Uint32__Group__0 ) ) ;
    public final void ruleuint32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1094:2: ( ( ( rule__Uint32__Group__0 ) ) )
            // InternalBasicsParser.g:1095:2: ( ( rule__Uint32__Group__0 ) )
            {
            // InternalBasicsParser.g:1095:2: ( ( rule__Uint32__Group__0 ) )
            // InternalBasicsParser.g:1096:3: ( rule__Uint32__Group__0 )
            {
             before(grammarAccess.getUint32Access().getGroup()); 
            // InternalBasicsParser.g:1097:3: ( rule__Uint32__Group__0 )
            // InternalBasicsParser.g:1097:4: rule__Uint32__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint32__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint32Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint32"


    // $ANTLR start "entryRuleint64"
    // InternalBasicsParser.g:1106:1: entryRuleint64 : ruleint64 EOF ;
    public final void entryRuleint64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1107:1: ( ruleint64 EOF )
            // InternalBasicsParser.g:1108:1: ruleint64 EOF
            {
             before(grammarAccess.getInt64Rule()); 
            pushFollow(FOLLOW_1);
            ruleint64();

            state._fsp--;

             after(grammarAccess.getInt64Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint64"


    // $ANTLR start "ruleint64"
    // InternalBasicsParser.g:1115:1: ruleint64 : ( ( rule__Int64__Group__0 ) ) ;
    public final void ruleint64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1119:2: ( ( ( rule__Int64__Group__0 ) ) )
            // InternalBasicsParser.g:1120:2: ( ( rule__Int64__Group__0 ) )
            {
            // InternalBasicsParser.g:1120:2: ( ( rule__Int64__Group__0 ) )
            // InternalBasicsParser.g:1121:3: ( rule__Int64__Group__0 )
            {
             before(grammarAccess.getInt64Access().getGroup()); 
            // InternalBasicsParser.g:1122:3: ( rule__Int64__Group__0 )
            // InternalBasicsParser.g:1122:4: rule__Int64__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int64__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt64Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint64"


    // $ANTLR start "entryRuleuint64"
    // InternalBasicsParser.g:1131:1: entryRuleuint64 : ruleuint64 EOF ;
    public final void entryRuleuint64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1132:1: ( ruleuint64 EOF )
            // InternalBasicsParser.g:1133:1: ruleuint64 EOF
            {
             before(grammarAccess.getUint64Rule()); 
            pushFollow(FOLLOW_1);
            ruleuint64();

            state._fsp--;

             after(grammarAccess.getUint64Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint64"


    // $ANTLR start "ruleuint64"
    // InternalBasicsParser.g:1140:1: ruleuint64 : ( ( rule__Uint64__Group__0 ) ) ;
    public final void ruleuint64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1144:2: ( ( ( rule__Uint64__Group__0 ) ) )
            // InternalBasicsParser.g:1145:2: ( ( rule__Uint64__Group__0 ) )
            {
            // InternalBasicsParser.g:1145:2: ( ( rule__Uint64__Group__0 ) )
            // InternalBasicsParser.g:1146:3: ( rule__Uint64__Group__0 )
            {
             before(grammarAccess.getUint64Access().getGroup()); 
            // InternalBasicsParser.g:1147:3: ( rule__Uint64__Group__0 )
            // InternalBasicsParser.g:1147:4: rule__Uint64__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint64__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint64Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint64"


    // $ANTLR start "entryRulefloat32"
    // InternalBasicsParser.g:1156:1: entryRulefloat32 : rulefloat32 EOF ;
    public final void entryRulefloat32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1157:1: ( rulefloat32 EOF )
            // InternalBasicsParser.g:1158:1: rulefloat32 EOF
            {
             before(grammarAccess.getFloat32Rule()); 
            pushFollow(FOLLOW_1);
            rulefloat32();

            state._fsp--;

             after(grammarAccess.getFloat32Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulefloat32"


    // $ANTLR start "rulefloat32"
    // InternalBasicsParser.g:1165:1: rulefloat32 : ( ( rule__Float32__Group__0 ) ) ;
    public final void rulefloat32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1169:2: ( ( ( rule__Float32__Group__0 ) ) )
            // InternalBasicsParser.g:1170:2: ( ( rule__Float32__Group__0 ) )
            {
            // InternalBasicsParser.g:1170:2: ( ( rule__Float32__Group__0 ) )
            // InternalBasicsParser.g:1171:3: ( rule__Float32__Group__0 )
            {
             before(grammarAccess.getFloat32Access().getGroup()); 
            // InternalBasicsParser.g:1172:3: ( rule__Float32__Group__0 )
            // InternalBasicsParser.g:1172:4: rule__Float32__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Float32__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloat32Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulefloat32"


    // $ANTLR start "entryRulefloat64"
    // InternalBasicsParser.g:1181:1: entryRulefloat64 : rulefloat64 EOF ;
    public final void entryRulefloat64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1182:1: ( rulefloat64 EOF )
            // InternalBasicsParser.g:1183:1: rulefloat64 EOF
            {
             before(grammarAccess.getFloat64Rule()); 
            pushFollow(FOLLOW_1);
            rulefloat64();

            state._fsp--;

             after(grammarAccess.getFloat64Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulefloat64"


    // $ANTLR start "rulefloat64"
    // InternalBasicsParser.g:1190:1: rulefloat64 : ( ( rule__Float64__Group__0 ) ) ;
    public final void rulefloat64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1194:2: ( ( ( rule__Float64__Group__0 ) ) )
            // InternalBasicsParser.g:1195:2: ( ( rule__Float64__Group__0 ) )
            {
            // InternalBasicsParser.g:1195:2: ( ( rule__Float64__Group__0 ) )
            // InternalBasicsParser.g:1196:3: ( rule__Float64__Group__0 )
            {
             before(grammarAccess.getFloat64Access().getGroup()); 
            // InternalBasicsParser.g:1197:3: ( rule__Float64__Group__0 )
            // InternalBasicsParser.g:1197:4: rule__Float64__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Float64__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloat64Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulefloat64"


    // $ANTLR start "entryRulestring0"
    // InternalBasicsParser.g:1206:1: entryRulestring0 : rulestring0 EOF ;
    public final void entryRulestring0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1207:1: ( rulestring0 EOF )
            // InternalBasicsParser.g:1208:1: rulestring0 EOF
            {
             before(grammarAccess.getString0Rule()); 
            pushFollow(FOLLOW_1);
            rulestring0();

            state._fsp--;

             after(grammarAccess.getString0Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulestring0"


    // $ANTLR start "rulestring0"
    // InternalBasicsParser.g:1215:1: rulestring0 : ( ( rule__String0__Group__0 ) ) ;
    public final void rulestring0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1219:2: ( ( ( rule__String0__Group__0 ) ) )
            // InternalBasicsParser.g:1220:2: ( ( rule__String0__Group__0 ) )
            {
            // InternalBasicsParser.g:1220:2: ( ( rule__String0__Group__0 ) )
            // InternalBasicsParser.g:1221:3: ( rule__String0__Group__0 )
            {
             before(grammarAccess.getString0Access().getGroup()); 
            // InternalBasicsParser.g:1222:3: ( rule__String0__Group__0 )
            // InternalBasicsParser.g:1222:4: rule__String0__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__String0__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getString0Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulestring0"


    // $ANTLR start "entryRulechar"
    // InternalBasicsParser.g:1231:1: entryRulechar : rulechar EOF ;
    public final void entryRulechar() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1232:1: ( rulechar EOF )
            // InternalBasicsParser.g:1233:1: rulechar EOF
            {
             before(grammarAccess.getCharRule()); 
            pushFollow(FOLLOW_1);
            rulechar();

            state._fsp--;

             after(grammarAccess.getCharRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulechar"


    // $ANTLR start "rulechar"
    // InternalBasicsParser.g:1240:1: rulechar : ( ( rule__Char__Group__0 ) ) ;
    public final void rulechar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1244:2: ( ( ( rule__Char__Group__0 ) ) )
            // InternalBasicsParser.g:1245:2: ( ( rule__Char__Group__0 ) )
            {
            // InternalBasicsParser.g:1245:2: ( ( rule__Char__Group__0 ) )
            // InternalBasicsParser.g:1246:3: ( rule__Char__Group__0 )
            {
             before(grammarAccess.getCharAccess().getGroup()); 
            // InternalBasicsParser.g:1247:3: ( rule__Char__Group__0 )
            // InternalBasicsParser.g:1247:4: rule__Char__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Char__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCharAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulechar"


    // $ANTLR start "entryRulebyte"
    // InternalBasicsParser.g:1256:1: entryRulebyte : rulebyte EOF ;
    public final void entryRulebyte() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1257:1: ( rulebyte EOF )
            // InternalBasicsParser.g:1258:1: rulebyte EOF
            {
             before(grammarAccess.getByteRule()); 
            pushFollow(FOLLOW_1);
            rulebyte();

            state._fsp--;

             after(grammarAccess.getByteRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulebyte"


    // $ANTLR start "rulebyte"
    // InternalBasicsParser.g:1265:1: rulebyte : ( ( rule__Byte__Group__0 ) ) ;
    public final void rulebyte() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1269:2: ( ( ( rule__Byte__Group__0 ) ) )
            // InternalBasicsParser.g:1270:2: ( ( rule__Byte__Group__0 ) )
            {
            // InternalBasicsParser.g:1270:2: ( ( rule__Byte__Group__0 ) )
            // InternalBasicsParser.g:1271:3: ( rule__Byte__Group__0 )
            {
             before(grammarAccess.getByteAccess().getGroup()); 
            // InternalBasicsParser.g:1272:3: ( rule__Byte__Group__0 )
            // InternalBasicsParser.g:1272:4: rule__Byte__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Byte__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getByteAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulebyte"


    // $ANTLR start "entryRuletime"
    // InternalBasicsParser.g:1281:1: entryRuletime : ruletime EOF ;
    public final void entryRuletime() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1282:1: ( ruletime EOF )
            // InternalBasicsParser.g:1283:1: ruletime EOF
            {
             before(grammarAccess.getTimeRule()); 
            pushFollow(FOLLOW_1);
            ruletime();

            state._fsp--;

             after(grammarAccess.getTimeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuletime"


    // $ANTLR start "ruletime"
    // InternalBasicsParser.g:1290:1: ruletime : ( ( rule__Time__Group__0 ) ) ;
    public final void ruletime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1294:2: ( ( ( rule__Time__Group__0 ) ) )
            // InternalBasicsParser.g:1295:2: ( ( rule__Time__Group__0 ) )
            {
            // InternalBasicsParser.g:1295:2: ( ( rule__Time__Group__0 ) )
            // InternalBasicsParser.g:1296:3: ( rule__Time__Group__0 )
            {
             before(grammarAccess.getTimeAccess().getGroup()); 
            // InternalBasicsParser.g:1297:3: ( rule__Time__Group__0 )
            // InternalBasicsParser.g:1297:4: rule__Time__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Time__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruletime"


    // $ANTLR start "entryRuleduration"
    // InternalBasicsParser.g:1306:1: entryRuleduration : ruleduration EOF ;
    public final void entryRuleduration() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1307:1: ( ruleduration EOF )
            // InternalBasicsParser.g:1308:1: ruleduration EOF
            {
             before(grammarAccess.getDurationRule()); 
            pushFollow(FOLLOW_1);
            ruleduration();

            state._fsp--;

             after(grammarAccess.getDurationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleduration"


    // $ANTLR start "ruleduration"
    // InternalBasicsParser.g:1315:1: ruleduration : ( ( rule__Duration__Group__0 ) ) ;
    public final void ruleduration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1319:2: ( ( ( rule__Duration__Group__0 ) ) )
            // InternalBasicsParser.g:1320:2: ( ( rule__Duration__Group__0 ) )
            {
            // InternalBasicsParser.g:1320:2: ( ( rule__Duration__Group__0 ) )
            // InternalBasicsParser.g:1321:3: ( rule__Duration__Group__0 )
            {
             before(grammarAccess.getDurationAccess().getGroup()); 
            // InternalBasicsParser.g:1322:3: ( rule__Duration__Group__0 )
            // InternalBasicsParser.g:1322:4: rule__Duration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Duration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDurationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleduration"


    // $ANTLR start "entryRuleboolArray"
    // InternalBasicsParser.g:1331:1: entryRuleboolArray : ruleboolArray EOF ;
    public final void entryRuleboolArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1332:1: ( ruleboolArray EOF )
            // InternalBasicsParser.g:1333:1: ruleboolArray EOF
            {
             before(grammarAccess.getBoolArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleboolArray();

            state._fsp--;

             after(grammarAccess.getBoolArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleboolArray"


    // $ANTLR start "ruleboolArray"
    // InternalBasicsParser.g:1340:1: ruleboolArray : ( ( rule__BoolArray__Group__0 ) ) ;
    public final void ruleboolArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1344:2: ( ( ( rule__BoolArray__Group__0 ) ) )
            // InternalBasicsParser.g:1345:2: ( ( rule__BoolArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1345:2: ( ( rule__BoolArray__Group__0 ) )
            // InternalBasicsParser.g:1346:3: ( rule__BoolArray__Group__0 )
            {
             before(grammarAccess.getBoolArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1347:3: ( rule__BoolArray__Group__0 )
            // InternalBasicsParser.g:1347:4: rule__BoolArray__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BoolArray__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBoolArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleboolArray"


    // $ANTLR start "entryRuleint8Array"
    // InternalBasicsParser.g:1356:1: entryRuleint8Array : ruleint8Array EOF ;
    public final void entryRuleint8Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1357:1: ( ruleint8Array EOF )
            // InternalBasicsParser.g:1358:1: ruleint8Array EOF
            {
             before(grammarAccess.getInt8ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleint8Array();

            state._fsp--;

             after(grammarAccess.getInt8ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint8Array"


    // $ANTLR start "ruleint8Array"
    // InternalBasicsParser.g:1365:1: ruleint8Array : ( ( rule__Int8Array__Group__0 ) ) ;
    public final void ruleint8Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1369:2: ( ( ( rule__Int8Array__Group__0 ) ) )
            // InternalBasicsParser.g:1370:2: ( ( rule__Int8Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1370:2: ( ( rule__Int8Array__Group__0 ) )
            // InternalBasicsParser.g:1371:3: ( rule__Int8Array__Group__0 )
            {
             before(grammarAccess.getInt8ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1372:3: ( rule__Int8Array__Group__0 )
            // InternalBasicsParser.g:1372:4: rule__Int8Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int8Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt8ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint8Array"


    // $ANTLR start "entryRuleuint8Array"
    // InternalBasicsParser.g:1381:1: entryRuleuint8Array : ruleuint8Array EOF ;
    public final void entryRuleuint8Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1382:1: ( ruleuint8Array EOF )
            // InternalBasicsParser.g:1383:1: ruleuint8Array EOF
            {
             before(grammarAccess.getUint8ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleuint8Array();

            state._fsp--;

             after(grammarAccess.getUint8ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint8Array"


    // $ANTLR start "ruleuint8Array"
    // InternalBasicsParser.g:1390:1: ruleuint8Array : ( ( rule__Uint8Array__Group__0 ) ) ;
    public final void ruleuint8Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1394:2: ( ( ( rule__Uint8Array__Group__0 ) ) )
            // InternalBasicsParser.g:1395:2: ( ( rule__Uint8Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1395:2: ( ( rule__Uint8Array__Group__0 ) )
            // InternalBasicsParser.g:1396:3: ( rule__Uint8Array__Group__0 )
            {
             before(grammarAccess.getUint8ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1397:3: ( rule__Uint8Array__Group__0 )
            // InternalBasicsParser.g:1397:4: rule__Uint8Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint8Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint8ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint8Array"


    // $ANTLR start "entryRuleint16Array"
    // InternalBasicsParser.g:1406:1: entryRuleint16Array : ruleint16Array EOF ;
    public final void entryRuleint16Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1407:1: ( ruleint16Array EOF )
            // InternalBasicsParser.g:1408:1: ruleint16Array EOF
            {
             before(grammarAccess.getInt16ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleint16Array();

            state._fsp--;

             after(grammarAccess.getInt16ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint16Array"


    // $ANTLR start "ruleint16Array"
    // InternalBasicsParser.g:1415:1: ruleint16Array : ( ( rule__Int16Array__Group__0 ) ) ;
    public final void ruleint16Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1419:2: ( ( ( rule__Int16Array__Group__0 ) ) )
            // InternalBasicsParser.g:1420:2: ( ( rule__Int16Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1420:2: ( ( rule__Int16Array__Group__0 ) )
            // InternalBasicsParser.g:1421:3: ( rule__Int16Array__Group__0 )
            {
             before(grammarAccess.getInt16ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1422:3: ( rule__Int16Array__Group__0 )
            // InternalBasicsParser.g:1422:4: rule__Int16Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int16Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt16ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint16Array"


    // $ANTLR start "entryRuleuint16Array"
    // InternalBasicsParser.g:1431:1: entryRuleuint16Array : ruleuint16Array EOF ;
    public final void entryRuleuint16Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1432:1: ( ruleuint16Array EOF )
            // InternalBasicsParser.g:1433:1: ruleuint16Array EOF
            {
             before(grammarAccess.getUint16ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleuint16Array();

            state._fsp--;

             after(grammarAccess.getUint16ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint16Array"


    // $ANTLR start "ruleuint16Array"
    // InternalBasicsParser.g:1440:1: ruleuint16Array : ( ( rule__Uint16Array__Group__0 ) ) ;
    public final void ruleuint16Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1444:2: ( ( ( rule__Uint16Array__Group__0 ) ) )
            // InternalBasicsParser.g:1445:2: ( ( rule__Uint16Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1445:2: ( ( rule__Uint16Array__Group__0 ) )
            // InternalBasicsParser.g:1446:3: ( rule__Uint16Array__Group__0 )
            {
             before(grammarAccess.getUint16ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1447:3: ( rule__Uint16Array__Group__0 )
            // InternalBasicsParser.g:1447:4: rule__Uint16Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint16Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint16ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint16Array"


    // $ANTLR start "entryRuleint32Array"
    // InternalBasicsParser.g:1456:1: entryRuleint32Array : ruleint32Array EOF ;
    public final void entryRuleint32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1457:1: ( ruleint32Array EOF )
            // InternalBasicsParser.g:1458:1: ruleint32Array EOF
            {
             before(grammarAccess.getInt32ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleint32Array();

            state._fsp--;

             after(grammarAccess.getInt32ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint32Array"


    // $ANTLR start "ruleint32Array"
    // InternalBasicsParser.g:1465:1: ruleint32Array : ( ( rule__Int32Array__Group__0 ) ) ;
    public final void ruleint32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1469:2: ( ( ( rule__Int32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1470:2: ( ( rule__Int32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1470:2: ( ( rule__Int32Array__Group__0 ) )
            // InternalBasicsParser.g:1471:3: ( rule__Int32Array__Group__0 )
            {
             before(grammarAccess.getInt32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1472:3: ( rule__Int32Array__Group__0 )
            // InternalBasicsParser.g:1472:4: rule__Int32Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int32Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt32ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint32Array"


    // $ANTLR start "entryRuleuint32Array"
    // InternalBasicsParser.g:1481:1: entryRuleuint32Array : ruleuint32Array EOF ;
    public final void entryRuleuint32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1482:1: ( ruleuint32Array EOF )
            // InternalBasicsParser.g:1483:1: ruleuint32Array EOF
            {
             before(grammarAccess.getUint32ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleuint32Array();

            state._fsp--;

             after(grammarAccess.getUint32ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint32Array"


    // $ANTLR start "ruleuint32Array"
    // InternalBasicsParser.g:1490:1: ruleuint32Array : ( ( rule__Uint32Array__Group__0 ) ) ;
    public final void ruleuint32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1494:2: ( ( ( rule__Uint32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1495:2: ( ( rule__Uint32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1495:2: ( ( rule__Uint32Array__Group__0 ) )
            // InternalBasicsParser.g:1496:3: ( rule__Uint32Array__Group__0 )
            {
             before(grammarAccess.getUint32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1497:3: ( rule__Uint32Array__Group__0 )
            // InternalBasicsParser.g:1497:4: rule__Uint32Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint32Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint32ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint32Array"


    // $ANTLR start "entryRuleint64Array"
    // InternalBasicsParser.g:1506:1: entryRuleint64Array : ruleint64Array EOF ;
    public final void entryRuleint64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1507:1: ( ruleint64Array EOF )
            // InternalBasicsParser.g:1508:1: ruleint64Array EOF
            {
             before(grammarAccess.getInt64ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleint64Array();

            state._fsp--;

             after(grammarAccess.getInt64ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleint64Array"


    // $ANTLR start "ruleint64Array"
    // InternalBasicsParser.g:1515:1: ruleint64Array : ( ( rule__Int64Array__Group__0 ) ) ;
    public final void ruleint64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1519:2: ( ( ( rule__Int64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1520:2: ( ( rule__Int64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1520:2: ( ( rule__Int64Array__Group__0 ) )
            // InternalBasicsParser.g:1521:3: ( rule__Int64Array__Group__0 )
            {
             before(grammarAccess.getInt64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1522:3: ( rule__Int64Array__Group__0 )
            // InternalBasicsParser.g:1522:4: rule__Int64Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Int64Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInt64ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleint64Array"


    // $ANTLR start "entryRuleuint64Array"
    // InternalBasicsParser.g:1531:1: entryRuleuint64Array : ruleuint64Array EOF ;
    public final void entryRuleuint64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1532:1: ( ruleuint64Array EOF )
            // InternalBasicsParser.g:1533:1: ruleuint64Array EOF
            {
             before(grammarAccess.getUint64ArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleuint64Array();

            state._fsp--;

             after(grammarAccess.getUint64ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleuint64Array"


    // $ANTLR start "ruleuint64Array"
    // InternalBasicsParser.g:1540:1: ruleuint64Array : ( ( rule__Uint64Array__Group__0 ) ) ;
    public final void ruleuint64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1544:2: ( ( ( rule__Uint64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1545:2: ( ( rule__Uint64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1545:2: ( ( rule__Uint64Array__Group__0 ) )
            // InternalBasicsParser.g:1546:3: ( rule__Uint64Array__Group__0 )
            {
             before(grammarAccess.getUint64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1547:3: ( rule__Uint64Array__Group__0 )
            // InternalBasicsParser.g:1547:4: rule__Uint64Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Uint64Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUint64ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleuint64Array"


    // $ANTLR start "entryRulefloat32Array"
    // InternalBasicsParser.g:1556:1: entryRulefloat32Array : rulefloat32Array EOF ;
    public final void entryRulefloat32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1557:1: ( rulefloat32Array EOF )
            // InternalBasicsParser.g:1558:1: rulefloat32Array EOF
            {
             before(grammarAccess.getFloat32ArrayRule()); 
            pushFollow(FOLLOW_1);
            rulefloat32Array();

            state._fsp--;

             after(grammarAccess.getFloat32ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulefloat32Array"


    // $ANTLR start "rulefloat32Array"
    // InternalBasicsParser.g:1565:1: rulefloat32Array : ( ( rule__Float32Array__Group__0 ) ) ;
    public final void rulefloat32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1569:2: ( ( ( rule__Float32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1570:2: ( ( rule__Float32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1570:2: ( ( rule__Float32Array__Group__0 ) )
            // InternalBasicsParser.g:1571:3: ( rule__Float32Array__Group__0 )
            {
             before(grammarAccess.getFloat32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1572:3: ( rule__Float32Array__Group__0 )
            // InternalBasicsParser.g:1572:4: rule__Float32Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Float32Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloat32ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulefloat32Array"


    // $ANTLR start "entryRulefloat64Array"
    // InternalBasicsParser.g:1581:1: entryRulefloat64Array : rulefloat64Array EOF ;
    public final void entryRulefloat64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1582:1: ( rulefloat64Array EOF )
            // InternalBasicsParser.g:1583:1: rulefloat64Array EOF
            {
             before(grammarAccess.getFloat64ArrayRule()); 
            pushFollow(FOLLOW_1);
            rulefloat64Array();

            state._fsp--;

             after(grammarAccess.getFloat64ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulefloat64Array"


    // $ANTLR start "rulefloat64Array"
    // InternalBasicsParser.g:1590:1: rulefloat64Array : ( ( rule__Float64Array__Group__0 ) ) ;
    public final void rulefloat64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1594:2: ( ( ( rule__Float64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1595:2: ( ( rule__Float64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1595:2: ( ( rule__Float64Array__Group__0 ) )
            // InternalBasicsParser.g:1596:3: ( rule__Float64Array__Group__0 )
            {
             before(grammarAccess.getFloat64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1597:3: ( rule__Float64Array__Group__0 )
            // InternalBasicsParser.g:1597:4: rule__Float64Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Float64Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloat64ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulefloat64Array"


    // $ANTLR start "entryRulestring0Array"
    // InternalBasicsParser.g:1606:1: entryRulestring0Array : rulestring0Array EOF ;
    public final void entryRulestring0Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1607:1: ( rulestring0Array EOF )
            // InternalBasicsParser.g:1608:1: rulestring0Array EOF
            {
             before(grammarAccess.getString0ArrayRule()); 
            pushFollow(FOLLOW_1);
            rulestring0Array();

            state._fsp--;

             after(grammarAccess.getString0ArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulestring0Array"


    // $ANTLR start "rulestring0Array"
    // InternalBasicsParser.g:1615:1: rulestring0Array : ( ( rule__String0Array__Group__0 ) ) ;
    public final void rulestring0Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1619:2: ( ( ( rule__String0Array__Group__0 ) ) )
            // InternalBasicsParser.g:1620:2: ( ( rule__String0Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1620:2: ( ( rule__String0Array__Group__0 ) )
            // InternalBasicsParser.g:1621:3: ( rule__String0Array__Group__0 )
            {
             before(grammarAccess.getString0ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1622:3: ( rule__String0Array__Group__0 )
            // InternalBasicsParser.g:1622:4: rule__String0Array__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__String0Array__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getString0ArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulestring0Array"


    // $ANTLR start "entryRulebyteArray"
    // InternalBasicsParser.g:1631:1: entryRulebyteArray : rulebyteArray EOF ;
    public final void entryRulebyteArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1632:1: ( rulebyteArray EOF )
            // InternalBasicsParser.g:1633:1: rulebyteArray EOF
            {
             before(grammarAccess.getByteArrayRule()); 
            pushFollow(FOLLOW_1);
            rulebyteArray();

            state._fsp--;

             after(grammarAccess.getByteArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulebyteArray"


    // $ANTLR start "rulebyteArray"
    // InternalBasicsParser.g:1640:1: rulebyteArray : ( ( rule__ByteArray__Group__0 ) ) ;
    public final void rulebyteArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1644:2: ( ( ( rule__ByteArray__Group__0 ) ) )
            // InternalBasicsParser.g:1645:2: ( ( rule__ByteArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1645:2: ( ( rule__ByteArray__Group__0 ) )
            // InternalBasicsParser.g:1646:3: ( rule__ByteArray__Group__0 )
            {
             before(grammarAccess.getByteArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1647:3: ( rule__ByteArray__Group__0 )
            // InternalBasicsParser.g:1647:4: rule__ByteArray__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ByteArray__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getByteArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulebyteArray"


    // $ANTLR start "entryRulecharArray"
    // InternalBasicsParser.g:1656:1: entryRulecharArray : rulecharArray EOF ;
    public final void entryRulecharArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1657:1: ( rulecharArray EOF )
            // InternalBasicsParser.g:1658:1: rulecharArray EOF
            {
             before(grammarAccess.getCharArrayRule()); 
            pushFollow(FOLLOW_1);
            rulecharArray();

            state._fsp--;

             after(grammarAccess.getCharArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulecharArray"


    // $ANTLR start "rulecharArray"
    // InternalBasicsParser.g:1665:1: rulecharArray : ( ( rule__CharArray__Group__0 ) ) ;
    public final void rulecharArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1669:2: ( ( ( rule__CharArray__Group__0 ) ) )
            // InternalBasicsParser.g:1670:2: ( ( rule__CharArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1670:2: ( ( rule__CharArray__Group__0 ) )
            // InternalBasicsParser.g:1671:3: ( rule__CharArray__Group__0 )
            {
             before(grammarAccess.getCharArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1672:3: ( rule__CharArray__Group__0 )
            // InternalBasicsParser.g:1672:4: rule__CharArray__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CharArray__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCharArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulecharArray"


    // $ANTLR start "entryRuleHeader"
    // InternalBasicsParser.g:1681:1: entryRuleHeader : ruleHeader EOF ;
    public final void entryRuleHeader() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1682:1: ( ruleHeader EOF )
            // InternalBasicsParser.g:1683:1: ruleHeader EOF
            {
             before(grammarAccess.getHeaderRule()); 
            pushFollow(FOLLOW_1);
            ruleHeader();

            state._fsp--;

             after(grammarAccess.getHeaderRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHeader"


    // $ANTLR start "ruleHeader"
    // InternalBasicsParser.g:1690:1: ruleHeader : ( ( rule__Header__Group__0 ) ) ;
    public final void ruleHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1694:2: ( ( ( rule__Header__Group__0 ) ) )
            // InternalBasicsParser.g:1695:2: ( ( rule__Header__Group__0 ) )
            {
            // InternalBasicsParser.g:1695:2: ( ( rule__Header__Group__0 ) )
            // InternalBasicsParser.g:1696:3: ( rule__Header__Group__0 )
            {
             before(grammarAccess.getHeaderAccess().getGroup()); 
            // InternalBasicsParser.g:1697:3: ( rule__Header__Group__0 )
            // InternalBasicsParser.g:1697:4: rule__Header__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Header__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHeaderAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHeader"


    // $ANTLR start "entryRuleSpecBaseRef"
    // InternalBasicsParser.g:1706:1: entryRuleSpecBaseRef : ruleSpecBaseRef EOF ;
    public final void entryRuleSpecBaseRef() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1707:1: ( ruleSpecBaseRef EOF )
            // InternalBasicsParser.g:1708:1: ruleSpecBaseRef EOF
            {
             before(grammarAccess.getSpecBaseRefRule()); 
            pushFollow(FOLLOW_1);
            ruleSpecBaseRef();

            state._fsp--;

             after(grammarAccess.getSpecBaseRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSpecBaseRef"


    // $ANTLR start "ruleSpecBaseRef"
    // InternalBasicsParser.g:1715:1: ruleSpecBaseRef : ( ( rule__SpecBaseRef__ReferenceAssignment ) ) ;
    public final void ruleSpecBaseRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1719:2: ( ( ( rule__SpecBaseRef__ReferenceAssignment ) ) )
            // InternalBasicsParser.g:1720:2: ( ( rule__SpecBaseRef__ReferenceAssignment ) )
            {
            // InternalBasicsParser.g:1720:2: ( ( rule__SpecBaseRef__ReferenceAssignment ) )
            // InternalBasicsParser.g:1721:3: ( rule__SpecBaseRef__ReferenceAssignment )
            {
             before(grammarAccess.getSpecBaseRefAccess().getReferenceAssignment()); 
            // InternalBasicsParser.g:1722:3: ( rule__SpecBaseRef__ReferenceAssignment )
            // InternalBasicsParser.g:1722:4: rule__SpecBaseRef__ReferenceAssignment
            {
            pushFollow(FOLLOW_2);
            rule__SpecBaseRef__ReferenceAssignment();

            state._fsp--;


            }

             after(grammarAccess.getSpecBaseRefAccess().getReferenceAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpecBaseRef"


    // $ANTLR start "entryRuleArraySpecRef"
    // InternalBasicsParser.g:1731:1: entryRuleArraySpecRef : ruleArraySpecRef EOF ;
    public final void entryRuleArraySpecRef() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1732:1: ( ruleArraySpecRef EOF )
            // InternalBasicsParser.g:1733:1: ruleArraySpecRef EOF
            {
             before(grammarAccess.getArraySpecRefRule()); 
            pushFollow(FOLLOW_1);
            ruleArraySpecRef();

            state._fsp--;

             after(grammarAccess.getArraySpecRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArraySpecRef"


    // $ANTLR start "ruleArraySpecRef"
    // InternalBasicsParser.g:1740:1: ruleArraySpecRef : ( ( rule__ArraySpecRef__Group__0 ) ) ;
    public final void ruleArraySpecRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1744:2: ( ( ( rule__ArraySpecRef__Group__0 ) ) )
            // InternalBasicsParser.g:1745:2: ( ( rule__ArraySpecRef__Group__0 ) )
            {
            // InternalBasicsParser.g:1745:2: ( ( rule__ArraySpecRef__Group__0 ) )
            // InternalBasicsParser.g:1746:3: ( rule__ArraySpecRef__Group__0 )
            {
             before(grammarAccess.getArraySpecRefAccess().getGroup()); 
            // InternalBasicsParser.g:1747:3: ( rule__ArraySpecRef__Group__0 )
            // InternalBasicsParser.g:1747:4: rule__ArraySpecRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArraySpecRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArraySpecRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArraySpecRef"


    // $ANTLR start "entryRuleKEYWORD"
    // InternalBasicsParser.g:1756:1: entryRuleKEYWORD : ruleKEYWORD EOF ;
    public final void entryRuleKEYWORD() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1757:1: ( ruleKEYWORD EOF )
            // InternalBasicsParser.g:1758:1: ruleKEYWORD EOF
            {
             before(grammarAccess.getKEYWORDRule()); 
            pushFollow(FOLLOW_1);
            ruleKEYWORD();

            state._fsp--;

             after(grammarAccess.getKEYWORDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKEYWORD"


    // $ANTLR start "ruleKEYWORD"
    // InternalBasicsParser.g:1765:1: ruleKEYWORD : ( ( rule__KEYWORD__Alternatives ) ) ;
    public final void ruleKEYWORD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1769:2: ( ( ( rule__KEYWORD__Alternatives ) ) )
            // InternalBasicsParser.g:1770:2: ( ( rule__KEYWORD__Alternatives ) )
            {
            // InternalBasicsParser.g:1770:2: ( ( rule__KEYWORD__Alternatives ) )
            // InternalBasicsParser.g:1771:3: ( rule__KEYWORD__Alternatives )
            {
             before(grammarAccess.getKEYWORDAccess().getAlternatives()); 
            // InternalBasicsParser.g:1772:3: ( rule__KEYWORD__Alternatives )
            // InternalBasicsParser.g:1772:4: rule__KEYWORD__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__KEYWORD__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getKEYWORDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKEYWORD"


    // $ANTLR start "entryRuleEString"
    // InternalBasicsParser.g:1781:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1782:1: ( ruleEString EOF )
            // InternalBasicsParser.g:1783:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalBasicsParser.g:1790:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1794:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalBasicsParser.g:1795:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalBasicsParser.g:1795:2: ( ( rule__EString__Alternatives ) )
            // InternalBasicsParser.g:1796:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalBasicsParser.g:1797:3: ( rule__EString__Alternatives )
            // InternalBasicsParser.g:1797:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleExtensionBlockName"
    // InternalBasicsParser.g:1806:1: entryRuleExtensionBlockName : ruleExtensionBlockName EOF ;
    public final void entryRuleExtensionBlockName() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1807:1: ( ruleExtensionBlockName EOF )
            // InternalBasicsParser.g:1808:1: ruleExtensionBlockName EOF
            {
             before(grammarAccess.getExtensionBlockNameRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionBlockName();

            state._fsp--;

             after(grammarAccess.getExtensionBlockNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionBlockName"


    // $ANTLR start "ruleExtensionBlockName"
    // InternalBasicsParser.g:1815:1: ruleExtensionBlockName : ( ( rule__ExtensionBlockName__Group__0 ) ) ;
    public final void ruleExtensionBlockName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1819:2: ( ( ( rule__ExtensionBlockName__Group__0 ) ) )
            // InternalBasicsParser.g:1820:2: ( ( rule__ExtensionBlockName__Group__0 ) )
            {
            // InternalBasicsParser.g:1820:2: ( ( rule__ExtensionBlockName__Group__0 ) )
            // InternalBasicsParser.g:1821:3: ( rule__ExtensionBlockName__Group__0 )
            {
             before(grammarAccess.getExtensionBlockNameAccess().getGroup()); 
            // InternalBasicsParser.g:1822:3: ( rule__ExtensionBlockName__Group__0 )
            // InternalBasicsParser.g:1822:4: rule__ExtensionBlockName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBlockName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionBlockNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionBlockName"


    // $ANTLR start "entryRuleExtensionEntry"
    // InternalBasicsParser.g:1831:1: entryRuleExtensionEntry : ruleExtensionEntry EOF ;
    public final void entryRuleExtensionEntry() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1832:1: ( ruleExtensionEntry EOF )
            // InternalBasicsParser.g:1833:1: ruleExtensionEntry EOF
            {
             before(grammarAccess.getExtensionEntryRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionEntry();

            state._fsp--;

             after(grammarAccess.getExtensionEntryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionEntry"


    // $ANTLR start "ruleExtensionEntry"
    // InternalBasicsParser.g:1840:1: ruleExtensionEntry : ( ( rule__ExtensionEntry__Group__0 ) ) ;
    public final void ruleExtensionEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1844:2: ( ( ( rule__ExtensionEntry__Group__0 ) ) )
            // InternalBasicsParser.g:1845:2: ( ( rule__ExtensionEntry__Group__0 ) )
            {
            // InternalBasicsParser.g:1845:2: ( ( rule__ExtensionEntry__Group__0 ) )
            // InternalBasicsParser.g:1846:3: ( rule__ExtensionEntry__Group__0 )
            {
             before(grammarAccess.getExtensionEntryAccess().getGroup()); 
            // InternalBasicsParser.g:1847:3: ( rule__ExtensionEntry__Group__0 )
            // InternalBasicsParser.g:1847:4: rule__ExtensionEntry__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionEntryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionEntry"


    // $ANTLR start "entryRuleExtensionKey"
    // InternalBasicsParser.g:1856:1: entryRuleExtensionKey : ruleExtensionKey EOF ;
    public final void entryRuleExtensionKey() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1857:1: ( ruleExtensionKey EOF )
            // InternalBasicsParser.g:1858:1: ruleExtensionKey EOF
            {
             before(grammarAccess.getExtensionKeyRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionKey();

            state._fsp--;

             after(grammarAccess.getExtensionKeyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionKey"


    // $ANTLR start "ruleExtensionKey"
    // InternalBasicsParser.g:1865:1: ruleExtensionKey : ( ( rule__ExtensionKey__Alternatives ) ) ;
    public final void ruleExtensionKey() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1869:2: ( ( ( rule__ExtensionKey__Alternatives ) ) )
            // InternalBasicsParser.g:1870:2: ( ( rule__ExtensionKey__Alternatives ) )
            {
            // InternalBasicsParser.g:1870:2: ( ( rule__ExtensionKey__Alternatives ) )
            // InternalBasicsParser.g:1871:3: ( rule__ExtensionKey__Alternatives )
            {
             before(grammarAccess.getExtensionKeyAccess().getAlternatives()); 
            // InternalBasicsParser.g:1872:3: ( rule__ExtensionKey__Alternatives )
            // InternalBasicsParser.g:1872:4: rule__ExtensionKey__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionKey__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExtensionKeyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionKey"


    // $ANTLR start "entryRuleExtensionColonKey"
    // InternalBasicsParser.g:1881:1: entryRuleExtensionColonKey : ruleExtensionColonKey EOF ;
    public final void entryRuleExtensionColonKey() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1882:1: ( ruleExtensionColonKey EOF )
            // InternalBasicsParser.g:1883:1: ruleExtensionColonKey EOF
            {
             before(grammarAccess.getExtensionColonKeyRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionColonKey();

            state._fsp--;

             after(grammarAccess.getExtensionColonKeyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionColonKey"


    // $ANTLR start "ruleExtensionColonKey"
    // InternalBasicsParser.g:1890:1: ruleExtensionColonKey : ( ( rule__ExtensionColonKey__Alternatives ) ) ;
    public final void ruleExtensionColonKey() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1894:2: ( ( ( rule__ExtensionColonKey__Alternatives ) ) )
            // InternalBasicsParser.g:1895:2: ( ( rule__ExtensionColonKey__Alternatives ) )
            {
            // InternalBasicsParser.g:1895:2: ( ( rule__ExtensionColonKey__Alternatives ) )
            // InternalBasicsParser.g:1896:3: ( rule__ExtensionColonKey__Alternatives )
            {
             before(grammarAccess.getExtensionColonKeyAccess().getAlternatives()); 
            // InternalBasicsParser.g:1897:3: ( rule__ExtensionColonKey__Alternatives )
            // InternalBasicsParser.g:1897:4: rule__ExtensionColonKey__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionColonKey__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExtensionColonKeyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionColonKey"


    // $ANTLR start "entryRuleExtensionValue"
    // InternalBasicsParser.g:1906:1: entryRuleExtensionValue : ruleExtensionValue EOF ;
    public final void entryRuleExtensionValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1907:1: ( ruleExtensionValue EOF )
            // InternalBasicsParser.g:1908:1: ruleExtensionValue EOF
            {
             before(grammarAccess.getExtensionValueRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionValue();

            state._fsp--;

             after(grammarAccess.getExtensionValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionValue"


    // $ANTLR start "ruleExtensionValue"
    // InternalBasicsParser.g:1915:1: ruleExtensionValue : ( ( rule__ExtensionValue__Alternatives ) ) ;
    public final void ruleExtensionValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1919:2: ( ( ( rule__ExtensionValue__Alternatives ) ) )
            // InternalBasicsParser.g:1920:2: ( ( rule__ExtensionValue__Alternatives ) )
            {
            // InternalBasicsParser.g:1920:2: ( ( rule__ExtensionValue__Alternatives ) )
            // InternalBasicsParser.g:1921:3: ( rule__ExtensionValue__Alternatives )
            {
             before(grammarAccess.getExtensionValueAccess().getAlternatives()); 
            // InternalBasicsParser.g:1922:3: ( rule__ExtensionValue__Alternatives )
            // InternalBasicsParser.g:1922:4: rule__ExtensionValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExtensionValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionValue"


    // $ANTLR start "entryRuleExtensionListValue"
    // InternalBasicsParser.g:1931:1: entryRuleExtensionListValue : ruleExtensionListValue EOF ;
    public final void entryRuleExtensionListValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1932:1: ( ruleExtensionListValue EOF )
            // InternalBasicsParser.g:1933:1: ruleExtensionListValue EOF
            {
             before(grammarAccess.getExtensionListValueRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionListValue();

            state._fsp--;

             after(grammarAccess.getExtensionListValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionListValue"


    // $ANTLR start "ruleExtensionListValue"
    // InternalBasicsParser.g:1940:1: ruleExtensionListValue : ( ( rule__ExtensionListValue__Group__0 ) ) ;
    public final void ruleExtensionListValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1944:2: ( ( ( rule__ExtensionListValue__Group__0 ) ) )
            // InternalBasicsParser.g:1945:2: ( ( rule__ExtensionListValue__Group__0 ) )
            {
            // InternalBasicsParser.g:1945:2: ( ( rule__ExtensionListValue__Group__0 ) )
            // InternalBasicsParser.g:1946:3: ( rule__ExtensionListValue__Group__0 )
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup()); 
            // InternalBasicsParser.g:1947:3: ( rule__ExtensionListValue__Group__0 )
            // InternalBasicsParser.g:1947:4: rule__ExtensionListValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionListValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionListValue"


    // $ANTLR start "entryRuleExtensionBraceMapValue"
    // InternalBasicsParser.g:1956:1: entryRuleExtensionBraceMapValue : ruleExtensionBraceMapValue EOF ;
    public final void entryRuleExtensionBraceMapValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1957:1: ( ruleExtensionBraceMapValue EOF )
            // InternalBasicsParser.g:1958:1: ruleExtensionBraceMapValue EOF
            {
             before(grammarAccess.getExtensionBraceMapValueRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionBraceMapValue();

            state._fsp--;

             after(grammarAccess.getExtensionBraceMapValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionBraceMapValue"


    // $ANTLR start "ruleExtensionBraceMapValue"
    // InternalBasicsParser.g:1965:1: ruleExtensionBraceMapValue : ( ( rule__ExtensionBraceMapValue__Group__0 ) ) ;
    public final void ruleExtensionBraceMapValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1969:2: ( ( ( rule__ExtensionBraceMapValue__Group__0 ) ) )
            // InternalBasicsParser.g:1970:2: ( ( rule__ExtensionBraceMapValue__Group__0 ) )
            {
            // InternalBasicsParser.g:1970:2: ( ( rule__ExtensionBraceMapValue__Group__0 ) )
            // InternalBasicsParser.g:1971:3: ( rule__ExtensionBraceMapValue__Group__0 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup()); 
            // InternalBasicsParser.g:1972:3: ( rule__ExtensionBraceMapValue__Group__0 )
            // InternalBasicsParser.g:1972:4: rule__ExtensionBraceMapValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionBraceMapValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionBraceMapValue"


    // $ANTLR start "entryRuleExtensionIndentedMapValue"
    // InternalBasicsParser.g:1981:1: entryRuleExtensionIndentedMapValue : ruleExtensionIndentedMapValue EOF ;
    public final void entryRuleExtensionIndentedMapValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1982:1: ( ruleExtensionIndentedMapValue EOF )
            // InternalBasicsParser.g:1983:1: ruleExtensionIndentedMapValue EOF
            {
             before(grammarAccess.getExtensionIndentedMapValueRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionIndentedMapValue();

            state._fsp--;

             after(grammarAccess.getExtensionIndentedMapValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionIndentedMapValue"


    // $ANTLR start "ruleExtensionIndentedMapValue"
    // InternalBasicsParser.g:1990:1: ruleExtensionIndentedMapValue : ( ( rule__ExtensionIndentedMapValue__Group__0 ) ) ;
    public final void ruleExtensionIndentedMapValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1994:2: ( ( ( rule__ExtensionIndentedMapValue__Group__0 ) ) )
            // InternalBasicsParser.g:1995:2: ( ( rule__ExtensionIndentedMapValue__Group__0 ) )
            {
            // InternalBasicsParser.g:1995:2: ( ( rule__ExtensionIndentedMapValue__Group__0 ) )
            // InternalBasicsParser.g:1996:3: ( rule__ExtensionIndentedMapValue__Group__0 )
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getGroup()); 
            // InternalBasicsParser.g:1997:3: ( rule__ExtensionIndentedMapValue__Group__0 )
            // InternalBasicsParser.g:1997:4: rule__ExtensionIndentedMapValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionIndentedMapValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionIndentedMapValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionIndentedMapValue"


    // $ANTLR start "entryRuleExtensionRefValue"
    // InternalBasicsParser.g:2006:1: entryRuleExtensionRefValue : ruleExtensionRefValue EOF ;
    public final void entryRuleExtensionRefValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2007:1: ( ruleExtensionRefValue EOF )
            // InternalBasicsParser.g:2008:1: ruleExtensionRefValue EOF
            {
             before(grammarAccess.getExtensionRefValueRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionRefValue();

            state._fsp--;

             after(grammarAccess.getExtensionRefValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionRefValue"


    // $ANTLR start "ruleExtensionRefValue"
    // InternalBasicsParser.g:2015:1: ruleExtensionRefValue : ( ( rule__ExtensionRefValue__Group__0 ) ) ;
    public final void ruleExtensionRefValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2019:2: ( ( ( rule__ExtensionRefValue__Group__0 ) ) )
            // InternalBasicsParser.g:2020:2: ( ( rule__ExtensionRefValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2020:2: ( ( rule__ExtensionRefValue__Group__0 ) )
            // InternalBasicsParser.g:2021:3: ( rule__ExtensionRefValue__Group__0 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getGroup()); 
            // InternalBasicsParser.g:2022:3: ( rule__ExtensionRefValue__Group__0 )
            // InternalBasicsParser.g:2022:4: rule__ExtensionRefValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionRefValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionRefValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionRefValue"


    // $ANTLR start "entryRuleExtensionScalarValue"
    // InternalBasicsParser.g:2031:1: entryRuleExtensionScalarValue : ruleExtensionScalarValue EOF ;
    public final void entryRuleExtensionScalarValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2032:1: ( ruleExtensionScalarValue EOF )
            // InternalBasicsParser.g:2033:1: ruleExtensionScalarValue EOF
            {
             before(grammarAccess.getExtensionScalarValueRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionScalarValue();

            state._fsp--;

             after(grammarAccess.getExtensionScalarValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionScalarValue"


    // $ANTLR start "ruleExtensionScalarValue"
    // InternalBasicsParser.g:2040:1: ruleExtensionScalarValue : ( ( rule__ExtensionScalarValue__Group__0 ) ) ;
    public final void ruleExtensionScalarValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2044:2: ( ( ( rule__ExtensionScalarValue__Group__0 ) ) )
            // InternalBasicsParser.g:2045:2: ( ( rule__ExtensionScalarValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2045:2: ( ( rule__ExtensionScalarValue__Group__0 ) )
            // InternalBasicsParser.g:2046:3: ( rule__ExtensionScalarValue__Group__0 )
            {
             before(grammarAccess.getExtensionScalarValueAccess().getGroup()); 
            // InternalBasicsParser.g:2047:3: ( rule__ExtensionScalarValue__Group__0 )
            // InternalBasicsParser.g:2047:4: rule__ExtensionScalarValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionScalarValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionScalarValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionScalarValue"


    // $ANTLR start "entryRuleExtensionScalarLiteral"
    // InternalBasicsParser.g:2056:1: entryRuleExtensionScalarLiteral : ruleExtensionScalarLiteral EOF ;
    public final void entryRuleExtensionScalarLiteral() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2057:1: ( ruleExtensionScalarLiteral EOF )
            // InternalBasicsParser.g:2058:1: ruleExtensionScalarLiteral EOF
            {
             before(grammarAccess.getExtensionScalarLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleExtensionScalarLiteral();

            state._fsp--;

             after(grammarAccess.getExtensionScalarLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtensionScalarLiteral"


    // $ANTLR start "ruleExtensionScalarLiteral"
    // InternalBasicsParser.g:2065:1: ruleExtensionScalarLiteral : ( ( rule__ExtensionScalarLiteral__Alternatives ) ) ;
    public final void ruleExtensionScalarLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2069:2: ( ( ( rule__ExtensionScalarLiteral__Alternatives ) ) )
            // InternalBasicsParser.g:2070:2: ( ( rule__ExtensionScalarLiteral__Alternatives ) )
            {
            // InternalBasicsParser.g:2070:2: ( ( rule__ExtensionScalarLiteral__Alternatives ) )
            // InternalBasicsParser.g:2071:3: ( rule__ExtensionScalarLiteral__Alternatives )
            {
             before(grammarAccess.getExtensionScalarLiteralAccess().getAlternatives()); 
            // InternalBasicsParser.g:2072:3: ( rule__ExtensionScalarLiteral__Alternatives )
            // InternalBasicsParser.g:2072:4: rule__ExtensionScalarLiteral__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionScalarLiteral__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExtensionScalarLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtensionScalarLiteral"


    // $ANTLR start "rule__Namespace__Alternatives"
    // InternalBasicsParser.g:2080:1: rule__Namespace__Alternatives : ( ( ruleGlobalNamespace ) | ( ruleRelativeNamespace_Impl ) | ( rulePrivateNamespace ) );
    public final void rule__Namespace__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2084:1: ( ( ruleGlobalNamespace ) | ( ruleRelativeNamespace_Impl ) | ( rulePrivateNamespace ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt1=1;
                }
                break;
            case RelativeNamespace:
                {
                alt1=2;
                }
                break;
            case PrivateNamespace:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalBasicsParser.g:2085:2: ( ruleGlobalNamespace )
                    {
                    // InternalBasicsParser.g:2085:2: ( ruleGlobalNamespace )
                    // InternalBasicsParser.g:2086:3: ruleGlobalNamespace
                    {
                     before(grammarAccess.getNamespaceAccess().getGlobalNamespaceParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleGlobalNamespace();

                    state._fsp--;

                     after(grammarAccess.getNamespaceAccess().getGlobalNamespaceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2091:2: ( ruleRelativeNamespace_Impl )
                    {
                    // InternalBasicsParser.g:2091:2: ( ruleRelativeNamespace_Impl )
                    // InternalBasicsParser.g:2092:3: ruleRelativeNamespace_Impl
                    {
                     before(grammarAccess.getNamespaceAccess().getRelativeNamespace_ImplParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRelativeNamespace_Impl();

                    state._fsp--;

                     after(grammarAccess.getNamespaceAccess().getRelativeNamespace_ImplParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2097:2: ( rulePrivateNamespace )
                    {
                    // InternalBasicsParser.g:2097:2: ( rulePrivateNamespace )
                    // InternalBasicsParser.g:2098:3: rulePrivateNamespace
                    {
                     before(grammarAccess.getNamespaceAccess().getPrivateNamespaceParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    rulePrivateNamespace();

                    state._fsp--;

                     after(grammarAccess.getNamespaceAccess().getPrivateNamespaceParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Namespace__Alternatives"


    // $ANTLR start "rule__ParameterType__Alternatives"
    // InternalBasicsParser.g:2107:1: rule__ParameterType__Alternatives : ( ( ruleParameterListType ) | ( ruleParameterStructType ) | ( ruleParameterIntegerType ) | ( ruleParameterStringType ) | ( ruleParameterDoubleType ) | ( ruleParameterBooleanType ) | ( ruleParameterBase64Type ) | ( ruleParameterArrayType ) );
    public final void rule__ParameterType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2111:1: ( ( ruleParameterListType ) | ( ruleParameterStructType ) | ( ruleParameterIntegerType ) | ( ruleParameterStringType ) | ( ruleParameterDoubleType ) | ( ruleParameterBooleanType ) | ( ruleParameterBase64Type ) | ( ruleParameterArrayType ) )
            int alt2=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt2=1;
                }
                break;
            case Struct:
                {
                alt2=2;
                }
                break;
            case Integer:
                {
                alt2=3;
                }
                break;
            case String:
                {
                alt2=4;
                }
                break;
            case Double:
                {
                alt2=5;
                }
                break;
            case Boolean:
                {
                alt2=6;
                }
                break;
            case Base64:
                {
                alt2=7;
                }
                break;
            case Array:
                {
                alt2=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalBasicsParser.g:2112:2: ( ruleParameterListType )
                    {
                    // InternalBasicsParser.g:2112:2: ( ruleParameterListType )
                    // InternalBasicsParser.g:2113:3: ruleParameterListType
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterListTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterListType();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterListTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2118:2: ( ruleParameterStructType )
                    {
                    // InternalBasicsParser.g:2118:2: ( ruleParameterStructType )
                    // InternalBasicsParser.g:2119:3: ruleParameterStructType
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterStructTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterStructType();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterStructTypeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2124:2: ( ruleParameterIntegerType )
                    {
                    // InternalBasicsParser.g:2124:2: ( ruleParameterIntegerType )
                    // InternalBasicsParser.g:2125:3: ruleParameterIntegerType
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterIntegerTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterIntegerType();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterIntegerTypeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2130:2: ( ruleParameterStringType )
                    {
                    // InternalBasicsParser.g:2130:2: ( ruleParameterStringType )
                    // InternalBasicsParser.g:2131:3: ruleParameterStringType
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterStringTypeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterStringType();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterStringTypeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2136:2: ( ruleParameterDoubleType )
                    {
                    // InternalBasicsParser.g:2136:2: ( ruleParameterDoubleType )
                    // InternalBasicsParser.g:2137:3: ruleParameterDoubleType
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterDoubleTypeParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterDoubleType();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterDoubleTypeParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2142:2: ( ruleParameterBooleanType )
                    {
                    // InternalBasicsParser.g:2142:2: ( ruleParameterBooleanType )
                    // InternalBasicsParser.g:2143:3: ruleParameterBooleanType
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterBooleanTypeParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterBooleanType();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterBooleanTypeParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2148:2: ( ruleParameterBase64Type )
                    {
                    // InternalBasicsParser.g:2148:2: ( ruleParameterBase64Type )
                    // InternalBasicsParser.g:2149:3: ruleParameterBase64Type
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterBase64TypeParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterBase64Type();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterBase64TypeParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2154:2: ( ruleParameterArrayType )
                    {
                    // InternalBasicsParser.g:2154:2: ( ruleParameterArrayType )
                    // InternalBasicsParser.g:2155:3: ruleParameterArrayType
                    {
                     before(grammarAccess.getParameterTypeAccess().getParameterArrayTypeParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterArrayType();

                    state._fsp--;

                     after(grammarAccess.getParameterTypeAccess().getParameterArrayTypeParserRuleCall_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterType__Alternatives"


    // $ANTLR start "rule__ParameterValue__Alternatives"
    // InternalBasicsParser.g:2164:1: rule__ParameterValue__Alternatives : ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) );
    public final void rule__ParameterValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2168:1: ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) )
            int alt3=7;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBasicsParser.g:2169:2: ( ruleParameterString )
                    {
                    // InternalBasicsParser.g:2169:2: ( ruleParameterString )
                    // InternalBasicsParser.g:2170:3: ruleParameterString
                    {
                     before(grammarAccess.getParameterValueAccess().getParameterStringParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterString();

                    state._fsp--;

                     after(grammarAccess.getParameterValueAccess().getParameterStringParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2175:2: ( ruleParameterBase64 )
                    {
                    // InternalBasicsParser.g:2175:2: ( ruleParameterBase64 )
                    // InternalBasicsParser.g:2176:3: ruleParameterBase64
                    {
                     before(grammarAccess.getParameterValueAccess().getParameterBase64ParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterBase64();

                    state._fsp--;

                     after(grammarAccess.getParameterValueAccess().getParameterBase64ParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2181:2: ( ruleParameterInteger )
                    {
                    // InternalBasicsParser.g:2181:2: ( ruleParameterInteger )
                    // InternalBasicsParser.g:2182:3: ruleParameterInteger
                    {
                     before(grammarAccess.getParameterValueAccess().getParameterIntegerParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterInteger();

                    state._fsp--;

                     after(grammarAccess.getParameterValueAccess().getParameterIntegerParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2187:2: ( ruleParameterDouble )
                    {
                    // InternalBasicsParser.g:2187:2: ( ruleParameterDouble )
                    // InternalBasicsParser.g:2188:3: ruleParameterDouble
                    {
                     before(grammarAccess.getParameterValueAccess().getParameterDoubleParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterDouble();

                    state._fsp--;

                     after(grammarAccess.getParameterValueAccess().getParameterDoubleParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2193:2: ( ruleParameterBoolean )
                    {
                    // InternalBasicsParser.g:2193:2: ( ruleParameterBoolean )
                    // InternalBasicsParser.g:2194:3: ruleParameterBoolean
                    {
                     before(grammarAccess.getParameterValueAccess().getParameterBooleanParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterBoolean();

                    state._fsp--;

                     after(grammarAccess.getParameterValueAccess().getParameterBooleanParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2199:2: ( ruleParameterList )
                    {
                    // InternalBasicsParser.g:2199:2: ( ruleParameterList )
                    // InternalBasicsParser.g:2200:3: ruleParameterList
                    {
                     before(grammarAccess.getParameterValueAccess().getParameterListParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterList();

                    state._fsp--;

                     after(grammarAccess.getParameterValueAccess().getParameterListParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2205:2: ( ruleParameterStruct )
                    {
                    // InternalBasicsParser.g:2205:2: ( ruleParameterStruct )
                    // InternalBasicsParser.g:2206:3: ruleParameterStruct
                    {
                     before(grammarAccess.getParameterValueAccess().getParameterStructParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterStruct();

                    state._fsp--;

                     after(grammarAccess.getParameterValueAccess().getParameterStructParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterValue__Alternatives"


    // $ANTLR start "rule__AbstractType__Alternatives"
    // InternalBasicsParser.g:2215:1: rule__AbstractType__Alternatives : ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleSpecBaseRef ) | ( ruleArraySpecRef ) | ( rulechar ) | ( rulecharArray ) );
    public final void rule__AbstractType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2219:1: ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleSpecBaseRef ) | ( ruleArraySpecRef ) | ( rulechar ) | ( rulecharArray ) )
            int alt4=33;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBasicsParser.g:2220:2: ( rulebool )
                    {
                    // InternalBasicsParser.g:2220:2: ( rulebool )
                    // InternalBasicsParser.g:2221:3: rulebool
                    {
                     before(grammarAccess.getAbstractTypeAccess().getBoolParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulebool();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getBoolParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2226:2: ( ruleint8 )
                    {
                    // InternalBasicsParser.g:2226:2: ( ruleint8 )
                    // InternalBasicsParser.g:2227:3: ruleint8
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt8ParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleint8();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt8ParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2232:2: ( ruleuint8 )
                    {
                    // InternalBasicsParser.g:2232:2: ( ruleuint8 )
                    // InternalBasicsParser.g:2233:3: ruleuint8
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint8ParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleuint8();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint8ParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2238:2: ( ruleint16 )
                    {
                    // InternalBasicsParser.g:2238:2: ( ruleint16 )
                    // InternalBasicsParser.g:2239:3: ruleint16
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt16ParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleint16();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt16ParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2244:2: ( ruleuint16 )
                    {
                    // InternalBasicsParser.g:2244:2: ( ruleuint16 )
                    // InternalBasicsParser.g:2245:3: ruleuint16
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint16ParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleuint16();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint16ParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2250:2: ( ruleint32 )
                    {
                    // InternalBasicsParser.g:2250:2: ( ruleint32 )
                    // InternalBasicsParser.g:2251:3: ruleint32
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt32ParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleint32();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt32ParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2256:2: ( ruleuint32 )
                    {
                    // InternalBasicsParser.g:2256:2: ( ruleuint32 )
                    // InternalBasicsParser.g:2257:3: ruleuint32
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint32ParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleuint32();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint32ParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2262:2: ( ruleint64 )
                    {
                    // InternalBasicsParser.g:2262:2: ( ruleint64 )
                    // InternalBasicsParser.g:2263:3: ruleint64
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt64ParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleint64();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt64ParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2268:2: ( ruleuint64 )
                    {
                    // InternalBasicsParser.g:2268:2: ( ruleuint64 )
                    // InternalBasicsParser.g:2269:3: ruleuint64
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint64ParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleuint64();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint64ParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2274:2: ( rulefloat32 )
                    {
                    // InternalBasicsParser.g:2274:2: ( rulefloat32 )
                    // InternalBasicsParser.g:2275:3: rulefloat32
                    {
                     before(grammarAccess.getAbstractTypeAccess().getFloat32ParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    rulefloat32();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getFloat32ParserRuleCall_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2280:2: ( rulefloat64 )
                    {
                    // InternalBasicsParser.g:2280:2: ( rulefloat64 )
                    // InternalBasicsParser.g:2281:3: rulefloat64
                    {
                     before(grammarAccess.getAbstractTypeAccess().getFloat64ParserRuleCall_10()); 
                    pushFollow(FOLLOW_2);
                    rulefloat64();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getFloat64ParserRuleCall_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2286:2: ( rulestring0 )
                    {
                    // InternalBasicsParser.g:2286:2: ( rulestring0 )
                    // InternalBasicsParser.g:2287:3: rulestring0
                    {
                     before(grammarAccess.getAbstractTypeAccess().getString0ParserRuleCall_11()); 
                    pushFollow(FOLLOW_2);
                    rulestring0();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getString0ParserRuleCall_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2292:2: ( rulebyte )
                    {
                    // InternalBasicsParser.g:2292:2: ( rulebyte )
                    // InternalBasicsParser.g:2293:3: rulebyte
                    {
                     before(grammarAccess.getAbstractTypeAccess().getByteParserRuleCall_12()); 
                    pushFollow(FOLLOW_2);
                    rulebyte();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getByteParserRuleCall_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2298:2: ( ruletime )
                    {
                    // InternalBasicsParser.g:2298:2: ( ruletime )
                    // InternalBasicsParser.g:2299:3: ruletime
                    {
                     before(grammarAccess.getAbstractTypeAccess().getTimeParserRuleCall_13()); 
                    pushFollow(FOLLOW_2);
                    ruletime();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getTimeParserRuleCall_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBasicsParser.g:2304:2: ( ruleduration )
                    {
                    // InternalBasicsParser.g:2304:2: ( ruleduration )
                    // InternalBasicsParser.g:2305:3: ruleduration
                    {
                     before(grammarAccess.getAbstractTypeAccess().getDurationParserRuleCall_14()); 
                    pushFollow(FOLLOW_2);
                    ruleduration();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getDurationParserRuleCall_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBasicsParser.g:2310:2: ( ruleHeader )
                    {
                    // InternalBasicsParser.g:2310:2: ( ruleHeader )
                    // InternalBasicsParser.g:2311:3: ruleHeader
                    {
                     before(grammarAccess.getAbstractTypeAccess().getHeaderParserRuleCall_15()); 
                    pushFollow(FOLLOW_2);
                    ruleHeader();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getHeaderParserRuleCall_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBasicsParser.g:2316:2: ( ruleboolArray )
                    {
                    // InternalBasicsParser.g:2316:2: ( ruleboolArray )
                    // InternalBasicsParser.g:2317:3: ruleboolArray
                    {
                     before(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_16()); 
                    pushFollow(FOLLOW_2);
                    ruleboolArray();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBasicsParser.g:2322:2: ( ruleint8Array )
                    {
                    // InternalBasicsParser.g:2322:2: ( ruleint8Array )
                    // InternalBasicsParser.g:2323:3: ruleint8Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_17()); 
                    pushFollow(FOLLOW_2);
                    ruleint8Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBasicsParser.g:2328:2: ( ruleuint8Array )
                    {
                    // InternalBasicsParser.g:2328:2: ( ruleuint8Array )
                    // InternalBasicsParser.g:2329:3: ruleuint8Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_18()); 
                    pushFollow(FOLLOW_2);
                    ruleuint8Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBasicsParser.g:2334:2: ( ruleint16Array )
                    {
                    // InternalBasicsParser.g:2334:2: ( ruleint16Array )
                    // InternalBasicsParser.g:2335:3: ruleint16Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_19()); 
                    pushFollow(FOLLOW_2);
                    ruleint16Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBasicsParser.g:2340:2: ( ruleuint16Array )
                    {
                    // InternalBasicsParser.g:2340:2: ( ruleuint16Array )
                    // InternalBasicsParser.g:2341:3: ruleuint16Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_20()); 
                    pushFollow(FOLLOW_2);
                    ruleuint16Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBasicsParser.g:2346:2: ( ruleint32Array )
                    {
                    // InternalBasicsParser.g:2346:2: ( ruleint32Array )
                    // InternalBasicsParser.g:2347:3: ruleint32Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_21()); 
                    pushFollow(FOLLOW_2);
                    ruleint32Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBasicsParser.g:2352:2: ( ruleuint32Array )
                    {
                    // InternalBasicsParser.g:2352:2: ( ruleuint32Array )
                    // InternalBasicsParser.g:2353:3: ruleuint32Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_22()); 
                    pushFollow(FOLLOW_2);
                    ruleuint32Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBasicsParser.g:2358:2: ( ruleint64Array )
                    {
                    // InternalBasicsParser.g:2358:2: ( ruleint64Array )
                    // InternalBasicsParser.g:2359:3: ruleint64Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_23()); 
                    pushFollow(FOLLOW_2);
                    ruleint64Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBasicsParser.g:2364:2: ( ruleuint64Array )
                    {
                    // InternalBasicsParser.g:2364:2: ( ruleuint64Array )
                    // InternalBasicsParser.g:2365:3: ruleuint64Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_24()); 
                    pushFollow(FOLLOW_2);
                    ruleuint64Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBasicsParser.g:2370:2: ( rulefloat32Array )
                    {
                    // InternalBasicsParser.g:2370:2: ( rulefloat32Array )
                    // InternalBasicsParser.g:2371:3: rulefloat32Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_25()); 
                    pushFollow(FOLLOW_2);
                    rulefloat32Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalBasicsParser.g:2376:2: ( rulefloat64Array )
                    {
                    // InternalBasicsParser.g:2376:2: ( rulefloat64Array )
                    // InternalBasicsParser.g:2377:3: rulefloat64Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_26()); 
                    pushFollow(FOLLOW_2);
                    rulefloat64Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalBasicsParser.g:2382:2: ( rulestring0Array )
                    {
                    // InternalBasicsParser.g:2382:2: ( rulestring0Array )
                    // InternalBasicsParser.g:2383:3: rulestring0Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_27()); 
                    pushFollow(FOLLOW_2);
                    rulestring0Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalBasicsParser.g:2388:2: ( rulebyteArray )
                    {
                    // InternalBasicsParser.g:2388:2: ( rulebyteArray )
                    // InternalBasicsParser.g:2389:3: rulebyteArray
                    {
                     before(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_28()); 
                    pushFollow(FOLLOW_2);
                    rulebyteArray();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalBasicsParser.g:2394:2: ( ruleSpecBaseRef )
                    {
                    // InternalBasicsParser.g:2394:2: ( ruleSpecBaseRef )
                    // InternalBasicsParser.g:2395:3: ruleSpecBaseRef
                    {
                     before(grammarAccess.getAbstractTypeAccess().getSpecBaseRefParserRuleCall_29()); 
                    pushFollow(FOLLOW_2);
                    ruleSpecBaseRef();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getSpecBaseRefParserRuleCall_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalBasicsParser.g:2400:2: ( ruleArraySpecRef )
                    {
                    // InternalBasicsParser.g:2400:2: ( ruleArraySpecRef )
                    // InternalBasicsParser.g:2401:3: ruleArraySpecRef
                    {
                     before(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_30()); 
                    pushFollow(FOLLOW_2);
                    ruleArraySpecRef();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalBasicsParser.g:2406:2: ( rulechar )
                    {
                    // InternalBasicsParser.g:2406:2: ( rulechar )
                    // InternalBasicsParser.g:2407:3: rulechar
                    {
                     before(grammarAccess.getAbstractTypeAccess().getCharParserRuleCall_31()); 
                    pushFollow(FOLLOW_2);
                    rulechar();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getCharParserRuleCall_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalBasicsParser.g:2412:2: ( rulecharArray )
                    {
                    // InternalBasicsParser.g:2412:2: ( rulecharArray )
                    // InternalBasicsParser.g:2413:3: rulecharArray
                    {
                     before(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_32()); 
                    pushFollow(FOLLOW_2);
                    rulecharArray();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_32()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Alternatives"


    // $ANTLR start "rule__KEYWORD__Alternatives"
    // InternalBasicsParser.g:2422:1: rule__KEYWORD__Alternatives : ( ( Goal ) | ( Message ) | ( Result ) | ( Feedback ) | ( Name ) | ( Value ) | ( Service ) | ( Type ) | ( Action ) | ( Duration ) | ( Time ) );
    public final void rule__KEYWORD__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2426:1: ( ( Goal ) | ( Message ) | ( Result ) | ( Feedback ) | ( Name ) | ( Value ) | ( Service ) | ( Type ) | ( Action ) | ( Duration ) | ( Time ) )
            int alt5=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt5=1;
                }
                break;
            case Message:
                {
                alt5=2;
                }
                break;
            case Result:
                {
                alt5=3;
                }
                break;
            case Feedback:
                {
                alt5=4;
                }
                break;
            case Name:
                {
                alt5=5;
                }
                break;
            case Value:
                {
                alt5=6;
                }
                break;
            case Service:
                {
                alt5=7;
                }
                break;
            case Type:
                {
                alt5=8;
                }
                break;
            case Action:
                {
                alt5=9;
                }
                break;
            case Duration:
                {
                alt5=10;
                }
                break;
            case Time:
                {
                alt5=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalBasicsParser.g:2427:2: ( Goal )
                    {
                    // InternalBasicsParser.g:2427:2: ( Goal )
                    // InternalBasicsParser.g:2428:3: Goal
                    {
                     before(grammarAccess.getKEYWORDAccess().getGoalKeyword_0()); 
                    match(input,Goal,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getGoalKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2433:2: ( Message )
                    {
                    // InternalBasicsParser.g:2433:2: ( Message )
                    // InternalBasicsParser.g:2434:3: Message
                    {
                     before(grammarAccess.getKEYWORDAccess().getMessageKeyword_1()); 
                    match(input,Message,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getMessageKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2439:2: ( Result )
                    {
                    // InternalBasicsParser.g:2439:2: ( Result )
                    // InternalBasicsParser.g:2440:3: Result
                    {
                     before(grammarAccess.getKEYWORDAccess().getResultKeyword_2()); 
                    match(input,Result,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getResultKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2445:2: ( Feedback )
                    {
                    // InternalBasicsParser.g:2445:2: ( Feedback )
                    // InternalBasicsParser.g:2446:3: Feedback
                    {
                     before(grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3()); 
                    match(input,Feedback,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2451:2: ( Name )
                    {
                    // InternalBasicsParser.g:2451:2: ( Name )
                    // InternalBasicsParser.g:2452:3: Name
                    {
                     before(grammarAccess.getKEYWORDAccess().getNameKeyword_4()); 
                    match(input,Name,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getNameKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2457:2: ( Value )
                    {
                    // InternalBasicsParser.g:2457:2: ( Value )
                    // InternalBasicsParser.g:2458:3: Value
                    {
                     before(grammarAccess.getKEYWORDAccess().getValueKeyword_5()); 
                    match(input,Value,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getValueKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2463:2: ( Service )
                    {
                    // InternalBasicsParser.g:2463:2: ( Service )
                    // InternalBasicsParser.g:2464:3: Service
                    {
                     before(grammarAccess.getKEYWORDAccess().getServiceKeyword_6()); 
                    match(input,Service,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getServiceKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2469:2: ( Type )
                    {
                    // InternalBasicsParser.g:2469:2: ( Type )
                    // InternalBasicsParser.g:2470:3: Type
                    {
                     before(grammarAccess.getKEYWORDAccess().getTypeKeyword_7()); 
                    match(input,Type,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getTypeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2475:2: ( Action )
                    {
                    // InternalBasicsParser.g:2475:2: ( Action )
                    // InternalBasicsParser.g:2476:3: Action
                    {
                     before(grammarAccess.getKEYWORDAccess().getActionKeyword_8()); 
                    match(input,Action,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getActionKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2481:2: ( Duration )
                    {
                    // InternalBasicsParser.g:2481:2: ( Duration )
                    // InternalBasicsParser.g:2482:3: Duration
                    {
                     before(grammarAccess.getKEYWORDAccess().getDurationKeyword_9()); 
                    match(input,Duration,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getDurationKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2487:2: ( Time )
                    {
                    // InternalBasicsParser.g:2487:2: ( Time )
                    // InternalBasicsParser.g:2488:3: Time
                    {
                     before(grammarAccess.getKEYWORDAccess().getTimeKeyword_10()); 
                    match(input,Time,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getTimeKeyword_10()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KEYWORD__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalBasicsParser.g:2497:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2501:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBasicsParser.g:2502:2: ( RULE_STRING )
                    {
                    // InternalBasicsParser.g:2502:2: ( RULE_STRING )
                    // InternalBasicsParser.g:2503:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2508:2: ( RULE_ID )
                    {
                    // InternalBasicsParser.g:2508:2: ( RULE_ID )
                    // InternalBasicsParser.g:2509:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__ExtensionEntry__Alternatives_1"
    // InternalBasicsParser.g:2518:1: rule__ExtensionEntry__Alternatives_1 : ( ( ( rule__ExtensionEntry__Group_1_0__0 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) ) );
    public final void rule__ExtensionEntry__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2522:1: ( ( ( rule__ExtensionEntry__Group_1_0__0 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=Duration && LA7_0<=Feedback)||(LA7_0>=Boolean && LA7_0<=Float64)||LA7_0==Message||LA7_0==Service||(LA7_0>=Base64 && LA7_0<=Action)||(LA7_0>=Result && LA7_0<=Uint64)||(LA7_0>=Array && LA7_0<=Int64)||(LA7_0>=Uint8 && LA7_0<=List)||(LA7_0>=Bool && LA7_0<=Node)||(LA7_0>=Time && LA7_0<=Any)||(LA7_0>=RULE_ID && LA7_0<=RULE_STRING)) ) {
                alt7=1;
            }
            else if ( (LA7_0==Default||LA7_0==Value_1||LA7_0==Type_1||LA7_0==Ns) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBasicsParser.g:2523:2: ( ( rule__ExtensionEntry__Group_1_0__0 ) )
                    {
                    // InternalBasicsParser.g:2523:2: ( ( rule__ExtensionEntry__Group_1_0__0 ) )
                    // InternalBasicsParser.g:2524:3: ( rule__ExtensionEntry__Group_1_0__0 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getGroup_1_0()); 
                    // InternalBasicsParser.g:2525:3: ( rule__ExtensionEntry__Group_1_0__0 )
                    // InternalBasicsParser.g:2525:4: rule__ExtensionEntry__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionEntry__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExtensionEntryAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2529:2: ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) )
                    {
                    // InternalBasicsParser.g:2529:2: ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) )
                    // InternalBasicsParser.g:2530:3: ( rule__ExtensionEntry__KeyAssignment_1_1 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_1()); 
                    // InternalBasicsParser.g:2531:3: ( rule__ExtensionEntry__KeyAssignment_1_1 )
                    // InternalBasicsParser.g:2531:4: rule__ExtensionEntry__KeyAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionEntry__KeyAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Alternatives_1"


    // $ANTLR start "rule__ExtensionKey__Alternatives"
    // InternalBasicsParser.g:2539:1: rule__ExtensionKey__Alternatives : ( ( RULE_ID ) | ( RULE_STRING ) | ( ruleKEYWORD ) | ( Node ) | ( String ) | ( Integer ) | ( Double ) | ( Boolean ) | ( Base64 ) | ( Array ) | ( List ) | ( Struct ) | ( Date ) | ( Any ) | ( Bool ) | ( Int8 ) | ( Uint8 ) | ( Int16 ) | ( Uint16 ) | ( Int32 ) | ( Uint32 ) | ( Int64 ) | ( Uint64 ) | ( Float32 ) | ( Float64 ) | ( String_1 ) | ( Char ) | ( Byte ) | ( Header ) );
    public final void rule__ExtensionKey__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2543:1: ( ( RULE_ID ) | ( RULE_STRING ) | ( ruleKEYWORD ) | ( Node ) | ( String ) | ( Integer ) | ( Double ) | ( Boolean ) | ( Base64 ) | ( Array ) | ( List ) | ( Struct ) | ( Date ) | ( Any ) | ( Bool ) | ( Int8 ) | ( Uint8 ) | ( Int16 ) | ( Uint16 ) | ( Int32 ) | ( Uint32 ) | ( Int64 ) | ( Uint64 ) | ( Float32 ) | ( Float64 ) | ( String_1 ) | ( Char ) | ( Byte ) | ( Header ) )
            int alt8=29;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case RULE_STRING:
                {
                alt8=2;
                }
                break;
            case Duration:
            case Feedback:
            case Message:
            case Service:
            case Action:
            case Result:
            case Value:
            case Goal:
            case Name:
            case Time:
            case Type:
                {
                alt8=3;
                }
                break;
            case Node:
                {
                alt8=4;
                }
                break;
            case String:
                {
                alt8=5;
                }
                break;
            case Integer:
                {
                alt8=6;
                }
                break;
            case Double:
                {
                alt8=7;
                }
                break;
            case Boolean:
                {
                alt8=8;
                }
                break;
            case Base64:
                {
                alt8=9;
                }
                break;
            case Array:
                {
                alt8=10;
                }
                break;
            case List:
                {
                alt8=11;
                }
                break;
            case Struct:
                {
                alt8=12;
                }
                break;
            case Date:
                {
                alt8=13;
                }
                break;
            case Any:
                {
                alt8=14;
                }
                break;
            case Bool:
                {
                alt8=15;
                }
                break;
            case Int8:
                {
                alt8=16;
                }
                break;
            case Uint8:
                {
                alt8=17;
                }
                break;
            case Int16:
                {
                alt8=18;
                }
                break;
            case Uint16:
                {
                alt8=19;
                }
                break;
            case Int32:
                {
                alt8=20;
                }
                break;
            case Uint32:
                {
                alt8=21;
                }
                break;
            case Int64:
                {
                alt8=22;
                }
                break;
            case Uint64:
                {
                alt8=23;
                }
                break;
            case Float32:
                {
                alt8=24;
                }
                break;
            case Float64:
                {
                alt8=25;
                }
                break;
            case String_1:
                {
                alt8=26;
                }
                break;
            case Char:
                {
                alt8=27;
                }
                break;
            case Byte:
                {
                alt8=28;
                }
                break;
            case Header:
                {
                alt8=29;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalBasicsParser.g:2544:2: ( RULE_ID )
                    {
                    // InternalBasicsParser.g:2544:2: ( RULE_ID )
                    // InternalBasicsParser.g:2545:3: RULE_ID
                    {
                     before(grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2550:2: ( RULE_STRING )
                    {
                    // InternalBasicsParser.g:2550:2: ( RULE_STRING )
                    // InternalBasicsParser.g:2551:3: RULE_STRING
                    {
                     before(grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2556:2: ( ruleKEYWORD )
                    {
                    // InternalBasicsParser.g:2556:2: ( ruleKEYWORD )
                    // InternalBasicsParser.g:2557:3: ruleKEYWORD
                    {
                     before(grammarAccess.getExtensionKeyAccess().getKEYWORDParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleKEYWORD();

                    state._fsp--;

                     after(grammarAccess.getExtensionKeyAccess().getKEYWORDParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2562:2: ( Node )
                    {
                    // InternalBasicsParser.g:2562:2: ( Node )
                    // InternalBasicsParser.g:2563:3: Node
                    {
                     before(grammarAccess.getExtensionKeyAccess().getNodeKeyword_3()); 
                    match(input,Node,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getNodeKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2568:2: ( String )
                    {
                    // InternalBasicsParser.g:2568:2: ( String )
                    // InternalBasicsParser.g:2569:3: String
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStringKeyword_4()); 
                    match(input,String,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStringKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2574:2: ( Integer )
                    {
                    // InternalBasicsParser.g:2574:2: ( Integer )
                    // InternalBasicsParser.g:2575:3: Integer
                    {
                     before(grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5()); 
                    match(input,Integer,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2580:2: ( Double )
                    {
                    // InternalBasicsParser.g:2580:2: ( Double )
                    // InternalBasicsParser.g:2581:3: Double
                    {
                     before(grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6()); 
                    match(input,Double,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2586:2: ( Boolean )
                    {
                    // InternalBasicsParser.g:2586:2: ( Boolean )
                    // InternalBasicsParser.g:2587:3: Boolean
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7()); 
                    match(input,Boolean,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2592:2: ( Base64 )
                    {
                    // InternalBasicsParser.g:2592:2: ( Base64 )
                    // InternalBasicsParser.g:2593:3: Base64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBase64Keyword_8()); 
                    match(input,Base64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBase64Keyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2598:2: ( Array )
                    {
                    // InternalBasicsParser.g:2598:2: ( Array )
                    // InternalBasicsParser.g:2599:3: Array
                    {
                     before(grammarAccess.getExtensionKeyAccess().getArrayKeyword_9()); 
                    match(input,Array,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getArrayKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2604:2: ( List )
                    {
                    // InternalBasicsParser.g:2604:2: ( List )
                    // InternalBasicsParser.g:2605:3: List
                    {
                     before(grammarAccess.getExtensionKeyAccess().getListKeyword_10()); 
                    match(input,List,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getListKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2610:2: ( Struct )
                    {
                    // InternalBasicsParser.g:2610:2: ( Struct )
                    // InternalBasicsParser.g:2611:3: Struct
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStructKeyword_11()); 
                    match(input,Struct,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStructKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2616:2: ( Date )
                    {
                    // InternalBasicsParser.g:2616:2: ( Date )
                    // InternalBasicsParser.g:2617:3: Date
                    {
                     before(grammarAccess.getExtensionKeyAccess().getDateKeyword_12()); 
                    match(input,Date,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getDateKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2622:2: ( Any )
                    {
                    // InternalBasicsParser.g:2622:2: ( Any )
                    // InternalBasicsParser.g:2623:3: Any
                    {
                     before(grammarAccess.getExtensionKeyAccess().getAnyKeyword_13()); 
                    match(input,Any,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getAnyKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBasicsParser.g:2628:2: ( Bool )
                    {
                    // InternalBasicsParser.g:2628:2: ( Bool )
                    // InternalBasicsParser.g:2629:3: Bool
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBoolKeyword_14()); 
                    match(input,Bool,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBoolKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBasicsParser.g:2634:2: ( Int8 )
                    {
                    // InternalBasicsParser.g:2634:2: ( Int8 )
                    // InternalBasicsParser.g:2635:3: Int8
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt8Keyword_15()); 
                    match(input,Int8,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt8Keyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBasicsParser.g:2640:2: ( Uint8 )
                    {
                    // InternalBasicsParser.g:2640:2: ( Uint8 )
                    // InternalBasicsParser.g:2641:3: Uint8
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint8Keyword_16()); 
                    match(input,Uint8,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint8Keyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBasicsParser.g:2646:2: ( Int16 )
                    {
                    // InternalBasicsParser.g:2646:2: ( Int16 )
                    // InternalBasicsParser.g:2647:3: Int16
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt16Keyword_17()); 
                    match(input,Int16,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt16Keyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBasicsParser.g:2652:2: ( Uint16 )
                    {
                    // InternalBasicsParser.g:2652:2: ( Uint16 )
                    // InternalBasicsParser.g:2653:3: Uint16
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint16Keyword_18()); 
                    match(input,Uint16,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint16Keyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBasicsParser.g:2658:2: ( Int32 )
                    {
                    // InternalBasicsParser.g:2658:2: ( Int32 )
                    // InternalBasicsParser.g:2659:3: Int32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt32Keyword_19()); 
                    match(input,Int32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt32Keyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBasicsParser.g:2664:2: ( Uint32 )
                    {
                    // InternalBasicsParser.g:2664:2: ( Uint32 )
                    // InternalBasicsParser.g:2665:3: Uint32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint32Keyword_20()); 
                    match(input,Uint32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint32Keyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBasicsParser.g:2670:2: ( Int64 )
                    {
                    // InternalBasicsParser.g:2670:2: ( Int64 )
                    // InternalBasicsParser.g:2671:3: Int64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt64Keyword_21()); 
                    match(input,Int64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt64Keyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBasicsParser.g:2676:2: ( Uint64 )
                    {
                    // InternalBasicsParser.g:2676:2: ( Uint64 )
                    // InternalBasicsParser.g:2677:3: Uint64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint64Keyword_22()); 
                    match(input,Uint64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint64Keyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBasicsParser.g:2682:2: ( Float32 )
                    {
                    // InternalBasicsParser.g:2682:2: ( Float32 )
                    // InternalBasicsParser.g:2683:3: Float32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23()); 
                    match(input,Float32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBasicsParser.g:2688:2: ( Float64 )
                    {
                    // InternalBasicsParser.g:2688:2: ( Float64 )
                    // InternalBasicsParser.g:2689:3: Float64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24()); 
                    match(input,Float64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBasicsParser.g:2694:2: ( String_1 )
                    {
                    // InternalBasicsParser.g:2694:2: ( String_1 )
                    // InternalBasicsParser.g:2695:3: String_1
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStringKeyword_25()); 
                    match(input,String_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStringKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalBasicsParser.g:2700:2: ( Char )
                    {
                    // InternalBasicsParser.g:2700:2: ( Char )
                    // InternalBasicsParser.g:2701:3: Char
                    {
                     before(grammarAccess.getExtensionKeyAccess().getCharKeyword_26()); 
                    match(input,Char,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getCharKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalBasicsParser.g:2706:2: ( Byte )
                    {
                    // InternalBasicsParser.g:2706:2: ( Byte )
                    // InternalBasicsParser.g:2707:3: Byte
                    {
                     before(grammarAccess.getExtensionKeyAccess().getByteKeyword_27()); 
                    match(input,Byte,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getByteKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalBasicsParser.g:2712:2: ( Header )
                    {
                    // InternalBasicsParser.g:2712:2: ( Header )
                    // InternalBasicsParser.g:2713:3: Header
                    {
                     before(grammarAccess.getExtensionKeyAccess().getHeaderKeyword_28()); 
                    match(input,Header,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getHeaderKeyword_28()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionKey__Alternatives"


    // $ANTLR start "rule__ExtensionColonKey__Alternatives"
    // InternalBasicsParser.g:2722:1: rule__ExtensionColonKey__Alternatives : ( ( Ns ) | ( Type_1 ) | ( Value_1 ) | ( Default ) );
    public final void rule__ExtensionColonKey__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2726:1: ( ( Ns ) | ( Type_1 ) | ( Value_1 ) | ( Default ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt9=1;
                }
                break;
            case Type_1:
                {
                alt9=2;
                }
                break;
            case Value_1:
                {
                alt9=3;
                }
                break;
            case Default:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalBasicsParser.g:2727:2: ( Ns )
                    {
                    // InternalBasicsParser.g:2727:2: ( Ns )
                    // InternalBasicsParser.g:2728:3: Ns
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0()); 
                    match(input,Ns,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2733:2: ( Type_1 )
                    {
                    // InternalBasicsParser.g:2733:2: ( Type_1 )
                    // InternalBasicsParser.g:2734:3: Type_1
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1()); 
                    match(input,Type_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2739:2: ( Value_1 )
                    {
                    // InternalBasicsParser.g:2739:2: ( Value_1 )
                    // InternalBasicsParser.g:2740:3: Value_1
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2()); 
                    match(input,Value_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2745:2: ( Default )
                    {
                    // InternalBasicsParser.g:2745:2: ( Default )
                    // InternalBasicsParser.g:2746:3: Default
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3()); 
                    match(input,Default,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionColonKey__Alternatives"


    // $ANTLR start "rule__ExtensionValue__Alternatives"
    // InternalBasicsParser.g:2755:1: rule__ExtensionValue__Alternatives : ( ( ruleExtensionListValue ) | ( ruleExtensionBraceMapValue ) | ( ruleExtensionIndentedMapValue ) | ( ruleExtensionRefValue ) | ( ruleExtensionScalarValue ) );
    public final void rule__ExtensionValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2759:1: ( ( ruleExtensionListValue ) | ( ruleExtensionBraceMapValue ) | ( ruleExtensionIndentedMapValue ) | ( ruleExtensionRefValue ) | ( ruleExtensionScalarValue ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt10=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt10=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt10=3;
                }
                break;
            case Param:
            case Pub:
            case Sub:
            case Ac:
            case As:
            case Sc:
            case Ss:
                {
                alt10=4;
                }
                break;
            case Duration:
            case Feedback:
            case Boolean:
            case Integer:
            case Float32:
            case Float64:
            case Message:
            case Service:
            case Base64:
            case Double:
            case Header:
            case String:
            case Struct:
            case Action:
            case Result:
            case String_1:
            case Uint16:
            case Uint32:
            case Uint64:
            case Array:
            case Int16:
            case Int32:
            case Int64:
            case Uint8:
            case Value:
            case Date:
            case List:
            case Bool:
            case Byte:
            case Char:
            case Goal:
            case Int8:
            case Name:
            case Node:
            case Time:
            case Type:
            case Any:
            case RULE_BOOLEAN:
            case RULE_DECINT:
            case RULE_DOUBLE:
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalBasicsParser.g:2760:2: ( ruleExtensionListValue )
                    {
                    // InternalBasicsParser.g:2760:2: ( ruleExtensionListValue )
                    // InternalBasicsParser.g:2761:3: ruleExtensionListValue
                    {
                     before(grammarAccess.getExtensionValueAccess().getExtensionListValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleExtensionListValue();

                    state._fsp--;

                     after(grammarAccess.getExtensionValueAccess().getExtensionListValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2766:2: ( ruleExtensionBraceMapValue )
                    {
                    // InternalBasicsParser.g:2766:2: ( ruleExtensionBraceMapValue )
                    // InternalBasicsParser.g:2767:3: ruleExtensionBraceMapValue
                    {
                     before(grammarAccess.getExtensionValueAccess().getExtensionBraceMapValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleExtensionBraceMapValue();

                    state._fsp--;

                     after(grammarAccess.getExtensionValueAccess().getExtensionBraceMapValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2772:2: ( ruleExtensionIndentedMapValue )
                    {
                    // InternalBasicsParser.g:2772:2: ( ruleExtensionIndentedMapValue )
                    // InternalBasicsParser.g:2773:3: ruleExtensionIndentedMapValue
                    {
                     before(grammarAccess.getExtensionValueAccess().getExtensionIndentedMapValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleExtensionIndentedMapValue();

                    state._fsp--;

                     after(grammarAccess.getExtensionValueAccess().getExtensionIndentedMapValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2778:2: ( ruleExtensionRefValue )
                    {
                    // InternalBasicsParser.g:2778:2: ( ruleExtensionRefValue )
                    // InternalBasicsParser.g:2779:3: ruleExtensionRefValue
                    {
                     before(grammarAccess.getExtensionValueAccess().getExtensionRefValueParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleExtensionRefValue();

                    state._fsp--;

                     after(grammarAccess.getExtensionValueAccess().getExtensionRefValueParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2784:2: ( ruleExtensionScalarValue )
                    {
                    // InternalBasicsParser.g:2784:2: ( ruleExtensionScalarValue )
                    // InternalBasicsParser.g:2785:3: ruleExtensionScalarValue
                    {
                     before(grammarAccess.getExtensionValueAccess().getExtensionScalarValueParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleExtensionScalarValue();

                    state._fsp--;

                     after(grammarAccess.getExtensionValueAccess().getExtensionScalarValueParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionValue__Alternatives"


    // $ANTLR start "rule__ExtensionRefValue__RefKindAlternatives_1_0"
    // InternalBasicsParser.g:2794:1: rule__ExtensionRefValue__RefKindAlternatives_1_0 : ( ( Pub ) | ( Sub ) | ( Ss ) | ( Sc ) | ( As ) | ( Ac ) | ( Param ) );
    public final void rule__ExtensionRefValue__RefKindAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2798:1: ( ( Pub ) | ( Sub ) | ( Ss ) | ( Sc ) | ( As ) | ( Ac ) | ( Param ) )
            int alt11=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt11=1;
                }
                break;
            case Sub:
                {
                alt11=2;
                }
                break;
            case Ss:
                {
                alt11=3;
                }
                break;
            case Sc:
                {
                alt11=4;
                }
                break;
            case As:
                {
                alt11=5;
                }
                break;
            case Ac:
                {
                alt11=6;
                }
                break;
            case Param:
                {
                alt11=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalBasicsParser.g:2799:2: ( Pub )
                    {
                    // InternalBasicsParser.g:2799:2: ( Pub )
                    // InternalBasicsParser.g:2800:3: Pub
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0()); 
                    match(input,Pub,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2805:2: ( Sub )
                    {
                    // InternalBasicsParser.g:2805:2: ( Sub )
                    // InternalBasicsParser.g:2806:3: Sub
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1()); 
                    match(input,Sub,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2811:2: ( Ss )
                    {
                    // InternalBasicsParser.g:2811:2: ( Ss )
                    // InternalBasicsParser.g:2812:3: Ss
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2()); 
                    match(input,Ss,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2817:2: ( Sc )
                    {
                    // InternalBasicsParser.g:2817:2: ( Sc )
                    // InternalBasicsParser.g:2818:3: Sc
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3()); 
                    match(input,Sc,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2823:2: ( As )
                    {
                    // InternalBasicsParser.g:2823:2: ( As )
                    // InternalBasicsParser.g:2824:3: As
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4()); 
                    match(input,As,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2829:2: ( Ac )
                    {
                    // InternalBasicsParser.g:2829:2: ( Ac )
                    // InternalBasicsParser.g:2830:3: Ac
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5()); 
                    match(input,Ac,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2835:2: ( Param )
                    {
                    // InternalBasicsParser.g:2835:2: ( Param )
                    // InternalBasicsParser.g:2836:3: Param
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindParamKeyword_1_0_6()); 
                    match(input,Param,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindParamKeyword_1_0_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__RefKindAlternatives_1_0"


    // $ANTLR start "rule__ExtensionScalarLiteral__Alternatives"
    // InternalBasicsParser.g:2845:1: rule__ExtensionScalarLiteral__Alternatives : ( ( RULE_BOOLEAN ) | ( RULE_DOUBLE ) | ( RULE_DECINT ) | ( RULE_INT ) | ( ruleExtensionKey ) );
    public final void rule__ExtensionScalarLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2849:1: ( ( RULE_BOOLEAN ) | ( RULE_DOUBLE ) | ( RULE_DECINT ) | ( RULE_INT ) | ( ruleExtensionKey ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt12=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt12=2;
                }
                break;
            case RULE_DECINT:
                {
                alt12=3;
                }
                break;
            case RULE_INT:
                {
                alt12=4;
                }
                break;
            case Duration:
            case Feedback:
            case Boolean:
            case Integer:
            case Float32:
            case Float64:
            case Message:
            case Service:
            case Base64:
            case Double:
            case Header:
            case String:
            case Struct:
            case Action:
            case Result:
            case String_1:
            case Uint16:
            case Uint32:
            case Uint64:
            case Array:
            case Int16:
            case Int32:
            case Int64:
            case Uint8:
            case Value:
            case Date:
            case List:
            case Bool:
            case Byte:
            case Char:
            case Goal:
            case Int8:
            case Name:
            case Node:
            case Time:
            case Type:
            case Any:
            case RULE_ID:
            case RULE_STRING:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalBasicsParser.g:2850:2: ( RULE_BOOLEAN )
                    {
                    // InternalBasicsParser.g:2850:2: ( RULE_BOOLEAN )
                    // InternalBasicsParser.g:2851:3: RULE_BOOLEAN
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0()); 
                    match(input,RULE_BOOLEAN,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2856:2: ( RULE_DOUBLE )
                    {
                    // InternalBasicsParser.g:2856:2: ( RULE_DOUBLE )
                    // InternalBasicsParser.g:2857:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2862:2: ( RULE_DECINT )
                    {
                    // InternalBasicsParser.g:2862:2: ( RULE_DECINT )
                    // InternalBasicsParser.g:2863:3: RULE_DECINT
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2()); 
                    match(input,RULE_DECINT,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2868:2: ( RULE_INT )
                    {
                    // InternalBasicsParser.g:2868:2: ( RULE_INT )
                    // InternalBasicsParser.g:2869:3: RULE_INT
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2874:2: ( ruleExtensionKey )
                    {
                    // InternalBasicsParser.g:2874:2: ( ruleExtensionKey )
                    // InternalBasicsParser.g:2875:3: ruleExtensionKey
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getExtensionKeyParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleExtensionKey();

                    state._fsp--;

                     after(grammarAccess.getExtensionScalarLiteralAccess().getExtensionKeyParserRuleCall_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionScalarLiteral__Alternatives"


    // $ANTLR start "rule__GlobalNamespace__Group__0"
    // InternalBasicsParser.g:2884:1: rule__GlobalNamespace__Group__0 : rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1 ;
    public final void rule__GlobalNamespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2888:1: ( rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1 )
            // InternalBasicsParser.g:2889:2: rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__GlobalNamespace__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group__0"


    // $ANTLR start "rule__GlobalNamespace__Group__0__Impl"
    // InternalBasicsParser.g:2896:1: rule__GlobalNamespace__Group__0__Impl : ( () ) ;
    public final void rule__GlobalNamespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2900:1: ( ( () ) )
            // InternalBasicsParser.g:2901:1: ( () )
            {
            // InternalBasicsParser.g:2901:1: ( () )
            // InternalBasicsParser.g:2902:2: ()
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0()); 
            // InternalBasicsParser.g:2903:2: ()
            // InternalBasicsParser.g:2903:3: 
            {
            }

             after(grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group__0__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group__1"
    // InternalBasicsParser.g:2911:1: rule__GlobalNamespace__Group__1 : rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2 ;
    public final void rule__GlobalNamespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2915:1: ( rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2 )
            // InternalBasicsParser.g:2916:2: rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__GlobalNamespace__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group__1"


    // $ANTLR start "rule__GlobalNamespace__Group__1__Impl"
    // InternalBasicsParser.g:2923:1: rule__GlobalNamespace__Group__1__Impl : ( GlobalNamespace ) ;
    public final void rule__GlobalNamespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2927:1: ( ( GlobalNamespace ) )
            // InternalBasicsParser.g:2928:1: ( GlobalNamespace )
            {
            // InternalBasicsParser.g:2928:1: ( GlobalNamespace )
            // InternalBasicsParser.g:2929:2: GlobalNamespace
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1()); 
            match(input,GlobalNamespace,FOLLOW_2); 
             after(grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group__1__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group__2"
    // InternalBasicsParser.g:2938:1: rule__GlobalNamespace__Group__2 : rule__GlobalNamespace__Group__2__Impl ;
    public final void rule__GlobalNamespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2942:1: ( rule__GlobalNamespace__Group__2__Impl )
            // InternalBasicsParser.g:2943:2: rule__GlobalNamespace__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group__2"


    // $ANTLR start "rule__GlobalNamespace__Group__2__Impl"
    // InternalBasicsParser.g:2949:1: rule__GlobalNamespace__Group__2__Impl : ( ( rule__GlobalNamespace__Group_2__0 )? ) ;
    public final void rule__GlobalNamespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2953:1: ( ( ( rule__GlobalNamespace__Group_2__0 )? ) )
            // InternalBasicsParser.g:2954:1: ( ( rule__GlobalNamespace__Group_2__0 )? )
            {
            // InternalBasicsParser.g:2954:1: ( ( rule__GlobalNamespace__Group_2__0 )? )
            // InternalBasicsParser.g:2955:2: ( rule__GlobalNamespace__Group_2__0 )?
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup_2()); 
            // InternalBasicsParser.g:2956:2: ( rule__GlobalNamespace__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LeftSquareBracket) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBasicsParser.g:2956:3: rule__GlobalNamespace__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__GlobalNamespace__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGlobalNamespaceAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group__2__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group_2__0"
    // InternalBasicsParser.g:2965:1: rule__GlobalNamespace__Group_2__0 : rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1 ;
    public final void rule__GlobalNamespace__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2969:1: ( rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1 )
            // InternalBasicsParser.g:2970:2: rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__GlobalNamespace__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__0"


    // $ANTLR start "rule__GlobalNamespace__Group_2__0__Impl"
    // InternalBasicsParser.g:2977:1: rule__GlobalNamespace__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__GlobalNamespace__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2981:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:2982:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:2982:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:2983:2: LeftSquareBracket
            {
             before(grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__0__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group_2__1"
    // InternalBasicsParser.g:2992:1: rule__GlobalNamespace__Group_2__1 : rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2 ;
    public final void rule__GlobalNamespace__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2996:1: ( rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2 )
            // InternalBasicsParser.g:2997:2: rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2
            {
            pushFollow(FOLLOW_6);
            rule__GlobalNamespace__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__1"


    // $ANTLR start "rule__GlobalNamespace__Group_2__1__Impl"
    // InternalBasicsParser.g:3004:1: rule__GlobalNamespace__Group_2__1__Impl : ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) ) ;
    public final void rule__GlobalNamespace__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3008:1: ( ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3009:1: ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3009:1: ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3010:2: ( rule__GlobalNamespace__PartsAssignment_2_1 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3011:2: ( rule__GlobalNamespace__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3011:3: rule__GlobalNamespace__PartsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__PartsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__1__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group_2__2"
    // InternalBasicsParser.g:3019:1: rule__GlobalNamespace__Group_2__2 : rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3 ;
    public final void rule__GlobalNamespace__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3023:1: ( rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3 )
            // InternalBasicsParser.g:3024:2: rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3
            {
            pushFollow(FOLLOW_6);
            rule__GlobalNamespace__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__2"


    // $ANTLR start "rule__GlobalNamespace__Group_2__2__Impl"
    // InternalBasicsParser.g:3031:1: rule__GlobalNamespace__Group_2__2__Impl : ( ( rule__GlobalNamespace__Group_2_2__0 )* ) ;
    public final void rule__GlobalNamespace__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3035:1: ( ( ( rule__GlobalNamespace__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3036:1: ( ( rule__GlobalNamespace__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3036:1: ( ( rule__GlobalNamespace__Group_2_2__0 )* )
            // InternalBasicsParser.g:3037:2: ( rule__GlobalNamespace__Group_2_2__0 )*
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3038:2: ( rule__GlobalNamespace__Group_2_2__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==Comma) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalBasicsParser.g:3038:3: rule__GlobalNamespace__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__GlobalNamespace__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getGlobalNamespaceAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__2__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group_2__3"
    // InternalBasicsParser.g:3046:1: rule__GlobalNamespace__Group_2__3 : rule__GlobalNamespace__Group_2__3__Impl ;
    public final void rule__GlobalNamespace__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3050:1: ( rule__GlobalNamespace__Group_2__3__Impl )
            // InternalBasicsParser.g:3051:2: rule__GlobalNamespace__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__3"


    // $ANTLR start "rule__GlobalNamespace__Group_2__3__Impl"
    // InternalBasicsParser.g:3057:1: rule__GlobalNamespace__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__GlobalNamespace__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3061:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3062:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3062:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3063:2: RightSquareBracket
            {
             before(grammarAccess.getGlobalNamespaceAccess().getRightSquareBracketKeyword_2_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getGlobalNamespaceAccess().getRightSquareBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2__3__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group_2_2__0"
    // InternalBasicsParser.g:3073:1: rule__GlobalNamespace__Group_2_2__0 : rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1 ;
    public final void rule__GlobalNamespace__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3077:1: ( rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1 )
            // InternalBasicsParser.g:3078:2: rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1
            {
            pushFollow(FOLLOW_5);
            rule__GlobalNamespace__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2_2__0"


    // $ANTLR start "rule__GlobalNamespace__Group_2_2__0__Impl"
    // InternalBasicsParser.g:3085:1: rule__GlobalNamespace__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__GlobalNamespace__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3089:1: ( ( Comma ) )
            // InternalBasicsParser.g:3090:1: ( Comma )
            {
            // InternalBasicsParser.g:3090:1: ( Comma )
            // InternalBasicsParser.g:3091:2: Comma
            {
             before(grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2_2__0__Impl"


    // $ANTLR start "rule__GlobalNamespace__Group_2_2__1"
    // InternalBasicsParser.g:3100:1: rule__GlobalNamespace__Group_2_2__1 : rule__GlobalNamespace__Group_2_2__1__Impl ;
    public final void rule__GlobalNamespace__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3104:1: ( rule__GlobalNamespace__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3105:2: rule__GlobalNamespace__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2_2__1"


    // $ANTLR start "rule__GlobalNamespace__Group_2_2__1__Impl"
    // InternalBasicsParser.g:3111:1: rule__GlobalNamespace__Group_2_2__1__Impl : ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) ) ;
    public final void rule__GlobalNamespace__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3115:1: ( ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3116:1: ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3116:1: ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3117:2: ( rule__GlobalNamespace__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3118:2: ( rule__GlobalNamespace__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3118:3: rule__GlobalNamespace__PartsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__GlobalNamespace__PartsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__Group_2_2__1__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group__0"
    // InternalBasicsParser.g:3127:1: rule__RelativeNamespace_Impl__Group__0 : rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1 ;
    public final void rule__RelativeNamespace_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3131:1: ( rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1 )
            // InternalBasicsParser.g:3132:2: rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__RelativeNamespace_Impl__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group__0"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group__0__Impl"
    // InternalBasicsParser.g:3139:1: rule__RelativeNamespace_Impl__Group__0__Impl : ( () ) ;
    public final void rule__RelativeNamespace_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3143:1: ( ( () ) )
            // InternalBasicsParser.g:3144:1: ( () )
            {
            // InternalBasicsParser.g:3144:1: ( () )
            // InternalBasicsParser.g:3145:2: ()
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0()); 
            // InternalBasicsParser.g:3146:2: ()
            // InternalBasicsParser.g:3146:3: 
            {
            }

             after(grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group__0__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group__1"
    // InternalBasicsParser.g:3154:1: rule__RelativeNamespace_Impl__Group__1 : rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2 ;
    public final void rule__RelativeNamespace_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3158:1: ( rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2 )
            // InternalBasicsParser.g:3159:2: rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__RelativeNamespace_Impl__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group__1"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group__1__Impl"
    // InternalBasicsParser.g:3166:1: rule__RelativeNamespace_Impl__Group__1__Impl : ( RelativeNamespace ) ;
    public final void rule__RelativeNamespace_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3170:1: ( ( RelativeNamespace ) )
            // InternalBasicsParser.g:3171:1: ( RelativeNamespace )
            {
            // InternalBasicsParser.g:3171:1: ( RelativeNamespace )
            // InternalBasicsParser.g:3172:2: RelativeNamespace
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1()); 
            match(input,RelativeNamespace,FOLLOW_2); 
             after(grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group__1__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group__2"
    // InternalBasicsParser.g:3181:1: rule__RelativeNamespace_Impl__Group__2 : rule__RelativeNamespace_Impl__Group__2__Impl ;
    public final void rule__RelativeNamespace_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3185:1: ( rule__RelativeNamespace_Impl__Group__2__Impl )
            // InternalBasicsParser.g:3186:2: rule__RelativeNamespace_Impl__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group__2"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group__2__Impl"
    // InternalBasicsParser.g:3192:1: rule__RelativeNamespace_Impl__Group__2__Impl : ( ( rule__RelativeNamespace_Impl__Group_2__0 )? ) ;
    public final void rule__RelativeNamespace_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3196:1: ( ( ( rule__RelativeNamespace_Impl__Group_2__0 )? ) )
            // InternalBasicsParser.g:3197:1: ( ( rule__RelativeNamespace_Impl__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3197:1: ( ( rule__RelativeNamespace_Impl__Group_2__0 )? )
            // InternalBasicsParser.g:3198:2: ( rule__RelativeNamespace_Impl__Group_2__0 )?
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2()); 
            // InternalBasicsParser.g:3199:2: ( rule__RelativeNamespace_Impl__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LeftSquareBracket) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBasicsParser.g:3199:3: rule__RelativeNamespace_Impl__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RelativeNamespace_Impl__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group__2__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__0"
    // InternalBasicsParser.g:3208:1: rule__RelativeNamespace_Impl__Group_2__0 : rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1 ;
    public final void rule__RelativeNamespace_Impl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3212:1: ( rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1 )
            // InternalBasicsParser.g:3213:2: rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__RelativeNamespace_Impl__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__0"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__0__Impl"
    // InternalBasicsParser.g:3220:1: rule__RelativeNamespace_Impl__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3224:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3225:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3225:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3226:2: LeftSquareBracket
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__0__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__1"
    // InternalBasicsParser.g:3235:1: rule__RelativeNamespace_Impl__Group_2__1 : rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2 ;
    public final void rule__RelativeNamespace_Impl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3239:1: ( rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2 )
            // InternalBasicsParser.g:3240:2: rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2
            {
            pushFollow(FOLLOW_6);
            rule__RelativeNamespace_Impl__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__1"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__1__Impl"
    // InternalBasicsParser.g:3247:1: rule__RelativeNamespace_Impl__Group_2__1__Impl : ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3251:1: ( ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3252:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3252:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3253:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3254:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3254:3: rule__RelativeNamespace_Impl__PartsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__PartsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__1__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__2"
    // InternalBasicsParser.g:3262:1: rule__RelativeNamespace_Impl__Group_2__2 : rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3 ;
    public final void rule__RelativeNamespace_Impl__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3266:1: ( rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3 )
            // InternalBasicsParser.g:3267:2: rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3
            {
            pushFollow(FOLLOW_6);
            rule__RelativeNamespace_Impl__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__2"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__2__Impl"
    // InternalBasicsParser.g:3274:1: rule__RelativeNamespace_Impl__Group_2__2__Impl : ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3278:1: ( ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3279:1: ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3279:1: ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* )
            // InternalBasicsParser.g:3280:2: ( rule__RelativeNamespace_Impl__Group_2_2__0 )*
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3281:2: ( rule__RelativeNamespace_Impl__Group_2_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Comma) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBasicsParser.g:3281:3: rule__RelativeNamespace_Impl__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__RelativeNamespace_Impl__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__2__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__3"
    // InternalBasicsParser.g:3289:1: rule__RelativeNamespace_Impl__Group_2__3 : rule__RelativeNamespace_Impl__Group_2__3__Impl ;
    public final void rule__RelativeNamespace_Impl__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3293:1: ( rule__RelativeNamespace_Impl__Group_2__3__Impl )
            // InternalBasicsParser.g:3294:2: rule__RelativeNamespace_Impl__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__3"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2__3__Impl"
    // InternalBasicsParser.g:3300:1: rule__RelativeNamespace_Impl__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3304:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3305:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3305:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3306:2: RightSquareBracket
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getRightSquareBracketKeyword_2_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getRelativeNamespace_ImplAccess().getRightSquareBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2__3__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2_2__0"
    // InternalBasicsParser.g:3316:1: rule__RelativeNamespace_Impl__Group_2_2__0 : rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1 ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3320:1: ( rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1 )
            // InternalBasicsParser.g:3321:2: rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1
            {
            pushFollow(FOLLOW_5);
            rule__RelativeNamespace_Impl__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2_2__0"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2_2__0__Impl"
    // InternalBasicsParser.g:3328:1: rule__RelativeNamespace_Impl__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3332:1: ( ( Comma ) )
            // InternalBasicsParser.g:3333:1: ( Comma )
            {
            // InternalBasicsParser.g:3333:1: ( Comma )
            // InternalBasicsParser.g:3334:2: Comma
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2_2__0__Impl"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2_2__1"
    // InternalBasicsParser.g:3343:1: rule__RelativeNamespace_Impl__Group_2_2__1 : rule__RelativeNamespace_Impl__Group_2_2__1__Impl ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3347:1: ( rule__RelativeNamespace_Impl__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3348:2: rule__RelativeNamespace_Impl__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2_2__1"


    // $ANTLR start "rule__RelativeNamespace_Impl__Group_2_2__1__Impl"
    // InternalBasicsParser.g:3354:1: rule__RelativeNamespace_Impl__Group_2_2__1__Impl : ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) ) ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3358:1: ( ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3359:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3359:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3360:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3361:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3361:3: rule__RelativeNamespace_Impl__PartsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__RelativeNamespace_Impl__PartsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__Group_2_2__1__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group__0"
    // InternalBasicsParser.g:3370:1: rule__PrivateNamespace__Group__0 : rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1 ;
    public final void rule__PrivateNamespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3374:1: ( rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1 )
            // InternalBasicsParser.g:3375:2: rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__PrivateNamespace__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group__0"


    // $ANTLR start "rule__PrivateNamespace__Group__0__Impl"
    // InternalBasicsParser.g:3382:1: rule__PrivateNamespace__Group__0__Impl : ( () ) ;
    public final void rule__PrivateNamespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3386:1: ( ( () ) )
            // InternalBasicsParser.g:3387:1: ( () )
            {
            // InternalBasicsParser.g:3387:1: ( () )
            // InternalBasicsParser.g:3388:2: ()
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0()); 
            // InternalBasicsParser.g:3389:2: ()
            // InternalBasicsParser.g:3389:3: 
            {
            }

             after(grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group__0__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group__1"
    // InternalBasicsParser.g:3397:1: rule__PrivateNamespace__Group__1 : rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2 ;
    public final void rule__PrivateNamespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3401:1: ( rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2 )
            // InternalBasicsParser.g:3402:2: rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__PrivateNamespace__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group__1"


    // $ANTLR start "rule__PrivateNamespace__Group__1__Impl"
    // InternalBasicsParser.g:3409:1: rule__PrivateNamespace__Group__1__Impl : ( PrivateNamespace ) ;
    public final void rule__PrivateNamespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3413:1: ( ( PrivateNamespace ) )
            // InternalBasicsParser.g:3414:1: ( PrivateNamespace )
            {
            // InternalBasicsParser.g:3414:1: ( PrivateNamespace )
            // InternalBasicsParser.g:3415:2: PrivateNamespace
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1()); 
            match(input,PrivateNamespace,FOLLOW_2); 
             after(grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group__1__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group__2"
    // InternalBasicsParser.g:3424:1: rule__PrivateNamespace__Group__2 : rule__PrivateNamespace__Group__2__Impl ;
    public final void rule__PrivateNamespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3428:1: ( rule__PrivateNamespace__Group__2__Impl )
            // InternalBasicsParser.g:3429:2: rule__PrivateNamespace__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group__2"


    // $ANTLR start "rule__PrivateNamespace__Group__2__Impl"
    // InternalBasicsParser.g:3435:1: rule__PrivateNamespace__Group__2__Impl : ( ( rule__PrivateNamespace__Group_2__0 )? ) ;
    public final void rule__PrivateNamespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3439:1: ( ( ( rule__PrivateNamespace__Group_2__0 )? ) )
            // InternalBasicsParser.g:3440:1: ( ( rule__PrivateNamespace__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3440:1: ( ( rule__PrivateNamespace__Group_2__0 )? )
            // InternalBasicsParser.g:3441:2: ( rule__PrivateNamespace__Group_2__0 )?
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup_2()); 
            // InternalBasicsParser.g:3442:2: ( rule__PrivateNamespace__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LeftSquareBracket) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalBasicsParser.g:3442:3: rule__PrivateNamespace__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrivateNamespace__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPrivateNamespaceAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group__2__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group_2__0"
    // InternalBasicsParser.g:3451:1: rule__PrivateNamespace__Group_2__0 : rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1 ;
    public final void rule__PrivateNamespace__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3455:1: ( rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1 )
            // InternalBasicsParser.g:3456:2: rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__PrivateNamespace__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__0"


    // $ANTLR start "rule__PrivateNamespace__Group_2__0__Impl"
    // InternalBasicsParser.g:3463:1: rule__PrivateNamespace__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__PrivateNamespace__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3467:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3468:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3468:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3469:2: LeftSquareBracket
            {
             before(grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__0__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group_2__1"
    // InternalBasicsParser.g:3478:1: rule__PrivateNamespace__Group_2__1 : rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2 ;
    public final void rule__PrivateNamespace__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3482:1: ( rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2 )
            // InternalBasicsParser.g:3483:2: rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2
            {
            pushFollow(FOLLOW_6);
            rule__PrivateNamespace__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__1"


    // $ANTLR start "rule__PrivateNamespace__Group_2__1__Impl"
    // InternalBasicsParser.g:3490:1: rule__PrivateNamespace__Group_2__1__Impl : ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) ) ;
    public final void rule__PrivateNamespace__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3494:1: ( ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3495:1: ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3495:1: ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3496:2: ( rule__PrivateNamespace__PartsAssignment_2_1 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3497:2: ( rule__PrivateNamespace__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3497:3: rule__PrivateNamespace__PartsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__PartsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__1__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group_2__2"
    // InternalBasicsParser.g:3505:1: rule__PrivateNamespace__Group_2__2 : rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3 ;
    public final void rule__PrivateNamespace__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3509:1: ( rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3 )
            // InternalBasicsParser.g:3510:2: rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3
            {
            pushFollow(FOLLOW_6);
            rule__PrivateNamespace__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__2"


    // $ANTLR start "rule__PrivateNamespace__Group_2__2__Impl"
    // InternalBasicsParser.g:3517:1: rule__PrivateNamespace__Group_2__2__Impl : ( ( rule__PrivateNamespace__Group_2_2__0 )* ) ;
    public final void rule__PrivateNamespace__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3521:1: ( ( ( rule__PrivateNamespace__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3522:1: ( ( rule__PrivateNamespace__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3522:1: ( ( rule__PrivateNamespace__Group_2_2__0 )* )
            // InternalBasicsParser.g:3523:2: ( rule__PrivateNamespace__Group_2_2__0 )*
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3524:2: ( rule__PrivateNamespace__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Comma) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBasicsParser.g:3524:3: rule__PrivateNamespace__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__PrivateNamespace__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getPrivateNamespaceAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__2__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group_2__3"
    // InternalBasicsParser.g:3532:1: rule__PrivateNamespace__Group_2__3 : rule__PrivateNamespace__Group_2__3__Impl ;
    public final void rule__PrivateNamespace__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3536:1: ( rule__PrivateNamespace__Group_2__3__Impl )
            // InternalBasicsParser.g:3537:2: rule__PrivateNamespace__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__3"


    // $ANTLR start "rule__PrivateNamespace__Group_2__3__Impl"
    // InternalBasicsParser.g:3543:1: rule__PrivateNamespace__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__PrivateNamespace__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3547:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3548:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3548:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3549:2: RightSquareBracket
            {
             before(grammarAccess.getPrivateNamespaceAccess().getRightSquareBracketKeyword_2_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getPrivateNamespaceAccess().getRightSquareBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2__3__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group_2_2__0"
    // InternalBasicsParser.g:3559:1: rule__PrivateNamespace__Group_2_2__0 : rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1 ;
    public final void rule__PrivateNamespace__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3563:1: ( rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1 )
            // InternalBasicsParser.g:3564:2: rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1
            {
            pushFollow(FOLLOW_5);
            rule__PrivateNamespace__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2_2__0"


    // $ANTLR start "rule__PrivateNamespace__Group_2_2__0__Impl"
    // InternalBasicsParser.g:3571:1: rule__PrivateNamespace__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__PrivateNamespace__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3575:1: ( ( Comma ) )
            // InternalBasicsParser.g:3576:1: ( Comma )
            {
            // InternalBasicsParser.g:3576:1: ( Comma )
            // InternalBasicsParser.g:3577:2: Comma
            {
             before(grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2_2__0__Impl"


    // $ANTLR start "rule__PrivateNamespace__Group_2_2__1"
    // InternalBasicsParser.g:3586:1: rule__PrivateNamespace__Group_2_2__1 : rule__PrivateNamespace__Group_2_2__1__Impl ;
    public final void rule__PrivateNamespace__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3590:1: ( rule__PrivateNamespace__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3591:2: rule__PrivateNamespace__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2_2__1"


    // $ANTLR start "rule__PrivateNamespace__Group_2_2__1__Impl"
    // InternalBasicsParser.g:3597:1: rule__PrivateNamespace__Group_2_2__1__Impl : ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) ) ;
    public final void rule__PrivateNamespace__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3601:1: ( ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3602:1: ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3602:1: ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3603:2: ( rule__PrivateNamespace__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3604:2: ( rule__PrivateNamespace__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3604:3: rule__PrivateNamespace__PartsAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PrivateNamespace__PartsAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__Group_2_2__1__Impl"


    // $ANTLR start "rule__ParameterListType__Group__0"
    // InternalBasicsParser.g:3613:1: rule__ParameterListType__Group__0 : rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1 ;
    public final void rule__ParameterListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3617:1: ( rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1 )
            // InternalBasicsParser.g:3618:2: rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__ParameterListType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__0"


    // $ANTLR start "rule__ParameterListType__Group__0__Impl"
    // InternalBasicsParser.g:3625:1: rule__ParameterListType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3629:1: ( ( () ) )
            // InternalBasicsParser.g:3630:1: ( () )
            {
            // InternalBasicsParser.g:3630:1: ( () )
            // InternalBasicsParser.g:3631:2: ()
            {
             before(grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0()); 
            // InternalBasicsParser.g:3632:2: ()
            // InternalBasicsParser.g:3632:3: 
            {
            }

             after(grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__0__Impl"


    // $ANTLR start "rule__ParameterListType__Group__1"
    // InternalBasicsParser.g:3640:1: rule__ParameterListType__Group__1 : rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2 ;
    public final void rule__ParameterListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3644:1: ( rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2 )
            // InternalBasicsParser.g:3645:2: rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ParameterListType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__1"


    // $ANTLR start "rule__ParameterListType__Group__1__Impl"
    // InternalBasicsParser.g:3652:1: rule__ParameterListType__Group__1__Impl : ( List ) ;
    public final void rule__ParameterListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3656:1: ( ( List ) )
            // InternalBasicsParser.g:3657:1: ( List )
            {
            // InternalBasicsParser.g:3657:1: ( List )
            // InternalBasicsParser.g:3658:2: List
            {
             before(grammarAccess.getParameterListTypeAccess().getListKeyword_1()); 
            match(input,List,FOLLOW_2); 
             after(grammarAccess.getParameterListTypeAccess().getListKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__1__Impl"


    // $ANTLR start "rule__ParameterListType__Group__2"
    // InternalBasicsParser.g:3667:1: rule__ParameterListType__Group__2 : rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3 ;
    public final void rule__ParameterListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3671:1: ( rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3 )
            // InternalBasicsParser.g:3672:2: rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__ParameterListType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__2"


    // $ANTLR start "rule__ParameterListType__Group__2__Impl"
    // InternalBasicsParser.g:3679:1: rule__ParameterListType__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3683:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3684:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3684:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3685:2: LeftSquareBracket
            {
             before(grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__2__Impl"


    // $ANTLR start "rule__ParameterListType__Group__3"
    // InternalBasicsParser.g:3694:1: rule__ParameterListType__Group__3 : rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4 ;
    public final void rule__ParameterListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3698:1: ( rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4 )
            // InternalBasicsParser.g:3699:2: rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__ParameterListType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__3"


    // $ANTLR start "rule__ParameterListType__Group__3__Impl"
    // InternalBasicsParser.g:3706:1: rule__ParameterListType__Group__3__Impl : ( ( rule__ParameterListType__SequenceAssignment_3 ) ) ;
    public final void rule__ParameterListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3710:1: ( ( ( rule__ParameterListType__SequenceAssignment_3 ) ) )
            // InternalBasicsParser.g:3711:1: ( ( rule__ParameterListType__SequenceAssignment_3 ) )
            {
            // InternalBasicsParser.g:3711:1: ( ( rule__ParameterListType__SequenceAssignment_3 ) )
            // InternalBasicsParser.g:3712:2: ( rule__ParameterListType__SequenceAssignment_3 )
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_3()); 
            // InternalBasicsParser.g:3713:2: ( rule__ParameterListType__SequenceAssignment_3 )
            // InternalBasicsParser.g:3713:3: rule__ParameterListType__SequenceAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ParameterListType__SequenceAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__3__Impl"


    // $ANTLR start "rule__ParameterListType__Group__4"
    // InternalBasicsParser.g:3721:1: rule__ParameterListType__Group__4 : rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5 ;
    public final void rule__ParameterListType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3725:1: ( rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5 )
            // InternalBasicsParser.g:3726:2: rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__ParameterListType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__4"


    // $ANTLR start "rule__ParameterListType__Group__4__Impl"
    // InternalBasicsParser.g:3733:1: rule__ParameterListType__Group__4__Impl : ( ( rule__ParameterListType__Group_4__0 )* ) ;
    public final void rule__ParameterListType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3737:1: ( ( ( rule__ParameterListType__Group_4__0 )* ) )
            // InternalBasicsParser.g:3738:1: ( ( rule__ParameterListType__Group_4__0 )* )
            {
            // InternalBasicsParser.g:3738:1: ( ( rule__ParameterListType__Group_4__0 )* )
            // InternalBasicsParser.g:3739:2: ( rule__ParameterListType__Group_4__0 )*
            {
             before(grammarAccess.getParameterListTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:3740:2: ( rule__ParameterListType__Group_4__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==Comma) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBasicsParser.g:3740:3: rule__ParameterListType__Group_4__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__ParameterListType__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getParameterListTypeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__4__Impl"


    // $ANTLR start "rule__ParameterListType__Group__5"
    // InternalBasicsParser.g:3748:1: rule__ParameterListType__Group__5 : rule__ParameterListType__Group__5__Impl ;
    public final void rule__ParameterListType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3752:1: ( rule__ParameterListType__Group__5__Impl )
            // InternalBasicsParser.g:3753:2: rule__ParameterListType__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__5"


    // $ANTLR start "rule__ParameterListType__Group__5__Impl"
    // InternalBasicsParser.g:3759:1: rule__ParameterListType__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterListType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3763:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3764:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3764:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3765:2: RightSquareBracket
            {
             before(grammarAccess.getParameterListTypeAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterListTypeAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group__5__Impl"


    // $ANTLR start "rule__ParameterListType__Group_4__0"
    // InternalBasicsParser.g:3775:1: rule__ParameterListType__Group_4__0 : rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1 ;
    public final void rule__ParameterListType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3779:1: ( rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1 )
            // InternalBasicsParser.g:3780:2: rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1
            {
            pushFollow(FOLLOW_11);
            rule__ParameterListType__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group_4__0"


    // $ANTLR start "rule__ParameterListType__Group_4__0__Impl"
    // InternalBasicsParser.g:3787:1: rule__ParameterListType__Group_4__0__Impl : ( Comma ) ;
    public final void rule__ParameterListType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3791:1: ( ( Comma ) )
            // InternalBasicsParser.g:3792:1: ( Comma )
            {
            // InternalBasicsParser.g:3792:1: ( Comma )
            // InternalBasicsParser.g:3793:2: Comma
            {
             before(grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group_4__0__Impl"


    // $ANTLR start "rule__ParameterListType__Group_4__1"
    // InternalBasicsParser.g:3802:1: rule__ParameterListType__Group_4__1 : rule__ParameterListType__Group_4__1__Impl ;
    public final void rule__ParameterListType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3806:1: ( rule__ParameterListType__Group_4__1__Impl )
            // InternalBasicsParser.g:3807:2: rule__ParameterListType__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterListType__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group_4__1"


    // $ANTLR start "rule__ParameterListType__Group_4__1__Impl"
    // InternalBasicsParser.g:3813:1: rule__ParameterListType__Group_4__1__Impl : ( ( rule__ParameterListType__SequenceAssignment_4_1 ) ) ;
    public final void rule__ParameterListType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3817:1: ( ( ( rule__ParameterListType__SequenceAssignment_4_1 ) ) )
            // InternalBasicsParser.g:3818:1: ( ( rule__ParameterListType__SequenceAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:3818:1: ( ( rule__ParameterListType__SequenceAssignment_4_1 ) )
            // InternalBasicsParser.g:3819:2: ( rule__ParameterListType__SequenceAssignment_4_1 )
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_4_1()); 
            // InternalBasicsParser.g:3820:2: ( rule__ParameterListType__SequenceAssignment_4_1 )
            // InternalBasicsParser.g:3820:3: rule__ParameterListType__SequenceAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterListType__SequenceAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__Group_4__1__Impl"


    // $ANTLR start "rule__ParameterStructType__Group__0"
    // InternalBasicsParser.g:3829:1: rule__ParameterStructType__Group__0 : rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1 ;
    public final void rule__ParameterStructType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3833:1: ( rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1 )
            // InternalBasicsParser.g:3834:2: rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__ParameterStructType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__0"


    // $ANTLR start "rule__ParameterStructType__Group__0__Impl"
    // InternalBasicsParser.g:3841:1: rule__ParameterStructType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStructType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3845:1: ( ( () ) )
            // InternalBasicsParser.g:3846:1: ( () )
            {
            // InternalBasicsParser.g:3846:1: ( () )
            // InternalBasicsParser.g:3847:2: ()
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0()); 
            // InternalBasicsParser.g:3848:2: ()
            // InternalBasicsParser.g:3848:3: 
            {
            }

             after(grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__0__Impl"


    // $ANTLR start "rule__ParameterStructType__Group__1"
    // InternalBasicsParser.g:3856:1: rule__ParameterStructType__Group__1 : rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2 ;
    public final void rule__ParameterStructType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3860:1: ( rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2 )
            // InternalBasicsParser.g:3861:2: rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ParameterStructType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__1"


    // $ANTLR start "rule__ParameterStructType__Group__1__Impl"
    // InternalBasicsParser.g:3868:1: rule__ParameterStructType__Group__1__Impl : ( Struct ) ;
    public final void rule__ParameterStructType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3872:1: ( ( Struct ) )
            // InternalBasicsParser.g:3873:1: ( Struct )
            {
            // InternalBasicsParser.g:3873:1: ( Struct )
            // InternalBasicsParser.g:3874:2: Struct
            {
             before(grammarAccess.getParameterStructTypeAccess().getStructKeyword_1()); 
            match(input,Struct,FOLLOW_2); 
             after(grammarAccess.getParameterStructTypeAccess().getStructKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__1__Impl"


    // $ANTLR start "rule__ParameterStructType__Group__2"
    // InternalBasicsParser.g:3883:1: rule__ParameterStructType__Group__2 : rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3 ;
    public final void rule__ParameterStructType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3887:1: ( rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3 )
            // InternalBasicsParser.g:3888:2: rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__ParameterStructType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__2"


    // $ANTLR start "rule__ParameterStructType__Group__2__Impl"
    // InternalBasicsParser.g:3895:1: rule__ParameterStructType__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterStructType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3899:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3900:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3900:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3901:2: LeftSquareBracket
            {
             before(grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__2__Impl"


    // $ANTLR start "rule__ParameterStructType__Group__3"
    // InternalBasicsParser.g:3910:1: rule__ParameterStructType__Group__3 : rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4 ;
    public final void rule__ParameterStructType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3914:1: ( rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4 )
            // InternalBasicsParser.g:3915:2: rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__ParameterStructType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__3"


    // $ANTLR start "rule__ParameterStructType__Group__3__Impl"
    // InternalBasicsParser.g:3922:1: rule__ParameterStructType__Group__3__Impl : ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) ) ;
    public final void rule__ParameterStructType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3926:1: ( ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) ) )
            // InternalBasicsParser.g:3927:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) )
            {
            // InternalBasicsParser.g:3927:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) )
            // InternalBasicsParser.g:3928:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_3()); 
            // InternalBasicsParser.g:3929:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 )
            // InternalBasicsParser.g:3929:3: rule__ParameterStructType__ParameterstructypetmemberAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructType__ParameterstructypetmemberAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__3__Impl"


    // $ANTLR start "rule__ParameterStructType__Group__4"
    // InternalBasicsParser.g:3937:1: rule__ParameterStructType__Group__4 : rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5 ;
    public final void rule__ParameterStructType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3941:1: ( rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5 )
            // InternalBasicsParser.g:3942:2: rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__ParameterStructType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__4"


    // $ANTLR start "rule__ParameterStructType__Group__4__Impl"
    // InternalBasicsParser.g:3949:1: rule__ParameterStructType__Group__4__Impl : ( ( rule__ParameterStructType__Group_4__0 )* ) ;
    public final void rule__ParameterStructType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3953:1: ( ( ( rule__ParameterStructType__Group_4__0 )* ) )
            // InternalBasicsParser.g:3954:1: ( ( rule__ParameterStructType__Group_4__0 )* )
            {
            // InternalBasicsParser.g:3954:1: ( ( rule__ParameterStructType__Group_4__0 )* )
            // InternalBasicsParser.g:3955:2: ( rule__ParameterStructType__Group_4__0 )*
            {
             before(grammarAccess.getParameterStructTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:3956:2: ( rule__ParameterStructType__Group_4__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==Comma) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBasicsParser.g:3956:3: rule__ParameterStructType__Group_4__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__ParameterStructType__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getParameterStructTypeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__4__Impl"


    // $ANTLR start "rule__ParameterStructType__Group__5"
    // InternalBasicsParser.g:3964:1: rule__ParameterStructType__Group__5 : rule__ParameterStructType__Group__5__Impl ;
    public final void rule__ParameterStructType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3968:1: ( rule__ParameterStructType__Group__5__Impl )
            // InternalBasicsParser.g:3969:2: rule__ParameterStructType__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__5"


    // $ANTLR start "rule__ParameterStructType__Group__5__Impl"
    // InternalBasicsParser.g:3975:1: rule__ParameterStructType__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterStructType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3979:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3980:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3980:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3981:2: RightSquareBracket
            {
             before(grammarAccess.getParameterStructTypeAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterStructTypeAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group__5__Impl"


    // $ANTLR start "rule__ParameterStructType__Group_4__0"
    // InternalBasicsParser.g:3991:1: rule__ParameterStructType__Group_4__0 : rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1 ;
    public final void rule__ParameterStructType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3995:1: ( rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1 )
            // InternalBasicsParser.g:3996:2: rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1
            {
            pushFollow(FOLLOW_13);
            rule__ParameterStructType__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group_4__0"


    // $ANTLR start "rule__ParameterStructType__Group_4__0__Impl"
    // InternalBasicsParser.g:4003:1: rule__ParameterStructType__Group_4__0__Impl : ( Comma ) ;
    public final void rule__ParameterStructType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4007:1: ( ( Comma ) )
            // InternalBasicsParser.g:4008:1: ( Comma )
            {
            // InternalBasicsParser.g:4008:1: ( Comma )
            // InternalBasicsParser.g:4009:2: Comma
            {
             before(grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group_4__0__Impl"


    // $ANTLR start "rule__ParameterStructType__Group_4__1"
    // InternalBasicsParser.g:4018:1: rule__ParameterStructType__Group_4__1 : rule__ParameterStructType__Group_4__1__Impl ;
    public final void rule__ParameterStructType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4022:1: ( rule__ParameterStructType__Group_4__1__Impl )
            // InternalBasicsParser.g:4023:2: rule__ParameterStructType__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructType__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group_4__1"


    // $ANTLR start "rule__ParameterStructType__Group_4__1__Impl"
    // InternalBasicsParser.g:4029:1: rule__ParameterStructType__Group_4__1__Impl : ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) ) ;
    public final void rule__ParameterStructType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4033:1: ( ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) ) )
            // InternalBasicsParser.g:4034:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:4034:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) )
            // InternalBasicsParser.g:4035:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_4_1()); 
            // InternalBasicsParser.g:4036:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 )
            // InternalBasicsParser.g:4036:3: rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__Group_4__1__Impl"


    // $ANTLR start "rule__ParameterIntegerType__Group__0"
    // InternalBasicsParser.g:4045:1: rule__ParameterIntegerType__Group__0 : rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1 ;
    public final void rule__ParameterIntegerType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4049:1: ( rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1 )
            // InternalBasicsParser.g:4050:2: rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__ParameterIntegerType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterIntegerType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group__0"


    // $ANTLR start "rule__ParameterIntegerType__Group__0__Impl"
    // InternalBasicsParser.g:4057:1: rule__ParameterIntegerType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterIntegerType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4061:1: ( ( () ) )
            // InternalBasicsParser.g:4062:1: ( () )
            {
            // InternalBasicsParser.g:4062:1: ( () )
            // InternalBasicsParser.g:4063:2: ()
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0()); 
            // InternalBasicsParser.g:4064:2: ()
            // InternalBasicsParser.g:4064:3: 
            {
            }

             after(grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group__0__Impl"


    // $ANTLR start "rule__ParameterIntegerType__Group__1"
    // InternalBasicsParser.g:4072:1: rule__ParameterIntegerType__Group__1 : rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2 ;
    public final void rule__ParameterIntegerType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4076:1: ( rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2 )
            // InternalBasicsParser.g:4077:2: rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ParameterIntegerType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterIntegerType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group__1"


    // $ANTLR start "rule__ParameterIntegerType__Group__1__Impl"
    // InternalBasicsParser.g:4084:1: rule__ParameterIntegerType__Group__1__Impl : ( Integer ) ;
    public final void rule__ParameterIntegerType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4088:1: ( ( Integer ) )
            // InternalBasicsParser.g:4089:1: ( Integer )
            {
            // InternalBasicsParser.g:4089:1: ( Integer )
            // InternalBasicsParser.g:4090:2: Integer
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1()); 
            match(input,Integer,FOLLOW_2); 
             after(grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group__1__Impl"


    // $ANTLR start "rule__ParameterIntegerType__Group__2"
    // InternalBasicsParser.g:4099:1: rule__ParameterIntegerType__Group__2 : rule__ParameterIntegerType__Group__2__Impl ;
    public final void rule__ParameterIntegerType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4103:1: ( rule__ParameterIntegerType__Group__2__Impl )
            // InternalBasicsParser.g:4104:2: rule__ParameterIntegerType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterIntegerType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group__2"


    // $ANTLR start "rule__ParameterIntegerType__Group__2__Impl"
    // InternalBasicsParser.g:4110:1: rule__ParameterIntegerType__Group__2__Impl : ( ( rule__ParameterIntegerType__Group_2__0 )? ) ;
    public final void rule__ParameterIntegerType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4114:1: ( ( ( rule__ParameterIntegerType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4115:1: ( ( rule__ParameterIntegerType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4115:1: ( ( rule__ParameterIntegerType__Group_2__0 )? )
            // InternalBasicsParser.g:4116:2: ( rule__ParameterIntegerType__Group_2__0 )?
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4117:2: ( rule__ParameterIntegerType__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Default) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalBasicsParser.g:4117:3: rule__ParameterIntegerType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterIntegerType__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterIntegerTypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group__2__Impl"


    // $ANTLR start "rule__ParameterIntegerType__Group_2__0"
    // InternalBasicsParser.g:4126:1: rule__ParameterIntegerType__Group_2__0 : rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1 ;
    public final void rule__ParameterIntegerType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4130:1: ( rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1 )
            // InternalBasicsParser.g:4131:2: rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1
            {
            pushFollow(FOLLOW_16);
            rule__ParameterIntegerType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterIntegerType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group_2__0"


    // $ANTLR start "rule__ParameterIntegerType__Group_2__0__Impl"
    // InternalBasicsParser.g:4138:1: rule__ParameterIntegerType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterIntegerType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4142:1: ( ( Default ) )
            // InternalBasicsParser.g:4143:1: ( Default )
            {
            // InternalBasicsParser.g:4143:1: ( Default )
            // InternalBasicsParser.g:4144:2: Default
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0()); 
            match(input,Default,FOLLOW_2); 
             after(grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group_2__0__Impl"


    // $ANTLR start "rule__ParameterIntegerType__Group_2__1"
    // InternalBasicsParser.g:4153:1: rule__ParameterIntegerType__Group_2__1 : rule__ParameterIntegerType__Group_2__1__Impl ;
    public final void rule__ParameterIntegerType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4157:1: ( rule__ParameterIntegerType__Group_2__1__Impl )
            // InternalBasicsParser.g:4158:2: rule__ParameterIntegerType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterIntegerType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group_2__1"


    // $ANTLR start "rule__ParameterIntegerType__Group_2__1__Impl"
    // InternalBasicsParser.g:4164:1: rule__ParameterIntegerType__Group_2__1__Impl : ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterIntegerType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4168:1: ( ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4169:1: ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4169:1: ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4170:2: ( rule__ParameterIntegerType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4171:2: ( rule__ParameterIntegerType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4171:3: rule__ParameterIntegerType__DefaultAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterIntegerType__DefaultAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterIntegerTypeAccess().getDefaultAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__Group_2__1__Impl"


    // $ANTLR start "rule__ParameterStringType__Group__0"
    // InternalBasicsParser.g:4180:1: rule__ParameterStringType__Group__0 : rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1 ;
    public final void rule__ParameterStringType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4184:1: ( rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1 )
            // InternalBasicsParser.g:4185:2: rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__ParameterStringType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStringType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group__0"


    // $ANTLR start "rule__ParameterStringType__Group__0__Impl"
    // InternalBasicsParser.g:4192:1: rule__ParameterStringType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStringType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4196:1: ( ( () ) )
            // InternalBasicsParser.g:4197:1: ( () )
            {
            // InternalBasicsParser.g:4197:1: ( () )
            // InternalBasicsParser.g:4198:2: ()
            {
             before(grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0()); 
            // InternalBasicsParser.g:4199:2: ()
            // InternalBasicsParser.g:4199:3: 
            {
            }

             after(grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group__0__Impl"


    // $ANTLR start "rule__ParameterStringType__Group__1"
    // InternalBasicsParser.g:4207:1: rule__ParameterStringType__Group__1 : rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2 ;
    public final void rule__ParameterStringType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4211:1: ( rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2 )
            // InternalBasicsParser.g:4212:2: rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ParameterStringType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStringType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group__1"


    // $ANTLR start "rule__ParameterStringType__Group__1__Impl"
    // InternalBasicsParser.g:4219:1: rule__ParameterStringType__Group__1__Impl : ( String ) ;
    public final void rule__ParameterStringType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4223:1: ( ( String ) )
            // InternalBasicsParser.g:4224:1: ( String )
            {
            // InternalBasicsParser.g:4224:1: ( String )
            // InternalBasicsParser.g:4225:2: String
            {
             before(grammarAccess.getParameterStringTypeAccess().getStringKeyword_1()); 
            match(input,String,FOLLOW_2); 
             after(grammarAccess.getParameterStringTypeAccess().getStringKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group__1__Impl"


    // $ANTLR start "rule__ParameterStringType__Group__2"
    // InternalBasicsParser.g:4234:1: rule__ParameterStringType__Group__2 : rule__ParameterStringType__Group__2__Impl ;
    public final void rule__ParameterStringType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4238:1: ( rule__ParameterStringType__Group__2__Impl )
            // InternalBasicsParser.g:4239:2: rule__ParameterStringType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStringType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group__2"


    // $ANTLR start "rule__ParameterStringType__Group__2__Impl"
    // InternalBasicsParser.g:4245:1: rule__ParameterStringType__Group__2__Impl : ( ( rule__ParameterStringType__Group_2__0 )? ) ;
    public final void rule__ParameterStringType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4249:1: ( ( ( rule__ParameterStringType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4250:1: ( ( rule__ParameterStringType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4250:1: ( ( rule__ParameterStringType__Group_2__0 )? )
            // InternalBasicsParser.g:4251:2: ( rule__ParameterStringType__Group_2__0 )?
            {
             before(grammarAccess.getParameterStringTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4252:2: ( rule__ParameterStringType__Group_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Default) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBasicsParser.g:4252:3: rule__ParameterStringType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterStringType__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterStringTypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group__2__Impl"


    // $ANTLR start "rule__ParameterStringType__Group_2__0"
    // InternalBasicsParser.g:4261:1: rule__ParameterStringType__Group_2__0 : rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1 ;
    public final void rule__ParameterStringType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4265:1: ( rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1 )
            // InternalBasicsParser.g:4266:2: rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1
            {
            pushFollow(FOLLOW_13);
            rule__ParameterStringType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStringType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group_2__0"


    // $ANTLR start "rule__ParameterStringType__Group_2__0__Impl"
    // InternalBasicsParser.g:4273:1: rule__ParameterStringType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterStringType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4277:1: ( ( Default ) )
            // InternalBasicsParser.g:4278:1: ( Default )
            {
            // InternalBasicsParser.g:4278:1: ( Default )
            // InternalBasicsParser.g:4279:2: Default
            {
             before(grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0()); 
            match(input,Default,FOLLOW_2); 
             after(grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group_2__0__Impl"


    // $ANTLR start "rule__ParameterStringType__Group_2__1"
    // InternalBasicsParser.g:4288:1: rule__ParameterStringType__Group_2__1 : rule__ParameterStringType__Group_2__1__Impl ;
    public final void rule__ParameterStringType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4292:1: ( rule__ParameterStringType__Group_2__1__Impl )
            // InternalBasicsParser.g:4293:2: rule__ParameterStringType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStringType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group_2__1"


    // $ANTLR start "rule__ParameterStringType__Group_2__1__Impl"
    // InternalBasicsParser.g:4299:1: rule__ParameterStringType__Group_2__1__Impl : ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterStringType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4303:1: ( ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4304:1: ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4304:1: ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4305:2: ( rule__ParameterStringType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterStringTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4306:2: ( rule__ParameterStringType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4306:3: rule__ParameterStringType__DefaultAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStringType__DefaultAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterStringTypeAccess().getDefaultAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__Group_2__1__Impl"


    // $ANTLR start "rule__ParameterDoubleType__Group__0"
    // InternalBasicsParser.g:4315:1: rule__ParameterDoubleType__Group__0 : rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1 ;
    public final void rule__ParameterDoubleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4319:1: ( rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1 )
            // InternalBasicsParser.g:4320:2: rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__ParameterDoubleType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterDoubleType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group__0"


    // $ANTLR start "rule__ParameterDoubleType__Group__0__Impl"
    // InternalBasicsParser.g:4327:1: rule__ParameterDoubleType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterDoubleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4331:1: ( ( () ) )
            // InternalBasicsParser.g:4332:1: ( () )
            {
            // InternalBasicsParser.g:4332:1: ( () )
            // InternalBasicsParser.g:4333:2: ()
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0()); 
            // InternalBasicsParser.g:4334:2: ()
            // InternalBasicsParser.g:4334:3: 
            {
            }

             after(grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group__0__Impl"


    // $ANTLR start "rule__ParameterDoubleType__Group__1"
    // InternalBasicsParser.g:4342:1: rule__ParameterDoubleType__Group__1 : rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2 ;
    public final void rule__ParameterDoubleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4346:1: ( rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2 )
            // InternalBasicsParser.g:4347:2: rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ParameterDoubleType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterDoubleType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group__1"


    // $ANTLR start "rule__ParameterDoubleType__Group__1__Impl"
    // InternalBasicsParser.g:4354:1: rule__ParameterDoubleType__Group__1__Impl : ( Double ) ;
    public final void rule__ParameterDoubleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4358:1: ( ( Double ) )
            // InternalBasicsParser.g:4359:1: ( Double )
            {
            // InternalBasicsParser.g:4359:1: ( Double )
            // InternalBasicsParser.g:4360:2: Double
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1()); 
            match(input,Double,FOLLOW_2); 
             after(grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group__1__Impl"


    // $ANTLR start "rule__ParameterDoubleType__Group__2"
    // InternalBasicsParser.g:4369:1: rule__ParameterDoubleType__Group__2 : rule__ParameterDoubleType__Group__2__Impl ;
    public final void rule__ParameterDoubleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4373:1: ( rule__ParameterDoubleType__Group__2__Impl )
            // InternalBasicsParser.g:4374:2: rule__ParameterDoubleType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterDoubleType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group__2"


    // $ANTLR start "rule__ParameterDoubleType__Group__2__Impl"
    // InternalBasicsParser.g:4380:1: rule__ParameterDoubleType__Group__2__Impl : ( ( rule__ParameterDoubleType__Group_2__0 )? ) ;
    public final void rule__ParameterDoubleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4384:1: ( ( ( rule__ParameterDoubleType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4385:1: ( ( rule__ParameterDoubleType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4385:1: ( ( rule__ParameterDoubleType__Group_2__0 )? )
            // InternalBasicsParser.g:4386:2: ( rule__ParameterDoubleType__Group_2__0 )?
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4387:2: ( rule__ParameterDoubleType__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Default) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBasicsParser.g:4387:3: rule__ParameterDoubleType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterDoubleType__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterDoubleTypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group__2__Impl"


    // $ANTLR start "rule__ParameterDoubleType__Group_2__0"
    // InternalBasicsParser.g:4396:1: rule__ParameterDoubleType__Group_2__0 : rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1 ;
    public final void rule__ParameterDoubleType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4400:1: ( rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1 )
            // InternalBasicsParser.g:4401:2: rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1
            {
            pushFollow(FOLLOW_19);
            rule__ParameterDoubleType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterDoubleType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group_2__0"


    // $ANTLR start "rule__ParameterDoubleType__Group_2__0__Impl"
    // InternalBasicsParser.g:4408:1: rule__ParameterDoubleType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterDoubleType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4412:1: ( ( Default ) )
            // InternalBasicsParser.g:4413:1: ( Default )
            {
            // InternalBasicsParser.g:4413:1: ( Default )
            // InternalBasicsParser.g:4414:2: Default
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0()); 
            match(input,Default,FOLLOW_2); 
             after(grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group_2__0__Impl"


    // $ANTLR start "rule__ParameterDoubleType__Group_2__1"
    // InternalBasicsParser.g:4423:1: rule__ParameterDoubleType__Group_2__1 : rule__ParameterDoubleType__Group_2__1__Impl ;
    public final void rule__ParameterDoubleType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4427:1: ( rule__ParameterDoubleType__Group_2__1__Impl )
            // InternalBasicsParser.g:4428:2: rule__ParameterDoubleType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterDoubleType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group_2__1"


    // $ANTLR start "rule__ParameterDoubleType__Group_2__1__Impl"
    // InternalBasicsParser.g:4434:1: rule__ParameterDoubleType__Group_2__1__Impl : ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterDoubleType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4438:1: ( ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4439:1: ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4439:1: ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4440:2: ( rule__ParameterDoubleType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4441:2: ( rule__ParameterDoubleType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4441:3: rule__ParameterDoubleType__DefaultAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterDoubleType__DefaultAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterDoubleTypeAccess().getDefaultAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__Group_2__1__Impl"


    // $ANTLR start "rule__ParameterBooleanType__Group__0"
    // InternalBasicsParser.g:4450:1: rule__ParameterBooleanType__Group__0 : rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1 ;
    public final void rule__ParameterBooleanType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4454:1: ( rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1 )
            // InternalBasicsParser.g:4455:2: rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__ParameterBooleanType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterBooleanType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group__0"


    // $ANTLR start "rule__ParameterBooleanType__Group__0__Impl"
    // InternalBasicsParser.g:4462:1: rule__ParameterBooleanType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterBooleanType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4466:1: ( ( () ) )
            // InternalBasicsParser.g:4467:1: ( () )
            {
            // InternalBasicsParser.g:4467:1: ( () )
            // InternalBasicsParser.g:4468:2: ()
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0()); 
            // InternalBasicsParser.g:4469:2: ()
            // InternalBasicsParser.g:4469:3: 
            {
            }

             after(grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group__0__Impl"


    // $ANTLR start "rule__ParameterBooleanType__Group__1"
    // InternalBasicsParser.g:4477:1: rule__ParameterBooleanType__Group__1 : rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2 ;
    public final void rule__ParameterBooleanType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4481:1: ( rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2 )
            // InternalBasicsParser.g:4482:2: rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ParameterBooleanType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterBooleanType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group__1"


    // $ANTLR start "rule__ParameterBooleanType__Group__1__Impl"
    // InternalBasicsParser.g:4489:1: rule__ParameterBooleanType__Group__1__Impl : ( Boolean ) ;
    public final void rule__ParameterBooleanType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4493:1: ( ( Boolean ) )
            // InternalBasicsParser.g:4494:1: ( Boolean )
            {
            // InternalBasicsParser.g:4494:1: ( Boolean )
            // InternalBasicsParser.g:4495:2: Boolean
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1()); 
            match(input,Boolean,FOLLOW_2); 
             after(grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group__1__Impl"


    // $ANTLR start "rule__ParameterBooleanType__Group__2"
    // InternalBasicsParser.g:4504:1: rule__ParameterBooleanType__Group__2 : rule__ParameterBooleanType__Group__2__Impl ;
    public final void rule__ParameterBooleanType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4508:1: ( rule__ParameterBooleanType__Group__2__Impl )
            // InternalBasicsParser.g:4509:2: rule__ParameterBooleanType__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBooleanType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group__2"


    // $ANTLR start "rule__ParameterBooleanType__Group__2__Impl"
    // InternalBasicsParser.g:4515:1: rule__ParameterBooleanType__Group__2__Impl : ( ( rule__ParameterBooleanType__Group_2__0 )? ) ;
    public final void rule__ParameterBooleanType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4519:1: ( ( ( rule__ParameterBooleanType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4520:1: ( ( rule__ParameterBooleanType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4520:1: ( ( rule__ParameterBooleanType__Group_2__0 )? )
            // InternalBasicsParser.g:4521:2: ( rule__ParameterBooleanType__Group_2__0 )?
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4522:2: ( rule__ParameterBooleanType__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Default) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBasicsParser.g:4522:3: rule__ParameterBooleanType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterBooleanType__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterBooleanTypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group__2__Impl"


    // $ANTLR start "rule__ParameterBooleanType__Group_2__0"
    // InternalBasicsParser.g:4531:1: rule__ParameterBooleanType__Group_2__0 : rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1 ;
    public final void rule__ParameterBooleanType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4535:1: ( rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1 )
            // InternalBasicsParser.g:4536:2: rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1
            {
            pushFollow(FOLLOW_21);
            rule__ParameterBooleanType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterBooleanType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group_2__0"


    // $ANTLR start "rule__ParameterBooleanType__Group_2__0__Impl"
    // InternalBasicsParser.g:4543:1: rule__ParameterBooleanType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterBooleanType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4547:1: ( ( Default ) )
            // InternalBasicsParser.g:4548:1: ( Default )
            {
            // InternalBasicsParser.g:4548:1: ( Default )
            // InternalBasicsParser.g:4549:2: Default
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0()); 
            match(input,Default,FOLLOW_2); 
             after(grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group_2__0__Impl"


    // $ANTLR start "rule__ParameterBooleanType__Group_2__1"
    // InternalBasicsParser.g:4558:1: rule__ParameterBooleanType__Group_2__1 : rule__ParameterBooleanType__Group_2__1__Impl ;
    public final void rule__ParameterBooleanType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4562:1: ( rule__ParameterBooleanType__Group_2__1__Impl )
            // InternalBasicsParser.g:4563:2: rule__ParameterBooleanType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBooleanType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group_2__1"


    // $ANTLR start "rule__ParameterBooleanType__Group_2__1__Impl"
    // InternalBasicsParser.g:4569:1: rule__ParameterBooleanType__Group_2__1__Impl : ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterBooleanType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4573:1: ( ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4574:1: ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4574:1: ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4575:2: ( rule__ParameterBooleanType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4576:2: ( rule__ParameterBooleanType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4576:3: rule__ParameterBooleanType__DefaultAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBooleanType__DefaultAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterBooleanTypeAccess().getDefaultAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__Group_2__1__Impl"


    // $ANTLR start "rule__ParameterBase64Type__Group__0"
    // InternalBasicsParser.g:4585:1: rule__ParameterBase64Type__Group__0 : rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1 ;
    public final void rule__ParameterBase64Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4589:1: ( rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1 )
            // InternalBasicsParser.g:4590:2: rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__ParameterBase64Type__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterBase64Type__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group__0"


    // $ANTLR start "rule__ParameterBase64Type__Group__0__Impl"
    // InternalBasicsParser.g:4597:1: rule__ParameterBase64Type__Group__0__Impl : ( () ) ;
    public final void rule__ParameterBase64Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4601:1: ( ( () ) )
            // InternalBasicsParser.g:4602:1: ( () )
            {
            // InternalBasicsParser.g:4602:1: ( () )
            // InternalBasicsParser.g:4603:2: ()
            {
             before(grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0()); 
            // InternalBasicsParser.g:4604:2: ()
            // InternalBasicsParser.g:4604:3: 
            {
            }

             after(grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group__0__Impl"


    // $ANTLR start "rule__ParameterBase64Type__Group__1"
    // InternalBasicsParser.g:4612:1: rule__ParameterBase64Type__Group__1 : rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2 ;
    public final void rule__ParameterBase64Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4616:1: ( rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2 )
            // InternalBasicsParser.g:4617:2: rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ParameterBase64Type__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterBase64Type__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group__1"


    // $ANTLR start "rule__ParameterBase64Type__Group__1__Impl"
    // InternalBasicsParser.g:4624:1: rule__ParameterBase64Type__Group__1__Impl : ( Base64 ) ;
    public final void rule__ParameterBase64Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4628:1: ( ( Base64 ) )
            // InternalBasicsParser.g:4629:1: ( Base64 )
            {
            // InternalBasicsParser.g:4629:1: ( Base64 )
            // InternalBasicsParser.g:4630:2: Base64
            {
             before(grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1()); 
            match(input,Base64,FOLLOW_2); 
             after(grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group__1__Impl"


    // $ANTLR start "rule__ParameterBase64Type__Group__2"
    // InternalBasicsParser.g:4639:1: rule__ParameterBase64Type__Group__2 : rule__ParameterBase64Type__Group__2__Impl ;
    public final void rule__ParameterBase64Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4643:1: ( rule__ParameterBase64Type__Group__2__Impl )
            // InternalBasicsParser.g:4644:2: rule__ParameterBase64Type__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBase64Type__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group__2"


    // $ANTLR start "rule__ParameterBase64Type__Group__2__Impl"
    // InternalBasicsParser.g:4650:1: rule__ParameterBase64Type__Group__2__Impl : ( ( rule__ParameterBase64Type__Group_2__0 )? ) ;
    public final void rule__ParameterBase64Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4654:1: ( ( ( rule__ParameterBase64Type__Group_2__0 )? ) )
            // InternalBasicsParser.g:4655:1: ( ( rule__ParameterBase64Type__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4655:1: ( ( rule__ParameterBase64Type__Group_2__0 )? )
            // InternalBasicsParser.g:4656:2: ( rule__ParameterBase64Type__Group_2__0 )?
            {
             before(grammarAccess.getParameterBase64TypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4657:2: ( rule__ParameterBase64Type__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Default) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBasicsParser.g:4657:3: rule__ParameterBase64Type__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterBase64Type__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterBase64TypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group__2__Impl"


    // $ANTLR start "rule__ParameterBase64Type__Group_2__0"
    // InternalBasicsParser.g:4666:1: rule__ParameterBase64Type__Group_2__0 : rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1 ;
    public final void rule__ParameterBase64Type__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4670:1: ( rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1 )
            // InternalBasicsParser.g:4671:2: rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1
            {
            pushFollow(FOLLOW_23);
            rule__ParameterBase64Type__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterBase64Type__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group_2__0"


    // $ANTLR start "rule__ParameterBase64Type__Group_2__0__Impl"
    // InternalBasicsParser.g:4678:1: rule__ParameterBase64Type__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterBase64Type__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4682:1: ( ( Default ) )
            // InternalBasicsParser.g:4683:1: ( Default )
            {
            // InternalBasicsParser.g:4683:1: ( Default )
            // InternalBasicsParser.g:4684:2: Default
            {
             before(grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0()); 
            match(input,Default,FOLLOW_2); 
             after(grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group_2__0__Impl"


    // $ANTLR start "rule__ParameterBase64Type__Group_2__1"
    // InternalBasicsParser.g:4693:1: rule__ParameterBase64Type__Group_2__1 : rule__ParameterBase64Type__Group_2__1__Impl ;
    public final void rule__ParameterBase64Type__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4697:1: ( rule__ParameterBase64Type__Group_2__1__Impl )
            // InternalBasicsParser.g:4698:2: rule__ParameterBase64Type__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBase64Type__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group_2__1"


    // $ANTLR start "rule__ParameterBase64Type__Group_2__1__Impl"
    // InternalBasicsParser.g:4704:1: rule__ParameterBase64Type__Group_2__1__Impl : ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterBase64Type__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4708:1: ( ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4709:1: ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4709:1: ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4710:2: ( rule__ParameterBase64Type__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterBase64TypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4711:2: ( rule__ParameterBase64Type__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4711:3: rule__ParameterBase64Type__DefaultAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterBase64Type__DefaultAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterBase64TypeAccess().getDefaultAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__Group_2__1__Impl"


    // $ANTLR start "rule__ParameterArrayType__Group__0"
    // InternalBasicsParser.g:4720:1: rule__ParameterArrayType__Group__0 : rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1 ;
    public final void rule__ParameterArrayType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4724:1: ( rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1 )
            // InternalBasicsParser.g:4725:2: rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ParameterArrayType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__0"


    // $ANTLR start "rule__ParameterArrayType__Group__0__Impl"
    // InternalBasicsParser.g:4732:1: rule__ParameterArrayType__Group__0__Impl : ( Array ) ;
    public final void rule__ParameterArrayType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4736:1: ( ( Array ) )
            // InternalBasicsParser.g:4737:1: ( Array )
            {
            // InternalBasicsParser.g:4737:1: ( Array )
            // InternalBasicsParser.g:4738:2: Array
            {
             before(grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0()); 
            match(input,Array,FOLLOW_2); 
             after(grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__0__Impl"


    // $ANTLR start "rule__ParameterArrayType__Group__1"
    // InternalBasicsParser.g:4747:1: rule__ParameterArrayType__Group__1 : rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2 ;
    public final void rule__ParameterArrayType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4751:1: ( rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2 )
            // InternalBasicsParser.g:4752:2: rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__ParameterArrayType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__1"


    // $ANTLR start "rule__ParameterArrayType__Group__1__Impl"
    // InternalBasicsParser.g:4759:1: rule__ParameterArrayType__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterArrayType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4763:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:4764:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:4764:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:4765:2: LeftSquareBracket
            {
             before(grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__1__Impl"


    // $ANTLR start "rule__ParameterArrayType__Group__2"
    // InternalBasicsParser.g:4774:1: rule__ParameterArrayType__Group__2 : rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3 ;
    public final void rule__ParameterArrayType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4778:1: ( rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3 )
            // InternalBasicsParser.g:4779:2: rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__ParameterArrayType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__2"


    // $ANTLR start "rule__ParameterArrayType__Group__2__Impl"
    // InternalBasicsParser.g:4786:1: rule__ParameterArrayType__Group__2__Impl : ( ( rule__ParameterArrayType__TypeAssignment_2 ) ) ;
    public final void rule__ParameterArrayType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4790:1: ( ( ( rule__ParameterArrayType__TypeAssignment_2 ) ) )
            // InternalBasicsParser.g:4791:1: ( ( rule__ParameterArrayType__TypeAssignment_2 ) )
            {
            // InternalBasicsParser.g:4791:1: ( ( rule__ParameterArrayType__TypeAssignment_2 ) )
            // InternalBasicsParser.g:4792:2: ( rule__ParameterArrayType__TypeAssignment_2 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getTypeAssignment_2()); 
            // InternalBasicsParser.g:4793:2: ( rule__ParameterArrayType__TypeAssignment_2 )
            // InternalBasicsParser.g:4793:3: rule__ParameterArrayType__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParameterArrayTypeAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__2__Impl"


    // $ANTLR start "rule__ParameterArrayType__Group__3"
    // InternalBasicsParser.g:4801:1: rule__ParameterArrayType__Group__3 : rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4 ;
    public final void rule__ParameterArrayType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4805:1: ( rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4 )
            // InternalBasicsParser.g:4806:2: rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__ParameterArrayType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__3"


    // $ANTLR start "rule__ParameterArrayType__Group__3__Impl"
    // InternalBasicsParser.g:4813:1: rule__ParameterArrayType__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterArrayType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4817:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:4818:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:4818:1: ( RightSquareBracket )
            // InternalBasicsParser.g:4819:2: RightSquareBracket
            {
             before(grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__3__Impl"


    // $ANTLR start "rule__ParameterArrayType__Group__4"
    // InternalBasicsParser.g:4828:1: rule__ParameterArrayType__Group__4 : rule__ParameterArrayType__Group__4__Impl ;
    public final void rule__ParameterArrayType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4832:1: ( rule__ParameterArrayType__Group__4__Impl )
            // InternalBasicsParser.g:4833:2: rule__ParameterArrayType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__4"


    // $ANTLR start "rule__ParameterArrayType__Group__4__Impl"
    // InternalBasicsParser.g:4839:1: rule__ParameterArrayType__Group__4__Impl : ( ( rule__ParameterArrayType__Group_4__0 )? ) ;
    public final void rule__ParameterArrayType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4843:1: ( ( ( rule__ParameterArrayType__Group_4__0 )? ) )
            // InternalBasicsParser.g:4844:1: ( ( rule__ParameterArrayType__Group_4__0 )? )
            {
            // InternalBasicsParser.g:4844:1: ( ( rule__ParameterArrayType__Group_4__0 )? )
            // InternalBasicsParser.g:4845:2: ( rule__ParameterArrayType__Group_4__0 )?
            {
             before(grammarAccess.getParameterArrayTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:4846:2: ( rule__ParameterArrayType__Group_4__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Default) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBasicsParser.g:4846:3: rule__ParameterArrayType__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterArrayType__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterArrayTypeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group__4__Impl"


    // $ANTLR start "rule__ParameterArrayType__Group_4__0"
    // InternalBasicsParser.g:4855:1: rule__ParameterArrayType__Group_4__0 : rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1 ;
    public final void rule__ParameterArrayType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4859:1: ( rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1 )
            // InternalBasicsParser.g:4860:2: rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1
            {
            pushFollow(FOLLOW_4);
            rule__ParameterArrayType__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group_4__0"


    // $ANTLR start "rule__ParameterArrayType__Group_4__0__Impl"
    // InternalBasicsParser.g:4867:1: rule__ParameterArrayType__Group_4__0__Impl : ( Default ) ;
    public final void rule__ParameterArrayType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4871:1: ( ( Default ) )
            // InternalBasicsParser.g:4872:1: ( Default )
            {
            // InternalBasicsParser.g:4872:1: ( Default )
            // InternalBasicsParser.g:4873:2: Default
            {
             before(grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0()); 
            match(input,Default,FOLLOW_2); 
             after(grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group_4__0__Impl"


    // $ANTLR start "rule__ParameterArrayType__Group_4__1"
    // InternalBasicsParser.g:4882:1: rule__ParameterArrayType__Group_4__1 : rule__ParameterArrayType__Group_4__1__Impl ;
    public final void rule__ParameterArrayType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4886:1: ( rule__ParameterArrayType__Group_4__1__Impl )
            // InternalBasicsParser.g:4887:2: rule__ParameterArrayType__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group_4__1"


    // $ANTLR start "rule__ParameterArrayType__Group_4__1__Impl"
    // InternalBasicsParser.g:4893:1: rule__ParameterArrayType__Group_4__1__Impl : ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) ) ;
    public final void rule__ParameterArrayType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4897:1: ( ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) ) )
            // InternalBasicsParser.g:4898:1: ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:4898:1: ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) )
            // InternalBasicsParser.g:4899:2: ( rule__ParameterArrayType__DefaultAssignment_4_1 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getDefaultAssignment_4_1()); 
            // InternalBasicsParser.g:4900:2: ( rule__ParameterArrayType__DefaultAssignment_4_1 )
            // InternalBasicsParser.g:4900:3: rule__ParameterArrayType__DefaultAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterArrayType__DefaultAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterArrayTypeAccess().getDefaultAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__Group_4__1__Impl"


    // $ANTLR start "rule__ParameterList__Group__0"
    // InternalBasicsParser.g:4909:1: rule__ParameterList__Group__0 : rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1 ;
    public final void rule__ParameterList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4913:1: ( rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1 )
            // InternalBasicsParser.g:4914:2: rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ParameterList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterList__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__0"


    // $ANTLR start "rule__ParameterList__Group__0__Impl"
    // InternalBasicsParser.g:4921:1: rule__ParameterList__Group__0__Impl : ( () ) ;
    public final void rule__ParameterList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4925:1: ( ( () ) )
            // InternalBasicsParser.g:4926:1: ( () )
            {
            // InternalBasicsParser.g:4926:1: ( () )
            // InternalBasicsParser.g:4927:2: ()
            {
             before(grammarAccess.getParameterListAccess().getParameterSequenceAction_0()); 
            // InternalBasicsParser.g:4928:2: ()
            // InternalBasicsParser.g:4928:3: 
            {
            }

             after(grammarAccess.getParameterListAccess().getParameterSequenceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__0__Impl"


    // $ANTLR start "rule__ParameterList__Group__1"
    // InternalBasicsParser.g:4936:1: rule__ParameterList__Group__1 : rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2 ;
    public final void rule__ParameterList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4940:1: ( rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2 )
            // InternalBasicsParser.g:4941:2: rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__ParameterList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterList__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__1"


    // $ANTLR start "rule__ParameterList__Group__1__Impl"
    // InternalBasicsParser.g:4948:1: rule__ParameterList__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4952:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:4953:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:4953:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:4954:2: LeftSquareBracket
            {
             before(grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__1__Impl"


    // $ANTLR start "rule__ParameterList__Group__2"
    // InternalBasicsParser.g:4963:1: rule__ParameterList__Group__2 : rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3 ;
    public final void rule__ParameterList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4967:1: ( rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3 )
            // InternalBasicsParser.g:4968:2: rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__ParameterList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterList__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__2"


    // $ANTLR start "rule__ParameterList__Group__2__Impl"
    // InternalBasicsParser.g:4975:1: rule__ParameterList__Group__2__Impl : ( ( rule__ParameterList__ValueAssignment_2 ) ) ;
    public final void rule__ParameterList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4979:1: ( ( ( rule__ParameterList__ValueAssignment_2 ) ) )
            // InternalBasicsParser.g:4980:1: ( ( rule__ParameterList__ValueAssignment_2 ) )
            {
            // InternalBasicsParser.g:4980:1: ( ( rule__ParameterList__ValueAssignment_2 ) )
            // InternalBasicsParser.g:4981:2: ( rule__ParameterList__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterListAccess().getValueAssignment_2()); 
            // InternalBasicsParser.g:4982:2: ( rule__ParameterList__ValueAssignment_2 )
            // InternalBasicsParser.g:4982:3: rule__ParameterList__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ParameterList__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParameterListAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__2__Impl"


    // $ANTLR start "rule__ParameterList__Group__3"
    // InternalBasicsParser.g:4990:1: rule__ParameterList__Group__3 : rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4 ;
    public final void rule__ParameterList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4994:1: ( rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4 )
            // InternalBasicsParser.g:4995:2: rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__ParameterList__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterList__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__3"


    // $ANTLR start "rule__ParameterList__Group__3__Impl"
    // InternalBasicsParser.g:5002:1: rule__ParameterList__Group__3__Impl : ( ( rule__ParameterList__Group_3__0 )* ) ;
    public final void rule__ParameterList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5006:1: ( ( ( rule__ParameterList__Group_3__0 )* ) )
            // InternalBasicsParser.g:5007:1: ( ( rule__ParameterList__Group_3__0 )* )
            {
            // InternalBasicsParser.g:5007:1: ( ( rule__ParameterList__Group_3__0 )* )
            // InternalBasicsParser.g:5008:2: ( rule__ParameterList__Group_3__0 )*
            {
             before(grammarAccess.getParameterListAccess().getGroup_3()); 
            // InternalBasicsParser.g:5009:2: ( rule__ParameterList__Group_3__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==Comma) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBasicsParser.g:5009:3: rule__ParameterList__Group_3__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__ParameterList__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getParameterListAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__3__Impl"


    // $ANTLR start "rule__ParameterList__Group__4"
    // InternalBasicsParser.g:5017:1: rule__ParameterList__Group__4 : rule__ParameterList__Group__4__Impl ;
    public final void rule__ParameterList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5021:1: ( rule__ParameterList__Group__4__Impl )
            // InternalBasicsParser.g:5022:2: rule__ParameterList__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterList__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__4"


    // $ANTLR start "rule__ParameterList__Group__4__Impl"
    // InternalBasicsParser.g:5028:1: rule__ParameterList__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5032:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5033:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5033:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5034:2: RightSquareBracket
            {
             before(grammarAccess.getParameterListAccess().getRightSquareBracketKeyword_4()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterListAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group__4__Impl"


    // $ANTLR start "rule__ParameterList__Group_3__0"
    // InternalBasicsParser.g:5044:1: rule__ParameterList__Group_3__0 : rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1 ;
    public final void rule__ParameterList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5048:1: ( rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1 )
            // InternalBasicsParser.g:5049:2: rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1
            {
            pushFollow(FOLLOW_25);
            rule__ParameterList__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterList__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group_3__0"


    // $ANTLR start "rule__ParameterList__Group_3__0__Impl"
    // InternalBasicsParser.g:5056:1: rule__ParameterList__Group_3__0__Impl : ( Comma ) ;
    public final void rule__ParameterList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5060:1: ( ( Comma ) )
            // InternalBasicsParser.g:5061:1: ( Comma )
            {
            // InternalBasicsParser.g:5061:1: ( Comma )
            // InternalBasicsParser.g:5062:2: Comma
            {
             before(grammarAccess.getParameterListAccess().getCommaKeyword_3_0()); 
            match(input,Comma,FOLLOW_2); 
             after(grammarAccess.getParameterListAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group_3__0__Impl"


    // $ANTLR start "rule__ParameterList__Group_3__1"
    // InternalBasicsParser.g:5071:1: rule__ParameterList__Group_3__1 : rule__ParameterList__Group_3__1__Impl ;
    public final void rule__ParameterList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5075:1: ( rule__ParameterList__Group_3__1__Impl )
            // InternalBasicsParser.g:5076:2: rule__ParameterList__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterList__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group_3__1"


    // $ANTLR start "rule__ParameterList__Group_3__1__Impl"
    // InternalBasicsParser.g:5082:1: rule__ParameterList__Group_3__1__Impl : ( ( rule__ParameterList__ValueAssignment_3_1 ) ) ;
    public final void rule__ParameterList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5086:1: ( ( ( rule__ParameterList__ValueAssignment_3_1 ) ) )
            // InternalBasicsParser.g:5087:1: ( ( rule__ParameterList__ValueAssignment_3_1 ) )
            {
            // InternalBasicsParser.g:5087:1: ( ( rule__ParameterList__ValueAssignment_3_1 ) )
            // InternalBasicsParser.g:5088:2: ( rule__ParameterList__ValueAssignment_3_1 )
            {
             before(grammarAccess.getParameterListAccess().getValueAssignment_3_1()); 
            // InternalBasicsParser.g:5089:2: ( rule__ParameterList__ValueAssignment_3_1 )
            // InternalBasicsParser.g:5089:3: rule__ParameterList__ValueAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterList__ValueAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterListAccess().getValueAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__Group_3__1__Impl"


    // $ANTLR start "rule__ParameterAny__Group__0"
    // InternalBasicsParser.g:5098:1: rule__ParameterAny__Group__0 : rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1 ;
    public final void rule__ParameterAny__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5102:1: ( rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1 )
            // InternalBasicsParser.g:5103:2: rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__ParameterAny__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterAny__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group__0"


    // $ANTLR start "rule__ParameterAny__Group__0__Impl"
    // InternalBasicsParser.g:5110:1: rule__ParameterAny__Group__0__Impl : ( () ) ;
    public final void rule__ParameterAny__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5114:1: ( ( () ) )
            // InternalBasicsParser.g:5115:1: ( () )
            {
            // InternalBasicsParser.g:5115:1: ( () )
            // InternalBasicsParser.g:5116:2: ()
            {
             before(grammarAccess.getParameterAnyAccess().getParameterAnyAction_0()); 
            // InternalBasicsParser.g:5117:2: ()
            // InternalBasicsParser.g:5117:3: 
            {
            }

             after(grammarAccess.getParameterAnyAccess().getParameterAnyAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group__0__Impl"


    // $ANTLR start "rule__ParameterAny__Group__1"
    // InternalBasicsParser.g:5125:1: rule__ParameterAny__Group__1 : rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2 ;
    public final void rule__ParameterAny__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5129:1: ( rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2 )
            // InternalBasicsParser.g:5130:2: rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__ParameterAny__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterAny__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group__1"


    // $ANTLR start "rule__ParameterAny__Group__1__Impl"
    // InternalBasicsParser.g:5137:1: rule__ParameterAny__Group__1__Impl : ( ParameterAny ) ;
    public final void rule__ParameterAny__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5141:1: ( ( ParameterAny ) )
            // InternalBasicsParser.g:5142:1: ( ParameterAny )
            {
            // InternalBasicsParser.g:5142:1: ( ParameterAny )
            // InternalBasicsParser.g:5143:2: ParameterAny
            {
             before(grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1()); 
            match(input,ParameterAny,FOLLOW_2); 
             after(grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group__1__Impl"


    // $ANTLR start "rule__ParameterAny__Group__2"
    // InternalBasicsParser.g:5152:1: rule__ParameterAny__Group__2 : rule__ParameterAny__Group__2__Impl ;
    public final void rule__ParameterAny__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5156:1: ( rule__ParameterAny__Group__2__Impl )
            // InternalBasicsParser.g:5157:2: rule__ParameterAny__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterAny__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group__2"


    // $ANTLR start "rule__ParameterAny__Group__2__Impl"
    // InternalBasicsParser.g:5163:1: rule__ParameterAny__Group__2__Impl : ( ( rule__ParameterAny__Group_2__0 )? ) ;
    public final void rule__ParameterAny__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5167:1: ( ( ( rule__ParameterAny__Group_2__0 )? ) )
            // InternalBasicsParser.g:5168:1: ( ( rule__ParameterAny__Group_2__0 )? )
            {
            // InternalBasicsParser.g:5168:1: ( ( rule__ParameterAny__Group_2__0 )? )
            // InternalBasicsParser.g:5169:2: ( rule__ParameterAny__Group_2__0 )?
            {
             before(grammarAccess.getParameterAnyAccess().getGroup_2()); 
            // InternalBasicsParser.g:5170:2: ( rule__ParameterAny__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Value) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalBasicsParser.g:5170:3: rule__ParameterAny__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterAny__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAnyAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group__2__Impl"


    // $ANTLR start "rule__ParameterAny__Group_2__0"
    // InternalBasicsParser.g:5179:1: rule__ParameterAny__Group_2__0 : rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1 ;
    public final void rule__ParameterAny__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5183:1: ( rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1 )
            // InternalBasicsParser.g:5184:2: rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1
            {
            pushFollow(FOLLOW_13);
            rule__ParameterAny__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterAny__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group_2__0"


    // $ANTLR start "rule__ParameterAny__Group_2__0__Impl"
    // InternalBasicsParser.g:5191:1: rule__ParameterAny__Group_2__0__Impl : ( Value ) ;
    public final void rule__ParameterAny__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5195:1: ( ( Value ) )
            // InternalBasicsParser.g:5196:1: ( Value )
            {
            // InternalBasicsParser.g:5196:1: ( Value )
            // InternalBasicsParser.g:5197:2: Value
            {
             before(grammarAccess.getParameterAnyAccess().getValueKeyword_2_0()); 
            match(input,Value,FOLLOW_2); 
             after(grammarAccess.getParameterAnyAccess().getValueKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group_2__0__Impl"


    // $ANTLR start "rule__ParameterAny__Group_2__1"
    // InternalBasicsParser.g:5206:1: rule__ParameterAny__Group_2__1 : rule__ParameterAny__Group_2__1__Impl ;
    public final void rule__ParameterAny__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5210:1: ( rule__ParameterAny__Group_2__1__Impl )
            // InternalBasicsParser.g:5211:2: rule__ParameterAny__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterAny__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group_2__1"


    // $ANTLR start "rule__ParameterAny__Group_2__1__Impl"
    // InternalBasicsParser.g:5217:1: rule__ParameterAny__Group_2__1__Impl : ( ( rule__ParameterAny__ValueAssignment_2_1 ) ) ;
    public final void rule__ParameterAny__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5221:1: ( ( ( rule__ParameterAny__ValueAssignment_2_1 ) ) )
            // InternalBasicsParser.g:5222:1: ( ( rule__ParameterAny__ValueAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:5222:1: ( ( rule__ParameterAny__ValueAssignment_2_1 ) )
            // InternalBasicsParser.g:5223:2: ( rule__ParameterAny__ValueAssignment_2_1 )
            {
             before(grammarAccess.getParameterAnyAccess().getValueAssignment_2_1()); 
            // InternalBasicsParser.g:5224:2: ( rule__ParameterAny__ValueAssignment_2_1 )
            // InternalBasicsParser.g:5224:3: rule__ParameterAny__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterAny__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAnyAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__Group_2__1__Impl"


    // $ANTLR start "rule__ParameterStruct__Group__0"
    // InternalBasicsParser.g:5233:1: rule__ParameterStruct__Group__0 : rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1 ;
    public final void rule__ParameterStruct__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5237:1: ( rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1 )
            // InternalBasicsParser.g:5238:2: rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__ParameterStruct__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group__0"


    // $ANTLR start "rule__ParameterStruct__Group__0__Impl"
    // InternalBasicsParser.g:5245:1: rule__ParameterStruct__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStruct__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5249:1: ( ( () ) )
            // InternalBasicsParser.g:5250:1: ( () )
            {
            // InternalBasicsParser.g:5250:1: ( () )
            // InternalBasicsParser.g:5251:2: ()
            {
             before(grammarAccess.getParameterStructAccess().getParameterStructAction_0()); 
            // InternalBasicsParser.g:5252:2: ()
            // InternalBasicsParser.g:5252:3: 
            {
            }

             after(grammarAccess.getParameterStructAccess().getParameterStructAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group__0__Impl"


    // $ANTLR start "rule__ParameterStruct__Group__1"
    // InternalBasicsParser.g:5260:1: rule__ParameterStruct__Group__1 : rule__ParameterStruct__Group__1__Impl ;
    public final void rule__ParameterStruct__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5264:1: ( rule__ParameterStruct__Group__1__Impl )
            // InternalBasicsParser.g:5265:2: rule__ParameterStruct__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group__1"


    // $ANTLR start "rule__ParameterStruct__Group__1__Impl"
    // InternalBasicsParser.g:5271:1: rule__ParameterStruct__Group__1__Impl : ( ( rule__ParameterStruct__Group_1__0 )? ) ;
    public final void rule__ParameterStruct__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5275:1: ( ( ( rule__ParameterStruct__Group_1__0 )? ) )
            // InternalBasicsParser.g:5276:1: ( ( rule__ParameterStruct__Group_1__0 )? )
            {
            // InternalBasicsParser.g:5276:1: ( ( rule__ParameterStruct__Group_1__0 )? )
            // InternalBasicsParser.g:5277:2: ( rule__ParameterStruct__Group_1__0 )?
            {
             before(grammarAccess.getParameterStructAccess().getGroup_1()); 
            // InternalBasicsParser.g:5278:2: ( rule__ParameterStruct__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LeftSquareBracket) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBasicsParser.g:5278:3: rule__ParameterStruct__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterStruct__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterStructAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group__1__Impl"


    // $ANTLR start "rule__ParameterStruct__Group_1__0"
    // InternalBasicsParser.g:5287:1: rule__ParameterStruct__Group_1__0 : rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1 ;
    public final void rule__ParameterStruct__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5291:1: ( rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1 )
            // InternalBasicsParser.g:5292:2: rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__ParameterStruct__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__0"


    // $ANTLR start "rule__ParameterStruct__Group_1__0__Impl"
    // InternalBasicsParser.g:5299:1: rule__ParameterStruct__Group_1__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterStruct__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5303:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:5304:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:5304:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:5305:2: LeftSquareBracket
            {
             before(grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__0__Impl"


    // $ANTLR start "rule__ParameterStruct__Group_1__1"
    // InternalBasicsParser.g:5314:1: rule__ParameterStruct__Group_1__1 : rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2 ;
    public final void rule__ParameterStruct__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5318:1: ( rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2 )
            // InternalBasicsParser.g:5319:2: rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2
            {
            pushFollow(FOLLOW_29);
            rule__ParameterStruct__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__1"


    // $ANTLR start "rule__ParameterStruct__Group_1__1__Impl"
    // InternalBasicsParser.g:5326:1: rule__ParameterStruct__Group_1__1__Impl : ( RULE_BEGIN ) ;
    public final void rule__ParameterStruct__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5330:1: ( ( RULE_BEGIN ) )
            // InternalBasicsParser.g:5331:1: ( RULE_BEGIN )
            {
            // InternalBasicsParser.g:5331:1: ( RULE_BEGIN )
            // InternalBasicsParser.g:5332:2: RULE_BEGIN
            {
             before(grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1()); 
            match(input,RULE_BEGIN,FOLLOW_2); 
             after(grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__1__Impl"


    // $ANTLR start "rule__ParameterStruct__Group_1__2"
    // InternalBasicsParser.g:5341:1: rule__ParameterStruct__Group_1__2 : rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3 ;
    public final void rule__ParameterStruct__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5345:1: ( rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3 )
            // InternalBasicsParser.g:5346:2: rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3
            {
            pushFollow(FOLLOW_29);
            rule__ParameterStruct__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__2"


    // $ANTLR start "rule__ParameterStruct__Group_1__2__Impl"
    // InternalBasicsParser.g:5353:1: rule__ParameterStruct__Group_1__2__Impl : ( ( rule__ParameterStruct__ValueAssignment_1_2 )* ) ;
    public final void rule__ParameterStruct__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5357:1: ( ( ( rule__ParameterStruct__ValueAssignment_1_2 )* ) )
            // InternalBasicsParser.g:5358:1: ( ( rule__ParameterStruct__ValueAssignment_1_2 )* )
            {
            // InternalBasicsParser.g:5358:1: ( ( rule__ParameterStruct__ValueAssignment_1_2 )* )
            // InternalBasicsParser.g:5359:2: ( rule__ParameterStruct__ValueAssignment_1_2 )*
            {
             before(grammarAccess.getParameterStructAccess().getValueAssignment_1_2()); 
            // InternalBasicsParser.g:5360:2: ( rule__ParameterStruct__ValueAssignment_1_2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBasicsParser.g:5360:3: rule__ParameterStruct__ValueAssignment_1_2
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__ParameterStruct__ValueAssignment_1_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getParameterStructAccess().getValueAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__2__Impl"


    // $ANTLR start "rule__ParameterStruct__Group_1__3"
    // InternalBasicsParser.g:5368:1: rule__ParameterStruct__Group_1__3 : rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4 ;
    public final void rule__ParameterStruct__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5372:1: ( rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4 )
            // InternalBasicsParser.g:5373:2: rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4
            {
            pushFollow(FOLLOW_31);
            rule__ParameterStruct__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__3"


    // $ANTLR start "rule__ParameterStruct__Group_1__3__Impl"
    // InternalBasicsParser.g:5380:1: rule__ParameterStruct__Group_1__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterStruct__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5384:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5385:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5385:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5386:2: RightSquareBracket
            {
             before(grammarAccess.getParameterStructAccess().getRightSquareBracketKeyword_1_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getParameterStructAccess().getRightSquareBracketKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__3__Impl"


    // $ANTLR start "rule__ParameterStruct__Group_1__4"
    // InternalBasicsParser.g:5395:1: rule__ParameterStruct__Group_1__4 : rule__ParameterStruct__Group_1__4__Impl ;
    public final void rule__ParameterStruct__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5399:1: ( rule__ParameterStruct__Group_1__4__Impl )
            // InternalBasicsParser.g:5400:2: rule__ParameterStruct__Group_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStruct__Group_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__4"


    // $ANTLR start "rule__ParameterStruct__Group_1__4__Impl"
    // InternalBasicsParser.g:5406:1: rule__ParameterStruct__Group_1__4__Impl : ( RULE_END ) ;
    public final void rule__ParameterStruct__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5410:1: ( ( RULE_END ) )
            // InternalBasicsParser.g:5411:1: ( RULE_END )
            {
            // InternalBasicsParser.g:5411:1: ( RULE_END )
            // InternalBasicsParser.g:5412:2: RULE_END
            {
             before(grammarAccess.getParameterStructAccess().getENDTerminalRuleCall_1_4()); 
            match(input,RULE_END,FOLLOW_2); 
             after(grammarAccess.getParameterStructAccess().getENDTerminalRuleCall_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__Group_1__4__Impl"


    // $ANTLR start "rule__ParameterStructMember__Group__0"
    // InternalBasicsParser.g:5422:1: rule__ParameterStructMember__Group__0 : rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1 ;
    public final void rule__ParameterStructMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5426:1: ( rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1 )
            // InternalBasicsParser.g:5427:2: rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__ParameterStructMember__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group__0"


    // $ANTLR start "rule__ParameterStructMember__Group__0__Impl"
    // InternalBasicsParser.g:5434:1: rule__ParameterStructMember__Group__0__Impl : ( ( rule__ParameterStructMember__NameAssignment_0 ) ) ;
    public final void rule__ParameterStructMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5438:1: ( ( ( rule__ParameterStructMember__NameAssignment_0 ) ) )
            // InternalBasicsParser.g:5439:1: ( ( rule__ParameterStructMember__NameAssignment_0 ) )
            {
            // InternalBasicsParser.g:5439:1: ( ( rule__ParameterStructMember__NameAssignment_0 ) )
            // InternalBasicsParser.g:5440:2: ( rule__ParameterStructMember__NameAssignment_0 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0()); 
            // InternalBasicsParser.g:5441:2: ( rule__ParameterStructMember__NameAssignment_0 )
            // InternalBasicsParser.g:5441:3: rule__ParameterStructMember__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group__0__Impl"


    // $ANTLR start "rule__ParameterStructMember__Group__1"
    // InternalBasicsParser.g:5449:1: rule__ParameterStructMember__Group__1 : rule__ParameterStructMember__Group__1__Impl rule__ParameterStructMember__Group__2 ;
    public final void rule__ParameterStructMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5453:1: ( rule__ParameterStructMember__Group__1__Impl rule__ParameterStructMember__Group__2 )
            // InternalBasicsParser.g:5454:2: rule__ParameterStructMember__Group__1__Impl rule__ParameterStructMember__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__ParameterStructMember__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group__1"


    // $ANTLR start "rule__ParameterStructMember__Group__1__Impl"
    // InternalBasicsParser.g:5461:1: rule__ParameterStructMember__Group__1__Impl : ( Colon ) ;
    public final void rule__ParameterStructMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5465:1: ( ( Colon ) )
            // InternalBasicsParser.g:5466:1: ( Colon )
            {
            // InternalBasicsParser.g:5466:1: ( Colon )
            // InternalBasicsParser.g:5467:2: Colon
            {
             before(grammarAccess.getParameterStructMemberAccess().getColonKeyword_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getParameterStructMemberAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group__1__Impl"


    // $ANTLR start "rule__ParameterStructMember__Group__2"
    // InternalBasicsParser.g:5476:1: rule__ParameterStructMember__Group__2 : rule__ParameterStructMember__Group__2__Impl ;
    public final void rule__ParameterStructMember__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5480:1: ( rule__ParameterStructMember__Group__2__Impl )
            // InternalBasicsParser.g:5481:2: rule__ParameterStructMember__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group__2"


    // $ANTLR start "rule__ParameterStructMember__Group__2__Impl"
    // InternalBasicsParser.g:5487:1: rule__ParameterStructMember__Group__2__Impl : ( ( rule__ParameterStructMember__ValueAssignment_2 ) ) ;
    public final void rule__ParameterStructMember__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5491:1: ( ( ( rule__ParameterStructMember__ValueAssignment_2 ) ) )
            // InternalBasicsParser.g:5492:1: ( ( rule__ParameterStructMember__ValueAssignment_2 ) )
            {
            // InternalBasicsParser.g:5492:1: ( ( rule__ParameterStructMember__ValueAssignment_2 ) )
            // InternalBasicsParser.g:5493:2: ( rule__ParameterStructMember__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getValueAssignment_2()); 
            // InternalBasicsParser.g:5494:2: ( rule__ParameterStructMember__ValueAssignment_2 )
            // InternalBasicsParser.g:5494:3: rule__ParameterStructMember__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructMemberAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group__2__Impl"


    // $ANTLR start "rule__ParameterStructTypeMember__Group__0"
    // InternalBasicsParser.g:5503:1: rule__ParameterStructTypeMember__Group__0 : rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1 ;
    public final void rule__ParameterStructTypeMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5507:1: ( rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1 )
            // InternalBasicsParser.g:5508:2: rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__ParameterStructTypeMember__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructTypeMember__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructTypeMember__Group__0"


    // $ANTLR start "rule__ParameterStructTypeMember__Group__0__Impl"
    // InternalBasicsParser.g:5515:1: rule__ParameterStructTypeMember__Group__0__Impl : ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) ) ;
    public final void rule__ParameterStructTypeMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5519:1: ( ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) ) )
            // InternalBasicsParser.g:5520:1: ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) )
            {
            // InternalBasicsParser.g:5520:1: ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) )
            // InternalBasicsParser.g:5521:2: ( rule__ParameterStructTypeMember__NameAssignment_0 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getNameAssignment_0()); 
            // InternalBasicsParser.g:5522:2: ( rule__ParameterStructTypeMember__NameAssignment_0 )
            // InternalBasicsParser.g:5522:3: rule__ParameterStructTypeMember__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructTypeMember__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructTypeMemberAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructTypeMember__Group__0__Impl"


    // $ANTLR start "rule__ParameterStructTypeMember__Group__1"
    // InternalBasicsParser.g:5530:1: rule__ParameterStructTypeMember__Group__1 : rule__ParameterStructTypeMember__Group__1__Impl ;
    public final void rule__ParameterStructTypeMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5534:1: ( rule__ParameterStructTypeMember__Group__1__Impl )
            // InternalBasicsParser.g:5535:2: rule__ParameterStructTypeMember__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructTypeMember__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructTypeMember__Group__1"


    // $ANTLR start "rule__ParameterStructTypeMember__Group__1__Impl"
    // InternalBasicsParser.g:5541:1: rule__ParameterStructTypeMember__Group__1__Impl : ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) ) ;
    public final void rule__ParameterStructTypeMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5545:1: ( ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) ) )
            // InternalBasicsParser.g:5546:1: ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) )
            {
            // InternalBasicsParser.g:5546:1: ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) )
            // InternalBasicsParser.g:5547:2: ( rule__ParameterStructTypeMember__TypeAssignment_1 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getTypeAssignment_1()); 
            // InternalBasicsParser.g:5548:2: ( rule__ParameterStructTypeMember__TypeAssignment_1 )
            // InternalBasicsParser.g:5548:3: rule__ParameterStructTypeMember__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructTypeMember__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructTypeMemberAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructTypeMember__Group__1__Impl"


    // $ANTLR start "rule__Bool__Group__0"
    // InternalBasicsParser.g:5557:1: rule__Bool__Group__0 : rule__Bool__Group__0__Impl rule__Bool__Group__1 ;
    public final void rule__Bool__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5561:1: ( rule__Bool__Group__0__Impl rule__Bool__Group__1 )
            // InternalBasicsParser.g:5562:2: rule__Bool__Group__0__Impl rule__Bool__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__Bool__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bool__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bool__Group__0"


    // $ANTLR start "rule__Bool__Group__0__Impl"
    // InternalBasicsParser.g:5569:1: rule__Bool__Group__0__Impl : ( () ) ;
    public final void rule__Bool__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5573:1: ( ( () ) )
            // InternalBasicsParser.g:5574:1: ( () )
            {
            // InternalBasicsParser.g:5574:1: ( () )
            // InternalBasicsParser.g:5575:2: ()
            {
             before(grammarAccess.getBoolAccess().getBoolAction_0()); 
            // InternalBasicsParser.g:5576:2: ()
            // InternalBasicsParser.g:5576:3: 
            {
            }

             after(grammarAccess.getBoolAccess().getBoolAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bool__Group__0__Impl"


    // $ANTLR start "rule__Bool__Group__1"
    // InternalBasicsParser.g:5584:1: rule__Bool__Group__1 : rule__Bool__Group__1__Impl ;
    public final void rule__Bool__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5588:1: ( rule__Bool__Group__1__Impl )
            // InternalBasicsParser.g:5589:2: rule__Bool__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bool__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bool__Group__1"


    // $ANTLR start "rule__Bool__Group__1__Impl"
    // InternalBasicsParser.g:5595:1: rule__Bool__Group__1__Impl : ( Bool ) ;
    public final void rule__Bool__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5599:1: ( ( Bool ) )
            // InternalBasicsParser.g:5600:1: ( Bool )
            {
            // InternalBasicsParser.g:5600:1: ( Bool )
            // InternalBasicsParser.g:5601:2: Bool
            {
             before(grammarAccess.getBoolAccess().getBoolKeyword_1()); 
            match(input,Bool,FOLLOW_2); 
             after(grammarAccess.getBoolAccess().getBoolKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bool__Group__1__Impl"


    // $ANTLR start "rule__Int8__Group__0"
    // InternalBasicsParser.g:5611:1: rule__Int8__Group__0 : rule__Int8__Group__0__Impl rule__Int8__Group__1 ;
    public final void rule__Int8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5615:1: ( rule__Int8__Group__0__Impl rule__Int8__Group__1 )
            // InternalBasicsParser.g:5616:2: rule__Int8__Group__0__Impl rule__Int8__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__Int8__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int8__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8__Group__0"


    // $ANTLR start "rule__Int8__Group__0__Impl"
    // InternalBasicsParser.g:5623:1: rule__Int8__Group__0__Impl : ( () ) ;
    public final void rule__Int8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5627:1: ( ( () ) )
            // InternalBasicsParser.g:5628:1: ( () )
            {
            // InternalBasicsParser.g:5628:1: ( () )
            // InternalBasicsParser.g:5629:2: ()
            {
             before(grammarAccess.getInt8Access().getInt8Action_0()); 
            // InternalBasicsParser.g:5630:2: ()
            // InternalBasicsParser.g:5630:3: 
            {
            }

             after(grammarAccess.getInt8Access().getInt8Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8__Group__0__Impl"


    // $ANTLR start "rule__Int8__Group__1"
    // InternalBasicsParser.g:5638:1: rule__Int8__Group__1 : rule__Int8__Group__1__Impl ;
    public final void rule__Int8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5642:1: ( rule__Int8__Group__1__Impl )
            // InternalBasicsParser.g:5643:2: rule__Int8__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int8__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8__Group__1"


    // $ANTLR start "rule__Int8__Group__1__Impl"
    // InternalBasicsParser.g:5649:1: rule__Int8__Group__1__Impl : ( Int8 ) ;
    public final void rule__Int8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5653:1: ( ( Int8 ) )
            // InternalBasicsParser.g:5654:1: ( Int8 )
            {
            // InternalBasicsParser.g:5654:1: ( Int8 )
            // InternalBasicsParser.g:5655:2: Int8
            {
             before(grammarAccess.getInt8Access().getInt8Keyword_1()); 
            match(input,Int8,FOLLOW_2); 
             after(grammarAccess.getInt8Access().getInt8Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8__Group__1__Impl"


    // $ANTLR start "rule__Uint8__Group__0"
    // InternalBasicsParser.g:5665:1: rule__Uint8__Group__0 : rule__Uint8__Group__0__Impl rule__Uint8__Group__1 ;
    public final void rule__Uint8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5669:1: ( rule__Uint8__Group__0__Impl rule__Uint8__Group__1 )
            // InternalBasicsParser.g:5670:2: rule__Uint8__Group__0__Impl rule__Uint8__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__Uint8__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint8__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8__Group__0"


    // $ANTLR start "rule__Uint8__Group__0__Impl"
    // InternalBasicsParser.g:5677:1: rule__Uint8__Group__0__Impl : ( () ) ;
    public final void rule__Uint8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5681:1: ( ( () ) )
            // InternalBasicsParser.g:5682:1: ( () )
            {
            // InternalBasicsParser.g:5682:1: ( () )
            // InternalBasicsParser.g:5683:2: ()
            {
             before(grammarAccess.getUint8Access().getUint8Action_0()); 
            // InternalBasicsParser.g:5684:2: ()
            // InternalBasicsParser.g:5684:3: 
            {
            }

             after(grammarAccess.getUint8Access().getUint8Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8__Group__0__Impl"


    // $ANTLR start "rule__Uint8__Group__1"
    // InternalBasicsParser.g:5692:1: rule__Uint8__Group__1 : rule__Uint8__Group__1__Impl ;
    public final void rule__Uint8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5696:1: ( rule__Uint8__Group__1__Impl )
            // InternalBasicsParser.g:5697:2: rule__Uint8__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint8__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8__Group__1"


    // $ANTLR start "rule__Uint8__Group__1__Impl"
    // InternalBasicsParser.g:5703:1: rule__Uint8__Group__1__Impl : ( Uint8 ) ;
    public final void rule__Uint8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5707:1: ( ( Uint8 ) )
            // InternalBasicsParser.g:5708:1: ( Uint8 )
            {
            // InternalBasicsParser.g:5708:1: ( Uint8 )
            // InternalBasicsParser.g:5709:2: Uint8
            {
             before(grammarAccess.getUint8Access().getUint8Keyword_1()); 
            match(input,Uint8,FOLLOW_2); 
             after(grammarAccess.getUint8Access().getUint8Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8__Group__1__Impl"


    // $ANTLR start "rule__Int16__Group__0"
    // InternalBasicsParser.g:5719:1: rule__Int16__Group__0 : rule__Int16__Group__0__Impl rule__Int16__Group__1 ;
    public final void rule__Int16__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5723:1: ( rule__Int16__Group__0__Impl rule__Int16__Group__1 )
            // InternalBasicsParser.g:5724:2: rule__Int16__Group__0__Impl rule__Int16__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__Int16__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int16__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16__Group__0"


    // $ANTLR start "rule__Int16__Group__0__Impl"
    // InternalBasicsParser.g:5731:1: rule__Int16__Group__0__Impl : ( () ) ;
    public final void rule__Int16__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5735:1: ( ( () ) )
            // InternalBasicsParser.g:5736:1: ( () )
            {
            // InternalBasicsParser.g:5736:1: ( () )
            // InternalBasicsParser.g:5737:2: ()
            {
             before(grammarAccess.getInt16Access().getInt16Action_0()); 
            // InternalBasicsParser.g:5738:2: ()
            // InternalBasicsParser.g:5738:3: 
            {
            }

             after(grammarAccess.getInt16Access().getInt16Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16__Group__0__Impl"


    // $ANTLR start "rule__Int16__Group__1"
    // InternalBasicsParser.g:5746:1: rule__Int16__Group__1 : rule__Int16__Group__1__Impl ;
    public final void rule__Int16__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5750:1: ( rule__Int16__Group__1__Impl )
            // InternalBasicsParser.g:5751:2: rule__Int16__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int16__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16__Group__1"


    // $ANTLR start "rule__Int16__Group__1__Impl"
    // InternalBasicsParser.g:5757:1: rule__Int16__Group__1__Impl : ( Int16 ) ;
    public final void rule__Int16__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5761:1: ( ( Int16 ) )
            // InternalBasicsParser.g:5762:1: ( Int16 )
            {
            // InternalBasicsParser.g:5762:1: ( Int16 )
            // InternalBasicsParser.g:5763:2: Int16
            {
             before(grammarAccess.getInt16Access().getInt16Keyword_1()); 
            match(input,Int16,FOLLOW_2); 
             after(grammarAccess.getInt16Access().getInt16Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16__Group__1__Impl"


    // $ANTLR start "rule__Uint16__Group__0"
    // InternalBasicsParser.g:5773:1: rule__Uint16__Group__0 : rule__Uint16__Group__0__Impl rule__Uint16__Group__1 ;
    public final void rule__Uint16__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5777:1: ( rule__Uint16__Group__0__Impl rule__Uint16__Group__1 )
            // InternalBasicsParser.g:5778:2: rule__Uint16__Group__0__Impl rule__Uint16__Group__1
            {
            pushFollow(FOLLOW_37);
            rule__Uint16__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint16__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16__Group__0"


    // $ANTLR start "rule__Uint16__Group__0__Impl"
    // InternalBasicsParser.g:5785:1: rule__Uint16__Group__0__Impl : ( () ) ;
    public final void rule__Uint16__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5789:1: ( ( () ) )
            // InternalBasicsParser.g:5790:1: ( () )
            {
            // InternalBasicsParser.g:5790:1: ( () )
            // InternalBasicsParser.g:5791:2: ()
            {
             before(grammarAccess.getUint16Access().getUint16Action_0()); 
            // InternalBasicsParser.g:5792:2: ()
            // InternalBasicsParser.g:5792:3: 
            {
            }

             after(grammarAccess.getUint16Access().getUint16Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16__Group__0__Impl"


    // $ANTLR start "rule__Uint16__Group__1"
    // InternalBasicsParser.g:5800:1: rule__Uint16__Group__1 : rule__Uint16__Group__1__Impl ;
    public final void rule__Uint16__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5804:1: ( rule__Uint16__Group__1__Impl )
            // InternalBasicsParser.g:5805:2: rule__Uint16__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint16__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16__Group__1"


    // $ANTLR start "rule__Uint16__Group__1__Impl"
    // InternalBasicsParser.g:5811:1: rule__Uint16__Group__1__Impl : ( Uint16 ) ;
    public final void rule__Uint16__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5815:1: ( ( Uint16 ) )
            // InternalBasicsParser.g:5816:1: ( Uint16 )
            {
            // InternalBasicsParser.g:5816:1: ( Uint16 )
            // InternalBasicsParser.g:5817:2: Uint16
            {
             before(grammarAccess.getUint16Access().getUint16Keyword_1()); 
            match(input,Uint16,FOLLOW_2); 
             after(grammarAccess.getUint16Access().getUint16Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16__Group__1__Impl"


    // $ANTLR start "rule__Int32__Group__0"
    // InternalBasicsParser.g:5827:1: rule__Int32__Group__0 : rule__Int32__Group__0__Impl rule__Int32__Group__1 ;
    public final void rule__Int32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5831:1: ( rule__Int32__Group__0__Impl rule__Int32__Group__1 )
            // InternalBasicsParser.g:5832:2: rule__Int32__Group__0__Impl rule__Int32__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__Int32__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int32__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32__Group__0"


    // $ANTLR start "rule__Int32__Group__0__Impl"
    // InternalBasicsParser.g:5839:1: rule__Int32__Group__0__Impl : ( () ) ;
    public final void rule__Int32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5843:1: ( ( () ) )
            // InternalBasicsParser.g:5844:1: ( () )
            {
            // InternalBasicsParser.g:5844:1: ( () )
            // InternalBasicsParser.g:5845:2: ()
            {
             before(grammarAccess.getInt32Access().getInt32Action_0()); 
            // InternalBasicsParser.g:5846:2: ()
            // InternalBasicsParser.g:5846:3: 
            {
            }

             after(grammarAccess.getInt32Access().getInt32Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32__Group__0__Impl"


    // $ANTLR start "rule__Int32__Group__1"
    // InternalBasicsParser.g:5854:1: rule__Int32__Group__1 : rule__Int32__Group__1__Impl ;
    public final void rule__Int32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5858:1: ( rule__Int32__Group__1__Impl )
            // InternalBasicsParser.g:5859:2: rule__Int32__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int32__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32__Group__1"


    // $ANTLR start "rule__Int32__Group__1__Impl"
    // InternalBasicsParser.g:5865:1: rule__Int32__Group__1__Impl : ( Int32 ) ;
    public final void rule__Int32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5869:1: ( ( Int32 ) )
            // InternalBasicsParser.g:5870:1: ( Int32 )
            {
            // InternalBasicsParser.g:5870:1: ( Int32 )
            // InternalBasicsParser.g:5871:2: Int32
            {
             before(grammarAccess.getInt32Access().getInt32Keyword_1()); 
            match(input,Int32,FOLLOW_2); 
             after(grammarAccess.getInt32Access().getInt32Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32__Group__1__Impl"


    // $ANTLR start "rule__Uint32__Group__0"
    // InternalBasicsParser.g:5881:1: rule__Uint32__Group__0 : rule__Uint32__Group__0__Impl rule__Uint32__Group__1 ;
    public final void rule__Uint32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5885:1: ( rule__Uint32__Group__0__Impl rule__Uint32__Group__1 )
            // InternalBasicsParser.g:5886:2: rule__Uint32__Group__0__Impl rule__Uint32__Group__1
            {
            pushFollow(FOLLOW_39);
            rule__Uint32__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint32__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32__Group__0"


    // $ANTLR start "rule__Uint32__Group__0__Impl"
    // InternalBasicsParser.g:5893:1: rule__Uint32__Group__0__Impl : ( () ) ;
    public final void rule__Uint32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5897:1: ( ( () ) )
            // InternalBasicsParser.g:5898:1: ( () )
            {
            // InternalBasicsParser.g:5898:1: ( () )
            // InternalBasicsParser.g:5899:2: ()
            {
             before(grammarAccess.getUint32Access().getUint32Action_0()); 
            // InternalBasicsParser.g:5900:2: ()
            // InternalBasicsParser.g:5900:3: 
            {
            }

             after(grammarAccess.getUint32Access().getUint32Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32__Group__0__Impl"


    // $ANTLR start "rule__Uint32__Group__1"
    // InternalBasicsParser.g:5908:1: rule__Uint32__Group__1 : rule__Uint32__Group__1__Impl ;
    public final void rule__Uint32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5912:1: ( rule__Uint32__Group__1__Impl )
            // InternalBasicsParser.g:5913:2: rule__Uint32__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint32__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32__Group__1"


    // $ANTLR start "rule__Uint32__Group__1__Impl"
    // InternalBasicsParser.g:5919:1: rule__Uint32__Group__1__Impl : ( Uint32 ) ;
    public final void rule__Uint32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5923:1: ( ( Uint32 ) )
            // InternalBasicsParser.g:5924:1: ( Uint32 )
            {
            // InternalBasicsParser.g:5924:1: ( Uint32 )
            // InternalBasicsParser.g:5925:2: Uint32
            {
             before(grammarAccess.getUint32Access().getUint32Keyword_1()); 
            match(input,Uint32,FOLLOW_2); 
             after(grammarAccess.getUint32Access().getUint32Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32__Group__1__Impl"


    // $ANTLR start "rule__Int64__Group__0"
    // InternalBasicsParser.g:5935:1: rule__Int64__Group__0 : rule__Int64__Group__0__Impl rule__Int64__Group__1 ;
    public final void rule__Int64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5939:1: ( rule__Int64__Group__0__Impl rule__Int64__Group__1 )
            // InternalBasicsParser.g:5940:2: rule__Int64__Group__0__Impl rule__Int64__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__Int64__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int64__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64__Group__0"


    // $ANTLR start "rule__Int64__Group__0__Impl"
    // InternalBasicsParser.g:5947:1: rule__Int64__Group__0__Impl : ( () ) ;
    public final void rule__Int64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5951:1: ( ( () ) )
            // InternalBasicsParser.g:5952:1: ( () )
            {
            // InternalBasicsParser.g:5952:1: ( () )
            // InternalBasicsParser.g:5953:2: ()
            {
             before(grammarAccess.getInt64Access().getInt64Action_0()); 
            // InternalBasicsParser.g:5954:2: ()
            // InternalBasicsParser.g:5954:3: 
            {
            }

             after(grammarAccess.getInt64Access().getInt64Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64__Group__0__Impl"


    // $ANTLR start "rule__Int64__Group__1"
    // InternalBasicsParser.g:5962:1: rule__Int64__Group__1 : rule__Int64__Group__1__Impl ;
    public final void rule__Int64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5966:1: ( rule__Int64__Group__1__Impl )
            // InternalBasicsParser.g:5967:2: rule__Int64__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int64__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64__Group__1"


    // $ANTLR start "rule__Int64__Group__1__Impl"
    // InternalBasicsParser.g:5973:1: rule__Int64__Group__1__Impl : ( Int64 ) ;
    public final void rule__Int64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5977:1: ( ( Int64 ) )
            // InternalBasicsParser.g:5978:1: ( Int64 )
            {
            // InternalBasicsParser.g:5978:1: ( Int64 )
            // InternalBasicsParser.g:5979:2: Int64
            {
             before(grammarAccess.getInt64Access().getInt64Keyword_1()); 
            match(input,Int64,FOLLOW_2); 
             after(grammarAccess.getInt64Access().getInt64Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64__Group__1__Impl"


    // $ANTLR start "rule__Uint64__Group__0"
    // InternalBasicsParser.g:5989:1: rule__Uint64__Group__0 : rule__Uint64__Group__0__Impl rule__Uint64__Group__1 ;
    public final void rule__Uint64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5993:1: ( rule__Uint64__Group__0__Impl rule__Uint64__Group__1 )
            // InternalBasicsParser.g:5994:2: rule__Uint64__Group__0__Impl rule__Uint64__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__Uint64__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint64__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64__Group__0"


    // $ANTLR start "rule__Uint64__Group__0__Impl"
    // InternalBasicsParser.g:6001:1: rule__Uint64__Group__0__Impl : ( () ) ;
    public final void rule__Uint64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6005:1: ( ( () ) )
            // InternalBasicsParser.g:6006:1: ( () )
            {
            // InternalBasicsParser.g:6006:1: ( () )
            // InternalBasicsParser.g:6007:2: ()
            {
             before(grammarAccess.getUint64Access().getUint64Action_0()); 
            // InternalBasicsParser.g:6008:2: ()
            // InternalBasicsParser.g:6008:3: 
            {
            }

             after(grammarAccess.getUint64Access().getUint64Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64__Group__0__Impl"


    // $ANTLR start "rule__Uint64__Group__1"
    // InternalBasicsParser.g:6016:1: rule__Uint64__Group__1 : rule__Uint64__Group__1__Impl ;
    public final void rule__Uint64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6020:1: ( rule__Uint64__Group__1__Impl )
            // InternalBasicsParser.g:6021:2: rule__Uint64__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint64__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64__Group__1"


    // $ANTLR start "rule__Uint64__Group__1__Impl"
    // InternalBasicsParser.g:6027:1: rule__Uint64__Group__1__Impl : ( Uint64 ) ;
    public final void rule__Uint64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6031:1: ( ( Uint64 ) )
            // InternalBasicsParser.g:6032:1: ( Uint64 )
            {
            // InternalBasicsParser.g:6032:1: ( Uint64 )
            // InternalBasicsParser.g:6033:2: Uint64
            {
             before(grammarAccess.getUint64Access().getUint64Keyword_1()); 
            match(input,Uint64,FOLLOW_2); 
             after(grammarAccess.getUint64Access().getUint64Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64__Group__1__Impl"


    // $ANTLR start "rule__Float32__Group__0"
    // InternalBasicsParser.g:6043:1: rule__Float32__Group__0 : rule__Float32__Group__0__Impl rule__Float32__Group__1 ;
    public final void rule__Float32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6047:1: ( rule__Float32__Group__0__Impl rule__Float32__Group__1 )
            // InternalBasicsParser.g:6048:2: rule__Float32__Group__0__Impl rule__Float32__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__Float32__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float32__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32__Group__0"


    // $ANTLR start "rule__Float32__Group__0__Impl"
    // InternalBasicsParser.g:6055:1: rule__Float32__Group__0__Impl : ( () ) ;
    public final void rule__Float32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6059:1: ( ( () ) )
            // InternalBasicsParser.g:6060:1: ( () )
            {
            // InternalBasicsParser.g:6060:1: ( () )
            // InternalBasicsParser.g:6061:2: ()
            {
             before(grammarAccess.getFloat32Access().getFloat32Action_0()); 
            // InternalBasicsParser.g:6062:2: ()
            // InternalBasicsParser.g:6062:3: 
            {
            }

             after(grammarAccess.getFloat32Access().getFloat32Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32__Group__0__Impl"


    // $ANTLR start "rule__Float32__Group__1"
    // InternalBasicsParser.g:6070:1: rule__Float32__Group__1 : rule__Float32__Group__1__Impl ;
    public final void rule__Float32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6074:1: ( rule__Float32__Group__1__Impl )
            // InternalBasicsParser.g:6075:2: rule__Float32__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Float32__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32__Group__1"


    // $ANTLR start "rule__Float32__Group__1__Impl"
    // InternalBasicsParser.g:6081:1: rule__Float32__Group__1__Impl : ( Float32 ) ;
    public final void rule__Float32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6085:1: ( ( Float32 ) )
            // InternalBasicsParser.g:6086:1: ( Float32 )
            {
            // InternalBasicsParser.g:6086:1: ( Float32 )
            // InternalBasicsParser.g:6087:2: Float32
            {
             before(grammarAccess.getFloat32Access().getFloat32Keyword_1()); 
            match(input,Float32,FOLLOW_2); 
             after(grammarAccess.getFloat32Access().getFloat32Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32__Group__1__Impl"


    // $ANTLR start "rule__Float64__Group__0"
    // InternalBasicsParser.g:6097:1: rule__Float64__Group__0 : rule__Float64__Group__0__Impl rule__Float64__Group__1 ;
    public final void rule__Float64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6101:1: ( rule__Float64__Group__0__Impl rule__Float64__Group__1 )
            // InternalBasicsParser.g:6102:2: rule__Float64__Group__0__Impl rule__Float64__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__Float64__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float64__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64__Group__0"


    // $ANTLR start "rule__Float64__Group__0__Impl"
    // InternalBasicsParser.g:6109:1: rule__Float64__Group__0__Impl : ( () ) ;
    public final void rule__Float64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6113:1: ( ( () ) )
            // InternalBasicsParser.g:6114:1: ( () )
            {
            // InternalBasicsParser.g:6114:1: ( () )
            // InternalBasicsParser.g:6115:2: ()
            {
             before(grammarAccess.getFloat64Access().getFloat64Action_0()); 
            // InternalBasicsParser.g:6116:2: ()
            // InternalBasicsParser.g:6116:3: 
            {
            }

             after(grammarAccess.getFloat64Access().getFloat64Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64__Group__0__Impl"


    // $ANTLR start "rule__Float64__Group__1"
    // InternalBasicsParser.g:6124:1: rule__Float64__Group__1 : rule__Float64__Group__1__Impl ;
    public final void rule__Float64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6128:1: ( rule__Float64__Group__1__Impl )
            // InternalBasicsParser.g:6129:2: rule__Float64__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Float64__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64__Group__1"


    // $ANTLR start "rule__Float64__Group__1__Impl"
    // InternalBasicsParser.g:6135:1: rule__Float64__Group__1__Impl : ( Float64 ) ;
    public final void rule__Float64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6139:1: ( ( Float64 ) )
            // InternalBasicsParser.g:6140:1: ( Float64 )
            {
            // InternalBasicsParser.g:6140:1: ( Float64 )
            // InternalBasicsParser.g:6141:2: Float64
            {
             before(grammarAccess.getFloat64Access().getFloat64Keyword_1()); 
            match(input,Float64,FOLLOW_2); 
             after(grammarAccess.getFloat64Access().getFloat64Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64__Group__1__Impl"


    // $ANTLR start "rule__String0__Group__0"
    // InternalBasicsParser.g:6151:1: rule__String0__Group__0 : rule__String0__Group__0__Impl rule__String0__Group__1 ;
    public final void rule__String0__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6155:1: ( rule__String0__Group__0__Impl rule__String0__Group__1 )
            // InternalBasicsParser.g:6156:2: rule__String0__Group__0__Impl rule__String0__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__String0__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__String0__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0__Group__0"


    // $ANTLR start "rule__String0__Group__0__Impl"
    // InternalBasicsParser.g:6163:1: rule__String0__Group__0__Impl : ( () ) ;
    public final void rule__String0__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6167:1: ( ( () ) )
            // InternalBasicsParser.g:6168:1: ( () )
            {
            // InternalBasicsParser.g:6168:1: ( () )
            // InternalBasicsParser.g:6169:2: ()
            {
             before(grammarAccess.getString0Access().getStringAction_0()); 
            // InternalBasicsParser.g:6170:2: ()
            // InternalBasicsParser.g:6170:3: 
            {
            }

             after(grammarAccess.getString0Access().getStringAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0__Group__0__Impl"


    // $ANTLR start "rule__String0__Group__1"
    // InternalBasicsParser.g:6178:1: rule__String0__Group__1 : rule__String0__Group__1__Impl ;
    public final void rule__String0__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6182:1: ( rule__String0__Group__1__Impl )
            // InternalBasicsParser.g:6183:2: rule__String0__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__String0__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0__Group__1"


    // $ANTLR start "rule__String0__Group__1__Impl"
    // InternalBasicsParser.g:6189:1: rule__String0__Group__1__Impl : ( String_1 ) ;
    public final void rule__String0__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6193:1: ( ( String_1 ) )
            // InternalBasicsParser.g:6194:1: ( String_1 )
            {
            // InternalBasicsParser.g:6194:1: ( String_1 )
            // InternalBasicsParser.g:6195:2: String_1
            {
             before(grammarAccess.getString0Access().getStringKeyword_1()); 
            match(input,String_1,FOLLOW_2); 
             after(grammarAccess.getString0Access().getStringKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0__Group__1__Impl"


    // $ANTLR start "rule__Char__Group__0"
    // InternalBasicsParser.g:6205:1: rule__Char__Group__0 : rule__Char__Group__0__Impl rule__Char__Group__1 ;
    public final void rule__Char__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6209:1: ( rule__Char__Group__0__Impl rule__Char__Group__1 )
            // InternalBasicsParser.g:6210:2: rule__Char__Group__0__Impl rule__Char__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__Char__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Char__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Char__Group__0"


    // $ANTLR start "rule__Char__Group__0__Impl"
    // InternalBasicsParser.g:6217:1: rule__Char__Group__0__Impl : ( () ) ;
    public final void rule__Char__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6221:1: ( ( () ) )
            // InternalBasicsParser.g:6222:1: ( () )
            {
            // InternalBasicsParser.g:6222:1: ( () )
            // InternalBasicsParser.g:6223:2: ()
            {
             before(grammarAccess.getCharAccess().getChar0Action_0()); 
            // InternalBasicsParser.g:6224:2: ()
            // InternalBasicsParser.g:6224:3: 
            {
            }

             after(grammarAccess.getCharAccess().getChar0Action_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Char__Group__0__Impl"


    // $ANTLR start "rule__Char__Group__1"
    // InternalBasicsParser.g:6232:1: rule__Char__Group__1 : rule__Char__Group__1__Impl ;
    public final void rule__Char__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6236:1: ( rule__Char__Group__1__Impl )
            // InternalBasicsParser.g:6237:2: rule__Char__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Char__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Char__Group__1"


    // $ANTLR start "rule__Char__Group__1__Impl"
    // InternalBasicsParser.g:6243:1: rule__Char__Group__1__Impl : ( Char ) ;
    public final void rule__Char__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6247:1: ( ( Char ) )
            // InternalBasicsParser.g:6248:1: ( Char )
            {
            // InternalBasicsParser.g:6248:1: ( Char )
            // InternalBasicsParser.g:6249:2: Char
            {
             before(grammarAccess.getCharAccess().getCharKeyword_1()); 
            match(input,Char,FOLLOW_2); 
             after(grammarAccess.getCharAccess().getCharKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Char__Group__1__Impl"


    // $ANTLR start "rule__Byte__Group__0"
    // InternalBasicsParser.g:6259:1: rule__Byte__Group__0 : rule__Byte__Group__0__Impl rule__Byte__Group__1 ;
    public final void rule__Byte__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6263:1: ( rule__Byte__Group__0__Impl rule__Byte__Group__1 )
            // InternalBasicsParser.g:6264:2: rule__Byte__Group__0__Impl rule__Byte__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__Byte__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Byte__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Byte__Group__0"


    // $ANTLR start "rule__Byte__Group__0__Impl"
    // InternalBasicsParser.g:6271:1: rule__Byte__Group__0__Impl : ( () ) ;
    public final void rule__Byte__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6275:1: ( ( () ) )
            // InternalBasicsParser.g:6276:1: ( () )
            {
            // InternalBasicsParser.g:6276:1: ( () )
            // InternalBasicsParser.g:6277:2: ()
            {
             before(grammarAccess.getByteAccess().getByteAction_0()); 
            // InternalBasicsParser.g:6278:2: ()
            // InternalBasicsParser.g:6278:3: 
            {
            }

             after(grammarAccess.getByteAccess().getByteAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Byte__Group__0__Impl"


    // $ANTLR start "rule__Byte__Group__1"
    // InternalBasicsParser.g:6286:1: rule__Byte__Group__1 : rule__Byte__Group__1__Impl ;
    public final void rule__Byte__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6290:1: ( rule__Byte__Group__1__Impl )
            // InternalBasicsParser.g:6291:2: rule__Byte__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Byte__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Byte__Group__1"


    // $ANTLR start "rule__Byte__Group__1__Impl"
    // InternalBasicsParser.g:6297:1: rule__Byte__Group__1__Impl : ( Byte ) ;
    public final void rule__Byte__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6301:1: ( ( Byte ) )
            // InternalBasicsParser.g:6302:1: ( Byte )
            {
            // InternalBasicsParser.g:6302:1: ( Byte )
            // InternalBasicsParser.g:6303:2: Byte
            {
             before(grammarAccess.getByteAccess().getByteKeyword_1()); 
            match(input,Byte,FOLLOW_2); 
             after(grammarAccess.getByteAccess().getByteKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Byte__Group__1__Impl"


    // $ANTLR start "rule__Time__Group__0"
    // InternalBasicsParser.g:6313:1: rule__Time__Group__0 : rule__Time__Group__0__Impl rule__Time__Group__1 ;
    public final void rule__Time__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6317:1: ( rule__Time__Group__0__Impl rule__Time__Group__1 )
            // InternalBasicsParser.g:6318:2: rule__Time__Group__0__Impl rule__Time__Group__1
            {
            pushFollow(FOLLOW_47);
            rule__Time__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Time__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Time__Group__0"


    // $ANTLR start "rule__Time__Group__0__Impl"
    // InternalBasicsParser.g:6325:1: rule__Time__Group__0__Impl : ( () ) ;
    public final void rule__Time__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6329:1: ( ( () ) )
            // InternalBasicsParser.g:6330:1: ( () )
            {
            // InternalBasicsParser.g:6330:1: ( () )
            // InternalBasicsParser.g:6331:2: ()
            {
             before(grammarAccess.getTimeAccess().getTimeAction_0()); 
            // InternalBasicsParser.g:6332:2: ()
            // InternalBasicsParser.g:6332:3: 
            {
            }

             after(grammarAccess.getTimeAccess().getTimeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Time__Group__0__Impl"


    // $ANTLR start "rule__Time__Group__1"
    // InternalBasicsParser.g:6340:1: rule__Time__Group__1 : rule__Time__Group__1__Impl ;
    public final void rule__Time__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6344:1: ( rule__Time__Group__1__Impl )
            // InternalBasicsParser.g:6345:2: rule__Time__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Time__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Time__Group__1"


    // $ANTLR start "rule__Time__Group__1__Impl"
    // InternalBasicsParser.g:6351:1: rule__Time__Group__1__Impl : ( Time ) ;
    public final void rule__Time__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6355:1: ( ( Time ) )
            // InternalBasicsParser.g:6356:1: ( Time )
            {
            // InternalBasicsParser.g:6356:1: ( Time )
            // InternalBasicsParser.g:6357:2: Time
            {
             before(grammarAccess.getTimeAccess().getTimeKeyword_1()); 
            match(input,Time,FOLLOW_2); 
             after(grammarAccess.getTimeAccess().getTimeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Time__Group__1__Impl"


    // $ANTLR start "rule__Duration__Group__0"
    // InternalBasicsParser.g:6367:1: rule__Duration__Group__0 : rule__Duration__Group__0__Impl rule__Duration__Group__1 ;
    public final void rule__Duration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6371:1: ( rule__Duration__Group__0__Impl rule__Duration__Group__1 )
            // InternalBasicsParser.g:6372:2: rule__Duration__Group__0__Impl rule__Duration__Group__1
            {
            pushFollow(FOLLOW_48);
            rule__Duration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Duration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Duration__Group__0"


    // $ANTLR start "rule__Duration__Group__0__Impl"
    // InternalBasicsParser.g:6379:1: rule__Duration__Group__0__Impl : ( () ) ;
    public final void rule__Duration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6383:1: ( ( () ) )
            // InternalBasicsParser.g:6384:1: ( () )
            {
            // InternalBasicsParser.g:6384:1: ( () )
            // InternalBasicsParser.g:6385:2: ()
            {
             before(grammarAccess.getDurationAccess().getDurationAction_0()); 
            // InternalBasicsParser.g:6386:2: ()
            // InternalBasicsParser.g:6386:3: 
            {
            }

             after(grammarAccess.getDurationAccess().getDurationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Duration__Group__0__Impl"


    // $ANTLR start "rule__Duration__Group__1"
    // InternalBasicsParser.g:6394:1: rule__Duration__Group__1 : rule__Duration__Group__1__Impl ;
    public final void rule__Duration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6398:1: ( rule__Duration__Group__1__Impl )
            // InternalBasicsParser.g:6399:2: rule__Duration__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Duration__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Duration__Group__1"


    // $ANTLR start "rule__Duration__Group__1__Impl"
    // InternalBasicsParser.g:6405:1: rule__Duration__Group__1__Impl : ( Duration ) ;
    public final void rule__Duration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6409:1: ( ( Duration ) )
            // InternalBasicsParser.g:6410:1: ( Duration )
            {
            // InternalBasicsParser.g:6410:1: ( Duration )
            // InternalBasicsParser.g:6411:2: Duration
            {
             before(grammarAccess.getDurationAccess().getDurationKeyword_1()); 
            match(input,Duration,FOLLOW_2); 
             after(grammarAccess.getDurationAccess().getDurationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Duration__Group__1__Impl"


    // $ANTLR start "rule__BoolArray__Group__0"
    // InternalBasicsParser.g:6421:1: rule__BoolArray__Group__0 : rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1 ;
    public final void rule__BoolArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6425:1: ( rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1 )
            // InternalBasicsParser.g:6426:2: rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__BoolArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolArray__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__0"


    // $ANTLR start "rule__BoolArray__Group__0__Impl"
    // InternalBasicsParser.g:6433:1: rule__BoolArray__Group__0__Impl : ( () ) ;
    public final void rule__BoolArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6437:1: ( ( () ) )
            // InternalBasicsParser.g:6438:1: ( () )
            {
            // InternalBasicsParser.g:6438:1: ( () )
            // InternalBasicsParser.g:6439:2: ()
            {
             before(grammarAccess.getBoolArrayAccess().getBoolArrayAction_0()); 
            // InternalBasicsParser.g:6440:2: ()
            // InternalBasicsParser.g:6440:3: 
            {
            }

             after(grammarAccess.getBoolArrayAccess().getBoolArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__0__Impl"


    // $ANTLR start "rule__BoolArray__Group__1"
    // InternalBasicsParser.g:6448:1: rule__BoolArray__Group__1 : rule__BoolArray__Group__1__Impl ;
    public final void rule__BoolArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6452:1: ( rule__BoolArray__Group__1__Impl )
            // InternalBasicsParser.g:6453:2: rule__BoolArray__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolArray__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__1"


    // $ANTLR start "rule__BoolArray__Group__1__Impl"
    // InternalBasicsParser.g:6459:1: rule__BoolArray__Group__1__Impl : ( Bool_1 ) ;
    public final void rule__BoolArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6463:1: ( ( Bool_1 ) )
            // InternalBasicsParser.g:6464:1: ( Bool_1 )
            {
            // InternalBasicsParser.g:6464:1: ( Bool_1 )
            // InternalBasicsParser.g:6465:2: Bool_1
            {
             before(grammarAccess.getBoolArrayAccess().getBoolKeyword_1()); 
            match(input,Bool_1,FOLLOW_2); 
             after(grammarAccess.getBoolArrayAccess().getBoolKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__1__Impl"


    // $ANTLR start "rule__Int8Array__Group__0"
    // InternalBasicsParser.g:6475:1: rule__Int8Array__Group__0 : rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1 ;
    public final void rule__Int8Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6479:1: ( rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1 )
            // InternalBasicsParser.g:6480:2: rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1
            {
            pushFollow(FOLLOW_50);
            rule__Int8Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int8Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__0"


    // $ANTLR start "rule__Int8Array__Group__0__Impl"
    // InternalBasicsParser.g:6487:1: rule__Int8Array__Group__0__Impl : ( () ) ;
    public final void rule__Int8Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6491:1: ( ( () ) )
            // InternalBasicsParser.g:6492:1: ( () )
            {
            // InternalBasicsParser.g:6492:1: ( () )
            // InternalBasicsParser.g:6493:2: ()
            {
             before(grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0()); 
            // InternalBasicsParser.g:6494:2: ()
            // InternalBasicsParser.g:6494:3: 
            {
            }

             after(grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__0__Impl"


    // $ANTLR start "rule__Int8Array__Group__1"
    // InternalBasicsParser.g:6502:1: rule__Int8Array__Group__1 : rule__Int8Array__Group__1__Impl ;
    public final void rule__Int8Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6506:1: ( rule__Int8Array__Group__1__Impl )
            // InternalBasicsParser.g:6507:2: rule__Int8Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int8Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__1"


    // $ANTLR start "rule__Int8Array__Group__1__Impl"
    // InternalBasicsParser.g:6513:1: rule__Int8Array__Group__1__Impl : ( Int8_1 ) ;
    public final void rule__Int8Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6517:1: ( ( Int8_1 ) )
            // InternalBasicsParser.g:6518:1: ( Int8_1 )
            {
            // InternalBasicsParser.g:6518:1: ( Int8_1 )
            // InternalBasicsParser.g:6519:2: Int8_1
            {
             before(grammarAccess.getInt8ArrayAccess().getInt8Keyword_1()); 
            match(input,Int8_1,FOLLOW_2); 
             after(grammarAccess.getInt8ArrayAccess().getInt8Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__1__Impl"


    // $ANTLR start "rule__Uint8Array__Group__0"
    // InternalBasicsParser.g:6529:1: rule__Uint8Array__Group__0 : rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1 ;
    public final void rule__Uint8Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6533:1: ( rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1 )
            // InternalBasicsParser.g:6534:2: rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__Uint8Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint8Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__0"


    // $ANTLR start "rule__Uint8Array__Group__0__Impl"
    // InternalBasicsParser.g:6541:1: rule__Uint8Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint8Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6545:1: ( ( () ) )
            // InternalBasicsParser.g:6546:1: ( () )
            {
            // InternalBasicsParser.g:6546:1: ( () )
            // InternalBasicsParser.g:6547:2: ()
            {
             before(grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0()); 
            // InternalBasicsParser.g:6548:2: ()
            // InternalBasicsParser.g:6548:3: 
            {
            }

             after(grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__0__Impl"


    // $ANTLR start "rule__Uint8Array__Group__1"
    // InternalBasicsParser.g:6556:1: rule__Uint8Array__Group__1 : rule__Uint8Array__Group__1__Impl ;
    public final void rule__Uint8Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6560:1: ( rule__Uint8Array__Group__1__Impl )
            // InternalBasicsParser.g:6561:2: rule__Uint8Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint8Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__1"


    // $ANTLR start "rule__Uint8Array__Group__1__Impl"
    // InternalBasicsParser.g:6567:1: rule__Uint8Array__Group__1__Impl : ( Uint8_1 ) ;
    public final void rule__Uint8Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6571:1: ( ( Uint8_1 ) )
            // InternalBasicsParser.g:6572:1: ( Uint8_1 )
            {
            // InternalBasicsParser.g:6572:1: ( Uint8_1 )
            // InternalBasicsParser.g:6573:2: Uint8_1
            {
             before(grammarAccess.getUint8ArrayAccess().getUint8Keyword_1()); 
            match(input,Uint8_1,FOLLOW_2); 
             after(grammarAccess.getUint8ArrayAccess().getUint8Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__1__Impl"


    // $ANTLR start "rule__Int16Array__Group__0"
    // InternalBasicsParser.g:6583:1: rule__Int16Array__Group__0 : rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1 ;
    public final void rule__Int16Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6587:1: ( rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1 )
            // InternalBasicsParser.g:6588:2: rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1
            {
            pushFollow(FOLLOW_52);
            rule__Int16Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int16Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__0"


    // $ANTLR start "rule__Int16Array__Group__0__Impl"
    // InternalBasicsParser.g:6595:1: rule__Int16Array__Group__0__Impl : ( () ) ;
    public final void rule__Int16Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6599:1: ( ( () ) )
            // InternalBasicsParser.g:6600:1: ( () )
            {
            // InternalBasicsParser.g:6600:1: ( () )
            // InternalBasicsParser.g:6601:2: ()
            {
             before(grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0()); 
            // InternalBasicsParser.g:6602:2: ()
            // InternalBasicsParser.g:6602:3: 
            {
            }

             after(grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__0__Impl"


    // $ANTLR start "rule__Int16Array__Group__1"
    // InternalBasicsParser.g:6610:1: rule__Int16Array__Group__1 : rule__Int16Array__Group__1__Impl ;
    public final void rule__Int16Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6614:1: ( rule__Int16Array__Group__1__Impl )
            // InternalBasicsParser.g:6615:2: rule__Int16Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int16Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__1"


    // $ANTLR start "rule__Int16Array__Group__1__Impl"
    // InternalBasicsParser.g:6621:1: rule__Int16Array__Group__1__Impl : ( Int16_1 ) ;
    public final void rule__Int16Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6625:1: ( ( Int16_1 ) )
            // InternalBasicsParser.g:6626:1: ( Int16_1 )
            {
            // InternalBasicsParser.g:6626:1: ( Int16_1 )
            // InternalBasicsParser.g:6627:2: Int16_1
            {
             before(grammarAccess.getInt16ArrayAccess().getInt16Keyword_1()); 
            match(input,Int16_1,FOLLOW_2); 
             after(grammarAccess.getInt16ArrayAccess().getInt16Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__1__Impl"


    // $ANTLR start "rule__Uint16Array__Group__0"
    // InternalBasicsParser.g:6637:1: rule__Uint16Array__Group__0 : rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1 ;
    public final void rule__Uint16Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6641:1: ( rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1 )
            // InternalBasicsParser.g:6642:2: rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1
            {
            pushFollow(FOLLOW_53);
            rule__Uint16Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint16Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__0"


    // $ANTLR start "rule__Uint16Array__Group__0__Impl"
    // InternalBasicsParser.g:6649:1: rule__Uint16Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint16Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6653:1: ( ( () ) )
            // InternalBasicsParser.g:6654:1: ( () )
            {
            // InternalBasicsParser.g:6654:1: ( () )
            // InternalBasicsParser.g:6655:2: ()
            {
             before(grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0()); 
            // InternalBasicsParser.g:6656:2: ()
            // InternalBasicsParser.g:6656:3: 
            {
            }

             after(grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__0__Impl"


    // $ANTLR start "rule__Uint16Array__Group__1"
    // InternalBasicsParser.g:6664:1: rule__Uint16Array__Group__1 : rule__Uint16Array__Group__1__Impl ;
    public final void rule__Uint16Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6668:1: ( rule__Uint16Array__Group__1__Impl )
            // InternalBasicsParser.g:6669:2: rule__Uint16Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint16Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__1"


    // $ANTLR start "rule__Uint16Array__Group__1__Impl"
    // InternalBasicsParser.g:6675:1: rule__Uint16Array__Group__1__Impl : ( Uint16_1 ) ;
    public final void rule__Uint16Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6679:1: ( ( Uint16_1 ) )
            // InternalBasicsParser.g:6680:1: ( Uint16_1 )
            {
            // InternalBasicsParser.g:6680:1: ( Uint16_1 )
            // InternalBasicsParser.g:6681:2: Uint16_1
            {
             before(grammarAccess.getUint16ArrayAccess().getUint16Keyword_1()); 
            match(input,Uint16_1,FOLLOW_2); 
             after(grammarAccess.getUint16ArrayAccess().getUint16Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__1__Impl"


    // $ANTLR start "rule__Int32Array__Group__0"
    // InternalBasicsParser.g:6691:1: rule__Int32Array__Group__0 : rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1 ;
    public final void rule__Int32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6695:1: ( rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1 )
            // InternalBasicsParser.g:6696:2: rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__Int32Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int32Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__0"


    // $ANTLR start "rule__Int32Array__Group__0__Impl"
    // InternalBasicsParser.g:6703:1: rule__Int32Array__Group__0__Impl : ( () ) ;
    public final void rule__Int32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6707:1: ( ( () ) )
            // InternalBasicsParser.g:6708:1: ( () )
            {
            // InternalBasicsParser.g:6708:1: ( () )
            // InternalBasicsParser.g:6709:2: ()
            {
             before(grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0()); 
            // InternalBasicsParser.g:6710:2: ()
            // InternalBasicsParser.g:6710:3: 
            {
            }

             after(grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__0__Impl"


    // $ANTLR start "rule__Int32Array__Group__1"
    // InternalBasicsParser.g:6718:1: rule__Int32Array__Group__1 : rule__Int32Array__Group__1__Impl ;
    public final void rule__Int32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6722:1: ( rule__Int32Array__Group__1__Impl )
            // InternalBasicsParser.g:6723:2: rule__Int32Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int32Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__1"


    // $ANTLR start "rule__Int32Array__Group__1__Impl"
    // InternalBasicsParser.g:6729:1: rule__Int32Array__Group__1__Impl : ( Int32_1 ) ;
    public final void rule__Int32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6733:1: ( ( Int32_1 ) )
            // InternalBasicsParser.g:6734:1: ( Int32_1 )
            {
            // InternalBasicsParser.g:6734:1: ( Int32_1 )
            // InternalBasicsParser.g:6735:2: Int32_1
            {
             before(grammarAccess.getInt32ArrayAccess().getInt32Keyword_1()); 
            match(input,Int32_1,FOLLOW_2); 
             after(grammarAccess.getInt32ArrayAccess().getInt32Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__1__Impl"


    // $ANTLR start "rule__Uint32Array__Group__0"
    // InternalBasicsParser.g:6745:1: rule__Uint32Array__Group__0 : rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1 ;
    public final void rule__Uint32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6749:1: ( rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1 )
            // InternalBasicsParser.g:6750:2: rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1
            {
            pushFollow(FOLLOW_55);
            rule__Uint32Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint32Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__0"


    // $ANTLR start "rule__Uint32Array__Group__0__Impl"
    // InternalBasicsParser.g:6757:1: rule__Uint32Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6761:1: ( ( () ) )
            // InternalBasicsParser.g:6762:1: ( () )
            {
            // InternalBasicsParser.g:6762:1: ( () )
            // InternalBasicsParser.g:6763:2: ()
            {
             before(grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0()); 
            // InternalBasicsParser.g:6764:2: ()
            // InternalBasicsParser.g:6764:3: 
            {
            }

             after(grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__0__Impl"


    // $ANTLR start "rule__Uint32Array__Group__1"
    // InternalBasicsParser.g:6772:1: rule__Uint32Array__Group__1 : rule__Uint32Array__Group__1__Impl ;
    public final void rule__Uint32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6776:1: ( rule__Uint32Array__Group__1__Impl )
            // InternalBasicsParser.g:6777:2: rule__Uint32Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint32Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__1"


    // $ANTLR start "rule__Uint32Array__Group__1__Impl"
    // InternalBasicsParser.g:6783:1: rule__Uint32Array__Group__1__Impl : ( Uint32_1 ) ;
    public final void rule__Uint32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6787:1: ( ( Uint32_1 ) )
            // InternalBasicsParser.g:6788:1: ( Uint32_1 )
            {
            // InternalBasicsParser.g:6788:1: ( Uint32_1 )
            // InternalBasicsParser.g:6789:2: Uint32_1
            {
             before(grammarAccess.getUint32ArrayAccess().getUint32Keyword_1()); 
            match(input,Uint32_1,FOLLOW_2); 
             after(grammarAccess.getUint32ArrayAccess().getUint32Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__1__Impl"


    // $ANTLR start "rule__Int64Array__Group__0"
    // InternalBasicsParser.g:6799:1: rule__Int64Array__Group__0 : rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1 ;
    public final void rule__Int64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6803:1: ( rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1 )
            // InternalBasicsParser.g:6804:2: rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1
            {
            pushFollow(FOLLOW_56);
            rule__Int64Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int64Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__0"


    // $ANTLR start "rule__Int64Array__Group__0__Impl"
    // InternalBasicsParser.g:6811:1: rule__Int64Array__Group__0__Impl : ( () ) ;
    public final void rule__Int64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6815:1: ( ( () ) )
            // InternalBasicsParser.g:6816:1: ( () )
            {
            // InternalBasicsParser.g:6816:1: ( () )
            // InternalBasicsParser.g:6817:2: ()
            {
             before(grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0()); 
            // InternalBasicsParser.g:6818:2: ()
            // InternalBasicsParser.g:6818:3: 
            {
            }

             after(grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__0__Impl"


    // $ANTLR start "rule__Int64Array__Group__1"
    // InternalBasicsParser.g:6826:1: rule__Int64Array__Group__1 : rule__Int64Array__Group__1__Impl ;
    public final void rule__Int64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6830:1: ( rule__Int64Array__Group__1__Impl )
            // InternalBasicsParser.g:6831:2: rule__Int64Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int64Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__1"


    // $ANTLR start "rule__Int64Array__Group__1__Impl"
    // InternalBasicsParser.g:6837:1: rule__Int64Array__Group__1__Impl : ( Int64_1 ) ;
    public final void rule__Int64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6841:1: ( ( Int64_1 ) )
            // InternalBasicsParser.g:6842:1: ( Int64_1 )
            {
            // InternalBasicsParser.g:6842:1: ( Int64_1 )
            // InternalBasicsParser.g:6843:2: Int64_1
            {
             before(grammarAccess.getInt64ArrayAccess().getInt64Keyword_1()); 
            match(input,Int64_1,FOLLOW_2); 
             after(grammarAccess.getInt64ArrayAccess().getInt64Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__1__Impl"


    // $ANTLR start "rule__Uint64Array__Group__0"
    // InternalBasicsParser.g:6853:1: rule__Uint64Array__Group__0 : rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1 ;
    public final void rule__Uint64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6857:1: ( rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1 )
            // InternalBasicsParser.g:6858:2: rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1
            {
            pushFollow(FOLLOW_57);
            rule__Uint64Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint64Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__0"


    // $ANTLR start "rule__Uint64Array__Group__0__Impl"
    // InternalBasicsParser.g:6865:1: rule__Uint64Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6869:1: ( ( () ) )
            // InternalBasicsParser.g:6870:1: ( () )
            {
            // InternalBasicsParser.g:6870:1: ( () )
            // InternalBasicsParser.g:6871:2: ()
            {
             before(grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0()); 
            // InternalBasicsParser.g:6872:2: ()
            // InternalBasicsParser.g:6872:3: 
            {
            }

             after(grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__0__Impl"


    // $ANTLR start "rule__Uint64Array__Group__1"
    // InternalBasicsParser.g:6880:1: rule__Uint64Array__Group__1 : rule__Uint64Array__Group__1__Impl ;
    public final void rule__Uint64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6884:1: ( rule__Uint64Array__Group__1__Impl )
            // InternalBasicsParser.g:6885:2: rule__Uint64Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint64Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__1"


    // $ANTLR start "rule__Uint64Array__Group__1__Impl"
    // InternalBasicsParser.g:6891:1: rule__Uint64Array__Group__1__Impl : ( Uint64_1 ) ;
    public final void rule__Uint64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6895:1: ( ( Uint64_1 ) )
            // InternalBasicsParser.g:6896:1: ( Uint64_1 )
            {
            // InternalBasicsParser.g:6896:1: ( Uint64_1 )
            // InternalBasicsParser.g:6897:2: Uint64_1
            {
             before(grammarAccess.getUint64ArrayAccess().getUint64Keyword_1()); 
            match(input,Uint64_1,FOLLOW_2); 
             after(grammarAccess.getUint64ArrayAccess().getUint64Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__1__Impl"


    // $ANTLR start "rule__Float32Array__Group__0"
    // InternalBasicsParser.g:6907:1: rule__Float32Array__Group__0 : rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1 ;
    public final void rule__Float32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6911:1: ( rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1 )
            // InternalBasicsParser.g:6912:2: rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1
            {
            pushFollow(FOLLOW_58);
            rule__Float32Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float32Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__0"


    // $ANTLR start "rule__Float32Array__Group__0__Impl"
    // InternalBasicsParser.g:6919:1: rule__Float32Array__Group__0__Impl : ( () ) ;
    public final void rule__Float32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6923:1: ( ( () ) )
            // InternalBasicsParser.g:6924:1: ( () )
            {
            // InternalBasicsParser.g:6924:1: ( () )
            // InternalBasicsParser.g:6925:2: ()
            {
             before(grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0()); 
            // InternalBasicsParser.g:6926:2: ()
            // InternalBasicsParser.g:6926:3: 
            {
            }

             after(grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__0__Impl"


    // $ANTLR start "rule__Float32Array__Group__1"
    // InternalBasicsParser.g:6934:1: rule__Float32Array__Group__1 : rule__Float32Array__Group__1__Impl ;
    public final void rule__Float32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6938:1: ( rule__Float32Array__Group__1__Impl )
            // InternalBasicsParser.g:6939:2: rule__Float32Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Float32Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__1"


    // $ANTLR start "rule__Float32Array__Group__1__Impl"
    // InternalBasicsParser.g:6945:1: rule__Float32Array__Group__1__Impl : ( Float32_1 ) ;
    public final void rule__Float32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6949:1: ( ( Float32_1 ) )
            // InternalBasicsParser.g:6950:1: ( Float32_1 )
            {
            // InternalBasicsParser.g:6950:1: ( Float32_1 )
            // InternalBasicsParser.g:6951:2: Float32_1
            {
             before(grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1()); 
            match(input,Float32_1,FOLLOW_2); 
             after(grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__1__Impl"


    // $ANTLR start "rule__Float64Array__Group__0"
    // InternalBasicsParser.g:6961:1: rule__Float64Array__Group__0 : rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1 ;
    public final void rule__Float64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6965:1: ( rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1 )
            // InternalBasicsParser.g:6966:2: rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1
            {
            pushFollow(FOLLOW_59);
            rule__Float64Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float64Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__0"


    // $ANTLR start "rule__Float64Array__Group__0__Impl"
    // InternalBasicsParser.g:6973:1: rule__Float64Array__Group__0__Impl : ( () ) ;
    public final void rule__Float64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6977:1: ( ( () ) )
            // InternalBasicsParser.g:6978:1: ( () )
            {
            // InternalBasicsParser.g:6978:1: ( () )
            // InternalBasicsParser.g:6979:2: ()
            {
             before(grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0()); 
            // InternalBasicsParser.g:6980:2: ()
            // InternalBasicsParser.g:6980:3: 
            {
            }

             after(grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__0__Impl"


    // $ANTLR start "rule__Float64Array__Group__1"
    // InternalBasicsParser.g:6988:1: rule__Float64Array__Group__1 : rule__Float64Array__Group__1__Impl ;
    public final void rule__Float64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6992:1: ( rule__Float64Array__Group__1__Impl )
            // InternalBasicsParser.g:6993:2: rule__Float64Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Float64Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__1"


    // $ANTLR start "rule__Float64Array__Group__1__Impl"
    // InternalBasicsParser.g:6999:1: rule__Float64Array__Group__1__Impl : ( Float64_1 ) ;
    public final void rule__Float64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7003:1: ( ( Float64_1 ) )
            // InternalBasicsParser.g:7004:1: ( Float64_1 )
            {
            // InternalBasicsParser.g:7004:1: ( Float64_1 )
            // InternalBasicsParser.g:7005:2: Float64_1
            {
             before(grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1()); 
            match(input,Float64_1,FOLLOW_2); 
             after(grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__1__Impl"


    // $ANTLR start "rule__String0Array__Group__0"
    // InternalBasicsParser.g:7015:1: rule__String0Array__Group__0 : rule__String0Array__Group__0__Impl rule__String0Array__Group__1 ;
    public final void rule__String0Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7019:1: ( rule__String0Array__Group__0__Impl rule__String0Array__Group__1 )
            // InternalBasicsParser.g:7020:2: rule__String0Array__Group__0__Impl rule__String0Array__Group__1
            {
            pushFollow(FOLLOW_60);
            rule__String0Array__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__String0Array__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__0"


    // $ANTLR start "rule__String0Array__Group__0__Impl"
    // InternalBasicsParser.g:7027:1: rule__String0Array__Group__0__Impl : ( () ) ;
    public final void rule__String0Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7031:1: ( ( () ) )
            // InternalBasicsParser.g:7032:1: ( () )
            {
            // InternalBasicsParser.g:7032:1: ( () )
            // InternalBasicsParser.g:7033:2: ()
            {
             before(grammarAccess.getString0ArrayAccess().getStringArrayAction_0()); 
            // InternalBasicsParser.g:7034:2: ()
            // InternalBasicsParser.g:7034:3: 
            {
            }

             after(grammarAccess.getString0ArrayAccess().getStringArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__0__Impl"


    // $ANTLR start "rule__String0Array__Group__1"
    // InternalBasicsParser.g:7042:1: rule__String0Array__Group__1 : rule__String0Array__Group__1__Impl ;
    public final void rule__String0Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7046:1: ( rule__String0Array__Group__1__Impl )
            // InternalBasicsParser.g:7047:2: rule__String0Array__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__String0Array__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__1"


    // $ANTLR start "rule__String0Array__Group__1__Impl"
    // InternalBasicsParser.g:7053:1: rule__String0Array__Group__1__Impl : ( String_2 ) ;
    public final void rule__String0Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7057:1: ( ( String_2 ) )
            // InternalBasicsParser.g:7058:1: ( String_2 )
            {
            // InternalBasicsParser.g:7058:1: ( String_2 )
            // InternalBasicsParser.g:7059:2: String_2
            {
             before(grammarAccess.getString0ArrayAccess().getStringKeyword_1()); 
            match(input,String_2,FOLLOW_2); 
             after(grammarAccess.getString0ArrayAccess().getStringKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__1__Impl"


    // $ANTLR start "rule__ByteArray__Group__0"
    // InternalBasicsParser.g:7069:1: rule__ByteArray__Group__0 : rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1 ;
    public final void rule__ByteArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7073:1: ( rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1 )
            // InternalBasicsParser.g:7074:2: rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1
            {
            pushFollow(FOLLOW_61);
            rule__ByteArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ByteArray__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__0"


    // $ANTLR start "rule__ByteArray__Group__0__Impl"
    // InternalBasicsParser.g:7081:1: rule__ByteArray__Group__0__Impl : ( () ) ;
    public final void rule__ByteArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7085:1: ( ( () ) )
            // InternalBasicsParser.g:7086:1: ( () )
            {
            // InternalBasicsParser.g:7086:1: ( () )
            // InternalBasicsParser.g:7087:2: ()
            {
             before(grammarAccess.getByteArrayAccess().getByteArrayAction_0()); 
            // InternalBasicsParser.g:7088:2: ()
            // InternalBasicsParser.g:7088:3: 
            {
            }

             after(grammarAccess.getByteArrayAccess().getByteArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__0__Impl"


    // $ANTLR start "rule__ByteArray__Group__1"
    // InternalBasicsParser.g:7096:1: rule__ByteArray__Group__1 : rule__ByteArray__Group__1__Impl ;
    public final void rule__ByteArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7100:1: ( rule__ByteArray__Group__1__Impl )
            // InternalBasicsParser.g:7101:2: rule__ByteArray__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ByteArray__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__1"


    // $ANTLR start "rule__ByteArray__Group__1__Impl"
    // InternalBasicsParser.g:7107:1: rule__ByteArray__Group__1__Impl : ( Byte_1 ) ;
    public final void rule__ByteArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7111:1: ( ( Byte_1 ) )
            // InternalBasicsParser.g:7112:1: ( Byte_1 )
            {
            // InternalBasicsParser.g:7112:1: ( Byte_1 )
            // InternalBasicsParser.g:7113:2: Byte_1
            {
             before(grammarAccess.getByteArrayAccess().getByteKeyword_1()); 
            match(input,Byte_1,FOLLOW_2); 
             after(grammarAccess.getByteArrayAccess().getByteKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__1__Impl"


    // $ANTLR start "rule__CharArray__Group__0"
    // InternalBasicsParser.g:7123:1: rule__CharArray__Group__0 : rule__CharArray__Group__0__Impl rule__CharArray__Group__1 ;
    public final void rule__CharArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7127:1: ( rule__CharArray__Group__0__Impl rule__CharArray__Group__1 )
            // InternalBasicsParser.g:7128:2: rule__CharArray__Group__0__Impl rule__CharArray__Group__1
            {
            pushFollow(FOLLOW_62);
            rule__CharArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CharArray__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__0"


    // $ANTLR start "rule__CharArray__Group__0__Impl"
    // InternalBasicsParser.g:7135:1: rule__CharArray__Group__0__Impl : ( () ) ;
    public final void rule__CharArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7139:1: ( ( () ) )
            // InternalBasicsParser.g:7140:1: ( () )
            {
            // InternalBasicsParser.g:7140:1: ( () )
            // InternalBasicsParser.g:7141:2: ()
            {
             before(grammarAccess.getCharArrayAccess().getCharArrayAction_0()); 
            // InternalBasicsParser.g:7142:2: ()
            // InternalBasicsParser.g:7142:3: 
            {
            }

             after(grammarAccess.getCharArrayAccess().getCharArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__0__Impl"


    // $ANTLR start "rule__CharArray__Group__1"
    // InternalBasicsParser.g:7150:1: rule__CharArray__Group__1 : rule__CharArray__Group__1__Impl ;
    public final void rule__CharArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7154:1: ( rule__CharArray__Group__1__Impl )
            // InternalBasicsParser.g:7155:2: rule__CharArray__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CharArray__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__1"


    // $ANTLR start "rule__CharArray__Group__1__Impl"
    // InternalBasicsParser.g:7161:1: rule__CharArray__Group__1__Impl : ( Char_1 ) ;
    public final void rule__CharArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7165:1: ( ( Char_1 ) )
            // InternalBasicsParser.g:7166:1: ( Char_1 )
            {
            // InternalBasicsParser.g:7166:1: ( Char_1 )
            // InternalBasicsParser.g:7167:2: Char_1
            {
             before(grammarAccess.getCharArrayAccess().getCharKeyword_1()); 
            match(input,Char_1,FOLLOW_2); 
             after(grammarAccess.getCharArrayAccess().getCharKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__1__Impl"


    // $ANTLR start "rule__Header__Group__0"
    // InternalBasicsParser.g:7177:1: rule__Header__Group__0 : rule__Header__Group__0__Impl rule__Header__Group__1 ;
    public final void rule__Header__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7181:1: ( rule__Header__Group__0__Impl rule__Header__Group__1 )
            // InternalBasicsParser.g:7182:2: rule__Header__Group__0__Impl rule__Header__Group__1
            {
            pushFollow(FOLLOW_63);
            rule__Header__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Header__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__0"


    // $ANTLR start "rule__Header__Group__0__Impl"
    // InternalBasicsParser.g:7189:1: rule__Header__Group__0__Impl : ( () ) ;
    public final void rule__Header__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7193:1: ( ( () ) )
            // InternalBasicsParser.g:7194:1: ( () )
            {
            // InternalBasicsParser.g:7194:1: ( () )
            // InternalBasicsParser.g:7195:2: ()
            {
             before(grammarAccess.getHeaderAccess().getHeaderAction_0()); 
            // InternalBasicsParser.g:7196:2: ()
            // InternalBasicsParser.g:7196:3: 
            {
            }

             after(grammarAccess.getHeaderAccess().getHeaderAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__0__Impl"


    // $ANTLR start "rule__Header__Group__1"
    // InternalBasicsParser.g:7204:1: rule__Header__Group__1 : rule__Header__Group__1__Impl ;
    public final void rule__Header__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7208:1: ( rule__Header__Group__1__Impl )
            // InternalBasicsParser.g:7209:2: rule__Header__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Header__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__1"


    // $ANTLR start "rule__Header__Group__1__Impl"
    // InternalBasicsParser.g:7215:1: rule__Header__Group__1__Impl : ( Header ) ;
    public final void rule__Header__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7219:1: ( ( Header ) )
            // InternalBasicsParser.g:7220:1: ( Header )
            {
            // InternalBasicsParser.g:7220:1: ( Header )
            // InternalBasicsParser.g:7221:2: Header
            {
             before(grammarAccess.getHeaderAccess().getHeaderKeyword_1()); 
            match(input,Header,FOLLOW_2); 
             after(grammarAccess.getHeaderAccess().getHeaderKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Header__Group__1__Impl"


    // $ANTLR start "rule__ArraySpecRef__Group__0"
    // InternalBasicsParser.g:7231:1: rule__ArraySpecRef__Group__0 : rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1 ;
    public final void rule__ArraySpecRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7235:1: ( rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1 )
            // InternalBasicsParser.g:7236:2: rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1
            {
            pushFollow(FOLLOW_64);
            rule__ArraySpecRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArraySpecRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArraySpecRef__Group__0"


    // $ANTLR start "rule__ArraySpecRef__Group__0__Impl"
    // InternalBasicsParser.g:7243:1: rule__ArraySpecRef__Group__0__Impl : ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) ) ;
    public final void rule__ArraySpecRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7247:1: ( ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) ) )
            // InternalBasicsParser.g:7248:1: ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) )
            {
            // InternalBasicsParser.g:7248:1: ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) )
            // InternalBasicsParser.g:7249:2: ( rule__ArraySpecRef__ReferenceAssignment_0 )
            {
             before(grammarAccess.getArraySpecRefAccess().getReferenceAssignment_0()); 
            // InternalBasicsParser.g:7250:2: ( rule__ArraySpecRef__ReferenceAssignment_0 )
            // InternalBasicsParser.g:7250:3: rule__ArraySpecRef__ReferenceAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ArraySpecRef__ReferenceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getArraySpecRefAccess().getReferenceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArraySpecRef__Group__0__Impl"


    // $ANTLR start "rule__ArraySpecRef__Group__1"
    // InternalBasicsParser.g:7258:1: rule__ArraySpecRef__Group__1 : rule__ArraySpecRef__Group__1__Impl ;
    public final void rule__ArraySpecRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7262:1: ( rule__ArraySpecRef__Group__1__Impl )
            // InternalBasicsParser.g:7263:2: rule__ArraySpecRef__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArraySpecRef__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArraySpecRef__Group__1"


    // $ANTLR start "rule__ArraySpecRef__Group__1__Impl"
    // InternalBasicsParser.g:7269:1: rule__ArraySpecRef__Group__1__Impl : ( LeftSquareBracketRightSquareBracket ) ;
    public final void rule__ArraySpecRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7273:1: ( ( LeftSquareBracketRightSquareBracket ) )
            // InternalBasicsParser.g:7274:1: ( LeftSquareBracketRightSquareBracket )
            {
            // InternalBasicsParser.g:7274:1: ( LeftSquareBracketRightSquareBracket )
            // InternalBasicsParser.g:7275:2: LeftSquareBracketRightSquareBracket
            {
             before(grammarAccess.getArraySpecRefAccess().getLeftSquareBracketRightSquareBracketKeyword_1()); 
            match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getArraySpecRefAccess().getLeftSquareBracketRightSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArraySpecRef__Group__1__Impl"


    // $ANTLR start "rule__ExtensionBlockName__Group__0"
    // InternalBasicsParser.g:7285:1: rule__ExtensionBlockName__Group__0 : rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1 ;
    public final void rule__ExtensionBlockName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7289:1: ( rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1 )
            // InternalBasicsParser.g:7290:2: rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1
            {
            pushFollow(FOLLOW_65);
            rule__ExtensionBlockName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionBlockName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group__0"


    // $ANTLR start "rule__ExtensionBlockName__Group__0__Impl"
    // InternalBasicsParser.g:7297:1: rule__ExtensionBlockName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__ExtensionBlockName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7301:1: ( ( RULE_ID ) )
            // InternalBasicsParser.g:7302:1: ( RULE_ID )
            {
            // InternalBasicsParser.g:7302:1: ( RULE_ID )
            // InternalBasicsParser.g:7303:2: RULE_ID
            {
             before(grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group__0__Impl"


    // $ANTLR start "rule__ExtensionBlockName__Group__1"
    // InternalBasicsParser.g:7312:1: rule__ExtensionBlockName__Group__1 : rule__ExtensionBlockName__Group__1__Impl ;
    public final void rule__ExtensionBlockName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7316:1: ( rule__ExtensionBlockName__Group__1__Impl )
            // InternalBasicsParser.g:7317:2: rule__ExtensionBlockName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBlockName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group__1"


    // $ANTLR start "rule__ExtensionBlockName__Group__1__Impl"
    // InternalBasicsParser.g:7323:1: rule__ExtensionBlockName__Group__1__Impl : ( ( rule__ExtensionBlockName__Group_1__0 )* ) ;
    public final void rule__ExtensionBlockName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7327:1: ( ( ( rule__ExtensionBlockName__Group_1__0 )* ) )
            // InternalBasicsParser.g:7328:1: ( ( rule__ExtensionBlockName__Group_1__0 )* )
            {
            // InternalBasicsParser.g:7328:1: ( ( rule__ExtensionBlockName__Group_1__0 )* )
            // InternalBasicsParser.g:7329:2: ( rule__ExtensionBlockName__Group_1__0 )*
            {
             before(grammarAccess.getExtensionBlockNameAccess().getGroup_1()); 
            // InternalBasicsParser.g:7330:2: ( rule__ExtensionBlockName__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==FullStop) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalBasicsParser.g:7330:3: rule__ExtensionBlockName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_66);
            	    rule__ExtensionBlockName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getExtensionBlockNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group__1__Impl"


    // $ANTLR start "rule__ExtensionBlockName__Group_1__0"
    // InternalBasicsParser.g:7339:1: rule__ExtensionBlockName__Group_1__0 : rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1 ;
    public final void rule__ExtensionBlockName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7343:1: ( rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1 )
            // InternalBasicsParser.g:7344:2: rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1
            {
            pushFollow(FOLLOW_67);
            rule__ExtensionBlockName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionBlockName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group_1__0"


    // $ANTLR start "rule__ExtensionBlockName__Group_1__0__Impl"
    // InternalBasicsParser.g:7351:1: rule__ExtensionBlockName__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__ExtensionBlockName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7355:1: ( ( FullStop ) )
            // InternalBasicsParser.g:7356:1: ( FullStop )
            {
            // InternalBasicsParser.g:7356:1: ( FullStop )
            // InternalBasicsParser.g:7357:2: FullStop
            {
             before(grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0()); 
            match(input,FullStop,FOLLOW_2); 
             after(grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group_1__0__Impl"


    // $ANTLR start "rule__ExtensionBlockName__Group_1__1"
    // InternalBasicsParser.g:7366:1: rule__ExtensionBlockName__Group_1__1 : rule__ExtensionBlockName__Group_1__1__Impl ;
    public final void rule__ExtensionBlockName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7370:1: ( rule__ExtensionBlockName__Group_1__1__Impl )
            // InternalBasicsParser.g:7371:2: rule__ExtensionBlockName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBlockName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group_1__1"


    // $ANTLR start "rule__ExtensionBlockName__Group_1__1__Impl"
    // InternalBasicsParser.g:7377:1: rule__ExtensionBlockName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__ExtensionBlockName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7381:1: ( ( RULE_ID ) )
            // InternalBasicsParser.g:7382:1: ( RULE_ID )
            {
            // InternalBasicsParser.g:7382:1: ( RULE_ID )
            // InternalBasicsParser.g:7383:2: RULE_ID
            {
             before(grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBlockName__Group_1__1__Impl"


    // $ANTLR start "rule__ExtensionEntry__Group__0"
    // InternalBasicsParser.g:7393:1: rule__ExtensionEntry__Group__0 : rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1 ;
    public final void rule__ExtensionEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7397:1: ( rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1 )
            // InternalBasicsParser.g:7398:2: rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1
            {
            pushFollow(FOLLOW_68);
            rule__ExtensionEntry__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group__0"


    // $ANTLR start "rule__ExtensionEntry__Group__0__Impl"
    // InternalBasicsParser.g:7405:1: rule__ExtensionEntry__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7409:1: ( ( () ) )
            // InternalBasicsParser.g:7410:1: ( () )
            {
            // InternalBasicsParser.g:7410:1: ( () )
            // InternalBasicsParser.g:7411:2: ()
            {
             before(grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0()); 
            // InternalBasicsParser.g:7412:2: ()
            // InternalBasicsParser.g:7412:3: 
            {
            }

             after(grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group__0__Impl"


    // $ANTLR start "rule__ExtensionEntry__Group__1"
    // InternalBasicsParser.g:7420:1: rule__ExtensionEntry__Group__1 : rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2 ;
    public final void rule__ExtensionEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7424:1: ( rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2 )
            // InternalBasicsParser.g:7425:2: rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2
            {
            pushFollow(FOLLOW_69);
            rule__ExtensionEntry__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group__1"


    // $ANTLR start "rule__ExtensionEntry__Group__1__Impl"
    // InternalBasicsParser.g:7432:1: rule__ExtensionEntry__Group__1__Impl : ( ( rule__ExtensionEntry__Alternatives_1 ) ) ;
    public final void rule__ExtensionEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7436:1: ( ( ( rule__ExtensionEntry__Alternatives_1 ) ) )
            // InternalBasicsParser.g:7437:1: ( ( rule__ExtensionEntry__Alternatives_1 ) )
            {
            // InternalBasicsParser.g:7437:1: ( ( rule__ExtensionEntry__Alternatives_1 ) )
            // InternalBasicsParser.g:7438:2: ( rule__ExtensionEntry__Alternatives_1 )
            {
             before(grammarAccess.getExtensionEntryAccess().getAlternatives_1()); 
            // InternalBasicsParser.g:7439:2: ( rule__ExtensionEntry__Alternatives_1 )
            // InternalBasicsParser.g:7439:3: rule__ExtensionEntry__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getExtensionEntryAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group__1__Impl"


    // $ANTLR start "rule__ExtensionEntry__Group__2"
    // InternalBasicsParser.g:7447:1: rule__ExtensionEntry__Group__2 : rule__ExtensionEntry__Group__2__Impl ;
    public final void rule__ExtensionEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7451:1: ( rule__ExtensionEntry__Group__2__Impl )
            // InternalBasicsParser.g:7452:2: rule__ExtensionEntry__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group__2"


    // $ANTLR start "rule__ExtensionEntry__Group__2__Impl"
    // InternalBasicsParser.g:7458:1: rule__ExtensionEntry__Group__2__Impl : ( ( rule__ExtensionEntry__ValueAssignment_2 ) ) ;
    public final void rule__ExtensionEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7462:1: ( ( ( rule__ExtensionEntry__ValueAssignment_2 ) ) )
            // InternalBasicsParser.g:7463:1: ( ( rule__ExtensionEntry__ValueAssignment_2 ) )
            {
            // InternalBasicsParser.g:7463:1: ( ( rule__ExtensionEntry__ValueAssignment_2 ) )
            // InternalBasicsParser.g:7464:2: ( rule__ExtensionEntry__ValueAssignment_2 )
            {
             before(grammarAccess.getExtensionEntryAccess().getValueAssignment_2()); 
            // InternalBasicsParser.g:7465:2: ( rule__ExtensionEntry__ValueAssignment_2 )
            // InternalBasicsParser.g:7465:3: rule__ExtensionEntry__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExtensionEntryAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group__2__Impl"


    // $ANTLR start "rule__ExtensionEntry__Group_1_0__0"
    // InternalBasicsParser.g:7474:1: rule__ExtensionEntry__Group_1_0__0 : rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1 ;
    public final void rule__ExtensionEntry__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7478:1: ( rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1 )
            // InternalBasicsParser.g:7479:2: rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1
            {
            pushFollow(FOLLOW_32);
            rule__ExtensionEntry__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group_1_0__0"


    // $ANTLR start "rule__ExtensionEntry__Group_1_0__0__Impl"
    // InternalBasicsParser.g:7486:1: rule__ExtensionEntry__Group_1_0__0__Impl : ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) ) ;
    public final void rule__ExtensionEntry__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7490:1: ( ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) ) )
            // InternalBasicsParser.g:7491:1: ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) )
            {
            // InternalBasicsParser.g:7491:1: ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) )
            // InternalBasicsParser.g:7492:2: ( rule__ExtensionEntry__KeyAssignment_1_0_0 )
            {
             before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_0_0()); 
            // InternalBasicsParser.g:7493:2: ( rule__ExtensionEntry__KeyAssignment_1_0_0 )
            // InternalBasicsParser.g:7493:3: rule__ExtensionEntry__KeyAssignment_1_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__KeyAssignment_1_0_0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group_1_0__0__Impl"


    // $ANTLR start "rule__ExtensionEntry__Group_1_0__1"
    // InternalBasicsParser.g:7501:1: rule__ExtensionEntry__Group_1_0__1 : rule__ExtensionEntry__Group_1_0__1__Impl ;
    public final void rule__ExtensionEntry__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7505:1: ( rule__ExtensionEntry__Group_1_0__1__Impl )
            // InternalBasicsParser.g:7506:2: rule__ExtensionEntry__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionEntry__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group_1_0__1"


    // $ANTLR start "rule__ExtensionEntry__Group_1_0__1__Impl"
    // InternalBasicsParser.g:7512:1: rule__ExtensionEntry__Group_1_0__1__Impl : ( Colon ) ;
    public final void rule__ExtensionEntry__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7516:1: ( ( Colon ) )
            // InternalBasicsParser.g:7517:1: ( Colon )
            {
            // InternalBasicsParser.g:7517:1: ( Colon )
            // InternalBasicsParser.g:7518:2: Colon
            {
             before(grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__Group_1_0__1__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group__0"
    // InternalBasicsParser.g:7528:1: rule__ExtensionListValue__Group__0 : rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1 ;
    public final void rule__ExtensionListValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7532:1: ( rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1 )
            // InternalBasicsParser.g:7533:2: rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ExtensionListValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__0"


    // $ANTLR start "rule__ExtensionListValue__Group__0__Impl"
    // InternalBasicsParser.g:7540:1: rule__ExtensionListValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionListValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7544:1: ( ( () ) )
            // InternalBasicsParser.g:7545:1: ( () )
            {
            // InternalBasicsParser.g:7545:1: ( () )
            // InternalBasicsParser.g:7546:2: ()
            {
             before(grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0()); 
            // InternalBasicsParser.g:7547:2: ()
            // InternalBasicsParser.g:7547:3: 
            {
            }

             after(grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__0__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group__1"
    // InternalBasicsParser.g:7555:1: rule__ExtensionListValue__Group__1 : rule__ExtensionListValue__Group__1__Impl rule__ExtensionListValue__Group__2 ;
    public final void rule__ExtensionListValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7559:1: ( rule__ExtensionListValue__Group__1__Impl rule__ExtensionListValue__Group__2 )
            // InternalBasicsParser.g:7560:2: rule__ExtensionListValue__Group__1__Impl rule__ExtensionListValue__Group__2
            {
            pushFollow(FOLLOW_70);
            rule__ExtensionListValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__1"


    // $ANTLR start "rule__ExtensionListValue__Group__1__Impl"
    // InternalBasicsParser.g:7567:1: rule__ExtensionListValue__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ExtensionListValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7571:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7572:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7572:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7573:2: LeftSquareBracket
            {
             before(grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__1__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group__2"
    // InternalBasicsParser.g:7582:1: rule__ExtensionListValue__Group__2 : rule__ExtensionListValue__Group__2__Impl rule__ExtensionListValue__Group__3 ;
    public final void rule__ExtensionListValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7586:1: ( rule__ExtensionListValue__Group__2__Impl rule__ExtensionListValue__Group__3 )
            // InternalBasicsParser.g:7587:2: rule__ExtensionListValue__Group__2__Impl rule__ExtensionListValue__Group__3
            {
            pushFollow(FOLLOW_70);
            rule__ExtensionListValue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__2"


    // $ANTLR start "rule__ExtensionListValue__Group__2__Impl"
    // InternalBasicsParser.g:7594:1: rule__ExtensionListValue__Group__2__Impl : ( ( rule__ExtensionListValue__Group_2__0 )? ) ;
    public final void rule__ExtensionListValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7598:1: ( ( ( rule__ExtensionListValue__Group_2__0 )? ) )
            // InternalBasicsParser.g:7599:1: ( ( rule__ExtensionListValue__Group_2__0 )? )
            {
            // InternalBasicsParser.g:7599:1: ( ( rule__ExtensionListValue__Group_2__0 )? )
            // InternalBasicsParser.g:7600:2: ( rule__ExtensionListValue__Group_2__0 )?
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup_2()); 
            // InternalBasicsParser.g:7601:2: ( rule__ExtensionListValue__Group_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=Duration && LA32_0<=Feedback)||(LA32_0>=Boolean && LA32_0<=Float64)||(LA32_0>=Message && LA32_0<=Service)||(LA32_0>=Base64 && LA32_0<=Action)||(LA32_0>=Result && LA32_0<=Uint64)||(LA32_0>=Array && LA32_0<=Sub)||(LA32_0>=Uint8 && LA32_0<=Any)||LA32_0==LeftSquareBracket||LA32_0==LeftCurlyBracket||(LA32_0>=RULE_BOOLEAN && LA32_0<=RULE_DOUBLE)||(LA32_0>=RULE_ID && LA32_0<=RULE_INT)||LA32_0==RULE_BEGIN) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBasicsParser.g:7601:3: rule__ExtensionListValue__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionListValue__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExtensionListValueAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__2__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group__3"
    // InternalBasicsParser.g:7609:1: rule__ExtensionListValue__Group__3 : rule__ExtensionListValue__Group__3__Impl ;
    public final void rule__ExtensionListValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7613:1: ( rule__ExtensionListValue__Group__3__Impl )
            // InternalBasicsParser.g:7614:2: rule__ExtensionListValue__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__3"


    // $ANTLR start "rule__ExtensionListValue__Group__3__Impl"
    // InternalBasicsParser.g:7620:1: rule__ExtensionListValue__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ExtensionListValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7624:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7625:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7625:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7626:2: RightSquareBracket
            {
             before(grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group__3__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_2__0"
    // InternalBasicsParser.g:7636:1: rule__ExtensionListValue__Group_2__0 : rule__ExtensionListValue__Group_2__0__Impl rule__ExtensionListValue__Group_2__1 ;
    public final void rule__ExtensionListValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7640:1: ( rule__ExtensionListValue__Group_2__0__Impl rule__ExtensionListValue__Group_2__1 )
            // InternalBasicsParser.g:7641:2: rule__ExtensionListValue__Group_2__0__Impl rule__ExtensionListValue__Group_2__1
            {
            pushFollow(FOLLOW_71);
            rule__ExtensionListValue__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2__0"


    // $ANTLR start "rule__ExtensionListValue__Group_2__0__Impl"
    // InternalBasicsParser.g:7648:1: rule__ExtensionListValue__Group_2__0__Impl : ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) ) ;
    public final void rule__ExtensionListValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7652:1: ( ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) ) )
            // InternalBasicsParser.g:7653:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) )
            {
            // InternalBasicsParser.g:7653:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) )
            // InternalBasicsParser.g:7654:2: ( rule__ExtensionListValue__ItemsAssignment_2_0 )
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsAssignment_2_0()); 
            // InternalBasicsParser.g:7655:2: ( rule__ExtensionListValue__ItemsAssignment_2_0 )
            // InternalBasicsParser.g:7655:3: rule__ExtensionListValue__ItemsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__ItemsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionListValueAccess().getItemsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2__0__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_2__1"
    // InternalBasicsParser.g:7663:1: rule__ExtensionListValue__Group_2__1 : rule__ExtensionListValue__Group_2__1__Impl ;
    public final void rule__ExtensionListValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7667:1: ( rule__ExtensionListValue__Group_2__1__Impl )
            // InternalBasicsParser.g:7668:2: rule__ExtensionListValue__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2__1"


    // $ANTLR start "rule__ExtensionListValue__Group_2__1__Impl"
    // InternalBasicsParser.g:7674:1: rule__ExtensionListValue__Group_2__1__Impl : ( ( rule__ExtensionListValue__Group_2_1__0 )* ) ;
    public final void rule__ExtensionListValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7678:1: ( ( ( rule__ExtensionListValue__Group_2_1__0 )* ) )
            // InternalBasicsParser.g:7679:1: ( ( rule__ExtensionListValue__Group_2_1__0 )* )
            {
            // InternalBasicsParser.g:7679:1: ( ( rule__ExtensionListValue__Group_2_1__0 )* )
            // InternalBasicsParser.g:7680:2: ( rule__ExtensionListValue__Group_2_1__0 )*
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup_2_1()); 
            // InternalBasicsParser.g:7681:2: ( rule__ExtensionListValue__Group_2_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=Duration && LA33_0<=Feedback)||(LA33_0>=Boolean && LA33_0<=Float64)||(LA33_0>=Message && LA33_0<=Service)||(LA33_0>=Base64 && LA33_0<=Action)||(LA33_0>=Result && LA33_0<=Uint64)||(LA33_0>=Array && LA33_0<=Sub)||(LA33_0>=Uint8 && LA33_0<=Any)||LA33_0==Comma||LA33_0==LeftSquareBracket||LA33_0==LeftCurlyBracket||(LA33_0>=RULE_BOOLEAN && LA33_0<=RULE_DOUBLE)||(LA33_0>=RULE_ID && LA33_0<=RULE_INT)||LA33_0==RULE_BEGIN) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBasicsParser.g:7681:3: rule__ExtensionListValue__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_72);
            	    rule__ExtensionListValue__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getExtensionListValueAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2__1__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_2_1__0"
    // InternalBasicsParser.g:7690:1: rule__ExtensionListValue__Group_2_1__0 : rule__ExtensionListValue__Group_2_1__0__Impl rule__ExtensionListValue__Group_2_1__1 ;
    public final void rule__ExtensionListValue__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7694:1: ( rule__ExtensionListValue__Group_2_1__0__Impl rule__ExtensionListValue__Group_2_1__1 )
            // InternalBasicsParser.g:7695:2: rule__ExtensionListValue__Group_2_1__0__Impl rule__ExtensionListValue__Group_2_1__1
            {
            pushFollow(FOLLOW_71);
            rule__ExtensionListValue__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2_1__0"


    // $ANTLR start "rule__ExtensionListValue__Group_2_1__0__Impl"
    // InternalBasicsParser.g:7702:1: rule__ExtensionListValue__Group_2_1__0__Impl : ( ( Comma )? ) ;
    public final void rule__ExtensionListValue__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7706:1: ( ( ( Comma )? ) )
            // InternalBasicsParser.g:7707:1: ( ( Comma )? )
            {
            // InternalBasicsParser.g:7707:1: ( ( Comma )? )
            // InternalBasicsParser.g:7708:2: ( Comma )?
            {
             before(grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0()); 
            // InternalBasicsParser.g:7709:2: ( Comma )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==Comma) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBasicsParser.g:7709:3: Comma
                    {
                    match(input,Comma,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2_1__0__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_2_1__1"
    // InternalBasicsParser.g:7717:1: rule__ExtensionListValue__Group_2_1__1 : rule__ExtensionListValue__Group_2_1__1__Impl ;
    public final void rule__ExtensionListValue__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7721:1: ( rule__ExtensionListValue__Group_2_1__1__Impl )
            // InternalBasicsParser.g:7722:2: rule__ExtensionListValue__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2_1__1"


    // $ANTLR start "rule__ExtensionListValue__Group_2_1__1__Impl"
    // InternalBasicsParser.g:7728:1: rule__ExtensionListValue__Group_2_1__1__Impl : ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) ) ;
    public final void rule__ExtensionListValue__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7732:1: ( ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) ) )
            // InternalBasicsParser.g:7733:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) )
            {
            // InternalBasicsParser.g:7733:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) )
            // InternalBasicsParser.g:7734:2: ( rule__ExtensionListValue__ItemsAssignment_2_1_1 )
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsAssignment_2_1_1()); 
            // InternalBasicsParser.g:7735:2: ( rule__ExtensionListValue__ItemsAssignment_2_1_1 )
            // InternalBasicsParser.g:7735:3: rule__ExtensionListValue__ItemsAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__ItemsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExtensionListValueAccess().getItemsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_2_1__1__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__0"
    // InternalBasicsParser.g:7744:1: rule__ExtensionBraceMapValue__Group__0 : rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1 ;
    public final void rule__ExtensionBraceMapValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7748:1: ( rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1 )
            // InternalBasicsParser.g:7749:2: rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1
            {
            pushFollow(FOLLOW_73);
            rule__ExtensionBraceMapValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__0"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__0__Impl"
    // InternalBasicsParser.g:7756:1: rule__ExtensionBraceMapValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionBraceMapValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7760:1: ( ( () ) )
            // InternalBasicsParser.g:7761:1: ( () )
            {
            // InternalBasicsParser.g:7761:1: ( () )
            // InternalBasicsParser.g:7762:2: ()
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0()); 
            // InternalBasicsParser.g:7763:2: ()
            // InternalBasicsParser.g:7763:3: 
            {
            }

             after(grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__0__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__1"
    // InternalBasicsParser.g:7771:1: rule__ExtensionBraceMapValue__Group__1 : rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2 ;
    public final void rule__ExtensionBraceMapValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7775:1: ( rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2 )
            // InternalBasicsParser.g:7776:2: rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2
            {
            pushFollow(FOLLOW_74);
            rule__ExtensionBraceMapValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__1"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__1__Impl"
    // InternalBasicsParser.g:7783:1: rule__ExtensionBraceMapValue__Group__1__Impl : ( LeftCurlyBracket ) ;
    public final void rule__ExtensionBraceMapValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7787:1: ( ( LeftCurlyBracket ) )
            // InternalBasicsParser.g:7788:1: ( LeftCurlyBracket )
            {
            // InternalBasicsParser.g:7788:1: ( LeftCurlyBracket )
            // InternalBasicsParser.g:7789:2: LeftCurlyBracket
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,LeftCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__1__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__2"
    // InternalBasicsParser.g:7798:1: rule__ExtensionBraceMapValue__Group__2 : rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3 ;
    public final void rule__ExtensionBraceMapValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7802:1: ( rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3 )
            // InternalBasicsParser.g:7803:2: rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3
            {
            pushFollow(FOLLOW_74);
            rule__ExtensionBraceMapValue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__2"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__2__Impl"
    // InternalBasicsParser.g:7810:1: rule__ExtensionBraceMapValue__Group__2__Impl : ( ( rule__ExtensionBraceMapValue__Group_2__0 )? ) ;
    public final void rule__ExtensionBraceMapValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7814:1: ( ( ( rule__ExtensionBraceMapValue__Group_2__0 )? ) )
            // InternalBasicsParser.g:7815:1: ( ( rule__ExtensionBraceMapValue__Group_2__0 )? )
            {
            // InternalBasicsParser.g:7815:1: ( ( rule__ExtensionBraceMapValue__Group_2__0 )? )
            // InternalBasicsParser.g:7816:2: ( rule__ExtensionBraceMapValue__Group_2__0 )?
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2()); 
            // InternalBasicsParser.g:7817:2: ( rule__ExtensionBraceMapValue__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=Default && LA35_0<=Feedback)||(LA35_0>=Boolean && LA35_0<=Float64)||LA35_0==Message||LA35_0==Service||(LA35_0>=Base64 && LA35_0<=Action)||(LA35_0>=Result && LA35_0<=Int64)||(LA35_0>=Type_1 && LA35_0<=List)||(LA35_0>=Bool && LA35_0<=Node)||(LA35_0>=Time && LA35_0<=Ns)||(LA35_0>=RULE_ID && LA35_0<=RULE_STRING)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBasicsParser.g:7817:3: rule__ExtensionBraceMapValue__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionBraceMapValue__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__2__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__3"
    // InternalBasicsParser.g:7825:1: rule__ExtensionBraceMapValue__Group__3 : rule__ExtensionBraceMapValue__Group__3__Impl ;
    public final void rule__ExtensionBraceMapValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7829:1: ( rule__ExtensionBraceMapValue__Group__3__Impl )
            // InternalBasicsParser.g:7830:2: rule__ExtensionBraceMapValue__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__3"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__3__Impl"
    // InternalBasicsParser.g:7836:1: rule__ExtensionBraceMapValue__Group__3__Impl : ( RightCurlyBracket ) ;
    public final void rule__ExtensionBraceMapValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7840:1: ( ( RightCurlyBracket ) )
            // InternalBasicsParser.g:7841:1: ( RightCurlyBracket )
            {
            // InternalBasicsParser.g:7841:1: ( RightCurlyBracket )
            // InternalBasicsParser.g:7842:2: RightCurlyBracket
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getRightCurlyBracketKeyword_3()); 
            match(input,RightCurlyBracket,FOLLOW_2); 
             after(grammarAccess.getExtensionBraceMapValueAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group__3__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2__0"
    // InternalBasicsParser.g:7852:1: rule__ExtensionBraceMapValue__Group_2__0 : rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1 ;
    public final void rule__ExtensionBraceMapValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7856:1: ( rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1 )
            // InternalBasicsParser.g:7857:2: rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1
            {
            pushFollow(FOLLOW_75);
            rule__ExtensionBraceMapValue__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2__0"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2__0__Impl"
    // InternalBasicsParser.g:7864:1: rule__ExtensionBraceMapValue__Group_2__0__Impl : ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) ) ;
    public final void rule__ExtensionBraceMapValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7868:1: ( ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) ) )
            // InternalBasicsParser.g:7869:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) )
            {
            // InternalBasicsParser.g:7869:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) )
            // InternalBasicsParser.g:7870:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_0()); 
            // InternalBasicsParser.g:7871:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 )
            // InternalBasicsParser.g:7871:3: rule__ExtensionBraceMapValue__EntriesAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__EntriesAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2__0__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2__1"
    // InternalBasicsParser.g:7879:1: rule__ExtensionBraceMapValue__Group_2__1 : rule__ExtensionBraceMapValue__Group_2__1__Impl ;
    public final void rule__ExtensionBraceMapValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7883:1: ( rule__ExtensionBraceMapValue__Group_2__1__Impl )
            // InternalBasicsParser.g:7884:2: rule__ExtensionBraceMapValue__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2__1"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2__1__Impl"
    // InternalBasicsParser.g:7890:1: rule__ExtensionBraceMapValue__Group_2__1__Impl : ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* ) ;
    public final void rule__ExtensionBraceMapValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7894:1: ( ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* ) )
            // InternalBasicsParser.g:7895:1: ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* )
            {
            // InternalBasicsParser.g:7895:1: ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* )
            // InternalBasicsParser.g:7896:2: ( rule__ExtensionBraceMapValue__Group_2_1__0 )*
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2_1()); 
            // InternalBasicsParser.g:7897:2: ( rule__ExtensionBraceMapValue__Group_2_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=Default && LA36_0<=Feedback)||(LA36_0>=Boolean && LA36_0<=Float64)||LA36_0==Message||LA36_0==Service||(LA36_0>=Base64 && LA36_0<=Action)||(LA36_0>=Result && LA36_0<=Int64)||(LA36_0>=Type_1 && LA36_0<=List)||(LA36_0>=Bool && LA36_0<=Node)||(LA36_0>=Time && LA36_0<=Ns)||LA36_0==Comma||(LA36_0>=RULE_ID && LA36_0<=RULE_STRING)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBasicsParser.g:7897:3: rule__ExtensionBraceMapValue__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_76);
            	    rule__ExtensionBraceMapValue__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2__1__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2_1__0"
    // InternalBasicsParser.g:7906:1: rule__ExtensionBraceMapValue__Group_2_1__0 : rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1 ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7910:1: ( rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1 )
            // InternalBasicsParser.g:7911:2: rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1
            {
            pushFollow(FOLLOW_75);
            rule__ExtensionBraceMapValue__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2_1__0"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2_1__0__Impl"
    // InternalBasicsParser.g:7918:1: rule__ExtensionBraceMapValue__Group_2_1__0__Impl : ( ( Comma )? ) ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7922:1: ( ( ( Comma )? ) )
            // InternalBasicsParser.g:7923:1: ( ( Comma )? )
            {
            // InternalBasicsParser.g:7923:1: ( ( Comma )? )
            // InternalBasicsParser.g:7924:2: ( Comma )?
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0()); 
            // InternalBasicsParser.g:7925:2: ( Comma )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Comma) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBasicsParser.g:7925:3: Comma
                    {
                    match(input,Comma,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2_1__0__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2_1__1"
    // InternalBasicsParser.g:7933:1: rule__ExtensionBraceMapValue__Group_2_1__1 : rule__ExtensionBraceMapValue__Group_2_1__1__Impl ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7937:1: ( rule__ExtensionBraceMapValue__Group_2_1__1__Impl )
            // InternalBasicsParser.g:7938:2: rule__ExtensionBraceMapValue__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2_1__1"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group_2_1__1__Impl"
    // InternalBasicsParser.g:7944:1: rule__ExtensionBraceMapValue__Group_2_1__1__Impl : ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) ) ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7948:1: ( ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) ) )
            // InternalBasicsParser.g:7949:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) )
            {
            // InternalBasicsParser.g:7949:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) )
            // InternalBasicsParser.g:7950:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_1_1()); 
            // InternalBasicsParser.g:7951:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 )
            // InternalBasicsParser.g:7951:3: rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__Group_2_1__1__Impl"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__0"
    // InternalBasicsParser.g:7960:1: rule__ExtensionIndentedMapValue__Group__0 : rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1 ;
    public final void rule__ExtensionIndentedMapValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7964:1: ( rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1 )
            // InternalBasicsParser.g:7965:2: rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__ExtensionIndentedMapValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionIndentedMapValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__0"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__0__Impl"
    // InternalBasicsParser.g:7972:1: rule__ExtensionIndentedMapValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionIndentedMapValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7976:1: ( ( () ) )
            // InternalBasicsParser.g:7977:1: ( () )
            {
            // InternalBasicsParser.g:7977:1: ( () )
            // InternalBasicsParser.g:7978:2: ()
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0()); 
            // InternalBasicsParser.g:7979:2: ()
            // InternalBasicsParser.g:7979:3: 
            {
            }

             after(grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__0__Impl"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__1"
    // InternalBasicsParser.g:7987:1: rule__ExtensionIndentedMapValue__Group__1 : rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2 ;
    public final void rule__ExtensionIndentedMapValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7991:1: ( rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2 )
            // InternalBasicsParser.g:7992:2: rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2
            {
            pushFollow(FOLLOW_68);
            rule__ExtensionIndentedMapValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionIndentedMapValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__1"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__1__Impl"
    // InternalBasicsParser.g:7999:1: rule__ExtensionIndentedMapValue__Group__1__Impl : ( RULE_BEGIN ) ;
    public final void rule__ExtensionIndentedMapValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8003:1: ( ( RULE_BEGIN ) )
            // InternalBasicsParser.g:8004:1: ( RULE_BEGIN )
            {
            // InternalBasicsParser.g:8004:1: ( RULE_BEGIN )
            // InternalBasicsParser.g:8005:2: RULE_BEGIN
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1()); 
            match(input,RULE_BEGIN,FOLLOW_2); 
             after(grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__1__Impl"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__2"
    // InternalBasicsParser.g:8014:1: rule__ExtensionIndentedMapValue__Group__2 : rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3 ;
    public final void rule__ExtensionIndentedMapValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8018:1: ( rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3 )
            // InternalBasicsParser.g:8019:2: rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__ExtensionIndentedMapValue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionIndentedMapValue__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__2"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__2__Impl"
    // InternalBasicsParser.g:8026:1: rule__ExtensionIndentedMapValue__Group__2__Impl : ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) ) ;
    public final void rule__ExtensionIndentedMapValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8030:1: ( ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) ) )
            // InternalBasicsParser.g:8031:1: ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) )
            {
            // InternalBasicsParser.g:8031:1: ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) )
            // InternalBasicsParser.g:8032:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* )
            {
            // InternalBasicsParser.g:8032:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) )
            // InternalBasicsParser.g:8033:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 
            // InternalBasicsParser.g:8034:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )
            // InternalBasicsParser.g:8034:4: rule__ExtensionIndentedMapValue__EntriesAssignment_2
            {
            pushFollow(FOLLOW_77);
            rule__ExtensionIndentedMapValue__EntriesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 

            }

            // InternalBasicsParser.g:8037:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* )
            // InternalBasicsParser.g:8038:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )*
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 
            // InternalBasicsParser.g:8039:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=Default && LA38_0<=Feedback)||(LA38_0>=Boolean && LA38_0<=Float64)||LA38_0==Message||LA38_0==Service||(LA38_0>=Base64 && LA38_0<=Action)||(LA38_0>=Result && LA38_0<=Int64)||(LA38_0>=Type_1 && LA38_0<=List)||(LA38_0>=Bool && LA38_0<=Node)||(LA38_0>=Time && LA38_0<=Ns)||(LA38_0>=RULE_ID && LA38_0<=RULE_STRING)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBasicsParser.g:8039:4: rule__ExtensionIndentedMapValue__EntriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_77);
            	    rule__ExtensionIndentedMapValue__EntriesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__2__Impl"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__3"
    // InternalBasicsParser.g:8048:1: rule__ExtensionIndentedMapValue__Group__3 : rule__ExtensionIndentedMapValue__Group__3__Impl ;
    public final void rule__ExtensionIndentedMapValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8052:1: ( rule__ExtensionIndentedMapValue__Group__3__Impl )
            // InternalBasicsParser.g:8053:2: rule__ExtensionIndentedMapValue__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionIndentedMapValue__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__3"


    // $ANTLR start "rule__ExtensionIndentedMapValue__Group__3__Impl"
    // InternalBasicsParser.g:8059:1: rule__ExtensionIndentedMapValue__Group__3__Impl : ( RULE_END ) ;
    public final void rule__ExtensionIndentedMapValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8063:1: ( ( RULE_END ) )
            // InternalBasicsParser.g:8064:1: ( RULE_END )
            {
            // InternalBasicsParser.g:8064:1: ( RULE_END )
            // InternalBasicsParser.g:8065:2: RULE_END
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getENDTerminalRuleCall_3()); 
            match(input,RULE_END,FOLLOW_2); 
             after(grammarAccess.getExtensionIndentedMapValueAccess().getENDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__Group__3__Impl"


    // $ANTLR start "rule__ExtensionRefValue__Group__0"
    // InternalBasicsParser.g:8075:1: rule__ExtensionRefValue__Group__0 : rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1 ;
    public final void rule__ExtensionRefValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8079:1: ( rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1 )
            // InternalBasicsParser.g:8080:2: rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1
            {
            pushFollow(FOLLOW_78);
            rule__ExtensionRefValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionRefValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__Group__0"


    // $ANTLR start "rule__ExtensionRefValue__Group__0__Impl"
    // InternalBasicsParser.g:8087:1: rule__ExtensionRefValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionRefValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8091:1: ( ( () ) )
            // InternalBasicsParser.g:8092:1: ( () )
            {
            // InternalBasicsParser.g:8092:1: ( () )
            // InternalBasicsParser.g:8093:2: ()
            {
             before(grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0()); 
            // InternalBasicsParser.g:8094:2: ()
            // InternalBasicsParser.g:8094:3: 
            {
            }

             after(grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__Group__0__Impl"


    // $ANTLR start "rule__ExtensionRefValue__Group__1"
    // InternalBasicsParser.g:8102:1: rule__ExtensionRefValue__Group__1 : rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2 ;
    public final void rule__ExtensionRefValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8106:1: ( rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2 )
            // InternalBasicsParser.g:8107:2: rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__ExtensionRefValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionRefValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__Group__1"


    // $ANTLR start "rule__ExtensionRefValue__Group__1__Impl"
    // InternalBasicsParser.g:8114:1: rule__ExtensionRefValue__Group__1__Impl : ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) ) ;
    public final void rule__ExtensionRefValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8118:1: ( ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) ) )
            // InternalBasicsParser.g:8119:1: ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) )
            {
            // InternalBasicsParser.g:8119:1: ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) )
            // InternalBasicsParser.g:8120:2: ( rule__ExtensionRefValue__RefKindAssignment_1 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getRefKindAssignment_1()); 
            // InternalBasicsParser.g:8121:2: ( rule__ExtensionRefValue__RefKindAssignment_1 )
            // InternalBasicsParser.g:8121:3: rule__ExtensionRefValue__RefKindAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionRefValue__RefKindAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExtensionRefValueAccess().getRefKindAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__Group__1__Impl"


    // $ANTLR start "rule__ExtensionRefValue__Group__2"
    // InternalBasicsParser.g:8129:1: rule__ExtensionRefValue__Group__2 : rule__ExtensionRefValue__Group__2__Impl ;
    public final void rule__ExtensionRefValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8133:1: ( rule__ExtensionRefValue__Group__2__Impl )
            // InternalBasicsParser.g:8134:2: rule__ExtensionRefValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionRefValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__Group__2"


    // $ANTLR start "rule__ExtensionRefValue__Group__2__Impl"
    // InternalBasicsParser.g:8140:1: rule__ExtensionRefValue__Group__2__Impl : ( ( rule__ExtensionRefValue__TargetAssignment_2 ) ) ;
    public final void rule__ExtensionRefValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8144:1: ( ( ( rule__ExtensionRefValue__TargetAssignment_2 ) ) )
            // InternalBasicsParser.g:8145:1: ( ( rule__ExtensionRefValue__TargetAssignment_2 ) )
            {
            // InternalBasicsParser.g:8145:1: ( ( rule__ExtensionRefValue__TargetAssignment_2 ) )
            // InternalBasicsParser.g:8146:2: ( rule__ExtensionRefValue__TargetAssignment_2 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getTargetAssignment_2()); 
            // InternalBasicsParser.g:8147:2: ( rule__ExtensionRefValue__TargetAssignment_2 )
            // InternalBasicsParser.g:8147:3: rule__ExtensionRefValue__TargetAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionRefValue__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExtensionRefValueAccess().getTargetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__Group__2__Impl"


    // $ANTLR start "rule__ExtensionScalarValue__Group__0"
    // InternalBasicsParser.g:8156:1: rule__ExtensionScalarValue__Group__0 : rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1 ;
    public final void rule__ExtensionScalarValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8160:1: ( rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1 )
            // InternalBasicsParser.g:8161:2: rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1
            {
            pushFollow(FOLLOW_69);
            rule__ExtensionScalarValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionScalarValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionScalarValue__Group__0"


    // $ANTLR start "rule__ExtensionScalarValue__Group__0__Impl"
    // InternalBasicsParser.g:8168:1: rule__ExtensionScalarValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionScalarValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8172:1: ( ( () ) )
            // InternalBasicsParser.g:8173:1: ( () )
            {
            // InternalBasicsParser.g:8173:1: ( () )
            // InternalBasicsParser.g:8174:2: ()
            {
             before(grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0()); 
            // InternalBasicsParser.g:8175:2: ()
            // InternalBasicsParser.g:8175:3: 
            {
            }

             after(grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionScalarValue__Group__0__Impl"


    // $ANTLR start "rule__ExtensionScalarValue__Group__1"
    // InternalBasicsParser.g:8183:1: rule__ExtensionScalarValue__Group__1 : rule__ExtensionScalarValue__Group__1__Impl ;
    public final void rule__ExtensionScalarValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8187:1: ( rule__ExtensionScalarValue__Group__1__Impl )
            // InternalBasicsParser.g:8188:2: rule__ExtensionScalarValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionScalarValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionScalarValue__Group__1"


    // $ANTLR start "rule__ExtensionScalarValue__Group__1__Impl"
    // InternalBasicsParser.g:8194:1: rule__ExtensionScalarValue__Group__1__Impl : ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) ) ;
    public final void rule__ExtensionScalarValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8198:1: ( ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) ) )
            // InternalBasicsParser.g:8199:1: ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) )
            {
            // InternalBasicsParser.g:8199:1: ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) )
            // InternalBasicsParser.g:8200:2: ( rule__ExtensionScalarValue__ValueAssignment_1 )
            {
             before(grammarAccess.getExtensionScalarValueAccess().getValueAssignment_1()); 
            // InternalBasicsParser.g:8201:2: ( rule__ExtensionScalarValue__ValueAssignment_1 )
            // InternalBasicsParser.g:8201:3: rule__ExtensionScalarValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionScalarValue__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExtensionScalarValueAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionScalarValue__Group__1__Impl"


    // $ANTLR start "rule__GlobalNamespace__PartsAssignment_2_1"
    // InternalBasicsParser.g:8210:1: rule__GlobalNamespace__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__GlobalNamespace__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8214:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8215:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8215:2: ( ruleGraphName )
            // InternalBasicsParser.g:8216:3: ruleGraphName
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphName();

            state._fsp--;

             after(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__PartsAssignment_2_1"


    // $ANTLR start "rule__GlobalNamespace__PartsAssignment_2_2_1"
    // InternalBasicsParser.g:8225:1: rule__GlobalNamespace__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__GlobalNamespace__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8229:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8230:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8230:2: ( ruleGraphName )
            // InternalBasicsParser.g:8231:3: ruleGraphName
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphName();

            state._fsp--;

             after(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GlobalNamespace__PartsAssignment_2_2_1"


    // $ANTLR start "rule__RelativeNamespace_Impl__PartsAssignment_2_1"
    // InternalBasicsParser.g:8240:1: rule__RelativeNamespace_Impl__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__RelativeNamespace_Impl__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8244:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8245:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8245:2: ( ruleGraphName )
            // InternalBasicsParser.g:8246:3: ruleGraphName
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphName();

            state._fsp--;

             after(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__PartsAssignment_2_1"


    // $ANTLR start "rule__RelativeNamespace_Impl__PartsAssignment_2_2_1"
    // InternalBasicsParser.g:8255:1: rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__RelativeNamespace_Impl__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8259:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8260:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8260:2: ( ruleGraphName )
            // InternalBasicsParser.g:8261:3: ruleGraphName
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphName();

            state._fsp--;

             after(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RelativeNamespace_Impl__PartsAssignment_2_2_1"


    // $ANTLR start "rule__PrivateNamespace__PartsAssignment_2_1"
    // InternalBasicsParser.g:8270:1: rule__PrivateNamespace__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__PrivateNamespace__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8274:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8275:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8275:2: ( ruleGraphName )
            // InternalBasicsParser.g:8276:3: ruleGraphName
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphName();

            state._fsp--;

             after(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__PartsAssignment_2_1"


    // $ANTLR start "rule__PrivateNamespace__PartsAssignment_2_2_1"
    // InternalBasicsParser.g:8285:1: rule__PrivateNamespace__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__PrivateNamespace__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8289:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8290:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8290:2: ( ruleGraphName )
            // InternalBasicsParser.g:8291:3: ruleGraphName
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGraphName();

            state._fsp--;

             after(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrivateNamespace__PartsAssignment_2_2_1"


    // $ANTLR start "rule__ParameterListType__SequenceAssignment_3"
    // InternalBasicsParser.g:8300:1: rule__ParameterListType__SequenceAssignment_3 : ( ruleParameterType ) ;
    public final void rule__ParameterListType__SequenceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8304:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8305:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8305:2: ( ruleParameterType )
            // InternalBasicsParser.g:8306:3: ruleParameterType
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterType();

            state._fsp--;

             after(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__SequenceAssignment_3"


    // $ANTLR start "rule__ParameterListType__SequenceAssignment_4_1"
    // InternalBasicsParser.g:8315:1: rule__ParameterListType__SequenceAssignment_4_1 : ( ruleParameterType ) ;
    public final void rule__ParameterListType__SequenceAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8319:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8320:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8320:2: ( ruleParameterType )
            // InternalBasicsParser.g:8321:3: ruleParameterType
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterType();

            state._fsp--;

             after(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterListType__SequenceAssignment_4_1"


    // $ANTLR start "rule__ParameterStructType__ParameterstructypetmemberAssignment_3"
    // InternalBasicsParser.g:8330:1: rule__ParameterStructType__ParameterstructypetmemberAssignment_3 : ( ruleParameterStructTypeMember ) ;
    public final void rule__ParameterStructType__ParameterstructypetmemberAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8334:1: ( ( ruleParameterStructTypeMember ) )
            // InternalBasicsParser.g:8335:2: ( ruleParameterStructTypeMember )
            {
            // InternalBasicsParser.g:8335:2: ( ruleParameterStructTypeMember )
            // InternalBasicsParser.g:8336:3: ruleParameterStructTypeMember
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterStructTypeMember();

            state._fsp--;

             after(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__ParameterstructypetmemberAssignment_3"


    // $ANTLR start "rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1"
    // InternalBasicsParser.g:8345:1: rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 : ( ruleParameterStructTypeMember ) ;
    public final void rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8349:1: ( ( ruleParameterStructTypeMember ) )
            // InternalBasicsParser.g:8350:2: ( ruleParameterStructTypeMember )
            {
            // InternalBasicsParser.g:8350:2: ( ruleParameterStructTypeMember )
            // InternalBasicsParser.g:8351:3: ruleParameterStructTypeMember
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterStructTypeMember();

            state._fsp--;

             after(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1"


    // $ANTLR start "rule__ParameterIntegerType__DefaultAssignment_2_1"
    // InternalBasicsParser.g:8360:1: rule__ParameterIntegerType__DefaultAssignment_2_1 : ( ruleParameterInteger ) ;
    public final void rule__ParameterIntegerType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8364:1: ( ( ruleParameterInteger ) )
            // InternalBasicsParser.g:8365:2: ( ruleParameterInteger )
            {
            // InternalBasicsParser.g:8365:2: ( ruleParameterInteger )
            // InternalBasicsParser.g:8366:3: ruleParameterInteger
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getDefaultParameterIntegerParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterInteger();

            state._fsp--;

             after(grammarAccess.getParameterIntegerTypeAccess().getDefaultParameterIntegerParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterIntegerType__DefaultAssignment_2_1"


    // $ANTLR start "rule__ParameterStringType__DefaultAssignment_2_1"
    // InternalBasicsParser.g:8375:1: rule__ParameterStringType__DefaultAssignment_2_1 : ( ruleParameterString ) ;
    public final void rule__ParameterStringType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8379:1: ( ( ruleParameterString ) )
            // InternalBasicsParser.g:8380:2: ( ruleParameterString )
            {
            // InternalBasicsParser.g:8380:2: ( ruleParameterString )
            // InternalBasicsParser.g:8381:3: ruleParameterString
            {
             before(grammarAccess.getParameterStringTypeAccess().getDefaultParameterStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterString();

            state._fsp--;

             after(grammarAccess.getParameterStringTypeAccess().getDefaultParameterStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStringType__DefaultAssignment_2_1"


    // $ANTLR start "rule__ParameterDoubleType__DefaultAssignment_2_1"
    // InternalBasicsParser.g:8390:1: rule__ParameterDoubleType__DefaultAssignment_2_1 : ( ruleParameterDouble ) ;
    public final void rule__ParameterDoubleType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8394:1: ( ( ruleParameterDouble ) )
            // InternalBasicsParser.g:8395:2: ( ruleParameterDouble )
            {
            // InternalBasicsParser.g:8395:2: ( ruleParameterDouble )
            // InternalBasicsParser.g:8396:3: ruleParameterDouble
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getDefaultParameterDoubleParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterDouble();

            state._fsp--;

             after(grammarAccess.getParameterDoubleTypeAccess().getDefaultParameterDoubleParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDoubleType__DefaultAssignment_2_1"


    // $ANTLR start "rule__ParameterBooleanType__DefaultAssignment_2_1"
    // InternalBasicsParser.g:8405:1: rule__ParameterBooleanType__DefaultAssignment_2_1 : ( ruleParameterBoolean ) ;
    public final void rule__ParameterBooleanType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8409:1: ( ( ruleParameterBoolean ) )
            // InternalBasicsParser.g:8410:2: ( ruleParameterBoolean )
            {
            // InternalBasicsParser.g:8410:2: ( ruleParameterBoolean )
            // InternalBasicsParser.g:8411:3: ruleParameterBoolean
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getDefaultParameterBooleanParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterBoolean();

            state._fsp--;

             after(grammarAccess.getParameterBooleanTypeAccess().getDefaultParameterBooleanParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBooleanType__DefaultAssignment_2_1"


    // $ANTLR start "rule__ParameterBase64Type__DefaultAssignment_2_1"
    // InternalBasicsParser.g:8420:1: rule__ParameterBase64Type__DefaultAssignment_2_1 : ( ruleParameterBase64 ) ;
    public final void rule__ParameterBase64Type__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8424:1: ( ( ruleParameterBase64 ) )
            // InternalBasicsParser.g:8425:2: ( ruleParameterBase64 )
            {
            // InternalBasicsParser.g:8425:2: ( ruleParameterBase64 )
            // InternalBasicsParser.g:8426:3: ruleParameterBase64
            {
             before(grammarAccess.getParameterBase64TypeAccess().getDefaultParameterBase64ParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterBase64();

            state._fsp--;

             after(grammarAccess.getParameterBase64TypeAccess().getDefaultParameterBase64ParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64Type__DefaultAssignment_2_1"


    // $ANTLR start "rule__ParameterArrayType__TypeAssignment_2"
    // InternalBasicsParser.g:8435:1: rule__ParameterArrayType__TypeAssignment_2 : ( ruleParameterType ) ;
    public final void rule__ParameterArrayType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8439:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8440:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8440:2: ( ruleParameterType )
            // InternalBasicsParser.g:8441:3: ruleParameterType
            {
             before(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterType();

            state._fsp--;

             after(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__TypeAssignment_2"


    // $ANTLR start "rule__ParameterArrayType__DefaultAssignment_4_1"
    // InternalBasicsParser.g:8450:1: rule__ParameterArrayType__DefaultAssignment_4_1 : ( ruleParameterList ) ;
    public final void rule__ParameterArrayType__DefaultAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8454:1: ( ( ruleParameterList ) )
            // InternalBasicsParser.g:8455:2: ( ruleParameterList )
            {
            // InternalBasicsParser.g:8455:2: ( ruleParameterList )
            // InternalBasicsParser.g:8456:3: ruleParameterList
            {
             before(grammarAccess.getParameterArrayTypeAccess().getDefaultParameterListParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterList();

            state._fsp--;

             after(grammarAccess.getParameterArrayTypeAccess().getDefaultParameterListParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterArrayType__DefaultAssignment_4_1"


    // $ANTLR start "rule__ParameterList__ValueAssignment_2"
    // InternalBasicsParser.g:8465:1: rule__ParameterList__ValueAssignment_2 : ( ruleParameterValue ) ;
    public final void rule__ParameterList__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8469:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:8470:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:8470:2: ( ruleParameterValue )
            // InternalBasicsParser.g:8471:3: ruleParameterValue
            {
             before(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterValue();

            state._fsp--;

             after(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__ValueAssignment_2"


    // $ANTLR start "rule__ParameterList__ValueAssignment_3_1"
    // InternalBasicsParser.g:8480:1: rule__ParameterList__ValueAssignment_3_1 : ( ruleParameterValue ) ;
    public final void rule__ParameterList__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8484:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:8485:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:8485:2: ( ruleParameterValue )
            // InternalBasicsParser.g:8486:3: ruleParameterValue
            {
             before(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterValue();

            state._fsp--;

             after(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterList__ValueAssignment_3_1"


    // $ANTLR start "rule__ParameterAny__ValueAssignment_2_1"
    // InternalBasicsParser.g:8495:1: rule__ParameterAny__ValueAssignment_2_1 : ( ruleEString ) ;
    public final void rule__ParameterAny__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8499:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8500:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8500:2: ( ruleEString )
            // InternalBasicsParser.g:8501:3: ruleEString
            {
             before(grammarAccess.getParameterAnyAccess().getValueEStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAnyAccess().getValueEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterAny__ValueAssignment_2_1"


    // $ANTLR start "rule__ParameterString__ValueAssignment"
    // InternalBasicsParser.g:8510:1: rule__ParameterString__ValueAssignment : ( ruleEString ) ;
    public final void rule__ParameterString__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8514:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8515:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8515:2: ( ruleEString )
            // InternalBasicsParser.g:8516:3: ruleEString
            {
             before(grammarAccess.getParameterStringAccess().getValueEStringParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterStringAccess().getValueEStringParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterString__ValueAssignment"


    // $ANTLR start "rule__ParameterBase64__ValueAssignment"
    // InternalBasicsParser.g:8525:1: rule__ParameterBase64__ValueAssignment : ( ruleBase64Binary ) ;
    public final void rule__ParameterBase64__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8529:1: ( ( ruleBase64Binary ) )
            // InternalBasicsParser.g:8530:2: ( ruleBase64Binary )
            {
            // InternalBasicsParser.g:8530:2: ( ruleBase64Binary )
            // InternalBasicsParser.g:8531:3: ruleBase64Binary
            {
             before(grammarAccess.getParameterBase64Access().getValueBase64BinaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleBase64Binary();

            state._fsp--;

             after(grammarAccess.getParameterBase64Access().getValueBase64BinaryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBase64__ValueAssignment"


    // $ANTLR start "rule__ParameterInteger__ValueAssignment"
    // InternalBasicsParser.g:8540:1: rule__ParameterInteger__ValueAssignment : ( ruleInteger0 ) ;
    public final void rule__ParameterInteger__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8544:1: ( ( ruleInteger0 ) )
            // InternalBasicsParser.g:8545:2: ( ruleInteger0 )
            {
            // InternalBasicsParser.g:8545:2: ( ruleInteger0 )
            // InternalBasicsParser.g:8546:3: ruleInteger0
            {
             before(grammarAccess.getParameterIntegerAccess().getValueInteger0ParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleInteger0();

            state._fsp--;

             after(grammarAccess.getParameterIntegerAccess().getValueInteger0ParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterInteger__ValueAssignment"


    // $ANTLR start "rule__ParameterDouble__ValueAssignment"
    // InternalBasicsParser.g:8555:1: rule__ParameterDouble__ValueAssignment : ( ruleDouble0 ) ;
    public final void rule__ParameterDouble__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8559:1: ( ( ruleDouble0 ) )
            // InternalBasicsParser.g:8560:2: ( ruleDouble0 )
            {
            // InternalBasicsParser.g:8560:2: ( ruleDouble0 )
            // InternalBasicsParser.g:8561:3: ruleDouble0
            {
             before(grammarAccess.getParameterDoubleAccess().getValueDouble0ParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDouble0();

            state._fsp--;

             after(grammarAccess.getParameterDoubleAccess().getValueDouble0ParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDouble__ValueAssignment"


    // $ANTLR start "rule__ParameterBoolean__ValueAssignment"
    // InternalBasicsParser.g:8570:1: rule__ParameterBoolean__ValueAssignment : ( ruleboolean0 ) ;
    public final void rule__ParameterBoolean__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8574:1: ( ( ruleboolean0 ) )
            // InternalBasicsParser.g:8575:2: ( ruleboolean0 )
            {
            // InternalBasicsParser.g:8575:2: ( ruleboolean0 )
            // InternalBasicsParser.g:8576:3: ruleboolean0
            {
             before(grammarAccess.getParameterBooleanAccess().getValueBoolean0ParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleboolean0();

            state._fsp--;

             after(grammarAccess.getParameterBooleanAccess().getValueBoolean0ParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterBoolean__ValueAssignment"


    // $ANTLR start "rule__ParameterStruct__ValueAssignment_1_2"
    // InternalBasicsParser.g:8585:1: rule__ParameterStruct__ValueAssignment_1_2 : ( ruleParameterStructMember ) ;
    public final void rule__ParameterStruct__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8589:1: ( ( ruleParameterStructMember ) )
            // InternalBasicsParser.g:8590:2: ( ruleParameterStructMember )
            {
            // InternalBasicsParser.g:8590:2: ( ruleParameterStructMember )
            // InternalBasicsParser.g:8591:3: ruleParameterStructMember
            {
             before(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterStructMember();

            state._fsp--;

             after(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStruct__ValueAssignment_1_2"


    // $ANTLR start "rule__ParameterDate__ValueAssignment"
    // InternalBasicsParser.g:8600:1: rule__ParameterDate__ValueAssignment : ( ruleDateTime0 ) ;
    public final void rule__ParameterDate__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8604:1: ( ( ruleDateTime0 ) )
            // InternalBasicsParser.g:8605:2: ( ruleDateTime0 )
            {
            // InternalBasicsParser.g:8605:2: ( ruleDateTime0 )
            // InternalBasicsParser.g:8606:3: ruleDateTime0
            {
             before(grammarAccess.getParameterDateAccess().getValueDateTime0ParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDateTime0();

            state._fsp--;

             after(grammarAccess.getParameterDateAccess().getValueDateTime0ParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterDate__ValueAssignment"


    // $ANTLR start "rule__ParameterStructMember__NameAssignment_0"
    // InternalBasicsParser.g:8615:1: rule__ParameterStructMember__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__ParameterStructMember__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8619:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8620:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8620:2: ( ruleEString )
            // InternalBasicsParser.g:8621:3: ruleEString
            {
             before(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__NameAssignment_0"


    // $ANTLR start "rule__ParameterStructMember__ValueAssignment_2"
    // InternalBasicsParser.g:8630:1: rule__ParameterStructMember__ValueAssignment_2 : ( ruleParameterValue ) ;
    public final void rule__ParameterStructMember__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8634:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:8635:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:8635:2: ( ruleParameterValue )
            // InternalBasicsParser.g:8636:3: ruleParameterValue
            {
             before(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterValue();

            state._fsp--;

             after(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__ValueAssignment_2"


    // $ANTLR start "rule__ParameterStructTypeMember__NameAssignment_0"
    // InternalBasicsParser.g:8645:1: rule__ParameterStructTypeMember__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__ParameterStructTypeMember__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8649:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8650:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8650:2: ( ruleEString )
            // InternalBasicsParser.g:8651:3: ruleEString
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructTypeMember__NameAssignment_0"


    // $ANTLR start "rule__ParameterStructTypeMember__TypeAssignment_1"
    // InternalBasicsParser.g:8660:1: rule__ParameterStructTypeMember__TypeAssignment_1 : ( ruleParameterType ) ;
    public final void rule__ParameterStructTypeMember__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8664:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8665:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8665:2: ( ruleParameterType )
            // InternalBasicsParser.g:8666:3: ruleParameterType
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getTypeParameterTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterType();

            state._fsp--;

             after(grammarAccess.getParameterStructTypeMemberAccess().getTypeParameterTypeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructTypeMember__TypeAssignment_1"


    // $ANTLR start "rule__SpecBaseRef__ReferenceAssignment"
    // InternalBasicsParser.g:8675:1: rule__SpecBaseRef__ReferenceAssignment : ( ( ruleEString ) ) ;
    public final void rule__SpecBaseRef__ReferenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8679:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:8680:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:8680:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:8681:3: ( ruleEString )
            {
             before(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecCrossReference_0()); 
            // InternalBasicsParser.g:8682:3: ( ruleEString )
            // InternalBasicsParser.g:8683:4: ruleEString
            {
             before(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecEStringParserRuleCall_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecEStringParserRuleCall_0_1()); 

            }

             after(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SpecBaseRef__ReferenceAssignment"


    // $ANTLR start "rule__ArraySpecRef__ReferenceAssignment_0"
    // InternalBasicsParser.g:8694:1: rule__ArraySpecRef__ReferenceAssignment_0 : ( ( ruleEString ) ) ;
    public final void rule__ArraySpecRef__ReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8698:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:8699:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:8699:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:8700:3: ( ruleEString )
            {
             before(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0()); 
            // InternalBasicsParser.g:8701:3: ( ruleEString )
            // InternalBasicsParser.g:8702:4: ruleEString
            {
             before(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecEStringParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecEStringParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArraySpecRef__ReferenceAssignment_0"


    // $ANTLR start "rule__ExtensionEntry__KeyAssignment_1_0_0"
    // InternalBasicsParser.g:8713:1: rule__ExtensionEntry__KeyAssignment_1_0_0 : ( ruleExtensionKey ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8717:1: ( ( ruleExtensionKey ) )
            // InternalBasicsParser.g:8718:2: ( ruleExtensionKey )
            {
            // InternalBasicsParser.g:8718:2: ( ruleExtensionKey )
            // InternalBasicsParser.g:8719:3: ruleExtensionKey
            {
             before(grammarAccess.getExtensionEntryAccess().getKeyExtensionKeyParserRuleCall_1_0_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionKey();

            state._fsp--;

             after(grammarAccess.getExtensionEntryAccess().getKeyExtensionKeyParserRuleCall_1_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__KeyAssignment_1_0_0"


    // $ANTLR start "rule__ExtensionEntry__KeyAssignment_1_1"
    // InternalBasicsParser.g:8728:1: rule__ExtensionEntry__KeyAssignment_1_1 : ( ruleExtensionColonKey ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8732:1: ( ( ruleExtensionColonKey ) )
            // InternalBasicsParser.g:8733:2: ( ruleExtensionColonKey )
            {
            // InternalBasicsParser.g:8733:2: ( ruleExtensionColonKey )
            // InternalBasicsParser.g:8734:3: ruleExtensionColonKey
            {
             before(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionColonKey();

            state._fsp--;

             after(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__KeyAssignment_1_1"


    // $ANTLR start "rule__ExtensionEntry__ValueAssignment_2"
    // InternalBasicsParser.g:8743:1: rule__ExtensionEntry__ValueAssignment_2 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionEntry__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8747:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:8748:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:8748:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:8749:3: ruleExtensionValue
            {
             before(grammarAccess.getExtensionEntryAccess().getValueExtensionValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionValue();

            state._fsp--;

             after(grammarAccess.getExtensionEntryAccess().getValueExtensionValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__ValueAssignment_2"


    // $ANTLR start "rule__ExtensionListValue__ItemsAssignment_2_0"
    // InternalBasicsParser.g:8758:1: rule__ExtensionListValue__ItemsAssignment_2_0 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionListValue__ItemsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8762:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:8763:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:8763:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:8764:3: ruleExtensionValue
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionValue();

            state._fsp--;

             after(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__ItemsAssignment_2_0"


    // $ANTLR start "rule__ExtensionListValue__ItemsAssignment_2_1_1"
    // InternalBasicsParser.g:8773:1: rule__ExtensionListValue__ItemsAssignment_2_1_1 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionListValue__ItemsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8777:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:8778:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:8778:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:8779:3: ruleExtensionValue
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionValue();

            state._fsp--;

             after(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__ItemsAssignment_2_1_1"


    // $ANTLR start "rule__ExtensionBraceMapValue__EntriesAssignment_2_0"
    // InternalBasicsParser.g:8788:1: rule__ExtensionBraceMapValue__EntriesAssignment_2_0 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionBraceMapValue__EntriesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8792:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:8793:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:8793:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:8794:3: ruleExtensionEntry
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionEntry();

            state._fsp--;

             after(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__EntriesAssignment_2_0"


    // $ANTLR start "rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1"
    // InternalBasicsParser.g:8803:1: rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8807:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:8808:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:8808:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:8809:3: ruleExtensionEntry
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionEntry();

            state._fsp--;

             after(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1"


    // $ANTLR start "rule__ExtensionIndentedMapValue__EntriesAssignment_2"
    // InternalBasicsParser.g:8818:1: rule__ExtensionIndentedMapValue__EntriesAssignment_2 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionIndentedMapValue__EntriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8822:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:8823:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:8823:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:8824:3: ruleExtensionEntry
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionEntry();

            state._fsp--;

             after(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionIndentedMapValue__EntriesAssignment_2"


    // $ANTLR start "rule__ExtensionRefValue__RefKindAssignment_1"
    // InternalBasicsParser.g:8833:1: rule__ExtensionRefValue__RefKindAssignment_1 : ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) ) ;
    public final void rule__ExtensionRefValue__RefKindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8837:1: ( ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) ) )
            // InternalBasicsParser.g:8838:2: ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) )
            {
            // InternalBasicsParser.g:8838:2: ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) )
            // InternalBasicsParser.g:8839:3: ( rule__ExtensionRefValue__RefKindAlternatives_1_0 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getRefKindAlternatives_1_0()); 
            // InternalBasicsParser.g:8840:3: ( rule__ExtensionRefValue__RefKindAlternatives_1_0 )
            // InternalBasicsParser.g:8840:4: rule__ExtensionRefValue__RefKindAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionRefValue__RefKindAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionRefValueAccess().getRefKindAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__RefKindAssignment_1"


    // $ANTLR start "rule__ExtensionRefValue__TargetAssignment_2"
    // InternalBasicsParser.g:8848:1: rule__ExtensionRefValue__TargetAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__ExtensionRefValue__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8852:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:8853:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:8853:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:8854:3: ( ruleEString )
            {
             before(grammarAccess.getExtensionRefValueAccess().getTargetEObjectCrossReference_2_0()); 
            // InternalBasicsParser.g:8855:3: ( ruleEString )
            // InternalBasicsParser.g:8856:4: ruleEString
            {
             before(grammarAccess.getExtensionRefValueAccess().getTargetEObjectEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExtensionRefValueAccess().getTargetEObjectEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getExtensionRefValueAccess().getTargetEObjectCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionRefValue__TargetAssignment_2"


    // $ANTLR start "rule__ExtensionScalarValue__ValueAssignment_1"
    // InternalBasicsParser.g:8867:1: rule__ExtensionScalarValue__ValueAssignment_1 : ( ruleExtensionScalarLiteral ) ;
    public final void rule__ExtensionScalarValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8871:1: ( ( ruleExtensionScalarLiteral ) )
            // InternalBasicsParser.g:8872:2: ( ruleExtensionScalarLiteral )
            {
            // InternalBasicsParser.g:8872:2: ( ruleExtensionScalarLiteral )
            // InternalBasicsParser.g:8873:3: ruleExtensionScalarLiteral
            {
             before(grammarAccess.getExtensionScalarValueAccess().getValueExtensionScalarLiteralParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionScalarLiteral();

            state._fsp--;

             after(grammarAccess.getExtensionScalarValueAccess().getValueExtensionScalarLiteralParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionScalarValue__ValueAssignment_1"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\10\2\11\10\uffff";
    static final String dfa_3s = "\3\110\4\uffff\1\110\3\uffff";
    static final String dfa_4s = "\3\134\4\uffff\1\137\3\uffff";
    static final String dfa_5s = "\3\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\10\3\uffff\1\7\1\10\3\uffff\1\3\1\6\1\4\1\5\6\uffff\1\2\1\1",
            "\1\11\1\uffff\1\10\2\uffff\1\11\15\uffff\2\11",
            "\1\11\1\uffff\1\10\2\uffff\1\11\15\uffff\2\11",
            "",
            "",
            "",
            "",
            "\1\12\3\uffff\2\12\3\uffff\4\12\6\uffff\2\12\2\uffff\1\10",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2164:1: rule__ParameterValue__Alternatives : ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) );";
        }
    }
    static final String dfa_8s = "\44\uffff";
    static final String dfa_9s = "\36\uffff\2\43\4\uffff";
    static final String dfa_10s = "\1\11\35\uffff\2\107\4\uffff";
    static final String dfa_11s = "\1\134\35\uffff\2\107\4\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\40\1\41\1\37\1\36";
    static final String dfa_13s = "\44\uffff}>";
    static final String[] dfa_14s = {
            "\1\32\1\33\1\uffff\1\17\1\uffff\1\34\1\25\1\27\1\31\2\uffff\1\12\1\13\1\24\1\26\1\30\3\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\41\1\22\1\uffff\1\14\1\5\1\7\1\11\2\uffff\1\4\1\6\1\10\3\uffff\1\3\5\uffff\1\1\1\15\1\40\1\uffff\1\2\4\uffff\1\16\27\uffff\1\37\1\36",
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
            "",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\42",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2215:1: rule__AbstractType__Alternatives : ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleSpecBaseRef ) | ( ruleArraySpecRef ) | ( rulechar ) | ( rulecharArray ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00802003600C0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x00000000181E1000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000018002000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000018000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0xFCF9FF87EA3C3800L,0x0000000018000079L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0xFFF7EF87EE3C3000L,0x00000000B81C503FL});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0xFFF7EF87EE3C3000L,0x00000000B81C703FL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xFFF7EF87EE3C3000L,0x00000000B81C513FL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0xFFF7EF87EE3C3002L,0x00000000B81C513FL});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0xFCF9FF87EA3C3800L,0x0000000018008079L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0xFCF9FF87EA3C3800L,0x0000000018000179L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0xFCF9FF87EA3C3802L,0x0000000018000179L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0xFCF9FF87EA3C3802L,0x0000000018000079L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0306000004000000L,0x0000000000000006L});

}