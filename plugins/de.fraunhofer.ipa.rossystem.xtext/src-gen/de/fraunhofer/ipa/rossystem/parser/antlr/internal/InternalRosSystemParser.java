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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "ParameterAny", "Connections", "Interfaces", "Parameters", "SubSystems", "Namespace", "Processes", "GraphName", "Float32_1", "Float64_1", "FromFile", "Default", "Duration", "Feedback", "String_2", "Threads", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Float32", "Float64", "Int16_1", "Int32_1", "Int64_1", "Message", "Param", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Int8_1", "Nodes", "Result", "Slots", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "From", "Int16", "Int32", "Int64", "Pub", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "HyphenMinus", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Connections=8;
    public static final int Float32_1=15;
    public static final int Node=75;
    public static final int RULE_DATE_TIME=102;
    public static final int Uint64_1=25;
    public static final int String=40;
    public static final int Processes=13;
    public static final int Int16=57;
    public static final int SubSystems=11;
    public static final int Float32=28;
    public static final int Goal=72;
    public static final int Bool=69;
    public static final int Uint16=51;
    public static final int Boolean=26;
    public static final int Sub=61;
    public static final int Uint8=63;
    public static final int Parameters=10;
    public static final int RULE_ID=103;
    public static final int RULE_DIGIT=92;
    public static final int GlobalNamespace=6;
    public static final int Namespace=12;
    public static final int Int16_1=30;
    public static final int Header=39;
    public static final int RULE_INT=105;
    public static final int Byte=70;
    public static final int RULE_ML_COMMENT=112;
    public static final int LeftSquareBracket=88;
    public static final int Ac=67;
    public static final int Base64=37;
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
    public static final int FullStop=85;
    public static final int RULE_HOUR=100;
    public static final int Int8=73;
    public static final int Default=18;
    public static final int Int8_1=46;
    public static final int CommercialAt=87;
    public static final int Uint16_1=23;
    public static final int Sc=76;
    public static final int Type=79;
    public static final int Float64=29;
    public static final int Int32_1=31;
    public static final int RULE_BINARY=93;
    public static final int String_1=50;
    public static final int String_2=21;
    public static final int Ss=77;
    public static final int RULE_DAY=97;
    public static final int RULE_BEGIN=107;
    public static final int RULE_BOOLEAN=94;
    public static final int RelativeNamespace=4;
    public static final int RULE_YEAR=99;
    public static final int Result=48;
    public static final int Name=74;
    public static final int RULE_MIN_SEC=101;
    public static final int Char_1=45;
    public static final int ParameterAny=7;
    public static final int List=66;
    public static final int RightSquareBracket=89;
    public static final int PrivateNamespace=5;
    public static final int GraphName=14;
    public static final int Byte_1=44;
    public static final int Float64_1=16;
    public static final int Duration=19;
    public static final int Uint32_1=24;
    public static final int Double=38;
    public static final int Type_1=62;
    public static final int Value=64;
    public static final int Uint64=53;
    public static final int FromFile=17;
    public static final int Action=42;
    public static final int RULE_END=108;
    public static final int Message=33;
    public static final int Value_1=54;
    public static final int Time=78;
    public static final int RULE_STRING=104;
    public static final int Bool_1=43;
    public static final int Any=80;
    public static final int Struct=41;
    public static final int RULE_SL_COMMENT=109;
    public static final int Slots=49;
    public static final int Uint8_1=36;
    public static final int RULE_DOUBLE=96;
    public static final int Feedback=20;
    public static final int RULE_ROS_CONVENTION_A=110;
    public static final int RULE_ROS_CONVENTION_PARAM=111;
    public static final int Colon=86;
    public static final int Pub=60;
    public static final int EOF=-1;
    public static final int Ns=81;
    public static final int RULE_WS=113;
    public static final int Int64_1=32;
    public static final int LeftCurlyBracket=90;
    public static final int Service=35;
    public static final int From=56;
    public static final int RULE_ANY_OTHER=114;
    public static final int Nodes=47;
    public static final int Date=65;
    public static final int Interfaces=9;
    public static final int Threads=22;
    public static final int Integer=27;
    public static final int Array=55;
    public static final int Int64=59;
    public static final int Param=34;
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
    // InternalRosSystemParser.g:89:1: ruleRosSystem returns [EObject current=null] : ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) this_BEGIN_3= RULE_BEGIN (otherlv_4= FromFile ( (lv_fromFile_5_0= ruleEString ) ) )? ( (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END ) | (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END ) | (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END ) | (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END ) | (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END ) | ( (lv_extensions_26_0= ruleExtensionBlock ) ) )* this_END_27= RULE_END ) ;
    public final EObject ruleRosSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        Token otherlv_10=null;
        Token this_BEGIN_11=null;
        Token this_END_13=null;
        Token otherlv_14=null;
        Token this_BEGIN_15=null;
        Token this_END_17=null;
        Token otherlv_18=null;
        Token this_BEGIN_19=null;
        Token this_END_21=null;
        Token otherlv_22=null;
        Token this_BEGIN_23=null;
        Token this_END_25=null;
        Token this_END_27=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_fromFile_5_0 = null;

        EObject lv_components_8_0 = null;

        EObject lv_processes_12_0 = null;

        EObject lv_components_16_0 = null;

        EObject lv_parameter_20_0 = null;

        EObject lv_connections_24_0 = null;

        EObject lv_extensions_26_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:95:2: ( ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) this_BEGIN_3= RULE_BEGIN (otherlv_4= FromFile ( (lv_fromFile_5_0= ruleEString ) ) )? ( (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END ) | (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END ) | (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END ) | (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END ) | (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END ) | ( (lv_extensions_26_0= ruleExtensionBlock ) ) )* this_END_27= RULE_END ) )
            // InternalRosSystemParser.g:96:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) this_BEGIN_3= RULE_BEGIN (otherlv_4= FromFile ( (lv_fromFile_5_0= ruleEString ) ) )? ( (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END ) | (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END ) | (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END ) | (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END ) | (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END ) | ( (lv_extensions_26_0= ruleExtensionBlock ) ) )* this_END_27= RULE_END )
            {
            // InternalRosSystemParser.g:96:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) this_BEGIN_3= RULE_BEGIN (otherlv_4= FromFile ( (lv_fromFile_5_0= ruleEString ) ) )? ( (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END ) | (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END ) | (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END ) | (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END ) | (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END ) | ( (lv_extensions_26_0= ruleExtensionBlock ) ) )* this_END_27= RULE_END )
            // InternalRosSystemParser.g:97:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) this_BEGIN_3= RULE_BEGIN (otherlv_4= FromFile ( (lv_fromFile_5_0= ruleEString ) ) )? ( (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END ) | (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END ) | (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END ) | (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END ) | (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END ) | ( (lv_extensions_26_0= ruleExtensionBlock ) ) )* this_END_27= RULE_END
            {
            // InternalRosSystemParser.g:97:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)) ) {
                alt1=1;
            }
            else if ( (LA1_0==Slots) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalRosSystemParser.g:98:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    {
                    // InternalRosSystemParser.g:98:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    // InternalRosSystemParser.g:99:5: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon
                    {
                    // InternalRosSystemParser.g:99:5: ( (lv_name_0_0= ruleEString ) )
                    // InternalRosSystemParser.g:100:6: (lv_name_0_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:100:6: (lv_name_0_0= ruleEString )
                    // InternalRosSystemParser.g:101:7: lv_name_0_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getRosSystemAccess().getNameEStringParserRuleCall_0_0_0_0());
                      						
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

                      					newLeafNode(otherlv_1, grammarAccess.getRosSystemAccess().getColonKeyword_0_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:124:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:124:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:125:5: (lv_name_2_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:125:5: (lv_name_2_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:126:6: lv_name_2_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosSystemAccess().getNameAddedKeywordNameParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_name_2_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosSystemRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_3, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_1());
              		
            }
            // InternalRosSystemParser.g:148:3: (otherlv_4= FromFile ( (lv_fromFile_5_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==FromFile) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalRosSystemParser.g:149:4: otherlv_4= FromFile ( (lv_fromFile_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,FromFile,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getRosSystemAccess().getFromFileKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:153:4: ( (lv_fromFile_5_0= ruleEString ) )
                    // InternalRosSystemParser.g:154:5: (lv_fromFile_5_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:154:5: (lv_fromFile_5_0= ruleEString )
                    // InternalRosSystemParser.g:155:6: lv_fromFile_5_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosSystemAccess().getFromFileEStringParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_fromFile_5_0=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosSystemRule());
                      						}
                      						set(
                      							current,
                      							"fromFile",
                      							lv_fromFile_5_0,
                      							"de.fraunhofer.ipa.ros.Basics.EString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:173:3: ( (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END ) | (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END ) | (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END ) | (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END ) | (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END ) | ( (lv_extensions_26_0= ruleExtensionBlock ) ) )*
            loop8:
            do {
                int alt8=7;
                switch ( input.LA(1) ) {
                case SubSystems:
                    {
                    alt8=1;
                    }
                    break;
                case Processes:
                    {
                    alt8=2;
                    }
                    break;
                case Nodes:
                    {
                    alt8=3;
                    }
                    break;
                case Parameters:
                    {
                    alt8=4;
                    }
                    break;
                case Connections:
                    {
                    alt8=5;
                    }
                    break;
                case CommercialAt:
                    {
                    alt8=6;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // InternalRosSystemParser.g:174:4: (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:174:4: (otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END )
            	    // InternalRosSystemParser.g:175:5: otherlv_6= SubSystems this_BEGIN_7= RULE_BEGIN ( (lv_components_8_0= ruleSubSystem ) )* this_END_9= RULE_END
            	    {
            	    otherlv_6=(Token)match(input,SubSystems,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_6, grammarAccess.getRosSystemAccess().getSubSystemsKeyword_3_0_0());
            	      				
            	    }
            	    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_7, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_3_0_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:183:5: ( (lv_components_8_0= ruleSubSystem ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_STRING)) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:184:6: (lv_components_8_0= ruleSubSystem )
            	    	    {
            	    	    // InternalRosSystemParser.g:184:6: (lv_components_8_0= ruleSubSystem )
            	    	    // InternalRosSystemParser.g:185:7: lv_components_8_0= ruleSubSystem
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getComponentsSubSystemParserRuleCall_3_0_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_8);
            	    	    lv_components_8_0=ruleSubSystem();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"components",
            	    	      								lv_components_8_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.SubSystem");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    this_END_9=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_9, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_3_0_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosSystemParser.g:208:4: (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:208:4: (otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END )
            	    // InternalRosSystemParser.g:209:5: otherlv_10= Processes this_BEGIN_11= RULE_BEGIN ( (lv_processes_12_0= ruleProcess ) )* this_END_13= RULE_END
            	    {
            	    otherlv_10=(Token)match(input,Processes,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_10, grammarAccess.getRosSystemAccess().getProcessesKeyword_3_1_0());
            	      				
            	    }
            	    this_BEGIN_11=(Token)match(input,RULE_BEGIN,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_11, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_3_1_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:217:5: ( (lv_processes_12_0= ruleProcess ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==Slots||(LA4_0>=RULE_ID && LA4_0<=RULE_STRING)) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:218:6: (lv_processes_12_0= ruleProcess )
            	    	    {
            	    	    // InternalRosSystemParser.g:218:6: (lv_processes_12_0= ruleProcess )
            	    	    // InternalRosSystemParser.g:219:7: lv_processes_12_0= ruleProcess
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getProcessesProcessParserRuleCall_3_1_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_9);
            	    	    lv_processes_12_0=ruleProcess();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"processes",
            	    	      								lv_processes_12_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.Process");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    this_END_13=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_13, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_3_1_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosSystemParser.g:242:4: (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:242:4: (otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END )
            	    // InternalRosSystemParser.g:243:5: otherlv_14= Nodes this_BEGIN_15= RULE_BEGIN ( (lv_components_16_0= ruleRosNode ) )* this_END_17= RULE_END
            	    {
            	    otherlv_14=(Token)match(input,Nodes,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_14, grammarAccess.getRosSystemAccess().getNodesKeyword_3_2_0());
            	      				
            	    }
            	    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_15, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_3_2_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:251:5: ( (lv_components_16_0= ruleRosNode ) )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==Slots||(LA5_0>=RULE_ID && LA5_0<=RULE_STRING)) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:252:6: (lv_components_16_0= ruleRosNode )
            	    	    {
            	    	    // InternalRosSystemParser.g:252:6: (lv_components_16_0= ruleRosNode )
            	    	    // InternalRosSystemParser.g:253:7: lv_components_16_0= ruleRosNode
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getComponentsRosNodeParserRuleCall_3_2_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_9);
            	    	    lv_components_16_0=ruleRosNode();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"components",
            	    	      								lv_components_16_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.RosNode");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    this_END_17=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_17, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_3_2_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRosSystemParser.g:276:4: (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:276:4: (otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END )
            	    // InternalRosSystemParser.g:277:5: otherlv_18= Parameters this_BEGIN_19= RULE_BEGIN ( (lv_parameter_20_0= ruleParameter ) )* this_END_21= RULE_END
            	    {
            	    otherlv_18=(Token)match(input,Parameters,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_18, grammarAccess.getRosSystemAccess().getParametersKeyword_3_3_0());
            	      				
            	    }
            	    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_19, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_3_3_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:285:5: ( (lv_parameter_20_0= ruleParameter ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==Slots||(LA6_0>=RULE_ID && LA6_0<=RULE_STRING)) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:286:6: (lv_parameter_20_0= ruleParameter )
            	    	    {
            	    	    // InternalRosSystemParser.g:286:6: (lv_parameter_20_0= ruleParameter )
            	    	    // InternalRosSystemParser.g:287:7: lv_parameter_20_0= ruleParameter
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getParameterParameterParserRuleCall_3_3_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_9);
            	    	    lv_parameter_20_0=ruleParameter();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"parameter",
            	    	      								lv_parameter_20_0,
            	    	      								"de.fraunhofer.ipa.ros.Basics.Parameter");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    this_END_21=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_21, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_3_3_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRosSystemParser.g:310:4: (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END )
            	    {
            	    // InternalRosSystemParser.g:310:4: (otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END )
            	    // InternalRosSystemParser.g:311:5: otherlv_22= Connections this_BEGIN_23= RULE_BEGIN ( (lv_connections_24_0= ruleConnection ) )* this_END_25= RULE_END
            	    {
            	    otherlv_22=(Token)match(input,Connections,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_22, grammarAccess.getRosSystemAccess().getConnectionsKeyword_3_4_0());
            	      				
            	    }
            	    this_BEGIN_23=(Token)match(input,RULE_BEGIN,FOLLOW_10); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_BEGIN_23, grammarAccess.getRosSystemAccess().getBEGINTerminalRuleCall_3_4_1());
            	      				
            	    }
            	    // InternalRosSystemParser.g:319:5: ( (lv_connections_24_0= ruleConnection ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==HyphenMinus) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalRosSystemParser.g:320:6: (lv_connections_24_0= ruleConnection )
            	    	    {
            	    	    // InternalRosSystemParser.g:320:6: (lv_connections_24_0= ruleConnection )
            	    	    // InternalRosSystemParser.g:321:7: lv_connections_24_0= ruleConnection
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getRosSystemAccess().getConnectionsConnectionParserRuleCall_3_4_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_10);
            	    	    lv_connections_24_0=ruleConnection();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	    	      							}
            	    	      							add(
            	    	      								current,
            	    	      								"connections",
            	    	      								lv_connections_24_0,
            	    	      								"de.fraunhofer.ipa.rossystem.RosSystem.Connection");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);

            	    this_END_25=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_END_25, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_3_4_3());
            	      				
            	    }

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRosSystemParser.g:344:4: ( (lv_extensions_26_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRosSystemParser.g:344:4: ( (lv_extensions_26_0= ruleExtensionBlock ) )
            	    // InternalRosSystemParser.g:345:5: (lv_extensions_26_0= ruleExtensionBlock )
            	    {
            	    // InternalRosSystemParser.g:345:5: (lv_extensions_26_0= ruleExtensionBlock )
            	    // InternalRosSystemParser.g:346:6: lv_extensions_26_0= ruleExtensionBlock
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRosSystemAccess().getExtensionsExtensionBlockParserRuleCall_3_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_extensions_26_0=ruleExtensionBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRosSystemRule());
            	      						}
            	      						add(
            	      							current,
            	      							"extensions",
            	      							lv_extensions_26_0,
            	      							"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
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

            this_END_27=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_27, grammarAccess.getRosSystemAccess().getENDTerminalRuleCall_4());
              		
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
    // InternalRosSystemParser.g:372:1: entryRuleSubSystem returns [EObject current=null] : iv_ruleSubSystem= ruleSubSystem EOF ;
    public final EObject entryRuleSubSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubSystem = null;


        try {
            // InternalRosSystemParser.g:372:50: (iv_ruleSubSystem= ruleSubSystem EOF )
            // InternalRosSystemParser.g:373:2: iv_ruleSubSystem= ruleSubSystem EOF
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
    // InternalRosSystemParser.g:379:1: ruleSubSystem returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSubSystem() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:385:2: ( ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:386:2: ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:386:2: ( ( ruleEString ) )
            // InternalRosSystemParser.g:387:3: ( ruleEString )
            {
            // InternalRosSystemParser.g:387:3: ( ruleEString )
            // InternalRosSystemParser.g:388:4: ruleEString
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
    // InternalRosSystemParser.g:405:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalRosSystemParser.g:405:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalRosSystemParser.g:406:2: iv_ruleProcess= ruleProcess EOF
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
    // InternalRosSystemParser.g:412:1: ruleProcess returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Nodes otherlv_6= LeftSquareBracket ( ( ruleEString ) ) (otherlv_8= Comma ( ( ruleEString ) ) )* otherlv_10= RightSquareBracket )? (otherlv_11= Threads ( (lv_threads_12_0= ruleInteger0 ) ) )? this_END_13= RULE_END ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token this_END_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_threads_12_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:418:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Nodes otherlv_6= LeftSquareBracket ( ( ruleEString ) ) (otherlv_8= Comma ( ( ruleEString ) ) )* otherlv_10= RightSquareBracket )? (otherlv_11= Threads ( (lv_threads_12_0= ruleInteger0 ) ) )? this_END_13= RULE_END ) )
            // InternalRosSystemParser.g:419:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Nodes otherlv_6= LeftSquareBracket ( ( ruleEString ) ) (otherlv_8= Comma ( ( ruleEString ) ) )* otherlv_10= RightSquareBracket )? (otherlv_11= Threads ( (lv_threads_12_0= ruleInteger0 ) ) )? this_END_13= RULE_END )
            {
            // InternalRosSystemParser.g:419:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Nodes otherlv_6= LeftSquareBracket ( ( ruleEString ) ) (otherlv_8= Comma ( ( ruleEString ) ) )* otherlv_10= RightSquareBracket )? (otherlv_11= Threads ( (lv_threads_12_0= ruleInteger0 ) ) )? this_END_13= RULE_END )
            // InternalRosSystemParser.g:420:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Nodes otherlv_6= LeftSquareBracket ( ( ruleEString ) ) (otherlv_8= Comma ( ( ruleEString ) ) )* otherlv_10= RightSquareBracket )? (otherlv_11= Threads ( (lv_threads_12_0= ruleInteger0 ) ) )? this_END_13= RULE_END
            {
            // InternalRosSystemParser.g:420:3: ()
            // InternalRosSystemParser.g:421:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getProcessAccess().getProcessAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:427:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
                alt9=1;
            }
            else if ( (LA9_0==Slots) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalRosSystemParser.g:428:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:428:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:429:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:429:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:430:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:430:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:431:7: lv_name_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getProcessAccess().getNameEStringParserRuleCall_1_0_0_0());
                      						
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

                      					newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:454:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:454:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:455:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:455:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:456:6: lv_name_3_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getProcessAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getProcessRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_3_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_4, grammarAccess.getProcessAccess().getBEGINTerminalRuleCall_2());
              		
            }
            // InternalRosSystemParser.g:478:3: (otherlv_5= Nodes otherlv_6= LeftSquareBracket ( ( ruleEString ) ) (otherlv_8= Comma ( ( ruleEString ) ) )* otherlv_10= RightSquareBracket )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Nodes) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRosSystemParser.g:479:4: otherlv_5= Nodes otherlv_6= LeftSquareBracket ( ( ruleEString ) ) (otherlv_8= Comma ( ( ruleEString ) ) )* otherlv_10= RightSquareBracket
                    {
                    otherlv_5=(Token)match(input,Nodes,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getNodesKeyword_3_0());
                      			
                    }
                    otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_3_1());
                      			
                    }
                    // InternalRosSystemParser.g:487:4: ( ( ruleEString ) )
                    // InternalRosSystemParser.g:488:5: ( ruleEString )
                    {
                    // InternalRosSystemParser.g:488:5: ( ruleEString )
                    // InternalRosSystemParser.g:489:6: ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getProcessRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getProcessAccess().getComponentsRosNodeCrossReference_3_2_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:503:4: (otherlv_8= Comma ( ( ruleEString ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Comma) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:504:5: otherlv_8= Comma ( ( ruleEString ) )
                    	    {
                    	    otherlv_8=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_8, grammarAccess.getProcessAccess().getCommaKeyword_3_3_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:508:5: ( ( ruleEString ) )
                    	    // InternalRosSystemParser.g:509:6: ( ruleEString )
                    	    {
                    	    // InternalRosSystemParser.g:509:6: ( ruleEString )
                    	    // InternalRosSystemParser.g:510:7: ruleEString
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getProcessRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getProcessAccess().getComponentsRosNodeCrossReference_3_3_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,RightSquareBracket,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getProcessAccess().getRightSquareBracketKeyword_3_4());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:530:3: (otherlv_11= Threads ( (lv_threads_12_0= ruleInteger0 ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Threads) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRosSystemParser.g:531:4: otherlv_11= Threads ( (lv_threads_12_0= ruleInteger0 ) )
                    {
                    otherlv_11=(Token)match(input,Threads,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getProcessAccess().getThreadsKeyword_4_0());
                      			
                    }
                    // InternalRosSystemParser.g:535:4: ( (lv_threads_12_0= ruleInteger0 ) )
                    // InternalRosSystemParser.g:536:5: (lv_threads_12_0= ruleInteger0 )
                    {
                    // InternalRosSystemParser.g:536:5: (lv_threads_12_0= ruleInteger0 )
                    // InternalRosSystemParser.g:537:6: lv_threads_12_0= ruleInteger0
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getProcessAccess().getThreadsInteger0ParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_threads_12_0=ruleInteger0();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getProcessRule());
                      						}
                      						set(
                      							current,
                      							"threads",
                      							lv_threads_12_0,
                      							"de.fraunhofer.ipa.ros.Basics.Integer0");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_END_13=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_13, grammarAccess.getProcessAccess().getENDTerminalRuleCall_5());
              		
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
    // InternalRosSystemParser.g:563:1: entryRuleRosNode returns [EObject current=null] : iv_ruleRosNode= ruleRosNode EOF ;
    public final EObject entryRuleRosNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosNode = null;


        try {
            // InternalRosSystemParser.g:563:48: (iv_ruleRosNode= ruleRosNode EOF )
            // InternalRosSystemParser.g:564:2: iv_ruleRosNode= ruleRosNode EOF
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
    // InternalRosSystemParser.g:570:1: ruleRosNode returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= From ( ( ruleEString ) ) (otherlv_7= Namespace ( (lv_namespace_8_0= ruleEString ) ) )? (otherlv_9= Slots this_BEGIN_10= RULE_BEGIN ( (lv_slots_11_0= ruleSlotAttachment ) )* this_END_12= RULE_END )? (otherlv_13= Interfaces this_BEGIN_14= RULE_BEGIN ( (lv_rosinterfaces_15_0= ruleRosInterface ) )* this_END_16= RULE_END )? (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_rosparameters_19_0= ruleRosParameter ) )* this_END_20= RULE_END )? ( (lv_extensions_21_0= ruleExtensionBlock ) )* this_END_22= RULE_END ) ;
    public final EObject ruleRosNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token this_BEGIN_10=null;
        Token this_END_12=null;
        Token otherlv_13=null;
        Token this_BEGIN_14=null;
        Token this_END_16=null;
        Token otherlv_17=null;
        Token this_BEGIN_18=null;
        Token this_END_20=null;
        Token this_END_22=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_namespace_8_0 = null;

        EObject lv_slots_11_0 = null;

        EObject lv_rosinterfaces_15_0 = null;

        EObject lv_rosparameters_19_0 = null;

        EObject lv_extensions_21_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:576:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= From ( ( ruleEString ) ) (otherlv_7= Namespace ( (lv_namespace_8_0= ruleEString ) ) )? (otherlv_9= Slots this_BEGIN_10= RULE_BEGIN ( (lv_slots_11_0= ruleSlotAttachment ) )* this_END_12= RULE_END )? (otherlv_13= Interfaces this_BEGIN_14= RULE_BEGIN ( (lv_rosinterfaces_15_0= ruleRosInterface ) )* this_END_16= RULE_END )? (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_rosparameters_19_0= ruleRosParameter ) )* this_END_20= RULE_END )? ( (lv_extensions_21_0= ruleExtensionBlock ) )* this_END_22= RULE_END ) )
            // InternalRosSystemParser.g:577:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= From ( ( ruleEString ) ) (otherlv_7= Namespace ( (lv_namespace_8_0= ruleEString ) ) )? (otherlv_9= Slots this_BEGIN_10= RULE_BEGIN ( (lv_slots_11_0= ruleSlotAttachment ) )* this_END_12= RULE_END )? (otherlv_13= Interfaces this_BEGIN_14= RULE_BEGIN ( (lv_rosinterfaces_15_0= ruleRosInterface ) )* this_END_16= RULE_END )? (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_rosparameters_19_0= ruleRosParameter ) )* this_END_20= RULE_END )? ( (lv_extensions_21_0= ruleExtensionBlock ) )* this_END_22= RULE_END )
            {
            // InternalRosSystemParser.g:577:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= From ( ( ruleEString ) ) (otherlv_7= Namespace ( (lv_namespace_8_0= ruleEString ) ) )? (otherlv_9= Slots this_BEGIN_10= RULE_BEGIN ( (lv_slots_11_0= ruleSlotAttachment ) )* this_END_12= RULE_END )? (otherlv_13= Interfaces this_BEGIN_14= RULE_BEGIN ( (lv_rosinterfaces_15_0= ruleRosInterface ) )* this_END_16= RULE_END )? (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_rosparameters_19_0= ruleRosParameter ) )* this_END_20= RULE_END )? ( (lv_extensions_21_0= ruleExtensionBlock ) )* this_END_22= RULE_END )
            // InternalRosSystemParser.g:578:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= From ( ( ruleEString ) ) (otherlv_7= Namespace ( (lv_namespace_8_0= ruleEString ) ) )? (otherlv_9= Slots this_BEGIN_10= RULE_BEGIN ( (lv_slots_11_0= ruleSlotAttachment ) )* this_END_12= RULE_END )? (otherlv_13= Interfaces this_BEGIN_14= RULE_BEGIN ( (lv_rosinterfaces_15_0= ruleRosInterface ) )* this_END_16= RULE_END )? (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_rosparameters_19_0= ruleRosParameter ) )* this_END_20= RULE_END )? ( (lv_extensions_21_0= ruleExtensionBlock ) )* this_END_22= RULE_END
            {
            // InternalRosSystemParser.g:578:3: ()
            // InternalRosSystemParser.g:579:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosNodeAccess().getRosNodeAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:585:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)) ) {
                alt13=1;
            }
            else if ( (LA13_0==Slots) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalRosSystemParser.g:586:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:586:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:587:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:587:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:588:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:588:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:589:7: lv_name_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getRosNodeAccess().getNameEStringParserRuleCall_1_0_0_0());
                      						
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

                      					newLeafNode(otherlv_2, grammarAccess.getRosNodeAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:612:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:612:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:613:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:613:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:614:6: lv_name_3_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosNodeAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_3_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_4, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_2());
              		
            }
            otherlv_5=(Token)match(input,From,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRosNodeAccess().getFromKeyword_3());
              		
            }
            // InternalRosSystemParser.g:640:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:641:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:641:4: ( ruleEString )
            // InternalRosSystemParser.g:642:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosNodeRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosNodeAccess().getFromNodeCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_18);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:656:3: (otherlv_7= Namespace ( (lv_namespace_8_0= ruleEString ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Namespace) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRosSystemParser.g:657:4: otherlv_7= Namespace ( (lv_namespace_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,Namespace,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getRosNodeAccess().getNamespaceKeyword_5_0());
                      			
                    }
                    // InternalRosSystemParser.g:661:4: ( (lv_namespace_8_0= ruleEString ) )
                    // InternalRosSystemParser.g:662:5: (lv_namespace_8_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:662:5: (lv_namespace_8_0= ruleEString )
                    // InternalRosSystemParser.g:663:6: lv_namespace_8_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosNodeAccess().getNamespaceEStringParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_namespace_8_0=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                      						}
                      						set(
                      							current,
                      							"namespace",
                      							lv_namespace_8_0,
                      							"de.fraunhofer.ipa.ros.Basics.EString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:681:3: (otherlv_9= Slots this_BEGIN_10= RULE_BEGIN ( (lv_slots_11_0= ruleSlotAttachment ) )* this_END_12= RULE_END )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Slots) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRosSystemParser.g:682:4: otherlv_9= Slots this_BEGIN_10= RULE_BEGIN ( (lv_slots_11_0= ruleSlotAttachment ) )* this_END_12= RULE_END
                    {
                    otherlv_9=(Token)match(input,Slots,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getRosNodeAccess().getSlotsKeyword_6_0());
                      			
                    }
                    this_BEGIN_10=(Token)match(input,RULE_BEGIN,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_10, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_6_1());
                      			
                    }
                    // InternalRosSystemParser.g:690:4: ( (lv_slots_11_0= ruleSlotAttachment ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==Slots||(LA15_0>=RULE_ID && LA15_0<=RULE_STRING)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:691:5: (lv_slots_11_0= ruleSlotAttachment )
                    	    {
                    	    // InternalRosSystemParser.g:691:5: (lv_slots_11_0= ruleSlotAttachment )
                    	    // InternalRosSystemParser.g:692:6: lv_slots_11_0= ruleSlotAttachment
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRosNodeAccess().getSlotsSlotAttachmentParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_slots_11_0=ruleSlotAttachment();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"slots",
                    	      							lv_slots_11_0,
                    	      							"de.fraunhofer.ipa.rossystem.RosSystem.SlotAttachment");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    this_END_12=(Token)match(input,RULE_END,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_12, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_6_3());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:714:3: (otherlv_13= Interfaces this_BEGIN_14= RULE_BEGIN ( (lv_rosinterfaces_15_0= ruleRosInterface ) )* this_END_16= RULE_END )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Interfaces) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRosSystemParser.g:715:4: otherlv_13= Interfaces this_BEGIN_14= RULE_BEGIN ( (lv_rosinterfaces_15_0= ruleRosInterface ) )* this_END_16= RULE_END
                    {
                    otherlv_13=(Token)match(input,Interfaces,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getRosNodeAccess().getInterfacesKeyword_7_0());
                      			
                    }
                    this_BEGIN_14=(Token)match(input,RULE_BEGIN,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_14, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_7_1());
                      			
                    }
                    // InternalRosSystemParser.g:723:4: ( (lv_rosinterfaces_15_0= ruleRosInterface ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==HyphenMinus) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:724:5: (lv_rosinterfaces_15_0= ruleRosInterface )
                    	    {
                    	    // InternalRosSystemParser.g:724:5: (lv_rosinterfaces_15_0= ruleRosInterface )
                    	    // InternalRosSystemParser.g:725:6: lv_rosinterfaces_15_0= ruleRosInterface
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRosNodeAccess().getRosinterfacesRosInterfaceParserRuleCall_7_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_rosinterfaces_15_0=ruleRosInterface();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"rosinterfaces",
                    	      							lv_rosinterfaces_15_0,
                    	      							"de.fraunhofer.ipa.rossystem.RosSystem.RosInterface");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    this_END_16=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_16, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_7_3());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:747:3: (otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_rosparameters_19_0= ruleRosParameter ) )* this_END_20= RULE_END )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Parameters) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalRosSystemParser.g:748:4: otherlv_17= Parameters this_BEGIN_18= RULE_BEGIN ( (lv_rosparameters_19_0= ruleRosParameter ) )* this_END_20= RULE_END
                    {
                    otherlv_17=(Token)match(input,Parameters,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_17, grammarAccess.getRosNodeAccess().getParametersKeyword_8_0());
                      			
                    }
                    this_BEGIN_18=(Token)match(input,RULE_BEGIN,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_18, grammarAccess.getRosNodeAccess().getBEGINTerminalRuleCall_8_1());
                      			
                    }
                    // InternalRosSystemParser.g:756:4: ( (lv_rosparameters_19_0= ruleRosParameter ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==HyphenMinus) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:757:5: (lv_rosparameters_19_0= ruleRosParameter )
                    	    {
                    	    // InternalRosSystemParser.g:757:5: (lv_rosparameters_19_0= ruleRosParameter )
                    	    // InternalRosSystemParser.g:758:6: lv_rosparameters_19_0= ruleRosParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRosNodeAccess().getRosparametersRosParameterParserRuleCall_8_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_rosparameters_19_0=ruleRosParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRosNodeRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"rosparameters",
                    	      							lv_rosparameters_19_0,
                    	      							"de.fraunhofer.ipa.rossystem.RosSystem.RosParameter");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    this_END_20=(Token)match(input,RULE_END,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_20, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_8_3());
                      			
                    }

                    }
                    break;

            }

            // InternalRosSystemParser.g:780:3: ( (lv_extensions_21_0= ruleExtensionBlock ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==CommercialAt) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalRosSystemParser.g:781:4: (lv_extensions_21_0= ruleExtensionBlock )
            	    {
            	    // InternalRosSystemParser.g:781:4: (lv_extensions_21_0= ruleExtensionBlock )
            	    // InternalRosSystemParser.g:782:5: lv_extensions_21_0= ruleExtensionBlock
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getRosNodeAccess().getExtensionsExtensionBlockParserRuleCall_9_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_extensions_21_0=ruleExtensionBlock();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getRosNodeRule());
            	      					}
            	      					add(
            	      						current,
            	      						"extensions",
            	      						lv_extensions_21_0,
            	      						"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            this_END_22=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_22, grammarAccess.getRosNodeAccess().getENDTerminalRuleCall_10());
              		
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


    // $ANTLR start "entryRuleSlotAttachment"
    // InternalRosSystemParser.g:807:1: entryRuleSlotAttachment returns [EObject current=null] : iv_ruleSlotAttachment= ruleSlotAttachment EOF ;
    public final EObject entryRuleSlotAttachment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSlotAttachment = null;


        try {
            // InternalRosSystemParser.g:807:55: (iv_ruleSlotAttachment= ruleSlotAttachment EOF )
            // InternalRosSystemParser.g:808:2: iv_ruleSlotAttachment= ruleSlotAttachment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSlotAttachmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSlotAttachment=ruleSlotAttachment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSlotAttachment; 
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
    // $ANTLR end "entryRuleSlotAttachment"


    // $ANTLR start "ruleSlotAttachment"
    // InternalRosSystemParser.g:814:1: ruleSlotAttachment returns [EObject current=null] : ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) otherlv_3= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_7= RightSquareBracket ) ;
    public final EObject ruleSlotAttachment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:820:2: ( ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) otherlv_3= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_7= RightSquareBracket ) )
            // InternalRosSystemParser.g:821:2: ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) otherlv_3= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_7= RightSquareBracket )
            {
            // InternalRosSystemParser.g:821:2: ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) otherlv_3= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_7= RightSquareBracket )
            // InternalRosSystemParser.g:822:3: ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) otherlv_3= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_7= RightSquareBracket
            {
            // InternalRosSystemParser.g:822:3: ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)) ) {
                alt22=1;
            }
            else if ( (LA22_0==Slots) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalRosSystemParser.g:823:4: ( ( ( ruleEString ) ) otherlv_1= Colon )
                    {
                    // InternalRosSystemParser.g:823:4: ( ( ( ruleEString ) ) otherlv_1= Colon )
                    // InternalRosSystemParser.g:824:5: ( ( ruleEString ) ) otherlv_1= Colon
                    {
                    // InternalRosSystemParser.g:824:5: ( ( ruleEString ) )
                    // InternalRosSystemParser.g:825:6: ( ruleEString )
                    {
                    // InternalRosSystemParser.g:825:6: ( ruleEString )
                    // InternalRosSystemParser.g:826:7: ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSlotAttachmentRule());
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getSlotAttachmentAccess().getSlotPluginSlotCrossReference_0_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_3);
                    ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,Colon,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getSlotAttachmentAccess().getColonKeyword_0_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:846:4: ( ( ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:846:4: ( ( ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:847:5: ( ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:847:5: ( ruleAddedKeywordName )
                    // InternalRosSystemParser.g:848:6: ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSlotAttachmentRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSlotAttachmentAccess().getSlotPluginSlotCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSlotAttachmentAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:867:3: ( ( ( ruleQualifiedRef ) ) (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalRosSystemParser.g:868:4: ( ( ruleQualifiedRef ) ) (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )*
                    {
                    // InternalRosSystemParser.g:868:4: ( ( ruleQualifiedRef ) )
                    // InternalRosSystemParser.g:869:5: ( ruleQualifiedRef )
                    {
                    // InternalRosSystemParser.g:869:5: ( ruleQualifiedRef )
                    // InternalRosSystemParser.g:870:6: ruleQualifiedRef
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSlotAttachmentRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSlotAttachmentAccess().getPluginsPluginCrossReference_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    ruleQualifiedRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRosSystemParser.g:884:4: (otherlv_5= Comma ( ( ruleQualifiedRef ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==Comma) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:885:5: otherlv_5= Comma ( ( ruleQualifiedRef ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getSlotAttachmentAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:889:5: ( ( ruleQualifiedRef ) )
                    	    // InternalRosSystemParser.g:890:6: ( ruleQualifiedRef )
                    	    {
                    	    // InternalRosSystemParser.g:890:6: ( ruleQualifiedRef )
                    	    // InternalRosSystemParser.g:891:7: ruleQualifiedRef
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getSlotAttachmentRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getSlotAttachmentAccess().getPluginsPluginCrossReference_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    ruleQualifiedRef();

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
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getSlotAttachmentAccess().getRightSquareBracketKeyword_3());
              		
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
    // $ANTLR end "ruleSlotAttachment"


    // $ANTLR start "entryRuleRosInterface"
    // InternalRosSystemParser.g:915:1: entryRuleRosInterface returns [EObject current=null] : iv_ruleRosInterface= ruleRosInterface EOF ;
    public final EObject entryRuleRosInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosInterface = null;


        try {
            // InternalRosSystemParser.g:915:53: (iv_ruleRosInterface= ruleRosInterface EOF )
            // InternalRosSystemParser.g:916:2: iv_ruleRosInterface= ruleRosInterface EOF
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
    // InternalRosSystemParser.g:922:1: ruleRosInterface returns [EObject current=null] : (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? ) ;
    public final EObject ruleRosInterface() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_5=null;
        Token this_END_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_reference_4_0 = null;

        EObject lv_extensions_6_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:928:2: ( (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? ) )
            // InternalRosSystemParser.g:929:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? )
            {
            // InternalRosSystemParser.g:929:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? )
            // InternalRosSystemParser.g:930:3: otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )?
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosInterfaceAccess().getHyphenMinusKeyword_0());
              		
            }
            // InternalRosSystemParser.g:934:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)) ) {
                alt25=1;
            }
            else if ( (LA25_0==Slots) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalRosSystemParser.g:935:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:935:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:936:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:936:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:937:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:937:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:938:7: lv_name_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getRosInterfaceAccess().getNameEStringParserRuleCall_1_0_0_0());
                      						
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getRosInterfaceAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:961:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:961:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:962:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:962:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:963:6: lv_name_3_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosInterfaceAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_23);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosInterfaceRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_3_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:981:3: ( (lv_reference_4_0= ruleInterfaceReference ) )
            // InternalRosSystemParser.g:982:4: (lv_reference_4_0= ruleInterfaceReference )
            {
            // InternalRosSystemParser.g:982:4: (lv_reference_4_0= ruleInterfaceReference )
            // InternalRosSystemParser.g:983:5: lv_reference_4_0= ruleInterfaceReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosInterfaceAccess().getReferenceInterfaceReferenceParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_reference_4_0=ruleInterfaceReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosInterfaceRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_4_0,
              						"de.fraunhofer.ipa.rossystem.RosSystem.InterfaceReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:1000:3: (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_BEGIN) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalRosSystemParser.g:1001:4: this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END
                    {
                    this_BEGIN_5=(Token)match(input,RULE_BEGIN,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_5, grammarAccess.getRosInterfaceAccess().getBEGINTerminalRuleCall_3_0());
                      			
                    }
                    // InternalRosSystemParser.g:1005:4: ( (lv_extensions_6_0= ruleExtensionBlock ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==CommercialAt) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:1006:5: (lv_extensions_6_0= ruleExtensionBlock )
                    	    {
                    	    // InternalRosSystemParser.g:1006:5: (lv_extensions_6_0= ruleExtensionBlock )
                    	    // InternalRosSystemParser.g:1007:6: lv_extensions_6_0= ruleExtensionBlock
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getRosInterfaceAccess().getExtensionsExtensionBlockParserRuleCall_3_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_7);
                    	    lv_extensions_6_0=ruleExtensionBlock();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getRosInterfaceRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"extensions",
                    	      							lv_extensions_6_0,
                    	      							"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    this_END_7=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_7, grammarAccess.getRosInterfaceAccess().getENDTerminalRuleCall_3_2());
                      			
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
    // InternalRosSystemParser.g:1033:1: entryRuleInterfaceReference returns [EObject current=null] : iv_ruleInterfaceReference= ruleInterfaceReference EOF ;
    public final EObject entryRuleInterfaceReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceReference = null;


        try {
            // InternalRosSystemParser.g:1033:59: (iv_ruleInterfaceReference= ruleInterfaceReference EOF )
            // InternalRosSystemParser.g:1034:2: iv_ruleInterfaceReference= ruleInterfaceReference EOF
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
    // InternalRosSystemParser.g:1040:1: ruleInterfaceReference returns [EObject current=null] : (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference ) ;
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
            // InternalRosSystemParser.g:1046:2: ( (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference ) )
            // InternalRosSystemParser.g:1047:2: (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference )
            {
            // InternalRosSystemParser.g:1047:2: (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference )
            int alt28=6;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt28=1;
                }
                break;
            case Sub:
                {
                alt28=2;
                }
                break;
            case Ss:
                {
                alt28=3;
                }
                break;
            case Sc:
                {
                alt28=4;
                }
                break;
            case As:
                {
                alt28=5;
                }
                break;
            case Ac:
                {
                alt28=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalRosSystemParser.g:1048:3: this_RosPublisherReference_0= ruleRosPublisherReference
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
                    // InternalRosSystemParser.g:1057:3: this_RosSubscriberReference_1= ruleRosSubscriberReference
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
                    // InternalRosSystemParser.g:1066:3: this_RosServiceServerReference_2= ruleRosServiceServerReference
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
                    // InternalRosSystemParser.g:1075:3: this_RosServerClientReference_3= ruleRosServerClientReference
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
                    // InternalRosSystemParser.g:1084:3: this_RosActionServerReference_4= ruleRosActionServerReference
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
                    // InternalRosSystemParser.g:1093:3: this_RosActionClientReference_5= ruleRosActionClientReference
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
    // InternalRosSystemParser.g:1105:1: entryRuleRosPublisherReference returns [EObject current=null] : iv_ruleRosPublisherReference= ruleRosPublisherReference EOF ;
    public final EObject entryRuleRosPublisherReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosPublisherReference = null;


        try {
            // InternalRosSystemParser.g:1105:62: (iv_ruleRosPublisherReference= ruleRosPublisherReference EOF )
            // InternalRosSystemParser.g:1106:2: iv_ruleRosPublisherReference= ruleRosPublisherReference EOF
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
    // InternalRosSystemParser.g:1112:1: ruleRosPublisherReference returns [EObject current=null] : (otherlv_0= Pub () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosPublisherReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1118:2: ( (otherlv_0= Pub () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1119:2: (otherlv_0= Pub () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1119:2: (otherlv_0= Pub () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1120:3: otherlv_0= Pub () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Pub,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosPublisherReferenceAccess().getPubKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1124:3: ()
            // InternalRosSystemParser.g:1125:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosPublisherReferenceAccess().getRosPublisherReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1131:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1132:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1132:4: ( ruleEString )
            // InternalRosSystemParser.g:1133:5: ruleEString
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
    // InternalRosSystemParser.g:1151:1: entryRuleRosSubscriberReference returns [EObject current=null] : iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF ;
    public final EObject entryRuleRosSubscriberReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosSubscriberReference = null;


        try {
            // InternalRosSystemParser.g:1151:63: (iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF )
            // InternalRosSystemParser.g:1152:2: iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF
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
    // InternalRosSystemParser.g:1158:1: ruleRosSubscriberReference returns [EObject current=null] : (otherlv_0= Sub () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosSubscriberReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1164:2: ( (otherlv_0= Sub () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1165:2: (otherlv_0= Sub () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1165:2: (otherlv_0= Sub () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1166:3: otherlv_0= Sub () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Sub,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosSubscriberReferenceAccess().getSubKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1170:3: ()
            // InternalRosSystemParser.g:1171:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosSubscriberReferenceAccess().getRosSubscriberReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1177:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1178:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1178:4: ( ruleEString )
            // InternalRosSystemParser.g:1179:5: ruleEString
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
    // InternalRosSystemParser.g:1197:1: entryRuleRosServiceServerReference returns [EObject current=null] : iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF ;
    public final EObject entryRuleRosServiceServerReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServiceServerReference = null;


        try {
            // InternalRosSystemParser.g:1197:66: (iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF )
            // InternalRosSystemParser.g:1198:2: iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF
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
    // InternalRosSystemParser.g:1204:1: ruleRosServiceServerReference returns [EObject current=null] : (otherlv_0= Ss () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosServiceServerReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1210:2: ( (otherlv_0= Ss () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1211:2: (otherlv_0= Ss () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1211:2: (otherlv_0= Ss () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1212:3: otherlv_0= Ss () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Ss,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServiceServerReferenceAccess().getSsKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1216:3: ()
            // InternalRosSystemParser.g:1217:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosServiceServerReferenceAccess().getRosServiceServerReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1223:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1224:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1224:4: ( ruleEString )
            // InternalRosSystemParser.g:1225:5: ruleEString
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
    // InternalRosSystemParser.g:1243:1: entryRuleRosServerClientReference returns [EObject current=null] : iv_ruleRosServerClientReference= ruleRosServerClientReference EOF ;
    public final EObject entryRuleRosServerClientReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServerClientReference = null;


        try {
            // InternalRosSystemParser.g:1243:65: (iv_ruleRosServerClientReference= ruleRosServerClientReference EOF )
            // InternalRosSystemParser.g:1244:2: iv_ruleRosServerClientReference= ruleRosServerClientReference EOF
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
    // InternalRosSystemParser.g:1250:1: ruleRosServerClientReference returns [EObject current=null] : (otherlv_0= Sc () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosServerClientReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1256:2: ( (otherlv_0= Sc () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1257:2: (otherlv_0= Sc () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1257:2: (otherlv_0= Sc () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1258:3: otherlv_0= Sc () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Sc,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServerClientReferenceAccess().getScKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1262:3: ()
            // InternalRosSystemParser.g:1263:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosServerClientReferenceAccess().getRosServiceClientReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1269:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1270:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1270:4: ( ruleEString )
            // InternalRosSystemParser.g:1271:5: ruleEString
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
    // InternalRosSystemParser.g:1289:1: entryRuleRosActionServerReference returns [EObject current=null] : iv_ruleRosActionServerReference= ruleRosActionServerReference EOF ;
    public final EObject entryRuleRosActionServerReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionServerReference = null;


        try {
            // InternalRosSystemParser.g:1289:65: (iv_ruleRosActionServerReference= ruleRosActionServerReference EOF )
            // InternalRosSystemParser.g:1290:2: iv_ruleRosActionServerReference= ruleRosActionServerReference EOF
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
    // InternalRosSystemParser.g:1296:1: ruleRosActionServerReference returns [EObject current=null] : (otherlv_0= As () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosActionServerReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1302:2: ( (otherlv_0= As () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1303:2: (otherlv_0= As () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1303:2: (otherlv_0= As () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1304:3: otherlv_0= As () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,As,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionServerReferenceAccess().getAsKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1308:3: ()
            // InternalRosSystemParser.g:1309:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosActionServerReferenceAccess().getRosActionServerReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1315:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1316:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1316:4: ( ruleEString )
            // InternalRosSystemParser.g:1317:5: ruleEString
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
    // InternalRosSystemParser.g:1335:1: entryRuleRosActionClientReference returns [EObject current=null] : iv_ruleRosActionClientReference= ruleRosActionClientReference EOF ;
    public final EObject entryRuleRosActionClientReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionClientReference = null;


        try {
            // InternalRosSystemParser.g:1335:65: (iv_ruleRosActionClientReference= ruleRosActionClientReference EOF )
            // InternalRosSystemParser.g:1336:2: iv_ruleRosActionClientReference= ruleRosActionClientReference EOF
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
    // InternalRosSystemParser.g:1342:1: ruleRosActionClientReference returns [EObject current=null] : (otherlv_0= Ac () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosActionClientReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1348:2: ( (otherlv_0= Ac () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1349:2: (otherlv_0= Ac () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1349:2: (otherlv_0= Ac () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1350:3: otherlv_0= Ac () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Ac,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionClientReferenceAccess().getAcKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1354:3: ()
            // InternalRosSystemParser.g:1355:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosActionClientReferenceAccess().getRosActionClientReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1361:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1362:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1362:4: ( ruleEString )
            // InternalRosSystemParser.g:1363:5: ruleEString
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
    // InternalRosSystemParser.g:1381:1: entryRuleRosParameter returns [EObject current=null] : iv_ruleRosParameter= ruleRosParameter EOF ;
    public final EObject entryRuleRosParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosParameter = null;


        try {
            // InternalRosSystemParser.g:1381:53: (iv_ruleRosParameter= ruleRosParameter EOF )
            // InternalRosSystemParser.g:1382:2: iv_ruleRosParameter= ruleRosParameter EOF
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
    // InternalRosSystemParser.g:1388:1: ruleRosParameter returns [EObject current=null] : (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END ) ;
    public final EObject ruleRosParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_5=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_value_7_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1394:2: ( (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END ) )
            // InternalRosSystemParser.g:1395:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END )
            {
            // InternalRosSystemParser.g:1395:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END )
            // InternalRosSystemParser.g:1396:3: otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosParameterAccess().getHyphenMinusKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1400:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
                alt29=1;
            }
            else if ( (LA29_0==Slots) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalRosSystemParser.g:1401:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:1401:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:1402:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:1402:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:1403:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:1403:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:1404:7: lv_name_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getRosParameterAccess().getNameEStringParserRuleCall_1_0_0_0());
                      						
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

                      					newLeafNode(otherlv_2, grammarAccess.getRosParameterAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:1427:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:1427:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:1428:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:1428:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:1429:6: lv_name_3_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosParameterAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_6);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRosParameterRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_3_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:1447:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1448:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1448:4: ( ruleEString )
            // InternalRosSystemParser.g:1449:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosParameterRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosParameterAccess().getFromParameterCrossReference_2_0());
              				
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

            this_BEGIN_5=(Token)match(input,RULE_BEGIN,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_5, grammarAccess.getRosParameterAccess().getBEGINTerminalRuleCall_3());
              		
            }
            otherlv_6=(Token)match(input,Value_1,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getRosParameterAccess().getValueKeyword_4());
              		
            }
            // InternalRosSystemParser.g:1471:3: ( (lv_value_7_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:1472:4: (lv_value_7_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:1472:4: (lv_value_7_0= ruleParameterValue )
            // InternalRosSystemParser.g:1473:5: lv_value_7_0= ruleParameterValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosParameterAccess().getValueParameterValueParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_value_7_0=ruleParameterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRosParameterRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_7_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_8, grammarAccess.getRosParameterAccess().getENDTerminalRuleCall_6());
              		
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
    // InternalRosSystemParser.g:1498:1: entryRuleConnection returns [EObject current=null] : iv_ruleConnection= ruleConnection EOF ;
    public final EObject entryRuleConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnection = null;


        try {
            // InternalRosSystemParser.g:1498:51: (iv_ruleConnection= ruleConnection EOF )
            // InternalRosSystemParser.g:1499:2: iv_ruleConnection= ruleConnection EOF
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
    // InternalRosSystemParser.g:1505:1: ruleConnection returns [EObject current=null] : ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection ) ;
    public final EObject ruleConnection() throws RecognitionException {
        EObject current = null;

        EObject this_RosSystemConnection_0 = null;

        EObject this_RosConnection_1 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1511:2: ( ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection ) )
            // InternalRosSystemParser.g:1512:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )
            {
            // InternalRosSystemParser.g:1512:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // InternalRosSystemParser.g:1513:3: ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection )
                    {
                    // InternalRosSystemParser.g:1513:3: ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection )
                    // InternalRosSystemParser.g:1514:4: ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection
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
                    // InternalRosSystemParser.g:1525:3: this_RosConnection_1= ruleRosConnection
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
    // InternalRosSystemParser.g:1537:1: entryRuleRosSystemConnection returns [EObject current=null] : iv_ruleRosSystemConnection= ruleRosSystemConnection EOF ;
    public final EObject entryRuleRosSystemConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosSystemConnection = null;


        try {
            // InternalRosSystemParser.g:1537:60: (iv_ruleRosSystemConnection= ruleRosSystemConnection EOF )
            // InternalRosSystemParser.g:1538:2: iv_ruleRosSystemConnection= ruleRosSystemConnection EOF
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
    // InternalRosSystemParser.g:1544:1: ruleRosSystemConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosSystemConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1550:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1551:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1551:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1552:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosSystemConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosSystemConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1560:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1561:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1561:4: ( ruleEString )
            // InternalRosSystemParser.g:1562:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosSystemConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSystemConnectionAccess().getFromRosInterfaceCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_28);
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
            // InternalRosSystemParser.g:1580:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1581:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1581:4: ( ruleEString )
            // InternalRosSystemParser.g:1582:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosSystemConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSystemConnectionAccess().getToRosInterfaceCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_29);
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
    // InternalRosSystemParser.g:1604:1: entryRuleRosConnection returns [EObject current=null] : iv_ruleRosConnection= ruleRosConnection EOF ;
    public final EObject entryRuleRosConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosConnection = null;


        try {
            // InternalRosSystemParser.g:1604:54: (iv_ruleRosConnection= ruleRosConnection EOF )
            // InternalRosSystemParser.g:1605:2: iv_ruleRosConnection= ruleRosConnection EOF
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
    // InternalRosSystemParser.g:1611:1: ruleRosConnection returns [EObject current=null] : ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection ) ;
    public final EObject ruleRosConnection() throws RecognitionException {
        EObject current = null;

        EObject this_RosTopicConnection_0 = null;

        EObject this_RosServiceConnection_1 = null;

        EObject this_RosActionConnection_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1617:2: ( ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection ) )
            // InternalRosSystemParser.g:1618:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )
            {
            // InternalRosSystemParser.g:1618:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )
            int alt31=3;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // InternalRosSystemParser.g:1619:3: ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection )
                    {
                    // InternalRosSystemParser.g:1619:3: ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection )
                    // InternalRosSystemParser.g:1620:4: ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection
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
                    // InternalRosSystemParser.g:1631:3: ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection )
                    {
                    // InternalRosSystemParser.g:1631:3: ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection )
                    // InternalRosSystemParser.g:1632:4: ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection
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
                    // InternalRosSystemParser.g:1643:3: this_RosActionConnection_2= ruleRosActionConnection
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
    // InternalRosSystemParser.g:1655:1: entryRuleRosTopicConnection returns [EObject current=null] : iv_ruleRosTopicConnection= ruleRosTopicConnection EOF ;
    public final EObject entryRuleRosTopicConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosTopicConnection = null;


        try {
            // InternalRosSystemParser.g:1655:59: (iv_ruleRosTopicConnection= ruleRosTopicConnection EOF )
            // InternalRosSystemParser.g:1656:2: iv_ruleRosTopicConnection= ruleRosTopicConnection EOF
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
    // InternalRosSystemParser.g:1662:1: ruleRosTopicConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosTopicConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1668:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1669:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1669:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1670:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosTopicConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosTopicConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1678:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1679:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1679:4: ( ruleEString )
            // InternalRosSystemParser.g:1680:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosTopicConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosTopicConnectionAccess().getFromPublisherCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_28);
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
            // InternalRosSystemParser.g:1698:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1699:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1699:4: ( ruleEString )
            // InternalRosSystemParser.g:1700:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosTopicConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosTopicConnectionAccess().getToSubscriberCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_29);
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
    // InternalRosSystemParser.g:1722:1: entryRuleRosServiceConnection returns [EObject current=null] : iv_ruleRosServiceConnection= ruleRosServiceConnection EOF ;
    public final EObject entryRuleRosServiceConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServiceConnection = null;


        try {
            // InternalRosSystemParser.g:1722:61: (iv_ruleRosServiceConnection= ruleRosServiceConnection EOF )
            // InternalRosSystemParser.g:1723:2: iv_ruleRosServiceConnection= ruleRosServiceConnection EOF
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
    // InternalRosSystemParser.g:1729:1: ruleRosServiceConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosServiceConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1735:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1736:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1736:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1737:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServiceConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosServiceConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1745:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1746:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1746:4: ( ruleEString )
            // InternalRosSystemParser.g:1747:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServiceConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServiceConnectionAccess().getFromServiceServerCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_28);
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
            // InternalRosSystemParser.g:1765:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1766:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1766:4: ( ruleEString )
            // InternalRosSystemParser.g:1767:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServiceConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServiceConnectionAccess().getToServiceClientCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_29);
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
    // InternalRosSystemParser.g:1789:1: entryRuleRosActionConnection returns [EObject current=null] : iv_ruleRosActionConnection= ruleRosActionConnection EOF ;
    public final EObject entryRuleRosActionConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionConnection = null;


        try {
            // InternalRosSystemParser.g:1789:60: (iv_ruleRosActionConnection= ruleRosActionConnection EOF )
            // InternalRosSystemParser.g:1790:2: iv_ruleRosActionConnection= ruleRosActionConnection EOF
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
    // InternalRosSystemParser.g:1796:1: ruleRosActionConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosActionConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1802:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1803:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1803:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1804:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosActionConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1812:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1813:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1813:4: ( ruleEString )
            // InternalRosSystemParser.g:1814:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionConnectionAccess().getFromActionServerCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_28);
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
            // InternalRosSystemParser.g:1832:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1833:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1833:4: ( ruleEString )
            // InternalRosSystemParser.g:1834:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionConnectionAccess().getToActionClientCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_29);
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


    // $ANTLR start "entryRuleAddedKeywordName"
    // InternalRosSystemParser.g:1856:1: entryRuleAddedKeywordName returns [String current=null] : iv_ruleAddedKeywordName= ruleAddedKeywordName EOF ;
    public final String entryRuleAddedKeywordName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAddedKeywordName = null;


        try {
            // InternalRosSystemParser.g:1856:56: (iv_ruleAddedKeywordName= ruleAddedKeywordName EOF )
            // InternalRosSystemParser.g:1857:2: iv_ruleAddedKeywordName= ruleAddedKeywordName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddedKeywordNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAddedKeywordName=ruleAddedKeywordName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddedKeywordName.getText(); 
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
    // $ANTLR end "entryRuleAddedKeywordName"


    // $ANTLR start "ruleAddedKeywordName"
    // InternalRosSystemParser.g:1863:1: ruleAddedKeywordName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Slots ;
    public final AntlrDatatypeRuleToken ruleAddedKeywordName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1869:2: (kw= Slots )
            // InternalRosSystemParser.g:1870:2: kw= Slots
            {
            kw=(Token)match(input,Slots,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getSlotsKeyword());
              	
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
    // $ANTLR end "ruleAddedKeywordName"


    // $ANTLR start "entryRuleExtensionColonKey"
    // InternalRosSystemParser.g:1878:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRosSystemParser.g:1878:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRosSystemParser.g:1879:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
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
    // InternalRosSystemParser.g:1885:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1891:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces ) )
            // InternalRosSystemParser.g:1892:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces )
            {
            // InternalRosSystemParser.g:1892:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces )
            int alt32=14;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt32=1;
                }
                break;
            case Type_1:
                {
                alt32=2;
                }
                break;
            case Value_1:
                {
                alt32=3;
                }
                break;
            case Default:
                {
                alt32=4;
                }
                break;
            case FromFile:
                {
                alt32=5;
                }
                break;
            case SubSystems:
                {
                alt32=6;
                }
                break;
            case Processes:
                {
                alt32=7;
                }
                break;
            case Nodes:
                {
                alt32=8;
                }
                break;
            case Parameters:
                {
                alt32=9;
                }
                break;
            case Connections:
                {
                alt32=10;
                }
                break;
            case Threads:
                {
                alt32=11;
                }
                break;
            case From:
                {
                alt32=12;
                }
                break;
            case Namespace:
                {
                alt32=13;
                }
                break;
            case Interfaces:
                {
                alt32=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalRosSystemParser.g:1893:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:1899:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:1905:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:1911:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:1917:3: kw= FromFile
                    {
                    kw=(Token)match(input,FromFile,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromFileKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:1923:3: kw= SubSystems
                    {
                    kw=(Token)match(input,SubSystems,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubSystemsKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:1929:3: kw= Processes
                    {
                    kw=(Token)match(input,Processes,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getProcessesKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:1935:3: kw= Nodes
                    {
                    kw=(Token)match(input,Nodes,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodesKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:1941:3: kw= Parameters
                    {
                    kw=(Token)match(input,Parameters,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParametersKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:1947:3: kw= Connections
                    {
                    kw=(Token)match(input,Connections,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getConnectionsKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:1953:3: kw= Threads
                    {
                    kw=(Token)match(input,Threads,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getThreadsKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:1959:3: kw= From
                    {
                    kw=(Token)match(input,From,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:1965:3: kw= Namespace
                    {
                    kw=(Token)match(input,Namespace,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNamespaceKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:1971:3: kw= Interfaces
                    {
                    kw=(Token)match(input,Interfaces,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getInterfacesKeyword_13());
                      		
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
    // InternalRosSystemParser.g:1980:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRosSystemParser.g:1980:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRosSystemParser.g:1981:2: iv_ruleNamespace= ruleNamespace EOF
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
    // InternalRosSystemParser.g:1987:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1993:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRosSystemParser.g:1994:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRosSystemParser.g:1994:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt33=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt33=1;
                }
                break;
            case RelativeNamespace:
                {
                alt33=2;
                }
                break;
            case PrivateNamespace:
                {
                alt33=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalRosSystemParser.g:1995:3: this_GlobalNamespace_0= ruleGlobalNamespace
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
                    // InternalRosSystemParser.g:2004:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
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
                    // InternalRosSystemParser.g:2013:3: this_PrivateNamespace_2= rulePrivateNamespace
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
    // InternalRosSystemParser.g:2025:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRosSystemParser.g:2025:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRosSystemParser.g:2026:2: iv_ruleGraphName= ruleGraphName EOF
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
    // InternalRosSystemParser.g:2032:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:2038:2: (kw= GraphName )
            // InternalRosSystemParser.g:2039:2: kw= GraphName
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
    // InternalRosSystemParser.g:2047:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRosSystemParser.g:2047:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRosSystemParser.g:2048:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
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
    // InternalRosSystemParser.g:2054:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosSystemParser.g:2060:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:2061:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:2061:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:2062:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:2062:3: ()
            // InternalRosSystemParser.g:2063:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2073:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==LeftSquareBracket) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalRosSystemParser.g:2074:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2078:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:2079:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:2079:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:2080:6: lv_parts_3_0= ruleGraphName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
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

                    // InternalRosSystemParser.g:2097:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==Comma) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:2098:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:2102:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:2103:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:2103:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:2104:7: lv_parts_5_0= ruleGraphName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop34;
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
    // InternalRosSystemParser.g:2131:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRosSystemParser.g:2131:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRosSystemParser.g:2132:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
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
    // InternalRosSystemParser.g:2138:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosSystemParser.g:2144:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:2145:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:2145:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:2146:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:2146:3: ()
            // InternalRosSystemParser.g:2147:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2157:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==LeftSquareBracket) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalRosSystemParser.g:2158:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2162:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:2163:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:2163:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:2164:6: lv_parts_3_0= ruleGraphName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
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

                    // InternalRosSystemParser.g:2181:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==Comma) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:2182:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:2186:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:2187:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:2187:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:2188:7: lv_parts_5_0= ruleGraphName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop36;
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
    // InternalRosSystemParser.g:2215:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRosSystemParser.g:2215:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRosSystemParser.g:2216:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
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
    // InternalRosSystemParser.g:2222:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosSystemParser.g:2228:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:2229:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:2229:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:2230:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:2230:3: ()
            // InternalRosSystemParser.g:2231:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2241:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==LeftSquareBracket) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalRosSystemParser.g:2242:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2246:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:2247:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:2247:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:2248:6: lv_parts_3_0= ruleGraphName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
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

                    // InternalRosSystemParser.g:2265:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==Comma) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:2266:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_31); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:2270:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:2271:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:2271:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:2272:7: lv_parts_5_0= ruleGraphName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
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
                    	    break loop38;
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
    // InternalRosSystemParser.g:2299:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRosSystemParser.g:2299:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRosSystemParser.g:2300:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRosSystemParser.g:2306:1: ruleParameter returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token this_END_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_namespace_6_0 = null;

        EObject lv_type_8_0 = null;

        EObject lv_value_10_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2312:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) )
            // InternalRosSystemParser.g:2313:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            {
            // InternalRosSystemParser.g:2313:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            // InternalRosSystemParser.g:2314:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END
            {
            // InternalRosSystemParser.g:2314:3: ()
            // InternalRosSystemParser.g:2315:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterAccess().getParameterAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:2321:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)) ) {
                alt40=1;
            }
            else if ( (LA40_0==Slots) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalRosSystemParser.g:2322:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:2322:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:2323:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:2323:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:2324:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:2324:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:2325:7: lv_name_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0_0_0());
                      						
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

                      					newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:2348:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:2348:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:2349:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:2349:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:2350:6: lv_name_3_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_4);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_3_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_4, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_2());
              		
            }
            // InternalRosSystemParser.g:2372:3: (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Ns) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalRosSystemParser.g:2373:4: otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) )
                    {
                    otherlv_5=(Token)match(input,Ns,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getNsKeyword_3_0());
                      			
                    }
                    // InternalRosSystemParser.g:2377:4: ( (lv_namespace_6_0= ruleNamespace ) )
                    // InternalRosSystemParser.g:2378:5: (lv_namespace_6_0= ruleNamespace )
                    {
                    // InternalRosSystemParser.g:2378:5: (lv_namespace_6_0= ruleNamespace )
                    // InternalRosSystemParser.g:2379:6: lv_namespace_6_0= ruleNamespace
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
                    lv_namespace_6_0=ruleNamespace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterRule());
                      						}
                      						set(
                      							current,
                      							"namespace",
                      							lv_namespace_6_0,
                      							"de.fraunhofer.ipa.ros.Basics.Namespace");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,Type_1,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getTypeKeyword_4());
              		
            }
            // InternalRosSystemParser.g:2401:3: ( (lv_type_8_0= ruleParameterType ) )
            // InternalRosSystemParser.g:2402:4: (lv_type_8_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:2402:4: (lv_type_8_0= ruleParameterType )
            // InternalRosSystemParser.g:2403:5: lv_type_8_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_type_8_0=ruleParameterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_8_0,
              						"de.fraunhofer.ipa.ros.Basics.ParameterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRosSystemParser.g:2420:3: (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==Value_1) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRosSystemParser.g:2421:4: otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) )
                    {
                    otherlv_9=(Token)match(input,Value_1,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getValueKeyword_6_0());
                      			
                    }
                    // InternalRosSystemParser.g:2425:4: ( (lv_value_10_0= ruleParameterValue ) )
                    // InternalRosSystemParser.g:2426:5: (lv_value_10_0= ruleParameterValue )
                    {
                    // InternalRosSystemParser.g:2426:5: (lv_value_10_0= ruleParameterValue )
                    // InternalRosSystemParser.g:2427:6: lv_value_10_0= ruleParameterValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_value_10_0=ruleParameterValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_10_0,
                      							"de.fraunhofer.ipa.ros.Basics.ParameterValue");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_END_11=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_11, grammarAccess.getParameterAccess().getENDTerminalRuleCall_7());
              		
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
    // InternalRosSystemParser.g:2453:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRosSystemParser.g:2453:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRosSystemParser.g:2454:2: iv_ruleParameterType= ruleParameterType EOF
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
    // InternalRosSystemParser.g:2460:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
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
            // InternalRosSystemParser.g:2466:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRosSystemParser.g:2467:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRosSystemParser.g:2467:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt43=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt43=1;
                }
                break;
            case Struct:
                {
                alt43=2;
                }
                break;
            case Integer:
                {
                alt43=3;
                }
                break;
            case String:
                {
                alt43=4;
                }
                break;
            case Double:
                {
                alt43=5;
                }
                break;
            case Boolean:
                {
                alt43=6;
                }
                break;
            case Base64:
                {
                alt43=7;
                }
                break;
            case Array:
                {
                alt43=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalRosSystemParser.g:2468:3: this_ParameterListType_0= ruleParameterListType
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
                    // InternalRosSystemParser.g:2477:3: this_ParameterStructType_1= ruleParameterStructType
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
                    // InternalRosSystemParser.g:2486:3: this_ParameterIntegerType_2= ruleParameterIntegerType
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
                    // InternalRosSystemParser.g:2495:3: this_ParameterStringType_3= ruleParameterStringType
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
                    // InternalRosSystemParser.g:2504:3: this_ParameterDoubleType_4= ruleParameterDoubleType
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
                    // InternalRosSystemParser.g:2513:3: this_ParameterBooleanType_5= ruleParameterBooleanType
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
                    // InternalRosSystemParser.g:2522:3: this_ParameterBase64Type_6= ruleParameterBase64Type
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
                    // InternalRosSystemParser.g:2531:3: this_ParameterArrayType_7= ruleParameterArrayType
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
    // InternalRosSystemParser.g:2543:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRosSystemParser.g:2543:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRosSystemParser.g:2544:2: iv_ruleParameterValue= ruleParameterValue EOF
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
    // InternalRosSystemParser.g:2550:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
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
            // InternalRosSystemParser.g:2556:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRosSystemParser.g:2557:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRosSystemParser.g:2557:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt44=7;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // InternalRosSystemParser.g:2558:3: this_ParameterString_0= ruleParameterString
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
                    // InternalRosSystemParser.g:2567:3: this_ParameterBase64_1= ruleParameterBase64
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
                    // InternalRosSystemParser.g:2576:3: this_ParameterInteger_2= ruleParameterInteger
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
                    // InternalRosSystemParser.g:2585:3: this_ParameterDouble_3= ruleParameterDouble
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
                    // InternalRosSystemParser.g:2594:3: this_ParameterBoolean_4= ruleParameterBoolean
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
                    // InternalRosSystemParser.g:2603:3: this_ParameterList_5= ruleParameterList
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
                    // InternalRosSystemParser.g:2612:3: this_ParameterStruct_6= ruleParameterStruct
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
    // InternalRosSystemParser.g:2624:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRosSystemParser.g:2624:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRosSystemParser.g:2625:2: iv_ruleParameterListType= ruleParameterListType EOF
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
    // InternalRosSystemParser.g:2631:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosSystemParser.g:2637:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosSystemParser.g:2638:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosSystemParser.g:2638:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosSystemParser.g:2639:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosSystemParser.g:2639:3: ()
            // InternalRosSystemParser.g:2640:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,List,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalRosSystemParser.g:2654:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRosSystemParser.g:2655:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:2655:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRosSystemParser.g:2656:5: lv_sequence_3_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
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

            // InternalRosSystemParser.g:2673:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==Comma) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalRosSystemParser.g:2674:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:2678:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRosSystemParser.g:2679:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRosSystemParser.g:2679:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRosSystemParser.g:2680:6: lv_sequence_5_0= ruleParameterType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
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
            	    break loop45;
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
    // InternalRosSystemParser.g:2706:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRosSystemParser.g:2706:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRosSystemParser.g:2707:2: iv_ruleParameterStructType= ruleParameterStructType EOF
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
    // InternalRosSystemParser.g:2713:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosSystemParser.g:2719:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosSystemParser.g:2720:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosSystemParser.g:2720:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosSystemParser.g:2721:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosSystemParser.g:2721:3: ()
            // InternalRosSystemParser.g:2722:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalRosSystemParser.g:2736:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRosSystemParser.g:2737:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRosSystemParser.g:2737:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRosSystemParser.g:2738:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_13);
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

            // InternalRosSystemParser.g:2755:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==Comma) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalRosSystemParser.g:2756:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:2760:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRosSystemParser.g:2761:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRosSystemParser.g:2761:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRosSystemParser.g:2762:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
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
            	    break loop46;
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
    // InternalRosSystemParser.g:2788:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRosSystemParser.g:2788:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRosSystemParser.g:2789:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
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
    // InternalRosSystemParser.g:2795:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2801:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRosSystemParser.g:2802:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRosSystemParser.g:2802:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRosSystemParser.g:2803:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRosSystemParser.g:2803:3: ()
            // InternalRosSystemParser.g:2804:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2814:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Default) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRosSystemParser.g:2815:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2819:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRosSystemParser.g:2820:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRosSystemParser.g:2820:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRosSystemParser.g:2821:6: lv_default_3_0= ruleParameterInteger
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
    // InternalRosSystemParser.g:2843:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRosSystemParser.g:2843:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRosSystemParser.g:2844:2: iv_ruleParameterStringType= ruleParameterStringType EOF
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
    // InternalRosSystemParser.g:2850:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2856:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRosSystemParser.g:2857:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRosSystemParser.g:2857:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRosSystemParser.g:2858:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRosSystemParser.g:2858:3: ()
            // InternalRosSystemParser.g:2859:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,String,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2869:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Default) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRosSystemParser.g:2870:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2874:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRosSystemParser.g:2875:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRosSystemParser.g:2875:5: (lv_default_3_0= ruleParameterString )
                    // InternalRosSystemParser.g:2876:6: lv_default_3_0= ruleParameterString
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
    // InternalRosSystemParser.g:2898:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRosSystemParser.g:2898:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRosSystemParser.g:2899:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
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
    // InternalRosSystemParser.g:2905:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2911:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRosSystemParser.g:2912:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRosSystemParser.g:2912:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRosSystemParser.g:2913:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRosSystemParser.g:2913:3: ()
            // InternalRosSystemParser.g:2914:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2924:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Default) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalRosSystemParser.g:2925:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2929:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRosSystemParser.g:2930:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRosSystemParser.g:2930:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRosSystemParser.g:2931:6: lv_default_3_0= ruleParameterDouble
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
    // InternalRosSystemParser.g:2953:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRosSystemParser.g:2953:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRosSystemParser.g:2954:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
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
    // InternalRosSystemParser.g:2960:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2966:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRosSystemParser.g:2967:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRosSystemParser.g:2967:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRosSystemParser.g:2968:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRosSystemParser.g:2968:3: ()
            // InternalRosSystemParser.g:2969:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2979:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==Default) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRosSystemParser.g:2980:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2984:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRosSystemParser.g:2985:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRosSystemParser.g:2985:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRosSystemParser.g:2986:6: lv_default_3_0= ruleParameterBoolean
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
    // InternalRosSystemParser.g:3008:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRosSystemParser.g:3008:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRosSystemParser.g:3009:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
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
    // InternalRosSystemParser.g:3015:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3021:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRosSystemParser.g:3022:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRosSystemParser.g:3022:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRosSystemParser.g:3023:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRosSystemParser.g:3023:3: ()
            // InternalRosSystemParser.g:3024:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
              		
            }
            // InternalRosSystemParser.g:3034:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Default) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRosSystemParser.g:3035:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:3039:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRosSystemParser.g:3040:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRosSystemParser.g:3040:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRosSystemParser.g:3041:6: lv_default_3_0= ruleParameterBase64
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
    // InternalRosSystemParser.g:3063:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRosSystemParser.g:3063:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRosSystemParser.g:3064:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
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
    // InternalRosSystemParser.g:3070:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
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
            // InternalRosSystemParser.g:3076:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRosSystemParser.g:3077:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRosSystemParser.g:3077:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRosSystemParser.g:3078:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:3086:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRosSystemParser.g:3087:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:3087:4: (lv_type_2_0= ruleParameterType )
            // InternalRosSystemParser.g:3088:5: lv_type_2_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
              		
            }
            // InternalRosSystemParser.g:3109:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==Default) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRosSystemParser.g:3110:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                      			
                    }
                    // InternalRosSystemParser.g:3114:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRosSystemParser.g:3115:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRosSystemParser.g:3115:5: (lv_default_5_0= ruleParameterList )
                    // InternalRosSystemParser.g:3116:6: lv_default_5_0= ruleParameterList
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
    // InternalRosSystemParser.g:3138:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRosSystemParser.g:3138:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRosSystemParser.g:3139:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRosSystemParser.g:3145:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3151:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:3152:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:3152:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:3153:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRosSystemParser.g:3153:3: ()
            // InternalRosSystemParser.g:3154:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:3164:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:3165:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:3165:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosSystemParser.g:3166:5: lv_value_2_0= ruleParameterValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
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

            // InternalRosSystemParser.g:3183:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==Comma) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalRosSystemParser.g:3184:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:3188:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRosSystemParser.g:3189:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRosSystemParser.g:3189:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRosSystemParser.g:3190:6: lv_value_4_0= ruleParameterValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
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
            	    break loop53;
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
    // InternalRosSystemParser.g:3216:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRosSystemParser.g:3216:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRosSystemParser.g:3217:2: iv_ruleParameterAny= ruleParameterAny EOF
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
    // InternalRosSystemParser.g:3223:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3229:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRosSystemParser.g:3230:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRosSystemParser.g:3230:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRosSystemParser.g:3231:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRosSystemParser.g:3231:3: ()
            // InternalRosSystemParser.g:3232:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
              		
            }
            // InternalRosSystemParser.g:3242:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==Value) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRosSystemParser.g:3243:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:3247:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRosSystemParser.g:3248:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:3248:5: (lv_value_3_0= ruleEString )
                    // InternalRosSystemParser.g:3249:6: lv_value_3_0= ruleEString
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
    // InternalRosSystemParser.g:3271:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRosSystemParser.g:3271:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRosSystemParser.g:3272:2: iv_ruleParameterString= ruleParameterString EOF
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
    // InternalRosSystemParser.g:3278:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3284:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRosSystemParser.g:3285:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRosSystemParser.g:3285:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRosSystemParser.g:3286:3: (lv_value_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:3286:3: (lv_value_0_0= ruleEString )
            // InternalRosSystemParser.g:3287:4: lv_value_0_0= ruleEString
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
    // InternalRosSystemParser.g:3307:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRosSystemParser.g:3307:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRosSystemParser.g:3308:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
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
    // InternalRosSystemParser.g:3314:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3320:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRosSystemParser.g:3321:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRosSystemParser.g:3321:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRosSystemParser.g:3322:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRosSystemParser.g:3322:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRosSystemParser.g:3323:4: lv_value_0_0= ruleBase64Binary
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
    // InternalRosSystemParser.g:3343:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRosSystemParser.g:3343:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRosSystemParser.g:3344:2: iv_ruleParameterInteger= ruleParameterInteger EOF
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
    // InternalRosSystemParser.g:3350:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3356:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRosSystemParser.g:3357:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRosSystemParser.g:3357:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRosSystemParser.g:3358:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRosSystemParser.g:3358:3: (lv_value_0_0= ruleInteger0 )
            // InternalRosSystemParser.g:3359:4: lv_value_0_0= ruleInteger0
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
    // InternalRosSystemParser.g:3379:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRosSystemParser.g:3379:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRosSystemParser.g:3380:2: iv_ruleParameterDouble= ruleParameterDouble EOF
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
    // InternalRosSystemParser.g:3386:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3392:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRosSystemParser.g:3393:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRosSystemParser.g:3393:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRosSystemParser.g:3394:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRosSystemParser.g:3394:3: (lv_value_0_0= ruleDouble0 )
            // InternalRosSystemParser.g:3395:4: lv_value_0_0= ruleDouble0
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
    // InternalRosSystemParser.g:3415:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRosSystemParser.g:3415:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRosSystemParser.g:3416:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
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
    // InternalRosSystemParser.g:3422:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3428:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRosSystemParser.g:3429:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRosSystemParser.g:3429:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRosSystemParser.g:3430:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRosSystemParser.g:3430:3: (lv_value_0_0= ruleboolean0 )
            // InternalRosSystemParser.g:3431:4: lv_value_0_0= ruleboolean0
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
    // InternalRosSystemParser.g:3451:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRosSystemParser.g:3451:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRosSystemParser.g:3452:2: iv_ruleParameterStruct= ruleParameterStruct EOF
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
    // InternalRosSystemParser.g:3458:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3464:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRosSystemParser.g:3465:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRosSystemParser.g:3465:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRosSystemParser.g:3466:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRosSystemParser.g:3466:3: ()
            // InternalRosSystemParser.g:3467:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:3473:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==LeftSquareBracket) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRosSystemParser.g:3474:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                      			
                    }
                    // InternalRosSystemParser.g:3482:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==Slots||(LA55_0>=RULE_ID && LA55_0<=RULE_STRING)) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:3483:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRosSystemParser.g:3483:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRosSystemParser.g:3484:6: lv_value_3_0= ruleParameterStructMember
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_42);
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
                    	    break loop55;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_16); if (state.failed) return current;
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
    // InternalRosSystemParser.g:3514:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRosSystemParser.g:3514:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRosSystemParser.g:3515:2: iv_ruleParameterDate= ruleParameterDate EOF
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
    // InternalRosSystemParser.g:3521:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3527:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRosSystemParser.g:3528:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRosSystemParser.g:3528:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRosSystemParser.g:3529:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRosSystemParser.g:3529:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRosSystemParser.g:3530:4: lv_value_0_0= ruleDateTime0
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
    // InternalRosSystemParser.g:3550:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRosSystemParser.g:3550:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRosSystemParser.g:3551:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
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
    // InternalRosSystemParser.g:3557:1: ruleParameterStructMember returns [EObject current=null] : ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3563:2: ( ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) )
            // InternalRosSystemParser.g:3564:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            {
            // InternalRosSystemParser.g:3564:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            // InternalRosSystemParser.g:3565:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) )
            {
            // InternalRosSystemParser.g:3565:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=RULE_ID && LA57_0<=RULE_STRING)) ) {
                alt57=1;
            }
            else if ( (LA57_0==Slots) ) {
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
                    // InternalRosSystemParser.g:3566:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    {
                    // InternalRosSystemParser.g:3566:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    // InternalRosSystemParser.g:3567:5: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon
                    {
                    // InternalRosSystemParser.g:3567:5: ( (lv_name_0_0= ruleEString ) )
                    // InternalRosSystemParser.g:3568:6: (lv_name_0_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:3568:6: (lv_name_0_0= ruleEString )
                    // InternalRosSystemParser.g:3569:7: lv_name_0_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0_0_0());
                      						
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

                    otherlv_1=(Token)match(input,Colon,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_0_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:3592:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:3592:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:3593:5: (lv_name_2_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:3593:5: (lv_name_2_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:3594:6: lv_name_2_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameAddedKeywordNameParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    lv_name_2_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:3612:3: ( (lv_value_3_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:3613:4: (lv_value_3_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:3613:4: (lv_value_3_0= ruleParameterValue )
            // InternalRosSystemParser.g:3614:5: lv_value_3_0= ruleParameterValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleParameterValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_3_0,
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
    // InternalRosSystemParser.g:3635:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRosSystemParser.g:3635:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRosSystemParser.g:3636:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
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
    // InternalRosSystemParser.g:3642:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3648:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRosSystemParser.g:3649:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRosSystemParser.g:3649:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRosSystemParser.g:3650:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRosSystemParser.g:3650:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosSystemParser.g:3651:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:3651:4: (lv_name_0_0= ruleEString )
            // InternalRosSystemParser.g:3652:5: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_35);
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

            // InternalRosSystemParser.g:3669:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRosSystemParser.g:3670:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:3670:4: (lv_type_1_0= ruleParameterType )
            // InternalRosSystemParser.g:3671:5: lv_type_1_0= ruleParameterType
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
    // InternalRosSystemParser.g:3692:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRosSystemParser.g:3692:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRosSystemParser.g:3693:2: iv_ruleBase64Binary= ruleBase64Binary EOF
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
    // InternalRosSystemParser.g:3699:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3705:2: (this_BINARY_0= RULE_BINARY )
            // InternalRosSystemParser.g:3706:2: this_BINARY_0= RULE_BINARY
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
    // InternalRosSystemParser.g:3716:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRosSystemParser.g:3716:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRosSystemParser.g:3717:2: iv_ruleboolean0= ruleboolean0 EOF
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
    // InternalRosSystemParser.g:3723:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3729:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRosSystemParser.g:3730:2: this_BOOLEAN_0= RULE_BOOLEAN
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
    // InternalRosSystemParser.g:3740:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRosSystemParser.g:3740:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRosSystemParser.g:3741:2: iv_ruleDouble0= ruleDouble0 EOF
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
    // InternalRosSystemParser.g:3747:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3753:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRosSystemParser.g:3754:2: this_DOUBLE_0= RULE_DOUBLE
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
    // InternalRosSystemParser.g:3764:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRosSystemParser.g:3764:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRosSystemParser.g:3765:2: iv_ruleInteger0= ruleInteger0 EOF
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
    // InternalRosSystemParser.g:3771:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3777:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosSystemParser.g:3778:2: this_DECINT_0= RULE_DECINT
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
    // InternalRosSystemParser.g:3788:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRosSystemParser.g:3788:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRosSystemParser.g:3789:2: iv_ruleDateTime0= ruleDateTime0 EOF
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
    // InternalRosSystemParser.g:3795:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3801:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRosSystemParser.g:3802:2: this_DATE_TIME_0= RULE_DATE_TIME
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
    // InternalRosSystemParser.g:3812:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRosSystemParser.g:3812:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRosSystemParser.g:3813:2: iv_ruleAbstractType= ruleAbstractType EOF
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
    // InternalRosSystemParser.g:3819:1: ruleAbstractType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
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
            // InternalRosSystemParser.g:3825:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRosSystemParser.g:3826:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRosSystemParser.g:3826:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt58=33;
            alt58 = dfa58.predict(input);
            switch (alt58) {
                case 1 :
                    // InternalRosSystemParser.g:3827:3: this_bool_0= rulebool
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
                    // InternalRosSystemParser.g:3836:3: this_int8_1= ruleint8
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
                    // InternalRosSystemParser.g:3845:3: this_uint8_2= ruleuint8
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
                    // InternalRosSystemParser.g:3854:3: this_int16_3= ruleint16
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
                    // InternalRosSystemParser.g:3863:3: this_uint16_4= ruleuint16
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
                    // InternalRosSystemParser.g:3872:3: this_int32_5= ruleint32
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
                    // InternalRosSystemParser.g:3881:3: this_uint32_6= ruleuint32
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
                    // InternalRosSystemParser.g:3890:3: this_int64_7= ruleint64
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
                    // InternalRosSystemParser.g:3899:3: this_uint64_8= ruleuint64
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
                    // InternalRosSystemParser.g:3908:3: this_float32_9= rulefloat32
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
                    // InternalRosSystemParser.g:3917:3: this_float64_10= rulefloat64
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
                    // InternalRosSystemParser.g:3926:3: this_string0_11= rulestring0
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
                    // InternalRosSystemParser.g:3935:3: this_byte_12= rulebyte
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
                    // InternalRosSystemParser.g:3944:3: this_time_13= ruletime
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
                    // InternalRosSystemParser.g:3953:3: this_duration_14= ruleduration
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
                    // InternalRosSystemParser.g:3962:3: this_Header_15= ruleHeader
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
                    // InternalRosSystemParser.g:3971:3: this_boolArray_16= ruleboolArray
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
                    // InternalRosSystemParser.g:3980:3: this_int8Array_17= ruleint8Array
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
                    // InternalRosSystemParser.g:3989:3: this_uint8Array_18= ruleuint8Array
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
                    // InternalRosSystemParser.g:3998:3: this_int16Array_19= ruleint16Array
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
                    // InternalRosSystemParser.g:4007:3: this_uint16Array_20= ruleuint16Array
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
                    // InternalRosSystemParser.g:4016:3: this_int32Array_21= ruleint32Array
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
                    // InternalRosSystemParser.g:4025:3: this_uint32Array_22= ruleuint32Array
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
                    // InternalRosSystemParser.g:4034:3: this_int64Array_23= ruleint64Array
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
                    // InternalRosSystemParser.g:4043:3: this_uint64Array_24= ruleuint64Array
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
                    // InternalRosSystemParser.g:4052:3: this_float32Array_25= rulefloat32Array
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
                    // InternalRosSystemParser.g:4061:3: this_float64Array_26= rulefloat64Array
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
                    // InternalRosSystemParser.g:4070:3: this_string0Array_27= rulestring0Array
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
                    // InternalRosSystemParser.g:4079:3: this_byteArray_28= rulebyteArray
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
                    // InternalRosSystemParser.g:4088:3: this_SpecBaseRef_29= ruleSpecBaseRef
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
                    // InternalRosSystemParser.g:4097:3: this_ArraySpecRef_30= ruleArraySpecRef
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
                    // InternalRosSystemParser.g:4106:3: this_char_31= rulechar
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
                    // InternalRosSystemParser.g:4115:3: this_charArray_32= rulecharArray
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
    // InternalRosSystemParser.g:4127:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRosSystemParser.g:4127:45: (iv_rulebool= rulebool EOF )
            // InternalRosSystemParser.g:4128:2: iv_rulebool= rulebool EOF
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
    // InternalRosSystemParser.g:4134:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4140:2: ( ( () otherlv_1= Bool ) )
            // InternalRosSystemParser.g:4141:2: ( () otherlv_1= Bool )
            {
            // InternalRosSystemParser.g:4141:2: ( () otherlv_1= Bool )
            // InternalRosSystemParser.g:4142:3: () otherlv_1= Bool
            {
            // InternalRosSystemParser.g:4142:3: ()
            // InternalRosSystemParser.g:4143:4: 
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
    // InternalRosSystemParser.g:4157:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRosSystemParser.g:4157:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRosSystemParser.g:4158:2: iv_ruleint8= ruleint8 EOF
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
    // InternalRosSystemParser.g:4164:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4170:2: ( ( () otherlv_1= Int8 ) )
            // InternalRosSystemParser.g:4171:2: ( () otherlv_1= Int8 )
            {
            // InternalRosSystemParser.g:4171:2: ( () otherlv_1= Int8 )
            // InternalRosSystemParser.g:4172:3: () otherlv_1= Int8
            {
            // InternalRosSystemParser.g:4172:3: ()
            // InternalRosSystemParser.g:4173:4: 
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
    // InternalRosSystemParser.g:4187:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRosSystemParser.g:4187:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRosSystemParser.g:4188:2: iv_ruleuint8= ruleuint8 EOF
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
    // InternalRosSystemParser.g:4194:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4200:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRosSystemParser.g:4201:2: ( () otherlv_1= Uint8 )
            {
            // InternalRosSystemParser.g:4201:2: ( () otherlv_1= Uint8 )
            // InternalRosSystemParser.g:4202:3: () otherlv_1= Uint8
            {
            // InternalRosSystemParser.g:4202:3: ()
            // InternalRosSystemParser.g:4203:4: 
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
    // InternalRosSystemParser.g:4217:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRosSystemParser.g:4217:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRosSystemParser.g:4218:2: iv_ruleint16= ruleint16 EOF
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
    // InternalRosSystemParser.g:4224:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4230:2: ( ( () otherlv_1= Int16 ) )
            // InternalRosSystemParser.g:4231:2: ( () otherlv_1= Int16 )
            {
            // InternalRosSystemParser.g:4231:2: ( () otherlv_1= Int16 )
            // InternalRosSystemParser.g:4232:3: () otherlv_1= Int16
            {
            // InternalRosSystemParser.g:4232:3: ()
            // InternalRosSystemParser.g:4233:4: 
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
    // InternalRosSystemParser.g:4247:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRosSystemParser.g:4247:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRosSystemParser.g:4248:2: iv_ruleuint16= ruleuint16 EOF
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
    // InternalRosSystemParser.g:4254:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4260:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRosSystemParser.g:4261:2: ( () otherlv_1= Uint16 )
            {
            // InternalRosSystemParser.g:4261:2: ( () otherlv_1= Uint16 )
            // InternalRosSystemParser.g:4262:3: () otherlv_1= Uint16
            {
            // InternalRosSystemParser.g:4262:3: ()
            // InternalRosSystemParser.g:4263:4: 
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
    // InternalRosSystemParser.g:4277:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRosSystemParser.g:4277:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRosSystemParser.g:4278:2: iv_ruleint32= ruleint32 EOF
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
    // InternalRosSystemParser.g:4284:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4290:2: ( ( () otherlv_1= Int32 ) )
            // InternalRosSystemParser.g:4291:2: ( () otherlv_1= Int32 )
            {
            // InternalRosSystemParser.g:4291:2: ( () otherlv_1= Int32 )
            // InternalRosSystemParser.g:4292:3: () otherlv_1= Int32
            {
            // InternalRosSystemParser.g:4292:3: ()
            // InternalRosSystemParser.g:4293:4: 
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
    // InternalRosSystemParser.g:4307:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRosSystemParser.g:4307:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRosSystemParser.g:4308:2: iv_ruleuint32= ruleuint32 EOF
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
    // InternalRosSystemParser.g:4314:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4320:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRosSystemParser.g:4321:2: ( () otherlv_1= Uint32 )
            {
            // InternalRosSystemParser.g:4321:2: ( () otherlv_1= Uint32 )
            // InternalRosSystemParser.g:4322:3: () otherlv_1= Uint32
            {
            // InternalRosSystemParser.g:4322:3: ()
            // InternalRosSystemParser.g:4323:4: 
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
    // InternalRosSystemParser.g:4337:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRosSystemParser.g:4337:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRosSystemParser.g:4338:2: iv_ruleint64= ruleint64 EOF
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
    // InternalRosSystemParser.g:4344:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4350:2: ( ( () otherlv_1= Int64 ) )
            // InternalRosSystemParser.g:4351:2: ( () otherlv_1= Int64 )
            {
            // InternalRosSystemParser.g:4351:2: ( () otherlv_1= Int64 )
            // InternalRosSystemParser.g:4352:3: () otherlv_1= Int64
            {
            // InternalRosSystemParser.g:4352:3: ()
            // InternalRosSystemParser.g:4353:4: 
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
    // InternalRosSystemParser.g:4367:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRosSystemParser.g:4367:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRosSystemParser.g:4368:2: iv_ruleuint64= ruleuint64 EOF
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
    // InternalRosSystemParser.g:4374:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4380:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRosSystemParser.g:4381:2: ( () otherlv_1= Uint64 )
            {
            // InternalRosSystemParser.g:4381:2: ( () otherlv_1= Uint64 )
            // InternalRosSystemParser.g:4382:3: () otherlv_1= Uint64
            {
            // InternalRosSystemParser.g:4382:3: ()
            // InternalRosSystemParser.g:4383:4: 
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
    // InternalRosSystemParser.g:4397:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRosSystemParser.g:4397:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRosSystemParser.g:4398:2: iv_rulefloat32= rulefloat32 EOF
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
    // InternalRosSystemParser.g:4404:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4410:2: ( ( () otherlv_1= Float32 ) )
            // InternalRosSystemParser.g:4411:2: ( () otherlv_1= Float32 )
            {
            // InternalRosSystemParser.g:4411:2: ( () otherlv_1= Float32 )
            // InternalRosSystemParser.g:4412:3: () otherlv_1= Float32
            {
            // InternalRosSystemParser.g:4412:3: ()
            // InternalRosSystemParser.g:4413:4: 
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
    // InternalRosSystemParser.g:4427:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRosSystemParser.g:4427:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRosSystemParser.g:4428:2: iv_rulefloat64= rulefloat64 EOF
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
    // InternalRosSystemParser.g:4434:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4440:2: ( ( () otherlv_1= Float64 ) )
            // InternalRosSystemParser.g:4441:2: ( () otherlv_1= Float64 )
            {
            // InternalRosSystemParser.g:4441:2: ( () otherlv_1= Float64 )
            // InternalRosSystemParser.g:4442:3: () otherlv_1= Float64
            {
            // InternalRosSystemParser.g:4442:3: ()
            // InternalRosSystemParser.g:4443:4: 
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
    // InternalRosSystemParser.g:4457:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRosSystemParser.g:4457:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRosSystemParser.g:4458:2: iv_rulestring0= rulestring0 EOF
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
    // InternalRosSystemParser.g:4464:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4470:2: ( ( () otherlv_1= String_1 ) )
            // InternalRosSystemParser.g:4471:2: ( () otherlv_1= String_1 )
            {
            // InternalRosSystemParser.g:4471:2: ( () otherlv_1= String_1 )
            // InternalRosSystemParser.g:4472:3: () otherlv_1= String_1
            {
            // InternalRosSystemParser.g:4472:3: ()
            // InternalRosSystemParser.g:4473:4: 
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
    // InternalRosSystemParser.g:4487:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRosSystemParser.g:4487:45: (iv_rulechar= rulechar EOF )
            // InternalRosSystemParser.g:4488:2: iv_rulechar= rulechar EOF
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
    // InternalRosSystemParser.g:4494:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4500:2: ( ( () otherlv_1= Char ) )
            // InternalRosSystemParser.g:4501:2: ( () otherlv_1= Char )
            {
            // InternalRosSystemParser.g:4501:2: ( () otherlv_1= Char )
            // InternalRosSystemParser.g:4502:3: () otherlv_1= Char
            {
            // InternalRosSystemParser.g:4502:3: ()
            // InternalRosSystemParser.g:4503:4: 
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
    // InternalRosSystemParser.g:4517:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRosSystemParser.g:4517:45: (iv_rulebyte= rulebyte EOF )
            // InternalRosSystemParser.g:4518:2: iv_rulebyte= rulebyte EOF
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
    // InternalRosSystemParser.g:4524:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4530:2: ( ( () otherlv_1= Byte ) )
            // InternalRosSystemParser.g:4531:2: ( () otherlv_1= Byte )
            {
            // InternalRosSystemParser.g:4531:2: ( () otherlv_1= Byte )
            // InternalRosSystemParser.g:4532:3: () otherlv_1= Byte
            {
            // InternalRosSystemParser.g:4532:3: ()
            // InternalRosSystemParser.g:4533:4: 
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
    // InternalRosSystemParser.g:4547:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRosSystemParser.g:4547:45: (iv_ruletime= ruletime EOF )
            // InternalRosSystemParser.g:4548:2: iv_ruletime= ruletime EOF
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
    // InternalRosSystemParser.g:4554:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4560:2: ( ( () otherlv_1= Time ) )
            // InternalRosSystemParser.g:4561:2: ( () otherlv_1= Time )
            {
            // InternalRosSystemParser.g:4561:2: ( () otherlv_1= Time )
            // InternalRosSystemParser.g:4562:3: () otherlv_1= Time
            {
            // InternalRosSystemParser.g:4562:3: ()
            // InternalRosSystemParser.g:4563:4: 
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
    // InternalRosSystemParser.g:4577:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRosSystemParser.g:4577:49: (iv_ruleduration= ruleduration EOF )
            // InternalRosSystemParser.g:4578:2: iv_ruleduration= ruleduration EOF
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
    // InternalRosSystemParser.g:4584:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4590:2: ( ( () otherlv_1= Duration ) )
            // InternalRosSystemParser.g:4591:2: ( () otherlv_1= Duration )
            {
            // InternalRosSystemParser.g:4591:2: ( () otherlv_1= Duration )
            // InternalRosSystemParser.g:4592:3: () otherlv_1= Duration
            {
            // InternalRosSystemParser.g:4592:3: ()
            // InternalRosSystemParser.g:4593:4: 
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
    // InternalRosSystemParser.g:4607:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRosSystemParser.g:4607:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRosSystemParser.g:4608:2: iv_ruleboolArray= ruleboolArray EOF
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
    // InternalRosSystemParser.g:4614:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4620:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRosSystemParser.g:4621:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRosSystemParser.g:4621:2: ( () otherlv_1= Bool_1 )
            // InternalRosSystemParser.g:4622:3: () otherlv_1= Bool_1
            {
            // InternalRosSystemParser.g:4622:3: ()
            // InternalRosSystemParser.g:4623:4: 
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
    // InternalRosSystemParser.g:4637:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRosSystemParser.g:4637:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRosSystemParser.g:4638:2: iv_ruleint8Array= ruleint8Array EOF
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
    // InternalRosSystemParser.g:4644:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4650:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRosSystemParser.g:4651:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRosSystemParser.g:4651:2: ( () otherlv_1= Int8_1 )
            // InternalRosSystemParser.g:4652:3: () otherlv_1= Int8_1
            {
            // InternalRosSystemParser.g:4652:3: ()
            // InternalRosSystemParser.g:4653:4: 
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
    // InternalRosSystemParser.g:4667:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRosSystemParser.g:4667:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRosSystemParser.g:4668:2: iv_ruleuint8Array= ruleuint8Array EOF
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
    // InternalRosSystemParser.g:4674:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4680:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRosSystemParser.g:4681:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRosSystemParser.g:4681:2: ( () otherlv_1= Uint8_1 )
            // InternalRosSystemParser.g:4682:3: () otherlv_1= Uint8_1
            {
            // InternalRosSystemParser.g:4682:3: ()
            // InternalRosSystemParser.g:4683:4: 
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
    // InternalRosSystemParser.g:4697:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRosSystemParser.g:4697:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRosSystemParser.g:4698:2: iv_ruleint16Array= ruleint16Array EOF
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
    // InternalRosSystemParser.g:4704:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4710:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRosSystemParser.g:4711:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRosSystemParser.g:4711:2: ( () otherlv_1= Int16_1 )
            // InternalRosSystemParser.g:4712:3: () otherlv_1= Int16_1
            {
            // InternalRosSystemParser.g:4712:3: ()
            // InternalRosSystemParser.g:4713:4: 
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
    // InternalRosSystemParser.g:4727:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRosSystemParser.g:4727:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRosSystemParser.g:4728:2: iv_ruleuint16Array= ruleuint16Array EOF
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
    // InternalRosSystemParser.g:4734:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4740:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRosSystemParser.g:4741:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRosSystemParser.g:4741:2: ( () otherlv_1= Uint16_1 )
            // InternalRosSystemParser.g:4742:3: () otherlv_1= Uint16_1
            {
            // InternalRosSystemParser.g:4742:3: ()
            // InternalRosSystemParser.g:4743:4: 
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
    // InternalRosSystemParser.g:4757:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRosSystemParser.g:4757:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRosSystemParser.g:4758:2: iv_ruleint32Array= ruleint32Array EOF
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
    // InternalRosSystemParser.g:4764:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4770:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRosSystemParser.g:4771:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRosSystemParser.g:4771:2: ( () otherlv_1= Int32_1 )
            // InternalRosSystemParser.g:4772:3: () otherlv_1= Int32_1
            {
            // InternalRosSystemParser.g:4772:3: ()
            // InternalRosSystemParser.g:4773:4: 
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
    // InternalRosSystemParser.g:4787:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRosSystemParser.g:4787:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRosSystemParser.g:4788:2: iv_ruleuint32Array= ruleuint32Array EOF
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
    // InternalRosSystemParser.g:4794:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4800:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRosSystemParser.g:4801:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRosSystemParser.g:4801:2: ( () otherlv_1= Uint32_1 )
            // InternalRosSystemParser.g:4802:3: () otherlv_1= Uint32_1
            {
            // InternalRosSystemParser.g:4802:3: ()
            // InternalRosSystemParser.g:4803:4: 
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
    // InternalRosSystemParser.g:4817:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRosSystemParser.g:4817:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRosSystemParser.g:4818:2: iv_ruleint64Array= ruleint64Array EOF
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
    // InternalRosSystemParser.g:4824:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4830:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRosSystemParser.g:4831:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRosSystemParser.g:4831:2: ( () otherlv_1= Int64_1 )
            // InternalRosSystemParser.g:4832:3: () otherlv_1= Int64_1
            {
            // InternalRosSystemParser.g:4832:3: ()
            // InternalRosSystemParser.g:4833:4: 
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
    // InternalRosSystemParser.g:4847:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRosSystemParser.g:4847:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRosSystemParser.g:4848:2: iv_ruleuint64Array= ruleuint64Array EOF
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
    // InternalRosSystemParser.g:4854:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4860:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRosSystemParser.g:4861:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRosSystemParser.g:4861:2: ( () otherlv_1= Uint64_1 )
            // InternalRosSystemParser.g:4862:3: () otherlv_1= Uint64_1
            {
            // InternalRosSystemParser.g:4862:3: ()
            // InternalRosSystemParser.g:4863:4: 
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
    // InternalRosSystemParser.g:4877:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRosSystemParser.g:4877:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRosSystemParser.g:4878:2: iv_rulefloat32Array= rulefloat32Array EOF
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
    // InternalRosSystemParser.g:4884:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4890:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRosSystemParser.g:4891:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRosSystemParser.g:4891:2: ( () otherlv_1= Float32_1 )
            // InternalRosSystemParser.g:4892:3: () otherlv_1= Float32_1
            {
            // InternalRosSystemParser.g:4892:3: ()
            // InternalRosSystemParser.g:4893:4: 
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
    // InternalRosSystemParser.g:4907:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRosSystemParser.g:4907:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRosSystemParser.g:4908:2: iv_rulefloat64Array= rulefloat64Array EOF
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
    // InternalRosSystemParser.g:4914:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4920:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRosSystemParser.g:4921:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRosSystemParser.g:4921:2: ( () otherlv_1= Float64_1 )
            // InternalRosSystemParser.g:4922:3: () otherlv_1= Float64_1
            {
            // InternalRosSystemParser.g:4922:3: ()
            // InternalRosSystemParser.g:4923:4: 
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
    // InternalRosSystemParser.g:4937:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRosSystemParser.g:4937:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRosSystemParser.g:4938:2: iv_rulestring0Array= rulestring0Array EOF
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
    // InternalRosSystemParser.g:4944:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4950:2: ( ( () otherlv_1= String_2 ) )
            // InternalRosSystemParser.g:4951:2: ( () otherlv_1= String_2 )
            {
            // InternalRosSystemParser.g:4951:2: ( () otherlv_1= String_2 )
            // InternalRosSystemParser.g:4952:3: () otherlv_1= String_2
            {
            // InternalRosSystemParser.g:4952:3: ()
            // InternalRosSystemParser.g:4953:4: 
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
    // InternalRosSystemParser.g:4967:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRosSystemParser.g:4967:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRosSystemParser.g:4968:2: iv_rulebyteArray= rulebyteArray EOF
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
    // InternalRosSystemParser.g:4974:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4980:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRosSystemParser.g:4981:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRosSystemParser.g:4981:2: ( () otherlv_1= Byte_1 )
            // InternalRosSystemParser.g:4982:3: () otherlv_1= Byte_1
            {
            // InternalRosSystemParser.g:4982:3: ()
            // InternalRosSystemParser.g:4983:4: 
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
    // InternalRosSystemParser.g:4997:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRosSystemParser.g:4997:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRosSystemParser.g:4998:2: iv_rulecharArray= rulecharArray EOF
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
    // InternalRosSystemParser.g:5004:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5010:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRosSystemParser.g:5011:2: ( () otherlv_1= Char_1 )
            {
            // InternalRosSystemParser.g:5011:2: ( () otherlv_1= Char_1 )
            // InternalRosSystemParser.g:5012:3: () otherlv_1= Char_1
            {
            // InternalRosSystemParser.g:5012:3: ()
            // InternalRosSystemParser.g:5013:4: 
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
    // InternalRosSystemParser.g:5027:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRosSystemParser.g:5027:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRosSystemParser.g:5028:2: iv_ruleHeader= ruleHeader EOF
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
    // InternalRosSystemParser.g:5034:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5040:2: ( ( () otherlv_1= Header ) )
            // InternalRosSystemParser.g:5041:2: ( () otherlv_1= Header )
            {
            // InternalRosSystemParser.g:5041:2: ( () otherlv_1= Header )
            // InternalRosSystemParser.g:5042:3: () otherlv_1= Header
            {
            // InternalRosSystemParser.g:5042:3: ()
            // InternalRosSystemParser.g:5043:4: 
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
    // InternalRosSystemParser.g:5057:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRosSystemParser.g:5057:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRosSystemParser.g:5058:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
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
    // InternalRosSystemParser.g:5064:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5070:2: ( ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:5071:2: ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:5071:2: ( ( ruleEString ) )
            // InternalRosSystemParser.g:5072:3: ( ruleEString )
            {
            // InternalRosSystemParser.g:5072:3: ( ruleEString )
            // InternalRosSystemParser.g:5073:4: ruleEString
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
    // InternalRosSystemParser.g:5090:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRosSystemParser.g:5090:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRosSystemParser.g:5091:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
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
    // InternalRosSystemParser.g:5097:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5103:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRosSystemParser.g:5104:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRosSystemParser.g:5104:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRosSystemParser.g:5105:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRosSystemParser.g:5105:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:5106:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:5106:4: ( ruleEString )
            // InternalRosSystemParser.g:5107:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getArraySpecRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_43);
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
    // InternalRosSystemParser.g:5129:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRosSystemParser.g:5129:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRosSystemParser.g:5130:2: iv_ruleKEYWORD= ruleKEYWORD EOF
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
    // InternalRosSystemParser.g:5136:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5142:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRosSystemParser.g:5143:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRosSystemParser.g:5143:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt59=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt59=1;
                }
                break;
            case Message:
                {
                alt59=2;
                }
                break;
            case Result:
                {
                alt59=3;
                }
                break;
            case Feedback:
                {
                alt59=4;
                }
                break;
            case Name:
                {
                alt59=5;
                }
                break;
            case Value:
                {
                alt59=6;
                }
                break;
            case Service:
                {
                alt59=7;
                }
                break;
            case Type:
                {
                alt59=8;
                }
                break;
            case Action:
                {
                alt59=9;
                }
                break;
            case Duration:
                {
                alt59=10;
                }
                break;
            case Time:
                {
                alt59=11;
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
                    // InternalRosSystemParser.g:5144:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5150:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:5156:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:5162:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:5168:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:5174:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:5180:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:5186:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:5192:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:5198:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:5204:3: kw= Time
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
    // InternalRosSystemParser.g:5213:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRosSystemParser.g:5213:47: (iv_ruleEString= ruleEString EOF )
            // InternalRosSystemParser.g:5214:2: iv_ruleEString= ruleEString EOF
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
    // InternalRosSystemParser.g:5220:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5226:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRosSystemParser.g:5227:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRosSystemParser.g:5227:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_STRING) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_ID) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalRosSystemParser.g:5228:3: this_STRING_0= RULE_STRING
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
                    // InternalRosSystemParser.g:5236:3: this_ID_1= RULE_ID
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


    // $ANTLR start "entryRuleQualifiedRef"
    // InternalRosSystemParser.g:5247:1: entryRuleQualifiedRef returns [String current=null] : iv_ruleQualifiedRef= ruleQualifiedRef EOF ;
    public final String entryRuleQualifiedRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedRef = null;


        try {
            // InternalRosSystemParser.g:5247:52: (iv_ruleQualifiedRef= ruleQualifiedRef EOF )
            // InternalRosSystemParser.g:5248:2: iv_ruleQualifiedRef= ruleQualifiedRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedRef=ruleQualifiedRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedRef.getText(); 
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
    // $ANTLR end "entryRuleQualifiedRef"


    // $ANTLR start "ruleQualifiedRef"
    // InternalRosSystemParser.g:5254:1: ruleQualifiedRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;
        Token this_ID_3=null;
        Token this_DOUBLE_4=null;
        Token this_ID_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5260:2: ( (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) )
            // InternalRosSystemParser.g:5261:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            {
            // InternalRosSystemParser.g:5261:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_STRING) ) {
                alt63=1;
            }
            else if ( (LA63_0==RULE_ID) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalRosSystemParser.g:5262:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STRING_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_STRING_0, grammarAccess.getQualifiedRefAccess().getSTRINGTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5270:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    {
                    // InternalRosSystemParser.g:5270:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    // InternalRosSystemParser.g:5271:4: this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_1, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_0());
                      			
                    }
                    // InternalRosSystemParser.g:5278:4: ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    loop62:
                    do {
                        int alt62=3;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==FullStop) ) {
                            alt62=1;
                        }
                        else if ( (LA62_0==RULE_DOUBLE) ) {
                            alt62=2;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:5279:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    {
                    	    // InternalRosSystemParser.g:5279:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    // InternalRosSystemParser.g:5280:6: kw= FullStop this_ID_3= RULE_ID
                    	    {
                    	    kw=(Token)match(input,FullStop,FOLLOW_45); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						current.merge(kw);
                    	      						newLeafNode(kw, grammarAccess.getQualifiedRefAccess().getFullStopKeyword_1_1_0_0());
                    	      					
                    	    }
                    	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						current.merge(this_ID_3);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_ID_3, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_1_0_1());
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRosSystemParser.g:5294:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    {
                    	    // InternalRosSystemParser.g:5294:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    // InternalRosSystemParser.g:5295:6: this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )?
                    	    {
                    	    this_DOUBLE_4=(Token)match(input,RULE_DOUBLE,FOLLOW_46); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						current.merge(this_DOUBLE_4);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_DOUBLE_4, grammarAccess.getQualifiedRefAccess().getDOUBLETerminalRuleCall_1_1_1_0());
                    	      					
                    	    }
                    	    // InternalRosSystemParser.g:5302:6: (this_ID_5= RULE_ID )?
                    	    int alt61=2;
                    	    int LA61_0 = input.LA(1);

                    	    if ( (LA61_0==RULE_ID) ) {
                    	        alt61=1;
                    	    }
                    	    switch (alt61) {
                    	        case 1 :
                    	            // InternalRosSystemParser.g:5303:7: this_ID_5= RULE_ID
                    	            {
                    	            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							current.merge(this_ID_5);
                    	              						
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              							newLeafNode(this_ID_5, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_1_1_1());
                    	              						
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop62;
                        }
                    } while (true);


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
    // $ANTLR end "ruleQualifiedRef"


    // $ANTLR start "entryRuleExtensionBlock"
    // InternalRosSystemParser.g:5318:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRosSystemParser.g:5318:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRosSystemParser.g:5319:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
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
    // InternalRosSystemParser.g:5325:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
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
            // InternalRosSystemParser.g:5331:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRosSystemParser.g:5332:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRosSystemParser.g:5332:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRosSystemParser.g:5333:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRosSystemParser.g:5333:3: ()
            // InternalRosSystemParser.g:5334:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
              		
            }
            // InternalRosSystemParser.g:5344:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRosSystemParser.g:5345:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRosSystemParser.g:5345:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRosSystemParser.g:5346:5: lv_name_2_0= ruleExtensionBlockName
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

            otherlv_3=(Token)match(input,Colon,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
              		
            }
            // InternalRosSystemParser.g:5367:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt68=3;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_BEGIN) ) {
                alt68=1;
            }
            else if ( (LA68_0==LeftCurlyBracket) ) {
                alt68=2;
            }
            switch (alt68) {
                case 1 :
                    // InternalRosSystemParser.g:5368:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRosSystemParser.g:5368:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRosSystemParser.g:5369:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                      				
                    }
                    // InternalRosSystemParser.g:5373:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt64=0;
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( ((LA64_0>=Connections && LA64_0<=Processes)||(LA64_0>=FromFile && LA64_0<=Feedback)||LA64_0==Threads||(LA64_0>=Boolean && LA64_0<=Float64)||LA64_0==Message||LA64_0==Service||(LA64_0>=Base64 && LA64_0<=Action)||(LA64_0>=Nodes && LA64_0<=Int64)||(LA64_0>=Type_1 && LA64_0<=List)||(LA64_0>=Bool && LA64_0<=Node)||(LA64_0>=Time && LA64_0<=Ns)||(LA64_0>=RULE_ID && LA64_0<=RULE_STRING)) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:5374:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosSystemParser.g:5374:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRosSystemParser.g:5375:7: lv_entries_5_0= ruleExtensionEntry
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_49);
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
                    	    if ( cnt64 >= 1 ) break loop64;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(64, input);
                                throw eee;
                        }
                        cnt64++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5398:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRosSystemParser.g:5398:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRosSystemParser.g:5399:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                      				
                    }
                    // InternalRosSystemParser.g:5403:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( ((LA67_0>=Connections && LA67_0<=Processes)||(LA67_0>=FromFile && LA67_0<=Feedback)||LA67_0==Threads||(LA67_0>=Boolean && LA67_0<=Float64)||LA67_0==Message||LA67_0==Service||(LA67_0>=Base64 && LA67_0<=Action)||(LA67_0>=Nodes && LA67_0<=Int64)||(LA67_0>=Type_1 && LA67_0<=List)||(LA67_0>=Bool && LA67_0<=Node)||(LA67_0>=Time && LA67_0<=Ns)||(LA67_0>=RULE_ID && LA67_0<=RULE_STRING)) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // InternalRosSystemParser.g:5404:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRosSystemParser.g:5404:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRosSystemParser.g:5405:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRosSystemParser.g:5405:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRosSystemParser.g:5406:8: lv_entries_8_0= ruleExtensionEntry
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_51);
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

                            // InternalRosSystemParser.g:5423:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop66:
                            do {
                                int alt66=2;
                                int LA66_0 = input.LA(1);

                                if ( ((LA66_0>=Connections && LA66_0<=Processes)||(LA66_0>=FromFile && LA66_0<=Feedback)||LA66_0==Threads||(LA66_0>=Boolean && LA66_0<=Float64)||LA66_0==Message||LA66_0==Service||(LA66_0>=Base64 && LA66_0<=Action)||(LA66_0>=Nodes && LA66_0<=Int64)||(LA66_0>=Type_1 && LA66_0<=List)||(LA66_0>=Bool && LA66_0<=Node)||(LA66_0>=Time && LA66_0<=Ns)||LA66_0==Comma||(LA66_0>=RULE_ID && LA66_0<=RULE_STRING)) ) {
                                    alt66=1;
                                }


                                switch (alt66) {
                            	case 1 :
                            	    // InternalRosSystemParser.g:5424:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRosSystemParser.g:5424:7: (otherlv_9= Comma )?
                            	    int alt65=2;
                            	    int LA65_0 = input.LA(1);

                            	    if ( (LA65_0==Comma) ) {
                            	        alt65=1;
                            	    }
                            	    switch (alt65) {
                            	        case 1 :
                            	            // InternalRosSystemParser.g:5425:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_48); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	              							
                            	            }

                            	            }
                            	            break;

                            	    }

                            	    // InternalRosSystemParser.g:5430:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRosSystemParser.g:5431:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRosSystemParser.g:5431:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRosSystemParser.g:5432:9: lv_entries_10_0= ruleExtensionEntry
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_51);
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
                            	    break loop66;
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
    // InternalRosSystemParser.g:5461:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRosSystemParser.g:5461:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRosSystemParser.g:5462:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
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
    // InternalRosSystemParser.g:5468:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5474:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRosSystemParser.g:5475:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRosSystemParser.g:5475:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRosSystemParser.g:5476:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalRosSystemParser.g:5483:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==FullStop) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalRosSystemParser.g:5484:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_45); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_52); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop69;
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
    // InternalRosSystemParser.g:5501:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRosSystemParser.g:5501:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRosSystemParser.g:5502:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
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
    // InternalRosSystemParser.g:5508:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        AntlrDatatypeRuleToken lv_key_4_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5514:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) )
            // InternalRosSystemParser.g:5515:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            {
            // InternalRosSystemParser.g:5515:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            // InternalRosSystemParser.g:5516:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) )
            {
            // InternalRosSystemParser.g:5516:3: ()
            // InternalRosSystemParser.g:5517:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:5523:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) )
            int alt70=3;
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
                alt70=1;
                }
                break;
            case Connections:
            case Interfaces:
            case Parameters:
            case SubSystems:
            case Namespace:
            case Processes:
            case FromFile:
            case Default:
            case Threads:
            case Nodes:
            case Value_1:
            case From:
            case Type_1:
            case Ns:
                {
                alt70=2;
                }
                break;
            case Slots:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalRosSystemParser.g:5524:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:5524:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:5525:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:5525:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRosSystemParser.g:5526:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRosSystemParser.g:5526:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRosSystemParser.g:5527:7: lv_key_1_0= ruleExtensionKey
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:5550:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRosSystemParser.g:5550:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRosSystemParser.g:5551:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRosSystemParser.g:5551:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRosSystemParser.g:5552:6: lv_key_3_0= ruleExtensionColonKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_53);
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
                case 3 :
                    // InternalRosSystemParser.g:5570:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:5570:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:5571:5: (lv_key_4_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:5571:5: (lv_key_4_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:5572:6: lv_key_4_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyAddedKeywordNameParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_53);
                    lv_key_4_0=ruleAddedKeywordName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_4_0,
                      							"de.fraunhofer.ipa.rossystem.RosSystem.AddedKeywordName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:5590:3: ( (lv_value_5_0= ruleExtensionValue ) )
            // InternalRosSystemParser.g:5591:4: (lv_value_5_0= ruleExtensionValue )
            {
            // InternalRosSystemParser.g:5591:4: (lv_value_5_0= ruleExtensionValue )
            // InternalRosSystemParser.g:5592:5: lv_value_5_0= ruleExtensionValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtensionEntryAccess().getValueExtensionValueParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_5_0=ruleExtensionValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_5_0,
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
    // InternalRosSystemParser.g:5613:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRosSystemParser.g:5613:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRosSystemParser.g:5614:2: iv_ruleExtensionKey= ruleExtensionKey EOF
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
    // InternalRosSystemParser.g:5620:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5626:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRosSystemParser.g:5627:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRosSystemParser.g:5627:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt71=29;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt71=1;
                }
                break;
            case RULE_STRING:
                {
                alt71=2;
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
                alt71=3;
                }
                break;
            case Node:
                {
                alt71=4;
                }
                break;
            case String:
                {
                alt71=5;
                }
                break;
            case Integer:
                {
                alt71=6;
                }
                break;
            case Double:
                {
                alt71=7;
                }
                break;
            case Boolean:
                {
                alt71=8;
                }
                break;
            case Base64:
                {
                alt71=9;
                }
                break;
            case Array:
                {
                alt71=10;
                }
                break;
            case List:
                {
                alt71=11;
                }
                break;
            case Struct:
                {
                alt71=12;
                }
                break;
            case Date:
                {
                alt71=13;
                }
                break;
            case Any:
                {
                alt71=14;
                }
                break;
            case Bool:
                {
                alt71=15;
                }
                break;
            case Int8:
                {
                alt71=16;
                }
                break;
            case Uint8:
                {
                alt71=17;
                }
                break;
            case Int16:
                {
                alt71=18;
                }
                break;
            case Uint16:
                {
                alt71=19;
                }
                break;
            case Int32:
                {
                alt71=20;
                }
                break;
            case Uint32:
                {
                alt71=21;
                }
                break;
            case Int64:
                {
                alt71=22;
                }
                break;
            case Uint64:
                {
                alt71=23;
                }
                break;
            case Float32:
                {
                alt71=24;
                }
                break;
            case Float64:
                {
                alt71=25;
                }
                break;
            case String_1:
                {
                alt71=26;
                }
                break;
            case Char:
                {
                alt71=27;
                }
                break;
            case Byte:
                {
                alt71=28;
                }
                break;
            case Header:
                {
                alt71=29;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // InternalRosSystemParser.g:5628:3: this_ID_0= RULE_ID
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
                    // InternalRosSystemParser.g:5636:3: this_STRING_1= RULE_STRING
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
                    // InternalRosSystemParser.g:5644:3: this_KEYWORD_2= ruleKEYWORD
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
                    // InternalRosSystemParser.g:5655:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:5661:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:5667:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:5673:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:5679:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:5685:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:5691:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:5697:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:5703:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:5709:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:5715:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalRosSystemParser.g:5721:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalRosSystemParser.g:5727:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalRosSystemParser.g:5733:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalRosSystemParser.g:5739:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalRosSystemParser.g:5745:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalRosSystemParser.g:5751:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalRosSystemParser.g:5757:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalRosSystemParser.g:5763:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalRosSystemParser.g:5769:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalRosSystemParser.g:5775:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalRosSystemParser.g:5781:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalRosSystemParser.g:5787:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalRosSystemParser.g:5793:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_26());
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalRosSystemParser.g:5799:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_27());
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalRosSystemParser.g:5805:3: kw= Header
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
    // InternalRosSystemParser.g:5814:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRosSystemParser.g:5814:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRosSystemParser.g:5815:2: iv_ruleExtensionValue= ruleExtensionValue EOF
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
    // InternalRosSystemParser.g:5821:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5827:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRosSystemParser.g:5828:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRosSystemParser.g:5828:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt72=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt72=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt72=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt72=3;
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
                alt72=4;
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
                alt72=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalRosSystemParser.g:5829:3: this_ExtensionListValue_0= ruleExtensionListValue
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
                    // InternalRosSystemParser.g:5838:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
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
                    // InternalRosSystemParser.g:5847:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
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
                    // InternalRosSystemParser.g:5856:3: this_ExtensionRefValue_3= ruleExtensionRefValue
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
                    // InternalRosSystemParser.g:5865:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
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
    // InternalRosSystemParser.g:5877:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRosSystemParser.g:5877:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRosSystemParser.g:5878:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
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
    // InternalRosSystemParser.g:5884:1: ruleExtensionListValue returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleExtensionListValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_items_2_0 = null;

        EObject lv_items_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5890:2: ( ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:5891:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:5891:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:5892:3: () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket
            {
            // InternalRosSystemParser.g:5892:3: ()
            // InternalRosSystemParser.g:5893:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:5903:3: ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=Duration && LA75_0<=Feedback)||(LA75_0>=Boolean && LA75_0<=Float64)||(LA75_0>=Message && LA75_0<=Service)||(LA75_0>=Base64 && LA75_0<=Action)||LA75_0==Result||(LA75_0>=String_1 && LA75_0<=Uint64)||LA75_0==Array||(LA75_0>=Int16 && LA75_0<=Sub)||(LA75_0>=Uint8 && LA75_0<=Any)||LA75_0==LeftSquareBracket||LA75_0==LeftCurlyBracket||(LA75_0>=RULE_BOOLEAN && LA75_0<=RULE_DOUBLE)||(LA75_0>=RULE_ID && LA75_0<=RULE_INT)||LA75_0==RULE_BEGIN) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalRosSystemParser.g:5904:4: ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    {
                    // InternalRosSystemParser.g:5904:4: ( (lv_items_2_0= ruleExtensionValue ) )
                    // InternalRosSystemParser.g:5905:5: (lv_items_2_0= ruleExtensionValue )
                    {
                    // InternalRosSystemParser.g:5905:5: (lv_items_2_0= ruleExtensionValue )
                    // InternalRosSystemParser.g:5906:6: lv_items_2_0= ruleExtensionValue
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_55);
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

                    // InternalRosSystemParser.g:5923:4: ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( ((LA74_0>=Duration && LA74_0<=Feedback)||(LA74_0>=Boolean && LA74_0<=Float64)||(LA74_0>=Message && LA74_0<=Service)||(LA74_0>=Base64 && LA74_0<=Action)||LA74_0==Result||(LA74_0>=String_1 && LA74_0<=Uint64)||LA74_0==Array||(LA74_0>=Int16 && LA74_0<=Sub)||(LA74_0>=Uint8 && LA74_0<=Any)||LA74_0==Comma||LA74_0==LeftSquareBracket||LA74_0==LeftCurlyBracket||(LA74_0>=RULE_BOOLEAN && LA74_0<=RULE_DOUBLE)||(LA74_0>=RULE_ID && LA74_0<=RULE_INT)||LA74_0==RULE_BEGIN) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:5924:5: (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) )
                    	    {
                    	    // InternalRosSystemParser.g:5924:5: (otherlv_3= Comma )?
                    	    int alt73=2;
                    	    int LA73_0 = input.LA(1);

                    	    if ( (LA73_0==Comma) ) {
                    	        alt73=1;
                    	    }
                    	    switch (alt73) {
                    	        case 1 :
                    	            // InternalRosSystemParser.g:5925:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_53); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_3, grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosSystemParser.g:5930:5: ( (lv_items_4_0= ruleExtensionValue ) )
                    	    // InternalRosSystemParser.g:5931:6: (lv_items_4_0= ruleExtensionValue )
                    	    {
                    	    // InternalRosSystemParser.g:5931:6: (lv_items_4_0= ruleExtensionValue )
                    	    // InternalRosSystemParser.g:5932:7: lv_items_4_0= ruleExtensionValue
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_55);
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
                    	    break loop74;
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
    // InternalRosSystemParser.g:5959:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRosSystemParser.g:5959:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRosSystemParser.g:5960:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
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
    // InternalRosSystemParser.g:5966:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:5972:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRosSystemParser.g:5973:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRosSystemParser.g:5973:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRosSystemParser.g:5974:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRosSystemParser.g:5974:3: ()
            // InternalRosSystemParser.g:5975:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:5985:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=Connections && LA78_0<=Processes)||(LA78_0>=FromFile && LA78_0<=Feedback)||LA78_0==Threads||(LA78_0>=Boolean && LA78_0<=Float64)||LA78_0==Message||LA78_0==Service||(LA78_0>=Base64 && LA78_0<=Action)||(LA78_0>=Nodes && LA78_0<=Int64)||(LA78_0>=Type_1 && LA78_0<=List)||(LA78_0>=Bool && LA78_0<=Node)||(LA78_0>=Time && LA78_0<=Ns)||(LA78_0>=RULE_ID && LA78_0<=RULE_STRING)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalRosSystemParser.g:5986:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRosSystemParser.g:5986:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRosSystemParser.g:5987:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRosSystemParser.g:5987:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRosSystemParser.g:5988:6: lv_entries_2_0= ruleExtensionEntry
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_51);
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

                    // InternalRosSystemParser.g:6005:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( ((LA77_0>=Connections && LA77_0<=Processes)||(LA77_0>=FromFile && LA77_0<=Feedback)||LA77_0==Threads||(LA77_0>=Boolean && LA77_0<=Float64)||LA77_0==Message||LA77_0==Service||(LA77_0>=Base64 && LA77_0<=Action)||(LA77_0>=Nodes && LA77_0<=Int64)||(LA77_0>=Type_1 && LA77_0<=List)||(LA77_0>=Bool && LA77_0<=Node)||(LA77_0>=Time && LA77_0<=Ns)||LA77_0==Comma||(LA77_0>=RULE_ID && LA77_0<=RULE_STRING)) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:6006:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRosSystemParser.g:6006:5: (otherlv_3= Comma )?
                    	    int alt76=2;
                    	    int LA76_0 = input.LA(1);

                    	    if ( (LA76_0==Comma) ) {
                    	        alt76=1;
                    	    }
                    	    switch (alt76) {
                    	        case 1 :
                    	            // InternalRosSystemParser.g:6007:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_48); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosSystemParser.g:6012:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRosSystemParser.g:6013:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosSystemParser.g:6013:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRosSystemParser.g:6014:7: lv_entries_4_0= ruleExtensionEntry
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_51);
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
                    	    break loop77;
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
    // InternalRosSystemParser.g:6041:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRosSystemParser.g:6041:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRosSystemParser.g:6042:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
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
    // InternalRosSystemParser.g:6048:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6054:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRosSystemParser.g:6055:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRosSystemParser.g:6055:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRosSystemParser.g:6056:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRosSystemParser.g:6056:3: ()
            // InternalRosSystemParser.g:6057:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
              					current);
              			
            }

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
              		
            }
            // InternalRosSystemParser.g:6067:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt79=0;
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=Connections && LA79_0<=Processes)||(LA79_0>=FromFile && LA79_0<=Feedback)||LA79_0==Threads||(LA79_0>=Boolean && LA79_0<=Float64)||LA79_0==Message||LA79_0==Service||(LA79_0>=Base64 && LA79_0<=Action)||(LA79_0>=Nodes && LA79_0<=Int64)||(LA79_0>=Type_1 && LA79_0<=List)||(LA79_0>=Bool && LA79_0<=Node)||(LA79_0>=Time && LA79_0<=Ns)||(LA79_0>=RULE_ID && LA79_0<=RULE_STRING)) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalRosSystemParser.g:6068:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRosSystemParser.g:6068:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRosSystemParser.g:6069:5: lv_entries_2_0= ruleExtensionEntry
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    if ( cnt79 >= 1 ) break loop79;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(79, input);
                        throw eee;
                }
                cnt79++;
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
    // InternalRosSystemParser.g:6094:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRosSystemParser.g:6094:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRosSystemParser.g:6095:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
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
    // InternalRosSystemParser.g:6101:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
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
            // InternalRosSystemParser.g:6107:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:6108:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:6108:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:6109:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:6109:3: ()
            // InternalRosSystemParser.g:6110:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:6116:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRosSystemParser.g:6117:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRosSystemParser.g:6117:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRosSystemParser.g:6118:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRosSystemParser.g:6118:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt80=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt80=1;
                }
                break;
            case Sub:
                {
                alt80=2;
                }
                break;
            case Ss:
                {
                alt80=3;
                }
                break;
            case Sc:
                {
                alt80=4;
                }
                break;
            case As:
                {
                alt80=5;
                }
                break;
            case Ac:
                {
                alt80=6;
                }
                break;
            case Param:
                {
                alt80=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalRosSystemParser.g:6119:6: lv_refKind_1_1= Pub
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
                    // InternalRosSystemParser.g:6130:6: lv_refKind_1_2= Sub
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
                    // InternalRosSystemParser.g:6141:6: lv_refKind_1_3= Ss
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
                    // InternalRosSystemParser.g:6152:6: lv_refKind_1_4= Sc
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
                    // InternalRosSystemParser.g:6163:6: lv_refKind_1_5= As
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
                    // InternalRosSystemParser.g:6174:6: lv_refKind_1_6= Ac
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
                    // InternalRosSystemParser.g:6185:6: lv_refKind_1_7= Param
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

            // InternalRosSystemParser.g:6198:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:6199:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:6199:4: ( ruleEString )
            // InternalRosSystemParser.g:6200:5: ruleEString
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
    // InternalRosSystemParser.g:6218:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRosSystemParser.g:6218:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRosSystemParser.g:6219:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
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
    // InternalRosSystemParser.g:6225:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6231:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRosSystemParser.g:6232:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRosSystemParser.g:6232:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRosSystemParser.g:6233:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRosSystemParser.g:6233:3: ()
            // InternalRosSystemParser.g:6234:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:6240:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRosSystemParser.g:6241:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRosSystemParser.g:6241:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRosSystemParser.g:6242:5: lv_value_1_0= ruleExtensionScalarLiteral
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
    // InternalRosSystemParser.g:6263:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRosSystemParser.g:6263:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRosSystemParser.g:6264:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
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
    // InternalRosSystemParser.g:6270:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6276:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRosSystemParser.g:6277:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRosSystemParser.g:6277:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt81=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt81=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt81=2;
                }
                break;
            case RULE_DECINT:
                {
                alt81=3;
                }
                break;
            case RULE_INT:
                {
                alt81=4;
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
                alt81=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalRosSystemParser.g:6278:3: this_BOOLEAN_0= RULE_BOOLEAN
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
                    // InternalRosSystemParser.g:6286:3: this_DOUBLE_1= RULE_DOUBLE
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
                    // InternalRosSystemParser.g:6294:3: this_DECINT_2= RULE_DECINT
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
                    // InternalRosSystemParser.g:6302:3: this_INT_3= RULE_INT
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
                    // InternalRosSystemParser.g:6310:3: this_ExtensionKey_4= ruleExtensionKey
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
        // InternalRosSystemParser.g:1514:4: ( ruleRosSystemConnection )
        // InternalRosSystemParser.g:1514:5: ruleRosSystemConnection
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
        // InternalRosSystemParser.g:1620:4: ( ruleRosTopicConnection )
        // InternalRosSystemParser.g:1620:5: ruleRosTopicConnection
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
        // InternalRosSystemParser.g:1632:4: ( ruleRosServiceConnection )
        // InternalRosSystemParser.g:1632:5: ruleRosServiceConnection
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


    protected DFA30 dfa30 = new DFA30(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA58 dfa58 = new DFA58(this);
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

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1512:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_8 = input.LA(1);

                         
                        int index30_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalRosSystemParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index30_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
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

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1618:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_8 = input.LA(1);

                         
                        int index31_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRosSystemParser()) ) {s = 9;}

                        else if ( (synpred3_InternalRosSystemParser()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index31_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\1\10\2\11\10\uffff";
    static final String dfa_14s = "\3\61\4\uffff\1\123\3\uffff";
    static final String dfa_15s = "\3\154\4\uffff\1\153\3\uffff";
    static final String dfa_16s = "\3\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_17s = "\13\uffff}>";
    static final String[] dfa_18s = {
            "\1\10\41\uffff\1\10\4\uffff\1\7\1\10\3\uffff\1\3\1\6\1\4\1\5\6\uffff\1\2\1\1\3\uffff\1\10",
            "\1\11\41\uffff\1\11\2\uffff\1\10\2\uffff\1\11\15\uffff\2\11\3\uffff\1\11",
            "\1\11\41\uffff\1\11\2\uffff\1\10\2\uffff\1\11\15\uffff\2\11\3\uffff\1\11",
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

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_1;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "2557:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_19s = "\44\uffff";
    static final String dfa_20s = "\36\uffff\2\43\4\uffff";
    static final String dfa_21s = "\1\17\35\uffff\2\122\4\uffff";
    static final String dfa_22s = "\1\150\35\uffff\2\122\4\uffff";
    static final String dfa_23s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\40\1\41\1\37\1\36";
    static final String dfa_24s = "\44\uffff}>";
    static final String[] dfa_25s = {
            "\1\32\1\33\2\uffff\1\17\1\uffff\1\34\1\uffff\1\25\1\27\1\31\2\uffff\1\12\1\13\1\24\1\26\1\30\3\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\41\1\22\3\uffff\1\14\1\5\1\7\1\11\3\uffff\1\4\1\6\1\10\3\uffff\1\3\5\uffff\1\1\1\15\1\40\1\uffff\1\2\4\uffff\1\16\30\uffff\1\37\1\36",
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

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_19;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "3826:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000800000022D00L,0x0000100000800000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000800000002D00L,0x0000100000800000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000118000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0002000000000000L,0x0000118000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000100000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000800000400000L,0x0000100000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000002080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L,0x0000100000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0002800000003F00L,0x0000100000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0002800000002F00L,0x0000100000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000800000002F00L,0x0000100000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000018002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0002000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x3000000000000000L,0x0000000000003018L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000800000002D00L,0x0000000000800000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x00000181E1000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x4000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x008003600C000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0040000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0002000000000000L,0x0000018002000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000002L,0x0000000100200000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000002L,0x0000008100200000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000080004000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0xCFFF87EA3C5E3F00L,0x000001800003CFE7L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xCFFF87EA3C5E3F00L,0x000011800003CFE7L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0xCFFF87EA3C5E3F00L,0x000001800803CFE7L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0xCFFF87EA3C5E3F00L,0x00000180080BCFE7L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0xBEBD07EE3C180000L,0x00000B81C501FFFFL});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0xBEBD07EE3C180000L,0x00000B81C701FFFFL});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0xBEBD07EE3C180000L,0x00000B81C709FFFFL});

}