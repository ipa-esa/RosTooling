package de.fraunhofer.ipa.rossystem.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.fraunhofer.ipa.rossystem.services.RosSystemGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalRosSystemParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "ParameterAny", "Connections", "Interfaces", "Parameters", "SubSystems", "Namespace", "Processes", "GraphName", "Float32_1", "Float64_1", "FromFile", "Default", "Duration", "Feedback", "Plugins", "String_2", "Threads", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Float32", "Float64", "Int16_1", "Int32_1", "Int64_1", "Message", "Param", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Int8_1", "Nodes", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "From", "Int16", "Int32", "Int64", "Pub", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "HyphenMinus", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Connections=8;
    public static final int Float32_1=15;
    public static final int Node=75;
    public static final int RULE_DATE_TIME=102;
    public static final int Uint64_1=26;
    public static final int String=41;
    public static final int Processes=13;
    public static final int Int16=57;
    public static final int SubSystems=11;
    public static final int Float32=29;
    public static final int Goal=72;
    public static final int Bool=69;
    public static final int Uint16=51;
    public static final int Boolean=27;
    public static final int Sub=61;
    public static final int Uint8=63;
    public static final int Parameters=10;
    public static final int RULE_ID=103;
    public static final int RULE_DIGIT=92;
    public static final int GlobalNamespace=6;
    public static final int Namespace=12;
    public static final int Int16_1=31;
    public static final int Header=40;
    public static final int RULE_INT=105;
    public static final int Byte=70;
    public static final int RULE_ML_COMMENT=112;
    public static final int LeftSquareBracket=88;
    public static final int Ac=67;
    public static final int Base64=38;
    public static final int Comma=83;
    public static final int As=68;
    public static final int HyphenMinus=84;
    public static final int RULE_MESSAGE_ASIGMENT=106;
    public static final int LeftSquareBracketRightSquareBracket=82;
    public static final int Int32=58;
    public static final int Char=71;
    public static final int RightCurlyBracket=91;
    public static final int RULE_DECINT=95;
    public static final int Uint32=52;
    public static final int Plugins=21;
    public static final int FullStop=85;
    public static final int RULE_HOUR=100;
    public static final int Int8=73;
    public static final int Default=18;
    public static final int Int8_1=47;
    public static final int CommercialAt=87;
    public static final int Uint16_1=24;
    public static final int Sc=76;
    public static final int Type=79;
    public static final int Float64=30;
    public static final int Int32_1=32;
    public static final int RULE_BINARY=93;
    public static final int String_1=50;
    public static final int String_2=22;
    public static final int Ss=77;
    public static final int RULE_DAY=97;
    public static final int RULE_BEGIN=107;
    public static final int RULE_BOOLEAN=94;
    public static final int RelativeNamespace=4;
    public static final int RULE_YEAR=99;
    public static final int Result=49;
    public static final int Name=74;
    public static final int RULE_MIN_SEC=101;
    public static final int Char_1=46;
    public static final int ParameterAny=7;
    public static final int List=66;
    public static final int RightSquareBracket=89;
    public static final int PrivateNamespace=5;
    public static final int GraphName=14;
    public static final int Byte_1=45;
    public static final int Float64_1=16;
    public static final int Duration=19;
    public static final int Uint32_1=25;
    public static final int Double=39;
    public static final int Type_1=62;
    public static final int Value=64;
    public static final int Uint64=53;
    public static final int FromFile=17;
    public static final int Action=43;
    public static final int RULE_END=108;
    public static final int Message=34;
    public static final int Value_1=54;
    public static final int Time=78;
    public static final int RULE_STRING=104;
    public static final int Bool_1=44;
    public static final int Any=80;
    public static final int Struct=42;
    public static final int RULE_SL_COMMENT=109;
    public static final int Uint8_1=37;
    public static final int RULE_DOUBLE=96;
    public static final int Feedback=20;
    public static final int RULE_ROS_CONVENTION_A=110;
    public static final int RULE_ROS_CONVENTION_PARAM=111;
    public static final int Colon=86;
    public static final int Pub=60;
    public static final int EOF=-1;
    public static final int Ns=81;
    public static final int RULE_WS=113;
    public static final int Int64_1=33;
    public static final int LeftCurlyBracket=90;
    public static final int Service=36;
    public static final int From=56;
    public static final int RULE_ANY_OTHER=114;
    public static final int Nodes=48;
    public static final int Date=65;
    public static final int Interfaces=9;
    public static final int Threads=23;
    public static final int Integer=28;
    public static final int Array=55;
    public static final int Int64=59;
    public static final int Param=35;
    public static final int RULE_MONTH=98;

    // delegates
    // delegators


        public InternalRosSystemParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRosSystemParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRosSystemParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRosSystemParser.g"; }



     	private RosSystemGrammarAccess grammarAccess;

        public InternalRosSystemParser(TokenStream input, RosSystemGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "System";
       	}

       	@Override
       	protected RosSystemGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSystem"
    // InternalRosSystemParser.g:57:1: entryRuleSystem returns [EObject current=null] : iv_ruleSystem= ruleSystem EOF ;
    public final EObject entryRuleSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystem = null;


        try {
            // InternalRosSystemParser.g:57:47: (iv_ruleSystem= ruleSystem EOF )
            // InternalRosSystemParser.g:58:2: iv_ruleSystem= ruleSystem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSystem=ruleSystem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystem; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystem"


    // $ANTLR start "ruleSystem"
    // InternalRosSystemParser.g:64:1: ruleSystem returns [EObject current=null] : this_RosSystem_0= ruleRosSystem ;
    public final EObject ruleSystem() throws RecognitionException {
        EObject current = null;

        EObject this_RosSystem_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:70:2: (this_RosSystem_0= ruleRosSystem )
            // InternalRosSystemParser.g:71:2: this_RosSystem_0= ruleRosSystem
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getSystemAccess().getRosSystemParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_RosSystem_0=ruleRosSystem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_RosSystem_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystem"


    // $ANTLR start "entryRuleRosSystem"
    // InternalRosSystemParser.g:82:1: entryRuleRosSystem returns [EObject current=null] : iv_ruleRosSystem= ruleRosSystem EOF ;
    public final EObject entryRuleRosSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosSystem = null;


        try {
            // InternalRosSystemParser.g:82:50: (iv_ruleRosSystem= ruleRosSystem EOF )
            // InternalRosSystemParser.g:83:2: iv_ruleRosSystem= ruleRosSystem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosSystemRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosSystem=ruleRosSystem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosSystem; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosSystem"


    // $ANTLR start "ruleRosSystem"
    // InternalRosSystemParser.g:89:1: ruleRosSystem returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN (otherlv_3= FromFile ( (lv_fromFile_4_0= ruleEString ) ) )? ( (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END ) | (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END ) | (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END ) | (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END ) | (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END ) | ( (lv_extensions_25_0= ruleExtensionBlock ) ) )* this_END_26= RULE_END ) ;
    public final EObject ruleRosSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token this_BEGIN_6=null;
        Token this_END_8=null;
        Token otherlv_9=null;
        Token this_BEGIN_10=null;
        Token this_END_12=null;
        Token otherlv_13=null;
        Token this_BEGIN_14=null;
        Token this_END_16=null;
        Token otherlv_17=null;
        Token this_BEGIN_18=null;
        Token this_END_20=null;
        Token otherlv_21=null;
        Token this_BEGIN_22=null;
        Token this_END_24=null;
        Token this_END_26=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_fromFile_4_0 = null;

        EObject lv_components_7_0 = null;

        EObject lv_processes_11_0 = null;

        EObject lv_components_15_0 = null;

        EObject lv_parameter_19_0 = null;

        EObject lv_connections_23_0 = null;

        EObject lv_extensions_25_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:95:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN (otherlv_3= FromFile ( (lv_fromFile_4_0= ruleEString ) ) )? ( (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END ) | (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END ) | (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END ) | (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END ) | (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END ) | ( (lv_extensions_25_0= ruleExtensionBlock ) ) )* this_END_26= RULE_END ) )
            // InternalRosSystemParser.g:96:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN (otherlv_3= FromFile ( (lv_fromFile_4_0= ruleEString ) ) )? ( (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END ) | (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END ) | (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END ) | (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END ) | (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END ) | ( (lv_extensions_25_0= ruleExtensionBlock ) ) )* this_END_26= RULE_END )
            {
            // InternalRosSystemParser.g:96:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN (otherlv_3= FromFile ( (lv_fromFile_4_0= ruleEString ) ) )? ( (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END ) | (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END ) | (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END ) | (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END ) | (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END ) | ( (lv_extensions_25_0= ruleExtensionBlock ) ) )* this_END_26= RULE_END )
            // InternalRosSystemParser.g:97:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon this_BEGIN_2= RULE_BEGIN (otherlv_3= FromFile ( (lv_fromFile_4_0= ruleEString ) ) )? ( (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END ) | (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END ) | (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END ) | (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END ) | (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END ) | ( (lv_extensions_25_0= ruleExtensionBlock ) ) )* this_END_26= RULE_END
            {
            // InternalRosSystemParser.g:97:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosSystemParser.g:98:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:98:4: (lv_name_0_0= ruleEString )
            // InternalRosSystemParser.g:99:5: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSystemAccess().getNameEStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosSystemRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_0_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosSystemAccess().getColonKeyword_1());
              		
            }
            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_2, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_2());
              		
            }
            // InternalRosSystemParser.g:124:3: (otherlv_3= FromFile ( (lv_fromFile_4_0= ruleEString ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==FromFile) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalRosSystemParser.g:125:4: otherlv_3= FromFile ( (lv_fromFile_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,FromFile,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getRosSystemAccess().getFromFileKeyword_3_0());
                      			
                    }
                    // InternalRosSystemParser.g:129:4: ( (lv_fromFile_4_0= ruleEString ) )
                    // InternalRosSystemParser.g:130:5: (lv_fromFile_4_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:130:5: (lv_fromFile_4_0= ruleEString )
                    // InternalRosSystemParser.g:131:6: lv_fromFile_4_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosSystemAccess().getFromFileEStringParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_fromFile_4_0=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosSystemRule());
                      						}
                      						set(
                      							current,
                      							"fromFile",
                      							lv_fromFile_4_0,
                      							"de.fraunhofer.ipa.ros.Basics.EString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:149:3: ( (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END ) | (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END ) | (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END ) | (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END ) | (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END ) | ( (lv_extensions_25_0= ruleExtensionBlock ) ) )*
            loop7:
            do {
                int alt7=7;
                switch ( input.LA(1) ) {
                case SubSystems:
                    {
                    alt7=1;
                    }
                    break;
                case Processes:
                    {
                    alt7=2;
                    }
                    break;
                case Nodes:
                    {
                    alt7=3;
                    }
                    break;
                case Parameters:
                    {
                    alt7=4;
                    }
                    break;
                case Connections:
                    {
                    alt7=5;
                    }
                    break;
                case CommercialAt:
                    {
                    alt7=6;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // InternalRosSystemParser.g:150:4: (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:150:4: (otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END )
            	    // InternalRosSystemParser.g:151:5: otherlv_5= SubSystems this_BEGIN_6= RULE_BEGIN ( (lv_components_7_0= ruleSubSystem ) )* this_END_8= RULE_END
            	    {
            	    otherlv_5=(Token)match(input,SubSystems,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_5, grammarAccess.getRosSystemAccess().getSubSystemsKeyword_4_0_0());
            	      				
            	    }
            	    this_BEGIN_6=(Token)match(input,RULE_BEGIN,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_6, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_4_0_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:159:5: ( (lv_components_7_0= ruleSubSystem ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_STRING)) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:160:6: (lv_components_7_0= ruleSubSystem )
            	    	    {
            	    	    // InternalRosSystemParser.g:160:6: (lv_components_7_0= ruleSubSystem )
            	    	    // InternalRosSystemParser.g:161:7: lv_components_7_0= ruleSubSystem
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getComponentsSubSystemParserRuleCall_4_0_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_components_7_0=ruleSubSystem();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"components",
            	    	      								lv_components_7_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.SubSystem");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);

            	    this_END_8=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_8, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_4_0_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosSystemParser.g:184:4: (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:184:4: (otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END )
            	    // InternalRosSystemParser.g:185:5: otherlv_9= Processes this_BEGIN_10= RULE_BEGIN ( (lv_processes_11_0= ruleProcess ) )* this_END_12= RULE_END
            	    {
            	    otherlv_9=(Token)match(input,Processes,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_9, grammarAccess.getRosSystemAccess().getProcessesKeyword_4_1_0());
            	      				
            	    }
            	    this_BEGIN_10=(Token)match(input,RULE_BEGIN,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_10, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_4_1_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:193:5: ( (lv_processes_11_0= ruleProcess ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:194:6: (lv_processes_11_0= ruleProcess )
            	    	    {
            	    	    // InternalRosSystemParser.g:194:6: (lv_processes_11_0= ruleProcess )
            	    	    // InternalRosSystemParser.g:195:7: lv_processes_11_0= ruleProcess
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getProcessesProcessParserRuleCall_4_1_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_processes_11_0=ruleProcess();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"processes",
            	    	      								lv_processes_11_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.Process");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    this_END_12=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_12, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_4_1_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosSystemParser.g:218:4: (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:218:4: (otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END )
            	    // InternalRosSystemParser.g:219:5: otherlv_13= Nodes this_BEGIN_14= RULE_BEGIN ( (lv_components_15_0= ruleRosNode ) )* this_END_16= RULE_END
            	    {
            	    otherlv_13=(Token)match(input,Nodes,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_13, grammarAccess.getRosSystemAccess().getNodesKeyword_4_2_0());
            	      				
            	    }
            	    this_BEGIN_14=(Token)match(input,RULE_BEGIN,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_14, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_4_2_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:227:5: ( (lv_components_15_0= ruleRosNode ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:228:6: (lv_components_15_0= ruleRosNode )
            	    	    {
            	    	    // InternalRosSystemParser.g:228:6: (lv_components_15_0= ruleRosNode )
            	    	    // InternalRosSystemParser.g:229:7: lv_components_15_0= ruleRosNode
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getComponentsRosNodeParserRuleCall_4_2_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_components_15_0=ruleRosNode();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"components",
            	    	      								lv_components_15_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.RosNode");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    this_END_16=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_16, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_4_2_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRosSystemParser.g:252:4: (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:252:4: (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END )
            	    // InternalRosSystemParser.g:253:5: otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_parameter_19_0= ruleParameter ) )* this_END_20= RULE_END
            	    {
            	    otherlv_17=(Token)match(input,Parameters,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_17, grammarAccess.getRosSystemAccess().getParametersKeyword_4_3_0());
            	      				
            	    }
            	    this_BEGIN_18=(Token)match(input,RULE_BEGIN,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_18, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_4_3_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:261:5: ( (lv_parameter_19_0= ruleParameter ) )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_STRING)) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:262:6: (lv_parameter_19_0= ruleParameter )
            	    	    {
            	    	    // InternalRosSystemParser.g:262:6: (lv_parameter_19_0= ruleParameter )
            	    	    // InternalRosSystemParser.g:263:7: lv_parameter_19_0= ruleParameter
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getParameterParameterParserRuleCall_4_3_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_parameter_19_0=ruleParameter();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"parameter",
            	    	      								lv_parameter_19_0,
            	    	      								"de.fraunhofer.ipa.ros.Basics.Parameter");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    this_END_20=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_20, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_4_3_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRosSystemParser.g:286:4: (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:286:4: (otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END )
            	    // InternalRosSystemParser.g:287:5: otherlv_21= Connections this_BEGIN_22= RULE_BEGIN ( (lv_connections_23_0= ruleConnection ) )* this_END_24= RULE_END
            	    {
            	    otherlv_21=(Token)match(input,Connections,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_21, grammarAccess.getRosSystemAccess().getConnectionsKeyword_4_4_0());
            	      				
            	    }
            	    this_BEGIN_22=(Token)match(input,RULE_BEGIN,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_22, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_4_4_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:295:5: ( (lv_connections_23_0= ruleConnection ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==HyphenMinus) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:296:6: (lv_connections_23_0= ruleConnection )
            	    	    {
            	    	    // InternalRosSystemParser.g:296:6: (lv_connections_23_0= ruleConnection )
            	    	    // InternalRosSystemParser.g:297:7: lv_connections_23_0= ruleConnection
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getConnectionsConnectionParserRuleCall_4_4_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_9);
            	    	    lv_connections_23_0=ruleConnection();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"connections",
            	    	      								lv_connections_23_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.Connection");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    this_END_24=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_24, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_4_4_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRosSystemParser.g:320:4: ( (lv_extensions_25_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRosSystemParser.g:320:4: ( (lv_extensions_25_0= ruleExtensionBlock ) )
            	    // InternalRosSystemParser.g:321:5: (lv_extensions_25_0= ruleExtensionBlock )
            	    {
            	    // InternalRosSystemParser.g:321:5: (lv_extensions_25_0= ruleExtensionBlock )
            	    // InternalRosSystemParser.g:322:6: lv_extensions_25_0= ruleExtensionBlock
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRosSystemAccess().getExtensionsExtensionBlockParserRuleCall_4_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_extensions_25_0=ruleExtensionBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	      						}
            	      						add(
            	      							current,
            	      							"extensions",
            	      							lv_extensions_25_0,
            	      							"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            this_END_26=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_26, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosSystem"


    // $ANTLR start "entryRuleSubSystem"
    // InternalRosSystemParser.g:348:1: entryRuleSubSystem returns [EObject current=null] : iv_ruleSubSystem= ruleSubSystem EOF ;
    public final EObject entryRuleSubSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystem = null;


        try {
            // InternalRosSystemParser.g:348:50: (iv_ruleSubSystem= ruleSubSystem EOF )
            // InternalRosSystemParser.g:349:2: iv_ruleSubSystem= ruleSubSystem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubSystemRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubSystem=ruleSubSystem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubSystem; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubSystem"


    // $ANTLR start "ruleSubSystem"
    // InternalRosSystemParser.g:355:1: ruleSubSystem returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSubSystem() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:361:2: ( ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:362:2: ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:362:2: ( ( ruleEString ) )
            // InternalRosSystemParser.g:363:3: ( ruleEString )
            {
            // InternalRosSystemParser.g:363:3: ( ruleEString )
            // InternalRosSystemParser.g:364:4: ruleEString
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getSubSystemRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getSubSystemAccess().getSystemSystemCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubSystem"


    // $ANTLR start "entryRuleProcess"
    // InternalRosSystemParser.g:381:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalRosSystemParser.g:381:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalRosSystemParser.g:382:2: iv_ruleProcess= ruleProcess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalRosSystemParser.g:388:1: ruleProcess returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Nodes otherlv_5= LeftSquareBracket ( ( ruleEString ) ) (otherlv_7= Comma ( ( ruleEString ) ) )* otherlv_9= RightSquareBracket )? (otherlv_10= Threads ( (lv_threads_11_0= ruleInteger0 ) ) )? this_END_12= RULE_END ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token this_END_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_threads_11_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:394:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Nodes otherlv_5= LeftSquareBracket ( ( ruleEString ) ) (otherlv_7= Comma ( ( ruleEString ) ) )* otherlv_9= RightSquareBracket )? (otherlv_10= Threads ( (lv_threads_11_0= ruleInteger0 ) ) )? this_END_12= RULE_END ) )
            // InternalRosSystemParser.g:395:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Nodes otherlv_5= LeftSquareBracket ( ( ruleEString ) ) (otherlv_7= Comma ( ( ruleEString ) ) )* otherlv_9= RightSquareBracket )? (otherlv_10= Threads ( (lv_threads_11_0= ruleInteger0 ) ) )? this_END_12= RULE_END )
            {
            // InternalRosSystemParser.g:395:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Nodes otherlv_5= LeftSquareBracket ( ( ruleEString ) ) (otherlv_7= Comma ( ( ruleEString ) ) )* otherlv_9= RightSquareBracket )? (otherlv_10= Threads ( (lv_threads_11_0= ruleInteger0 ) ) )? this_END_12= RULE_END )
            // InternalRosSystemParser.g:396:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Nodes otherlv_5= LeftSquareBracket ( ( ruleEString ) ) (otherlv_7= Comma ( ( ruleEString ) ) )* otherlv_9= RightSquareBracket )? (otherlv_10= Threads ( (lv_threads_11_0= ruleInteger0 ) ) )? this_END_12= RULE_END
            {
            // InternalRosSystemParser.g:396:3: ()
            // InternalRosSystemParser.g:397:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getProcessAccess().getProcessAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:403:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosSystemParser.g:404:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosSystemParser.g:404:4: (lv_name_1_0= ruleEString )
            // InternalRosSystemParser.g:405:5: lv_name_1_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProcessAccess().getNameEStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProcessRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getColonKeyword_2());
              		
            }
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_3, grammarAccess.getProcessAccess().getBEGINTerminalRuleCall_3());
              		
            }
            // InternalRosSystemParser.g:430:3: (otherlv_4= Nodes otherlv_5= LeftSquareBracket ( ( ruleEString ) ) (otherlv_7= Comma ( ( ruleEString ) ) )* otherlv_9= RightSquareBracket )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Nodes) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalRosSystemParser.g:431:4: otherlv_4= Nodes otherlv_5= LeftSquareBracket ( ( ruleEString ) ) (otherlv_7= Comma ( ( ruleEString ) ) )* otherlv_9= RightSquareBracket
                    {
                    otherlv_4=(Token)match(input,Nodes,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getProcessAccess().getNodesKeyword_4_0());
                      			
                    }
                    otherlv_5=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_4_1());
                      			
                    }
                    // InternalRosSystemParser.g:439:4: ( ( ruleEString ) )
                    // InternalRosSystemParser.g:440:5: ( ruleEString )
                    {
                    // InternalRosSystemParser.g:440:5: ( ruleEString )
                    // InternalRosSystemParser.g:441:6: ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getProcessRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getProcessAccess().getComponentsRosNodeCrossReference_4_2_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:455:4: (otherlv_7= Comma ( ( ruleEString ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==Comma) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:456:5: otherlv_7= Comma ( ( ruleEString ) )
                    	    {
                    	    otherlv_7=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_7, grammarAccess.getProcessAccess().getCommaKeyword_4_3_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:460:5: ( ( ruleEString ) )
                    	    // InternalRosSystemParser.g:461:6: ( ruleEString )
                    	    {
                    	    // InternalRosSystemParser.g:461:6: ( ruleEString )
                    	    // InternalRosSystemParser.g:462:7: ruleEString
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getProcessRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getProcessAccess().getComponentsRosNodeCrossReference_4_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    ruleEString();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,RightSquareBracket,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getProcessAccess().getRightSquareBracketKeyword_4_4());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:482:3: (otherlv_10= Threads ( (lv_threads_11_0= ruleInteger0 ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Threads) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRosSystemParser.g:483:4: otherlv_10= Threads ( (lv_threads_11_0= ruleInteger0 ) )
                    {
                    otherlv_10=(Token)match(input,Threads,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getProcessAccess().getThreadsKeyword_5_0());
                      			
                    }
                    // InternalRosSystemParser.g:487:4: ( (lv_threads_11_0= ruleInteger0 ) )
                    // InternalRosSystemParser.g:488:5: (lv_threads_11_0= ruleInteger0 )
                    {
                    // InternalRosSystemParser.g:488:5: (lv_threads_11_0= ruleInteger0 )
                    // InternalRosSystemParser.g:489:6: lv_threads_11_0= ruleInteger0
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getProcessAccess().getThreadsInteger0ParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
                    lv_threads_11_0=ruleInteger0();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getProcessRule());
                      						}
                      						set(
                      							current,
                      							"threads",
                      							lv_threads_11_0,
                      							"de.fraunhofer.ipa.ros.Basics.Integer0");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_END_12=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_12, grammarAccess.getProcessAccess().getENDTerminalRuleCall_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleRosNode"
    // InternalRosSystemParser.g:515:1: entryRuleRosNode returns [EObject current=null] : iv_ruleRosNode= ruleRosNode EOF ;
    public final EObject entryRuleRosNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosNode = null;


        try {
            // InternalRosSystemParser.g:515:48: (iv_ruleRosNode= ruleRosNode EOF )
            // InternalRosSystemParser.g:516:2: iv_ruleRosNode= ruleRosNode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosNode=ruleRosNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosNode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosNode"


    // $ANTLR start "ruleRosNode"
    // InternalRosSystemParser.g:522:1: ruleRosNode returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= From ( ( ruleEString ) ) (otherlv_6= Namespace ( (lv_namespace_7_0= ruleEString ) ) )? (otherlv_8= Plugins otherlv_9= LeftSquareBracket ( ( ruleEString ) ) (otherlv_11= Comma ( ( ruleEString ) ) )* otherlv_13= RightSquareBracket )? (otherlv_14= Interfaces this_BEGIN_15= RULE_BEGIN ( (lv_rosinterfaces_16_0= ruleRosInterface ) )* this_END_17= RULE_END )? (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_rosparameters_20_0= ruleRosParameter ) )* this_END_21= RULE_END )? ( (lv_extensions_22_0= ruleExtensionBlock ) )* this_END_23= RULE_END ) ;
    public final EObject ruleRosNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token this_BEGIN_15=null;
        Token this_END_17=null;
        Token otherlv_18=null;
        Token this_BEGIN_19=null;
        Token this_END_21=null;
        Token this_END_23=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_namespace_7_0 = null;

        EObject lv_rosinterfaces_16_0 = null;

        EObject lv_rosparameters_20_0 = null;

        EObject lv_extensions_22_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:528:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= From ( ( ruleEString ) ) (otherlv_6= Namespace ( (lv_namespace_7_0= ruleEString ) ) )? (otherlv_8= Plugins otherlv_9= LeftSquareBracket ( ( ruleEString ) ) (otherlv_11= Comma ( ( ruleEString ) ) )* otherlv_13= RightSquareBracket )? (otherlv_14= Interfaces this_BEGIN_15= RULE_BEGIN ( (lv_rosinterfaces_16_0= ruleRosInterface ) )* this_END_17= RULE_END )? (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_rosparameters_20_0= ruleRosParameter ) )* this_END_21= RULE_END )? ( (lv_extensions_22_0= ruleExtensionBlock ) )* this_END_23= RULE_END ) )
            // InternalRosSystemParser.g:529:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= From ( ( ruleEString ) ) (otherlv_6= Namespace ( (lv_namespace_7_0= ruleEString ) ) )? (otherlv_8= Plugins otherlv_9= LeftSquareBracket ( ( ruleEString ) ) (otherlv_11= Comma ( ( ruleEString ) ) )* otherlv_13= RightSquareBracket )? (otherlv_14= Interfaces this_BEGIN_15= RULE_BEGIN ( (lv_rosinterfaces_16_0= ruleRosInterface ) )* this_END_17= RULE_END )? (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_rosparameters_20_0= ruleRosParameter ) )* this_END_21= RULE_END )? ( (lv_extensions_22_0= ruleExtensionBlock ) )* this_END_23= RULE_END )
            {
            // InternalRosSystemParser.g:529:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= From ( ( ruleEString ) ) (otherlv_6= Namespace ( (lv_namespace_7_0= ruleEString ) ) )? (otherlv_8= Plugins otherlv_9= LeftSquareBracket ( ( ruleEString ) ) (otherlv_11= Comma ( ( ruleEString ) ) )* otherlv_13= RightSquareBracket )? (otherlv_14= Interfaces this_BEGIN_15= RULE_BEGIN ( (lv_rosinterfaces_16_0= ruleRosInterface ) )* this_END_17= RULE_END )? (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_rosparameters_20_0= ruleRosParameter ) )* this_END_21= RULE_END )? ( (lv_extensions_22_0= ruleExtensionBlock ) )* this_END_23= RULE_END )
            // InternalRosSystemParser.g:530:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= From ( ( ruleEString ) ) (otherlv_6= Namespace ( (lv_namespace_7_0= ruleEString ) ) )? (otherlv_8= Plugins otherlv_9= LeftSquareBracket ( ( ruleEString ) ) (otherlv_11= Comma ( ( ruleEString ) ) )* otherlv_13= RightSquareBracket )? (otherlv_14= Interfaces this_BEGIN_15= RULE_BEGIN ( (lv_rosinterfaces_16_0= ruleRosInterface ) )* this_END_17= RULE_END )? (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_rosparameters_20_0= ruleRosParameter ) )* this_END_21= RULE_END )? ( (lv_extensions_22_0= ruleExtensionBlock ) )* this_END_23= RULE_END
            {
            // InternalRosSystemParser.g:530:3: ()
            // InternalRosSystemParser.g:531:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosNodeAccess().getRosNodeAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:537:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosSystemParser.g:538:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosSystemParser.g:538:4: (lv_name_1_0= ruleEString )
            // InternalRosSystemParser.g:539:5: lv_name_1_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosNodeAccess().getNameEStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosNodeRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRosNodeAccess().getColonKeyword_2());
              		
            }
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_3, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_3());
              		
            }
            otherlv_4=(Token)match(input,From,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRosNodeAccess().getFromKeyword_4());
              		
            }
            // InternalRosSystemParser.g:568:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:569:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:569:4: ( ruleEString )
            // InternalRosSystemParser.g:570:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosNodeRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosNodeAccess().getFromNodeCrossReference_5_0());
              				
            }
            pushFollow(FOLLOW_17);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:584:3: (otherlv_6= Namespace ( (lv_namespace_7_0= ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Namespace) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRosSystemParser.g:585:4: otherlv_6= Namespace ( (lv_namespace_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,Namespace,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getRosNodeAccess().getNamespaceKeyword_6_0());
                      			
                    }
                    // InternalRosSystemParser.g:589:4: ( (lv_namespace_7_0= ruleEString ) )
                    // InternalRosSystemParser.g:590:5: (lv_namespace_7_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:590:5: (lv_namespace_7_0= ruleEString )
                    // InternalRosSystemParser.g:591:6: lv_namespace_7_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosNodeAccess().getNamespaceEStringParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_18);
                    lv_namespace_7_0=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                      						}
                      						set(
                      							current,
                      							"namespace",
                      							lv_namespace_7_0,
                      							"de.fraunhofer.ipa.ros.Basics.EString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:609:3: (otherlv_8= Plugins otherlv_9= LeftSquareBracket ( ( ruleEString ) ) (otherlv_11= Comma ( ( ruleEString ) ) )* otherlv_13= RightSquareBracket )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Plugins) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRosSystemParser.g:610:4: otherlv_8= Plugins otherlv_9= LeftSquareBracket ( ( ruleEString ) ) (otherlv_11= Comma ( ( ruleEString ) ) )* otherlv_13= RightSquareBracket
                    {
                    otherlv_8=(Token)match(input,Plugins,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getRosNodeAccess().getPluginsKeyword_7_0());
                      			
                    }
                    otherlv_9=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getRosNodeAccess().getLeftSquareBracketKeyword_7_1());
                      			
                    }
                    // InternalRosSystemParser.g:618:4: ( ( ruleEString ) )
                    // InternalRosSystemParser.g:619:5: ( ruleEString )
                    {
                    // InternalRosSystemParser.g:619:5: ( ruleEString )
                    // InternalRosSystemParser.g:620:6: ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRosNodeRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosNodeAccess().getPluginsPluginCrossReference_7_2_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:634:4: (otherlv_11= Comma ( ( ruleEString ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Comma) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:635:5: otherlv_11= Comma ( ( ruleEString ) )
                    	    {
                    	    otherlv_11=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_11, grammarAccess.getRosNodeAccess().getCommaKeyword_7_3_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:639:5: ( ( ruleEString ) )
                    	    // InternalRosSystemParser.g:640:6: ( ruleEString )
                    	    {
                    	    // InternalRosSystemParser.g:640:6: ( ruleEString )
                    	    // InternalRosSystemParser.g:641:7: ruleEString
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getRosNodeRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRosNodeAccess().getPluginsPluginCrossReference_7_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    ruleEString();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,RightSquareBracket,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getRosNodeAccess().getRightSquareBracketKeyword_7_4());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:661:3: (otherlv_14= Interfaces this_BEGIN_15= RULE_BEGIN ( (lv_rosinterfaces_16_0= ruleRosInterface ) )* this_END_17= RULE_END )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==Interfaces) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRosSystemParser.g:662:4: otherlv_14= Interfaces this_BEGIN_15= RULE_BEGIN ( (lv_rosinterfaces_16_0= ruleRosInterface ) )* this_END_17= RULE_END
                    {
                    otherlv_14=(Token)match(input,Interfaces,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getRosNodeAccess().getInterfacesKeyword_8_0());
                      			
                    }
                    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_15, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_8_1());
                      			
                    }
                    // InternalRosSystemParser.g:670:4: ( (lv_rosinterfaces_16_0= ruleRosInterface ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==HyphenMinus) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:671:5: (lv_rosinterfaces_16_0= ruleRosInterface )
                    	    {
                    	    // InternalRosSystemParser.g:671:5: (lv_rosinterfaces_16_0= ruleRosInterface )
                    	    // InternalRosSystemParser.g:672:6: lv_rosinterfaces_16_0= ruleRosInterface
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRosNodeAccess().getRosinterfacesRosInterfaceParserRuleCall_8_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_rosinterfaces_16_0=ruleRosInterface();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"rosinterfaces",
                    	      							lv_rosinterfaces_16_0,
                    	      							"de.fraunhofer.ipa.rossystem.RosSystem.RosInterface");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    this_END_17=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_17, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_8_3());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:694:3: (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_rosparameters_20_0= ruleRosParameter ) )* this_END_21= RULE_END )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Parameters) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRosSystemParser.g:695:4: otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_rosparameters_20_0= ruleRosParameter ) )* this_END_21= RULE_END
                    {
                    otherlv_18=(Token)match(input,Parameters,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_18, grammarAccess.getRosNodeAccess().getParametersKeyword_9_0());
                      			
                    }
                    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_19, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_9_1());
                      			
                    }
                    // InternalRosSystemParser.g:703:4: ( (lv_rosparameters_20_0= ruleRosParameter ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==HyphenMinus) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:704:5: (lv_rosparameters_20_0= ruleRosParameter )
                    	    {
                    	    // InternalRosSystemParser.g:704:5: (lv_rosparameters_20_0= ruleRosParameter )
                    	    // InternalRosSystemParser.g:705:6: lv_rosparameters_20_0= ruleRosParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRosNodeAccess().getRosparametersRosParameterParserRuleCall_9_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_rosparameters_20_0=ruleRosParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"rosparameters",
                    	      							lv_rosparameters_20_0,
                    	      							"de.fraunhofer.ipa.rossystem.RosSystem.RosParameter");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    this_END_21=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_21, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_9_3());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:727:3: ( (lv_extensions_22_0= ruleExtensionBlock ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==CommercialAt) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalRosSystemParser.g:728:4: (lv_extensions_22_0= ruleExtensionBlock )
            	    {
            	    // InternalRosSystemParser.g:728:4: (lv_extensions_22_0= ruleExtensionBlock )
            	    // InternalRosSystemParser.g:729:5: lv_extensions_22_0= ruleExtensionBlock
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRosNodeAccess().getExtensionsExtensionBlockParserRuleCall_10_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_extensions_22_0=ruleExtensionBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRosNodeRule());
            	      					}
            	      					add(
            	      						current,
            	      						"extensions",
            	      						lv_extensions_22_0,
            	      						"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            this_END_23=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_23, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_11());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosNode"


    // $ANTLR start "entryRuleRosInterface"
    // InternalRosSystemParser.g:754:1: entryRuleRosInterface returns [EObject current=null] : iv_ruleRosInterface= ruleRosInterface EOF ;
    public final EObject entryRuleRosInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosInterface = null;


        try {
            // InternalRosSystemParser.g:754:53: (iv_ruleRosInterface= ruleRosInterface EOF )
            // InternalRosSystemParser.g:755:2: iv_ruleRosInterface= ruleRosInterface EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosInterfaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosInterface=ruleRosInterface();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosInterface; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosInterface"


    // $ANTLR start "ruleRosInterface"
    // InternalRosSystemParser.g:761:1: ruleRosInterface returns [EObject current=null] : (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (lv_reference_3_0= ruleInterfaceReference ) ) (this_BEGIN_4= RULE_BEGIN ( (lv_extensions_5_0= ruleExtensionBlock ) )+ this_END_6= RULE_END )? ) ;
    public final EObject ruleRosInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_reference_3_0 = null;

        EObject lv_extensions_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:767:2: ( (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (lv_reference_3_0= ruleInterfaceReference ) ) (this_BEGIN_4= RULE_BEGIN ( (lv_extensions_5_0= ruleExtensionBlock ) )+ this_END_6= RULE_END )? ) )
            // InternalRosSystemParser.g:768:2: (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (lv_reference_3_0= ruleInterfaceReference ) ) (this_BEGIN_4= RULE_BEGIN ( (lv_extensions_5_0= ruleExtensionBlock ) )+ this_END_6= RULE_END )? )
            {
            // InternalRosSystemParser.g:768:2: (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (lv_reference_3_0= ruleInterfaceReference ) ) (this_BEGIN_4= RULE_BEGIN ( (lv_extensions_5_0= ruleExtensionBlock ) )+ this_END_6= RULE_END )? )
            // InternalRosSystemParser.g:769:3: otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (lv_reference_3_0= ruleInterfaceReference ) ) (this_BEGIN_4= RULE_BEGIN ( (lv_extensions_5_0= ruleExtensionBlock ) )+ this_END_6= RULE_END )?
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosInterfaceAccess().getHyphenMinusKeyword_0());
              		
            }
            // InternalRosSystemParser.g:773:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosSystemParser.g:774:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosSystemParser.g:774:4: (lv_name_1_0= ruleEString )
            // InternalRosSystemParser.g:775:5: lv_name_1_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosInterfaceAccess().getNameEStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosInterfaceRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRosInterfaceAccess().getColonKeyword_2());
              		
            }
            // InternalRosSystemParser.g:796:3: ( (lv_reference_3_0= ruleInterfaceReference ) )
            // InternalRosSystemParser.g:797:4: (lv_reference_3_0= ruleInterfaceReference )
            {
            // InternalRosSystemParser.g:797:4: (lv_reference_3_0= ruleInterfaceReference )
            // InternalRosSystemParser.g:798:5: lv_reference_3_0= ruleInterfaceReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosInterfaceAccess().getReferenceInterfaceReferenceParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_reference_3_0=ruleInterfaceReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosInterfaceRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_3_0,
              						"de.fraunhofer.ipa.rossystem.RosSystem.InterfaceReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:815:3: (this_BEGIN_4= RULE_BEGIN ( (lv_extensions_5_0= ruleExtensionBlock ) )+ this_END_6= RULE_END )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_BEGIN) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRosSystemParser.g:816:4: this_BEGIN_4= RULE_BEGIN ( (lv_extensions_5_0= ruleExtensionBlock ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_4, grammarAccess.getRosInterfaceAccess().getBEGINTerminalRuleCall_4_0());
                      			
                    }
                    // InternalRosSystemParser.g:820:4: ( (lv_extensions_5_0= ruleExtensionBlock ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==CommercialAt) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:821:5: (lv_extensions_5_0= ruleExtensionBlock )
                    	    {
                    	    // InternalRosSystemParser.g:821:5: (lv_extensions_5_0= ruleExtensionBlock )
                    	    // InternalRosSystemParser.g:822:6: lv_extensions_5_0= ruleExtensionBlock
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRosInterfaceAccess().getExtensionsExtensionBlockParserRuleCall_4_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_7);
                    	    lv_extensions_5_0=ruleExtensionBlock();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRosInterfaceRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"extensions",
                    	      							lv_extensions_5_0,
                    	      							"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_6, grammarAccess.getRosInterfaceAccess().getENDTerminalRuleCall_4_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosInterface"


    // $ANTLR start "entryRuleInterfaceReference"
    // InternalRosSystemParser.g:848:1: entryRuleInterfaceReference returns [EObject current=null] : iv_ruleInterfaceReference= ruleInterfaceReference EOF ;
    public final EObject entryRuleInterfaceReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceReference = null;


        try {
            // InternalRosSystemParser.g:848:59: (iv_ruleInterfaceReference= ruleInterfaceReference EOF )
            // InternalRosSystemParser.g:849:2: iv_ruleInterfaceReference= ruleInterfaceReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterfaceReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInterfaceReference=ruleInterfaceReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterfaceReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterfaceReference"


    // $ANTLR start "ruleInterfaceReference"
    // InternalRosSystemParser.g:855:1: ruleInterfaceReference returns [EObject current=null] : (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference ) ;
    public final EObject ruleInterfaceReference() throws RecognitionException {
        EObject current = null;

        EObject this_RosPublisherReference_0 = null;

        EObject this_RosSubscriberReference_1 = null;

        EObject this_RosServiceServerReference_2 = null;

        EObject this_RosServerClientReference_3 = null;

        EObject this_RosActionServerReference_4 = null;

        EObject this_RosActionClientReference_5 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:861:2: ( (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference ) )
            // InternalRosSystemParser.g:862:2: (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference )
            {
            // InternalRosSystemParser.g:862:2: (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference )
            int alt21=6;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt21=1;
                }
                break;
            case Sub:
                {
                alt21=2;
                }
                break;
            case Ss:
                {
                alt21=3;
                }
                break;
            case Sc:
                {
                alt21=4;
                }
                break;
            case As:
                {
                alt21=5;
                }
                break;
            case Ac:
                {
                alt21=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalRosSystemParser.g:863:3: this_RosPublisherReference_0= ruleRosPublisherReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInterfaceReferenceAccess().getRosPublisherReferenceParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosPublisherReference_0=ruleRosPublisherReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosPublisherReference_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:872:3: this_RosSubscriberReference_1= ruleRosSubscriberReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInterfaceReferenceAccess().getRosSubscriberReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosSubscriberReference_1=ruleRosSubscriberReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosSubscriberReference_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:881:3: this_RosServiceServerReference_2= ruleRosServiceServerReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInterfaceReferenceAccess().getRosServiceServerReferenceParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosServiceServerReference_2=ruleRosServiceServerReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosServiceServerReference_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:890:3: this_RosServerClientReference_3= ruleRosServerClientReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInterfaceReferenceAccess().getRosServerClientReferenceParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosServerClientReference_3=ruleRosServerClientReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosServerClientReference_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:899:3: this_RosActionServerReference_4= ruleRosActionServerReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInterfaceReferenceAccess().getRosActionServerReferenceParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosActionServerReference_4=ruleRosActionServerReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosActionServerReference_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:908:3: this_RosActionClientReference_5= ruleRosActionClientReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getInterfaceReferenceAccess().getRosActionClientReferenceParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosActionClientReference_5=ruleRosActionClientReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosActionClientReference_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterfaceReference"


    // $ANTLR start "entryRuleRosPublisherReference"
    // InternalRosSystemParser.g:920:1: entryRuleRosPublisherReference returns [EObject current=null] : iv_ruleRosPublisherReference= ruleRosPublisherReference EOF ;
    public final EObject entryRuleRosPublisherReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosPublisherReference = null;


        try {
            // InternalRosSystemParser.g:920:62: (iv_ruleRosPublisherReference= ruleRosPublisherReference EOF )
            // InternalRosSystemParser.g:921:2: iv_ruleRosPublisherReference= ruleRosPublisherReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosPublisherReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosPublisherReference=ruleRosPublisherReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosPublisherReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosPublisherReference"


    // $ANTLR start "ruleRosPublisherReference"
    // InternalRosSystemParser.g:927:1: ruleRosPublisherReference returns [EObject current=null] : (otherlv_0= Pub () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosPublisherReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:933:2: ( (otherlv_0= Pub () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:934:2: (otherlv_0= Pub () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:934:2: (otherlv_0= Pub () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:935:3: otherlv_0= Pub () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Pub,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosPublisherReferenceAccess().getPubKeyword_0());
              		
            }
            // InternalRosSystemParser.g:939:3: ()
            // InternalRosSystemParser.g:940:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosPublisherReferenceAccess().getRosPublisherReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:946:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:947:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:947:4: ( ruleEString )
            // InternalRosSystemParser.g:948:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosPublisherReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosPublisherReferenceAccess().getFromPublisherCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosPublisherReference"


    // $ANTLR start "entryRuleRosSubscriberReference"
    // InternalRosSystemParser.g:966:1: entryRuleRosSubscriberReference returns [EObject current=null] : iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF ;
    public final EObject entryRuleRosSubscriberReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosSubscriberReference = null;


        try {
            // InternalRosSystemParser.g:966:63: (iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF )
            // InternalRosSystemParser.g:967:2: iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosSubscriberReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosSubscriberReference=ruleRosSubscriberReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosSubscriberReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosSubscriberReference"


    // $ANTLR start "ruleRosSubscriberReference"
    // InternalRosSystemParser.g:973:1: ruleRosSubscriberReference returns [EObject current=null] : (otherlv_0= Sub () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosSubscriberReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:979:2: ( (otherlv_0= Sub () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:980:2: (otherlv_0= Sub () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:980:2: (otherlv_0= Sub () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:981:3: otherlv_0= Sub () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Sub,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosSubscriberReferenceAccess().getSubKeyword_0());
              		
            }
            // InternalRosSystemParser.g:985:3: ()
            // InternalRosSystemParser.g:986:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosSubscriberReferenceAccess().getRosSubscriberReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:992:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:993:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:993:4: ( ruleEString )
            // InternalRosSystemParser.g:994:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosSubscriberReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSubscriberReferenceAccess().getFromSubscriberCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosSubscriberReference"


    // $ANTLR start "entryRuleRosServiceServerReference"
    // InternalRosSystemParser.g:1012:1: entryRuleRosServiceServerReference returns [EObject current=null] : iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF ;
    public final EObject entryRuleRosServiceServerReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServiceServerReference = null;


        try {
            // InternalRosSystemParser.g:1012:66: (iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF )
            // InternalRosSystemParser.g:1013:2: iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosServiceServerReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosServiceServerReference=ruleRosServiceServerReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosServiceServerReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosServiceServerReference"


    // $ANTLR start "ruleRosServiceServerReference"
    // InternalRosSystemParser.g:1019:1: ruleRosServiceServerReference returns [EObject current=null] : (otherlv_0= Ss () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosServiceServerReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1025:2: ( (otherlv_0= Ss () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1026:2: (otherlv_0= Ss () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1026:2: (otherlv_0= Ss () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1027:3: otherlv_0= Ss () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Ss,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServiceServerReferenceAccess().getSsKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1031:3: ()
            // InternalRosSystemParser.g:1032:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosServiceServerReferenceAccess().getRosServiceServerReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1038:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1039:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1039:4: ( ruleEString )
            // InternalRosSystemParser.g:1040:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServiceServerReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServiceServerReferenceAccess().getFromServiceServerCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosServiceServerReference"


    // $ANTLR start "entryRuleRosServerClientReference"
    // InternalRosSystemParser.g:1058:1: entryRuleRosServerClientReference returns [EObject current=null] : iv_ruleRosServerClientReference= ruleRosServerClientReference EOF ;
    public final EObject entryRuleRosServerClientReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServerClientReference = null;


        try {
            // InternalRosSystemParser.g:1058:65: (iv_ruleRosServerClientReference= ruleRosServerClientReference EOF )
            // InternalRosSystemParser.g:1059:2: iv_ruleRosServerClientReference= ruleRosServerClientReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosServerClientReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosServerClientReference=ruleRosServerClientReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosServerClientReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosServerClientReference"


    // $ANTLR start "ruleRosServerClientReference"
    // InternalRosSystemParser.g:1065:1: ruleRosServerClientReference returns [EObject current=null] : (otherlv_0= Sc () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosServerClientReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1071:2: ( (otherlv_0= Sc () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1072:2: (otherlv_0= Sc () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1072:2: (otherlv_0= Sc () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1073:3: otherlv_0= Sc () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Sc,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServerClientReferenceAccess().getScKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1077:3: ()
            // InternalRosSystemParser.g:1078:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosServerClientReferenceAccess().getRosServiceClientReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1084:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1085:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1085:4: ( ruleEString )
            // InternalRosSystemParser.g:1086:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServerClientReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServerClientReferenceAccess().getFromServiceClientCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosServerClientReference"


    // $ANTLR start "entryRuleRosActionServerReference"
    // InternalRosSystemParser.g:1104:1: entryRuleRosActionServerReference returns [EObject current=null] : iv_ruleRosActionServerReference= ruleRosActionServerReference EOF ;
    public final EObject entryRuleRosActionServerReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionServerReference = null;


        try {
            // InternalRosSystemParser.g:1104:65: (iv_ruleRosActionServerReference= ruleRosActionServerReference EOF )
            // InternalRosSystemParser.g:1105:2: iv_ruleRosActionServerReference= ruleRosActionServerReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosActionServerReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosActionServerReference=ruleRosActionServerReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosActionServerReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosActionServerReference"


    // $ANTLR start "ruleRosActionServerReference"
    // InternalRosSystemParser.g:1111:1: ruleRosActionServerReference returns [EObject current=null] : (otherlv_0= As () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosActionServerReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1117:2: ( (otherlv_0= As () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1118:2: (otherlv_0= As () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1118:2: (otherlv_0= As () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1119:3: otherlv_0= As () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,As,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionServerReferenceAccess().getAsKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1123:3: ()
            // InternalRosSystemParser.g:1124:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosActionServerReferenceAccess().getRosActionServerReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1130:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1131:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1131:4: ( ruleEString )
            // InternalRosSystemParser.g:1132:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionServerReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionServerReferenceAccess().getFromActionServerCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosActionServerReference"


    // $ANTLR start "entryRuleRosActionClientReference"
    // InternalRosSystemParser.g:1150:1: entryRuleRosActionClientReference returns [EObject current=null] : iv_ruleRosActionClientReference= ruleRosActionClientReference EOF ;
    public final EObject entryRuleRosActionClientReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionClientReference = null;


        try {
            // InternalRosSystemParser.g:1150:65: (iv_ruleRosActionClientReference= ruleRosActionClientReference EOF )
            // InternalRosSystemParser.g:1151:2: iv_ruleRosActionClientReference= ruleRosActionClientReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosActionClientReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosActionClientReference=ruleRosActionClientReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosActionClientReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosActionClientReference"


    // $ANTLR start "ruleRosActionClientReference"
    // InternalRosSystemParser.g:1157:1: ruleRosActionClientReference returns [EObject current=null] : (otherlv_0= Ac () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosActionClientReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1163:2: ( (otherlv_0= Ac () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1164:2: (otherlv_0= Ac () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1164:2: (otherlv_0= Ac () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1165:3: otherlv_0= Ac () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Ac,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionClientReferenceAccess().getAcKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1169:3: ()
            // InternalRosSystemParser.g:1170:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosActionClientReferenceAccess().getRosActionClientReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1176:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1177:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1177:4: ( ruleEString )
            // InternalRosSystemParser.g:1178:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionClientReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionClientReferenceAccess().getFromActionClientCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosActionClientReference"


    // $ANTLR start "entryRuleRosParameter"
    // InternalRosSystemParser.g:1196:1: entryRuleRosParameter returns [EObject current=null] : iv_ruleRosParameter= ruleRosParameter EOF ;
    public final EObject entryRuleRosParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosParameter = null;


        try {
            // InternalRosSystemParser.g:1196:53: (iv_ruleRosParameter= ruleRosParameter EOF )
            // InternalRosSystemParser.g:1197:2: iv_ruleRosParameter= ruleRosParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosParameter=ruleRosParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosParameter"


    // $ANTLR start "ruleRosParameter"
    // InternalRosSystemParser.g:1203:1: ruleRosParameter returns [EObject current=null] : (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( ( ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Value_1 ( (lv_value_6_0= ruleParameterValue ) ) this_END_7= RULE_END ) ;
    public final EObject ruleRosParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token this_END_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1209:2: ( (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( ( ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Value_1 ( (lv_value_6_0= ruleParameterValue ) ) this_END_7= RULE_END ) )
            // InternalRosSystemParser.g:1210:2: (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( ( ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Value_1 ( (lv_value_6_0= ruleParameterValue ) ) this_END_7= RULE_END )
            {
            // InternalRosSystemParser.g:1210:2: (otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( ( ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Value_1 ( (lv_value_6_0= ruleParameterValue ) ) this_END_7= RULE_END )
            // InternalRosSystemParser.g:1211:3: otherlv_0= HyphenMinus ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( ( ruleEString ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Value_1 ( (lv_value_6_0= ruleParameterValue ) ) this_END_7= RULE_END
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosParameterAccess().getHyphenMinusKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1215:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosSystemParser.g:1216:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosSystemParser.g:1216:4: (lv_name_1_0= ruleEString )
            // InternalRosSystemParser.g:1217:5: lv_name_1_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosParameterAccess().getNameEStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosParameterRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRosParameterAccess().getColonKeyword_2());
              		
            }
            // InternalRosSystemParser.g:1238:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1239:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1239:4: ( ruleEString )
            // InternalRosSystemParser.g:1240:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosParameterRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosParameterAccess().getFromParameterCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_4);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_4, grammarAccess.getRosParameterAccess().getBEGINTerminalRuleCall_4());
              		
            }
            otherlv_5=(Token)match(input,Value_1,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRosParameterAccess().getValueKeyword_5());
              		
            }
            // InternalRosSystemParser.g:1262:3: ( (lv_value_6_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:1263:4: (lv_value_6_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:1263:4: (lv_value_6_0= ruleParameterValue )
            // InternalRosSystemParser.g:1264:5: lv_value_6_0= ruleParameterValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosParameterAccess().getValueParameterValueParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_value_6_0=ruleParameterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosParameterRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_6_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_END_7=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_7, grammarAccess.getRosParameterAccess().getENDTerminalRuleCall_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosParameter"


    // $ANTLR start "entryRuleConnection"
    // InternalRosSystemParser.g:1289:1: entryRuleConnection returns [EObject current=null] : iv_ruleConnection= ruleConnection EOF ;
    public final EObject entryRuleConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnection = null;


        try {
            // InternalRosSystemParser.g:1289:51: (iv_ruleConnection= ruleConnection EOF )
            // InternalRosSystemParser.g:1290:2: iv_ruleConnection= ruleConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConnectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConnection=ruleConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConnection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnection"


    // $ANTLR start "ruleConnection"
    // InternalRosSystemParser.g:1296:1: ruleConnection returns [EObject current=null] : ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection ) ;
    public final EObject ruleConnection() throws RecognitionException {
        EObject current = null;

        EObject this_RosSystemConnection_0 = null;

        EObject this_RosConnection_1 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1302:2: ( ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection ) )
            // InternalRosSystemParser.g:1303:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )
            {
            // InternalRosSystemParser.g:1303:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalRosSystemParser.g:1304:3: ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection )
                    {
                    // InternalRosSystemParser.g:1304:3: ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection )
                    // InternalRosSystemParser.g:1305:4: ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getConnectionAccess().getRosSystemConnectionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_RosSystemConnection_0=ruleRosSystemConnection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RosSystemConnection_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:1316:3: this_RosConnection_1= ruleRosConnection
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getConnectionAccess().getRosConnectionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosConnection_1=ruleRosConnection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosConnection_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnection"


    // $ANTLR start "entryRuleRosSystemConnection"
    // InternalRosSystemParser.g:1328:1: entryRuleRosSystemConnection returns [EObject current=null] : iv_ruleRosSystemConnection= ruleRosSystemConnection EOF ;
    public final EObject entryRuleRosSystemConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosSystemConnection = null;


        try {
            // InternalRosSystemParser.g:1328:60: (iv_ruleRosSystemConnection= ruleRosSystemConnection EOF )
            // InternalRosSystemParser.g:1329:2: iv_ruleRosSystemConnection= ruleRosSystemConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosSystemConnectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosSystemConnection=ruleRosSystemConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosSystemConnection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosSystemConnection"


    // $ANTLR start "ruleRosSystemConnection"
    // InternalRosSystemParser.g:1335:1: ruleRosSystemConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosSystemConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1341:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1342:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1342:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1343:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosSystemConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosSystemConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1351:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1352:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1352:4: ( ruleEString )
            // InternalRosSystemParser.g:1353:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosSystemConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSystemConnectionAccess().getFromRosInterfaceCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosSystemConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1371:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1372:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1372:4: ( ruleEString )
            // InternalRosSystemParser.g:1373:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosSystemConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSystemConnectionAccess().getToRosInterfaceCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRosSystemConnectionAccess().getRightSquareBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosSystemConnection"


    // $ANTLR start "entryRuleRosConnection"
    // InternalRosSystemParser.g:1395:1: entryRuleRosConnection returns [EObject current=null] : iv_ruleRosConnection= ruleRosConnection EOF ;
    public final EObject entryRuleRosConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosConnection = null;


        try {
            // InternalRosSystemParser.g:1395:54: (iv_ruleRosConnection= ruleRosConnection EOF )
            // InternalRosSystemParser.g:1396:2: iv_ruleRosConnection= ruleRosConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosConnectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosConnection=ruleRosConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosConnection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosConnection"


    // $ANTLR start "ruleRosConnection"
    // InternalRosSystemParser.g:1402:1: ruleRosConnection returns [EObject current=null] : ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection ) ;
    public final EObject ruleRosConnection() throws RecognitionException {
        EObject current = null;

        EObject this_RosTopicConnection_0 = null;

        EObject this_RosServiceConnection_1 = null;

        EObject this_RosActionConnection_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1408:2: ( ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection ) )
            // InternalRosSystemParser.g:1409:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )
            {
            // InternalRosSystemParser.g:1409:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )
            int alt23=3;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalRosSystemParser.g:1410:3: ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection )
                    {
                    // InternalRosSystemParser.g:1410:3: ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection )
                    // InternalRosSystemParser.g:1411:4: ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRosConnectionAccess().getRosTopicConnectionParserRuleCall_0());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_RosTopicConnection_0=ruleRosTopicConnection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RosTopicConnection_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:1422:3: ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection )
                    {
                    // InternalRosSystemParser.g:1422:3: ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection )
                    // InternalRosSystemParser.g:1423:4: ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getRosConnectionAccess().getRosServiceConnectionParserRuleCall_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_RosServiceConnection_1=ruleRosServiceConnection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_RosServiceConnection_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:1434:3: this_RosActionConnection_2= ruleRosActionConnection
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRosConnectionAccess().getRosActionConnectionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RosActionConnection_2=ruleRosActionConnection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RosActionConnection_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosConnection"


    // $ANTLR start "entryRuleRosTopicConnection"
    // InternalRosSystemParser.g:1446:1: entryRuleRosTopicConnection returns [EObject current=null] : iv_ruleRosTopicConnection= ruleRosTopicConnection EOF ;
    public final EObject entryRuleRosTopicConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosTopicConnection = null;


        try {
            // InternalRosSystemParser.g:1446:59: (iv_ruleRosTopicConnection= ruleRosTopicConnection EOF )
            // InternalRosSystemParser.g:1447:2: iv_ruleRosTopicConnection= ruleRosTopicConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosTopicConnectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosTopicConnection=ruleRosTopicConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosTopicConnection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosTopicConnection"


    // $ANTLR start "ruleRosTopicConnection"
    // InternalRosSystemParser.g:1453:1: ruleRosTopicConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosTopicConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1459:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1460:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1460:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1461:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosTopicConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosTopicConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1469:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1470:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1470:4: ( ruleEString )
            // InternalRosSystemParser.g:1471:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosTopicConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosTopicConnectionAccess().getFromPublisherCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosTopicConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1489:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1490:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1490:4: ( ruleEString )
            // InternalRosSystemParser.g:1491:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosTopicConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosTopicConnectionAccess().getToSubscriberCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRosTopicConnectionAccess().getRightSquareBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosTopicConnection"


    // $ANTLR start "entryRuleRosServiceConnection"
    // InternalRosSystemParser.g:1513:1: entryRuleRosServiceConnection returns [EObject current=null] : iv_ruleRosServiceConnection= ruleRosServiceConnection EOF ;
    public final EObject entryRuleRosServiceConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServiceConnection = null;


        try {
            // InternalRosSystemParser.g:1513:61: (iv_ruleRosServiceConnection= ruleRosServiceConnection EOF )
            // InternalRosSystemParser.g:1514:2: iv_ruleRosServiceConnection= ruleRosServiceConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosServiceConnectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosServiceConnection=ruleRosServiceConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosServiceConnection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosServiceConnection"


    // $ANTLR start "ruleRosServiceConnection"
    // InternalRosSystemParser.g:1520:1: ruleRosServiceConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosServiceConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1526:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1527:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1527:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1528:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServiceConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosServiceConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1536:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1537:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1537:4: ( ruleEString )
            // InternalRosSystemParser.g:1538:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServiceConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServiceConnectionAccess().getFromServiceServerCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosServiceConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1556:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1557:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1557:4: ( ruleEString )
            // InternalRosSystemParser.g:1558:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServiceConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServiceConnectionAccess().getToServiceClientCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRosServiceConnectionAccess().getRightSquareBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosServiceConnection"


    // $ANTLR start "entryRuleRosActionConnection"
    // InternalRosSystemParser.g:1580:1: entryRuleRosActionConnection returns [EObject current=null] : iv_ruleRosActionConnection= ruleRosActionConnection EOF ;
    public final EObject entryRuleRosActionConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionConnection = null;


        try {
            // InternalRosSystemParser.g:1580:60: (iv_ruleRosActionConnection= ruleRosActionConnection EOF )
            // InternalRosSystemParser.g:1581:2: iv_ruleRosActionConnection= ruleRosActionConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRosActionConnectionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRosActionConnection=ruleRosActionConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRosActionConnection; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosActionConnection"


    // $ANTLR start "ruleRosActionConnection"
    // InternalRosSystemParser.g:1587:1: ruleRosActionConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosActionConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1593:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1594:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1594:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1595:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosActionConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1603:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1604:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1604:4: ( ruleEString )
            // InternalRosSystemParser.g:1605:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionConnectionAccess().getFromActionServerCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosActionConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1623:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1624:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1624:4: ( ruleEString )
            // InternalRosSystemParser.g:1625:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionConnectionAccess().getToActionClientCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRosActionConnectionAccess().getRightSquareBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosActionConnection"


    // $ANTLR start "entryRuleExtensionColonKey"
    // InternalRosSystemParser.g:1647:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRosSystemParser.g:1647:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRosSystemParser.g:1648:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionColonKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionColonKey=ruleExtensionColonKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionColonKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionColonKey"


    // $ANTLR start "ruleExtensionColonKey"
    // InternalRosSystemParser.g:1654:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Plugins | kw= Interfaces ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1660:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Plugins | kw= Interfaces ) )
            // InternalRosSystemParser.g:1661:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Plugins | kw= Interfaces )
            {
            // InternalRosSystemParser.g:1661:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Plugins | kw= Interfaces )
            int alt24=15;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt24=1;
                }
                break;
            case Type_1:
                {
                alt24=2;
                }
                break;
            case Value_1:
                {
                alt24=3;
                }
                break;
            case Default:
                {
                alt24=4;
                }
                break;
            case FromFile:
                {
                alt24=5;
                }
                break;
            case SubSystems:
                {
                alt24=6;
                }
                break;
            case Processes:
                {
                alt24=7;
                }
                break;
            case Nodes:
                {
                alt24=8;
                }
                break;
            case Parameters:
                {
                alt24=9;
                }
                break;
            case Connections:
                {
                alt24=10;
                }
                break;
            case Threads:
                {
                alt24=11;
                }
                break;
            case From:
                {
                alt24=12;
                }
                break;
            case Namespace:
                {
                alt24=13;
                }
                break;
            case Plugins:
                {
                alt24=14;
                }
                break;
            case Interfaces:
                {
                alt24=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalRosSystemParser.g:1662:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:1668:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:1674:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:1680:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:1686:3: kw= FromFile
                    {
                    kw=(Token)match(input,FromFile,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromFileKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:1692:3: kw= SubSystems
                    {
                    kw=(Token)match(input,SubSystems,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubSystemsKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:1698:3: kw= Processes
                    {
                    kw=(Token)match(input,Processes,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getProcessesKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:1704:3: kw= Nodes
                    {
                    kw=(Token)match(input,Nodes,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodesKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:1710:3: kw= Parameters
                    {
                    kw=(Token)match(input,Parameters,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParametersKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:1716:3: kw= Connections
                    {
                    kw=(Token)match(input,Connections,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getConnectionsKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:1722:3: kw= Threads
                    {
                    kw=(Token)match(input,Threads,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getThreadsKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:1728:3: kw= From
                    {
                    kw=(Token)match(input,From,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:1734:3: kw= Namespace
                    {
                    kw=(Token)match(input,Namespace,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNamespaceKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:1740:3: kw= Plugins
                    {
                    kw=(Token)match(input,Plugins,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPluginsKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalRosSystemParser.g:1746:3: kw= Interfaces
                    {
                    kw=(Token)match(input,Interfaces,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getInterfacesKeyword_14());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionColonKey"


    // $ANTLR start "entryRuleNamespace"
    // InternalRosSystemParser.g:1755:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRosSystemParser.g:1755:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRosSystemParser.g:1756:2: iv_ruleNamespace= ruleNamespace EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamespaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamespace; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalRosSystemParser.g:1762:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1768:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRosSystemParser.g:1769:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRosSystemParser.g:1769:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt25=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt25=1;
                }
                break;
            case RelativeNamespace:
                {
                alt25=2;
                }
                break;
            case PrivateNamespace:
                {
                alt25=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalRosSystemParser.g:1770:3: this_GlobalNamespace_0= ruleGlobalNamespace
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNamespaceAccess().getGlobalNamespaceParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_GlobalNamespace_0=ruleGlobalNamespace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_GlobalNamespace_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:1779:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNamespaceAccess().getRelativeNamespace_ImplParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RelativeNamespace_Impl_1=ruleRelativeNamespace_Impl();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RelativeNamespace_Impl_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:1788:3: this_PrivateNamespace_2= rulePrivateNamespace
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNamespaceAccess().getPrivateNamespaceParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrivateNamespace_2=rulePrivateNamespace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrivateNamespace_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRuleGraphName"
    // InternalRosSystemParser.g:1800:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRosSystemParser.g:1800:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRosSystemParser.g:1801:2: iv_ruleGraphName= ruleGraphName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGraphNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGraphName=ruleGraphName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGraphName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGraphName"


    // $ANTLR start "ruleGraphName"
    // InternalRosSystemParser.g:1807:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1813:2: (kw= GraphName )
            // InternalRosSystemParser.g:1814:2: kw= GraphName
            {
            kw=(Token)match(input,GraphName,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getGraphNameAccess().getGraphNameKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGraphName"


    // $ANTLR start "entryRuleGlobalNamespace"
    // InternalRosSystemParser.g:1822:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRosSystemParser.g:1822:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRosSystemParser.g:1823:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGlobalNamespaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGlobalNamespace=ruleGlobalNamespace();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGlobalNamespace; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalNamespace"


    // $ANTLR start "ruleGlobalNamespace"
    // InternalRosSystemParser.g:1829:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject ruleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1835:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:1836:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:1836:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:1837:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:1837:3: ()
            // InternalRosSystemParser.g:1838:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1848:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LeftSquareBracket) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRosSystemParser.g:1849:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:1853:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:1854:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:1854:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:1855:6: lv_parts_3_0= ruleGraphName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getGlobalNamespaceRule());
                      						}
                      						add(
                      							current,
                      							"parts",
                      							lv_parts_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.GraphName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:1872:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==Comma) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:1873:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_28); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:1877:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:1878:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:1878:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:1879:7: lv_parts_5_0= ruleGraphName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getGlobalNamespaceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parts",
                    	      								lv_parts_5_0,
                    	      								"de.fraunhofer.ipa.ros.Basics.GraphName");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getGlobalNamespaceAccess().getRightSquareBracketKeyword_2_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalNamespace"


    // $ANTLR start "entryRuleRelativeNamespace_Impl"
    // InternalRosSystemParser.g:1906:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRosSystemParser.g:1906:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRosSystemParser.g:1907:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelativeNamespace_ImplRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelativeNamespace_Impl=ruleRelativeNamespace_Impl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelativeNamespace_Impl; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelativeNamespace_Impl"


    // $ANTLR start "ruleRelativeNamespace_Impl"
    // InternalRosSystemParser.g:1913:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject ruleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1919:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:1920:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:1920:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:1921:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:1921:3: ()
            // InternalRosSystemParser.g:1922:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1932:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LeftSquareBracket) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalRosSystemParser.g:1933:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:1937:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:1938:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:1938:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:1939:6: lv_parts_3_0= ruleGraphName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelativeNamespace_ImplRule());
                      						}
                      						add(
                      							current,
                      							"parts",
                      							lv_parts_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.GraphName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:1956:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==Comma) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:1957:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_28); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:1961:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:1962:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:1962:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:1963:7: lv_parts_5_0= ruleGraphName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getRelativeNamespace_ImplRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parts",
                    	      								lv_parts_5_0,
                    	      								"de.fraunhofer.ipa.ros.Basics.GraphName");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getRelativeNamespace_ImplAccess().getRightSquareBracketKeyword_2_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelativeNamespace_Impl"


    // $ANTLR start "entryRulePrivateNamespace"
    // InternalRosSystemParser.g:1990:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRosSystemParser.g:1990:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRosSystemParser.g:1991:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivateNamespaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrivateNamespace=rulePrivateNamespace();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivateNamespace; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrivateNamespace"


    // $ANTLR start "rulePrivateNamespace"
    // InternalRosSystemParser.g:1997:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
    public final EObject rulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_parts_3_0 = null;

        AntlrDatatypeRuleToken lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2003:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:2004:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:2004:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:2005:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:2005:3: ()
            // InternalRosSystemParser.g:2006:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2016:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LeftSquareBracket) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalRosSystemParser.g:2017:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2021:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:2022:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:2022:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:2023:6: lv_parts_3_0= ruleGraphName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrivateNamespaceRule());
                      						}
                      						add(
                      							current,
                      							"parts",
                      							lv_parts_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.GraphName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:2040:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==Comma) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:2041:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_28); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:2045:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:2046:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:2046:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:2047:7: lv_parts_5_0= ruleGraphName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_12);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getPrivateNamespaceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parts",
                    	      								lv_parts_5_0,
                    	      								"de.fraunhofer.ipa.ros.Basics.GraphName");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getPrivateNamespaceAccess().getRightSquareBracketKeyword_2_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrivateNamespace"


    // $ANTLR start "entryRuleParameter"
    // InternalRosSystemParser.g:2074:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRosSystemParser.g:2074:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRosSystemParser.g:2075:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalRosSystemParser.g:2081:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_END_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_5_0 = null;

        EObject lv_type_7_0 = null;

        EObject lv_value_9_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2087:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) )
            // InternalRosSystemParser.g:2088:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            {
            // InternalRosSystemParser.g:2088:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            // InternalRosSystemParser.g:2089:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END
            {
            // InternalRosSystemParser.g:2089:3: ()
            // InternalRosSystemParser.g:2090:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterAccess().getParameterAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:2096:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosSystemParser.g:2097:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosSystemParser.g:2097:4: (lv_name_1_0= ruleEString )
            // InternalRosSystemParser.g:2098:5: lv_name_1_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
              		
            }
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_3, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_3());
              		
            }
            // InternalRosSystemParser.g:2123:3: (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==Ns) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalRosSystemParser.g:2124:4: otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) )
                    {
                    otherlv_4=(Token)match(input,Ns,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getNsKeyword_4_0());
                      			
                    }
                    // InternalRosSystemParser.g:2128:4: ( (lv_namespace_5_0= ruleNamespace ) )
                    // InternalRosSystemParser.g:2129:5: (lv_namespace_5_0= ruleNamespace )
                    {
                    // InternalRosSystemParser.g:2129:5: (lv_namespace_5_0= ruleNamespace )
                    // InternalRosSystemParser.g:2130:6: lv_namespace_5_0= ruleNamespace
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
                    lv_namespace_5_0=ruleNamespace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterRule());
                      						}
                      						set(
                      							current,
                      							"namespace",
                      							lv_namespace_5_0,
                      							"de.fraunhofer.ipa.ros.Basics.Namespace");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,Type_1,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getTypeKeyword_5());
              		
            }
            // InternalRosSystemParser.g:2152:3: ( (lv_type_7_0= ruleParameterType ) )
            // InternalRosSystemParser.g:2153:4: (lv_type_7_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:2153:4: (lv_type_7_0= ruleParameterType )
            // InternalRosSystemParser.g:2154:5: lv_type_7_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_type_7_0=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_7_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:2171:3: (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==Value_1) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalRosSystemParser.g:2172:4: otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) )
                    {
                    otherlv_8=(Token)match(input,Value_1,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getValueKeyword_7_0());
                      			
                    }
                    // InternalRosSystemParser.g:2176:4: ( (lv_value_9_0= ruleParameterValue ) )
                    // InternalRosSystemParser.g:2177:5: (lv_value_9_0= ruleParameterValue )
                    {
                    // InternalRosSystemParser.g:2177:5: (lv_value_9_0= ruleParameterValue )
                    // InternalRosSystemParser.g:2178:6: lv_value_9_0= ruleParameterValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_15);
                    lv_value_9_0=ruleParameterValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_9_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_10, grammarAccess.getParameterAccess().getENDTerminalRuleCall_8());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterType"
    // InternalRosSystemParser.g:2204:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRosSystemParser.g:2204:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRosSystemParser.g:2205:2: iv_ruleParameterType= ruleParameterType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterType"


    // $ANTLR start "ruleParameterType"
    // InternalRosSystemParser.g:2211:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
    public final EObject ruleParameterType() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterListType_0 = null;

        EObject this_ParameterStructType_1 = null;

        EObject this_ParameterIntegerType_2 = null;

        EObject this_ParameterStringType_3 = null;

        EObject this_ParameterDoubleType_4 = null;

        EObject this_ParameterBooleanType_5 = null;

        EObject this_ParameterBase64Type_6 = null;

        EObject this_ParameterArrayType_7 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2217:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRosSystemParser.g:2218:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRosSystemParser.g:2218:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt34=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt34=1;
                }
                break;
            case Struct:
                {
                alt34=2;
                }
                break;
            case Integer:
                {
                alt34=3;
                }
                break;
            case String:
                {
                alt34=4;
                }
                break;
            case Double:
                {
                alt34=5;
                }
                break;
            case Boolean:
                {
                alt34=6;
                }
                break;
            case Base64:
                {
                alt34=7;
                }
                break;
            case Array:
                {
                alt34=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalRosSystemParser.g:2219:3: this_ParameterListType_0= ruleParameterListType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterListTypeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterListType_0=ruleParameterListType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterListType_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:2228:3: this_ParameterStructType_1= ruleParameterStructType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStructTypeParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterStructType_1=ruleParameterStructType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterStructType_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:2237:3: this_ParameterIntegerType_2= ruleParameterIntegerType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterIntegerTypeParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterIntegerType_2=ruleParameterIntegerType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterIntegerType_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:2246:3: this_ParameterStringType_3= ruleParameterStringType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStringTypeParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterStringType_3=ruleParameterStringType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterStringType_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:2255:3: this_ParameterDoubleType_4= ruleParameterDoubleType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterDoubleTypeParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterDoubleType_4=ruleParameterDoubleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterDoubleType_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:2264:3: this_ParameterBooleanType_5= ruleParameterBooleanType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBooleanTypeParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterBooleanType_5=ruleParameterBooleanType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterBooleanType_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:2273:3: this_ParameterBase64Type_6= ruleParameterBase64Type
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBase64TypeParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterBase64Type_6=ruleParameterBase64Type();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterBase64Type_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:2282:3: this_ParameterArrayType_7= ruleParameterArrayType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterArrayTypeParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterArrayType_7=ruleParameterArrayType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterArrayType_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "entryRuleParameterValue"
    // InternalRosSystemParser.g:2294:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRosSystemParser.g:2294:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRosSystemParser.g:2295:2: iv_ruleParameterValue= ruleParameterValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterValue=ruleParameterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterValue"


    // $ANTLR start "ruleParameterValue"
    // InternalRosSystemParser.g:2301:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
    public final EObject ruleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject this_ParameterString_0 = null;

        EObject this_ParameterBase64_1 = null;

        EObject this_ParameterInteger_2 = null;

        EObject this_ParameterDouble_3 = null;

        EObject this_ParameterBoolean_4 = null;

        EObject this_ParameterList_5 = null;

        EObject this_ParameterStruct_6 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2307:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRosSystemParser.g:2308:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRosSystemParser.g:2308:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt35=7;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // InternalRosSystemParser.g:2309:3: this_ParameterString_0= ruleParameterString
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStringParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterString_0=ruleParameterString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterString_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:2318:3: this_ParameterBase64_1= ruleParameterBase64
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBase64ParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterBase64_1=ruleParameterBase64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterBase64_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:2327:3: this_ParameterInteger_2= ruleParameterInteger
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterIntegerParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterInteger_2=ruleParameterInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterInteger_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:2336:3: this_ParameterDouble_3= ruleParameterDouble
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterDoubleParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterDouble_3=ruleParameterDouble();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterDouble_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:2345:3: this_ParameterBoolean_4= ruleParameterBoolean
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBooleanParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterBoolean_4=ruleParameterBoolean();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterBoolean_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:2354:3: this_ParameterList_5= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterListParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterList_5=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterList_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:2363:3: this_ParameterStruct_6= ruleParameterStruct
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStructParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParameterStruct_6=ruleParameterStruct();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParameterStruct_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterValue"


    // $ANTLR start "entryRuleParameterListType"
    // InternalRosSystemParser.g:2375:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRosSystemParser.g:2375:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRosSystemParser.g:2376:2: iv_ruleParameterListType= ruleParameterListType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterListType=ruleParameterListType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterListType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterListType"


    // $ANTLR start "ruleParameterListType"
    // InternalRosSystemParser.g:2382:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleParameterListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_sequence_3_0 = null;

        EObject lv_sequence_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2388:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosSystemParser.g:2389:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosSystemParser.g:2389:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosSystemParser.g:2390:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosSystemParser.g:2390:3: ()
            // InternalRosSystemParser.g:2391:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,List,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalRosSystemParser.g:2405:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRosSystemParser.g:2406:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:2406:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRosSystemParser.g:2407:5: lv_sequence_3_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_sequence_3_0=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterListTypeRule());
              					}
              					add(
              						current,
              						"sequence",
              						lv_sequence_3_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:2424:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==Comma) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalRosSystemParser.g:2425:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:2429:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRosSystemParser.g:2430:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRosSystemParser.g:2430:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRosSystemParser.g:2431:6: lv_sequence_5_0= ruleParameterType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_sequence_5_0=ruleParameterType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getParameterListTypeRule());
            	      						}
            	      						add(
            	      							current,
            	      							"sequence",
            	      							lv_sequence_5_0,
            	      							"de.fraunhofer.ipa.ros.Basics.ParameterType");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getParameterListTypeAccess().getRightSquareBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterListType"


    // $ANTLR start "entryRuleParameterStructType"
    // InternalRosSystemParser.g:2457:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRosSystemParser.g:2457:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRosSystemParser.g:2458:2: iv_ruleParameterStructType= ruleParameterStructType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterStructTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructType=ruleParameterStructType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterStructType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructType"


    // $ANTLR start "ruleParameterStructType"
    // InternalRosSystemParser.g:2464:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleParameterStructType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameterstructypetmember_3_0 = null;

        EObject lv_parameterstructypetmember_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2470:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosSystemParser.g:2471:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosSystemParser.g:2471:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosSystemParser.g:2472:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosSystemParser.g:2472:3: ()
            // InternalRosSystemParser.g:2473:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalRosSystemParser.g:2487:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRosSystemParser.g:2488:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRosSystemParser.g:2488:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRosSystemParser.g:2489:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_parameterstructypetmember_3_0=ruleParameterStructTypeMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterStructTypeRule());
              					}
              					add(
              						current,
              						"parameterstructypetmember",
              						lv_parameterstructypetmember_3_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterStructTypeMember");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:2506:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==Comma) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalRosSystemParser.g:2507:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:2511:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRosSystemParser.g:2512:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRosSystemParser.g:2512:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRosSystemParser.g:2513:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_parameterstructypetmember_5_0=ruleParameterStructTypeMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getParameterStructTypeRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameterstructypetmember",
            	      							lv_parameterstructypetmember_5_0,
            	      							"de.fraunhofer.ipa.ros.Basics.ParameterStructTypeMember");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getParameterStructTypeAccess().getRightSquareBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructType"


    // $ANTLR start "entryRuleParameterIntegerType"
    // InternalRosSystemParser.g:2539:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRosSystemParser.g:2539:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRosSystemParser.g:2540:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterIntegerTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterIntegerType=ruleParameterIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterIntegerType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterIntegerType"


    // $ANTLR start "ruleParameterIntegerType"
    // InternalRosSystemParser.g:2546:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2552:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRosSystemParser.g:2553:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRosSystemParser.g:2553:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRosSystemParser.g:2554:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRosSystemParser.g:2554:3: ()
            // InternalRosSystemParser.g:2555:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2565:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==Default) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalRosSystemParser.g:2566:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2570:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRosSystemParser.g:2571:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRosSystemParser.g:2571:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRosSystemParser.g:2572:6: lv_default_3_0= ruleParameterInteger
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterIntegerTypeAccess().getDefaultParameterIntegerParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterIntegerTypeRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterInteger");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterIntegerType"


    // $ANTLR start "entryRuleParameterStringType"
    // InternalRosSystemParser.g:2594:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRosSystemParser.g:2594:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRosSystemParser.g:2595:2: iv_ruleParameterStringType= ruleParameterStringType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterStringTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterStringType=ruleParameterStringType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterStringType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStringType"


    // $ANTLR start "ruleParameterStringType"
    // InternalRosSystemParser.g:2601:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2607:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRosSystemParser.g:2608:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRosSystemParser.g:2608:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRosSystemParser.g:2609:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRosSystemParser.g:2609:3: ()
            // InternalRosSystemParser.g:2610:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,String,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2620:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Default) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRosSystemParser.g:2621:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2625:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRosSystemParser.g:2626:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRosSystemParser.g:2626:5: (lv_default_3_0= ruleParameterString )
                    // InternalRosSystemParser.g:2627:6: lv_default_3_0= ruleParameterString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterStringTypeAccess().getDefaultParameterStringParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterStringTypeRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStringType"


    // $ANTLR start "entryRuleParameterDoubleType"
    // InternalRosSystemParser.g:2649:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRosSystemParser.g:2649:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRosSystemParser.g:2650:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterDoubleTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterDoubleType=ruleParameterDoubleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterDoubleType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDoubleType"


    // $ANTLR start "ruleParameterDoubleType"
    // InternalRosSystemParser.g:2656:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2662:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRosSystemParser.g:2663:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRosSystemParser.g:2663:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRosSystemParser.g:2664:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRosSystemParser.g:2664:3: ()
            // InternalRosSystemParser.g:2665:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2675:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Default) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalRosSystemParser.g:2676:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2680:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRosSystemParser.g:2681:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRosSystemParser.g:2681:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRosSystemParser.g:2682:6: lv_default_3_0= ruleParameterDouble
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterDoubleTypeAccess().getDefaultParameterDoubleParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterDouble();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterDoubleTypeRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterDouble");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDoubleType"


    // $ANTLR start "entryRuleParameterBooleanType"
    // InternalRosSystemParser.g:2704:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRosSystemParser.g:2704:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRosSystemParser.g:2705:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterBooleanTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterBooleanType=ruleParameterBooleanType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterBooleanType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBooleanType"


    // $ANTLR start "ruleParameterBooleanType"
    // InternalRosSystemParser.g:2711:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2717:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRosSystemParser.g:2718:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRosSystemParser.g:2718:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRosSystemParser.g:2719:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRosSystemParser.g:2719:3: ()
            // InternalRosSystemParser.g:2720:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2730:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Default) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRosSystemParser.g:2731:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2735:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRosSystemParser.g:2736:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRosSystemParser.g:2736:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRosSystemParser.g:2737:6: lv_default_3_0= ruleParameterBoolean
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterBooleanTypeAccess().getDefaultParameterBooleanParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBoolean();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterBooleanTypeRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterBoolean");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBooleanType"


    // $ANTLR start "entryRuleParameterBase64Type"
    // InternalRosSystemParser.g:2759:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRosSystemParser.g:2759:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRosSystemParser.g:2760:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterBase64TypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64Type=ruleParameterBase64Type();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterBase64Type; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBase64Type"


    // $ANTLR start "ruleParameterBase64Type"
    // InternalRosSystemParser.g:2766:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2772:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRosSystemParser.g:2773:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRosSystemParser.g:2773:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRosSystemParser.g:2774:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRosSystemParser.g:2774:3: ()
            // InternalRosSystemParser.g:2775:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
              		
            }
            // InternalRosSystemParser.g:2785:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==Default) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRosSystemParser.g:2786:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2790:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRosSystemParser.g:2791:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRosSystemParser.g:2791:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRosSystemParser.g:2792:6: lv_default_3_0= ruleParameterBase64
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterBase64TypeAccess().getDefaultParameterBase64ParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBase64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterBase64TypeRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterBase64");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBase64Type"


    // $ANTLR start "entryRuleParameterArrayType"
    // InternalRosSystemParser.g:2814:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRosSystemParser.g:2814:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRosSystemParser.g:2815:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterArrayTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterArrayType=ruleParameterArrayType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterArrayType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterArrayType"


    // $ANTLR start "ruleParameterArrayType"
    // InternalRosSystemParser.g:2821:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
    public final EObject ruleParameterArrayType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_type_2_0 = null;

        EObject lv_default_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2827:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRosSystemParser.g:2828:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRosSystemParser.g:2828:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRosSystemParser.g:2829:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2837:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRosSystemParser.g:2838:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:2838:4: (lv_type_2_0= ruleParameterType )
            // InternalRosSystemParser.g:2839:5: lv_type_2_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_26);
            lv_type_2_0=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterArrayTypeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
              		
            }
            // InternalRosSystemParser.g:2860:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Default) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalRosSystemParser.g:2861:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                      			
                    }
                    // InternalRosSystemParser.g:2865:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRosSystemParser.g:2866:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRosSystemParser.g:2866:5: (lv_default_5_0= ruleParameterList )
                    // InternalRosSystemParser.g:2867:6: lv_default_5_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getDefaultParameterListParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_default_5_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterArrayTypeRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_5_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterList");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterArrayType"


    // $ANTLR start "entryRuleParameterList"
    // InternalRosSystemParser.g:2889:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRosSystemParser.g:2889:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRosSystemParser.g:2890:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalRosSystemParser.g:2896:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2902:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:2903:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:2903:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:2904:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRosSystemParser.g:2904:3: ()
            // InternalRosSystemParser.g:2905:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2915:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:2916:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:2916:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosSystemParser.g:2917:5: lv_value_2_0= ruleParameterValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_12);
            lv_value_2_0=ruleParameterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterListRule());
              					}
              					add(
              						current,
              						"value",
              						lv_value_2_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:2934:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==Comma) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalRosSystemParser.g:2935:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_24); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:2939:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRosSystemParser.g:2940:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRosSystemParser.g:2940:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRosSystemParser.g:2941:6: lv_value_4_0= ruleParameterValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_value_4_0=ruleParameterValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getParameterListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"value",
            	      							lv_value_4_0,
            	      							"de.fraunhofer.ipa.ros.Basics.ParameterValue");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getParameterListAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleParameterAny"
    // InternalRosSystemParser.g:2967:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRosSystemParser.g:2967:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRosSystemParser.g:2968:2: iv_ruleParameterAny= ruleParameterAny EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterAnyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterAny=ruleParameterAny();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterAny; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterAny"


    // $ANTLR start "ruleParameterAny"
    // InternalRosSystemParser.g:2974:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2980:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRosSystemParser.g:2981:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRosSystemParser.g:2981:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRosSystemParser.g:2982:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRosSystemParser.g:2982:3: ()
            // InternalRosSystemParser.g:2983:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2993:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Value) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalRosSystemParser.g:2994:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2998:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRosSystemParser.g:2999:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:2999:5: (lv_value_3_0= ruleEString )
                    // InternalRosSystemParser.g:3000:6: lv_value_3_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterAnyAccess().getValueEStringParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterAnyRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.EString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterAny"


    // $ANTLR start "entryRuleParameterString"
    // InternalRosSystemParser.g:3022:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRosSystemParser.g:3022:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRosSystemParser.g:3023:2: iv_ruleParameterString= ruleParameterString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterString=ruleParameterString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterString; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterString"


    // $ANTLR start "ruleParameterString"
    // InternalRosSystemParser.g:3029:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3035:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRosSystemParser.g:3036:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRosSystemParser.g:3036:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRosSystemParser.g:3037:3: (lv_value_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:3037:3: (lv_value_0_0= ruleEString )
            // InternalRosSystemParser.g:3038:4: lv_value_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterStringAccess().getValueEStringParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterStringRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.fraunhofer.ipa.ros.Basics.EString");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterString"


    // $ANTLR start "entryRuleParameterBase64"
    // InternalRosSystemParser.g:3058:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRosSystemParser.g:3058:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRosSystemParser.g:3059:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterBase64Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64=ruleParameterBase64();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterBase64; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBase64"


    // $ANTLR start "ruleParameterBase64"
    // InternalRosSystemParser.g:3065:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3071:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRosSystemParser.g:3072:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRosSystemParser.g:3072:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRosSystemParser.g:3073:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRosSystemParser.g:3073:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRosSystemParser.g:3074:4: lv_value_0_0= ruleBase64Binary
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterBase64Access().getValueBase64BinaryParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleBase64Binary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterBase64Rule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.fraunhofer.ipa.ros.Basics.Base64Binary");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBase64"


    // $ANTLR start "entryRuleParameterInteger"
    // InternalRosSystemParser.g:3094:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRosSystemParser.g:3094:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRosSystemParser.g:3095:2: iv_ruleParameterInteger= ruleParameterInteger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterIntegerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterInteger=ruleParameterInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterInteger; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterInteger"


    // $ANTLR start "ruleParameterInteger"
    // InternalRosSystemParser.g:3101:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3107:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRosSystemParser.g:3108:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRosSystemParser.g:3108:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRosSystemParser.g:3109:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRosSystemParser.g:3109:3: (lv_value_0_0= ruleInteger0 )
            // InternalRosSystemParser.g:3110:4: lv_value_0_0= ruleInteger0
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterIntegerAccess().getValueInteger0ParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleInteger0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterIntegerRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.fraunhofer.ipa.ros.Basics.Integer0");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterInteger"


    // $ANTLR start "entryRuleParameterDouble"
    // InternalRosSystemParser.g:3130:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRosSystemParser.g:3130:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRosSystemParser.g:3131:2: iv_ruleParameterDouble= ruleParameterDouble EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterDoubleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterDouble=ruleParameterDouble();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterDouble; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDouble"


    // $ANTLR start "ruleParameterDouble"
    // InternalRosSystemParser.g:3137:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3143:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRosSystemParser.g:3144:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRosSystemParser.g:3144:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRosSystemParser.g:3145:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRosSystemParser.g:3145:3: (lv_value_0_0= ruleDouble0 )
            // InternalRosSystemParser.g:3146:4: lv_value_0_0= ruleDouble0
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterDoubleAccess().getValueDouble0ParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDouble0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterDoubleRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.fraunhofer.ipa.ros.Basics.Double0");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDouble"


    // $ANTLR start "entryRuleParameterBoolean"
    // InternalRosSystemParser.g:3166:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRosSystemParser.g:3166:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRosSystemParser.g:3167:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterBooleanRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterBoolean=ruleParameterBoolean();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterBoolean; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterBoolean"


    // $ANTLR start "ruleParameterBoolean"
    // InternalRosSystemParser.g:3173:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3179:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRosSystemParser.g:3180:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRosSystemParser.g:3180:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRosSystemParser.g:3181:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRosSystemParser.g:3181:3: (lv_value_0_0= ruleboolean0 )
            // InternalRosSystemParser.g:3182:4: lv_value_0_0= ruleboolean0
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterBooleanAccess().getValueBoolean0ParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleboolean0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterBooleanRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.fraunhofer.ipa.ros.Basics.boolean0");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterBoolean"


    // $ANTLR start "entryRuleParameterStruct"
    // InternalRosSystemParser.g:3202:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRosSystemParser.g:3202:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRosSystemParser.g:3203:2: iv_ruleParameterStruct= ruleParameterStruct EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterStructRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterStruct=ruleParameterStruct();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterStruct; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStruct"


    // $ANTLR start "ruleParameterStruct"
    // InternalRosSystemParser.g:3209:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3215:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRosSystemParser.g:3216:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRosSystemParser.g:3216:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRosSystemParser.g:3217:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRosSystemParser.g:3217:3: ()
            // InternalRosSystemParser.g:3218:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:3224:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==LeftSquareBracket) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRosSystemParser.g:3225:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                      			
                    }
                    // InternalRosSystemParser.g:3233:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( ((LA46_0>=RULE_ID && LA46_0<=RULE_STRING)) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:3234:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRosSystemParser.g:3234:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRosSystemParser.g:3235:6: lv_value_3_0= ruleParameterStructMember
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_39);
                    	    lv_value_3_0=ruleParameterStructMember();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getParameterStructRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"value",
                    	      							lv_value_3_0,
                    	      							"de.fraunhofer.ipa.ros.Basics.ParameterStructMember");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getParameterStructAccess().getRightSquareBracketKeyword_1_3());
                      			
                    }
                    this_END_5=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_5, grammarAccess.getParameterStructAccess().getENDTerminalRuleCall_1_4());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStruct"


    // $ANTLR start "entryRuleParameterDate"
    // InternalRosSystemParser.g:3265:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRosSystemParser.g:3265:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRosSystemParser.g:3266:2: iv_ruleParameterDate= ruleParameterDate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterDateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterDate=ruleParameterDate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterDate; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterDate"


    // $ANTLR start "ruleParameterDate"
    // InternalRosSystemParser.g:3272:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3278:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRosSystemParser.g:3279:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRosSystemParser.g:3279:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRosSystemParser.g:3280:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRosSystemParser.g:3280:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRosSystemParser.g:3281:4: lv_value_0_0= ruleDateTime0
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getParameterDateAccess().getValueDateTime0ParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDateTime0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getParameterDateRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"de.fraunhofer.ipa.ros.Basics.DateTime0");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterDate"


    // $ANTLR start "entryRuleParameterStructMember"
    // InternalRosSystemParser.g:3301:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRosSystemParser.g:3301:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRosSystemParser.g:3302:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterStructMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructMember=ruleParameterStructMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterStructMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructMember"


    // $ANTLR start "ruleParameterStructMember"
    // InternalRosSystemParser.g:3308:1: ruleParameterStructMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3314:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) )
            // InternalRosSystemParser.g:3315:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            {
            // InternalRosSystemParser.g:3315:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            // InternalRosSystemParser.g:3316:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) )
            {
            // InternalRosSystemParser.g:3316:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosSystemParser.g:3317:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:3317:4: (lv_name_0_0= ruleEString )
            // InternalRosSystemParser.g:3318:5: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_0_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,Colon,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_1());
              		
            }
            // InternalRosSystemParser.g:3339:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:3340:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:3340:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosSystemParser.g:3341:5: lv_value_2_0= ruleParameterValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleParameterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructMember"


    // $ANTLR start "entryRuleParameterStructTypeMember"
    // InternalRosSystemParser.g:3362:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRosSystemParser.g:3362:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRosSystemParser.g:3363:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterStructTypeMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructTypeMember=ruleParameterStructTypeMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterStructTypeMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterStructTypeMember"


    // $ANTLR start "ruleParameterStructTypeMember"
    // InternalRosSystemParser.g:3369:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3375:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRosSystemParser.g:3376:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRosSystemParser.g:3376:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRosSystemParser.g:3377:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRosSystemParser.g:3377:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosSystemParser.g:3378:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:3378:4: (lv_name_0_0= ruleEString )
            // InternalRosSystemParser.g:3379:5: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_name_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterStructTypeMemberRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_0_0,
              						"de.fraunhofer.ipa.ros.Basics.EString");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:3396:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRosSystemParser.g:3397:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:3397:4: (lv_type_1_0= ruleParameterType )
            // InternalRosSystemParser.g:3398:5: lv_type_1_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getTypeParameterTypeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterStructTypeMemberRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterStructTypeMember"


    // $ANTLR start "entryRuleBase64Binary"
    // InternalRosSystemParser.g:3419:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRosSystemParser.g:3419:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRosSystemParser.g:3420:2: iv_ruleBase64Binary= ruleBase64Binary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBase64BinaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBase64Binary=ruleBase64Binary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBase64Binary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBase64Binary"


    // $ANTLR start "ruleBase64Binary"
    // InternalRosSystemParser.g:3426:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3432:2: (this_BINARY_0= RULE_BINARY )
            // InternalRosSystemParser.g:3433:2: this_BINARY_0= RULE_BINARY
            {
            this_BINARY_0=(Token)match(input,RULE_BINARY,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_BINARY_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_BINARY_0, grammarAccess.getBase64BinaryAccess().getBINARYTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBase64Binary"


    // $ANTLR start "entryRuleboolean0"
    // InternalRosSystemParser.g:3443:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRosSystemParser.g:3443:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRosSystemParser.g:3444:2: iv_ruleboolean0= ruleboolean0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolean0Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleboolean0=ruleboolean0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleboolean0.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolean0"


    // $ANTLR start "ruleboolean0"
    // InternalRosSystemParser.g:3450:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3456:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRosSystemParser.g:3457:2: this_BOOLEAN_0= RULE_BOOLEAN
            {
            this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_BOOLEAN_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_BOOLEAN_0, grammarAccess.getBoolean0Access().getBOOLEANTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolean0"


    // $ANTLR start "entryRuleDouble0"
    // InternalRosSystemParser.g:3467:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRosSystemParser.g:3467:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRosSystemParser.g:3468:2: iv_ruleDouble0= ruleDouble0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDouble0Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDouble0=ruleDouble0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDouble0.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDouble0"


    // $ANTLR start "ruleDouble0"
    // InternalRosSystemParser.g:3474:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3480:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRosSystemParser.g:3481:2: this_DOUBLE_0= RULE_DOUBLE
            {
            this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DOUBLE_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_DOUBLE_0, grammarAccess.getDouble0Access().getDOUBLETerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDouble0"


    // $ANTLR start "entryRuleInteger0"
    // InternalRosSystemParser.g:3491:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRosSystemParser.g:3491:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRosSystemParser.g:3492:2: iv_ruleInteger0= ruleInteger0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInteger0Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInteger0=ruleInteger0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInteger0.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger0"


    // $ANTLR start "ruleInteger0"
    // InternalRosSystemParser.g:3498:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3504:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosSystemParser.g:3505:2: this_DECINT_0= RULE_DECINT
            {
            this_DECINT_0=(Token)match(input,RULE_DECINT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DECINT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_DECINT_0, grammarAccess.getInteger0Access().getDECINTTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger0"


    // $ANTLR start "entryRuleDateTime0"
    // InternalRosSystemParser.g:3515:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRosSystemParser.g:3515:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRosSystemParser.g:3516:2: iv_ruleDateTime0= ruleDateTime0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDateTime0Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDateTime0=ruleDateTime0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDateTime0.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateTime0"


    // $ANTLR start "ruleDateTime0"
    // InternalRosSystemParser.g:3522:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3528:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRosSystemParser.g:3529:2: this_DATE_TIME_0= RULE_DATE_TIME
            {
            this_DATE_TIME_0=(Token)match(input,RULE_DATE_TIME,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DATE_TIME_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_DATE_TIME_0, grammarAccess.getDateTime0Access().getDATE_TIMETerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateTime0"


    // $ANTLR start "entryRuleAbstractType"
    // InternalRosSystemParser.g:3539:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRosSystemParser.g:3539:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRosSystemParser.g:3540:2: iv_ruleAbstractType= ruleAbstractType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbstractType=ruleAbstractType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractType"


    // $ANTLR start "ruleAbstractType"
    // InternalRosSystemParser.g:3546:1: ruleAbstractType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
    public final EObject ruleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject this_bool_0 = null;

        EObject this_int8_1 = null;

        EObject this_uint8_2 = null;

        EObject this_int16_3 = null;

        EObject this_uint16_4 = null;

        EObject this_int32_5 = null;

        EObject this_uint32_6 = null;

        EObject this_int64_7 = null;

        EObject this_uint64_8 = null;

        EObject this_float32_9 = null;

        EObject this_float64_10 = null;

        EObject this_string0_11 = null;

        EObject this_byte_12 = null;

        EObject this_time_13 = null;

        EObject this_duration_14 = null;

        EObject this_Header_15 = null;

        EObject this_boolArray_16 = null;

        EObject this_int8Array_17 = null;

        EObject this_uint8Array_18 = null;

        EObject this_int16Array_19 = null;

        EObject this_uint16Array_20 = null;

        EObject this_int32Array_21 = null;

        EObject this_uint32Array_22 = null;

        EObject this_int64Array_23 = null;

        EObject this_uint64Array_24 = null;

        EObject this_float32Array_25 = null;

        EObject this_float64Array_26 = null;

        EObject this_string0Array_27 = null;

        EObject this_byteArray_28 = null;

        EObject this_SpecBaseRef_29 = null;

        EObject this_ArraySpecRef_30 = null;

        EObject this_char_31 = null;

        EObject this_charArray_32 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3552:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRosSystemParser.g:3553:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRosSystemParser.g:3553:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt48=33;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // InternalRosSystemParser.g:3554:3: this_bool_0= rulebool
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_bool_0=rulebool();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_bool_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:3563:3: this_int8_1= ruleint8
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int8_1=ruleint8();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int8_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:3572:3: this_uint8_2= ruleuint8
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint8_2=ruleuint8();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint8_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:3581:3: this_int16_3= ruleint16
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int16_3=ruleint16();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int16_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:3590:3: this_uint16_4= ruleuint16
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint16_4=ruleuint16();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint16_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:3599:3: this_int32_5= ruleint32
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int32_5=ruleint32();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int32_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:3608:3: this_uint32_6= ruleuint32
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint32_6=ruleuint32();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint32_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:3617:3: this_int64_7= ruleint64
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int64_7=ruleint64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int64_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:3626:3: this_uint64_8= ruleuint64
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint64_8=ruleuint64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint64_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:3635:3: this_float32_9= rulefloat32
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_float32_9=rulefloat32();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_float32_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:3644:3: this_float64_10= rulefloat64
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_float64_10=rulefloat64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_float64_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:3653:3: this_string0_11= rulestring0
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ParserRuleCall_11());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_string0_11=rulestring0();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_string0_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:3662:3: this_byte_12= rulebyte
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteParserRuleCall_12());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_byte_12=rulebyte();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_byte_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:3671:3: this_time_13= ruletime
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getTimeParserRuleCall_13());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_time_13=ruletime();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_time_13;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalRosSystemParser.g:3680:3: this_duration_14= ruleduration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getDurationParserRuleCall_14());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_duration_14=ruleduration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_duration_14;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalRosSystemParser.g:3689:3: this_Header_15= ruleHeader
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getHeaderParserRuleCall_15());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Header_15=ruleHeader();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Header_15;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalRosSystemParser.g:3698:3: this_boolArray_16= ruleboolArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_16());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_boolArray_16=ruleboolArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_boolArray_16;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalRosSystemParser.g:3707:3: this_int8Array_17= ruleint8Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_17());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int8Array_17=ruleint8Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int8Array_17;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalRosSystemParser.g:3716:3: this_uint8Array_18= ruleuint8Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_18());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint8Array_18=ruleuint8Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint8Array_18;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalRosSystemParser.g:3725:3: this_int16Array_19= ruleint16Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_19());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int16Array_19=ruleint16Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int16Array_19;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalRosSystemParser.g:3734:3: this_uint16Array_20= ruleuint16Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_20());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint16Array_20=ruleuint16Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint16Array_20;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalRosSystemParser.g:3743:3: this_int32Array_21= ruleint32Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_21());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int32Array_21=ruleint32Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int32Array_21;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalRosSystemParser.g:3752:3: this_uint32Array_22= ruleuint32Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_22());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint32Array_22=ruleuint32Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint32Array_22;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalRosSystemParser.g:3761:3: this_int64Array_23= ruleint64Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_23());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_int64Array_23=ruleint64Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_int64Array_23;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalRosSystemParser.g:3770:3: this_uint64Array_24= ruleuint64Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_24());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_uint64Array_24=ruleuint64Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_uint64Array_24;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalRosSystemParser.g:3779:3: this_float32Array_25= rulefloat32Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_25());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_float32Array_25=rulefloat32Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_float32Array_25;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalRosSystemParser.g:3788:3: this_float64Array_26= rulefloat64Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_26());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_float64Array_26=rulefloat64Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_float64Array_26;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalRosSystemParser.g:3797:3: this_string0Array_27= rulestring0Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_27());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_string0Array_27=rulestring0Array();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_string0Array_27;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalRosSystemParser.g:3806:3: this_byteArray_28= rulebyteArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_28());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_byteArray_28=rulebyteArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_byteArray_28;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 30 :
                    // InternalRosSystemParser.g:3815:3: this_SpecBaseRef_29= ruleSpecBaseRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getSpecBaseRefParserRuleCall_29());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SpecBaseRef_29=ruleSpecBaseRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SpecBaseRef_29;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 31 :
                    // InternalRosSystemParser.g:3824:3: this_ArraySpecRef_30= ruleArraySpecRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_30());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArraySpecRef_30=ruleArraySpecRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArraySpecRef_30;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 32 :
                    // InternalRosSystemParser.g:3833:3: this_char_31= rulechar
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getCharParserRuleCall_31());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_char_31=rulechar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_char_31;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 33 :
                    // InternalRosSystemParser.g:3842:3: this_charArray_32= rulecharArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_32());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_charArray_32=rulecharArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_charArray_32;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractType"


    // $ANTLR start "entryRulebool"
    // InternalRosSystemParser.g:3854:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRosSystemParser.g:3854:45: (iv_rulebool= rulebool EOF )
            // InternalRosSystemParser.g:3855:2: iv_rulebool= rulebool EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulebool=rulebool();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulebool; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebool"


    // $ANTLR start "rulebool"
    // InternalRosSystemParser.g:3861:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3867:2: ( ( () otherlv_1= Bool ) )
            // InternalRosSystemParser.g:3868:2: ( () otherlv_1= Bool )
            {
            // InternalRosSystemParser.g:3868:2: ( () otherlv_1= Bool )
            // InternalRosSystemParser.g:3869:3: () otherlv_1= Bool
            {
            // InternalRosSystemParser.g:3869:3: ()
            // InternalRosSystemParser.g:3870:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBoolAccess().getBoolAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Bool,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBoolAccess().getBoolKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebool"


    // $ANTLR start "entryRuleint8"
    // InternalRosSystemParser.g:3884:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRosSystemParser.g:3884:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRosSystemParser.g:3885:2: iv_ruleint8= ruleint8 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt8Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint8=ruleint8();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint8; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint8"


    // $ANTLR start "ruleint8"
    // InternalRosSystemParser.g:3891:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3897:2: ( ( () otherlv_1= Int8 ) )
            // InternalRosSystemParser.g:3898:2: ( () otherlv_1= Int8 )
            {
            // InternalRosSystemParser.g:3898:2: ( () otherlv_1= Int8 )
            // InternalRosSystemParser.g:3899:3: () otherlv_1= Int8
            {
            // InternalRosSystemParser.g:3899:3: ()
            // InternalRosSystemParser.g:3900:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt8Access().getInt8Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int8,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt8Access().getInt8Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint8"


    // $ANTLR start "entryRuleuint8"
    // InternalRosSystemParser.g:3914:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRosSystemParser.g:3914:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRosSystemParser.g:3915:2: iv_ruleuint8= ruleuint8 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint8Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint8=ruleuint8();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint8; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint8"


    // $ANTLR start "ruleuint8"
    // InternalRosSystemParser.g:3921:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3927:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRosSystemParser.g:3928:2: ( () otherlv_1= Uint8 )
            {
            // InternalRosSystemParser.g:3928:2: ( () otherlv_1= Uint8 )
            // InternalRosSystemParser.g:3929:3: () otherlv_1= Uint8
            {
            // InternalRosSystemParser.g:3929:3: ()
            // InternalRosSystemParser.g:3930:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint8Access().getUint8Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint8,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint8Access().getUint8Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint8"


    // $ANTLR start "entryRuleint16"
    // InternalRosSystemParser.g:3944:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRosSystemParser.g:3944:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRosSystemParser.g:3945:2: iv_ruleint16= ruleint16 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt16Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint16=ruleint16();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint16; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint16"


    // $ANTLR start "ruleint16"
    // InternalRosSystemParser.g:3951:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3957:2: ( ( () otherlv_1= Int16 ) )
            // InternalRosSystemParser.g:3958:2: ( () otherlv_1= Int16 )
            {
            // InternalRosSystemParser.g:3958:2: ( () otherlv_1= Int16 )
            // InternalRosSystemParser.g:3959:3: () otherlv_1= Int16
            {
            // InternalRosSystemParser.g:3959:3: ()
            // InternalRosSystemParser.g:3960:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt16Access().getInt16Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt16Access().getInt16Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint16"


    // $ANTLR start "entryRuleuint16"
    // InternalRosSystemParser.g:3974:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRosSystemParser.g:3974:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRosSystemParser.g:3975:2: iv_ruleuint16= ruleuint16 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint16Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint16=ruleuint16();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint16; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint16"


    // $ANTLR start "ruleuint16"
    // InternalRosSystemParser.g:3981:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3987:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRosSystemParser.g:3988:2: ( () otherlv_1= Uint16 )
            {
            // InternalRosSystemParser.g:3988:2: ( () otherlv_1= Uint16 )
            // InternalRosSystemParser.g:3989:3: () otherlv_1= Uint16
            {
            // InternalRosSystemParser.g:3989:3: ()
            // InternalRosSystemParser.g:3990:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint16Access().getUint16Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint16,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint16Access().getUint16Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint16"


    // $ANTLR start "entryRuleint32"
    // InternalRosSystemParser.g:4004:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRosSystemParser.g:4004:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRosSystemParser.g:4005:2: iv_ruleint32= ruleint32 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt32Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint32=ruleint32();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint32; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint32"


    // $ANTLR start "ruleint32"
    // InternalRosSystemParser.g:4011:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4017:2: ( ( () otherlv_1= Int32 ) )
            // InternalRosSystemParser.g:4018:2: ( () otherlv_1= Int32 )
            {
            // InternalRosSystemParser.g:4018:2: ( () otherlv_1= Int32 )
            // InternalRosSystemParser.g:4019:3: () otherlv_1= Int32
            {
            // InternalRosSystemParser.g:4019:3: ()
            // InternalRosSystemParser.g:4020:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt32Access().getInt32Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt32Access().getInt32Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint32"


    // $ANTLR start "entryRuleuint32"
    // InternalRosSystemParser.g:4034:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRosSystemParser.g:4034:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRosSystemParser.g:4035:2: iv_ruleuint32= ruleuint32 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint32Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint32=ruleuint32();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint32; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint32"


    // $ANTLR start "ruleuint32"
    // InternalRosSystemParser.g:4041:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4047:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRosSystemParser.g:4048:2: ( () otherlv_1= Uint32 )
            {
            // InternalRosSystemParser.g:4048:2: ( () otherlv_1= Uint32 )
            // InternalRosSystemParser.g:4049:3: () otherlv_1= Uint32
            {
            // InternalRosSystemParser.g:4049:3: ()
            // InternalRosSystemParser.g:4050:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint32Access().getUint32Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint32Access().getUint32Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint32"


    // $ANTLR start "entryRuleint64"
    // InternalRosSystemParser.g:4064:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRosSystemParser.g:4064:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRosSystemParser.g:4065:2: iv_ruleint64= ruleint64 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt64Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint64=ruleint64();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint64; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint64"


    // $ANTLR start "ruleint64"
    // InternalRosSystemParser.g:4071:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4077:2: ( ( () otherlv_1= Int64 ) )
            // InternalRosSystemParser.g:4078:2: ( () otherlv_1= Int64 )
            {
            // InternalRosSystemParser.g:4078:2: ( () otherlv_1= Int64 )
            // InternalRosSystemParser.g:4079:3: () otherlv_1= Int64
            {
            // InternalRosSystemParser.g:4079:3: ()
            // InternalRosSystemParser.g:4080:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt64Access().getInt64Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int64,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt64Access().getInt64Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint64"


    // $ANTLR start "entryRuleuint64"
    // InternalRosSystemParser.g:4094:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRosSystemParser.g:4094:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRosSystemParser.g:4095:2: iv_ruleuint64= ruleuint64 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint64Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint64=ruleuint64();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint64; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint64"


    // $ANTLR start "ruleuint64"
    // InternalRosSystemParser.g:4101:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4107:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRosSystemParser.g:4108:2: ( () otherlv_1= Uint64 )
            {
            // InternalRosSystemParser.g:4108:2: ( () otherlv_1= Uint64 )
            // InternalRosSystemParser.g:4109:3: () otherlv_1= Uint64
            {
            // InternalRosSystemParser.g:4109:3: ()
            // InternalRosSystemParser.g:4110:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint64Access().getUint64Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint64,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint64Access().getUint64Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint64"


    // $ANTLR start "entryRulefloat32"
    // InternalRosSystemParser.g:4124:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRosSystemParser.g:4124:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRosSystemParser.g:4125:2: iv_rulefloat32= rulefloat32 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloat32Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulefloat32=rulefloat32();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulefloat32; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat32"


    // $ANTLR start "rulefloat32"
    // InternalRosSystemParser.g:4131:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4137:2: ( ( () otherlv_1= Float32 ) )
            // InternalRosSystemParser.g:4138:2: ( () otherlv_1= Float32 )
            {
            // InternalRosSystemParser.g:4138:2: ( () otherlv_1= Float32 )
            // InternalRosSystemParser.g:4139:3: () otherlv_1= Float32
            {
            // InternalRosSystemParser.g:4139:3: ()
            // InternalRosSystemParser.g:4140:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloat32Access().getFloat32Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFloat32Access().getFloat32Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat32"


    // $ANTLR start "entryRulefloat64"
    // InternalRosSystemParser.g:4154:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRosSystemParser.g:4154:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRosSystemParser.g:4155:2: iv_rulefloat64= rulefloat64 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloat64Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulefloat64=rulefloat64();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulefloat64; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat64"


    // $ANTLR start "rulefloat64"
    // InternalRosSystemParser.g:4161:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4167:2: ( ( () otherlv_1= Float64 ) )
            // InternalRosSystemParser.g:4168:2: ( () otherlv_1= Float64 )
            {
            // InternalRosSystemParser.g:4168:2: ( () otherlv_1= Float64 )
            // InternalRosSystemParser.g:4169:3: () otherlv_1= Float64
            {
            // InternalRosSystemParser.g:4169:3: ()
            // InternalRosSystemParser.g:4170:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloat64Access().getFloat64Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float64,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFloat64Access().getFloat64Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat64"


    // $ANTLR start "entryRulestring0"
    // InternalRosSystemParser.g:4184:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRosSystemParser.g:4184:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRosSystemParser.g:4185:2: iv_rulestring0= rulestring0 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getString0Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulestring0=rulestring0();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulestring0; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestring0"


    // $ANTLR start "rulestring0"
    // InternalRosSystemParser.g:4191:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4197:2: ( ( () otherlv_1= String_1 ) )
            // InternalRosSystemParser.g:4198:2: ( () otherlv_1= String_1 )
            {
            // InternalRosSystemParser.g:4198:2: ( () otherlv_1= String_1 )
            // InternalRosSystemParser.g:4199:3: () otherlv_1= String_1
            {
            // InternalRosSystemParser.g:4199:3: ()
            // InternalRosSystemParser.g:4200:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getString0Access().getStringAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,String_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getString0Access().getStringKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestring0"


    // $ANTLR start "entryRulechar"
    // InternalRosSystemParser.g:4214:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRosSystemParser.g:4214:45: (iv_rulechar= rulechar EOF )
            // InternalRosSystemParser.g:4215:2: iv_rulechar= rulechar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCharRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulechar=rulechar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulechar; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechar"


    // $ANTLR start "rulechar"
    // InternalRosSystemParser.g:4221:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4227:2: ( ( () otherlv_1= Char ) )
            // InternalRosSystemParser.g:4228:2: ( () otherlv_1= Char )
            {
            // InternalRosSystemParser.g:4228:2: ( () otherlv_1= Char )
            // InternalRosSystemParser.g:4229:3: () otherlv_1= Char
            {
            // InternalRosSystemParser.g:4229:3: ()
            // InternalRosSystemParser.g:4230:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCharAccess().getChar0Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Char,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCharAccess().getCharKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechar"


    // $ANTLR start "entryRulebyte"
    // InternalRosSystemParser.g:4244:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRosSystemParser.g:4244:45: (iv_rulebyte= rulebyte EOF )
            // InternalRosSystemParser.g:4245:2: iv_rulebyte= rulebyte EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getByteRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulebyte=rulebyte();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulebyte; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebyte"


    // $ANTLR start "rulebyte"
    // InternalRosSystemParser.g:4251:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4257:2: ( ( () otherlv_1= Byte ) )
            // InternalRosSystemParser.g:4258:2: ( () otherlv_1= Byte )
            {
            // InternalRosSystemParser.g:4258:2: ( () otherlv_1= Byte )
            // InternalRosSystemParser.g:4259:3: () otherlv_1= Byte
            {
            // InternalRosSystemParser.g:4259:3: ()
            // InternalRosSystemParser.g:4260:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getByteAccess().getByteAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Byte,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getByteAccess().getByteKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebyte"


    // $ANTLR start "entryRuletime"
    // InternalRosSystemParser.g:4274:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRosSystemParser.g:4274:45: (iv_ruletime= ruletime EOF )
            // InternalRosSystemParser.g:4275:2: iv_ruletime= ruletime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruletime=ruletime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruletime; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletime"


    // $ANTLR start "ruletime"
    // InternalRosSystemParser.g:4281:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4287:2: ( ( () otherlv_1= Time ) )
            // InternalRosSystemParser.g:4288:2: ( () otherlv_1= Time )
            {
            // InternalRosSystemParser.g:4288:2: ( () otherlv_1= Time )
            // InternalRosSystemParser.g:4289:3: () otherlv_1= Time
            {
            // InternalRosSystemParser.g:4289:3: ()
            // InternalRosSystemParser.g:4290:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTimeAccess().getTimeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Time,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTimeKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletime"


    // $ANTLR start "entryRuleduration"
    // InternalRosSystemParser.g:4304:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRosSystemParser.g:4304:49: (iv_ruleduration= ruleduration EOF )
            // InternalRosSystemParser.g:4305:2: iv_ruleduration= ruleduration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDurationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleduration=ruleduration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleduration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleduration"


    // $ANTLR start "ruleduration"
    // InternalRosSystemParser.g:4311:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4317:2: ( ( () otherlv_1= Duration ) )
            // InternalRosSystemParser.g:4318:2: ( () otherlv_1= Duration )
            {
            // InternalRosSystemParser.g:4318:2: ( () otherlv_1= Duration )
            // InternalRosSystemParser.g:4319:3: () otherlv_1= Duration
            {
            // InternalRosSystemParser.g:4319:3: ()
            // InternalRosSystemParser.g:4320:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDurationAccess().getDurationAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Duration,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDurationAccess().getDurationKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleduration"


    // $ANTLR start "entryRuleboolArray"
    // InternalRosSystemParser.g:4334:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRosSystemParser.g:4334:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRosSystemParser.g:4335:2: iv_ruleboolArray= ruleboolArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleboolArray=ruleboolArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleboolArray; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleboolArray"


    // $ANTLR start "ruleboolArray"
    // InternalRosSystemParser.g:4341:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4347:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRosSystemParser.g:4348:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRosSystemParser.g:4348:2: ( () otherlv_1= Bool_1 )
            // InternalRosSystemParser.g:4349:3: () otherlv_1= Bool_1
            {
            // InternalRosSystemParser.g:4349:3: ()
            // InternalRosSystemParser.g:4350:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBoolArrayAccess().getBoolArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Bool_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBoolArrayAccess().getBoolKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleboolArray"


    // $ANTLR start "entryRuleint8Array"
    // InternalRosSystemParser.g:4364:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRosSystemParser.g:4364:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRosSystemParser.g:4365:2: iv_ruleint8Array= ruleint8Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt8ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint8Array=ruleint8Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint8Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint8Array"


    // $ANTLR start "ruleint8Array"
    // InternalRosSystemParser.g:4371:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4377:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRosSystemParser.g:4378:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRosSystemParser.g:4378:2: ( () otherlv_1= Int8_1 )
            // InternalRosSystemParser.g:4379:3: () otherlv_1= Int8_1
            {
            // InternalRosSystemParser.g:4379:3: ()
            // InternalRosSystemParser.g:4380:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int8_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt8ArrayAccess().getInt8Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint8Array"


    // $ANTLR start "entryRuleuint8Array"
    // InternalRosSystemParser.g:4394:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRosSystemParser.g:4394:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRosSystemParser.g:4395:2: iv_ruleuint8Array= ruleuint8Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint8ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint8Array=ruleuint8Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint8Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint8Array"


    // $ANTLR start "ruleuint8Array"
    // InternalRosSystemParser.g:4401:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4407:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRosSystemParser.g:4408:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRosSystemParser.g:4408:2: ( () otherlv_1= Uint8_1 )
            // InternalRosSystemParser.g:4409:3: () otherlv_1= Uint8_1
            {
            // InternalRosSystemParser.g:4409:3: ()
            // InternalRosSystemParser.g:4410:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint8_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint8ArrayAccess().getUint8Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint8Array"


    // $ANTLR start "entryRuleint16Array"
    // InternalRosSystemParser.g:4424:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRosSystemParser.g:4424:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRosSystemParser.g:4425:2: iv_ruleint16Array= ruleint16Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt16ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint16Array=ruleint16Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint16Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint16Array"


    // $ANTLR start "ruleint16Array"
    // InternalRosSystemParser.g:4431:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4437:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRosSystemParser.g:4438:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRosSystemParser.g:4438:2: ( () otherlv_1= Int16_1 )
            // InternalRosSystemParser.g:4439:3: () otherlv_1= Int16_1
            {
            // InternalRosSystemParser.g:4439:3: ()
            // InternalRosSystemParser.g:4440:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int16_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt16ArrayAccess().getInt16Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint16Array"


    // $ANTLR start "entryRuleuint16Array"
    // InternalRosSystemParser.g:4454:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRosSystemParser.g:4454:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRosSystemParser.g:4455:2: iv_ruleuint16Array= ruleuint16Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint16ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint16Array=ruleuint16Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint16Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint16Array"


    // $ANTLR start "ruleuint16Array"
    // InternalRosSystemParser.g:4461:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4467:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRosSystemParser.g:4468:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRosSystemParser.g:4468:2: ( () otherlv_1= Uint16_1 )
            // InternalRosSystemParser.g:4469:3: () otherlv_1= Uint16_1
            {
            // InternalRosSystemParser.g:4469:3: ()
            // InternalRosSystemParser.g:4470:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint16_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint16ArrayAccess().getUint16Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint16Array"


    // $ANTLR start "entryRuleint32Array"
    // InternalRosSystemParser.g:4484:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRosSystemParser.g:4484:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRosSystemParser.g:4485:2: iv_ruleint32Array= ruleint32Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt32ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint32Array=ruleint32Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint32Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint32Array"


    // $ANTLR start "ruleint32Array"
    // InternalRosSystemParser.g:4491:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4497:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRosSystemParser.g:4498:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRosSystemParser.g:4498:2: ( () otherlv_1= Int32_1 )
            // InternalRosSystemParser.g:4499:3: () otherlv_1= Int32_1
            {
            // InternalRosSystemParser.g:4499:3: ()
            // InternalRosSystemParser.g:4500:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int32_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt32ArrayAccess().getInt32Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint32Array"


    // $ANTLR start "entryRuleuint32Array"
    // InternalRosSystemParser.g:4514:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRosSystemParser.g:4514:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRosSystemParser.g:4515:2: iv_ruleuint32Array= ruleuint32Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint32ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint32Array=ruleuint32Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint32Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint32Array"


    // $ANTLR start "ruleuint32Array"
    // InternalRosSystemParser.g:4521:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4527:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRosSystemParser.g:4528:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRosSystemParser.g:4528:2: ( () otherlv_1= Uint32_1 )
            // InternalRosSystemParser.g:4529:3: () otherlv_1= Uint32_1
            {
            // InternalRosSystemParser.g:4529:3: ()
            // InternalRosSystemParser.g:4530:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint32_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint32ArrayAccess().getUint32Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint32Array"


    // $ANTLR start "entryRuleint64Array"
    // InternalRosSystemParser.g:4544:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRosSystemParser.g:4544:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRosSystemParser.g:4545:2: iv_ruleint64Array= ruleint64Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInt64ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleint64Array=ruleint64Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleint64Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleint64Array"


    // $ANTLR start "ruleint64Array"
    // InternalRosSystemParser.g:4551:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4557:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRosSystemParser.g:4558:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRosSystemParser.g:4558:2: ( () otherlv_1= Int64_1 )
            // InternalRosSystemParser.g:4559:3: () otherlv_1= Int64_1
            {
            // InternalRosSystemParser.g:4559:3: ()
            // InternalRosSystemParser.g:4560:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int64_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInt64ArrayAccess().getInt64Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleint64Array"


    // $ANTLR start "entryRuleuint64Array"
    // InternalRosSystemParser.g:4574:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRosSystemParser.g:4574:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRosSystemParser.g:4575:2: iv_ruleuint64Array= ruleuint64Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUint64ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleuint64Array=ruleuint64Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleuint64Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleuint64Array"


    // $ANTLR start "ruleuint64Array"
    // InternalRosSystemParser.g:4581:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4587:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRosSystemParser.g:4588:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRosSystemParser.g:4588:2: ( () otherlv_1= Uint64_1 )
            // InternalRosSystemParser.g:4589:3: () otherlv_1= Uint64_1
            {
            // InternalRosSystemParser.g:4589:3: ()
            // InternalRosSystemParser.g:4590:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint64_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUint64ArrayAccess().getUint64Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleuint64Array"


    // $ANTLR start "entryRulefloat32Array"
    // InternalRosSystemParser.g:4604:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRosSystemParser.g:4604:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRosSystemParser.g:4605:2: iv_rulefloat32Array= rulefloat32Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloat32ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulefloat32Array=rulefloat32Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulefloat32Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat32Array"


    // $ANTLR start "rulefloat32Array"
    // InternalRosSystemParser.g:4611:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4617:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRosSystemParser.g:4618:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRosSystemParser.g:4618:2: ( () otherlv_1= Float32_1 )
            // InternalRosSystemParser.g:4619:3: () otherlv_1= Float32_1
            {
            // InternalRosSystemParser.g:4619:3: ()
            // InternalRosSystemParser.g:4620:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float32_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat32Array"


    // $ANTLR start "entryRulefloat64Array"
    // InternalRosSystemParser.g:4634:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRosSystemParser.g:4634:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRosSystemParser.g:4635:2: iv_rulefloat64Array= rulefloat64Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloat64ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulefloat64Array=rulefloat64Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulefloat64Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulefloat64Array"


    // $ANTLR start "rulefloat64Array"
    // InternalRosSystemParser.g:4641:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4647:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRosSystemParser.g:4648:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRosSystemParser.g:4648:2: ( () otherlv_1= Float64_1 )
            // InternalRosSystemParser.g:4649:3: () otherlv_1= Float64_1
            {
            // InternalRosSystemParser.g:4649:3: ()
            // InternalRosSystemParser.g:4650:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float64_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulefloat64Array"


    // $ANTLR start "entryRulestring0Array"
    // InternalRosSystemParser.g:4664:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRosSystemParser.g:4664:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRosSystemParser.g:4665:2: iv_rulestring0Array= rulestring0Array EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getString0ArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulestring0Array=rulestring0Array();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulestring0Array; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulestring0Array"


    // $ANTLR start "rulestring0Array"
    // InternalRosSystemParser.g:4671:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4677:2: ( ( () otherlv_1= String_2 ) )
            // InternalRosSystemParser.g:4678:2: ( () otherlv_1= String_2 )
            {
            // InternalRosSystemParser.g:4678:2: ( () otherlv_1= String_2 )
            // InternalRosSystemParser.g:4679:3: () otherlv_1= String_2
            {
            // InternalRosSystemParser.g:4679:3: ()
            // InternalRosSystemParser.g:4680:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getString0ArrayAccess().getStringArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,String_2,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getString0ArrayAccess().getStringKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulestring0Array"


    // $ANTLR start "entryRulebyteArray"
    // InternalRosSystemParser.g:4694:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRosSystemParser.g:4694:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRosSystemParser.g:4695:2: iv_rulebyteArray= rulebyteArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getByteArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulebyteArray=rulebyteArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulebyteArray; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulebyteArray"


    // $ANTLR start "rulebyteArray"
    // InternalRosSystemParser.g:4701:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4707:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRosSystemParser.g:4708:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRosSystemParser.g:4708:2: ( () otherlv_1= Byte_1 )
            // InternalRosSystemParser.g:4709:3: () otherlv_1= Byte_1
            {
            // InternalRosSystemParser.g:4709:3: ()
            // InternalRosSystemParser.g:4710:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getByteArrayAccess().getByteArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Byte_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getByteArrayAccess().getByteKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulebyteArray"


    // $ANTLR start "entryRulecharArray"
    // InternalRosSystemParser.g:4724:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRosSystemParser.g:4724:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRosSystemParser.g:4725:2: iv_rulecharArray= rulecharArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCharArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulecharArray=rulecharArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulecharArray; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecharArray"


    // $ANTLR start "rulecharArray"
    // InternalRosSystemParser.g:4731:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4737:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRosSystemParser.g:4738:2: ( () otherlv_1= Char_1 )
            {
            // InternalRosSystemParser.g:4738:2: ( () otherlv_1= Char_1 )
            // InternalRosSystemParser.g:4739:3: () otherlv_1= Char_1
            {
            // InternalRosSystemParser.g:4739:3: ()
            // InternalRosSystemParser.g:4740:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCharArrayAccess().getCharArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Char_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCharArrayAccess().getCharKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecharArray"


    // $ANTLR start "entryRuleHeader"
    // InternalRosSystemParser.g:4754:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRosSystemParser.g:4754:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRosSystemParser.g:4755:2: iv_ruleHeader= ruleHeader EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHeaderRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHeader=ruleHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHeader; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHeader"


    // $ANTLR start "ruleHeader"
    // InternalRosSystemParser.g:4761:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4767:2: ( ( () otherlv_1= Header ) )
            // InternalRosSystemParser.g:4768:2: ( () otherlv_1= Header )
            {
            // InternalRosSystemParser.g:4768:2: ( () otherlv_1= Header )
            // InternalRosSystemParser.g:4769:3: () otherlv_1= Header
            {
            // InternalRosSystemParser.g:4769:3: ()
            // InternalRosSystemParser.g:4770:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHeaderAccess().getHeaderAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Header,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getHeaderAccess().getHeaderKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHeader"


    // $ANTLR start "entryRuleSpecBaseRef"
    // InternalRosSystemParser.g:4784:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRosSystemParser.g:4784:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRosSystemParser.g:4785:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSpecBaseRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSpecBaseRef=ruleSpecBaseRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSpecBaseRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecBaseRef"


    // $ANTLR start "ruleSpecBaseRef"
    // InternalRosSystemParser.g:4791:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4797:2: ( ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:4798:2: ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:4798:2: ( ( ruleEString ) )
            // InternalRosSystemParser.g:4799:3: ( ruleEString )
            {
            // InternalRosSystemParser.g:4799:3: ( ruleEString )
            // InternalRosSystemParser.g:4800:4: ruleEString
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getSpecBaseRefRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecBaseRef"


    // $ANTLR start "entryRuleArraySpecRef"
    // InternalRosSystemParser.g:4817:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRosSystemParser.g:4817:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRosSystemParser.g:4818:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArraySpecRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArraySpecRef=ruleArraySpecRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArraySpecRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArraySpecRef"


    // $ANTLR start "ruleArraySpecRef"
    // InternalRosSystemParser.g:4824:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4830:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRosSystemParser.g:4831:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRosSystemParser.g:4831:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRosSystemParser.g:4832:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRosSystemParser.g:4832:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:4833:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:4833:4: ( ruleEString )
            // InternalRosSystemParser.g:4834:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getArraySpecRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_40);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArraySpecRefAccess().getLeftSquareBracketRightSquareBracketKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArraySpecRef"


    // $ANTLR start "entryRuleKEYWORD"
    // InternalRosSystemParser.g:4856:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRosSystemParser.g:4856:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRosSystemParser.g:4857:2: iv_ruleKEYWORD= ruleKEYWORD EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKEYWORDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKEYWORD=ruleKEYWORD();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKEYWORD.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKEYWORD"


    // $ANTLR start "ruleKEYWORD"
    // InternalRosSystemParser.g:4863:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4869:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRosSystemParser.g:4870:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRosSystemParser.g:4870:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt49=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt49=1;
                }
                break;
            case Message:
                {
                alt49=2;
                }
                break;
            case Result:
                {
                alt49=3;
                }
                break;
            case Feedback:
                {
                alt49=4;
                }
                break;
            case Name:
                {
                alt49=5;
                }
                break;
            case Value:
                {
                alt49=6;
                }
                break;
            case Service:
                {
                alt49=7;
                }
                break;
            case Type:
                {
                alt49=8;
                }
                break;
            case Action:
                {
                alt49=9;
                }
                break;
            case Duration:
                {
                alt49=10;
                }
                break;
            case Time:
                {
                alt49=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalRosSystemParser.g:4871:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:4877:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:4883:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:4889:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:4895:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:4901:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:4907:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:4913:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:4919:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:4925:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:4931:3: kw= Time
                    {
                    kw=(Token)match(input,Time,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTimeKeyword_10());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKEYWORD"


    // $ANTLR start "entryRuleEString"
    // InternalRosSystemParser.g:4940:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRosSystemParser.g:4940:47: (iv_ruleEString= ruleEString EOF )
            // InternalRosSystemParser.g:4941:2: iv_ruleEString= ruleEString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEString.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalRosSystemParser.g:4947:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4953:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRosSystemParser.g:4954:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRosSystemParser.g:4954:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_STRING) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_ID) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalRosSystemParser.g:4955:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:4963:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleExtensionBlock"
    // InternalRosSystemParser.g:4974:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRosSystemParser.g:4974:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRosSystemParser.g:4975:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionBlock=ruleExtensionBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionBlock"


    // $ANTLR start "ruleExtensionBlock"
    // InternalRosSystemParser.g:4981:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
    public final EObject ruleExtensionBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_entries_5_0 = null;

        EObject lv_entries_8_0 = null;

        EObject lv_entries_10_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:4987:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRosSystemParser.g:4988:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRosSystemParser.g:4988:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRosSystemParser.g:4989:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRosSystemParser.g:4989:3: ()
            // InternalRosSystemParser.g:4990:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
              		
            }
            // InternalRosSystemParser.g:5000:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRosSystemParser.g:5001:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRosSystemParser.g:5001:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRosSystemParser.g:5002:5: lv_name_2_0= ruleExtensionBlockName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtensionBlockAccess().getNameExtensionBlockNameParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleExtensionBlockName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtensionBlockRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.fraunhofer.ipa.ros.Basics.ExtensionBlockName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,Colon,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
              		
            }
            // InternalRosSystemParser.g:5023:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt55=3;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_BEGIN) ) {
                alt55=1;
            }
            else if ( (LA55_0==LeftCurlyBracket) ) {
                alt55=2;
            }
            switch (alt55) {
                case 1 :
                    // InternalRosSystemParser.g:5024:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRosSystemParser.g:5024:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRosSystemParser.g:5025:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                      				
                    }
                    // InternalRosSystemParser.g:5029:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt51=0;
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( ((LA51_0>=Connections && LA51_0<=Processes)||(LA51_0>=FromFile && LA51_0<=Plugins)||LA51_0==Threads||(LA51_0>=Boolean && LA51_0<=Float64)||LA51_0==Message||LA51_0==Service||(LA51_0>=Base64 && LA51_0<=Action)||(LA51_0>=Nodes && LA51_0<=Int64)||(LA51_0>=Type_1 && LA51_0<=List)||(LA51_0>=Bool && LA51_0<=Node)||(LA51_0>=Time && LA51_0<=Ns)||(LA51_0>=RULE_ID && LA51_0<=RULE_STRING)) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:5030:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosSystemParser.g:5030:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRosSystemParser.g:5031:7: lv_entries_5_0= ruleExtensionEntry
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_44);
                    	    lv_entries_5_0=ruleExtensionEntry();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getExtensionBlockRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"entries",
                    	      								lv_entries_5_0,
                    	      								"de.fraunhofer.ipa.ros.Basics.ExtensionEntry");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt51 >= 1 ) break loop51;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5054:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRosSystemParser.g:5054:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRosSystemParser.g:5055:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                      				
                    }
                    // InternalRosSystemParser.g:5059:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( ((LA54_0>=Connections && LA54_0<=Processes)||(LA54_0>=FromFile && LA54_0<=Plugins)||LA54_0==Threads||(LA54_0>=Boolean && LA54_0<=Float64)||LA54_0==Message||LA54_0==Service||(LA54_0>=Base64 && LA54_0<=Action)||(LA54_0>=Nodes && LA54_0<=Int64)||(LA54_0>=Type_1 && LA54_0<=List)||(LA54_0>=Bool && LA54_0<=Node)||(LA54_0>=Time && LA54_0<=Ns)||(LA54_0>=RULE_ID && LA54_0<=RULE_STRING)) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // InternalRosSystemParser.g:5060:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRosSystemParser.g:5060:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRosSystemParser.g:5061:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRosSystemParser.g:5061:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRosSystemParser.g:5062:8: lv_entries_8_0= ruleExtensionEntry
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_46);
                            lv_entries_8_0=ruleExtensionEntry();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getExtensionBlockRule());
                              								}
                              								add(
                              									current,
                              									"entries",
                              									lv_entries_8_0,
                              									"de.fraunhofer.ipa.ros.Basics.ExtensionEntry");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalRosSystemParser.g:5079:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( ((LA53_0>=Connections && LA53_0<=Processes)||(LA53_0>=FromFile && LA53_0<=Plugins)||LA53_0==Threads||(LA53_0>=Boolean && LA53_0<=Float64)||LA53_0==Message||LA53_0==Service||(LA53_0>=Base64 && LA53_0<=Action)||(LA53_0>=Nodes && LA53_0<=Int64)||(LA53_0>=Type_1 && LA53_0<=List)||(LA53_0>=Bool && LA53_0<=Node)||(LA53_0>=Time && LA53_0<=Ns)||LA53_0==Comma||(LA53_0>=RULE_ID && LA53_0<=RULE_STRING)) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // InternalRosSystemParser.g:5080:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRosSystemParser.g:5080:7: (otherlv_9= Comma )?
                            	    int alt52=2;
                            	    int LA52_0 = input.LA(1);

                            	    if ( (LA52_0==Comma) ) {
                            	        alt52=1;
                            	    }
                            	    switch (alt52) {
                            	        case 1 :
                            	            // InternalRosSystemParser.g:5081:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_43); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	              							
                            	            }

                            	            }
                            	            break;

                            	    }

                            	    // InternalRosSystemParser.g:5086:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRosSystemParser.g:5087:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRosSystemParser.g:5087:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRosSystemParser.g:5088:9: lv_entries_10_0= ruleExtensionEntry
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_46);
                            	    lv_entries_10_0=ruleExtensionEntry();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getExtensionBlockRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"entries",
                            	      										lv_entries_10_0,
                            	      										"de.fraunhofer.ipa.ros.Basics.ExtensionEntry");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop53;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_11, grammarAccess.getExtensionBlockAccess().getRightCurlyBracketKeyword_4_1_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionBlock"


    // $ANTLR start "entryRuleExtensionBlockName"
    // InternalRosSystemParser.g:5117:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRosSystemParser.g:5117:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRosSystemParser.g:5118:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionBlockNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionBlockName=ruleExtensionBlockName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionBlockName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionBlockName"


    // $ANTLR start "ruleExtensionBlockName"
    // InternalRosSystemParser.g:5124:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5130:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRosSystemParser.g:5131:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRosSystemParser.g:5131:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRosSystemParser.g:5132:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalRosSystemParser.g:5139:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==FullStop) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalRosSystemParser.g:5140:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_41); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_47); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionBlockName"


    // $ANTLR start "entryRuleExtensionEntry"
    // InternalRosSystemParser.g:5157:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRosSystemParser.g:5157:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRosSystemParser.g:5158:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionEntryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionEntry=ruleExtensionEntry();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionEntry; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionEntry"


    // $ANTLR start "ruleExtensionEntry"
    // InternalRosSystemParser.g:5164:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5170:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) )
            // InternalRosSystemParser.g:5171:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            {
            // InternalRosSystemParser.g:5171:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            // InternalRosSystemParser.g:5172:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) )
            {
            // InternalRosSystemParser.g:5172:3: ()
            // InternalRosSystemParser.g:5173:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:5179:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=Duration && LA57_0<=Feedback)||(LA57_0>=Boolean && LA57_0<=Float64)||LA57_0==Message||LA57_0==Service||(LA57_0>=Base64 && LA57_0<=Action)||(LA57_0>=Result && LA57_0<=Uint64)||LA57_0==Array||(LA57_0>=Int16 && LA57_0<=Int64)||(LA57_0>=Uint8 && LA57_0<=List)||(LA57_0>=Bool && LA57_0<=Node)||(LA57_0>=Time && LA57_0<=Any)||(LA57_0>=RULE_ID && LA57_0<=RULE_STRING)) ) {
                alt57=1;
            }
            else if ( ((LA57_0>=Connections && LA57_0<=Processes)||(LA57_0>=FromFile && LA57_0<=Default)||LA57_0==Plugins||LA57_0==Threads||LA57_0==Nodes||LA57_0==Value_1||LA57_0==From||LA57_0==Type_1||LA57_0==Ns) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalRosSystemParser.g:5180:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:5180:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:5181:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:5181:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRosSystemParser.g:5182:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRosSystemParser.g:5182:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRosSystemParser.g:5183:7: lv_key_1_0= ruleExtensionKey
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionKeyParserRuleCall_1_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_3);
                    lv_key_1_0=ruleExtensionKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
                      							}
                      							set(
                      								current,
                      								"key",
                      								lv_key_1_0,
                      								"de.fraunhofer.ipa.ros.Basics.ExtensionKey");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5206:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRosSystemParser.g:5206:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRosSystemParser.g:5207:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRosSystemParser.g:5207:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRosSystemParser.g:5208:6: lv_key_3_0= ruleExtensionColonKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_48);
                    lv_key_3_0=ruleExtensionColonKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_3_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.ExtensionColonKey");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:5226:3: ( (lv_value_4_0= ruleExtensionValue ) )
            // InternalRosSystemParser.g:5227:4: (lv_value_4_0= ruleExtensionValue )
            {
            // InternalRosSystemParser.g:5227:4: (lv_value_4_0= ruleExtensionValue )
            // InternalRosSystemParser.g:5228:5: lv_value_4_0= ruleExtensionValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtensionEntryAccess().getValueExtensionValueParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleExtensionValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_4_0,
              						"de.fraunhofer.ipa.ros.Basics.ExtensionValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionEntry"


    // $ANTLR start "entryRuleExtensionKey"
    // InternalRosSystemParser.g:5249:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRosSystemParser.g:5249:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRosSystemParser.g:5250:2: iv_ruleExtensionKey= ruleExtensionKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionKey=ruleExtensionKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionKey"


    // $ANTLR start "ruleExtensionKey"
    // InternalRosSystemParser.g:5256:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5262:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRosSystemParser.g:5263:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRosSystemParser.g:5263:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt58=29;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt58=1;
                }
                break;
            case RULE_STRING:
                {
                alt58=2;
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
                alt58=3;
                }
                break;
            case Node:
                {
                alt58=4;
                }
                break;
            case String:
                {
                alt58=5;
                }
                break;
            case Integer:
                {
                alt58=6;
                }
                break;
            case Double:
                {
                alt58=7;
                }
                break;
            case Boolean:
                {
                alt58=8;
                }
                break;
            case Base64:
                {
                alt58=9;
                }
                break;
            case Array:
                {
                alt58=10;
                }
                break;
            case List:
                {
                alt58=11;
                }
                break;
            case Struct:
                {
                alt58=12;
                }
                break;
            case Date:
                {
                alt58=13;
                }
                break;
            case Any:
                {
                alt58=14;
                }
                break;
            case Bool:
                {
                alt58=15;
                }
                break;
            case Int8:
                {
                alt58=16;
                }
                break;
            case Uint8:
                {
                alt58=17;
                }
                break;
            case Int16:
                {
                alt58=18;
                }
                break;
            case Uint16:
                {
                alt58=19;
                }
                break;
            case Int32:
                {
                alt58=20;
                }
                break;
            case Uint32:
                {
                alt58=21;
                }
                break;
            case Int64:
                {
                alt58=22;
                }
                break;
            case Uint64:
                {
                alt58=23;
                }
                break;
            case Float32:
                {
                alt58=24;
                }
                break;
            case Float64:
                {
                alt58=25;
                }
                break;
            case String_1:
                {
                alt58=26;
                }
                break;
            case Char:
                {
                alt58=27;
                }
                break;
            case Byte:
                {
                alt58=28;
                }
                break;
            case Header:
                {
                alt58=29;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalRosSystemParser.g:5264:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_0, grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5272:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_1, grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:5280:3: this_KEYWORD_2= ruleKEYWORD
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExtensionKeyAccess().getKEYWORDParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_KEYWORD_2=ruleKEYWORD();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_KEYWORD_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:5291:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:5297:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:5303:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:5309:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:5315:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:5321:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:5327:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:5333:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:5339:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:5345:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:5351:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalRosSystemParser.g:5357:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalRosSystemParser.g:5363:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalRosSystemParser.g:5369:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalRosSystemParser.g:5375:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalRosSystemParser.g:5381:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalRosSystemParser.g:5387:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalRosSystemParser.g:5393:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalRosSystemParser.g:5399:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalRosSystemParser.g:5405:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalRosSystemParser.g:5411:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalRosSystemParser.g:5417:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalRosSystemParser.g:5423:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalRosSystemParser.g:5429:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_26());
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalRosSystemParser.g:5435:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_27());
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalRosSystemParser.g:5441:3: kw= Header
                    {
                    kw=(Token)match(input,Header,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getHeaderKeyword_28());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionKey"


    // $ANTLR start "entryRuleExtensionValue"
    // InternalRosSystemParser.g:5450:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRosSystemParser.g:5450:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRosSystemParser.g:5451:2: iv_ruleExtensionValue= ruleExtensionValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionValue=ruleExtensionValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionValue"


    // $ANTLR start "ruleExtensionValue"
    // InternalRosSystemParser.g:5457:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5463:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRosSystemParser.g:5464:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRosSystemParser.g:5464:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt59=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt59=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt59=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt59=3;
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
                alt59=4;
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
                alt59=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalRosSystemParser.g:5465:3: this_ExtensionListValue_0= ruleExtensionListValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionListValueParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExtensionListValue_0=ruleExtensionListValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExtensionListValue_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5474:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionBraceMapValueParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExtensionBraceMapValue_1=ruleExtensionBraceMapValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExtensionBraceMapValue_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:5483:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionIndentedMapValueParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExtensionIndentedMapValue_2=ruleExtensionIndentedMapValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExtensionIndentedMapValue_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:5492:3: this_ExtensionRefValue_3= ruleExtensionRefValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionRefValueParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExtensionRefValue_3=ruleExtensionRefValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExtensionRefValue_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:5501:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionScalarValueParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExtensionScalarValue_4=ruleExtensionScalarValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExtensionScalarValue_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionValue"


    // $ANTLR start "entryRuleExtensionListValue"
    // InternalRosSystemParser.g:5513:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRosSystemParser.g:5513:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRosSystemParser.g:5514:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionListValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionListValue=ruleExtensionListValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionListValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionListValue"


    // $ANTLR start "ruleExtensionListValue"
    // InternalRosSystemParser.g:5520:1: ruleExtensionListValue returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleExtensionListValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_items_2_0 = null;

        EObject lv_items_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5526:2: ( ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:5527:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:5527:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:5528:3: () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket
            {
            // InternalRosSystemParser.g:5528:3: ()
            // InternalRosSystemParser.g:5529:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:5539:3: ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=Duration && LA62_0<=Feedback)||(LA62_0>=Boolean && LA62_0<=Float64)||(LA62_0>=Message && LA62_0<=Service)||(LA62_0>=Base64 && LA62_0<=Action)||(LA62_0>=Result && LA62_0<=Uint64)||LA62_0==Array||(LA62_0>=Int16 && LA62_0<=Sub)||(LA62_0>=Uint8 && LA62_0<=Any)||LA62_0==LeftSquareBracket||LA62_0==LeftCurlyBracket||(LA62_0>=RULE_BOOLEAN && LA62_0<=RULE_DOUBLE)||(LA62_0>=RULE_ID && LA62_0<=RULE_INT)||LA62_0==RULE_BEGIN) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRosSystemParser.g:5540:4: ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    {
                    // InternalRosSystemParser.g:5540:4: ( (lv_items_2_0= ruleExtensionValue ) )
                    // InternalRosSystemParser.g:5541:5: (lv_items_2_0= ruleExtensionValue )
                    {
                    // InternalRosSystemParser.g:5541:5: (lv_items_2_0= ruleExtensionValue )
                    // InternalRosSystemParser.g:5542:6: lv_items_2_0= ruleExtensionValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_50);
                    lv_items_2_0=ruleExtensionValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExtensionListValueRule());
                      						}
                      						add(
                      							current,
                      							"items",
                      							lv_items_2_0,
                      							"de.fraunhofer.ipa.ros.Basics.ExtensionValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:5559:4: ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( ((LA61_0>=Duration && LA61_0<=Feedback)||(LA61_0>=Boolean && LA61_0<=Float64)||(LA61_0>=Message && LA61_0<=Service)||(LA61_0>=Base64 && LA61_0<=Action)||(LA61_0>=Result && LA61_0<=Uint64)||LA61_0==Array||(LA61_0>=Int16 && LA61_0<=Sub)||(LA61_0>=Uint8 && LA61_0<=Any)||LA61_0==Comma||LA61_0==LeftSquareBracket||LA61_0==LeftCurlyBracket||(LA61_0>=RULE_BOOLEAN && LA61_0<=RULE_DOUBLE)||(LA61_0>=RULE_ID && LA61_0<=RULE_INT)||LA61_0==RULE_BEGIN) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:5560:5: (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) )
                    	    {
                    	    // InternalRosSystemParser.g:5560:5: (otherlv_3= Comma )?
                    	    int alt60=2;
                    	    int LA60_0 = input.LA(1);

                    	    if ( (LA60_0==Comma) ) {
                    	        alt60=1;
                    	    }
                    	    switch (alt60) {
                    	        case 1 :
                    	            // InternalRosSystemParser.g:5561:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_48); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_3, grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosSystemParser.g:5566:5: ( (lv_items_4_0= ruleExtensionValue ) )
                    	    // InternalRosSystemParser.g:5567:6: (lv_items_4_0= ruleExtensionValue )
                    	    {
                    	    // InternalRosSystemParser.g:5567:6: (lv_items_4_0= ruleExtensionValue )
                    	    // InternalRosSystemParser.g:5568:7: lv_items_4_0= ruleExtensionValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_50);
                    	    lv_items_4_0=ruleExtensionValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getExtensionListValueRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"items",
                    	      								lv_items_4_0,
                    	      								"de.fraunhofer.ipa.ros.Basics.ExtensionValue");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionListValue"


    // $ANTLR start "entryRuleExtensionBraceMapValue"
    // InternalRosSystemParser.g:5595:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRosSystemParser.g:5595:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRosSystemParser.g:5596:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionBraceMapValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionBraceMapValue=ruleExtensionBraceMapValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionBraceMapValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionBraceMapValue"


    // $ANTLR start "ruleExtensionBraceMapValue"
    // InternalRosSystemParser.g:5602:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5608:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRosSystemParser.g:5609:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRosSystemParser.g:5609:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRosSystemParser.g:5610:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRosSystemParser.g:5610:3: ()
            // InternalRosSystemParser.g:5611:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:5621:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=Connections && LA65_0<=Processes)||(LA65_0>=FromFile && LA65_0<=Plugins)||LA65_0==Threads||(LA65_0>=Boolean && LA65_0<=Float64)||LA65_0==Message||LA65_0==Service||(LA65_0>=Base64 && LA65_0<=Action)||(LA65_0>=Nodes && LA65_0<=Int64)||(LA65_0>=Type_1 && LA65_0<=List)||(LA65_0>=Bool && LA65_0<=Node)||(LA65_0>=Time && LA65_0<=Ns)||(LA65_0>=RULE_ID && LA65_0<=RULE_STRING)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRosSystemParser.g:5622:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRosSystemParser.g:5622:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRosSystemParser.g:5623:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRosSystemParser.g:5623:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRosSystemParser.g:5624:6: lv_entries_2_0= ruleExtensionEntry
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_46);
                    lv_entries_2_0=ruleExtensionEntry();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExtensionBraceMapValueRule());
                      						}
                      						add(
                      							current,
                      							"entries",
                      							lv_entries_2_0,
                      							"de.fraunhofer.ipa.ros.Basics.ExtensionEntry");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:5641:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( ((LA64_0>=Connections && LA64_0<=Processes)||(LA64_0>=FromFile && LA64_0<=Plugins)||LA64_0==Threads||(LA64_0>=Boolean && LA64_0<=Float64)||LA64_0==Message||LA64_0==Service||(LA64_0>=Base64 && LA64_0<=Action)||(LA64_0>=Nodes && LA64_0<=Int64)||(LA64_0>=Type_1 && LA64_0<=List)||(LA64_0>=Bool && LA64_0<=Node)||(LA64_0>=Time && LA64_0<=Ns)||LA64_0==Comma||(LA64_0>=RULE_ID && LA64_0<=RULE_STRING)) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:5642:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRosSystemParser.g:5642:5: (otherlv_3= Comma )?
                    	    int alt63=2;
                    	    int LA63_0 = input.LA(1);

                    	    if ( (LA63_0==Comma) ) {
                    	        alt63=1;
                    	    }
                    	    switch (alt63) {
                    	        case 1 :
                    	            // InternalRosSystemParser.g:5643:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_43); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosSystemParser.g:5648:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRosSystemParser.g:5649:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosSystemParser.g:5649:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRosSystemParser.g:5650:7: lv_entries_4_0= ruleExtensionEntry
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_46);
                    	    lv_entries_4_0=ruleExtensionEntry();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getExtensionBraceMapValueRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"entries",
                    	      								lv_entries_4_0,
                    	      								"de.fraunhofer.ipa.ros.Basics.ExtensionEntry");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getExtensionBraceMapValueAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionBraceMapValue"


    // $ANTLR start "entryRuleExtensionIndentedMapValue"
    // InternalRosSystemParser.g:5677:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRosSystemParser.g:5677:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRosSystemParser.g:5678:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionIndentedMapValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionIndentedMapValue=ruleExtensionIndentedMapValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionIndentedMapValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionIndentedMapValue"


    // $ANTLR start "ruleExtensionIndentedMapValue"
    // InternalRosSystemParser.g:5684:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5690:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRosSystemParser.g:5691:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRosSystemParser.g:5691:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRosSystemParser.g:5692:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRosSystemParser.g:5692:3: ()
            // InternalRosSystemParser.g:5693:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
              					current);
              			
            }

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
              		
            }
            // InternalRosSystemParser.g:5703:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=Connections && LA66_0<=Processes)||(LA66_0>=FromFile && LA66_0<=Plugins)||LA66_0==Threads||(LA66_0>=Boolean && LA66_0<=Float64)||LA66_0==Message||LA66_0==Service||(LA66_0>=Base64 && LA66_0<=Action)||(LA66_0>=Nodes && LA66_0<=Int64)||(LA66_0>=Type_1 && LA66_0<=List)||(LA66_0>=Bool && LA66_0<=Node)||(LA66_0>=Time && LA66_0<=Ns)||(LA66_0>=RULE_ID && LA66_0<=RULE_STRING)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalRosSystemParser.g:5704:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRosSystemParser.g:5704:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRosSystemParser.g:5705:5: lv_entries_2_0= ruleExtensionEntry
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_44);
            	    lv_entries_2_0=ruleExtensionEntry();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getExtensionIndentedMapValueRule());
            	      					}
            	      					add(
            	      						current,
            	      						"entries",
            	      						lv_entries_2_0,
            	      						"de.fraunhofer.ipa.ros.Basics.ExtensionEntry");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);

            this_END_3=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_3, grammarAccess.getExtensionIndentedMapValueAccess().getENDTerminalRuleCall_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionIndentedMapValue"


    // $ANTLR start "entryRuleExtensionRefValue"
    // InternalRosSystemParser.g:5730:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRosSystemParser.g:5730:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRosSystemParser.g:5731:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionRefValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionRefValue=ruleExtensionRefValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionRefValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionRefValue"


    // $ANTLR start "ruleExtensionRefValue"
    // InternalRosSystemParser.g:5737:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
    public final EObject ruleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        Token lv_refKind_1_1=null;
        Token lv_refKind_1_2=null;
        Token lv_refKind_1_3=null;
        Token lv_refKind_1_4=null;
        Token lv_refKind_1_5=null;
        Token lv_refKind_1_6=null;
        Token lv_refKind_1_7=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5743:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:5744:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:5744:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:5745:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:5745:3: ()
            // InternalRosSystemParser.g:5746:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:5752:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRosSystemParser.g:5753:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRosSystemParser.g:5753:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRosSystemParser.g:5754:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRosSystemParser.g:5754:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt67=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt67=1;
                }
                break;
            case Sub:
                {
                alt67=2;
                }
                break;
            case Ss:
                {
                alt67=3;
                }
                break;
            case Sc:
                {
                alt67=4;
                }
                break;
            case As:
                {
                alt67=5;
                }
                break;
            case Ac:
                {
                alt67=6;
                }
                break;
            case Param:
                {
                alt67=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalRosSystemParser.g:5755:6: lv_refKind_1_1= Pub
                    {
                    lv_refKind_1_1=(Token)match(input,Pub,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_refKind_1_1, grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                      						}
                      						setWithLastConsumed(current, "refKind", lv_refKind_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5766:6: lv_refKind_1_2= Sub
                    {
                    lv_refKind_1_2=(Token)match(input,Sub,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_refKind_1_2, grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                      						}
                      						setWithLastConsumed(current, "refKind", lv_refKind_1_2, null);
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:5777:6: lv_refKind_1_3= Ss
                    {
                    lv_refKind_1_3=(Token)match(input,Ss,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_refKind_1_3, grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                      						}
                      						setWithLastConsumed(current, "refKind", lv_refKind_1_3, null);
                      					
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:5788:6: lv_refKind_1_4= Sc
                    {
                    lv_refKind_1_4=(Token)match(input,Sc,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_refKind_1_4, grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                      						}
                      						setWithLastConsumed(current, "refKind", lv_refKind_1_4, null);
                      					
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:5799:6: lv_refKind_1_5= As
                    {
                    lv_refKind_1_5=(Token)match(input,As,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_refKind_1_5, grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                      						}
                      						setWithLastConsumed(current, "refKind", lv_refKind_1_5, null);
                      					
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:5810:6: lv_refKind_1_6= Ac
                    {
                    lv_refKind_1_6=(Token)match(input,Ac,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_refKind_1_6, grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                      						}
                      						setWithLastConsumed(current, "refKind", lv_refKind_1_6, null);
                      					
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:5821:6: lv_refKind_1_7= Param
                    {
                    lv_refKind_1_7=(Token)match(input,Param,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_refKind_1_7, grammarAccess.getExtensionRefValueAccess().getRefKindParamKeyword_1_0_6());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                      						}
                      						setWithLastConsumed(current, "refKind", lv_refKind_1_7, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalRosSystemParser.g:5834:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:5835:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:5835:4: ( ruleEString )
            // InternalRosSystemParser.g:5836:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getExtensionRefValueRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtensionRefValueAccess().getTargetEObjectCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionRefValue"


    // $ANTLR start "entryRuleExtensionScalarValue"
    // InternalRosSystemParser.g:5854:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRosSystemParser.g:5854:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRosSystemParser.g:5855:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionScalarValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionScalarValue=ruleExtensionScalarValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionScalarValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionScalarValue"


    // $ANTLR start "ruleExtensionScalarValue"
    // InternalRosSystemParser.g:5861:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5867:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRosSystemParser.g:5868:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRosSystemParser.g:5868:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRosSystemParser.g:5869:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRosSystemParser.g:5869:3: ()
            // InternalRosSystemParser.g:5870:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:5876:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRosSystemParser.g:5877:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRosSystemParser.g:5877:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRosSystemParser.g:5878:5: lv_value_1_0= ruleExtensionScalarLiteral
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtensionScalarValueAccess().getValueExtensionScalarLiteralParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleExtensionScalarLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtensionScalarValueRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"de.fraunhofer.ipa.ros.Basics.ExtensionScalarLiteral");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionScalarValue"


    // $ANTLR start "entryRuleExtensionScalarLiteral"
    // InternalRosSystemParser.g:5899:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRosSystemParser.g:5899:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRosSystemParser.g:5900:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionScalarLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtensionScalarLiteral=ruleExtensionScalarLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtensionScalarLiteral.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtensionScalarLiteral"


    // $ANTLR start "ruleExtensionScalarLiteral"
    // InternalRosSystemParser.g:5906:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5912:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRosSystemParser.g:5913:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRosSystemParser.g:5913:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt68=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt68=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt68=2;
                }
                break;
            case RULE_DECINT:
                {
                alt68=3;
                }
                break;
            case RULE_INT:
                {
                alt68=4;
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
                alt68=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalRosSystemParser.g:5914:3: this_BOOLEAN_0= RULE_BOOLEAN
                    {
                    this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_BOOLEAN_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_BOOLEAN_0, grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5922:3: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_DOUBLE_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_DOUBLE_1, grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:5930:3: this_DECINT_2= RULE_DECINT
                    {
                    this_DECINT_2=(Token)match(input,RULE_DECINT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_DECINT_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_DECINT_2, grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:5938:3: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_3, grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:5946:3: this_ExtensionKey_4= ruleExtensionKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExtensionScalarLiteralAccess().getExtensionKeyParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExtensionKey_4=ruleExtensionKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ExtensionKey_4);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtensionScalarLiteral"

    // $ANTLR start synpred1_InternalRosSystemParser
    public final void synpred1_InternalRosSystemParser_fragment() throws RecognitionException {   
        // InternalRosSystemParser.g:1305:4: ( ruleRosSystemConnection )
        // InternalRosSystemParser.g:1305:5: ruleRosSystemConnection
        {
        pushFollow(FOLLOW_2);
        ruleRosSystemConnection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalRosSystemParser

    // $ANTLR start synpred2_InternalRosSystemParser
    public final void synpred2_InternalRosSystemParser_fragment() throws RecognitionException {   
        // InternalRosSystemParser.g:1411:4: ( ruleRosTopicConnection )
        // InternalRosSystemParser.g:1411:5: ruleRosTopicConnection
        {
        pushFollow(FOLLOW_2);
        ruleRosTopicConnection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalRosSystemParser

    // $ANTLR start synpred3_InternalRosSystemParser
    public final void synpred3_InternalRosSystemParser_fragment() throws RecognitionException {   
        // InternalRosSystemParser.g:1423:4: ( ruleRosServiceConnection )
        // InternalRosSystemParser.g:1423:5: ruleRosServiceConnection
        {
        pushFollow(FOLLOW_2);
        ruleRosServiceConnection();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalRosSystemParser

    // Delegated rules

    public final boolean synpred1_InternalRosSystemParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalRosSystemParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalRosSystemParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalRosSystemParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalRosSystemParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalRosSystemParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\124\1\130\1\147\2\123\1\147\2\131\1\0\2\uffff";
    static final String dfa_3s = "\1\124\1\130\1\150\2\123\1\150\2\131\1\0\2\uffff";
    static final String dfa_4s = "\11\uffff\1\1\1\2";
    static final String dfa_5s = "\10\uffff\1\0\2\uffff}>";
    static final String[] dfa_6s = {
            "\1\1",
            "\1\2",
            "\1\4\1\3",
            "\1\5",
            "\1\5",
            "\1\7\1\6",
            "\1\10",
            "\1\10",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1303:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_8 = input.LA(1);

                         
                        int index22_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalRosSystemParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index22_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\14\uffff";
    static final String dfa_8s = "\1\124\1\130\1\147\2\123\1\147\2\131\1\0\3\uffff";
    static final String dfa_9s = "\1\124\1\130\1\150\2\123\1\150\2\131\1\0\3\uffff";
    static final String dfa_10s = "\11\uffff\1\1\1\2\1\3";
    static final String dfa_11s = "\10\uffff\1\0\3\uffff}>";
    static final String[] dfa_12s = {
            "\1\1",
            "\1\2",
            "\1\4\1\3",
            "\1\5",
            "\1\5",
            "\1\7\1\6",
            "\1\10",
            "\1\10",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1409:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_8 = input.LA(1);

                         
                        int index23_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRosSystemParser()) ) {s = 9;}

                        else if ( (synpred3_InternalRosSystemParser()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index23_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\1\10\2\11\10\uffff";
    static final String dfa_14s = "\3\123\4\uffff\1\123\3\uffff";
    static final String dfa_15s = "\3\154\4\uffff\1\153\3\uffff";
    static final String dfa_16s = "\3\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_17s = "\13\uffff}>";
    static final String[] dfa_18s = {
            "\1\10\4\uffff\1\7\1\10\3\uffff\1\3\1\6\1\4\1\5\6\uffff\1\2\1\1\3\uffff\1\10",
            "\1\11\2\uffff\1\10\2\uffff\1\11\15\uffff\2\11\3\uffff\1\11",
            "\1\11\2\uffff\1\10\2\uffff\1\11\15\uffff\2\11\3\uffff\1\11",
            "",
            "",
            "",
            "",
            "\1\12\4\uffff\2\12\3\uffff\4\12\6\uffff\2\12\2\uffff\1\10",
            "",
            "",
            ""
    };
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_1;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "2308:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_19s = "\44\uffff";
    static final String dfa_20s = "\36\uffff\2\42\4\uffff";
    static final String dfa_21s = "\1\17\35\uffff\2\122\4\uffff";
    static final String dfa_22s = "\1\150\35\uffff\2\122\4\uffff";
    static final String dfa_23s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\40\1\41\1\36\1\37";
    static final String dfa_24s = "\44\uffff}>";
    static final String[] dfa_25s = {
            "\1\32\1\33\2\uffff\1\17\2\uffff\1\34\1\uffff\1\25\1\27\1\31\2\uffff\1\12\1\13\1\24\1\26\1\30\3\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\41\1\22\2\uffff\1\14\1\5\1\7\1\11\3\uffff\1\4\1\6\1\10\3\uffff\1\3\5\uffff\1\1\1\15\1\40\1\uffff\1\2\4\uffff\1\16\30\uffff\1\37\1\36",
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

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_19;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "3553:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0001000000022D00L,0x0000100000800000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0001000000002D00L,0x0000100000800000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000118000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000100000100000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0001000000800000L,0x0000100000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000002080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L,0x0000100000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0001000000203F00L,0x0000100000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001000000202F00L,0x0000100000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0001000000002F00L,0x0000100000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x3000000000000000L,0x0000000000003018L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0001000000002D00L,0x0000000000800000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x00000181E1000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x4000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x008006C018000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0040000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000018002000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000080004000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0xCFFF0FD478BE3F00L,0x000001800003CFE7L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0xCFFF0FD478BE3F00L,0x000011800003CFE7L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0xCFFF0FD478BE3F00L,0x000001800803CFE7L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0xCFFF0FD478BE3F00L,0x00000180080BCFE7L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0xBEBE0FDC78180000L,0x00000B81C501FFFFL});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xBEBE0FDC78180000L,0x00000B81C701FFFFL});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0xBEBE0FDC78180000L,0x00000B81C709FFFFL});

}