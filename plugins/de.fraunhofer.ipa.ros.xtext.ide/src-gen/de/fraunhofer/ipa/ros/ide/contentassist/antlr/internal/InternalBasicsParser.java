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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "ParameterAny", "Pluginbases", "Pluginslots", "Implements", "Active_in", "Lifecycle", "Parameter", "GraphName", "Float32_1", "Float64_1", "Multiple", "Default", "Duration", "Feedback", "Plugins", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Float32", "Float64", "Format", "Header_1", "Int16_1", "Int32_1", "Int64_1", "Loader", "Message", "Param", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Class", "Int8_1", "Result", "Slots", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Base", "Int16", "Int32", "Int64", "Pub", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
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
    		tokenNameToValue.put("Base", "'base:'");
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
    		tokenNameToValue.put("Class", "'class:'");
    		tokenNameToValue.put("Int8_1", "'int8[]'");
    		tokenNameToValue.put("Result", "'result'");
    		tokenNameToValue.put("Slots", "'slots:'");
    		tokenNameToValue.put("String_1", "'string'");
    		tokenNameToValue.put("Uint16", "'uint16'");
    		tokenNameToValue.put("Uint32", "'uint32'");
    		tokenNameToValue.put("Uint64", "'uint64'");
    		tokenNameToValue.put("Value_1", "'value:'");
    		tokenNameToValue.put("Boolean", "'Boolean'");
    		tokenNameToValue.put("Integer", "'Integer'");
    		tokenNameToValue.put("Float32", "'float32'");
    		tokenNameToValue.put("Float64", "'float64'");
    		tokenNameToValue.put("Format", "'format:'");
    		tokenNameToValue.put("Header_1", "'header:'");
    		tokenNameToValue.put("Int16_1", "'int16[]'");
    		tokenNameToValue.put("Int32_1", "'int32[]'");
    		tokenNameToValue.put("Int64_1", "'int64[]'");
    		tokenNameToValue.put("Loader", "'loader:'");
    		tokenNameToValue.put("Message", "'message'");
    		tokenNameToValue.put("Param", "'param->'");
    		tokenNameToValue.put("Service", "'service'");
    		tokenNameToValue.put("Uint8_1", "'uint8[]'");
    		tokenNameToValue.put("Default", "'default:'");
    		tokenNameToValue.put("Duration", "'duration'");
    		tokenNameToValue.put("Feedback", "'feedback'");
    		tokenNameToValue.put("Plugins", "'plugins:'");
    		tokenNameToValue.put("String_2", "'string[]'");
    		tokenNameToValue.put("Uint16_1", "'uint16[]'");
    		tokenNameToValue.put("Uint32_1", "'uint32[]'");
    		tokenNameToValue.put("Uint64_1", "'uint64[]'");
    		tokenNameToValue.put("GraphName", "'GraphName'");
    		tokenNameToValue.put("Float32_1", "'float32[]'");
    		tokenNameToValue.put("Float64_1", "'float64[]'");
    		tokenNameToValue.put("Multiple", "'multiple:'");
    		tokenNameToValue.put("Active_in", "'active_in:'");
    		tokenNameToValue.put("Lifecycle", "'lifecycle:'");
    		tokenNameToValue.put("Parameter", "'parameter:'");
    		tokenNameToValue.put("Implements", "'implements:'");
    		tokenNameToValue.put("ParameterAny", "'ParameterAny'");
    		tokenNameToValue.put("Pluginbases", "'pluginbases:'");
    		tokenNameToValue.put("Pluginslots", "'pluginslots:'");
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
    // InternalBasicsParser.g:145:1: entryRuleNamespace : ruleNamespace EOF ;
    public final void entryRuleNamespace() throws RecognitionException {
        try {
            // InternalBasicsParser.g:146:1: ( ruleNamespace EOF )
            // InternalBasicsParser.g:147:1: ruleNamespace EOF
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
    // InternalBasicsParser.g:154:1: ruleNamespace : ( ( rule__Namespace__Alternatives ) ) ;
    public final void ruleNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:158:2: ( ( ( rule__Namespace__Alternatives ) ) )
            // InternalBasicsParser.g:159:2: ( ( rule__Namespace__Alternatives ) )
            {
            // InternalBasicsParser.g:159:2: ( ( rule__Namespace__Alternatives ) )
            // InternalBasicsParser.g:160:3: ( rule__Namespace__Alternatives )
            {
             before(grammarAccess.getNamespaceAccess().getAlternatives()); 
            // InternalBasicsParser.g:161:3: ( rule__Namespace__Alternatives )
            // InternalBasicsParser.g:161:4: rule__Namespace__Alternatives
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
    // InternalBasicsParser.g:170:1: entryRuleGraphName : ruleGraphName EOF ;
    public final void entryRuleGraphName() throws RecognitionException {
        try {
            // InternalBasicsParser.g:171:1: ( ruleGraphName EOF )
            // InternalBasicsParser.g:172:1: ruleGraphName EOF
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
    // InternalBasicsParser.g:179:1: ruleGraphName : ( GraphName ) ;
    public final void ruleGraphName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:183:2: ( ( GraphName ) )
            // InternalBasicsParser.g:184:2: ( GraphName )
            {
            // InternalBasicsParser.g:184:2: ( GraphName )
            // InternalBasicsParser.g:185:3: GraphName
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
    // InternalBasicsParser.g:195:1: entryRuleGlobalNamespace : ruleGlobalNamespace EOF ;
    public final void entryRuleGlobalNamespace() throws RecognitionException {
        try {
            // InternalBasicsParser.g:196:1: ( ruleGlobalNamespace EOF )
            // InternalBasicsParser.g:197:1: ruleGlobalNamespace EOF
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
    // InternalBasicsParser.g:204:1: ruleGlobalNamespace : ( ( rule__GlobalNamespace__Group__0 ) ) ;
    public final void ruleGlobalNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:208:2: ( ( ( rule__GlobalNamespace__Group__0 ) ) )
            // InternalBasicsParser.g:209:2: ( ( rule__GlobalNamespace__Group__0 ) )
            {
            // InternalBasicsParser.g:209:2: ( ( rule__GlobalNamespace__Group__0 ) )
            // InternalBasicsParser.g:210:3: ( rule__GlobalNamespace__Group__0 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup()); 
            // InternalBasicsParser.g:211:3: ( rule__GlobalNamespace__Group__0 )
            // InternalBasicsParser.g:211:4: rule__GlobalNamespace__Group__0
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
    // InternalBasicsParser.g:220:1: entryRuleRelativeNamespace_Impl : ruleRelativeNamespace_Impl EOF ;
    public final void entryRuleRelativeNamespace_Impl() throws RecognitionException {
        try {
            // InternalBasicsParser.g:221:1: ( ruleRelativeNamespace_Impl EOF )
            // InternalBasicsParser.g:222:1: ruleRelativeNamespace_Impl EOF
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
    // InternalBasicsParser.g:229:1: ruleRelativeNamespace_Impl : ( ( rule__RelativeNamespace_Impl__Group__0 ) ) ;
    public final void ruleRelativeNamespace_Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:233:2: ( ( ( rule__RelativeNamespace_Impl__Group__0 ) ) )
            // InternalBasicsParser.g:234:2: ( ( rule__RelativeNamespace_Impl__Group__0 ) )
            {
            // InternalBasicsParser.g:234:2: ( ( rule__RelativeNamespace_Impl__Group__0 ) )
            // InternalBasicsParser.g:235:3: ( rule__RelativeNamespace_Impl__Group__0 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup()); 
            // InternalBasicsParser.g:236:3: ( rule__RelativeNamespace_Impl__Group__0 )
            // InternalBasicsParser.g:236:4: rule__RelativeNamespace_Impl__Group__0
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
    // InternalBasicsParser.g:245:1: entryRulePrivateNamespace : rulePrivateNamespace EOF ;
    public final void entryRulePrivateNamespace() throws RecognitionException {
        try {
            // InternalBasicsParser.g:246:1: ( rulePrivateNamespace EOF )
            // InternalBasicsParser.g:247:1: rulePrivateNamespace EOF
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
    // InternalBasicsParser.g:254:1: rulePrivateNamespace : ( ( rule__PrivateNamespace__Group__0 ) ) ;
    public final void rulePrivateNamespace() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:258:2: ( ( ( rule__PrivateNamespace__Group__0 ) ) )
            // InternalBasicsParser.g:259:2: ( ( rule__PrivateNamespace__Group__0 ) )
            {
            // InternalBasicsParser.g:259:2: ( ( rule__PrivateNamespace__Group__0 ) )
            // InternalBasicsParser.g:260:3: ( rule__PrivateNamespace__Group__0 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup()); 
            // InternalBasicsParser.g:261:3: ( rule__PrivateNamespace__Group__0 )
            // InternalBasicsParser.g:261:4: rule__PrivateNamespace__Group__0
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
    // InternalBasicsParser.g:270:1: entryRuleParameterType : ruleParameterType EOF ;
    public final void entryRuleParameterType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:271:1: ( ruleParameterType EOF )
            // InternalBasicsParser.g:272:1: ruleParameterType EOF
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
    // InternalBasicsParser.g:279:1: ruleParameterType : ( ( rule__ParameterType__Alternatives ) ) ;
    public final void ruleParameterType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:283:2: ( ( ( rule__ParameterType__Alternatives ) ) )
            // InternalBasicsParser.g:284:2: ( ( rule__ParameterType__Alternatives ) )
            {
            // InternalBasicsParser.g:284:2: ( ( rule__ParameterType__Alternatives ) )
            // InternalBasicsParser.g:285:3: ( rule__ParameterType__Alternatives )
            {
             before(grammarAccess.getParameterTypeAccess().getAlternatives()); 
            // InternalBasicsParser.g:286:3: ( rule__ParameterType__Alternatives )
            // InternalBasicsParser.g:286:4: rule__ParameterType__Alternatives
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
    // InternalBasicsParser.g:295:1: entryRuleParameterValue : ruleParameterValue EOF ;
    public final void entryRuleParameterValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:296:1: ( ruleParameterValue EOF )
            // InternalBasicsParser.g:297:1: ruleParameterValue EOF
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
    // InternalBasicsParser.g:304:1: ruleParameterValue : ( ( rule__ParameterValue__Alternatives ) ) ;
    public final void ruleParameterValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:308:2: ( ( ( rule__ParameterValue__Alternatives ) ) )
            // InternalBasicsParser.g:309:2: ( ( rule__ParameterValue__Alternatives ) )
            {
            // InternalBasicsParser.g:309:2: ( ( rule__ParameterValue__Alternatives ) )
            // InternalBasicsParser.g:310:3: ( rule__ParameterValue__Alternatives )
            {
             before(grammarAccess.getParameterValueAccess().getAlternatives()); 
            // InternalBasicsParser.g:311:3: ( rule__ParameterValue__Alternatives )
            // InternalBasicsParser.g:311:4: rule__ParameterValue__Alternatives
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
    // InternalBasicsParser.g:320:1: entryRuleParameterListType : ruleParameterListType EOF ;
    public final void entryRuleParameterListType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:321:1: ( ruleParameterListType EOF )
            // InternalBasicsParser.g:322:1: ruleParameterListType EOF
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
    // InternalBasicsParser.g:329:1: ruleParameterListType : ( ( rule__ParameterListType__Group__0 ) ) ;
    public final void ruleParameterListType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:333:2: ( ( ( rule__ParameterListType__Group__0 ) ) )
            // InternalBasicsParser.g:334:2: ( ( rule__ParameterListType__Group__0 ) )
            {
            // InternalBasicsParser.g:334:2: ( ( rule__ParameterListType__Group__0 ) )
            // InternalBasicsParser.g:335:3: ( rule__ParameterListType__Group__0 )
            {
             before(grammarAccess.getParameterListTypeAccess().getGroup()); 
            // InternalBasicsParser.g:336:3: ( rule__ParameterListType__Group__0 )
            // InternalBasicsParser.g:336:4: rule__ParameterListType__Group__0
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
    // InternalBasicsParser.g:345:1: entryRuleParameterStructType : ruleParameterStructType EOF ;
    public final void entryRuleParameterStructType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:346:1: ( ruleParameterStructType EOF )
            // InternalBasicsParser.g:347:1: ruleParameterStructType EOF
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
    // InternalBasicsParser.g:354:1: ruleParameterStructType : ( ( rule__ParameterStructType__Group__0 ) ) ;
    public final void ruleParameterStructType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:358:2: ( ( ( rule__ParameterStructType__Group__0 ) ) )
            // InternalBasicsParser.g:359:2: ( ( rule__ParameterStructType__Group__0 ) )
            {
            // InternalBasicsParser.g:359:2: ( ( rule__ParameterStructType__Group__0 ) )
            // InternalBasicsParser.g:360:3: ( rule__ParameterStructType__Group__0 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getGroup()); 
            // InternalBasicsParser.g:361:3: ( rule__ParameterStructType__Group__0 )
            // InternalBasicsParser.g:361:4: rule__ParameterStructType__Group__0
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
    // InternalBasicsParser.g:370:1: entryRuleParameterIntegerType : ruleParameterIntegerType EOF ;
    public final void entryRuleParameterIntegerType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:371:1: ( ruleParameterIntegerType EOF )
            // InternalBasicsParser.g:372:1: ruleParameterIntegerType EOF
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
    // InternalBasicsParser.g:379:1: ruleParameterIntegerType : ( ( rule__ParameterIntegerType__Group__0 ) ) ;
    public final void ruleParameterIntegerType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:383:2: ( ( ( rule__ParameterIntegerType__Group__0 ) ) )
            // InternalBasicsParser.g:384:2: ( ( rule__ParameterIntegerType__Group__0 ) )
            {
            // InternalBasicsParser.g:384:2: ( ( rule__ParameterIntegerType__Group__0 ) )
            // InternalBasicsParser.g:385:3: ( rule__ParameterIntegerType__Group__0 )
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getGroup()); 
            // InternalBasicsParser.g:386:3: ( rule__ParameterIntegerType__Group__0 )
            // InternalBasicsParser.g:386:4: rule__ParameterIntegerType__Group__0
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
    // InternalBasicsParser.g:395:1: entryRuleParameterStringType : ruleParameterStringType EOF ;
    public final void entryRuleParameterStringType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:396:1: ( ruleParameterStringType EOF )
            // InternalBasicsParser.g:397:1: ruleParameterStringType EOF
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
    // InternalBasicsParser.g:404:1: ruleParameterStringType : ( ( rule__ParameterStringType__Group__0 ) ) ;
    public final void ruleParameterStringType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:408:2: ( ( ( rule__ParameterStringType__Group__0 ) ) )
            // InternalBasicsParser.g:409:2: ( ( rule__ParameterStringType__Group__0 ) )
            {
            // InternalBasicsParser.g:409:2: ( ( rule__ParameterStringType__Group__0 ) )
            // InternalBasicsParser.g:410:3: ( rule__ParameterStringType__Group__0 )
            {
             before(grammarAccess.getParameterStringTypeAccess().getGroup()); 
            // InternalBasicsParser.g:411:3: ( rule__ParameterStringType__Group__0 )
            // InternalBasicsParser.g:411:4: rule__ParameterStringType__Group__0
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
    // InternalBasicsParser.g:420:1: entryRuleParameterDoubleType : ruleParameterDoubleType EOF ;
    public final void entryRuleParameterDoubleType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:421:1: ( ruleParameterDoubleType EOF )
            // InternalBasicsParser.g:422:1: ruleParameterDoubleType EOF
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
    // InternalBasicsParser.g:429:1: ruleParameterDoubleType : ( ( rule__ParameterDoubleType__Group__0 ) ) ;
    public final void ruleParameterDoubleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:433:2: ( ( ( rule__ParameterDoubleType__Group__0 ) ) )
            // InternalBasicsParser.g:434:2: ( ( rule__ParameterDoubleType__Group__0 ) )
            {
            // InternalBasicsParser.g:434:2: ( ( rule__ParameterDoubleType__Group__0 ) )
            // InternalBasicsParser.g:435:3: ( rule__ParameterDoubleType__Group__0 )
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getGroup()); 
            // InternalBasicsParser.g:436:3: ( rule__ParameterDoubleType__Group__0 )
            // InternalBasicsParser.g:436:4: rule__ParameterDoubleType__Group__0
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
    // InternalBasicsParser.g:445:1: entryRuleParameterBooleanType : ruleParameterBooleanType EOF ;
    public final void entryRuleParameterBooleanType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:446:1: ( ruleParameterBooleanType EOF )
            // InternalBasicsParser.g:447:1: ruleParameterBooleanType EOF
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
    // InternalBasicsParser.g:454:1: ruleParameterBooleanType : ( ( rule__ParameterBooleanType__Group__0 ) ) ;
    public final void ruleParameterBooleanType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:458:2: ( ( ( rule__ParameterBooleanType__Group__0 ) ) )
            // InternalBasicsParser.g:459:2: ( ( rule__ParameterBooleanType__Group__0 ) )
            {
            // InternalBasicsParser.g:459:2: ( ( rule__ParameterBooleanType__Group__0 ) )
            // InternalBasicsParser.g:460:3: ( rule__ParameterBooleanType__Group__0 )
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getGroup()); 
            // InternalBasicsParser.g:461:3: ( rule__ParameterBooleanType__Group__0 )
            // InternalBasicsParser.g:461:4: rule__ParameterBooleanType__Group__0
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
    // InternalBasicsParser.g:470:1: entryRuleParameterBase64Type : ruleParameterBase64Type EOF ;
    public final void entryRuleParameterBase64Type() throws RecognitionException {
        try {
            // InternalBasicsParser.g:471:1: ( ruleParameterBase64Type EOF )
            // InternalBasicsParser.g:472:1: ruleParameterBase64Type EOF
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
    // InternalBasicsParser.g:479:1: ruleParameterBase64Type : ( ( rule__ParameterBase64Type__Group__0 ) ) ;
    public final void ruleParameterBase64Type() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:483:2: ( ( ( rule__ParameterBase64Type__Group__0 ) ) )
            // InternalBasicsParser.g:484:2: ( ( rule__ParameterBase64Type__Group__0 ) )
            {
            // InternalBasicsParser.g:484:2: ( ( rule__ParameterBase64Type__Group__0 ) )
            // InternalBasicsParser.g:485:3: ( rule__ParameterBase64Type__Group__0 )
            {
             before(grammarAccess.getParameterBase64TypeAccess().getGroup()); 
            // InternalBasicsParser.g:486:3: ( rule__ParameterBase64Type__Group__0 )
            // InternalBasicsParser.g:486:4: rule__ParameterBase64Type__Group__0
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
    // InternalBasicsParser.g:495:1: entryRuleParameterArrayType : ruleParameterArrayType EOF ;
    public final void entryRuleParameterArrayType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:496:1: ( ruleParameterArrayType EOF )
            // InternalBasicsParser.g:497:1: ruleParameterArrayType EOF
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
    // InternalBasicsParser.g:504:1: ruleParameterArrayType : ( ( rule__ParameterArrayType__Group__0 ) ) ;
    public final void ruleParameterArrayType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:508:2: ( ( ( rule__ParameterArrayType__Group__0 ) ) )
            // InternalBasicsParser.g:509:2: ( ( rule__ParameterArrayType__Group__0 ) )
            {
            // InternalBasicsParser.g:509:2: ( ( rule__ParameterArrayType__Group__0 ) )
            // InternalBasicsParser.g:510:3: ( rule__ParameterArrayType__Group__0 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getGroup()); 
            // InternalBasicsParser.g:511:3: ( rule__ParameterArrayType__Group__0 )
            // InternalBasicsParser.g:511:4: rule__ParameterArrayType__Group__0
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
    // InternalBasicsParser.g:520:1: entryRuleParameterList : ruleParameterList EOF ;
    public final void entryRuleParameterList() throws RecognitionException {
        try {
            // InternalBasicsParser.g:521:1: ( ruleParameterList EOF )
            // InternalBasicsParser.g:522:1: ruleParameterList EOF
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
    // InternalBasicsParser.g:529:1: ruleParameterList : ( ( rule__ParameterList__Group__0 ) ) ;
    public final void ruleParameterList() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:533:2: ( ( ( rule__ParameterList__Group__0 ) ) )
            // InternalBasicsParser.g:534:2: ( ( rule__ParameterList__Group__0 ) )
            {
            // InternalBasicsParser.g:534:2: ( ( rule__ParameterList__Group__0 ) )
            // InternalBasicsParser.g:535:3: ( rule__ParameterList__Group__0 )
            {
             before(grammarAccess.getParameterListAccess().getGroup()); 
            // InternalBasicsParser.g:536:3: ( rule__ParameterList__Group__0 )
            // InternalBasicsParser.g:536:4: rule__ParameterList__Group__0
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
    // InternalBasicsParser.g:545:1: entryRuleParameterAny : ruleParameterAny EOF ;
    public final void entryRuleParameterAny() throws RecognitionException {
        try {
            // InternalBasicsParser.g:546:1: ( ruleParameterAny EOF )
            // InternalBasicsParser.g:547:1: ruleParameterAny EOF
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
    // InternalBasicsParser.g:554:1: ruleParameterAny : ( ( rule__ParameterAny__Group__0 ) ) ;
    public final void ruleParameterAny() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:558:2: ( ( ( rule__ParameterAny__Group__0 ) ) )
            // InternalBasicsParser.g:559:2: ( ( rule__ParameterAny__Group__0 ) )
            {
            // InternalBasicsParser.g:559:2: ( ( rule__ParameterAny__Group__0 ) )
            // InternalBasicsParser.g:560:3: ( rule__ParameterAny__Group__0 )
            {
             before(grammarAccess.getParameterAnyAccess().getGroup()); 
            // InternalBasicsParser.g:561:3: ( rule__ParameterAny__Group__0 )
            // InternalBasicsParser.g:561:4: rule__ParameterAny__Group__0
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
    // InternalBasicsParser.g:570:1: entryRuleParameterString : ruleParameterString EOF ;
    public final void entryRuleParameterString() throws RecognitionException {
        try {
            // InternalBasicsParser.g:571:1: ( ruleParameterString EOF )
            // InternalBasicsParser.g:572:1: ruleParameterString EOF
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
    // InternalBasicsParser.g:579:1: ruleParameterString : ( ( rule__ParameterString__ValueAssignment ) ) ;
    public final void ruleParameterString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:583:2: ( ( ( rule__ParameterString__ValueAssignment ) ) )
            // InternalBasicsParser.g:584:2: ( ( rule__ParameterString__ValueAssignment ) )
            {
            // InternalBasicsParser.g:584:2: ( ( rule__ParameterString__ValueAssignment ) )
            // InternalBasicsParser.g:585:3: ( rule__ParameterString__ValueAssignment )
            {
             before(grammarAccess.getParameterStringAccess().getValueAssignment()); 
            // InternalBasicsParser.g:586:3: ( rule__ParameterString__ValueAssignment )
            // InternalBasicsParser.g:586:4: rule__ParameterString__ValueAssignment
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
    // InternalBasicsParser.g:595:1: entryRuleParameterBase64 : ruleParameterBase64 EOF ;
    public final void entryRuleParameterBase64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:596:1: ( ruleParameterBase64 EOF )
            // InternalBasicsParser.g:597:1: ruleParameterBase64 EOF
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
    // InternalBasicsParser.g:604:1: ruleParameterBase64 : ( ( rule__ParameterBase64__ValueAssignment ) ) ;
    public final void ruleParameterBase64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:608:2: ( ( ( rule__ParameterBase64__ValueAssignment ) ) )
            // InternalBasicsParser.g:609:2: ( ( rule__ParameterBase64__ValueAssignment ) )
            {
            // InternalBasicsParser.g:609:2: ( ( rule__ParameterBase64__ValueAssignment ) )
            // InternalBasicsParser.g:610:3: ( rule__ParameterBase64__ValueAssignment )
            {
             before(grammarAccess.getParameterBase64Access().getValueAssignment()); 
            // InternalBasicsParser.g:611:3: ( rule__ParameterBase64__ValueAssignment )
            // InternalBasicsParser.g:611:4: rule__ParameterBase64__ValueAssignment
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
    // InternalBasicsParser.g:620:1: entryRuleParameterInteger : ruleParameterInteger EOF ;
    public final void entryRuleParameterInteger() throws RecognitionException {
        try {
            // InternalBasicsParser.g:621:1: ( ruleParameterInteger EOF )
            // InternalBasicsParser.g:622:1: ruleParameterInteger EOF
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
    // InternalBasicsParser.g:629:1: ruleParameterInteger : ( ( rule__ParameterInteger__ValueAssignment ) ) ;
    public final void ruleParameterInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:633:2: ( ( ( rule__ParameterInteger__ValueAssignment ) ) )
            // InternalBasicsParser.g:634:2: ( ( rule__ParameterInteger__ValueAssignment ) )
            {
            // InternalBasicsParser.g:634:2: ( ( rule__ParameterInteger__ValueAssignment ) )
            // InternalBasicsParser.g:635:3: ( rule__ParameterInteger__ValueAssignment )
            {
             before(grammarAccess.getParameterIntegerAccess().getValueAssignment()); 
            // InternalBasicsParser.g:636:3: ( rule__ParameterInteger__ValueAssignment )
            // InternalBasicsParser.g:636:4: rule__ParameterInteger__ValueAssignment
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
    // InternalBasicsParser.g:645:1: entryRuleParameterDouble : ruleParameterDouble EOF ;
    public final void entryRuleParameterDouble() throws RecognitionException {
        try {
            // InternalBasicsParser.g:646:1: ( ruleParameterDouble EOF )
            // InternalBasicsParser.g:647:1: ruleParameterDouble EOF
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
    // InternalBasicsParser.g:654:1: ruleParameterDouble : ( ( rule__ParameterDouble__ValueAssignment ) ) ;
    public final void ruleParameterDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:658:2: ( ( ( rule__ParameterDouble__ValueAssignment ) ) )
            // InternalBasicsParser.g:659:2: ( ( rule__ParameterDouble__ValueAssignment ) )
            {
            // InternalBasicsParser.g:659:2: ( ( rule__ParameterDouble__ValueAssignment ) )
            // InternalBasicsParser.g:660:3: ( rule__ParameterDouble__ValueAssignment )
            {
             before(grammarAccess.getParameterDoubleAccess().getValueAssignment()); 
            // InternalBasicsParser.g:661:3: ( rule__ParameterDouble__ValueAssignment )
            // InternalBasicsParser.g:661:4: rule__ParameterDouble__ValueAssignment
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
    // InternalBasicsParser.g:670:1: entryRuleParameterBoolean : ruleParameterBoolean EOF ;
    public final void entryRuleParameterBoolean() throws RecognitionException {
        try {
            // InternalBasicsParser.g:671:1: ( ruleParameterBoolean EOF )
            // InternalBasicsParser.g:672:1: ruleParameterBoolean EOF
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
    // InternalBasicsParser.g:679:1: ruleParameterBoolean : ( ( rule__ParameterBoolean__ValueAssignment ) ) ;
    public final void ruleParameterBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:683:2: ( ( ( rule__ParameterBoolean__ValueAssignment ) ) )
            // InternalBasicsParser.g:684:2: ( ( rule__ParameterBoolean__ValueAssignment ) )
            {
            // InternalBasicsParser.g:684:2: ( ( rule__ParameterBoolean__ValueAssignment ) )
            // InternalBasicsParser.g:685:3: ( rule__ParameterBoolean__ValueAssignment )
            {
             before(grammarAccess.getParameterBooleanAccess().getValueAssignment()); 
            // InternalBasicsParser.g:686:3: ( rule__ParameterBoolean__ValueAssignment )
            // InternalBasicsParser.g:686:4: rule__ParameterBoolean__ValueAssignment
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
    // InternalBasicsParser.g:695:1: entryRuleParameterStruct : ruleParameterStruct EOF ;
    public final void entryRuleParameterStruct() throws RecognitionException {
        try {
            // InternalBasicsParser.g:696:1: ( ruleParameterStruct EOF )
            // InternalBasicsParser.g:697:1: ruleParameterStruct EOF
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
    // InternalBasicsParser.g:704:1: ruleParameterStruct : ( ( rule__ParameterStruct__Group__0 ) ) ;
    public final void ruleParameterStruct() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:708:2: ( ( ( rule__ParameterStruct__Group__0 ) ) )
            // InternalBasicsParser.g:709:2: ( ( rule__ParameterStruct__Group__0 ) )
            {
            // InternalBasicsParser.g:709:2: ( ( rule__ParameterStruct__Group__0 ) )
            // InternalBasicsParser.g:710:3: ( rule__ParameterStruct__Group__0 )
            {
             before(grammarAccess.getParameterStructAccess().getGroup()); 
            // InternalBasicsParser.g:711:3: ( rule__ParameterStruct__Group__0 )
            // InternalBasicsParser.g:711:4: rule__ParameterStruct__Group__0
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
    // InternalBasicsParser.g:720:1: entryRuleParameterDate : ruleParameterDate EOF ;
    public final void entryRuleParameterDate() throws RecognitionException {
        try {
            // InternalBasicsParser.g:721:1: ( ruleParameterDate EOF )
            // InternalBasicsParser.g:722:1: ruleParameterDate EOF
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
    // InternalBasicsParser.g:729:1: ruleParameterDate : ( ( rule__ParameterDate__ValueAssignment ) ) ;
    public final void ruleParameterDate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:733:2: ( ( ( rule__ParameterDate__ValueAssignment ) ) )
            // InternalBasicsParser.g:734:2: ( ( rule__ParameterDate__ValueAssignment ) )
            {
            // InternalBasicsParser.g:734:2: ( ( rule__ParameterDate__ValueAssignment ) )
            // InternalBasicsParser.g:735:3: ( rule__ParameterDate__ValueAssignment )
            {
             before(grammarAccess.getParameterDateAccess().getValueAssignment()); 
            // InternalBasicsParser.g:736:3: ( rule__ParameterDate__ValueAssignment )
            // InternalBasicsParser.g:736:4: rule__ParameterDate__ValueAssignment
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
    // InternalBasicsParser.g:745:1: entryRuleParameterStructMember : ruleParameterStructMember EOF ;
    public final void entryRuleParameterStructMember() throws RecognitionException {
        try {
            // InternalBasicsParser.g:746:1: ( ruleParameterStructMember EOF )
            // InternalBasicsParser.g:747:1: ruleParameterStructMember EOF
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
    // InternalBasicsParser.g:754:1: ruleParameterStructMember : ( ( rule__ParameterStructMember__Group__0 ) ) ;
    public final void ruleParameterStructMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:758:2: ( ( ( rule__ParameterStructMember__Group__0 ) ) )
            // InternalBasicsParser.g:759:2: ( ( rule__ParameterStructMember__Group__0 ) )
            {
            // InternalBasicsParser.g:759:2: ( ( rule__ParameterStructMember__Group__0 ) )
            // InternalBasicsParser.g:760:3: ( rule__ParameterStructMember__Group__0 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getGroup()); 
            // InternalBasicsParser.g:761:3: ( rule__ParameterStructMember__Group__0 )
            // InternalBasicsParser.g:761:4: rule__ParameterStructMember__Group__0
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
    // InternalBasicsParser.g:770:1: entryRuleParameterStructTypeMember : ruleParameterStructTypeMember EOF ;
    public final void entryRuleParameterStructTypeMember() throws RecognitionException {
        try {
            // InternalBasicsParser.g:771:1: ( ruleParameterStructTypeMember EOF )
            // InternalBasicsParser.g:772:1: ruleParameterStructTypeMember EOF
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
    // InternalBasicsParser.g:779:1: ruleParameterStructTypeMember : ( ( rule__ParameterStructTypeMember__Group__0 ) ) ;
    public final void ruleParameterStructTypeMember() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:783:2: ( ( ( rule__ParameterStructTypeMember__Group__0 ) ) )
            // InternalBasicsParser.g:784:2: ( ( rule__ParameterStructTypeMember__Group__0 ) )
            {
            // InternalBasicsParser.g:784:2: ( ( rule__ParameterStructTypeMember__Group__0 ) )
            // InternalBasicsParser.g:785:3: ( rule__ParameterStructTypeMember__Group__0 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getGroup()); 
            // InternalBasicsParser.g:786:3: ( rule__ParameterStructTypeMember__Group__0 )
            // InternalBasicsParser.g:786:4: rule__ParameterStructTypeMember__Group__0
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
    // InternalBasicsParser.g:795:1: entryRuleBase64Binary : ruleBase64Binary EOF ;
    public final void entryRuleBase64Binary() throws RecognitionException {
        try {
            // InternalBasicsParser.g:796:1: ( ruleBase64Binary EOF )
            // InternalBasicsParser.g:797:1: ruleBase64Binary EOF
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
    // InternalBasicsParser.g:804:1: ruleBase64Binary : ( RULE_BINARY ) ;
    public final void ruleBase64Binary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:808:2: ( ( RULE_BINARY ) )
            // InternalBasicsParser.g:809:2: ( RULE_BINARY )
            {
            // InternalBasicsParser.g:809:2: ( RULE_BINARY )
            // InternalBasicsParser.g:810:3: RULE_BINARY
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
    // InternalBasicsParser.g:820:1: entryRuleboolean0 : ruleboolean0 EOF ;
    public final void entryRuleboolean0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:821:1: ( ruleboolean0 EOF )
            // InternalBasicsParser.g:822:1: ruleboolean0 EOF
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
    // InternalBasicsParser.g:829:1: ruleboolean0 : ( RULE_BOOLEAN ) ;
    public final void ruleboolean0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:833:2: ( ( RULE_BOOLEAN ) )
            // InternalBasicsParser.g:834:2: ( RULE_BOOLEAN )
            {
            // InternalBasicsParser.g:834:2: ( RULE_BOOLEAN )
            // InternalBasicsParser.g:835:3: RULE_BOOLEAN
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
    // InternalBasicsParser.g:845:1: entryRuleDouble0 : ruleDouble0 EOF ;
    public final void entryRuleDouble0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:846:1: ( ruleDouble0 EOF )
            // InternalBasicsParser.g:847:1: ruleDouble0 EOF
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
    // InternalBasicsParser.g:854:1: ruleDouble0 : ( RULE_DOUBLE ) ;
    public final void ruleDouble0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:858:2: ( ( RULE_DOUBLE ) )
            // InternalBasicsParser.g:859:2: ( RULE_DOUBLE )
            {
            // InternalBasicsParser.g:859:2: ( RULE_DOUBLE )
            // InternalBasicsParser.g:860:3: RULE_DOUBLE
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
    // InternalBasicsParser.g:870:1: entryRuleInteger0 : ruleInteger0 EOF ;
    public final void entryRuleInteger0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:871:1: ( ruleInteger0 EOF )
            // InternalBasicsParser.g:872:1: ruleInteger0 EOF
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
    // InternalBasicsParser.g:879:1: ruleInteger0 : ( RULE_DECINT ) ;
    public final void ruleInteger0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:883:2: ( ( RULE_DECINT ) )
            // InternalBasicsParser.g:884:2: ( RULE_DECINT )
            {
            // InternalBasicsParser.g:884:2: ( RULE_DECINT )
            // InternalBasicsParser.g:885:3: RULE_DECINT
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
    // InternalBasicsParser.g:895:1: entryRuleDateTime0 : ruleDateTime0 EOF ;
    public final void entryRuleDateTime0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:896:1: ( ruleDateTime0 EOF )
            // InternalBasicsParser.g:897:1: ruleDateTime0 EOF
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
    // InternalBasicsParser.g:904:1: ruleDateTime0 : ( RULE_DATE_TIME ) ;
    public final void ruleDateTime0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:908:2: ( ( RULE_DATE_TIME ) )
            // InternalBasicsParser.g:909:2: ( RULE_DATE_TIME )
            {
            // InternalBasicsParser.g:909:2: ( RULE_DATE_TIME )
            // InternalBasicsParser.g:910:3: RULE_DATE_TIME
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
    // InternalBasicsParser.g:920:1: entryRuleAbstractType : ruleAbstractType EOF ;
    public final void entryRuleAbstractType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:921:1: ( ruleAbstractType EOF )
            // InternalBasicsParser.g:922:1: ruleAbstractType EOF
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
    // InternalBasicsParser.g:929:1: ruleAbstractType : ( ( rule__AbstractType__Alternatives ) ) ;
    public final void ruleAbstractType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:933:2: ( ( ( rule__AbstractType__Alternatives ) ) )
            // InternalBasicsParser.g:934:2: ( ( rule__AbstractType__Alternatives ) )
            {
            // InternalBasicsParser.g:934:2: ( ( rule__AbstractType__Alternatives ) )
            // InternalBasicsParser.g:935:3: ( rule__AbstractType__Alternatives )
            {
             before(grammarAccess.getAbstractTypeAccess().getAlternatives()); 
            // InternalBasicsParser.g:936:3: ( rule__AbstractType__Alternatives )
            // InternalBasicsParser.g:936:4: rule__AbstractType__Alternatives
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
    // InternalBasicsParser.g:945:1: entryRulebool : rulebool EOF ;
    public final void entryRulebool() throws RecognitionException {
        try {
            // InternalBasicsParser.g:946:1: ( rulebool EOF )
            // InternalBasicsParser.g:947:1: rulebool EOF
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
    // InternalBasicsParser.g:954:1: rulebool : ( ( rule__Bool__Group__0 ) ) ;
    public final void rulebool() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:958:2: ( ( ( rule__Bool__Group__0 ) ) )
            // InternalBasicsParser.g:959:2: ( ( rule__Bool__Group__0 ) )
            {
            // InternalBasicsParser.g:959:2: ( ( rule__Bool__Group__0 ) )
            // InternalBasicsParser.g:960:3: ( rule__Bool__Group__0 )
            {
             before(grammarAccess.getBoolAccess().getGroup()); 
            // InternalBasicsParser.g:961:3: ( rule__Bool__Group__0 )
            // InternalBasicsParser.g:961:4: rule__Bool__Group__0
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
    // InternalBasicsParser.g:970:1: entryRuleint8 : ruleint8 EOF ;
    public final void entryRuleint8() throws RecognitionException {
        try {
            // InternalBasicsParser.g:971:1: ( ruleint8 EOF )
            // InternalBasicsParser.g:972:1: ruleint8 EOF
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
    // InternalBasicsParser.g:979:1: ruleint8 : ( ( rule__Int8__Group__0 ) ) ;
    public final void ruleint8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:983:2: ( ( ( rule__Int8__Group__0 ) ) )
            // InternalBasicsParser.g:984:2: ( ( rule__Int8__Group__0 ) )
            {
            // InternalBasicsParser.g:984:2: ( ( rule__Int8__Group__0 ) )
            // InternalBasicsParser.g:985:3: ( rule__Int8__Group__0 )
            {
             before(grammarAccess.getInt8Access().getGroup()); 
            // InternalBasicsParser.g:986:3: ( rule__Int8__Group__0 )
            // InternalBasicsParser.g:986:4: rule__Int8__Group__0
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
    // InternalBasicsParser.g:995:1: entryRuleuint8 : ruleuint8 EOF ;
    public final void entryRuleuint8() throws RecognitionException {
        try {
            // InternalBasicsParser.g:996:1: ( ruleuint8 EOF )
            // InternalBasicsParser.g:997:1: ruleuint8 EOF
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
    // InternalBasicsParser.g:1004:1: ruleuint8 : ( ( rule__Uint8__Group__0 ) ) ;
    public final void ruleuint8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1008:2: ( ( ( rule__Uint8__Group__0 ) ) )
            // InternalBasicsParser.g:1009:2: ( ( rule__Uint8__Group__0 ) )
            {
            // InternalBasicsParser.g:1009:2: ( ( rule__Uint8__Group__0 ) )
            // InternalBasicsParser.g:1010:3: ( rule__Uint8__Group__0 )
            {
             before(grammarAccess.getUint8Access().getGroup()); 
            // InternalBasicsParser.g:1011:3: ( rule__Uint8__Group__0 )
            // InternalBasicsParser.g:1011:4: rule__Uint8__Group__0
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
    // InternalBasicsParser.g:1020:1: entryRuleint16 : ruleint16 EOF ;
    public final void entryRuleint16() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1021:1: ( ruleint16 EOF )
            // InternalBasicsParser.g:1022:1: ruleint16 EOF
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
    // InternalBasicsParser.g:1029:1: ruleint16 : ( ( rule__Int16__Group__0 ) ) ;
    public final void ruleint16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1033:2: ( ( ( rule__Int16__Group__0 ) ) )
            // InternalBasicsParser.g:1034:2: ( ( rule__Int16__Group__0 ) )
            {
            // InternalBasicsParser.g:1034:2: ( ( rule__Int16__Group__0 ) )
            // InternalBasicsParser.g:1035:3: ( rule__Int16__Group__0 )
            {
             before(grammarAccess.getInt16Access().getGroup()); 
            // InternalBasicsParser.g:1036:3: ( rule__Int16__Group__0 )
            // InternalBasicsParser.g:1036:4: rule__Int16__Group__0
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
    // InternalBasicsParser.g:1045:1: entryRuleuint16 : ruleuint16 EOF ;
    public final void entryRuleuint16() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1046:1: ( ruleuint16 EOF )
            // InternalBasicsParser.g:1047:1: ruleuint16 EOF
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
    // InternalBasicsParser.g:1054:1: ruleuint16 : ( ( rule__Uint16__Group__0 ) ) ;
    public final void ruleuint16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1058:2: ( ( ( rule__Uint16__Group__0 ) ) )
            // InternalBasicsParser.g:1059:2: ( ( rule__Uint16__Group__0 ) )
            {
            // InternalBasicsParser.g:1059:2: ( ( rule__Uint16__Group__0 ) )
            // InternalBasicsParser.g:1060:3: ( rule__Uint16__Group__0 )
            {
             before(grammarAccess.getUint16Access().getGroup()); 
            // InternalBasicsParser.g:1061:3: ( rule__Uint16__Group__0 )
            // InternalBasicsParser.g:1061:4: rule__Uint16__Group__0
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
    // InternalBasicsParser.g:1070:1: entryRuleint32 : ruleint32 EOF ;
    public final void entryRuleint32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1071:1: ( ruleint32 EOF )
            // InternalBasicsParser.g:1072:1: ruleint32 EOF
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
    // InternalBasicsParser.g:1079:1: ruleint32 : ( ( rule__Int32__Group__0 ) ) ;
    public final void ruleint32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1083:2: ( ( ( rule__Int32__Group__0 ) ) )
            // InternalBasicsParser.g:1084:2: ( ( rule__Int32__Group__0 ) )
            {
            // InternalBasicsParser.g:1084:2: ( ( rule__Int32__Group__0 ) )
            // InternalBasicsParser.g:1085:3: ( rule__Int32__Group__0 )
            {
             before(grammarAccess.getInt32Access().getGroup()); 
            // InternalBasicsParser.g:1086:3: ( rule__Int32__Group__0 )
            // InternalBasicsParser.g:1086:4: rule__Int32__Group__0
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
    // InternalBasicsParser.g:1095:1: entryRuleuint32 : ruleuint32 EOF ;
    public final void entryRuleuint32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1096:1: ( ruleuint32 EOF )
            // InternalBasicsParser.g:1097:1: ruleuint32 EOF
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
    // InternalBasicsParser.g:1104:1: ruleuint32 : ( ( rule__Uint32__Group__0 ) ) ;
    public final void ruleuint32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1108:2: ( ( ( rule__Uint32__Group__0 ) ) )
            // InternalBasicsParser.g:1109:2: ( ( rule__Uint32__Group__0 ) )
            {
            // InternalBasicsParser.g:1109:2: ( ( rule__Uint32__Group__0 ) )
            // InternalBasicsParser.g:1110:3: ( rule__Uint32__Group__0 )
            {
             before(grammarAccess.getUint32Access().getGroup()); 
            // InternalBasicsParser.g:1111:3: ( rule__Uint32__Group__0 )
            // InternalBasicsParser.g:1111:4: rule__Uint32__Group__0
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
    // InternalBasicsParser.g:1120:1: entryRuleint64 : ruleint64 EOF ;
    public final void entryRuleint64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1121:1: ( ruleint64 EOF )
            // InternalBasicsParser.g:1122:1: ruleint64 EOF
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
    // InternalBasicsParser.g:1129:1: ruleint64 : ( ( rule__Int64__Group__0 ) ) ;
    public final void ruleint64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1133:2: ( ( ( rule__Int64__Group__0 ) ) )
            // InternalBasicsParser.g:1134:2: ( ( rule__Int64__Group__0 ) )
            {
            // InternalBasicsParser.g:1134:2: ( ( rule__Int64__Group__0 ) )
            // InternalBasicsParser.g:1135:3: ( rule__Int64__Group__0 )
            {
             before(grammarAccess.getInt64Access().getGroup()); 
            // InternalBasicsParser.g:1136:3: ( rule__Int64__Group__0 )
            // InternalBasicsParser.g:1136:4: rule__Int64__Group__0
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
    // InternalBasicsParser.g:1145:1: entryRuleuint64 : ruleuint64 EOF ;
    public final void entryRuleuint64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1146:1: ( ruleuint64 EOF )
            // InternalBasicsParser.g:1147:1: ruleuint64 EOF
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
    // InternalBasicsParser.g:1154:1: ruleuint64 : ( ( rule__Uint64__Group__0 ) ) ;
    public final void ruleuint64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1158:2: ( ( ( rule__Uint64__Group__0 ) ) )
            // InternalBasicsParser.g:1159:2: ( ( rule__Uint64__Group__0 ) )
            {
            // InternalBasicsParser.g:1159:2: ( ( rule__Uint64__Group__0 ) )
            // InternalBasicsParser.g:1160:3: ( rule__Uint64__Group__0 )
            {
             before(grammarAccess.getUint64Access().getGroup()); 
            // InternalBasicsParser.g:1161:3: ( rule__Uint64__Group__0 )
            // InternalBasicsParser.g:1161:4: rule__Uint64__Group__0
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
    // InternalBasicsParser.g:1170:1: entryRulefloat32 : rulefloat32 EOF ;
    public final void entryRulefloat32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1171:1: ( rulefloat32 EOF )
            // InternalBasicsParser.g:1172:1: rulefloat32 EOF
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
    // InternalBasicsParser.g:1179:1: rulefloat32 : ( ( rule__Float32__Group__0 ) ) ;
    public final void rulefloat32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1183:2: ( ( ( rule__Float32__Group__0 ) ) )
            // InternalBasicsParser.g:1184:2: ( ( rule__Float32__Group__0 ) )
            {
            // InternalBasicsParser.g:1184:2: ( ( rule__Float32__Group__0 ) )
            // InternalBasicsParser.g:1185:3: ( rule__Float32__Group__0 )
            {
             before(grammarAccess.getFloat32Access().getGroup()); 
            // InternalBasicsParser.g:1186:3: ( rule__Float32__Group__0 )
            // InternalBasicsParser.g:1186:4: rule__Float32__Group__0
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
    // InternalBasicsParser.g:1195:1: entryRulefloat64 : rulefloat64 EOF ;
    public final void entryRulefloat64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1196:1: ( rulefloat64 EOF )
            // InternalBasicsParser.g:1197:1: rulefloat64 EOF
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
    // InternalBasicsParser.g:1204:1: rulefloat64 : ( ( rule__Float64__Group__0 ) ) ;
    public final void rulefloat64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1208:2: ( ( ( rule__Float64__Group__0 ) ) )
            // InternalBasicsParser.g:1209:2: ( ( rule__Float64__Group__0 ) )
            {
            // InternalBasicsParser.g:1209:2: ( ( rule__Float64__Group__0 ) )
            // InternalBasicsParser.g:1210:3: ( rule__Float64__Group__0 )
            {
             before(grammarAccess.getFloat64Access().getGroup()); 
            // InternalBasicsParser.g:1211:3: ( rule__Float64__Group__0 )
            // InternalBasicsParser.g:1211:4: rule__Float64__Group__0
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
    // InternalBasicsParser.g:1220:1: entryRulestring0 : rulestring0 EOF ;
    public final void entryRulestring0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1221:1: ( rulestring0 EOF )
            // InternalBasicsParser.g:1222:1: rulestring0 EOF
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
    // InternalBasicsParser.g:1229:1: rulestring0 : ( ( rule__String0__Group__0 ) ) ;
    public final void rulestring0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1233:2: ( ( ( rule__String0__Group__0 ) ) )
            // InternalBasicsParser.g:1234:2: ( ( rule__String0__Group__0 ) )
            {
            // InternalBasicsParser.g:1234:2: ( ( rule__String0__Group__0 ) )
            // InternalBasicsParser.g:1235:3: ( rule__String0__Group__0 )
            {
             before(grammarAccess.getString0Access().getGroup()); 
            // InternalBasicsParser.g:1236:3: ( rule__String0__Group__0 )
            // InternalBasicsParser.g:1236:4: rule__String0__Group__0
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
    // InternalBasicsParser.g:1245:1: entryRulechar : rulechar EOF ;
    public final void entryRulechar() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1246:1: ( rulechar EOF )
            // InternalBasicsParser.g:1247:1: rulechar EOF
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
    // InternalBasicsParser.g:1254:1: rulechar : ( ( rule__Char__Group__0 ) ) ;
    public final void rulechar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1258:2: ( ( ( rule__Char__Group__0 ) ) )
            // InternalBasicsParser.g:1259:2: ( ( rule__Char__Group__0 ) )
            {
            // InternalBasicsParser.g:1259:2: ( ( rule__Char__Group__0 ) )
            // InternalBasicsParser.g:1260:3: ( rule__Char__Group__0 )
            {
             before(grammarAccess.getCharAccess().getGroup()); 
            // InternalBasicsParser.g:1261:3: ( rule__Char__Group__0 )
            // InternalBasicsParser.g:1261:4: rule__Char__Group__0
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
    // InternalBasicsParser.g:1270:1: entryRulebyte : rulebyte EOF ;
    public final void entryRulebyte() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1271:1: ( rulebyte EOF )
            // InternalBasicsParser.g:1272:1: rulebyte EOF
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
    // InternalBasicsParser.g:1279:1: rulebyte : ( ( rule__Byte__Group__0 ) ) ;
    public final void rulebyte() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1283:2: ( ( ( rule__Byte__Group__0 ) ) )
            // InternalBasicsParser.g:1284:2: ( ( rule__Byte__Group__0 ) )
            {
            // InternalBasicsParser.g:1284:2: ( ( rule__Byte__Group__0 ) )
            // InternalBasicsParser.g:1285:3: ( rule__Byte__Group__0 )
            {
             before(grammarAccess.getByteAccess().getGroup()); 
            // InternalBasicsParser.g:1286:3: ( rule__Byte__Group__0 )
            // InternalBasicsParser.g:1286:4: rule__Byte__Group__0
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
    // InternalBasicsParser.g:1295:1: entryRuletime : ruletime EOF ;
    public final void entryRuletime() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1296:1: ( ruletime EOF )
            // InternalBasicsParser.g:1297:1: ruletime EOF
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
    // InternalBasicsParser.g:1304:1: ruletime : ( ( rule__Time__Group__0 ) ) ;
    public final void ruletime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1308:2: ( ( ( rule__Time__Group__0 ) ) )
            // InternalBasicsParser.g:1309:2: ( ( rule__Time__Group__0 ) )
            {
            // InternalBasicsParser.g:1309:2: ( ( rule__Time__Group__0 ) )
            // InternalBasicsParser.g:1310:3: ( rule__Time__Group__0 )
            {
             before(grammarAccess.getTimeAccess().getGroup()); 
            // InternalBasicsParser.g:1311:3: ( rule__Time__Group__0 )
            // InternalBasicsParser.g:1311:4: rule__Time__Group__0
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
    // InternalBasicsParser.g:1320:1: entryRuleduration : ruleduration EOF ;
    public final void entryRuleduration() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1321:1: ( ruleduration EOF )
            // InternalBasicsParser.g:1322:1: ruleduration EOF
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
    // InternalBasicsParser.g:1329:1: ruleduration : ( ( rule__Duration__Group__0 ) ) ;
    public final void ruleduration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1333:2: ( ( ( rule__Duration__Group__0 ) ) )
            // InternalBasicsParser.g:1334:2: ( ( rule__Duration__Group__0 ) )
            {
            // InternalBasicsParser.g:1334:2: ( ( rule__Duration__Group__0 ) )
            // InternalBasicsParser.g:1335:3: ( rule__Duration__Group__0 )
            {
             before(grammarAccess.getDurationAccess().getGroup()); 
            // InternalBasicsParser.g:1336:3: ( rule__Duration__Group__0 )
            // InternalBasicsParser.g:1336:4: rule__Duration__Group__0
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
    // InternalBasicsParser.g:1345:1: entryRuleboolArray : ruleboolArray EOF ;
    public final void entryRuleboolArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1346:1: ( ruleboolArray EOF )
            // InternalBasicsParser.g:1347:1: ruleboolArray EOF
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
    // InternalBasicsParser.g:1354:1: ruleboolArray : ( ( rule__BoolArray__Group__0 ) ) ;
    public final void ruleboolArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1358:2: ( ( ( rule__BoolArray__Group__0 ) ) )
            // InternalBasicsParser.g:1359:2: ( ( rule__BoolArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1359:2: ( ( rule__BoolArray__Group__0 ) )
            // InternalBasicsParser.g:1360:3: ( rule__BoolArray__Group__0 )
            {
             before(grammarAccess.getBoolArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1361:3: ( rule__BoolArray__Group__0 )
            // InternalBasicsParser.g:1361:4: rule__BoolArray__Group__0
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
    // InternalBasicsParser.g:1370:1: entryRuleint8Array : ruleint8Array EOF ;
    public final void entryRuleint8Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1371:1: ( ruleint8Array EOF )
            // InternalBasicsParser.g:1372:1: ruleint8Array EOF
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
    // InternalBasicsParser.g:1379:1: ruleint8Array : ( ( rule__Int8Array__Group__0 ) ) ;
    public final void ruleint8Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1383:2: ( ( ( rule__Int8Array__Group__0 ) ) )
            // InternalBasicsParser.g:1384:2: ( ( rule__Int8Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1384:2: ( ( rule__Int8Array__Group__0 ) )
            // InternalBasicsParser.g:1385:3: ( rule__Int8Array__Group__0 )
            {
             before(grammarAccess.getInt8ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1386:3: ( rule__Int8Array__Group__0 )
            // InternalBasicsParser.g:1386:4: rule__Int8Array__Group__0
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
    // InternalBasicsParser.g:1395:1: entryRuleuint8Array : ruleuint8Array EOF ;
    public final void entryRuleuint8Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1396:1: ( ruleuint8Array EOF )
            // InternalBasicsParser.g:1397:1: ruleuint8Array EOF
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
    // InternalBasicsParser.g:1404:1: ruleuint8Array : ( ( rule__Uint8Array__Group__0 ) ) ;
    public final void ruleuint8Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1408:2: ( ( ( rule__Uint8Array__Group__0 ) ) )
            // InternalBasicsParser.g:1409:2: ( ( rule__Uint8Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1409:2: ( ( rule__Uint8Array__Group__0 ) )
            // InternalBasicsParser.g:1410:3: ( rule__Uint8Array__Group__0 )
            {
             before(grammarAccess.getUint8ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1411:3: ( rule__Uint8Array__Group__0 )
            // InternalBasicsParser.g:1411:4: rule__Uint8Array__Group__0
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
    // InternalBasicsParser.g:1420:1: entryRuleint16Array : ruleint16Array EOF ;
    public final void entryRuleint16Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1421:1: ( ruleint16Array EOF )
            // InternalBasicsParser.g:1422:1: ruleint16Array EOF
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
    // InternalBasicsParser.g:1429:1: ruleint16Array : ( ( rule__Int16Array__Group__0 ) ) ;
    public final void ruleint16Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1433:2: ( ( ( rule__Int16Array__Group__0 ) ) )
            // InternalBasicsParser.g:1434:2: ( ( rule__Int16Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1434:2: ( ( rule__Int16Array__Group__0 ) )
            // InternalBasicsParser.g:1435:3: ( rule__Int16Array__Group__0 )
            {
             before(grammarAccess.getInt16ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1436:3: ( rule__Int16Array__Group__0 )
            // InternalBasicsParser.g:1436:4: rule__Int16Array__Group__0
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
    // InternalBasicsParser.g:1445:1: entryRuleuint16Array : ruleuint16Array EOF ;
    public final void entryRuleuint16Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1446:1: ( ruleuint16Array EOF )
            // InternalBasicsParser.g:1447:1: ruleuint16Array EOF
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
    // InternalBasicsParser.g:1454:1: ruleuint16Array : ( ( rule__Uint16Array__Group__0 ) ) ;
    public final void ruleuint16Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1458:2: ( ( ( rule__Uint16Array__Group__0 ) ) )
            // InternalBasicsParser.g:1459:2: ( ( rule__Uint16Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1459:2: ( ( rule__Uint16Array__Group__0 ) )
            // InternalBasicsParser.g:1460:3: ( rule__Uint16Array__Group__0 )
            {
             before(grammarAccess.getUint16ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1461:3: ( rule__Uint16Array__Group__0 )
            // InternalBasicsParser.g:1461:4: rule__Uint16Array__Group__0
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
    // InternalBasicsParser.g:1470:1: entryRuleint32Array : ruleint32Array EOF ;
    public final void entryRuleint32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1471:1: ( ruleint32Array EOF )
            // InternalBasicsParser.g:1472:1: ruleint32Array EOF
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
    // InternalBasicsParser.g:1479:1: ruleint32Array : ( ( rule__Int32Array__Group__0 ) ) ;
    public final void ruleint32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1483:2: ( ( ( rule__Int32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1484:2: ( ( rule__Int32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1484:2: ( ( rule__Int32Array__Group__0 ) )
            // InternalBasicsParser.g:1485:3: ( rule__Int32Array__Group__0 )
            {
             before(grammarAccess.getInt32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1486:3: ( rule__Int32Array__Group__0 )
            // InternalBasicsParser.g:1486:4: rule__Int32Array__Group__0
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
    // InternalBasicsParser.g:1495:1: entryRuleuint32Array : ruleuint32Array EOF ;
    public final void entryRuleuint32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1496:1: ( ruleuint32Array EOF )
            // InternalBasicsParser.g:1497:1: ruleuint32Array EOF
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
    // InternalBasicsParser.g:1504:1: ruleuint32Array : ( ( rule__Uint32Array__Group__0 ) ) ;
    public final void ruleuint32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1508:2: ( ( ( rule__Uint32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1509:2: ( ( rule__Uint32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1509:2: ( ( rule__Uint32Array__Group__0 ) )
            // InternalBasicsParser.g:1510:3: ( rule__Uint32Array__Group__0 )
            {
             before(grammarAccess.getUint32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1511:3: ( rule__Uint32Array__Group__0 )
            // InternalBasicsParser.g:1511:4: rule__Uint32Array__Group__0
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
    // InternalBasicsParser.g:1520:1: entryRuleint64Array : ruleint64Array EOF ;
    public final void entryRuleint64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1521:1: ( ruleint64Array EOF )
            // InternalBasicsParser.g:1522:1: ruleint64Array EOF
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
    // InternalBasicsParser.g:1529:1: ruleint64Array : ( ( rule__Int64Array__Group__0 ) ) ;
    public final void ruleint64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1533:2: ( ( ( rule__Int64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1534:2: ( ( rule__Int64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1534:2: ( ( rule__Int64Array__Group__0 ) )
            // InternalBasicsParser.g:1535:3: ( rule__Int64Array__Group__0 )
            {
             before(grammarAccess.getInt64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1536:3: ( rule__Int64Array__Group__0 )
            // InternalBasicsParser.g:1536:4: rule__Int64Array__Group__0
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
    // InternalBasicsParser.g:1545:1: entryRuleuint64Array : ruleuint64Array EOF ;
    public final void entryRuleuint64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1546:1: ( ruleuint64Array EOF )
            // InternalBasicsParser.g:1547:1: ruleuint64Array EOF
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
    // InternalBasicsParser.g:1554:1: ruleuint64Array : ( ( rule__Uint64Array__Group__0 ) ) ;
    public final void ruleuint64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1558:2: ( ( ( rule__Uint64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1559:2: ( ( rule__Uint64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1559:2: ( ( rule__Uint64Array__Group__0 ) )
            // InternalBasicsParser.g:1560:3: ( rule__Uint64Array__Group__0 )
            {
             before(grammarAccess.getUint64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1561:3: ( rule__Uint64Array__Group__0 )
            // InternalBasicsParser.g:1561:4: rule__Uint64Array__Group__0
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
    // InternalBasicsParser.g:1570:1: entryRulefloat32Array : rulefloat32Array EOF ;
    public final void entryRulefloat32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1571:1: ( rulefloat32Array EOF )
            // InternalBasicsParser.g:1572:1: rulefloat32Array EOF
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
    // InternalBasicsParser.g:1579:1: rulefloat32Array : ( ( rule__Float32Array__Group__0 ) ) ;
    public final void rulefloat32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1583:2: ( ( ( rule__Float32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1584:2: ( ( rule__Float32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1584:2: ( ( rule__Float32Array__Group__0 ) )
            // InternalBasicsParser.g:1585:3: ( rule__Float32Array__Group__0 )
            {
             before(grammarAccess.getFloat32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1586:3: ( rule__Float32Array__Group__0 )
            // InternalBasicsParser.g:1586:4: rule__Float32Array__Group__0
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
    // InternalBasicsParser.g:1595:1: entryRulefloat64Array : rulefloat64Array EOF ;
    public final void entryRulefloat64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1596:1: ( rulefloat64Array EOF )
            // InternalBasicsParser.g:1597:1: rulefloat64Array EOF
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
    // InternalBasicsParser.g:1604:1: rulefloat64Array : ( ( rule__Float64Array__Group__0 ) ) ;
    public final void rulefloat64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1608:2: ( ( ( rule__Float64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1609:2: ( ( rule__Float64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1609:2: ( ( rule__Float64Array__Group__0 ) )
            // InternalBasicsParser.g:1610:3: ( rule__Float64Array__Group__0 )
            {
             before(grammarAccess.getFloat64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1611:3: ( rule__Float64Array__Group__0 )
            // InternalBasicsParser.g:1611:4: rule__Float64Array__Group__0
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
    // InternalBasicsParser.g:1620:1: entryRulestring0Array : rulestring0Array EOF ;
    public final void entryRulestring0Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1621:1: ( rulestring0Array EOF )
            // InternalBasicsParser.g:1622:1: rulestring0Array EOF
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
    // InternalBasicsParser.g:1629:1: rulestring0Array : ( ( rule__String0Array__Group__0 ) ) ;
    public final void rulestring0Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1633:2: ( ( ( rule__String0Array__Group__0 ) ) )
            // InternalBasicsParser.g:1634:2: ( ( rule__String0Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1634:2: ( ( rule__String0Array__Group__0 ) )
            // InternalBasicsParser.g:1635:3: ( rule__String0Array__Group__0 )
            {
             before(grammarAccess.getString0ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1636:3: ( rule__String0Array__Group__0 )
            // InternalBasicsParser.g:1636:4: rule__String0Array__Group__0
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
    // InternalBasicsParser.g:1645:1: entryRulebyteArray : rulebyteArray EOF ;
    public final void entryRulebyteArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1646:1: ( rulebyteArray EOF )
            // InternalBasicsParser.g:1647:1: rulebyteArray EOF
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
    // InternalBasicsParser.g:1654:1: rulebyteArray : ( ( rule__ByteArray__Group__0 ) ) ;
    public final void rulebyteArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1658:2: ( ( ( rule__ByteArray__Group__0 ) ) )
            // InternalBasicsParser.g:1659:2: ( ( rule__ByteArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1659:2: ( ( rule__ByteArray__Group__0 ) )
            // InternalBasicsParser.g:1660:3: ( rule__ByteArray__Group__0 )
            {
             before(grammarAccess.getByteArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1661:3: ( rule__ByteArray__Group__0 )
            // InternalBasicsParser.g:1661:4: rule__ByteArray__Group__0
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
    // InternalBasicsParser.g:1670:1: entryRulecharArray : rulecharArray EOF ;
    public final void entryRulecharArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1671:1: ( rulecharArray EOF )
            // InternalBasicsParser.g:1672:1: rulecharArray EOF
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
    // InternalBasicsParser.g:1679:1: rulecharArray : ( ( rule__CharArray__Group__0 ) ) ;
    public final void rulecharArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1683:2: ( ( ( rule__CharArray__Group__0 ) ) )
            // InternalBasicsParser.g:1684:2: ( ( rule__CharArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1684:2: ( ( rule__CharArray__Group__0 ) )
            // InternalBasicsParser.g:1685:3: ( rule__CharArray__Group__0 )
            {
             before(grammarAccess.getCharArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1686:3: ( rule__CharArray__Group__0 )
            // InternalBasicsParser.g:1686:4: rule__CharArray__Group__0
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
    // InternalBasicsParser.g:1695:1: entryRuleHeader : ruleHeader EOF ;
    public final void entryRuleHeader() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1696:1: ( ruleHeader EOF )
            // InternalBasicsParser.g:1697:1: ruleHeader EOF
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
    // InternalBasicsParser.g:1704:1: ruleHeader : ( ( rule__Header__Group__0 ) ) ;
    public final void ruleHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1708:2: ( ( ( rule__Header__Group__0 ) ) )
            // InternalBasicsParser.g:1709:2: ( ( rule__Header__Group__0 ) )
            {
            // InternalBasicsParser.g:1709:2: ( ( rule__Header__Group__0 ) )
            // InternalBasicsParser.g:1710:3: ( rule__Header__Group__0 )
            {
             before(grammarAccess.getHeaderAccess().getGroup()); 
            // InternalBasicsParser.g:1711:3: ( rule__Header__Group__0 )
            // InternalBasicsParser.g:1711:4: rule__Header__Group__0
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
    // InternalBasicsParser.g:1720:1: entryRuleSpecBaseRef : ruleSpecBaseRef EOF ;
    public final void entryRuleSpecBaseRef() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1721:1: ( ruleSpecBaseRef EOF )
            // InternalBasicsParser.g:1722:1: ruleSpecBaseRef EOF
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
    // InternalBasicsParser.g:1729:1: ruleSpecBaseRef : ( ( rule__SpecBaseRef__ReferenceAssignment ) ) ;
    public final void ruleSpecBaseRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1733:2: ( ( ( rule__SpecBaseRef__ReferenceAssignment ) ) )
            // InternalBasicsParser.g:1734:2: ( ( rule__SpecBaseRef__ReferenceAssignment ) )
            {
            // InternalBasicsParser.g:1734:2: ( ( rule__SpecBaseRef__ReferenceAssignment ) )
            // InternalBasicsParser.g:1735:3: ( rule__SpecBaseRef__ReferenceAssignment )
            {
             before(grammarAccess.getSpecBaseRefAccess().getReferenceAssignment()); 
            // InternalBasicsParser.g:1736:3: ( rule__SpecBaseRef__ReferenceAssignment )
            // InternalBasicsParser.g:1736:4: rule__SpecBaseRef__ReferenceAssignment
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
    // InternalBasicsParser.g:1745:1: entryRuleArraySpecRef : ruleArraySpecRef EOF ;
    public final void entryRuleArraySpecRef() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1746:1: ( ruleArraySpecRef EOF )
            // InternalBasicsParser.g:1747:1: ruleArraySpecRef EOF
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
    // InternalBasicsParser.g:1754:1: ruleArraySpecRef : ( ( rule__ArraySpecRef__Group__0 ) ) ;
    public final void ruleArraySpecRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1758:2: ( ( ( rule__ArraySpecRef__Group__0 ) ) )
            // InternalBasicsParser.g:1759:2: ( ( rule__ArraySpecRef__Group__0 ) )
            {
            // InternalBasicsParser.g:1759:2: ( ( rule__ArraySpecRef__Group__0 ) )
            // InternalBasicsParser.g:1760:3: ( rule__ArraySpecRef__Group__0 )
            {
             before(grammarAccess.getArraySpecRefAccess().getGroup()); 
            // InternalBasicsParser.g:1761:3: ( rule__ArraySpecRef__Group__0 )
            // InternalBasicsParser.g:1761:4: rule__ArraySpecRef__Group__0
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
    // InternalBasicsParser.g:1770:1: entryRuleKEYWORD : ruleKEYWORD EOF ;
    public final void entryRuleKEYWORD() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1771:1: ( ruleKEYWORD EOF )
            // InternalBasicsParser.g:1772:1: ruleKEYWORD EOF
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
    // InternalBasicsParser.g:1779:1: ruleKEYWORD : ( ( rule__KEYWORD__Alternatives ) ) ;
    public final void ruleKEYWORD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1783:2: ( ( ( rule__KEYWORD__Alternatives ) ) )
            // InternalBasicsParser.g:1784:2: ( ( rule__KEYWORD__Alternatives ) )
            {
            // InternalBasicsParser.g:1784:2: ( ( rule__KEYWORD__Alternatives ) )
            // InternalBasicsParser.g:1785:3: ( rule__KEYWORD__Alternatives )
            {
             before(grammarAccess.getKEYWORDAccess().getAlternatives()); 
            // InternalBasicsParser.g:1786:3: ( rule__KEYWORD__Alternatives )
            // InternalBasicsParser.g:1786:4: rule__KEYWORD__Alternatives
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
    // InternalBasicsParser.g:1795:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1796:1: ( ruleEString EOF )
            // InternalBasicsParser.g:1797:1: ruleEString EOF
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
    // InternalBasicsParser.g:1804:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1808:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalBasicsParser.g:1809:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalBasicsParser.g:1809:2: ( ( rule__EString__Alternatives ) )
            // InternalBasicsParser.g:1810:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalBasicsParser.g:1811:3: ( rule__EString__Alternatives )
            // InternalBasicsParser.g:1811:4: rule__EString__Alternatives
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


    // $ANTLR start "entryRuleAddedKeywordName"
    // InternalBasicsParser.g:1820:1: entryRuleAddedKeywordName : ruleAddedKeywordName EOF ;
    public final void entryRuleAddedKeywordName() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1821:1: ( ruleAddedKeywordName EOF )
            // InternalBasicsParser.g:1822:1: ruleAddedKeywordName EOF
            {
             before(grammarAccess.getAddedKeywordNameRule()); 
            pushFollow(FOLLOW_1);
            ruleAddedKeywordName();

            state._fsp--;

             after(grammarAccess.getAddedKeywordNameRule()); 
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
    // $ANTLR end "entryRuleAddedKeywordName"


    // $ANTLR start "ruleAddedKeywordName"
    // InternalBasicsParser.g:1829:1: ruleAddedKeywordName : ( ( rule__AddedKeywordName__Alternatives ) ) ;
    public final void ruleAddedKeywordName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1833:2: ( ( ( rule__AddedKeywordName__Alternatives ) ) )
            // InternalBasicsParser.g:1834:2: ( ( rule__AddedKeywordName__Alternatives ) )
            {
            // InternalBasicsParser.g:1834:2: ( ( rule__AddedKeywordName__Alternatives ) )
            // InternalBasicsParser.g:1835:3: ( rule__AddedKeywordName__Alternatives )
            {
             before(grammarAccess.getAddedKeywordNameAccess().getAlternatives()); 
            // InternalBasicsParser.g:1836:3: ( rule__AddedKeywordName__Alternatives )
            // InternalBasicsParser.g:1836:4: rule__AddedKeywordName__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AddedKeywordName__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAddedKeywordNameAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddedKeywordName"


    // $ANTLR start "entryRuleExtensionBlockName"
    // InternalBasicsParser.g:1845:1: entryRuleExtensionBlockName : ruleExtensionBlockName EOF ;
    public final void entryRuleExtensionBlockName() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1846:1: ( ruleExtensionBlockName EOF )
            // InternalBasicsParser.g:1847:1: ruleExtensionBlockName EOF
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
    // InternalBasicsParser.g:1854:1: ruleExtensionBlockName : ( ( rule__ExtensionBlockName__Group__0 ) ) ;
    public final void ruleExtensionBlockName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1858:2: ( ( ( rule__ExtensionBlockName__Group__0 ) ) )
            // InternalBasicsParser.g:1859:2: ( ( rule__ExtensionBlockName__Group__0 ) )
            {
            // InternalBasicsParser.g:1859:2: ( ( rule__ExtensionBlockName__Group__0 ) )
            // InternalBasicsParser.g:1860:3: ( rule__ExtensionBlockName__Group__0 )
            {
             before(grammarAccess.getExtensionBlockNameAccess().getGroup()); 
            // InternalBasicsParser.g:1861:3: ( rule__ExtensionBlockName__Group__0 )
            // InternalBasicsParser.g:1861:4: rule__ExtensionBlockName__Group__0
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
    // InternalBasicsParser.g:1870:1: entryRuleExtensionEntry : ruleExtensionEntry EOF ;
    public final void entryRuleExtensionEntry() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1871:1: ( ruleExtensionEntry EOF )
            // InternalBasicsParser.g:1872:1: ruleExtensionEntry EOF
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
    // InternalBasicsParser.g:1879:1: ruleExtensionEntry : ( ( rule__ExtensionEntry__Group__0 ) ) ;
    public final void ruleExtensionEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1883:2: ( ( ( rule__ExtensionEntry__Group__0 ) ) )
            // InternalBasicsParser.g:1884:2: ( ( rule__ExtensionEntry__Group__0 ) )
            {
            // InternalBasicsParser.g:1884:2: ( ( rule__ExtensionEntry__Group__0 ) )
            // InternalBasicsParser.g:1885:3: ( rule__ExtensionEntry__Group__0 )
            {
             before(grammarAccess.getExtensionEntryAccess().getGroup()); 
            // InternalBasicsParser.g:1886:3: ( rule__ExtensionEntry__Group__0 )
            // InternalBasicsParser.g:1886:4: rule__ExtensionEntry__Group__0
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
    // InternalBasicsParser.g:1895:1: entryRuleExtensionKey : ruleExtensionKey EOF ;
    public final void entryRuleExtensionKey() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1896:1: ( ruleExtensionKey EOF )
            // InternalBasicsParser.g:1897:1: ruleExtensionKey EOF
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
    // InternalBasicsParser.g:1904:1: ruleExtensionKey : ( ( rule__ExtensionKey__Alternatives ) ) ;
    public final void ruleExtensionKey() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1908:2: ( ( ( rule__ExtensionKey__Alternatives ) ) )
            // InternalBasicsParser.g:1909:2: ( ( rule__ExtensionKey__Alternatives ) )
            {
            // InternalBasicsParser.g:1909:2: ( ( rule__ExtensionKey__Alternatives ) )
            // InternalBasicsParser.g:1910:3: ( rule__ExtensionKey__Alternatives )
            {
             before(grammarAccess.getExtensionKeyAccess().getAlternatives()); 
            // InternalBasicsParser.g:1911:3: ( rule__ExtensionKey__Alternatives )
            // InternalBasicsParser.g:1911:4: rule__ExtensionKey__Alternatives
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
    // InternalBasicsParser.g:1920:1: entryRuleExtensionColonKey : ruleExtensionColonKey EOF ;
    public final void entryRuleExtensionColonKey() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1921:1: ( ruleExtensionColonKey EOF )
            // InternalBasicsParser.g:1922:1: ruleExtensionColonKey EOF
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
    // InternalBasicsParser.g:1929:1: ruleExtensionColonKey : ( ( rule__ExtensionColonKey__Alternatives ) ) ;
    public final void ruleExtensionColonKey() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1933:2: ( ( ( rule__ExtensionColonKey__Alternatives ) ) )
            // InternalBasicsParser.g:1934:2: ( ( rule__ExtensionColonKey__Alternatives ) )
            {
            // InternalBasicsParser.g:1934:2: ( ( rule__ExtensionColonKey__Alternatives ) )
            // InternalBasicsParser.g:1935:3: ( rule__ExtensionColonKey__Alternatives )
            {
             before(grammarAccess.getExtensionColonKeyAccess().getAlternatives()); 
            // InternalBasicsParser.g:1936:3: ( rule__ExtensionColonKey__Alternatives )
            // InternalBasicsParser.g:1936:4: rule__ExtensionColonKey__Alternatives
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
    // InternalBasicsParser.g:1945:1: entryRuleExtensionValue : ruleExtensionValue EOF ;
    public final void entryRuleExtensionValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1946:1: ( ruleExtensionValue EOF )
            // InternalBasicsParser.g:1947:1: ruleExtensionValue EOF
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
    // InternalBasicsParser.g:1954:1: ruleExtensionValue : ( ( rule__ExtensionValue__Alternatives ) ) ;
    public final void ruleExtensionValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1958:2: ( ( ( rule__ExtensionValue__Alternatives ) ) )
            // InternalBasicsParser.g:1959:2: ( ( rule__ExtensionValue__Alternatives ) )
            {
            // InternalBasicsParser.g:1959:2: ( ( rule__ExtensionValue__Alternatives ) )
            // InternalBasicsParser.g:1960:3: ( rule__ExtensionValue__Alternatives )
            {
             before(grammarAccess.getExtensionValueAccess().getAlternatives()); 
            // InternalBasicsParser.g:1961:3: ( rule__ExtensionValue__Alternatives )
            // InternalBasicsParser.g:1961:4: rule__ExtensionValue__Alternatives
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
    // InternalBasicsParser.g:1970:1: entryRuleExtensionListValue : ruleExtensionListValue EOF ;
    public final void entryRuleExtensionListValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1971:1: ( ruleExtensionListValue EOF )
            // InternalBasicsParser.g:1972:1: ruleExtensionListValue EOF
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
    // InternalBasicsParser.g:1979:1: ruleExtensionListValue : ( ( rule__ExtensionListValue__Group__0 ) ) ;
    public final void ruleExtensionListValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1983:2: ( ( ( rule__ExtensionListValue__Group__0 ) ) )
            // InternalBasicsParser.g:1984:2: ( ( rule__ExtensionListValue__Group__0 ) )
            {
            // InternalBasicsParser.g:1984:2: ( ( rule__ExtensionListValue__Group__0 ) )
            // InternalBasicsParser.g:1985:3: ( rule__ExtensionListValue__Group__0 )
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup()); 
            // InternalBasicsParser.g:1986:3: ( rule__ExtensionListValue__Group__0 )
            // InternalBasicsParser.g:1986:4: rule__ExtensionListValue__Group__0
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
    // InternalBasicsParser.g:1995:1: entryRuleExtensionBraceMapValue : ruleExtensionBraceMapValue EOF ;
    public final void entryRuleExtensionBraceMapValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1996:1: ( ruleExtensionBraceMapValue EOF )
            // InternalBasicsParser.g:1997:1: ruleExtensionBraceMapValue EOF
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
    // InternalBasicsParser.g:2004:1: ruleExtensionBraceMapValue : ( ( rule__ExtensionBraceMapValue__Group__0 ) ) ;
    public final void ruleExtensionBraceMapValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2008:2: ( ( ( rule__ExtensionBraceMapValue__Group__0 ) ) )
            // InternalBasicsParser.g:2009:2: ( ( rule__ExtensionBraceMapValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2009:2: ( ( rule__ExtensionBraceMapValue__Group__0 ) )
            // InternalBasicsParser.g:2010:3: ( rule__ExtensionBraceMapValue__Group__0 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup()); 
            // InternalBasicsParser.g:2011:3: ( rule__ExtensionBraceMapValue__Group__0 )
            // InternalBasicsParser.g:2011:4: rule__ExtensionBraceMapValue__Group__0
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
    // InternalBasicsParser.g:2020:1: entryRuleExtensionIndentedMapValue : ruleExtensionIndentedMapValue EOF ;
    public final void entryRuleExtensionIndentedMapValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2021:1: ( ruleExtensionIndentedMapValue EOF )
            // InternalBasicsParser.g:2022:1: ruleExtensionIndentedMapValue EOF
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
    // InternalBasicsParser.g:2029:1: ruleExtensionIndentedMapValue : ( ( rule__ExtensionIndentedMapValue__Group__0 ) ) ;
    public final void ruleExtensionIndentedMapValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2033:2: ( ( ( rule__ExtensionIndentedMapValue__Group__0 ) ) )
            // InternalBasicsParser.g:2034:2: ( ( rule__ExtensionIndentedMapValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2034:2: ( ( rule__ExtensionIndentedMapValue__Group__0 ) )
            // InternalBasicsParser.g:2035:3: ( rule__ExtensionIndentedMapValue__Group__0 )
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getGroup()); 
            // InternalBasicsParser.g:2036:3: ( rule__ExtensionIndentedMapValue__Group__0 )
            // InternalBasicsParser.g:2036:4: rule__ExtensionIndentedMapValue__Group__0
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
    // InternalBasicsParser.g:2045:1: entryRuleExtensionRefValue : ruleExtensionRefValue EOF ;
    public final void entryRuleExtensionRefValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2046:1: ( ruleExtensionRefValue EOF )
            // InternalBasicsParser.g:2047:1: ruleExtensionRefValue EOF
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
    // InternalBasicsParser.g:2054:1: ruleExtensionRefValue : ( ( rule__ExtensionRefValue__Group__0 ) ) ;
    public final void ruleExtensionRefValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2058:2: ( ( ( rule__ExtensionRefValue__Group__0 ) ) )
            // InternalBasicsParser.g:2059:2: ( ( rule__ExtensionRefValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2059:2: ( ( rule__ExtensionRefValue__Group__0 ) )
            // InternalBasicsParser.g:2060:3: ( rule__ExtensionRefValue__Group__0 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getGroup()); 
            // InternalBasicsParser.g:2061:3: ( rule__ExtensionRefValue__Group__0 )
            // InternalBasicsParser.g:2061:4: rule__ExtensionRefValue__Group__0
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
    // InternalBasicsParser.g:2070:1: entryRuleExtensionScalarValue : ruleExtensionScalarValue EOF ;
    public final void entryRuleExtensionScalarValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2071:1: ( ruleExtensionScalarValue EOF )
            // InternalBasicsParser.g:2072:1: ruleExtensionScalarValue EOF
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
    // InternalBasicsParser.g:2079:1: ruleExtensionScalarValue : ( ( rule__ExtensionScalarValue__Group__0 ) ) ;
    public final void ruleExtensionScalarValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2083:2: ( ( ( rule__ExtensionScalarValue__Group__0 ) ) )
            // InternalBasicsParser.g:2084:2: ( ( rule__ExtensionScalarValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2084:2: ( ( rule__ExtensionScalarValue__Group__0 ) )
            // InternalBasicsParser.g:2085:3: ( rule__ExtensionScalarValue__Group__0 )
            {
             before(grammarAccess.getExtensionScalarValueAccess().getGroup()); 
            // InternalBasicsParser.g:2086:3: ( rule__ExtensionScalarValue__Group__0 )
            // InternalBasicsParser.g:2086:4: rule__ExtensionScalarValue__Group__0
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
    // InternalBasicsParser.g:2095:1: entryRuleExtensionScalarLiteral : ruleExtensionScalarLiteral EOF ;
    public final void entryRuleExtensionScalarLiteral() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2096:1: ( ruleExtensionScalarLiteral EOF )
            // InternalBasicsParser.g:2097:1: ruleExtensionScalarLiteral EOF
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
    // InternalBasicsParser.g:2104:1: ruleExtensionScalarLiteral : ( ( rule__ExtensionScalarLiteral__Alternatives ) ) ;
    public final void ruleExtensionScalarLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2108:2: ( ( ( rule__ExtensionScalarLiteral__Alternatives ) ) )
            // InternalBasicsParser.g:2109:2: ( ( rule__ExtensionScalarLiteral__Alternatives ) )
            {
            // InternalBasicsParser.g:2109:2: ( ( rule__ExtensionScalarLiteral__Alternatives ) )
            // InternalBasicsParser.g:2110:3: ( rule__ExtensionScalarLiteral__Alternatives )
            {
             before(grammarAccess.getExtensionScalarLiteralAccess().getAlternatives()); 
            // InternalBasicsParser.g:2111:3: ( rule__ExtensionScalarLiteral__Alternatives )
            // InternalBasicsParser.g:2111:4: rule__ExtensionScalarLiteral__Alternatives
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
    // InternalBasicsParser.g:2119:1: rule__Namespace__Alternatives : ( ( ruleGlobalNamespace ) | ( ruleRelativeNamespace_Impl ) | ( rulePrivateNamespace ) );
    public final void rule__Namespace__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2123:1: ( ( ruleGlobalNamespace ) | ( ruleRelativeNamespace_Impl ) | ( rulePrivateNamespace ) )
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
                    // InternalBasicsParser.g:2124:2: ( ruleGlobalNamespace )
                    {
                    // InternalBasicsParser.g:2124:2: ( ruleGlobalNamespace )
                    // InternalBasicsParser.g:2125:3: ruleGlobalNamespace
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
                    // InternalBasicsParser.g:2130:2: ( ruleRelativeNamespace_Impl )
                    {
                    // InternalBasicsParser.g:2130:2: ( ruleRelativeNamespace_Impl )
                    // InternalBasicsParser.g:2131:3: ruleRelativeNamespace_Impl
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
                    // InternalBasicsParser.g:2136:2: ( rulePrivateNamespace )
                    {
                    // InternalBasicsParser.g:2136:2: ( rulePrivateNamespace )
                    // InternalBasicsParser.g:2137:3: rulePrivateNamespace
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
    // InternalBasicsParser.g:2146:1: rule__ParameterType__Alternatives : ( ( ruleParameterListType ) | ( ruleParameterStructType ) | ( ruleParameterIntegerType ) | ( ruleParameterStringType ) | ( ruleParameterDoubleType ) | ( ruleParameterBooleanType ) | ( ruleParameterBase64Type ) | ( ruleParameterArrayType ) );
    public final void rule__ParameterType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2150:1: ( ( ruleParameterListType ) | ( ruleParameterStructType ) | ( ruleParameterIntegerType ) | ( ruleParameterStringType ) | ( ruleParameterDoubleType ) | ( ruleParameterBooleanType ) | ( ruleParameterBase64Type ) | ( ruleParameterArrayType ) )
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
                    // InternalBasicsParser.g:2151:2: ( ruleParameterListType )
                    {
                    // InternalBasicsParser.g:2151:2: ( ruleParameterListType )
                    // InternalBasicsParser.g:2152:3: ruleParameterListType
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
                    // InternalBasicsParser.g:2157:2: ( ruleParameterStructType )
                    {
                    // InternalBasicsParser.g:2157:2: ( ruleParameterStructType )
                    // InternalBasicsParser.g:2158:3: ruleParameterStructType
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
                    // InternalBasicsParser.g:2163:2: ( ruleParameterIntegerType )
                    {
                    // InternalBasicsParser.g:2163:2: ( ruleParameterIntegerType )
                    // InternalBasicsParser.g:2164:3: ruleParameterIntegerType
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
                    // InternalBasicsParser.g:2169:2: ( ruleParameterStringType )
                    {
                    // InternalBasicsParser.g:2169:2: ( ruleParameterStringType )
                    // InternalBasicsParser.g:2170:3: ruleParameterStringType
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
                    // InternalBasicsParser.g:2175:2: ( ruleParameterDoubleType )
                    {
                    // InternalBasicsParser.g:2175:2: ( ruleParameterDoubleType )
                    // InternalBasicsParser.g:2176:3: ruleParameterDoubleType
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
                    // InternalBasicsParser.g:2181:2: ( ruleParameterBooleanType )
                    {
                    // InternalBasicsParser.g:2181:2: ( ruleParameterBooleanType )
                    // InternalBasicsParser.g:2182:3: ruleParameterBooleanType
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
                    // InternalBasicsParser.g:2187:2: ( ruleParameterBase64Type )
                    {
                    // InternalBasicsParser.g:2187:2: ( ruleParameterBase64Type )
                    // InternalBasicsParser.g:2188:3: ruleParameterBase64Type
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
                    // InternalBasicsParser.g:2193:2: ( ruleParameterArrayType )
                    {
                    // InternalBasicsParser.g:2193:2: ( ruleParameterArrayType )
                    // InternalBasicsParser.g:2194:3: ruleParameterArrayType
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
    // InternalBasicsParser.g:2203:1: rule__ParameterValue__Alternatives : ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) );
    public final void rule__ParameterValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2207:1: ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) )
            int alt3=7;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBasicsParser.g:2208:2: ( ruleParameterString )
                    {
                    // InternalBasicsParser.g:2208:2: ( ruleParameterString )
                    // InternalBasicsParser.g:2209:3: ruleParameterString
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
                    // InternalBasicsParser.g:2214:2: ( ruleParameterBase64 )
                    {
                    // InternalBasicsParser.g:2214:2: ( ruleParameterBase64 )
                    // InternalBasicsParser.g:2215:3: ruleParameterBase64
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
                    // InternalBasicsParser.g:2220:2: ( ruleParameterInteger )
                    {
                    // InternalBasicsParser.g:2220:2: ( ruleParameterInteger )
                    // InternalBasicsParser.g:2221:3: ruleParameterInteger
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
                    // InternalBasicsParser.g:2226:2: ( ruleParameterDouble )
                    {
                    // InternalBasicsParser.g:2226:2: ( ruleParameterDouble )
                    // InternalBasicsParser.g:2227:3: ruleParameterDouble
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
                    // InternalBasicsParser.g:2232:2: ( ruleParameterBoolean )
                    {
                    // InternalBasicsParser.g:2232:2: ( ruleParameterBoolean )
                    // InternalBasicsParser.g:2233:3: ruleParameterBoolean
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
                    // InternalBasicsParser.g:2238:2: ( ruleParameterList )
                    {
                    // InternalBasicsParser.g:2238:2: ( ruleParameterList )
                    // InternalBasicsParser.g:2239:3: ruleParameterList
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
                    // InternalBasicsParser.g:2244:2: ( ruleParameterStruct )
                    {
                    // InternalBasicsParser.g:2244:2: ( ruleParameterStruct )
                    // InternalBasicsParser.g:2245:3: ruleParameterStruct
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


    // $ANTLR start "rule__ParameterStructMember__Alternatives_0"
    // InternalBasicsParser.g:2254:1: rule__ParameterStructMember__Alternatives_0 : ( ( ( rule__ParameterStructMember__Group_0_0__0 ) ) | ( ( rule__ParameterStructMember__NameAssignment_0_1 ) ) );
    public final void rule__ParameterStructMember__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2258:1: ( ( ( rule__ParameterStructMember__Group_0_0__0 ) ) | ( ( rule__ParameterStructMember__NameAssignment_0_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=Pluginbases && LA4_0<=Parameter)||LA4_0==Multiple||LA4_0==Plugins||(LA4_0>=Format && LA4_0<=Header_1)||LA4_0==Loader||LA4_0==Class||LA4_0==Slots||LA4_0==Base) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBasicsParser.g:2259:2: ( ( rule__ParameterStructMember__Group_0_0__0 ) )
                    {
                    // InternalBasicsParser.g:2259:2: ( ( rule__ParameterStructMember__Group_0_0__0 ) )
                    // InternalBasicsParser.g:2260:3: ( rule__ParameterStructMember__Group_0_0__0 )
                    {
                     before(grammarAccess.getParameterStructMemberAccess().getGroup_0_0()); 
                    // InternalBasicsParser.g:2261:3: ( rule__ParameterStructMember__Group_0_0__0 )
                    // InternalBasicsParser.g:2261:4: rule__ParameterStructMember__Group_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterStructMember__Group_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParameterStructMemberAccess().getGroup_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2265:2: ( ( rule__ParameterStructMember__NameAssignment_0_1 ) )
                    {
                    // InternalBasicsParser.g:2265:2: ( ( rule__ParameterStructMember__NameAssignment_0_1 ) )
                    // InternalBasicsParser.g:2266:3: ( rule__ParameterStructMember__NameAssignment_0_1 )
                    {
                     before(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0_1()); 
                    // InternalBasicsParser.g:2267:3: ( rule__ParameterStructMember__NameAssignment_0_1 )
                    // InternalBasicsParser.g:2267:4: rule__ParameterStructMember__NameAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ParameterStructMember__NameAssignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0_1()); 

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
    // $ANTLR end "rule__ParameterStructMember__Alternatives_0"


    // $ANTLR start "rule__AbstractType__Alternatives"
    // InternalBasicsParser.g:2275:1: rule__AbstractType__Alternatives : ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleSpecBaseRef ) | ( ruleArraySpecRef ) | ( rulechar ) | ( rulecharArray ) );
    public final void rule__AbstractType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2279:1: ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleSpecBaseRef ) | ( ruleArraySpecRef ) | ( rulechar ) | ( rulecharArray ) )
            int alt5=33;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBasicsParser.g:2280:2: ( rulebool )
                    {
                    // InternalBasicsParser.g:2280:2: ( rulebool )
                    // InternalBasicsParser.g:2281:3: rulebool
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
                    // InternalBasicsParser.g:2286:2: ( ruleint8 )
                    {
                    // InternalBasicsParser.g:2286:2: ( ruleint8 )
                    // InternalBasicsParser.g:2287:3: ruleint8
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
                    // InternalBasicsParser.g:2292:2: ( ruleuint8 )
                    {
                    // InternalBasicsParser.g:2292:2: ( ruleuint8 )
                    // InternalBasicsParser.g:2293:3: ruleuint8
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
                    // InternalBasicsParser.g:2298:2: ( ruleint16 )
                    {
                    // InternalBasicsParser.g:2298:2: ( ruleint16 )
                    // InternalBasicsParser.g:2299:3: ruleint16
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
                    // InternalBasicsParser.g:2304:2: ( ruleuint16 )
                    {
                    // InternalBasicsParser.g:2304:2: ( ruleuint16 )
                    // InternalBasicsParser.g:2305:3: ruleuint16
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
                    // InternalBasicsParser.g:2310:2: ( ruleint32 )
                    {
                    // InternalBasicsParser.g:2310:2: ( ruleint32 )
                    // InternalBasicsParser.g:2311:3: ruleint32
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
                    // InternalBasicsParser.g:2316:2: ( ruleuint32 )
                    {
                    // InternalBasicsParser.g:2316:2: ( ruleuint32 )
                    // InternalBasicsParser.g:2317:3: ruleuint32
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
                    // InternalBasicsParser.g:2322:2: ( ruleint64 )
                    {
                    // InternalBasicsParser.g:2322:2: ( ruleint64 )
                    // InternalBasicsParser.g:2323:3: ruleint64
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
                    // InternalBasicsParser.g:2328:2: ( ruleuint64 )
                    {
                    // InternalBasicsParser.g:2328:2: ( ruleuint64 )
                    // InternalBasicsParser.g:2329:3: ruleuint64
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
                    // InternalBasicsParser.g:2334:2: ( rulefloat32 )
                    {
                    // InternalBasicsParser.g:2334:2: ( rulefloat32 )
                    // InternalBasicsParser.g:2335:3: rulefloat32
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
                    // InternalBasicsParser.g:2340:2: ( rulefloat64 )
                    {
                    // InternalBasicsParser.g:2340:2: ( rulefloat64 )
                    // InternalBasicsParser.g:2341:3: rulefloat64
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
                    // InternalBasicsParser.g:2346:2: ( rulestring0 )
                    {
                    // InternalBasicsParser.g:2346:2: ( rulestring0 )
                    // InternalBasicsParser.g:2347:3: rulestring0
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
                    // InternalBasicsParser.g:2352:2: ( rulebyte )
                    {
                    // InternalBasicsParser.g:2352:2: ( rulebyte )
                    // InternalBasicsParser.g:2353:3: rulebyte
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
                    // InternalBasicsParser.g:2358:2: ( ruletime )
                    {
                    // InternalBasicsParser.g:2358:2: ( ruletime )
                    // InternalBasicsParser.g:2359:3: ruletime
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
                    // InternalBasicsParser.g:2364:2: ( ruleduration )
                    {
                    // InternalBasicsParser.g:2364:2: ( ruleduration )
                    // InternalBasicsParser.g:2365:3: ruleduration
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
                    // InternalBasicsParser.g:2370:2: ( ruleHeader )
                    {
                    // InternalBasicsParser.g:2370:2: ( ruleHeader )
                    // InternalBasicsParser.g:2371:3: ruleHeader
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
                    // InternalBasicsParser.g:2376:2: ( ruleboolArray )
                    {
                    // InternalBasicsParser.g:2376:2: ( ruleboolArray )
                    // InternalBasicsParser.g:2377:3: ruleboolArray
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
                    // InternalBasicsParser.g:2382:2: ( ruleint8Array )
                    {
                    // InternalBasicsParser.g:2382:2: ( ruleint8Array )
                    // InternalBasicsParser.g:2383:3: ruleint8Array
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
                    // InternalBasicsParser.g:2388:2: ( ruleuint8Array )
                    {
                    // InternalBasicsParser.g:2388:2: ( ruleuint8Array )
                    // InternalBasicsParser.g:2389:3: ruleuint8Array
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
                    // InternalBasicsParser.g:2394:2: ( ruleint16Array )
                    {
                    // InternalBasicsParser.g:2394:2: ( ruleint16Array )
                    // InternalBasicsParser.g:2395:3: ruleint16Array
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
                    // InternalBasicsParser.g:2400:2: ( ruleuint16Array )
                    {
                    // InternalBasicsParser.g:2400:2: ( ruleuint16Array )
                    // InternalBasicsParser.g:2401:3: ruleuint16Array
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
                    // InternalBasicsParser.g:2406:2: ( ruleint32Array )
                    {
                    // InternalBasicsParser.g:2406:2: ( ruleint32Array )
                    // InternalBasicsParser.g:2407:3: ruleint32Array
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
                    // InternalBasicsParser.g:2412:2: ( ruleuint32Array )
                    {
                    // InternalBasicsParser.g:2412:2: ( ruleuint32Array )
                    // InternalBasicsParser.g:2413:3: ruleuint32Array
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
                    // InternalBasicsParser.g:2418:2: ( ruleint64Array )
                    {
                    // InternalBasicsParser.g:2418:2: ( ruleint64Array )
                    // InternalBasicsParser.g:2419:3: ruleint64Array
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
                    // InternalBasicsParser.g:2424:2: ( ruleuint64Array )
                    {
                    // InternalBasicsParser.g:2424:2: ( ruleuint64Array )
                    // InternalBasicsParser.g:2425:3: ruleuint64Array
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
                    // InternalBasicsParser.g:2430:2: ( rulefloat32Array )
                    {
                    // InternalBasicsParser.g:2430:2: ( rulefloat32Array )
                    // InternalBasicsParser.g:2431:3: rulefloat32Array
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
                    // InternalBasicsParser.g:2436:2: ( rulefloat64Array )
                    {
                    // InternalBasicsParser.g:2436:2: ( rulefloat64Array )
                    // InternalBasicsParser.g:2437:3: rulefloat64Array
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
                    // InternalBasicsParser.g:2442:2: ( rulestring0Array )
                    {
                    // InternalBasicsParser.g:2442:2: ( rulestring0Array )
                    // InternalBasicsParser.g:2443:3: rulestring0Array
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
                    // InternalBasicsParser.g:2448:2: ( rulebyteArray )
                    {
                    // InternalBasicsParser.g:2448:2: ( rulebyteArray )
                    // InternalBasicsParser.g:2449:3: rulebyteArray
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
                    // InternalBasicsParser.g:2454:2: ( ruleSpecBaseRef )
                    {
                    // InternalBasicsParser.g:2454:2: ( ruleSpecBaseRef )
                    // InternalBasicsParser.g:2455:3: ruleSpecBaseRef
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
                    // InternalBasicsParser.g:2460:2: ( ruleArraySpecRef )
                    {
                    // InternalBasicsParser.g:2460:2: ( ruleArraySpecRef )
                    // InternalBasicsParser.g:2461:3: ruleArraySpecRef
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
                    // InternalBasicsParser.g:2466:2: ( rulechar )
                    {
                    // InternalBasicsParser.g:2466:2: ( rulechar )
                    // InternalBasicsParser.g:2467:3: rulechar
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
                    // InternalBasicsParser.g:2472:2: ( rulecharArray )
                    {
                    // InternalBasicsParser.g:2472:2: ( rulecharArray )
                    // InternalBasicsParser.g:2473:3: rulecharArray
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
    // InternalBasicsParser.g:2482:1: rule__KEYWORD__Alternatives : ( ( Goal ) | ( Message ) | ( Result ) | ( Feedback ) | ( Name ) | ( Value ) | ( Service ) | ( Type ) | ( Action ) | ( Duration ) | ( Time ) );
    public final void rule__KEYWORD__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2486:1: ( ( Goal ) | ( Message ) | ( Result ) | ( Feedback ) | ( Name ) | ( Value ) | ( Service ) | ( Type ) | ( Action ) | ( Duration ) | ( Time ) )
            int alt6=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt6=1;
                }
                break;
            case Message:
                {
                alt6=2;
                }
                break;
            case Result:
                {
                alt6=3;
                }
                break;
            case Feedback:
                {
                alt6=4;
                }
                break;
            case Name:
                {
                alt6=5;
                }
                break;
            case Value:
                {
                alt6=6;
                }
                break;
            case Service:
                {
                alt6=7;
                }
                break;
            case Type:
                {
                alt6=8;
                }
                break;
            case Action:
                {
                alt6=9;
                }
                break;
            case Duration:
                {
                alt6=10;
                }
                break;
            case Time:
                {
                alt6=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalBasicsParser.g:2487:2: ( Goal )
                    {
                    // InternalBasicsParser.g:2487:2: ( Goal )
                    // InternalBasicsParser.g:2488:3: Goal
                    {
                     before(grammarAccess.getKEYWORDAccess().getGoalKeyword_0()); 
                    match(input,Goal,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getGoalKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2493:2: ( Message )
                    {
                    // InternalBasicsParser.g:2493:2: ( Message )
                    // InternalBasicsParser.g:2494:3: Message
                    {
                     before(grammarAccess.getKEYWORDAccess().getMessageKeyword_1()); 
                    match(input,Message,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getMessageKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2499:2: ( Result )
                    {
                    // InternalBasicsParser.g:2499:2: ( Result )
                    // InternalBasicsParser.g:2500:3: Result
                    {
                     before(grammarAccess.getKEYWORDAccess().getResultKeyword_2()); 
                    match(input,Result,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getResultKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2505:2: ( Feedback )
                    {
                    // InternalBasicsParser.g:2505:2: ( Feedback )
                    // InternalBasicsParser.g:2506:3: Feedback
                    {
                     before(grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3()); 
                    match(input,Feedback,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2511:2: ( Name )
                    {
                    // InternalBasicsParser.g:2511:2: ( Name )
                    // InternalBasicsParser.g:2512:3: Name
                    {
                     before(grammarAccess.getKEYWORDAccess().getNameKeyword_4()); 
                    match(input,Name,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getNameKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2517:2: ( Value )
                    {
                    // InternalBasicsParser.g:2517:2: ( Value )
                    // InternalBasicsParser.g:2518:3: Value
                    {
                     before(grammarAccess.getKEYWORDAccess().getValueKeyword_5()); 
                    match(input,Value,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getValueKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2523:2: ( Service )
                    {
                    // InternalBasicsParser.g:2523:2: ( Service )
                    // InternalBasicsParser.g:2524:3: Service
                    {
                     before(grammarAccess.getKEYWORDAccess().getServiceKeyword_6()); 
                    match(input,Service,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getServiceKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2529:2: ( Type )
                    {
                    // InternalBasicsParser.g:2529:2: ( Type )
                    // InternalBasicsParser.g:2530:3: Type
                    {
                     before(grammarAccess.getKEYWORDAccess().getTypeKeyword_7()); 
                    match(input,Type,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getTypeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2535:2: ( Action )
                    {
                    // InternalBasicsParser.g:2535:2: ( Action )
                    // InternalBasicsParser.g:2536:3: Action
                    {
                     before(grammarAccess.getKEYWORDAccess().getActionKeyword_8()); 
                    match(input,Action,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getActionKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2541:2: ( Duration )
                    {
                    // InternalBasicsParser.g:2541:2: ( Duration )
                    // InternalBasicsParser.g:2542:3: Duration
                    {
                     before(grammarAccess.getKEYWORDAccess().getDurationKeyword_9()); 
                    match(input,Duration,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getDurationKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2547:2: ( Time )
                    {
                    // InternalBasicsParser.g:2547:2: ( Time )
                    // InternalBasicsParser.g:2548:3: Time
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
    // InternalBasicsParser.g:2557:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2561:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBasicsParser.g:2562:2: ( RULE_STRING )
                    {
                    // InternalBasicsParser.g:2562:2: ( RULE_STRING )
                    // InternalBasicsParser.g:2563:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2568:2: ( RULE_ID )
                    {
                    // InternalBasicsParser.g:2568:2: ( RULE_ID )
                    // InternalBasicsParser.g:2569:3: RULE_ID
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


    // $ANTLR start "rule__AddedKeywordName__Alternatives"
    // InternalBasicsParser.g:2578:1: rule__AddedKeywordName__Alternatives : ( ( Lifecycle ) | ( Active_in ) | ( Plugins ) | ( Implements ) | ( Pluginslots ) | ( Pluginbases ) | ( Base ) | ( Parameter ) | ( Format ) | ( Multiple ) | ( Class ) | ( Header_1 ) | ( Loader ) | ( Slots ) );
    public final void rule__AddedKeywordName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2582:1: ( ( Lifecycle ) | ( Active_in ) | ( Plugins ) | ( Implements ) | ( Pluginslots ) | ( Pluginbases ) | ( Base ) | ( Parameter ) | ( Format ) | ( Multiple ) | ( Class ) | ( Header_1 ) | ( Loader ) | ( Slots ) )
            int alt8=14;
            switch ( input.LA(1) ) {
            case Lifecycle:
                {
                alt8=1;
                }
                break;
            case Active_in:
                {
                alt8=2;
                }
                break;
            case Plugins:
                {
                alt8=3;
                }
                break;
            case Implements:
                {
                alt8=4;
                }
                break;
            case Pluginslots:
                {
                alt8=5;
                }
                break;
            case Pluginbases:
                {
                alt8=6;
                }
                break;
            case Base:
                {
                alt8=7;
                }
                break;
            case Parameter:
                {
                alt8=8;
                }
                break;
            case Format:
                {
                alt8=9;
                }
                break;
            case Multiple:
                {
                alt8=10;
                }
                break;
            case Class:
                {
                alt8=11;
                }
                break;
            case Header_1:
                {
                alt8=12;
                }
                break;
            case Loader:
                {
                alt8=13;
                }
                break;
            case Slots:
                {
                alt8=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalBasicsParser.g:2583:2: ( Lifecycle )
                    {
                    // InternalBasicsParser.g:2583:2: ( Lifecycle )
                    // InternalBasicsParser.g:2584:3: Lifecycle
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getLifecycleKeyword_0()); 
                    match(input,Lifecycle,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getLifecycleKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2589:2: ( Active_in )
                    {
                    // InternalBasicsParser.g:2589:2: ( Active_in )
                    // InternalBasicsParser.g:2590:3: Active_in
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getActive_inKeyword_1()); 
                    match(input,Active_in,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getActive_inKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2595:2: ( Plugins )
                    {
                    // InternalBasicsParser.g:2595:2: ( Plugins )
                    // InternalBasicsParser.g:2596:3: Plugins
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getPluginsKeyword_2()); 
                    match(input,Plugins,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getPluginsKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2601:2: ( Implements )
                    {
                    // InternalBasicsParser.g:2601:2: ( Implements )
                    // InternalBasicsParser.g:2602:3: Implements
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getImplementsKeyword_3()); 
                    match(input,Implements,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getImplementsKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2607:2: ( Pluginslots )
                    {
                    // InternalBasicsParser.g:2607:2: ( Pluginslots )
                    // InternalBasicsParser.g:2608:3: Pluginslots
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getPluginslotsKeyword_4()); 
                    match(input,Pluginslots,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getPluginslotsKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2613:2: ( Pluginbases )
                    {
                    // InternalBasicsParser.g:2613:2: ( Pluginbases )
                    // InternalBasicsParser.g:2614:3: Pluginbases
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getPluginbasesKeyword_5()); 
                    match(input,Pluginbases,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getPluginbasesKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2619:2: ( Base )
                    {
                    // InternalBasicsParser.g:2619:2: ( Base )
                    // InternalBasicsParser.g:2620:3: Base
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getBaseKeyword_6()); 
                    match(input,Base,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getBaseKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2625:2: ( Parameter )
                    {
                    // InternalBasicsParser.g:2625:2: ( Parameter )
                    // InternalBasicsParser.g:2626:3: Parameter
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getParameterKeyword_7()); 
                    match(input,Parameter,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getParameterKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2631:2: ( Format )
                    {
                    // InternalBasicsParser.g:2631:2: ( Format )
                    // InternalBasicsParser.g:2632:3: Format
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getFormatKeyword_8()); 
                    match(input,Format,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getFormatKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2637:2: ( Multiple )
                    {
                    // InternalBasicsParser.g:2637:2: ( Multiple )
                    // InternalBasicsParser.g:2638:3: Multiple
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getMultipleKeyword_9()); 
                    match(input,Multiple,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getMultipleKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2643:2: ( Class )
                    {
                    // InternalBasicsParser.g:2643:2: ( Class )
                    // InternalBasicsParser.g:2644:3: Class
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getClassKeyword_10()); 
                    match(input,Class,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getClassKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2649:2: ( Header_1 )
                    {
                    // InternalBasicsParser.g:2649:2: ( Header_1 )
                    // InternalBasicsParser.g:2650:3: Header_1
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getHeaderKeyword_11()); 
                    match(input,Header_1,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getHeaderKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2655:2: ( Loader )
                    {
                    // InternalBasicsParser.g:2655:2: ( Loader )
                    // InternalBasicsParser.g:2656:3: Loader
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getLoaderKeyword_12()); 
                    match(input,Loader,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getLoaderKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2661:2: ( Slots )
                    {
                    // InternalBasicsParser.g:2661:2: ( Slots )
                    // InternalBasicsParser.g:2662:3: Slots
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getSlotsKeyword_13()); 
                    match(input,Slots,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getSlotsKeyword_13()); 

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
    // $ANTLR end "rule__AddedKeywordName__Alternatives"


    // $ANTLR start "rule__ExtensionEntry__Alternatives_1"
    // InternalBasicsParser.g:2671:1: rule__ExtensionEntry__Alternatives_1 : ( ( ( rule__ExtensionEntry__Group_1_0__0 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) ) );
    public final void rule__ExtensionEntry__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2675:1: ( ( ( rule__ExtensionEntry__Group_1_0__0 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
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
                alt9=1;
                }
                break;
            case Default:
            case Value_1:
            case Type_1:
            case Ns:
                {
                alt9=2;
                }
                break;
            case Pluginbases:
            case Pluginslots:
            case Implements:
            case Active_in:
            case Lifecycle:
            case Parameter:
            case Multiple:
            case Plugins:
            case Format:
            case Header_1:
            case Loader:
            case Class:
            case Slots:
            case Base:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalBasicsParser.g:2676:2: ( ( rule__ExtensionEntry__Group_1_0__0 ) )
                    {
                    // InternalBasicsParser.g:2676:2: ( ( rule__ExtensionEntry__Group_1_0__0 ) )
                    // InternalBasicsParser.g:2677:3: ( rule__ExtensionEntry__Group_1_0__0 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getGroup_1_0()); 
                    // InternalBasicsParser.g:2678:3: ( rule__ExtensionEntry__Group_1_0__0 )
                    // InternalBasicsParser.g:2678:4: rule__ExtensionEntry__Group_1_0__0
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
                    // InternalBasicsParser.g:2682:2: ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) )
                    {
                    // InternalBasicsParser.g:2682:2: ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) )
                    // InternalBasicsParser.g:2683:3: ( rule__ExtensionEntry__KeyAssignment_1_1 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_1()); 
                    // InternalBasicsParser.g:2684:3: ( rule__ExtensionEntry__KeyAssignment_1_1 )
                    // InternalBasicsParser.g:2684:4: rule__ExtensionEntry__KeyAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionEntry__KeyAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2688:2: ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) )
                    {
                    // InternalBasicsParser.g:2688:2: ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) )
                    // InternalBasicsParser.g:2689:3: ( rule__ExtensionEntry__KeyAssignment_1_2 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_2()); 
                    // InternalBasicsParser.g:2690:3: ( rule__ExtensionEntry__KeyAssignment_1_2 )
                    // InternalBasicsParser.g:2690:4: rule__ExtensionEntry__KeyAssignment_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionEntry__KeyAssignment_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_2()); 

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
    // InternalBasicsParser.g:2698:1: rule__ExtensionKey__Alternatives : ( ( RULE_ID ) | ( RULE_STRING ) | ( ruleKEYWORD ) | ( Node ) | ( String ) | ( Integer ) | ( Double ) | ( Boolean ) | ( Base64 ) | ( Array ) | ( List ) | ( Struct ) | ( Date ) | ( Any ) | ( Bool ) | ( Int8 ) | ( Uint8 ) | ( Int16 ) | ( Uint16 ) | ( Int32 ) | ( Uint32 ) | ( Int64 ) | ( Uint64 ) | ( Float32 ) | ( Float64 ) | ( String_1 ) | ( Char ) | ( Byte ) | ( Header ) );
    public final void rule__ExtensionKey__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2702:1: ( ( RULE_ID ) | ( RULE_STRING ) | ( ruleKEYWORD ) | ( Node ) | ( String ) | ( Integer ) | ( Double ) | ( Boolean ) | ( Base64 ) | ( Array ) | ( List ) | ( Struct ) | ( Date ) | ( Any ) | ( Bool ) | ( Int8 ) | ( Uint8 ) | ( Int16 ) | ( Uint16 ) | ( Int32 ) | ( Uint32 ) | ( Int64 ) | ( Uint64 ) | ( Float32 ) | ( Float64 ) | ( String_1 ) | ( Char ) | ( Byte ) | ( Header ) )
            int alt10=29;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt10=1;
                }
                break;
            case RULE_STRING:
                {
                alt10=2;
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
                alt10=3;
                }
                break;
            case Node:
                {
                alt10=4;
                }
                break;
            case String:
                {
                alt10=5;
                }
                break;
            case Integer:
                {
                alt10=6;
                }
                break;
            case Double:
                {
                alt10=7;
                }
                break;
            case Boolean:
                {
                alt10=8;
                }
                break;
            case Base64:
                {
                alt10=9;
                }
                break;
            case Array:
                {
                alt10=10;
                }
                break;
            case List:
                {
                alt10=11;
                }
                break;
            case Struct:
                {
                alt10=12;
                }
                break;
            case Date:
                {
                alt10=13;
                }
                break;
            case Any:
                {
                alt10=14;
                }
                break;
            case Bool:
                {
                alt10=15;
                }
                break;
            case Int8:
                {
                alt10=16;
                }
                break;
            case Uint8:
                {
                alt10=17;
                }
                break;
            case Int16:
                {
                alt10=18;
                }
                break;
            case Uint16:
                {
                alt10=19;
                }
                break;
            case Int32:
                {
                alt10=20;
                }
                break;
            case Uint32:
                {
                alt10=21;
                }
                break;
            case Int64:
                {
                alt10=22;
                }
                break;
            case Uint64:
                {
                alt10=23;
                }
                break;
            case Float32:
                {
                alt10=24;
                }
                break;
            case Float64:
                {
                alt10=25;
                }
                break;
            case String_1:
                {
                alt10=26;
                }
                break;
            case Char:
                {
                alt10=27;
                }
                break;
            case Byte:
                {
                alt10=28;
                }
                break;
            case Header:
                {
                alt10=29;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalBasicsParser.g:2703:2: ( RULE_ID )
                    {
                    // InternalBasicsParser.g:2703:2: ( RULE_ID )
                    // InternalBasicsParser.g:2704:3: RULE_ID
                    {
                     before(grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2709:2: ( RULE_STRING )
                    {
                    // InternalBasicsParser.g:2709:2: ( RULE_STRING )
                    // InternalBasicsParser.g:2710:3: RULE_STRING
                    {
                     before(grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2715:2: ( ruleKEYWORD )
                    {
                    // InternalBasicsParser.g:2715:2: ( ruleKEYWORD )
                    // InternalBasicsParser.g:2716:3: ruleKEYWORD
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
                    // InternalBasicsParser.g:2721:2: ( Node )
                    {
                    // InternalBasicsParser.g:2721:2: ( Node )
                    // InternalBasicsParser.g:2722:3: Node
                    {
                     before(grammarAccess.getExtensionKeyAccess().getNodeKeyword_3()); 
                    match(input,Node,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getNodeKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2727:2: ( String )
                    {
                    // InternalBasicsParser.g:2727:2: ( String )
                    // InternalBasicsParser.g:2728:3: String
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStringKeyword_4()); 
                    match(input,String,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStringKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2733:2: ( Integer )
                    {
                    // InternalBasicsParser.g:2733:2: ( Integer )
                    // InternalBasicsParser.g:2734:3: Integer
                    {
                     before(grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5()); 
                    match(input,Integer,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2739:2: ( Double )
                    {
                    // InternalBasicsParser.g:2739:2: ( Double )
                    // InternalBasicsParser.g:2740:3: Double
                    {
                     before(grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6()); 
                    match(input,Double,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2745:2: ( Boolean )
                    {
                    // InternalBasicsParser.g:2745:2: ( Boolean )
                    // InternalBasicsParser.g:2746:3: Boolean
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7()); 
                    match(input,Boolean,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2751:2: ( Base64 )
                    {
                    // InternalBasicsParser.g:2751:2: ( Base64 )
                    // InternalBasicsParser.g:2752:3: Base64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBase64Keyword_8()); 
                    match(input,Base64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBase64Keyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2757:2: ( Array )
                    {
                    // InternalBasicsParser.g:2757:2: ( Array )
                    // InternalBasicsParser.g:2758:3: Array
                    {
                     before(grammarAccess.getExtensionKeyAccess().getArrayKeyword_9()); 
                    match(input,Array,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getArrayKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2763:2: ( List )
                    {
                    // InternalBasicsParser.g:2763:2: ( List )
                    // InternalBasicsParser.g:2764:3: List
                    {
                     before(grammarAccess.getExtensionKeyAccess().getListKeyword_10()); 
                    match(input,List,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getListKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2769:2: ( Struct )
                    {
                    // InternalBasicsParser.g:2769:2: ( Struct )
                    // InternalBasicsParser.g:2770:3: Struct
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStructKeyword_11()); 
                    match(input,Struct,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStructKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2775:2: ( Date )
                    {
                    // InternalBasicsParser.g:2775:2: ( Date )
                    // InternalBasicsParser.g:2776:3: Date
                    {
                     before(grammarAccess.getExtensionKeyAccess().getDateKeyword_12()); 
                    match(input,Date,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getDateKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2781:2: ( Any )
                    {
                    // InternalBasicsParser.g:2781:2: ( Any )
                    // InternalBasicsParser.g:2782:3: Any
                    {
                     before(grammarAccess.getExtensionKeyAccess().getAnyKeyword_13()); 
                    match(input,Any,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getAnyKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBasicsParser.g:2787:2: ( Bool )
                    {
                    // InternalBasicsParser.g:2787:2: ( Bool )
                    // InternalBasicsParser.g:2788:3: Bool
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBoolKeyword_14()); 
                    match(input,Bool,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBoolKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBasicsParser.g:2793:2: ( Int8 )
                    {
                    // InternalBasicsParser.g:2793:2: ( Int8 )
                    // InternalBasicsParser.g:2794:3: Int8
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt8Keyword_15()); 
                    match(input,Int8,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt8Keyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBasicsParser.g:2799:2: ( Uint8 )
                    {
                    // InternalBasicsParser.g:2799:2: ( Uint8 )
                    // InternalBasicsParser.g:2800:3: Uint8
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint8Keyword_16()); 
                    match(input,Uint8,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint8Keyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBasicsParser.g:2805:2: ( Int16 )
                    {
                    // InternalBasicsParser.g:2805:2: ( Int16 )
                    // InternalBasicsParser.g:2806:3: Int16
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt16Keyword_17()); 
                    match(input,Int16,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt16Keyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBasicsParser.g:2811:2: ( Uint16 )
                    {
                    // InternalBasicsParser.g:2811:2: ( Uint16 )
                    // InternalBasicsParser.g:2812:3: Uint16
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint16Keyword_18()); 
                    match(input,Uint16,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint16Keyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBasicsParser.g:2817:2: ( Int32 )
                    {
                    // InternalBasicsParser.g:2817:2: ( Int32 )
                    // InternalBasicsParser.g:2818:3: Int32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt32Keyword_19()); 
                    match(input,Int32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt32Keyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBasicsParser.g:2823:2: ( Uint32 )
                    {
                    // InternalBasicsParser.g:2823:2: ( Uint32 )
                    // InternalBasicsParser.g:2824:3: Uint32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint32Keyword_20()); 
                    match(input,Uint32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint32Keyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBasicsParser.g:2829:2: ( Int64 )
                    {
                    // InternalBasicsParser.g:2829:2: ( Int64 )
                    // InternalBasicsParser.g:2830:3: Int64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt64Keyword_21()); 
                    match(input,Int64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt64Keyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBasicsParser.g:2835:2: ( Uint64 )
                    {
                    // InternalBasicsParser.g:2835:2: ( Uint64 )
                    // InternalBasicsParser.g:2836:3: Uint64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint64Keyword_22()); 
                    match(input,Uint64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint64Keyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBasicsParser.g:2841:2: ( Float32 )
                    {
                    // InternalBasicsParser.g:2841:2: ( Float32 )
                    // InternalBasicsParser.g:2842:3: Float32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23()); 
                    match(input,Float32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBasicsParser.g:2847:2: ( Float64 )
                    {
                    // InternalBasicsParser.g:2847:2: ( Float64 )
                    // InternalBasicsParser.g:2848:3: Float64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24()); 
                    match(input,Float64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBasicsParser.g:2853:2: ( String_1 )
                    {
                    // InternalBasicsParser.g:2853:2: ( String_1 )
                    // InternalBasicsParser.g:2854:3: String_1
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStringKeyword_25()); 
                    match(input,String_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStringKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalBasicsParser.g:2859:2: ( Char )
                    {
                    // InternalBasicsParser.g:2859:2: ( Char )
                    // InternalBasicsParser.g:2860:3: Char
                    {
                     before(grammarAccess.getExtensionKeyAccess().getCharKeyword_26()); 
                    match(input,Char,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getCharKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalBasicsParser.g:2865:2: ( Byte )
                    {
                    // InternalBasicsParser.g:2865:2: ( Byte )
                    // InternalBasicsParser.g:2866:3: Byte
                    {
                     before(grammarAccess.getExtensionKeyAccess().getByteKeyword_27()); 
                    match(input,Byte,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getByteKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalBasicsParser.g:2871:2: ( Header )
                    {
                    // InternalBasicsParser.g:2871:2: ( Header )
                    // InternalBasicsParser.g:2872:3: Header
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
    // InternalBasicsParser.g:2881:1: rule__ExtensionColonKey__Alternatives : ( ( Ns ) | ( Type_1 ) | ( Value_1 ) | ( Default ) );
    public final void rule__ExtensionColonKey__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2885:1: ( ( Ns ) | ( Type_1 ) | ( Value_1 ) | ( Default ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt11=1;
                }
                break;
            case Type_1:
                {
                alt11=2;
                }
                break;
            case Value_1:
                {
                alt11=3;
                }
                break;
            case Default:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalBasicsParser.g:2886:2: ( Ns )
                    {
                    // InternalBasicsParser.g:2886:2: ( Ns )
                    // InternalBasicsParser.g:2887:3: Ns
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0()); 
                    match(input,Ns,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2892:2: ( Type_1 )
                    {
                    // InternalBasicsParser.g:2892:2: ( Type_1 )
                    // InternalBasicsParser.g:2893:3: Type_1
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1()); 
                    match(input,Type_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2898:2: ( Value_1 )
                    {
                    // InternalBasicsParser.g:2898:2: ( Value_1 )
                    // InternalBasicsParser.g:2899:3: Value_1
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2()); 
                    match(input,Value_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2904:2: ( Default )
                    {
                    // InternalBasicsParser.g:2904:2: ( Default )
                    // InternalBasicsParser.g:2905:3: Default
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
    // InternalBasicsParser.g:2914:1: rule__ExtensionValue__Alternatives : ( ( ruleExtensionListValue ) | ( ruleExtensionBraceMapValue ) | ( ruleExtensionIndentedMapValue ) | ( ruleExtensionRefValue ) | ( ruleExtensionScalarValue ) );
    public final void rule__ExtensionValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2918:1: ( ( ruleExtensionListValue ) | ( ruleExtensionBraceMapValue ) | ( ruleExtensionIndentedMapValue ) | ( ruleExtensionRefValue ) | ( ruleExtensionScalarValue ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracketRightSquareBracket:
            case LeftSquareBracket:
                {
                alt12=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt12=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt12=3;
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
            case RULE_BOOLEAN:
            case RULE_DECINT:
            case RULE_DOUBLE:
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
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
                    // InternalBasicsParser.g:2919:2: ( ruleExtensionListValue )
                    {
                    // InternalBasicsParser.g:2919:2: ( ruleExtensionListValue )
                    // InternalBasicsParser.g:2920:3: ruleExtensionListValue
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
                    // InternalBasicsParser.g:2925:2: ( ruleExtensionBraceMapValue )
                    {
                    // InternalBasicsParser.g:2925:2: ( ruleExtensionBraceMapValue )
                    // InternalBasicsParser.g:2926:3: ruleExtensionBraceMapValue
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
                    // InternalBasicsParser.g:2931:2: ( ruleExtensionIndentedMapValue )
                    {
                    // InternalBasicsParser.g:2931:2: ( ruleExtensionIndentedMapValue )
                    // InternalBasicsParser.g:2932:3: ruleExtensionIndentedMapValue
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
                    // InternalBasicsParser.g:2937:2: ( ruleExtensionRefValue )
                    {
                    // InternalBasicsParser.g:2937:2: ( ruleExtensionRefValue )
                    // InternalBasicsParser.g:2938:3: ruleExtensionRefValue
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
                    // InternalBasicsParser.g:2943:2: ( ruleExtensionScalarValue )
                    {
                    // InternalBasicsParser.g:2943:2: ( ruleExtensionScalarValue )
                    // InternalBasicsParser.g:2944:3: ruleExtensionScalarValue
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


    // $ANTLR start "rule__ExtensionListValue__Alternatives_1"
    // InternalBasicsParser.g:2953:1: rule__ExtensionListValue__Alternatives_1 : ( ( LeftSquareBracketRightSquareBracket ) | ( ( rule__ExtensionListValue__Group_1_1__0 ) ) );
    public final void rule__ExtensionListValue__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2957:1: ( ( LeftSquareBracketRightSquareBracket ) | ( ( rule__ExtensionListValue__Group_1_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LeftSquareBracketRightSquareBracket) ) {
                alt13=1;
            }
            else if ( (LA13_0==LeftSquareBracket) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalBasicsParser.g:2958:2: ( LeftSquareBracketRightSquareBracket )
                    {
                    // InternalBasicsParser.g:2958:2: ( LeftSquareBracketRightSquareBracket )
                    // InternalBasicsParser.g:2959:3: LeftSquareBracketRightSquareBracket
                    {
                     before(grammarAccess.getExtensionListValueAccess().getLeftSquareBracketRightSquareBracketKeyword_1_0()); 
                    match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); 
                     after(grammarAccess.getExtensionListValueAccess().getLeftSquareBracketRightSquareBracketKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2964:2: ( ( rule__ExtensionListValue__Group_1_1__0 ) )
                    {
                    // InternalBasicsParser.g:2964:2: ( ( rule__ExtensionListValue__Group_1_1__0 ) )
                    // InternalBasicsParser.g:2965:3: ( rule__ExtensionListValue__Group_1_1__0 )
                    {
                     before(grammarAccess.getExtensionListValueAccess().getGroup_1_1()); 
                    // InternalBasicsParser.g:2966:3: ( rule__ExtensionListValue__Group_1_1__0 )
                    // InternalBasicsParser.g:2966:4: rule__ExtensionListValue__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionListValue__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getExtensionListValueAccess().getGroup_1_1()); 

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
    // $ANTLR end "rule__ExtensionListValue__Alternatives_1"


    // $ANTLR start "rule__ExtensionRefValue__RefKindAlternatives_1_0"
    // InternalBasicsParser.g:2974:1: rule__ExtensionRefValue__RefKindAlternatives_1_0 : ( ( Pub ) | ( Sub ) | ( Ss ) | ( Sc ) | ( As ) | ( Ac ) | ( Param ) );
    public final void rule__ExtensionRefValue__RefKindAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2978:1: ( ( Pub ) | ( Sub ) | ( Ss ) | ( Sc ) | ( As ) | ( Ac ) | ( Param ) )
            int alt14=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt14=1;
                }
                break;
            case Sub:
                {
                alt14=2;
                }
                break;
            case Ss:
                {
                alt14=3;
                }
                break;
            case Sc:
                {
                alt14=4;
                }
                break;
            case As:
                {
                alt14=5;
                }
                break;
            case Ac:
                {
                alt14=6;
                }
                break;
            case Param:
                {
                alt14=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalBasicsParser.g:2979:2: ( Pub )
                    {
                    // InternalBasicsParser.g:2979:2: ( Pub )
                    // InternalBasicsParser.g:2980:3: Pub
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0()); 
                    match(input,Pub,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2985:2: ( Sub )
                    {
                    // InternalBasicsParser.g:2985:2: ( Sub )
                    // InternalBasicsParser.g:2986:3: Sub
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1()); 
                    match(input,Sub,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2991:2: ( Ss )
                    {
                    // InternalBasicsParser.g:2991:2: ( Ss )
                    // InternalBasicsParser.g:2992:3: Ss
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2()); 
                    match(input,Ss,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2997:2: ( Sc )
                    {
                    // InternalBasicsParser.g:2997:2: ( Sc )
                    // InternalBasicsParser.g:2998:3: Sc
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3()); 
                    match(input,Sc,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:3003:2: ( As )
                    {
                    // InternalBasicsParser.g:3003:2: ( As )
                    // InternalBasicsParser.g:3004:3: As
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4()); 
                    match(input,As,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:3009:2: ( Ac )
                    {
                    // InternalBasicsParser.g:3009:2: ( Ac )
                    // InternalBasicsParser.g:3010:3: Ac
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5()); 
                    match(input,Ac,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:3015:2: ( Param )
                    {
                    // InternalBasicsParser.g:3015:2: ( Param )
                    // InternalBasicsParser.g:3016:3: Param
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
    // InternalBasicsParser.g:3025:1: rule__ExtensionScalarLiteral__Alternatives : ( ( RULE_BOOLEAN ) | ( RULE_DOUBLE ) | ( RULE_DECINT ) | ( RULE_INT ) | ( ruleExtensionKey ) );
    public final void rule__ExtensionScalarLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3029:1: ( ( RULE_BOOLEAN ) | ( RULE_DOUBLE ) | ( RULE_DECINT ) | ( RULE_INT ) | ( ruleExtensionKey ) )
            int alt15=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt15=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt15=2;
                }
                break;
            case RULE_DECINT:
                {
                alt15=3;
                }
                break;
            case RULE_INT:
                {
                alt15=4;
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
                alt15=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalBasicsParser.g:3030:2: ( RULE_BOOLEAN )
                    {
                    // InternalBasicsParser.g:3030:2: ( RULE_BOOLEAN )
                    // InternalBasicsParser.g:3031:3: RULE_BOOLEAN
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0()); 
                    match(input,RULE_BOOLEAN,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:3036:2: ( RULE_DOUBLE )
                    {
                    // InternalBasicsParser.g:3036:2: ( RULE_DOUBLE )
                    // InternalBasicsParser.g:3037:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:3042:2: ( RULE_DECINT )
                    {
                    // InternalBasicsParser.g:3042:2: ( RULE_DECINT )
                    // InternalBasicsParser.g:3043:3: RULE_DECINT
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2()); 
                    match(input,RULE_DECINT,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:3048:2: ( RULE_INT )
                    {
                    // InternalBasicsParser.g:3048:2: ( RULE_INT )
                    // InternalBasicsParser.g:3049:3: RULE_INT
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:3054:2: ( ruleExtensionKey )
                    {
                    // InternalBasicsParser.g:3054:2: ( ruleExtensionKey )
                    // InternalBasicsParser.g:3055:3: ruleExtensionKey
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
    // InternalBasicsParser.g:3064:1: rule__GlobalNamespace__Group__0 : rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1 ;
    public final void rule__GlobalNamespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3068:1: ( rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1 )
            // InternalBasicsParser.g:3069:2: rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1
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
    // InternalBasicsParser.g:3076:1: rule__GlobalNamespace__Group__0__Impl : ( () ) ;
    public final void rule__GlobalNamespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3080:1: ( ( () ) )
            // InternalBasicsParser.g:3081:1: ( () )
            {
            // InternalBasicsParser.g:3081:1: ( () )
            // InternalBasicsParser.g:3082:2: ()
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0()); 
            // InternalBasicsParser.g:3083:2: ()
            // InternalBasicsParser.g:3083:3: 
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
    // InternalBasicsParser.g:3091:1: rule__GlobalNamespace__Group__1 : rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2 ;
    public final void rule__GlobalNamespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3095:1: ( rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2 )
            // InternalBasicsParser.g:3096:2: rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2
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
    // InternalBasicsParser.g:3103:1: rule__GlobalNamespace__Group__1__Impl : ( GlobalNamespace ) ;
    public final void rule__GlobalNamespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3107:1: ( ( GlobalNamespace ) )
            // InternalBasicsParser.g:3108:1: ( GlobalNamespace )
            {
            // InternalBasicsParser.g:3108:1: ( GlobalNamespace )
            // InternalBasicsParser.g:3109:2: GlobalNamespace
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
    // InternalBasicsParser.g:3118:1: rule__GlobalNamespace__Group__2 : rule__GlobalNamespace__Group__2__Impl ;
    public final void rule__GlobalNamespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3122:1: ( rule__GlobalNamespace__Group__2__Impl )
            // InternalBasicsParser.g:3123:2: rule__GlobalNamespace__Group__2__Impl
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
    // InternalBasicsParser.g:3129:1: rule__GlobalNamespace__Group__2__Impl : ( ( rule__GlobalNamespace__Group_2__0 )? ) ;
    public final void rule__GlobalNamespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3133:1: ( ( ( rule__GlobalNamespace__Group_2__0 )? ) )
            // InternalBasicsParser.g:3134:1: ( ( rule__GlobalNamespace__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3134:1: ( ( rule__GlobalNamespace__Group_2__0 )? )
            // InternalBasicsParser.g:3135:2: ( rule__GlobalNamespace__Group_2__0 )?
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup_2()); 
            // InternalBasicsParser.g:3136:2: ( rule__GlobalNamespace__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LeftSquareBracket) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBasicsParser.g:3136:3: rule__GlobalNamespace__Group_2__0
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
    // InternalBasicsParser.g:3145:1: rule__GlobalNamespace__Group_2__0 : rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1 ;
    public final void rule__GlobalNamespace__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3149:1: ( rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1 )
            // InternalBasicsParser.g:3150:2: rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1
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
    // InternalBasicsParser.g:3157:1: rule__GlobalNamespace__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__GlobalNamespace__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3161:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3162:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3162:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3163:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3172:1: rule__GlobalNamespace__Group_2__1 : rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2 ;
    public final void rule__GlobalNamespace__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3176:1: ( rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2 )
            // InternalBasicsParser.g:3177:2: rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2
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
    // InternalBasicsParser.g:3184:1: rule__GlobalNamespace__Group_2__1__Impl : ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) ) ;
    public final void rule__GlobalNamespace__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3188:1: ( ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3189:1: ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3189:1: ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3190:2: ( rule__GlobalNamespace__PartsAssignment_2_1 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3191:2: ( rule__GlobalNamespace__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3191:3: rule__GlobalNamespace__PartsAssignment_2_1
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
    // InternalBasicsParser.g:3199:1: rule__GlobalNamespace__Group_2__2 : rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3 ;
    public final void rule__GlobalNamespace__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3203:1: ( rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3 )
            // InternalBasicsParser.g:3204:2: rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3
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
    // InternalBasicsParser.g:3211:1: rule__GlobalNamespace__Group_2__2__Impl : ( ( rule__GlobalNamespace__Group_2_2__0 )* ) ;
    public final void rule__GlobalNamespace__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3215:1: ( ( ( rule__GlobalNamespace__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3216:1: ( ( rule__GlobalNamespace__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3216:1: ( ( rule__GlobalNamespace__Group_2_2__0 )* )
            // InternalBasicsParser.g:3217:2: ( rule__GlobalNamespace__Group_2_2__0 )*
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3218:2: ( rule__GlobalNamespace__Group_2_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Comma) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBasicsParser.g:3218:3: rule__GlobalNamespace__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__GlobalNamespace__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalBasicsParser.g:3226:1: rule__GlobalNamespace__Group_2__3 : rule__GlobalNamespace__Group_2__3__Impl ;
    public final void rule__GlobalNamespace__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3230:1: ( rule__GlobalNamespace__Group_2__3__Impl )
            // InternalBasicsParser.g:3231:2: rule__GlobalNamespace__Group_2__3__Impl
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
    // InternalBasicsParser.g:3237:1: rule__GlobalNamespace__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__GlobalNamespace__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3241:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3242:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3242:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3243:2: RightSquareBracket
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
    // InternalBasicsParser.g:3253:1: rule__GlobalNamespace__Group_2_2__0 : rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1 ;
    public final void rule__GlobalNamespace__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3257:1: ( rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1 )
            // InternalBasicsParser.g:3258:2: rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1
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
    // InternalBasicsParser.g:3265:1: rule__GlobalNamespace__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__GlobalNamespace__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3269:1: ( ( Comma ) )
            // InternalBasicsParser.g:3270:1: ( Comma )
            {
            // InternalBasicsParser.g:3270:1: ( Comma )
            // InternalBasicsParser.g:3271:2: Comma
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
    // InternalBasicsParser.g:3280:1: rule__GlobalNamespace__Group_2_2__1 : rule__GlobalNamespace__Group_2_2__1__Impl ;
    public final void rule__GlobalNamespace__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3284:1: ( rule__GlobalNamespace__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3285:2: rule__GlobalNamespace__Group_2_2__1__Impl
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
    // InternalBasicsParser.g:3291:1: rule__GlobalNamespace__Group_2_2__1__Impl : ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) ) ;
    public final void rule__GlobalNamespace__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3295:1: ( ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3296:1: ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3296:1: ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3297:2: ( rule__GlobalNamespace__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3298:2: ( rule__GlobalNamespace__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3298:3: rule__GlobalNamespace__PartsAssignment_2_2_1
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
    // InternalBasicsParser.g:3307:1: rule__RelativeNamespace_Impl__Group__0 : rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1 ;
    public final void rule__RelativeNamespace_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3311:1: ( rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1 )
            // InternalBasicsParser.g:3312:2: rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1
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
    // InternalBasicsParser.g:3319:1: rule__RelativeNamespace_Impl__Group__0__Impl : ( () ) ;
    public final void rule__RelativeNamespace_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3323:1: ( ( () ) )
            // InternalBasicsParser.g:3324:1: ( () )
            {
            // InternalBasicsParser.g:3324:1: ( () )
            // InternalBasicsParser.g:3325:2: ()
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0()); 
            // InternalBasicsParser.g:3326:2: ()
            // InternalBasicsParser.g:3326:3: 
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
    // InternalBasicsParser.g:3334:1: rule__RelativeNamespace_Impl__Group__1 : rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2 ;
    public final void rule__RelativeNamespace_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3338:1: ( rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2 )
            // InternalBasicsParser.g:3339:2: rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2
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
    // InternalBasicsParser.g:3346:1: rule__RelativeNamespace_Impl__Group__1__Impl : ( RelativeNamespace ) ;
    public final void rule__RelativeNamespace_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3350:1: ( ( RelativeNamespace ) )
            // InternalBasicsParser.g:3351:1: ( RelativeNamespace )
            {
            // InternalBasicsParser.g:3351:1: ( RelativeNamespace )
            // InternalBasicsParser.g:3352:2: RelativeNamespace
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
    // InternalBasicsParser.g:3361:1: rule__RelativeNamespace_Impl__Group__2 : rule__RelativeNamespace_Impl__Group__2__Impl ;
    public final void rule__RelativeNamespace_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3365:1: ( rule__RelativeNamespace_Impl__Group__2__Impl )
            // InternalBasicsParser.g:3366:2: rule__RelativeNamespace_Impl__Group__2__Impl
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
    // InternalBasicsParser.g:3372:1: rule__RelativeNamespace_Impl__Group__2__Impl : ( ( rule__RelativeNamespace_Impl__Group_2__0 )? ) ;
    public final void rule__RelativeNamespace_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3376:1: ( ( ( rule__RelativeNamespace_Impl__Group_2__0 )? ) )
            // InternalBasicsParser.g:3377:1: ( ( rule__RelativeNamespace_Impl__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3377:1: ( ( rule__RelativeNamespace_Impl__Group_2__0 )? )
            // InternalBasicsParser.g:3378:2: ( rule__RelativeNamespace_Impl__Group_2__0 )?
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2()); 
            // InternalBasicsParser.g:3379:2: ( rule__RelativeNamespace_Impl__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LeftSquareBracket) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBasicsParser.g:3379:3: rule__RelativeNamespace_Impl__Group_2__0
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
    // InternalBasicsParser.g:3388:1: rule__RelativeNamespace_Impl__Group_2__0 : rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1 ;
    public final void rule__RelativeNamespace_Impl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3392:1: ( rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1 )
            // InternalBasicsParser.g:3393:2: rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1
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
    // InternalBasicsParser.g:3400:1: rule__RelativeNamespace_Impl__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3404:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3405:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3405:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3406:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3415:1: rule__RelativeNamespace_Impl__Group_2__1 : rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2 ;
    public final void rule__RelativeNamespace_Impl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3419:1: ( rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2 )
            // InternalBasicsParser.g:3420:2: rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2
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
    // InternalBasicsParser.g:3427:1: rule__RelativeNamespace_Impl__Group_2__1__Impl : ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3431:1: ( ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3432:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3432:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3433:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3434:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3434:3: rule__RelativeNamespace_Impl__PartsAssignment_2_1
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
    // InternalBasicsParser.g:3442:1: rule__RelativeNamespace_Impl__Group_2__2 : rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3 ;
    public final void rule__RelativeNamespace_Impl__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3446:1: ( rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3 )
            // InternalBasicsParser.g:3447:2: rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3
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
    // InternalBasicsParser.g:3454:1: rule__RelativeNamespace_Impl__Group_2__2__Impl : ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3458:1: ( ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3459:1: ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3459:1: ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* )
            // InternalBasicsParser.g:3460:2: ( rule__RelativeNamespace_Impl__Group_2_2__0 )*
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3461:2: ( rule__RelativeNamespace_Impl__Group_2_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==Comma) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBasicsParser.g:3461:3: rule__RelativeNamespace_Impl__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__RelativeNamespace_Impl__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalBasicsParser.g:3469:1: rule__RelativeNamespace_Impl__Group_2__3 : rule__RelativeNamespace_Impl__Group_2__3__Impl ;
    public final void rule__RelativeNamespace_Impl__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3473:1: ( rule__RelativeNamespace_Impl__Group_2__3__Impl )
            // InternalBasicsParser.g:3474:2: rule__RelativeNamespace_Impl__Group_2__3__Impl
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
    // InternalBasicsParser.g:3480:1: rule__RelativeNamespace_Impl__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3484:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3485:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3485:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3486:2: RightSquareBracket
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
    // InternalBasicsParser.g:3496:1: rule__RelativeNamespace_Impl__Group_2_2__0 : rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1 ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3500:1: ( rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1 )
            // InternalBasicsParser.g:3501:2: rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1
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
    // InternalBasicsParser.g:3508:1: rule__RelativeNamespace_Impl__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3512:1: ( ( Comma ) )
            // InternalBasicsParser.g:3513:1: ( Comma )
            {
            // InternalBasicsParser.g:3513:1: ( Comma )
            // InternalBasicsParser.g:3514:2: Comma
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
    // InternalBasicsParser.g:3523:1: rule__RelativeNamespace_Impl__Group_2_2__1 : rule__RelativeNamespace_Impl__Group_2_2__1__Impl ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3527:1: ( rule__RelativeNamespace_Impl__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3528:2: rule__RelativeNamespace_Impl__Group_2_2__1__Impl
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
    // InternalBasicsParser.g:3534:1: rule__RelativeNamespace_Impl__Group_2_2__1__Impl : ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) ) ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3538:1: ( ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3539:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3539:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3540:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3541:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3541:3: rule__RelativeNamespace_Impl__PartsAssignment_2_2_1
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
    // InternalBasicsParser.g:3550:1: rule__PrivateNamespace__Group__0 : rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1 ;
    public final void rule__PrivateNamespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3554:1: ( rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1 )
            // InternalBasicsParser.g:3555:2: rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1
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
    // InternalBasicsParser.g:3562:1: rule__PrivateNamespace__Group__0__Impl : ( () ) ;
    public final void rule__PrivateNamespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3566:1: ( ( () ) )
            // InternalBasicsParser.g:3567:1: ( () )
            {
            // InternalBasicsParser.g:3567:1: ( () )
            // InternalBasicsParser.g:3568:2: ()
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0()); 
            // InternalBasicsParser.g:3569:2: ()
            // InternalBasicsParser.g:3569:3: 
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
    // InternalBasicsParser.g:3577:1: rule__PrivateNamespace__Group__1 : rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2 ;
    public final void rule__PrivateNamespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3581:1: ( rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2 )
            // InternalBasicsParser.g:3582:2: rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2
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
    // InternalBasicsParser.g:3589:1: rule__PrivateNamespace__Group__1__Impl : ( PrivateNamespace ) ;
    public final void rule__PrivateNamespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3593:1: ( ( PrivateNamespace ) )
            // InternalBasicsParser.g:3594:1: ( PrivateNamespace )
            {
            // InternalBasicsParser.g:3594:1: ( PrivateNamespace )
            // InternalBasicsParser.g:3595:2: PrivateNamespace
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
    // InternalBasicsParser.g:3604:1: rule__PrivateNamespace__Group__2 : rule__PrivateNamespace__Group__2__Impl ;
    public final void rule__PrivateNamespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3608:1: ( rule__PrivateNamespace__Group__2__Impl )
            // InternalBasicsParser.g:3609:2: rule__PrivateNamespace__Group__2__Impl
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
    // InternalBasicsParser.g:3615:1: rule__PrivateNamespace__Group__2__Impl : ( ( rule__PrivateNamespace__Group_2__0 )? ) ;
    public final void rule__PrivateNamespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3619:1: ( ( ( rule__PrivateNamespace__Group_2__0 )? ) )
            // InternalBasicsParser.g:3620:1: ( ( rule__PrivateNamespace__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3620:1: ( ( rule__PrivateNamespace__Group_2__0 )? )
            // InternalBasicsParser.g:3621:2: ( rule__PrivateNamespace__Group_2__0 )?
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup_2()); 
            // InternalBasicsParser.g:3622:2: ( rule__PrivateNamespace__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LeftSquareBracket) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBasicsParser.g:3622:3: rule__PrivateNamespace__Group_2__0
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
    // InternalBasicsParser.g:3631:1: rule__PrivateNamespace__Group_2__0 : rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1 ;
    public final void rule__PrivateNamespace__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3635:1: ( rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1 )
            // InternalBasicsParser.g:3636:2: rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1
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
    // InternalBasicsParser.g:3643:1: rule__PrivateNamespace__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__PrivateNamespace__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3647:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3648:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3648:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3649:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3658:1: rule__PrivateNamespace__Group_2__1 : rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2 ;
    public final void rule__PrivateNamespace__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3662:1: ( rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2 )
            // InternalBasicsParser.g:3663:2: rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2
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
    // InternalBasicsParser.g:3670:1: rule__PrivateNamespace__Group_2__1__Impl : ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) ) ;
    public final void rule__PrivateNamespace__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3674:1: ( ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3675:1: ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3675:1: ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3676:2: ( rule__PrivateNamespace__PartsAssignment_2_1 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3677:2: ( rule__PrivateNamespace__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3677:3: rule__PrivateNamespace__PartsAssignment_2_1
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
    // InternalBasicsParser.g:3685:1: rule__PrivateNamespace__Group_2__2 : rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3 ;
    public final void rule__PrivateNamespace__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3689:1: ( rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3 )
            // InternalBasicsParser.g:3690:2: rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3
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
    // InternalBasicsParser.g:3697:1: rule__PrivateNamespace__Group_2__2__Impl : ( ( rule__PrivateNamespace__Group_2_2__0 )* ) ;
    public final void rule__PrivateNamespace__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3701:1: ( ( ( rule__PrivateNamespace__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3702:1: ( ( rule__PrivateNamespace__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3702:1: ( ( rule__PrivateNamespace__Group_2_2__0 )* )
            // InternalBasicsParser.g:3703:2: ( rule__PrivateNamespace__Group_2_2__0 )*
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3704:2: ( rule__PrivateNamespace__Group_2_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Comma) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBasicsParser.g:3704:3: rule__PrivateNamespace__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__PrivateNamespace__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalBasicsParser.g:3712:1: rule__PrivateNamespace__Group_2__3 : rule__PrivateNamespace__Group_2__3__Impl ;
    public final void rule__PrivateNamespace__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3716:1: ( rule__PrivateNamespace__Group_2__3__Impl )
            // InternalBasicsParser.g:3717:2: rule__PrivateNamespace__Group_2__3__Impl
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
    // InternalBasicsParser.g:3723:1: rule__PrivateNamespace__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__PrivateNamespace__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3727:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3728:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3728:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3729:2: RightSquareBracket
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
    // InternalBasicsParser.g:3739:1: rule__PrivateNamespace__Group_2_2__0 : rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1 ;
    public final void rule__PrivateNamespace__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3743:1: ( rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1 )
            // InternalBasicsParser.g:3744:2: rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1
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
    // InternalBasicsParser.g:3751:1: rule__PrivateNamespace__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__PrivateNamespace__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3755:1: ( ( Comma ) )
            // InternalBasicsParser.g:3756:1: ( Comma )
            {
            // InternalBasicsParser.g:3756:1: ( Comma )
            // InternalBasicsParser.g:3757:2: Comma
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
    // InternalBasicsParser.g:3766:1: rule__PrivateNamespace__Group_2_2__1 : rule__PrivateNamespace__Group_2_2__1__Impl ;
    public final void rule__PrivateNamespace__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3770:1: ( rule__PrivateNamespace__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3771:2: rule__PrivateNamespace__Group_2_2__1__Impl
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
    // InternalBasicsParser.g:3777:1: rule__PrivateNamespace__Group_2_2__1__Impl : ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) ) ;
    public final void rule__PrivateNamespace__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3781:1: ( ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3782:1: ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3782:1: ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3783:2: ( rule__PrivateNamespace__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3784:2: ( rule__PrivateNamespace__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3784:3: rule__PrivateNamespace__PartsAssignment_2_2_1
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
    // InternalBasicsParser.g:3793:1: rule__ParameterListType__Group__0 : rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1 ;
    public final void rule__ParameterListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3797:1: ( rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1 )
            // InternalBasicsParser.g:3798:2: rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1
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
    // InternalBasicsParser.g:3805:1: rule__ParameterListType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3809:1: ( ( () ) )
            // InternalBasicsParser.g:3810:1: ( () )
            {
            // InternalBasicsParser.g:3810:1: ( () )
            // InternalBasicsParser.g:3811:2: ()
            {
             before(grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0()); 
            // InternalBasicsParser.g:3812:2: ()
            // InternalBasicsParser.g:3812:3: 
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
    // InternalBasicsParser.g:3820:1: rule__ParameterListType__Group__1 : rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2 ;
    public final void rule__ParameterListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3824:1: ( rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2 )
            // InternalBasicsParser.g:3825:2: rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2
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
    // InternalBasicsParser.g:3832:1: rule__ParameterListType__Group__1__Impl : ( List ) ;
    public final void rule__ParameterListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3836:1: ( ( List ) )
            // InternalBasicsParser.g:3837:1: ( List )
            {
            // InternalBasicsParser.g:3837:1: ( List )
            // InternalBasicsParser.g:3838:2: List
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
    // InternalBasicsParser.g:3847:1: rule__ParameterListType__Group__2 : rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3 ;
    public final void rule__ParameterListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3851:1: ( rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3 )
            // InternalBasicsParser.g:3852:2: rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3
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
    // InternalBasicsParser.g:3859:1: rule__ParameterListType__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3863:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3864:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3864:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3865:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3874:1: rule__ParameterListType__Group__3 : rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4 ;
    public final void rule__ParameterListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3878:1: ( rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4 )
            // InternalBasicsParser.g:3879:2: rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4
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
    // InternalBasicsParser.g:3886:1: rule__ParameterListType__Group__3__Impl : ( ( rule__ParameterListType__SequenceAssignment_3 ) ) ;
    public final void rule__ParameterListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3890:1: ( ( ( rule__ParameterListType__SequenceAssignment_3 ) ) )
            // InternalBasicsParser.g:3891:1: ( ( rule__ParameterListType__SequenceAssignment_3 ) )
            {
            // InternalBasicsParser.g:3891:1: ( ( rule__ParameterListType__SequenceAssignment_3 ) )
            // InternalBasicsParser.g:3892:2: ( rule__ParameterListType__SequenceAssignment_3 )
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_3()); 
            // InternalBasicsParser.g:3893:2: ( rule__ParameterListType__SequenceAssignment_3 )
            // InternalBasicsParser.g:3893:3: rule__ParameterListType__SequenceAssignment_3
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
    // InternalBasicsParser.g:3901:1: rule__ParameterListType__Group__4 : rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5 ;
    public final void rule__ParameterListType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3905:1: ( rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5 )
            // InternalBasicsParser.g:3906:2: rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5
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
    // InternalBasicsParser.g:3913:1: rule__ParameterListType__Group__4__Impl : ( ( rule__ParameterListType__Group_4__0 )* ) ;
    public final void rule__ParameterListType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3917:1: ( ( ( rule__ParameterListType__Group_4__0 )* ) )
            // InternalBasicsParser.g:3918:1: ( ( rule__ParameterListType__Group_4__0 )* )
            {
            // InternalBasicsParser.g:3918:1: ( ( rule__ParameterListType__Group_4__0 )* )
            // InternalBasicsParser.g:3919:2: ( rule__ParameterListType__Group_4__0 )*
            {
             before(grammarAccess.getParameterListTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:3920:2: ( rule__ParameterListType__Group_4__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==Comma) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBasicsParser.g:3920:3: rule__ParameterListType__Group_4__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__ParameterListType__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalBasicsParser.g:3928:1: rule__ParameterListType__Group__5 : rule__ParameterListType__Group__5__Impl ;
    public final void rule__ParameterListType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3932:1: ( rule__ParameterListType__Group__5__Impl )
            // InternalBasicsParser.g:3933:2: rule__ParameterListType__Group__5__Impl
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
    // InternalBasicsParser.g:3939:1: rule__ParameterListType__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterListType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3943:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3944:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3944:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3945:2: RightSquareBracket
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
    // InternalBasicsParser.g:3955:1: rule__ParameterListType__Group_4__0 : rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1 ;
    public final void rule__ParameterListType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3959:1: ( rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1 )
            // InternalBasicsParser.g:3960:2: rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1
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
    // InternalBasicsParser.g:3967:1: rule__ParameterListType__Group_4__0__Impl : ( Comma ) ;
    public final void rule__ParameterListType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3971:1: ( ( Comma ) )
            // InternalBasicsParser.g:3972:1: ( Comma )
            {
            // InternalBasicsParser.g:3972:1: ( Comma )
            // InternalBasicsParser.g:3973:2: Comma
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
    // InternalBasicsParser.g:3982:1: rule__ParameterListType__Group_4__1 : rule__ParameterListType__Group_4__1__Impl ;
    public final void rule__ParameterListType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3986:1: ( rule__ParameterListType__Group_4__1__Impl )
            // InternalBasicsParser.g:3987:2: rule__ParameterListType__Group_4__1__Impl
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
    // InternalBasicsParser.g:3993:1: rule__ParameterListType__Group_4__1__Impl : ( ( rule__ParameterListType__SequenceAssignment_4_1 ) ) ;
    public final void rule__ParameterListType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3997:1: ( ( ( rule__ParameterListType__SequenceAssignment_4_1 ) ) )
            // InternalBasicsParser.g:3998:1: ( ( rule__ParameterListType__SequenceAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:3998:1: ( ( rule__ParameterListType__SequenceAssignment_4_1 ) )
            // InternalBasicsParser.g:3999:2: ( rule__ParameterListType__SequenceAssignment_4_1 )
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_4_1()); 
            // InternalBasicsParser.g:4000:2: ( rule__ParameterListType__SequenceAssignment_4_1 )
            // InternalBasicsParser.g:4000:3: rule__ParameterListType__SequenceAssignment_4_1
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
    // InternalBasicsParser.g:4009:1: rule__ParameterStructType__Group__0 : rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1 ;
    public final void rule__ParameterStructType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4013:1: ( rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1 )
            // InternalBasicsParser.g:4014:2: rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1
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
    // InternalBasicsParser.g:4021:1: rule__ParameterStructType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStructType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4025:1: ( ( () ) )
            // InternalBasicsParser.g:4026:1: ( () )
            {
            // InternalBasicsParser.g:4026:1: ( () )
            // InternalBasicsParser.g:4027:2: ()
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0()); 
            // InternalBasicsParser.g:4028:2: ()
            // InternalBasicsParser.g:4028:3: 
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
    // InternalBasicsParser.g:4036:1: rule__ParameterStructType__Group__1 : rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2 ;
    public final void rule__ParameterStructType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4040:1: ( rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2 )
            // InternalBasicsParser.g:4041:2: rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2
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
    // InternalBasicsParser.g:4048:1: rule__ParameterStructType__Group__1__Impl : ( Struct ) ;
    public final void rule__ParameterStructType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4052:1: ( ( Struct ) )
            // InternalBasicsParser.g:4053:1: ( Struct )
            {
            // InternalBasicsParser.g:4053:1: ( Struct )
            // InternalBasicsParser.g:4054:2: Struct
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
    // InternalBasicsParser.g:4063:1: rule__ParameterStructType__Group__2 : rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3 ;
    public final void rule__ParameterStructType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4067:1: ( rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3 )
            // InternalBasicsParser.g:4068:2: rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3
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
    // InternalBasicsParser.g:4075:1: rule__ParameterStructType__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterStructType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4079:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:4080:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:4080:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:4081:2: LeftSquareBracket
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
    // InternalBasicsParser.g:4090:1: rule__ParameterStructType__Group__3 : rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4 ;
    public final void rule__ParameterStructType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4094:1: ( rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4 )
            // InternalBasicsParser.g:4095:2: rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4
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
    // InternalBasicsParser.g:4102:1: rule__ParameterStructType__Group__3__Impl : ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) ) ;
    public final void rule__ParameterStructType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4106:1: ( ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) ) )
            // InternalBasicsParser.g:4107:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) )
            {
            // InternalBasicsParser.g:4107:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) )
            // InternalBasicsParser.g:4108:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_3()); 
            // InternalBasicsParser.g:4109:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 )
            // InternalBasicsParser.g:4109:3: rule__ParameterStructType__ParameterstructypetmemberAssignment_3
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
    // InternalBasicsParser.g:4117:1: rule__ParameterStructType__Group__4 : rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5 ;
    public final void rule__ParameterStructType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4121:1: ( rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5 )
            // InternalBasicsParser.g:4122:2: rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5
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
    // InternalBasicsParser.g:4129:1: rule__ParameterStructType__Group__4__Impl : ( ( rule__ParameterStructType__Group_4__0 )* ) ;
    public final void rule__ParameterStructType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4133:1: ( ( ( rule__ParameterStructType__Group_4__0 )* ) )
            // InternalBasicsParser.g:4134:1: ( ( rule__ParameterStructType__Group_4__0 )* )
            {
            // InternalBasicsParser.g:4134:1: ( ( rule__ParameterStructType__Group_4__0 )* )
            // InternalBasicsParser.g:4135:2: ( rule__ParameterStructType__Group_4__0 )*
            {
             before(grammarAccess.getParameterStructTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:4136:2: ( rule__ParameterStructType__Group_4__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Comma) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBasicsParser.g:4136:3: rule__ParameterStructType__Group_4__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__ParameterStructType__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalBasicsParser.g:4144:1: rule__ParameterStructType__Group__5 : rule__ParameterStructType__Group__5__Impl ;
    public final void rule__ParameterStructType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4148:1: ( rule__ParameterStructType__Group__5__Impl )
            // InternalBasicsParser.g:4149:2: rule__ParameterStructType__Group__5__Impl
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
    // InternalBasicsParser.g:4155:1: rule__ParameterStructType__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterStructType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4159:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:4160:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:4160:1: ( RightSquareBracket )
            // InternalBasicsParser.g:4161:2: RightSquareBracket
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
    // InternalBasicsParser.g:4171:1: rule__ParameterStructType__Group_4__0 : rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1 ;
    public final void rule__ParameterStructType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4175:1: ( rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1 )
            // InternalBasicsParser.g:4176:2: rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1
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
    // InternalBasicsParser.g:4183:1: rule__ParameterStructType__Group_4__0__Impl : ( Comma ) ;
    public final void rule__ParameterStructType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4187:1: ( ( Comma ) )
            // InternalBasicsParser.g:4188:1: ( Comma )
            {
            // InternalBasicsParser.g:4188:1: ( Comma )
            // InternalBasicsParser.g:4189:2: Comma
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
    // InternalBasicsParser.g:4198:1: rule__ParameterStructType__Group_4__1 : rule__ParameterStructType__Group_4__1__Impl ;
    public final void rule__ParameterStructType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4202:1: ( rule__ParameterStructType__Group_4__1__Impl )
            // InternalBasicsParser.g:4203:2: rule__ParameterStructType__Group_4__1__Impl
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
    // InternalBasicsParser.g:4209:1: rule__ParameterStructType__Group_4__1__Impl : ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) ) ;
    public final void rule__ParameterStructType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4213:1: ( ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) ) )
            // InternalBasicsParser.g:4214:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:4214:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) )
            // InternalBasicsParser.g:4215:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_4_1()); 
            // InternalBasicsParser.g:4216:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 )
            // InternalBasicsParser.g:4216:3: rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1
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
    // InternalBasicsParser.g:4225:1: rule__ParameterIntegerType__Group__0 : rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1 ;
    public final void rule__ParameterIntegerType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4229:1: ( rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1 )
            // InternalBasicsParser.g:4230:2: rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1
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
    // InternalBasicsParser.g:4237:1: rule__ParameterIntegerType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterIntegerType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4241:1: ( ( () ) )
            // InternalBasicsParser.g:4242:1: ( () )
            {
            // InternalBasicsParser.g:4242:1: ( () )
            // InternalBasicsParser.g:4243:2: ()
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0()); 
            // InternalBasicsParser.g:4244:2: ()
            // InternalBasicsParser.g:4244:3: 
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
    // InternalBasicsParser.g:4252:1: rule__ParameterIntegerType__Group__1 : rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2 ;
    public final void rule__ParameterIntegerType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4256:1: ( rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2 )
            // InternalBasicsParser.g:4257:2: rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2
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
    // InternalBasicsParser.g:4264:1: rule__ParameterIntegerType__Group__1__Impl : ( Integer ) ;
    public final void rule__ParameterIntegerType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4268:1: ( ( Integer ) )
            // InternalBasicsParser.g:4269:1: ( Integer )
            {
            // InternalBasicsParser.g:4269:1: ( Integer )
            // InternalBasicsParser.g:4270:2: Integer
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
    // InternalBasicsParser.g:4279:1: rule__ParameterIntegerType__Group__2 : rule__ParameterIntegerType__Group__2__Impl ;
    public final void rule__ParameterIntegerType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4283:1: ( rule__ParameterIntegerType__Group__2__Impl )
            // InternalBasicsParser.g:4284:2: rule__ParameterIntegerType__Group__2__Impl
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
    // InternalBasicsParser.g:4290:1: rule__ParameterIntegerType__Group__2__Impl : ( ( rule__ParameterIntegerType__Group_2__0 )? ) ;
    public final void rule__ParameterIntegerType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4294:1: ( ( ( rule__ParameterIntegerType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4295:1: ( ( rule__ParameterIntegerType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4295:1: ( ( rule__ParameterIntegerType__Group_2__0 )? )
            // InternalBasicsParser.g:4296:2: ( rule__ParameterIntegerType__Group_2__0 )?
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4297:2: ( rule__ParameterIntegerType__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Default) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBasicsParser.g:4297:3: rule__ParameterIntegerType__Group_2__0
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
    // InternalBasicsParser.g:4306:1: rule__ParameterIntegerType__Group_2__0 : rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1 ;
    public final void rule__ParameterIntegerType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4310:1: ( rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1 )
            // InternalBasicsParser.g:4311:2: rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1
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
    // InternalBasicsParser.g:4318:1: rule__ParameterIntegerType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterIntegerType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4322:1: ( ( Default ) )
            // InternalBasicsParser.g:4323:1: ( Default )
            {
            // InternalBasicsParser.g:4323:1: ( Default )
            // InternalBasicsParser.g:4324:2: Default
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
    // InternalBasicsParser.g:4333:1: rule__ParameterIntegerType__Group_2__1 : rule__ParameterIntegerType__Group_2__1__Impl ;
    public final void rule__ParameterIntegerType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4337:1: ( rule__ParameterIntegerType__Group_2__1__Impl )
            // InternalBasicsParser.g:4338:2: rule__ParameterIntegerType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4344:1: rule__ParameterIntegerType__Group_2__1__Impl : ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterIntegerType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4348:1: ( ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4349:1: ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4349:1: ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4350:2: ( rule__ParameterIntegerType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4351:2: ( rule__ParameterIntegerType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4351:3: rule__ParameterIntegerType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4360:1: rule__ParameterStringType__Group__0 : rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1 ;
    public final void rule__ParameterStringType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4364:1: ( rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1 )
            // InternalBasicsParser.g:4365:2: rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1
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
    // InternalBasicsParser.g:4372:1: rule__ParameterStringType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStringType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4376:1: ( ( () ) )
            // InternalBasicsParser.g:4377:1: ( () )
            {
            // InternalBasicsParser.g:4377:1: ( () )
            // InternalBasicsParser.g:4378:2: ()
            {
             before(grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0()); 
            // InternalBasicsParser.g:4379:2: ()
            // InternalBasicsParser.g:4379:3: 
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
    // InternalBasicsParser.g:4387:1: rule__ParameterStringType__Group__1 : rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2 ;
    public final void rule__ParameterStringType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4391:1: ( rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2 )
            // InternalBasicsParser.g:4392:2: rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2
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
    // InternalBasicsParser.g:4399:1: rule__ParameterStringType__Group__1__Impl : ( String ) ;
    public final void rule__ParameterStringType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4403:1: ( ( String ) )
            // InternalBasicsParser.g:4404:1: ( String )
            {
            // InternalBasicsParser.g:4404:1: ( String )
            // InternalBasicsParser.g:4405:2: String
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
    // InternalBasicsParser.g:4414:1: rule__ParameterStringType__Group__2 : rule__ParameterStringType__Group__2__Impl ;
    public final void rule__ParameterStringType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4418:1: ( rule__ParameterStringType__Group__2__Impl )
            // InternalBasicsParser.g:4419:2: rule__ParameterStringType__Group__2__Impl
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
    // InternalBasicsParser.g:4425:1: rule__ParameterStringType__Group__2__Impl : ( ( rule__ParameterStringType__Group_2__0 )? ) ;
    public final void rule__ParameterStringType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4429:1: ( ( ( rule__ParameterStringType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4430:1: ( ( rule__ParameterStringType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4430:1: ( ( rule__ParameterStringType__Group_2__0 )? )
            // InternalBasicsParser.g:4431:2: ( rule__ParameterStringType__Group_2__0 )?
            {
             before(grammarAccess.getParameterStringTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4432:2: ( rule__ParameterStringType__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Default) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBasicsParser.g:4432:3: rule__ParameterStringType__Group_2__0
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
    // InternalBasicsParser.g:4441:1: rule__ParameterStringType__Group_2__0 : rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1 ;
    public final void rule__ParameterStringType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4445:1: ( rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1 )
            // InternalBasicsParser.g:4446:2: rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1
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
    // InternalBasicsParser.g:4453:1: rule__ParameterStringType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterStringType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4457:1: ( ( Default ) )
            // InternalBasicsParser.g:4458:1: ( Default )
            {
            // InternalBasicsParser.g:4458:1: ( Default )
            // InternalBasicsParser.g:4459:2: Default
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
    // InternalBasicsParser.g:4468:1: rule__ParameterStringType__Group_2__1 : rule__ParameterStringType__Group_2__1__Impl ;
    public final void rule__ParameterStringType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4472:1: ( rule__ParameterStringType__Group_2__1__Impl )
            // InternalBasicsParser.g:4473:2: rule__ParameterStringType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4479:1: rule__ParameterStringType__Group_2__1__Impl : ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterStringType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4483:1: ( ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4484:1: ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4484:1: ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4485:2: ( rule__ParameterStringType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterStringTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4486:2: ( rule__ParameterStringType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4486:3: rule__ParameterStringType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4495:1: rule__ParameterDoubleType__Group__0 : rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1 ;
    public final void rule__ParameterDoubleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4499:1: ( rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1 )
            // InternalBasicsParser.g:4500:2: rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1
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
    // InternalBasicsParser.g:4507:1: rule__ParameterDoubleType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterDoubleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4511:1: ( ( () ) )
            // InternalBasicsParser.g:4512:1: ( () )
            {
            // InternalBasicsParser.g:4512:1: ( () )
            // InternalBasicsParser.g:4513:2: ()
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0()); 
            // InternalBasicsParser.g:4514:2: ()
            // InternalBasicsParser.g:4514:3: 
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
    // InternalBasicsParser.g:4522:1: rule__ParameterDoubleType__Group__1 : rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2 ;
    public final void rule__ParameterDoubleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4526:1: ( rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2 )
            // InternalBasicsParser.g:4527:2: rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2
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
    // InternalBasicsParser.g:4534:1: rule__ParameterDoubleType__Group__1__Impl : ( Double ) ;
    public final void rule__ParameterDoubleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4538:1: ( ( Double ) )
            // InternalBasicsParser.g:4539:1: ( Double )
            {
            // InternalBasicsParser.g:4539:1: ( Double )
            // InternalBasicsParser.g:4540:2: Double
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
    // InternalBasicsParser.g:4549:1: rule__ParameterDoubleType__Group__2 : rule__ParameterDoubleType__Group__2__Impl ;
    public final void rule__ParameterDoubleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4553:1: ( rule__ParameterDoubleType__Group__2__Impl )
            // InternalBasicsParser.g:4554:2: rule__ParameterDoubleType__Group__2__Impl
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
    // InternalBasicsParser.g:4560:1: rule__ParameterDoubleType__Group__2__Impl : ( ( rule__ParameterDoubleType__Group_2__0 )? ) ;
    public final void rule__ParameterDoubleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4564:1: ( ( ( rule__ParameterDoubleType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4565:1: ( ( rule__ParameterDoubleType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4565:1: ( ( rule__ParameterDoubleType__Group_2__0 )? )
            // InternalBasicsParser.g:4566:2: ( rule__ParameterDoubleType__Group_2__0 )?
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4567:2: ( rule__ParameterDoubleType__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Default) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBasicsParser.g:4567:3: rule__ParameterDoubleType__Group_2__0
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
    // InternalBasicsParser.g:4576:1: rule__ParameterDoubleType__Group_2__0 : rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1 ;
    public final void rule__ParameterDoubleType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4580:1: ( rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1 )
            // InternalBasicsParser.g:4581:2: rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1
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
    // InternalBasicsParser.g:4588:1: rule__ParameterDoubleType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterDoubleType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4592:1: ( ( Default ) )
            // InternalBasicsParser.g:4593:1: ( Default )
            {
            // InternalBasicsParser.g:4593:1: ( Default )
            // InternalBasicsParser.g:4594:2: Default
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
    // InternalBasicsParser.g:4603:1: rule__ParameterDoubleType__Group_2__1 : rule__ParameterDoubleType__Group_2__1__Impl ;
    public final void rule__ParameterDoubleType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4607:1: ( rule__ParameterDoubleType__Group_2__1__Impl )
            // InternalBasicsParser.g:4608:2: rule__ParameterDoubleType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4614:1: rule__ParameterDoubleType__Group_2__1__Impl : ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterDoubleType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4618:1: ( ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4619:1: ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4619:1: ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4620:2: ( rule__ParameterDoubleType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4621:2: ( rule__ParameterDoubleType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4621:3: rule__ParameterDoubleType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4630:1: rule__ParameterBooleanType__Group__0 : rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1 ;
    public final void rule__ParameterBooleanType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4634:1: ( rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1 )
            // InternalBasicsParser.g:4635:2: rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1
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
    // InternalBasicsParser.g:4642:1: rule__ParameterBooleanType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterBooleanType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4646:1: ( ( () ) )
            // InternalBasicsParser.g:4647:1: ( () )
            {
            // InternalBasicsParser.g:4647:1: ( () )
            // InternalBasicsParser.g:4648:2: ()
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0()); 
            // InternalBasicsParser.g:4649:2: ()
            // InternalBasicsParser.g:4649:3: 
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
    // InternalBasicsParser.g:4657:1: rule__ParameterBooleanType__Group__1 : rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2 ;
    public final void rule__ParameterBooleanType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4661:1: ( rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2 )
            // InternalBasicsParser.g:4662:2: rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2
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
    // InternalBasicsParser.g:4669:1: rule__ParameterBooleanType__Group__1__Impl : ( Boolean ) ;
    public final void rule__ParameterBooleanType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4673:1: ( ( Boolean ) )
            // InternalBasicsParser.g:4674:1: ( Boolean )
            {
            // InternalBasicsParser.g:4674:1: ( Boolean )
            // InternalBasicsParser.g:4675:2: Boolean
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
    // InternalBasicsParser.g:4684:1: rule__ParameterBooleanType__Group__2 : rule__ParameterBooleanType__Group__2__Impl ;
    public final void rule__ParameterBooleanType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4688:1: ( rule__ParameterBooleanType__Group__2__Impl )
            // InternalBasicsParser.g:4689:2: rule__ParameterBooleanType__Group__2__Impl
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
    // InternalBasicsParser.g:4695:1: rule__ParameterBooleanType__Group__2__Impl : ( ( rule__ParameterBooleanType__Group_2__0 )? ) ;
    public final void rule__ParameterBooleanType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4699:1: ( ( ( rule__ParameterBooleanType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4700:1: ( ( rule__ParameterBooleanType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4700:1: ( ( rule__ParameterBooleanType__Group_2__0 )? )
            // InternalBasicsParser.g:4701:2: ( rule__ParameterBooleanType__Group_2__0 )?
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4702:2: ( rule__ParameterBooleanType__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Default) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBasicsParser.g:4702:3: rule__ParameterBooleanType__Group_2__0
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
    // InternalBasicsParser.g:4711:1: rule__ParameterBooleanType__Group_2__0 : rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1 ;
    public final void rule__ParameterBooleanType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4715:1: ( rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1 )
            // InternalBasicsParser.g:4716:2: rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1
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
    // InternalBasicsParser.g:4723:1: rule__ParameterBooleanType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterBooleanType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4727:1: ( ( Default ) )
            // InternalBasicsParser.g:4728:1: ( Default )
            {
            // InternalBasicsParser.g:4728:1: ( Default )
            // InternalBasicsParser.g:4729:2: Default
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
    // InternalBasicsParser.g:4738:1: rule__ParameterBooleanType__Group_2__1 : rule__ParameterBooleanType__Group_2__1__Impl ;
    public final void rule__ParameterBooleanType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4742:1: ( rule__ParameterBooleanType__Group_2__1__Impl )
            // InternalBasicsParser.g:4743:2: rule__ParameterBooleanType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4749:1: rule__ParameterBooleanType__Group_2__1__Impl : ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterBooleanType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4753:1: ( ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4754:1: ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4754:1: ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4755:2: ( rule__ParameterBooleanType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4756:2: ( rule__ParameterBooleanType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4756:3: rule__ParameterBooleanType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4765:1: rule__ParameterBase64Type__Group__0 : rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1 ;
    public final void rule__ParameterBase64Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4769:1: ( rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1 )
            // InternalBasicsParser.g:4770:2: rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1
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
    // InternalBasicsParser.g:4777:1: rule__ParameterBase64Type__Group__0__Impl : ( () ) ;
    public final void rule__ParameterBase64Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4781:1: ( ( () ) )
            // InternalBasicsParser.g:4782:1: ( () )
            {
            // InternalBasicsParser.g:4782:1: ( () )
            // InternalBasicsParser.g:4783:2: ()
            {
             before(grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0()); 
            // InternalBasicsParser.g:4784:2: ()
            // InternalBasicsParser.g:4784:3: 
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
    // InternalBasicsParser.g:4792:1: rule__ParameterBase64Type__Group__1 : rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2 ;
    public final void rule__ParameterBase64Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4796:1: ( rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2 )
            // InternalBasicsParser.g:4797:2: rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2
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
    // InternalBasicsParser.g:4804:1: rule__ParameterBase64Type__Group__1__Impl : ( Base64 ) ;
    public final void rule__ParameterBase64Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4808:1: ( ( Base64 ) )
            // InternalBasicsParser.g:4809:1: ( Base64 )
            {
            // InternalBasicsParser.g:4809:1: ( Base64 )
            // InternalBasicsParser.g:4810:2: Base64
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
    // InternalBasicsParser.g:4819:1: rule__ParameterBase64Type__Group__2 : rule__ParameterBase64Type__Group__2__Impl ;
    public final void rule__ParameterBase64Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4823:1: ( rule__ParameterBase64Type__Group__2__Impl )
            // InternalBasicsParser.g:4824:2: rule__ParameterBase64Type__Group__2__Impl
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
    // InternalBasicsParser.g:4830:1: rule__ParameterBase64Type__Group__2__Impl : ( ( rule__ParameterBase64Type__Group_2__0 )? ) ;
    public final void rule__ParameterBase64Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4834:1: ( ( ( rule__ParameterBase64Type__Group_2__0 )? ) )
            // InternalBasicsParser.g:4835:1: ( ( rule__ParameterBase64Type__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4835:1: ( ( rule__ParameterBase64Type__Group_2__0 )? )
            // InternalBasicsParser.g:4836:2: ( rule__ParameterBase64Type__Group_2__0 )?
            {
             before(grammarAccess.getParameterBase64TypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4837:2: ( rule__ParameterBase64Type__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Default) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalBasicsParser.g:4837:3: rule__ParameterBase64Type__Group_2__0
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
    // InternalBasicsParser.g:4846:1: rule__ParameterBase64Type__Group_2__0 : rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1 ;
    public final void rule__ParameterBase64Type__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4850:1: ( rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1 )
            // InternalBasicsParser.g:4851:2: rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1
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
    // InternalBasicsParser.g:4858:1: rule__ParameterBase64Type__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterBase64Type__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4862:1: ( ( Default ) )
            // InternalBasicsParser.g:4863:1: ( Default )
            {
            // InternalBasicsParser.g:4863:1: ( Default )
            // InternalBasicsParser.g:4864:2: Default
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
    // InternalBasicsParser.g:4873:1: rule__ParameterBase64Type__Group_2__1 : rule__ParameterBase64Type__Group_2__1__Impl ;
    public final void rule__ParameterBase64Type__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4877:1: ( rule__ParameterBase64Type__Group_2__1__Impl )
            // InternalBasicsParser.g:4878:2: rule__ParameterBase64Type__Group_2__1__Impl
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
    // InternalBasicsParser.g:4884:1: rule__ParameterBase64Type__Group_2__1__Impl : ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterBase64Type__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4888:1: ( ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4889:1: ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4889:1: ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4890:2: ( rule__ParameterBase64Type__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterBase64TypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4891:2: ( rule__ParameterBase64Type__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4891:3: rule__ParameterBase64Type__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4900:1: rule__ParameterArrayType__Group__0 : rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1 ;
    public final void rule__ParameterArrayType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4904:1: ( rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1 )
            // InternalBasicsParser.g:4905:2: rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1
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
    // InternalBasicsParser.g:4912:1: rule__ParameterArrayType__Group__0__Impl : ( Array ) ;
    public final void rule__ParameterArrayType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4916:1: ( ( Array ) )
            // InternalBasicsParser.g:4917:1: ( Array )
            {
            // InternalBasicsParser.g:4917:1: ( Array )
            // InternalBasicsParser.g:4918:2: Array
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
    // InternalBasicsParser.g:4927:1: rule__ParameterArrayType__Group__1 : rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2 ;
    public final void rule__ParameterArrayType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4931:1: ( rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2 )
            // InternalBasicsParser.g:4932:2: rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2
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
    // InternalBasicsParser.g:4939:1: rule__ParameterArrayType__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterArrayType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4943:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:4944:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:4944:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:4945:2: LeftSquareBracket
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
    // InternalBasicsParser.g:4954:1: rule__ParameterArrayType__Group__2 : rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3 ;
    public final void rule__ParameterArrayType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4958:1: ( rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3 )
            // InternalBasicsParser.g:4959:2: rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3
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
    // InternalBasicsParser.g:4966:1: rule__ParameterArrayType__Group__2__Impl : ( ( rule__ParameterArrayType__TypeAssignment_2 ) ) ;
    public final void rule__ParameterArrayType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4970:1: ( ( ( rule__ParameterArrayType__TypeAssignment_2 ) ) )
            // InternalBasicsParser.g:4971:1: ( ( rule__ParameterArrayType__TypeAssignment_2 ) )
            {
            // InternalBasicsParser.g:4971:1: ( ( rule__ParameterArrayType__TypeAssignment_2 ) )
            // InternalBasicsParser.g:4972:2: ( rule__ParameterArrayType__TypeAssignment_2 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getTypeAssignment_2()); 
            // InternalBasicsParser.g:4973:2: ( rule__ParameterArrayType__TypeAssignment_2 )
            // InternalBasicsParser.g:4973:3: rule__ParameterArrayType__TypeAssignment_2
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
    // InternalBasicsParser.g:4981:1: rule__ParameterArrayType__Group__3 : rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4 ;
    public final void rule__ParameterArrayType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4985:1: ( rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4 )
            // InternalBasicsParser.g:4986:2: rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4
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
    // InternalBasicsParser.g:4993:1: rule__ParameterArrayType__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterArrayType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4997:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:4998:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:4998:1: ( RightSquareBracket )
            // InternalBasicsParser.g:4999:2: RightSquareBracket
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
    // InternalBasicsParser.g:5008:1: rule__ParameterArrayType__Group__4 : rule__ParameterArrayType__Group__4__Impl ;
    public final void rule__ParameterArrayType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5012:1: ( rule__ParameterArrayType__Group__4__Impl )
            // InternalBasicsParser.g:5013:2: rule__ParameterArrayType__Group__4__Impl
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
    // InternalBasicsParser.g:5019:1: rule__ParameterArrayType__Group__4__Impl : ( ( rule__ParameterArrayType__Group_4__0 )? ) ;
    public final void rule__ParameterArrayType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5023:1: ( ( ( rule__ParameterArrayType__Group_4__0 )? ) )
            // InternalBasicsParser.g:5024:1: ( ( rule__ParameterArrayType__Group_4__0 )? )
            {
            // InternalBasicsParser.g:5024:1: ( ( rule__ParameterArrayType__Group_4__0 )? )
            // InternalBasicsParser.g:5025:2: ( rule__ParameterArrayType__Group_4__0 )?
            {
             before(grammarAccess.getParameterArrayTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:5026:2: ( rule__ParameterArrayType__Group_4__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==Default) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBasicsParser.g:5026:3: rule__ParameterArrayType__Group_4__0
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
    // InternalBasicsParser.g:5035:1: rule__ParameterArrayType__Group_4__0 : rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1 ;
    public final void rule__ParameterArrayType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5039:1: ( rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1 )
            // InternalBasicsParser.g:5040:2: rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1
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
    // InternalBasicsParser.g:5047:1: rule__ParameterArrayType__Group_4__0__Impl : ( Default ) ;
    public final void rule__ParameterArrayType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5051:1: ( ( Default ) )
            // InternalBasicsParser.g:5052:1: ( Default )
            {
            // InternalBasicsParser.g:5052:1: ( Default )
            // InternalBasicsParser.g:5053:2: Default
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
    // InternalBasicsParser.g:5062:1: rule__ParameterArrayType__Group_4__1 : rule__ParameterArrayType__Group_4__1__Impl ;
    public final void rule__ParameterArrayType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5066:1: ( rule__ParameterArrayType__Group_4__1__Impl )
            // InternalBasicsParser.g:5067:2: rule__ParameterArrayType__Group_4__1__Impl
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
    // InternalBasicsParser.g:5073:1: rule__ParameterArrayType__Group_4__1__Impl : ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) ) ;
    public final void rule__ParameterArrayType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5077:1: ( ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) ) )
            // InternalBasicsParser.g:5078:1: ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:5078:1: ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) )
            // InternalBasicsParser.g:5079:2: ( rule__ParameterArrayType__DefaultAssignment_4_1 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getDefaultAssignment_4_1()); 
            // InternalBasicsParser.g:5080:2: ( rule__ParameterArrayType__DefaultAssignment_4_1 )
            // InternalBasicsParser.g:5080:3: rule__ParameterArrayType__DefaultAssignment_4_1
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
    // InternalBasicsParser.g:5089:1: rule__ParameterList__Group__0 : rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1 ;
    public final void rule__ParameterList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5093:1: ( rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1 )
            // InternalBasicsParser.g:5094:2: rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1
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
    // InternalBasicsParser.g:5101:1: rule__ParameterList__Group__0__Impl : ( () ) ;
    public final void rule__ParameterList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5105:1: ( ( () ) )
            // InternalBasicsParser.g:5106:1: ( () )
            {
            // InternalBasicsParser.g:5106:1: ( () )
            // InternalBasicsParser.g:5107:2: ()
            {
             before(grammarAccess.getParameterListAccess().getParameterSequenceAction_0()); 
            // InternalBasicsParser.g:5108:2: ()
            // InternalBasicsParser.g:5108:3: 
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
    // InternalBasicsParser.g:5116:1: rule__ParameterList__Group__1 : rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2 ;
    public final void rule__ParameterList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5120:1: ( rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2 )
            // InternalBasicsParser.g:5121:2: rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2
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
    // InternalBasicsParser.g:5128:1: rule__ParameterList__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5132:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:5133:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:5133:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:5134:2: LeftSquareBracket
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
    // InternalBasicsParser.g:5143:1: rule__ParameterList__Group__2 : rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3 ;
    public final void rule__ParameterList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5147:1: ( rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3 )
            // InternalBasicsParser.g:5148:2: rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3
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
    // InternalBasicsParser.g:5155:1: rule__ParameterList__Group__2__Impl : ( ( rule__ParameterList__ValueAssignment_2 ) ) ;
    public final void rule__ParameterList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5159:1: ( ( ( rule__ParameterList__ValueAssignment_2 ) ) )
            // InternalBasicsParser.g:5160:1: ( ( rule__ParameterList__ValueAssignment_2 ) )
            {
            // InternalBasicsParser.g:5160:1: ( ( rule__ParameterList__ValueAssignment_2 ) )
            // InternalBasicsParser.g:5161:2: ( rule__ParameterList__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterListAccess().getValueAssignment_2()); 
            // InternalBasicsParser.g:5162:2: ( rule__ParameterList__ValueAssignment_2 )
            // InternalBasicsParser.g:5162:3: rule__ParameterList__ValueAssignment_2
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
    // InternalBasicsParser.g:5170:1: rule__ParameterList__Group__3 : rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4 ;
    public final void rule__ParameterList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5174:1: ( rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4 )
            // InternalBasicsParser.g:5175:2: rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4
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
    // InternalBasicsParser.g:5182:1: rule__ParameterList__Group__3__Impl : ( ( rule__ParameterList__Group_3__0 )* ) ;
    public final void rule__ParameterList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5186:1: ( ( ( rule__ParameterList__Group_3__0 )* ) )
            // InternalBasicsParser.g:5187:1: ( ( rule__ParameterList__Group_3__0 )* )
            {
            // InternalBasicsParser.g:5187:1: ( ( rule__ParameterList__Group_3__0 )* )
            // InternalBasicsParser.g:5188:2: ( rule__ParameterList__Group_3__0 )*
            {
             before(grammarAccess.getParameterListAccess().getGroup_3()); 
            // InternalBasicsParser.g:5189:2: ( rule__ParameterList__Group_3__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==Comma) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBasicsParser.g:5189:3: rule__ParameterList__Group_3__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__ParameterList__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalBasicsParser.g:5197:1: rule__ParameterList__Group__4 : rule__ParameterList__Group__4__Impl ;
    public final void rule__ParameterList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5201:1: ( rule__ParameterList__Group__4__Impl )
            // InternalBasicsParser.g:5202:2: rule__ParameterList__Group__4__Impl
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
    // InternalBasicsParser.g:5208:1: rule__ParameterList__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5212:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5213:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5213:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5214:2: RightSquareBracket
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
    // InternalBasicsParser.g:5224:1: rule__ParameterList__Group_3__0 : rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1 ;
    public final void rule__ParameterList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5228:1: ( rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1 )
            // InternalBasicsParser.g:5229:2: rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1
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
    // InternalBasicsParser.g:5236:1: rule__ParameterList__Group_3__0__Impl : ( Comma ) ;
    public final void rule__ParameterList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5240:1: ( ( Comma ) )
            // InternalBasicsParser.g:5241:1: ( Comma )
            {
            // InternalBasicsParser.g:5241:1: ( Comma )
            // InternalBasicsParser.g:5242:2: Comma
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
    // InternalBasicsParser.g:5251:1: rule__ParameterList__Group_3__1 : rule__ParameterList__Group_3__1__Impl ;
    public final void rule__ParameterList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5255:1: ( rule__ParameterList__Group_3__1__Impl )
            // InternalBasicsParser.g:5256:2: rule__ParameterList__Group_3__1__Impl
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
    // InternalBasicsParser.g:5262:1: rule__ParameterList__Group_3__1__Impl : ( ( rule__ParameterList__ValueAssignment_3_1 ) ) ;
    public final void rule__ParameterList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5266:1: ( ( ( rule__ParameterList__ValueAssignment_3_1 ) ) )
            // InternalBasicsParser.g:5267:1: ( ( rule__ParameterList__ValueAssignment_3_1 ) )
            {
            // InternalBasicsParser.g:5267:1: ( ( rule__ParameterList__ValueAssignment_3_1 ) )
            // InternalBasicsParser.g:5268:2: ( rule__ParameterList__ValueAssignment_3_1 )
            {
             before(grammarAccess.getParameterListAccess().getValueAssignment_3_1()); 
            // InternalBasicsParser.g:5269:2: ( rule__ParameterList__ValueAssignment_3_1 )
            // InternalBasicsParser.g:5269:3: rule__ParameterList__ValueAssignment_3_1
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
    // InternalBasicsParser.g:5278:1: rule__ParameterAny__Group__0 : rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1 ;
    public final void rule__ParameterAny__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5282:1: ( rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1 )
            // InternalBasicsParser.g:5283:2: rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1
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
    // InternalBasicsParser.g:5290:1: rule__ParameterAny__Group__0__Impl : ( () ) ;
    public final void rule__ParameterAny__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5294:1: ( ( () ) )
            // InternalBasicsParser.g:5295:1: ( () )
            {
            // InternalBasicsParser.g:5295:1: ( () )
            // InternalBasicsParser.g:5296:2: ()
            {
             before(grammarAccess.getParameterAnyAccess().getParameterAnyAction_0()); 
            // InternalBasicsParser.g:5297:2: ()
            // InternalBasicsParser.g:5297:3: 
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
    // InternalBasicsParser.g:5305:1: rule__ParameterAny__Group__1 : rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2 ;
    public final void rule__ParameterAny__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5309:1: ( rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2 )
            // InternalBasicsParser.g:5310:2: rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2
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
    // InternalBasicsParser.g:5317:1: rule__ParameterAny__Group__1__Impl : ( ParameterAny ) ;
    public final void rule__ParameterAny__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5321:1: ( ( ParameterAny ) )
            // InternalBasicsParser.g:5322:1: ( ParameterAny )
            {
            // InternalBasicsParser.g:5322:1: ( ParameterAny )
            // InternalBasicsParser.g:5323:2: ParameterAny
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
    // InternalBasicsParser.g:5332:1: rule__ParameterAny__Group__2 : rule__ParameterAny__Group__2__Impl ;
    public final void rule__ParameterAny__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5336:1: ( rule__ParameterAny__Group__2__Impl )
            // InternalBasicsParser.g:5337:2: rule__ParameterAny__Group__2__Impl
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
    // InternalBasicsParser.g:5343:1: rule__ParameterAny__Group__2__Impl : ( ( rule__ParameterAny__Group_2__0 )? ) ;
    public final void rule__ParameterAny__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5347:1: ( ( ( rule__ParameterAny__Group_2__0 )? ) )
            // InternalBasicsParser.g:5348:1: ( ( rule__ParameterAny__Group_2__0 )? )
            {
            // InternalBasicsParser.g:5348:1: ( ( rule__ParameterAny__Group_2__0 )? )
            // InternalBasicsParser.g:5349:2: ( rule__ParameterAny__Group_2__0 )?
            {
             before(grammarAccess.getParameterAnyAccess().getGroup_2()); 
            // InternalBasicsParser.g:5350:2: ( rule__ParameterAny__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==Value) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBasicsParser.g:5350:3: rule__ParameterAny__Group_2__0
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
    // InternalBasicsParser.g:5359:1: rule__ParameterAny__Group_2__0 : rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1 ;
    public final void rule__ParameterAny__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5363:1: ( rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1 )
            // InternalBasicsParser.g:5364:2: rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1
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
    // InternalBasicsParser.g:5371:1: rule__ParameterAny__Group_2__0__Impl : ( Value ) ;
    public final void rule__ParameterAny__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5375:1: ( ( Value ) )
            // InternalBasicsParser.g:5376:1: ( Value )
            {
            // InternalBasicsParser.g:5376:1: ( Value )
            // InternalBasicsParser.g:5377:2: Value
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
    // InternalBasicsParser.g:5386:1: rule__ParameterAny__Group_2__1 : rule__ParameterAny__Group_2__1__Impl ;
    public final void rule__ParameterAny__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5390:1: ( rule__ParameterAny__Group_2__1__Impl )
            // InternalBasicsParser.g:5391:2: rule__ParameterAny__Group_2__1__Impl
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
    // InternalBasicsParser.g:5397:1: rule__ParameterAny__Group_2__1__Impl : ( ( rule__ParameterAny__ValueAssignment_2_1 ) ) ;
    public final void rule__ParameterAny__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5401:1: ( ( ( rule__ParameterAny__ValueAssignment_2_1 ) ) )
            // InternalBasicsParser.g:5402:1: ( ( rule__ParameterAny__ValueAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:5402:1: ( ( rule__ParameterAny__ValueAssignment_2_1 ) )
            // InternalBasicsParser.g:5403:2: ( rule__ParameterAny__ValueAssignment_2_1 )
            {
             before(grammarAccess.getParameterAnyAccess().getValueAssignment_2_1()); 
            // InternalBasicsParser.g:5404:2: ( rule__ParameterAny__ValueAssignment_2_1 )
            // InternalBasicsParser.g:5404:3: rule__ParameterAny__ValueAssignment_2_1
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
    // InternalBasicsParser.g:5413:1: rule__ParameterStruct__Group__0 : rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1 ;
    public final void rule__ParameterStruct__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5417:1: ( rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1 )
            // InternalBasicsParser.g:5418:2: rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1
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
    // InternalBasicsParser.g:5425:1: rule__ParameterStruct__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStruct__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5429:1: ( ( () ) )
            // InternalBasicsParser.g:5430:1: ( () )
            {
            // InternalBasicsParser.g:5430:1: ( () )
            // InternalBasicsParser.g:5431:2: ()
            {
             before(grammarAccess.getParameterStructAccess().getParameterStructAction_0()); 
            // InternalBasicsParser.g:5432:2: ()
            // InternalBasicsParser.g:5432:3: 
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
    // InternalBasicsParser.g:5440:1: rule__ParameterStruct__Group__1 : rule__ParameterStruct__Group__1__Impl ;
    public final void rule__ParameterStruct__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5444:1: ( rule__ParameterStruct__Group__1__Impl )
            // InternalBasicsParser.g:5445:2: rule__ParameterStruct__Group__1__Impl
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
    // InternalBasicsParser.g:5451:1: rule__ParameterStruct__Group__1__Impl : ( ( rule__ParameterStruct__Group_1__0 )? ) ;
    public final void rule__ParameterStruct__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5455:1: ( ( ( rule__ParameterStruct__Group_1__0 )? ) )
            // InternalBasicsParser.g:5456:1: ( ( rule__ParameterStruct__Group_1__0 )? )
            {
            // InternalBasicsParser.g:5456:1: ( ( rule__ParameterStruct__Group_1__0 )? )
            // InternalBasicsParser.g:5457:2: ( rule__ParameterStruct__Group_1__0 )?
            {
             before(grammarAccess.getParameterStructAccess().getGroup_1()); 
            // InternalBasicsParser.g:5458:2: ( rule__ParameterStruct__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LeftSquareBracket) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBasicsParser.g:5458:3: rule__ParameterStruct__Group_1__0
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
    // InternalBasicsParser.g:5467:1: rule__ParameterStruct__Group_1__0 : rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1 ;
    public final void rule__ParameterStruct__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5471:1: ( rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1 )
            // InternalBasicsParser.g:5472:2: rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1
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
    // InternalBasicsParser.g:5479:1: rule__ParameterStruct__Group_1__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterStruct__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5483:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:5484:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:5484:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:5485:2: LeftSquareBracket
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
    // InternalBasicsParser.g:5494:1: rule__ParameterStruct__Group_1__1 : rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2 ;
    public final void rule__ParameterStruct__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5498:1: ( rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2 )
            // InternalBasicsParser.g:5499:2: rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2
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
    // InternalBasicsParser.g:5506:1: rule__ParameterStruct__Group_1__1__Impl : ( RULE_BEGIN ) ;
    public final void rule__ParameterStruct__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5510:1: ( ( RULE_BEGIN ) )
            // InternalBasicsParser.g:5511:1: ( RULE_BEGIN )
            {
            // InternalBasicsParser.g:5511:1: ( RULE_BEGIN )
            // InternalBasicsParser.g:5512:2: RULE_BEGIN
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
    // InternalBasicsParser.g:5521:1: rule__ParameterStruct__Group_1__2 : rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3 ;
    public final void rule__ParameterStruct__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5525:1: ( rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3 )
            // InternalBasicsParser.g:5526:2: rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3
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
    // InternalBasicsParser.g:5533:1: rule__ParameterStruct__Group_1__2__Impl : ( ( rule__ParameterStruct__ValueAssignment_1_2 )* ) ;
    public final void rule__ParameterStruct__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5537:1: ( ( ( rule__ParameterStruct__ValueAssignment_1_2 )* ) )
            // InternalBasicsParser.g:5538:1: ( ( rule__ParameterStruct__ValueAssignment_1_2 )* )
            {
            // InternalBasicsParser.g:5538:1: ( ( rule__ParameterStruct__ValueAssignment_1_2 )* )
            // InternalBasicsParser.g:5539:2: ( rule__ParameterStruct__ValueAssignment_1_2 )*
            {
             before(grammarAccess.getParameterStructAccess().getValueAssignment_1_2()); 
            // InternalBasicsParser.g:5540:2: ( rule__ParameterStruct__ValueAssignment_1_2 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=Pluginbases && LA33_0<=Parameter)||LA33_0==Multiple||LA33_0==Plugins||(LA33_0>=Format && LA33_0<=Header_1)||LA33_0==Loader||LA33_0==Class||LA33_0==Slots||LA33_0==Base||(LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBasicsParser.g:5540:3: rule__ParameterStruct__ValueAssignment_1_2
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__ParameterStruct__ValueAssignment_1_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalBasicsParser.g:5548:1: rule__ParameterStruct__Group_1__3 : rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4 ;
    public final void rule__ParameterStruct__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5552:1: ( rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4 )
            // InternalBasicsParser.g:5553:2: rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4
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
    // InternalBasicsParser.g:5560:1: rule__ParameterStruct__Group_1__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterStruct__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5564:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5565:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5565:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5566:2: RightSquareBracket
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
    // InternalBasicsParser.g:5575:1: rule__ParameterStruct__Group_1__4 : rule__ParameterStruct__Group_1__4__Impl ;
    public final void rule__ParameterStruct__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5579:1: ( rule__ParameterStruct__Group_1__4__Impl )
            // InternalBasicsParser.g:5580:2: rule__ParameterStruct__Group_1__4__Impl
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
    // InternalBasicsParser.g:5586:1: rule__ParameterStruct__Group_1__4__Impl : ( RULE_END ) ;
    public final void rule__ParameterStruct__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5590:1: ( ( RULE_END ) )
            // InternalBasicsParser.g:5591:1: ( RULE_END )
            {
            // InternalBasicsParser.g:5591:1: ( RULE_END )
            // InternalBasicsParser.g:5592:2: RULE_END
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
    // InternalBasicsParser.g:5602:1: rule__ParameterStructMember__Group__0 : rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1 ;
    public final void rule__ParameterStructMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5606:1: ( rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1 )
            // InternalBasicsParser.g:5607:2: rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalBasicsParser.g:5614:1: rule__ParameterStructMember__Group__0__Impl : ( ( rule__ParameterStructMember__Alternatives_0 ) ) ;
    public final void rule__ParameterStructMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5618:1: ( ( ( rule__ParameterStructMember__Alternatives_0 ) ) )
            // InternalBasicsParser.g:5619:1: ( ( rule__ParameterStructMember__Alternatives_0 ) )
            {
            // InternalBasicsParser.g:5619:1: ( ( rule__ParameterStructMember__Alternatives_0 ) )
            // InternalBasicsParser.g:5620:2: ( rule__ParameterStructMember__Alternatives_0 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getAlternatives_0()); 
            // InternalBasicsParser.g:5621:2: ( rule__ParameterStructMember__Alternatives_0 )
            // InternalBasicsParser.g:5621:3: rule__ParameterStructMember__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructMemberAccess().getAlternatives_0()); 

            }


            }

        }
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
    // InternalBasicsParser.g:5629:1: rule__ParameterStructMember__Group__1 : rule__ParameterStructMember__Group__1__Impl ;
    public final void rule__ParameterStructMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5633:1: ( rule__ParameterStructMember__Group__1__Impl )
            // InternalBasicsParser.g:5634:2: rule__ParameterStructMember__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Group__1__Impl();

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
    // InternalBasicsParser.g:5640:1: rule__ParameterStructMember__Group__1__Impl : ( ( rule__ParameterStructMember__ValueAssignment_1 ) ) ;
    public final void rule__ParameterStructMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5644:1: ( ( ( rule__ParameterStructMember__ValueAssignment_1 ) ) )
            // InternalBasicsParser.g:5645:1: ( ( rule__ParameterStructMember__ValueAssignment_1 ) )
            {
            // InternalBasicsParser.g:5645:1: ( ( rule__ParameterStructMember__ValueAssignment_1 ) )
            // InternalBasicsParser.g:5646:2: ( rule__ParameterStructMember__ValueAssignment_1 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getValueAssignment_1()); 
            // InternalBasicsParser.g:5647:2: ( rule__ParameterStructMember__ValueAssignment_1 )
            // InternalBasicsParser.g:5647:3: rule__ParameterStructMember__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructMemberAccess().getValueAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ParameterStructMember__Group_0_0__0"
    // InternalBasicsParser.g:5656:1: rule__ParameterStructMember__Group_0_0__0 : rule__ParameterStructMember__Group_0_0__0__Impl rule__ParameterStructMember__Group_0_0__1 ;
    public final void rule__ParameterStructMember__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5660:1: ( rule__ParameterStructMember__Group_0_0__0__Impl rule__ParameterStructMember__Group_0_0__1 )
            // InternalBasicsParser.g:5661:2: rule__ParameterStructMember__Group_0_0__0__Impl rule__ParameterStructMember__Group_0_0__1
            {
            pushFollow(FOLLOW_32);
            rule__ParameterStructMember__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Group_0_0__1();

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
    // $ANTLR end "rule__ParameterStructMember__Group_0_0__0"


    // $ANTLR start "rule__ParameterStructMember__Group_0_0__0__Impl"
    // InternalBasicsParser.g:5668:1: rule__ParameterStructMember__Group_0_0__0__Impl : ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) ) ;
    public final void rule__ParameterStructMember__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5672:1: ( ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) ) )
            // InternalBasicsParser.g:5673:1: ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) )
            {
            // InternalBasicsParser.g:5673:1: ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) )
            // InternalBasicsParser.g:5674:2: ( rule__ParameterStructMember__NameAssignment_0_0_0 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0_0_0()); 
            // InternalBasicsParser.g:5675:2: ( rule__ParameterStructMember__NameAssignment_0_0_0 )
            // InternalBasicsParser.g:5675:3: rule__ParameterStructMember__NameAssignment_0_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__NameAssignment_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group_0_0__0__Impl"


    // $ANTLR start "rule__ParameterStructMember__Group_0_0__1"
    // InternalBasicsParser.g:5683:1: rule__ParameterStructMember__Group_0_0__1 : rule__ParameterStructMember__Group_0_0__1__Impl ;
    public final void rule__ParameterStructMember__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5687:1: ( rule__ParameterStructMember__Group_0_0__1__Impl )
            // InternalBasicsParser.g:5688:2: rule__ParameterStructMember__Group_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterStructMember__Group_0_0__1__Impl();

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
    // $ANTLR end "rule__ParameterStructMember__Group_0_0__1"


    // $ANTLR start "rule__ParameterStructMember__Group_0_0__1__Impl"
    // InternalBasicsParser.g:5694:1: rule__ParameterStructMember__Group_0_0__1__Impl : ( Colon ) ;
    public final void rule__ParameterStructMember__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5698:1: ( ( Colon ) )
            // InternalBasicsParser.g:5699:1: ( Colon )
            {
            // InternalBasicsParser.g:5699:1: ( Colon )
            // InternalBasicsParser.g:5700:2: Colon
            {
             before(grammarAccess.getParameterStructMemberAccess().getColonKeyword_0_0_1()); 
            match(input,Colon,FOLLOW_2); 
             after(grammarAccess.getParameterStructMemberAccess().getColonKeyword_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__Group_0_0__1__Impl"


    // $ANTLR start "rule__ParameterStructTypeMember__Group__0"
    // InternalBasicsParser.g:5710:1: rule__ParameterStructTypeMember__Group__0 : rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1 ;
    public final void rule__ParameterStructTypeMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5714:1: ( rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1 )
            // InternalBasicsParser.g:5715:2: rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1
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
    // InternalBasicsParser.g:5722:1: rule__ParameterStructTypeMember__Group__0__Impl : ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) ) ;
    public final void rule__ParameterStructTypeMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5726:1: ( ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) ) )
            // InternalBasicsParser.g:5727:1: ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) )
            {
            // InternalBasicsParser.g:5727:1: ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) )
            // InternalBasicsParser.g:5728:2: ( rule__ParameterStructTypeMember__NameAssignment_0 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getNameAssignment_0()); 
            // InternalBasicsParser.g:5729:2: ( rule__ParameterStructTypeMember__NameAssignment_0 )
            // InternalBasicsParser.g:5729:3: rule__ParameterStructTypeMember__NameAssignment_0
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
    // InternalBasicsParser.g:5737:1: rule__ParameterStructTypeMember__Group__1 : rule__ParameterStructTypeMember__Group__1__Impl ;
    public final void rule__ParameterStructTypeMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5741:1: ( rule__ParameterStructTypeMember__Group__1__Impl )
            // InternalBasicsParser.g:5742:2: rule__ParameterStructTypeMember__Group__1__Impl
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
    // InternalBasicsParser.g:5748:1: rule__ParameterStructTypeMember__Group__1__Impl : ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) ) ;
    public final void rule__ParameterStructTypeMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5752:1: ( ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) ) )
            // InternalBasicsParser.g:5753:1: ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) )
            {
            // InternalBasicsParser.g:5753:1: ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) )
            // InternalBasicsParser.g:5754:2: ( rule__ParameterStructTypeMember__TypeAssignment_1 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getTypeAssignment_1()); 
            // InternalBasicsParser.g:5755:2: ( rule__ParameterStructTypeMember__TypeAssignment_1 )
            // InternalBasicsParser.g:5755:3: rule__ParameterStructTypeMember__TypeAssignment_1
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
    // InternalBasicsParser.g:5764:1: rule__Bool__Group__0 : rule__Bool__Group__0__Impl rule__Bool__Group__1 ;
    public final void rule__Bool__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5768:1: ( rule__Bool__Group__0__Impl rule__Bool__Group__1 )
            // InternalBasicsParser.g:5769:2: rule__Bool__Group__0__Impl rule__Bool__Group__1
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
    // InternalBasicsParser.g:5776:1: rule__Bool__Group__0__Impl : ( () ) ;
    public final void rule__Bool__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5780:1: ( ( () ) )
            // InternalBasicsParser.g:5781:1: ( () )
            {
            // InternalBasicsParser.g:5781:1: ( () )
            // InternalBasicsParser.g:5782:2: ()
            {
             before(grammarAccess.getBoolAccess().getBoolAction_0()); 
            // InternalBasicsParser.g:5783:2: ()
            // InternalBasicsParser.g:5783:3: 
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
    // InternalBasicsParser.g:5791:1: rule__Bool__Group__1 : rule__Bool__Group__1__Impl ;
    public final void rule__Bool__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5795:1: ( rule__Bool__Group__1__Impl )
            // InternalBasicsParser.g:5796:2: rule__Bool__Group__1__Impl
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
    // InternalBasicsParser.g:5802:1: rule__Bool__Group__1__Impl : ( Bool ) ;
    public final void rule__Bool__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5806:1: ( ( Bool ) )
            // InternalBasicsParser.g:5807:1: ( Bool )
            {
            // InternalBasicsParser.g:5807:1: ( Bool )
            // InternalBasicsParser.g:5808:2: Bool
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
    // InternalBasicsParser.g:5818:1: rule__Int8__Group__0 : rule__Int8__Group__0__Impl rule__Int8__Group__1 ;
    public final void rule__Int8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5822:1: ( rule__Int8__Group__0__Impl rule__Int8__Group__1 )
            // InternalBasicsParser.g:5823:2: rule__Int8__Group__0__Impl rule__Int8__Group__1
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
    // InternalBasicsParser.g:5830:1: rule__Int8__Group__0__Impl : ( () ) ;
    public final void rule__Int8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5834:1: ( ( () ) )
            // InternalBasicsParser.g:5835:1: ( () )
            {
            // InternalBasicsParser.g:5835:1: ( () )
            // InternalBasicsParser.g:5836:2: ()
            {
             before(grammarAccess.getInt8Access().getInt8Action_0()); 
            // InternalBasicsParser.g:5837:2: ()
            // InternalBasicsParser.g:5837:3: 
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
    // InternalBasicsParser.g:5845:1: rule__Int8__Group__1 : rule__Int8__Group__1__Impl ;
    public final void rule__Int8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5849:1: ( rule__Int8__Group__1__Impl )
            // InternalBasicsParser.g:5850:2: rule__Int8__Group__1__Impl
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
    // InternalBasicsParser.g:5856:1: rule__Int8__Group__1__Impl : ( Int8 ) ;
    public final void rule__Int8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5860:1: ( ( Int8 ) )
            // InternalBasicsParser.g:5861:1: ( Int8 )
            {
            // InternalBasicsParser.g:5861:1: ( Int8 )
            // InternalBasicsParser.g:5862:2: Int8
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
    // InternalBasicsParser.g:5872:1: rule__Uint8__Group__0 : rule__Uint8__Group__0__Impl rule__Uint8__Group__1 ;
    public final void rule__Uint8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5876:1: ( rule__Uint8__Group__0__Impl rule__Uint8__Group__1 )
            // InternalBasicsParser.g:5877:2: rule__Uint8__Group__0__Impl rule__Uint8__Group__1
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
    // InternalBasicsParser.g:5884:1: rule__Uint8__Group__0__Impl : ( () ) ;
    public final void rule__Uint8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5888:1: ( ( () ) )
            // InternalBasicsParser.g:5889:1: ( () )
            {
            // InternalBasicsParser.g:5889:1: ( () )
            // InternalBasicsParser.g:5890:2: ()
            {
             before(grammarAccess.getUint8Access().getUint8Action_0()); 
            // InternalBasicsParser.g:5891:2: ()
            // InternalBasicsParser.g:5891:3: 
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
    // InternalBasicsParser.g:5899:1: rule__Uint8__Group__1 : rule__Uint8__Group__1__Impl ;
    public final void rule__Uint8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5903:1: ( rule__Uint8__Group__1__Impl )
            // InternalBasicsParser.g:5904:2: rule__Uint8__Group__1__Impl
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
    // InternalBasicsParser.g:5910:1: rule__Uint8__Group__1__Impl : ( Uint8 ) ;
    public final void rule__Uint8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5914:1: ( ( Uint8 ) )
            // InternalBasicsParser.g:5915:1: ( Uint8 )
            {
            // InternalBasicsParser.g:5915:1: ( Uint8 )
            // InternalBasicsParser.g:5916:2: Uint8
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
    // InternalBasicsParser.g:5926:1: rule__Int16__Group__0 : rule__Int16__Group__0__Impl rule__Int16__Group__1 ;
    public final void rule__Int16__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5930:1: ( rule__Int16__Group__0__Impl rule__Int16__Group__1 )
            // InternalBasicsParser.g:5931:2: rule__Int16__Group__0__Impl rule__Int16__Group__1
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
    // InternalBasicsParser.g:5938:1: rule__Int16__Group__0__Impl : ( () ) ;
    public final void rule__Int16__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5942:1: ( ( () ) )
            // InternalBasicsParser.g:5943:1: ( () )
            {
            // InternalBasicsParser.g:5943:1: ( () )
            // InternalBasicsParser.g:5944:2: ()
            {
             before(grammarAccess.getInt16Access().getInt16Action_0()); 
            // InternalBasicsParser.g:5945:2: ()
            // InternalBasicsParser.g:5945:3: 
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
    // InternalBasicsParser.g:5953:1: rule__Int16__Group__1 : rule__Int16__Group__1__Impl ;
    public final void rule__Int16__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5957:1: ( rule__Int16__Group__1__Impl )
            // InternalBasicsParser.g:5958:2: rule__Int16__Group__1__Impl
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
    // InternalBasicsParser.g:5964:1: rule__Int16__Group__1__Impl : ( Int16 ) ;
    public final void rule__Int16__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5968:1: ( ( Int16 ) )
            // InternalBasicsParser.g:5969:1: ( Int16 )
            {
            // InternalBasicsParser.g:5969:1: ( Int16 )
            // InternalBasicsParser.g:5970:2: Int16
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
    // InternalBasicsParser.g:5980:1: rule__Uint16__Group__0 : rule__Uint16__Group__0__Impl rule__Uint16__Group__1 ;
    public final void rule__Uint16__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5984:1: ( rule__Uint16__Group__0__Impl rule__Uint16__Group__1 )
            // InternalBasicsParser.g:5985:2: rule__Uint16__Group__0__Impl rule__Uint16__Group__1
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
    // InternalBasicsParser.g:5992:1: rule__Uint16__Group__0__Impl : ( () ) ;
    public final void rule__Uint16__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5996:1: ( ( () ) )
            // InternalBasicsParser.g:5997:1: ( () )
            {
            // InternalBasicsParser.g:5997:1: ( () )
            // InternalBasicsParser.g:5998:2: ()
            {
             before(grammarAccess.getUint16Access().getUint16Action_0()); 
            // InternalBasicsParser.g:5999:2: ()
            // InternalBasicsParser.g:5999:3: 
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
    // InternalBasicsParser.g:6007:1: rule__Uint16__Group__1 : rule__Uint16__Group__1__Impl ;
    public final void rule__Uint16__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6011:1: ( rule__Uint16__Group__1__Impl )
            // InternalBasicsParser.g:6012:2: rule__Uint16__Group__1__Impl
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
    // InternalBasicsParser.g:6018:1: rule__Uint16__Group__1__Impl : ( Uint16 ) ;
    public final void rule__Uint16__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6022:1: ( ( Uint16 ) )
            // InternalBasicsParser.g:6023:1: ( Uint16 )
            {
            // InternalBasicsParser.g:6023:1: ( Uint16 )
            // InternalBasicsParser.g:6024:2: Uint16
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
    // InternalBasicsParser.g:6034:1: rule__Int32__Group__0 : rule__Int32__Group__0__Impl rule__Int32__Group__1 ;
    public final void rule__Int32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6038:1: ( rule__Int32__Group__0__Impl rule__Int32__Group__1 )
            // InternalBasicsParser.g:6039:2: rule__Int32__Group__0__Impl rule__Int32__Group__1
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
    // InternalBasicsParser.g:6046:1: rule__Int32__Group__0__Impl : ( () ) ;
    public final void rule__Int32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6050:1: ( ( () ) )
            // InternalBasicsParser.g:6051:1: ( () )
            {
            // InternalBasicsParser.g:6051:1: ( () )
            // InternalBasicsParser.g:6052:2: ()
            {
             before(grammarAccess.getInt32Access().getInt32Action_0()); 
            // InternalBasicsParser.g:6053:2: ()
            // InternalBasicsParser.g:6053:3: 
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
    // InternalBasicsParser.g:6061:1: rule__Int32__Group__1 : rule__Int32__Group__1__Impl ;
    public final void rule__Int32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6065:1: ( rule__Int32__Group__1__Impl )
            // InternalBasicsParser.g:6066:2: rule__Int32__Group__1__Impl
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
    // InternalBasicsParser.g:6072:1: rule__Int32__Group__1__Impl : ( Int32 ) ;
    public final void rule__Int32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6076:1: ( ( Int32 ) )
            // InternalBasicsParser.g:6077:1: ( Int32 )
            {
            // InternalBasicsParser.g:6077:1: ( Int32 )
            // InternalBasicsParser.g:6078:2: Int32
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
    // InternalBasicsParser.g:6088:1: rule__Uint32__Group__0 : rule__Uint32__Group__0__Impl rule__Uint32__Group__1 ;
    public final void rule__Uint32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6092:1: ( rule__Uint32__Group__0__Impl rule__Uint32__Group__1 )
            // InternalBasicsParser.g:6093:2: rule__Uint32__Group__0__Impl rule__Uint32__Group__1
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
    // InternalBasicsParser.g:6100:1: rule__Uint32__Group__0__Impl : ( () ) ;
    public final void rule__Uint32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6104:1: ( ( () ) )
            // InternalBasicsParser.g:6105:1: ( () )
            {
            // InternalBasicsParser.g:6105:1: ( () )
            // InternalBasicsParser.g:6106:2: ()
            {
             before(grammarAccess.getUint32Access().getUint32Action_0()); 
            // InternalBasicsParser.g:6107:2: ()
            // InternalBasicsParser.g:6107:3: 
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
    // InternalBasicsParser.g:6115:1: rule__Uint32__Group__1 : rule__Uint32__Group__1__Impl ;
    public final void rule__Uint32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6119:1: ( rule__Uint32__Group__1__Impl )
            // InternalBasicsParser.g:6120:2: rule__Uint32__Group__1__Impl
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
    // InternalBasicsParser.g:6126:1: rule__Uint32__Group__1__Impl : ( Uint32 ) ;
    public final void rule__Uint32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6130:1: ( ( Uint32 ) )
            // InternalBasicsParser.g:6131:1: ( Uint32 )
            {
            // InternalBasicsParser.g:6131:1: ( Uint32 )
            // InternalBasicsParser.g:6132:2: Uint32
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
    // InternalBasicsParser.g:6142:1: rule__Int64__Group__0 : rule__Int64__Group__0__Impl rule__Int64__Group__1 ;
    public final void rule__Int64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6146:1: ( rule__Int64__Group__0__Impl rule__Int64__Group__1 )
            // InternalBasicsParser.g:6147:2: rule__Int64__Group__0__Impl rule__Int64__Group__1
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
    // InternalBasicsParser.g:6154:1: rule__Int64__Group__0__Impl : ( () ) ;
    public final void rule__Int64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6158:1: ( ( () ) )
            // InternalBasicsParser.g:6159:1: ( () )
            {
            // InternalBasicsParser.g:6159:1: ( () )
            // InternalBasicsParser.g:6160:2: ()
            {
             before(grammarAccess.getInt64Access().getInt64Action_0()); 
            // InternalBasicsParser.g:6161:2: ()
            // InternalBasicsParser.g:6161:3: 
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
    // InternalBasicsParser.g:6169:1: rule__Int64__Group__1 : rule__Int64__Group__1__Impl ;
    public final void rule__Int64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6173:1: ( rule__Int64__Group__1__Impl )
            // InternalBasicsParser.g:6174:2: rule__Int64__Group__1__Impl
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
    // InternalBasicsParser.g:6180:1: rule__Int64__Group__1__Impl : ( Int64 ) ;
    public final void rule__Int64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6184:1: ( ( Int64 ) )
            // InternalBasicsParser.g:6185:1: ( Int64 )
            {
            // InternalBasicsParser.g:6185:1: ( Int64 )
            // InternalBasicsParser.g:6186:2: Int64
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
    // InternalBasicsParser.g:6196:1: rule__Uint64__Group__0 : rule__Uint64__Group__0__Impl rule__Uint64__Group__1 ;
    public final void rule__Uint64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6200:1: ( rule__Uint64__Group__0__Impl rule__Uint64__Group__1 )
            // InternalBasicsParser.g:6201:2: rule__Uint64__Group__0__Impl rule__Uint64__Group__1
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
    // InternalBasicsParser.g:6208:1: rule__Uint64__Group__0__Impl : ( () ) ;
    public final void rule__Uint64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6212:1: ( ( () ) )
            // InternalBasicsParser.g:6213:1: ( () )
            {
            // InternalBasicsParser.g:6213:1: ( () )
            // InternalBasicsParser.g:6214:2: ()
            {
             before(grammarAccess.getUint64Access().getUint64Action_0()); 
            // InternalBasicsParser.g:6215:2: ()
            // InternalBasicsParser.g:6215:3: 
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
    // InternalBasicsParser.g:6223:1: rule__Uint64__Group__1 : rule__Uint64__Group__1__Impl ;
    public final void rule__Uint64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6227:1: ( rule__Uint64__Group__1__Impl )
            // InternalBasicsParser.g:6228:2: rule__Uint64__Group__1__Impl
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
    // InternalBasicsParser.g:6234:1: rule__Uint64__Group__1__Impl : ( Uint64 ) ;
    public final void rule__Uint64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6238:1: ( ( Uint64 ) )
            // InternalBasicsParser.g:6239:1: ( Uint64 )
            {
            // InternalBasicsParser.g:6239:1: ( Uint64 )
            // InternalBasicsParser.g:6240:2: Uint64
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
    // InternalBasicsParser.g:6250:1: rule__Float32__Group__0 : rule__Float32__Group__0__Impl rule__Float32__Group__1 ;
    public final void rule__Float32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6254:1: ( rule__Float32__Group__0__Impl rule__Float32__Group__1 )
            // InternalBasicsParser.g:6255:2: rule__Float32__Group__0__Impl rule__Float32__Group__1
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
    // InternalBasicsParser.g:6262:1: rule__Float32__Group__0__Impl : ( () ) ;
    public final void rule__Float32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6266:1: ( ( () ) )
            // InternalBasicsParser.g:6267:1: ( () )
            {
            // InternalBasicsParser.g:6267:1: ( () )
            // InternalBasicsParser.g:6268:2: ()
            {
             before(grammarAccess.getFloat32Access().getFloat32Action_0()); 
            // InternalBasicsParser.g:6269:2: ()
            // InternalBasicsParser.g:6269:3: 
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
    // InternalBasicsParser.g:6277:1: rule__Float32__Group__1 : rule__Float32__Group__1__Impl ;
    public final void rule__Float32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6281:1: ( rule__Float32__Group__1__Impl )
            // InternalBasicsParser.g:6282:2: rule__Float32__Group__1__Impl
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
    // InternalBasicsParser.g:6288:1: rule__Float32__Group__1__Impl : ( Float32 ) ;
    public final void rule__Float32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6292:1: ( ( Float32 ) )
            // InternalBasicsParser.g:6293:1: ( Float32 )
            {
            // InternalBasicsParser.g:6293:1: ( Float32 )
            // InternalBasicsParser.g:6294:2: Float32
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
    // InternalBasicsParser.g:6304:1: rule__Float64__Group__0 : rule__Float64__Group__0__Impl rule__Float64__Group__1 ;
    public final void rule__Float64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6308:1: ( rule__Float64__Group__0__Impl rule__Float64__Group__1 )
            // InternalBasicsParser.g:6309:2: rule__Float64__Group__0__Impl rule__Float64__Group__1
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
    // InternalBasicsParser.g:6316:1: rule__Float64__Group__0__Impl : ( () ) ;
    public final void rule__Float64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6320:1: ( ( () ) )
            // InternalBasicsParser.g:6321:1: ( () )
            {
            // InternalBasicsParser.g:6321:1: ( () )
            // InternalBasicsParser.g:6322:2: ()
            {
             before(grammarAccess.getFloat64Access().getFloat64Action_0()); 
            // InternalBasicsParser.g:6323:2: ()
            // InternalBasicsParser.g:6323:3: 
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
    // InternalBasicsParser.g:6331:1: rule__Float64__Group__1 : rule__Float64__Group__1__Impl ;
    public final void rule__Float64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6335:1: ( rule__Float64__Group__1__Impl )
            // InternalBasicsParser.g:6336:2: rule__Float64__Group__1__Impl
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
    // InternalBasicsParser.g:6342:1: rule__Float64__Group__1__Impl : ( Float64 ) ;
    public final void rule__Float64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6346:1: ( ( Float64 ) )
            // InternalBasicsParser.g:6347:1: ( Float64 )
            {
            // InternalBasicsParser.g:6347:1: ( Float64 )
            // InternalBasicsParser.g:6348:2: Float64
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
    // InternalBasicsParser.g:6358:1: rule__String0__Group__0 : rule__String0__Group__0__Impl rule__String0__Group__1 ;
    public final void rule__String0__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6362:1: ( rule__String0__Group__0__Impl rule__String0__Group__1 )
            // InternalBasicsParser.g:6363:2: rule__String0__Group__0__Impl rule__String0__Group__1
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
    // InternalBasicsParser.g:6370:1: rule__String0__Group__0__Impl : ( () ) ;
    public final void rule__String0__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6374:1: ( ( () ) )
            // InternalBasicsParser.g:6375:1: ( () )
            {
            // InternalBasicsParser.g:6375:1: ( () )
            // InternalBasicsParser.g:6376:2: ()
            {
             before(grammarAccess.getString0Access().getStringAction_0()); 
            // InternalBasicsParser.g:6377:2: ()
            // InternalBasicsParser.g:6377:3: 
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
    // InternalBasicsParser.g:6385:1: rule__String0__Group__1 : rule__String0__Group__1__Impl ;
    public final void rule__String0__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6389:1: ( rule__String0__Group__1__Impl )
            // InternalBasicsParser.g:6390:2: rule__String0__Group__1__Impl
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
    // InternalBasicsParser.g:6396:1: rule__String0__Group__1__Impl : ( String_1 ) ;
    public final void rule__String0__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6400:1: ( ( String_1 ) )
            // InternalBasicsParser.g:6401:1: ( String_1 )
            {
            // InternalBasicsParser.g:6401:1: ( String_1 )
            // InternalBasicsParser.g:6402:2: String_1
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
    // InternalBasicsParser.g:6412:1: rule__Char__Group__0 : rule__Char__Group__0__Impl rule__Char__Group__1 ;
    public final void rule__Char__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6416:1: ( rule__Char__Group__0__Impl rule__Char__Group__1 )
            // InternalBasicsParser.g:6417:2: rule__Char__Group__0__Impl rule__Char__Group__1
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
    // InternalBasicsParser.g:6424:1: rule__Char__Group__0__Impl : ( () ) ;
    public final void rule__Char__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6428:1: ( ( () ) )
            // InternalBasicsParser.g:6429:1: ( () )
            {
            // InternalBasicsParser.g:6429:1: ( () )
            // InternalBasicsParser.g:6430:2: ()
            {
             before(grammarAccess.getCharAccess().getChar0Action_0()); 
            // InternalBasicsParser.g:6431:2: ()
            // InternalBasicsParser.g:6431:3: 
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
    // InternalBasicsParser.g:6439:1: rule__Char__Group__1 : rule__Char__Group__1__Impl ;
    public final void rule__Char__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6443:1: ( rule__Char__Group__1__Impl )
            // InternalBasicsParser.g:6444:2: rule__Char__Group__1__Impl
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
    // InternalBasicsParser.g:6450:1: rule__Char__Group__1__Impl : ( Char ) ;
    public final void rule__Char__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6454:1: ( ( Char ) )
            // InternalBasicsParser.g:6455:1: ( Char )
            {
            // InternalBasicsParser.g:6455:1: ( Char )
            // InternalBasicsParser.g:6456:2: Char
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
    // InternalBasicsParser.g:6466:1: rule__Byte__Group__0 : rule__Byte__Group__0__Impl rule__Byte__Group__1 ;
    public final void rule__Byte__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6470:1: ( rule__Byte__Group__0__Impl rule__Byte__Group__1 )
            // InternalBasicsParser.g:6471:2: rule__Byte__Group__0__Impl rule__Byte__Group__1
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
    // InternalBasicsParser.g:6478:1: rule__Byte__Group__0__Impl : ( () ) ;
    public final void rule__Byte__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6482:1: ( ( () ) )
            // InternalBasicsParser.g:6483:1: ( () )
            {
            // InternalBasicsParser.g:6483:1: ( () )
            // InternalBasicsParser.g:6484:2: ()
            {
             before(grammarAccess.getByteAccess().getByteAction_0()); 
            // InternalBasicsParser.g:6485:2: ()
            // InternalBasicsParser.g:6485:3: 
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
    // InternalBasicsParser.g:6493:1: rule__Byte__Group__1 : rule__Byte__Group__1__Impl ;
    public final void rule__Byte__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6497:1: ( rule__Byte__Group__1__Impl )
            // InternalBasicsParser.g:6498:2: rule__Byte__Group__1__Impl
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
    // InternalBasicsParser.g:6504:1: rule__Byte__Group__1__Impl : ( Byte ) ;
    public final void rule__Byte__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6508:1: ( ( Byte ) )
            // InternalBasicsParser.g:6509:1: ( Byte )
            {
            // InternalBasicsParser.g:6509:1: ( Byte )
            // InternalBasicsParser.g:6510:2: Byte
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
    // InternalBasicsParser.g:6520:1: rule__Time__Group__0 : rule__Time__Group__0__Impl rule__Time__Group__1 ;
    public final void rule__Time__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6524:1: ( rule__Time__Group__0__Impl rule__Time__Group__1 )
            // InternalBasicsParser.g:6525:2: rule__Time__Group__0__Impl rule__Time__Group__1
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
    // InternalBasicsParser.g:6532:1: rule__Time__Group__0__Impl : ( () ) ;
    public final void rule__Time__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6536:1: ( ( () ) )
            // InternalBasicsParser.g:6537:1: ( () )
            {
            // InternalBasicsParser.g:6537:1: ( () )
            // InternalBasicsParser.g:6538:2: ()
            {
             before(grammarAccess.getTimeAccess().getTimeAction_0()); 
            // InternalBasicsParser.g:6539:2: ()
            // InternalBasicsParser.g:6539:3: 
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
    // InternalBasicsParser.g:6547:1: rule__Time__Group__1 : rule__Time__Group__1__Impl ;
    public final void rule__Time__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6551:1: ( rule__Time__Group__1__Impl )
            // InternalBasicsParser.g:6552:2: rule__Time__Group__1__Impl
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
    // InternalBasicsParser.g:6558:1: rule__Time__Group__1__Impl : ( Time ) ;
    public final void rule__Time__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6562:1: ( ( Time ) )
            // InternalBasicsParser.g:6563:1: ( Time )
            {
            // InternalBasicsParser.g:6563:1: ( Time )
            // InternalBasicsParser.g:6564:2: Time
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
    // InternalBasicsParser.g:6574:1: rule__Duration__Group__0 : rule__Duration__Group__0__Impl rule__Duration__Group__1 ;
    public final void rule__Duration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6578:1: ( rule__Duration__Group__0__Impl rule__Duration__Group__1 )
            // InternalBasicsParser.g:6579:2: rule__Duration__Group__0__Impl rule__Duration__Group__1
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
    // InternalBasicsParser.g:6586:1: rule__Duration__Group__0__Impl : ( () ) ;
    public final void rule__Duration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6590:1: ( ( () ) )
            // InternalBasicsParser.g:6591:1: ( () )
            {
            // InternalBasicsParser.g:6591:1: ( () )
            // InternalBasicsParser.g:6592:2: ()
            {
             before(grammarAccess.getDurationAccess().getDurationAction_0()); 
            // InternalBasicsParser.g:6593:2: ()
            // InternalBasicsParser.g:6593:3: 
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
    // InternalBasicsParser.g:6601:1: rule__Duration__Group__1 : rule__Duration__Group__1__Impl ;
    public final void rule__Duration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6605:1: ( rule__Duration__Group__1__Impl )
            // InternalBasicsParser.g:6606:2: rule__Duration__Group__1__Impl
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
    // InternalBasicsParser.g:6612:1: rule__Duration__Group__1__Impl : ( Duration ) ;
    public final void rule__Duration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6616:1: ( ( Duration ) )
            // InternalBasicsParser.g:6617:1: ( Duration )
            {
            // InternalBasicsParser.g:6617:1: ( Duration )
            // InternalBasicsParser.g:6618:2: Duration
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
    // InternalBasicsParser.g:6628:1: rule__BoolArray__Group__0 : rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1 ;
    public final void rule__BoolArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6632:1: ( rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1 )
            // InternalBasicsParser.g:6633:2: rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1
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
    // InternalBasicsParser.g:6640:1: rule__BoolArray__Group__0__Impl : ( () ) ;
    public final void rule__BoolArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6644:1: ( ( () ) )
            // InternalBasicsParser.g:6645:1: ( () )
            {
            // InternalBasicsParser.g:6645:1: ( () )
            // InternalBasicsParser.g:6646:2: ()
            {
             before(grammarAccess.getBoolArrayAccess().getBoolArrayAction_0()); 
            // InternalBasicsParser.g:6647:2: ()
            // InternalBasicsParser.g:6647:3: 
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
    // InternalBasicsParser.g:6655:1: rule__BoolArray__Group__1 : rule__BoolArray__Group__1__Impl ;
    public final void rule__BoolArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6659:1: ( rule__BoolArray__Group__1__Impl )
            // InternalBasicsParser.g:6660:2: rule__BoolArray__Group__1__Impl
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
    // InternalBasicsParser.g:6666:1: rule__BoolArray__Group__1__Impl : ( Bool_1 ) ;
    public final void rule__BoolArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6670:1: ( ( Bool_1 ) )
            // InternalBasicsParser.g:6671:1: ( Bool_1 )
            {
            // InternalBasicsParser.g:6671:1: ( Bool_1 )
            // InternalBasicsParser.g:6672:2: Bool_1
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
    // InternalBasicsParser.g:6682:1: rule__Int8Array__Group__0 : rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1 ;
    public final void rule__Int8Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6686:1: ( rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1 )
            // InternalBasicsParser.g:6687:2: rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1
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
    // InternalBasicsParser.g:6694:1: rule__Int8Array__Group__0__Impl : ( () ) ;
    public final void rule__Int8Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6698:1: ( ( () ) )
            // InternalBasicsParser.g:6699:1: ( () )
            {
            // InternalBasicsParser.g:6699:1: ( () )
            // InternalBasicsParser.g:6700:2: ()
            {
             before(grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0()); 
            // InternalBasicsParser.g:6701:2: ()
            // InternalBasicsParser.g:6701:3: 
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
    // InternalBasicsParser.g:6709:1: rule__Int8Array__Group__1 : rule__Int8Array__Group__1__Impl ;
    public final void rule__Int8Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6713:1: ( rule__Int8Array__Group__1__Impl )
            // InternalBasicsParser.g:6714:2: rule__Int8Array__Group__1__Impl
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
    // InternalBasicsParser.g:6720:1: rule__Int8Array__Group__1__Impl : ( Int8_1 ) ;
    public final void rule__Int8Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6724:1: ( ( Int8_1 ) )
            // InternalBasicsParser.g:6725:1: ( Int8_1 )
            {
            // InternalBasicsParser.g:6725:1: ( Int8_1 )
            // InternalBasicsParser.g:6726:2: Int8_1
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
    // InternalBasicsParser.g:6736:1: rule__Uint8Array__Group__0 : rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1 ;
    public final void rule__Uint8Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6740:1: ( rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1 )
            // InternalBasicsParser.g:6741:2: rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1
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
    // InternalBasicsParser.g:6748:1: rule__Uint8Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint8Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6752:1: ( ( () ) )
            // InternalBasicsParser.g:6753:1: ( () )
            {
            // InternalBasicsParser.g:6753:1: ( () )
            // InternalBasicsParser.g:6754:2: ()
            {
             before(grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0()); 
            // InternalBasicsParser.g:6755:2: ()
            // InternalBasicsParser.g:6755:3: 
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
    // InternalBasicsParser.g:6763:1: rule__Uint8Array__Group__1 : rule__Uint8Array__Group__1__Impl ;
    public final void rule__Uint8Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6767:1: ( rule__Uint8Array__Group__1__Impl )
            // InternalBasicsParser.g:6768:2: rule__Uint8Array__Group__1__Impl
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
    // InternalBasicsParser.g:6774:1: rule__Uint8Array__Group__1__Impl : ( Uint8_1 ) ;
    public final void rule__Uint8Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6778:1: ( ( Uint8_1 ) )
            // InternalBasicsParser.g:6779:1: ( Uint8_1 )
            {
            // InternalBasicsParser.g:6779:1: ( Uint8_1 )
            // InternalBasicsParser.g:6780:2: Uint8_1
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
    // InternalBasicsParser.g:6790:1: rule__Int16Array__Group__0 : rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1 ;
    public final void rule__Int16Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6794:1: ( rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1 )
            // InternalBasicsParser.g:6795:2: rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1
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
    // InternalBasicsParser.g:6802:1: rule__Int16Array__Group__0__Impl : ( () ) ;
    public final void rule__Int16Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6806:1: ( ( () ) )
            // InternalBasicsParser.g:6807:1: ( () )
            {
            // InternalBasicsParser.g:6807:1: ( () )
            // InternalBasicsParser.g:6808:2: ()
            {
             before(grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0()); 
            // InternalBasicsParser.g:6809:2: ()
            // InternalBasicsParser.g:6809:3: 
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
    // InternalBasicsParser.g:6817:1: rule__Int16Array__Group__1 : rule__Int16Array__Group__1__Impl ;
    public final void rule__Int16Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6821:1: ( rule__Int16Array__Group__1__Impl )
            // InternalBasicsParser.g:6822:2: rule__Int16Array__Group__1__Impl
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
    // InternalBasicsParser.g:6828:1: rule__Int16Array__Group__1__Impl : ( Int16_1 ) ;
    public final void rule__Int16Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6832:1: ( ( Int16_1 ) )
            // InternalBasicsParser.g:6833:1: ( Int16_1 )
            {
            // InternalBasicsParser.g:6833:1: ( Int16_1 )
            // InternalBasicsParser.g:6834:2: Int16_1
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
    // InternalBasicsParser.g:6844:1: rule__Uint16Array__Group__0 : rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1 ;
    public final void rule__Uint16Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6848:1: ( rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1 )
            // InternalBasicsParser.g:6849:2: rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1
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
    // InternalBasicsParser.g:6856:1: rule__Uint16Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint16Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6860:1: ( ( () ) )
            // InternalBasicsParser.g:6861:1: ( () )
            {
            // InternalBasicsParser.g:6861:1: ( () )
            // InternalBasicsParser.g:6862:2: ()
            {
             before(grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0()); 
            // InternalBasicsParser.g:6863:2: ()
            // InternalBasicsParser.g:6863:3: 
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
    // InternalBasicsParser.g:6871:1: rule__Uint16Array__Group__1 : rule__Uint16Array__Group__1__Impl ;
    public final void rule__Uint16Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6875:1: ( rule__Uint16Array__Group__1__Impl )
            // InternalBasicsParser.g:6876:2: rule__Uint16Array__Group__1__Impl
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
    // InternalBasicsParser.g:6882:1: rule__Uint16Array__Group__1__Impl : ( Uint16_1 ) ;
    public final void rule__Uint16Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6886:1: ( ( Uint16_1 ) )
            // InternalBasicsParser.g:6887:1: ( Uint16_1 )
            {
            // InternalBasicsParser.g:6887:1: ( Uint16_1 )
            // InternalBasicsParser.g:6888:2: Uint16_1
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
    // InternalBasicsParser.g:6898:1: rule__Int32Array__Group__0 : rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1 ;
    public final void rule__Int32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6902:1: ( rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1 )
            // InternalBasicsParser.g:6903:2: rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1
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
    // InternalBasicsParser.g:6910:1: rule__Int32Array__Group__0__Impl : ( () ) ;
    public final void rule__Int32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6914:1: ( ( () ) )
            // InternalBasicsParser.g:6915:1: ( () )
            {
            // InternalBasicsParser.g:6915:1: ( () )
            // InternalBasicsParser.g:6916:2: ()
            {
             before(grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0()); 
            // InternalBasicsParser.g:6917:2: ()
            // InternalBasicsParser.g:6917:3: 
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
    // InternalBasicsParser.g:6925:1: rule__Int32Array__Group__1 : rule__Int32Array__Group__1__Impl ;
    public final void rule__Int32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6929:1: ( rule__Int32Array__Group__1__Impl )
            // InternalBasicsParser.g:6930:2: rule__Int32Array__Group__1__Impl
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
    // InternalBasicsParser.g:6936:1: rule__Int32Array__Group__1__Impl : ( Int32_1 ) ;
    public final void rule__Int32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6940:1: ( ( Int32_1 ) )
            // InternalBasicsParser.g:6941:1: ( Int32_1 )
            {
            // InternalBasicsParser.g:6941:1: ( Int32_1 )
            // InternalBasicsParser.g:6942:2: Int32_1
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
    // InternalBasicsParser.g:6952:1: rule__Uint32Array__Group__0 : rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1 ;
    public final void rule__Uint32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6956:1: ( rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1 )
            // InternalBasicsParser.g:6957:2: rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1
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
    // InternalBasicsParser.g:6964:1: rule__Uint32Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6968:1: ( ( () ) )
            // InternalBasicsParser.g:6969:1: ( () )
            {
            // InternalBasicsParser.g:6969:1: ( () )
            // InternalBasicsParser.g:6970:2: ()
            {
             before(grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0()); 
            // InternalBasicsParser.g:6971:2: ()
            // InternalBasicsParser.g:6971:3: 
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
    // InternalBasicsParser.g:6979:1: rule__Uint32Array__Group__1 : rule__Uint32Array__Group__1__Impl ;
    public final void rule__Uint32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6983:1: ( rule__Uint32Array__Group__1__Impl )
            // InternalBasicsParser.g:6984:2: rule__Uint32Array__Group__1__Impl
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
    // InternalBasicsParser.g:6990:1: rule__Uint32Array__Group__1__Impl : ( Uint32_1 ) ;
    public final void rule__Uint32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6994:1: ( ( Uint32_1 ) )
            // InternalBasicsParser.g:6995:1: ( Uint32_1 )
            {
            // InternalBasicsParser.g:6995:1: ( Uint32_1 )
            // InternalBasicsParser.g:6996:2: Uint32_1
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
    // InternalBasicsParser.g:7006:1: rule__Int64Array__Group__0 : rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1 ;
    public final void rule__Int64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7010:1: ( rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1 )
            // InternalBasicsParser.g:7011:2: rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1
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
    // InternalBasicsParser.g:7018:1: rule__Int64Array__Group__0__Impl : ( () ) ;
    public final void rule__Int64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7022:1: ( ( () ) )
            // InternalBasicsParser.g:7023:1: ( () )
            {
            // InternalBasicsParser.g:7023:1: ( () )
            // InternalBasicsParser.g:7024:2: ()
            {
             before(grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0()); 
            // InternalBasicsParser.g:7025:2: ()
            // InternalBasicsParser.g:7025:3: 
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
    // InternalBasicsParser.g:7033:1: rule__Int64Array__Group__1 : rule__Int64Array__Group__1__Impl ;
    public final void rule__Int64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7037:1: ( rule__Int64Array__Group__1__Impl )
            // InternalBasicsParser.g:7038:2: rule__Int64Array__Group__1__Impl
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
    // InternalBasicsParser.g:7044:1: rule__Int64Array__Group__1__Impl : ( Int64_1 ) ;
    public final void rule__Int64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7048:1: ( ( Int64_1 ) )
            // InternalBasicsParser.g:7049:1: ( Int64_1 )
            {
            // InternalBasicsParser.g:7049:1: ( Int64_1 )
            // InternalBasicsParser.g:7050:2: Int64_1
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
    // InternalBasicsParser.g:7060:1: rule__Uint64Array__Group__0 : rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1 ;
    public final void rule__Uint64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7064:1: ( rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1 )
            // InternalBasicsParser.g:7065:2: rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1
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
    // InternalBasicsParser.g:7072:1: rule__Uint64Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7076:1: ( ( () ) )
            // InternalBasicsParser.g:7077:1: ( () )
            {
            // InternalBasicsParser.g:7077:1: ( () )
            // InternalBasicsParser.g:7078:2: ()
            {
             before(grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0()); 
            // InternalBasicsParser.g:7079:2: ()
            // InternalBasicsParser.g:7079:3: 
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
    // InternalBasicsParser.g:7087:1: rule__Uint64Array__Group__1 : rule__Uint64Array__Group__1__Impl ;
    public final void rule__Uint64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7091:1: ( rule__Uint64Array__Group__1__Impl )
            // InternalBasicsParser.g:7092:2: rule__Uint64Array__Group__1__Impl
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
    // InternalBasicsParser.g:7098:1: rule__Uint64Array__Group__1__Impl : ( Uint64_1 ) ;
    public final void rule__Uint64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7102:1: ( ( Uint64_1 ) )
            // InternalBasicsParser.g:7103:1: ( Uint64_1 )
            {
            // InternalBasicsParser.g:7103:1: ( Uint64_1 )
            // InternalBasicsParser.g:7104:2: Uint64_1
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
    // InternalBasicsParser.g:7114:1: rule__Float32Array__Group__0 : rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1 ;
    public final void rule__Float32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7118:1: ( rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1 )
            // InternalBasicsParser.g:7119:2: rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1
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
    // InternalBasicsParser.g:7126:1: rule__Float32Array__Group__0__Impl : ( () ) ;
    public final void rule__Float32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7130:1: ( ( () ) )
            // InternalBasicsParser.g:7131:1: ( () )
            {
            // InternalBasicsParser.g:7131:1: ( () )
            // InternalBasicsParser.g:7132:2: ()
            {
             before(grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0()); 
            // InternalBasicsParser.g:7133:2: ()
            // InternalBasicsParser.g:7133:3: 
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
    // InternalBasicsParser.g:7141:1: rule__Float32Array__Group__1 : rule__Float32Array__Group__1__Impl ;
    public final void rule__Float32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7145:1: ( rule__Float32Array__Group__1__Impl )
            // InternalBasicsParser.g:7146:2: rule__Float32Array__Group__1__Impl
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
    // InternalBasicsParser.g:7152:1: rule__Float32Array__Group__1__Impl : ( Float32_1 ) ;
    public final void rule__Float32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7156:1: ( ( Float32_1 ) )
            // InternalBasicsParser.g:7157:1: ( Float32_1 )
            {
            // InternalBasicsParser.g:7157:1: ( Float32_1 )
            // InternalBasicsParser.g:7158:2: Float32_1
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
    // InternalBasicsParser.g:7168:1: rule__Float64Array__Group__0 : rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1 ;
    public final void rule__Float64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7172:1: ( rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1 )
            // InternalBasicsParser.g:7173:2: rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1
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
    // InternalBasicsParser.g:7180:1: rule__Float64Array__Group__0__Impl : ( () ) ;
    public final void rule__Float64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7184:1: ( ( () ) )
            // InternalBasicsParser.g:7185:1: ( () )
            {
            // InternalBasicsParser.g:7185:1: ( () )
            // InternalBasicsParser.g:7186:2: ()
            {
             before(grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0()); 
            // InternalBasicsParser.g:7187:2: ()
            // InternalBasicsParser.g:7187:3: 
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
    // InternalBasicsParser.g:7195:1: rule__Float64Array__Group__1 : rule__Float64Array__Group__1__Impl ;
    public final void rule__Float64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7199:1: ( rule__Float64Array__Group__1__Impl )
            // InternalBasicsParser.g:7200:2: rule__Float64Array__Group__1__Impl
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
    // InternalBasicsParser.g:7206:1: rule__Float64Array__Group__1__Impl : ( Float64_1 ) ;
    public final void rule__Float64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7210:1: ( ( Float64_1 ) )
            // InternalBasicsParser.g:7211:1: ( Float64_1 )
            {
            // InternalBasicsParser.g:7211:1: ( Float64_1 )
            // InternalBasicsParser.g:7212:2: Float64_1
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
    // InternalBasicsParser.g:7222:1: rule__String0Array__Group__0 : rule__String0Array__Group__0__Impl rule__String0Array__Group__1 ;
    public final void rule__String0Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7226:1: ( rule__String0Array__Group__0__Impl rule__String0Array__Group__1 )
            // InternalBasicsParser.g:7227:2: rule__String0Array__Group__0__Impl rule__String0Array__Group__1
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
    // InternalBasicsParser.g:7234:1: rule__String0Array__Group__0__Impl : ( () ) ;
    public final void rule__String0Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7238:1: ( ( () ) )
            // InternalBasicsParser.g:7239:1: ( () )
            {
            // InternalBasicsParser.g:7239:1: ( () )
            // InternalBasicsParser.g:7240:2: ()
            {
             before(grammarAccess.getString0ArrayAccess().getStringArrayAction_0()); 
            // InternalBasicsParser.g:7241:2: ()
            // InternalBasicsParser.g:7241:3: 
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
    // InternalBasicsParser.g:7249:1: rule__String0Array__Group__1 : rule__String0Array__Group__1__Impl ;
    public final void rule__String0Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7253:1: ( rule__String0Array__Group__1__Impl )
            // InternalBasicsParser.g:7254:2: rule__String0Array__Group__1__Impl
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
    // InternalBasicsParser.g:7260:1: rule__String0Array__Group__1__Impl : ( String_2 ) ;
    public final void rule__String0Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7264:1: ( ( String_2 ) )
            // InternalBasicsParser.g:7265:1: ( String_2 )
            {
            // InternalBasicsParser.g:7265:1: ( String_2 )
            // InternalBasicsParser.g:7266:2: String_2
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
    // InternalBasicsParser.g:7276:1: rule__ByteArray__Group__0 : rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1 ;
    public final void rule__ByteArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7280:1: ( rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1 )
            // InternalBasicsParser.g:7281:2: rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1
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
    // InternalBasicsParser.g:7288:1: rule__ByteArray__Group__0__Impl : ( () ) ;
    public final void rule__ByteArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7292:1: ( ( () ) )
            // InternalBasicsParser.g:7293:1: ( () )
            {
            // InternalBasicsParser.g:7293:1: ( () )
            // InternalBasicsParser.g:7294:2: ()
            {
             before(grammarAccess.getByteArrayAccess().getByteArrayAction_0()); 
            // InternalBasicsParser.g:7295:2: ()
            // InternalBasicsParser.g:7295:3: 
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
    // InternalBasicsParser.g:7303:1: rule__ByteArray__Group__1 : rule__ByteArray__Group__1__Impl ;
    public final void rule__ByteArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7307:1: ( rule__ByteArray__Group__1__Impl )
            // InternalBasicsParser.g:7308:2: rule__ByteArray__Group__1__Impl
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
    // InternalBasicsParser.g:7314:1: rule__ByteArray__Group__1__Impl : ( Byte_1 ) ;
    public final void rule__ByteArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7318:1: ( ( Byte_1 ) )
            // InternalBasicsParser.g:7319:1: ( Byte_1 )
            {
            // InternalBasicsParser.g:7319:1: ( Byte_1 )
            // InternalBasicsParser.g:7320:2: Byte_1
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
    // InternalBasicsParser.g:7330:1: rule__CharArray__Group__0 : rule__CharArray__Group__0__Impl rule__CharArray__Group__1 ;
    public final void rule__CharArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7334:1: ( rule__CharArray__Group__0__Impl rule__CharArray__Group__1 )
            // InternalBasicsParser.g:7335:2: rule__CharArray__Group__0__Impl rule__CharArray__Group__1
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
    // InternalBasicsParser.g:7342:1: rule__CharArray__Group__0__Impl : ( () ) ;
    public final void rule__CharArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7346:1: ( ( () ) )
            // InternalBasicsParser.g:7347:1: ( () )
            {
            // InternalBasicsParser.g:7347:1: ( () )
            // InternalBasicsParser.g:7348:2: ()
            {
             before(grammarAccess.getCharArrayAccess().getCharArrayAction_0()); 
            // InternalBasicsParser.g:7349:2: ()
            // InternalBasicsParser.g:7349:3: 
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
    // InternalBasicsParser.g:7357:1: rule__CharArray__Group__1 : rule__CharArray__Group__1__Impl ;
    public final void rule__CharArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7361:1: ( rule__CharArray__Group__1__Impl )
            // InternalBasicsParser.g:7362:2: rule__CharArray__Group__1__Impl
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
    // InternalBasicsParser.g:7368:1: rule__CharArray__Group__1__Impl : ( Char_1 ) ;
    public final void rule__CharArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7372:1: ( ( Char_1 ) )
            // InternalBasicsParser.g:7373:1: ( Char_1 )
            {
            // InternalBasicsParser.g:7373:1: ( Char_1 )
            // InternalBasicsParser.g:7374:2: Char_1
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
    // InternalBasicsParser.g:7384:1: rule__Header__Group__0 : rule__Header__Group__0__Impl rule__Header__Group__1 ;
    public final void rule__Header__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7388:1: ( rule__Header__Group__0__Impl rule__Header__Group__1 )
            // InternalBasicsParser.g:7389:2: rule__Header__Group__0__Impl rule__Header__Group__1
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
    // InternalBasicsParser.g:7396:1: rule__Header__Group__0__Impl : ( () ) ;
    public final void rule__Header__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7400:1: ( ( () ) )
            // InternalBasicsParser.g:7401:1: ( () )
            {
            // InternalBasicsParser.g:7401:1: ( () )
            // InternalBasicsParser.g:7402:2: ()
            {
             before(grammarAccess.getHeaderAccess().getHeaderAction_0()); 
            // InternalBasicsParser.g:7403:2: ()
            // InternalBasicsParser.g:7403:3: 
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
    // InternalBasicsParser.g:7411:1: rule__Header__Group__1 : rule__Header__Group__1__Impl ;
    public final void rule__Header__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7415:1: ( rule__Header__Group__1__Impl )
            // InternalBasicsParser.g:7416:2: rule__Header__Group__1__Impl
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
    // InternalBasicsParser.g:7422:1: rule__Header__Group__1__Impl : ( Header ) ;
    public final void rule__Header__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7426:1: ( ( Header ) )
            // InternalBasicsParser.g:7427:1: ( Header )
            {
            // InternalBasicsParser.g:7427:1: ( Header )
            // InternalBasicsParser.g:7428:2: Header
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
    // InternalBasicsParser.g:7438:1: rule__ArraySpecRef__Group__0 : rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1 ;
    public final void rule__ArraySpecRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7442:1: ( rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1 )
            // InternalBasicsParser.g:7443:2: rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1
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
    // InternalBasicsParser.g:7450:1: rule__ArraySpecRef__Group__0__Impl : ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) ) ;
    public final void rule__ArraySpecRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7454:1: ( ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) ) )
            // InternalBasicsParser.g:7455:1: ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) )
            {
            // InternalBasicsParser.g:7455:1: ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) )
            // InternalBasicsParser.g:7456:2: ( rule__ArraySpecRef__ReferenceAssignment_0 )
            {
             before(grammarAccess.getArraySpecRefAccess().getReferenceAssignment_0()); 
            // InternalBasicsParser.g:7457:2: ( rule__ArraySpecRef__ReferenceAssignment_0 )
            // InternalBasicsParser.g:7457:3: rule__ArraySpecRef__ReferenceAssignment_0
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
    // InternalBasicsParser.g:7465:1: rule__ArraySpecRef__Group__1 : rule__ArraySpecRef__Group__1__Impl ;
    public final void rule__ArraySpecRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7469:1: ( rule__ArraySpecRef__Group__1__Impl )
            // InternalBasicsParser.g:7470:2: rule__ArraySpecRef__Group__1__Impl
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
    // InternalBasicsParser.g:7476:1: rule__ArraySpecRef__Group__1__Impl : ( LeftSquareBracketRightSquareBracket ) ;
    public final void rule__ArraySpecRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7480:1: ( ( LeftSquareBracketRightSquareBracket ) )
            // InternalBasicsParser.g:7481:1: ( LeftSquareBracketRightSquareBracket )
            {
            // InternalBasicsParser.g:7481:1: ( LeftSquareBracketRightSquareBracket )
            // InternalBasicsParser.g:7482:2: LeftSquareBracketRightSquareBracket
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
    // InternalBasicsParser.g:7492:1: rule__ExtensionBlockName__Group__0 : rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1 ;
    public final void rule__ExtensionBlockName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7496:1: ( rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1 )
            // InternalBasicsParser.g:7497:2: rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1
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
    // InternalBasicsParser.g:7504:1: rule__ExtensionBlockName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__ExtensionBlockName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7508:1: ( ( RULE_ID ) )
            // InternalBasicsParser.g:7509:1: ( RULE_ID )
            {
            // InternalBasicsParser.g:7509:1: ( RULE_ID )
            // InternalBasicsParser.g:7510:2: RULE_ID
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
    // InternalBasicsParser.g:7519:1: rule__ExtensionBlockName__Group__1 : rule__ExtensionBlockName__Group__1__Impl ;
    public final void rule__ExtensionBlockName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7523:1: ( rule__ExtensionBlockName__Group__1__Impl )
            // InternalBasicsParser.g:7524:2: rule__ExtensionBlockName__Group__1__Impl
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
    // InternalBasicsParser.g:7530:1: rule__ExtensionBlockName__Group__1__Impl : ( ( rule__ExtensionBlockName__Group_1__0 )* ) ;
    public final void rule__ExtensionBlockName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7534:1: ( ( ( rule__ExtensionBlockName__Group_1__0 )* ) )
            // InternalBasicsParser.g:7535:1: ( ( rule__ExtensionBlockName__Group_1__0 )* )
            {
            // InternalBasicsParser.g:7535:1: ( ( rule__ExtensionBlockName__Group_1__0 )* )
            // InternalBasicsParser.g:7536:2: ( rule__ExtensionBlockName__Group_1__0 )*
            {
             before(grammarAccess.getExtensionBlockNameAccess().getGroup_1()); 
            // InternalBasicsParser.g:7537:2: ( rule__ExtensionBlockName__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==FullStop) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBasicsParser.g:7537:3: rule__ExtensionBlockName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_66);
            	    rule__ExtensionBlockName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalBasicsParser.g:7546:1: rule__ExtensionBlockName__Group_1__0 : rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1 ;
    public final void rule__ExtensionBlockName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7550:1: ( rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1 )
            // InternalBasicsParser.g:7551:2: rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1
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
    // InternalBasicsParser.g:7558:1: rule__ExtensionBlockName__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__ExtensionBlockName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7562:1: ( ( FullStop ) )
            // InternalBasicsParser.g:7563:1: ( FullStop )
            {
            // InternalBasicsParser.g:7563:1: ( FullStop )
            // InternalBasicsParser.g:7564:2: FullStop
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
    // InternalBasicsParser.g:7573:1: rule__ExtensionBlockName__Group_1__1 : rule__ExtensionBlockName__Group_1__1__Impl ;
    public final void rule__ExtensionBlockName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7577:1: ( rule__ExtensionBlockName__Group_1__1__Impl )
            // InternalBasicsParser.g:7578:2: rule__ExtensionBlockName__Group_1__1__Impl
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
    // InternalBasicsParser.g:7584:1: rule__ExtensionBlockName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__ExtensionBlockName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7588:1: ( ( RULE_ID ) )
            // InternalBasicsParser.g:7589:1: ( RULE_ID )
            {
            // InternalBasicsParser.g:7589:1: ( RULE_ID )
            // InternalBasicsParser.g:7590:2: RULE_ID
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
    // InternalBasicsParser.g:7600:1: rule__ExtensionEntry__Group__0 : rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1 ;
    public final void rule__ExtensionEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7604:1: ( rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1 )
            // InternalBasicsParser.g:7605:2: rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1
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
    // InternalBasicsParser.g:7612:1: rule__ExtensionEntry__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7616:1: ( ( () ) )
            // InternalBasicsParser.g:7617:1: ( () )
            {
            // InternalBasicsParser.g:7617:1: ( () )
            // InternalBasicsParser.g:7618:2: ()
            {
             before(grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0()); 
            // InternalBasicsParser.g:7619:2: ()
            // InternalBasicsParser.g:7619:3: 
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
    // InternalBasicsParser.g:7627:1: rule__ExtensionEntry__Group__1 : rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2 ;
    public final void rule__ExtensionEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7631:1: ( rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2 )
            // InternalBasicsParser.g:7632:2: rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2
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
    // InternalBasicsParser.g:7639:1: rule__ExtensionEntry__Group__1__Impl : ( ( rule__ExtensionEntry__Alternatives_1 ) ) ;
    public final void rule__ExtensionEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7643:1: ( ( ( rule__ExtensionEntry__Alternatives_1 ) ) )
            // InternalBasicsParser.g:7644:1: ( ( rule__ExtensionEntry__Alternatives_1 ) )
            {
            // InternalBasicsParser.g:7644:1: ( ( rule__ExtensionEntry__Alternatives_1 ) )
            // InternalBasicsParser.g:7645:2: ( rule__ExtensionEntry__Alternatives_1 )
            {
             before(grammarAccess.getExtensionEntryAccess().getAlternatives_1()); 
            // InternalBasicsParser.g:7646:2: ( rule__ExtensionEntry__Alternatives_1 )
            // InternalBasicsParser.g:7646:3: rule__ExtensionEntry__Alternatives_1
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
    // InternalBasicsParser.g:7654:1: rule__ExtensionEntry__Group__2 : rule__ExtensionEntry__Group__2__Impl ;
    public final void rule__ExtensionEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7658:1: ( rule__ExtensionEntry__Group__2__Impl )
            // InternalBasicsParser.g:7659:2: rule__ExtensionEntry__Group__2__Impl
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
    // InternalBasicsParser.g:7665:1: rule__ExtensionEntry__Group__2__Impl : ( ( rule__ExtensionEntry__ValueAssignment_2 ) ) ;
    public final void rule__ExtensionEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7669:1: ( ( ( rule__ExtensionEntry__ValueAssignment_2 ) ) )
            // InternalBasicsParser.g:7670:1: ( ( rule__ExtensionEntry__ValueAssignment_2 ) )
            {
            // InternalBasicsParser.g:7670:1: ( ( rule__ExtensionEntry__ValueAssignment_2 ) )
            // InternalBasicsParser.g:7671:2: ( rule__ExtensionEntry__ValueAssignment_2 )
            {
             before(grammarAccess.getExtensionEntryAccess().getValueAssignment_2()); 
            // InternalBasicsParser.g:7672:2: ( rule__ExtensionEntry__ValueAssignment_2 )
            // InternalBasicsParser.g:7672:3: rule__ExtensionEntry__ValueAssignment_2
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
    // InternalBasicsParser.g:7681:1: rule__ExtensionEntry__Group_1_0__0 : rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1 ;
    public final void rule__ExtensionEntry__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7685:1: ( rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1 )
            // InternalBasicsParser.g:7686:2: rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1
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
    // InternalBasicsParser.g:7693:1: rule__ExtensionEntry__Group_1_0__0__Impl : ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) ) ;
    public final void rule__ExtensionEntry__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7697:1: ( ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) ) )
            // InternalBasicsParser.g:7698:1: ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) )
            {
            // InternalBasicsParser.g:7698:1: ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) )
            // InternalBasicsParser.g:7699:2: ( rule__ExtensionEntry__KeyAssignment_1_0_0 )
            {
             before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_0_0()); 
            // InternalBasicsParser.g:7700:2: ( rule__ExtensionEntry__KeyAssignment_1_0_0 )
            // InternalBasicsParser.g:7700:3: rule__ExtensionEntry__KeyAssignment_1_0_0
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
    // InternalBasicsParser.g:7708:1: rule__ExtensionEntry__Group_1_0__1 : rule__ExtensionEntry__Group_1_0__1__Impl ;
    public final void rule__ExtensionEntry__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7712:1: ( rule__ExtensionEntry__Group_1_0__1__Impl )
            // InternalBasicsParser.g:7713:2: rule__ExtensionEntry__Group_1_0__1__Impl
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
    // InternalBasicsParser.g:7719:1: rule__ExtensionEntry__Group_1_0__1__Impl : ( Colon ) ;
    public final void rule__ExtensionEntry__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7723:1: ( ( Colon ) )
            // InternalBasicsParser.g:7724:1: ( Colon )
            {
            // InternalBasicsParser.g:7724:1: ( Colon )
            // InternalBasicsParser.g:7725:2: Colon
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
    // InternalBasicsParser.g:7735:1: rule__ExtensionListValue__Group__0 : rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1 ;
    public final void rule__ExtensionListValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7739:1: ( rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1 )
            // InternalBasicsParser.g:7740:2: rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1
            {
            pushFollow(FOLLOW_70);
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
    // InternalBasicsParser.g:7747:1: rule__ExtensionListValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionListValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7751:1: ( ( () ) )
            // InternalBasicsParser.g:7752:1: ( () )
            {
            // InternalBasicsParser.g:7752:1: ( () )
            // InternalBasicsParser.g:7753:2: ()
            {
             before(grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0()); 
            // InternalBasicsParser.g:7754:2: ()
            // InternalBasicsParser.g:7754:3: 
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
    // InternalBasicsParser.g:7762:1: rule__ExtensionListValue__Group__1 : rule__ExtensionListValue__Group__1__Impl ;
    public final void rule__ExtensionListValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7766:1: ( rule__ExtensionListValue__Group__1__Impl )
            // InternalBasicsParser.g:7767:2: rule__ExtensionListValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group__1__Impl();

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
    // InternalBasicsParser.g:7773:1: rule__ExtensionListValue__Group__1__Impl : ( ( rule__ExtensionListValue__Alternatives_1 ) ) ;
    public final void rule__ExtensionListValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7777:1: ( ( ( rule__ExtensionListValue__Alternatives_1 ) ) )
            // InternalBasicsParser.g:7778:1: ( ( rule__ExtensionListValue__Alternatives_1 ) )
            {
            // InternalBasicsParser.g:7778:1: ( ( rule__ExtensionListValue__Alternatives_1 ) )
            // InternalBasicsParser.g:7779:2: ( rule__ExtensionListValue__Alternatives_1 )
            {
             before(grammarAccess.getExtensionListValueAccess().getAlternatives_1()); 
            // InternalBasicsParser.g:7780:2: ( rule__ExtensionListValue__Alternatives_1 )
            // InternalBasicsParser.g:7780:3: rule__ExtensionListValue__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getExtensionListValueAccess().getAlternatives_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ExtensionListValue__Group_1_1__0"
    // InternalBasicsParser.g:7789:1: rule__ExtensionListValue__Group_1_1__0 : rule__ExtensionListValue__Group_1_1__0__Impl rule__ExtensionListValue__Group_1_1__1 ;
    public final void rule__ExtensionListValue__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7793:1: ( rule__ExtensionListValue__Group_1_1__0__Impl rule__ExtensionListValue__Group_1_1__1 )
            // InternalBasicsParser.g:7794:2: rule__ExtensionListValue__Group_1_1__0__Impl rule__ExtensionListValue__Group_1_1__1
            {
            pushFollow(FOLLOW_71);
            rule__ExtensionListValue__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_1_1__1();

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
    // $ANTLR end "rule__ExtensionListValue__Group_1_1__0"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1__0__Impl"
    // InternalBasicsParser.g:7801:1: rule__ExtensionListValue__Group_1_1__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__ExtensionListValue__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7805:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7806:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7806:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7807:2: LeftSquareBracket
            {
             before(grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1_1_0()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_1_1__0__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1__1"
    // InternalBasicsParser.g:7816:1: rule__ExtensionListValue__Group_1_1__1 : rule__ExtensionListValue__Group_1_1__1__Impl rule__ExtensionListValue__Group_1_1__2 ;
    public final void rule__ExtensionListValue__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7820:1: ( rule__ExtensionListValue__Group_1_1__1__Impl rule__ExtensionListValue__Group_1_1__2 )
            // InternalBasicsParser.g:7821:2: rule__ExtensionListValue__Group_1_1__1__Impl rule__ExtensionListValue__Group_1_1__2
            {
            pushFollow(FOLLOW_71);
            rule__ExtensionListValue__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_1_1__2();

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
    // $ANTLR end "rule__ExtensionListValue__Group_1_1__1"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1__1__Impl"
    // InternalBasicsParser.g:7828:1: rule__ExtensionListValue__Group_1_1__1__Impl : ( ( rule__ExtensionListValue__Group_1_1_1__0 )? ) ;
    public final void rule__ExtensionListValue__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7832:1: ( ( ( rule__ExtensionListValue__Group_1_1_1__0 )? ) )
            // InternalBasicsParser.g:7833:1: ( ( rule__ExtensionListValue__Group_1_1_1__0 )? )
            {
            // InternalBasicsParser.g:7833:1: ( ( rule__ExtensionListValue__Group_1_1_1__0 )? )
            // InternalBasicsParser.g:7834:2: ( rule__ExtensionListValue__Group_1_1_1__0 )?
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup_1_1_1()); 
            // InternalBasicsParser.g:7835:2: ( rule__ExtensionListValue__Group_1_1_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=Duration && LA35_0<=Feedback)||(LA35_0>=Boolean && LA35_0<=Float64)||(LA35_0>=Message && LA35_0<=Service)||(LA35_0>=Base64 && LA35_0<=Action)||LA35_0==Result||(LA35_0>=String_1 && LA35_0<=Uint64)||LA35_0==Array||(LA35_0>=Int16 && LA35_0<=Sub)||(LA35_0>=Uint8 && LA35_0<=Any)||LA35_0==LeftSquareBracketRightSquareBracket||LA35_0==LeftSquareBracket||LA35_0==LeftCurlyBracket||(LA35_0>=RULE_BOOLEAN && LA35_0<=RULE_DOUBLE)||(LA35_0>=RULE_ID && LA35_0<=RULE_INT)||LA35_0==RULE_BEGIN) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBasicsParser.g:7835:3: rule__ExtensionListValue__Group_1_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ExtensionListValue__Group_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExtensionListValueAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_1_1__1__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1__2"
    // InternalBasicsParser.g:7843:1: rule__ExtensionListValue__Group_1_1__2 : rule__ExtensionListValue__Group_1_1__2__Impl ;
    public final void rule__ExtensionListValue__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7847:1: ( rule__ExtensionListValue__Group_1_1__2__Impl )
            // InternalBasicsParser.g:7848:2: rule__ExtensionListValue__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_1_1__2__Impl();

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
    // $ANTLR end "rule__ExtensionListValue__Group_1_1__2"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1__2__Impl"
    // InternalBasicsParser.g:7854:1: rule__ExtensionListValue__Group_1_1__2__Impl : ( RightSquareBracket ) ;
    public final void rule__ExtensionListValue__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7858:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7859:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7859:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7860:2: RightSquareBracket
            {
             before(grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_1_1_2()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_1_1__2__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1__0"
    // InternalBasicsParser.g:7870:1: rule__ExtensionListValue__Group_1_1_1__0 : rule__ExtensionListValue__Group_1_1_1__0__Impl rule__ExtensionListValue__Group_1_1_1__1 ;
    public final void rule__ExtensionListValue__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7874:1: ( rule__ExtensionListValue__Group_1_1_1__0__Impl rule__ExtensionListValue__Group_1_1_1__1 )
            // InternalBasicsParser.g:7875:2: rule__ExtensionListValue__Group_1_1_1__0__Impl rule__ExtensionListValue__Group_1_1_1__1
            {
            pushFollow(FOLLOW_72);
            rule__ExtensionListValue__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_1_1_1__1();

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
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1__0"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1__0__Impl"
    // InternalBasicsParser.g:7882:1: rule__ExtensionListValue__Group_1_1_1__0__Impl : ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_0 ) ) ;
    public final void rule__ExtensionListValue__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7886:1: ( ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_0 ) ) )
            // InternalBasicsParser.g:7887:1: ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_0 ) )
            {
            // InternalBasicsParser.g:7887:1: ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_0 ) )
            // InternalBasicsParser.g:7888:2: ( rule__ExtensionListValue__ItemsAssignment_1_1_1_0 )
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsAssignment_1_1_1_0()); 
            // InternalBasicsParser.g:7889:2: ( rule__ExtensionListValue__ItemsAssignment_1_1_1_0 )
            // InternalBasicsParser.g:7889:3: rule__ExtensionListValue__ItemsAssignment_1_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__ItemsAssignment_1_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getExtensionListValueAccess().getItemsAssignment_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1__1"
    // InternalBasicsParser.g:7897:1: rule__ExtensionListValue__Group_1_1_1__1 : rule__ExtensionListValue__Group_1_1_1__1__Impl ;
    public final void rule__ExtensionListValue__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7901:1: ( rule__ExtensionListValue__Group_1_1_1__1__Impl )
            // InternalBasicsParser.g:7902:2: rule__ExtensionListValue__Group_1_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_1_1_1__1__Impl();

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
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1__1"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1__1__Impl"
    // InternalBasicsParser.g:7908:1: rule__ExtensionListValue__Group_1_1_1__1__Impl : ( ( rule__ExtensionListValue__Group_1_1_1_1__0 )* ) ;
    public final void rule__ExtensionListValue__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7912:1: ( ( ( rule__ExtensionListValue__Group_1_1_1_1__0 )* ) )
            // InternalBasicsParser.g:7913:1: ( ( rule__ExtensionListValue__Group_1_1_1_1__0 )* )
            {
            // InternalBasicsParser.g:7913:1: ( ( rule__ExtensionListValue__Group_1_1_1_1__0 )* )
            // InternalBasicsParser.g:7914:2: ( rule__ExtensionListValue__Group_1_1_1_1__0 )*
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup_1_1_1_1()); 
            // InternalBasicsParser.g:7915:2: ( rule__ExtensionListValue__Group_1_1_1_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=Duration && LA36_0<=Feedback)||(LA36_0>=Boolean && LA36_0<=Float64)||(LA36_0>=Message && LA36_0<=Service)||(LA36_0>=Base64 && LA36_0<=Action)||LA36_0==Result||(LA36_0>=String_1 && LA36_0<=Uint64)||LA36_0==Array||(LA36_0>=Int16 && LA36_0<=Sub)||(LA36_0>=Uint8 && LA36_0<=Any)||(LA36_0>=LeftSquareBracketRightSquareBracket && LA36_0<=Comma)||LA36_0==LeftSquareBracket||LA36_0==LeftCurlyBracket||(LA36_0>=RULE_BOOLEAN && LA36_0<=RULE_DOUBLE)||(LA36_0>=RULE_ID && LA36_0<=RULE_INT)||LA36_0==RULE_BEGIN) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBasicsParser.g:7915:3: rule__ExtensionListValue__Group_1_1_1_1__0
            	    {
            	    pushFollow(FOLLOW_73);
            	    rule__ExtensionListValue__Group_1_1_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getExtensionListValueAccess().getGroup_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1_1__0"
    // InternalBasicsParser.g:7924:1: rule__ExtensionListValue__Group_1_1_1_1__0 : rule__ExtensionListValue__Group_1_1_1_1__0__Impl rule__ExtensionListValue__Group_1_1_1_1__1 ;
    public final void rule__ExtensionListValue__Group_1_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7928:1: ( rule__ExtensionListValue__Group_1_1_1_1__0__Impl rule__ExtensionListValue__Group_1_1_1_1__1 )
            // InternalBasicsParser.g:7929:2: rule__ExtensionListValue__Group_1_1_1_1__0__Impl rule__ExtensionListValue__Group_1_1_1_1__1
            {
            pushFollow(FOLLOW_72);
            rule__ExtensionListValue__Group_1_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_1_1_1_1__1();

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
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1_1__0"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1_1__0__Impl"
    // InternalBasicsParser.g:7936:1: rule__ExtensionListValue__Group_1_1_1_1__0__Impl : ( ( Comma )? ) ;
    public final void rule__ExtensionListValue__Group_1_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7940:1: ( ( ( Comma )? ) )
            // InternalBasicsParser.g:7941:1: ( ( Comma )? )
            {
            // InternalBasicsParser.g:7941:1: ( ( Comma )? )
            // InternalBasicsParser.g:7942:2: ( Comma )?
            {
             before(grammarAccess.getExtensionListValueAccess().getCommaKeyword_1_1_1_1_0()); 
            // InternalBasicsParser.g:7943:2: ( Comma )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Comma) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBasicsParser.g:7943:3: Comma
                    {
                    match(input,Comma,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getExtensionListValueAccess().getCommaKeyword_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1_1__0__Impl"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1_1__1"
    // InternalBasicsParser.g:7951:1: rule__ExtensionListValue__Group_1_1_1_1__1 : rule__ExtensionListValue__Group_1_1_1_1__1__Impl ;
    public final void rule__ExtensionListValue__Group_1_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7955:1: ( rule__ExtensionListValue__Group_1_1_1_1__1__Impl )
            // InternalBasicsParser.g:7956:2: rule__ExtensionListValue__Group_1_1_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__Group_1_1_1_1__1__Impl();

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
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1_1__1"


    // $ANTLR start "rule__ExtensionListValue__Group_1_1_1_1__1__Impl"
    // InternalBasicsParser.g:7962:1: rule__ExtensionListValue__Group_1_1_1_1__1__Impl : ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1 ) ) ;
    public final void rule__ExtensionListValue__Group_1_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7966:1: ( ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1 ) ) )
            // InternalBasicsParser.g:7967:1: ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1 ) )
            {
            // InternalBasicsParser.g:7967:1: ( ( rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1 ) )
            // InternalBasicsParser.g:7968:2: ( rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1 )
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsAssignment_1_1_1_1_1()); 
            // InternalBasicsParser.g:7969:2: ( rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1 )
            // InternalBasicsParser.g:7969:3: rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExtensionListValueAccess().getItemsAssignment_1_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__Group_1_1_1_1__1__Impl"


    // $ANTLR start "rule__ExtensionBraceMapValue__Group__0"
    // InternalBasicsParser.g:7978:1: rule__ExtensionBraceMapValue__Group__0 : rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1 ;
    public final void rule__ExtensionBraceMapValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7982:1: ( rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1 )
            // InternalBasicsParser.g:7983:2: rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1
            {
            pushFollow(FOLLOW_74);
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
    // InternalBasicsParser.g:7990:1: rule__ExtensionBraceMapValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionBraceMapValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7994:1: ( ( () ) )
            // InternalBasicsParser.g:7995:1: ( () )
            {
            // InternalBasicsParser.g:7995:1: ( () )
            // InternalBasicsParser.g:7996:2: ()
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0()); 
            // InternalBasicsParser.g:7997:2: ()
            // InternalBasicsParser.g:7997:3: 
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
    // InternalBasicsParser.g:8005:1: rule__ExtensionBraceMapValue__Group__1 : rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2 ;
    public final void rule__ExtensionBraceMapValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8009:1: ( rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2 )
            // InternalBasicsParser.g:8010:2: rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2
            {
            pushFollow(FOLLOW_75);
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
    // InternalBasicsParser.g:8017:1: rule__ExtensionBraceMapValue__Group__1__Impl : ( LeftCurlyBracket ) ;
    public final void rule__ExtensionBraceMapValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8021:1: ( ( LeftCurlyBracket ) )
            // InternalBasicsParser.g:8022:1: ( LeftCurlyBracket )
            {
            // InternalBasicsParser.g:8022:1: ( LeftCurlyBracket )
            // InternalBasicsParser.g:8023:2: LeftCurlyBracket
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
    // InternalBasicsParser.g:8032:1: rule__ExtensionBraceMapValue__Group__2 : rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3 ;
    public final void rule__ExtensionBraceMapValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8036:1: ( rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3 )
            // InternalBasicsParser.g:8037:2: rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3
            {
            pushFollow(FOLLOW_75);
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
    // InternalBasicsParser.g:8044:1: rule__ExtensionBraceMapValue__Group__2__Impl : ( ( rule__ExtensionBraceMapValue__Group_2__0 )? ) ;
    public final void rule__ExtensionBraceMapValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8048:1: ( ( ( rule__ExtensionBraceMapValue__Group_2__0 )? ) )
            // InternalBasicsParser.g:8049:1: ( ( rule__ExtensionBraceMapValue__Group_2__0 )? )
            {
            // InternalBasicsParser.g:8049:1: ( ( rule__ExtensionBraceMapValue__Group_2__0 )? )
            // InternalBasicsParser.g:8050:2: ( rule__ExtensionBraceMapValue__Group_2__0 )?
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2()); 
            // InternalBasicsParser.g:8051:2: ( rule__ExtensionBraceMapValue__Group_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=Pluginbases && LA38_0<=Parameter)||(LA38_0>=Multiple && LA38_0<=Plugins)||(LA38_0>=Boolean && LA38_0<=Header_1)||(LA38_0>=Loader && LA38_0<=Message)||LA38_0==Service||(LA38_0>=Base64 && LA38_0<=Action)||LA38_0==Class||(LA38_0>=Result && LA38_0<=Int64)||(LA38_0>=Type_1 && LA38_0<=List)||(LA38_0>=Bool && LA38_0<=Node)||(LA38_0>=Time && LA38_0<=Ns)||(LA38_0>=RULE_ID && LA38_0<=RULE_STRING)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBasicsParser.g:8051:3: rule__ExtensionBraceMapValue__Group_2__0
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
    // InternalBasicsParser.g:8059:1: rule__ExtensionBraceMapValue__Group__3 : rule__ExtensionBraceMapValue__Group__3__Impl ;
    public final void rule__ExtensionBraceMapValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8063:1: ( rule__ExtensionBraceMapValue__Group__3__Impl )
            // InternalBasicsParser.g:8064:2: rule__ExtensionBraceMapValue__Group__3__Impl
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
    // InternalBasicsParser.g:8070:1: rule__ExtensionBraceMapValue__Group__3__Impl : ( RightCurlyBracket ) ;
    public final void rule__ExtensionBraceMapValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8074:1: ( ( RightCurlyBracket ) )
            // InternalBasicsParser.g:8075:1: ( RightCurlyBracket )
            {
            // InternalBasicsParser.g:8075:1: ( RightCurlyBracket )
            // InternalBasicsParser.g:8076:2: RightCurlyBracket
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
    // InternalBasicsParser.g:8086:1: rule__ExtensionBraceMapValue__Group_2__0 : rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1 ;
    public final void rule__ExtensionBraceMapValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8090:1: ( rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1 )
            // InternalBasicsParser.g:8091:2: rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1
            {
            pushFollow(FOLLOW_76);
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
    // InternalBasicsParser.g:8098:1: rule__ExtensionBraceMapValue__Group_2__0__Impl : ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) ) ;
    public final void rule__ExtensionBraceMapValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8102:1: ( ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) ) )
            // InternalBasicsParser.g:8103:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) )
            {
            // InternalBasicsParser.g:8103:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) )
            // InternalBasicsParser.g:8104:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_0()); 
            // InternalBasicsParser.g:8105:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 )
            // InternalBasicsParser.g:8105:3: rule__ExtensionBraceMapValue__EntriesAssignment_2_0
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
    // InternalBasicsParser.g:8113:1: rule__ExtensionBraceMapValue__Group_2__1 : rule__ExtensionBraceMapValue__Group_2__1__Impl ;
    public final void rule__ExtensionBraceMapValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8117:1: ( rule__ExtensionBraceMapValue__Group_2__1__Impl )
            // InternalBasicsParser.g:8118:2: rule__ExtensionBraceMapValue__Group_2__1__Impl
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
    // InternalBasicsParser.g:8124:1: rule__ExtensionBraceMapValue__Group_2__1__Impl : ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* ) ;
    public final void rule__ExtensionBraceMapValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8128:1: ( ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* ) )
            // InternalBasicsParser.g:8129:1: ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* )
            {
            // InternalBasicsParser.g:8129:1: ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* )
            // InternalBasicsParser.g:8130:2: ( rule__ExtensionBraceMapValue__Group_2_1__0 )*
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2_1()); 
            // InternalBasicsParser.g:8131:2: ( rule__ExtensionBraceMapValue__Group_2_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=Pluginbases && LA39_0<=Parameter)||(LA39_0>=Multiple && LA39_0<=Plugins)||(LA39_0>=Boolean && LA39_0<=Header_1)||(LA39_0>=Loader && LA39_0<=Message)||LA39_0==Service||(LA39_0>=Base64 && LA39_0<=Action)||LA39_0==Class||(LA39_0>=Result && LA39_0<=Int64)||(LA39_0>=Type_1 && LA39_0<=List)||(LA39_0>=Bool && LA39_0<=Node)||(LA39_0>=Time && LA39_0<=Ns)||LA39_0==Comma||(LA39_0>=RULE_ID && LA39_0<=RULE_STRING)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalBasicsParser.g:8131:3: rule__ExtensionBraceMapValue__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_77);
            	    rule__ExtensionBraceMapValue__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalBasicsParser.g:8140:1: rule__ExtensionBraceMapValue__Group_2_1__0 : rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1 ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8144:1: ( rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1 )
            // InternalBasicsParser.g:8145:2: rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1
            {
            pushFollow(FOLLOW_76);
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
    // InternalBasicsParser.g:8152:1: rule__ExtensionBraceMapValue__Group_2_1__0__Impl : ( ( Comma )? ) ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8156:1: ( ( ( Comma )? ) )
            // InternalBasicsParser.g:8157:1: ( ( Comma )? )
            {
            // InternalBasicsParser.g:8157:1: ( ( Comma )? )
            // InternalBasicsParser.g:8158:2: ( Comma )?
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0()); 
            // InternalBasicsParser.g:8159:2: ( Comma )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Comma) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBasicsParser.g:8159:3: Comma
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
    // InternalBasicsParser.g:8167:1: rule__ExtensionBraceMapValue__Group_2_1__1 : rule__ExtensionBraceMapValue__Group_2_1__1__Impl ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8171:1: ( rule__ExtensionBraceMapValue__Group_2_1__1__Impl )
            // InternalBasicsParser.g:8172:2: rule__ExtensionBraceMapValue__Group_2_1__1__Impl
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
    // InternalBasicsParser.g:8178:1: rule__ExtensionBraceMapValue__Group_2_1__1__Impl : ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) ) ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8182:1: ( ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) ) )
            // InternalBasicsParser.g:8183:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) )
            {
            // InternalBasicsParser.g:8183:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) )
            // InternalBasicsParser.g:8184:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_1_1()); 
            // InternalBasicsParser.g:8185:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 )
            // InternalBasicsParser.g:8185:3: rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1
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
    // InternalBasicsParser.g:8194:1: rule__ExtensionIndentedMapValue__Group__0 : rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1 ;
    public final void rule__ExtensionIndentedMapValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8198:1: ( rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1 )
            // InternalBasicsParser.g:8199:2: rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1
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
    // InternalBasicsParser.g:8206:1: rule__ExtensionIndentedMapValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionIndentedMapValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8210:1: ( ( () ) )
            // InternalBasicsParser.g:8211:1: ( () )
            {
            // InternalBasicsParser.g:8211:1: ( () )
            // InternalBasicsParser.g:8212:2: ()
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0()); 
            // InternalBasicsParser.g:8213:2: ()
            // InternalBasicsParser.g:8213:3: 
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
    // InternalBasicsParser.g:8221:1: rule__ExtensionIndentedMapValue__Group__1 : rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2 ;
    public final void rule__ExtensionIndentedMapValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8225:1: ( rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2 )
            // InternalBasicsParser.g:8226:2: rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2
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
    // InternalBasicsParser.g:8233:1: rule__ExtensionIndentedMapValue__Group__1__Impl : ( RULE_BEGIN ) ;
    public final void rule__ExtensionIndentedMapValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8237:1: ( ( RULE_BEGIN ) )
            // InternalBasicsParser.g:8238:1: ( RULE_BEGIN )
            {
            // InternalBasicsParser.g:8238:1: ( RULE_BEGIN )
            // InternalBasicsParser.g:8239:2: RULE_BEGIN
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
    // InternalBasicsParser.g:8248:1: rule__ExtensionIndentedMapValue__Group__2 : rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3 ;
    public final void rule__ExtensionIndentedMapValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8252:1: ( rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3 )
            // InternalBasicsParser.g:8253:2: rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3
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
    // InternalBasicsParser.g:8260:1: rule__ExtensionIndentedMapValue__Group__2__Impl : ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) ) ;
    public final void rule__ExtensionIndentedMapValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8264:1: ( ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) ) )
            // InternalBasicsParser.g:8265:1: ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) )
            {
            // InternalBasicsParser.g:8265:1: ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) )
            // InternalBasicsParser.g:8266:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* )
            {
            // InternalBasicsParser.g:8266:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) )
            // InternalBasicsParser.g:8267:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 
            // InternalBasicsParser.g:8268:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )
            // InternalBasicsParser.g:8268:4: rule__ExtensionIndentedMapValue__EntriesAssignment_2
            {
            pushFollow(FOLLOW_78);
            rule__ExtensionIndentedMapValue__EntriesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 

            }

            // InternalBasicsParser.g:8271:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* )
            // InternalBasicsParser.g:8272:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )*
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 
            // InternalBasicsParser.g:8273:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=Pluginbases && LA41_0<=Parameter)||(LA41_0>=Multiple && LA41_0<=Plugins)||(LA41_0>=Boolean && LA41_0<=Header_1)||(LA41_0>=Loader && LA41_0<=Message)||LA41_0==Service||(LA41_0>=Base64 && LA41_0<=Action)||LA41_0==Class||(LA41_0>=Result && LA41_0<=Int64)||(LA41_0>=Type_1 && LA41_0<=List)||(LA41_0>=Bool && LA41_0<=Node)||(LA41_0>=Time && LA41_0<=Ns)||(LA41_0>=RULE_ID && LA41_0<=RULE_STRING)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBasicsParser.g:8273:4: rule__ExtensionIndentedMapValue__EntriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_78);
            	    rule__ExtensionIndentedMapValue__EntriesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalBasicsParser.g:8282:1: rule__ExtensionIndentedMapValue__Group__3 : rule__ExtensionIndentedMapValue__Group__3__Impl ;
    public final void rule__ExtensionIndentedMapValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8286:1: ( rule__ExtensionIndentedMapValue__Group__3__Impl )
            // InternalBasicsParser.g:8287:2: rule__ExtensionIndentedMapValue__Group__3__Impl
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
    // InternalBasicsParser.g:8293:1: rule__ExtensionIndentedMapValue__Group__3__Impl : ( RULE_END ) ;
    public final void rule__ExtensionIndentedMapValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8297:1: ( ( RULE_END ) )
            // InternalBasicsParser.g:8298:1: ( RULE_END )
            {
            // InternalBasicsParser.g:8298:1: ( RULE_END )
            // InternalBasicsParser.g:8299:2: RULE_END
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
    // InternalBasicsParser.g:8309:1: rule__ExtensionRefValue__Group__0 : rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1 ;
    public final void rule__ExtensionRefValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8313:1: ( rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1 )
            // InternalBasicsParser.g:8314:2: rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1
            {
            pushFollow(FOLLOW_79);
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
    // InternalBasicsParser.g:8321:1: rule__ExtensionRefValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionRefValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8325:1: ( ( () ) )
            // InternalBasicsParser.g:8326:1: ( () )
            {
            // InternalBasicsParser.g:8326:1: ( () )
            // InternalBasicsParser.g:8327:2: ()
            {
             before(grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0()); 
            // InternalBasicsParser.g:8328:2: ()
            // InternalBasicsParser.g:8328:3: 
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
    // InternalBasicsParser.g:8336:1: rule__ExtensionRefValue__Group__1 : rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2 ;
    public final void rule__ExtensionRefValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8340:1: ( rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2 )
            // InternalBasicsParser.g:8341:2: rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2
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
    // InternalBasicsParser.g:8348:1: rule__ExtensionRefValue__Group__1__Impl : ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) ) ;
    public final void rule__ExtensionRefValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8352:1: ( ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) ) )
            // InternalBasicsParser.g:8353:1: ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) )
            {
            // InternalBasicsParser.g:8353:1: ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) )
            // InternalBasicsParser.g:8354:2: ( rule__ExtensionRefValue__RefKindAssignment_1 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getRefKindAssignment_1()); 
            // InternalBasicsParser.g:8355:2: ( rule__ExtensionRefValue__RefKindAssignment_1 )
            // InternalBasicsParser.g:8355:3: rule__ExtensionRefValue__RefKindAssignment_1
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
    // InternalBasicsParser.g:8363:1: rule__ExtensionRefValue__Group__2 : rule__ExtensionRefValue__Group__2__Impl ;
    public final void rule__ExtensionRefValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8367:1: ( rule__ExtensionRefValue__Group__2__Impl )
            // InternalBasicsParser.g:8368:2: rule__ExtensionRefValue__Group__2__Impl
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
    // InternalBasicsParser.g:8374:1: rule__ExtensionRefValue__Group__2__Impl : ( ( rule__ExtensionRefValue__TargetAssignment_2 ) ) ;
    public final void rule__ExtensionRefValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8378:1: ( ( ( rule__ExtensionRefValue__TargetAssignment_2 ) ) )
            // InternalBasicsParser.g:8379:1: ( ( rule__ExtensionRefValue__TargetAssignment_2 ) )
            {
            // InternalBasicsParser.g:8379:1: ( ( rule__ExtensionRefValue__TargetAssignment_2 ) )
            // InternalBasicsParser.g:8380:2: ( rule__ExtensionRefValue__TargetAssignment_2 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getTargetAssignment_2()); 
            // InternalBasicsParser.g:8381:2: ( rule__ExtensionRefValue__TargetAssignment_2 )
            // InternalBasicsParser.g:8381:3: rule__ExtensionRefValue__TargetAssignment_2
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
    // InternalBasicsParser.g:8390:1: rule__ExtensionScalarValue__Group__0 : rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1 ;
    public final void rule__ExtensionScalarValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8394:1: ( rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1 )
            // InternalBasicsParser.g:8395:2: rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1
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
    // InternalBasicsParser.g:8402:1: rule__ExtensionScalarValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionScalarValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8406:1: ( ( () ) )
            // InternalBasicsParser.g:8407:1: ( () )
            {
            // InternalBasicsParser.g:8407:1: ( () )
            // InternalBasicsParser.g:8408:2: ()
            {
             before(grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0()); 
            // InternalBasicsParser.g:8409:2: ()
            // InternalBasicsParser.g:8409:3: 
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
    // InternalBasicsParser.g:8417:1: rule__ExtensionScalarValue__Group__1 : rule__ExtensionScalarValue__Group__1__Impl ;
    public final void rule__ExtensionScalarValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8421:1: ( rule__ExtensionScalarValue__Group__1__Impl )
            // InternalBasicsParser.g:8422:2: rule__ExtensionScalarValue__Group__1__Impl
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
    // InternalBasicsParser.g:8428:1: rule__ExtensionScalarValue__Group__1__Impl : ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) ) ;
    public final void rule__ExtensionScalarValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8432:1: ( ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) ) )
            // InternalBasicsParser.g:8433:1: ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) )
            {
            // InternalBasicsParser.g:8433:1: ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) )
            // InternalBasicsParser.g:8434:2: ( rule__ExtensionScalarValue__ValueAssignment_1 )
            {
             before(grammarAccess.getExtensionScalarValueAccess().getValueAssignment_1()); 
            // InternalBasicsParser.g:8435:2: ( rule__ExtensionScalarValue__ValueAssignment_1 )
            // InternalBasicsParser.g:8435:3: rule__ExtensionScalarValue__ValueAssignment_1
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
    // InternalBasicsParser.g:8444:1: rule__GlobalNamespace__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__GlobalNamespace__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8448:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8449:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8449:2: ( ruleGraphName )
            // InternalBasicsParser.g:8450:3: ruleGraphName
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
    // InternalBasicsParser.g:8459:1: rule__GlobalNamespace__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__GlobalNamespace__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8463:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8464:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8464:2: ( ruleGraphName )
            // InternalBasicsParser.g:8465:3: ruleGraphName
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
    // InternalBasicsParser.g:8474:1: rule__RelativeNamespace_Impl__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__RelativeNamespace_Impl__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8478:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8479:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8479:2: ( ruleGraphName )
            // InternalBasicsParser.g:8480:3: ruleGraphName
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
    // InternalBasicsParser.g:8489:1: rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__RelativeNamespace_Impl__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8493:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8494:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8494:2: ( ruleGraphName )
            // InternalBasicsParser.g:8495:3: ruleGraphName
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
    // InternalBasicsParser.g:8504:1: rule__PrivateNamespace__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__PrivateNamespace__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8508:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8509:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8509:2: ( ruleGraphName )
            // InternalBasicsParser.g:8510:3: ruleGraphName
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
    // InternalBasicsParser.g:8519:1: rule__PrivateNamespace__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__PrivateNamespace__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8523:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:8524:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:8524:2: ( ruleGraphName )
            // InternalBasicsParser.g:8525:3: ruleGraphName
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
    // InternalBasicsParser.g:8534:1: rule__ParameterListType__SequenceAssignment_3 : ( ruleParameterType ) ;
    public final void rule__ParameterListType__SequenceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8538:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8539:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8539:2: ( ruleParameterType )
            // InternalBasicsParser.g:8540:3: ruleParameterType
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
    // InternalBasicsParser.g:8549:1: rule__ParameterListType__SequenceAssignment_4_1 : ( ruleParameterType ) ;
    public final void rule__ParameterListType__SequenceAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8553:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8554:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8554:2: ( ruleParameterType )
            // InternalBasicsParser.g:8555:3: ruleParameterType
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
    // InternalBasicsParser.g:8564:1: rule__ParameterStructType__ParameterstructypetmemberAssignment_3 : ( ruleParameterStructTypeMember ) ;
    public final void rule__ParameterStructType__ParameterstructypetmemberAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8568:1: ( ( ruleParameterStructTypeMember ) )
            // InternalBasicsParser.g:8569:2: ( ruleParameterStructTypeMember )
            {
            // InternalBasicsParser.g:8569:2: ( ruleParameterStructTypeMember )
            // InternalBasicsParser.g:8570:3: ruleParameterStructTypeMember
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
    // InternalBasicsParser.g:8579:1: rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 : ( ruleParameterStructTypeMember ) ;
    public final void rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8583:1: ( ( ruleParameterStructTypeMember ) )
            // InternalBasicsParser.g:8584:2: ( ruleParameterStructTypeMember )
            {
            // InternalBasicsParser.g:8584:2: ( ruleParameterStructTypeMember )
            // InternalBasicsParser.g:8585:3: ruleParameterStructTypeMember
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
    // InternalBasicsParser.g:8594:1: rule__ParameterIntegerType__DefaultAssignment_2_1 : ( ruleParameterInteger ) ;
    public final void rule__ParameterIntegerType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8598:1: ( ( ruleParameterInteger ) )
            // InternalBasicsParser.g:8599:2: ( ruleParameterInteger )
            {
            // InternalBasicsParser.g:8599:2: ( ruleParameterInteger )
            // InternalBasicsParser.g:8600:3: ruleParameterInteger
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
    // InternalBasicsParser.g:8609:1: rule__ParameterStringType__DefaultAssignment_2_1 : ( ruleParameterString ) ;
    public final void rule__ParameterStringType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8613:1: ( ( ruleParameterString ) )
            // InternalBasicsParser.g:8614:2: ( ruleParameterString )
            {
            // InternalBasicsParser.g:8614:2: ( ruleParameterString )
            // InternalBasicsParser.g:8615:3: ruleParameterString
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
    // InternalBasicsParser.g:8624:1: rule__ParameterDoubleType__DefaultAssignment_2_1 : ( ruleParameterDouble ) ;
    public final void rule__ParameterDoubleType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8628:1: ( ( ruleParameterDouble ) )
            // InternalBasicsParser.g:8629:2: ( ruleParameterDouble )
            {
            // InternalBasicsParser.g:8629:2: ( ruleParameterDouble )
            // InternalBasicsParser.g:8630:3: ruleParameterDouble
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
    // InternalBasicsParser.g:8639:1: rule__ParameterBooleanType__DefaultAssignment_2_1 : ( ruleParameterBoolean ) ;
    public final void rule__ParameterBooleanType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8643:1: ( ( ruleParameterBoolean ) )
            // InternalBasicsParser.g:8644:2: ( ruleParameterBoolean )
            {
            // InternalBasicsParser.g:8644:2: ( ruleParameterBoolean )
            // InternalBasicsParser.g:8645:3: ruleParameterBoolean
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
    // InternalBasicsParser.g:8654:1: rule__ParameterBase64Type__DefaultAssignment_2_1 : ( ruleParameterBase64 ) ;
    public final void rule__ParameterBase64Type__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8658:1: ( ( ruleParameterBase64 ) )
            // InternalBasicsParser.g:8659:2: ( ruleParameterBase64 )
            {
            // InternalBasicsParser.g:8659:2: ( ruleParameterBase64 )
            // InternalBasicsParser.g:8660:3: ruleParameterBase64
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
    // InternalBasicsParser.g:8669:1: rule__ParameterArrayType__TypeAssignment_2 : ( ruleParameterType ) ;
    public final void rule__ParameterArrayType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8673:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8674:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8674:2: ( ruleParameterType )
            // InternalBasicsParser.g:8675:3: ruleParameterType
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
    // InternalBasicsParser.g:8684:1: rule__ParameterArrayType__DefaultAssignment_4_1 : ( ruleParameterList ) ;
    public final void rule__ParameterArrayType__DefaultAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8688:1: ( ( ruleParameterList ) )
            // InternalBasicsParser.g:8689:2: ( ruleParameterList )
            {
            // InternalBasicsParser.g:8689:2: ( ruleParameterList )
            // InternalBasicsParser.g:8690:3: ruleParameterList
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
    // InternalBasicsParser.g:8699:1: rule__ParameterList__ValueAssignment_2 : ( ruleParameterValue ) ;
    public final void rule__ParameterList__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8703:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:8704:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:8704:2: ( ruleParameterValue )
            // InternalBasicsParser.g:8705:3: ruleParameterValue
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
    // InternalBasicsParser.g:8714:1: rule__ParameterList__ValueAssignment_3_1 : ( ruleParameterValue ) ;
    public final void rule__ParameterList__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8718:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:8719:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:8719:2: ( ruleParameterValue )
            // InternalBasicsParser.g:8720:3: ruleParameterValue
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
    // InternalBasicsParser.g:8729:1: rule__ParameterAny__ValueAssignment_2_1 : ( ruleEString ) ;
    public final void rule__ParameterAny__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8733:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8734:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8734:2: ( ruleEString )
            // InternalBasicsParser.g:8735:3: ruleEString
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
    // InternalBasicsParser.g:8744:1: rule__ParameterString__ValueAssignment : ( ruleEString ) ;
    public final void rule__ParameterString__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8748:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8749:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8749:2: ( ruleEString )
            // InternalBasicsParser.g:8750:3: ruleEString
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
    // InternalBasicsParser.g:8759:1: rule__ParameterBase64__ValueAssignment : ( ruleBase64Binary ) ;
    public final void rule__ParameterBase64__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8763:1: ( ( ruleBase64Binary ) )
            // InternalBasicsParser.g:8764:2: ( ruleBase64Binary )
            {
            // InternalBasicsParser.g:8764:2: ( ruleBase64Binary )
            // InternalBasicsParser.g:8765:3: ruleBase64Binary
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
    // InternalBasicsParser.g:8774:1: rule__ParameterInteger__ValueAssignment : ( ruleInteger0 ) ;
    public final void rule__ParameterInteger__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8778:1: ( ( ruleInteger0 ) )
            // InternalBasicsParser.g:8779:2: ( ruleInteger0 )
            {
            // InternalBasicsParser.g:8779:2: ( ruleInteger0 )
            // InternalBasicsParser.g:8780:3: ruleInteger0
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
    // InternalBasicsParser.g:8789:1: rule__ParameterDouble__ValueAssignment : ( ruleDouble0 ) ;
    public final void rule__ParameterDouble__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8793:1: ( ( ruleDouble0 ) )
            // InternalBasicsParser.g:8794:2: ( ruleDouble0 )
            {
            // InternalBasicsParser.g:8794:2: ( ruleDouble0 )
            // InternalBasicsParser.g:8795:3: ruleDouble0
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
    // InternalBasicsParser.g:8804:1: rule__ParameterBoolean__ValueAssignment : ( ruleboolean0 ) ;
    public final void rule__ParameterBoolean__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8808:1: ( ( ruleboolean0 ) )
            // InternalBasicsParser.g:8809:2: ( ruleboolean0 )
            {
            // InternalBasicsParser.g:8809:2: ( ruleboolean0 )
            // InternalBasicsParser.g:8810:3: ruleboolean0
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
    // InternalBasicsParser.g:8819:1: rule__ParameterStruct__ValueAssignment_1_2 : ( ruleParameterStructMember ) ;
    public final void rule__ParameterStruct__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8823:1: ( ( ruleParameterStructMember ) )
            // InternalBasicsParser.g:8824:2: ( ruleParameterStructMember )
            {
            // InternalBasicsParser.g:8824:2: ( ruleParameterStructMember )
            // InternalBasicsParser.g:8825:3: ruleParameterStructMember
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
    // InternalBasicsParser.g:8834:1: rule__ParameterDate__ValueAssignment : ( ruleDateTime0 ) ;
    public final void rule__ParameterDate__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8838:1: ( ( ruleDateTime0 ) )
            // InternalBasicsParser.g:8839:2: ( ruleDateTime0 )
            {
            // InternalBasicsParser.g:8839:2: ( ruleDateTime0 )
            // InternalBasicsParser.g:8840:3: ruleDateTime0
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


    // $ANTLR start "rule__ParameterStructMember__NameAssignment_0_0_0"
    // InternalBasicsParser.g:8849:1: rule__ParameterStructMember__NameAssignment_0_0_0 : ( ruleEString ) ;
    public final void rule__ParameterStructMember__NameAssignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8853:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8854:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8854:2: ( ruleEString )
            // InternalBasicsParser.g:8855:3: ruleEString
            {
             before(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__NameAssignment_0_0_0"


    // $ANTLR start "rule__ParameterStructMember__NameAssignment_0_1"
    // InternalBasicsParser.g:8864:1: rule__ParameterStructMember__NameAssignment_0_1 : ( ruleAddedKeywordName ) ;
    public final void rule__ParameterStructMember__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8868:1: ( ( ruleAddedKeywordName ) )
            // InternalBasicsParser.g:8869:2: ( ruleAddedKeywordName )
            {
            // InternalBasicsParser.g:8869:2: ( ruleAddedKeywordName )
            // InternalBasicsParser.g:8870:3: ruleAddedKeywordName
            {
             before(grammarAccess.getParameterStructMemberAccess().getNameAddedKeywordNameParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAddedKeywordName();

            state._fsp--;

             after(grammarAccess.getParameterStructMemberAccess().getNameAddedKeywordNameParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__NameAssignment_0_1"


    // $ANTLR start "rule__ParameterStructMember__ValueAssignment_1"
    // InternalBasicsParser.g:8879:1: rule__ParameterStructMember__ValueAssignment_1 : ( ruleParameterValue ) ;
    public final void rule__ParameterStructMember__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8883:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:8884:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:8884:2: ( ruleParameterValue )
            // InternalBasicsParser.g:8885:3: ruleParameterValue
            {
             before(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameterValue();

            state._fsp--;

             after(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterStructMember__ValueAssignment_1"


    // $ANTLR start "rule__ParameterStructTypeMember__NameAssignment_0"
    // InternalBasicsParser.g:8894:1: rule__ParameterStructTypeMember__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__ParameterStructTypeMember__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8898:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:8899:2: ( ruleEString )
            {
            // InternalBasicsParser.g:8899:2: ( ruleEString )
            // InternalBasicsParser.g:8900:3: ruleEString
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
    // InternalBasicsParser.g:8909:1: rule__ParameterStructTypeMember__TypeAssignment_1 : ( ruleParameterType ) ;
    public final void rule__ParameterStructTypeMember__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8913:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:8914:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:8914:2: ( ruleParameterType )
            // InternalBasicsParser.g:8915:3: ruleParameterType
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
    // InternalBasicsParser.g:8924:1: rule__SpecBaseRef__ReferenceAssignment : ( ( ruleEString ) ) ;
    public final void rule__SpecBaseRef__ReferenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8928:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:8929:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:8929:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:8930:3: ( ruleEString )
            {
             before(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecCrossReference_0()); 
            // InternalBasicsParser.g:8931:3: ( ruleEString )
            // InternalBasicsParser.g:8932:4: ruleEString
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
    // InternalBasicsParser.g:8943:1: rule__ArraySpecRef__ReferenceAssignment_0 : ( ( ruleEString ) ) ;
    public final void rule__ArraySpecRef__ReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8947:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:8948:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:8948:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:8949:3: ( ruleEString )
            {
             before(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0()); 
            // InternalBasicsParser.g:8950:3: ( ruleEString )
            // InternalBasicsParser.g:8951:4: ruleEString
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
    // InternalBasicsParser.g:8962:1: rule__ExtensionEntry__KeyAssignment_1_0_0 : ( ruleExtensionKey ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8966:1: ( ( ruleExtensionKey ) )
            // InternalBasicsParser.g:8967:2: ( ruleExtensionKey )
            {
            // InternalBasicsParser.g:8967:2: ( ruleExtensionKey )
            // InternalBasicsParser.g:8968:3: ruleExtensionKey
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
    // InternalBasicsParser.g:8977:1: rule__ExtensionEntry__KeyAssignment_1_1 : ( ruleExtensionColonKey ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8981:1: ( ( ruleExtensionColonKey ) )
            // InternalBasicsParser.g:8982:2: ( ruleExtensionColonKey )
            {
            // InternalBasicsParser.g:8982:2: ( ruleExtensionColonKey )
            // InternalBasicsParser.g:8983:3: ruleExtensionColonKey
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


    // $ANTLR start "rule__ExtensionEntry__KeyAssignment_1_2"
    // InternalBasicsParser.g:8992:1: rule__ExtensionEntry__KeyAssignment_1_2 : ( ruleAddedKeywordName ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8996:1: ( ( ruleAddedKeywordName ) )
            // InternalBasicsParser.g:8997:2: ( ruleAddedKeywordName )
            {
            // InternalBasicsParser.g:8997:2: ( ruleAddedKeywordName )
            // InternalBasicsParser.g:8998:3: ruleAddedKeywordName
            {
             before(grammarAccess.getExtensionEntryAccess().getKeyAddedKeywordNameParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAddedKeywordName();

            state._fsp--;

             after(grammarAccess.getExtensionEntryAccess().getKeyAddedKeywordNameParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionEntry__KeyAssignment_1_2"


    // $ANTLR start "rule__ExtensionEntry__ValueAssignment_2"
    // InternalBasicsParser.g:9007:1: rule__ExtensionEntry__ValueAssignment_2 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionEntry__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9011:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:9012:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:9012:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:9013:3: ruleExtensionValue
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


    // $ANTLR start "rule__ExtensionListValue__ItemsAssignment_1_1_1_0"
    // InternalBasicsParser.g:9022:1: rule__ExtensionListValue__ItemsAssignment_1_1_1_0 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionListValue__ItemsAssignment_1_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9026:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:9027:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:9027:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:9028:3: ruleExtensionValue
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionValue();

            state._fsp--;

             after(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__ItemsAssignment_1_1_1_0"


    // $ANTLR start "rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1"
    // InternalBasicsParser.g:9037:1: rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9041:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:9042:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:9042:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:9043:3: ruleExtensionValue
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExtensionValue();

            state._fsp--;

             after(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExtensionListValue__ItemsAssignment_1_1_1_1_1"


    // $ANTLR start "rule__ExtensionBraceMapValue__EntriesAssignment_2_0"
    // InternalBasicsParser.g:9052:1: rule__ExtensionBraceMapValue__EntriesAssignment_2_0 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionBraceMapValue__EntriesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9056:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:9057:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:9057:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:9058:3: ruleExtensionEntry
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
    // InternalBasicsParser.g:9067:1: rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9071:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:9072:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:9072:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:9073:3: ruleExtensionEntry
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
    // InternalBasicsParser.g:9082:1: rule__ExtensionIndentedMapValue__EntriesAssignment_2 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionIndentedMapValue__EntriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9086:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:9087:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:9087:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:9088:3: ruleExtensionEntry
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
    // InternalBasicsParser.g:9097:1: rule__ExtensionRefValue__RefKindAssignment_1 : ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) ) ;
    public final void rule__ExtensionRefValue__RefKindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9101:1: ( ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) ) )
            // InternalBasicsParser.g:9102:2: ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) )
            {
            // InternalBasicsParser.g:9102:2: ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) )
            // InternalBasicsParser.g:9103:3: ( rule__ExtensionRefValue__RefKindAlternatives_1_0 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getRefKindAlternatives_1_0()); 
            // InternalBasicsParser.g:9104:3: ( rule__ExtensionRefValue__RefKindAlternatives_1_0 )
            // InternalBasicsParser.g:9104:4: rule__ExtensionRefValue__RefKindAlternatives_1_0
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
    // InternalBasicsParser.g:9112:1: rule__ExtensionRefValue__TargetAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__ExtensionRefValue__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9116:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:9117:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:9117:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:9118:3: ( ruleEString )
            {
             before(grammarAccess.getExtensionRefValueAccess().getTargetEObjectCrossReference_2_0()); 
            // InternalBasicsParser.g:9119:3: ( ruleEString )
            // InternalBasicsParser.g:9120:4: ruleEString
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
    // InternalBasicsParser.g:9131:1: rule__ExtensionScalarValue__ValueAssignment_1 : ( ruleExtensionScalarLiteral ) ;
    public final void rule__ExtensionScalarValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9135:1: ( ( ruleExtensionScalarLiteral ) )
            // InternalBasicsParser.g:9136:2: ( ruleExtensionScalarLiteral )
            {
            // InternalBasicsParser.g:9136:2: ( ruleExtensionScalarLiteral )
            // InternalBasicsParser.g:9137:3: ruleExtensionScalarLiteral
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
    protected DFA5 dfa5 = new DFA5(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\10\2\11\10\uffff";
    static final String dfa_3s = "\3\10\4\uffff\1\126\3\uffff";
    static final String dfa_4s = "\3\152\4\uffff\1\155\3\uffff";
    static final String dfa_5s = "\3\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\6\10\3\uffff\1\10\3\uffff\1\10\10\uffff\2\10\3\uffff\1\10\15\uffff\1\10\2\uffff\1\10\6\uffff\1\10\32\uffff\1\10\3\uffff\1\7\1\10\3\uffff\1\3\1\6\1\4\1\5\6\uffff\1\2\1\1",
            "\6\11\3\uffff\1\11\3\uffff\1\11\10\uffff\2\11\3\uffff\1\11\15\uffff\1\11\2\uffff\1\11\6\uffff\1\11\32\uffff\1\11\1\uffff\1\10\2\uffff\1\11\15\uffff\2\11",
            "\6\11\3\uffff\1\11\3\uffff\1\11\10\uffff\2\11\3\uffff\1\11\15\uffff\1\11\2\uffff\1\11\6\uffff\1\11\32\uffff\1\11\1\uffff\1\10\2\uffff\1\11\15\uffff\2\11",
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
            return "2203:1: rule__ParameterValue__Alternatives : ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) );";
        }
    }
    static final String dfa_8s = "\44\uffff";
    static final String dfa_9s = "\36\uffff\2\42\4\uffff";
    static final String dfa_10s = "\1\17\35\uffff\2\125\4\uffff";
    static final String dfa_11s = "\1\152\35\uffff\2\125\4\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\40\1\41\1\36\1\37";
    static final String dfa_13s = "\44\uffff}>";
    static final String[] dfa_14s = {
            "\1\32\1\33\2\uffff\1\17\2\uffff\1\34\1\25\1\27\1\31\2\uffff\1\12\1\13\2\uffff\1\24\1\26\1\30\4\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\41\1\uffff\1\22\2\uffff\1\14\1\5\1\7\1\11\3\uffff\1\4\1\6\1\10\3\uffff\1\3\5\uffff\1\1\1\15\1\40\1\uffff\1\2\4\uffff\1\16\27\uffff\1\37\1\36",
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
            "\1\43",
            "\1\43",
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

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "2275:1: rule__AbstractType__Alternatives : ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleSpecBaseRef ) | ( ruleArraySpecRef ) | ( rulechar ) | ( rulecharArray ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000008400000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x04001B000C000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000060000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000060784000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x08120008C0223F00L,0x0000060008000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x08120008C0223F02L,0x0000060000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x7FFA3F58FC3E3F00L,0x00000600001E7F3EL});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0xF5E83F703C180000L,0x00002E07142FFFFDL});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000004200000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xF5E83F703C180000L,0x00002E071C2FFFFDL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0xF5E83F703C180000L,0x00002E07146FFFFDL});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0xF5E83F703C180002L,0x00002E07146FFFFDL});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x7FFA3F58FC3E3F00L,0x00000600201E7F3EL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x7FFA3F58FC3E3F00L,0x00000600005E7F3EL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x7FFA3F58FC3E3F02L,0x00000600005E7F3EL});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x7FFA3F58FC3E3F02L,0x00000600001E7F3EL});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x8000002000000000L,0x00000000000180C1L});

}