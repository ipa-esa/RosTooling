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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "ParameterAny", "Pluginbases", "Pluginslots", "Implements", "Active_in", "Lifecycle", "Parameter", "GraphName", "Multiple", "Default", "Duration", "Feedback", "Plugins", "Boolean", "Integer", "Float32", "Float64", "Format", "Header_1", "Loader", "Message", "Param", "Service", "Base64", "Double", "Header", "String", "Struct", "Action", "Class", "Result", "Slots", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Base", "Int16", "Int32", "Int64", "Pub", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LessThanSignEqualsSign", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
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
    		tokenNameToValue.put("LessThanSignEqualsSign", "'<='");
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
    		tokenNameToValue.put("Class", "'class:'");
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
    		tokenNameToValue.put("Loader", "'loader:'");
    		tokenNameToValue.put("Message", "'message'");
    		tokenNameToValue.put("Param", "'param->'");
    		tokenNameToValue.put("Service", "'service'");
    		tokenNameToValue.put("Default", "'default:'");
    		tokenNameToValue.put("Duration", "'duration'");
    		tokenNameToValue.put("Feedback", "'feedback'");
    		tokenNameToValue.put("Plugins", "'plugins:'");
    		tokenNameToValue.put("GraphName", "'GraphName'");
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


    // $ANTLR start "entryRuleArraySize"
    // InternalBasicsParser.g:931:1: entryRuleArraySize : ruleArraySize EOF ;
    public final void entryRuleArraySize() throws RecognitionException {
        try {
            // InternalBasicsParser.g:932:1: ( ruleArraySize EOF )
            // InternalBasicsParser.g:933:1: ruleArraySize EOF
            {
             before(grammarAccess.getArraySizeRule()); 
            pushFollow(FOLLOW_1);
            ruleArraySize();

            state._fsp--;

             after(grammarAccess.getArraySizeRule()); 
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
    // $ANTLR end "entryRuleArraySize"


    // $ANTLR start "ruleArraySize"
    // InternalBasicsParser.g:940:1: ruleArraySize : ( RULE_DECINT ) ;
    public final void ruleArraySize() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:944:2: ( ( RULE_DECINT ) )
            // InternalBasicsParser.g:945:2: ( RULE_DECINT )
            {
            // InternalBasicsParser.g:945:2: ( RULE_DECINT )
            // InternalBasicsParser.g:946:3: RULE_DECINT
            {
             before(grammarAccess.getArraySizeAccess().getDECINTTerminalRuleCall()); 
            match(input,RULE_DECINT,FOLLOW_2); 
             after(grammarAccess.getArraySizeAccess().getDECINTTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArraySize"


    // $ANTLR start "entryRuleScalarType"
    // InternalBasicsParser.g:956:1: entryRuleScalarType : ruleScalarType EOF ;
    public final void entryRuleScalarType() throws RecognitionException {
        try {
            // InternalBasicsParser.g:957:1: ( ruleScalarType EOF )
            // InternalBasicsParser.g:958:1: ruleScalarType EOF
            {
             before(grammarAccess.getScalarTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleScalarType();

            state._fsp--;

             after(grammarAccess.getScalarTypeRule()); 
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
    // $ANTLR end "entryRuleScalarType"


    // $ANTLR start "ruleScalarType"
    // InternalBasicsParser.g:965:1: ruleScalarType : ( ( rule__ScalarType__Alternatives ) ) ;
    public final void ruleScalarType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:969:2: ( ( ( rule__ScalarType__Alternatives ) ) )
            // InternalBasicsParser.g:970:2: ( ( rule__ScalarType__Alternatives ) )
            {
            // InternalBasicsParser.g:970:2: ( ( rule__ScalarType__Alternatives ) )
            // InternalBasicsParser.g:971:3: ( rule__ScalarType__Alternatives )
            {
             before(grammarAccess.getScalarTypeAccess().getAlternatives()); 
            // InternalBasicsParser.g:972:3: ( rule__ScalarType__Alternatives )
            // InternalBasicsParser.g:972:4: rule__ScalarType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ScalarType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getScalarTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleScalarType"


    // $ANTLR start "entryRulebool"
    // InternalBasicsParser.g:981:1: entryRulebool : rulebool EOF ;
    public final void entryRulebool() throws RecognitionException {
        try {
            // InternalBasicsParser.g:982:1: ( rulebool EOF )
            // InternalBasicsParser.g:983:1: rulebool EOF
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
    // InternalBasicsParser.g:990:1: rulebool : ( ( rule__Bool__Group__0 ) ) ;
    public final void rulebool() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:994:2: ( ( ( rule__Bool__Group__0 ) ) )
            // InternalBasicsParser.g:995:2: ( ( rule__Bool__Group__0 ) )
            {
            // InternalBasicsParser.g:995:2: ( ( rule__Bool__Group__0 ) )
            // InternalBasicsParser.g:996:3: ( rule__Bool__Group__0 )
            {
             before(grammarAccess.getBoolAccess().getGroup()); 
            // InternalBasicsParser.g:997:3: ( rule__Bool__Group__0 )
            // InternalBasicsParser.g:997:4: rule__Bool__Group__0
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
    // InternalBasicsParser.g:1006:1: entryRuleint8 : ruleint8 EOF ;
    public final void entryRuleint8() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1007:1: ( ruleint8 EOF )
            // InternalBasicsParser.g:1008:1: ruleint8 EOF
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
    // InternalBasicsParser.g:1015:1: ruleint8 : ( ( rule__Int8__Group__0 ) ) ;
    public final void ruleint8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1019:2: ( ( ( rule__Int8__Group__0 ) ) )
            // InternalBasicsParser.g:1020:2: ( ( rule__Int8__Group__0 ) )
            {
            // InternalBasicsParser.g:1020:2: ( ( rule__Int8__Group__0 ) )
            // InternalBasicsParser.g:1021:3: ( rule__Int8__Group__0 )
            {
             before(grammarAccess.getInt8Access().getGroup()); 
            // InternalBasicsParser.g:1022:3: ( rule__Int8__Group__0 )
            // InternalBasicsParser.g:1022:4: rule__Int8__Group__0
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
    // InternalBasicsParser.g:1031:1: entryRuleuint8 : ruleuint8 EOF ;
    public final void entryRuleuint8() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1032:1: ( ruleuint8 EOF )
            // InternalBasicsParser.g:1033:1: ruleuint8 EOF
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
    // InternalBasicsParser.g:1040:1: ruleuint8 : ( ( rule__Uint8__Group__0 ) ) ;
    public final void ruleuint8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1044:2: ( ( ( rule__Uint8__Group__0 ) ) )
            // InternalBasicsParser.g:1045:2: ( ( rule__Uint8__Group__0 ) )
            {
            // InternalBasicsParser.g:1045:2: ( ( rule__Uint8__Group__0 ) )
            // InternalBasicsParser.g:1046:3: ( rule__Uint8__Group__0 )
            {
             before(grammarAccess.getUint8Access().getGroup()); 
            // InternalBasicsParser.g:1047:3: ( rule__Uint8__Group__0 )
            // InternalBasicsParser.g:1047:4: rule__Uint8__Group__0
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
    // InternalBasicsParser.g:1056:1: entryRuleint16 : ruleint16 EOF ;
    public final void entryRuleint16() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1057:1: ( ruleint16 EOF )
            // InternalBasicsParser.g:1058:1: ruleint16 EOF
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
    // InternalBasicsParser.g:1065:1: ruleint16 : ( ( rule__Int16__Group__0 ) ) ;
    public final void ruleint16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1069:2: ( ( ( rule__Int16__Group__0 ) ) )
            // InternalBasicsParser.g:1070:2: ( ( rule__Int16__Group__0 ) )
            {
            // InternalBasicsParser.g:1070:2: ( ( rule__Int16__Group__0 ) )
            // InternalBasicsParser.g:1071:3: ( rule__Int16__Group__0 )
            {
             before(grammarAccess.getInt16Access().getGroup()); 
            // InternalBasicsParser.g:1072:3: ( rule__Int16__Group__0 )
            // InternalBasicsParser.g:1072:4: rule__Int16__Group__0
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
    // InternalBasicsParser.g:1081:1: entryRuleuint16 : ruleuint16 EOF ;
    public final void entryRuleuint16() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1082:1: ( ruleuint16 EOF )
            // InternalBasicsParser.g:1083:1: ruleuint16 EOF
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
    // InternalBasicsParser.g:1090:1: ruleuint16 : ( ( rule__Uint16__Group__0 ) ) ;
    public final void ruleuint16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1094:2: ( ( ( rule__Uint16__Group__0 ) ) )
            // InternalBasicsParser.g:1095:2: ( ( rule__Uint16__Group__0 ) )
            {
            // InternalBasicsParser.g:1095:2: ( ( rule__Uint16__Group__0 ) )
            // InternalBasicsParser.g:1096:3: ( rule__Uint16__Group__0 )
            {
             before(grammarAccess.getUint16Access().getGroup()); 
            // InternalBasicsParser.g:1097:3: ( rule__Uint16__Group__0 )
            // InternalBasicsParser.g:1097:4: rule__Uint16__Group__0
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
    // InternalBasicsParser.g:1106:1: entryRuleint32 : ruleint32 EOF ;
    public final void entryRuleint32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1107:1: ( ruleint32 EOF )
            // InternalBasicsParser.g:1108:1: ruleint32 EOF
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
    // InternalBasicsParser.g:1115:1: ruleint32 : ( ( rule__Int32__Group__0 ) ) ;
    public final void ruleint32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1119:2: ( ( ( rule__Int32__Group__0 ) ) )
            // InternalBasicsParser.g:1120:2: ( ( rule__Int32__Group__0 ) )
            {
            // InternalBasicsParser.g:1120:2: ( ( rule__Int32__Group__0 ) )
            // InternalBasicsParser.g:1121:3: ( rule__Int32__Group__0 )
            {
             before(grammarAccess.getInt32Access().getGroup()); 
            // InternalBasicsParser.g:1122:3: ( rule__Int32__Group__0 )
            // InternalBasicsParser.g:1122:4: rule__Int32__Group__0
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
    // InternalBasicsParser.g:1131:1: entryRuleuint32 : ruleuint32 EOF ;
    public final void entryRuleuint32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1132:1: ( ruleuint32 EOF )
            // InternalBasicsParser.g:1133:1: ruleuint32 EOF
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
    // InternalBasicsParser.g:1140:1: ruleuint32 : ( ( rule__Uint32__Group__0 ) ) ;
    public final void ruleuint32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1144:2: ( ( ( rule__Uint32__Group__0 ) ) )
            // InternalBasicsParser.g:1145:2: ( ( rule__Uint32__Group__0 ) )
            {
            // InternalBasicsParser.g:1145:2: ( ( rule__Uint32__Group__0 ) )
            // InternalBasicsParser.g:1146:3: ( rule__Uint32__Group__0 )
            {
             before(grammarAccess.getUint32Access().getGroup()); 
            // InternalBasicsParser.g:1147:3: ( rule__Uint32__Group__0 )
            // InternalBasicsParser.g:1147:4: rule__Uint32__Group__0
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
    // InternalBasicsParser.g:1156:1: entryRuleint64 : ruleint64 EOF ;
    public final void entryRuleint64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1157:1: ( ruleint64 EOF )
            // InternalBasicsParser.g:1158:1: ruleint64 EOF
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
    // InternalBasicsParser.g:1165:1: ruleint64 : ( ( rule__Int64__Group__0 ) ) ;
    public final void ruleint64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1169:2: ( ( ( rule__Int64__Group__0 ) ) )
            // InternalBasicsParser.g:1170:2: ( ( rule__Int64__Group__0 ) )
            {
            // InternalBasicsParser.g:1170:2: ( ( rule__Int64__Group__0 ) )
            // InternalBasicsParser.g:1171:3: ( rule__Int64__Group__0 )
            {
             before(grammarAccess.getInt64Access().getGroup()); 
            // InternalBasicsParser.g:1172:3: ( rule__Int64__Group__0 )
            // InternalBasicsParser.g:1172:4: rule__Int64__Group__0
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
    // InternalBasicsParser.g:1181:1: entryRuleuint64 : ruleuint64 EOF ;
    public final void entryRuleuint64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1182:1: ( ruleuint64 EOF )
            // InternalBasicsParser.g:1183:1: ruleuint64 EOF
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
    // InternalBasicsParser.g:1190:1: ruleuint64 : ( ( rule__Uint64__Group__0 ) ) ;
    public final void ruleuint64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1194:2: ( ( ( rule__Uint64__Group__0 ) ) )
            // InternalBasicsParser.g:1195:2: ( ( rule__Uint64__Group__0 ) )
            {
            // InternalBasicsParser.g:1195:2: ( ( rule__Uint64__Group__0 ) )
            // InternalBasicsParser.g:1196:3: ( rule__Uint64__Group__0 )
            {
             before(grammarAccess.getUint64Access().getGroup()); 
            // InternalBasicsParser.g:1197:3: ( rule__Uint64__Group__0 )
            // InternalBasicsParser.g:1197:4: rule__Uint64__Group__0
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
    // InternalBasicsParser.g:1206:1: entryRulefloat32 : rulefloat32 EOF ;
    public final void entryRulefloat32() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1207:1: ( rulefloat32 EOF )
            // InternalBasicsParser.g:1208:1: rulefloat32 EOF
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
    // InternalBasicsParser.g:1215:1: rulefloat32 : ( ( rule__Float32__Group__0 ) ) ;
    public final void rulefloat32() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1219:2: ( ( ( rule__Float32__Group__0 ) ) )
            // InternalBasicsParser.g:1220:2: ( ( rule__Float32__Group__0 ) )
            {
            // InternalBasicsParser.g:1220:2: ( ( rule__Float32__Group__0 ) )
            // InternalBasicsParser.g:1221:3: ( rule__Float32__Group__0 )
            {
             before(grammarAccess.getFloat32Access().getGroup()); 
            // InternalBasicsParser.g:1222:3: ( rule__Float32__Group__0 )
            // InternalBasicsParser.g:1222:4: rule__Float32__Group__0
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
    // InternalBasicsParser.g:1231:1: entryRulefloat64 : rulefloat64 EOF ;
    public final void entryRulefloat64() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1232:1: ( rulefloat64 EOF )
            // InternalBasicsParser.g:1233:1: rulefloat64 EOF
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
    // InternalBasicsParser.g:1240:1: rulefloat64 : ( ( rule__Float64__Group__0 ) ) ;
    public final void rulefloat64() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1244:2: ( ( ( rule__Float64__Group__0 ) ) )
            // InternalBasicsParser.g:1245:2: ( ( rule__Float64__Group__0 ) )
            {
            // InternalBasicsParser.g:1245:2: ( ( rule__Float64__Group__0 ) )
            // InternalBasicsParser.g:1246:3: ( rule__Float64__Group__0 )
            {
             before(grammarAccess.getFloat64Access().getGroup()); 
            // InternalBasicsParser.g:1247:3: ( rule__Float64__Group__0 )
            // InternalBasicsParser.g:1247:4: rule__Float64__Group__0
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
    // InternalBasicsParser.g:1256:1: entryRulestring0 : rulestring0 EOF ;
    public final void entryRulestring0() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1257:1: ( rulestring0 EOF )
            // InternalBasicsParser.g:1258:1: rulestring0 EOF
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
    // InternalBasicsParser.g:1265:1: rulestring0 : ( ( rule__String0__Group__0 ) ) ;
    public final void rulestring0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1269:2: ( ( ( rule__String0__Group__0 ) ) )
            // InternalBasicsParser.g:1270:2: ( ( rule__String0__Group__0 ) )
            {
            // InternalBasicsParser.g:1270:2: ( ( rule__String0__Group__0 ) )
            // InternalBasicsParser.g:1271:3: ( rule__String0__Group__0 )
            {
             before(grammarAccess.getString0Access().getGroup()); 
            // InternalBasicsParser.g:1272:3: ( rule__String0__Group__0 )
            // InternalBasicsParser.g:1272:4: rule__String0__Group__0
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
    // InternalBasicsParser.g:1281:1: entryRulechar : rulechar EOF ;
    public final void entryRulechar() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1282:1: ( rulechar EOF )
            // InternalBasicsParser.g:1283:1: rulechar EOF
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
    // InternalBasicsParser.g:1290:1: rulechar : ( ( rule__Char__Group__0 ) ) ;
    public final void rulechar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1294:2: ( ( ( rule__Char__Group__0 ) ) )
            // InternalBasicsParser.g:1295:2: ( ( rule__Char__Group__0 ) )
            {
            // InternalBasicsParser.g:1295:2: ( ( rule__Char__Group__0 ) )
            // InternalBasicsParser.g:1296:3: ( rule__Char__Group__0 )
            {
             before(grammarAccess.getCharAccess().getGroup()); 
            // InternalBasicsParser.g:1297:3: ( rule__Char__Group__0 )
            // InternalBasicsParser.g:1297:4: rule__Char__Group__0
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
    // InternalBasicsParser.g:1306:1: entryRulebyte : rulebyte EOF ;
    public final void entryRulebyte() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1307:1: ( rulebyte EOF )
            // InternalBasicsParser.g:1308:1: rulebyte EOF
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
    // InternalBasicsParser.g:1315:1: rulebyte : ( ( rule__Byte__Group__0 ) ) ;
    public final void rulebyte() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1319:2: ( ( ( rule__Byte__Group__0 ) ) )
            // InternalBasicsParser.g:1320:2: ( ( rule__Byte__Group__0 ) )
            {
            // InternalBasicsParser.g:1320:2: ( ( rule__Byte__Group__0 ) )
            // InternalBasicsParser.g:1321:3: ( rule__Byte__Group__0 )
            {
             before(grammarAccess.getByteAccess().getGroup()); 
            // InternalBasicsParser.g:1322:3: ( rule__Byte__Group__0 )
            // InternalBasicsParser.g:1322:4: rule__Byte__Group__0
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
    // InternalBasicsParser.g:1331:1: entryRuletime : ruletime EOF ;
    public final void entryRuletime() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1332:1: ( ruletime EOF )
            // InternalBasicsParser.g:1333:1: ruletime EOF
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
    // InternalBasicsParser.g:1340:1: ruletime : ( ( rule__Time__Group__0 ) ) ;
    public final void ruletime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1344:2: ( ( ( rule__Time__Group__0 ) ) )
            // InternalBasicsParser.g:1345:2: ( ( rule__Time__Group__0 ) )
            {
            // InternalBasicsParser.g:1345:2: ( ( rule__Time__Group__0 ) )
            // InternalBasicsParser.g:1346:3: ( rule__Time__Group__0 )
            {
             before(grammarAccess.getTimeAccess().getGroup()); 
            // InternalBasicsParser.g:1347:3: ( rule__Time__Group__0 )
            // InternalBasicsParser.g:1347:4: rule__Time__Group__0
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
    // InternalBasicsParser.g:1356:1: entryRuleduration : ruleduration EOF ;
    public final void entryRuleduration() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1357:1: ( ruleduration EOF )
            // InternalBasicsParser.g:1358:1: ruleduration EOF
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
    // InternalBasicsParser.g:1365:1: ruleduration : ( ( rule__Duration__Group__0 ) ) ;
    public final void ruleduration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1369:2: ( ( ( rule__Duration__Group__0 ) ) )
            // InternalBasicsParser.g:1370:2: ( ( rule__Duration__Group__0 ) )
            {
            // InternalBasicsParser.g:1370:2: ( ( rule__Duration__Group__0 ) )
            // InternalBasicsParser.g:1371:3: ( rule__Duration__Group__0 )
            {
             before(grammarAccess.getDurationAccess().getGroup()); 
            // InternalBasicsParser.g:1372:3: ( rule__Duration__Group__0 )
            // InternalBasicsParser.g:1372:4: rule__Duration__Group__0
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
    // InternalBasicsParser.g:1381:1: entryRuleboolArray : ruleboolArray EOF ;
    public final void entryRuleboolArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1382:1: ( ruleboolArray EOF )
            // InternalBasicsParser.g:1383:1: ruleboolArray EOF
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
    // InternalBasicsParser.g:1390:1: ruleboolArray : ( ( rule__BoolArray__Group__0 ) ) ;
    public final void ruleboolArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1394:2: ( ( ( rule__BoolArray__Group__0 ) ) )
            // InternalBasicsParser.g:1395:2: ( ( rule__BoolArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1395:2: ( ( rule__BoolArray__Group__0 ) )
            // InternalBasicsParser.g:1396:3: ( rule__BoolArray__Group__0 )
            {
             before(grammarAccess.getBoolArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1397:3: ( rule__BoolArray__Group__0 )
            // InternalBasicsParser.g:1397:4: rule__BoolArray__Group__0
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
    // InternalBasicsParser.g:1406:1: entryRuleint8Array : ruleint8Array EOF ;
    public final void entryRuleint8Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1407:1: ( ruleint8Array EOF )
            // InternalBasicsParser.g:1408:1: ruleint8Array EOF
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
    // InternalBasicsParser.g:1415:1: ruleint8Array : ( ( rule__Int8Array__Group__0 ) ) ;
    public final void ruleint8Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1419:2: ( ( ( rule__Int8Array__Group__0 ) ) )
            // InternalBasicsParser.g:1420:2: ( ( rule__Int8Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1420:2: ( ( rule__Int8Array__Group__0 ) )
            // InternalBasicsParser.g:1421:3: ( rule__Int8Array__Group__0 )
            {
             before(grammarAccess.getInt8ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1422:3: ( rule__Int8Array__Group__0 )
            // InternalBasicsParser.g:1422:4: rule__Int8Array__Group__0
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
    // InternalBasicsParser.g:1431:1: entryRuleuint8Array : ruleuint8Array EOF ;
    public final void entryRuleuint8Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1432:1: ( ruleuint8Array EOF )
            // InternalBasicsParser.g:1433:1: ruleuint8Array EOF
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
    // InternalBasicsParser.g:1440:1: ruleuint8Array : ( ( rule__Uint8Array__Group__0 ) ) ;
    public final void ruleuint8Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1444:2: ( ( ( rule__Uint8Array__Group__0 ) ) )
            // InternalBasicsParser.g:1445:2: ( ( rule__Uint8Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1445:2: ( ( rule__Uint8Array__Group__0 ) )
            // InternalBasicsParser.g:1446:3: ( rule__Uint8Array__Group__0 )
            {
             before(grammarAccess.getUint8ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1447:3: ( rule__Uint8Array__Group__0 )
            // InternalBasicsParser.g:1447:4: rule__Uint8Array__Group__0
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
    // InternalBasicsParser.g:1456:1: entryRuleint16Array : ruleint16Array EOF ;
    public final void entryRuleint16Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1457:1: ( ruleint16Array EOF )
            // InternalBasicsParser.g:1458:1: ruleint16Array EOF
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
    // InternalBasicsParser.g:1465:1: ruleint16Array : ( ( rule__Int16Array__Group__0 ) ) ;
    public final void ruleint16Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1469:2: ( ( ( rule__Int16Array__Group__0 ) ) )
            // InternalBasicsParser.g:1470:2: ( ( rule__Int16Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1470:2: ( ( rule__Int16Array__Group__0 ) )
            // InternalBasicsParser.g:1471:3: ( rule__Int16Array__Group__0 )
            {
             before(grammarAccess.getInt16ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1472:3: ( rule__Int16Array__Group__0 )
            // InternalBasicsParser.g:1472:4: rule__Int16Array__Group__0
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
    // InternalBasicsParser.g:1481:1: entryRuleuint16Array : ruleuint16Array EOF ;
    public final void entryRuleuint16Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1482:1: ( ruleuint16Array EOF )
            // InternalBasicsParser.g:1483:1: ruleuint16Array EOF
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
    // InternalBasicsParser.g:1490:1: ruleuint16Array : ( ( rule__Uint16Array__Group__0 ) ) ;
    public final void ruleuint16Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1494:2: ( ( ( rule__Uint16Array__Group__0 ) ) )
            // InternalBasicsParser.g:1495:2: ( ( rule__Uint16Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1495:2: ( ( rule__Uint16Array__Group__0 ) )
            // InternalBasicsParser.g:1496:3: ( rule__Uint16Array__Group__0 )
            {
             before(grammarAccess.getUint16ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1497:3: ( rule__Uint16Array__Group__0 )
            // InternalBasicsParser.g:1497:4: rule__Uint16Array__Group__0
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
    // InternalBasicsParser.g:1506:1: entryRuleint32Array : ruleint32Array EOF ;
    public final void entryRuleint32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1507:1: ( ruleint32Array EOF )
            // InternalBasicsParser.g:1508:1: ruleint32Array EOF
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
    // InternalBasicsParser.g:1515:1: ruleint32Array : ( ( rule__Int32Array__Group__0 ) ) ;
    public final void ruleint32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1519:2: ( ( ( rule__Int32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1520:2: ( ( rule__Int32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1520:2: ( ( rule__Int32Array__Group__0 ) )
            // InternalBasicsParser.g:1521:3: ( rule__Int32Array__Group__0 )
            {
             before(grammarAccess.getInt32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1522:3: ( rule__Int32Array__Group__0 )
            // InternalBasicsParser.g:1522:4: rule__Int32Array__Group__0
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
    // InternalBasicsParser.g:1531:1: entryRuleuint32Array : ruleuint32Array EOF ;
    public final void entryRuleuint32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1532:1: ( ruleuint32Array EOF )
            // InternalBasicsParser.g:1533:1: ruleuint32Array EOF
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
    // InternalBasicsParser.g:1540:1: ruleuint32Array : ( ( rule__Uint32Array__Group__0 ) ) ;
    public final void ruleuint32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1544:2: ( ( ( rule__Uint32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1545:2: ( ( rule__Uint32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1545:2: ( ( rule__Uint32Array__Group__0 ) )
            // InternalBasicsParser.g:1546:3: ( rule__Uint32Array__Group__0 )
            {
             before(grammarAccess.getUint32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1547:3: ( rule__Uint32Array__Group__0 )
            // InternalBasicsParser.g:1547:4: rule__Uint32Array__Group__0
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
    // InternalBasicsParser.g:1556:1: entryRuleint64Array : ruleint64Array EOF ;
    public final void entryRuleint64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1557:1: ( ruleint64Array EOF )
            // InternalBasicsParser.g:1558:1: ruleint64Array EOF
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
    // InternalBasicsParser.g:1565:1: ruleint64Array : ( ( rule__Int64Array__Group__0 ) ) ;
    public final void ruleint64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1569:2: ( ( ( rule__Int64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1570:2: ( ( rule__Int64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1570:2: ( ( rule__Int64Array__Group__0 ) )
            // InternalBasicsParser.g:1571:3: ( rule__Int64Array__Group__0 )
            {
             before(grammarAccess.getInt64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1572:3: ( rule__Int64Array__Group__0 )
            // InternalBasicsParser.g:1572:4: rule__Int64Array__Group__0
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
    // InternalBasicsParser.g:1581:1: entryRuleuint64Array : ruleuint64Array EOF ;
    public final void entryRuleuint64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1582:1: ( ruleuint64Array EOF )
            // InternalBasicsParser.g:1583:1: ruleuint64Array EOF
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
    // InternalBasicsParser.g:1590:1: ruleuint64Array : ( ( rule__Uint64Array__Group__0 ) ) ;
    public final void ruleuint64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1594:2: ( ( ( rule__Uint64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1595:2: ( ( rule__Uint64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1595:2: ( ( rule__Uint64Array__Group__0 ) )
            // InternalBasicsParser.g:1596:3: ( rule__Uint64Array__Group__0 )
            {
             before(grammarAccess.getUint64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1597:3: ( rule__Uint64Array__Group__0 )
            // InternalBasicsParser.g:1597:4: rule__Uint64Array__Group__0
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
    // InternalBasicsParser.g:1606:1: entryRulefloat32Array : rulefloat32Array EOF ;
    public final void entryRulefloat32Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1607:1: ( rulefloat32Array EOF )
            // InternalBasicsParser.g:1608:1: rulefloat32Array EOF
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
    // InternalBasicsParser.g:1615:1: rulefloat32Array : ( ( rule__Float32Array__Group__0 ) ) ;
    public final void rulefloat32Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1619:2: ( ( ( rule__Float32Array__Group__0 ) ) )
            // InternalBasicsParser.g:1620:2: ( ( rule__Float32Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1620:2: ( ( rule__Float32Array__Group__0 ) )
            // InternalBasicsParser.g:1621:3: ( rule__Float32Array__Group__0 )
            {
             before(grammarAccess.getFloat32ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1622:3: ( rule__Float32Array__Group__0 )
            // InternalBasicsParser.g:1622:4: rule__Float32Array__Group__0
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
    // InternalBasicsParser.g:1631:1: entryRulefloat64Array : rulefloat64Array EOF ;
    public final void entryRulefloat64Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1632:1: ( rulefloat64Array EOF )
            // InternalBasicsParser.g:1633:1: rulefloat64Array EOF
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
    // InternalBasicsParser.g:1640:1: rulefloat64Array : ( ( rule__Float64Array__Group__0 ) ) ;
    public final void rulefloat64Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1644:2: ( ( ( rule__Float64Array__Group__0 ) ) )
            // InternalBasicsParser.g:1645:2: ( ( rule__Float64Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1645:2: ( ( rule__Float64Array__Group__0 ) )
            // InternalBasicsParser.g:1646:3: ( rule__Float64Array__Group__0 )
            {
             before(grammarAccess.getFloat64ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1647:3: ( rule__Float64Array__Group__0 )
            // InternalBasicsParser.g:1647:4: rule__Float64Array__Group__0
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
    // InternalBasicsParser.g:1656:1: entryRulestring0Array : rulestring0Array EOF ;
    public final void entryRulestring0Array() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1657:1: ( rulestring0Array EOF )
            // InternalBasicsParser.g:1658:1: rulestring0Array EOF
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
    // InternalBasicsParser.g:1665:1: rulestring0Array : ( ( rule__String0Array__Group__0 ) ) ;
    public final void rulestring0Array() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1669:2: ( ( ( rule__String0Array__Group__0 ) ) )
            // InternalBasicsParser.g:1670:2: ( ( rule__String0Array__Group__0 ) )
            {
            // InternalBasicsParser.g:1670:2: ( ( rule__String0Array__Group__0 ) )
            // InternalBasicsParser.g:1671:3: ( rule__String0Array__Group__0 )
            {
             before(grammarAccess.getString0ArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1672:3: ( rule__String0Array__Group__0 )
            // InternalBasicsParser.g:1672:4: rule__String0Array__Group__0
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
    // InternalBasicsParser.g:1681:1: entryRulebyteArray : rulebyteArray EOF ;
    public final void entryRulebyteArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1682:1: ( rulebyteArray EOF )
            // InternalBasicsParser.g:1683:1: rulebyteArray EOF
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
    // InternalBasicsParser.g:1690:1: rulebyteArray : ( ( rule__ByteArray__Group__0 ) ) ;
    public final void rulebyteArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1694:2: ( ( ( rule__ByteArray__Group__0 ) ) )
            // InternalBasicsParser.g:1695:2: ( ( rule__ByteArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1695:2: ( ( rule__ByteArray__Group__0 ) )
            // InternalBasicsParser.g:1696:3: ( rule__ByteArray__Group__0 )
            {
             before(grammarAccess.getByteArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1697:3: ( rule__ByteArray__Group__0 )
            // InternalBasicsParser.g:1697:4: rule__ByteArray__Group__0
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
    // InternalBasicsParser.g:1706:1: entryRulecharArray : rulecharArray EOF ;
    public final void entryRulecharArray() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1707:1: ( rulecharArray EOF )
            // InternalBasicsParser.g:1708:1: rulecharArray EOF
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
    // InternalBasicsParser.g:1715:1: rulecharArray : ( ( rule__CharArray__Group__0 ) ) ;
    public final void rulecharArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1719:2: ( ( ( rule__CharArray__Group__0 ) ) )
            // InternalBasicsParser.g:1720:2: ( ( rule__CharArray__Group__0 ) )
            {
            // InternalBasicsParser.g:1720:2: ( ( rule__CharArray__Group__0 ) )
            // InternalBasicsParser.g:1721:3: ( rule__CharArray__Group__0 )
            {
             before(grammarAccess.getCharArrayAccess().getGroup()); 
            // InternalBasicsParser.g:1722:3: ( rule__CharArray__Group__0 )
            // InternalBasicsParser.g:1722:4: rule__CharArray__Group__0
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
    // InternalBasicsParser.g:1731:1: entryRuleHeader : ruleHeader EOF ;
    public final void entryRuleHeader() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1732:1: ( ruleHeader EOF )
            // InternalBasicsParser.g:1733:1: ruleHeader EOF
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
    // InternalBasicsParser.g:1740:1: ruleHeader : ( ( rule__Header__Group__0 ) ) ;
    public final void ruleHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1744:2: ( ( ( rule__Header__Group__0 ) ) )
            // InternalBasicsParser.g:1745:2: ( ( rule__Header__Group__0 ) )
            {
            // InternalBasicsParser.g:1745:2: ( ( rule__Header__Group__0 ) )
            // InternalBasicsParser.g:1746:3: ( rule__Header__Group__0 )
            {
             before(grammarAccess.getHeaderAccess().getGroup()); 
            // InternalBasicsParser.g:1747:3: ( rule__Header__Group__0 )
            // InternalBasicsParser.g:1747:4: rule__Header__Group__0
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
    // InternalBasicsParser.g:1756:1: entryRuleSpecBaseRef : ruleSpecBaseRef EOF ;
    public final void entryRuleSpecBaseRef() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1757:1: ( ruleSpecBaseRef EOF )
            // InternalBasicsParser.g:1758:1: ruleSpecBaseRef EOF
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
    // InternalBasicsParser.g:1765:1: ruleSpecBaseRef : ( ( rule__SpecBaseRef__ReferenceAssignment ) ) ;
    public final void ruleSpecBaseRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1769:2: ( ( ( rule__SpecBaseRef__ReferenceAssignment ) ) )
            // InternalBasicsParser.g:1770:2: ( ( rule__SpecBaseRef__ReferenceAssignment ) )
            {
            // InternalBasicsParser.g:1770:2: ( ( rule__SpecBaseRef__ReferenceAssignment ) )
            // InternalBasicsParser.g:1771:3: ( rule__SpecBaseRef__ReferenceAssignment )
            {
             before(grammarAccess.getSpecBaseRefAccess().getReferenceAssignment()); 
            // InternalBasicsParser.g:1772:3: ( rule__SpecBaseRef__ReferenceAssignment )
            // InternalBasicsParser.g:1772:4: rule__SpecBaseRef__ReferenceAssignment
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
    // InternalBasicsParser.g:1781:1: entryRuleArraySpecRef : ruleArraySpecRef EOF ;
    public final void entryRuleArraySpecRef() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1782:1: ( ruleArraySpecRef EOF )
            // InternalBasicsParser.g:1783:1: ruleArraySpecRef EOF
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
    // InternalBasicsParser.g:1790:1: ruleArraySpecRef : ( ( rule__ArraySpecRef__Group__0 ) ) ;
    public final void ruleArraySpecRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1794:2: ( ( ( rule__ArraySpecRef__Group__0 ) ) )
            // InternalBasicsParser.g:1795:2: ( ( rule__ArraySpecRef__Group__0 ) )
            {
            // InternalBasicsParser.g:1795:2: ( ( rule__ArraySpecRef__Group__0 ) )
            // InternalBasicsParser.g:1796:3: ( rule__ArraySpecRef__Group__0 )
            {
             before(grammarAccess.getArraySpecRefAccess().getGroup()); 
            // InternalBasicsParser.g:1797:3: ( rule__ArraySpecRef__Group__0 )
            // InternalBasicsParser.g:1797:4: rule__ArraySpecRef__Group__0
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
    // InternalBasicsParser.g:1806:1: entryRuleKEYWORD : ruleKEYWORD EOF ;
    public final void entryRuleKEYWORD() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1807:1: ( ruleKEYWORD EOF )
            // InternalBasicsParser.g:1808:1: ruleKEYWORD EOF
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
    // InternalBasicsParser.g:1815:1: ruleKEYWORD : ( ( rule__KEYWORD__Alternatives ) ) ;
    public final void ruleKEYWORD() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1819:2: ( ( ( rule__KEYWORD__Alternatives ) ) )
            // InternalBasicsParser.g:1820:2: ( ( rule__KEYWORD__Alternatives ) )
            {
            // InternalBasicsParser.g:1820:2: ( ( rule__KEYWORD__Alternatives ) )
            // InternalBasicsParser.g:1821:3: ( rule__KEYWORD__Alternatives )
            {
             before(grammarAccess.getKEYWORDAccess().getAlternatives()); 
            // InternalBasicsParser.g:1822:3: ( rule__KEYWORD__Alternatives )
            // InternalBasicsParser.g:1822:4: rule__KEYWORD__Alternatives
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
    // InternalBasicsParser.g:1831:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1832:1: ( ruleEString EOF )
            // InternalBasicsParser.g:1833:1: ruleEString EOF
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
    // InternalBasicsParser.g:1840:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1844:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalBasicsParser.g:1845:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalBasicsParser.g:1845:2: ( ( rule__EString__Alternatives ) )
            // InternalBasicsParser.g:1846:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalBasicsParser.g:1847:3: ( rule__EString__Alternatives )
            // InternalBasicsParser.g:1847:4: rule__EString__Alternatives
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
    // InternalBasicsParser.g:1856:1: entryRuleAddedKeywordName : ruleAddedKeywordName EOF ;
    public final void entryRuleAddedKeywordName() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1857:1: ( ruleAddedKeywordName EOF )
            // InternalBasicsParser.g:1858:1: ruleAddedKeywordName EOF
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
    // InternalBasicsParser.g:1865:1: ruleAddedKeywordName : ( ( rule__AddedKeywordName__Alternatives ) ) ;
    public final void ruleAddedKeywordName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1869:2: ( ( ( rule__AddedKeywordName__Alternatives ) ) )
            // InternalBasicsParser.g:1870:2: ( ( rule__AddedKeywordName__Alternatives ) )
            {
            // InternalBasicsParser.g:1870:2: ( ( rule__AddedKeywordName__Alternatives ) )
            // InternalBasicsParser.g:1871:3: ( rule__AddedKeywordName__Alternatives )
            {
             before(grammarAccess.getAddedKeywordNameAccess().getAlternatives()); 
            // InternalBasicsParser.g:1872:3: ( rule__AddedKeywordName__Alternatives )
            // InternalBasicsParser.g:1872:4: rule__AddedKeywordName__Alternatives
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
    // InternalBasicsParser.g:1881:1: entryRuleExtensionBlockName : ruleExtensionBlockName EOF ;
    public final void entryRuleExtensionBlockName() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1882:1: ( ruleExtensionBlockName EOF )
            // InternalBasicsParser.g:1883:1: ruleExtensionBlockName EOF
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
    // InternalBasicsParser.g:1890:1: ruleExtensionBlockName : ( ( rule__ExtensionBlockName__Group__0 ) ) ;
    public final void ruleExtensionBlockName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1894:2: ( ( ( rule__ExtensionBlockName__Group__0 ) ) )
            // InternalBasicsParser.g:1895:2: ( ( rule__ExtensionBlockName__Group__0 ) )
            {
            // InternalBasicsParser.g:1895:2: ( ( rule__ExtensionBlockName__Group__0 ) )
            // InternalBasicsParser.g:1896:3: ( rule__ExtensionBlockName__Group__0 )
            {
             before(grammarAccess.getExtensionBlockNameAccess().getGroup()); 
            // InternalBasicsParser.g:1897:3: ( rule__ExtensionBlockName__Group__0 )
            // InternalBasicsParser.g:1897:4: rule__ExtensionBlockName__Group__0
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
    // InternalBasicsParser.g:1906:1: entryRuleExtensionEntry : ruleExtensionEntry EOF ;
    public final void entryRuleExtensionEntry() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1907:1: ( ruleExtensionEntry EOF )
            // InternalBasicsParser.g:1908:1: ruleExtensionEntry EOF
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
    // InternalBasicsParser.g:1915:1: ruleExtensionEntry : ( ( rule__ExtensionEntry__Group__0 ) ) ;
    public final void ruleExtensionEntry() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1919:2: ( ( ( rule__ExtensionEntry__Group__0 ) ) )
            // InternalBasicsParser.g:1920:2: ( ( rule__ExtensionEntry__Group__0 ) )
            {
            // InternalBasicsParser.g:1920:2: ( ( rule__ExtensionEntry__Group__0 ) )
            // InternalBasicsParser.g:1921:3: ( rule__ExtensionEntry__Group__0 )
            {
             before(grammarAccess.getExtensionEntryAccess().getGroup()); 
            // InternalBasicsParser.g:1922:3: ( rule__ExtensionEntry__Group__0 )
            // InternalBasicsParser.g:1922:4: rule__ExtensionEntry__Group__0
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
    // InternalBasicsParser.g:1931:1: entryRuleExtensionKey : ruleExtensionKey EOF ;
    public final void entryRuleExtensionKey() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1932:1: ( ruleExtensionKey EOF )
            // InternalBasicsParser.g:1933:1: ruleExtensionKey EOF
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
    // InternalBasicsParser.g:1940:1: ruleExtensionKey : ( ( rule__ExtensionKey__Alternatives ) ) ;
    public final void ruleExtensionKey() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1944:2: ( ( ( rule__ExtensionKey__Alternatives ) ) )
            // InternalBasicsParser.g:1945:2: ( ( rule__ExtensionKey__Alternatives ) )
            {
            // InternalBasicsParser.g:1945:2: ( ( rule__ExtensionKey__Alternatives ) )
            // InternalBasicsParser.g:1946:3: ( rule__ExtensionKey__Alternatives )
            {
             before(grammarAccess.getExtensionKeyAccess().getAlternatives()); 
            // InternalBasicsParser.g:1947:3: ( rule__ExtensionKey__Alternatives )
            // InternalBasicsParser.g:1947:4: rule__ExtensionKey__Alternatives
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
    // InternalBasicsParser.g:1956:1: entryRuleExtensionColonKey : ruleExtensionColonKey EOF ;
    public final void entryRuleExtensionColonKey() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1957:1: ( ruleExtensionColonKey EOF )
            // InternalBasicsParser.g:1958:1: ruleExtensionColonKey EOF
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
    // InternalBasicsParser.g:1965:1: ruleExtensionColonKey : ( ( rule__ExtensionColonKey__Alternatives ) ) ;
    public final void ruleExtensionColonKey() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1969:2: ( ( ( rule__ExtensionColonKey__Alternatives ) ) )
            // InternalBasicsParser.g:1970:2: ( ( rule__ExtensionColonKey__Alternatives ) )
            {
            // InternalBasicsParser.g:1970:2: ( ( rule__ExtensionColonKey__Alternatives ) )
            // InternalBasicsParser.g:1971:3: ( rule__ExtensionColonKey__Alternatives )
            {
             before(grammarAccess.getExtensionColonKeyAccess().getAlternatives()); 
            // InternalBasicsParser.g:1972:3: ( rule__ExtensionColonKey__Alternatives )
            // InternalBasicsParser.g:1972:4: rule__ExtensionColonKey__Alternatives
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
    // InternalBasicsParser.g:1981:1: entryRuleExtensionValue : ruleExtensionValue EOF ;
    public final void entryRuleExtensionValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:1982:1: ( ruleExtensionValue EOF )
            // InternalBasicsParser.g:1983:1: ruleExtensionValue EOF
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
    // InternalBasicsParser.g:1990:1: ruleExtensionValue : ( ( rule__ExtensionValue__Alternatives ) ) ;
    public final void ruleExtensionValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:1994:2: ( ( ( rule__ExtensionValue__Alternatives ) ) )
            // InternalBasicsParser.g:1995:2: ( ( rule__ExtensionValue__Alternatives ) )
            {
            // InternalBasicsParser.g:1995:2: ( ( rule__ExtensionValue__Alternatives ) )
            // InternalBasicsParser.g:1996:3: ( rule__ExtensionValue__Alternatives )
            {
             before(grammarAccess.getExtensionValueAccess().getAlternatives()); 
            // InternalBasicsParser.g:1997:3: ( rule__ExtensionValue__Alternatives )
            // InternalBasicsParser.g:1997:4: rule__ExtensionValue__Alternatives
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
    // InternalBasicsParser.g:2006:1: entryRuleExtensionListValue : ruleExtensionListValue EOF ;
    public final void entryRuleExtensionListValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2007:1: ( ruleExtensionListValue EOF )
            // InternalBasicsParser.g:2008:1: ruleExtensionListValue EOF
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
    // InternalBasicsParser.g:2015:1: ruleExtensionListValue : ( ( rule__ExtensionListValue__Group__0 ) ) ;
    public final void ruleExtensionListValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2019:2: ( ( ( rule__ExtensionListValue__Group__0 ) ) )
            // InternalBasicsParser.g:2020:2: ( ( rule__ExtensionListValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2020:2: ( ( rule__ExtensionListValue__Group__0 ) )
            // InternalBasicsParser.g:2021:3: ( rule__ExtensionListValue__Group__0 )
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup()); 
            // InternalBasicsParser.g:2022:3: ( rule__ExtensionListValue__Group__0 )
            // InternalBasicsParser.g:2022:4: rule__ExtensionListValue__Group__0
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
    // InternalBasicsParser.g:2031:1: entryRuleExtensionBraceMapValue : ruleExtensionBraceMapValue EOF ;
    public final void entryRuleExtensionBraceMapValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2032:1: ( ruleExtensionBraceMapValue EOF )
            // InternalBasicsParser.g:2033:1: ruleExtensionBraceMapValue EOF
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
    // InternalBasicsParser.g:2040:1: ruleExtensionBraceMapValue : ( ( rule__ExtensionBraceMapValue__Group__0 ) ) ;
    public final void ruleExtensionBraceMapValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2044:2: ( ( ( rule__ExtensionBraceMapValue__Group__0 ) ) )
            // InternalBasicsParser.g:2045:2: ( ( rule__ExtensionBraceMapValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2045:2: ( ( rule__ExtensionBraceMapValue__Group__0 ) )
            // InternalBasicsParser.g:2046:3: ( rule__ExtensionBraceMapValue__Group__0 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup()); 
            // InternalBasicsParser.g:2047:3: ( rule__ExtensionBraceMapValue__Group__0 )
            // InternalBasicsParser.g:2047:4: rule__ExtensionBraceMapValue__Group__0
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
    // InternalBasicsParser.g:2056:1: entryRuleExtensionIndentedMapValue : ruleExtensionIndentedMapValue EOF ;
    public final void entryRuleExtensionIndentedMapValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2057:1: ( ruleExtensionIndentedMapValue EOF )
            // InternalBasicsParser.g:2058:1: ruleExtensionIndentedMapValue EOF
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
    // InternalBasicsParser.g:2065:1: ruleExtensionIndentedMapValue : ( ( rule__ExtensionIndentedMapValue__Group__0 ) ) ;
    public final void ruleExtensionIndentedMapValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2069:2: ( ( ( rule__ExtensionIndentedMapValue__Group__0 ) ) )
            // InternalBasicsParser.g:2070:2: ( ( rule__ExtensionIndentedMapValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2070:2: ( ( rule__ExtensionIndentedMapValue__Group__0 ) )
            // InternalBasicsParser.g:2071:3: ( rule__ExtensionIndentedMapValue__Group__0 )
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getGroup()); 
            // InternalBasicsParser.g:2072:3: ( rule__ExtensionIndentedMapValue__Group__0 )
            // InternalBasicsParser.g:2072:4: rule__ExtensionIndentedMapValue__Group__0
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
    // InternalBasicsParser.g:2081:1: entryRuleExtensionRefValue : ruleExtensionRefValue EOF ;
    public final void entryRuleExtensionRefValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2082:1: ( ruleExtensionRefValue EOF )
            // InternalBasicsParser.g:2083:1: ruleExtensionRefValue EOF
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
    // InternalBasicsParser.g:2090:1: ruleExtensionRefValue : ( ( rule__ExtensionRefValue__Group__0 ) ) ;
    public final void ruleExtensionRefValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2094:2: ( ( ( rule__ExtensionRefValue__Group__0 ) ) )
            // InternalBasicsParser.g:2095:2: ( ( rule__ExtensionRefValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2095:2: ( ( rule__ExtensionRefValue__Group__0 ) )
            // InternalBasicsParser.g:2096:3: ( rule__ExtensionRefValue__Group__0 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getGroup()); 
            // InternalBasicsParser.g:2097:3: ( rule__ExtensionRefValue__Group__0 )
            // InternalBasicsParser.g:2097:4: rule__ExtensionRefValue__Group__0
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
    // InternalBasicsParser.g:2106:1: entryRuleExtensionScalarValue : ruleExtensionScalarValue EOF ;
    public final void entryRuleExtensionScalarValue() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2107:1: ( ruleExtensionScalarValue EOF )
            // InternalBasicsParser.g:2108:1: ruleExtensionScalarValue EOF
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
    // InternalBasicsParser.g:2115:1: ruleExtensionScalarValue : ( ( rule__ExtensionScalarValue__Group__0 ) ) ;
    public final void ruleExtensionScalarValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2119:2: ( ( ( rule__ExtensionScalarValue__Group__0 ) ) )
            // InternalBasicsParser.g:2120:2: ( ( rule__ExtensionScalarValue__Group__0 ) )
            {
            // InternalBasicsParser.g:2120:2: ( ( rule__ExtensionScalarValue__Group__0 ) )
            // InternalBasicsParser.g:2121:3: ( rule__ExtensionScalarValue__Group__0 )
            {
             before(grammarAccess.getExtensionScalarValueAccess().getGroup()); 
            // InternalBasicsParser.g:2122:3: ( rule__ExtensionScalarValue__Group__0 )
            // InternalBasicsParser.g:2122:4: rule__ExtensionScalarValue__Group__0
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
    // InternalBasicsParser.g:2131:1: entryRuleExtensionScalarLiteral : ruleExtensionScalarLiteral EOF ;
    public final void entryRuleExtensionScalarLiteral() throws RecognitionException {
        try {
            // InternalBasicsParser.g:2132:1: ( ruleExtensionScalarLiteral EOF )
            // InternalBasicsParser.g:2133:1: ruleExtensionScalarLiteral EOF
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
    // InternalBasicsParser.g:2140:1: ruleExtensionScalarLiteral : ( ( rule__ExtensionScalarLiteral__Alternatives ) ) ;
    public final void ruleExtensionScalarLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2144:2: ( ( ( rule__ExtensionScalarLiteral__Alternatives ) ) )
            // InternalBasicsParser.g:2145:2: ( ( rule__ExtensionScalarLiteral__Alternatives ) )
            {
            // InternalBasicsParser.g:2145:2: ( ( rule__ExtensionScalarLiteral__Alternatives ) )
            // InternalBasicsParser.g:2146:3: ( rule__ExtensionScalarLiteral__Alternatives )
            {
             before(grammarAccess.getExtensionScalarLiteralAccess().getAlternatives()); 
            // InternalBasicsParser.g:2147:3: ( rule__ExtensionScalarLiteral__Alternatives )
            // InternalBasicsParser.g:2147:4: rule__ExtensionScalarLiteral__Alternatives
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
    // InternalBasicsParser.g:2155:1: rule__Namespace__Alternatives : ( ( ruleGlobalNamespace ) | ( ruleRelativeNamespace_Impl ) | ( rulePrivateNamespace ) );
    public final void rule__Namespace__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2159:1: ( ( ruleGlobalNamespace ) | ( ruleRelativeNamespace_Impl ) | ( rulePrivateNamespace ) )
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
                    // InternalBasicsParser.g:2160:2: ( ruleGlobalNamespace )
                    {
                    // InternalBasicsParser.g:2160:2: ( ruleGlobalNamespace )
                    // InternalBasicsParser.g:2161:3: ruleGlobalNamespace
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
                    // InternalBasicsParser.g:2166:2: ( ruleRelativeNamespace_Impl )
                    {
                    // InternalBasicsParser.g:2166:2: ( ruleRelativeNamespace_Impl )
                    // InternalBasicsParser.g:2167:3: ruleRelativeNamespace_Impl
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
                    // InternalBasicsParser.g:2172:2: ( rulePrivateNamespace )
                    {
                    // InternalBasicsParser.g:2172:2: ( rulePrivateNamespace )
                    // InternalBasicsParser.g:2173:3: rulePrivateNamespace
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
    // InternalBasicsParser.g:2182:1: rule__ParameterType__Alternatives : ( ( ruleParameterListType ) | ( ruleParameterStructType ) | ( ruleParameterIntegerType ) | ( ruleParameterStringType ) | ( ruleParameterDoubleType ) | ( ruleParameterBooleanType ) | ( ruleParameterBase64Type ) | ( ruleParameterArrayType ) );
    public final void rule__ParameterType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2186:1: ( ( ruleParameterListType ) | ( ruleParameterStructType ) | ( ruleParameterIntegerType ) | ( ruleParameterStringType ) | ( ruleParameterDoubleType ) | ( ruleParameterBooleanType ) | ( ruleParameterBase64Type ) | ( ruleParameterArrayType ) )
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
                    // InternalBasicsParser.g:2187:2: ( ruleParameterListType )
                    {
                    // InternalBasicsParser.g:2187:2: ( ruleParameterListType )
                    // InternalBasicsParser.g:2188:3: ruleParameterListType
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
                    // InternalBasicsParser.g:2193:2: ( ruleParameterStructType )
                    {
                    // InternalBasicsParser.g:2193:2: ( ruleParameterStructType )
                    // InternalBasicsParser.g:2194:3: ruleParameterStructType
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
                    // InternalBasicsParser.g:2199:2: ( ruleParameterIntegerType )
                    {
                    // InternalBasicsParser.g:2199:2: ( ruleParameterIntegerType )
                    // InternalBasicsParser.g:2200:3: ruleParameterIntegerType
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
                    // InternalBasicsParser.g:2205:2: ( ruleParameterStringType )
                    {
                    // InternalBasicsParser.g:2205:2: ( ruleParameterStringType )
                    // InternalBasicsParser.g:2206:3: ruleParameterStringType
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
                    // InternalBasicsParser.g:2211:2: ( ruleParameterDoubleType )
                    {
                    // InternalBasicsParser.g:2211:2: ( ruleParameterDoubleType )
                    // InternalBasicsParser.g:2212:3: ruleParameterDoubleType
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
                    // InternalBasicsParser.g:2217:2: ( ruleParameterBooleanType )
                    {
                    // InternalBasicsParser.g:2217:2: ( ruleParameterBooleanType )
                    // InternalBasicsParser.g:2218:3: ruleParameterBooleanType
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
                    // InternalBasicsParser.g:2223:2: ( ruleParameterBase64Type )
                    {
                    // InternalBasicsParser.g:2223:2: ( ruleParameterBase64Type )
                    // InternalBasicsParser.g:2224:3: ruleParameterBase64Type
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
                    // InternalBasicsParser.g:2229:2: ( ruleParameterArrayType )
                    {
                    // InternalBasicsParser.g:2229:2: ( ruleParameterArrayType )
                    // InternalBasicsParser.g:2230:3: ruleParameterArrayType
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
    // InternalBasicsParser.g:2239:1: rule__ParameterValue__Alternatives : ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) );
    public final void rule__ParameterValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2243:1: ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) )
            int alt3=7;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InternalBasicsParser.g:2244:2: ( ruleParameterString )
                    {
                    // InternalBasicsParser.g:2244:2: ( ruleParameterString )
                    // InternalBasicsParser.g:2245:3: ruleParameterString
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
                    // InternalBasicsParser.g:2250:2: ( ruleParameterBase64 )
                    {
                    // InternalBasicsParser.g:2250:2: ( ruleParameterBase64 )
                    // InternalBasicsParser.g:2251:3: ruleParameterBase64
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
                    // InternalBasicsParser.g:2256:2: ( ruleParameterInteger )
                    {
                    // InternalBasicsParser.g:2256:2: ( ruleParameterInteger )
                    // InternalBasicsParser.g:2257:3: ruleParameterInteger
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
                    // InternalBasicsParser.g:2262:2: ( ruleParameterDouble )
                    {
                    // InternalBasicsParser.g:2262:2: ( ruleParameterDouble )
                    // InternalBasicsParser.g:2263:3: ruleParameterDouble
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
                    // InternalBasicsParser.g:2268:2: ( ruleParameterBoolean )
                    {
                    // InternalBasicsParser.g:2268:2: ( ruleParameterBoolean )
                    // InternalBasicsParser.g:2269:3: ruleParameterBoolean
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
                    // InternalBasicsParser.g:2274:2: ( ruleParameterList )
                    {
                    // InternalBasicsParser.g:2274:2: ( ruleParameterList )
                    // InternalBasicsParser.g:2275:3: ruleParameterList
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
                    // InternalBasicsParser.g:2280:2: ( ruleParameterStruct )
                    {
                    // InternalBasicsParser.g:2280:2: ( ruleParameterStruct )
                    // InternalBasicsParser.g:2281:3: ruleParameterStruct
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
    // InternalBasicsParser.g:2290:1: rule__ParameterStructMember__Alternatives_0 : ( ( ( rule__ParameterStructMember__Group_0_0__0 ) ) | ( ( rule__ParameterStructMember__NameAssignment_0_1 ) ) );
    public final void rule__ParameterStructMember__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2294:1: ( ( ( rule__ParameterStructMember__Group_0_0__0 ) ) | ( ( rule__ParameterStructMember__NameAssignment_0_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=Pluginbases && LA4_0<=Parameter)||LA4_0==Multiple||LA4_0==Plugins||(LA4_0>=Format && LA4_0<=Loader)||LA4_0==Class||LA4_0==Slots||LA4_0==Base) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBasicsParser.g:2295:2: ( ( rule__ParameterStructMember__Group_0_0__0 ) )
                    {
                    // InternalBasicsParser.g:2295:2: ( ( rule__ParameterStructMember__Group_0_0__0 ) )
                    // InternalBasicsParser.g:2296:3: ( rule__ParameterStructMember__Group_0_0__0 )
                    {
                     before(grammarAccess.getParameterStructMemberAccess().getGroup_0_0()); 
                    // InternalBasicsParser.g:2297:3: ( rule__ParameterStructMember__Group_0_0__0 )
                    // InternalBasicsParser.g:2297:4: rule__ParameterStructMember__Group_0_0__0
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
                    // InternalBasicsParser.g:2301:2: ( ( rule__ParameterStructMember__NameAssignment_0_1 ) )
                    {
                    // InternalBasicsParser.g:2301:2: ( ( rule__ParameterStructMember__NameAssignment_0_1 ) )
                    // InternalBasicsParser.g:2302:3: ( rule__ParameterStructMember__NameAssignment_0_1 )
                    {
                     before(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0_1()); 
                    // InternalBasicsParser.g:2303:3: ( rule__ParameterStructMember__NameAssignment_0_1 )
                    // InternalBasicsParser.g:2303:4: rule__ParameterStructMember__NameAssignment_0_1
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
    // InternalBasicsParser.g:2311:1: rule__AbstractType__Alternatives : ( ( ( rule__AbstractType__Group_0__0 ) ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleArraySpecRef ) | ( rulecharArray ) );
    public final void rule__AbstractType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2315:1: ( ( ( rule__AbstractType__Group_0__0 ) ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleArraySpecRef ) | ( rulecharArray ) )
            int alt5=16;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBasicsParser.g:2316:2: ( ( rule__AbstractType__Group_0__0 ) )
                    {
                    // InternalBasicsParser.g:2316:2: ( ( rule__AbstractType__Group_0__0 ) )
                    // InternalBasicsParser.g:2317:3: ( rule__AbstractType__Group_0__0 )
                    {
                     before(grammarAccess.getAbstractTypeAccess().getGroup_0()); 
                    // InternalBasicsParser.g:2318:3: ( rule__AbstractType__Group_0__0 )
                    // InternalBasicsParser.g:2318:4: rule__AbstractType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AbstractType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAbstractTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2322:2: ( ruleboolArray )
                    {
                    // InternalBasicsParser.g:2322:2: ( ruleboolArray )
                    // InternalBasicsParser.g:2323:3: ruleboolArray
                    {
                     before(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleboolArray();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2328:2: ( ruleint8Array )
                    {
                    // InternalBasicsParser.g:2328:2: ( ruleint8Array )
                    // InternalBasicsParser.g:2329:3: ruleint8Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleint8Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2334:2: ( ruleuint8Array )
                    {
                    // InternalBasicsParser.g:2334:2: ( ruleuint8Array )
                    // InternalBasicsParser.g:2335:3: ruleuint8Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleuint8Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2340:2: ( ruleint16Array )
                    {
                    // InternalBasicsParser.g:2340:2: ( ruleint16Array )
                    // InternalBasicsParser.g:2341:3: ruleint16Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleint16Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2346:2: ( ruleuint16Array )
                    {
                    // InternalBasicsParser.g:2346:2: ( ruleuint16Array )
                    // InternalBasicsParser.g:2347:3: ruleuint16Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleuint16Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2352:2: ( ruleint32Array )
                    {
                    // InternalBasicsParser.g:2352:2: ( ruleint32Array )
                    // InternalBasicsParser.g:2353:3: ruleint32Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleint32Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2358:2: ( ruleuint32Array )
                    {
                    // InternalBasicsParser.g:2358:2: ( ruleuint32Array )
                    // InternalBasicsParser.g:2359:3: ruleuint32Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleuint32Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2364:2: ( ruleint64Array )
                    {
                    // InternalBasicsParser.g:2364:2: ( ruleint64Array )
                    // InternalBasicsParser.g:2365:3: ruleint64Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleint64Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2370:2: ( ruleuint64Array )
                    {
                    // InternalBasicsParser.g:2370:2: ( ruleuint64Array )
                    // InternalBasicsParser.g:2371:3: ruleuint64Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    ruleuint64Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2376:2: ( rulefloat32Array )
                    {
                    // InternalBasicsParser.g:2376:2: ( rulefloat32Array )
                    // InternalBasicsParser.g:2377:3: rulefloat32Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_10()); 
                    pushFollow(FOLLOW_2);
                    rulefloat32Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2382:2: ( rulefloat64Array )
                    {
                    // InternalBasicsParser.g:2382:2: ( rulefloat64Array )
                    // InternalBasicsParser.g:2383:3: rulefloat64Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_11()); 
                    pushFollow(FOLLOW_2);
                    rulefloat64Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2388:2: ( rulestring0Array )
                    {
                    // InternalBasicsParser.g:2388:2: ( rulestring0Array )
                    // InternalBasicsParser.g:2389:3: rulestring0Array
                    {
                     before(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_12()); 
                    pushFollow(FOLLOW_2);
                    rulestring0Array();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2394:2: ( rulebyteArray )
                    {
                    // InternalBasicsParser.g:2394:2: ( rulebyteArray )
                    // InternalBasicsParser.g:2395:3: rulebyteArray
                    {
                     before(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_13()); 
                    pushFollow(FOLLOW_2);
                    rulebyteArray();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBasicsParser.g:2400:2: ( ruleArraySpecRef )
                    {
                    // InternalBasicsParser.g:2400:2: ( ruleArraySpecRef )
                    // InternalBasicsParser.g:2401:3: ruleArraySpecRef
                    {
                     before(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_14()); 
                    pushFollow(FOLLOW_2);
                    ruleArraySpecRef();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBasicsParser.g:2406:2: ( rulecharArray )
                    {
                    // InternalBasicsParser.g:2406:2: ( rulecharArray )
                    // InternalBasicsParser.g:2407:3: rulecharArray
                    {
                     before(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_15()); 
                    pushFollow(FOLLOW_2);
                    rulecharArray();

                    state._fsp--;

                     after(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_15()); 

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


    // $ANTLR start "rule__ScalarType__Alternatives"
    // InternalBasicsParser.g:2416:1: rule__ScalarType__Alternatives : ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleSpecBaseRef ) | ( rulechar ) );
    public final void rule__ScalarType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2420:1: ( ( rulebool ) | ( ruleint8 ) | ( ruleuint8 ) | ( ruleint16 ) | ( ruleuint16 ) | ( ruleint32 ) | ( ruleuint32 ) | ( ruleint64 ) | ( ruleuint64 ) | ( rulefloat32 ) | ( rulefloat64 ) | ( rulestring0 ) | ( rulebyte ) | ( ruletime ) | ( ruleduration ) | ( ruleHeader ) | ( ruleSpecBaseRef ) | ( rulechar ) )
            int alt6=18;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt6=1;
                }
                break;
            case Int8:
                {
                alt6=2;
                }
                break;
            case Uint8:
                {
                alt6=3;
                }
                break;
            case Int16:
                {
                alt6=4;
                }
                break;
            case Uint16:
                {
                alt6=5;
                }
                break;
            case Int32:
                {
                alt6=6;
                }
                break;
            case Uint32:
                {
                alt6=7;
                }
                break;
            case Int64:
                {
                alt6=8;
                }
                break;
            case Uint64:
                {
                alt6=9;
                }
                break;
            case Float32:
                {
                alt6=10;
                }
                break;
            case Float64:
                {
                alt6=11;
                }
                break;
            case String_1:
                {
                alt6=12;
                }
                break;
            case Byte:
                {
                alt6=13;
                }
                break;
            case Time:
                {
                alt6=14;
                }
                break;
            case Duration:
                {
                alt6=15;
                }
                break;
            case Header:
                {
                alt6=16;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
                {
                alt6=17;
                }
                break;
            case Char:
                {
                alt6=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalBasicsParser.g:2421:2: ( rulebool )
                    {
                    // InternalBasicsParser.g:2421:2: ( rulebool )
                    // InternalBasicsParser.g:2422:3: rulebool
                    {
                     before(grammarAccess.getScalarTypeAccess().getBoolParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulebool();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getBoolParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2427:2: ( ruleint8 )
                    {
                    // InternalBasicsParser.g:2427:2: ( ruleint8 )
                    // InternalBasicsParser.g:2428:3: ruleint8
                    {
                     before(grammarAccess.getScalarTypeAccess().getInt8ParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleint8();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getInt8ParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2433:2: ( ruleuint8 )
                    {
                    // InternalBasicsParser.g:2433:2: ( ruleuint8 )
                    // InternalBasicsParser.g:2434:3: ruleuint8
                    {
                     before(grammarAccess.getScalarTypeAccess().getUint8ParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleuint8();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getUint8ParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2439:2: ( ruleint16 )
                    {
                    // InternalBasicsParser.g:2439:2: ( ruleint16 )
                    // InternalBasicsParser.g:2440:3: ruleint16
                    {
                     before(grammarAccess.getScalarTypeAccess().getInt16ParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleint16();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getInt16ParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2445:2: ( ruleuint16 )
                    {
                    // InternalBasicsParser.g:2445:2: ( ruleuint16 )
                    // InternalBasicsParser.g:2446:3: ruleuint16
                    {
                     before(grammarAccess.getScalarTypeAccess().getUint16ParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleuint16();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getUint16ParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2451:2: ( ruleint32 )
                    {
                    // InternalBasicsParser.g:2451:2: ( ruleint32 )
                    // InternalBasicsParser.g:2452:3: ruleint32
                    {
                     before(grammarAccess.getScalarTypeAccess().getInt32ParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleint32();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getInt32ParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2457:2: ( ruleuint32 )
                    {
                    // InternalBasicsParser.g:2457:2: ( ruleuint32 )
                    // InternalBasicsParser.g:2458:3: ruleuint32
                    {
                     before(grammarAccess.getScalarTypeAccess().getUint32ParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleuint32();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getUint32ParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2463:2: ( ruleint64 )
                    {
                    // InternalBasicsParser.g:2463:2: ( ruleint64 )
                    // InternalBasicsParser.g:2464:3: ruleint64
                    {
                     before(grammarAccess.getScalarTypeAccess().getInt64ParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleint64();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getInt64ParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2469:2: ( ruleuint64 )
                    {
                    // InternalBasicsParser.g:2469:2: ( ruleuint64 )
                    // InternalBasicsParser.g:2470:3: ruleuint64
                    {
                     before(grammarAccess.getScalarTypeAccess().getUint64ParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleuint64();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getUint64ParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2475:2: ( rulefloat32 )
                    {
                    // InternalBasicsParser.g:2475:2: ( rulefloat32 )
                    // InternalBasicsParser.g:2476:3: rulefloat32
                    {
                     before(grammarAccess.getScalarTypeAccess().getFloat32ParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    rulefloat32();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getFloat32ParserRuleCall_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2481:2: ( rulefloat64 )
                    {
                    // InternalBasicsParser.g:2481:2: ( rulefloat64 )
                    // InternalBasicsParser.g:2482:3: rulefloat64
                    {
                     before(grammarAccess.getScalarTypeAccess().getFloat64ParserRuleCall_10()); 
                    pushFollow(FOLLOW_2);
                    rulefloat64();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getFloat64ParserRuleCall_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2487:2: ( rulestring0 )
                    {
                    // InternalBasicsParser.g:2487:2: ( rulestring0 )
                    // InternalBasicsParser.g:2488:3: rulestring0
                    {
                     before(grammarAccess.getScalarTypeAccess().getString0ParserRuleCall_11()); 
                    pushFollow(FOLLOW_2);
                    rulestring0();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getString0ParserRuleCall_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2493:2: ( rulebyte )
                    {
                    // InternalBasicsParser.g:2493:2: ( rulebyte )
                    // InternalBasicsParser.g:2494:3: rulebyte
                    {
                     before(grammarAccess.getScalarTypeAccess().getByteParserRuleCall_12()); 
                    pushFollow(FOLLOW_2);
                    rulebyte();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getByteParserRuleCall_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2499:2: ( ruletime )
                    {
                    // InternalBasicsParser.g:2499:2: ( ruletime )
                    // InternalBasicsParser.g:2500:3: ruletime
                    {
                     before(grammarAccess.getScalarTypeAccess().getTimeParserRuleCall_13()); 
                    pushFollow(FOLLOW_2);
                    ruletime();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getTimeParserRuleCall_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBasicsParser.g:2505:2: ( ruleduration )
                    {
                    // InternalBasicsParser.g:2505:2: ( ruleduration )
                    // InternalBasicsParser.g:2506:3: ruleduration
                    {
                     before(grammarAccess.getScalarTypeAccess().getDurationParserRuleCall_14()); 
                    pushFollow(FOLLOW_2);
                    ruleduration();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getDurationParserRuleCall_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBasicsParser.g:2511:2: ( ruleHeader )
                    {
                    // InternalBasicsParser.g:2511:2: ( ruleHeader )
                    // InternalBasicsParser.g:2512:3: ruleHeader
                    {
                     before(grammarAccess.getScalarTypeAccess().getHeaderParserRuleCall_15()); 
                    pushFollow(FOLLOW_2);
                    ruleHeader();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getHeaderParserRuleCall_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBasicsParser.g:2517:2: ( ruleSpecBaseRef )
                    {
                    // InternalBasicsParser.g:2517:2: ( ruleSpecBaseRef )
                    // InternalBasicsParser.g:2518:3: ruleSpecBaseRef
                    {
                     before(grammarAccess.getScalarTypeAccess().getSpecBaseRefParserRuleCall_16()); 
                    pushFollow(FOLLOW_2);
                    ruleSpecBaseRef();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getSpecBaseRefParserRuleCall_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBasicsParser.g:2523:2: ( rulechar )
                    {
                    // InternalBasicsParser.g:2523:2: ( rulechar )
                    // InternalBasicsParser.g:2524:3: rulechar
                    {
                     before(grammarAccess.getScalarTypeAccess().getCharParserRuleCall_17()); 
                    pushFollow(FOLLOW_2);
                    rulechar();

                    state._fsp--;

                     after(grammarAccess.getScalarTypeAccess().getCharParserRuleCall_17()); 

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
    // $ANTLR end "rule__ScalarType__Alternatives"


    // $ANTLR start "rule__KEYWORD__Alternatives"
    // InternalBasicsParser.g:2533:1: rule__KEYWORD__Alternatives : ( ( Goal ) | ( Message ) | ( Result ) | ( Feedback ) | ( Name ) | ( Value ) | ( Service ) | ( Type ) | ( Action ) | ( Duration ) | ( Time ) );
    public final void rule__KEYWORD__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2537:1: ( ( Goal ) | ( Message ) | ( Result ) | ( Feedback ) | ( Name ) | ( Value ) | ( Service ) | ( Type ) | ( Action ) | ( Duration ) | ( Time ) )
            int alt7=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt7=1;
                }
                break;
            case Message:
                {
                alt7=2;
                }
                break;
            case Result:
                {
                alt7=3;
                }
                break;
            case Feedback:
                {
                alt7=4;
                }
                break;
            case Name:
                {
                alt7=5;
                }
                break;
            case Value:
                {
                alt7=6;
                }
                break;
            case Service:
                {
                alt7=7;
                }
                break;
            case Type:
                {
                alt7=8;
                }
                break;
            case Action:
                {
                alt7=9;
                }
                break;
            case Duration:
                {
                alt7=10;
                }
                break;
            case Time:
                {
                alt7=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalBasicsParser.g:2538:2: ( Goal )
                    {
                    // InternalBasicsParser.g:2538:2: ( Goal )
                    // InternalBasicsParser.g:2539:3: Goal
                    {
                     before(grammarAccess.getKEYWORDAccess().getGoalKeyword_0()); 
                    match(input,Goal,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getGoalKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2544:2: ( Message )
                    {
                    // InternalBasicsParser.g:2544:2: ( Message )
                    // InternalBasicsParser.g:2545:3: Message
                    {
                     before(grammarAccess.getKEYWORDAccess().getMessageKeyword_1()); 
                    match(input,Message,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getMessageKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2550:2: ( Result )
                    {
                    // InternalBasicsParser.g:2550:2: ( Result )
                    // InternalBasicsParser.g:2551:3: Result
                    {
                     before(grammarAccess.getKEYWORDAccess().getResultKeyword_2()); 
                    match(input,Result,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getResultKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2556:2: ( Feedback )
                    {
                    // InternalBasicsParser.g:2556:2: ( Feedback )
                    // InternalBasicsParser.g:2557:3: Feedback
                    {
                     before(grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3()); 
                    match(input,Feedback,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2562:2: ( Name )
                    {
                    // InternalBasicsParser.g:2562:2: ( Name )
                    // InternalBasicsParser.g:2563:3: Name
                    {
                     before(grammarAccess.getKEYWORDAccess().getNameKeyword_4()); 
                    match(input,Name,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getNameKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2568:2: ( Value )
                    {
                    // InternalBasicsParser.g:2568:2: ( Value )
                    // InternalBasicsParser.g:2569:3: Value
                    {
                     before(grammarAccess.getKEYWORDAccess().getValueKeyword_5()); 
                    match(input,Value,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getValueKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2574:2: ( Service )
                    {
                    // InternalBasicsParser.g:2574:2: ( Service )
                    // InternalBasicsParser.g:2575:3: Service
                    {
                     before(grammarAccess.getKEYWORDAccess().getServiceKeyword_6()); 
                    match(input,Service,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getServiceKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2580:2: ( Type )
                    {
                    // InternalBasicsParser.g:2580:2: ( Type )
                    // InternalBasicsParser.g:2581:3: Type
                    {
                     before(grammarAccess.getKEYWORDAccess().getTypeKeyword_7()); 
                    match(input,Type,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getTypeKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2586:2: ( Action )
                    {
                    // InternalBasicsParser.g:2586:2: ( Action )
                    // InternalBasicsParser.g:2587:3: Action
                    {
                     before(grammarAccess.getKEYWORDAccess().getActionKeyword_8()); 
                    match(input,Action,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getActionKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2592:2: ( Duration )
                    {
                    // InternalBasicsParser.g:2592:2: ( Duration )
                    // InternalBasicsParser.g:2593:3: Duration
                    {
                     before(grammarAccess.getKEYWORDAccess().getDurationKeyword_9()); 
                    match(input,Duration,FOLLOW_2); 
                     after(grammarAccess.getKEYWORDAccess().getDurationKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2598:2: ( Time )
                    {
                    // InternalBasicsParser.g:2598:2: ( Time )
                    // InternalBasicsParser.g:2599:3: Time
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
    // InternalBasicsParser.g:2608:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2612:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBasicsParser.g:2613:2: ( RULE_STRING )
                    {
                    // InternalBasicsParser.g:2613:2: ( RULE_STRING )
                    // InternalBasicsParser.g:2614:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2619:2: ( RULE_ID )
                    {
                    // InternalBasicsParser.g:2619:2: ( RULE_ID )
                    // InternalBasicsParser.g:2620:3: RULE_ID
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
    // InternalBasicsParser.g:2629:1: rule__AddedKeywordName__Alternatives : ( ( Lifecycle ) | ( Active_in ) | ( Plugins ) | ( Implements ) | ( Pluginslots ) | ( Pluginbases ) | ( Base ) | ( Parameter ) | ( Format ) | ( Multiple ) | ( Class ) | ( Header_1 ) | ( Loader ) | ( Slots ) );
    public final void rule__AddedKeywordName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2633:1: ( ( Lifecycle ) | ( Active_in ) | ( Plugins ) | ( Implements ) | ( Pluginslots ) | ( Pluginbases ) | ( Base ) | ( Parameter ) | ( Format ) | ( Multiple ) | ( Class ) | ( Header_1 ) | ( Loader ) | ( Slots ) )
            int alt9=14;
            switch ( input.LA(1) ) {
            case Lifecycle:
                {
                alt9=1;
                }
                break;
            case Active_in:
                {
                alt9=2;
                }
                break;
            case Plugins:
                {
                alt9=3;
                }
                break;
            case Implements:
                {
                alt9=4;
                }
                break;
            case Pluginslots:
                {
                alt9=5;
                }
                break;
            case Pluginbases:
                {
                alt9=6;
                }
                break;
            case Base:
                {
                alt9=7;
                }
                break;
            case Parameter:
                {
                alt9=8;
                }
                break;
            case Format:
                {
                alt9=9;
                }
                break;
            case Multiple:
                {
                alt9=10;
                }
                break;
            case Class:
                {
                alt9=11;
                }
                break;
            case Header_1:
                {
                alt9=12;
                }
                break;
            case Loader:
                {
                alt9=13;
                }
                break;
            case Slots:
                {
                alt9=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalBasicsParser.g:2634:2: ( Lifecycle )
                    {
                    // InternalBasicsParser.g:2634:2: ( Lifecycle )
                    // InternalBasicsParser.g:2635:3: Lifecycle
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getLifecycleKeyword_0()); 
                    match(input,Lifecycle,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getLifecycleKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2640:2: ( Active_in )
                    {
                    // InternalBasicsParser.g:2640:2: ( Active_in )
                    // InternalBasicsParser.g:2641:3: Active_in
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getActive_inKeyword_1()); 
                    match(input,Active_in,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getActive_inKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2646:2: ( Plugins )
                    {
                    // InternalBasicsParser.g:2646:2: ( Plugins )
                    // InternalBasicsParser.g:2647:3: Plugins
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getPluginsKeyword_2()); 
                    match(input,Plugins,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getPluginsKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2652:2: ( Implements )
                    {
                    // InternalBasicsParser.g:2652:2: ( Implements )
                    // InternalBasicsParser.g:2653:3: Implements
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getImplementsKeyword_3()); 
                    match(input,Implements,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getImplementsKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2658:2: ( Pluginslots )
                    {
                    // InternalBasicsParser.g:2658:2: ( Pluginslots )
                    // InternalBasicsParser.g:2659:3: Pluginslots
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getPluginslotsKeyword_4()); 
                    match(input,Pluginslots,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getPluginslotsKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2664:2: ( Pluginbases )
                    {
                    // InternalBasicsParser.g:2664:2: ( Pluginbases )
                    // InternalBasicsParser.g:2665:3: Pluginbases
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getPluginbasesKeyword_5()); 
                    match(input,Pluginbases,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getPluginbasesKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2670:2: ( Base )
                    {
                    // InternalBasicsParser.g:2670:2: ( Base )
                    // InternalBasicsParser.g:2671:3: Base
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getBaseKeyword_6()); 
                    match(input,Base,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getBaseKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2676:2: ( Parameter )
                    {
                    // InternalBasicsParser.g:2676:2: ( Parameter )
                    // InternalBasicsParser.g:2677:3: Parameter
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getParameterKeyword_7()); 
                    match(input,Parameter,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getParameterKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2682:2: ( Format )
                    {
                    // InternalBasicsParser.g:2682:2: ( Format )
                    // InternalBasicsParser.g:2683:3: Format
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getFormatKeyword_8()); 
                    match(input,Format,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getFormatKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2688:2: ( Multiple )
                    {
                    // InternalBasicsParser.g:2688:2: ( Multiple )
                    // InternalBasicsParser.g:2689:3: Multiple
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getMultipleKeyword_9()); 
                    match(input,Multiple,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getMultipleKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2694:2: ( Class )
                    {
                    // InternalBasicsParser.g:2694:2: ( Class )
                    // InternalBasicsParser.g:2695:3: Class
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getClassKeyword_10()); 
                    match(input,Class,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getClassKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2700:2: ( Header_1 )
                    {
                    // InternalBasicsParser.g:2700:2: ( Header_1 )
                    // InternalBasicsParser.g:2701:3: Header_1
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getHeaderKeyword_11()); 
                    match(input,Header_1,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getHeaderKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2706:2: ( Loader )
                    {
                    // InternalBasicsParser.g:2706:2: ( Loader )
                    // InternalBasicsParser.g:2707:3: Loader
                    {
                     before(grammarAccess.getAddedKeywordNameAccess().getLoaderKeyword_12()); 
                    match(input,Loader,FOLLOW_2); 
                     after(grammarAccess.getAddedKeywordNameAccess().getLoaderKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2712:2: ( Slots )
                    {
                    // InternalBasicsParser.g:2712:2: ( Slots )
                    // InternalBasicsParser.g:2713:3: Slots
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
    // InternalBasicsParser.g:2722:1: rule__ExtensionEntry__Alternatives_1 : ( ( ( rule__ExtensionEntry__Group_1_0__0 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) ) );
    public final void rule__ExtensionEntry__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2726:1: ( ( ( rule__ExtensionEntry__Group_1_0__0 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) ) | ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) ) )
            int alt10=3;
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
                alt10=1;
                }
                break;
            case Default:
            case Value_1:
            case Type_1:
            case Ns:
                {
                alt10=2;
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
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalBasicsParser.g:2727:2: ( ( rule__ExtensionEntry__Group_1_0__0 ) )
                    {
                    // InternalBasicsParser.g:2727:2: ( ( rule__ExtensionEntry__Group_1_0__0 ) )
                    // InternalBasicsParser.g:2728:3: ( rule__ExtensionEntry__Group_1_0__0 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getGroup_1_0()); 
                    // InternalBasicsParser.g:2729:3: ( rule__ExtensionEntry__Group_1_0__0 )
                    // InternalBasicsParser.g:2729:4: rule__ExtensionEntry__Group_1_0__0
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
                    // InternalBasicsParser.g:2733:2: ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) )
                    {
                    // InternalBasicsParser.g:2733:2: ( ( rule__ExtensionEntry__KeyAssignment_1_1 ) )
                    // InternalBasicsParser.g:2734:3: ( rule__ExtensionEntry__KeyAssignment_1_1 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_1()); 
                    // InternalBasicsParser.g:2735:3: ( rule__ExtensionEntry__KeyAssignment_1_1 )
                    // InternalBasicsParser.g:2735:4: rule__ExtensionEntry__KeyAssignment_1_1
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
                    // InternalBasicsParser.g:2739:2: ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) )
                    {
                    // InternalBasicsParser.g:2739:2: ( ( rule__ExtensionEntry__KeyAssignment_1_2 ) )
                    // InternalBasicsParser.g:2740:3: ( rule__ExtensionEntry__KeyAssignment_1_2 )
                    {
                     before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_2()); 
                    // InternalBasicsParser.g:2741:3: ( rule__ExtensionEntry__KeyAssignment_1_2 )
                    // InternalBasicsParser.g:2741:4: rule__ExtensionEntry__KeyAssignment_1_2
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
    // InternalBasicsParser.g:2749:1: rule__ExtensionKey__Alternatives : ( ( RULE_ID ) | ( RULE_STRING ) | ( ruleKEYWORD ) | ( Node ) | ( String ) | ( Integer ) | ( Double ) | ( Boolean ) | ( Base64 ) | ( Array ) | ( List ) | ( Struct ) | ( Date ) | ( Any ) | ( Bool ) | ( Int8 ) | ( Uint8 ) | ( Int16 ) | ( Uint16 ) | ( Int32 ) | ( Uint32 ) | ( Int64 ) | ( Uint64 ) | ( Float32 ) | ( Float64 ) | ( String_1 ) | ( Char ) | ( Byte ) | ( Header ) );
    public final void rule__ExtensionKey__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2753:1: ( ( RULE_ID ) | ( RULE_STRING ) | ( ruleKEYWORD ) | ( Node ) | ( String ) | ( Integer ) | ( Double ) | ( Boolean ) | ( Base64 ) | ( Array ) | ( List ) | ( Struct ) | ( Date ) | ( Any ) | ( Bool ) | ( Int8 ) | ( Uint8 ) | ( Int16 ) | ( Uint16 ) | ( Int32 ) | ( Uint32 ) | ( Int64 ) | ( Uint64 ) | ( Float32 ) | ( Float64 ) | ( String_1 ) | ( Char ) | ( Byte ) | ( Header ) )
            int alt11=29;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt11=1;
                }
                break;
            case RULE_STRING:
                {
                alt11=2;
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
                alt11=3;
                }
                break;
            case Node:
                {
                alt11=4;
                }
                break;
            case String:
                {
                alt11=5;
                }
                break;
            case Integer:
                {
                alt11=6;
                }
                break;
            case Double:
                {
                alt11=7;
                }
                break;
            case Boolean:
                {
                alt11=8;
                }
                break;
            case Base64:
                {
                alt11=9;
                }
                break;
            case Array:
                {
                alt11=10;
                }
                break;
            case List:
                {
                alt11=11;
                }
                break;
            case Struct:
                {
                alt11=12;
                }
                break;
            case Date:
                {
                alt11=13;
                }
                break;
            case Any:
                {
                alt11=14;
                }
                break;
            case Bool:
                {
                alt11=15;
                }
                break;
            case Int8:
                {
                alt11=16;
                }
                break;
            case Uint8:
                {
                alt11=17;
                }
                break;
            case Int16:
                {
                alt11=18;
                }
                break;
            case Uint16:
                {
                alt11=19;
                }
                break;
            case Int32:
                {
                alt11=20;
                }
                break;
            case Uint32:
                {
                alt11=21;
                }
                break;
            case Int64:
                {
                alt11=22;
                }
                break;
            case Uint64:
                {
                alt11=23;
                }
                break;
            case Float32:
                {
                alt11=24;
                }
                break;
            case Float64:
                {
                alt11=25;
                }
                break;
            case String_1:
                {
                alt11=26;
                }
                break;
            case Char:
                {
                alt11=27;
                }
                break;
            case Byte:
                {
                alt11=28;
                }
                break;
            case Header:
                {
                alt11=29;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalBasicsParser.g:2754:2: ( RULE_ID )
                    {
                    // InternalBasicsParser.g:2754:2: ( RULE_ID )
                    // InternalBasicsParser.g:2755:3: RULE_ID
                    {
                     before(grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2760:2: ( RULE_STRING )
                    {
                    // InternalBasicsParser.g:2760:2: ( RULE_STRING )
                    // InternalBasicsParser.g:2761:3: RULE_STRING
                    {
                     before(grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2766:2: ( ruleKEYWORD )
                    {
                    // InternalBasicsParser.g:2766:2: ( ruleKEYWORD )
                    // InternalBasicsParser.g:2767:3: ruleKEYWORD
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
                    // InternalBasicsParser.g:2772:2: ( Node )
                    {
                    // InternalBasicsParser.g:2772:2: ( Node )
                    // InternalBasicsParser.g:2773:3: Node
                    {
                     before(grammarAccess.getExtensionKeyAccess().getNodeKeyword_3()); 
                    match(input,Node,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getNodeKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:2778:2: ( String )
                    {
                    // InternalBasicsParser.g:2778:2: ( String )
                    // InternalBasicsParser.g:2779:3: String
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStringKeyword_4()); 
                    match(input,String,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStringKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:2784:2: ( Integer )
                    {
                    // InternalBasicsParser.g:2784:2: ( Integer )
                    // InternalBasicsParser.g:2785:3: Integer
                    {
                     before(grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5()); 
                    match(input,Integer,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:2790:2: ( Double )
                    {
                    // InternalBasicsParser.g:2790:2: ( Double )
                    // InternalBasicsParser.g:2791:3: Double
                    {
                     before(grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6()); 
                    match(input,Double,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBasicsParser.g:2796:2: ( Boolean )
                    {
                    // InternalBasicsParser.g:2796:2: ( Boolean )
                    // InternalBasicsParser.g:2797:3: Boolean
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7()); 
                    match(input,Boolean,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBasicsParser.g:2802:2: ( Base64 )
                    {
                    // InternalBasicsParser.g:2802:2: ( Base64 )
                    // InternalBasicsParser.g:2803:3: Base64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBase64Keyword_8()); 
                    match(input,Base64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBase64Keyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBasicsParser.g:2808:2: ( Array )
                    {
                    // InternalBasicsParser.g:2808:2: ( Array )
                    // InternalBasicsParser.g:2809:3: Array
                    {
                     before(grammarAccess.getExtensionKeyAccess().getArrayKeyword_9()); 
                    match(input,Array,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getArrayKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBasicsParser.g:2814:2: ( List )
                    {
                    // InternalBasicsParser.g:2814:2: ( List )
                    // InternalBasicsParser.g:2815:3: List
                    {
                     before(grammarAccess.getExtensionKeyAccess().getListKeyword_10()); 
                    match(input,List,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getListKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBasicsParser.g:2820:2: ( Struct )
                    {
                    // InternalBasicsParser.g:2820:2: ( Struct )
                    // InternalBasicsParser.g:2821:3: Struct
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStructKeyword_11()); 
                    match(input,Struct,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStructKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBasicsParser.g:2826:2: ( Date )
                    {
                    // InternalBasicsParser.g:2826:2: ( Date )
                    // InternalBasicsParser.g:2827:3: Date
                    {
                     before(grammarAccess.getExtensionKeyAccess().getDateKeyword_12()); 
                    match(input,Date,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getDateKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBasicsParser.g:2832:2: ( Any )
                    {
                    // InternalBasicsParser.g:2832:2: ( Any )
                    // InternalBasicsParser.g:2833:3: Any
                    {
                     before(grammarAccess.getExtensionKeyAccess().getAnyKeyword_13()); 
                    match(input,Any,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getAnyKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBasicsParser.g:2838:2: ( Bool )
                    {
                    // InternalBasicsParser.g:2838:2: ( Bool )
                    // InternalBasicsParser.g:2839:3: Bool
                    {
                     before(grammarAccess.getExtensionKeyAccess().getBoolKeyword_14()); 
                    match(input,Bool,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getBoolKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBasicsParser.g:2844:2: ( Int8 )
                    {
                    // InternalBasicsParser.g:2844:2: ( Int8 )
                    // InternalBasicsParser.g:2845:3: Int8
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt8Keyword_15()); 
                    match(input,Int8,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt8Keyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBasicsParser.g:2850:2: ( Uint8 )
                    {
                    // InternalBasicsParser.g:2850:2: ( Uint8 )
                    // InternalBasicsParser.g:2851:3: Uint8
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint8Keyword_16()); 
                    match(input,Uint8,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint8Keyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBasicsParser.g:2856:2: ( Int16 )
                    {
                    // InternalBasicsParser.g:2856:2: ( Int16 )
                    // InternalBasicsParser.g:2857:3: Int16
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt16Keyword_17()); 
                    match(input,Int16,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt16Keyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBasicsParser.g:2862:2: ( Uint16 )
                    {
                    // InternalBasicsParser.g:2862:2: ( Uint16 )
                    // InternalBasicsParser.g:2863:3: Uint16
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint16Keyword_18()); 
                    match(input,Uint16,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint16Keyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBasicsParser.g:2868:2: ( Int32 )
                    {
                    // InternalBasicsParser.g:2868:2: ( Int32 )
                    // InternalBasicsParser.g:2869:3: Int32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt32Keyword_19()); 
                    match(input,Int32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt32Keyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBasicsParser.g:2874:2: ( Uint32 )
                    {
                    // InternalBasicsParser.g:2874:2: ( Uint32 )
                    // InternalBasicsParser.g:2875:3: Uint32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint32Keyword_20()); 
                    match(input,Uint32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint32Keyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBasicsParser.g:2880:2: ( Int64 )
                    {
                    // InternalBasicsParser.g:2880:2: ( Int64 )
                    // InternalBasicsParser.g:2881:3: Int64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getInt64Keyword_21()); 
                    match(input,Int64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getInt64Keyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBasicsParser.g:2886:2: ( Uint64 )
                    {
                    // InternalBasicsParser.g:2886:2: ( Uint64 )
                    // InternalBasicsParser.g:2887:3: Uint64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getUint64Keyword_22()); 
                    match(input,Uint64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getUint64Keyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBasicsParser.g:2892:2: ( Float32 )
                    {
                    // InternalBasicsParser.g:2892:2: ( Float32 )
                    // InternalBasicsParser.g:2893:3: Float32
                    {
                     before(grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23()); 
                    match(input,Float32,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBasicsParser.g:2898:2: ( Float64 )
                    {
                    // InternalBasicsParser.g:2898:2: ( Float64 )
                    // InternalBasicsParser.g:2899:3: Float64
                    {
                     before(grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24()); 
                    match(input,Float64,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBasicsParser.g:2904:2: ( String_1 )
                    {
                    // InternalBasicsParser.g:2904:2: ( String_1 )
                    // InternalBasicsParser.g:2905:3: String_1
                    {
                     before(grammarAccess.getExtensionKeyAccess().getStringKeyword_25()); 
                    match(input,String_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getStringKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalBasicsParser.g:2910:2: ( Char )
                    {
                    // InternalBasicsParser.g:2910:2: ( Char )
                    // InternalBasicsParser.g:2911:3: Char
                    {
                     before(grammarAccess.getExtensionKeyAccess().getCharKeyword_26()); 
                    match(input,Char,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getCharKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalBasicsParser.g:2916:2: ( Byte )
                    {
                    // InternalBasicsParser.g:2916:2: ( Byte )
                    // InternalBasicsParser.g:2917:3: Byte
                    {
                     before(grammarAccess.getExtensionKeyAccess().getByteKeyword_27()); 
                    match(input,Byte,FOLLOW_2); 
                     after(grammarAccess.getExtensionKeyAccess().getByteKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalBasicsParser.g:2922:2: ( Header )
                    {
                    // InternalBasicsParser.g:2922:2: ( Header )
                    // InternalBasicsParser.g:2923:3: Header
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
    // InternalBasicsParser.g:2932:1: rule__ExtensionColonKey__Alternatives : ( ( Ns ) | ( Type_1 ) | ( Value_1 ) | ( Default ) );
    public final void rule__ExtensionColonKey__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2936:1: ( ( Ns ) | ( Type_1 ) | ( Value_1 ) | ( Default ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt12=1;
                }
                break;
            case Type_1:
                {
                alt12=2;
                }
                break;
            case Value_1:
                {
                alt12=3;
                }
                break;
            case Default:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalBasicsParser.g:2937:2: ( Ns )
                    {
                    // InternalBasicsParser.g:2937:2: ( Ns )
                    // InternalBasicsParser.g:2938:3: Ns
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0()); 
                    match(input,Ns,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:2943:2: ( Type_1 )
                    {
                    // InternalBasicsParser.g:2943:2: ( Type_1 )
                    // InternalBasicsParser.g:2944:3: Type_1
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1()); 
                    match(input,Type_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:2949:2: ( Value_1 )
                    {
                    // InternalBasicsParser.g:2949:2: ( Value_1 )
                    // InternalBasicsParser.g:2950:3: Value_1
                    {
                     before(grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2()); 
                    match(input,Value_1,FOLLOW_2); 
                     after(grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:2955:2: ( Default )
                    {
                    // InternalBasicsParser.g:2955:2: ( Default )
                    // InternalBasicsParser.g:2956:3: Default
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
    // InternalBasicsParser.g:2965:1: rule__ExtensionValue__Alternatives : ( ( ruleExtensionListValue ) | ( ruleExtensionBraceMapValue ) | ( ruleExtensionIndentedMapValue ) | ( ruleExtensionRefValue ) | ( ruleExtensionScalarValue ) );
    public final void rule__ExtensionValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:2969:1: ( ( ruleExtensionListValue ) | ( ruleExtensionBraceMapValue ) | ( ruleExtensionIndentedMapValue ) | ( ruleExtensionRefValue ) | ( ruleExtensionScalarValue ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt13=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt13=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt13=3;
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
                alt13=4;
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
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalBasicsParser.g:2970:2: ( ruleExtensionListValue )
                    {
                    // InternalBasicsParser.g:2970:2: ( ruleExtensionListValue )
                    // InternalBasicsParser.g:2971:3: ruleExtensionListValue
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
                    // InternalBasicsParser.g:2976:2: ( ruleExtensionBraceMapValue )
                    {
                    // InternalBasicsParser.g:2976:2: ( ruleExtensionBraceMapValue )
                    // InternalBasicsParser.g:2977:3: ruleExtensionBraceMapValue
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
                    // InternalBasicsParser.g:2982:2: ( ruleExtensionIndentedMapValue )
                    {
                    // InternalBasicsParser.g:2982:2: ( ruleExtensionIndentedMapValue )
                    // InternalBasicsParser.g:2983:3: ruleExtensionIndentedMapValue
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
                    // InternalBasicsParser.g:2988:2: ( ruleExtensionRefValue )
                    {
                    // InternalBasicsParser.g:2988:2: ( ruleExtensionRefValue )
                    // InternalBasicsParser.g:2989:3: ruleExtensionRefValue
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
                    // InternalBasicsParser.g:2994:2: ( ruleExtensionScalarValue )
                    {
                    // InternalBasicsParser.g:2994:2: ( ruleExtensionScalarValue )
                    // InternalBasicsParser.g:2995:3: ruleExtensionScalarValue
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
    // InternalBasicsParser.g:3004:1: rule__ExtensionRefValue__RefKindAlternatives_1_0 : ( ( Pub ) | ( Sub ) | ( Ss ) | ( Sc ) | ( As ) | ( Ac ) | ( Param ) );
    public final void rule__ExtensionRefValue__RefKindAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3008:1: ( ( Pub ) | ( Sub ) | ( Ss ) | ( Sc ) | ( As ) | ( Ac ) | ( Param ) )
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
                    // InternalBasicsParser.g:3009:2: ( Pub )
                    {
                    // InternalBasicsParser.g:3009:2: ( Pub )
                    // InternalBasicsParser.g:3010:3: Pub
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0()); 
                    match(input,Pub,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:3015:2: ( Sub )
                    {
                    // InternalBasicsParser.g:3015:2: ( Sub )
                    // InternalBasicsParser.g:3016:3: Sub
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1()); 
                    match(input,Sub,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:3021:2: ( Ss )
                    {
                    // InternalBasicsParser.g:3021:2: ( Ss )
                    // InternalBasicsParser.g:3022:3: Ss
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2()); 
                    match(input,Ss,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:3027:2: ( Sc )
                    {
                    // InternalBasicsParser.g:3027:2: ( Sc )
                    // InternalBasicsParser.g:3028:3: Sc
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3()); 
                    match(input,Sc,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:3033:2: ( As )
                    {
                    // InternalBasicsParser.g:3033:2: ( As )
                    // InternalBasicsParser.g:3034:3: As
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4()); 
                    match(input,As,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBasicsParser.g:3039:2: ( Ac )
                    {
                    // InternalBasicsParser.g:3039:2: ( Ac )
                    // InternalBasicsParser.g:3040:3: Ac
                    {
                     before(grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5()); 
                    match(input,Ac,FOLLOW_2); 
                     after(grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBasicsParser.g:3045:2: ( Param )
                    {
                    // InternalBasicsParser.g:3045:2: ( Param )
                    // InternalBasicsParser.g:3046:3: Param
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
    // InternalBasicsParser.g:3055:1: rule__ExtensionScalarLiteral__Alternatives : ( ( RULE_BOOLEAN ) | ( RULE_DOUBLE ) | ( RULE_DECINT ) | ( RULE_INT ) | ( ruleExtensionKey ) );
    public final void rule__ExtensionScalarLiteral__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3059:1: ( ( RULE_BOOLEAN ) | ( RULE_DOUBLE ) | ( RULE_DECINT ) | ( RULE_INT ) | ( ruleExtensionKey ) )
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
                    // InternalBasicsParser.g:3060:2: ( RULE_BOOLEAN )
                    {
                    // InternalBasicsParser.g:3060:2: ( RULE_BOOLEAN )
                    // InternalBasicsParser.g:3061:3: RULE_BOOLEAN
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0()); 
                    match(input,RULE_BOOLEAN,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBasicsParser.g:3066:2: ( RULE_DOUBLE )
                    {
                    // InternalBasicsParser.g:3066:2: ( RULE_DOUBLE )
                    // InternalBasicsParser.g:3067:3: RULE_DOUBLE
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1()); 
                    match(input,RULE_DOUBLE,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBasicsParser.g:3072:2: ( RULE_DECINT )
                    {
                    // InternalBasicsParser.g:3072:2: ( RULE_DECINT )
                    // InternalBasicsParser.g:3073:3: RULE_DECINT
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2()); 
                    match(input,RULE_DECINT,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBasicsParser.g:3078:2: ( RULE_INT )
                    {
                    // InternalBasicsParser.g:3078:2: ( RULE_INT )
                    // InternalBasicsParser.g:3079:3: RULE_INT
                    {
                     before(grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3()); 
                    match(input,RULE_INT,FOLLOW_2); 
                     after(grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBasicsParser.g:3084:2: ( ruleExtensionKey )
                    {
                    // InternalBasicsParser.g:3084:2: ( ruleExtensionKey )
                    // InternalBasicsParser.g:3085:3: ruleExtensionKey
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
    // InternalBasicsParser.g:3094:1: rule__GlobalNamespace__Group__0 : rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1 ;
    public final void rule__GlobalNamespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3098:1: ( rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1 )
            // InternalBasicsParser.g:3099:2: rule__GlobalNamespace__Group__0__Impl rule__GlobalNamespace__Group__1
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
    // InternalBasicsParser.g:3106:1: rule__GlobalNamespace__Group__0__Impl : ( () ) ;
    public final void rule__GlobalNamespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3110:1: ( ( () ) )
            // InternalBasicsParser.g:3111:1: ( () )
            {
            // InternalBasicsParser.g:3111:1: ( () )
            // InternalBasicsParser.g:3112:2: ()
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0()); 
            // InternalBasicsParser.g:3113:2: ()
            // InternalBasicsParser.g:3113:3: 
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
    // InternalBasicsParser.g:3121:1: rule__GlobalNamespace__Group__1 : rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2 ;
    public final void rule__GlobalNamespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3125:1: ( rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2 )
            // InternalBasicsParser.g:3126:2: rule__GlobalNamespace__Group__1__Impl rule__GlobalNamespace__Group__2
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
    // InternalBasicsParser.g:3133:1: rule__GlobalNamespace__Group__1__Impl : ( GlobalNamespace ) ;
    public final void rule__GlobalNamespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3137:1: ( ( GlobalNamespace ) )
            // InternalBasicsParser.g:3138:1: ( GlobalNamespace )
            {
            // InternalBasicsParser.g:3138:1: ( GlobalNamespace )
            // InternalBasicsParser.g:3139:2: GlobalNamespace
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
    // InternalBasicsParser.g:3148:1: rule__GlobalNamespace__Group__2 : rule__GlobalNamespace__Group__2__Impl ;
    public final void rule__GlobalNamespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3152:1: ( rule__GlobalNamespace__Group__2__Impl )
            // InternalBasicsParser.g:3153:2: rule__GlobalNamespace__Group__2__Impl
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
    // InternalBasicsParser.g:3159:1: rule__GlobalNamespace__Group__2__Impl : ( ( rule__GlobalNamespace__Group_2__0 )? ) ;
    public final void rule__GlobalNamespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3163:1: ( ( ( rule__GlobalNamespace__Group_2__0 )? ) )
            // InternalBasicsParser.g:3164:1: ( ( rule__GlobalNamespace__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3164:1: ( ( rule__GlobalNamespace__Group_2__0 )? )
            // InternalBasicsParser.g:3165:2: ( rule__GlobalNamespace__Group_2__0 )?
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup_2()); 
            // InternalBasicsParser.g:3166:2: ( rule__GlobalNamespace__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LeftSquareBracket) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBasicsParser.g:3166:3: rule__GlobalNamespace__Group_2__0
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
    // InternalBasicsParser.g:3175:1: rule__GlobalNamespace__Group_2__0 : rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1 ;
    public final void rule__GlobalNamespace__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3179:1: ( rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1 )
            // InternalBasicsParser.g:3180:2: rule__GlobalNamespace__Group_2__0__Impl rule__GlobalNamespace__Group_2__1
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
    // InternalBasicsParser.g:3187:1: rule__GlobalNamespace__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__GlobalNamespace__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3191:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3192:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3192:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3193:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3202:1: rule__GlobalNamespace__Group_2__1 : rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2 ;
    public final void rule__GlobalNamespace__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3206:1: ( rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2 )
            // InternalBasicsParser.g:3207:2: rule__GlobalNamespace__Group_2__1__Impl rule__GlobalNamespace__Group_2__2
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
    // InternalBasicsParser.g:3214:1: rule__GlobalNamespace__Group_2__1__Impl : ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) ) ;
    public final void rule__GlobalNamespace__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3218:1: ( ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3219:1: ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3219:1: ( ( rule__GlobalNamespace__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3220:2: ( rule__GlobalNamespace__PartsAssignment_2_1 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3221:2: ( rule__GlobalNamespace__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3221:3: rule__GlobalNamespace__PartsAssignment_2_1
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
    // InternalBasicsParser.g:3229:1: rule__GlobalNamespace__Group_2__2 : rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3 ;
    public final void rule__GlobalNamespace__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3233:1: ( rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3 )
            // InternalBasicsParser.g:3234:2: rule__GlobalNamespace__Group_2__2__Impl rule__GlobalNamespace__Group_2__3
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
    // InternalBasicsParser.g:3241:1: rule__GlobalNamespace__Group_2__2__Impl : ( ( rule__GlobalNamespace__Group_2_2__0 )* ) ;
    public final void rule__GlobalNamespace__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3245:1: ( ( ( rule__GlobalNamespace__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3246:1: ( ( rule__GlobalNamespace__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3246:1: ( ( rule__GlobalNamespace__Group_2_2__0 )* )
            // InternalBasicsParser.g:3247:2: ( rule__GlobalNamespace__Group_2_2__0 )*
            {
             before(grammarAccess.getGlobalNamespaceAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3248:2: ( rule__GlobalNamespace__Group_2_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Comma) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalBasicsParser.g:3248:3: rule__GlobalNamespace__Group_2_2__0
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
    // InternalBasicsParser.g:3256:1: rule__GlobalNamespace__Group_2__3 : rule__GlobalNamespace__Group_2__3__Impl ;
    public final void rule__GlobalNamespace__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3260:1: ( rule__GlobalNamespace__Group_2__3__Impl )
            // InternalBasicsParser.g:3261:2: rule__GlobalNamespace__Group_2__3__Impl
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
    // InternalBasicsParser.g:3267:1: rule__GlobalNamespace__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__GlobalNamespace__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3271:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3272:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3272:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3273:2: RightSquareBracket
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
    // InternalBasicsParser.g:3283:1: rule__GlobalNamespace__Group_2_2__0 : rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1 ;
    public final void rule__GlobalNamespace__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3287:1: ( rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1 )
            // InternalBasicsParser.g:3288:2: rule__GlobalNamespace__Group_2_2__0__Impl rule__GlobalNamespace__Group_2_2__1
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
    // InternalBasicsParser.g:3295:1: rule__GlobalNamespace__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__GlobalNamespace__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3299:1: ( ( Comma ) )
            // InternalBasicsParser.g:3300:1: ( Comma )
            {
            // InternalBasicsParser.g:3300:1: ( Comma )
            // InternalBasicsParser.g:3301:2: Comma
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
    // InternalBasicsParser.g:3310:1: rule__GlobalNamespace__Group_2_2__1 : rule__GlobalNamespace__Group_2_2__1__Impl ;
    public final void rule__GlobalNamespace__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3314:1: ( rule__GlobalNamespace__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3315:2: rule__GlobalNamespace__Group_2_2__1__Impl
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
    // InternalBasicsParser.g:3321:1: rule__GlobalNamespace__Group_2_2__1__Impl : ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) ) ;
    public final void rule__GlobalNamespace__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3325:1: ( ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3326:1: ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3326:1: ( ( rule__GlobalNamespace__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3327:2: ( rule__GlobalNamespace__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getGlobalNamespaceAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3328:2: ( rule__GlobalNamespace__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3328:3: rule__GlobalNamespace__PartsAssignment_2_2_1
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
    // InternalBasicsParser.g:3337:1: rule__RelativeNamespace_Impl__Group__0 : rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1 ;
    public final void rule__RelativeNamespace_Impl__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3341:1: ( rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1 )
            // InternalBasicsParser.g:3342:2: rule__RelativeNamespace_Impl__Group__0__Impl rule__RelativeNamespace_Impl__Group__1
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
    // InternalBasicsParser.g:3349:1: rule__RelativeNamespace_Impl__Group__0__Impl : ( () ) ;
    public final void rule__RelativeNamespace_Impl__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3353:1: ( ( () ) )
            // InternalBasicsParser.g:3354:1: ( () )
            {
            // InternalBasicsParser.g:3354:1: ( () )
            // InternalBasicsParser.g:3355:2: ()
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0()); 
            // InternalBasicsParser.g:3356:2: ()
            // InternalBasicsParser.g:3356:3: 
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
    // InternalBasicsParser.g:3364:1: rule__RelativeNamespace_Impl__Group__1 : rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2 ;
    public final void rule__RelativeNamespace_Impl__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3368:1: ( rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2 )
            // InternalBasicsParser.g:3369:2: rule__RelativeNamespace_Impl__Group__1__Impl rule__RelativeNamespace_Impl__Group__2
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
    // InternalBasicsParser.g:3376:1: rule__RelativeNamespace_Impl__Group__1__Impl : ( RelativeNamespace ) ;
    public final void rule__RelativeNamespace_Impl__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3380:1: ( ( RelativeNamespace ) )
            // InternalBasicsParser.g:3381:1: ( RelativeNamespace )
            {
            // InternalBasicsParser.g:3381:1: ( RelativeNamespace )
            // InternalBasicsParser.g:3382:2: RelativeNamespace
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
    // InternalBasicsParser.g:3391:1: rule__RelativeNamespace_Impl__Group__2 : rule__RelativeNamespace_Impl__Group__2__Impl ;
    public final void rule__RelativeNamespace_Impl__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3395:1: ( rule__RelativeNamespace_Impl__Group__2__Impl )
            // InternalBasicsParser.g:3396:2: rule__RelativeNamespace_Impl__Group__2__Impl
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
    // InternalBasicsParser.g:3402:1: rule__RelativeNamespace_Impl__Group__2__Impl : ( ( rule__RelativeNamespace_Impl__Group_2__0 )? ) ;
    public final void rule__RelativeNamespace_Impl__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3406:1: ( ( ( rule__RelativeNamespace_Impl__Group_2__0 )? ) )
            // InternalBasicsParser.g:3407:1: ( ( rule__RelativeNamespace_Impl__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3407:1: ( ( rule__RelativeNamespace_Impl__Group_2__0 )? )
            // InternalBasicsParser.g:3408:2: ( rule__RelativeNamespace_Impl__Group_2__0 )?
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2()); 
            // InternalBasicsParser.g:3409:2: ( rule__RelativeNamespace_Impl__Group_2__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LeftSquareBracket) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBasicsParser.g:3409:3: rule__RelativeNamespace_Impl__Group_2__0
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
    // InternalBasicsParser.g:3418:1: rule__RelativeNamespace_Impl__Group_2__0 : rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1 ;
    public final void rule__RelativeNamespace_Impl__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3422:1: ( rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1 )
            // InternalBasicsParser.g:3423:2: rule__RelativeNamespace_Impl__Group_2__0__Impl rule__RelativeNamespace_Impl__Group_2__1
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
    // InternalBasicsParser.g:3430:1: rule__RelativeNamespace_Impl__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3434:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3435:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3435:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3436:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3445:1: rule__RelativeNamespace_Impl__Group_2__1 : rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2 ;
    public final void rule__RelativeNamespace_Impl__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3449:1: ( rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2 )
            // InternalBasicsParser.g:3450:2: rule__RelativeNamespace_Impl__Group_2__1__Impl rule__RelativeNamespace_Impl__Group_2__2
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
    // InternalBasicsParser.g:3457:1: rule__RelativeNamespace_Impl__Group_2__1__Impl : ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3461:1: ( ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3462:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3462:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3463:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3464:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3464:3: rule__RelativeNamespace_Impl__PartsAssignment_2_1
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
    // InternalBasicsParser.g:3472:1: rule__RelativeNamespace_Impl__Group_2__2 : rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3 ;
    public final void rule__RelativeNamespace_Impl__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3476:1: ( rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3 )
            // InternalBasicsParser.g:3477:2: rule__RelativeNamespace_Impl__Group_2__2__Impl rule__RelativeNamespace_Impl__Group_2__3
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
    // InternalBasicsParser.g:3484:1: rule__RelativeNamespace_Impl__Group_2__2__Impl : ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3488:1: ( ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3489:1: ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3489:1: ( ( rule__RelativeNamespace_Impl__Group_2_2__0 )* )
            // InternalBasicsParser.g:3490:2: ( rule__RelativeNamespace_Impl__Group_2_2__0 )*
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3491:2: ( rule__RelativeNamespace_Impl__Group_2_2__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==Comma) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBasicsParser.g:3491:3: rule__RelativeNamespace_Impl__Group_2_2__0
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
    // InternalBasicsParser.g:3499:1: rule__RelativeNamespace_Impl__Group_2__3 : rule__RelativeNamespace_Impl__Group_2__3__Impl ;
    public final void rule__RelativeNamespace_Impl__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3503:1: ( rule__RelativeNamespace_Impl__Group_2__3__Impl )
            // InternalBasicsParser.g:3504:2: rule__RelativeNamespace_Impl__Group_2__3__Impl
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
    // InternalBasicsParser.g:3510:1: rule__RelativeNamespace_Impl__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__RelativeNamespace_Impl__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3514:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3515:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3515:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3516:2: RightSquareBracket
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
    // InternalBasicsParser.g:3526:1: rule__RelativeNamespace_Impl__Group_2_2__0 : rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1 ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3530:1: ( rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1 )
            // InternalBasicsParser.g:3531:2: rule__RelativeNamespace_Impl__Group_2_2__0__Impl rule__RelativeNamespace_Impl__Group_2_2__1
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
    // InternalBasicsParser.g:3538:1: rule__RelativeNamespace_Impl__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3542:1: ( ( Comma ) )
            // InternalBasicsParser.g:3543:1: ( Comma )
            {
            // InternalBasicsParser.g:3543:1: ( Comma )
            // InternalBasicsParser.g:3544:2: Comma
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
    // InternalBasicsParser.g:3553:1: rule__RelativeNamespace_Impl__Group_2_2__1 : rule__RelativeNamespace_Impl__Group_2_2__1__Impl ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3557:1: ( rule__RelativeNamespace_Impl__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3558:2: rule__RelativeNamespace_Impl__Group_2_2__1__Impl
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
    // InternalBasicsParser.g:3564:1: rule__RelativeNamespace_Impl__Group_2_2__1__Impl : ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) ) ;
    public final void rule__RelativeNamespace_Impl__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3568:1: ( ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3569:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3569:1: ( ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3570:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getRelativeNamespace_ImplAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3571:2: ( rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3571:3: rule__RelativeNamespace_Impl__PartsAssignment_2_2_1
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
    // InternalBasicsParser.g:3580:1: rule__PrivateNamespace__Group__0 : rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1 ;
    public final void rule__PrivateNamespace__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3584:1: ( rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1 )
            // InternalBasicsParser.g:3585:2: rule__PrivateNamespace__Group__0__Impl rule__PrivateNamespace__Group__1
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
    // InternalBasicsParser.g:3592:1: rule__PrivateNamespace__Group__0__Impl : ( () ) ;
    public final void rule__PrivateNamespace__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3596:1: ( ( () ) )
            // InternalBasicsParser.g:3597:1: ( () )
            {
            // InternalBasicsParser.g:3597:1: ( () )
            // InternalBasicsParser.g:3598:2: ()
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0()); 
            // InternalBasicsParser.g:3599:2: ()
            // InternalBasicsParser.g:3599:3: 
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
    // InternalBasicsParser.g:3607:1: rule__PrivateNamespace__Group__1 : rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2 ;
    public final void rule__PrivateNamespace__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3611:1: ( rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2 )
            // InternalBasicsParser.g:3612:2: rule__PrivateNamespace__Group__1__Impl rule__PrivateNamespace__Group__2
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
    // InternalBasicsParser.g:3619:1: rule__PrivateNamespace__Group__1__Impl : ( PrivateNamespace ) ;
    public final void rule__PrivateNamespace__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3623:1: ( ( PrivateNamespace ) )
            // InternalBasicsParser.g:3624:1: ( PrivateNamespace )
            {
            // InternalBasicsParser.g:3624:1: ( PrivateNamespace )
            // InternalBasicsParser.g:3625:2: PrivateNamespace
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
    // InternalBasicsParser.g:3634:1: rule__PrivateNamespace__Group__2 : rule__PrivateNamespace__Group__2__Impl ;
    public final void rule__PrivateNamespace__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3638:1: ( rule__PrivateNamespace__Group__2__Impl )
            // InternalBasicsParser.g:3639:2: rule__PrivateNamespace__Group__2__Impl
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
    // InternalBasicsParser.g:3645:1: rule__PrivateNamespace__Group__2__Impl : ( ( rule__PrivateNamespace__Group_2__0 )? ) ;
    public final void rule__PrivateNamespace__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3649:1: ( ( ( rule__PrivateNamespace__Group_2__0 )? ) )
            // InternalBasicsParser.g:3650:1: ( ( rule__PrivateNamespace__Group_2__0 )? )
            {
            // InternalBasicsParser.g:3650:1: ( ( rule__PrivateNamespace__Group_2__0 )? )
            // InternalBasicsParser.g:3651:2: ( rule__PrivateNamespace__Group_2__0 )?
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup_2()); 
            // InternalBasicsParser.g:3652:2: ( rule__PrivateNamespace__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LeftSquareBracket) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBasicsParser.g:3652:3: rule__PrivateNamespace__Group_2__0
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
    // InternalBasicsParser.g:3661:1: rule__PrivateNamespace__Group_2__0 : rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1 ;
    public final void rule__PrivateNamespace__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3665:1: ( rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1 )
            // InternalBasicsParser.g:3666:2: rule__PrivateNamespace__Group_2__0__Impl rule__PrivateNamespace__Group_2__1
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
    // InternalBasicsParser.g:3673:1: rule__PrivateNamespace__Group_2__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__PrivateNamespace__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3677:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3678:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3678:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3679:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3688:1: rule__PrivateNamespace__Group_2__1 : rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2 ;
    public final void rule__PrivateNamespace__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3692:1: ( rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2 )
            // InternalBasicsParser.g:3693:2: rule__PrivateNamespace__Group_2__1__Impl rule__PrivateNamespace__Group_2__2
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
    // InternalBasicsParser.g:3700:1: rule__PrivateNamespace__Group_2__1__Impl : ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) ) ;
    public final void rule__PrivateNamespace__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3704:1: ( ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) ) )
            // InternalBasicsParser.g:3705:1: ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:3705:1: ( ( rule__PrivateNamespace__PartsAssignment_2_1 ) )
            // InternalBasicsParser.g:3706:2: ( rule__PrivateNamespace__PartsAssignment_2_1 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_1()); 
            // InternalBasicsParser.g:3707:2: ( rule__PrivateNamespace__PartsAssignment_2_1 )
            // InternalBasicsParser.g:3707:3: rule__PrivateNamespace__PartsAssignment_2_1
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
    // InternalBasicsParser.g:3715:1: rule__PrivateNamespace__Group_2__2 : rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3 ;
    public final void rule__PrivateNamespace__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3719:1: ( rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3 )
            // InternalBasicsParser.g:3720:2: rule__PrivateNamespace__Group_2__2__Impl rule__PrivateNamespace__Group_2__3
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
    // InternalBasicsParser.g:3727:1: rule__PrivateNamespace__Group_2__2__Impl : ( ( rule__PrivateNamespace__Group_2_2__0 )* ) ;
    public final void rule__PrivateNamespace__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3731:1: ( ( ( rule__PrivateNamespace__Group_2_2__0 )* ) )
            // InternalBasicsParser.g:3732:1: ( ( rule__PrivateNamespace__Group_2_2__0 )* )
            {
            // InternalBasicsParser.g:3732:1: ( ( rule__PrivateNamespace__Group_2_2__0 )* )
            // InternalBasicsParser.g:3733:2: ( rule__PrivateNamespace__Group_2_2__0 )*
            {
             before(grammarAccess.getPrivateNamespaceAccess().getGroup_2_2()); 
            // InternalBasicsParser.g:3734:2: ( rule__PrivateNamespace__Group_2_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Comma) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBasicsParser.g:3734:3: rule__PrivateNamespace__Group_2_2__0
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
    // InternalBasicsParser.g:3742:1: rule__PrivateNamespace__Group_2__3 : rule__PrivateNamespace__Group_2__3__Impl ;
    public final void rule__PrivateNamespace__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3746:1: ( rule__PrivateNamespace__Group_2__3__Impl )
            // InternalBasicsParser.g:3747:2: rule__PrivateNamespace__Group_2__3__Impl
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
    // InternalBasicsParser.g:3753:1: rule__PrivateNamespace__Group_2__3__Impl : ( RightSquareBracket ) ;
    public final void rule__PrivateNamespace__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3757:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3758:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3758:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3759:2: RightSquareBracket
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
    // InternalBasicsParser.g:3769:1: rule__PrivateNamespace__Group_2_2__0 : rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1 ;
    public final void rule__PrivateNamespace__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3773:1: ( rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1 )
            // InternalBasicsParser.g:3774:2: rule__PrivateNamespace__Group_2_2__0__Impl rule__PrivateNamespace__Group_2_2__1
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
    // InternalBasicsParser.g:3781:1: rule__PrivateNamespace__Group_2_2__0__Impl : ( Comma ) ;
    public final void rule__PrivateNamespace__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3785:1: ( ( Comma ) )
            // InternalBasicsParser.g:3786:1: ( Comma )
            {
            // InternalBasicsParser.g:3786:1: ( Comma )
            // InternalBasicsParser.g:3787:2: Comma
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
    // InternalBasicsParser.g:3796:1: rule__PrivateNamespace__Group_2_2__1 : rule__PrivateNamespace__Group_2_2__1__Impl ;
    public final void rule__PrivateNamespace__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3800:1: ( rule__PrivateNamespace__Group_2_2__1__Impl )
            // InternalBasicsParser.g:3801:2: rule__PrivateNamespace__Group_2_2__1__Impl
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
    // InternalBasicsParser.g:3807:1: rule__PrivateNamespace__Group_2_2__1__Impl : ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) ) ;
    public final void rule__PrivateNamespace__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3811:1: ( ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) ) )
            // InternalBasicsParser.g:3812:1: ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) )
            {
            // InternalBasicsParser.g:3812:1: ( ( rule__PrivateNamespace__PartsAssignment_2_2_1 ) )
            // InternalBasicsParser.g:3813:2: ( rule__PrivateNamespace__PartsAssignment_2_2_1 )
            {
             before(grammarAccess.getPrivateNamespaceAccess().getPartsAssignment_2_2_1()); 
            // InternalBasicsParser.g:3814:2: ( rule__PrivateNamespace__PartsAssignment_2_2_1 )
            // InternalBasicsParser.g:3814:3: rule__PrivateNamespace__PartsAssignment_2_2_1
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
    // InternalBasicsParser.g:3823:1: rule__ParameterListType__Group__0 : rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1 ;
    public final void rule__ParameterListType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3827:1: ( rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1 )
            // InternalBasicsParser.g:3828:2: rule__ParameterListType__Group__0__Impl rule__ParameterListType__Group__1
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
    // InternalBasicsParser.g:3835:1: rule__ParameterListType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterListType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3839:1: ( ( () ) )
            // InternalBasicsParser.g:3840:1: ( () )
            {
            // InternalBasicsParser.g:3840:1: ( () )
            // InternalBasicsParser.g:3841:2: ()
            {
             before(grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0()); 
            // InternalBasicsParser.g:3842:2: ()
            // InternalBasicsParser.g:3842:3: 
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
    // InternalBasicsParser.g:3850:1: rule__ParameterListType__Group__1 : rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2 ;
    public final void rule__ParameterListType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3854:1: ( rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2 )
            // InternalBasicsParser.g:3855:2: rule__ParameterListType__Group__1__Impl rule__ParameterListType__Group__2
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
    // InternalBasicsParser.g:3862:1: rule__ParameterListType__Group__1__Impl : ( List ) ;
    public final void rule__ParameterListType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3866:1: ( ( List ) )
            // InternalBasicsParser.g:3867:1: ( List )
            {
            // InternalBasicsParser.g:3867:1: ( List )
            // InternalBasicsParser.g:3868:2: List
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
    // InternalBasicsParser.g:3877:1: rule__ParameterListType__Group__2 : rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3 ;
    public final void rule__ParameterListType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3881:1: ( rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3 )
            // InternalBasicsParser.g:3882:2: rule__ParameterListType__Group__2__Impl rule__ParameterListType__Group__3
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
    // InternalBasicsParser.g:3889:1: rule__ParameterListType__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterListType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3893:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:3894:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:3894:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:3895:2: LeftSquareBracket
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
    // InternalBasicsParser.g:3904:1: rule__ParameterListType__Group__3 : rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4 ;
    public final void rule__ParameterListType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3908:1: ( rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4 )
            // InternalBasicsParser.g:3909:2: rule__ParameterListType__Group__3__Impl rule__ParameterListType__Group__4
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
    // InternalBasicsParser.g:3916:1: rule__ParameterListType__Group__3__Impl : ( ( rule__ParameterListType__SequenceAssignment_3 ) ) ;
    public final void rule__ParameterListType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3920:1: ( ( ( rule__ParameterListType__SequenceAssignment_3 ) ) )
            // InternalBasicsParser.g:3921:1: ( ( rule__ParameterListType__SequenceAssignment_3 ) )
            {
            // InternalBasicsParser.g:3921:1: ( ( rule__ParameterListType__SequenceAssignment_3 ) )
            // InternalBasicsParser.g:3922:2: ( rule__ParameterListType__SequenceAssignment_3 )
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_3()); 
            // InternalBasicsParser.g:3923:2: ( rule__ParameterListType__SequenceAssignment_3 )
            // InternalBasicsParser.g:3923:3: rule__ParameterListType__SequenceAssignment_3
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
    // InternalBasicsParser.g:3931:1: rule__ParameterListType__Group__4 : rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5 ;
    public final void rule__ParameterListType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3935:1: ( rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5 )
            // InternalBasicsParser.g:3936:2: rule__ParameterListType__Group__4__Impl rule__ParameterListType__Group__5
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
    // InternalBasicsParser.g:3943:1: rule__ParameterListType__Group__4__Impl : ( ( rule__ParameterListType__Group_4__0 )* ) ;
    public final void rule__ParameterListType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3947:1: ( ( ( rule__ParameterListType__Group_4__0 )* ) )
            // InternalBasicsParser.g:3948:1: ( ( rule__ParameterListType__Group_4__0 )* )
            {
            // InternalBasicsParser.g:3948:1: ( ( rule__ParameterListType__Group_4__0 )* )
            // InternalBasicsParser.g:3949:2: ( rule__ParameterListType__Group_4__0 )*
            {
             before(grammarAccess.getParameterListTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:3950:2: ( rule__ParameterListType__Group_4__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==Comma) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBasicsParser.g:3950:3: rule__ParameterListType__Group_4__0
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
    // InternalBasicsParser.g:3958:1: rule__ParameterListType__Group__5 : rule__ParameterListType__Group__5__Impl ;
    public final void rule__ParameterListType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3962:1: ( rule__ParameterListType__Group__5__Impl )
            // InternalBasicsParser.g:3963:2: rule__ParameterListType__Group__5__Impl
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
    // InternalBasicsParser.g:3969:1: rule__ParameterListType__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterListType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3973:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:3974:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:3974:1: ( RightSquareBracket )
            // InternalBasicsParser.g:3975:2: RightSquareBracket
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
    // InternalBasicsParser.g:3985:1: rule__ParameterListType__Group_4__0 : rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1 ;
    public final void rule__ParameterListType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:3989:1: ( rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1 )
            // InternalBasicsParser.g:3990:2: rule__ParameterListType__Group_4__0__Impl rule__ParameterListType__Group_4__1
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
    // InternalBasicsParser.g:3997:1: rule__ParameterListType__Group_4__0__Impl : ( Comma ) ;
    public final void rule__ParameterListType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4001:1: ( ( Comma ) )
            // InternalBasicsParser.g:4002:1: ( Comma )
            {
            // InternalBasicsParser.g:4002:1: ( Comma )
            // InternalBasicsParser.g:4003:2: Comma
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
    // InternalBasicsParser.g:4012:1: rule__ParameterListType__Group_4__1 : rule__ParameterListType__Group_4__1__Impl ;
    public final void rule__ParameterListType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4016:1: ( rule__ParameterListType__Group_4__1__Impl )
            // InternalBasicsParser.g:4017:2: rule__ParameterListType__Group_4__1__Impl
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
    // InternalBasicsParser.g:4023:1: rule__ParameterListType__Group_4__1__Impl : ( ( rule__ParameterListType__SequenceAssignment_4_1 ) ) ;
    public final void rule__ParameterListType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4027:1: ( ( ( rule__ParameterListType__SequenceAssignment_4_1 ) ) )
            // InternalBasicsParser.g:4028:1: ( ( rule__ParameterListType__SequenceAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:4028:1: ( ( rule__ParameterListType__SequenceAssignment_4_1 ) )
            // InternalBasicsParser.g:4029:2: ( rule__ParameterListType__SequenceAssignment_4_1 )
            {
             before(grammarAccess.getParameterListTypeAccess().getSequenceAssignment_4_1()); 
            // InternalBasicsParser.g:4030:2: ( rule__ParameterListType__SequenceAssignment_4_1 )
            // InternalBasicsParser.g:4030:3: rule__ParameterListType__SequenceAssignment_4_1
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
    // InternalBasicsParser.g:4039:1: rule__ParameterStructType__Group__0 : rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1 ;
    public final void rule__ParameterStructType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4043:1: ( rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1 )
            // InternalBasicsParser.g:4044:2: rule__ParameterStructType__Group__0__Impl rule__ParameterStructType__Group__1
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
    // InternalBasicsParser.g:4051:1: rule__ParameterStructType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStructType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4055:1: ( ( () ) )
            // InternalBasicsParser.g:4056:1: ( () )
            {
            // InternalBasicsParser.g:4056:1: ( () )
            // InternalBasicsParser.g:4057:2: ()
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0()); 
            // InternalBasicsParser.g:4058:2: ()
            // InternalBasicsParser.g:4058:3: 
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
    // InternalBasicsParser.g:4066:1: rule__ParameterStructType__Group__1 : rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2 ;
    public final void rule__ParameterStructType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4070:1: ( rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2 )
            // InternalBasicsParser.g:4071:2: rule__ParameterStructType__Group__1__Impl rule__ParameterStructType__Group__2
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
    // InternalBasicsParser.g:4078:1: rule__ParameterStructType__Group__1__Impl : ( Struct ) ;
    public final void rule__ParameterStructType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4082:1: ( ( Struct ) )
            // InternalBasicsParser.g:4083:1: ( Struct )
            {
            // InternalBasicsParser.g:4083:1: ( Struct )
            // InternalBasicsParser.g:4084:2: Struct
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
    // InternalBasicsParser.g:4093:1: rule__ParameterStructType__Group__2 : rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3 ;
    public final void rule__ParameterStructType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4097:1: ( rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3 )
            // InternalBasicsParser.g:4098:2: rule__ParameterStructType__Group__2__Impl rule__ParameterStructType__Group__3
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
    // InternalBasicsParser.g:4105:1: rule__ParameterStructType__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterStructType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4109:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:4110:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:4110:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:4111:2: LeftSquareBracket
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
    // InternalBasicsParser.g:4120:1: rule__ParameterStructType__Group__3 : rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4 ;
    public final void rule__ParameterStructType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4124:1: ( rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4 )
            // InternalBasicsParser.g:4125:2: rule__ParameterStructType__Group__3__Impl rule__ParameterStructType__Group__4
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
    // InternalBasicsParser.g:4132:1: rule__ParameterStructType__Group__3__Impl : ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) ) ;
    public final void rule__ParameterStructType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4136:1: ( ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) ) )
            // InternalBasicsParser.g:4137:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) )
            {
            // InternalBasicsParser.g:4137:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 ) )
            // InternalBasicsParser.g:4138:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_3()); 
            // InternalBasicsParser.g:4139:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_3 )
            // InternalBasicsParser.g:4139:3: rule__ParameterStructType__ParameterstructypetmemberAssignment_3
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
    // InternalBasicsParser.g:4147:1: rule__ParameterStructType__Group__4 : rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5 ;
    public final void rule__ParameterStructType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4151:1: ( rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5 )
            // InternalBasicsParser.g:4152:2: rule__ParameterStructType__Group__4__Impl rule__ParameterStructType__Group__5
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
    // InternalBasicsParser.g:4159:1: rule__ParameterStructType__Group__4__Impl : ( ( rule__ParameterStructType__Group_4__0 )* ) ;
    public final void rule__ParameterStructType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4163:1: ( ( ( rule__ParameterStructType__Group_4__0 )* ) )
            // InternalBasicsParser.g:4164:1: ( ( rule__ParameterStructType__Group_4__0 )* )
            {
            // InternalBasicsParser.g:4164:1: ( ( rule__ParameterStructType__Group_4__0 )* )
            // InternalBasicsParser.g:4165:2: ( rule__ParameterStructType__Group_4__0 )*
            {
             before(grammarAccess.getParameterStructTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:4166:2: ( rule__ParameterStructType__Group_4__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Comma) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBasicsParser.g:4166:3: rule__ParameterStructType__Group_4__0
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
    // InternalBasicsParser.g:4174:1: rule__ParameterStructType__Group__5 : rule__ParameterStructType__Group__5__Impl ;
    public final void rule__ParameterStructType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4178:1: ( rule__ParameterStructType__Group__5__Impl )
            // InternalBasicsParser.g:4179:2: rule__ParameterStructType__Group__5__Impl
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
    // InternalBasicsParser.g:4185:1: rule__ParameterStructType__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterStructType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4189:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:4190:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:4190:1: ( RightSquareBracket )
            // InternalBasicsParser.g:4191:2: RightSquareBracket
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
    // InternalBasicsParser.g:4201:1: rule__ParameterStructType__Group_4__0 : rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1 ;
    public final void rule__ParameterStructType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4205:1: ( rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1 )
            // InternalBasicsParser.g:4206:2: rule__ParameterStructType__Group_4__0__Impl rule__ParameterStructType__Group_4__1
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
    // InternalBasicsParser.g:4213:1: rule__ParameterStructType__Group_4__0__Impl : ( Comma ) ;
    public final void rule__ParameterStructType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4217:1: ( ( Comma ) )
            // InternalBasicsParser.g:4218:1: ( Comma )
            {
            // InternalBasicsParser.g:4218:1: ( Comma )
            // InternalBasicsParser.g:4219:2: Comma
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
    // InternalBasicsParser.g:4228:1: rule__ParameterStructType__Group_4__1 : rule__ParameterStructType__Group_4__1__Impl ;
    public final void rule__ParameterStructType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4232:1: ( rule__ParameterStructType__Group_4__1__Impl )
            // InternalBasicsParser.g:4233:2: rule__ParameterStructType__Group_4__1__Impl
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
    // InternalBasicsParser.g:4239:1: rule__ParameterStructType__Group_4__1__Impl : ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) ) ;
    public final void rule__ParameterStructType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4243:1: ( ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) ) )
            // InternalBasicsParser.g:4244:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:4244:1: ( ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 ) )
            // InternalBasicsParser.g:4245:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 )
            {
             before(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberAssignment_4_1()); 
            // InternalBasicsParser.g:4246:2: ( rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 )
            // InternalBasicsParser.g:4246:3: rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1
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
    // InternalBasicsParser.g:4255:1: rule__ParameterIntegerType__Group__0 : rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1 ;
    public final void rule__ParameterIntegerType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4259:1: ( rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1 )
            // InternalBasicsParser.g:4260:2: rule__ParameterIntegerType__Group__0__Impl rule__ParameterIntegerType__Group__1
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
    // InternalBasicsParser.g:4267:1: rule__ParameterIntegerType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterIntegerType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4271:1: ( ( () ) )
            // InternalBasicsParser.g:4272:1: ( () )
            {
            // InternalBasicsParser.g:4272:1: ( () )
            // InternalBasicsParser.g:4273:2: ()
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0()); 
            // InternalBasicsParser.g:4274:2: ()
            // InternalBasicsParser.g:4274:3: 
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
    // InternalBasicsParser.g:4282:1: rule__ParameterIntegerType__Group__1 : rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2 ;
    public final void rule__ParameterIntegerType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4286:1: ( rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2 )
            // InternalBasicsParser.g:4287:2: rule__ParameterIntegerType__Group__1__Impl rule__ParameterIntegerType__Group__2
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
    // InternalBasicsParser.g:4294:1: rule__ParameterIntegerType__Group__1__Impl : ( Integer ) ;
    public final void rule__ParameterIntegerType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4298:1: ( ( Integer ) )
            // InternalBasicsParser.g:4299:1: ( Integer )
            {
            // InternalBasicsParser.g:4299:1: ( Integer )
            // InternalBasicsParser.g:4300:2: Integer
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
    // InternalBasicsParser.g:4309:1: rule__ParameterIntegerType__Group__2 : rule__ParameterIntegerType__Group__2__Impl ;
    public final void rule__ParameterIntegerType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4313:1: ( rule__ParameterIntegerType__Group__2__Impl )
            // InternalBasicsParser.g:4314:2: rule__ParameterIntegerType__Group__2__Impl
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
    // InternalBasicsParser.g:4320:1: rule__ParameterIntegerType__Group__2__Impl : ( ( rule__ParameterIntegerType__Group_2__0 )? ) ;
    public final void rule__ParameterIntegerType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4324:1: ( ( ( rule__ParameterIntegerType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4325:1: ( ( rule__ParameterIntegerType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4325:1: ( ( rule__ParameterIntegerType__Group_2__0 )? )
            // InternalBasicsParser.g:4326:2: ( rule__ParameterIntegerType__Group_2__0 )?
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4327:2: ( rule__ParameterIntegerType__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Default) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBasicsParser.g:4327:3: rule__ParameterIntegerType__Group_2__0
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
    // InternalBasicsParser.g:4336:1: rule__ParameterIntegerType__Group_2__0 : rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1 ;
    public final void rule__ParameterIntegerType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4340:1: ( rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1 )
            // InternalBasicsParser.g:4341:2: rule__ParameterIntegerType__Group_2__0__Impl rule__ParameterIntegerType__Group_2__1
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
    // InternalBasicsParser.g:4348:1: rule__ParameterIntegerType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterIntegerType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4352:1: ( ( Default ) )
            // InternalBasicsParser.g:4353:1: ( Default )
            {
            // InternalBasicsParser.g:4353:1: ( Default )
            // InternalBasicsParser.g:4354:2: Default
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
    // InternalBasicsParser.g:4363:1: rule__ParameterIntegerType__Group_2__1 : rule__ParameterIntegerType__Group_2__1__Impl ;
    public final void rule__ParameterIntegerType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4367:1: ( rule__ParameterIntegerType__Group_2__1__Impl )
            // InternalBasicsParser.g:4368:2: rule__ParameterIntegerType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4374:1: rule__ParameterIntegerType__Group_2__1__Impl : ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterIntegerType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4378:1: ( ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4379:1: ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4379:1: ( ( rule__ParameterIntegerType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4380:2: ( rule__ParameterIntegerType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterIntegerTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4381:2: ( rule__ParameterIntegerType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4381:3: rule__ParameterIntegerType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4390:1: rule__ParameterStringType__Group__0 : rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1 ;
    public final void rule__ParameterStringType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4394:1: ( rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1 )
            // InternalBasicsParser.g:4395:2: rule__ParameterStringType__Group__0__Impl rule__ParameterStringType__Group__1
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
    // InternalBasicsParser.g:4402:1: rule__ParameterStringType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStringType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4406:1: ( ( () ) )
            // InternalBasicsParser.g:4407:1: ( () )
            {
            // InternalBasicsParser.g:4407:1: ( () )
            // InternalBasicsParser.g:4408:2: ()
            {
             before(grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0()); 
            // InternalBasicsParser.g:4409:2: ()
            // InternalBasicsParser.g:4409:3: 
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
    // InternalBasicsParser.g:4417:1: rule__ParameterStringType__Group__1 : rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2 ;
    public final void rule__ParameterStringType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4421:1: ( rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2 )
            // InternalBasicsParser.g:4422:2: rule__ParameterStringType__Group__1__Impl rule__ParameterStringType__Group__2
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
    // InternalBasicsParser.g:4429:1: rule__ParameterStringType__Group__1__Impl : ( String ) ;
    public final void rule__ParameterStringType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4433:1: ( ( String ) )
            // InternalBasicsParser.g:4434:1: ( String )
            {
            // InternalBasicsParser.g:4434:1: ( String )
            // InternalBasicsParser.g:4435:2: String
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
    // InternalBasicsParser.g:4444:1: rule__ParameterStringType__Group__2 : rule__ParameterStringType__Group__2__Impl ;
    public final void rule__ParameterStringType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4448:1: ( rule__ParameterStringType__Group__2__Impl )
            // InternalBasicsParser.g:4449:2: rule__ParameterStringType__Group__2__Impl
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
    // InternalBasicsParser.g:4455:1: rule__ParameterStringType__Group__2__Impl : ( ( rule__ParameterStringType__Group_2__0 )? ) ;
    public final void rule__ParameterStringType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4459:1: ( ( ( rule__ParameterStringType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4460:1: ( ( rule__ParameterStringType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4460:1: ( ( rule__ParameterStringType__Group_2__0 )? )
            // InternalBasicsParser.g:4461:2: ( rule__ParameterStringType__Group_2__0 )?
            {
             before(grammarAccess.getParameterStringTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4462:2: ( rule__ParameterStringType__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Default) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBasicsParser.g:4462:3: rule__ParameterStringType__Group_2__0
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
    // InternalBasicsParser.g:4471:1: rule__ParameterStringType__Group_2__0 : rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1 ;
    public final void rule__ParameterStringType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4475:1: ( rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1 )
            // InternalBasicsParser.g:4476:2: rule__ParameterStringType__Group_2__0__Impl rule__ParameterStringType__Group_2__1
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
    // InternalBasicsParser.g:4483:1: rule__ParameterStringType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterStringType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4487:1: ( ( Default ) )
            // InternalBasicsParser.g:4488:1: ( Default )
            {
            // InternalBasicsParser.g:4488:1: ( Default )
            // InternalBasicsParser.g:4489:2: Default
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
    // InternalBasicsParser.g:4498:1: rule__ParameterStringType__Group_2__1 : rule__ParameterStringType__Group_2__1__Impl ;
    public final void rule__ParameterStringType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4502:1: ( rule__ParameterStringType__Group_2__1__Impl )
            // InternalBasicsParser.g:4503:2: rule__ParameterStringType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4509:1: rule__ParameterStringType__Group_2__1__Impl : ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterStringType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4513:1: ( ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4514:1: ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4514:1: ( ( rule__ParameterStringType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4515:2: ( rule__ParameterStringType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterStringTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4516:2: ( rule__ParameterStringType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4516:3: rule__ParameterStringType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4525:1: rule__ParameterDoubleType__Group__0 : rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1 ;
    public final void rule__ParameterDoubleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4529:1: ( rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1 )
            // InternalBasicsParser.g:4530:2: rule__ParameterDoubleType__Group__0__Impl rule__ParameterDoubleType__Group__1
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
    // InternalBasicsParser.g:4537:1: rule__ParameterDoubleType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterDoubleType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4541:1: ( ( () ) )
            // InternalBasicsParser.g:4542:1: ( () )
            {
            // InternalBasicsParser.g:4542:1: ( () )
            // InternalBasicsParser.g:4543:2: ()
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0()); 
            // InternalBasicsParser.g:4544:2: ()
            // InternalBasicsParser.g:4544:3: 
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
    // InternalBasicsParser.g:4552:1: rule__ParameterDoubleType__Group__1 : rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2 ;
    public final void rule__ParameterDoubleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4556:1: ( rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2 )
            // InternalBasicsParser.g:4557:2: rule__ParameterDoubleType__Group__1__Impl rule__ParameterDoubleType__Group__2
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
    // InternalBasicsParser.g:4564:1: rule__ParameterDoubleType__Group__1__Impl : ( Double ) ;
    public final void rule__ParameterDoubleType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4568:1: ( ( Double ) )
            // InternalBasicsParser.g:4569:1: ( Double )
            {
            // InternalBasicsParser.g:4569:1: ( Double )
            // InternalBasicsParser.g:4570:2: Double
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
    // InternalBasicsParser.g:4579:1: rule__ParameterDoubleType__Group__2 : rule__ParameterDoubleType__Group__2__Impl ;
    public final void rule__ParameterDoubleType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4583:1: ( rule__ParameterDoubleType__Group__2__Impl )
            // InternalBasicsParser.g:4584:2: rule__ParameterDoubleType__Group__2__Impl
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
    // InternalBasicsParser.g:4590:1: rule__ParameterDoubleType__Group__2__Impl : ( ( rule__ParameterDoubleType__Group_2__0 )? ) ;
    public final void rule__ParameterDoubleType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4594:1: ( ( ( rule__ParameterDoubleType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4595:1: ( ( rule__ParameterDoubleType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4595:1: ( ( rule__ParameterDoubleType__Group_2__0 )? )
            // InternalBasicsParser.g:4596:2: ( rule__ParameterDoubleType__Group_2__0 )?
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4597:2: ( rule__ParameterDoubleType__Group_2__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Default) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBasicsParser.g:4597:3: rule__ParameterDoubleType__Group_2__0
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
    // InternalBasicsParser.g:4606:1: rule__ParameterDoubleType__Group_2__0 : rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1 ;
    public final void rule__ParameterDoubleType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4610:1: ( rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1 )
            // InternalBasicsParser.g:4611:2: rule__ParameterDoubleType__Group_2__0__Impl rule__ParameterDoubleType__Group_2__1
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
    // InternalBasicsParser.g:4618:1: rule__ParameterDoubleType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterDoubleType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4622:1: ( ( Default ) )
            // InternalBasicsParser.g:4623:1: ( Default )
            {
            // InternalBasicsParser.g:4623:1: ( Default )
            // InternalBasicsParser.g:4624:2: Default
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
    // InternalBasicsParser.g:4633:1: rule__ParameterDoubleType__Group_2__1 : rule__ParameterDoubleType__Group_2__1__Impl ;
    public final void rule__ParameterDoubleType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4637:1: ( rule__ParameterDoubleType__Group_2__1__Impl )
            // InternalBasicsParser.g:4638:2: rule__ParameterDoubleType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4644:1: rule__ParameterDoubleType__Group_2__1__Impl : ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterDoubleType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4648:1: ( ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4649:1: ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4649:1: ( ( rule__ParameterDoubleType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4650:2: ( rule__ParameterDoubleType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterDoubleTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4651:2: ( rule__ParameterDoubleType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4651:3: rule__ParameterDoubleType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4660:1: rule__ParameterBooleanType__Group__0 : rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1 ;
    public final void rule__ParameterBooleanType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4664:1: ( rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1 )
            // InternalBasicsParser.g:4665:2: rule__ParameterBooleanType__Group__0__Impl rule__ParameterBooleanType__Group__1
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
    // InternalBasicsParser.g:4672:1: rule__ParameterBooleanType__Group__0__Impl : ( () ) ;
    public final void rule__ParameterBooleanType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4676:1: ( ( () ) )
            // InternalBasicsParser.g:4677:1: ( () )
            {
            // InternalBasicsParser.g:4677:1: ( () )
            // InternalBasicsParser.g:4678:2: ()
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0()); 
            // InternalBasicsParser.g:4679:2: ()
            // InternalBasicsParser.g:4679:3: 
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
    // InternalBasicsParser.g:4687:1: rule__ParameterBooleanType__Group__1 : rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2 ;
    public final void rule__ParameterBooleanType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4691:1: ( rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2 )
            // InternalBasicsParser.g:4692:2: rule__ParameterBooleanType__Group__1__Impl rule__ParameterBooleanType__Group__2
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
    // InternalBasicsParser.g:4699:1: rule__ParameterBooleanType__Group__1__Impl : ( Boolean ) ;
    public final void rule__ParameterBooleanType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4703:1: ( ( Boolean ) )
            // InternalBasicsParser.g:4704:1: ( Boolean )
            {
            // InternalBasicsParser.g:4704:1: ( Boolean )
            // InternalBasicsParser.g:4705:2: Boolean
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
    // InternalBasicsParser.g:4714:1: rule__ParameterBooleanType__Group__2 : rule__ParameterBooleanType__Group__2__Impl ;
    public final void rule__ParameterBooleanType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4718:1: ( rule__ParameterBooleanType__Group__2__Impl )
            // InternalBasicsParser.g:4719:2: rule__ParameterBooleanType__Group__2__Impl
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
    // InternalBasicsParser.g:4725:1: rule__ParameterBooleanType__Group__2__Impl : ( ( rule__ParameterBooleanType__Group_2__0 )? ) ;
    public final void rule__ParameterBooleanType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4729:1: ( ( ( rule__ParameterBooleanType__Group_2__0 )? ) )
            // InternalBasicsParser.g:4730:1: ( ( rule__ParameterBooleanType__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4730:1: ( ( rule__ParameterBooleanType__Group_2__0 )? )
            // InternalBasicsParser.g:4731:2: ( rule__ParameterBooleanType__Group_2__0 )?
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4732:2: ( rule__ParameterBooleanType__Group_2__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Default) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBasicsParser.g:4732:3: rule__ParameterBooleanType__Group_2__0
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
    // InternalBasicsParser.g:4741:1: rule__ParameterBooleanType__Group_2__0 : rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1 ;
    public final void rule__ParameterBooleanType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4745:1: ( rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1 )
            // InternalBasicsParser.g:4746:2: rule__ParameterBooleanType__Group_2__0__Impl rule__ParameterBooleanType__Group_2__1
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
    // InternalBasicsParser.g:4753:1: rule__ParameterBooleanType__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterBooleanType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4757:1: ( ( Default ) )
            // InternalBasicsParser.g:4758:1: ( Default )
            {
            // InternalBasicsParser.g:4758:1: ( Default )
            // InternalBasicsParser.g:4759:2: Default
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
    // InternalBasicsParser.g:4768:1: rule__ParameterBooleanType__Group_2__1 : rule__ParameterBooleanType__Group_2__1__Impl ;
    public final void rule__ParameterBooleanType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4772:1: ( rule__ParameterBooleanType__Group_2__1__Impl )
            // InternalBasicsParser.g:4773:2: rule__ParameterBooleanType__Group_2__1__Impl
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
    // InternalBasicsParser.g:4779:1: rule__ParameterBooleanType__Group_2__1__Impl : ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterBooleanType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4783:1: ( ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4784:1: ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4784:1: ( ( rule__ParameterBooleanType__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4785:2: ( rule__ParameterBooleanType__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterBooleanTypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4786:2: ( rule__ParameterBooleanType__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4786:3: rule__ParameterBooleanType__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4795:1: rule__ParameterBase64Type__Group__0 : rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1 ;
    public final void rule__ParameterBase64Type__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4799:1: ( rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1 )
            // InternalBasicsParser.g:4800:2: rule__ParameterBase64Type__Group__0__Impl rule__ParameterBase64Type__Group__1
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
    // InternalBasicsParser.g:4807:1: rule__ParameterBase64Type__Group__0__Impl : ( () ) ;
    public final void rule__ParameterBase64Type__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4811:1: ( ( () ) )
            // InternalBasicsParser.g:4812:1: ( () )
            {
            // InternalBasicsParser.g:4812:1: ( () )
            // InternalBasicsParser.g:4813:2: ()
            {
             before(grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0()); 
            // InternalBasicsParser.g:4814:2: ()
            // InternalBasicsParser.g:4814:3: 
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
    // InternalBasicsParser.g:4822:1: rule__ParameterBase64Type__Group__1 : rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2 ;
    public final void rule__ParameterBase64Type__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4826:1: ( rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2 )
            // InternalBasicsParser.g:4827:2: rule__ParameterBase64Type__Group__1__Impl rule__ParameterBase64Type__Group__2
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
    // InternalBasicsParser.g:4834:1: rule__ParameterBase64Type__Group__1__Impl : ( Base64 ) ;
    public final void rule__ParameterBase64Type__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4838:1: ( ( Base64 ) )
            // InternalBasicsParser.g:4839:1: ( Base64 )
            {
            // InternalBasicsParser.g:4839:1: ( Base64 )
            // InternalBasicsParser.g:4840:2: Base64
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
    // InternalBasicsParser.g:4849:1: rule__ParameterBase64Type__Group__2 : rule__ParameterBase64Type__Group__2__Impl ;
    public final void rule__ParameterBase64Type__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4853:1: ( rule__ParameterBase64Type__Group__2__Impl )
            // InternalBasicsParser.g:4854:2: rule__ParameterBase64Type__Group__2__Impl
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
    // InternalBasicsParser.g:4860:1: rule__ParameterBase64Type__Group__2__Impl : ( ( rule__ParameterBase64Type__Group_2__0 )? ) ;
    public final void rule__ParameterBase64Type__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4864:1: ( ( ( rule__ParameterBase64Type__Group_2__0 )? ) )
            // InternalBasicsParser.g:4865:1: ( ( rule__ParameterBase64Type__Group_2__0 )? )
            {
            // InternalBasicsParser.g:4865:1: ( ( rule__ParameterBase64Type__Group_2__0 )? )
            // InternalBasicsParser.g:4866:2: ( rule__ParameterBase64Type__Group_2__0 )?
            {
             before(grammarAccess.getParameterBase64TypeAccess().getGroup_2()); 
            // InternalBasicsParser.g:4867:2: ( rule__ParameterBase64Type__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Default) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalBasicsParser.g:4867:3: rule__ParameterBase64Type__Group_2__0
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
    // InternalBasicsParser.g:4876:1: rule__ParameterBase64Type__Group_2__0 : rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1 ;
    public final void rule__ParameterBase64Type__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4880:1: ( rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1 )
            // InternalBasicsParser.g:4881:2: rule__ParameterBase64Type__Group_2__0__Impl rule__ParameterBase64Type__Group_2__1
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
    // InternalBasicsParser.g:4888:1: rule__ParameterBase64Type__Group_2__0__Impl : ( Default ) ;
    public final void rule__ParameterBase64Type__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4892:1: ( ( Default ) )
            // InternalBasicsParser.g:4893:1: ( Default )
            {
            // InternalBasicsParser.g:4893:1: ( Default )
            // InternalBasicsParser.g:4894:2: Default
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
    // InternalBasicsParser.g:4903:1: rule__ParameterBase64Type__Group_2__1 : rule__ParameterBase64Type__Group_2__1__Impl ;
    public final void rule__ParameterBase64Type__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4907:1: ( rule__ParameterBase64Type__Group_2__1__Impl )
            // InternalBasicsParser.g:4908:2: rule__ParameterBase64Type__Group_2__1__Impl
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
    // InternalBasicsParser.g:4914:1: rule__ParameterBase64Type__Group_2__1__Impl : ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) ) ;
    public final void rule__ParameterBase64Type__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4918:1: ( ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) ) )
            // InternalBasicsParser.g:4919:1: ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:4919:1: ( ( rule__ParameterBase64Type__DefaultAssignment_2_1 ) )
            // InternalBasicsParser.g:4920:2: ( rule__ParameterBase64Type__DefaultAssignment_2_1 )
            {
             before(grammarAccess.getParameterBase64TypeAccess().getDefaultAssignment_2_1()); 
            // InternalBasicsParser.g:4921:2: ( rule__ParameterBase64Type__DefaultAssignment_2_1 )
            // InternalBasicsParser.g:4921:3: rule__ParameterBase64Type__DefaultAssignment_2_1
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
    // InternalBasicsParser.g:4930:1: rule__ParameterArrayType__Group__0 : rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1 ;
    public final void rule__ParameterArrayType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4934:1: ( rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1 )
            // InternalBasicsParser.g:4935:2: rule__ParameterArrayType__Group__0__Impl rule__ParameterArrayType__Group__1
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
    // InternalBasicsParser.g:4942:1: rule__ParameterArrayType__Group__0__Impl : ( Array ) ;
    public final void rule__ParameterArrayType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4946:1: ( ( Array ) )
            // InternalBasicsParser.g:4947:1: ( Array )
            {
            // InternalBasicsParser.g:4947:1: ( Array )
            // InternalBasicsParser.g:4948:2: Array
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
    // InternalBasicsParser.g:4957:1: rule__ParameterArrayType__Group__1 : rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2 ;
    public final void rule__ParameterArrayType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4961:1: ( rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2 )
            // InternalBasicsParser.g:4962:2: rule__ParameterArrayType__Group__1__Impl rule__ParameterArrayType__Group__2
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
    // InternalBasicsParser.g:4969:1: rule__ParameterArrayType__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterArrayType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4973:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:4974:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:4974:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:4975:2: LeftSquareBracket
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
    // InternalBasicsParser.g:4984:1: rule__ParameterArrayType__Group__2 : rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3 ;
    public final void rule__ParameterArrayType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:4988:1: ( rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3 )
            // InternalBasicsParser.g:4989:2: rule__ParameterArrayType__Group__2__Impl rule__ParameterArrayType__Group__3
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
    // InternalBasicsParser.g:4996:1: rule__ParameterArrayType__Group__2__Impl : ( ( rule__ParameterArrayType__TypeAssignment_2 ) ) ;
    public final void rule__ParameterArrayType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5000:1: ( ( ( rule__ParameterArrayType__TypeAssignment_2 ) ) )
            // InternalBasicsParser.g:5001:1: ( ( rule__ParameterArrayType__TypeAssignment_2 ) )
            {
            // InternalBasicsParser.g:5001:1: ( ( rule__ParameterArrayType__TypeAssignment_2 ) )
            // InternalBasicsParser.g:5002:2: ( rule__ParameterArrayType__TypeAssignment_2 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getTypeAssignment_2()); 
            // InternalBasicsParser.g:5003:2: ( rule__ParameterArrayType__TypeAssignment_2 )
            // InternalBasicsParser.g:5003:3: rule__ParameterArrayType__TypeAssignment_2
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
    // InternalBasicsParser.g:5011:1: rule__ParameterArrayType__Group__3 : rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4 ;
    public final void rule__ParameterArrayType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5015:1: ( rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4 )
            // InternalBasicsParser.g:5016:2: rule__ParameterArrayType__Group__3__Impl rule__ParameterArrayType__Group__4
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
    // InternalBasicsParser.g:5023:1: rule__ParameterArrayType__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterArrayType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5027:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5028:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5028:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5029:2: RightSquareBracket
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
    // InternalBasicsParser.g:5038:1: rule__ParameterArrayType__Group__4 : rule__ParameterArrayType__Group__4__Impl ;
    public final void rule__ParameterArrayType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5042:1: ( rule__ParameterArrayType__Group__4__Impl )
            // InternalBasicsParser.g:5043:2: rule__ParameterArrayType__Group__4__Impl
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
    // InternalBasicsParser.g:5049:1: rule__ParameterArrayType__Group__4__Impl : ( ( rule__ParameterArrayType__Group_4__0 )? ) ;
    public final void rule__ParameterArrayType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5053:1: ( ( ( rule__ParameterArrayType__Group_4__0 )? ) )
            // InternalBasicsParser.g:5054:1: ( ( rule__ParameterArrayType__Group_4__0 )? )
            {
            // InternalBasicsParser.g:5054:1: ( ( rule__ParameterArrayType__Group_4__0 )? )
            // InternalBasicsParser.g:5055:2: ( rule__ParameterArrayType__Group_4__0 )?
            {
             before(grammarAccess.getParameterArrayTypeAccess().getGroup_4()); 
            // InternalBasicsParser.g:5056:2: ( rule__ParameterArrayType__Group_4__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==Default) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBasicsParser.g:5056:3: rule__ParameterArrayType__Group_4__0
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
    // InternalBasicsParser.g:5065:1: rule__ParameterArrayType__Group_4__0 : rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1 ;
    public final void rule__ParameterArrayType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5069:1: ( rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1 )
            // InternalBasicsParser.g:5070:2: rule__ParameterArrayType__Group_4__0__Impl rule__ParameterArrayType__Group_4__1
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
    // InternalBasicsParser.g:5077:1: rule__ParameterArrayType__Group_4__0__Impl : ( Default ) ;
    public final void rule__ParameterArrayType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5081:1: ( ( Default ) )
            // InternalBasicsParser.g:5082:1: ( Default )
            {
            // InternalBasicsParser.g:5082:1: ( Default )
            // InternalBasicsParser.g:5083:2: Default
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
    // InternalBasicsParser.g:5092:1: rule__ParameterArrayType__Group_4__1 : rule__ParameterArrayType__Group_4__1__Impl ;
    public final void rule__ParameterArrayType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5096:1: ( rule__ParameterArrayType__Group_4__1__Impl )
            // InternalBasicsParser.g:5097:2: rule__ParameterArrayType__Group_4__1__Impl
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
    // InternalBasicsParser.g:5103:1: rule__ParameterArrayType__Group_4__1__Impl : ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) ) ;
    public final void rule__ParameterArrayType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5107:1: ( ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) ) )
            // InternalBasicsParser.g:5108:1: ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) )
            {
            // InternalBasicsParser.g:5108:1: ( ( rule__ParameterArrayType__DefaultAssignment_4_1 ) )
            // InternalBasicsParser.g:5109:2: ( rule__ParameterArrayType__DefaultAssignment_4_1 )
            {
             before(grammarAccess.getParameterArrayTypeAccess().getDefaultAssignment_4_1()); 
            // InternalBasicsParser.g:5110:2: ( rule__ParameterArrayType__DefaultAssignment_4_1 )
            // InternalBasicsParser.g:5110:3: rule__ParameterArrayType__DefaultAssignment_4_1
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
    // InternalBasicsParser.g:5119:1: rule__ParameterList__Group__0 : rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1 ;
    public final void rule__ParameterList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5123:1: ( rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1 )
            // InternalBasicsParser.g:5124:2: rule__ParameterList__Group__0__Impl rule__ParameterList__Group__1
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
    // InternalBasicsParser.g:5131:1: rule__ParameterList__Group__0__Impl : ( () ) ;
    public final void rule__ParameterList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5135:1: ( ( () ) )
            // InternalBasicsParser.g:5136:1: ( () )
            {
            // InternalBasicsParser.g:5136:1: ( () )
            // InternalBasicsParser.g:5137:2: ()
            {
             before(grammarAccess.getParameterListAccess().getParameterSequenceAction_0()); 
            // InternalBasicsParser.g:5138:2: ()
            // InternalBasicsParser.g:5138:3: 
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
    // InternalBasicsParser.g:5146:1: rule__ParameterList__Group__1 : rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2 ;
    public final void rule__ParameterList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5150:1: ( rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2 )
            // InternalBasicsParser.g:5151:2: rule__ParameterList__Group__1__Impl rule__ParameterList__Group__2
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
    // InternalBasicsParser.g:5158:1: rule__ParameterList__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5162:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:5163:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:5163:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:5164:2: LeftSquareBracket
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
    // InternalBasicsParser.g:5173:1: rule__ParameterList__Group__2 : rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3 ;
    public final void rule__ParameterList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5177:1: ( rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3 )
            // InternalBasicsParser.g:5178:2: rule__ParameterList__Group__2__Impl rule__ParameterList__Group__3
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
    // InternalBasicsParser.g:5185:1: rule__ParameterList__Group__2__Impl : ( ( rule__ParameterList__ValueAssignment_2 ) ) ;
    public final void rule__ParameterList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5189:1: ( ( ( rule__ParameterList__ValueAssignment_2 ) ) )
            // InternalBasicsParser.g:5190:1: ( ( rule__ParameterList__ValueAssignment_2 ) )
            {
            // InternalBasicsParser.g:5190:1: ( ( rule__ParameterList__ValueAssignment_2 ) )
            // InternalBasicsParser.g:5191:2: ( rule__ParameterList__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterListAccess().getValueAssignment_2()); 
            // InternalBasicsParser.g:5192:2: ( rule__ParameterList__ValueAssignment_2 )
            // InternalBasicsParser.g:5192:3: rule__ParameterList__ValueAssignment_2
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
    // InternalBasicsParser.g:5200:1: rule__ParameterList__Group__3 : rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4 ;
    public final void rule__ParameterList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5204:1: ( rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4 )
            // InternalBasicsParser.g:5205:2: rule__ParameterList__Group__3__Impl rule__ParameterList__Group__4
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
    // InternalBasicsParser.g:5212:1: rule__ParameterList__Group__3__Impl : ( ( rule__ParameterList__Group_3__0 )* ) ;
    public final void rule__ParameterList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5216:1: ( ( ( rule__ParameterList__Group_3__0 )* ) )
            // InternalBasicsParser.g:5217:1: ( ( rule__ParameterList__Group_3__0 )* )
            {
            // InternalBasicsParser.g:5217:1: ( ( rule__ParameterList__Group_3__0 )* )
            // InternalBasicsParser.g:5218:2: ( rule__ParameterList__Group_3__0 )*
            {
             before(grammarAccess.getParameterListAccess().getGroup_3()); 
            // InternalBasicsParser.g:5219:2: ( rule__ParameterList__Group_3__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==Comma) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBasicsParser.g:5219:3: rule__ParameterList__Group_3__0
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
    // InternalBasicsParser.g:5227:1: rule__ParameterList__Group__4 : rule__ParameterList__Group__4__Impl ;
    public final void rule__ParameterList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5231:1: ( rule__ParameterList__Group__4__Impl )
            // InternalBasicsParser.g:5232:2: rule__ParameterList__Group__4__Impl
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
    // InternalBasicsParser.g:5238:1: rule__ParameterList__Group__4__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5242:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5243:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5243:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5244:2: RightSquareBracket
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
    // InternalBasicsParser.g:5254:1: rule__ParameterList__Group_3__0 : rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1 ;
    public final void rule__ParameterList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5258:1: ( rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1 )
            // InternalBasicsParser.g:5259:2: rule__ParameterList__Group_3__0__Impl rule__ParameterList__Group_3__1
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
    // InternalBasicsParser.g:5266:1: rule__ParameterList__Group_3__0__Impl : ( Comma ) ;
    public final void rule__ParameterList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5270:1: ( ( Comma ) )
            // InternalBasicsParser.g:5271:1: ( Comma )
            {
            // InternalBasicsParser.g:5271:1: ( Comma )
            // InternalBasicsParser.g:5272:2: Comma
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
    // InternalBasicsParser.g:5281:1: rule__ParameterList__Group_3__1 : rule__ParameterList__Group_3__1__Impl ;
    public final void rule__ParameterList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5285:1: ( rule__ParameterList__Group_3__1__Impl )
            // InternalBasicsParser.g:5286:2: rule__ParameterList__Group_3__1__Impl
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
    // InternalBasicsParser.g:5292:1: rule__ParameterList__Group_3__1__Impl : ( ( rule__ParameterList__ValueAssignment_3_1 ) ) ;
    public final void rule__ParameterList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5296:1: ( ( ( rule__ParameterList__ValueAssignment_3_1 ) ) )
            // InternalBasicsParser.g:5297:1: ( ( rule__ParameterList__ValueAssignment_3_1 ) )
            {
            // InternalBasicsParser.g:5297:1: ( ( rule__ParameterList__ValueAssignment_3_1 ) )
            // InternalBasicsParser.g:5298:2: ( rule__ParameterList__ValueAssignment_3_1 )
            {
             before(grammarAccess.getParameterListAccess().getValueAssignment_3_1()); 
            // InternalBasicsParser.g:5299:2: ( rule__ParameterList__ValueAssignment_3_1 )
            // InternalBasicsParser.g:5299:3: rule__ParameterList__ValueAssignment_3_1
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
    // InternalBasicsParser.g:5308:1: rule__ParameterAny__Group__0 : rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1 ;
    public final void rule__ParameterAny__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5312:1: ( rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1 )
            // InternalBasicsParser.g:5313:2: rule__ParameterAny__Group__0__Impl rule__ParameterAny__Group__1
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
    // InternalBasicsParser.g:5320:1: rule__ParameterAny__Group__0__Impl : ( () ) ;
    public final void rule__ParameterAny__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5324:1: ( ( () ) )
            // InternalBasicsParser.g:5325:1: ( () )
            {
            // InternalBasicsParser.g:5325:1: ( () )
            // InternalBasicsParser.g:5326:2: ()
            {
             before(grammarAccess.getParameterAnyAccess().getParameterAnyAction_0()); 
            // InternalBasicsParser.g:5327:2: ()
            // InternalBasicsParser.g:5327:3: 
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
    // InternalBasicsParser.g:5335:1: rule__ParameterAny__Group__1 : rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2 ;
    public final void rule__ParameterAny__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5339:1: ( rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2 )
            // InternalBasicsParser.g:5340:2: rule__ParameterAny__Group__1__Impl rule__ParameterAny__Group__2
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
    // InternalBasicsParser.g:5347:1: rule__ParameterAny__Group__1__Impl : ( ParameterAny ) ;
    public final void rule__ParameterAny__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5351:1: ( ( ParameterAny ) )
            // InternalBasicsParser.g:5352:1: ( ParameterAny )
            {
            // InternalBasicsParser.g:5352:1: ( ParameterAny )
            // InternalBasicsParser.g:5353:2: ParameterAny
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
    // InternalBasicsParser.g:5362:1: rule__ParameterAny__Group__2 : rule__ParameterAny__Group__2__Impl ;
    public final void rule__ParameterAny__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5366:1: ( rule__ParameterAny__Group__2__Impl )
            // InternalBasicsParser.g:5367:2: rule__ParameterAny__Group__2__Impl
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
    // InternalBasicsParser.g:5373:1: rule__ParameterAny__Group__2__Impl : ( ( rule__ParameterAny__Group_2__0 )? ) ;
    public final void rule__ParameterAny__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5377:1: ( ( ( rule__ParameterAny__Group_2__0 )? ) )
            // InternalBasicsParser.g:5378:1: ( ( rule__ParameterAny__Group_2__0 )? )
            {
            // InternalBasicsParser.g:5378:1: ( ( rule__ParameterAny__Group_2__0 )? )
            // InternalBasicsParser.g:5379:2: ( rule__ParameterAny__Group_2__0 )?
            {
             before(grammarAccess.getParameterAnyAccess().getGroup_2()); 
            // InternalBasicsParser.g:5380:2: ( rule__ParameterAny__Group_2__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==Value) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBasicsParser.g:5380:3: rule__ParameterAny__Group_2__0
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
    // InternalBasicsParser.g:5389:1: rule__ParameterAny__Group_2__0 : rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1 ;
    public final void rule__ParameterAny__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5393:1: ( rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1 )
            // InternalBasicsParser.g:5394:2: rule__ParameterAny__Group_2__0__Impl rule__ParameterAny__Group_2__1
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
    // InternalBasicsParser.g:5401:1: rule__ParameterAny__Group_2__0__Impl : ( Value ) ;
    public final void rule__ParameterAny__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5405:1: ( ( Value ) )
            // InternalBasicsParser.g:5406:1: ( Value )
            {
            // InternalBasicsParser.g:5406:1: ( Value )
            // InternalBasicsParser.g:5407:2: Value
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
    // InternalBasicsParser.g:5416:1: rule__ParameterAny__Group_2__1 : rule__ParameterAny__Group_2__1__Impl ;
    public final void rule__ParameterAny__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5420:1: ( rule__ParameterAny__Group_2__1__Impl )
            // InternalBasicsParser.g:5421:2: rule__ParameterAny__Group_2__1__Impl
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
    // InternalBasicsParser.g:5427:1: rule__ParameterAny__Group_2__1__Impl : ( ( rule__ParameterAny__ValueAssignment_2_1 ) ) ;
    public final void rule__ParameterAny__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5431:1: ( ( ( rule__ParameterAny__ValueAssignment_2_1 ) ) )
            // InternalBasicsParser.g:5432:1: ( ( rule__ParameterAny__ValueAssignment_2_1 ) )
            {
            // InternalBasicsParser.g:5432:1: ( ( rule__ParameterAny__ValueAssignment_2_1 ) )
            // InternalBasicsParser.g:5433:2: ( rule__ParameterAny__ValueAssignment_2_1 )
            {
             before(grammarAccess.getParameterAnyAccess().getValueAssignment_2_1()); 
            // InternalBasicsParser.g:5434:2: ( rule__ParameterAny__ValueAssignment_2_1 )
            // InternalBasicsParser.g:5434:3: rule__ParameterAny__ValueAssignment_2_1
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
    // InternalBasicsParser.g:5443:1: rule__ParameterStruct__Group__0 : rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1 ;
    public final void rule__ParameterStruct__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5447:1: ( rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1 )
            // InternalBasicsParser.g:5448:2: rule__ParameterStruct__Group__0__Impl rule__ParameterStruct__Group__1
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
    // InternalBasicsParser.g:5455:1: rule__ParameterStruct__Group__0__Impl : ( () ) ;
    public final void rule__ParameterStruct__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5459:1: ( ( () ) )
            // InternalBasicsParser.g:5460:1: ( () )
            {
            // InternalBasicsParser.g:5460:1: ( () )
            // InternalBasicsParser.g:5461:2: ()
            {
             before(grammarAccess.getParameterStructAccess().getParameterStructAction_0()); 
            // InternalBasicsParser.g:5462:2: ()
            // InternalBasicsParser.g:5462:3: 
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
    // InternalBasicsParser.g:5470:1: rule__ParameterStruct__Group__1 : rule__ParameterStruct__Group__1__Impl ;
    public final void rule__ParameterStruct__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5474:1: ( rule__ParameterStruct__Group__1__Impl )
            // InternalBasicsParser.g:5475:2: rule__ParameterStruct__Group__1__Impl
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
    // InternalBasicsParser.g:5481:1: rule__ParameterStruct__Group__1__Impl : ( ( rule__ParameterStruct__Group_1__0 )? ) ;
    public final void rule__ParameterStruct__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5485:1: ( ( ( rule__ParameterStruct__Group_1__0 )? ) )
            // InternalBasicsParser.g:5486:1: ( ( rule__ParameterStruct__Group_1__0 )? )
            {
            // InternalBasicsParser.g:5486:1: ( ( rule__ParameterStruct__Group_1__0 )? )
            // InternalBasicsParser.g:5487:2: ( rule__ParameterStruct__Group_1__0 )?
            {
             before(grammarAccess.getParameterStructAccess().getGroup_1()); 
            // InternalBasicsParser.g:5488:2: ( rule__ParameterStruct__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LeftSquareBracket) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBasicsParser.g:5488:3: rule__ParameterStruct__Group_1__0
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
    // InternalBasicsParser.g:5497:1: rule__ParameterStruct__Group_1__0 : rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1 ;
    public final void rule__ParameterStruct__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5501:1: ( rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1 )
            // InternalBasicsParser.g:5502:2: rule__ParameterStruct__Group_1__0__Impl rule__ParameterStruct__Group_1__1
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
    // InternalBasicsParser.g:5509:1: rule__ParameterStruct__Group_1__0__Impl : ( LeftSquareBracket ) ;
    public final void rule__ParameterStruct__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5513:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:5514:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:5514:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:5515:2: LeftSquareBracket
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
    // InternalBasicsParser.g:5524:1: rule__ParameterStruct__Group_1__1 : rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2 ;
    public final void rule__ParameterStruct__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5528:1: ( rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2 )
            // InternalBasicsParser.g:5529:2: rule__ParameterStruct__Group_1__1__Impl rule__ParameterStruct__Group_1__2
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
    // InternalBasicsParser.g:5536:1: rule__ParameterStruct__Group_1__1__Impl : ( RULE_BEGIN ) ;
    public final void rule__ParameterStruct__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5540:1: ( ( RULE_BEGIN ) )
            // InternalBasicsParser.g:5541:1: ( RULE_BEGIN )
            {
            // InternalBasicsParser.g:5541:1: ( RULE_BEGIN )
            // InternalBasicsParser.g:5542:2: RULE_BEGIN
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
    // InternalBasicsParser.g:5551:1: rule__ParameterStruct__Group_1__2 : rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3 ;
    public final void rule__ParameterStruct__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5555:1: ( rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3 )
            // InternalBasicsParser.g:5556:2: rule__ParameterStruct__Group_1__2__Impl rule__ParameterStruct__Group_1__3
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
    // InternalBasicsParser.g:5563:1: rule__ParameterStruct__Group_1__2__Impl : ( ( rule__ParameterStruct__ValueAssignment_1_2 )* ) ;
    public final void rule__ParameterStruct__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5567:1: ( ( ( rule__ParameterStruct__ValueAssignment_1_2 )* ) )
            // InternalBasicsParser.g:5568:1: ( ( rule__ParameterStruct__ValueAssignment_1_2 )* )
            {
            // InternalBasicsParser.g:5568:1: ( ( rule__ParameterStruct__ValueAssignment_1_2 )* )
            // InternalBasicsParser.g:5569:2: ( rule__ParameterStruct__ValueAssignment_1_2 )*
            {
             before(grammarAccess.getParameterStructAccess().getValueAssignment_1_2()); 
            // InternalBasicsParser.g:5570:2: ( rule__ParameterStruct__ValueAssignment_1_2 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=Pluginbases && LA33_0<=Parameter)||LA33_0==Multiple||LA33_0==Plugins||(LA33_0>=Format && LA33_0<=Loader)||LA33_0==Class||LA33_0==Slots||LA33_0==Base||(LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalBasicsParser.g:5570:3: rule__ParameterStruct__ValueAssignment_1_2
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
    // InternalBasicsParser.g:5578:1: rule__ParameterStruct__Group_1__3 : rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4 ;
    public final void rule__ParameterStruct__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5582:1: ( rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4 )
            // InternalBasicsParser.g:5583:2: rule__ParameterStruct__Group_1__3__Impl rule__ParameterStruct__Group_1__4
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
    // InternalBasicsParser.g:5590:1: rule__ParameterStruct__Group_1__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ParameterStruct__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5594:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5595:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5595:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5596:2: RightSquareBracket
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
    // InternalBasicsParser.g:5605:1: rule__ParameterStruct__Group_1__4 : rule__ParameterStruct__Group_1__4__Impl ;
    public final void rule__ParameterStruct__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5609:1: ( rule__ParameterStruct__Group_1__4__Impl )
            // InternalBasicsParser.g:5610:2: rule__ParameterStruct__Group_1__4__Impl
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
    // InternalBasicsParser.g:5616:1: rule__ParameterStruct__Group_1__4__Impl : ( RULE_END ) ;
    public final void rule__ParameterStruct__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5620:1: ( ( RULE_END ) )
            // InternalBasicsParser.g:5621:1: ( RULE_END )
            {
            // InternalBasicsParser.g:5621:1: ( RULE_END )
            // InternalBasicsParser.g:5622:2: RULE_END
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
    // InternalBasicsParser.g:5632:1: rule__ParameterStructMember__Group__0 : rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1 ;
    public final void rule__ParameterStructMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5636:1: ( rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1 )
            // InternalBasicsParser.g:5637:2: rule__ParameterStructMember__Group__0__Impl rule__ParameterStructMember__Group__1
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
    // InternalBasicsParser.g:5644:1: rule__ParameterStructMember__Group__0__Impl : ( ( rule__ParameterStructMember__Alternatives_0 ) ) ;
    public final void rule__ParameterStructMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5648:1: ( ( ( rule__ParameterStructMember__Alternatives_0 ) ) )
            // InternalBasicsParser.g:5649:1: ( ( rule__ParameterStructMember__Alternatives_0 ) )
            {
            // InternalBasicsParser.g:5649:1: ( ( rule__ParameterStructMember__Alternatives_0 ) )
            // InternalBasicsParser.g:5650:2: ( rule__ParameterStructMember__Alternatives_0 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getAlternatives_0()); 
            // InternalBasicsParser.g:5651:2: ( rule__ParameterStructMember__Alternatives_0 )
            // InternalBasicsParser.g:5651:3: rule__ParameterStructMember__Alternatives_0
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
    // InternalBasicsParser.g:5659:1: rule__ParameterStructMember__Group__1 : rule__ParameterStructMember__Group__1__Impl ;
    public final void rule__ParameterStructMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5663:1: ( rule__ParameterStructMember__Group__1__Impl )
            // InternalBasicsParser.g:5664:2: rule__ParameterStructMember__Group__1__Impl
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
    // InternalBasicsParser.g:5670:1: rule__ParameterStructMember__Group__1__Impl : ( ( rule__ParameterStructMember__ValueAssignment_1 ) ) ;
    public final void rule__ParameterStructMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5674:1: ( ( ( rule__ParameterStructMember__ValueAssignment_1 ) ) )
            // InternalBasicsParser.g:5675:1: ( ( rule__ParameterStructMember__ValueAssignment_1 ) )
            {
            // InternalBasicsParser.g:5675:1: ( ( rule__ParameterStructMember__ValueAssignment_1 ) )
            // InternalBasicsParser.g:5676:2: ( rule__ParameterStructMember__ValueAssignment_1 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getValueAssignment_1()); 
            // InternalBasicsParser.g:5677:2: ( rule__ParameterStructMember__ValueAssignment_1 )
            // InternalBasicsParser.g:5677:3: rule__ParameterStructMember__ValueAssignment_1
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
    // InternalBasicsParser.g:5686:1: rule__ParameterStructMember__Group_0_0__0 : rule__ParameterStructMember__Group_0_0__0__Impl rule__ParameterStructMember__Group_0_0__1 ;
    public final void rule__ParameterStructMember__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5690:1: ( rule__ParameterStructMember__Group_0_0__0__Impl rule__ParameterStructMember__Group_0_0__1 )
            // InternalBasicsParser.g:5691:2: rule__ParameterStructMember__Group_0_0__0__Impl rule__ParameterStructMember__Group_0_0__1
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
    // InternalBasicsParser.g:5698:1: rule__ParameterStructMember__Group_0_0__0__Impl : ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) ) ;
    public final void rule__ParameterStructMember__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5702:1: ( ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) ) )
            // InternalBasicsParser.g:5703:1: ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) )
            {
            // InternalBasicsParser.g:5703:1: ( ( rule__ParameterStructMember__NameAssignment_0_0_0 ) )
            // InternalBasicsParser.g:5704:2: ( rule__ParameterStructMember__NameAssignment_0_0_0 )
            {
             before(grammarAccess.getParameterStructMemberAccess().getNameAssignment_0_0_0()); 
            // InternalBasicsParser.g:5705:2: ( rule__ParameterStructMember__NameAssignment_0_0_0 )
            // InternalBasicsParser.g:5705:3: rule__ParameterStructMember__NameAssignment_0_0_0
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
    // InternalBasicsParser.g:5713:1: rule__ParameterStructMember__Group_0_0__1 : rule__ParameterStructMember__Group_0_0__1__Impl ;
    public final void rule__ParameterStructMember__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5717:1: ( rule__ParameterStructMember__Group_0_0__1__Impl )
            // InternalBasicsParser.g:5718:2: rule__ParameterStructMember__Group_0_0__1__Impl
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
    // InternalBasicsParser.g:5724:1: rule__ParameterStructMember__Group_0_0__1__Impl : ( Colon ) ;
    public final void rule__ParameterStructMember__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5728:1: ( ( Colon ) )
            // InternalBasicsParser.g:5729:1: ( Colon )
            {
            // InternalBasicsParser.g:5729:1: ( Colon )
            // InternalBasicsParser.g:5730:2: Colon
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
    // InternalBasicsParser.g:5740:1: rule__ParameterStructTypeMember__Group__0 : rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1 ;
    public final void rule__ParameterStructTypeMember__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5744:1: ( rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1 )
            // InternalBasicsParser.g:5745:2: rule__ParameterStructTypeMember__Group__0__Impl rule__ParameterStructTypeMember__Group__1
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
    // InternalBasicsParser.g:5752:1: rule__ParameterStructTypeMember__Group__0__Impl : ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) ) ;
    public final void rule__ParameterStructTypeMember__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5756:1: ( ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) ) )
            // InternalBasicsParser.g:5757:1: ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) )
            {
            // InternalBasicsParser.g:5757:1: ( ( rule__ParameterStructTypeMember__NameAssignment_0 ) )
            // InternalBasicsParser.g:5758:2: ( rule__ParameterStructTypeMember__NameAssignment_0 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getNameAssignment_0()); 
            // InternalBasicsParser.g:5759:2: ( rule__ParameterStructTypeMember__NameAssignment_0 )
            // InternalBasicsParser.g:5759:3: rule__ParameterStructTypeMember__NameAssignment_0
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
    // InternalBasicsParser.g:5767:1: rule__ParameterStructTypeMember__Group__1 : rule__ParameterStructTypeMember__Group__1__Impl ;
    public final void rule__ParameterStructTypeMember__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5771:1: ( rule__ParameterStructTypeMember__Group__1__Impl )
            // InternalBasicsParser.g:5772:2: rule__ParameterStructTypeMember__Group__1__Impl
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
    // InternalBasicsParser.g:5778:1: rule__ParameterStructTypeMember__Group__1__Impl : ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) ) ;
    public final void rule__ParameterStructTypeMember__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5782:1: ( ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) ) )
            // InternalBasicsParser.g:5783:1: ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) )
            {
            // InternalBasicsParser.g:5783:1: ( ( rule__ParameterStructTypeMember__TypeAssignment_1 ) )
            // InternalBasicsParser.g:5784:2: ( rule__ParameterStructTypeMember__TypeAssignment_1 )
            {
             before(grammarAccess.getParameterStructTypeMemberAccess().getTypeAssignment_1()); 
            // InternalBasicsParser.g:5785:2: ( rule__ParameterStructTypeMember__TypeAssignment_1 )
            // InternalBasicsParser.g:5785:3: rule__ParameterStructTypeMember__TypeAssignment_1
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


    // $ANTLR start "rule__AbstractType__Group_0__0"
    // InternalBasicsParser.g:5794:1: rule__AbstractType__Group_0__0 : rule__AbstractType__Group_0__0__Impl rule__AbstractType__Group_0__1 ;
    public final void rule__AbstractType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5798:1: ( rule__AbstractType__Group_0__0__Impl rule__AbstractType__Group_0__1 )
            // InternalBasicsParser.g:5799:2: rule__AbstractType__Group_0__0__Impl rule__AbstractType__Group_0__1
            {
            pushFollow(FOLLOW_4);
            rule__AbstractType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AbstractType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0__0"


    // $ANTLR start "rule__AbstractType__Group_0__0__Impl"
    // InternalBasicsParser.g:5806:1: rule__AbstractType__Group_0__0__Impl : ( ruleScalarType ) ;
    public final void rule__AbstractType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5810:1: ( ( ruleScalarType ) )
            // InternalBasicsParser.g:5811:1: ( ruleScalarType )
            {
            // InternalBasicsParser.g:5811:1: ( ruleScalarType )
            // InternalBasicsParser.g:5812:2: ruleScalarType
            {
             before(grammarAccess.getAbstractTypeAccess().getScalarTypeParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleScalarType();

            state._fsp--;

             after(grammarAccess.getAbstractTypeAccess().getScalarTypeParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0__0__Impl"


    // $ANTLR start "rule__AbstractType__Group_0__1"
    // InternalBasicsParser.g:5821:1: rule__AbstractType__Group_0__1 : rule__AbstractType__Group_0__1__Impl ;
    public final void rule__AbstractType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5825:1: ( rule__AbstractType__Group_0__1__Impl )
            // InternalBasicsParser.g:5826:2: rule__AbstractType__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AbstractType__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0__1"


    // $ANTLR start "rule__AbstractType__Group_0__1__Impl"
    // InternalBasicsParser.g:5832:1: rule__AbstractType__Group_0__1__Impl : ( ( rule__AbstractType__Group_0_1__0 )? ) ;
    public final void rule__AbstractType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5836:1: ( ( ( rule__AbstractType__Group_0_1__0 )? ) )
            // InternalBasicsParser.g:5837:1: ( ( rule__AbstractType__Group_0_1__0 )? )
            {
            // InternalBasicsParser.g:5837:1: ( ( rule__AbstractType__Group_0_1__0 )? )
            // InternalBasicsParser.g:5838:2: ( rule__AbstractType__Group_0_1__0 )?
            {
             before(grammarAccess.getAbstractTypeAccess().getGroup_0_1()); 
            // InternalBasicsParser.g:5839:2: ( rule__AbstractType__Group_0_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==LeftSquareBracket) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBasicsParser.g:5839:3: rule__AbstractType__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AbstractType__Group_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractTypeAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0__1__Impl"


    // $ANTLR start "rule__AbstractType__Group_0_1__0"
    // InternalBasicsParser.g:5848:1: rule__AbstractType__Group_0_1__0 : rule__AbstractType__Group_0_1__0__Impl rule__AbstractType__Group_0_1__1 ;
    public final void rule__AbstractType__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5852:1: ( rule__AbstractType__Group_0_1__0__Impl rule__AbstractType__Group_0_1__1 )
            // InternalBasicsParser.g:5853:2: rule__AbstractType__Group_0_1__0__Impl rule__AbstractType__Group_0_1__1
            {
            pushFollow(FOLLOW_4);
            rule__AbstractType__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AbstractType__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__0"


    // $ANTLR start "rule__AbstractType__Group_0_1__0__Impl"
    // InternalBasicsParser.g:5860:1: rule__AbstractType__Group_0_1__0__Impl : ( () ) ;
    public final void rule__AbstractType__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5864:1: ( ( () ) )
            // InternalBasicsParser.g:5865:1: ( () )
            {
            // InternalBasicsParser.g:5865:1: ( () )
            // InternalBasicsParser.g:5866:2: ()
            {
             before(grammarAccess.getAbstractTypeAccess().getSizedArrayElementAction_0_1_0()); 
            // InternalBasicsParser.g:5867:2: ()
            // InternalBasicsParser.g:5867:3: 
            {
            }

             after(grammarAccess.getAbstractTypeAccess().getSizedArrayElementAction_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__0__Impl"


    // $ANTLR start "rule__AbstractType__Group_0_1__1"
    // InternalBasicsParser.g:5875:1: rule__AbstractType__Group_0_1__1 : rule__AbstractType__Group_0_1__1__Impl rule__AbstractType__Group_0_1__2 ;
    public final void rule__AbstractType__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5879:1: ( rule__AbstractType__Group_0_1__1__Impl rule__AbstractType__Group_0_1__2 )
            // InternalBasicsParser.g:5880:2: rule__AbstractType__Group_0_1__1__Impl rule__AbstractType__Group_0_1__2
            {
            pushFollow(FOLLOW_33);
            rule__AbstractType__Group_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AbstractType__Group_0_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__1"


    // $ANTLR start "rule__AbstractType__Group_0_1__1__Impl"
    // InternalBasicsParser.g:5887:1: rule__AbstractType__Group_0_1__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__AbstractType__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5891:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:5892:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:5892:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:5893:2: LeftSquareBracket
            {
             before(grammarAccess.getAbstractTypeAccess().getLeftSquareBracketKeyword_0_1_1()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getAbstractTypeAccess().getLeftSquareBracketKeyword_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__1__Impl"


    // $ANTLR start "rule__AbstractType__Group_0_1__2"
    // InternalBasicsParser.g:5902:1: rule__AbstractType__Group_0_1__2 : rule__AbstractType__Group_0_1__2__Impl rule__AbstractType__Group_0_1__3 ;
    public final void rule__AbstractType__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5906:1: ( rule__AbstractType__Group_0_1__2__Impl rule__AbstractType__Group_0_1__3 )
            // InternalBasicsParser.g:5907:2: rule__AbstractType__Group_0_1__2__Impl rule__AbstractType__Group_0_1__3
            {
            pushFollow(FOLLOW_33);
            rule__AbstractType__Group_0_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AbstractType__Group_0_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__2"


    // $ANTLR start "rule__AbstractType__Group_0_1__2__Impl"
    // InternalBasicsParser.g:5914:1: rule__AbstractType__Group_0_1__2__Impl : ( ( rule__AbstractType__BoundedAssignment_0_1_2 )? ) ;
    public final void rule__AbstractType__Group_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5918:1: ( ( ( rule__AbstractType__BoundedAssignment_0_1_2 )? ) )
            // InternalBasicsParser.g:5919:1: ( ( rule__AbstractType__BoundedAssignment_0_1_2 )? )
            {
            // InternalBasicsParser.g:5919:1: ( ( rule__AbstractType__BoundedAssignment_0_1_2 )? )
            // InternalBasicsParser.g:5920:2: ( rule__AbstractType__BoundedAssignment_0_1_2 )?
            {
             before(grammarAccess.getAbstractTypeAccess().getBoundedAssignment_0_1_2()); 
            // InternalBasicsParser.g:5921:2: ( rule__AbstractType__BoundedAssignment_0_1_2 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==LessThanSignEqualsSign) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBasicsParser.g:5921:3: rule__AbstractType__BoundedAssignment_0_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__AbstractType__BoundedAssignment_0_1_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAbstractTypeAccess().getBoundedAssignment_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__2__Impl"


    // $ANTLR start "rule__AbstractType__Group_0_1__3"
    // InternalBasicsParser.g:5929:1: rule__AbstractType__Group_0_1__3 : rule__AbstractType__Group_0_1__3__Impl rule__AbstractType__Group_0_1__4 ;
    public final void rule__AbstractType__Group_0_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5933:1: ( rule__AbstractType__Group_0_1__3__Impl rule__AbstractType__Group_0_1__4 )
            // InternalBasicsParser.g:5934:2: rule__AbstractType__Group_0_1__3__Impl rule__AbstractType__Group_0_1__4
            {
            pushFollow(FOLLOW_24);
            rule__AbstractType__Group_0_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AbstractType__Group_0_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__3"


    // $ANTLR start "rule__AbstractType__Group_0_1__3__Impl"
    // InternalBasicsParser.g:5941:1: rule__AbstractType__Group_0_1__3__Impl : ( ( rule__AbstractType__SizeAssignment_0_1_3 ) ) ;
    public final void rule__AbstractType__Group_0_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5945:1: ( ( ( rule__AbstractType__SizeAssignment_0_1_3 ) ) )
            // InternalBasicsParser.g:5946:1: ( ( rule__AbstractType__SizeAssignment_0_1_3 ) )
            {
            // InternalBasicsParser.g:5946:1: ( ( rule__AbstractType__SizeAssignment_0_1_3 ) )
            // InternalBasicsParser.g:5947:2: ( rule__AbstractType__SizeAssignment_0_1_3 )
            {
             before(grammarAccess.getAbstractTypeAccess().getSizeAssignment_0_1_3()); 
            // InternalBasicsParser.g:5948:2: ( rule__AbstractType__SizeAssignment_0_1_3 )
            // InternalBasicsParser.g:5948:3: rule__AbstractType__SizeAssignment_0_1_3
            {
            pushFollow(FOLLOW_2);
            rule__AbstractType__SizeAssignment_0_1_3();

            state._fsp--;


            }

             after(grammarAccess.getAbstractTypeAccess().getSizeAssignment_0_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__3__Impl"


    // $ANTLR start "rule__AbstractType__Group_0_1__4"
    // InternalBasicsParser.g:5956:1: rule__AbstractType__Group_0_1__4 : rule__AbstractType__Group_0_1__4__Impl ;
    public final void rule__AbstractType__Group_0_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5960:1: ( rule__AbstractType__Group_0_1__4__Impl )
            // InternalBasicsParser.g:5961:2: rule__AbstractType__Group_0_1__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AbstractType__Group_0_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__4"


    // $ANTLR start "rule__AbstractType__Group_0_1__4__Impl"
    // InternalBasicsParser.g:5967:1: rule__AbstractType__Group_0_1__4__Impl : ( RightSquareBracket ) ;
    public final void rule__AbstractType__Group_0_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5971:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:5972:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:5972:1: ( RightSquareBracket )
            // InternalBasicsParser.g:5973:2: RightSquareBracket
            {
             before(grammarAccess.getAbstractTypeAccess().getRightSquareBracketKeyword_0_1_4()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getAbstractTypeAccess().getRightSquareBracketKeyword_0_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__Group_0_1__4__Impl"


    // $ANTLR start "rule__Bool__Group__0"
    // InternalBasicsParser.g:5983:1: rule__Bool__Group__0 : rule__Bool__Group__0__Impl rule__Bool__Group__1 ;
    public final void rule__Bool__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5987:1: ( rule__Bool__Group__0__Impl rule__Bool__Group__1 )
            // InternalBasicsParser.g:5988:2: rule__Bool__Group__0__Impl rule__Bool__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalBasicsParser.g:5995:1: rule__Bool__Group__0__Impl : ( () ) ;
    public final void rule__Bool__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:5999:1: ( ( () ) )
            // InternalBasicsParser.g:6000:1: ( () )
            {
            // InternalBasicsParser.g:6000:1: ( () )
            // InternalBasicsParser.g:6001:2: ()
            {
             before(grammarAccess.getBoolAccess().getBoolAction_0()); 
            // InternalBasicsParser.g:6002:2: ()
            // InternalBasicsParser.g:6002:3: 
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
    // InternalBasicsParser.g:6010:1: rule__Bool__Group__1 : rule__Bool__Group__1__Impl ;
    public final void rule__Bool__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6014:1: ( rule__Bool__Group__1__Impl )
            // InternalBasicsParser.g:6015:2: rule__Bool__Group__1__Impl
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
    // InternalBasicsParser.g:6021:1: rule__Bool__Group__1__Impl : ( Bool ) ;
    public final void rule__Bool__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6025:1: ( ( Bool ) )
            // InternalBasicsParser.g:6026:1: ( Bool )
            {
            // InternalBasicsParser.g:6026:1: ( Bool )
            // InternalBasicsParser.g:6027:2: Bool
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
    // InternalBasicsParser.g:6037:1: rule__Int8__Group__0 : rule__Int8__Group__0__Impl rule__Int8__Group__1 ;
    public final void rule__Int8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6041:1: ( rule__Int8__Group__0__Impl rule__Int8__Group__1 )
            // InternalBasicsParser.g:6042:2: rule__Int8__Group__0__Impl rule__Int8__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalBasicsParser.g:6049:1: rule__Int8__Group__0__Impl : ( () ) ;
    public final void rule__Int8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6053:1: ( ( () ) )
            // InternalBasicsParser.g:6054:1: ( () )
            {
            // InternalBasicsParser.g:6054:1: ( () )
            // InternalBasicsParser.g:6055:2: ()
            {
             before(grammarAccess.getInt8Access().getInt8Action_0()); 
            // InternalBasicsParser.g:6056:2: ()
            // InternalBasicsParser.g:6056:3: 
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
    // InternalBasicsParser.g:6064:1: rule__Int8__Group__1 : rule__Int8__Group__1__Impl ;
    public final void rule__Int8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6068:1: ( rule__Int8__Group__1__Impl )
            // InternalBasicsParser.g:6069:2: rule__Int8__Group__1__Impl
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
    // InternalBasicsParser.g:6075:1: rule__Int8__Group__1__Impl : ( Int8 ) ;
    public final void rule__Int8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6079:1: ( ( Int8 ) )
            // InternalBasicsParser.g:6080:1: ( Int8 )
            {
            // InternalBasicsParser.g:6080:1: ( Int8 )
            // InternalBasicsParser.g:6081:2: Int8
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
    // InternalBasicsParser.g:6091:1: rule__Uint8__Group__0 : rule__Uint8__Group__0__Impl rule__Uint8__Group__1 ;
    public final void rule__Uint8__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6095:1: ( rule__Uint8__Group__0__Impl rule__Uint8__Group__1 )
            // InternalBasicsParser.g:6096:2: rule__Uint8__Group__0__Impl rule__Uint8__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalBasicsParser.g:6103:1: rule__Uint8__Group__0__Impl : ( () ) ;
    public final void rule__Uint8__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6107:1: ( ( () ) )
            // InternalBasicsParser.g:6108:1: ( () )
            {
            // InternalBasicsParser.g:6108:1: ( () )
            // InternalBasicsParser.g:6109:2: ()
            {
             before(grammarAccess.getUint8Access().getUint8Action_0()); 
            // InternalBasicsParser.g:6110:2: ()
            // InternalBasicsParser.g:6110:3: 
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
    // InternalBasicsParser.g:6118:1: rule__Uint8__Group__1 : rule__Uint8__Group__1__Impl ;
    public final void rule__Uint8__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6122:1: ( rule__Uint8__Group__1__Impl )
            // InternalBasicsParser.g:6123:2: rule__Uint8__Group__1__Impl
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
    // InternalBasicsParser.g:6129:1: rule__Uint8__Group__1__Impl : ( Uint8 ) ;
    public final void rule__Uint8__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6133:1: ( ( Uint8 ) )
            // InternalBasicsParser.g:6134:1: ( Uint8 )
            {
            // InternalBasicsParser.g:6134:1: ( Uint8 )
            // InternalBasicsParser.g:6135:2: Uint8
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
    // InternalBasicsParser.g:6145:1: rule__Int16__Group__0 : rule__Int16__Group__0__Impl rule__Int16__Group__1 ;
    public final void rule__Int16__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6149:1: ( rule__Int16__Group__0__Impl rule__Int16__Group__1 )
            // InternalBasicsParser.g:6150:2: rule__Int16__Group__0__Impl rule__Int16__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalBasicsParser.g:6157:1: rule__Int16__Group__0__Impl : ( () ) ;
    public final void rule__Int16__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6161:1: ( ( () ) )
            // InternalBasicsParser.g:6162:1: ( () )
            {
            // InternalBasicsParser.g:6162:1: ( () )
            // InternalBasicsParser.g:6163:2: ()
            {
             before(grammarAccess.getInt16Access().getInt16Action_0()); 
            // InternalBasicsParser.g:6164:2: ()
            // InternalBasicsParser.g:6164:3: 
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
    // InternalBasicsParser.g:6172:1: rule__Int16__Group__1 : rule__Int16__Group__1__Impl ;
    public final void rule__Int16__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6176:1: ( rule__Int16__Group__1__Impl )
            // InternalBasicsParser.g:6177:2: rule__Int16__Group__1__Impl
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
    // InternalBasicsParser.g:6183:1: rule__Int16__Group__1__Impl : ( Int16 ) ;
    public final void rule__Int16__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6187:1: ( ( Int16 ) )
            // InternalBasicsParser.g:6188:1: ( Int16 )
            {
            // InternalBasicsParser.g:6188:1: ( Int16 )
            // InternalBasicsParser.g:6189:2: Int16
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
    // InternalBasicsParser.g:6199:1: rule__Uint16__Group__0 : rule__Uint16__Group__0__Impl rule__Uint16__Group__1 ;
    public final void rule__Uint16__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6203:1: ( rule__Uint16__Group__0__Impl rule__Uint16__Group__1 )
            // InternalBasicsParser.g:6204:2: rule__Uint16__Group__0__Impl rule__Uint16__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalBasicsParser.g:6211:1: rule__Uint16__Group__0__Impl : ( () ) ;
    public final void rule__Uint16__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6215:1: ( ( () ) )
            // InternalBasicsParser.g:6216:1: ( () )
            {
            // InternalBasicsParser.g:6216:1: ( () )
            // InternalBasicsParser.g:6217:2: ()
            {
             before(grammarAccess.getUint16Access().getUint16Action_0()); 
            // InternalBasicsParser.g:6218:2: ()
            // InternalBasicsParser.g:6218:3: 
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
    // InternalBasicsParser.g:6226:1: rule__Uint16__Group__1 : rule__Uint16__Group__1__Impl ;
    public final void rule__Uint16__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6230:1: ( rule__Uint16__Group__1__Impl )
            // InternalBasicsParser.g:6231:2: rule__Uint16__Group__1__Impl
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
    // InternalBasicsParser.g:6237:1: rule__Uint16__Group__1__Impl : ( Uint16 ) ;
    public final void rule__Uint16__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6241:1: ( ( Uint16 ) )
            // InternalBasicsParser.g:6242:1: ( Uint16 )
            {
            // InternalBasicsParser.g:6242:1: ( Uint16 )
            // InternalBasicsParser.g:6243:2: Uint16
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
    // InternalBasicsParser.g:6253:1: rule__Int32__Group__0 : rule__Int32__Group__0__Impl rule__Int32__Group__1 ;
    public final void rule__Int32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6257:1: ( rule__Int32__Group__0__Impl rule__Int32__Group__1 )
            // InternalBasicsParser.g:6258:2: rule__Int32__Group__0__Impl rule__Int32__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalBasicsParser.g:6265:1: rule__Int32__Group__0__Impl : ( () ) ;
    public final void rule__Int32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6269:1: ( ( () ) )
            // InternalBasicsParser.g:6270:1: ( () )
            {
            // InternalBasicsParser.g:6270:1: ( () )
            // InternalBasicsParser.g:6271:2: ()
            {
             before(grammarAccess.getInt32Access().getInt32Action_0()); 
            // InternalBasicsParser.g:6272:2: ()
            // InternalBasicsParser.g:6272:3: 
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
    // InternalBasicsParser.g:6280:1: rule__Int32__Group__1 : rule__Int32__Group__1__Impl ;
    public final void rule__Int32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6284:1: ( rule__Int32__Group__1__Impl )
            // InternalBasicsParser.g:6285:2: rule__Int32__Group__1__Impl
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
    // InternalBasicsParser.g:6291:1: rule__Int32__Group__1__Impl : ( Int32 ) ;
    public final void rule__Int32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6295:1: ( ( Int32 ) )
            // InternalBasicsParser.g:6296:1: ( Int32 )
            {
            // InternalBasicsParser.g:6296:1: ( Int32 )
            // InternalBasicsParser.g:6297:2: Int32
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
    // InternalBasicsParser.g:6307:1: rule__Uint32__Group__0 : rule__Uint32__Group__0__Impl rule__Uint32__Group__1 ;
    public final void rule__Uint32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6311:1: ( rule__Uint32__Group__0__Impl rule__Uint32__Group__1 )
            // InternalBasicsParser.g:6312:2: rule__Uint32__Group__0__Impl rule__Uint32__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalBasicsParser.g:6319:1: rule__Uint32__Group__0__Impl : ( () ) ;
    public final void rule__Uint32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6323:1: ( ( () ) )
            // InternalBasicsParser.g:6324:1: ( () )
            {
            // InternalBasicsParser.g:6324:1: ( () )
            // InternalBasicsParser.g:6325:2: ()
            {
             before(grammarAccess.getUint32Access().getUint32Action_0()); 
            // InternalBasicsParser.g:6326:2: ()
            // InternalBasicsParser.g:6326:3: 
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
    // InternalBasicsParser.g:6334:1: rule__Uint32__Group__1 : rule__Uint32__Group__1__Impl ;
    public final void rule__Uint32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6338:1: ( rule__Uint32__Group__1__Impl )
            // InternalBasicsParser.g:6339:2: rule__Uint32__Group__1__Impl
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
    // InternalBasicsParser.g:6345:1: rule__Uint32__Group__1__Impl : ( Uint32 ) ;
    public final void rule__Uint32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6349:1: ( ( Uint32 ) )
            // InternalBasicsParser.g:6350:1: ( Uint32 )
            {
            // InternalBasicsParser.g:6350:1: ( Uint32 )
            // InternalBasicsParser.g:6351:2: Uint32
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
    // InternalBasicsParser.g:6361:1: rule__Int64__Group__0 : rule__Int64__Group__0__Impl rule__Int64__Group__1 ;
    public final void rule__Int64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6365:1: ( rule__Int64__Group__0__Impl rule__Int64__Group__1 )
            // InternalBasicsParser.g:6366:2: rule__Int64__Group__0__Impl rule__Int64__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalBasicsParser.g:6373:1: rule__Int64__Group__0__Impl : ( () ) ;
    public final void rule__Int64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6377:1: ( ( () ) )
            // InternalBasicsParser.g:6378:1: ( () )
            {
            // InternalBasicsParser.g:6378:1: ( () )
            // InternalBasicsParser.g:6379:2: ()
            {
             before(grammarAccess.getInt64Access().getInt64Action_0()); 
            // InternalBasicsParser.g:6380:2: ()
            // InternalBasicsParser.g:6380:3: 
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
    // InternalBasicsParser.g:6388:1: rule__Int64__Group__1 : rule__Int64__Group__1__Impl ;
    public final void rule__Int64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6392:1: ( rule__Int64__Group__1__Impl )
            // InternalBasicsParser.g:6393:2: rule__Int64__Group__1__Impl
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
    // InternalBasicsParser.g:6399:1: rule__Int64__Group__1__Impl : ( Int64 ) ;
    public final void rule__Int64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6403:1: ( ( Int64 ) )
            // InternalBasicsParser.g:6404:1: ( Int64 )
            {
            // InternalBasicsParser.g:6404:1: ( Int64 )
            // InternalBasicsParser.g:6405:2: Int64
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
    // InternalBasicsParser.g:6415:1: rule__Uint64__Group__0 : rule__Uint64__Group__0__Impl rule__Uint64__Group__1 ;
    public final void rule__Uint64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6419:1: ( rule__Uint64__Group__0__Impl rule__Uint64__Group__1 )
            // InternalBasicsParser.g:6420:2: rule__Uint64__Group__0__Impl rule__Uint64__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalBasicsParser.g:6427:1: rule__Uint64__Group__0__Impl : ( () ) ;
    public final void rule__Uint64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6431:1: ( ( () ) )
            // InternalBasicsParser.g:6432:1: ( () )
            {
            // InternalBasicsParser.g:6432:1: ( () )
            // InternalBasicsParser.g:6433:2: ()
            {
             before(grammarAccess.getUint64Access().getUint64Action_0()); 
            // InternalBasicsParser.g:6434:2: ()
            // InternalBasicsParser.g:6434:3: 
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
    // InternalBasicsParser.g:6442:1: rule__Uint64__Group__1 : rule__Uint64__Group__1__Impl ;
    public final void rule__Uint64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6446:1: ( rule__Uint64__Group__1__Impl )
            // InternalBasicsParser.g:6447:2: rule__Uint64__Group__1__Impl
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
    // InternalBasicsParser.g:6453:1: rule__Uint64__Group__1__Impl : ( Uint64 ) ;
    public final void rule__Uint64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6457:1: ( ( Uint64 ) )
            // InternalBasicsParser.g:6458:1: ( Uint64 )
            {
            // InternalBasicsParser.g:6458:1: ( Uint64 )
            // InternalBasicsParser.g:6459:2: Uint64
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
    // InternalBasicsParser.g:6469:1: rule__Float32__Group__0 : rule__Float32__Group__0__Impl rule__Float32__Group__1 ;
    public final void rule__Float32__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6473:1: ( rule__Float32__Group__0__Impl rule__Float32__Group__1 )
            // InternalBasicsParser.g:6474:2: rule__Float32__Group__0__Impl rule__Float32__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalBasicsParser.g:6481:1: rule__Float32__Group__0__Impl : ( () ) ;
    public final void rule__Float32__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6485:1: ( ( () ) )
            // InternalBasicsParser.g:6486:1: ( () )
            {
            // InternalBasicsParser.g:6486:1: ( () )
            // InternalBasicsParser.g:6487:2: ()
            {
             before(grammarAccess.getFloat32Access().getFloat32Action_0()); 
            // InternalBasicsParser.g:6488:2: ()
            // InternalBasicsParser.g:6488:3: 
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
    // InternalBasicsParser.g:6496:1: rule__Float32__Group__1 : rule__Float32__Group__1__Impl ;
    public final void rule__Float32__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6500:1: ( rule__Float32__Group__1__Impl )
            // InternalBasicsParser.g:6501:2: rule__Float32__Group__1__Impl
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
    // InternalBasicsParser.g:6507:1: rule__Float32__Group__1__Impl : ( Float32 ) ;
    public final void rule__Float32__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6511:1: ( ( Float32 ) )
            // InternalBasicsParser.g:6512:1: ( Float32 )
            {
            // InternalBasicsParser.g:6512:1: ( Float32 )
            // InternalBasicsParser.g:6513:2: Float32
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
    // InternalBasicsParser.g:6523:1: rule__Float64__Group__0 : rule__Float64__Group__0__Impl rule__Float64__Group__1 ;
    public final void rule__Float64__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6527:1: ( rule__Float64__Group__0__Impl rule__Float64__Group__1 )
            // InternalBasicsParser.g:6528:2: rule__Float64__Group__0__Impl rule__Float64__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalBasicsParser.g:6535:1: rule__Float64__Group__0__Impl : ( () ) ;
    public final void rule__Float64__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6539:1: ( ( () ) )
            // InternalBasicsParser.g:6540:1: ( () )
            {
            // InternalBasicsParser.g:6540:1: ( () )
            // InternalBasicsParser.g:6541:2: ()
            {
             before(grammarAccess.getFloat64Access().getFloat64Action_0()); 
            // InternalBasicsParser.g:6542:2: ()
            // InternalBasicsParser.g:6542:3: 
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
    // InternalBasicsParser.g:6550:1: rule__Float64__Group__1 : rule__Float64__Group__1__Impl ;
    public final void rule__Float64__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6554:1: ( rule__Float64__Group__1__Impl )
            // InternalBasicsParser.g:6555:2: rule__Float64__Group__1__Impl
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
    // InternalBasicsParser.g:6561:1: rule__Float64__Group__1__Impl : ( Float64 ) ;
    public final void rule__Float64__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6565:1: ( ( Float64 ) )
            // InternalBasicsParser.g:6566:1: ( Float64 )
            {
            // InternalBasicsParser.g:6566:1: ( Float64 )
            // InternalBasicsParser.g:6567:2: Float64
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
    // InternalBasicsParser.g:6577:1: rule__String0__Group__0 : rule__String0__Group__0__Impl rule__String0__Group__1 ;
    public final void rule__String0__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6581:1: ( rule__String0__Group__0__Impl rule__String0__Group__1 )
            // InternalBasicsParser.g:6582:2: rule__String0__Group__0__Impl rule__String0__Group__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalBasicsParser.g:6589:1: rule__String0__Group__0__Impl : ( () ) ;
    public final void rule__String0__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6593:1: ( ( () ) )
            // InternalBasicsParser.g:6594:1: ( () )
            {
            // InternalBasicsParser.g:6594:1: ( () )
            // InternalBasicsParser.g:6595:2: ()
            {
             before(grammarAccess.getString0Access().getStringAction_0()); 
            // InternalBasicsParser.g:6596:2: ()
            // InternalBasicsParser.g:6596:3: 
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
    // InternalBasicsParser.g:6604:1: rule__String0__Group__1 : rule__String0__Group__1__Impl ;
    public final void rule__String0__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6608:1: ( rule__String0__Group__1__Impl )
            // InternalBasicsParser.g:6609:2: rule__String0__Group__1__Impl
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
    // InternalBasicsParser.g:6615:1: rule__String0__Group__1__Impl : ( String_1 ) ;
    public final void rule__String0__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6619:1: ( ( String_1 ) )
            // InternalBasicsParser.g:6620:1: ( String_1 )
            {
            // InternalBasicsParser.g:6620:1: ( String_1 )
            // InternalBasicsParser.g:6621:2: String_1
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
    // InternalBasicsParser.g:6631:1: rule__Char__Group__0 : rule__Char__Group__0__Impl rule__Char__Group__1 ;
    public final void rule__Char__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6635:1: ( rule__Char__Group__0__Impl rule__Char__Group__1 )
            // InternalBasicsParser.g:6636:2: rule__Char__Group__0__Impl rule__Char__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalBasicsParser.g:6643:1: rule__Char__Group__0__Impl : ( () ) ;
    public final void rule__Char__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6647:1: ( ( () ) )
            // InternalBasicsParser.g:6648:1: ( () )
            {
            // InternalBasicsParser.g:6648:1: ( () )
            // InternalBasicsParser.g:6649:2: ()
            {
             before(grammarAccess.getCharAccess().getChar0Action_0()); 
            // InternalBasicsParser.g:6650:2: ()
            // InternalBasicsParser.g:6650:3: 
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
    // InternalBasicsParser.g:6658:1: rule__Char__Group__1 : rule__Char__Group__1__Impl ;
    public final void rule__Char__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6662:1: ( rule__Char__Group__1__Impl )
            // InternalBasicsParser.g:6663:2: rule__Char__Group__1__Impl
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
    // InternalBasicsParser.g:6669:1: rule__Char__Group__1__Impl : ( Char ) ;
    public final void rule__Char__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6673:1: ( ( Char ) )
            // InternalBasicsParser.g:6674:1: ( Char )
            {
            // InternalBasicsParser.g:6674:1: ( Char )
            // InternalBasicsParser.g:6675:2: Char
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
    // InternalBasicsParser.g:6685:1: rule__Byte__Group__0 : rule__Byte__Group__0__Impl rule__Byte__Group__1 ;
    public final void rule__Byte__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6689:1: ( rule__Byte__Group__0__Impl rule__Byte__Group__1 )
            // InternalBasicsParser.g:6690:2: rule__Byte__Group__0__Impl rule__Byte__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalBasicsParser.g:6697:1: rule__Byte__Group__0__Impl : ( () ) ;
    public final void rule__Byte__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6701:1: ( ( () ) )
            // InternalBasicsParser.g:6702:1: ( () )
            {
            // InternalBasicsParser.g:6702:1: ( () )
            // InternalBasicsParser.g:6703:2: ()
            {
             before(grammarAccess.getByteAccess().getByteAction_0()); 
            // InternalBasicsParser.g:6704:2: ()
            // InternalBasicsParser.g:6704:3: 
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
    // InternalBasicsParser.g:6712:1: rule__Byte__Group__1 : rule__Byte__Group__1__Impl ;
    public final void rule__Byte__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6716:1: ( rule__Byte__Group__1__Impl )
            // InternalBasicsParser.g:6717:2: rule__Byte__Group__1__Impl
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
    // InternalBasicsParser.g:6723:1: rule__Byte__Group__1__Impl : ( Byte ) ;
    public final void rule__Byte__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6727:1: ( ( Byte ) )
            // InternalBasicsParser.g:6728:1: ( Byte )
            {
            // InternalBasicsParser.g:6728:1: ( Byte )
            // InternalBasicsParser.g:6729:2: Byte
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
    // InternalBasicsParser.g:6739:1: rule__Time__Group__0 : rule__Time__Group__0__Impl rule__Time__Group__1 ;
    public final void rule__Time__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6743:1: ( rule__Time__Group__0__Impl rule__Time__Group__1 )
            // InternalBasicsParser.g:6744:2: rule__Time__Group__0__Impl rule__Time__Group__1
            {
            pushFollow(FOLLOW_48);
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
    // InternalBasicsParser.g:6751:1: rule__Time__Group__0__Impl : ( () ) ;
    public final void rule__Time__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6755:1: ( ( () ) )
            // InternalBasicsParser.g:6756:1: ( () )
            {
            // InternalBasicsParser.g:6756:1: ( () )
            // InternalBasicsParser.g:6757:2: ()
            {
             before(grammarAccess.getTimeAccess().getTimeAction_0()); 
            // InternalBasicsParser.g:6758:2: ()
            // InternalBasicsParser.g:6758:3: 
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
    // InternalBasicsParser.g:6766:1: rule__Time__Group__1 : rule__Time__Group__1__Impl ;
    public final void rule__Time__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6770:1: ( rule__Time__Group__1__Impl )
            // InternalBasicsParser.g:6771:2: rule__Time__Group__1__Impl
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
    // InternalBasicsParser.g:6777:1: rule__Time__Group__1__Impl : ( Time ) ;
    public final void rule__Time__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6781:1: ( ( Time ) )
            // InternalBasicsParser.g:6782:1: ( Time )
            {
            // InternalBasicsParser.g:6782:1: ( Time )
            // InternalBasicsParser.g:6783:2: Time
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
    // InternalBasicsParser.g:6793:1: rule__Duration__Group__0 : rule__Duration__Group__0__Impl rule__Duration__Group__1 ;
    public final void rule__Duration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6797:1: ( rule__Duration__Group__0__Impl rule__Duration__Group__1 )
            // InternalBasicsParser.g:6798:2: rule__Duration__Group__0__Impl rule__Duration__Group__1
            {
            pushFollow(FOLLOW_49);
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
    // InternalBasicsParser.g:6805:1: rule__Duration__Group__0__Impl : ( () ) ;
    public final void rule__Duration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6809:1: ( ( () ) )
            // InternalBasicsParser.g:6810:1: ( () )
            {
            // InternalBasicsParser.g:6810:1: ( () )
            // InternalBasicsParser.g:6811:2: ()
            {
             before(grammarAccess.getDurationAccess().getDurationAction_0()); 
            // InternalBasicsParser.g:6812:2: ()
            // InternalBasicsParser.g:6812:3: 
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
    // InternalBasicsParser.g:6820:1: rule__Duration__Group__1 : rule__Duration__Group__1__Impl ;
    public final void rule__Duration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6824:1: ( rule__Duration__Group__1__Impl )
            // InternalBasicsParser.g:6825:2: rule__Duration__Group__1__Impl
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
    // InternalBasicsParser.g:6831:1: rule__Duration__Group__1__Impl : ( Duration ) ;
    public final void rule__Duration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6835:1: ( ( Duration ) )
            // InternalBasicsParser.g:6836:1: ( Duration )
            {
            // InternalBasicsParser.g:6836:1: ( Duration )
            // InternalBasicsParser.g:6837:2: Duration
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
    // InternalBasicsParser.g:6847:1: rule__BoolArray__Group__0 : rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1 ;
    public final void rule__BoolArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6851:1: ( rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1 )
            // InternalBasicsParser.g:6852:2: rule__BoolArray__Group__0__Impl rule__BoolArray__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalBasicsParser.g:6859:1: rule__BoolArray__Group__0__Impl : ( () ) ;
    public final void rule__BoolArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6863:1: ( ( () ) )
            // InternalBasicsParser.g:6864:1: ( () )
            {
            // InternalBasicsParser.g:6864:1: ( () )
            // InternalBasicsParser.g:6865:2: ()
            {
             before(grammarAccess.getBoolArrayAccess().getBoolArrayAction_0()); 
            // InternalBasicsParser.g:6866:2: ()
            // InternalBasicsParser.g:6866:3: 
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
    // InternalBasicsParser.g:6874:1: rule__BoolArray__Group__1 : rule__BoolArray__Group__1__Impl rule__BoolArray__Group__2 ;
    public final void rule__BoolArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6878:1: ( rule__BoolArray__Group__1__Impl rule__BoolArray__Group__2 )
            // InternalBasicsParser.g:6879:2: rule__BoolArray__Group__1__Impl rule__BoolArray__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__BoolArray__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolArray__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:6886:1: rule__BoolArray__Group__1__Impl : ( Bool ) ;
    public final void rule__BoolArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6890:1: ( ( Bool ) )
            // InternalBasicsParser.g:6891:1: ( Bool )
            {
            // InternalBasicsParser.g:6891:1: ( Bool )
            // InternalBasicsParser.g:6892:2: Bool
            {
             before(grammarAccess.getBoolArrayAccess().getBoolKeyword_1()); 
            match(input,Bool,FOLLOW_2); 
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


    // $ANTLR start "rule__BoolArray__Group__2"
    // InternalBasicsParser.g:6901:1: rule__BoolArray__Group__2 : rule__BoolArray__Group__2__Impl rule__BoolArray__Group__3 ;
    public final void rule__BoolArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6905:1: ( rule__BoolArray__Group__2__Impl rule__BoolArray__Group__3 )
            // InternalBasicsParser.g:6906:2: rule__BoolArray__Group__2__Impl rule__BoolArray__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__BoolArray__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BoolArray__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__2"


    // $ANTLR start "rule__BoolArray__Group__2__Impl"
    // InternalBasicsParser.g:6913:1: rule__BoolArray__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__BoolArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6917:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:6918:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:6918:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:6919:2: LeftSquareBracket
            {
             before(grammarAccess.getBoolArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getBoolArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__2__Impl"


    // $ANTLR start "rule__BoolArray__Group__3"
    // InternalBasicsParser.g:6928:1: rule__BoolArray__Group__3 : rule__BoolArray__Group__3__Impl ;
    public final void rule__BoolArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6932:1: ( rule__BoolArray__Group__3__Impl )
            // InternalBasicsParser.g:6933:2: rule__BoolArray__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BoolArray__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__3"


    // $ANTLR start "rule__BoolArray__Group__3__Impl"
    // InternalBasicsParser.g:6939:1: rule__BoolArray__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__BoolArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6943:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:6944:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:6944:1: ( RightSquareBracket )
            // InternalBasicsParser.g:6945:2: RightSquareBracket
            {
             before(grammarAccess.getBoolArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getBoolArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BoolArray__Group__3__Impl"


    // $ANTLR start "rule__Int8Array__Group__0"
    // InternalBasicsParser.g:6955:1: rule__Int8Array__Group__0 : rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1 ;
    public final void rule__Int8Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6959:1: ( rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1 )
            // InternalBasicsParser.g:6960:2: rule__Int8Array__Group__0__Impl rule__Int8Array__Group__1
            {
            pushFollow(FOLLOW_35);
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
    // InternalBasicsParser.g:6967:1: rule__Int8Array__Group__0__Impl : ( () ) ;
    public final void rule__Int8Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6971:1: ( ( () ) )
            // InternalBasicsParser.g:6972:1: ( () )
            {
            // InternalBasicsParser.g:6972:1: ( () )
            // InternalBasicsParser.g:6973:2: ()
            {
             before(grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0()); 
            // InternalBasicsParser.g:6974:2: ()
            // InternalBasicsParser.g:6974:3: 
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
    // InternalBasicsParser.g:6982:1: rule__Int8Array__Group__1 : rule__Int8Array__Group__1__Impl rule__Int8Array__Group__2 ;
    public final void rule__Int8Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6986:1: ( rule__Int8Array__Group__1__Impl rule__Int8Array__Group__2 )
            // InternalBasicsParser.g:6987:2: rule__Int8Array__Group__1__Impl rule__Int8Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Int8Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int8Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:6994:1: rule__Int8Array__Group__1__Impl : ( Int8 ) ;
    public final void rule__Int8Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:6998:1: ( ( Int8 ) )
            // InternalBasicsParser.g:6999:1: ( Int8 )
            {
            // InternalBasicsParser.g:6999:1: ( Int8 )
            // InternalBasicsParser.g:7000:2: Int8
            {
             before(grammarAccess.getInt8ArrayAccess().getInt8Keyword_1()); 
            match(input,Int8,FOLLOW_2); 
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


    // $ANTLR start "rule__Int8Array__Group__2"
    // InternalBasicsParser.g:7009:1: rule__Int8Array__Group__2 : rule__Int8Array__Group__2__Impl rule__Int8Array__Group__3 ;
    public final void rule__Int8Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7013:1: ( rule__Int8Array__Group__2__Impl rule__Int8Array__Group__3 )
            // InternalBasicsParser.g:7014:2: rule__Int8Array__Group__2__Impl rule__Int8Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Int8Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int8Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__2"


    // $ANTLR start "rule__Int8Array__Group__2__Impl"
    // InternalBasicsParser.g:7021:1: rule__Int8Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Int8Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7025:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7026:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7026:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7027:2: LeftSquareBracket
            {
             before(grammarAccess.getInt8ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt8ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__2__Impl"


    // $ANTLR start "rule__Int8Array__Group__3"
    // InternalBasicsParser.g:7036:1: rule__Int8Array__Group__3 : rule__Int8Array__Group__3__Impl ;
    public final void rule__Int8Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7040:1: ( rule__Int8Array__Group__3__Impl )
            // InternalBasicsParser.g:7041:2: rule__Int8Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int8Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__3"


    // $ANTLR start "rule__Int8Array__Group__3__Impl"
    // InternalBasicsParser.g:7047:1: rule__Int8Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Int8Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7051:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7052:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7052:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7053:2: RightSquareBracket
            {
             before(grammarAccess.getInt8ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt8ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int8Array__Group__3__Impl"


    // $ANTLR start "rule__Uint8Array__Group__0"
    // InternalBasicsParser.g:7063:1: rule__Uint8Array__Group__0 : rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1 ;
    public final void rule__Uint8Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7067:1: ( rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1 )
            // InternalBasicsParser.g:7068:2: rule__Uint8Array__Group__0__Impl rule__Uint8Array__Group__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalBasicsParser.g:7075:1: rule__Uint8Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint8Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7079:1: ( ( () ) )
            // InternalBasicsParser.g:7080:1: ( () )
            {
            // InternalBasicsParser.g:7080:1: ( () )
            // InternalBasicsParser.g:7081:2: ()
            {
             before(grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0()); 
            // InternalBasicsParser.g:7082:2: ()
            // InternalBasicsParser.g:7082:3: 
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
    // InternalBasicsParser.g:7090:1: rule__Uint8Array__Group__1 : rule__Uint8Array__Group__1__Impl rule__Uint8Array__Group__2 ;
    public final void rule__Uint8Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7094:1: ( rule__Uint8Array__Group__1__Impl rule__Uint8Array__Group__2 )
            // InternalBasicsParser.g:7095:2: rule__Uint8Array__Group__1__Impl rule__Uint8Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Uint8Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint8Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7102:1: rule__Uint8Array__Group__1__Impl : ( Uint8 ) ;
    public final void rule__Uint8Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7106:1: ( ( Uint8 ) )
            // InternalBasicsParser.g:7107:1: ( Uint8 )
            {
            // InternalBasicsParser.g:7107:1: ( Uint8 )
            // InternalBasicsParser.g:7108:2: Uint8
            {
             before(grammarAccess.getUint8ArrayAccess().getUint8Keyword_1()); 
            match(input,Uint8,FOLLOW_2); 
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


    // $ANTLR start "rule__Uint8Array__Group__2"
    // InternalBasicsParser.g:7117:1: rule__Uint8Array__Group__2 : rule__Uint8Array__Group__2__Impl rule__Uint8Array__Group__3 ;
    public final void rule__Uint8Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7121:1: ( rule__Uint8Array__Group__2__Impl rule__Uint8Array__Group__3 )
            // InternalBasicsParser.g:7122:2: rule__Uint8Array__Group__2__Impl rule__Uint8Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Uint8Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint8Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__2"


    // $ANTLR start "rule__Uint8Array__Group__2__Impl"
    // InternalBasicsParser.g:7129:1: rule__Uint8Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Uint8Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7133:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7134:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7134:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7135:2: LeftSquareBracket
            {
             before(grammarAccess.getUint8ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint8ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__2__Impl"


    // $ANTLR start "rule__Uint8Array__Group__3"
    // InternalBasicsParser.g:7144:1: rule__Uint8Array__Group__3 : rule__Uint8Array__Group__3__Impl ;
    public final void rule__Uint8Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7148:1: ( rule__Uint8Array__Group__3__Impl )
            // InternalBasicsParser.g:7149:2: rule__Uint8Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint8Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__3"


    // $ANTLR start "rule__Uint8Array__Group__3__Impl"
    // InternalBasicsParser.g:7155:1: rule__Uint8Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Uint8Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7159:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7160:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7160:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7161:2: RightSquareBracket
            {
             before(grammarAccess.getUint8ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint8ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint8Array__Group__3__Impl"


    // $ANTLR start "rule__Int16Array__Group__0"
    // InternalBasicsParser.g:7171:1: rule__Int16Array__Group__0 : rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1 ;
    public final void rule__Int16Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7175:1: ( rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1 )
            // InternalBasicsParser.g:7176:2: rule__Int16Array__Group__0__Impl rule__Int16Array__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalBasicsParser.g:7183:1: rule__Int16Array__Group__0__Impl : ( () ) ;
    public final void rule__Int16Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7187:1: ( ( () ) )
            // InternalBasicsParser.g:7188:1: ( () )
            {
            // InternalBasicsParser.g:7188:1: ( () )
            // InternalBasicsParser.g:7189:2: ()
            {
             before(grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0()); 
            // InternalBasicsParser.g:7190:2: ()
            // InternalBasicsParser.g:7190:3: 
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
    // InternalBasicsParser.g:7198:1: rule__Int16Array__Group__1 : rule__Int16Array__Group__1__Impl rule__Int16Array__Group__2 ;
    public final void rule__Int16Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7202:1: ( rule__Int16Array__Group__1__Impl rule__Int16Array__Group__2 )
            // InternalBasicsParser.g:7203:2: rule__Int16Array__Group__1__Impl rule__Int16Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Int16Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int16Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7210:1: rule__Int16Array__Group__1__Impl : ( Int16 ) ;
    public final void rule__Int16Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7214:1: ( ( Int16 ) )
            // InternalBasicsParser.g:7215:1: ( Int16 )
            {
            // InternalBasicsParser.g:7215:1: ( Int16 )
            // InternalBasicsParser.g:7216:2: Int16
            {
             before(grammarAccess.getInt16ArrayAccess().getInt16Keyword_1()); 
            match(input,Int16,FOLLOW_2); 
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


    // $ANTLR start "rule__Int16Array__Group__2"
    // InternalBasicsParser.g:7225:1: rule__Int16Array__Group__2 : rule__Int16Array__Group__2__Impl rule__Int16Array__Group__3 ;
    public final void rule__Int16Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7229:1: ( rule__Int16Array__Group__2__Impl rule__Int16Array__Group__3 )
            // InternalBasicsParser.g:7230:2: rule__Int16Array__Group__2__Impl rule__Int16Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Int16Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int16Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__2"


    // $ANTLR start "rule__Int16Array__Group__2__Impl"
    // InternalBasicsParser.g:7237:1: rule__Int16Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Int16Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7241:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7242:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7242:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7243:2: LeftSquareBracket
            {
             before(grammarAccess.getInt16ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt16ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__2__Impl"


    // $ANTLR start "rule__Int16Array__Group__3"
    // InternalBasicsParser.g:7252:1: rule__Int16Array__Group__3 : rule__Int16Array__Group__3__Impl ;
    public final void rule__Int16Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7256:1: ( rule__Int16Array__Group__3__Impl )
            // InternalBasicsParser.g:7257:2: rule__Int16Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int16Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__3"


    // $ANTLR start "rule__Int16Array__Group__3__Impl"
    // InternalBasicsParser.g:7263:1: rule__Int16Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Int16Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7267:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7268:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7268:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7269:2: RightSquareBracket
            {
             before(grammarAccess.getInt16ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt16ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int16Array__Group__3__Impl"


    // $ANTLR start "rule__Uint16Array__Group__0"
    // InternalBasicsParser.g:7279:1: rule__Uint16Array__Group__0 : rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1 ;
    public final void rule__Uint16Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7283:1: ( rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1 )
            // InternalBasicsParser.g:7284:2: rule__Uint16Array__Group__0__Impl rule__Uint16Array__Group__1
            {
            pushFollow(FOLLOW_38);
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
    // InternalBasicsParser.g:7291:1: rule__Uint16Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint16Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7295:1: ( ( () ) )
            // InternalBasicsParser.g:7296:1: ( () )
            {
            // InternalBasicsParser.g:7296:1: ( () )
            // InternalBasicsParser.g:7297:2: ()
            {
             before(grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0()); 
            // InternalBasicsParser.g:7298:2: ()
            // InternalBasicsParser.g:7298:3: 
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
    // InternalBasicsParser.g:7306:1: rule__Uint16Array__Group__1 : rule__Uint16Array__Group__1__Impl rule__Uint16Array__Group__2 ;
    public final void rule__Uint16Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7310:1: ( rule__Uint16Array__Group__1__Impl rule__Uint16Array__Group__2 )
            // InternalBasicsParser.g:7311:2: rule__Uint16Array__Group__1__Impl rule__Uint16Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Uint16Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint16Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7318:1: rule__Uint16Array__Group__1__Impl : ( Uint16 ) ;
    public final void rule__Uint16Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7322:1: ( ( Uint16 ) )
            // InternalBasicsParser.g:7323:1: ( Uint16 )
            {
            // InternalBasicsParser.g:7323:1: ( Uint16 )
            // InternalBasicsParser.g:7324:2: Uint16
            {
             before(grammarAccess.getUint16ArrayAccess().getUint16Keyword_1()); 
            match(input,Uint16,FOLLOW_2); 
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


    // $ANTLR start "rule__Uint16Array__Group__2"
    // InternalBasicsParser.g:7333:1: rule__Uint16Array__Group__2 : rule__Uint16Array__Group__2__Impl rule__Uint16Array__Group__3 ;
    public final void rule__Uint16Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7337:1: ( rule__Uint16Array__Group__2__Impl rule__Uint16Array__Group__3 )
            // InternalBasicsParser.g:7338:2: rule__Uint16Array__Group__2__Impl rule__Uint16Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Uint16Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint16Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__2"


    // $ANTLR start "rule__Uint16Array__Group__2__Impl"
    // InternalBasicsParser.g:7345:1: rule__Uint16Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Uint16Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7349:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7350:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7350:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7351:2: LeftSquareBracket
            {
             before(grammarAccess.getUint16ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint16ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__2__Impl"


    // $ANTLR start "rule__Uint16Array__Group__3"
    // InternalBasicsParser.g:7360:1: rule__Uint16Array__Group__3 : rule__Uint16Array__Group__3__Impl ;
    public final void rule__Uint16Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7364:1: ( rule__Uint16Array__Group__3__Impl )
            // InternalBasicsParser.g:7365:2: rule__Uint16Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint16Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__3"


    // $ANTLR start "rule__Uint16Array__Group__3__Impl"
    // InternalBasicsParser.g:7371:1: rule__Uint16Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Uint16Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7375:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7376:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7376:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7377:2: RightSquareBracket
            {
             before(grammarAccess.getUint16ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint16ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint16Array__Group__3__Impl"


    // $ANTLR start "rule__Int32Array__Group__0"
    // InternalBasicsParser.g:7387:1: rule__Int32Array__Group__0 : rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1 ;
    public final void rule__Int32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7391:1: ( rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1 )
            // InternalBasicsParser.g:7392:2: rule__Int32Array__Group__0__Impl rule__Int32Array__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalBasicsParser.g:7399:1: rule__Int32Array__Group__0__Impl : ( () ) ;
    public final void rule__Int32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7403:1: ( ( () ) )
            // InternalBasicsParser.g:7404:1: ( () )
            {
            // InternalBasicsParser.g:7404:1: ( () )
            // InternalBasicsParser.g:7405:2: ()
            {
             before(grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0()); 
            // InternalBasicsParser.g:7406:2: ()
            // InternalBasicsParser.g:7406:3: 
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
    // InternalBasicsParser.g:7414:1: rule__Int32Array__Group__1 : rule__Int32Array__Group__1__Impl rule__Int32Array__Group__2 ;
    public final void rule__Int32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7418:1: ( rule__Int32Array__Group__1__Impl rule__Int32Array__Group__2 )
            // InternalBasicsParser.g:7419:2: rule__Int32Array__Group__1__Impl rule__Int32Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Int32Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int32Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7426:1: rule__Int32Array__Group__1__Impl : ( Int32 ) ;
    public final void rule__Int32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7430:1: ( ( Int32 ) )
            // InternalBasicsParser.g:7431:1: ( Int32 )
            {
            // InternalBasicsParser.g:7431:1: ( Int32 )
            // InternalBasicsParser.g:7432:2: Int32
            {
             before(grammarAccess.getInt32ArrayAccess().getInt32Keyword_1()); 
            match(input,Int32,FOLLOW_2); 
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


    // $ANTLR start "rule__Int32Array__Group__2"
    // InternalBasicsParser.g:7441:1: rule__Int32Array__Group__2 : rule__Int32Array__Group__2__Impl rule__Int32Array__Group__3 ;
    public final void rule__Int32Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7445:1: ( rule__Int32Array__Group__2__Impl rule__Int32Array__Group__3 )
            // InternalBasicsParser.g:7446:2: rule__Int32Array__Group__2__Impl rule__Int32Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Int32Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int32Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__2"


    // $ANTLR start "rule__Int32Array__Group__2__Impl"
    // InternalBasicsParser.g:7453:1: rule__Int32Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Int32Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7457:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7458:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7458:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7459:2: LeftSquareBracket
            {
             before(grammarAccess.getInt32ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt32ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__2__Impl"


    // $ANTLR start "rule__Int32Array__Group__3"
    // InternalBasicsParser.g:7468:1: rule__Int32Array__Group__3 : rule__Int32Array__Group__3__Impl ;
    public final void rule__Int32Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7472:1: ( rule__Int32Array__Group__3__Impl )
            // InternalBasicsParser.g:7473:2: rule__Int32Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int32Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__3"


    // $ANTLR start "rule__Int32Array__Group__3__Impl"
    // InternalBasicsParser.g:7479:1: rule__Int32Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Int32Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7483:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7484:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7484:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7485:2: RightSquareBracket
            {
             before(grammarAccess.getInt32ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt32ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int32Array__Group__3__Impl"


    // $ANTLR start "rule__Uint32Array__Group__0"
    // InternalBasicsParser.g:7495:1: rule__Uint32Array__Group__0 : rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1 ;
    public final void rule__Uint32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7499:1: ( rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1 )
            // InternalBasicsParser.g:7500:2: rule__Uint32Array__Group__0__Impl rule__Uint32Array__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalBasicsParser.g:7507:1: rule__Uint32Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7511:1: ( ( () ) )
            // InternalBasicsParser.g:7512:1: ( () )
            {
            // InternalBasicsParser.g:7512:1: ( () )
            // InternalBasicsParser.g:7513:2: ()
            {
             before(grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0()); 
            // InternalBasicsParser.g:7514:2: ()
            // InternalBasicsParser.g:7514:3: 
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
    // InternalBasicsParser.g:7522:1: rule__Uint32Array__Group__1 : rule__Uint32Array__Group__1__Impl rule__Uint32Array__Group__2 ;
    public final void rule__Uint32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7526:1: ( rule__Uint32Array__Group__1__Impl rule__Uint32Array__Group__2 )
            // InternalBasicsParser.g:7527:2: rule__Uint32Array__Group__1__Impl rule__Uint32Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Uint32Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint32Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7534:1: rule__Uint32Array__Group__1__Impl : ( Uint32 ) ;
    public final void rule__Uint32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7538:1: ( ( Uint32 ) )
            // InternalBasicsParser.g:7539:1: ( Uint32 )
            {
            // InternalBasicsParser.g:7539:1: ( Uint32 )
            // InternalBasicsParser.g:7540:2: Uint32
            {
             before(grammarAccess.getUint32ArrayAccess().getUint32Keyword_1()); 
            match(input,Uint32,FOLLOW_2); 
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


    // $ANTLR start "rule__Uint32Array__Group__2"
    // InternalBasicsParser.g:7549:1: rule__Uint32Array__Group__2 : rule__Uint32Array__Group__2__Impl rule__Uint32Array__Group__3 ;
    public final void rule__Uint32Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7553:1: ( rule__Uint32Array__Group__2__Impl rule__Uint32Array__Group__3 )
            // InternalBasicsParser.g:7554:2: rule__Uint32Array__Group__2__Impl rule__Uint32Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Uint32Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint32Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__2"


    // $ANTLR start "rule__Uint32Array__Group__2__Impl"
    // InternalBasicsParser.g:7561:1: rule__Uint32Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Uint32Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7565:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7566:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7566:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7567:2: LeftSquareBracket
            {
             before(grammarAccess.getUint32ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint32ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__2__Impl"


    // $ANTLR start "rule__Uint32Array__Group__3"
    // InternalBasicsParser.g:7576:1: rule__Uint32Array__Group__3 : rule__Uint32Array__Group__3__Impl ;
    public final void rule__Uint32Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7580:1: ( rule__Uint32Array__Group__3__Impl )
            // InternalBasicsParser.g:7581:2: rule__Uint32Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint32Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__3"


    // $ANTLR start "rule__Uint32Array__Group__3__Impl"
    // InternalBasicsParser.g:7587:1: rule__Uint32Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Uint32Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7591:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7592:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7592:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7593:2: RightSquareBracket
            {
             before(grammarAccess.getUint32ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint32ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint32Array__Group__3__Impl"


    // $ANTLR start "rule__Int64Array__Group__0"
    // InternalBasicsParser.g:7603:1: rule__Int64Array__Group__0 : rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1 ;
    public final void rule__Int64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7607:1: ( rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1 )
            // InternalBasicsParser.g:7608:2: rule__Int64Array__Group__0__Impl rule__Int64Array__Group__1
            {
            pushFollow(FOLLOW_41);
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
    // InternalBasicsParser.g:7615:1: rule__Int64Array__Group__0__Impl : ( () ) ;
    public final void rule__Int64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7619:1: ( ( () ) )
            // InternalBasicsParser.g:7620:1: ( () )
            {
            // InternalBasicsParser.g:7620:1: ( () )
            // InternalBasicsParser.g:7621:2: ()
            {
             before(grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0()); 
            // InternalBasicsParser.g:7622:2: ()
            // InternalBasicsParser.g:7622:3: 
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
    // InternalBasicsParser.g:7630:1: rule__Int64Array__Group__1 : rule__Int64Array__Group__1__Impl rule__Int64Array__Group__2 ;
    public final void rule__Int64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7634:1: ( rule__Int64Array__Group__1__Impl rule__Int64Array__Group__2 )
            // InternalBasicsParser.g:7635:2: rule__Int64Array__Group__1__Impl rule__Int64Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Int64Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int64Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7642:1: rule__Int64Array__Group__1__Impl : ( Int64 ) ;
    public final void rule__Int64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7646:1: ( ( Int64 ) )
            // InternalBasicsParser.g:7647:1: ( Int64 )
            {
            // InternalBasicsParser.g:7647:1: ( Int64 )
            // InternalBasicsParser.g:7648:2: Int64
            {
             before(grammarAccess.getInt64ArrayAccess().getInt64Keyword_1()); 
            match(input,Int64,FOLLOW_2); 
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


    // $ANTLR start "rule__Int64Array__Group__2"
    // InternalBasicsParser.g:7657:1: rule__Int64Array__Group__2 : rule__Int64Array__Group__2__Impl rule__Int64Array__Group__3 ;
    public final void rule__Int64Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7661:1: ( rule__Int64Array__Group__2__Impl rule__Int64Array__Group__3 )
            // InternalBasicsParser.g:7662:2: rule__Int64Array__Group__2__Impl rule__Int64Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Int64Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Int64Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__2"


    // $ANTLR start "rule__Int64Array__Group__2__Impl"
    // InternalBasicsParser.g:7669:1: rule__Int64Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Int64Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7673:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7674:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7674:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7675:2: LeftSquareBracket
            {
             before(grammarAccess.getInt64ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt64ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__2__Impl"


    // $ANTLR start "rule__Int64Array__Group__3"
    // InternalBasicsParser.g:7684:1: rule__Int64Array__Group__3 : rule__Int64Array__Group__3__Impl ;
    public final void rule__Int64Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7688:1: ( rule__Int64Array__Group__3__Impl )
            // InternalBasicsParser.g:7689:2: rule__Int64Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Int64Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__3"


    // $ANTLR start "rule__Int64Array__Group__3__Impl"
    // InternalBasicsParser.g:7695:1: rule__Int64Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Int64Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7699:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7700:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7700:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7701:2: RightSquareBracket
            {
             before(grammarAccess.getInt64ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getInt64ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Int64Array__Group__3__Impl"


    // $ANTLR start "rule__Uint64Array__Group__0"
    // InternalBasicsParser.g:7711:1: rule__Uint64Array__Group__0 : rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1 ;
    public final void rule__Uint64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7715:1: ( rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1 )
            // InternalBasicsParser.g:7716:2: rule__Uint64Array__Group__0__Impl rule__Uint64Array__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalBasicsParser.g:7723:1: rule__Uint64Array__Group__0__Impl : ( () ) ;
    public final void rule__Uint64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7727:1: ( ( () ) )
            // InternalBasicsParser.g:7728:1: ( () )
            {
            // InternalBasicsParser.g:7728:1: ( () )
            // InternalBasicsParser.g:7729:2: ()
            {
             before(grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0()); 
            // InternalBasicsParser.g:7730:2: ()
            // InternalBasicsParser.g:7730:3: 
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
    // InternalBasicsParser.g:7738:1: rule__Uint64Array__Group__1 : rule__Uint64Array__Group__1__Impl rule__Uint64Array__Group__2 ;
    public final void rule__Uint64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7742:1: ( rule__Uint64Array__Group__1__Impl rule__Uint64Array__Group__2 )
            // InternalBasicsParser.g:7743:2: rule__Uint64Array__Group__1__Impl rule__Uint64Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Uint64Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint64Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7750:1: rule__Uint64Array__Group__1__Impl : ( Uint64 ) ;
    public final void rule__Uint64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7754:1: ( ( Uint64 ) )
            // InternalBasicsParser.g:7755:1: ( Uint64 )
            {
            // InternalBasicsParser.g:7755:1: ( Uint64 )
            // InternalBasicsParser.g:7756:2: Uint64
            {
             before(grammarAccess.getUint64ArrayAccess().getUint64Keyword_1()); 
            match(input,Uint64,FOLLOW_2); 
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


    // $ANTLR start "rule__Uint64Array__Group__2"
    // InternalBasicsParser.g:7765:1: rule__Uint64Array__Group__2 : rule__Uint64Array__Group__2__Impl rule__Uint64Array__Group__3 ;
    public final void rule__Uint64Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7769:1: ( rule__Uint64Array__Group__2__Impl rule__Uint64Array__Group__3 )
            // InternalBasicsParser.g:7770:2: rule__Uint64Array__Group__2__Impl rule__Uint64Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Uint64Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Uint64Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__2"


    // $ANTLR start "rule__Uint64Array__Group__2__Impl"
    // InternalBasicsParser.g:7777:1: rule__Uint64Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Uint64Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7781:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7782:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7782:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7783:2: LeftSquareBracket
            {
             before(grammarAccess.getUint64ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint64ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__2__Impl"


    // $ANTLR start "rule__Uint64Array__Group__3"
    // InternalBasicsParser.g:7792:1: rule__Uint64Array__Group__3 : rule__Uint64Array__Group__3__Impl ;
    public final void rule__Uint64Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7796:1: ( rule__Uint64Array__Group__3__Impl )
            // InternalBasicsParser.g:7797:2: rule__Uint64Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Uint64Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__3"


    // $ANTLR start "rule__Uint64Array__Group__3__Impl"
    // InternalBasicsParser.g:7803:1: rule__Uint64Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Uint64Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7807:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7808:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7808:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7809:2: RightSquareBracket
            {
             before(grammarAccess.getUint64ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getUint64ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Uint64Array__Group__3__Impl"


    // $ANTLR start "rule__Float32Array__Group__0"
    // InternalBasicsParser.g:7819:1: rule__Float32Array__Group__0 : rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1 ;
    public final void rule__Float32Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7823:1: ( rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1 )
            // InternalBasicsParser.g:7824:2: rule__Float32Array__Group__0__Impl rule__Float32Array__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalBasicsParser.g:7831:1: rule__Float32Array__Group__0__Impl : ( () ) ;
    public final void rule__Float32Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7835:1: ( ( () ) )
            // InternalBasicsParser.g:7836:1: ( () )
            {
            // InternalBasicsParser.g:7836:1: ( () )
            // InternalBasicsParser.g:7837:2: ()
            {
             before(grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0()); 
            // InternalBasicsParser.g:7838:2: ()
            // InternalBasicsParser.g:7838:3: 
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
    // InternalBasicsParser.g:7846:1: rule__Float32Array__Group__1 : rule__Float32Array__Group__1__Impl rule__Float32Array__Group__2 ;
    public final void rule__Float32Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7850:1: ( rule__Float32Array__Group__1__Impl rule__Float32Array__Group__2 )
            // InternalBasicsParser.g:7851:2: rule__Float32Array__Group__1__Impl rule__Float32Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Float32Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float32Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7858:1: rule__Float32Array__Group__1__Impl : ( Float32 ) ;
    public final void rule__Float32Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7862:1: ( ( Float32 ) )
            // InternalBasicsParser.g:7863:1: ( Float32 )
            {
            // InternalBasicsParser.g:7863:1: ( Float32 )
            // InternalBasicsParser.g:7864:2: Float32
            {
             before(grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1()); 
            match(input,Float32,FOLLOW_2); 
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


    // $ANTLR start "rule__Float32Array__Group__2"
    // InternalBasicsParser.g:7873:1: rule__Float32Array__Group__2 : rule__Float32Array__Group__2__Impl rule__Float32Array__Group__3 ;
    public final void rule__Float32Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7877:1: ( rule__Float32Array__Group__2__Impl rule__Float32Array__Group__3 )
            // InternalBasicsParser.g:7878:2: rule__Float32Array__Group__2__Impl rule__Float32Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Float32Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float32Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__2"


    // $ANTLR start "rule__Float32Array__Group__2__Impl"
    // InternalBasicsParser.g:7885:1: rule__Float32Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Float32Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7889:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7890:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7890:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7891:2: LeftSquareBracket
            {
             before(grammarAccess.getFloat32ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getFloat32ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__2__Impl"


    // $ANTLR start "rule__Float32Array__Group__3"
    // InternalBasicsParser.g:7900:1: rule__Float32Array__Group__3 : rule__Float32Array__Group__3__Impl ;
    public final void rule__Float32Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7904:1: ( rule__Float32Array__Group__3__Impl )
            // InternalBasicsParser.g:7905:2: rule__Float32Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Float32Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__3"


    // $ANTLR start "rule__Float32Array__Group__3__Impl"
    // InternalBasicsParser.g:7911:1: rule__Float32Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Float32Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7915:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:7916:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:7916:1: ( RightSquareBracket )
            // InternalBasicsParser.g:7917:2: RightSquareBracket
            {
             before(grammarAccess.getFloat32ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getFloat32ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float32Array__Group__3__Impl"


    // $ANTLR start "rule__Float64Array__Group__0"
    // InternalBasicsParser.g:7927:1: rule__Float64Array__Group__0 : rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1 ;
    public final void rule__Float64Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7931:1: ( rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1 )
            // InternalBasicsParser.g:7932:2: rule__Float64Array__Group__0__Impl rule__Float64Array__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalBasicsParser.g:7939:1: rule__Float64Array__Group__0__Impl : ( () ) ;
    public final void rule__Float64Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7943:1: ( ( () ) )
            // InternalBasicsParser.g:7944:1: ( () )
            {
            // InternalBasicsParser.g:7944:1: ( () )
            // InternalBasicsParser.g:7945:2: ()
            {
             before(grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0()); 
            // InternalBasicsParser.g:7946:2: ()
            // InternalBasicsParser.g:7946:3: 
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
    // InternalBasicsParser.g:7954:1: rule__Float64Array__Group__1 : rule__Float64Array__Group__1__Impl rule__Float64Array__Group__2 ;
    public final void rule__Float64Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7958:1: ( rule__Float64Array__Group__1__Impl rule__Float64Array__Group__2 )
            // InternalBasicsParser.g:7959:2: rule__Float64Array__Group__1__Impl rule__Float64Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Float64Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float64Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:7966:1: rule__Float64Array__Group__1__Impl : ( Float64 ) ;
    public final void rule__Float64Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7970:1: ( ( Float64 ) )
            // InternalBasicsParser.g:7971:1: ( Float64 )
            {
            // InternalBasicsParser.g:7971:1: ( Float64 )
            // InternalBasicsParser.g:7972:2: Float64
            {
             before(grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1()); 
            match(input,Float64,FOLLOW_2); 
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


    // $ANTLR start "rule__Float64Array__Group__2"
    // InternalBasicsParser.g:7981:1: rule__Float64Array__Group__2 : rule__Float64Array__Group__2__Impl rule__Float64Array__Group__3 ;
    public final void rule__Float64Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7985:1: ( rule__Float64Array__Group__2__Impl rule__Float64Array__Group__3 )
            // InternalBasicsParser.g:7986:2: rule__Float64Array__Group__2__Impl rule__Float64Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__Float64Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float64Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__2"


    // $ANTLR start "rule__Float64Array__Group__2__Impl"
    // InternalBasicsParser.g:7993:1: rule__Float64Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Float64Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:7997:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:7998:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:7998:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:7999:2: LeftSquareBracket
            {
             before(grammarAccess.getFloat64ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getFloat64ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__2__Impl"


    // $ANTLR start "rule__Float64Array__Group__3"
    // InternalBasicsParser.g:8008:1: rule__Float64Array__Group__3 : rule__Float64Array__Group__3__Impl ;
    public final void rule__Float64Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8012:1: ( rule__Float64Array__Group__3__Impl )
            // InternalBasicsParser.g:8013:2: rule__Float64Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Float64Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__3"


    // $ANTLR start "rule__Float64Array__Group__3__Impl"
    // InternalBasicsParser.g:8019:1: rule__Float64Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Float64Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8023:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:8024:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:8024:1: ( RightSquareBracket )
            // InternalBasicsParser.g:8025:2: RightSquareBracket
            {
             before(grammarAccess.getFloat64ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getFloat64ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float64Array__Group__3__Impl"


    // $ANTLR start "rule__String0Array__Group__0"
    // InternalBasicsParser.g:8035:1: rule__String0Array__Group__0 : rule__String0Array__Group__0__Impl rule__String0Array__Group__1 ;
    public final void rule__String0Array__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8039:1: ( rule__String0Array__Group__0__Impl rule__String0Array__Group__1 )
            // InternalBasicsParser.g:8040:2: rule__String0Array__Group__0__Impl rule__String0Array__Group__1
            {
            pushFollow(FOLLOW_45);
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
    // InternalBasicsParser.g:8047:1: rule__String0Array__Group__0__Impl : ( () ) ;
    public final void rule__String0Array__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8051:1: ( ( () ) )
            // InternalBasicsParser.g:8052:1: ( () )
            {
            // InternalBasicsParser.g:8052:1: ( () )
            // InternalBasicsParser.g:8053:2: ()
            {
             before(grammarAccess.getString0ArrayAccess().getStringArrayAction_0()); 
            // InternalBasicsParser.g:8054:2: ()
            // InternalBasicsParser.g:8054:3: 
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
    // InternalBasicsParser.g:8062:1: rule__String0Array__Group__1 : rule__String0Array__Group__1__Impl rule__String0Array__Group__2 ;
    public final void rule__String0Array__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8066:1: ( rule__String0Array__Group__1__Impl rule__String0Array__Group__2 )
            // InternalBasicsParser.g:8067:2: rule__String0Array__Group__1__Impl rule__String0Array__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__String0Array__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__String0Array__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:8074:1: rule__String0Array__Group__1__Impl : ( String_1 ) ;
    public final void rule__String0Array__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8078:1: ( ( String_1 ) )
            // InternalBasicsParser.g:8079:1: ( String_1 )
            {
            // InternalBasicsParser.g:8079:1: ( String_1 )
            // InternalBasicsParser.g:8080:2: String_1
            {
             before(grammarAccess.getString0ArrayAccess().getStringKeyword_1()); 
            match(input,String_1,FOLLOW_2); 
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


    // $ANTLR start "rule__String0Array__Group__2"
    // InternalBasicsParser.g:8089:1: rule__String0Array__Group__2 : rule__String0Array__Group__2__Impl rule__String0Array__Group__3 ;
    public final void rule__String0Array__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8093:1: ( rule__String0Array__Group__2__Impl rule__String0Array__Group__3 )
            // InternalBasicsParser.g:8094:2: rule__String0Array__Group__2__Impl rule__String0Array__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__String0Array__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__String0Array__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__2"


    // $ANTLR start "rule__String0Array__Group__2__Impl"
    // InternalBasicsParser.g:8101:1: rule__String0Array__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__String0Array__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8105:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:8106:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:8106:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:8107:2: LeftSquareBracket
            {
             before(grammarAccess.getString0ArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getString0ArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__2__Impl"


    // $ANTLR start "rule__String0Array__Group__3"
    // InternalBasicsParser.g:8116:1: rule__String0Array__Group__3 : rule__String0Array__Group__3__Impl ;
    public final void rule__String0Array__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8120:1: ( rule__String0Array__Group__3__Impl )
            // InternalBasicsParser.g:8121:2: rule__String0Array__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__String0Array__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__3"


    // $ANTLR start "rule__String0Array__Group__3__Impl"
    // InternalBasicsParser.g:8127:1: rule__String0Array__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__String0Array__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8131:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:8132:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:8132:1: ( RightSquareBracket )
            // InternalBasicsParser.g:8133:2: RightSquareBracket
            {
             before(grammarAccess.getString0ArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getString0ArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__String0Array__Group__3__Impl"


    // $ANTLR start "rule__ByteArray__Group__0"
    // InternalBasicsParser.g:8143:1: rule__ByteArray__Group__0 : rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1 ;
    public final void rule__ByteArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8147:1: ( rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1 )
            // InternalBasicsParser.g:8148:2: rule__ByteArray__Group__0__Impl rule__ByteArray__Group__1
            {
            pushFollow(FOLLOW_47);
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
    // InternalBasicsParser.g:8155:1: rule__ByteArray__Group__0__Impl : ( () ) ;
    public final void rule__ByteArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8159:1: ( ( () ) )
            // InternalBasicsParser.g:8160:1: ( () )
            {
            // InternalBasicsParser.g:8160:1: ( () )
            // InternalBasicsParser.g:8161:2: ()
            {
             before(grammarAccess.getByteArrayAccess().getByteArrayAction_0()); 
            // InternalBasicsParser.g:8162:2: ()
            // InternalBasicsParser.g:8162:3: 
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
    // InternalBasicsParser.g:8170:1: rule__ByteArray__Group__1 : rule__ByteArray__Group__1__Impl rule__ByteArray__Group__2 ;
    public final void rule__ByteArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8174:1: ( rule__ByteArray__Group__1__Impl rule__ByteArray__Group__2 )
            // InternalBasicsParser.g:8175:2: rule__ByteArray__Group__1__Impl rule__ByteArray__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ByteArray__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ByteArray__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:8182:1: rule__ByteArray__Group__1__Impl : ( Byte ) ;
    public final void rule__ByteArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8186:1: ( ( Byte ) )
            // InternalBasicsParser.g:8187:1: ( Byte )
            {
            // InternalBasicsParser.g:8187:1: ( Byte )
            // InternalBasicsParser.g:8188:2: Byte
            {
             before(grammarAccess.getByteArrayAccess().getByteKeyword_1()); 
            match(input,Byte,FOLLOW_2); 
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


    // $ANTLR start "rule__ByteArray__Group__2"
    // InternalBasicsParser.g:8197:1: rule__ByteArray__Group__2 : rule__ByteArray__Group__2__Impl rule__ByteArray__Group__3 ;
    public final void rule__ByteArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8201:1: ( rule__ByteArray__Group__2__Impl rule__ByteArray__Group__3 )
            // InternalBasicsParser.g:8202:2: rule__ByteArray__Group__2__Impl rule__ByteArray__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__ByteArray__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ByteArray__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__2"


    // $ANTLR start "rule__ByteArray__Group__2__Impl"
    // InternalBasicsParser.g:8209:1: rule__ByteArray__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__ByteArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8213:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:8214:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:8214:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:8215:2: LeftSquareBracket
            {
             before(grammarAccess.getByteArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getByteArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__2__Impl"


    // $ANTLR start "rule__ByteArray__Group__3"
    // InternalBasicsParser.g:8224:1: rule__ByteArray__Group__3 : rule__ByteArray__Group__3__Impl ;
    public final void rule__ByteArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8228:1: ( rule__ByteArray__Group__3__Impl )
            // InternalBasicsParser.g:8229:2: rule__ByteArray__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ByteArray__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__3"


    // $ANTLR start "rule__ByteArray__Group__3__Impl"
    // InternalBasicsParser.g:8235:1: rule__ByteArray__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ByteArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8239:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:8240:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:8240:1: ( RightSquareBracket )
            // InternalBasicsParser.g:8241:2: RightSquareBracket
            {
             before(grammarAccess.getByteArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getByteArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ByteArray__Group__3__Impl"


    // $ANTLR start "rule__CharArray__Group__0"
    // InternalBasicsParser.g:8251:1: rule__CharArray__Group__0 : rule__CharArray__Group__0__Impl rule__CharArray__Group__1 ;
    public final void rule__CharArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8255:1: ( rule__CharArray__Group__0__Impl rule__CharArray__Group__1 )
            // InternalBasicsParser.g:8256:2: rule__CharArray__Group__0__Impl rule__CharArray__Group__1
            {
            pushFollow(FOLLOW_46);
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
    // InternalBasicsParser.g:8263:1: rule__CharArray__Group__0__Impl : ( () ) ;
    public final void rule__CharArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8267:1: ( ( () ) )
            // InternalBasicsParser.g:8268:1: ( () )
            {
            // InternalBasicsParser.g:8268:1: ( () )
            // InternalBasicsParser.g:8269:2: ()
            {
             before(grammarAccess.getCharArrayAccess().getCharArrayAction_0()); 
            // InternalBasicsParser.g:8270:2: ()
            // InternalBasicsParser.g:8270:3: 
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
    // InternalBasicsParser.g:8278:1: rule__CharArray__Group__1 : rule__CharArray__Group__1__Impl rule__CharArray__Group__2 ;
    public final void rule__CharArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8282:1: ( rule__CharArray__Group__1__Impl rule__CharArray__Group__2 )
            // InternalBasicsParser.g:8283:2: rule__CharArray__Group__1__Impl rule__CharArray__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__CharArray__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CharArray__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:8290:1: rule__CharArray__Group__1__Impl : ( Char ) ;
    public final void rule__CharArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8294:1: ( ( Char ) )
            // InternalBasicsParser.g:8295:1: ( Char )
            {
            // InternalBasicsParser.g:8295:1: ( Char )
            // InternalBasicsParser.g:8296:2: Char
            {
             before(grammarAccess.getCharArrayAccess().getCharKeyword_1()); 
            match(input,Char,FOLLOW_2); 
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


    // $ANTLR start "rule__CharArray__Group__2"
    // InternalBasicsParser.g:8305:1: rule__CharArray__Group__2 : rule__CharArray__Group__2__Impl rule__CharArray__Group__3 ;
    public final void rule__CharArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8309:1: ( rule__CharArray__Group__2__Impl rule__CharArray__Group__3 )
            // InternalBasicsParser.g:8310:2: rule__CharArray__Group__2__Impl rule__CharArray__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__CharArray__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CharArray__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__2"


    // $ANTLR start "rule__CharArray__Group__2__Impl"
    // InternalBasicsParser.g:8317:1: rule__CharArray__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__CharArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8321:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:8322:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:8322:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:8323:2: LeftSquareBracket
            {
             before(grammarAccess.getCharArrayAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getCharArrayAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__2__Impl"


    // $ANTLR start "rule__CharArray__Group__3"
    // InternalBasicsParser.g:8332:1: rule__CharArray__Group__3 : rule__CharArray__Group__3__Impl ;
    public final void rule__CharArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8336:1: ( rule__CharArray__Group__3__Impl )
            // InternalBasicsParser.g:8337:2: rule__CharArray__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CharArray__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__3"


    // $ANTLR start "rule__CharArray__Group__3__Impl"
    // InternalBasicsParser.g:8343:1: rule__CharArray__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__CharArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8347:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:8348:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:8348:1: ( RightSquareBracket )
            // InternalBasicsParser.g:8349:2: RightSquareBracket
            {
             before(grammarAccess.getCharArrayAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getCharArrayAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CharArray__Group__3__Impl"


    // $ANTLR start "rule__Header__Group__0"
    // InternalBasicsParser.g:8359:1: rule__Header__Group__0 : rule__Header__Group__0__Impl rule__Header__Group__1 ;
    public final void rule__Header__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8363:1: ( rule__Header__Group__0__Impl rule__Header__Group__1 )
            // InternalBasicsParser.g:8364:2: rule__Header__Group__0__Impl rule__Header__Group__1
            {
            pushFollow(FOLLOW_50);
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
    // InternalBasicsParser.g:8371:1: rule__Header__Group__0__Impl : ( () ) ;
    public final void rule__Header__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8375:1: ( ( () ) )
            // InternalBasicsParser.g:8376:1: ( () )
            {
            // InternalBasicsParser.g:8376:1: ( () )
            // InternalBasicsParser.g:8377:2: ()
            {
             before(grammarAccess.getHeaderAccess().getHeaderAction_0()); 
            // InternalBasicsParser.g:8378:2: ()
            // InternalBasicsParser.g:8378:3: 
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
    // InternalBasicsParser.g:8386:1: rule__Header__Group__1 : rule__Header__Group__1__Impl ;
    public final void rule__Header__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8390:1: ( rule__Header__Group__1__Impl )
            // InternalBasicsParser.g:8391:2: rule__Header__Group__1__Impl
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
    // InternalBasicsParser.g:8397:1: rule__Header__Group__1__Impl : ( Header ) ;
    public final void rule__Header__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8401:1: ( ( Header ) )
            // InternalBasicsParser.g:8402:1: ( Header )
            {
            // InternalBasicsParser.g:8402:1: ( Header )
            // InternalBasicsParser.g:8403:2: Header
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
    // InternalBasicsParser.g:8413:1: rule__ArraySpecRef__Group__0 : rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1 ;
    public final void rule__ArraySpecRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8417:1: ( rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1 )
            // InternalBasicsParser.g:8418:2: rule__ArraySpecRef__Group__0__Impl rule__ArraySpecRef__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalBasicsParser.g:8425:1: rule__ArraySpecRef__Group__0__Impl : ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) ) ;
    public final void rule__ArraySpecRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8429:1: ( ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) ) )
            // InternalBasicsParser.g:8430:1: ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) )
            {
            // InternalBasicsParser.g:8430:1: ( ( rule__ArraySpecRef__ReferenceAssignment_0 ) )
            // InternalBasicsParser.g:8431:2: ( rule__ArraySpecRef__ReferenceAssignment_0 )
            {
             before(grammarAccess.getArraySpecRefAccess().getReferenceAssignment_0()); 
            // InternalBasicsParser.g:8432:2: ( rule__ArraySpecRef__ReferenceAssignment_0 )
            // InternalBasicsParser.g:8432:3: rule__ArraySpecRef__ReferenceAssignment_0
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
    // InternalBasicsParser.g:8440:1: rule__ArraySpecRef__Group__1 : rule__ArraySpecRef__Group__1__Impl rule__ArraySpecRef__Group__2 ;
    public final void rule__ArraySpecRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8444:1: ( rule__ArraySpecRef__Group__1__Impl rule__ArraySpecRef__Group__2 )
            // InternalBasicsParser.g:8445:2: rule__ArraySpecRef__Group__1__Impl rule__ArraySpecRef__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__ArraySpecRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArraySpecRef__Group__2();

            state._fsp--;


            }

        }
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
    // InternalBasicsParser.g:8452:1: rule__ArraySpecRef__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ArraySpecRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8456:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:8457:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:8457:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:8458:2: LeftSquareBracket
            {
             before(grammarAccess.getArraySpecRefAccess().getLeftSquareBracketKeyword_1()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getArraySpecRefAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ArraySpecRef__Group__2"
    // InternalBasicsParser.g:8467:1: rule__ArraySpecRef__Group__2 : rule__ArraySpecRef__Group__2__Impl ;
    public final void rule__ArraySpecRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8471:1: ( rule__ArraySpecRef__Group__2__Impl )
            // InternalBasicsParser.g:8472:2: rule__ArraySpecRef__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArraySpecRef__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArraySpecRef__Group__2"


    // $ANTLR start "rule__ArraySpecRef__Group__2__Impl"
    // InternalBasicsParser.g:8478:1: rule__ArraySpecRef__Group__2__Impl : ( RightSquareBracket ) ;
    public final void rule__ArraySpecRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8482:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:8483:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:8483:1: ( RightSquareBracket )
            // InternalBasicsParser.g:8484:2: RightSquareBracket
            {
             before(grammarAccess.getArraySpecRefAccess().getRightSquareBracketKeyword_2()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getArraySpecRefAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArraySpecRef__Group__2__Impl"


    // $ANTLR start "rule__ExtensionBlockName__Group__0"
    // InternalBasicsParser.g:8494:1: rule__ExtensionBlockName__Group__0 : rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1 ;
    public final void rule__ExtensionBlockName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8498:1: ( rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1 )
            // InternalBasicsParser.g:8499:2: rule__ExtensionBlockName__Group__0__Impl rule__ExtensionBlockName__Group__1
            {
            pushFollow(FOLLOW_51);
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
    // InternalBasicsParser.g:8506:1: rule__ExtensionBlockName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__ExtensionBlockName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8510:1: ( ( RULE_ID ) )
            // InternalBasicsParser.g:8511:1: ( RULE_ID )
            {
            // InternalBasicsParser.g:8511:1: ( RULE_ID )
            // InternalBasicsParser.g:8512:2: RULE_ID
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
    // InternalBasicsParser.g:8521:1: rule__ExtensionBlockName__Group__1 : rule__ExtensionBlockName__Group__1__Impl ;
    public final void rule__ExtensionBlockName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8525:1: ( rule__ExtensionBlockName__Group__1__Impl )
            // InternalBasicsParser.g:8526:2: rule__ExtensionBlockName__Group__1__Impl
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
    // InternalBasicsParser.g:8532:1: rule__ExtensionBlockName__Group__1__Impl : ( ( rule__ExtensionBlockName__Group_1__0 )* ) ;
    public final void rule__ExtensionBlockName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8536:1: ( ( ( rule__ExtensionBlockName__Group_1__0 )* ) )
            // InternalBasicsParser.g:8537:1: ( ( rule__ExtensionBlockName__Group_1__0 )* )
            {
            // InternalBasicsParser.g:8537:1: ( ( rule__ExtensionBlockName__Group_1__0 )* )
            // InternalBasicsParser.g:8538:2: ( rule__ExtensionBlockName__Group_1__0 )*
            {
             before(grammarAccess.getExtensionBlockNameAccess().getGroup_1()); 
            // InternalBasicsParser.g:8539:2: ( rule__ExtensionBlockName__Group_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==FullStop) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBasicsParser.g:8539:3: rule__ExtensionBlockName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__ExtensionBlockName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalBasicsParser.g:8548:1: rule__ExtensionBlockName__Group_1__0 : rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1 ;
    public final void rule__ExtensionBlockName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8552:1: ( rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1 )
            // InternalBasicsParser.g:8553:2: rule__ExtensionBlockName__Group_1__0__Impl rule__ExtensionBlockName__Group_1__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalBasicsParser.g:8560:1: rule__ExtensionBlockName__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__ExtensionBlockName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8564:1: ( ( FullStop ) )
            // InternalBasicsParser.g:8565:1: ( FullStop )
            {
            // InternalBasicsParser.g:8565:1: ( FullStop )
            // InternalBasicsParser.g:8566:2: FullStop
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
    // InternalBasicsParser.g:8575:1: rule__ExtensionBlockName__Group_1__1 : rule__ExtensionBlockName__Group_1__1__Impl ;
    public final void rule__ExtensionBlockName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8579:1: ( rule__ExtensionBlockName__Group_1__1__Impl )
            // InternalBasicsParser.g:8580:2: rule__ExtensionBlockName__Group_1__1__Impl
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
    // InternalBasicsParser.g:8586:1: rule__ExtensionBlockName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__ExtensionBlockName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8590:1: ( ( RULE_ID ) )
            // InternalBasicsParser.g:8591:1: ( RULE_ID )
            {
            // InternalBasicsParser.g:8591:1: ( RULE_ID )
            // InternalBasicsParser.g:8592:2: RULE_ID
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
    // InternalBasicsParser.g:8602:1: rule__ExtensionEntry__Group__0 : rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1 ;
    public final void rule__ExtensionEntry__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8606:1: ( rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1 )
            // InternalBasicsParser.g:8607:2: rule__ExtensionEntry__Group__0__Impl rule__ExtensionEntry__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalBasicsParser.g:8614:1: rule__ExtensionEntry__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionEntry__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8618:1: ( ( () ) )
            // InternalBasicsParser.g:8619:1: ( () )
            {
            // InternalBasicsParser.g:8619:1: ( () )
            // InternalBasicsParser.g:8620:2: ()
            {
             before(grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0()); 
            // InternalBasicsParser.g:8621:2: ()
            // InternalBasicsParser.g:8621:3: 
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
    // InternalBasicsParser.g:8629:1: rule__ExtensionEntry__Group__1 : rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2 ;
    public final void rule__ExtensionEntry__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8633:1: ( rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2 )
            // InternalBasicsParser.g:8634:2: rule__ExtensionEntry__Group__1__Impl rule__ExtensionEntry__Group__2
            {
            pushFollow(FOLLOW_55);
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
    // InternalBasicsParser.g:8641:1: rule__ExtensionEntry__Group__1__Impl : ( ( rule__ExtensionEntry__Alternatives_1 ) ) ;
    public final void rule__ExtensionEntry__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8645:1: ( ( ( rule__ExtensionEntry__Alternatives_1 ) ) )
            // InternalBasicsParser.g:8646:1: ( ( rule__ExtensionEntry__Alternatives_1 ) )
            {
            // InternalBasicsParser.g:8646:1: ( ( rule__ExtensionEntry__Alternatives_1 ) )
            // InternalBasicsParser.g:8647:2: ( rule__ExtensionEntry__Alternatives_1 )
            {
             before(grammarAccess.getExtensionEntryAccess().getAlternatives_1()); 
            // InternalBasicsParser.g:8648:2: ( rule__ExtensionEntry__Alternatives_1 )
            // InternalBasicsParser.g:8648:3: rule__ExtensionEntry__Alternatives_1
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
    // InternalBasicsParser.g:8656:1: rule__ExtensionEntry__Group__2 : rule__ExtensionEntry__Group__2__Impl ;
    public final void rule__ExtensionEntry__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8660:1: ( rule__ExtensionEntry__Group__2__Impl )
            // InternalBasicsParser.g:8661:2: rule__ExtensionEntry__Group__2__Impl
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
    // InternalBasicsParser.g:8667:1: rule__ExtensionEntry__Group__2__Impl : ( ( rule__ExtensionEntry__ValueAssignment_2 ) ) ;
    public final void rule__ExtensionEntry__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8671:1: ( ( ( rule__ExtensionEntry__ValueAssignment_2 ) ) )
            // InternalBasicsParser.g:8672:1: ( ( rule__ExtensionEntry__ValueAssignment_2 ) )
            {
            // InternalBasicsParser.g:8672:1: ( ( rule__ExtensionEntry__ValueAssignment_2 ) )
            // InternalBasicsParser.g:8673:2: ( rule__ExtensionEntry__ValueAssignment_2 )
            {
             before(grammarAccess.getExtensionEntryAccess().getValueAssignment_2()); 
            // InternalBasicsParser.g:8674:2: ( rule__ExtensionEntry__ValueAssignment_2 )
            // InternalBasicsParser.g:8674:3: rule__ExtensionEntry__ValueAssignment_2
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
    // InternalBasicsParser.g:8683:1: rule__ExtensionEntry__Group_1_0__0 : rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1 ;
    public final void rule__ExtensionEntry__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8687:1: ( rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1 )
            // InternalBasicsParser.g:8688:2: rule__ExtensionEntry__Group_1_0__0__Impl rule__ExtensionEntry__Group_1_0__1
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
    // InternalBasicsParser.g:8695:1: rule__ExtensionEntry__Group_1_0__0__Impl : ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) ) ;
    public final void rule__ExtensionEntry__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8699:1: ( ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) ) )
            // InternalBasicsParser.g:8700:1: ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) )
            {
            // InternalBasicsParser.g:8700:1: ( ( rule__ExtensionEntry__KeyAssignment_1_0_0 ) )
            // InternalBasicsParser.g:8701:2: ( rule__ExtensionEntry__KeyAssignment_1_0_0 )
            {
             before(grammarAccess.getExtensionEntryAccess().getKeyAssignment_1_0_0()); 
            // InternalBasicsParser.g:8702:2: ( rule__ExtensionEntry__KeyAssignment_1_0_0 )
            // InternalBasicsParser.g:8702:3: rule__ExtensionEntry__KeyAssignment_1_0_0
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
    // InternalBasicsParser.g:8710:1: rule__ExtensionEntry__Group_1_0__1 : rule__ExtensionEntry__Group_1_0__1__Impl ;
    public final void rule__ExtensionEntry__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8714:1: ( rule__ExtensionEntry__Group_1_0__1__Impl )
            // InternalBasicsParser.g:8715:2: rule__ExtensionEntry__Group_1_0__1__Impl
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
    // InternalBasicsParser.g:8721:1: rule__ExtensionEntry__Group_1_0__1__Impl : ( Colon ) ;
    public final void rule__ExtensionEntry__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8725:1: ( ( Colon ) )
            // InternalBasicsParser.g:8726:1: ( Colon )
            {
            // InternalBasicsParser.g:8726:1: ( Colon )
            // InternalBasicsParser.g:8727:2: Colon
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
    // InternalBasicsParser.g:8737:1: rule__ExtensionListValue__Group__0 : rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1 ;
    public final void rule__ExtensionListValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8741:1: ( rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1 )
            // InternalBasicsParser.g:8742:2: rule__ExtensionListValue__Group__0__Impl rule__ExtensionListValue__Group__1
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
    // InternalBasicsParser.g:8749:1: rule__ExtensionListValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionListValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8753:1: ( ( () ) )
            // InternalBasicsParser.g:8754:1: ( () )
            {
            // InternalBasicsParser.g:8754:1: ( () )
            // InternalBasicsParser.g:8755:2: ()
            {
             before(grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0()); 
            // InternalBasicsParser.g:8756:2: ()
            // InternalBasicsParser.g:8756:3: 
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
    // InternalBasicsParser.g:8764:1: rule__ExtensionListValue__Group__1 : rule__ExtensionListValue__Group__1__Impl rule__ExtensionListValue__Group__2 ;
    public final void rule__ExtensionListValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8768:1: ( rule__ExtensionListValue__Group__1__Impl rule__ExtensionListValue__Group__2 )
            // InternalBasicsParser.g:8769:2: rule__ExtensionListValue__Group__1__Impl rule__ExtensionListValue__Group__2
            {
            pushFollow(FOLLOW_56);
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
    // InternalBasicsParser.g:8776:1: rule__ExtensionListValue__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__ExtensionListValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8780:1: ( ( LeftSquareBracket ) )
            // InternalBasicsParser.g:8781:1: ( LeftSquareBracket )
            {
            // InternalBasicsParser.g:8781:1: ( LeftSquareBracket )
            // InternalBasicsParser.g:8782:2: LeftSquareBracket
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
    // InternalBasicsParser.g:8791:1: rule__ExtensionListValue__Group__2 : rule__ExtensionListValue__Group__2__Impl rule__ExtensionListValue__Group__3 ;
    public final void rule__ExtensionListValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8795:1: ( rule__ExtensionListValue__Group__2__Impl rule__ExtensionListValue__Group__3 )
            // InternalBasicsParser.g:8796:2: rule__ExtensionListValue__Group__2__Impl rule__ExtensionListValue__Group__3
            {
            pushFollow(FOLLOW_56);
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
    // InternalBasicsParser.g:8803:1: rule__ExtensionListValue__Group__2__Impl : ( ( rule__ExtensionListValue__Group_2__0 )? ) ;
    public final void rule__ExtensionListValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8807:1: ( ( ( rule__ExtensionListValue__Group_2__0 )? ) )
            // InternalBasicsParser.g:8808:1: ( ( rule__ExtensionListValue__Group_2__0 )? )
            {
            // InternalBasicsParser.g:8808:1: ( ( rule__ExtensionListValue__Group_2__0 )? )
            // InternalBasicsParser.g:8809:2: ( rule__ExtensionListValue__Group_2__0 )?
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup_2()); 
            // InternalBasicsParser.g:8810:2: ( rule__ExtensionListValue__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=Duration && LA37_0<=Feedback)||(LA37_0>=Boolean && LA37_0<=Float64)||(LA37_0>=Message && LA37_0<=Action)||LA37_0==Result||(LA37_0>=String_1 && LA37_0<=Uint64)||LA37_0==Array||(LA37_0>=Int16 && LA37_0<=Sub)||(LA37_0>=Uint8 && LA37_0<=Any)||LA37_0==LeftSquareBracket||LA37_0==LeftCurlyBracket||(LA37_0>=RULE_BOOLEAN && LA37_0<=RULE_DOUBLE)||(LA37_0>=RULE_ID && LA37_0<=RULE_INT)||LA37_0==RULE_BEGIN) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBasicsParser.g:8810:3: rule__ExtensionListValue__Group_2__0
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
    // InternalBasicsParser.g:8818:1: rule__ExtensionListValue__Group__3 : rule__ExtensionListValue__Group__3__Impl ;
    public final void rule__ExtensionListValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8822:1: ( rule__ExtensionListValue__Group__3__Impl )
            // InternalBasicsParser.g:8823:2: rule__ExtensionListValue__Group__3__Impl
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
    // InternalBasicsParser.g:8829:1: rule__ExtensionListValue__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__ExtensionListValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8833:1: ( ( RightSquareBracket ) )
            // InternalBasicsParser.g:8834:1: ( RightSquareBracket )
            {
            // InternalBasicsParser.g:8834:1: ( RightSquareBracket )
            // InternalBasicsParser.g:8835:2: RightSquareBracket
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
    // InternalBasicsParser.g:8845:1: rule__ExtensionListValue__Group_2__0 : rule__ExtensionListValue__Group_2__0__Impl rule__ExtensionListValue__Group_2__1 ;
    public final void rule__ExtensionListValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8849:1: ( rule__ExtensionListValue__Group_2__0__Impl rule__ExtensionListValue__Group_2__1 )
            // InternalBasicsParser.g:8850:2: rule__ExtensionListValue__Group_2__0__Impl rule__ExtensionListValue__Group_2__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalBasicsParser.g:8857:1: rule__ExtensionListValue__Group_2__0__Impl : ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) ) ;
    public final void rule__ExtensionListValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8861:1: ( ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) ) )
            // InternalBasicsParser.g:8862:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) )
            {
            // InternalBasicsParser.g:8862:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_0 ) )
            // InternalBasicsParser.g:8863:2: ( rule__ExtensionListValue__ItemsAssignment_2_0 )
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsAssignment_2_0()); 
            // InternalBasicsParser.g:8864:2: ( rule__ExtensionListValue__ItemsAssignment_2_0 )
            // InternalBasicsParser.g:8864:3: rule__ExtensionListValue__ItemsAssignment_2_0
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
    // InternalBasicsParser.g:8872:1: rule__ExtensionListValue__Group_2__1 : rule__ExtensionListValue__Group_2__1__Impl ;
    public final void rule__ExtensionListValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8876:1: ( rule__ExtensionListValue__Group_2__1__Impl )
            // InternalBasicsParser.g:8877:2: rule__ExtensionListValue__Group_2__1__Impl
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
    // InternalBasicsParser.g:8883:1: rule__ExtensionListValue__Group_2__1__Impl : ( ( rule__ExtensionListValue__Group_2_1__0 )* ) ;
    public final void rule__ExtensionListValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8887:1: ( ( ( rule__ExtensionListValue__Group_2_1__0 )* ) )
            // InternalBasicsParser.g:8888:1: ( ( rule__ExtensionListValue__Group_2_1__0 )* )
            {
            // InternalBasicsParser.g:8888:1: ( ( rule__ExtensionListValue__Group_2_1__0 )* )
            // InternalBasicsParser.g:8889:2: ( rule__ExtensionListValue__Group_2_1__0 )*
            {
             before(grammarAccess.getExtensionListValueAccess().getGroup_2_1()); 
            // InternalBasicsParser.g:8890:2: ( rule__ExtensionListValue__Group_2_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=Duration && LA38_0<=Feedback)||(LA38_0>=Boolean && LA38_0<=Float64)||(LA38_0>=Message && LA38_0<=Action)||LA38_0==Result||(LA38_0>=String_1 && LA38_0<=Uint64)||LA38_0==Array||(LA38_0>=Int16 && LA38_0<=Sub)||(LA38_0>=Uint8 && LA38_0<=Any)||LA38_0==Comma||LA38_0==LeftSquareBracket||LA38_0==LeftCurlyBracket||(LA38_0>=RULE_BOOLEAN && LA38_0<=RULE_DOUBLE)||(LA38_0>=RULE_ID && LA38_0<=RULE_INT)||LA38_0==RULE_BEGIN) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBasicsParser.g:8890:3: rule__ExtensionListValue__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__ExtensionListValue__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalBasicsParser.g:8899:1: rule__ExtensionListValue__Group_2_1__0 : rule__ExtensionListValue__Group_2_1__0__Impl rule__ExtensionListValue__Group_2_1__1 ;
    public final void rule__ExtensionListValue__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8903:1: ( rule__ExtensionListValue__Group_2_1__0__Impl rule__ExtensionListValue__Group_2_1__1 )
            // InternalBasicsParser.g:8904:2: rule__ExtensionListValue__Group_2_1__0__Impl rule__ExtensionListValue__Group_2_1__1
            {
            pushFollow(FOLLOW_57);
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
    // InternalBasicsParser.g:8911:1: rule__ExtensionListValue__Group_2_1__0__Impl : ( ( Comma )? ) ;
    public final void rule__ExtensionListValue__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8915:1: ( ( ( Comma )? ) )
            // InternalBasicsParser.g:8916:1: ( ( Comma )? )
            {
            // InternalBasicsParser.g:8916:1: ( ( Comma )? )
            // InternalBasicsParser.g:8917:2: ( Comma )?
            {
             before(grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0()); 
            // InternalBasicsParser.g:8918:2: ( Comma )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Comma) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalBasicsParser.g:8918:3: Comma
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
    // InternalBasicsParser.g:8926:1: rule__ExtensionListValue__Group_2_1__1 : rule__ExtensionListValue__Group_2_1__1__Impl ;
    public final void rule__ExtensionListValue__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8930:1: ( rule__ExtensionListValue__Group_2_1__1__Impl )
            // InternalBasicsParser.g:8931:2: rule__ExtensionListValue__Group_2_1__1__Impl
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
    // InternalBasicsParser.g:8937:1: rule__ExtensionListValue__Group_2_1__1__Impl : ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) ) ;
    public final void rule__ExtensionListValue__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8941:1: ( ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) ) )
            // InternalBasicsParser.g:8942:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) )
            {
            // InternalBasicsParser.g:8942:1: ( ( rule__ExtensionListValue__ItemsAssignment_2_1_1 ) )
            // InternalBasicsParser.g:8943:2: ( rule__ExtensionListValue__ItemsAssignment_2_1_1 )
            {
             before(grammarAccess.getExtensionListValueAccess().getItemsAssignment_2_1_1()); 
            // InternalBasicsParser.g:8944:2: ( rule__ExtensionListValue__ItemsAssignment_2_1_1 )
            // InternalBasicsParser.g:8944:3: rule__ExtensionListValue__ItemsAssignment_2_1_1
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
    // InternalBasicsParser.g:8953:1: rule__ExtensionBraceMapValue__Group__0 : rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1 ;
    public final void rule__ExtensionBraceMapValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8957:1: ( rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1 )
            // InternalBasicsParser.g:8958:2: rule__ExtensionBraceMapValue__Group__0__Impl rule__ExtensionBraceMapValue__Group__1
            {
            pushFollow(FOLLOW_59);
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
    // InternalBasicsParser.g:8965:1: rule__ExtensionBraceMapValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionBraceMapValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8969:1: ( ( () ) )
            // InternalBasicsParser.g:8970:1: ( () )
            {
            // InternalBasicsParser.g:8970:1: ( () )
            // InternalBasicsParser.g:8971:2: ()
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0()); 
            // InternalBasicsParser.g:8972:2: ()
            // InternalBasicsParser.g:8972:3: 
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
    // InternalBasicsParser.g:8980:1: rule__ExtensionBraceMapValue__Group__1 : rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2 ;
    public final void rule__ExtensionBraceMapValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8984:1: ( rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2 )
            // InternalBasicsParser.g:8985:2: rule__ExtensionBraceMapValue__Group__1__Impl rule__ExtensionBraceMapValue__Group__2
            {
            pushFollow(FOLLOW_60);
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
    // InternalBasicsParser.g:8992:1: rule__ExtensionBraceMapValue__Group__1__Impl : ( LeftCurlyBracket ) ;
    public final void rule__ExtensionBraceMapValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:8996:1: ( ( LeftCurlyBracket ) )
            // InternalBasicsParser.g:8997:1: ( LeftCurlyBracket )
            {
            // InternalBasicsParser.g:8997:1: ( LeftCurlyBracket )
            // InternalBasicsParser.g:8998:2: LeftCurlyBracket
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
    // InternalBasicsParser.g:9007:1: rule__ExtensionBraceMapValue__Group__2 : rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3 ;
    public final void rule__ExtensionBraceMapValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9011:1: ( rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3 )
            // InternalBasicsParser.g:9012:2: rule__ExtensionBraceMapValue__Group__2__Impl rule__ExtensionBraceMapValue__Group__3
            {
            pushFollow(FOLLOW_60);
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
    // InternalBasicsParser.g:9019:1: rule__ExtensionBraceMapValue__Group__2__Impl : ( ( rule__ExtensionBraceMapValue__Group_2__0 )? ) ;
    public final void rule__ExtensionBraceMapValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9023:1: ( ( ( rule__ExtensionBraceMapValue__Group_2__0 )? ) )
            // InternalBasicsParser.g:9024:1: ( ( rule__ExtensionBraceMapValue__Group_2__0 )? )
            {
            // InternalBasicsParser.g:9024:1: ( ( rule__ExtensionBraceMapValue__Group_2__0 )? )
            // InternalBasicsParser.g:9025:2: ( rule__ExtensionBraceMapValue__Group_2__0 )?
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2()); 
            // InternalBasicsParser.g:9026:2: ( rule__ExtensionBraceMapValue__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=Pluginbases && LA40_0<=Parameter)||(LA40_0>=Multiple && LA40_0<=Message)||(LA40_0>=Service && LA40_0<=Int64)||(LA40_0>=Type_1 && LA40_0<=List)||(LA40_0>=Bool && LA40_0<=Node)||(LA40_0>=Time && LA40_0<=Ns)||(LA40_0>=RULE_ID && LA40_0<=RULE_STRING)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBasicsParser.g:9026:3: rule__ExtensionBraceMapValue__Group_2__0
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
    // InternalBasicsParser.g:9034:1: rule__ExtensionBraceMapValue__Group__3 : rule__ExtensionBraceMapValue__Group__3__Impl ;
    public final void rule__ExtensionBraceMapValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9038:1: ( rule__ExtensionBraceMapValue__Group__3__Impl )
            // InternalBasicsParser.g:9039:2: rule__ExtensionBraceMapValue__Group__3__Impl
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
    // InternalBasicsParser.g:9045:1: rule__ExtensionBraceMapValue__Group__3__Impl : ( RightCurlyBracket ) ;
    public final void rule__ExtensionBraceMapValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9049:1: ( ( RightCurlyBracket ) )
            // InternalBasicsParser.g:9050:1: ( RightCurlyBracket )
            {
            // InternalBasicsParser.g:9050:1: ( RightCurlyBracket )
            // InternalBasicsParser.g:9051:2: RightCurlyBracket
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
    // InternalBasicsParser.g:9061:1: rule__ExtensionBraceMapValue__Group_2__0 : rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1 ;
    public final void rule__ExtensionBraceMapValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9065:1: ( rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1 )
            // InternalBasicsParser.g:9066:2: rule__ExtensionBraceMapValue__Group_2__0__Impl rule__ExtensionBraceMapValue__Group_2__1
            {
            pushFollow(FOLLOW_61);
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
    // InternalBasicsParser.g:9073:1: rule__ExtensionBraceMapValue__Group_2__0__Impl : ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) ) ;
    public final void rule__ExtensionBraceMapValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9077:1: ( ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) ) )
            // InternalBasicsParser.g:9078:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) )
            {
            // InternalBasicsParser.g:9078:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 ) )
            // InternalBasicsParser.g:9079:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_0()); 
            // InternalBasicsParser.g:9080:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_0 )
            // InternalBasicsParser.g:9080:3: rule__ExtensionBraceMapValue__EntriesAssignment_2_0
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
    // InternalBasicsParser.g:9088:1: rule__ExtensionBraceMapValue__Group_2__1 : rule__ExtensionBraceMapValue__Group_2__1__Impl ;
    public final void rule__ExtensionBraceMapValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9092:1: ( rule__ExtensionBraceMapValue__Group_2__1__Impl )
            // InternalBasicsParser.g:9093:2: rule__ExtensionBraceMapValue__Group_2__1__Impl
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
    // InternalBasicsParser.g:9099:1: rule__ExtensionBraceMapValue__Group_2__1__Impl : ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* ) ;
    public final void rule__ExtensionBraceMapValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9103:1: ( ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* ) )
            // InternalBasicsParser.g:9104:1: ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* )
            {
            // InternalBasicsParser.g:9104:1: ( ( rule__ExtensionBraceMapValue__Group_2_1__0 )* )
            // InternalBasicsParser.g:9105:2: ( rule__ExtensionBraceMapValue__Group_2_1__0 )*
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getGroup_2_1()); 
            // InternalBasicsParser.g:9106:2: ( rule__ExtensionBraceMapValue__Group_2_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=Pluginbases && LA41_0<=Parameter)||(LA41_0>=Multiple && LA41_0<=Message)||(LA41_0>=Service && LA41_0<=Int64)||(LA41_0>=Type_1 && LA41_0<=List)||(LA41_0>=Bool && LA41_0<=Node)||(LA41_0>=Time && LA41_0<=Ns)||LA41_0==Comma||(LA41_0>=RULE_ID && LA41_0<=RULE_STRING)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBasicsParser.g:9106:3: rule__ExtensionBraceMapValue__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_62);
            	    rule__ExtensionBraceMapValue__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalBasicsParser.g:9115:1: rule__ExtensionBraceMapValue__Group_2_1__0 : rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1 ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9119:1: ( rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1 )
            // InternalBasicsParser.g:9120:2: rule__ExtensionBraceMapValue__Group_2_1__0__Impl rule__ExtensionBraceMapValue__Group_2_1__1
            {
            pushFollow(FOLLOW_61);
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
    // InternalBasicsParser.g:9127:1: rule__ExtensionBraceMapValue__Group_2_1__0__Impl : ( ( Comma )? ) ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9131:1: ( ( ( Comma )? ) )
            // InternalBasicsParser.g:9132:1: ( ( Comma )? )
            {
            // InternalBasicsParser.g:9132:1: ( ( Comma )? )
            // InternalBasicsParser.g:9133:2: ( Comma )?
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0()); 
            // InternalBasicsParser.g:9134:2: ( Comma )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==Comma) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBasicsParser.g:9134:3: Comma
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
    // InternalBasicsParser.g:9142:1: rule__ExtensionBraceMapValue__Group_2_1__1 : rule__ExtensionBraceMapValue__Group_2_1__1__Impl ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9146:1: ( rule__ExtensionBraceMapValue__Group_2_1__1__Impl )
            // InternalBasicsParser.g:9147:2: rule__ExtensionBraceMapValue__Group_2_1__1__Impl
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
    // InternalBasicsParser.g:9153:1: rule__ExtensionBraceMapValue__Group_2_1__1__Impl : ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) ) ;
    public final void rule__ExtensionBraceMapValue__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9157:1: ( ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) ) )
            // InternalBasicsParser.g:9158:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) )
            {
            // InternalBasicsParser.g:9158:1: ( ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 ) )
            // InternalBasicsParser.g:9159:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 )
            {
             before(grammarAccess.getExtensionBraceMapValueAccess().getEntriesAssignment_2_1_1()); 
            // InternalBasicsParser.g:9160:2: ( rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 )
            // InternalBasicsParser.g:9160:3: rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1
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
    // InternalBasicsParser.g:9169:1: rule__ExtensionIndentedMapValue__Group__0 : rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1 ;
    public final void rule__ExtensionIndentedMapValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9173:1: ( rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1 )
            // InternalBasicsParser.g:9174:2: rule__ExtensionIndentedMapValue__Group__0__Impl rule__ExtensionIndentedMapValue__Group__1
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
    // InternalBasicsParser.g:9181:1: rule__ExtensionIndentedMapValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionIndentedMapValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9185:1: ( ( () ) )
            // InternalBasicsParser.g:9186:1: ( () )
            {
            // InternalBasicsParser.g:9186:1: ( () )
            // InternalBasicsParser.g:9187:2: ()
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0()); 
            // InternalBasicsParser.g:9188:2: ()
            // InternalBasicsParser.g:9188:3: 
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
    // InternalBasicsParser.g:9196:1: rule__ExtensionIndentedMapValue__Group__1 : rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2 ;
    public final void rule__ExtensionIndentedMapValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9200:1: ( rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2 )
            // InternalBasicsParser.g:9201:2: rule__ExtensionIndentedMapValue__Group__1__Impl rule__ExtensionIndentedMapValue__Group__2
            {
            pushFollow(FOLLOW_54);
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
    // InternalBasicsParser.g:9208:1: rule__ExtensionIndentedMapValue__Group__1__Impl : ( RULE_BEGIN ) ;
    public final void rule__ExtensionIndentedMapValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9212:1: ( ( RULE_BEGIN ) )
            // InternalBasicsParser.g:9213:1: ( RULE_BEGIN )
            {
            // InternalBasicsParser.g:9213:1: ( RULE_BEGIN )
            // InternalBasicsParser.g:9214:2: RULE_BEGIN
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
    // InternalBasicsParser.g:9223:1: rule__ExtensionIndentedMapValue__Group__2 : rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3 ;
    public final void rule__ExtensionIndentedMapValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9227:1: ( rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3 )
            // InternalBasicsParser.g:9228:2: rule__ExtensionIndentedMapValue__Group__2__Impl rule__ExtensionIndentedMapValue__Group__3
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
    // InternalBasicsParser.g:9235:1: rule__ExtensionIndentedMapValue__Group__2__Impl : ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) ) ;
    public final void rule__ExtensionIndentedMapValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9239:1: ( ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) ) )
            // InternalBasicsParser.g:9240:1: ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) )
            {
            // InternalBasicsParser.g:9240:1: ( ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* ) )
            // InternalBasicsParser.g:9241:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) ) ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* )
            {
            // InternalBasicsParser.g:9241:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 ) )
            // InternalBasicsParser.g:9242:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 
            // InternalBasicsParser.g:9243:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )
            // InternalBasicsParser.g:9243:4: rule__ExtensionIndentedMapValue__EntriesAssignment_2
            {
            pushFollow(FOLLOW_63);
            rule__ExtensionIndentedMapValue__EntriesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 

            }

            // InternalBasicsParser.g:9246:2: ( ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )* )
            // InternalBasicsParser.g:9247:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )*
            {
             before(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesAssignment_2()); 
            // InternalBasicsParser.g:9248:3: ( rule__ExtensionIndentedMapValue__EntriesAssignment_2 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=Pluginbases && LA43_0<=Parameter)||(LA43_0>=Multiple && LA43_0<=Message)||(LA43_0>=Service && LA43_0<=Int64)||(LA43_0>=Type_1 && LA43_0<=List)||(LA43_0>=Bool && LA43_0<=Node)||(LA43_0>=Time && LA43_0<=Ns)||(LA43_0>=RULE_ID && LA43_0<=RULE_STRING)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalBasicsParser.g:9248:4: rule__ExtensionIndentedMapValue__EntriesAssignment_2
            	    {
            	    pushFollow(FOLLOW_63);
            	    rule__ExtensionIndentedMapValue__EntriesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // InternalBasicsParser.g:9257:1: rule__ExtensionIndentedMapValue__Group__3 : rule__ExtensionIndentedMapValue__Group__3__Impl ;
    public final void rule__ExtensionIndentedMapValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9261:1: ( rule__ExtensionIndentedMapValue__Group__3__Impl )
            // InternalBasicsParser.g:9262:2: rule__ExtensionIndentedMapValue__Group__3__Impl
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
    // InternalBasicsParser.g:9268:1: rule__ExtensionIndentedMapValue__Group__3__Impl : ( RULE_END ) ;
    public final void rule__ExtensionIndentedMapValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9272:1: ( ( RULE_END ) )
            // InternalBasicsParser.g:9273:1: ( RULE_END )
            {
            // InternalBasicsParser.g:9273:1: ( RULE_END )
            // InternalBasicsParser.g:9274:2: RULE_END
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
    // InternalBasicsParser.g:9284:1: rule__ExtensionRefValue__Group__0 : rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1 ;
    public final void rule__ExtensionRefValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9288:1: ( rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1 )
            // InternalBasicsParser.g:9289:2: rule__ExtensionRefValue__Group__0__Impl rule__ExtensionRefValue__Group__1
            {
            pushFollow(FOLLOW_64);
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
    // InternalBasicsParser.g:9296:1: rule__ExtensionRefValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionRefValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9300:1: ( ( () ) )
            // InternalBasicsParser.g:9301:1: ( () )
            {
            // InternalBasicsParser.g:9301:1: ( () )
            // InternalBasicsParser.g:9302:2: ()
            {
             before(grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0()); 
            // InternalBasicsParser.g:9303:2: ()
            // InternalBasicsParser.g:9303:3: 
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
    // InternalBasicsParser.g:9311:1: rule__ExtensionRefValue__Group__1 : rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2 ;
    public final void rule__ExtensionRefValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9315:1: ( rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2 )
            // InternalBasicsParser.g:9316:2: rule__ExtensionRefValue__Group__1__Impl rule__ExtensionRefValue__Group__2
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
    // InternalBasicsParser.g:9323:1: rule__ExtensionRefValue__Group__1__Impl : ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) ) ;
    public final void rule__ExtensionRefValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9327:1: ( ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) ) )
            // InternalBasicsParser.g:9328:1: ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) )
            {
            // InternalBasicsParser.g:9328:1: ( ( rule__ExtensionRefValue__RefKindAssignment_1 ) )
            // InternalBasicsParser.g:9329:2: ( rule__ExtensionRefValue__RefKindAssignment_1 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getRefKindAssignment_1()); 
            // InternalBasicsParser.g:9330:2: ( rule__ExtensionRefValue__RefKindAssignment_1 )
            // InternalBasicsParser.g:9330:3: rule__ExtensionRefValue__RefKindAssignment_1
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
    // InternalBasicsParser.g:9338:1: rule__ExtensionRefValue__Group__2 : rule__ExtensionRefValue__Group__2__Impl ;
    public final void rule__ExtensionRefValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9342:1: ( rule__ExtensionRefValue__Group__2__Impl )
            // InternalBasicsParser.g:9343:2: rule__ExtensionRefValue__Group__2__Impl
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
    // InternalBasicsParser.g:9349:1: rule__ExtensionRefValue__Group__2__Impl : ( ( rule__ExtensionRefValue__TargetAssignment_2 ) ) ;
    public final void rule__ExtensionRefValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9353:1: ( ( ( rule__ExtensionRefValue__TargetAssignment_2 ) ) )
            // InternalBasicsParser.g:9354:1: ( ( rule__ExtensionRefValue__TargetAssignment_2 ) )
            {
            // InternalBasicsParser.g:9354:1: ( ( rule__ExtensionRefValue__TargetAssignment_2 ) )
            // InternalBasicsParser.g:9355:2: ( rule__ExtensionRefValue__TargetAssignment_2 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getTargetAssignment_2()); 
            // InternalBasicsParser.g:9356:2: ( rule__ExtensionRefValue__TargetAssignment_2 )
            // InternalBasicsParser.g:9356:3: rule__ExtensionRefValue__TargetAssignment_2
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
    // InternalBasicsParser.g:9365:1: rule__ExtensionScalarValue__Group__0 : rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1 ;
    public final void rule__ExtensionScalarValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9369:1: ( rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1 )
            // InternalBasicsParser.g:9370:2: rule__ExtensionScalarValue__Group__0__Impl rule__ExtensionScalarValue__Group__1
            {
            pushFollow(FOLLOW_55);
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
    // InternalBasicsParser.g:9377:1: rule__ExtensionScalarValue__Group__0__Impl : ( () ) ;
    public final void rule__ExtensionScalarValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9381:1: ( ( () ) )
            // InternalBasicsParser.g:9382:1: ( () )
            {
            // InternalBasicsParser.g:9382:1: ( () )
            // InternalBasicsParser.g:9383:2: ()
            {
             before(grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0()); 
            // InternalBasicsParser.g:9384:2: ()
            // InternalBasicsParser.g:9384:3: 
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
    // InternalBasicsParser.g:9392:1: rule__ExtensionScalarValue__Group__1 : rule__ExtensionScalarValue__Group__1__Impl ;
    public final void rule__ExtensionScalarValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9396:1: ( rule__ExtensionScalarValue__Group__1__Impl )
            // InternalBasicsParser.g:9397:2: rule__ExtensionScalarValue__Group__1__Impl
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
    // InternalBasicsParser.g:9403:1: rule__ExtensionScalarValue__Group__1__Impl : ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) ) ;
    public final void rule__ExtensionScalarValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9407:1: ( ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) ) )
            // InternalBasicsParser.g:9408:1: ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) )
            {
            // InternalBasicsParser.g:9408:1: ( ( rule__ExtensionScalarValue__ValueAssignment_1 ) )
            // InternalBasicsParser.g:9409:2: ( rule__ExtensionScalarValue__ValueAssignment_1 )
            {
             before(grammarAccess.getExtensionScalarValueAccess().getValueAssignment_1()); 
            // InternalBasicsParser.g:9410:2: ( rule__ExtensionScalarValue__ValueAssignment_1 )
            // InternalBasicsParser.g:9410:3: rule__ExtensionScalarValue__ValueAssignment_1
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
    // InternalBasicsParser.g:9419:1: rule__GlobalNamespace__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__GlobalNamespace__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9423:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:9424:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:9424:2: ( ruleGraphName )
            // InternalBasicsParser.g:9425:3: ruleGraphName
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
    // InternalBasicsParser.g:9434:1: rule__GlobalNamespace__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__GlobalNamespace__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9438:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:9439:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:9439:2: ( ruleGraphName )
            // InternalBasicsParser.g:9440:3: ruleGraphName
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
    // InternalBasicsParser.g:9449:1: rule__RelativeNamespace_Impl__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__RelativeNamespace_Impl__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9453:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:9454:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:9454:2: ( ruleGraphName )
            // InternalBasicsParser.g:9455:3: ruleGraphName
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
    // InternalBasicsParser.g:9464:1: rule__RelativeNamespace_Impl__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__RelativeNamespace_Impl__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9468:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:9469:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:9469:2: ( ruleGraphName )
            // InternalBasicsParser.g:9470:3: ruleGraphName
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
    // InternalBasicsParser.g:9479:1: rule__PrivateNamespace__PartsAssignment_2_1 : ( ruleGraphName ) ;
    public final void rule__PrivateNamespace__PartsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9483:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:9484:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:9484:2: ( ruleGraphName )
            // InternalBasicsParser.g:9485:3: ruleGraphName
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
    // InternalBasicsParser.g:9494:1: rule__PrivateNamespace__PartsAssignment_2_2_1 : ( ruleGraphName ) ;
    public final void rule__PrivateNamespace__PartsAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9498:1: ( ( ruleGraphName ) )
            // InternalBasicsParser.g:9499:2: ( ruleGraphName )
            {
            // InternalBasicsParser.g:9499:2: ( ruleGraphName )
            // InternalBasicsParser.g:9500:3: ruleGraphName
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
    // InternalBasicsParser.g:9509:1: rule__ParameterListType__SequenceAssignment_3 : ( ruleParameterType ) ;
    public final void rule__ParameterListType__SequenceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9513:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:9514:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:9514:2: ( ruleParameterType )
            // InternalBasicsParser.g:9515:3: ruleParameterType
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
    // InternalBasicsParser.g:9524:1: rule__ParameterListType__SequenceAssignment_4_1 : ( ruleParameterType ) ;
    public final void rule__ParameterListType__SequenceAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9528:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:9529:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:9529:2: ( ruleParameterType )
            // InternalBasicsParser.g:9530:3: ruleParameterType
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
    // InternalBasicsParser.g:9539:1: rule__ParameterStructType__ParameterstructypetmemberAssignment_3 : ( ruleParameterStructTypeMember ) ;
    public final void rule__ParameterStructType__ParameterstructypetmemberAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9543:1: ( ( ruleParameterStructTypeMember ) )
            // InternalBasicsParser.g:9544:2: ( ruleParameterStructTypeMember )
            {
            // InternalBasicsParser.g:9544:2: ( ruleParameterStructTypeMember )
            // InternalBasicsParser.g:9545:3: ruleParameterStructTypeMember
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
    // InternalBasicsParser.g:9554:1: rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1 : ( ruleParameterStructTypeMember ) ;
    public final void rule__ParameterStructType__ParameterstructypetmemberAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9558:1: ( ( ruleParameterStructTypeMember ) )
            // InternalBasicsParser.g:9559:2: ( ruleParameterStructTypeMember )
            {
            // InternalBasicsParser.g:9559:2: ( ruleParameterStructTypeMember )
            // InternalBasicsParser.g:9560:3: ruleParameterStructTypeMember
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
    // InternalBasicsParser.g:9569:1: rule__ParameterIntegerType__DefaultAssignment_2_1 : ( ruleParameterInteger ) ;
    public final void rule__ParameterIntegerType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9573:1: ( ( ruleParameterInteger ) )
            // InternalBasicsParser.g:9574:2: ( ruleParameterInteger )
            {
            // InternalBasicsParser.g:9574:2: ( ruleParameterInteger )
            // InternalBasicsParser.g:9575:3: ruleParameterInteger
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
    // InternalBasicsParser.g:9584:1: rule__ParameterStringType__DefaultAssignment_2_1 : ( ruleParameterString ) ;
    public final void rule__ParameterStringType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9588:1: ( ( ruleParameterString ) )
            // InternalBasicsParser.g:9589:2: ( ruleParameterString )
            {
            // InternalBasicsParser.g:9589:2: ( ruleParameterString )
            // InternalBasicsParser.g:9590:3: ruleParameterString
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
    // InternalBasicsParser.g:9599:1: rule__ParameterDoubleType__DefaultAssignment_2_1 : ( ruleParameterDouble ) ;
    public final void rule__ParameterDoubleType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9603:1: ( ( ruleParameterDouble ) )
            // InternalBasicsParser.g:9604:2: ( ruleParameterDouble )
            {
            // InternalBasicsParser.g:9604:2: ( ruleParameterDouble )
            // InternalBasicsParser.g:9605:3: ruleParameterDouble
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
    // InternalBasicsParser.g:9614:1: rule__ParameterBooleanType__DefaultAssignment_2_1 : ( ruleParameterBoolean ) ;
    public final void rule__ParameterBooleanType__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9618:1: ( ( ruleParameterBoolean ) )
            // InternalBasicsParser.g:9619:2: ( ruleParameterBoolean )
            {
            // InternalBasicsParser.g:9619:2: ( ruleParameterBoolean )
            // InternalBasicsParser.g:9620:3: ruleParameterBoolean
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
    // InternalBasicsParser.g:9629:1: rule__ParameterBase64Type__DefaultAssignment_2_1 : ( ruleParameterBase64 ) ;
    public final void rule__ParameterBase64Type__DefaultAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9633:1: ( ( ruleParameterBase64 ) )
            // InternalBasicsParser.g:9634:2: ( ruleParameterBase64 )
            {
            // InternalBasicsParser.g:9634:2: ( ruleParameterBase64 )
            // InternalBasicsParser.g:9635:3: ruleParameterBase64
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
    // InternalBasicsParser.g:9644:1: rule__ParameterArrayType__TypeAssignment_2 : ( ruleParameterType ) ;
    public final void rule__ParameterArrayType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9648:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:9649:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:9649:2: ( ruleParameterType )
            // InternalBasicsParser.g:9650:3: ruleParameterType
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
    // InternalBasicsParser.g:9659:1: rule__ParameterArrayType__DefaultAssignment_4_1 : ( ruleParameterList ) ;
    public final void rule__ParameterArrayType__DefaultAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9663:1: ( ( ruleParameterList ) )
            // InternalBasicsParser.g:9664:2: ( ruleParameterList )
            {
            // InternalBasicsParser.g:9664:2: ( ruleParameterList )
            // InternalBasicsParser.g:9665:3: ruleParameterList
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
    // InternalBasicsParser.g:9674:1: rule__ParameterList__ValueAssignment_2 : ( ruleParameterValue ) ;
    public final void rule__ParameterList__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9678:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:9679:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:9679:2: ( ruleParameterValue )
            // InternalBasicsParser.g:9680:3: ruleParameterValue
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
    // InternalBasicsParser.g:9689:1: rule__ParameterList__ValueAssignment_3_1 : ( ruleParameterValue ) ;
    public final void rule__ParameterList__ValueAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9693:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:9694:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:9694:2: ( ruleParameterValue )
            // InternalBasicsParser.g:9695:3: ruleParameterValue
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
    // InternalBasicsParser.g:9704:1: rule__ParameterAny__ValueAssignment_2_1 : ( ruleEString ) ;
    public final void rule__ParameterAny__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9708:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:9709:2: ( ruleEString )
            {
            // InternalBasicsParser.g:9709:2: ( ruleEString )
            // InternalBasicsParser.g:9710:3: ruleEString
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
    // InternalBasicsParser.g:9719:1: rule__ParameterString__ValueAssignment : ( ruleEString ) ;
    public final void rule__ParameterString__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9723:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:9724:2: ( ruleEString )
            {
            // InternalBasicsParser.g:9724:2: ( ruleEString )
            // InternalBasicsParser.g:9725:3: ruleEString
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
    // InternalBasicsParser.g:9734:1: rule__ParameterBase64__ValueAssignment : ( ruleBase64Binary ) ;
    public final void rule__ParameterBase64__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9738:1: ( ( ruleBase64Binary ) )
            // InternalBasicsParser.g:9739:2: ( ruleBase64Binary )
            {
            // InternalBasicsParser.g:9739:2: ( ruleBase64Binary )
            // InternalBasicsParser.g:9740:3: ruleBase64Binary
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
    // InternalBasicsParser.g:9749:1: rule__ParameterInteger__ValueAssignment : ( ruleInteger0 ) ;
    public final void rule__ParameterInteger__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9753:1: ( ( ruleInteger0 ) )
            // InternalBasicsParser.g:9754:2: ( ruleInteger0 )
            {
            // InternalBasicsParser.g:9754:2: ( ruleInteger0 )
            // InternalBasicsParser.g:9755:3: ruleInteger0
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
    // InternalBasicsParser.g:9764:1: rule__ParameterDouble__ValueAssignment : ( ruleDouble0 ) ;
    public final void rule__ParameterDouble__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9768:1: ( ( ruleDouble0 ) )
            // InternalBasicsParser.g:9769:2: ( ruleDouble0 )
            {
            // InternalBasicsParser.g:9769:2: ( ruleDouble0 )
            // InternalBasicsParser.g:9770:3: ruleDouble0
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
    // InternalBasicsParser.g:9779:1: rule__ParameterBoolean__ValueAssignment : ( ruleboolean0 ) ;
    public final void rule__ParameterBoolean__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9783:1: ( ( ruleboolean0 ) )
            // InternalBasicsParser.g:9784:2: ( ruleboolean0 )
            {
            // InternalBasicsParser.g:9784:2: ( ruleboolean0 )
            // InternalBasicsParser.g:9785:3: ruleboolean0
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
    // InternalBasicsParser.g:9794:1: rule__ParameterStruct__ValueAssignment_1_2 : ( ruleParameterStructMember ) ;
    public final void rule__ParameterStruct__ValueAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9798:1: ( ( ruleParameterStructMember ) )
            // InternalBasicsParser.g:9799:2: ( ruleParameterStructMember )
            {
            // InternalBasicsParser.g:9799:2: ( ruleParameterStructMember )
            // InternalBasicsParser.g:9800:3: ruleParameterStructMember
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
    // InternalBasicsParser.g:9809:1: rule__ParameterDate__ValueAssignment : ( ruleDateTime0 ) ;
    public final void rule__ParameterDate__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9813:1: ( ( ruleDateTime0 ) )
            // InternalBasicsParser.g:9814:2: ( ruleDateTime0 )
            {
            // InternalBasicsParser.g:9814:2: ( ruleDateTime0 )
            // InternalBasicsParser.g:9815:3: ruleDateTime0
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
    // InternalBasicsParser.g:9824:1: rule__ParameterStructMember__NameAssignment_0_0_0 : ( ruleEString ) ;
    public final void rule__ParameterStructMember__NameAssignment_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9828:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:9829:2: ( ruleEString )
            {
            // InternalBasicsParser.g:9829:2: ( ruleEString )
            // InternalBasicsParser.g:9830:3: ruleEString
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
    // InternalBasicsParser.g:9839:1: rule__ParameterStructMember__NameAssignment_0_1 : ( ruleAddedKeywordName ) ;
    public final void rule__ParameterStructMember__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9843:1: ( ( ruleAddedKeywordName ) )
            // InternalBasicsParser.g:9844:2: ( ruleAddedKeywordName )
            {
            // InternalBasicsParser.g:9844:2: ( ruleAddedKeywordName )
            // InternalBasicsParser.g:9845:3: ruleAddedKeywordName
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
    // InternalBasicsParser.g:9854:1: rule__ParameterStructMember__ValueAssignment_1 : ( ruleParameterValue ) ;
    public final void rule__ParameterStructMember__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9858:1: ( ( ruleParameterValue ) )
            // InternalBasicsParser.g:9859:2: ( ruleParameterValue )
            {
            // InternalBasicsParser.g:9859:2: ( ruleParameterValue )
            // InternalBasicsParser.g:9860:3: ruleParameterValue
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
    // InternalBasicsParser.g:9869:1: rule__ParameterStructTypeMember__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__ParameterStructTypeMember__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9873:1: ( ( ruleEString ) )
            // InternalBasicsParser.g:9874:2: ( ruleEString )
            {
            // InternalBasicsParser.g:9874:2: ( ruleEString )
            // InternalBasicsParser.g:9875:3: ruleEString
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
    // InternalBasicsParser.g:9884:1: rule__ParameterStructTypeMember__TypeAssignment_1 : ( ruleParameterType ) ;
    public final void rule__ParameterStructTypeMember__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9888:1: ( ( ruleParameterType ) )
            // InternalBasicsParser.g:9889:2: ( ruleParameterType )
            {
            // InternalBasicsParser.g:9889:2: ( ruleParameterType )
            // InternalBasicsParser.g:9890:3: ruleParameterType
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


    // $ANTLR start "rule__AbstractType__BoundedAssignment_0_1_2"
    // InternalBasicsParser.g:9899:1: rule__AbstractType__BoundedAssignment_0_1_2 : ( ( LessThanSignEqualsSign ) ) ;
    public final void rule__AbstractType__BoundedAssignment_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9903:1: ( ( ( LessThanSignEqualsSign ) ) )
            // InternalBasicsParser.g:9904:2: ( ( LessThanSignEqualsSign ) )
            {
            // InternalBasicsParser.g:9904:2: ( ( LessThanSignEqualsSign ) )
            // InternalBasicsParser.g:9905:3: ( LessThanSignEqualsSign )
            {
             before(grammarAccess.getAbstractTypeAccess().getBoundedLessThanSignEqualsSignKeyword_0_1_2_0()); 
            // InternalBasicsParser.g:9906:3: ( LessThanSignEqualsSign )
            // InternalBasicsParser.g:9907:4: LessThanSignEqualsSign
            {
             before(grammarAccess.getAbstractTypeAccess().getBoundedLessThanSignEqualsSignKeyword_0_1_2_0()); 
            match(input,LessThanSignEqualsSign,FOLLOW_2); 
             after(grammarAccess.getAbstractTypeAccess().getBoundedLessThanSignEqualsSignKeyword_0_1_2_0()); 

            }

             after(grammarAccess.getAbstractTypeAccess().getBoundedLessThanSignEqualsSignKeyword_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__BoundedAssignment_0_1_2"


    // $ANTLR start "rule__AbstractType__SizeAssignment_0_1_3"
    // InternalBasicsParser.g:9918:1: rule__AbstractType__SizeAssignment_0_1_3 : ( ruleArraySize ) ;
    public final void rule__AbstractType__SizeAssignment_0_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9922:1: ( ( ruleArraySize ) )
            // InternalBasicsParser.g:9923:2: ( ruleArraySize )
            {
            // InternalBasicsParser.g:9923:2: ( ruleArraySize )
            // InternalBasicsParser.g:9924:3: ruleArraySize
            {
             before(grammarAccess.getAbstractTypeAccess().getSizeArraySizeParserRuleCall_0_1_3_0()); 
            pushFollow(FOLLOW_2);
            ruleArraySize();

            state._fsp--;

             after(grammarAccess.getAbstractTypeAccess().getSizeArraySizeParserRuleCall_0_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractType__SizeAssignment_0_1_3"


    // $ANTLR start "rule__SpecBaseRef__ReferenceAssignment"
    // InternalBasicsParser.g:9933:1: rule__SpecBaseRef__ReferenceAssignment : ( ( ruleEString ) ) ;
    public final void rule__SpecBaseRef__ReferenceAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9937:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:9938:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:9938:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:9939:3: ( ruleEString )
            {
             before(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecCrossReference_0()); 
            // InternalBasicsParser.g:9940:3: ( ruleEString )
            // InternalBasicsParser.g:9941:4: ruleEString
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
    // InternalBasicsParser.g:9952:1: rule__ArraySpecRef__ReferenceAssignment_0 : ( ( ruleEString ) ) ;
    public final void rule__ArraySpecRef__ReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9956:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:9957:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:9957:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:9958:3: ( ruleEString )
            {
             before(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0()); 
            // InternalBasicsParser.g:9959:3: ( ruleEString )
            // InternalBasicsParser.g:9960:4: ruleEString
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
    // InternalBasicsParser.g:9971:1: rule__ExtensionEntry__KeyAssignment_1_0_0 : ( ruleExtensionKey ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9975:1: ( ( ruleExtensionKey ) )
            // InternalBasicsParser.g:9976:2: ( ruleExtensionKey )
            {
            // InternalBasicsParser.g:9976:2: ( ruleExtensionKey )
            // InternalBasicsParser.g:9977:3: ruleExtensionKey
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
    // InternalBasicsParser.g:9986:1: rule__ExtensionEntry__KeyAssignment_1_1 : ( ruleExtensionColonKey ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:9990:1: ( ( ruleExtensionColonKey ) )
            // InternalBasicsParser.g:9991:2: ( ruleExtensionColonKey )
            {
            // InternalBasicsParser.g:9991:2: ( ruleExtensionColonKey )
            // InternalBasicsParser.g:9992:3: ruleExtensionColonKey
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
    // InternalBasicsParser.g:10001:1: rule__ExtensionEntry__KeyAssignment_1_2 : ( ruleAddedKeywordName ) ;
    public final void rule__ExtensionEntry__KeyAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10005:1: ( ( ruleAddedKeywordName ) )
            // InternalBasicsParser.g:10006:2: ( ruleAddedKeywordName )
            {
            // InternalBasicsParser.g:10006:2: ( ruleAddedKeywordName )
            // InternalBasicsParser.g:10007:3: ruleAddedKeywordName
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
    // InternalBasicsParser.g:10016:1: rule__ExtensionEntry__ValueAssignment_2 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionEntry__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10020:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:10021:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:10021:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:10022:3: ruleExtensionValue
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
    // InternalBasicsParser.g:10031:1: rule__ExtensionListValue__ItemsAssignment_2_0 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionListValue__ItemsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10035:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:10036:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:10036:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:10037:3: ruleExtensionValue
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
    // InternalBasicsParser.g:10046:1: rule__ExtensionListValue__ItemsAssignment_2_1_1 : ( ruleExtensionValue ) ;
    public final void rule__ExtensionListValue__ItemsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10050:1: ( ( ruleExtensionValue ) )
            // InternalBasicsParser.g:10051:2: ( ruleExtensionValue )
            {
            // InternalBasicsParser.g:10051:2: ( ruleExtensionValue )
            // InternalBasicsParser.g:10052:3: ruleExtensionValue
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
    // InternalBasicsParser.g:10061:1: rule__ExtensionBraceMapValue__EntriesAssignment_2_0 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionBraceMapValue__EntriesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10065:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:10066:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:10066:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:10067:3: ruleExtensionEntry
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
    // InternalBasicsParser.g:10076:1: rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionBraceMapValue__EntriesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10080:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:10081:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:10081:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:10082:3: ruleExtensionEntry
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
    // InternalBasicsParser.g:10091:1: rule__ExtensionIndentedMapValue__EntriesAssignment_2 : ( ruleExtensionEntry ) ;
    public final void rule__ExtensionIndentedMapValue__EntriesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10095:1: ( ( ruleExtensionEntry ) )
            // InternalBasicsParser.g:10096:2: ( ruleExtensionEntry )
            {
            // InternalBasicsParser.g:10096:2: ( ruleExtensionEntry )
            // InternalBasicsParser.g:10097:3: ruleExtensionEntry
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
    // InternalBasicsParser.g:10106:1: rule__ExtensionRefValue__RefKindAssignment_1 : ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) ) ;
    public final void rule__ExtensionRefValue__RefKindAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10110:1: ( ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) ) )
            // InternalBasicsParser.g:10111:2: ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) )
            {
            // InternalBasicsParser.g:10111:2: ( ( rule__ExtensionRefValue__RefKindAlternatives_1_0 ) )
            // InternalBasicsParser.g:10112:3: ( rule__ExtensionRefValue__RefKindAlternatives_1_0 )
            {
             before(grammarAccess.getExtensionRefValueAccess().getRefKindAlternatives_1_0()); 
            // InternalBasicsParser.g:10113:3: ( rule__ExtensionRefValue__RefKindAlternatives_1_0 )
            // InternalBasicsParser.g:10113:4: rule__ExtensionRefValue__RefKindAlternatives_1_0
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
    // InternalBasicsParser.g:10121:1: rule__ExtensionRefValue__TargetAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__ExtensionRefValue__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10125:1: ( ( ( ruleEString ) ) )
            // InternalBasicsParser.g:10126:2: ( ( ruleEString ) )
            {
            // InternalBasicsParser.g:10126:2: ( ( ruleEString ) )
            // InternalBasicsParser.g:10127:3: ( ruleEString )
            {
             before(grammarAccess.getExtensionRefValueAccess().getTargetEObjectCrossReference_2_0()); 
            // InternalBasicsParser.g:10128:3: ( ruleEString )
            // InternalBasicsParser.g:10129:4: ruleEString
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
    // InternalBasicsParser.g:10140:1: rule__ExtensionScalarValue__ValueAssignment_1 : ( ruleExtensionScalarLiteral ) ;
    public final void rule__ExtensionScalarValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBasicsParser.g:10144:1: ( ( ruleExtensionScalarLiteral ) )
            // InternalBasicsParser.g:10145:2: ( ruleExtensionScalarLiteral )
            {
            // InternalBasicsParser.g:10145:2: ( ruleExtensionScalarLiteral )
            // InternalBasicsParser.g:10146:3: ruleExtensionScalarLiteral
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
    static final String dfa_3s = "\3\10\4\uffff\1\110\3\uffff";
    static final String dfa_4s = "\3\134\4\uffff\1\137\3\uffff";
    static final String dfa_5s = "\3\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\6\10\1\uffff\1\10\3\uffff\1\10\4\uffff\3\10\11\uffff\1\10\1\uffff\1\10\6\uffff\1\10\32\uffff\1\10\3\uffff\1\7\1\10\3\uffff\1\3\1\6\1\4\1\5\6\uffff\1\2\1\1",
            "\6\11\1\uffff\1\11\3\uffff\1\11\4\uffff\3\11\11\uffff\1\11\1\uffff\1\11\6\uffff\1\11\32\uffff\1\11\1\uffff\1\10\2\uffff\1\11\15\uffff\2\11",
            "\6\11\1\uffff\1\11\3\uffff\1\11\4\uffff\3\11\11\uffff\1\11\1\uffff\1\11\6\uffff\1\11\32\uffff\1\11\1\uffff\1\10\2\uffff\1\11\15\uffff\2\11",
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
            return "2239:1: rule__ParameterValue__Alternatives : ( ( ruleParameterString ) | ( ruleParameterBase64 ) | ( ruleParameterInteger ) | ( ruleParameterDouble ) | ( ruleParameterBoolean ) | ( ruleParameterList ) | ( ruleParameterStruct ) );";
        }
    }
    static final String dfa_8s = "\60\uffff";
    static final String dfa_9s = "\1\uffff\15\16\1\uffff\3\16\36\uffff";
    static final String dfa_10s = "\1\21\15\114\1\uffff\3\114\17\107\17\uffff";
    static final String dfa_11s = "\1\134\15\114\1\uffff\3\114\17\123\17\uffff";
    static final String dfa_12s = "\16\uffff\1\1\22\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20";
    static final String dfa_13s = "\60\uffff}>";
    static final String[] dfa_14s = {
            "\1\16\4\uffff\1\12\1\13\10\uffff\1\16\6\uffff\1\14\1\5\1\7\1\11\3\uffff\1\4\1\6\1\10\3\uffff\1\3\5\uffff\1\1\1\15\1\21\1\uffff\1\2\4\uffff\1\16\27\uffff\1\20\1\17",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "\1\37",
            "\1\37",
            "\1\40",
            "\1\16\5\uffff\1\41\5\uffff\1\16",
            "\1\16\5\uffff\1\42\5\uffff\1\16",
            "\1\16\5\uffff\1\43\5\uffff\1\16",
            "\1\16\5\uffff\1\44\5\uffff\1\16",
            "\1\16\5\uffff\1\45\5\uffff\1\16",
            "\1\16\5\uffff\1\46\5\uffff\1\16",
            "\1\16\5\uffff\1\47\5\uffff\1\16",
            "\1\16\5\uffff\1\50\5\uffff\1\16",
            "\1\16\5\uffff\1\51\5\uffff\1\16",
            "\1\16\5\uffff\1\52\5\uffff\1\16",
            "\1\16\5\uffff\1\53\5\uffff\1\16",
            "\1\16\5\uffff\1\54\5\uffff\1\16",
            "\1\16\5\uffff\1\55\5\uffff\1\16",
            "\1\16\5\uffff\1\56\5\uffff\1\16",
            "\1\16\5\uffff\1\57\5\uffff\1\16",
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
            return "2311:1: rule__AbstractType__Alternatives : ( ( ( rule__AbstractType__Group_0__0 ) ) | ( ruleboolArray ) | ( ruleint8Array ) | ( ruleuint8Array ) | ( ruleint16Array ) | ( ruleuint16Array ) | ( ruleint32Array ) | ( ruleuint32Array ) | ( ruleint64Array ) | ( ruleuint64Array ) | ( rulefloat32Array ) | ( rulefloat64Array ) | ( rulestring0Array ) | ( rulebyteArray ) | ( ruleArraySpecRef ) | ( rulecharArray ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00801006C0300000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x00000000181E1000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000020500708BF00L,0x0000000018002000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x000020500708BF02L,0x0000000018000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080080L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0xFCF9FFFFEFFFBF00L,0x0000000018000079L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0xFFF7D7AFF8F60000L,0x00000000B81C503FL});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0xFFF7D7AFF8F60000L,0x00000000B81C703FL});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xFFF7D7AFF8F60000L,0x00000000B81C513FL});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0xFFF7D7AFF8F60002L,0x00000000B81C513FL});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0xFCF9FFFFEFFFBF00L,0x0000000018008079L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0xFCF9FFFFEFFFBF00L,0x0000000018000179L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0xFCF9FFFFEFFFBF02L,0x0000000018000179L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0xFCF9FFFFEFFFBF02L,0x0000000018000079L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0306000010000000L,0x0000000000000006L});

}