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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "ParameterAny", "Connections", "Interfaces", "Parameters", "SubSystems", "Namespace", "Processes", "GraphName", "Float32_2", "Float64_2", "FromFile", "Default", "Duration", "Feedback", "Float32_1", "Float64_1", "String_3", "Threads", "Uint16_2", "Uint32_2", "Uint64_2", "Boolean", "Integer", "Float32", "Float64", "Int16_2", "Int32_2", "Int64_2", "Message", "Param", "Service", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Uint8_2", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_2", "Byte_2", "Char_2", "Int16_1", "Int32_1", "Int64_1", "Int8_2", "Nodes", "Result", "Slots", "String_1", "Uint16", "Uint32", "Uint64", "Uint8_1", "Value_1", "Array", "Bool_1", "Byte_1", "Char_1", "From", "Int16", "Int32", "Int64", "Int8_1", "Pub", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LessThanSignEqualsSign", "LeftSquareBracketRightSquareBracket", "Comma", "HyphenMinus", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Connections=8;
    public static final int Float32_1=21;
    public static final int Float32_2=15;
    public static final int Node=89;
    public static final int Uint64_2=27;
    public static final int RULE_DATE_TIME=117;
    public static final int Uint64_1=41;
    public static final int String=46;
    public static final int Processes=13;
    public static final int Int16=70;
    public static final int SubSystems=11;
    public static final int Float32=30;
    public static final int Goal=86;
    public static final int Bool=83;
    public static final int Uint16=60;
    public static final int Boolean=28;
    public static final int Sub=75;
    public static final int Uint8=77;
    public static final int Parameters=10;
    public static final int RULE_ID=118;
    public static final int RULE_DIGIT=107;
    public static final int GlobalNamespace=6;
    public static final int Namespace=12;
    public static final int Int16_2=32;
    public static final int Int16_1=52;
    public static final int Header=45;
    public static final int RULE_INT=120;
    public static final int Byte=84;
    public static final int RULE_ML_COMMENT=127;
    public static final int LeftSquareBracket=103;
    public static final int Ac=81;
    public static final int Base64=43;
    public static final int Comma=98;
    public static final int As=82;
    public static final int HyphenMinus=99;
    public static final int RULE_MESSAGE_ASIGMENT=121;
    public static final int LeftSquareBracketRightSquareBracket=97;
    public static final int Int32=71;
    public static final int Char=85;
    public static final int LessThanSignEqualsSign=96;
    public static final int RightCurlyBracket=106;
    public static final int RULE_DECINT=110;
    public static final int Uint32=61;
    public static final int FullStop=100;
    public static final int RULE_HOUR=115;
    public static final int Int8_2=55;
    public static final int Int8=87;
    public static final int Default=18;
    public static final int Int8_1=73;
    public static final int CommercialAt=102;
    public static final int Uint16_1=39;
    public static final int Sc=90;
    public static final int Type=93;
    public static final int Uint16_2=25;
    public static final int Float64=31;
    public static final int Int32_1=53;
    public static final int Int32_2=33;
    public static final int RULE_BINARY=108;
    public static final int String_1=59;
    public static final int String_2=38;
    public static final int String_3=23;
    public static final int Ss=91;
    public static final int RULE_DAY=112;
    public static final int RULE_BEGIN=122;
    public static final int RULE_BOOLEAN=109;
    public static final int RelativeNamespace=4;
    public static final int RULE_YEAR=114;
    public static final int Result=57;
    public static final int Name=88;
    public static final int RULE_MIN_SEC=116;
    public static final int Char_1=68;
    public static final int Char_2=51;
    public static final int Int64_2=34;
    public static final int ParameterAny=7;
    public static final int List=80;
    public static final int RightSquareBracket=104;
    public static final int PrivateNamespace=5;
    public static final int GraphName=14;
    public static final int Byte_2=50;
    public static final int Byte_1=67;
    public static final int Float64_2=16;
    public static final int Float64_1=22;
    public static final int Duration=19;
    public static final int Uint32_1=40;
    public static final int Uint32_2=26;
    public static final int Double=44;
    public static final int Type_1=76;
    public static final int Value=78;
    public static final int Uint64=62;
    public static final int FromFile=17;
    public static final int Action=48;
    public static final int RULE_END=123;
    public static final int Message=35;
    public static final int Value_1=64;
    public static final int Time=92;
    public static final int RULE_STRING=119;
    public static final int Bool_1=66;
    public static final int Bool_2=49;
    public static final int Any=94;
    public static final int Struct=47;
    public static final int RULE_SL_COMMENT=124;
    public static final int Slots=58;
    public static final int Uint8_1=63;
    public static final int Uint8_2=42;
    public static final int RULE_DOUBLE=111;
    public static final int Feedback=20;
    public static final int RULE_ROS_CONVENTION_A=125;
    public static final int RULE_ROS_CONVENTION_PARAM=126;
    public static final int Colon=101;
    public static final int Pub=74;
    public static final int EOF=-1;
    public static final int Ns=95;
    public static final int RULE_WS=128;
    public static final int Int64_1=54;
    public static final int LeftCurlyBracket=105;
    public static final int Service=37;
    public static final int From=69;
    public static final int RULE_ANY_OTHER=129;
    public static final int Nodes=56;
    public static final int Date=79;
    public static final int Interfaces=9;
    public static final int Threads=24;
    public static final int Integer=29;
    public static final int Array=65;
    public static final int Int64=72;
    public static final int Param=36;
    public static final int RULE_MONTH=113;

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
    // InternalRosSystemParser.g:814:1: ruleSlotAttachment returns [EObject current=null] : ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) (otherlv_3= LeftSquareBracketRightSquareBracket | (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket ) ) ) ;
    public final EObject ruleSlotAttachment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:820:2: ( ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) (otherlv_3= LeftSquareBracketRightSquareBracket | (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket ) ) ) )
            // InternalRosSystemParser.g:821:2: ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) (otherlv_3= LeftSquareBracketRightSquareBracket | (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket ) ) )
            {
            // InternalRosSystemParser.g:821:2: ( ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) (otherlv_3= LeftSquareBracketRightSquareBracket | (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket ) ) )
            // InternalRosSystemParser.g:822:3: ( ( ( ( ruleEString ) ) otherlv_1= Colon ) | ( ( ruleAddedKeywordName ) ) ) (otherlv_3= LeftSquareBracketRightSquareBracket | (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket ) )
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

                    otherlv_1=(Token)match(input,Colon,FOLLOW_21); if (state.failed) return current;
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
                    pushFollow(FOLLOW_21);
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

            // InternalRosSystemParser.g:863:3: (otherlv_3= LeftSquareBracketRightSquareBracket | (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==LeftSquareBracketRightSquareBracket) ) {
                alt25=1;
            }
            else if ( (LA25_0==LeftSquareBracket) ) {
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
                    // InternalRosSystemParser.g:864:4: otherlv_3= LeftSquareBracketRightSquareBracket
                    {
                    otherlv_3=(Token)match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getSlotAttachmentAccess().getLeftSquareBracketRightSquareBracketKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:869:4: (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket )
                    {
                    // InternalRosSystemParser.g:869:4: (otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket )
                    // InternalRosSystemParser.g:870:5: otherlv_4= LeftSquareBracket ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )? otherlv_8= RightSquareBracket
                    {
                    otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getSlotAttachmentAccess().getLeftSquareBracketKeyword_1_1_0());
                      				
                    }
                    // InternalRosSystemParser.g:874:5: ( ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )* )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // InternalRosSystemParser.g:875:6: ( ( ruleQualifiedRef ) ) (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )*
                            {
                            // InternalRosSystemParser.g:875:6: ( ( ruleQualifiedRef ) )
                            // InternalRosSystemParser.g:876:7: ( ruleQualifiedRef )
                            {
                            // InternalRosSystemParser.g:876:7: ( ruleQualifiedRef )
                            // InternalRosSystemParser.g:877:8: ruleQualifiedRef
                            {
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getSlotAttachmentRule());
                              								}
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getSlotAttachmentAccess().getPluginsPluginCrossReference_1_1_1_0_0());
                              							
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

                            // InternalRosSystemParser.g:891:6: (otherlv_6= Comma ( ( ruleQualifiedRef ) ) )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==Comma) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // InternalRosSystemParser.g:892:7: otherlv_6= Comma ( ( ruleQualifiedRef ) )
                            	    {
                            	    otherlv_6=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_6, grammarAccess.getSlotAttachmentAccess().getCommaKeyword_1_1_1_1_0());
                            	      						
                            	    }
                            	    // InternalRosSystemParser.g:896:7: ( ( ruleQualifiedRef ) )
                            	    // InternalRosSystemParser.g:897:8: ( ruleQualifiedRef )
                            	    {
                            	    // InternalRosSystemParser.g:897:8: ( ruleQualifiedRef )
                            	    // InternalRosSystemParser.g:898:9: ruleQualifiedRef
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElement(grammarAccess.getSlotAttachmentRule());
                            	      									}
                            	      								
                            	    }
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getSlotAttachmentAccess().getPluginsPluginCrossReference_1_1_1_1_1_0());
                            	      								
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

                    otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getSlotAttachmentAccess().getRightSquareBracketKeyword_1_1_2());
                      				
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
    // $ANTLR end "ruleSlotAttachment"


    // $ANTLR start "entryRuleRosInterface"
    // InternalRosSystemParser.g:924:1: entryRuleRosInterface returns [EObject current=null] : iv_ruleRosInterface= ruleRosInterface EOF ;
    public final EObject entryRuleRosInterface() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosInterface = null;


        try {
            // InternalRosSystemParser.g:924:53: (iv_ruleRosInterface= ruleRosInterface EOF )
            // InternalRosSystemParser.g:925:2: iv_ruleRosInterface= ruleRosInterface EOF
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
    // InternalRosSystemParser.g:931:1: ruleRosInterface returns [EObject current=null] : (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? ) ;
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
            // InternalRosSystemParser.g:937:2: ( (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? ) )
            // InternalRosSystemParser.g:938:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? )
            {
            // InternalRosSystemParser.g:938:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )? )
            // InternalRosSystemParser.g:939:3: otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (lv_reference_4_0= ruleInterfaceReference ) ) (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )?
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosInterfaceAccess().getHyphenMinusKeyword_0());
              		
            }
            // InternalRosSystemParser.g:943:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_STRING)) ) {
                alt26=1;
            }
            else if ( (LA26_0==Slots) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalRosSystemParser.g:944:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:944:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:945:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:945:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:946:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:946:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:947:7: lv_name_1_0= ruleEString
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getRosInterfaceAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:970:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:970:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:971:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:971:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:972:6: lv_name_3_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRosInterfaceAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
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

            // InternalRosSystemParser.g:990:3: ( (lv_reference_4_0= ruleInterfaceReference ) )
            // InternalRosSystemParser.g:991:4: (lv_reference_4_0= ruleInterfaceReference )
            {
            // InternalRosSystemParser.g:991:4: (lv_reference_4_0= ruleInterfaceReference )
            // InternalRosSystemParser.g:992:5: lv_reference_4_0= ruleInterfaceReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosInterfaceAccess().getReferenceInterfaceReferenceParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_25);
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

            // InternalRosSystemParser.g:1009:3: (this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_BEGIN) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalRosSystemParser.g:1010:4: this_BEGIN_5= RULE_BEGIN ( (lv_extensions_6_0= ruleExtensionBlock ) )+ this_END_7= RULE_END
                    {
                    this_BEGIN_5=(Token)match(input,RULE_BEGIN,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_5, grammarAccess.getRosInterfaceAccess().getBEGINTerminalRuleCall_3_0());
                      			
                    }
                    // InternalRosSystemParser.g:1014:4: ( (lv_extensions_6_0= ruleExtensionBlock ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==CommercialAt) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:1015:5: (lv_extensions_6_0= ruleExtensionBlock )
                    	    {
                    	    // InternalRosSystemParser.g:1015:5: (lv_extensions_6_0= ruleExtensionBlock )
                    	    // InternalRosSystemParser.g:1016:6: lv_extensions_6_0= ruleExtensionBlock
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
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
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
    // InternalRosSystemParser.g:1042:1: entryRuleInterfaceReference returns [EObject current=null] : iv_ruleInterfaceReference= ruleInterfaceReference EOF ;
    public final EObject entryRuleInterfaceReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterfaceReference = null;


        try {
            // InternalRosSystemParser.g:1042:59: (iv_ruleInterfaceReference= ruleInterfaceReference EOF )
            // InternalRosSystemParser.g:1043:2: iv_ruleInterfaceReference= ruleInterfaceReference EOF
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
    // InternalRosSystemParser.g:1049:1: ruleInterfaceReference returns [EObject current=null] : (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference ) ;
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
            // InternalRosSystemParser.g:1055:2: ( (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference ) )
            // InternalRosSystemParser.g:1056:2: (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference )
            {
            // InternalRosSystemParser.g:1056:2: (this_RosPublisherReference_0= ruleRosPublisherReference | this_RosSubscriberReference_1= ruleRosSubscriberReference | this_RosServiceServerReference_2= ruleRosServiceServerReference | this_RosServerClientReference_3= ruleRosServerClientReference | this_RosActionServerReference_4= ruleRosActionServerReference | this_RosActionClientReference_5= ruleRosActionClientReference )
            int alt29=6;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt29=1;
                }
                break;
            case Sub:
                {
                alt29=2;
                }
                break;
            case Ss:
                {
                alt29=3;
                }
                break;
            case Sc:
                {
                alt29=4;
                }
                break;
            case As:
                {
                alt29=5;
                }
                break;
            case Ac:
                {
                alt29=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalRosSystemParser.g:1057:3: this_RosPublisherReference_0= ruleRosPublisherReference
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
                    // InternalRosSystemParser.g:1066:3: this_RosSubscriberReference_1= ruleRosSubscriberReference
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
                    // InternalRosSystemParser.g:1075:3: this_RosServiceServerReference_2= ruleRosServiceServerReference
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
                    // InternalRosSystemParser.g:1084:3: this_RosServerClientReference_3= ruleRosServerClientReference
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
                    // InternalRosSystemParser.g:1093:3: this_RosActionServerReference_4= ruleRosActionServerReference
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
                    // InternalRosSystemParser.g:1102:3: this_RosActionClientReference_5= ruleRosActionClientReference
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
    // InternalRosSystemParser.g:1114:1: entryRuleRosPublisherReference returns [EObject current=null] : iv_ruleRosPublisherReference= ruleRosPublisherReference EOF ;
    public final EObject entryRuleRosPublisherReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosPublisherReference = null;


        try {
            // InternalRosSystemParser.g:1114:62: (iv_ruleRosPublisherReference= ruleRosPublisherReference EOF )
            // InternalRosSystemParser.g:1115:2: iv_ruleRosPublisherReference= ruleRosPublisherReference EOF
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
    // InternalRosSystemParser.g:1121:1: ruleRosPublisherReference returns [EObject current=null] : (otherlv_0= Pub () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosPublisherReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1127:2: ( (otherlv_0= Pub () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1128:2: (otherlv_0= Pub () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1128:2: (otherlv_0= Pub () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1129:3: otherlv_0= Pub () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Pub,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosPublisherReferenceAccess().getPubKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1133:3: ()
            // InternalRosSystemParser.g:1134:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosPublisherReferenceAccess().getRosPublisherReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1140:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1141:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1141:4: ( ruleEString )
            // InternalRosSystemParser.g:1142:5: ruleEString
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
    // InternalRosSystemParser.g:1160:1: entryRuleRosSubscriberReference returns [EObject current=null] : iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF ;
    public final EObject entryRuleRosSubscriberReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosSubscriberReference = null;


        try {
            // InternalRosSystemParser.g:1160:63: (iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF )
            // InternalRosSystemParser.g:1161:2: iv_ruleRosSubscriberReference= ruleRosSubscriberReference EOF
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
    // InternalRosSystemParser.g:1167:1: ruleRosSubscriberReference returns [EObject current=null] : (otherlv_0= Sub () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosSubscriberReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1173:2: ( (otherlv_0= Sub () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1174:2: (otherlv_0= Sub () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1174:2: (otherlv_0= Sub () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1175:3: otherlv_0= Sub () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Sub,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosSubscriberReferenceAccess().getSubKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1179:3: ()
            // InternalRosSystemParser.g:1180:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosSubscriberReferenceAccess().getRosSubscriberReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1186:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1187:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1187:4: ( ruleEString )
            // InternalRosSystemParser.g:1188:5: ruleEString
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
    // InternalRosSystemParser.g:1206:1: entryRuleRosServiceServerReference returns [EObject current=null] : iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF ;
    public final EObject entryRuleRosServiceServerReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServiceServerReference = null;


        try {
            // InternalRosSystemParser.g:1206:66: (iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF )
            // InternalRosSystemParser.g:1207:2: iv_ruleRosServiceServerReference= ruleRosServiceServerReference EOF
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
    // InternalRosSystemParser.g:1213:1: ruleRosServiceServerReference returns [EObject current=null] : (otherlv_0= Ss () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosServiceServerReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1219:2: ( (otherlv_0= Ss () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1220:2: (otherlv_0= Ss () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1220:2: (otherlv_0= Ss () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1221:3: otherlv_0= Ss () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Ss,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServiceServerReferenceAccess().getSsKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1225:3: ()
            // InternalRosSystemParser.g:1226:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosServiceServerReferenceAccess().getRosServiceServerReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1232:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1233:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1233:4: ( ruleEString )
            // InternalRosSystemParser.g:1234:5: ruleEString
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
    // InternalRosSystemParser.g:1252:1: entryRuleRosServerClientReference returns [EObject current=null] : iv_ruleRosServerClientReference= ruleRosServerClientReference EOF ;
    public final EObject entryRuleRosServerClientReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServerClientReference = null;


        try {
            // InternalRosSystemParser.g:1252:65: (iv_ruleRosServerClientReference= ruleRosServerClientReference EOF )
            // InternalRosSystemParser.g:1253:2: iv_ruleRosServerClientReference= ruleRosServerClientReference EOF
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
    // InternalRosSystemParser.g:1259:1: ruleRosServerClientReference returns [EObject current=null] : (otherlv_0= Sc () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosServerClientReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1265:2: ( (otherlv_0= Sc () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1266:2: (otherlv_0= Sc () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1266:2: (otherlv_0= Sc () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1267:3: otherlv_0= Sc () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Sc,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServerClientReferenceAccess().getScKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1271:3: ()
            // InternalRosSystemParser.g:1272:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosServerClientReferenceAccess().getRosServiceClientReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1278:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1279:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1279:4: ( ruleEString )
            // InternalRosSystemParser.g:1280:5: ruleEString
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
    // InternalRosSystemParser.g:1298:1: entryRuleRosActionServerReference returns [EObject current=null] : iv_ruleRosActionServerReference= ruleRosActionServerReference EOF ;
    public final EObject entryRuleRosActionServerReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionServerReference = null;


        try {
            // InternalRosSystemParser.g:1298:65: (iv_ruleRosActionServerReference= ruleRosActionServerReference EOF )
            // InternalRosSystemParser.g:1299:2: iv_ruleRosActionServerReference= ruleRosActionServerReference EOF
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
    // InternalRosSystemParser.g:1305:1: ruleRosActionServerReference returns [EObject current=null] : (otherlv_0= As () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosActionServerReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1311:2: ( (otherlv_0= As () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1312:2: (otherlv_0= As () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1312:2: (otherlv_0= As () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1313:3: otherlv_0= As () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,As,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionServerReferenceAccess().getAsKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1317:3: ()
            // InternalRosSystemParser.g:1318:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosActionServerReferenceAccess().getRosActionServerReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1324:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1325:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1325:4: ( ruleEString )
            // InternalRosSystemParser.g:1326:5: ruleEString
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
    // InternalRosSystemParser.g:1344:1: entryRuleRosActionClientReference returns [EObject current=null] : iv_ruleRosActionClientReference= ruleRosActionClientReference EOF ;
    public final EObject entryRuleRosActionClientReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionClientReference = null;


        try {
            // InternalRosSystemParser.g:1344:65: (iv_ruleRosActionClientReference= ruleRosActionClientReference EOF )
            // InternalRosSystemParser.g:1345:2: iv_ruleRosActionClientReference= ruleRosActionClientReference EOF
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
    // InternalRosSystemParser.g:1351:1: ruleRosActionClientReference returns [EObject current=null] : (otherlv_0= Ac () ( ( ruleEString ) ) ) ;
    public final EObject ruleRosActionClientReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1357:2: ( (otherlv_0= Ac () ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:1358:2: (otherlv_0= Ac () ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:1358:2: (otherlv_0= Ac () ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:1359:3: otherlv_0= Ac () ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,Ac,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionClientReferenceAccess().getAcKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1363:3: ()
            // InternalRosSystemParser.g:1364:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRosActionClientReferenceAccess().getRosActionClientReferenceAction_1(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:1370:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1371:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1371:4: ( ruleEString )
            // InternalRosSystemParser.g:1372:5: ruleEString
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
    // InternalRosSystemParser.g:1390:1: entryRuleRosParameter returns [EObject current=null] : iv_ruleRosParameter= ruleRosParameter EOF ;
    public final EObject entryRuleRosParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosParameter = null;


        try {
            // InternalRosSystemParser.g:1390:53: (iv_ruleRosParameter= ruleRosParameter EOF )
            // InternalRosSystemParser.g:1391:2: iv_ruleRosParameter= ruleRosParameter EOF
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
    // InternalRosSystemParser.g:1397:1: ruleRosParameter returns [EObject current=null] : (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END ) ;
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
            // InternalRosSystemParser.g:1403:2: ( (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END ) )
            // InternalRosSystemParser.g:1404:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END )
            {
            // InternalRosSystemParser.g:1404:2: (otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END )
            // InternalRosSystemParser.g:1405:3: otherlv_0= HyphenMinus ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( ( ruleEString ) ) this_BEGIN_5= RULE_BEGIN otherlv_6= Value_1 ( (lv_value_7_0= ruleParameterValue ) ) this_END_8= RULE_END
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosParameterAccess().getHyphenMinusKeyword_0());
              		
            }
            // InternalRosSystemParser.g:1409:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
                alt30=1;
            }
            else if ( (LA30_0==Slots) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // InternalRosSystemParser.g:1410:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:1410:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:1411:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:1411:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:1412:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:1412:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:1413:7: lv_name_1_0= ruleEString
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
                    // InternalRosSystemParser.g:1436:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:1436:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:1437:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:1437:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:1438:6: lv_name_3_0= ruleAddedKeywordName
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

            // InternalRosSystemParser.g:1456:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1457:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1457:4: ( ruleEString )
            // InternalRosSystemParser.g:1458:5: ruleEString
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

            this_BEGIN_5=(Token)match(input,RULE_BEGIN,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_5, grammarAccess.getRosParameterAccess().getBEGINTerminalRuleCall_3());
              		
            }
            otherlv_6=(Token)match(input,Value_1,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getRosParameterAccess().getValueKeyword_4());
              		
            }
            // InternalRosSystemParser.g:1480:3: ( (lv_value_7_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:1481:4: (lv_value_7_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:1481:4: (lv_value_7_0= ruleParameterValue )
            // InternalRosSystemParser.g:1482:5: lv_value_7_0= ruleParameterValue
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
    // InternalRosSystemParser.g:1507:1: entryRuleConnection returns [EObject current=null] : iv_ruleConnection= ruleConnection EOF ;
    public final EObject entryRuleConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnection = null;


        try {
            // InternalRosSystemParser.g:1507:51: (iv_ruleConnection= ruleConnection EOF )
            // InternalRosSystemParser.g:1508:2: iv_ruleConnection= ruleConnection EOF
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
    // InternalRosSystemParser.g:1514:1: ruleConnection returns [EObject current=null] : ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection ) ;
    public final EObject ruleConnection() throws RecognitionException {
        EObject current = null;

        EObject this_RosSystemConnection_0 = null;

        EObject this_RosConnection_1 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1520:2: ( ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection ) )
            // InternalRosSystemParser.g:1521:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )
            {
            // InternalRosSystemParser.g:1521:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // InternalRosSystemParser.g:1522:3: ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection )
                    {
                    // InternalRosSystemParser.g:1522:3: ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection )
                    // InternalRosSystemParser.g:1523:4: ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection
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
                    // InternalRosSystemParser.g:1534:3: this_RosConnection_1= ruleRosConnection
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
    // InternalRosSystemParser.g:1546:1: entryRuleRosSystemConnection returns [EObject current=null] : iv_ruleRosSystemConnection= ruleRosSystemConnection EOF ;
    public final EObject entryRuleRosSystemConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosSystemConnection = null;


        try {
            // InternalRosSystemParser.g:1546:60: (iv_ruleRosSystemConnection= ruleRosSystemConnection EOF )
            // InternalRosSystemParser.g:1547:2: iv_ruleRosSystemConnection= ruleRosSystemConnection EOF
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
    // InternalRosSystemParser.g:1553:1: ruleRosSystemConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosSystemConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1559:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1560:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1560:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1561:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosSystemConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosSystemConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1569:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1570:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1570:4: ( ruleEString )
            // InternalRosSystemParser.g:1571:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosSystemConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSystemConnectionAccess().getFromRosInterfaceCrossReference_2_0());
              				
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

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosSystemConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1589:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1590:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1590:4: ( ruleEString )
            // InternalRosSystemParser.g:1591:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosSystemConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosSystemConnectionAccess().getToRosInterfaceCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_30);
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
    // InternalRosSystemParser.g:1613:1: entryRuleRosConnection returns [EObject current=null] : iv_ruleRosConnection= ruleRosConnection EOF ;
    public final EObject entryRuleRosConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosConnection = null;


        try {
            // InternalRosSystemParser.g:1613:54: (iv_ruleRosConnection= ruleRosConnection EOF )
            // InternalRosSystemParser.g:1614:2: iv_ruleRosConnection= ruleRosConnection EOF
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
    // InternalRosSystemParser.g:1620:1: ruleRosConnection returns [EObject current=null] : ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection ) ;
    public final EObject ruleRosConnection() throws RecognitionException {
        EObject current = null;

        EObject this_RosTopicConnection_0 = null;

        EObject this_RosServiceConnection_1 = null;

        EObject this_RosActionConnection_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:1626:2: ( ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection ) )
            // InternalRosSystemParser.g:1627:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )
            {
            // InternalRosSystemParser.g:1627:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )
            int alt32=3;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalRosSystemParser.g:1628:3: ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection )
                    {
                    // InternalRosSystemParser.g:1628:3: ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection )
                    // InternalRosSystemParser.g:1629:4: ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection
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
                    // InternalRosSystemParser.g:1640:3: ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection )
                    {
                    // InternalRosSystemParser.g:1640:3: ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection )
                    // InternalRosSystemParser.g:1641:4: ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection
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
                    // InternalRosSystemParser.g:1652:3: this_RosActionConnection_2= ruleRosActionConnection
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
    // InternalRosSystemParser.g:1664:1: entryRuleRosTopicConnection returns [EObject current=null] : iv_ruleRosTopicConnection= ruleRosTopicConnection EOF ;
    public final EObject entryRuleRosTopicConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosTopicConnection = null;


        try {
            // InternalRosSystemParser.g:1664:59: (iv_ruleRosTopicConnection= ruleRosTopicConnection EOF )
            // InternalRosSystemParser.g:1665:2: iv_ruleRosTopicConnection= ruleRosTopicConnection EOF
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
    // InternalRosSystemParser.g:1671:1: ruleRosTopicConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosTopicConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1677:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1678:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1678:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1679:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosTopicConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosTopicConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1687:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1688:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1688:4: ( ruleEString )
            // InternalRosSystemParser.g:1689:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosTopicConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosTopicConnectionAccess().getFromPublisherCrossReference_2_0());
              				
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

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosTopicConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1707:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1708:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1708:4: ( ruleEString )
            // InternalRosSystemParser.g:1709:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosTopicConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosTopicConnectionAccess().getToSubscriberCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_30);
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
    // InternalRosSystemParser.g:1731:1: entryRuleRosServiceConnection returns [EObject current=null] : iv_ruleRosServiceConnection= ruleRosServiceConnection EOF ;
    public final EObject entryRuleRosServiceConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosServiceConnection = null;


        try {
            // InternalRosSystemParser.g:1731:61: (iv_ruleRosServiceConnection= ruleRosServiceConnection EOF )
            // InternalRosSystemParser.g:1732:2: iv_ruleRosServiceConnection= ruleRosServiceConnection EOF
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
    // InternalRosSystemParser.g:1738:1: ruleRosServiceConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosServiceConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1744:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1745:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1745:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1746:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosServiceConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosServiceConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1754:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1755:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1755:4: ( ruleEString )
            // InternalRosSystemParser.g:1756:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServiceConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServiceConnectionAccess().getFromServiceServerCrossReference_2_0());
              				
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

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosServiceConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1774:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1775:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1775:4: ( ruleEString )
            // InternalRosSystemParser.g:1776:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosServiceConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosServiceConnectionAccess().getToServiceClientCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_30);
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
    // InternalRosSystemParser.g:1798:1: entryRuleRosActionConnection returns [EObject current=null] : iv_ruleRosActionConnection= ruleRosActionConnection EOF ;
    public final EObject entryRuleRosActionConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRosActionConnection = null;


        try {
            // InternalRosSystemParser.g:1798:60: (iv_ruleRosActionConnection= ruleRosActionConnection EOF )
            // InternalRosSystemParser.g:1799:2: iv_ruleRosActionConnection= ruleRosActionConnection EOF
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
    // InternalRosSystemParser.g:1805:1: ruleRosActionConnection returns [EObject current=null] : (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) ;
    public final EObject ruleRosActionConnection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1811:2: ( (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:1812:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:1812:2: (otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:1813:3: otherlv_0= HyphenMinus otherlv_1= LeftSquareBracket ( ( ruleEString ) ) otherlv_3= Comma ( ( ruleEString ) ) otherlv_5= RightSquareBracket
            {
            otherlv_0=(Token)match(input,HyphenMinus,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRosActionConnectionAccess().getHyphenMinusKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRosActionConnectionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:1821:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1822:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1822:4: ( ruleEString )
            // InternalRosSystemParser.g:1823:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionConnectionAccess().getFromActionServerCrossReference_2_0());
              				
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

            otherlv_3=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRosActionConnectionAccess().getCommaKeyword_3());
              		
            }
            // InternalRosSystemParser.g:1841:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:1842:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:1842:4: ( ruleEString )
            // InternalRosSystemParser.g:1843:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRosActionConnectionRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRosActionConnectionAccess().getToActionClientCrossReference_4_0());
              				
            }
            pushFollow(FOLLOW_30);
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
    // InternalRosSystemParser.g:1865:1: entryRuleAddedKeywordName returns [String current=null] : iv_ruleAddedKeywordName= ruleAddedKeywordName EOF ;
    public final String entryRuleAddedKeywordName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAddedKeywordName = null;


        try {
            // InternalRosSystemParser.g:1865:56: (iv_ruleAddedKeywordName= ruleAddedKeywordName EOF )
            // InternalRosSystemParser.g:1866:2: iv_ruleAddedKeywordName= ruleAddedKeywordName EOF
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
    // InternalRosSystemParser.g:1872:1: ruleAddedKeywordName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Slots ;
    public final AntlrDatatypeRuleToken ruleAddedKeywordName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1878:2: (kw= Slots )
            // InternalRosSystemParser.g:1879:2: kw= Slots
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
    // InternalRosSystemParser.g:1887:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRosSystemParser.g:1887:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRosSystemParser.g:1888:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
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
    // InternalRosSystemParser.g:1894:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:1900:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces ) )
            // InternalRosSystemParser.g:1901:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces )
            {
            // InternalRosSystemParser.g:1901:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromFile | kw= SubSystems | kw= Processes | kw= Nodes | kw= Parameters | kw= Connections | kw= Threads | kw= From | kw= Namespace | kw= Interfaces )
            int alt33=14;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt33=1;
                }
                break;
            case Type_1:
                {
                alt33=2;
                }
                break;
            case Value_1:
                {
                alt33=3;
                }
                break;
            case Default:
                {
                alt33=4;
                }
                break;
            case FromFile:
                {
                alt33=5;
                }
                break;
            case SubSystems:
                {
                alt33=6;
                }
                break;
            case Processes:
                {
                alt33=7;
                }
                break;
            case Nodes:
                {
                alt33=8;
                }
                break;
            case Parameters:
                {
                alt33=9;
                }
                break;
            case Connections:
                {
                alt33=10;
                }
                break;
            case Threads:
                {
                alt33=11;
                }
                break;
            case From:
                {
                alt33=12;
                }
                break;
            case Namespace:
                {
                alt33=13;
                }
                break;
            case Interfaces:
                {
                alt33=14;
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
                    // InternalRosSystemParser.g:1902:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:1908:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:1914:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:1920:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:1926:3: kw= FromFile
                    {
                    kw=(Token)match(input,FromFile,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromFileKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:1932:3: kw= SubSystems
                    {
                    kw=(Token)match(input,SubSystems,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubSystemsKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:1938:3: kw= Processes
                    {
                    kw=(Token)match(input,Processes,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getProcessesKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:1944:3: kw= Nodes
                    {
                    kw=(Token)match(input,Nodes,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodesKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:1950:3: kw= Parameters
                    {
                    kw=(Token)match(input,Parameters,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParametersKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:1956:3: kw= Connections
                    {
                    kw=(Token)match(input,Connections,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getConnectionsKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:1962:3: kw= Threads
                    {
                    kw=(Token)match(input,Threads,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getThreadsKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:1968:3: kw= From
                    {
                    kw=(Token)match(input,From,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:1974:3: kw= Namespace
                    {
                    kw=(Token)match(input,Namespace,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNamespaceKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:1980:3: kw= Interfaces
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
    // InternalRosSystemParser.g:1989:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRosSystemParser.g:1989:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRosSystemParser.g:1990:2: iv_ruleNamespace= ruleNamespace EOF
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
    // InternalRosSystemParser.g:1996:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2002:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRosSystemParser.g:2003:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRosSystemParser.g:2003:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt34=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt34=1;
                }
                break;
            case RelativeNamespace:
                {
                alt34=2;
                }
                break;
            case PrivateNamespace:
                {
                alt34=3;
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
                    // InternalRosSystemParser.g:2004:3: this_GlobalNamespace_0= ruleGlobalNamespace
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
                    // InternalRosSystemParser.g:2013:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
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
                    // InternalRosSystemParser.g:2022:3: this_PrivateNamespace_2= rulePrivateNamespace
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
    // InternalRosSystemParser.g:2034:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRosSystemParser.g:2034:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRosSystemParser.g:2035:2: iv_ruleGraphName= ruleGraphName EOF
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
    // InternalRosSystemParser.g:2041:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:2047:2: (kw= GraphName )
            // InternalRosSystemParser.g:2048:2: kw= GraphName
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
    // InternalRosSystemParser.g:2056:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRosSystemParser.g:2056:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRosSystemParser.g:2057:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
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
    // InternalRosSystemParser.g:2063:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosSystemParser.g:2069:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:2070:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:2070:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:2071:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:2071:3: ()
            // InternalRosSystemParser.g:2072:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2082:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==LeftSquareBracket) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalRosSystemParser.g:2083:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2087:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:2088:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:2088:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:2089:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRosSystemParser.g:2106:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==Comma) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:2107:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_32); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:2111:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:2112:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:2112:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:2113:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop35;
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
    // InternalRosSystemParser.g:2140:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRosSystemParser.g:2140:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRosSystemParser.g:2141:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
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
    // InternalRosSystemParser.g:2147:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosSystemParser.g:2153:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:2154:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:2154:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:2155:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:2155:3: ()
            // InternalRosSystemParser.g:2156:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2166:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==LeftSquareBracket) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalRosSystemParser.g:2167:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2171:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:2172:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:2172:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:2173:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRosSystemParser.g:2190:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==Comma) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:2191:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_32); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:2195:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:2196:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:2196:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:2197:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop37;
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
    // InternalRosSystemParser.g:2224:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRosSystemParser.g:2224:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRosSystemParser.g:2225:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
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
    // InternalRosSystemParser.g:2231:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosSystemParser.g:2237:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosSystemParser.g:2238:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosSystemParser.g:2238:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosSystemParser.g:2239:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosSystemParser.g:2239:3: ()
            // InternalRosSystemParser.g:2240:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2250:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==LeftSquareBracket) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalRosSystemParser.g:2251:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2255:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosSystemParser.g:2256:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosSystemParser.g:2256:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosSystemParser.g:2257:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRosSystemParser.g:2274:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==Comma) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:2275:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_32); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalRosSystemParser.g:2279:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosSystemParser.g:2280:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosSystemParser.g:2280:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosSystemParser.g:2281:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop39;
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
    // InternalRosSystemParser.g:2308:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRosSystemParser.g:2308:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRosSystemParser.g:2309:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRosSystemParser.g:2315:1: ruleParameter returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) ;
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
            // InternalRosSystemParser.g:2321:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) )
            // InternalRosSystemParser.g:2322:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            {
            // InternalRosSystemParser.g:2322:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            // InternalRosSystemParser.g:2323:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END
            {
            // InternalRosSystemParser.g:2323:3: ()
            // InternalRosSystemParser.g:2324:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterAccess().getParameterAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:2330:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)) ) {
                alt41=1;
            }
            else if ( (LA41_0==Slots) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalRosSystemParser.g:2331:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:2331:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:2332:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:2332:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosSystemParser.g:2333:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:2333:6: (lv_name_1_0= ruleEString )
                    // InternalRosSystemParser.g:2334:7: lv_name_1_0= ruleEString
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
                    // InternalRosSystemParser.g:2357:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:2357:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:2358:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:2358:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:2359:6: lv_name_3_0= ruleAddedKeywordName
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

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_4, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_2());
              		
            }
            // InternalRosSystemParser.g:2381:3: (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==Ns) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalRosSystemParser.g:2382:4: otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) )
                    {
                    otherlv_5=(Token)match(input,Ns,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getNsKeyword_3_0());
                      			
                    }
                    // InternalRosSystemParser.g:2386:4: ( (lv_namespace_6_0= ruleNamespace ) )
                    // InternalRosSystemParser.g:2387:5: (lv_namespace_6_0= ruleNamespace )
                    {
                    // InternalRosSystemParser.g:2387:5: (lv_namespace_6_0= ruleNamespace )
                    // InternalRosSystemParser.g:2388:6: lv_namespace_6_0= ruleNamespace
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_35);
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

            otherlv_7=(Token)match(input,Type_1,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getTypeKeyword_4());
              		
            }
            // InternalRosSystemParser.g:2410:3: ( (lv_type_8_0= ruleParameterType ) )
            // InternalRosSystemParser.g:2411:4: (lv_type_8_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:2411:4: (lv_type_8_0= ruleParameterType )
            // InternalRosSystemParser.g:2412:5: lv_type_8_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_37);
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

            // InternalRosSystemParser.g:2429:3: (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==Value_1) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalRosSystemParser.g:2430:4: otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) )
                    {
                    otherlv_9=(Token)match(input,Value_1,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getValueKeyword_6_0());
                      			
                    }
                    // InternalRosSystemParser.g:2434:4: ( (lv_value_10_0= ruleParameterValue ) )
                    // InternalRosSystemParser.g:2435:5: (lv_value_10_0= ruleParameterValue )
                    {
                    // InternalRosSystemParser.g:2435:5: (lv_value_10_0= ruleParameterValue )
                    // InternalRosSystemParser.g:2436:6: lv_value_10_0= ruleParameterValue
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
    // InternalRosSystemParser.g:2462:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRosSystemParser.g:2462:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRosSystemParser.g:2463:2: iv_ruleParameterType= ruleParameterType EOF
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
    // InternalRosSystemParser.g:2469:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
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
            // InternalRosSystemParser.g:2475:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRosSystemParser.g:2476:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRosSystemParser.g:2476:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt44=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt44=1;
                }
                break;
            case Struct:
                {
                alt44=2;
                }
                break;
            case Integer:
                {
                alt44=3;
                }
                break;
            case String:
                {
                alt44=4;
                }
                break;
            case Double:
                {
                alt44=5;
                }
                break;
            case Boolean:
                {
                alt44=6;
                }
                break;
            case Base64:
                {
                alt44=7;
                }
                break;
            case Array:
                {
                alt44=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalRosSystemParser.g:2477:3: this_ParameterListType_0= ruleParameterListType
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
                    // InternalRosSystemParser.g:2486:3: this_ParameterStructType_1= ruleParameterStructType
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
                    // InternalRosSystemParser.g:2495:3: this_ParameterIntegerType_2= ruleParameterIntegerType
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
                    // InternalRosSystemParser.g:2504:3: this_ParameterStringType_3= ruleParameterStringType
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
                    // InternalRosSystemParser.g:2513:3: this_ParameterDoubleType_4= ruleParameterDoubleType
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
                    // InternalRosSystemParser.g:2522:3: this_ParameterBooleanType_5= ruleParameterBooleanType
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
                    // InternalRosSystemParser.g:2531:3: this_ParameterBase64Type_6= ruleParameterBase64Type
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
                    // InternalRosSystemParser.g:2540:3: this_ParameterArrayType_7= ruleParameterArrayType
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
    // InternalRosSystemParser.g:2552:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRosSystemParser.g:2552:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRosSystemParser.g:2553:2: iv_ruleParameterValue= ruleParameterValue EOF
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
    // InternalRosSystemParser.g:2559:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
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
            // InternalRosSystemParser.g:2565:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRosSystemParser.g:2566:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRosSystemParser.g:2566:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt45=7;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // InternalRosSystemParser.g:2567:3: this_ParameterString_0= ruleParameterString
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
                    // InternalRosSystemParser.g:2576:3: this_ParameterBase64_1= ruleParameterBase64
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
                    // InternalRosSystemParser.g:2585:3: this_ParameterInteger_2= ruleParameterInteger
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
                    // InternalRosSystemParser.g:2594:3: this_ParameterDouble_3= ruleParameterDouble
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
                    // InternalRosSystemParser.g:2603:3: this_ParameterBoolean_4= ruleParameterBoolean
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
                    // InternalRosSystemParser.g:2612:3: this_ParameterList_5= ruleParameterList
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
                    // InternalRosSystemParser.g:2621:3: this_ParameterStruct_6= ruleParameterStruct
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
    // InternalRosSystemParser.g:2633:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRosSystemParser.g:2633:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRosSystemParser.g:2634:2: iv_ruleParameterListType= ruleParameterListType EOF
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
    // InternalRosSystemParser.g:2640:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosSystemParser.g:2646:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosSystemParser.g:2647:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosSystemParser.g:2647:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosSystemParser.g:2648:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosSystemParser.g:2648:3: ()
            // InternalRosSystemParser.g:2649:4: 
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
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalRosSystemParser.g:2663:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRosSystemParser.g:2664:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:2664:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRosSystemParser.g:2665:5: lv_sequence_3_0= ruleParameterType
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

            // InternalRosSystemParser.g:2682:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==Comma) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalRosSystemParser.g:2683:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:2687:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRosSystemParser.g:2688:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRosSystemParser.g:2688:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRosSystemParser.g:2689:6: lv_sequence_5_0= ruleParameterType
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
            	    break loop46;
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
    // InternalRosSystemParser.g:2715:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRosSystemParser.g:2715:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRosSystemParser.g:2716:2: iv_ruleParameterStructType= ruleParameterStructType EOF
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
    // InternalRosSystemParser.g:2722:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosSystemParser.g:2728:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosSystemParser.g:2729:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosSystemParser.g:2729:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosSystemParser.g:2730:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosSystemParser.g:2730:3: ()
            // InternalRosSystemParser.g:2731:4: 
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
            // InternalRosSystemParser.g:2745:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRosSystemParser.g:2746:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRosSystemParser.g:2746:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRosSystemParser.g:2747:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
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

            // InternalRosSystemParser.g:2764:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==Comma) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalRosSystemParser.g:2765:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:2769:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRosSystemParser.g:2770:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRosSystemParser.g:2770:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRosSystemParser.g:2771:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
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
            	    break loop47;
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
    // InternalRosSystemParser.g:2797:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRosSystemParser.g:2797:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRosSystemParser.g:2798:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
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
    // InternalRosSystemParser.g:2804:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2810:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRosSystemParser.g:2811:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRosSystemParser.g:2811:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRosSystemParser.g:2812:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRosSystemParser.g:2812:3: ()
            // InternalRosSystemParser.g:2813:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2823:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Default) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRosSystemParser.g:2824:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2828:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRosSystemParser.g:2829:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRosSystemParser.g:2829:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRosSystemParser.g:2830:6: lv_default_3_0= ruleParameterInteger
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
    // InternalRosSystemParser.g:2852:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRosSystemParser.g:2852:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRosSystemParser.g:2853:2: iv_ruleParameterStringType= ruleParameterStringType EOF
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
    // InternalRosSystemParser.g:2859:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2865:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRosSystemParser.g:2866:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRosSystemParser.g:2866:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRosSystemParser.g:2867:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRosSystemParser.g:2867:3: ()
            // InternalRosSystemParser.g:2868:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,String,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2878:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Default) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalRosSystemParser.g:2879:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2883:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRosSystemParser.g:2884:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRosSystemParser.g:2884:5: (lv_default_3_0= ruleParameterString )
                    // InternalRosSystemParser.g:2885:6: lv_default_3_0= ruleParameterString
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
    // InternalRosSystemParser.g:2907:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRosSystemParser.g:2907:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRosSystemParser.g:2908:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
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
    // InternalRosSystemParser.g:2914:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2920:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRosSystemParser.g:2921:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRosSystemParser.g:2921:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRosSystemParser.g:2922:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRosSystemParser.g:2922:3: ()
            // InternalRosSystemParser.g:2923:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2933:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==Default) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRosSystemParser.g:2934:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2938:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRosSystemParser.g:2939:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRosSystemParser.g:2939:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRosSystemParser.g:2940:6: lv_default_3_0= ruleParameterDouble
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
    // InternalRosSystemParser.g:2962:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRosSystemParser.g:2962:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRosSystemParser.g:2963:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
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
    // InternalRosSystemParser.g:2969:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:2975:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRosSystemParser.g:2976:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRosSystemParser.g:2976:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRosSystemParser.g:2977:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRosSystemParser.g:2977:3: ()
            // InternalRosSystemParser.g:2978:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
              		
            }
            // InternalRosSystemParser.g:2988:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Default) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRosSystemParser.g:2989:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_40); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:2993:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRosSystemParser.g:2994:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRosSystemParser.g:2994:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRosSystemParser.g:2995:6: lv_default_3_0= ruleParameterBoolean
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
    // InternalRosSystemParser.g:3017:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRosSystemParser.g:3017:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRosSystemParser.g:3018:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
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
    // InternalRosSystemParser.g:3024:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3030:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRosSystemParser.g:3031:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRosSystemParser.g:3031:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRosSystemParser.g:3032:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRosSystemParser.g:3032:3: ()
            // InternalRosSystemParser.g:3033:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
              		
            }
            // InternalRosSystemParser.g:3043:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==Default) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRosSystemParser.g:3044:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:3048:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRosSystemParser.g:3049:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRosSystemParser.g:3049:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRosSystemParser.g:3050:6: lv_default_3_0= ruleParameterBase64
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
    // InternalRosSystemParser.g:3072:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRosSystemParser.g:3072:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRosSystemParser.g:3073:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
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
    // InternalRosSystemParser.g:3079:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
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
            // InternalRosSystemParser.g:3085:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRosSystemParser.g:3086:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRosSystemParser.g:3086:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRosSystemParser.g:3087:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:3095:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRosSystemParser.g:3096:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:3096:4: (lv_type_2_0= ruleParameterType )
            // InternalRosSystemParser.g:3097:5: lv_type_2_0= ruleParameterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_30);
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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
              		
            }
            // InternalRosSystemParser.g:3118:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Default) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalRosSystemParser.g:3119:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                      			
                    }
                    // InternalRosSystemParser.g:3123:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRosSystemParser.g:3124:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRosSystemParser.g:3124:5: (lv_default_5_0= ruleParameterList )
                    // InternalRosSystemParser.g:3125:6: lv_default_5_0= ruleParameterList
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
    // InternalRosSystemParser.g:3147:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRosSystemParser.g:3147:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRosSystemParser.g:3148:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRosSystemParser.g:3154:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3160:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRosSystemParser.g:3161:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRosSystemParser.g:3161:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRosSystemParser.g:3162:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRosSystemParser.g:3162:3: ()
            // InternalRosSystemParser.g:3163:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:3173:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:3174:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:3174:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosSystemParser.g:3175:5: lv_value_2_0= ruleParameterValue
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

            // InternalRosSystemParser.g:3192:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==Comma) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalRosSystemParser.g:3193:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalRosSystemParser.g:3197:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRosSystemParser.g:3198:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRosSystemParser.g:3198:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRosSystemParser.g:3199:6: lv_value_4_0= ruleParameterValue
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
            	    break loop54;
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
    // InternalRosSystemParser.g:3225:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRosSystemParser.g:3225:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRosSystemParser.g:3226:2: iv_ruleParameterAny= ruleParameterAny EOF
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
    // InternalRosSystemParser.g:3232:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3238:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRosSystemParser.g:3239:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRosSystemParser.g:3239:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRosSystemParser.g:3240:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRosSystemParser.g:3240:3: ()
            // InternalRosSystemParser.g:3241:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
              		
            }
            // InternalRosSystemParser.g:3251:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==Value) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalRosSystemParser.g:3252:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                      			
                    }
                    // InternalRosSystemParser.g:3256:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRosSystemParser.g:3257:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:3257:5: (lv_value_3_0= ruleEString )
                    // InternalRosSystemParser.g:3258:6: lv_value_3_0= ruleEString
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
    // InternalRosSystemParser.g:3280:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRosSystemParser.g:3280:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRosSystemParser.g:3281:2: iv_ruleParameterString= ruleParameterString EOF
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
    // InternalRosSystemParser.g:3287:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3293:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRosSystemParser.g:3294:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRosSystemParser.g:3294:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRosSystemParser.g:3295:3: (lv_value_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:3295:3: (lv_value_0_0= ruleEString )
            // InternalRosSystemParser.g:3296:4: lv_value_0_0= ruleEString
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
    // InternalRosSystemParser.g:3316:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRosSystemParser.g:3316:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRosSystemParser.g:3317:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
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
    // InternalRosSystemParser.g:3323:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3329:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRosSystemParser.g:3330:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRosSystemParser.g:3330:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRosSystemParser.g:3331:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRosSystemParser.g:3331:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRosSystemParser.g:3332:4: lv_value_0_0= ruleBase64Binary
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
    // InternalRosSystemParser.g:3352:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRosSystemParser.g:3352:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRosSystemParser.g:3353:2: iv_ruleParameterInteger= ruleParameterInteger EOF
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
    // InternalRosSystemParser.g:3359:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3365:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRosSystemParser.g:3366:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRosSystemParser.g:3366:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRosSystemParser.g:3367:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRosSystemParser.g:3367:3: (lv_value_0_0= ruleInteger0 )
            // InternalRosSystemParser.g:3368:4: lv_value_0_0= ruleInteger0
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
    // InternalRosSystemParser.g:3388:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRosSystemParser.g:3388:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRosSystemParser.g:3389:2: iv_ruleParameterDouble= ruleParameterDouble EOF
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
    // InternalRosSystemParser.g:3395:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3401:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRosSystemParser.g:3402:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRosSystemParser.g:3402:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRosSystemParser.g:3403:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRosSystemParser.g:3403:3: (lv_value_0_0= ruleDouble0 )
            // InternalRosSystemParser.g:3404:4: lv_value_0_0= ruleDouble0
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
    // InternalRosSystemParser.g:3424:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRosSystemParser.g:3424:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRosSystemParser.g:3425:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
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
    // InternalRosSystemParser.g:3431:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3437:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRosSystemParser.g:3438:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRosSystemParser.g:3438:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRosSystemParser.g:3439:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRosSystemParser.g:3439:3: (lv_value_0_0= ruleboolean0 )
            // InternalRosSystemParser.g:3440:4: lv_value_0_0= ruleboolean0
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
    // InternalRosSystemParser.g:3460:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRosSystemParser.g:3460:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRosSystemParser.g:3461:2: iv_ruleParameterStruct= ruleParameterStruct EOF
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
    // InternalRosSystemParser.g:3467:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3473:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRosSystemParser.g:3474:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRosSystemParser.g:3474:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRosSystemParser.g:3475:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRosSystemParser.g:3475:3: ()
            // InternalRosSystemParser.g:3476:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:3482:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==LeftSquareBracket) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalRosSystemParser.g:3483:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                      			
                    }
                    // InternalRosSystemParser.g:3491:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==Slots||(LA56_0>=RULE_ID && LA56_0<=RULE_STRING)) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:3492:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRosSystemParser.g:3492:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRosSystemParser.g:3493:6: lv_value_3_0= ruleParameterStructMember
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_43);
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
                    	    break loop56;
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
    // InternalRosSystemParser.g:3523:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRosSystemParser.g:3523:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRosSystemParser.g:3524:2: iv_ruleParameterDate= ruleParameterDate EOF
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
    // InternalRosSystemParser.g:3530:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3536:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRosSystemParser.g:3537:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRosSystemParser.g:3537:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRosSystemParser.g:3538:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRosSystemParser.g:3538:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRosSystemParser.g:3539:4: lv_value_0_0= ruleDateTime0
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
    // InternalRosSystemParser.g:3559:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRosSystemParser.g:3559:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRosSystemParser.g:3560:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
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
    // InternalRosSystemParser.g:3566:1: ruleParameterStructMember returns [EObject current=null] : ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3572:2: ( ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) )
            // InternalRosSystemParser.g:3573:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            {
            // InternalRosSystemParser.g:3573:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            // InternalRosSystemParser.g:3574:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) )
            {
            // InternalRosSystemParser.g:3574:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_ID && LA58_0<=RULE_STRING)) ) {
                alt58=1;
            }
            else if ( (LA58_0==Slots) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalRosSystemParser.g:3575:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    {
                    // InternalRosSystemParser.g:3575:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    // InternalRosSystemParser.g:3576:5: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon
                    {
                    // InternalRosSystemParser.g:3576:5: ( (lv_name_0_0= ruleEString ) )
                    // InternalRosSystemParser.g:3577:6: (lv_name_0_0= ruleEString )
                    {
                    // InternalRosSystemParser.g:3577:6: (lv_name_0_0= ruleEString )
                    // InternalRosSystemParser.g:3578:7: lv_name_0_0= ruleEString
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

                    otherlv_1=(Token)match(input,Colon,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_0_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:3601:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:3601:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:3602:5: (lv_name_2_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:3602:5: (lv_name_2_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:3603:6: lv_name_2_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameAddedKeywordNameParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_28);
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

            // InternalRosSystemParser.g:3621:3: ( (lv_value_3_0= ruleParameterValue ) )
            // InternalRosSystemParser.g:3622:4: (lv_value_3_0= ruleParameterValue )
            {
            // InternalRosSystemParser.g:3622:4: (lv_value_3_0= ruleParameterValue )
            // InternalRosSystemParser.g:3623:5: lv_value_3_0= ruleParameterValue
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
    // InternalRosSystemParser.g:3644:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRosSystemParser.g:3644:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRosSystemParser.g:3645:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
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
    // InternalRosSystemParser.g:3651:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3657:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRosSystemParser.g:3658:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRosSystemParser.g:3658:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRosSystemParser.g:3659:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRosSystemParser.g:3659:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosSystemParser.g:3660:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosSystemParser.g:3660:4: (lv_name_0_0= ruleEString )
            // InternalRosSystemParser.g:3661:5: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_36);
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

            // InternalRosSystemParser.g:3678:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRosSystemParser.g:3679:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRosSystemParser.g:3679:4: (lv_type_1_0= ruleParameterType )
            // InternalRosSystemParser.g:3680:5: lv_type_1_0= ruleParameterType
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
    // InternalRosSystemParser.g:3701:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRosSystemParser.g:3701:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRosSystemParser.g:3702:2: iv_ruleBase64Binary= ruleBase64Binary EOF
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
    // InternalRosSystemParser.g:3708:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3714:2: (this_BINARY_0= RULE_BINARY )
            // InternalRosSystemParser.g:3715:2: this_BINARY_0= RULE_BINARY
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
    // InternalRosSystemParser.g:3725:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRosSystemParser.g:3725:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRosSystemParser.g:3726:2: iv_ruleboolean0= ruleboolean0 EOF
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
    // InternalRosSystemParser.g:3732:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3738:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRosSystemParser.g:3739:2: this_BOOLEAN_0= RULE_BOOLEAN
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
    // InternalRosSystemParser.g:3749:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRosSystemParser.g:3749:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRosSystemParser.g:3750:2: iv_ruleDouble0= ruleDouble0 EOF
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
    // InternalRosSystemParser.g:3756:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3762:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRosSystemParser.g:3763:2: this_DOUBLE_0= RULE_DOUBLE
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
    // InternalRosSystemParser.g:3773:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRosSystemParser.g:3773:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRosSystemParser.g:3774:2: iv_ruleInteger0= ruleInteger0 EOF
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
    // InternalRosSystemParser.g:3780:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3786:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosSystemParser.g:3787:2: this_DECINT_0= RULE_DECINT
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
    // InternalRosSystemParser.g:3797:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRosSystemParser.g:3797:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRosSystemParser.g:3798:2: iv_ruleDateTime0= ruleDateTime0 EOF
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
    // InternalRosSystemParser.g:3804:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:3810:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRosSystemParser.g:3811:2: this_DATE_TIME_0= RULE_DATE_TIME
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
    // InternalRosSystemParser.g:3821:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRosSystemParser.g:3821:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRosSystemParser.g:3822:2: iv_ruleAbstractType= ruleAbstractType EOF
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
    // InternalRosSystemParser.g:3828:1: ruleAbstractType returns [EObject current=null] : (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) ) ;
    public final EObject ruleAbstractType() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token lv_bounded_4_0=null;
        Token otherlv_6=null;
        EObject this_SizedPrimitiveArray_0 = null;

        EObject this_ElementType_1 = null;

        AntlrDatatypeRuleToken lv_size_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3834:2: ( (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) ) )
            // InternalRosSystemParser.g:3835:2: (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) )
            {
            // InternalRosSystemParser.g:3835:2: (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( ((LA61_0>=Float32_1 && LA61_0<=Float64_1)||(LA61_0>=String_2 && LA61_0<=Uint64_1)||(LA61_0>=Int16_1 && LA61_0<=Int64_1)||LA61_0==Uint8_1||(LA61_0>=Bool_1 && LA61_0<=Char_1)||LA61_0==Int8_1) ) {
                alt61=1;
            }
            else if ( ((LA61_0>=Float32_2 && LA61_0<=Float64_2)||LA61_0==Duration||LA61_0==String_3||(LA61_0>=Uint16_2 && LA61_0<=Uint64_2)||(LA61_0>=Float32 && LA61_0<=Int64_2)||LA61_0==Uint8_2||LA61_0==Header||(LA61_0>=Bool_2 && LA61_0<=Char_2)||LA61_0==Int8_2||(LA61_0>=String_1 && LA61_0<=Uint64)||(LA61_0>=Int16 && LA61_0<=Int64)||LA61_0==Uint8||(LA61_0>=Bool && LA61_0<=Char)||LA61_0==Int8||LA61_0==Time||(LA61_0>=RULE_ID && LA61_0<=RULE_STRING)) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalRosSystemParser.g:3836:3: this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractTypeAccess().getSizedPrimitiveArrayParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SizedPrimitiveArray_0=ruleSizedPrimitiveArray();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SizedPrimitiveArray_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:3845:3: (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? )
                    {
                    // InternalRosSystemParser.g:3845:3: (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? )
                    // InternalRosSystemParser.g:3846:4: this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAbstractTypeAccess().getElementTypeParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_31);
                    this_ElementType_1=ruleElementType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ElementType_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalRosSystemParser.g:3854:4: ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==LeftSquareBracket) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // InternalRosSystemParser.g:3855:5: () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket
                            {
                            // InternalRosSystemParser.g:3855:5: ()
                            // InternalRosSystemParser.g:3856:6: 
                            {
                            if ( state.backtracking==0 ) {

                              						current = forceCreateModelElementAndSet(
                              							grammarAccess.getAbstractTypeAccess().getSizedArrayElementAction_1_1_0(),
                              							current);
                              					
                            }

                            }

                            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_44); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getAbstractTypeAccess().getLeftSquareBracketKeyword_1_1_1());
                              				
                            }
                            // InternalRosSystemParser.g:3866:5: ( (lv_bounded_4_0= LessThanSignEqualsSign ) )?
                            int alt59=2;
                            int LA59_0 = input.LA(1);

                            if ( (LA59_0==LessThanSignEqualsSign) ) {
                                alt59=1;
                            }
                            switch (alt59) {
                                case 1 :
                                    // InternalRosSystemParser.g:3867:6: (lv_bounded_4_0= LessThanSignEqualsSign )
                                    {
                                    // InternalRosSystemParser.g:3867:6: (lv_bounded_4_0= LessThanSignEqualsSign )
                                    // InternalRosSystemParser.g:3868:7: lv_bounded_4_0= LessThanSignEqualsSign
                                    {
                                    lv_bounded_4_0=(Token)match(input,LessThanSignEqualsSign,FOLLOW_44); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      							newLeafNode(lv_bounded_4_0, grammarAccess.getAbstractTypeAccess().getBoundedLessThanSignEqualsSignKeyword_1_1_2_0());
                                      						
                                    }
                                    if ( state.backtracking==0 ) {

                                      							if (current==null) {
                                      								current = createModelElement(grammarAccess.getAbstractTypeRule());
                                      							}
                                      							setWithLastConsumed(current, "bounded", lv_bounded_4_0 != null, "<=");
                                      						
                                    }

                                    }


                                    }
                                    break;

                            }

                            // InternalRosSystemParser.g:3880:5: ( (lv_size_5_0= ruleArraySize ) )
                            // InternalRosSystemParser.g:3881:6: (lv_size_5_0= ruleArraySize )
                            {
                            // InternalRosSystemParser.g:3881:6: (lv_size_5_0= ruleArraySize )
                            // InternalRosSystemParser.g:3882:7: lv_size_5_0= ruleArraySize
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAbstractTypeAccess().getSizeArraySizeParserRuleCall_1_1_3_0());
                              						
                            }
                            pushFollow(FOLLOW_30);
                            lv_size_5_0=ruleArraySize();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getAbstractTypeRule());
                              							}
                              							set(
                              								current,
                              								"size",
                              								lv_size_5_0,
                              								"de.fraunhofer.ipa.ros.Basics.ArraySize");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getAbstractTypeAccess().getRightSquareBracketKeyword_1_1_4());
                              				
                            }

                            }
                            break;

                    }


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


    // $ANTLR start "entryRuleSizedPrimitiveArray"
    // InternalRosSystemParser.g:3909:1: entryRuleSizedPrimitiveArray returns [EObject current=null] : iv_ruleSizedPrimitiveArray= ruleSizedPrimitiveArray EOF ;
    public final EObject entryRuleSizedPrimitiveArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedPrimitiveArray = null;


        try {
            // InternalRosSystemParser.g:3909:60: (iv_ruleSizedPrimitiveArray= ruleSizedPrimitiveArray EOF )
            // InternalRosSystemParser.g:3910:2: iv_ruleSizedPrimitiveArray= ruleSizedPrimitiveArray EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedPrimitiveArrayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedPrimitiveArray=ruleSizedPrimitiveArray();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedPrimitiveArray; 
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
    // $ANTLR end "entryRuleSizedPrimitiveArray"


    // $ANTLR start "ruleSizedPrimitiveArray"
    // InternalRosSystemParser.g:3916:1: ruleSizedPrimitiveArray returns [EObject current=null] : ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket ) ;
    public final EObject ruleSizedPrimitiveArray() throws RecognitionException {
        EObject current = null;

        Token lv_bounded_14_0=null;
        Token otherlv_16=null;
        EObject lv_element_0_0 = null;

        EObject lv_element_1_0 = null;

        EObject lv_element_2_0 = null;

        EObject lv_element_3_0 = null;

        EObject lv_element_4_0 = null;

        EObject lv_element_5_0 = null;

        EObject lv_element_6_0 = null;

        EObject lv_element_7_0 = null;

        EObject lv_element_8_0 = null;

        EObject lv_element_9_0 = null;

        EObject lv_element_10_0 = null;

        EObject lv_element_11_0 = null;

        EObject lv_element_12_0 = null;

        EObject lv_element_13_0 = null;

        AntlrDatatypeRuleToken lv_size_15_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:3922:2: ( ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket ) )
            // InternalRosSystemParser.g:3923:2: ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket )
            {
            // InternalRosSystemParser.g:3923:2: ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket )
            // InternalRosSystemParser.g:3924:3: ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket
            {
            // InternalRosSystemParser.g:3924:3: ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) )
            int alt62=14;
            switch ( input.LA(1) ) {
            case Bool_1:
                {
                alt62=1;
                }
                break;
            case Int8_1:
                {
                alt62=2;
                }
                break;
            case Uint8_1:
                {
                alt62=3;
                }
                break;
            case Int16_1:
                {
                alt62=4;
                }
                break;
            case Uint16_1:
                {
                alt62=5;
                }
                break;
            case Int32_1:
                {
                alt62=6;
                }
                break;
            case Uint32_1:
                {
                alt62=7;
                }
                break;
            case Int64_1:
                {
                alt62=8;
                }
                break;
            case Uint64_1:
                {
                alt62=9;
                }
                break;
            case Float32_1:
                {
                alt62=10;
                }
                break;
            case Float64_1:
                {
                alt62=11;
                }
                break;
            case String_2:
                {
                alt62=12;
                }
                break;
            case Byte_1:
                {
                alt62=13;
                }
                break;
            case Char_1:
                {
                alt62=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalRosSystemParser.g:3925:4: ( (lv_element_0_0= ruleSizedBool ) )
                    {
                    // InternalRosSystemParser.g:3925:4: ( (lv_element_0_0= ruleSizedBool ) )
                    // InternalRosSystemParser.g:3926:5: (lv_element_0_0= ruleSizedBool )
                    {
                    // InternalRosSystemParser.g:3926:5: (lv_element_0_0= ruleSizedBool )
                    // InternalRosSystemParser.g:3927:6: lv_element_0_0= ruleSizedBool
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedBoolParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_0_0=ruleSizedBool();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_0_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedBool");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:3945:4: ( (lv_element_1_0= ruleSizedInt8 ) )
                    {
                    // InternalRosSystemParser.g:3945:4: ( (lv_element_1_0= ruleSizedInt8 ) )
                    // InternalRosSystemParser.g:3946:5: (lv_element_1_0= ruleSizedInt8 )
                    {
                    // InternalRosSystemParser.g:3946:5: (lv_element_1_0= ruleSizedInt8 )
                    // InternalRosSystemParser.g:3947:6: lv_element_1_0= ruleSizedInt8
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt8ParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_1_0=ruleSizedInt8();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_1_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedInt8");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:3965:4: ( (lv_element_2_0= ruleSizedUint8 ) )
                    {
                    // InternalRosSystemParser.g:3965:4: ( (lv_element_2_0= ruleSizedUint8 ) )
                    // InternalRosSystemParser.g:3966:5: (lv_element_2_0= ruleSizedUint8 )
                    {
                    // InternalRosSystemParser.g:3966:5: (lv_element_2_0= ruleSizedUint8 )
                    // InternalRosSystemParser.g:3967:6: lv_element_2_0= ruleSizedUint8
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint8ParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_2_0=ruleSizedUint8();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_2_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedUint8");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:3985:4: ( (lv_element_3_0= ruleSizedInt16 ) )
                    {
                    // InternalRosSystemParser.g:3985:4: ( (lv_element_3_0= ruleSizedInt16 ) )
                    // InternalRosSystemParser.g:3986:5: (lv_element_3_0= ruleSizedInt16 )
                    {
                    // InternalRosSystemParser.g:3986:5: (lv_element_3_0= ruleSizedInt16 )
                    // InternalRosSystemParser.g:3987:6: lv_element_3_0= ruleSizedInt16
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt16ParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_3_0=ruleSizedInt16();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_3_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedInt16");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:4005:4: ( (lv_element_4_0= ruleSizedUint16 ) )
                    {
                    // InternalRosSystemParser.g:4005:4: ( (lv_element_4_0= ruleSizedUint16 ) )
                    // InternalRosSystemParser.g:4006:5: (lv_element_4_0= ruleSizedUint16 )
                    {
                    // InternalRosSystemParser.g:4006:5: (lv_element_4_0= ruleSizedUint16 )
                    // InternalRosSystemParser.g:4007:6: lv_element_4_0= ruleSizedUint16
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint16ParserRuleCall_0_4_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_4_0=ruleSizedUint16();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_4_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedUint16");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:4025:4: ( (lv_element_5_0= ruleSizedInt32 ) )
                    {
                    // InternalRosSystemParser.g:4025:4: ( (lv_element_5_0= ruleSizedInt32 ) )
                    // InternalRosSystemParser.g:4026:5: (lv_element_5_0= ruleSizedInt32 )
                    {
                    // InternalRosSystemParser.g:4026:5: (lv_element_5_0= ruleSizedInt32 )
                    // InternalRosSystemParser.g:4027:6: lv_element_5_0= ruleSizedInt32
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt32ParserRuleCall_0_5_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_5_0=ruleSizedInt32();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_5_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedInt32");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:4045:4: ( (lv_element_6_0= ruleSizedUint32 ) )
                    {
                    // InternalRosSystemParser.g:4045:4: ( (lv_element_6_0= ruleSizedUint32 ) )
                    // InternalRosSystemParser.g:4046:5: (lv_element_6_0= ruleSizedUint32 )
                    {
                    // InternalRosSystemParser.g:4046:5: (lv_element_6_0= ruleSizedUint32 )
                    // InternalRosSystemParser.g:4047:6: lv_element_6_0= ruleSizedUint32
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint32ParserRuleCall_0_6_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_6_0=ruleSizedUint32();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_6_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedUint32");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:4065:4: ( (lv_element_7_0= ruleSizedInt64 ) )
                    {
                    // InternalRosSystemParser.g:4065:4: ( (lv_element_7_0= ruleSizedInt64 ) )
                    // InternalRosSystemParser.g:4066:5: (lv_element_7_0= ruleSizedInt64 )
                    {
                    // InternalRosSystemParser.g:4066:5: (lv_element_7_0= ruleSizedInt64 )
                    // InternalRosSystemParser.g:4067:6: lv_element_7_0= ruleSizedInt64
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt64ParserRuleCall_0_7_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_7_0=ruleSizedInt64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_7_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedInt64");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:4085:4: ( (lv_element_8_0= ruleSizedUint64 ) )
                    {
                    // InternalRosSystemParser.g:4085:4: ( (lv_element_8_0= ruleSizedUint64 ) )
                    // InternalRosSystemParser.g:4086:5: (lv_element_8_0= ruleSizedUint64 )
                    {
                    // InternalRosSystemParser.g:4086:5: (lv_element_8_0= ruleSizedUint64 )
                    // InternalRosSystemParser.g:4087:6: lv_element_8_0= ruleSizedUint64
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint64ParserRuleCall_0_8_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_8_0=ruleSizedUint64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_8_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedUint64");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:4105:4: ( (lv_element_9_0= ruleSizedFloat32 ) )
                    {
                    // InternalRosSystemParser.g:4105:4: ( (lv_element_9_0= ruleSizedFloat32 ) )
                    // InternalRosSystemParser.g:4106:5: (lv_element_9_0= ruleSizedFloat32 )
                    {
                    // InternalRosSystemParser.g:4106:5: (lv_element_9_0= ruleSizedFloat32 )
                    // InternalRosSystemParser.g:4107:6: lv_element_9_0= ruleSizedFloat32
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedFloat32ParserRuleCall_0_9_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_9_0=ruleSizedFloat32();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_9_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedFloat32");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:4125:4: ( (lv_element_10_0= ruleSizedFloat64 ) )
                    {
                    // InternalRosSystemParser.g:4125:4: ( (lv_element_10_0= ruleSizedFloat64 ) )
                    // InternalRosSystemParser.g:4126:5: (lv_element_10_0= ruleSizedFloat64 )
                    {
                    // InternalRosSystemParser.g:4126:5: (lv_element_10_0= ruleSizedFloat64 )
                    // InternalRosSystemParser.g:4127:6: lv_element_10_0= ruleSizedFloat64
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedFloat64ParserRuleCall_0_10_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_10_0=ruleSizedFloat64();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_10_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedFloat64");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:4145:4: ( (lv_element_11_0= ruleSizedString ) )
                    {
                    // InternalRosSystemParser.g:4145:4: ( (lv_element_11_0= ruleSizedString ) )
                    // InternalRosSystemParser.g:4146:5: (lv_element_11_0= ruleSizedString )
                    {
                    // InternalRosSystemParser.g:4146:5: (lv_element_11_0= ruleSizedString )
                    // InternalRosSystemParser.g:4147:6: lv_element_11_0= ruleSizedString
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedStringParserRuleCall_0_11_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_11_0=ruleSizedString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_11_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedString");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:4165:4: ( (lv_element_12_0= ruleSizedByte ) )
                    {
                    // InternalRosSystemParser.g:4165:4: ( (lv_element_12_0= ruleSizedByte ) )
                    // InternalRosSystemParser.g:4166:5: (lv_element_12_0= ruleSizedByte )
                    {
                    // InternalRosSystemParser.g:4166:5: (lv_element_12_0= ruleSizedByte )
                    // InternalRosSystemParser.g:4167:6: lv_element_12_0= ruleSizedByte
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedByteParserRuleCall_0_12_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_12_0=ruleSizedByte();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_12_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedByte");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:4185:4: ( (lv_element_13_0= ruleSizedChar ) )
                    {
                    // InternalRosSystemParser.g:4185:4: ( (lv_element_13_0= ruleSizedChar ) )
                    // InternalRosSystemParser.g:4186:5: (lv_element_13_0= ruleSizedChar )
                    {
                    // InternalRosSystemParser.g:4186:5: (lv_element_13_0= ruleSizedChar )
                    // InternalRosSystemParser.g:4187:6: lv_element_13_0= ruleSizedChar
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedCharParserRuleCall_0_13_0());
                      					
                    }
                    pushFollow(FOLLOW_44);
                    lv_element_13_0=ruleSizedChar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
                      						}
                      						set(
                      							current,
                      							"element",
                      							lv_element_13_0,
                      							"de.fraunhofer.ipa.ros.Basics.SizedChar");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:4205:3: ( (lv_bounded_14_0= LessThanSignEqualsSign ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==LessThanSignEqualsSign) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRosSystemParser.g:4206:4: (lv_bounded_14_0= LessThanSignEqualsSign )
                    {
                    // InternalRosSystemParser.g:4206:4: (lv_bounded_14_0= LessThanSignEqualsSign )
                    // InternalRosSystemParser.g:4207:5: lv_bounded_14_0= LessThanSignEqualsSign
                    {
                    lv_bounded_14_0=(Token)match(input,LessThanSignEqualsSign,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_bounded_14_0, grammarAccess.getSizedPrimitiveArrayAccess().getBoundedLessThanSignEqualsSignKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getSizedPrimitiveArrayRule());
                      					}
                      					setWithLastConsumed(current, "bounded", lv_bounded_14_0 != null, "<=");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRosSystemParser.g:4219:3: ( (lv_size_15_0= ruleArraySize ) )
            // InternalRosSystemParser.g:4220:4: (lv_size_15_0= ruleArraySize )
            {
            // InternalRosSystemParser.g:4220:4: (lv_size_15_0= ruleArraySize )
            // InternalRosSystemParser.g:4221:5: lv_size_15_0= ruleArraySize
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getSizeArraySizeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_30);
            lv_size_15_0=ruleArraySize();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSizedPrimitiveArrayRule());
              					}
              					set(
              						current,
              						"size",
              						lv_size_15_0,
              						"de.fraunhofer.ipa.ros.Basics.ArraySize");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_16=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_16, grammarAccess.getSizedPrimitiveArrayAccess().getRightSquareBracketKeyword_3());
              		
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
    // $ANTLR end "ruleSizedPrimitiveArray"


    // $ANTLR start "entryRuleSizedBool"
    // InternalRosSystemParser.g:4246:1: entryRuleSizedBool returns [EObject current=null] : iv_ruleSizedBool= ruleSizedBool EOF ;
    public final EObject entryRuleSizedBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedBool = null;


        try {
            // InternalRosSystemParser.g:4246:50: (iv_ruleSizedBool= ruleSizedBool EOF )
            // InternalRosSystemParser.g:4247:2: iv_ruleSizedBool= ruleSizedBool EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedBoolRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedBool=ruleSizedBool();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedBool; 
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
    // $ANTLR end "entryRuleSizedBool"


    // $ANTLR start "ruleSizedBool"
    // InternalRosSystemParser.g:4253:1: ruleSizedBool returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleSizedBool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4259:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRosSystemParser.g:4260:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRosSystemParser.g:4260:2: ( () otherlv_1= Bool_1 )
            // InternalRosSystemParser.g:4261:3: () otherlv_1= Bool_1
            {
            // InternalRosSystemParser.g:4261:3: ()
            // InternalRosSystemParser.g:4262:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedBoolAccess().getBoolAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Bool_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedBoolAccess().getBoolKeyword_1());
              		
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
    // $ANTLR end "ruleSizedBool"


    // $ANTLR start "entryRuleSizedInt8"
    // InternalRosSystemParser.g:4276:1: entryRuleSizedInt8 returns [EObject current=null] : iv_ruleSizedInt8= ruleSizedInt8 EOF ;
    public final EObject entryRuleSizedInt8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt8 = null;


        try {
            // InternalRosSystemParser.g:4276:50: (iv_ruleSizedInt8= ruleSizedInt8 EOF )
            // InternalRosSystemParser.g:4277:2: iv_ruleSizedInt8= ruleSizedInt8 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedInt8Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt8=ruleSizedInt8();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedInt8; 
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
    // $ANTLR end "entryRuleSizedInt8"


    // $ANTLR start "ruleSizedInt8"
    // InternalRosSystemParser.g:4283:1: ruleSizedInt8 returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleSizedInt8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4289:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRosSystemParser.g:4290:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRosSystemParser.g:4290:2: ( () otherlv_1= Int8_1 )
            // InternalRosSystemParser.g:4291:3: () otherlv_1= Int8_1
            {
            // InternalRosSystemParser.g:4291:3: ()
            // InternalRosSystemParser.g:4292:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedInt8Access().getInt8Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int8_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedInt8Access().getInt8Keyword_1());
              		
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
    // $ANTLR end "ruleSizedInt8"


    // $ANTLR start "entryRuleSizedUint8"
    // InternalRosSystemParser.g:4306:1: entryRuleSizedUint8 returns [EObject current=null] : iv_ruleSizedUint8= ruleSizedUint8 EOF ;
    public final EObject entryRuleSizedUint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint8 = null;


        try {
            // InternalRosSystemParser.g:4306:51: (iv_ruleSizedUint8= ruleSizedUint8 EOF )
            // InternalRosSystemParser.g:4307:2: iv_ruleSizedUint8= ruleSizedUint8 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedUint8Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint8=ruleSizedUint8();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedUint8; 
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
    // $ANTLR end "entryRuleSizedUint8"


    // $ANTLR start "ruleSizedUint8"
    // InternalRosSystemParser.g:4313:1: ruleSizedUint8 returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleSizedUint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4319:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRosSystemParser.g:4320:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRosSystemParser.g:4320:2: ( () otherlv_1= Uint8_1 )
            // InternalRosSystemParser.g:4321:3: () otherlv_1= Uint8_1
            {
            // InternalRosSystemParser.g:4321:3: ()
            // InternalRosSystemParser.g:4322:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedUint8Access().getUint8Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint8_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedUint8Access().getUint8Keyword_1());
              		
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
    // $ANTLR end "ruleSizedUint8"


    // $ANTLR start "entryRuleSizedInt16"
    // InternalRosSystemParser.g:4336:1: entryRuleSizedInt16 returns [EObject current=null] : iv_ruleSizedInt16= ruleSizedInt16 EOF ;
    public final EObject entryRuleSizedInt16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt16 = null;


        try {
            // InternalRosSystemParser.g:4336:51: (iv_ruleSizedInt16= ruleSizedInt16 EOF )
            // InternalRosSystemParser.g:4337:2: iv_ruleSizedInt16= ruleSizedInt16 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedInt16Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt16=ruleSizedInt16();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedInt16; 
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
    // $ANTLR end "entryRuleSizedInt16"


    // $ANTLR start "ruleSizedInt16"
    // InternalRosSystemParser.g:4343:1: ruleSizedInt16 returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleSizedInt16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4349:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRosSystemParser.g:4350:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRosSystemParser.g:4350:2: ( () otherlv_1= Int16_1 )
            // InternalRosSystemParser.g:4351:3: () otherlv_1= Int16_1
            {
            // InternalRosSystemParser.g:4351:3: ()
            // InternalRosSystemParser.g:4352:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedInt16Access().getInt16Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int16_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedInt16Access().getInt16Keyword_1());
              		
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
    // $ANTLR end "ruleSizedInt16"


    // $ANTLR start "entryRuleSizedUint16"
    // InternalRosSystemParser.g:4366:1: entryRuleSizedUint16 returns [EObject current=null] : iv_ruleSizedUint16= ruleSizedUint16 EOF ;
    public final EObject entryRuleSizedUint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint16 = null;


        try {
            // InternalRosSystemParser.g:4366:52: (iv_ruleSizedUint16= ruleSizedUint16 EOF )
            // InternalRosSystemParser.g:4367:2: iv_ruleSizedUint16= ruleSizedUint16 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedUint16Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint16=ruleSizedUint16();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedUint16; 
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
    // $ANTLR end "entryRuleSizedUint16"


    // $ANTLR start "ruleSizedUint16"
    // InternalRosSystemParser.g:4373:1: ruleSizedUint16 returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleSizedUint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4379:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRosSystemParser.g:4380:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRosSystemParser.g:4380:2: ( () otherlv_1= Uint16_1 )
            // InternalRosSystemParser.g:4381:3: () otherlv_1= Uint16_1
            {
            // InternalRosSystemParser.g:4381:3: ()
            // InternalRosSystemParser.g:4382:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedUint16Access().getUint16Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint16_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedUint16Access().getUint16Keyword_1());
              		
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
    // $ANTLR end "ruleSizedUint16"


    // $ANTLR start "entryRuleSizedInt32"
    // InternalRosSystemParser.g:4396:1: entryRuleSizedInt32 returns [EObject current=null] : iv_ruleSizedInt32= ruleSizedInt32 EOF ;
    public final EObject entryRuleSizedInt32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt32 = null;


        try {
            // InternalRosSystemParser.g:4396:51: (iv_ruleSizedInt32= ruleSizedInt32 EOF )
            // InternalRosSystemParser.g:4397:2: iv_ruleSizedInt32= ruleSizedInt32 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedInt32Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt32=ruleSizedInt32();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedInt32; 
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
    // $ANTLR end "entryRuleSizedInt32"


    // $ANTLR start "ruleSizedInt32"
    // InternalRosSystemParser.g:4403:1: ruleSizedInt32 returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleSizedInt32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4409:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRosSystemParser.g:4410:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRosSystemParser.g:4410:2: ( () otherlv_1= Int32_1 )
            // InternalRosSystemParser.g:4411:3: () otherlv_1= Int32_1
            {
            // InternalRosSystemParser.g:4411:3: ()
            // InternalRosSystemParser.g:4412:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedInt32Access().getInt32Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int32_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedInt32Access().getInt32Keyword_1());
              		
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
    // $ANTLR end "ruleSizedInt32"


    // $ANTLR start "entryRuleSizedUint32"
    // InternalRosSystemParser.g:4426:1: entryRuleSizedUint32 returns [EObject current=null] : iv_ruleSizedUint32= ruleSizedUint32 EOF ;
    public final EObject entryRuleSizedUint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint32 = null;


        try {
            // InternalRosSystemParser.g:4426:52: (iv_ruleSizedUint32= ruleSizedUint32 EOF )
            // InternalRosSystemParser.g:4427:2: iv_ruleSizedUint32= ruleSizedUint32 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedUint32Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint32=ruleSizedUint32();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedUint32; 
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
    // $ANTLR end "entryRuleSizedUint32"


    // $ANTLR start "ruleSizedUint32"
    // InternalRosSystemParser.g:4433:1: ruleSizedUint32 returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleSizedUint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4439:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRosSystemParser.g:4440:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRosSystemParser.g:4440:2: ( () otherlv_1= Uint32_1 )
            // InternalRosSystemParser.g:4441:3: () otherlv_1= Uint32_1
            {
            // InternalRosSystemParser.g:4441:3: ()
            // InternalRosSystemParser.g:4442:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedUint32Access().getUint32Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint32_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedUint32Access().getUint32Keyword_1());
              		
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
    // $ANTLR end "ruleSizedUint32"


    // $ANTLR start "entryRuleSizedInt64"
    // InternalRosSystemParser.g:4456:1: entryRuleSizedInt64 returns [EObject current=null] : iv_ruleSizedInt64= ruleSizedInt64 EOF ;
    public final EObject entryRuleSizedInt64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt64 = null;


        try {
            // InternalRosSystemParser.g:4456:51: (iv_ruleSizedInt64= ruleSizedInt64 EOF )
            // InternalRosSystemParser.g:4457:2: iv_ruleSizedInt64= ruleSizedInt64 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedInt64Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt64=ruleSizedInt64();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedInt64; 
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
    // $ANTLR end "entryRuleSizedInt64"


    // $ANTLR start "ruleSizedInt64"
    // InternalRosSystemParser.g:4463:1: ruleSizedInt64 returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleSizedInt64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4469:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRosSystemParser.g:4470:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRosSystemParser.g:4470:2: ( () otherlv_1= Int64_1 )
            // InternalRosSystemParser.g:4471:3: () otherlv_1= Int64_1
            {
            // InternalRosSystemParser.g:4471:3: ()
            // InternalRosSystemParser.g:4472:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedInt64Access().getInt64Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int64_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedInt64Access().getInt64Keyword_1());
              		
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
    // $ANTLR end "ruleSizedInt64"


    // $ANTLR start "entryRuleSizedUint64"
    // InternalRosSystemParser.g:4486:1: entryRuleSizedUint64 returns [EObject current=null] : iv_ruleSizedUint64= ruleSizedUint64 EOF ;
    public final EObject entryRuleSizedUint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint64 = null;


        try {
            // InternalRosSystemParser.g:4486:52: (iv_ruleSizedUint64= ruleSizedUint64 EOF )
            // InternalRosSystemParser.g:4487:2: iv_ruleSizedUint64= ruleSizedUint64 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedUint64Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint64=ruleSizedUint64();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedUint64; 
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
    // $ANTLR end "entryRuleSizedUint64"


    // $ANTLR start "ruleSizedUint64"
    // InternalRosSystemParser.g:4493:1: ruleSizedUint64 returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleSizedUint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4499:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRosSystemParser.g:4500:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRosSystemParser.g:4500:2: ( () otherlv_1= Uint64_1 )
            // InternalRosSystemParser.g:4501:3: () otherlv_1= Uint64_1
            {
            // InternalRosSystemParser.g:4501:3: ()
            // InternalRosSystemParser.g:4502:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedUint64Access().getUint64Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint64_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedUint64Access().getUint64Keyword_1());
              		
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
    // $ANTLR end "ruleSizedUint64"


    // $ANTLR start "entryRuleSizedFloat32"
    // InternalRosSystemParser.g:4516:1: entryRuleSizedFloat32 returns [EObject current=null] : iv_ruleSizedFloat32= ruleSizedFloat32 EOF ;
    public final EObject entryRuleSizedFloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedFloat32 = null;


        try {
            // InternalRosSystemParser.g:4516:53: (iv_ruleSizedFloat32= ruleSizedFloat32 EOF )
            // InternalRosSystemParser.g:4517:2: iv_ruleSizedFloat32= ruleSizedFloat32 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedFloat32Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedFloat32=ruleSizedFloat32();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedFloat32; 
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
    // $ANTLR end "entryRuleSizedFloat32"


    // $ANTLR start "ruleSizedFloat32"
    // InternalRosSystemParser.g:4523:1: ruleSizedFloat32 returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject ruleSizedFloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4529:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRosSystemParser.g:4530:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRosSystemParser.g:4530:2: ( () otherlv_1= Float32_1 )
            // InternalRosSystemParser.g:4531:3: () otherlv_1= Float32_1
            {
            // InternalRosSystemParser.g:4531:3: ()
            // InternalRosSystemParser.g:4532:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedFloat32Access().getFloat32Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float32_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedFloat32Access().getFloat32Keyword_1());
              		
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
    // $ANTLR end "ruleSizedFloat32"


    // $ANTLR start "entryRuleSizedFloat64"
    // InternalRosSystemParser.g:4546:1: entryRuleSizedFloat64 returns [EObject current=null] : iv_ruleSizedFloat64= ruleSizedFloat64 EOF ;
    public final EObject entryRuleSizedFloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedFloat64 = null;


        try {
            // InternalRosSystemParser.g:4546:53: (iv_ruleSizedFloat64= ruleSizedFloat64 EOF )
            // InternalRosSystemParser.g:4547:2: iv_ruleSizedFloat64= ruleSizedFloat64 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedFloat64Rule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedFloat64=ruleSizedFloat64();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedFloat64; 
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
    // $ANTLR end "entryRuleSizedFloat64"


    // $ANTLR start "ruleSizedFloat64"
    // InternalRosSystemParser.g:4553:1: ruleSizedFloat64 returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject ruleSizedFloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4559:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRosSystemParser.g:4560:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRosSystemParser.g:4560:2: ( () otherlv_1= Float64_1 )
            // InternalRosSystemParser.g:4561:3: () otherlv_1= Float64_1
            {
            // InternalRosSystemParser.g:4561:3: ()
            // InternalRosSystemParser.g:4562:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedFloat64Access().getFloat64Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float64_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedFloat64Access().getFloat64Keyword_1());
              		
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
    // $ANTLR end "ruleSizedFloat64"


    // $ANTLR start "entryRuleSizedString"
    // InternalRosSystemParser.g:4576:1: entryRuleSizedString returns [EObject current=null] : iv_ruleSizedString= ruleSizedString EOF ;
    public final EObject entryRuleSizedString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedString = null;


        try {
            // InternalRosSystemParser.g:4576:52: (iv_ruleSizedString= ruleSizedString EOF )
            // InternalRosSystemParser.g:4577:2: iv_ruleSizedString= ruleSizedString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedString=ruleSizedString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedString; 
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
    // $ANTLR end "entryRuleSizedString"


    // $ANTLR start "ruleSizedString"
    // InternalRosSystemParser.g:4583:1: ruleSizedString returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject ruleSizedString() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4589:2: ( ( () otherlv_1= String_2 ) )
            // InternalRosSystemParser.g:4590:2: ( () otherlv_1= String_2 )
            {
            // InternalRosSystemParser.g:4590:2: ( () otherlv_1= String_2 )
            // InternalRosSystemParser.g:4591:3: () otherlv_1= String_2
            {
            // InternalRosSystemParser.g:4591:3: ()
            // InternalRosSystemParser.g:4592:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedStringAccess().getStringAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,String_2,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedStringAccess().getStringKeyword_1());
              		
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
    // $ANTLR end "ruleSizedString"


    // $ANTLR start "entryRuleSizedByte"
    // InternalRosSystemParser.g:4606:1: entryRuleSizedByte returns [EObject current=null] : iv_ruleSizedByte= ruleSizedByte EOF ;
    public final EObject entryRuleSizedByte() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedByte = null;


        try {
            // InternalRosSystemParser.g:4606:50: (iv_ruleSizedByte= ruleSizedByte EOF )
            // InternalRosSystemParser.g:4607:2: iv_ruleSizedByte= ruleSizedByte EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedByteRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedByte=ruleSizedByte();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedByte; 
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
    // $ANTLR end "entryRuleSizedByte"


    // $ANTLR start "ruleSizedByte"
    // InternalRosSystemParser.g:4613:1: ruleSizedByte returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject ruleSizedByte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4619:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRosSystemParser.g:4620:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRosSystemParser.g:4620:2: ( () otherlv_1= Byte_1 )
            // InternalRosSystemParser.g:4621:3: () otherlv_1= Byte_1
            {
            // InternalRosSystemParser.g:4621:3: ()
            // InternalRosSystemParser.g:4622:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedByteAccess().getByteAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Byte_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedByteAccess().getByteKeyword_1());
              		
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
    // $ANTLR end "ruleSizedByte"


    // $ANTLR start "entryRuleSizedChar"
    // InternalRosSystemParser.g:4636:1: entryRuleSizedChar returns [EObject current=null] : iv_ruleSizedChar= ruleSizedChar EOF ;
    public final EObject entryRuleSizedChar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedChar = null;


        try {
            // InternalRosSystemParser.g:4636:50: (iv_ruleSizedChar= ruleSizedChar EOF )
            // InternalRosSystemParser.g:4637:2: iv_ruleSizedChar= ruleSizedChar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSizedCharRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSizedChar=ruleSizedChar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSizedChar; 
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
    // $ANTLR end "entryRuleSizedChar"


    // $ANTLR start "ruleSizedChar"
    // InternalRosSystemParser.g:4643:1: ruleSizedChar returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject ruleSizedChar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4649:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRosSystemParser.g:4650:2: ( () otherlv_1= Char_1 )
            {
            // InternalRosSystemParser.g:4650:2: ( () otherlv_1= Char_1 )
            // InternalRosSystemParser.g:4651:3: () otherlv_1= Char_1
            {
            // InternalRosSystemParser.g:4651:3: ()
            // InternalRosSystemParser.g:4652:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSizedCharAccess().getChar0Action_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Char_1,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSizedCharAccess().getCharKeyword_1());
              		
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
    // $ANTLR end "ruleSizedChar"


    // $ANTLR start "entryRuleArraySize"
    // InternalRosSystemParser.g:4666:1: entryRuleArraySize returns [String current=null] : iv_ruleArraySize= ruleArraySize EOF ;
    public final String entryRuleArraySize() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArraySize = null;


        try {
            // InternalRosSystemParser.g:4666:49: (iv_ruleArraySize= ruleArraySize EOF )
            // InternalRosSystemParser.g:4667:2: iv_ruleArraySize= ruleArraySize EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArraySizeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArraySize=ruleArraySize();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArraySize.getText(); 
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
    // $ANTLR end "entryRuleArraySize"


    // $ANTLR start "ruleArraySize"
    // InternalRosSystemParser.g:4673:1: ruleArraySize returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleArraySize() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:4679:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosSystemParser.g:4680:2: this_DECINT_0= RULE_DECINT
            {
            this_DECINT_0=(Token)match(input,RULE_DECINT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DECINT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_DECINT_0, grammarAccess.getArraySizeAccess().getDECINTTerminalRuleCall());
              	
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
    // $ANTLR end "ruleArraySize"


    // $ANTLR start "entryRuleElementType"
    // InternalRosSystemParser.g:4690:1: entryRuleElementType returns [EObject current=null] : iv_ruleElementType= ruleElementType EOF ;
    public final EObject entryRuleElementType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementType = null;


        try {
            // InternalRosSystemParser.g:4690:52: (iv_ruleElementType= ruleElementType EOF )
            // InternalRosSystemParser.g:4691:2: iv_ruleElementType= ruleElementType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElementType=ruleElementType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementType; 
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
    // $ANTLR end "entryRuleElementType"


    // $ANTLR start "ruleElementType"
    // InternalRosSystemParser.g:4697:1: ruleElementType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
    public final EObject ruleElementType() throws RecognitionException {
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
            // InternalRosSystemParser.g:4703:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRosSystemParser.g:4704:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRosSystemParser.g:4704:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt64=33;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // InternalRosSystemParser.g:4705:3: this_bool_0= rulebool
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getBoolParserRuleCall_0());
                      		
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
                    // InternalRosSystemParser.g:4714:3: this_int8_1= ruleint8
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt8ParserRuleCall_1());
                      		
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
                    // InternalRosSystemParser.g:4723:3: this_uint8_2= ruleuint8
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint8ParserRuleCall_2());
                      		
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
                    // InternalRosSystemParser.g:4732:3: this_int16_3= ruleint16
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt16ParserRuleCall_3());
                      		
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
                    // InternalRosSystemParser.g:4741:3: this_uint16_4= ruleuint16
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint16ParserRuleCall_4());
                      		
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
                    // InternalRosSystemParser.g:4750:3: this_int32_5= ruleint32
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt32ParserRuleCall_5());
                      		
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
                    // InternalRosSystemParser.g:4759:3: this_uint32_6= ruleuint32
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint32ParserRuleCall_6());
                      		
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
                    // InternalRosSystemParser.g:4768:3: this_int64_7= ruleint64
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt64ParserRuleCall_7());
                      		
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
                    // InternalRosSystemParser.g:4777:3: this_uint64_8= ruleuint64
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint64ParserRuleCall_8());
                      		
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
                    // InternalRosSystemParser.g:4786:3: this_float32_9= rulefloat32
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat32ParserRuleCall_9());
                      		
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
                    // InternalRosSystemParser.g:4795:3: this_float64_10= rulefloat64
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat64ParserRuleCall_10());
                      		
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
                    // InternalRosSystemParser.g:4804:3: this_string0_11= rulestring0
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getString0ParserRuleCall_11());
                      		
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
                    // InternalRosSystemParser.g:4813:3: this_byte_12= rulebyte
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getByteParserRuleCall_12());
                      		
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
                    // InternalRosSystemParser.g:4822:3: this_time_13= ruletime
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getTimeParserRuleCall_13());
                      		
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
                    // InternalRosSystemParser.g:4831:3: this_duration_14= ruleduration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getDurationParserRuleCall_14());
                      		
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
                    // InternalRosSystemParser.g:4840:3: this_Header_15= ruleHeader
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getHeaderParserRuleCall_15());
                      		
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
                    // InternalRosSystemParser.g:4849:3: this_boolArray_16= ruleboolArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getBoolArrayParserRuleCall_16());
                      		
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
                    // InternalRosSystemParser.g:4858:3: this_int8Array_17= ruleint8Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt8ArrayParserRuleCall_17());
                      		
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
                    // InternalRosSystemParser.g:4867:3: this_uint8Array_18= ruleuint8Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint8ArrayParserRuleCall_18());
                      		
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
                    // InternalRosSystemParser.g:4876:3: this_int16Array_19= ruleint16Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt16ArrayParserRuleCall_19());
                      		
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
                    // InternalRosSystemParser.g:4885:3: this_uint16Array_20= ruleuint16Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint16ArrayParserRuleCall_20());
                      		
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
                    // InternalRosSystemParser.g:4894:3: this_int32Array_21= ruleint32Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt32ArrayParserRuleCall_21());
                      		
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
                    // InternalRosSystemParser.g:4903:3: this_uint32Array_22= ruleuint32Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint32ArrayParserRuleCall_22());
                      		
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
                    // InternalRosSystemParser.g:4912:3: this_int64Array_23= ruleint64Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getInt64ArrayParserRuleCall_23());
                      		
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
                    // InternalRosSystemParser.g:4921:3: this_uint64Array_24= ruleuint64Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getUint64ArrayParserRuleCall_24());
                      		
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
                    // InternalRosSystemParser.g:4930:3: this_float32Array_25= rulefloat32Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat32ArrayParserRuleCall_25());
                      		
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
                    // InternalRosSystemParser.g:4939:3: this_float64Array_26= rulefloat64Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat64ArrayParserRuleCall_26());
                      		
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
                    // InternalRosSystemParser.g:4948:3: this_string0Array_27= rulestring0Array
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getString0ArrayParserRuleCall_27());
                      		
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
                    // InternalRosSystemParser.g:4957:3: this_byteArray_28= rulebyteArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getByteArrayParserRuleCall_28());
                      		
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
                    // InternalRosSystemParser.g:4966:3: this_SpecBaseRef_29= ruleSpecBaseRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getSpecBaseRefParserRuleCall_29());
                      		
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
                    // InternalRosSystemParser.g:4975:3: this_ArraySpecRef_30= ruleArraySpecRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getArraySpecRefParserRuleCall_30());
                      		
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
                    // InternalRosSystemParser.g:4984:3: this_char_31= rulechar
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getCharParserRuleCall_31());
                      		
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
                    // InternalRosSystemParser.g:4993:3: this_charArray_32= rulecharArray
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getElementTypeAccess().getCharArrayParserRuleCall_32());
                      		
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
    // $ANTLR end "ruleElementType"


    // $ANTLR start "entryRulebool"
    // InternalRosSystemParser.g:5005:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRosSystemParser.g:5005:45: (iv_rulebool= rulebool EOF )
            // InternalRosSystemParser.g:5006:2: iv_rulebool= rulebool EOF
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
    // InternalRosSystemParser.g:5012:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5018:2: ( ( () otherlv_1= Bool ) )
            // InternalRosSystemParser.g:5019:2: ( () otherlv_1= Bool )
            {
            // InternalRosSystemParser.g:5019:2: ( () otherlv_1= Bool )
            // InternalRosSystemParser.g:5020:3: () otherlv_1= Bool
            {
            // InternalRosSystemParser.g:5020:3: ()
            // InternalRosSystemParser.g:5021:4: 
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
    // InternalRosSystemParser.g:5035:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRosSystemParser.g:5035:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRosSystemParser.g:5036:2: iv_ruleint8= ruleint8 EOF
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
    // InternalRosSystemParser.g:5042:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5048:2: ( ( () otherlv_1= Int8 ) )
            // InternalRosSystemParser.g:5049:2: ( () otherlv_1= Int8 )
            {
            // InternalRosSystemParser.g:5049:2: ( () otherlv_1= Int8 )
            // InternalRosSystemParser.g:5050:3: () otherlv_1= Int8
            {
            // InternalRosSystemParser.g:5050:3: ()
            // InternalRosSystemParser.g:5051:4: 
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
    // InternalRosSystemParser.g:5065:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRosSystemParser.g:5065:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRosSystemParser.g:5066:2: iv_ruleuint8= ruleuint8 EOF
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
    // InternalRosSystemParser.g:5072:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5078:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRosSystemParser.g:5079:2: ( () otherlv_1= Uint8 )
            {
            // InternalRosSystemParser.g:5079:2: ( () otherlv_1= Uint8 )
            // InternalRosSystemParser.g:5080:3: () otherlv_1= Uint8
            {
            // InternalRosSystemParser.g:5080:3: ()
            // InternalRosSystemParser.g:5081:4: 
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
    // InternalRosSystemParser.g:5095:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRosSystemParser.g:5095:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRosSystemParser.g:5096:2: iv_ruleint16= ruleint16 EOF
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
    // InternalRosSystemParser.g:5102:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5108:2: ( ( () otherlv_1= Int16 ) )
            // InternalRosSystemParser.g:5109:2: ( () otherlv_1= Int16 )
            {
            // InternalRosSystemParser.g:5109:2: ( () otherlv_1= Int16 )
            // InternalRosSystemParser.g:5110:3: () otherlv_1= Int16
            {
            // InternalRosSystemParser.g:5110:3: ()
            // InternalRosSystemParser.g:5111:4: 
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
    // InternalRosSystemParser.g:5125:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRosSystemParser.g:5125:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRosSystemParser.g:5126:2: iv_ruleuint16= ruleuint16 EOF
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
    // InternalRosSystemParser.g:5132:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5138:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRosSystemParser.g:5139:2: ( () otherlv_1= Uint16 )
            {
            // InternalRosSystemParser.g:5139:2: ( () otherlv_1= Uint16 )
            // InternalRosSystemParser.g:5140:3: () otherlv_1= Uint16
            {
            // InternalRosSystemParser.g:5140:3: ()
            // InternalRosSystemParser.g:5141:4: 
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
    // InternalRosSystemParser.g:5155:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRosSystemParser.g:5155:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRosSystemParser.g:5156:2: iv_ruleint32= ruleint32 EOF
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
    // InternalRosSystemParser.g:5162:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5168:2: ( ( () otherlv_1= Int32 ) )
            // InternalRosSystemParser.g:5169:2: ( () otherlv_1= Int32 )
            {
            // InternalRosSystemParser.g:5169:2: ( () otherlv_1= Int32 )
            // InternalRosSystemParser.g:5170:3: () otherlv_1= Int32
            {
            // InternalRosSystemParser.g:5170:3: ()
            // InternalRosSystemParser.g:5171:4: 
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
    // InternalRosSystemParser.g:5185:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRosSystemParser.g:5185:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRosSystemParser.g:5186:2: iv_ruleuint32= ruleuint32 EOF
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
    // InternalRosSystemParser.g:5192:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5198:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRosSystemParser.g:5199:2: ( () otherlv_1= Uint32 )
            {
            // InternalRosSystemParser.g:5199:2: ( () otherlv_1= Uint32 )
            // InternalRosSystemParser.g:5200:3: () otherlv_1= Uint32
            {
            // InternalRosSystemParser.g:5200:3: ()
            // InternalRosSystemParser.g:5201:4: 
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
    // InternalRosSystemParser.g:5215:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRosSystemParser.g:5215:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRosSystemParser.g:5216:2: iv_ruleint64= ruleint64 EOF
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
    // InternalRosSystemParser.g:5222:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5228:2: ( ( () otherlv_1= Int64 ) )
            // InternalRosSystemParser.g:5229:2: ( () otherlv_1= Int64 )
            {
            // InternalRosSystemParser.g:5229:2: ( () otherlv_1= Int64 )
            // InternalRosSystemParser.g:5230:3: () otherlv_1= Int64
            {
            // InternalRosSystemParser.g:5230:3: ()
            // InternalRosSystemParser.g:5231:4: 
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
    // InternalRosSystemParser.g:5245:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRosSystemParser.g:5245:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRosSystemParser.g:5246:2: iv_ruleuint64= ruleuint64 EOF
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
    // InternalRosSystemParser.g:5252:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5258:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRosSystemParser.g:5259:2: ( () otherlv_1= Uint64 )
            {
            // InternalRosSystemParser.g:5259:2: ( () otherlv_1= Uint64 )
            // InternalRosSystemParser.g:5260:3: () otherlv_1= Uint64
            {
            // InternalRosSystemParser.g:5260:3: ()
            // InternalRosSystemParser.g:5261:4: 
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
    // InternalRosSystemParser.g:5275:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRosSystemParser.g:5275:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRosSystemParser.g:5276:2: iv_rulefloat32= rulefloat32 EOF
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
    // InternalRosSystemParser.g:5282:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5288:2: ( ( () otherlv_1= Float32 ) )
            // InternalRosSystemParser.g:5289:2: ( () otherlv_1= Float32 )
            {
            // InternalRosSystemParser.g:5289:2: ( () otherlv_1= Float32 )
            // InternalRosSystemParser.g:5290:3: () otherlv_1= Float32
            {
            // InternalRosSystemParser.g:5290:3: ()
            // InternalRosSystemParser.g:5291:4: 
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
    // InternalRosSystemParser.g:5305:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRosSystemParser.g:5305:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRosSystemParser.g:5306:2: iv_rulefloat64= rulefloat64 EOF
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
    // InternalRosSystemParser.g:5312:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5318:2: ( ( () otherlv_1= Float64 ) )
            // InternalRosSystemParser.g:5319:2: ( () otherlv_1= Float64 )
            {
            // InternalRosSystemParser.g:5319:2: ( () otherlv_1= Float64 )
            // InternalRosSystemParser.g:5320:3: () otherlv_1= Float64
            {
            // InternalRosSystemParser.g:5320:3: ()
            // InternalRosSystemParser.g:5321:4: 
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
    // InternalRosSystemParser.g:5335:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRosSystemParser.g:5335:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRosSystemParser.g:5336:2: iv_rulestring0= rulestring0 EOF
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
    // InternalRosSystemParser.g:5342:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5348:2: ( ( () otherlv_1= String_1 ) )
            // InternalRosSystemParser.g:5349:2: ( () otherlv_1= String_1 )
            {
            // InternalRosSystemParser.g:5349:2: ( () otherlv_1= String_1 )
            // InternalRosSystemParser.g:5350:3: () otherlv_1= String_1
            {
            // InternalRosSystemParser.g:5350:3: ()
            // InternalRosSystemParser.g:5351:4: 
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
    // InternalRosSystemParser.g:5365:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRosSystemParser.g:5365:45: (iv_rulechar= rulechar EOF )
            // InternalRosSystemParser.g:5366:2: iv_rulechar= rulechar EOF
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
    // InternalRosSystemParser.g:5372:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5378:2: ( ( () otherlv_1= Char ) )
            // InternalRosSystemParser.g:5379:2: ( () otherlv_1= Char )
            {
            // InternalRosSystemParser.g:5379:2: ( () otherlv_1= Char )
            // InternalRosSystemParser.g:5380:3: () otherlv_1= Char
            {
            // InternalRosSystemParser.g:5380:3: ()
            // InternalRosSystemParser.g:5381:4: 
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
    // InternalRosSystemParser.g:5395:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRosSystemParser.g:5395:45: (iv_rulebyte= rulebyte EOF )
            // InternalRosSystemParser.g:5396:2: iv_rulebyte= rulebyte EOF
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
    // InternalRosSystemParser.g:5402:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5408:2: ( ( () otherlv_1= Byte ) )
            // InternalRosSystemParser.g:5409:2: ( () otherlv_1= Byte )
            {
            // InternalRosSystemParser.g:5409:2: ( () otherlv_1= Byte )
            // InternalRosSystemParser.g:5410:3: () otherlv_1= Byte
            {
            // InternalRosSystemParser.g:5410:3: ()
            // InternalRosSystemParser.g:5411:4: 
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
    // InternalRosSystemParser.g:5425:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRosSystemParser.g:5425:45: (iv_ruletime= ruletime EOF )
            // InternalRosSystemParser.g:5426:2: iv_ruletime= ruletime EOF
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
    // InternalRosSystemParser.g:5432:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5438:2: ( ( () otherlv_1= Time ) )
            // InternalRosSystemParser.g:5439:2: ( () otherlv_1= Time )
            {
            // InternalRosSystemParser.g:5439:2: ( () otherlv_1= Time )
            // InternalRosSystemParser.g:5440:3: () otherlv_1= Time
            {
            // InternalRosSystemParser.g:5440:3: ()
            // InternalRosSystemParser.g:5441:4: 
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
    // InternalRosSystemParser.g:5455:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRosSystemParser.g:5455:49: (iv_ruleduration= ruleduration EOF )
            // InternalRosSystemParser.g:5456:2: iv_ruleduration= ruleduration EOF
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
    // InternalRosSystemParser.g:5462:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5468:2: ( ( () otherlv_1= Duration ) )
            // InternalRosSystemParser.g:5469:2: ( () otherlv_1= Duration )
            {
            // InternalRosSystemParser.g:5469:2: ( () otherlv_1= Duration )
            // InternalRosSystemParser.g:5470:3: () otherlv_1= Duration
            {
            // InternalRosSystemParser.g:5470:3: ()
            // InternalRosSystemParser.g:5471:4: 
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
    // InternalRosSystemParser.g:5485:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRosSystemParser.g:5485:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRosSystemParser.g:5486:2: iv_ruleboolArray= ruleboolArray EOF
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
    // InternalRosSystemParser.g:5492:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_2 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5498:2: ( ( () otherlv_1= Bool_2 ) )
            // InternalRosSystemParser.g:5499:2: ( () otherlv_1= Bool_2 )
            {
            // InternalRosSystemParser.g:5499:2: ( () otherlv_1= Bool_2 )
            // InternalRosSystemParser.g:5500:3: () otherlv_1= Bool_2
            {
            // InternalRosSystemParser.g:5500:3: ()
            // InternalRosSystemParser.g:5501:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBoolArrayAccess().getBoolArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Bool_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5515:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRosSystemParser.g:5515:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRosSystemParser.g:5516:2: iv_ruleint8Array= ruleint8Array EOF
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
    // InternalRosSystemParser.g:5522:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_2 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5528:2: ( ( () otherlv_1= Int8_2 ) )
            // InternalRosSystemParser.g:5529:2: ( () otherlv_1= Int8_2 )
            {
            // InternalRosSystemParser.g:5529:2: ( () otherlv_1= Int8_2 )
            // InternalRosSystemParser.g:5530:3: () otherlv_1= Int8_2
            {
            // InternalRosSystemParser.g:5530:3: ()
            // InternalRosSystemParser.g:5531:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int8_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5545:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRosSystemParser.g:5545:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRosSystemParser.g:5546:2: iv_ruleuint8Array= ruleuint8Array EOF
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
    // InternalRosSystemParser.g:5552:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_2 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5558:2: ( ( () otherlv_1= Uint8_2 ) )
            // InternalRosSystemParser.g:5559:2: ( () otherlv_1= Uint8_2 )
            {
            // InternalRosSystemParser.g:5559:2: ( () otherlv_1= Uint8_2 )
            // InternalRosSystemParser.g:5560:3: () otherlv_1= Uint8_2
            {
            // InternalRosSystemParser.g:5560:3: ()
            // InternalRosSystemParser.g:5561:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint8_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5575:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRosSystemParser.g:5575:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRosSystemParser.g:5576:2: iv_ruleint16Array= ruleint16Array EOF
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
    // InternalRosSystemParser.g:5582:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_2 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5588:2: ( ( () otherlv_1= Int16_2 ) )
            // InternalRosSystemParser.g:5589:2: ( () otherlv_1= Int16_2 )
            {
            // InternalRosSystemParser.g:5589:2: ( () otherlv_1= Int16_2 )
            // InternalRosSystemParser.g:5590:3: () otherlv_1= Int16_2
            {
            // InternalRosSystemParser.g:5590:3: ()
            // InternalRosSystemParser.g:5591:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int16_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5605:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRosSystemParser.g:5605:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRosSystemParser.g:5606:2: iv_ruleuint16Array= ruleuint16Array EOF
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
    // InternalRosSystemParser.g:5612:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_2 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5618:2: ( ( () otherlv_1= Uint16_2 ) )
            // InternalRosSystemParser.g:5619:2: ( () otherlv_1= Uint16_2 )
            {
            // InternalRosSystemParser.g:5619:2: ( () otherlv_1= Uint16_2 )
            // InternalRosSystemParser.g:5620:3: () otherlv_1= Uint16_2
            {
            // InternalRosSystemParser.g:5620:3: ()
            // InternalRosSystemParser.g:5621:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint16_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5635:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRosSystemParser.g:5635:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRosSystemParser.g:5636:2: iv_ruleint32Array= ruleint32Array EOF
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
    // InternalRosSystemParser.g:5642:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_2 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5648:2: ( ( () otherlv_1= Int32_2 ) )
            // InternalRosSystemParser.g:5649:2: ( () otherlv_1= Int32_2 )
            {
            // InternalRosSystemParser.g:5649:2: ( () otherlv_1= Int32_2 )
            // InternalRosSystemParser.g:5650:3: () otherlv_1= Int32_2
            {
            // InternalRosSystemParser.g:5650:3: ()
            // InternalRosSystemParser.g:5651:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int32_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5665:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRosSystemParser.g:5665:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRosSystemParser.g:5666:2: iv_ruleuint32Array= ruleuint32Array EOF
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
    // InternalRosSystemParser.g:5672:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_2 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5678:2: ( ( () otherlv_1= Uint32_2 ) )
            // InternalRosSystemParser.g:5679:2: ( () otherlv_1= Uint32_2 )
            {
            // InternalRosSystemParser.g:5679:2: ( () otherlv_1= Uint32_2 )
            // InternalRosSystemParser.g:5680:3: () otherlv_1= Uint32_2
            {
            // InternalRosSystemParser.g:5680:3: ()
            // InternalRosSystemParser.g:5681:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint32_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5695:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRosSystemParser.g:5695:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRosSystemParser.g:5696:2: iv_ruleint64Array= ruleint64Array EOF
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
    // InternalRosSystemParser.g:5702:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_2 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5708:2: ( ( () otherlv_1= Int64_2 ) )
            // InternalRosSystemParser.g:5709:2: ( () otherlv_1= Int64_2 )
            {
            // InternalRosSystemParser.g:5709:2: ( () otherlv_1= Int64_2 )
            // InternalRosSystemParser.g:5710:3: () otherlv_1= Int64_2
            {
            // InternalRosSystemParser.g:5710:3: ()
            // InternalRosSystemParser.g:5711:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Int64_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5725:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRosSystemParser.g:5725:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRosSystemParser.g:5726:2: iv_ruleuint64Array= ruleuint64Array EOF
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
    // InternalRosSystemParser.g:5732:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_2 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5738:2: ( ( () otherlv_1= Uint64_2 ) )
            // InternalRosSystemParser.g:5739:2: ( () otherlv_1= Uint64_2 )
            {
            // InternalRosSystemParser.g:5739:2: ( () otherlv_1= Uint64_2 )
            // InternalRosSystemParser.g:5740:3: () otherlv_1= Uint64_2
            {
            // InternalRosSystemParser.g:5740:3: ()
            // InternalRosSystemParser.g:5741:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Uint64_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5755:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRosSystemParser.g:5755:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRosSystemParser.g:5756:2: iv_rulefloat32Array= rulefloat32Array EOF
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
    // InternalRosSystemParser.g:5762:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_2 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5768:2: ( ( () otherlv_1= Float32_2 ) )
            // InternalRosSystemParser.g:5769:2: ( () otherlv_1= Float32_2 )
            {
            // InternalRosSystemParser.g:5769:2: ( () otherlv_1= Float32_2 )
            // InternalRosSystemParser.g:5770:3: () otherlv_1= Float32_2
            {
            // InternalRosSystemParser.g:5770:3: ()
            // InternalRosSystemParser.g:5771:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float32_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5785:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRosSystemParser.g:5785:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRosSystemParser.g:5786:2: iv_rulefloat64Array= rulefloat64Array EOF
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
    // InternalRosSystemParser.g:5792:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_2 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5798:2: ( ( () otherlv_1= Float64_2 ) )
            // InternalRosSystemParser.g:5799:2: ( () otherlv_1= Float64_2 )
            {
            // InternalRosSystemParser.g:5799:2: ( () otherlv_1= Float64_2 )
            // InternalRosSystemParser.g:5800:3: () otherlv_1= Float64_2
            {
            // InternalRosSystemParser.g:5800:3: ()
            // InternalRosSystemParser.g:5801:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Float64_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5815:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRosSystemParser.g:5815:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRosSystemParser.g:5816:2: iv_rulestring0Array= rulestring0Array EOF
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
    // InternalRosSystemParser.g:5822:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_3 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5828:2: ( ( () otherlv_1= String_3 ) )
            // InternalRosSystemParser.g:5829:2: ( () otherlv_1= String_3 )
            {
            // InternalRosSystemParser.g:5829:2: ( () otherlv_1= String_3 )
            // InternalRosSystemParser.g:5830:3: () otherlv_1= String_3
            {
            // InternalRosSystemParser.g:5830:3: ()
            // InternalRosSystemParser.g:5831:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getString0ArrayAccess().getStringArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,String_3,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5845:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRosSystemParser.g:5845:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRosSystemParser.g:5846:2: iv_rulebyteArray= rulebyteArray EOF
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
    // InternalRosSystemParser.g:5852:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_2 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5858:2: ( ( () otherlv_1= Byte_2 ) )
            // InternalRosSystemParser.g:5859:2: ( () otherlv_1= Byte_2 )
            {
            // InternalRosSystemParser.g:5859:2: ( () otherlv_1= Byte_2 )
            // InternalRosSystemParser.g:5860:3: () otherlv_1= Byte_2
            {
            // InternalRosSystemParser.g:5860:3: ()
            // InternalRosSystemParser.g:5861:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getByteArrayAccess().getByteArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Byte_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5875:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRosSystemParser.g:5875:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRosSystemParser.g:5876:2: iv_rulecharArray= rulecharArray EOF
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
    // InternalRosSystemParser.g:5882:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_2 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5888:2: ( ( () otherlv_1= Char_2 ) )
            // InternalRosSystemParser.g:5889:2: ( () otherlv_1= Char_2 )
            {
            // InternalRosSystemParser.g:5889:2: ( () otherlv_1= Char_2 )
            // InternalRosSystemParser.g:5890:3: () otherlv_1= Char_2
            {
            // InternalRosSystemParser.g:5890:3: ()
            // InternalRosSystemParser.g:5891:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCharArrayAccess().getCharArrayAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Char_2,FOLLOW_2); if (state.failed) return current;
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
    // InternalRosSystemParser.g:5905:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRosSystemParser.g:5905:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRosSystemParser.g:5906:2: iv_ruleHeader= ruleHeader EOF
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
    // InternalRosSystemParser.g:5912:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5918:2: ( ( () otherlv_1= Header ) )
            // InternalRosSystemParser.g:5919:2: ( () otherlv_1= Header )
            {
            // InternalRosSystemParser.g:5919:2: ( () otherlv_1= Header )
            // InternalRosSystemParser.g:5920:3: () otherlv_1= Header
            {
            // InternalRosSystemParser.g:5920:3: ()
            // InternalRosSystemParser.g:5921:4: 
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
    // InternalRosSystemParser.g:5935:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRosSystemParser.g:5935:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRosSystemParser.g:5936:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
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
    // InternalRosSystemParser.g:5942:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5948:2: ( ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:5949:2: ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:5949:2: ( ( ruleEString ) )
            // InternalRosSystemParser.g:5950:3: ( ruleEString )
            {
            // InternalRosSystemParser.g:5950:3: ( ruleEString )
            // InternalRosSystemParser.g:5951:4: ruleEString
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
    // InternalRosSystemParser.g:5968:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRosSystemParser.g:5968:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRosSystemParser.g:5969:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
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
    // InternalRosSystemParser.g:5975:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:5981:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRosSystemParser.g:5982:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRosSystemParser.g:5982:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRosSystemParser.g:5983:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRosSystemParser.g:5983:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:5984:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:5984:4: ( ruleEString )
            // InternalRosSystemParser.g:5985:5: ruleEString
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getArraySpecRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_45);
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
    // InternalRosSystemParser.g:6007:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRosSystemParser.g:6007:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRosSystemParser.g:6008:2: iv_ruleKEYWORD= ruleKEYWORD EOF
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
    // InternalRosSystemParser.g:6014:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:6020:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRosSystemParser.g:6021:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRosSystemParser.g:6021:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt65=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt65=1;
                }
                break;
            case Message:
                {
                alt65=2;
                }
                break;
            case Result:
                {
                alt65=3;
                }
                break;
            case Feedback:
                {
                alt65=4;
                }
                break;
            case Name:
                {
                alt65=5;
                }
                break;
            case Value:
                {
                alt65=6;
                }
                break;
            case Service:
                {
                alt65=7;
                }
                break;
            case Type:
                {
                alt65=8;
                }
                break;
            case Action:
                {
                alt65=9;
                }
                break;
            case Duration:
                {
                alt65=10;
                }
                break;
            case Time:
                {
                alt65=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalRosSystemParser.g:6022:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:6028:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRosSystemParser.g:6034:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRosSystemParser.g:6040:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:6046:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:6052:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:6058:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:6064:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:6070:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:6076:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:6082:3: kw= Time
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
    // InternalRosSystemParser.g:6091:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRosSystemParser.g:6091:47: (iv_ruleEString= ruleEString EOF )
            // InternalRosSystemParser.g:6092:2: iv_ruleEString= ruleEString EOF
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
    // InternalRosSystemParser.g:6098:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:6104:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRosSystemParser.g:6105:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRosSystemParser.g:6105:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_STRING) ) {
                alt66=1;
            }
            else if ( (LA66_0==RULE_ID) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalRosSystemParser.g:6106:3: this_STRING_0= RULE_STRING
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
                    // InternalRosSystemParser.g:6114:3: this_ID_1= RULE_ID
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
    // InternalRosSystemParser.g:6125:1: entryRuleQualifiedRef returns [String current=null] : iv_ruleQualifiedRef= ruleQualifiedRef EOF ;
    public final String entryRuleQualifiedRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedRef = null;


        try {
            // InternalRosSystemParser.g:6125:52: (iv_ruleQualifiedRef= ruleQualifiedRef EOF )
            // InternalRosSystemParser.g:6126:2: iv_ruleQualifiedRef= ruleQualifiedRef EOF
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
    // InternalRosSystemParser.g:6132:1: ruleQualifiedRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) ;
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
            // InternalRosSystemParser.g:6138:2: ( (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) )
            // InternalRosSystemParser.g:6139:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            {
            // InternalRosSystemParser.g:6139:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_STRING) ) {
                alt69=1;
            }
            else if ( (LA69_0==RULE_ID) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalRosSystemParser.g:6140:3: this_STRING_0= RULE_STRING
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
                    // InternalRosSystemParser.g:6148:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    {
                    // InternalRosSystemParser.g:6148:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    // InternalRosSystemParser.g:6149:4: this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_1, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_0());
                      			
                    }
                    // InternalRosSystemParser.g:6156:4: ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    loop68:
                    do {
                        int alt68=3;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==FullStop) ) {
                            alt68=1;
                        }
                        else if ( (LA68_0==RULE_DOUBLE) ) {
                            alt68=2;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:6157:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    {
                    	    // InternalRosSystemParser.g:6157:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    // InternalRosSystemParser.g:6158:6: kw= FullStop this_ID_3= RULE_ID
                    	    {
                    	    kw=(Token)match(input,FullStop,FOLLOW_47); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						current.merge(kw);
                    	      						newLeafNode(kw, grammarAccess.getQualifiedRefAccess().getFullStopKeyword_1_1_0_0());
                    	      					
                    	    }
                    	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
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
                    	    // InternalRosSystemParser.g:6172:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    {
                    	    // InternalRosSystemParser.g:6172:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    // InternalRosSystemParser.g:6173:6: this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )?
                    	    {
                    	    this_DOUBLE_4=(Token)match(input,RULE_DOUBLE,FOLLOW_48); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						current.merge(this_DOUBLE_4);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(this_DOUBLE_4, grammarAccess.getQualifiedRefAccess().getDOUBLETerminalRuleCall_1_1_1_0());
                    	      					
                    	    }
                    	    // InternalRosSystemParser.g:6180:6: (this_ID_5= RULE_ID )?
                    	    int alt67=2;
                    	    int LA67_0 = input.LA(1);

                    	    if ( (LA67_0==RULE_ID) ) {
                    	        alt67=1;
                    	    }
                    	    switch (alt67) {
                    	        case 1 :
                    	            // InternalRosSystemParser.g:6181:7: this_ID_5= RULE_ID
                    	            {
                    	            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_46); if (state.failed) return current;
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
                    	    break loop68;
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
    // InternalRosSystemParser.g:6196:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRosSystemParser.g:6196:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRosSystemParser.g:6197:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
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
    // InternalRosSystemParser.g:6203:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
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
            // InternalRosSystemParser.g:6209:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRosSystemParser.g:6210:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRosSystemParser.g:6210:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRosSystemParser.g:6211:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRosSystemParser.g:6211:3: ()
            // InternalRosSystemParser.g:6212:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
              		
            }
            // InternalRosSystemParser.g:6222:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRosSystemParser.g:6223:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRosSystemParser.g:6223:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRosSystemParser.g:6224:5: lv_name_2_0= ruleExtensionBlockName
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

            otherlv_3=(Token)match(input,Colon,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
              		
            }
            // InternalRosSystemParser.g:6245:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt74=3;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_BEGIN) ) {
                alt74=1;
            }
            else if ( (LA74_0==LeftCurlyBracket) ) {
                alt74=2;
            }
            switch (alt74) {
                case 1 :
                    // InternalRosSystemParser.g:6246:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRosSystemParser.g:6246:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRosSystemParser.g:6247:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                      				
                    }
                    // InternalRosSystemParser.g:6251:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt70=0;
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( ((LA70_0>=Connections && LA70_0<=Processes)||(LA70_0>=FromFile && LA70_0<=Feedback)||LA70_0==Threads||(LA70_0>=Boolean && LA70_0<=Float64)||LA70_0==Message||LA70_0==Service||(LA70_0>=Base64 && LA70_0<=Action)||(LA70_0>=Nodes && LA70_0<=Uint64)||(LA70_0>=Value_1 && LA70_0<=Array)||(LA70_0>=From && LA70_0<=Int64)||(LA70_0>=Type_1 && LA70_0<=List)||(LA70_0>=Bool && LA70_0<=Node)||(LA70_0>=Time && LA70_0<=Ns)||(LA70_0>=RULE_ID && LA70_0<=RULE_STRING)) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:6252:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosSystemParser.g:6252:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRosSystemParser.g:6253:7: lv_entries_5_0= ruleExtensionEntry
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_51);
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
                    	    if ( cnt70 >= 1 ) break loop70;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(70, input);
                                throw eee;
                        }
                        cnt70++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:6276:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRosSystemParser.g:6276:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRosSystemParser.g:6277:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                      				
                    }
                    // InternalRosSystemParser.g:6281:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( ((LA73_0>=Connections && LA73_0<=Processes)||(LA73_0>=FromFile && LA73_0<=Feedback)||LA73_0==Threads||(LA73_0>=Boolean && LA73_0<=Float64)||LA73_0==Message||LA73_0==Service||(LA73_0>=Base64 && LA73_0<=Action)||(LA73_0>=Nodes && LA73_0<=Uint64)||(LA73_0>=Value_1 && LA73_0<=Array)||(LA73_0>=From && LA73_0<=Int64)||(LA73_0>=Type_1 && LA73_0<=List)||(LA73_0>=Bool && LA73_0<=Node)||(LA73_0>=Time && LA73_0<=Ns)||(LA73_0>=RULE_ID && LA73_0<=RULE_STRING)) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalRosSystemParser.g:6282:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRosSystemParser.g:6282:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRosSystemParser.g:6283:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRosSystemParser.g:6283:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRosSystemParser.g:6284:8: lv_entries_8_0= ruleExtensionEntry
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_53);
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

                            // InternalRosSystemParser.g:6301:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop72:
                            do {
                                int alt72=2;
                                int LA72_0 = input.LA(1);

                                if ( ((LA72_0>=Connections && LA72_0<=Processes)||(LA72_0>=FromFile && LA72_0<=Feedback)||LA72_0==Threads||(LA72_0>=Boolean && LA72_0<=Float64)||LA72_0==Message||LA72_0==Service||(LA72_0>=Base64 && LA72_0<=Action)||(LA72_0>=Nodes && LA72_0<=Uint64)||(LA72_0>=Value_1 && LA72_0<=Array)||(LA72_0>=From && LA72_0<=Int64)||(LA72_0>=Type_1 && LA72_0<=List)||(LA72_0>=Bool && LA72_0<=Node)||(LA72_0>=Time && LA72_0<=Ns)||LA72_0==Comma||(LA72_0>=RULE_ID && LA72_0<=RULE_STRING)) ) {
                                    alt72=1;
                                }


                                switch (alt72) {
                            	case 1 :
                            	    // InternalRosSystemParser.g:6302:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRosSystemParser.g:6302:7: (otherlv_9= Comma )?
                            	    int alt71=2;
                            	    int LA71_0 = input.LA(1);

                            	    if ( (LA71_0==Comma) ) {
                            	        alt71=1;
                            	    }
                            	    switch (alt71) {
                            	        case 1 :
                            	            // InternalRosSystemParser.g:6303:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_50); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	              							
                            	            }

                            	            }
                            	            break;

                            	    }

                            	    // InternalRosSystemParser.g:6308:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRosSystemParser.g:6309:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRosSystemParser.g:6309:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRosSystemParser.g:6310:9: lv_entries_10_0= ruleExtensionEntry
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_53);
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
                            	    break loop72;
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
    // InternalRosSystemParser.g:6339:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRosSystemParser.g:6339:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRosSystemParser.g:6340:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
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
    // InternalRosSystemParser.g:6346:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRosSystemParser.g:6352:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRosSystemParser.g:6353:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRosSystemParser.g:6353:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRosSystemParser.g:6354:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalRosSystemParser.g:6361:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==FullStop) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalRosSystemParser.g:6362:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_47); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_54); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop75;
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
    // InternalRosSystemParser.g:6379:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRosSystemParser.g:6379:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRosSystemParser.g:6380:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
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
    // InternalRosSystemParser.g:6386:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        AntlrDatatypeRuleToken lv_key_4_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6392:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) )
            // InternalRosSystemParser.g:6393:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            {
            // InternalRosSystemParser.g:6393:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            // InternalRosSystemParser.g:6394:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) )
            {
            // InternalRosSystemParser.g:6394:3: ()
            // InternalRosSystemParser.g:6395:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:6401:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) )
            int alt76=3;
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
                alt76=1;
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
                alt76=2;
                }
                break;
            case Slots:
                {
                alt76=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // InternalRosSystemParser.g:6402:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRosSystemParser.g:6402:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRosSystemParser.g:6403:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRosSystemParser.g:6403:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRosSystemParser.g:6404:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRosSystemParser.g:6404:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRosSystemParser.g:6405:7: lv_key_1_0= ruleExtensionKey
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:6428:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRosSystemParser.g:6428:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRosSystemParser.g:6429:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRosSystemParser.g:6429:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRosSystemParser.g:6430:6: lv_key_3_0= ruleExtensionColonKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_55);
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
                    // InternalRosSystemParser.g:6448:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosSystemParser.g:6448:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    // InternalRosSystemParser.g:6449:5: (lv_key_4_0= ruleAddedKeywordName )
                    {
                    // InternalRosSystemParser.g:6449:5: (lv_key_4_0= ruleAddedKeywordName )
                    // InternalRosSystemParser.g:6450:6: lv_key_4_0= ruleAddedKeywordName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyAddedKeywordNameParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_55);
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

            // InternalRosSystemParser.g:6468:3: ( (lv_value_5_0= ruleExtensionValue ) )
            // InternalRosSystemParser.g:6469:4: (lv_value_5_0= ruleExtensionValue )
            {
            // InternalRosSystemParser.g:6469:4: (lv_value_5_0= ruleExtensionValue )
            // InternalRosSystemParser.g:6470:5: lv_value_5_0= ruleExtensionValue
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
    // InternalRosSystemParser.g:6491:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRosSystemParser.g:6491:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRosSystemParser.g:6492:2: iv_ruleExtensionKey= ruleExtensionKey EOF
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
    // InternalRosSystemParser.g:6498:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6504:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRosSystemParser.g:6505:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRosSystemParser.g:6505:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt77=29;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt77=1;
                }
                break;
            case RULE_STRING:
                {
                alt77=2;
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
                alt77=3;
                }
                break;
            case Node:
                {
                alt77=4;
                }
                break;
            case String:
                {
                alt77=5;
                }
                break;
            case Integer:
                {
                alt77=6;
                }
                break;
            case Double:
                {
                alt77=7;
                }
                break;
            case Boolean:
                {
                alt77=8;
                }
                break;
            case Base64:
                {
                alt77=9;
                }
                break;
            case Array:
                {
                alt77=10;
                }
                break;
            case List:
                {
                alt77=11;
                }
                break;
            case Struct:
                {
                alt77=12;
                }
                break;
            case Date:
                {
                alt77=13;
                }
                break;
            case Any:
                {
                alt77=14;
                }
                break;
            case Bool:
                {
                alt77=15;
                }
                break;
            case Int8:
                {
                alt77=16;
                }
                break;
            case Uint8:
                {
                alt77=17;
                }
                break;
            case Int16:
                {
                alt77=18;
                }
                break;
            case Uint16:
                {
                alt77=19;
                }
                break;
            case Int32:
                {
                alt77=20;
                }
                break;
            case Uint32:
                {
                alt77=21;
                }
                break;
            case Int64:
                {
                alt77=22;
                }
                break;
            case Uint64:
                {
                alt77=23;
                }
                break;
            case Float32:
                {
                alt77=24;
                }
                break;
            case Float64:
                {
                alt77=25;
                }
                break;
            case String_1:
                {
                alt77=26;
                }
                break;
            case Char:
                {
                alt77=27;
                }
                break;
            case Byte:
                {
                alt77=28;
                }
                break;
            case Header:
                {
                alt77=29;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalRosSystemParser.g:6506:3: this_ID_0= RULE_ID
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
                    // InternalRosSystemParser.g:6514:3: this_STRING_1= RULE_STRING
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
                    // InternalRosSystemParser.g:6522:3: this_KEYWORD_2= ruleKEYWORD
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
                    // InternalRosSystemParser.g:6533:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRosSystemParser.g:6539:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRosSystemParser.g:6545:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRosSystemParser.g:6551:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRosSystemParser.g:6557:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRosSystemParser.g:6563:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRosSystemParser.g:6569:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRosSystemParser.g:6575:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRosSystemParser.g:6581:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRosSystemParser.g:6587:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRosSystemParser.g:6593:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalRosSystemParser.g:6599:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalRosSystemParser.g:6605:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalRosSystemParser.g:6611:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalRosSystemParser.g:6617:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalRosSystemParser.g:6623:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalRosSystemParser.g:6629:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalRosSystemParser.g:6635:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalRosSystemParser.g:6641:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalRosSystemParser.g:6647:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalRosSystemParser.g:6653:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalRosSystemParser.g:6659:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalRosSystemParser.g:6665:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalRosSystemParser.g:6671:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_26());
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalRosSystemParser.g:6677:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_27());
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalRosSystemParser.g:6683:3: kw= Header
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
    // InternalRosSystemParser.g:6692:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRosSystemParser.g:6692:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRosSystemParser.g:6693:2: iv_ruleExtensionValue= ruleExtensionValue EOF
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
    // InternalRosSystemParser.g:6699:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6705:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRosSystemParser.g:6706:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRosSystemParser.g:6706:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt78=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracketRightSquareBracket:
            case LeftSquareBracket:
                {
                alt78=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt78=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt78=3;
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
                alt78=4;
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
                alt78=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalRosSystemParser.g:6707:3: this_ExtensionListValue_0= ruleExtensionListValue
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
                    // InternalRosSystemParser.g:6716:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
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
                    // InternalRosSystemParser.g:6725:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
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
                    // InternalRosSystemParser.g:6734:3: this_ExtensionRefValue_3= ruleExtensionRefValue
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
                    // InternalRosSystemParser.g:6743:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
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
    // InternalRosSystemParser.g:6755:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRosSystemParser.g:6755:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRosSystemParser.g:6756:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
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
    // InternalRosSystemParser.g:6762:1: ruleExtensionListValue returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) ) ;
    public final EObject ruleExtensionListValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_items_3_0 = null;

        EObject lv_items_5_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6768:2: ( ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) ) )
            // InternalRosSystemParser.g:6769:2: ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) )
            {
            // InternalRosSystemParser.g:6769:2: ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) )
            // InternalRosSystemParser.g:6770:3: () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) )
            {
            // InternalRosSystemParser.g:6770:3: ()
            // InternalRosSystemParser.g:6771:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:6777:3: (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==LeftSquareBracketRightSquareBracket) ) {
                alt82=1;
            }
            else if ( (LA82_0==LeftSquareBracket) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalRosSystemParser.g:6778:4: otherlv_1= LeftSquareBracketRightSquareBracket
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketRightSquareBracketKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalRosSystemParser.g:6783:4: (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket )
                    {
                    // InternalRosSystemParser.g:6783:4: (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket )
                    // InternalRosSystemParser.g:6784:5: otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1_1_0());
                      				
                    }
                    // InternalRosSystemParser.g:6788:5: ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( ((LA81_0>=Duration && LA81_0<=Feedback)||(LA81_0>=Boolean && LA81_0<=Float64)||(LA81_0>=Message && LA81_0<=Service)||(LA81_0>=Base64 && LA81_0<=Action)||LA81_0==Result||(LA81_0>=String_1 && LA81_0<=Uint64)||LA81_0==Array||(LA81_0>=Int16 && LA81_0<=Int64)||(LA81_0>=Pub && LA81_0<=Sub)||(LA81_0>=Uint8 && LA81_0<=Any)||LA81_0==LeftSquareBracketRightSquareBracket||LA81_0==LeftSquareBracket||LA81_0==LeftCurlyBracket||(LA81_0>=RULE_BOOLEAN && LA81_0<=RULE_DOUBLE)||(LA81_0>=RULE_ID && LA81_0<=RULE_INT)||LA81_0==RULE_BEGIN) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalRosSystemParser.g:6789:6: ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )*
                            {
                            // InternalRosSystemParser.g:6789:6: ( (lv_items_3_0= ruleExtensionValue ) )
                            // InternalRosSystemParser.g:6790:7: (lv_items_3_0= ruleExtensionValue )
                            {
                            // InternalRosSystemParser.g:6790:7: (lv_items_3_0= ruleExtensionValue )
                            // InternalRosSystemParser.g:6791:8: lv_items_3_0= ruleExtensionValue
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_57);
                            lv_items_3_0=ruleExtensionValue();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getExtensionListValueRule());
                              								}
                              								add(
                              									current,
                              									"items",
                              									lv_items_3_0,
                              									"de.fraunhofer.ipa.ros.Basics.ExtensionValue");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalRosSystemParser.g:6808:6: ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )*
                            loop80:
                            do {
                                int alt80=2;
                                int LA80_0 = input.LA(1);

                                if ( ((LA80_0>=Duration && LA80_0<=Feedback)||(LA80_0>=Boolean && LA80_0<=Float64)||(LA80_0>=Message && LA80_0<=Service)||(LA80_0>=Base64 && LA80_0<=Action)||LA80_0==Result||(LA80_0>=String_1 && LA80_0<=Uint64)||LA80_0==Array||(LA80_0>=Int16 && LA80_0<=Int64)||(LA80_0>=Pub && LA80_0<=Sub)||(LA80_0>=Uint8 && LA80_0<=Any)||(LA80_0>=LeftSquareBracketRightSquareBracket && LA80_0<=Comma)||LA80_0==LeftSquareBracket||LA80_0==LeftCurlyBracket||(LA80_0>=RULE_BOOLEAN && LA80_0<=RULE_DOUBLE)||(LA80_0>=RULE_ID && LA80_0<=RULE_INT)||LA80_0==RULE_BEGIN) ) {
                                    alt80=1;
                                }


                                switch (alt80) {
                            	case 1 :
                            	    // InternalRosSystemParser.g:6809:7: (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) )
                            	    {
                            	    // InternalRosSystemParser.g:6809:7: (otherlv_4= Comma )?
                            	    int alt79=2;
                            	    int LA79_0 = input.LA(1);

                            	    if ( (LA79_0==Comma) ) {
                            	        alt79=1;
                            	    }
                            	    switch (alt79) {
                            	        case 1 :
                            	            // InternalRosSystemParser.g:6810:8: otherlv_4= Comma
                            	            {
                            	            otherlv_4=(Token)match(input,Comma,FOLLOW_55); if (state.failed) return current;
                            	            if ( state.backtracking==0 ) {

                            	              								newLeafNode(otherlv_4, grammarAccess.getExtensionListValueAccess().getCommaKeyword_1_1_1_1_0());
                            	              							
                            	            }

                            	            }
                            	            break;

                            	    }

                            	    // InternalRosSystemParser.g:6815:7: ( (lv_items_5_0= ruleExtensionValue ) )
                            	    // InternalRosSystemParser.g:6816:8: (lv_items_5_0= ruleExtensionValue )
                            	    {
                            	    // InternalRosSystemParser.g:6816:8: (lv_items_5_0= ruleExtensionValue )
                            	    // InternalRosSystemParser.g:6817:9: lv_items_5_0= ruleExtensionValue
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_57);
                            	    lv_items_5_0=ruleExtensionValue();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getExtensionListValueRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"items",
                            	      										lv_items_5_0,
                            	      										"de.fraunhofer.ipa.ros.Basics.ExtensionValue");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop80;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_1_1_2());
                      				
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
    // $ANTLR end "ruleExtensionListValue"


    // $ANTLR start "entryRuleExtensionBraceMapValue"
    // InternalRosSystemParser.g:6846:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRosSystemParser.g:6846:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRosSystemParser.g:6847:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
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
    // InternalRosSystemParser.g:6853:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6859:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRosSystemParser.g:6860:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRosSystemParser.g:6860:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRosSystemParser.g:6861:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRosSystemParser.g:6861:3: ()
            // InternalRosSystemParser.g:6862:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalRosSystemParser.g:6872:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( ((LA85_0>=Connections && LA85_0<=Processes)||(LA85_0>=FromFile && LA85_0<=Feedback)||LA85_0==Threads||(LA85_0>=Boolean && LA85_0<=Float64)||LA85_0==Message||LA85_0==Service||(LA85_0>=Base64 && LA85_0<=Action)||(LA85_0>=Nodes && LA85_0<=Uint64)||(LA85_0>=Value_1 && LA85_0<=Array)||(LA85_0>=From && LA85_0<=Int64)||(LA85_0>=Type_1 && LA85_0<=List)||(LA85_0>=Bool && LA85_0<=Node)||(LA85_0>=Time && LA85_0<=Ns)||(LA85_0>=RULE_ID && LA85_0<=RULE_STRING)) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalRosSystemParser.g:6873:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRosSystemParser.g:6873:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRosSystemParser.g:6874:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRosSystemParser.g:6874:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRosSystemParser.g:6875:6: lv_entries_2_0= ruleExtensionEntry
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_53);
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

                    // InternalRosSystemParser.g:6892:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( ((LA84_0>=Connections && LA84_0<=Processes)||(LA84_0>=FromFile && LA84_0<=Feedback)||LA84_0==Threads||(LA84_0>=Boolean && LA84_0<=Float64)||LA84_0==Message||LA84_0==Service||(LA84_0>=Base64 && LA84_0<=Action)||(LA84_0>=Nodes && LA84_0<=Uint64)||(LA84_0>=Value_1 && LA84_0<=Array)||(LA84_0>=From && LA84_0<=Int64)||(LA84_0>=Type_1 && LA84_0<=List)||(LA84_0>=Bool && LA84_0<=Node)||(LA84_0>=Time && LA84_0<=Ns)||LA84_0==Comma||(LA84_0>=RULE_ID && LA84_0<=RULE_STRING)) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // InternalRosSystemParser.g:6893:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRosSystemParser.g:6893:5: (otherlv_3= Comma )?
                    	    int alt83=2;
                    	    int LA83_0 = input.LA(1);

                    	    if ( (LA83_0==Comma) ) {
                    	        alt83=1;
                    	    }
                    	    switch (alt83) {
                    	        case 1 :
                    	            // InternalRosSystemParser.g:6894:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_50); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosSystemParser.g:6899:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRosSystemParser.g:6900:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosSystemParser.g:6900:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRosSystemParser.g:6901:7: lv_entries_4_0= ruleExtensionEntry
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_53);
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
                    	    break loop84;
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
    // InternalRosSystemParser.g:6928:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRosSystemParser.g:6928:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRosSystemParser.g:6929:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
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
    // InternalRosSystemParser.g:6935:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:6941:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRosSystemParser.g:6942:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRosSystemParser.g:6942:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRosSystemParser.g:6943:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRosSystemParser.g:6943:3: ()
            // InternalRosSystemParser.g:6944:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
              					current);
              			
            }

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
              		
            }
            // InternalRosSystemParser.g:6954:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt86=0;
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( ((LA86_0>=Connections && LA86_0<=Processes)||(LA86_0>=FromFile && LA86_0<=Feedback)||LA86_0==Threads||(LA86_0>=Boolean && LA86_0<=Float64)||LA86_0==Message||LA86_0==Service||(LA86_0>=Base64 && LA86_0<=Action)||(LA86_0>=Nodes && LA86_0<=Uint64)||(LA86_0>=Value_1 && LA86_0<=Array)||(LA86_0>=From && LA86_0<=Int64)||(LA86_0>=Type_1 && LA86_0<=List)||(LA86_0>=Bool && LA86_0<=Node)||(LA86_0>=Time && LA86_0<=Ns)||(LA86_0>=RULE_ID && LA86_0<=RULE_STRING)) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalRosSystemParser.g:6955:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRosSystemParser.g:6955:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRosSystemParser.g:6956:5: lv_entries_2_0= ruleExtensionEntry
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_51);
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
            	    if ( cnt86 >= 1 ) break loop86;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(86, input);
                        throw eee;
                }
                cnt86++;
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
    // InternalRosSystemParser.g:6981:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRosSystemParser.g:6981:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRosSystemParser.g:6982:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
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
    // InternalRosSystemParser.g:6988:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
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
            // InternalRosSystemParser.g:6994:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRosSystemParser.g:6995:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRosSystemParser.g:6995:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRosSystemParser.g:6996:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRosSystemParser.g:6996:3: ()
            // InternalRosSystemParser.g:6997:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:7003:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRosSystemParser.g:7004:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRosSystemParser.g:7004:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRosSystemParser.g:7005:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRosSystemParser.g:7005:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt87=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt87=1;
                }
                break;
            case Sub:
                {
                alt87=2;
                }
                break;
            case Ss:
                {
                alt87=3;
                }
                break;
            case Sc:
                {
                alt87=4;
                }
                break;
            case As:
                {
                alt87=5;
                }
                break;
            case Ac:
                {
                alt87=6;
                }
                break;
            case Param:
                {
                alt87=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalRosSystemParser.g:7006:6: lv_refKind_1_1= Pub
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
                    // InternalRosSystemParser.g:7017:6: lv_refKind_1_2= Sub
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
                    // InternalRosSystemParser.g:7028:6: lv_refKind_1_3= Ss
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
                    // InternalRosSystemParser.g:7039:6: lv_refKind_1_4= Sc
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
                    // InternalRosSystemParser.g:7050:6: lv_refKind_1_5= As
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
                    // InternalRosSystemParser.g:7061:6: lv_refKind_1_6= Ac
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
                    // InternalRosSystemParser.g:7072:6: lv_refKind_1_7= Param
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

            // InternalRosSystemParser.g:7085:3: ( ( ruleEString ) )
            // InternalRosSystemParser.g:7086:4: ( ruleEString )
            {
            // InternalRosSystemParser.g:7086:4: ( ruleEString )
            // InternalRosSystemParser.g:7087:5: ruleEString
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
    // InternalRosSystemParser.g:7105:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRosSystemParser.g:7105:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRosSystemParser.g:7106:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
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
    // InternalRosSystemParser.g:7112:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:7118:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRosSystemParser.g:7119:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRosSystemParser.g:7119:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRosSystemParser.g:7120:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRosSystemParser.g:7120:3: ()
            // InternalRosSystemParser.g:7121:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
              					current);
              			
            }

            }

            // InternalRosSystemParser.g:7127:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRosSystemParser.g:7128:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRosSystemParser.g:7128:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRosSystemParser.g:7129:5: lv_value_1_0= ruleExtensionScalarLiteral
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
    // InternalRosSystemParser.g:7150:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRosSystemParser.g:7150:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRosSystemParser.g:7151:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
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
    // InternalRosSystemParser.g:7157:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRosSystemParser.g:7163:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRosSystemParser.g:7164:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRosSystemParser.g:7164:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt88=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt88=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt88=2;
                }
                break;
            case RULE_DECINT:
                {
                alt88=3;
                }
                break;
            case RULE_INT:
                {
                alt88=4;
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
                alt88=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalRosSystemParser.g:7165:3: this_BOOLEAN_0= RULE_BOOLEAN
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
                    // InternalRosSystemParser.g:7173:3: this_DOUBLE_1= RULE_DOUBLE
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
                    // InternalRosSystemParser.g:7181:3: this_DECINT_2= RULE_DECINT
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
                    // InternalRosSystemParser.g:7189:3: this_INT_3= RULE_INT
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
                    // InternalRosSystemParser.g:7197:3: this_ExtensionKey_4= ruleExtensionKey
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
        // InternalRosSystemParser.g:1523:4: ( ruleRosSystemConnection )
        // InternalRosSystemParser.g:1523:5: ruleRosSystemConnection
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
        // InternalRosSystemParser.g:1629:4: ( ruleRosTopicConnection )
        // InternalRosSystemParser.g:1629:5: ruleRosTopicConnection
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
        // InternalRosSystemParser.g:1641:4: ( ruleRosServiceConnection )
        // InternalRosSystemParser.g:1641:5: ruleRosServiceConnection
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


    protected DFA31 dfa31 = new DFA31(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA64 dfa64 = new DFA64(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\143\1\147\1\166\2\142\1\166\2\150\1\0\2\uffff";
    static final String dfa_3s = "\1\143\1\147\1\167\2\142\1\167\2\150\1\0\2\uffff";
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

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1521:2: ( ( ( ruleRosSystemConnection )=>this_RosSystemConnection_0= ruleRosSystemConnection ) | this_RosConnection_1= ruleRosConnection )";
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
                        if ( (synpred1_InternalRosSystemParser()) ) {s = 9;}

                        else if ( (true) ) {s = 10;}

                         
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
    static final String dfa_7s = "\14\uffff";
    static final String dfa_8s = "\1\143\1\147\1\166\2\142\1\166\2\150\1\0\3\uffff";
    static final String dfa_9s = "\1\143\1\147\1\167\2\142\1\167\2\150\1\0\3\uffff";
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

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "1627:2: ( ( ( ruleRosTopicConnection )=>this_RosTopicConnection_0= ruleRosTopicConnection ) | ( ( ruleRosServiceConnection )=>this_RosServiceConnection_1= ruleRosServiceConnection ) | this_RosActionConnection_2= ruleRosActionConnection )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_8 = input.LA(1);

                         
                        int index32_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRosSystemParser()) ) {s = 9;}

                        else if ( (synpred3_InternalRosSystemParser()) ) {s = 10;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index32_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\1\10\2\11\10\uffff";
    static final String dfa_14s = "\3\72\4\uffff\1\142\3\uffff";
    static final String dfa_15s = "\3\173\4\uffff\1\172\3\uffff";
    static final String dfa_16s = "\3\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_17s = "\13\uffff}>";
    static final String[] dfa_18s = {
            "\1\10\47\uffff\1\10\4\uffff\1\7\1\10\3\uffff\1\3\1\6\1\4\1\5\6\uffff\1\2\1\1\3\uffff\1\10",
            "\1\11\47\uffff\1\11\2\uffff\1\10\2\uffff\1\11\15\uffff\2\11\3\uffff\1\11",
            "\1\11\47\uffff\1\11\2\uffff\1\10\2\uffff\1\11\15\uffff\2\11\3\uffff\1\11",
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

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_1;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "2566:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_19s = "\44\uffff";
    static final String dfa_20s = "\36\uffff\2\43\4\uffff";
    static final String dfa_21s = "\1\17\35\uffff\2\141\4\uffff";
    static final String dfa_22s = "\1\167\35\uffff\2\147\4\uffff";
    static final String dfa_23s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\2\uffff\1\40\1\41\1\37\1\36";
    static final String dfa_24s = "\44\uffff}>";
    static final String[] dfa_25s = {
            "\1\32\1\33\2\uffff\1\17\3\uffff\1\34\1\uffff\1\25\1\27\1\31\2\uffff\1\12\1\13\1\24\1\26\1\30\7\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\41\3\uffff\1\22\3\uffff\1\14\1\5\1\7\1\11\7\uffff\1\4\1\6\1\10\4\uffff\1\3\5\uffff\1\1\1\15\1\40\1\uffff\1\2\4\uffff\1\16\31\uffff\1\37\1\36",
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
            "\1\42\5\uffff\1\43",
            "\1\42\5\uffff\1\43",
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

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_19;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "4704:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0100000000022D00L,0x0800004000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x00C0000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0100000000002D00L,0x0800004000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x08C0000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0400000000000000L,0x08C0000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0800000800000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0100000001000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000010400000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0500000000003F00L,0x0800004000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0500000000002F00L,0x0800004000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0100000000002F00L,0x0800004000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000008200000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x00C0010000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0400000000000000L,0x00C0000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x000000000C060C00L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0100000000002D00L,0x0000004000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x00C0F08000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000080001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000D80030000000L,0x0000000000010002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000001L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0400000000000000L,0x00C0010000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000400100000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000002L,0x0000801000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0040801000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0400020000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x7F01F828F11E3F00L,0x00C00000F3F9F1E3L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x7F01F828F11E3F00L,0x08C00000F3F9F1E3L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x7F01F828F11E3F00L,0x00C00400F3F9F1E3L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x7F01F828F11E3F00L,0x00C00404F3F9F1E3L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x7A01F838F0180000L,0x05C0E2827FFFEDC2L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x7A01F838F0180000L,0x05C0E3827FFFEDC2L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x7A01F838F0180000L,0x05C0E3867FFFEDC2L});

}