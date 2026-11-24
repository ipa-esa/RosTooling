package de.fraunhofer.ipa.ros.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.fraunhofer.ipa.ros.services.RosGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRosParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ExternalDependency", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "Serviceclients", "Serviceservers", "Actionclients", "Actionservers", "Dependencies", "ParameterAny", "FromGitRepo", "Pluginslots", "Subscribers", "Implements", "Parameters", "Publishers", "Parameter", "GraphName", "Float32_2", "Float64_2", "Multiple", "Actions", "Default", "Duration", "Feedback", "Float32_1", "Float64_1", "Plugins", "Response", "String_3", "Uint16_2", "Uint32_2", "Uint64_2", "Boolean", "Integer", "Float32", "Float64", "Format", "Int16_2", "Int32_2", "Int64_2", "Library", "Message", "Param", "Request", "Service", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Uint8_2", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_2", "Byte_2", "Char_2", "Int16_1", "Int32_1", "Int64_1", "Int8_2", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Uint8_1", "Value_1", "Array", "Base", "Bool_1", "Byte_1", "Char_1", "Class", "Int16", "Int32", "Int64", "Int8_1", "Msgs", "Node_1", "Pub", "Srvs", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LessThanSignEqualsSign", "LeftSquareBracketRightSquareBracket", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Float32_1=29;
    public static final int Float32_2=22;
    public static final int Node=103;
    public static final int Uint64_2=36;
    public static final int RULE_DATE_TIME=130;
    public static final int Uint64_1=53;
    public static final int Serviceclients=8;
    public static final int String=58;
    public static final int Int16=81;
    public static final int Float32=39;
    public static final int Goal=100;
    public static final int Actionservers=11;
    public static final int Bool=97;
    public static final int Msgs=85;
    public static final int Uint16=70;
    public static final int Boolean=37;
    public static final int ExternalDependency=4;
    public static final int Sub=89;
    public static final int Uint8=91;
    public static final int Parameters=18;
    public static final int RULE_ID=131;
    public static final int Actions=25;
    public static final int RULE_DIGIT=120;
    public static final int GlobalNamespace=7;
    public static final int Node_1=86;
    public static final int Int16_2=42;
    public static final int Int16_1=64;
    public static final int Header=57;
    public static final int RULE_INT=133;
    public static final int Byte=98;
    public static final int RULE_ML_COMMENT=140;
    public static final int LeftSquareBracket=116;
    public static final int Pluginslots=15;
    public static final int Ac=95;
    public static final int Base64=55;
    public static final int Comma=112;
    public static final int As=96;
    public static final int RULE_MESSAGE_ASIGMENT=134;
    public static final int LeftSquareBracketRightSquareBracket=111;
    public static final int Int32=82;
    public static final int Char=99;
    public static final int Publishers=19;
    public static final int Srvs=88;
    public static final int LessThanSignEqualsSign=110;
    public static final int RightCurlyBracket=119;
    public static final int RULE_DECINT=123;
    public static final int Uint32=71;
    public static final int Plugins=31;
    public static final int FromGitRepo=14;
    public static final int FullStop=113;
    public static final int RULE_HOUR=128;
    public static final int Int8_2=67;
    public static final int Int8=101;
    public static final int Default=26;
    public static final int Int8_1=84;
    public static final int CommercialAt=115;
    public static final int Uint16_1=51;
    public static final int Sc=104;
    public static final int Type=107;
    public static final int Uint16_2=34;
    public static final int Float64=40;
    public static final int Int32_1=65;
    public static final int Int32_2=43;
    public static final int Parameter=20;
    public static final int RULE_BINARY=121;
    public static final int String_1=69;
    public static final int Subscribers=16;
    public static final int String_2=50;
    public static final int String_3=33;
    public static final int Ss=105;
    public static final int Actionclients=10;
    public static final int RULE_DAY=125;
    public static final int RULE_BEGIN=135;
    public static final int RULE_BOOLEAN=122;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=9;
    public static final int RULE_YEAR=127;
    public static final int Result=68;
    public static final int Name=102;
    public static final int RULE_MIN_SEC=129;
    public static final int Implements=17;
    public static final int Char_1=79;
    public static final int Char_2=63;
    public static final int Int64_2=44;
    public static final int ParameterAny=13;
    public static final int List=94;
    public static final int Dependencies=12;
    public static final int RightSquareBracket=117;
    public static final int PrivateNamespace=6;
    public static final int GraphName=21;
    public static final int Byte_2=62;
    public static final int Byte_1=78;
    public static final int Float64_2=23;
    public static final int Float64_1=30;
    public static final int Duration=27;
    public static final int Uint32_1=52;
    public static final int Uint32_2=35;
    public static final int Double=56;
    public static final int Type_1=90;
    public static final int Value=92;
    public static final int Class=80;
    public static final int Library=45;
    public static final int Uint64=72;
    public static final int Action=60;
    public static final int RULE_END=136;
    public static final int Message=46;
    public static final int Value_1=74;
    public static final int Time=106;
    public static final int RULE_STRING=132;
    public static final int Bool_1=77;
    public static final int Bool_2=61;
    public static final int Any=108;
    public static final int Struct=59;
    public static final int RULE_SL_COMMENT=137;
    public static final int Uint8_1=73;
    public static final int Format=41;
    public static final int Uint8_2=54;
    public static final int RULE_DOUBLE=124;
    public static final int Feedback=28;
    public static final int RULE_ROS_CONVENTION_A=138;
    public static final int RULE_ROS_CONVENTION_PARAM=139;
    public static final int Colon=114;
    public static final int Pub=87;
    public static final int EOF=-1;
    public static final int Multiple=24;
    public static final int Ns=109;
    public static final int RULE_WS=141;
    public static final int Request=48;
    public static final int Int64_1=66;
    public static final int LeftCurlyBracket=118;
    public static final int Service=49;
    public static final int RULE_ANY_OTHER=142;
    public static final int Base=76;
    public static final int Date=93;
    public static final int Response=32;
    public static final int Integer=38;
    public static final int Array=75;
    public static final int Int64=83;
    public static final int Param=47;
    public static final int RULE_MONTH=126;

    // delegates
    // delegators


        public InternalRosParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRosParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRosParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRosParser.g"; }



     	private RosGrammarAccess grammarAccess;

        public InternalRosParser(TokenStream input, RosGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "PackageSet";
       	}

       	@Override
       	protected RosGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePackageSet"
    // InternalRosParser.g:58:1: entryRulePackageSet returns [EObject current=null] : iv_rulePackageSet= rulePackageSet EOF ;
    public final EObject entryRulePackageSet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageSet = null;


        try {
            // InternalRosParser.g:58:51: (iv_rulePackageSet= rulePackageSet EOF )
            // InternalRosParser.g:59:2: iv_rulePackageSet= rulePackageSet EOF
            {
             newCompositeNode(grammarAccess.getPackageSetRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageSet=rulePackageSet();

            state._fsp--;

             current =iv_rulePackageSet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageSet"


    // $ANTLR start "rulePackageSet"
    // InternalRosParser.g:65:1: rulePackageSet returns [EObject current=null] : ( () ( (lv_package_1_0= rulePackage_Impl ) )* ) ;
    public final EObject rulePackageSet() throws RecognitionException {
        EObject current = null;

        EObject lv_package_1_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:71:2: ( ( () ( (lv_package_1_0= rulePackage_Impl ) )* ) )
            // InternalRosParser.g:72:2: ( () ( (lv_package_1_0= rulePackage_Impl ) )* )
            {
            // InternalRosParser.g:72:2: ( () ( (lv_package_1_0= rulePackage_Impl ) )* )
            // InternalRosParser.g:73:3: () ( (lv_package_1_0= rulePackage_Impl ) )*
            {
            // InternalRosParser.g:73:3: ()
            // InternalRosParser.g:74:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPackageSetAccess().getPackageSetAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:80:3: ( (lv_package_1_0= rulePackage_Impl ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Pluginslots||LA1_0==Implements||LA1_0==Parameter||LA1_0==Multiple||LA1_0==Plugins||LA1_0==Format||LA1_0==Library||LA1_0==Base||LA1_0==Class||LA1_0==Node||LA1_0==RULE_ID||LA1_0==RULE_ROS_CONVENTION_A) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRosParser.g:81:4: (lv_package_1_0= rulePackage_Impl )
            	    {
            	    // InternalRosParser.g:81:4: (lv_package_1_0= rulePackage_Impl )
            	    // InternalRosParser.g:82:5: lv_package_1_0= rulePackage_Impl
            	    {

            	    					newCompositeNode(grammarAccess.getPackageSetAccess().getPackagePackage_ImplParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_package_1_0=rulePackage_Impl();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageSetRule());
            	    					}
            	    					add(
            	    						current,
            	    						"package",
            	    						lv_package_1_0,
            	    						"de.fraunhofer.ipa.ros.Ros.Package_Impl");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageSet"


    // $ANTLR start "entryRulePackage_Impl"
    // InternalRosParser.g:103:1: entryRulePackage_Impl returns [EObject current=null] : iv_rulePackage_Impl= rulePackage_Impl EOF ;
    public final EObject entryRulePackage_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage_Impl = null;


        try {
            // InternalRosParser.g:103:53: (iv_rulePackage_Impl= rulePackage_Impl EOF )
            // InternalRosParser.g:104:2: iv_rulePackage_Impl= rulePackage_Impl EOF
            {
             newCompositeNode(grammarAccess.getPackage_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackage_Impl=rulePackage_Impl();

            state._fsp--;

             current =iv_rulePackage_Impl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage_Impl"


    // $ANTLR start "rulePackage_Impl"
    // InternalRosParser.g:110:1: rulePackage_Impl returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END ) ;
    public final EObject rulePackage_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token this_BEGIN_14=null;
        Token this_END_16=null;
        Token otherlv_17=null;
        Token this_BEGIN_18=null;
        Token this_END_20=null;
        Token otherlv_21=null;
        Token this_BEGIN_22=null;
        Token this_END_24=null;
        Token this_END_25=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_fromGitRepo_6_0 = null;

        EObject lv_dependency_9_0 = null;

        EObject lv_dependency_11_0 = null;

        EObject lv_spec_15_0 = null;

        EObject lv_spec_19_0 = null;

        EObject lv_spec_23_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:116:2: ( ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END ) )
            // InternalRosParser.g:117:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END )
            {
            // InternalRosParser.g:117:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END )
            // InternalRosParser.g:118:3: () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )? (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )? ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )* this_END_25= RULE_END
            {
            // InternalRosParser.g:118:3: ()
            // InternalRosParser.g:119:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPackage_ImplAccess().getPackageAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:125:3: ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Library||LA2_0==Class||LA2_0==Node||LA2_0==RULE_ID||LA2_0==RULE_ROS_CONVENTION_A) ) {
                alt2=1;
            }
            else if ( (LA2_0==Pluginslots||LA2_0==Implements||LA2_0==Parameter||LA2_0==Multiple||LA2_0==Plugins||LA2_0==Format||LA2_0==Base) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalRosParser.g:126:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:126:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    // InternalRosParser.g:127:5: ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:127:5: ( (lv_name_1_0= ruleRosNames ) )
                    // InternalRosParser.g:128:6: (lv_name_1_0= ruleRosNames )
                    {
                    // InternalRosParser.g:128:6: (lv_name_1_0= ruleRosNames )
                    // InternalRosParser.g:129:7: lv_name_1_0= ruleRosNames
                    {

                    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameRosNamesParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleRosNames();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.RosNames");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getPackage_ImplAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:152:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:152:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:153:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:153:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:154:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_6); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_2());
            		
            // InternalRosParser.g:176:3: (otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==FromGitRepo) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalRosParser.g:177:4: otherlv_5= FromGitRepo ( (lv_fromGitRepo_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,FromGitRepo,FOLLOW_7); 

                    				newLeafNode(otherlv_5, grammarAccess.getPackage_ImplAccess().getFromGitRepoKeyword_3_0());
                    			
                    // InternalRosParser.g:181:4: ( (lv_fromGitRepo_6_0= ruleEString ) )
                    // InternalRosParser.g:182:5: (lv_fromGitRepo_6_0= ruleEString )
                    {
                    // InternalRosParser.g:182:5: (lv_fromGitRepo_6_0= ruleEString )
                    // InternalRosParser.g:183:6: lv_fromGitRepo_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getFromGitRepoEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_fromGitRepo_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    						}
                    						set(
                    							current,
                    							"fromGitRepo",
                    							lv_fromGitRepo_6_0,
                    							"de.fraunhofer.ipa.ros.Ros.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRosParser.g:201:3: (otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Dependencies) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalRosParser.g:202:4: otherlv_7= Dependencies otherlv_8= LeftSquareBracket ( (lv_dependency_9_0= ruleDependency ) ) (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )* otherlv_12= RightSquareBracket
                    {
                    otherlv_7=(Token)match(input,Dependencies,FOLLOW_9); 

                    				newLeafNode(otherlv_7, grammarAccess.getPackage_ImplAccess().getDependenciesKeyword_4_0());
                    			
                    otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_10); 

                    				newLeafNode(otherlv_8, grammarAccess.getPackage_ImplAccess().getLeftSquareBracketKeyword_4_1());
                    			
                    // InternalRosParser.g:210:4: ( (lv_dependency_9_0= ruleDependency ) )
                    // InternalRosParser.g:211:5: (lv_dependency_9_0= ruleDependency )
                    {
                    // InternalRosParser.g:211:5: (lv_dependency_9_0= ruleDependency )
                    // InternalRosParser.g:212:6: lv_dependency_9_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_dependency_9_0=ruleDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    						}
                    						add(
                    							current,
                    							"dependency",
                    							lv_dependency_9_0,
                    							"de.fraunhofer.ipa.ros.Ros.Dependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRosParser.g:229:4: (otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==Comma) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalRosParser.g:230:5: otherlv_10= Comma ( (lv_dependency_11_0= ruleDependency ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Comma,FOLLOW_10); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getPackage_ImplAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalRosParser.g:234:5: ( (lv_dependency_11_0= ruleDependency ) )
                    	    // InternalRosParser.g:235:6: (lv_dependency_11_0= ruleDependency )
                    	    {
                    	    // InternalRosParser.g:235:6: (lv_dependency_11_0= ruleDependency )
                    	    // InternalRosParser.g:236:7: lv_dependency_11_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_dependency_11_0=ruleDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependency",
                    	    								lv_dependency_11_0,
                    	    								"de.fraunhofer.ipa.ros.Ros.Dependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_12); 

                    				newLeafNode(otherlv_12, grammarAccess.getPackage_ImplAccess().getRightSquareBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalRosParser.g:259:3: ( (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END ) | (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END ) | (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END ) )*
            loop9:
            do {
                int alt9=4;
                switch ( input.LA(1) ) {
                case Msgs:
                    {
                    alt9=1;
                    }
                    break;
                case Srvs:
                    {
                    alt9=2;
                    }
                    break;
                case Actions:
                    {
                    alt9=3;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // InternalRosParser.g:260:4: (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END )
            	    {
            	    // InternalRosParser.g:260:4: (otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END )
            	    // InternalRosParser.g:261:5: otherlv_13= Msgs this_BEGIN_14= RULE_BEGIN ( (lv_spec_15_0= ruleTopicSpec ) )* this_END_16= RULE_END
            	    {
            	    otherlv_13=(Token)match(input,Msgs,FOLLOW_5); 

            	    					newLeafNode(otherlv_13, grammarAccess.getPackage_ImplAccess().getMsgsKeyword_5_0_0());
            	    				
            	    this_BEGIN_14=(Token)match(input,RULE_BEGIN,FOLLOW_13); 

            	    					newLeafNode(this_BEGIN_14, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_5_0_1());
            	    				
            	    // InternalRosParser.g:269:5: ( (lv_spec_15_0= ruleTopicSpec ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==Library||(LA6_0>=Header && LA6_0<=String)||LA6_0==Class||(LA6_0>=RULE_ID && LA6_0<=RULE_STRING)) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalRosParser.g:270:6: (lv_spec_15_0= ruleTopicSpec )
            	    	    {
            	    	    // InternalRosParser.g:270:6: (lv_spec_15_0= ruleTopicSpec )
            	    	    // InternalRosParser.g:271:7: lv_spec_15_0= ruleTopicSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecTopicSpecParserRuleCall_5_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_13);
            	    	    lv_spec_15_0=ruleTopicSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_15_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.TopicSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    this_END_16=(Token)match(input,RULE_END,FOLLOW_12); 

            	    					newLeafNode(this_END_16, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_5_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosParser.g:294:4: (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END )
            	    {
            	    // InternalRosParser.g:294:4: (otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END )
            	    // InternalRosParser.g:295:5: otherlv_17= Srvs this_BEGIN_18= RULE_BEGIN ( (lv_spec_19_0= ruleServiceSpec ) )* this_END_20= RULE_END
            	    {
            	    otherlv_17=(Token)match(input,Srvs,FOLLOW_5); 

            	    					newLeafNode(otherlv_17, grammarAccess.getPackage_ImplAccess().getSrvsKeyword_5_1_0());
            	    				
            	    this_BEGIN_18=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_18, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_5_1_1());
            	    				
            	    // InternalRosParser.g:303:5: ( (lv_spec_19_0= ruleServiceSpec ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==Library||LA7_0==Class||(LA7_0>=RULE_ID && LA7_0<=RULE_STRING)) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalRosParser.g:304:6: (lv_spec_19_0= ruleServiceSpec )
            	    	    {
            	    	    // InternalRosParser.g:304:6: (lv_spec_19_0= ruleServiceSpec )
            	    	    // InternalRosParser.g:305:7: lv_spec_19_0= ruleServiceSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecServiceSpecParserRuleCall_5_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_spec_19_0=ruleServiceSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_19_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);

            	    this_END_20=(Token)match(input,RULE_END,FOLLOW_12); 

            	    					newLeafNode(this_END_20, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_5_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosParser.g:328:4: (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END )
            	    {
            	    // InternalRosParser.g:328:4: (otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END )
            	    // InternalRosParser.g:329:5: otherlv_21= Actions this_BEGIN_22= RULE_BEGIN ( (lv_spec_23_0= ruleActionSpec ) )* this_END_24= RULE_END
            	    {
            	    otherlv_21=(Token)match(input,Actions,FOLLOW_5); 

            	    					newLeafNode(otherlv_21, grammarAccess.getPackage_ImplAccess().getActionsKeyword_5_2_0());
            	    				
            	    this_BEGIN_22=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_22, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_5_2_1());
            	    				
            	    // InternalRosParser.g:337:5: ( (lv_spec_23_0= ruleActionSpec ) )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==Library||LA8_0==Class||(LA8_0>=RULE_ID && LA8_0<=RULE_STRING)) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalRosParser.g:338:6: (lv_spec_23_0= ruleActionSpec )
            	    	    {
            	    	    // InternalRosParser.g:338:6: (lv_spec_23_0= ruleActionSpec )
            	    	    // InternalRosParser.g:339:7: lv_spec_23_0= ruleActionSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecActionSpecParserRuleCall_5_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_spec_23_0=ruleActionSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_23_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);

            	    this_END_24=(Token)match(input,RULE_END,FOLLOW_12); 

            	    					newLeafNode(this_END_24, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_5_2_3());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            this_END_25=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_25, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage_Impl"


    // $ANTLR start "entryRuleTopicSpec"
    // InternalRosParser.g:370:1: entryRuleTopicSpec returns [EObject current=null] : iv_ruleTopicSpec= ruleTopicSpec EOF ;
    public final EObject entryRuleTopicSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicSpec = null;


        try {
            // InternalRosParser.g:370:50: (iv_ruleTopicSpec= ruleTopicSpec EOF )
            // InternalRosParser.g:371:2: iv_ruleTopicSpec= ruleTopicSpec EOF
            {
             newCompositeNode(grammarAccess.getTopicSpecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTopicSpec=ruleTopicSpec();

            state._fsp--;

             current =iv_ruleTopicSpec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopicSpec"


    // $ANTLR start "ruleTopicSpec"
    // InternalRosParser.g:377:1: ruleTopicSpec returns [EObject current=null] : ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) ;
    public final EObject ruleTopicSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        Token this_END_7=null;
        AntlrDatatypeRuleToken lv_name_1_1 = null;

        EObject lv_message_5_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:383:2: ( ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) )
            // InternalRosParser.g:384:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            {
            // InternalRosParser.g:384:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            // InternalRosParser.g:385:3: () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END
            {
            // InternalRosParser.g:385:3: ()
            // InternalRosParser.g:386:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTopicSpecAccess().getTopicSpecAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:392:3: ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) )
            // InternalRosParser.g:393:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            {
            // InternalRosParser.g:393:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            // InternalRosParser.g:394:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            {
            // InternalRosParser.g:394:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            int alt10=3;
            switch ( input.LA(1) ) {
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt10=1;
                }
                break;
            case Header:
                {
                alt10=2;
                }
                break;
            case String:
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
                    // InternalRosParser.g:395:6: lv_name_1_1= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getTopicSpecAccess().getNameEStringParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_1_1=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTopicSpecRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_1,
                    							"de.fraunhofer.ipa.ros.Ros.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:411:6: lv_name_1_2= Header
                    {
                    lv_name_1_2=(Token)match(input,Header,FOLLOW_5); 

                    						newLeafNode(lv_name_1_2, grammarAccess.getTopicSpecAccess().getNameHeaderKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopicSpecRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:422:6: lv_name_1_3= String
                    {
                    lv_name_1_3=(Token)match(input,String,FOLLOW_5); 

                    						newLeafNode(lv_name_1_3, grammarAccess.getTopicSpecAccess().getNameStringKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopicSpecRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_3, null);
                    					

                    }
                    break;

            }


            }


            }

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_15); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Message,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getTopicSpecAccess().getMessageKeyword_3());
            		
            // InternalRosParser.g:443:3: (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_BEGIN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRosParser.g:444:4: this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRosParser.g:448:4: ( (lv_message_5_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:449:5: (lv_message_5_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:449:5: (lv_message_5_0= ruleMessageDefinition )
                    // InternalRosParser.g:450:6: lv_message_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getTopicSpecAccess().getMessageMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_message_5_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTopicSpecRule());
                    						}
                    						set(
                    							current,
                    							"message",
                    							lv_message_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_18); 

                    				newLeafNode(this_END_6, grammarAccess.getTopicSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            this_END_7=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_7, grammarAccess.getTopicSpecAccess().getENDTerminalRuleCall_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopicSpec"


    // $ANTLR start "entryRuleServiceSpec"
    // InternalRosParser.g:480:1: entryRuleServiceSpec returns [EObject current=null] : iv_ruleServiceSpec= ruleServiceSpec EOF ;
    public final EObject entryRuleServiceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceSpec = null;


        try {
            // InternalRosParser.g:480:52: (iv_ruleServiceSpec= ruleServiceSpec EOF )
            // InternalRosParser.g:481:2: iv_ruleServiceSpec= ruleServiceSpec EOF
            {
             newCompositeNode(grammarAccess.getServiceSpecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceSpec=ruleServiceSpec();

            state._fsp--;

             current =iv_ruleServiceSpec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceSpec"


    // $ANTLR start "ruleServiceSpec"
    // InternalRosParser.g:487:1: ruleServiceSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) ;
    public final EObject ruleServiceSpec() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Token this_END_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_request_5_0 = null;

        EObject lv_response_9_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:493:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) )
            // InternalRosParser.g:494:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            {
            // InternalRosParser.g:494:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            // InternalRosParser.g:495:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END
            {
            // InternalRosParser.g:495:3: ()
            // InternalRosParser.g:496:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceSpecAccess().getServiceSpecAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:502:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:503:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:503:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:504:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceSpecAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceSpecRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Ros.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_19); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Request,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceSpecAccess().getRequestKeyword_3());
            		
            // InternalRosParser.g:529:3: (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_BEGIN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRosParser.g:530:4: this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRosParser.g:534:4: ( (lv_request_5_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:535:5: (lv_request_5_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:535:5: (lv_request_5_0= ruleMessageDefinition )
                    // InternalRosParser.g:536:6: lv_request_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getServiceSpecAccess().getRequestMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_request_5_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceSpecRule());
                    						}
                    						set(
                    							current,
                    							"request",
                    							lv_request_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_21); 

                    				newLeafNode(this_END_6, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,Response,FOLLOW_16); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceSpecAccess().getResponseKeyword_5());
            		
            // InternalRosParser.g:562:3: (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_BEGIN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRosParser.g:563:4: this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRosParser.g:567:4: ( (lv_response_9_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:568:5: (lv_response_9_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:568:5: (lv_response_9_0= ruleMessageDefinition )
                    // InternalRosParser.g:569:6: lv_response_9_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getServiceSpecAccess().getResponseMessageDefinitionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_response_9_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceSpecRule());
                    						}
                    						set(
                    							current,
                    							"response",
                    							lv_response_9_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_18); 

                    				newLeafNode(this_END_10, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_6_2());
                    			

                    }
                    break;

            }

            this_END_11=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_11, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceSpec"


    // $ANTLR start "entryRuleActionSpec"
    // InternalRosParser.g:599:1: entryRuleActionSpec returns [EObject current=null] : iv_ruleActionSpec= ruleActionSpec EOF ;
    public final EObject entryRuleActionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSpec = null;


        try {
            // InternalRosParser.g:599:51: (iv_ruleActionSpec= ruleActionSpec EOF )
            // InternalRosParser.g:600:2: iv_ruleActionSpec= ruleActionSpec EOF
            {
             newCompositeNode(grammarAccess.getActionSpecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionSpec=ruleActionSpec();

            state._fsp--;

             current =iv_ruleActionSpec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionSpec"


    // $ANTLR start "ruleActionSpec"
    // InternalRosParser.g:606:1: ruleActionSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) ;
    public final EObject ruleActionSpec() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_2=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token this_END_6=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Token otherlv_11=null;
        Token this_BEGIN_12=null;
        Token this_END_14=null;
        Token this_END_15=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_goal_5_0 = null;

        EObject lv_result_9_0 = null;

        EObject lv_feedback_13_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:612:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) )
            // InternalRosParser.g:613:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            {
            // InternalRosParser.g:613:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            // InternalRosParser.g:614:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END
            {
            // InternalRosParser.g:614:3: ()
            // InternalRosParser.g:615:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionSpecAccess().getActionSpecAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:621:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:622:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:622:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:623:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionSpecAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActionSpecRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Ros.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Goal,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getActionSpecAccess().getGoalKeyword_3());
            		
            // InternalRosParser.g:648:3: (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_BEGIN) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRosParser.g:649:4: this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRosParser.g:653:4: ( (lv_goal_5_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:654:5: (lv_goal_5_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:654:5: (lv_goal_5_0= ruleMessageDefinition )
                    // InternalRosParser.g:655:6: lv_goal_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getGoalMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_goal_5_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionSpecRule());
                    						}
                    						set(
                    							current,
                    							"goal",
                    							lv_goal_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_24); 

                    				newLeafNode(this_END_6, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,Result,FOLLOW_25); 

            			newLeafNode(otherlv_7, grammarAccess.getActionSpecAccess().getResultKeyword_5());
            		
            // InternalRosParser.g:681:3: (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_BEGIN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRosParser.g:682:4: this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRosParser.g:686:4: ( (lv_result_9_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:687:5: (lv_result_9_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:687:5: (lv_result_9_0= ruleMessageDefinition )
                    // InternalRosParser.g:688:6: lv_result_9_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getResultMessageDefinitionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_result_9_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionSpecRule());
                    						}
                    						set(
                    							current,
                    							"result",
                    							lv_result_9_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_26); 

                    				newLeafNode(this_END_10, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_6_2());
                    			

                    }
                    break;

            }

            otherlv_11=(Token)match(input,Feedback,FOLLOW_16); 

            			newLeafNode(otherlv_11, grammarAccess.getActionSpecAccess().getFeedbackKeyword_7());
            		
            // InternalRosParser.g:714:3: (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_BEGIN) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRosParser.g:715:4: this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END
                    {
                    this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_12, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_8_0());
                    			
                    // InternalRosParser.g:719:4: ( (lv_feedback_13_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:720:5: (lv_feedback_13_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:720:5: (lv_feedback_13_0= ruleMessageDefinition )
                    // InternalRosParser.g:721:6: lv_feedback_13_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getFeedbackMessageDefinitionParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_feedback_13_0=ruleMessageDefinition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionSpecRule());
                    						}
                    						set(
                    							current,
                    							"feedback",
                    							lv_feedback_13_0,
                    							"de.fraunhofer.ipa.ros.Ros.MessageDefinition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    this_END_14=(Token)match(input,RULE_END,FOLLOW_18); 

                    				newLeafNode(this_END_14, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_8_2());
                    			

                    }
                    break;

            }

            this_END_15=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_15, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionSpec"


    // $ANTLR start "entryRuleMessageDefinition"
    // InternalRosParser.g:751:1: entryRuleMessageDefinition returns [EObject current=null] : iv_ruleMessageDefinition= ruleMessageDefinition EOF ;
    public final EObject entryRuleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageDefinition = null;


        try {
            // InternalRosParser.g:751:58: (iv_ruleMessageDefinition= ruleMessageDefinition EOF )
            // InternalRosParser.g:752:2: iv_ruleMessageDefinition= ruleMessageDefinition EOF
            {
             newCompositeNode(grammarAccess.getMessageDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessageDefinition=ruleMessageDefinition();

            state._fsp--;

             current =iv_ruleMessageDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessageDefinition"


    // $ANTLR start "ruleMessageDefinition"
    // InternalRosParser.g:758:1: ruleMessageDefinition returns [EObject current=null] : ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) ;
    public final EObject ruleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_MessagePart_1_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:764:2: ( ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) )
            // InternalRosParser.g:765:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            {
            // InternalRosParser.g:765:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            // InternalRosParser.g:766:3: () ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            {
            // InternalRosParser.g:766:3: ()
            // InternalRosParser.g:767:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMessageDefinitionAccess().getMessageDefinitionAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:773:3: ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=Float32_2 && LA17_0<=Float64_2)||LA17_0==Duration||(LA17_0>=Float32_1 && LA17_0<=Float64_1)||(LA17_0>=String_3 && LA17_0<=Uint64_2)||(LA17_0>=Float32 && LA17_0<=Float64)||(LA17_0>=Int16_2 && LA17_0<=Library)||(LA17_0>=String_2 && LA17_0<=Uint8_2)||LA17_0==Header||(LA17_0>=Bool_2 && LA17_0<=Int8_2)||(LA17_0>=String_1 && LA17_0<=Uint8_1)||(LA17_0>=Bool_1 && LA17_0<=Int8_1)||LA17_0==Uint8||(LA17_0>=Bool && LA17_0<=Char)||LA17_0==Int8||LA17_0==Time||(LA17_0>=RULE_ID && LA17_0<=RULE_STRING)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalRosParser.g:774:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    {
            	    // InternalRosParser.g:774:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    // InternalRosParser.g:775:5: lv_MessagePart_1_0= ruleMessagePart
            	    {

            	    					newCompositeNode(grammarAccess.getMessageDefinitionAccess().getMessagePartMessagePartParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_27);
            	    lv_MessagePart_1_0=ruleMessagePart();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMessageDefinitionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"MessagePart",
            	    						lv_MessagePart_1_0,
            	    						"de.fraunhofer.ipa.ros.Basics.MessagePart");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessageDefinition"


    // $ANTLR start "entryRuleNode"
    // InternalRosParser.g:796:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalRosParser.g:796:45: (iv_ruleNode= ruleNode EOF )
            // InternalRosParser.g:797:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalRosParser.g:803:1: ruleNode returns [EObject current=null] : (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token this_END_5=null;
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
        Token otherlv_26=null;
        Token this_BEGIN_27=null;
        Token this_END_29=null;
        Token otherlv_30=null;
        Token this_BEGIN_31=null;
        Token this_END_33=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_publisher_4_0 = null;

        EObject lv_subscriber_8_0 = null;

        EObject lv_serviceserver_12_0 = null;

        EObject lv_serviceclient_16_0 = null;

        EObject lv_actionserver_20_0 = null;

        EObject lv_actionclient_24_0 = null;

        EObject lv_parameter_28_0 = null;

        EObject lv_pluginSlots_32_0 = null;

        EObject lv_extensions_34_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:809:2: ( (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) )
            // InternalRosParser.g:810:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            {
            // InternalRosParser.g:810:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            // InternalRosParser.g:811:3: otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            {
            otherlv_0=(Token)match(input,Node_1,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
            		
            // InternalRosParser.g:815:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRosParser.g:816:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRosParser.g:816:4: (lv_name_1_0= ruleRosNames )
            // InternalRosParser.g:817:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_29);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNodeRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Ros.RosNames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:834:3: ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            loop26:
            do {
                int alt26=10;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt26=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt26=2;
                    }
                    break;
                case Serviceservers:
                    {
                    alt26=3;
                    }
                    break;
                case Serviceclients:
                    {
                    alt26=4;
                    }
                    break;
                case Actionservers:
                    {
                    alt26=5;
                    }
                    break;
                case Actionclients:
                    {
                    alt26=6;
                    }
                    break;
                case Parameters:
                    {
                    alt26=7;
                    }
                    break;
                case Pluginslots:
                    {
                    alt26=8;
                    }
                    break;
                case CommercialAt:
                    {
                    alt26=9;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // InternalRosParser.g:835:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    {
            	    // InternalRosParser.g:835:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    // InternalRosParser.g:836:5: otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END
            	    {
            	    otherlv_2=(Token)match(input,Publishers,FOLLOW_5); 

            	    					newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getPublishersKeyword_2_0_0());
            	    				
            	    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_3, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_0_1());
            	    				
            	    // InternalRosParser.g:844:5: ( (lv_publisher_4_0= rulePublisher ) )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==Pluginslots||LA18_0==Implements||LA18_0==Parameter||LA18_0==Multiple||LA18_0==Plugins||LA18_0==Format||LA18_0==Library||LA18_0==Base||LA18_0==Class||(LA18_0>=RULE_ID && LA18_0<=RULE_STRING)) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // InternalRosParser.g:845:6: (lv_publisher_4_0= rulePublisher )
            	    	    {
            	    	    // InternalRosParser.g:845:6: (lv_publisher_4_0= rulePublisher )
            	    	    // InternalRosParser.g:846:7: lv_publisher_4_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPublisherPublisherParserRuleCall_2_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_publisher_4_0=rulePublisher();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"publisher",
            	    	    								lv_publisher_4_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.Publisher");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);

            	    this_END_5=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_5, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosParser.g:869:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    {
            	    // InternalRosParser.g:869:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    // InternalRosParser.g:870:5: otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END
            	    {
            	    otherlv_6=(Token)match(input,Subscribers,FOLLOW_5); 

            	    					newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getSubscribersKeyword_2_1_0());
            	    				
            	    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_7, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_1_1());
            	    				
            	    // InternalRosParser.g:878:5: ( (lv_subscriber_8_0= ruleSubscriber ) )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==Pluginslots||LA19_0==Implements||LA19_0==Parameter||LA19_0==Multiple||LA19_0==Plugins||LA19_0==Format||LA19_0==Library||LA19_0==Base||LA19_0==Class||(LA19_0>=RULE_ID && LA19_0<=RULE_STRING)) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // InternalRosParser.g:879:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRosParser.g:879:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    // InternalRosParser.g:880:7: lv_subscriber_8_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getSubscriberSubscriberParserRuleCall_2_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_subscriber_8_0=ruleSubscriber();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"subscriber",
            	    	    								lv_subscriber_8_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.Subscriber");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop19;
            	        }
            	    } while (true);

            	    this_END_9=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_9, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosParser.g:903:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    {
            	    // InternalRosParser.g:903:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    // InternalRosParser.g:904:5: otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END
            	    {
            	    otherlv_10=(Token)match(input,Serviceservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getServiceserversKeyword_2_2_0());
            	    				
            	    this_BEGIN_11=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_11, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_2_1());
            	    				
            	    // InternalRosParser.g:912:5: ( (lv_serviceserver_12_0= ruleServiceServer ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Pluginslots||LA20_0==Implements||LA20_0==Parameter||LA20_0==Multiple||LA20_0==Plugins||LA20_0==Format||LA20_0==Library||LA20_0==Base||LA20_0==Class||(LA20_0>=RULE_ID && LA20_0<=RULE_STRING)) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // InternalRosParser.g:913:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRosParser.g:913:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    // InternalRosParser.g:914:7: lv_serviceserver_12_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceserverServiceServerParserRuleCall_2_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_serviceserver_12_0=ruleServiceServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceserver",
            	    	    								lv_serviceserver_12_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);

            	    this_END_13=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_13, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRosParser.g:937:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    {
            	    // InternalRosParser.g:937:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    // InternalRosParser.g:938:5: otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END
            	    {
            	    otherlv_14=(Token)match(input,Serviceclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getServiceclientsKeyword_2_3_0());
            	    				
            	    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_15, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_3_1());
            	    				
            	    // InternalRosParser.g:946:5: ( (lv_serviceclient_16_0= ruleServiceClient ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Pluginslots||LA21_0==Implements||LA21_0==Parameter||LA21_0==Multiple||LA21_0==Plugins||LA21_0==Format||LA21_0==Library||LA21_0==Base||LA21_0==Class||(LA21_0>=RULE_ID && LA21_0<=RULE_STRING)) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // InternalRosParser.g:947:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRosParser.g:947:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    // InternalRosParser.g:948:7: lv_serviceclient_16_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceclientServiceClientParserRuleCall_2_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_serviceclient_16_0=ruleServiceClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceclient",
            	    	    								lv_serviceclient_16_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop21;
            	        }
            	    } while (true);

            	    this_END_17=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_17, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRosParser.g:971:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    {
            	    // InternalRosParser.g:971:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    // InternalRosParser.g:972:5: otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END
            	    {
            	    otherlv_18=(Token)match(input,Actionservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getActionserversKeyword_2_4_0());
            	    				
            	    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_19, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_4_1());
            	    				
            	    // InternalRosParser.g:980:5: ( (lv_actionserver_20_0= ruleActionServer ) )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Pluginslots||LA22_0==Implements||LA22_0==Parameter||LA22_0==Multiple||LA22_0==Plugins||LA22_0==Format||LA22_0==Library||LA22_0==Base||LA22_0==Class||(LA22_0>=RULE_ID && LA22_0<=RULE_STRING)) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // InternalRosParser.g:981:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    {
            	    	    // InternalRosParser.g:981:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    // InternalRosParser.g:982:7: lv_actionserver_20_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionserverActionServerParserRuleCall_2_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_actionserver_20_0=ruleActionServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionserver",
            	    	    								lv_actionserver_20_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop22;
            	        }
            	    } while (true);

            	    this_END_21=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_21, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRosParser.g:1005:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    {
            	    // InternalRosParser.g:1005:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    // InternalRosParser.g:1006:5: otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END
            	    {
            	    otherlv_22=(Token)match(input,Actionclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getActionclientsKeyword_2_5_0());
            	    				
            	    this_BEGIN_23=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_23, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_5_1());
            	    				
            	    // InternalRosParser.g:1014:5: ( (lv_actionclient_24_0= ruleActionClient ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==Pluginslots||LA23_0==Implements||LA23_0==Parameter||LA23_0==Multiple||LA23_0==Plugins||LA23_0==Format||LA23_0==Library||LA23_0==Base||LA23_0==Class||(LA23_0>=RULE_ID && LA23_0<=RULE_STRING)) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1015:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    {
            	    	    // InternalRosParser.g:1015:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    // InternalRosParser.g:1016:7: lv_actionclient_24_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionclientActionClientParserRuleCall_2_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_actionclient_24_0=ruleActionClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionclient",
            	    	    								lv_actionclient_24_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);

            	    this_END_25=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_25, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRosParser.g:1039:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    {
            	    // InternalRosParser.g:1039:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    // InternalRosParser.g:1040:5: otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END
            	    {
            	    otherlv_26=(Token)match(input,Parameters,FOLLOW_5); 

            	    					newLeafNode(otherlv_26, grammarAccess.getNodeAccess().getParametersKeyword_2_6_0());
            	    				
            	    this_BEGIN_27=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_27, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_6_1());
            	    				
            	    // InternalRosParser.g:1048:5: ( (lv_parameter_28_0= ruleParameter ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Pluginslots||LA24_0==Implements||LA24_0==Parameter||LA24_0==Multiple||LA24_0==Plugins||LA24_0==Format||LA24_0==Library||LA24_0==Base||LA24_0==Class||(LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1049:6: (lv_parameter_28_0= ruleParameter )
            	    	    {
            	    	    // InternalRosParser.g:1049:6: (lv_parameter_28_0= ruleParameter )
            	    	    // InternalRosParser.g:1050:7: lv_parameter_28_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getParameterParameterParserRuleCall_2_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_parameter_28_0=ruleParameter();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"parameter",
            	    	    								lv_parameter_28_0,
            	    	    								"de.fraunhofer.ipa.ros.Basics.Parameter");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);

            	    this_END_29=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_29, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRosParser.g:1073:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    {
            	    // InternalRosParser.g:1073:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    // InternalRosParser.g:1074:5: otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END
            	    {
            	    otherlv_30=(Token)match(input,Pluginslots,FOLLOW_5); 

            	    					newLeafNode(otherlv_30, grammarAccess.getNodeAccess().getPluginslotsKeyword_2_7_0());
            	    				
            	    this_BEGIN_31=(Token)match(input,RULE_BEGIN,FOLLOW_31); 

            	    					newLeafNode(this_BEGIN_31, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_7_1());
            	    				
            	    // InternalRosParser.g:1082:5: ( (lv_pluginSlots_32_0= rulePluginSlot ) )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Pluginslots||LA25_0==Implements||LA25_0==Parameter||LA25_0==Multiple||LA25_0==Plugins||LA25_0==Format||LA25_0==Library||LA25_0==Base||LA25_0==Class||(LA25_0>=RULE_ID && LA25_0<=RULE_STRING)) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1083:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    {
            	    	    // InternalRosParser.g:1083:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    // InternalRosParser.g:1084:7: lv_pluginSlots_32_0= rulePluginSlot
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPluginSlotsPluginSlotParserRuleCall_2_7_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_31);
            	    	    lv_pluginSlots_32_0=rulePluginSlot();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getNodeRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"pluginSlots",
            	    	    								lv_pluginSlots_32_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.PluginSlot");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop25;
            	        }
            	    } while (true);

            	    this_END_33=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_33, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_7_3());
            	    				

            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRosParser.g:1107:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRosParser.g:1107:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    // InternalRosParser.g:1108:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    {
            	    // InternalRosParser.g:1108:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    // InternalRosParser.g:1109:6: lv_extensions_34_0= ruleExtensionBlock
            	    {

            	    						newCompositeNode(grammarAccess.getNodeAccess().getExtensionsExtensionBlockParserRuleCall_2_8_0());
            	    					
            	    pushFollow(FOLLOW_29);
            	    lv_extensions_34_0=ruleExtensionBlock();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNodeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"extensions",
            	    							lv_extensions_34_0,
            	    							"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRulePlugin"
    // InternalRosParser.g:1131:1: entryRulePlugin returns [EObject current=null] : iv_rulePlugin= rulePlugin EOF ;
    public final EObject entryRulePlugin() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlugin = null;


        try {
            // InternalRosParser.g:1131:47: (iv_rulePlugin= rulePlugin EOF )
            // InternalRosParser.g:1132:2: iv_rulePlugin= rulePlugin EOF
            {
             newCompositeNode(grammarAccess.getPluginRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlugin=rulePlugin();

            state._fsp--;

             current =iv_rulePlugin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlugin"


    // $ANTLR start "rulePlugin"
    // InternalRosParser.g:1138:1: rulePlugin returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END ) ;
    public final EObject rulePlugin() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Token otherlv_11=null;
        Token this_BEGIN_12=null;
        Token this_END_14=null;
        Token otherlv_15=null;
        Token this_BEGIN_16=null;
        Token this_END_18=null;
        Token otherlv_19=null;
        Token this_BEGIN_20=null;
        Token this_END_22=null;
        Token otherlv_23=null;
        Token this_BEGIN_24=null;
        Token this_END_26=null;
        Token otherlv_27=null;
        Token this_BEGIN_28=null;
        Token this_END_30=null;
        Token otherlv_31=null;
        Token this_BEGIN_32=null;
        Token this_END_34=null;
        Token this_END_36=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_publisher_9_0 = null;

        EObject lv_subscriber_13_0 = null;

        EObject lv_serviceserver_17_0 = null;

        EObject lv_serviceclient_21_0 = null;

        EObject lv_actionserver_25_0 = null;

        EObject lv_actionclient_29_0 = null;

        EObject lv_parameter_33_0 = null;

        EObject lv_extensions_35_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:1144:2: ( ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END ) )
            // InternalRosParser.g:1145:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END )
            {
            // InternalRosParser.g:1145:2: ( () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END )
            // InternalRosParser.g:1146:3: () ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Implements ( ( ruleQualifiedRef ) ) ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )* this_END_36= RULE_END
            {
            // InternalRosParser.g:1146:3: ()
            // InternalRosParser.g:1147:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginAccess().getPluginAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:1153:3: ( ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Library||LA27_0==Class||LA27_0==Node||LA27_0==RULE_ID||LA27_0==RULE_ROS_CONVENTION_A) ) {
                alt27=1;
            }
            else if ( (LA27_0==Pluginslots||LA27_0==Implements||LA27_0==Parameter||LA27_0==Multiple||LA27_0==Plugins||LA27_0==Format||LA27_0==Base) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalRosParser.g:1154:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:1154:4: ( ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon )
                    // InternalRosParser.g:1155:5: ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:1155:5: ( (lv_name_1_0= ruleRosNames ) )
                    // InternalRosParser.g:1156:6: (lv_name_1_0= ruleRosNames )
                    {
                    // InternalRosParser.g:1156:6: (lv_name_1_0= ruleRosNames )
                    // InternalRosParser.g:1157:7: lv_name_1_0= ruleRosNames
                    {

                    							newCompositeNode(grammarAccess.getPluginAccess().getNameRosNamesParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleRosNames();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPluginRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.RosNames");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getPluginAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1180:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:1180:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:1181:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:1181:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:1182:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPluginAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_32); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Implements,FOLLOW_33); 

            			newLeafNode(otherlv_5, grammarAccess.getPluginAccess().getImplementsKeyword_3());
            		
            // InternalRosParser.g:1208:3: ( ( ruleQualifiedRef ) )
            // InternalRosParser.g:1209:4: ( ruleQualifiedRef )
            {
            // InternalRosParser.g:1209:4: ( ruleQualifiedRef )
            // InternalRosParser.g:1210:5: ruleQualifiedRef
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPluginRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPluginAccess().getImplementsPluginBaseCrossReference_4_0());
            				
            pushFollow(FOLLOW_34);
            ruleQualifiedRef();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:1224:3: ( (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END ) | (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END ) | (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END ) | (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END ) | (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END ) | (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END ) | (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END ) | ( (lv_extensions_35_0= ruleExtensionBlock ) ) )*
            loop35:
            do {
                int alt35=9;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt35=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt35=2;
                    }
                    break;
                case Serviceservers:
                    {
                    alt35=3;
                    }
                    break;
                case Serviceclients:
                    {
                    alt35=4;
                    }
                    break;
                case Actionservers:
                    {
                    alt35=5;
                    }
                    break;
                case Actionclients:
                    {
                    alt35=6;
                    }
                    break;
                case Parameters:
                    {
                    alt35=7;
                    }
                    break;
                case CommercialAt:
                    {
                    alt35=8;
                    }
                    break;

                }

                switch (alt35) {
            	case 1 :
            	    // InternalRosParser.g:1225:4: (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END )
            	    {
            	    // InternalRosParser.g:1225:4: (otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END )
            	    // InternalRosParser.g:1226:5: otherlv_7= Publishers this_BEGIN_8= RULE_BEGIN ( (lv_publisher_9_0= rulePublisher ) )* this_END_10= RULE_END
            	    {
            	    otherlv_7=(Token)match(input,Publishers,FOLLOW_5); 

            	    					newLeafNode(otherlv_7, grammarAccess.getPluginAccess().getPublishersKeyword_5_0_0());
            	    				
            	    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_8, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_0_1());
            	    				
            	    // InternalRosParser.g:1234:5: ( (lv_publisher_9_0= rulePublisher ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Pluginslots||LA28_0==Implements||LA28_0==Parameter||LA28_0==Multiple||LA28_0==Plugins||LA28_0==Format||LA28_0==Library||LA28_0==Base||LA28_0==Class||(LA28_0>=RULE_ID && LA28_0<=RULE_STRING)) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1235:6: (lv_publisher_9_0= rulePublisher )
            	    	    {
            	    	    // InternalRosParser.g:1235:6: (lv_publisher_9_0= rulePublisher )
            	    	    // InternalRosParser.g:1236:7: lv_publisher_9_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getPublisherPublisherParserRuleCall_5_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_publisher_9_0=rulePublisher();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"publisher",
            	    	    								lv_publisher_9_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.Publisher");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop28;
            	        }
            	    } while (true);

            	    this_END_10=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_10, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosParser.g:1259:4: (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END )
            	    {
            	    // InternalRosParser.g:1259:4: (otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END )
            	    // InternalRosParser.g:1260:5: otherlv_11= Subscribers this_BEGIN_12= RULE_BEGIN ( (lv_subscriber_13_0= ruleSubscriber ) )* this_END_14= RULE_END
            	    {
            	    otherlv_11=(Token)match(input,Subscribers,FOLLOW_5); 

            	    					newLeafNode(otherlv_11, grammarAccess.getPluginAccess().getSubscribersKeyword_5_1_0());
            	    				
            	    this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_12, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_1_1());
            	    				
            	    // InternalRosParser.g:1268:5: ( (lv_subscriber_13_0= ruleSubscriber ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Pluginslots||LA29_0==Implements||LA29_0==Parameter||LA29_0==Multiple||LA29_0==Plugins||LA29_0==Format||LA29_0==Library||LA29_0==Base||LA29_0==Class||(LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1269:6: (lv_subscriber_13_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRosParser.g:1269:6: (lv_subscriber_13_0= ruleSubscriber )
            	    	    // InternalRosParser.g:1270:7: lv_subscriber_13_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getSubscriberSubscriberParserRuleCall_5_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_subscriber_13_0=ruleSubscriber();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"subscriber",
            	    	    								lv_subscriber_13_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.Subscriber");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop29;
            	        }
            	    } while (true);

            	    this_END_14=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_14, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosParser.g:1293:4: (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END )
            	    {
            	    // InternalRosParser.g:1293:4: (otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END )
            	    // InternalRosParser.g:1294:5: otherlv_15= Serviceservers this_BEGIN_16= RULE_BEGIN ( (lv_serviceserver_17_0= ruleServiceServer ) )* this_END_18= RULE_END
            	    {
            	    otherlv_15=(Token)match(input,Serviceservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_15, grammarAccess.getPluginAccess().getServiceserversKeyword_5_2_0());
            	    				
            	    this_BEGIN_16=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_16, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_2_1());
            	    				
            	    // InternalRosParser.g:1302:5: ( (lv_serviceserver_17_0= ruleServiceServer ) )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==Pluginslots||LA30_0==Implements||LA30_0==Parameter||LA30_0==Multiple||LA30_0==Plugins||LA30_0==Format||LA30_0==Library||LA30_0==Base||LA30_0==Class||(LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1303:6: (lv_serviceserver_17_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRosParser.g:1303:6: (lv_serviceserver_17_0= ruleServiceServer )
            	    	    // InternalRosParser.g:1304:7: lv_serviceserver_17_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceserverServiceServerParserRuleCall_5_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_serviceserver_17_0=ruleServiceServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceserver",
            	    	    								lv_serviceserver_17_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop30;
            	        }
            	    } while (true);

            	    this_END_18=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_18, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRosParser.g:1327:4: (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END )
            	    {
            	    // InternalRosParser.g:1327:4: (otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END )
            	    // InternalRosParser.g:1328:5: otherlv_19= Serviceclients this_BEGIN_20= RULE_BEGIN ( (lv_serviceclient_21_0= ruleServiceClient ) )* this_END_22= RULE_END
            	    {
            	    otherlv_19=(Token)match(input,Serviceclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_19, grammarAccess.getPluginAccess().getServiceclientsKeyword_5_3_0());
            	    				
            	    this_BEGIN_20=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_20, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_3_1());
            	    				
            	    // InternalRosParser.g:1336:5: ( (lv_serviceclient_21_0= ruleServiceClient ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Pluginslots||LA31_0==Implements||LA31_0==Parameter||LA31_0==Multiple||LA31_0==Plugins||LA31_0==Format||LA31_0==Library||LA31_0==Base||LA31_0==Class||(LA31_0>=RULE_ID && LA31_0<=RULE_STRING)) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1337:6: (lv_serviceclient_21_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRosParser.g:1337:6: (lv_serviceclient_21_0= ruleServiceClient )
            	    	    // InternalRosParser.g:1338:7: lv_serviceclient_21_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceclientServiceClientParserRuleCall_5_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_serviceclient_21_0=ruleServiceClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceclient",
            	    	    								lv_serviceclient_21_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop31;
            	        }
            	    } while (true);

            	    this_END_22=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_22, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRosParser.g:1361:4: (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END )
            	    {
            	    // InternalRosParser.g:1361:4: (otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END )
            	    // InternalRosParser.g:1362:5: otherlv_23= Actionservers this_BEGIN_24= RULE_BEGIN ( (lv_actionserver_25_0= ruleActionServer ) )* this_END_26= RULE_END
            	    {
            	    otherlv_23=(Token)match(input,Actionservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_23, grammarAccess.getPluginAccess().getActionserversKeyword_5_4_0());
            	    				
            	    this_BEGIN_24=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_24, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_4_1());
            	    				
            	    // InternalRosParser.g:1370:5: ( (lv_actionserver_25_0= ruleActionServer ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Pluginslots||LA32_0==Implements||LA32_0==Parameter||LA32_0==Multiple||LA32_0==Plugins||LA32_0==Format||LA32_0==Library||LA32_0==Base||LA32_0==Class||(LA32_0>=RULE_ID && LA32_0<=RULE_STRING)) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1371:6: (lv_actionserver_25_0= ruleActionServer )
            	    	    {
            	    	    // InternalRosParser.g:1371:6: (lv_actionserver_25_0= ruleActionServer )
            	    	    // InternalRosParser.g:1372:7: lv_actionserver_25_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionserverActionServerParserRuleCall_5_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_actionserver_25_0=ruleActionServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionserver",
            	    	    								lv_actionserver_25_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop32;
            	        }
            	    } while (true);

            	    this_END_26=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_26, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRosParser.g:1395:4: (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END )
            	    {
            	    // InternalRosParser.g:1395:4: (otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END )
            	    // InternalRosParser.g:1396:5: otherlv_27= Actionclients this_BEGIN_28= RULE_BEGIN ( (lv_actionclient_29_0= ruleActionClient ) )* this_END_30= RULE_END
            	    {
            	    otherlv_27=(Token)match(input,Actionclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_27, grammarAccess.getPluginAccess().getActionclientsKeyword_5_5_0());
            	    				
            	    this_BEGIN_28=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_28, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_5_1());
            	    				
            	    // InternalRosParser.g:1404:5: ( (lv_actionclient_29_0= ruleActionClient ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Pluginslots||LA33_0==Implements||LA33_0==Parameter||LA33_0==Multiple||LA33_0==Plugins||LA33_0==Format||LA33_0==Library||LA33_0==Base||LA33_0==Class||(LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1405:6: (lv_actionclient_29_0= ruleActionClient )
            	    	    {
            	    	    // InternalRosParser.g:1405:6: (lv_actionclient_29_0= ruleActionClient )
            	    	    // InternalRosParser.g:1406:7: lv_actionclient_29_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionclientActionClientParserRuleCall_5_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_actionclient_29_0=ruleActionClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionclient",
            	    	    								lv_actionclient_29_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop33;
            	        }
            	    } while (true);

            	    this_END_30=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_30, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRosParser.g:1429:4: (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END )
            	    {
            	    // InternalRosParser.g:1429:4: (otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END )
            	    // InternalRosParser.g:1430:5: otherlv_31= Parameters this_BEGIN_32= RULE_BEGIN ( (lv_parameter_33_0= ruleParameter ) )* this_END_34= RULE_END
            	    {
            	    otherlv_31=(Token)match(input,Parameters,FOLLOW_5); 

            	    					newLeafNode(otherlv_31, grammarAccess.getPluginAccess().getParametersKeyword_5_6_0());
            	    				
            	    this_BEGIN_32=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            	    					newLeafNode(this_BEGIN_32, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_5_6_1());
            	    				
            	    // InternalRosParser.g:1438:5: ( (lv_parameter_33_0= ruleParameter ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==Pluginslots||LA34_0==Implements||LA34_0==Parameter||LA34_0==Multiple||LA34_0==Plugins||LA34_0==Format||LA34_0==Library||LA34_0==Base||LA34_0==Class||(LA34_0>=RULE_ID && LA34_0<=RULE_STRING)) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1439:6: (lv_parameter_33_0= ruleParameter )
            	    	    {
            	    	    // InternalRosParser.g:1439:6: (lv_parameter_33_0= ruleParameter )
            	    	    // InternalRosParser.g:1440:7: lv_parameter_33_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getParameterParameterParserRuleCall_5_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_30);
            	    	    lv_parameter_33_0=ruleParameter();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"parameter",
            	    	    								lv_parameter_33_0,
            	    	    								"de.fraunhofer.ipa.ros.Basics.Parameter");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop34;
            	        }
            	    } while (true);

            	    this_END_34=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_34, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRosParser.g:1463:4: ( (lv_extensions_35_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRosParser.g:1463:4: ( (lv_extensions_35_0= ruleExtensionBlock ) )
            	    // InternalRosParser.g:1464:5: (lv_extensions_35_0= ruleExtensionBlock )
            	    {
            	    // InternalRosParser.g:1464:5: (lv_extensions_35_0= ruleExtensionBlock )
            	    // InternalRosParser.g:1465:6: lv_extensions_35_0= ruleExtensionBlock
            	    {

            	    						newCompositeNode(grammarAccess.getPluginAccess().getExtensionsExtensionBlockParserRuleCall_5_7_0());
            	    					
            	    pushFollow(FOLLOW_34);
            	    lv_extensions_35_0=ruleExtensionBlock();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPluginRule());
            	    						}
            	    						add(
            	    							current,
            	    							"extensions",
            	    							lv_extensions_35_0,
            	    							"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            this_END_36=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_36, grammarAccess.getPluginAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlugin"


    // $ANTLR start "entryRulePluginSlot"
    // InternalRosParser.g:1491:1: entryRulePluginSlot returns [EObject current=null] : iv_rulePluginSlot= rulePluginSlot EOF ;
    public final EObject entryRulePluginSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginSlot = null;


        try {
            // InternalRosParser.g:1491:51: (iv_rulePluginSlot= rulePluginSlot EOF )
            // InternalRosParser.g:1492:2: iv_rulePluginSlot= rulePluginSlot EOF
            {
             newCompositeNode(grammarAccess.getPluginSlotRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePluginSlot=rulePluginSlot();

            state._fsp--;

             current =iv_rulePluginSlot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePluginSlot"


    // $ANTLR start "rulePluginSlot"
    // InternalRosParser.g:1498:1: rulePluginSlot returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) ) ;
    public final EObject rulePluginSlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token this_END_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_parameter_9_0 = null;

        Enumerator lv_valueFormat_11_0 = null;

        AntlrDatatypeRuleToken lv_multiple_13_0 = null;

        AntlrDatatypeRuleToken lv_parameter_22_0 = null;

        Enumerator lv_valueFormat_25_0 = null;

        AntlrDatatypeRuleToken lv_multiple_28_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:1504:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) ) )
            // InternalRosParser.g:1505:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) )
            {
            // InternalRosParser.g:1505:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) ) )
            // InternalRosParser.g:1506:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) )
            {
            // InternalRosParser.g:1506:3: ()
            // InternalRosParser.g:1507:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginSlotAccess().getPluginSlotAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:1513:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Library||LA36_0==Class||(LA36_0>=RULE_ID && LA36_0<=RULE_STRING)) ) {
                alt36=1;
            }
            else if ( (LA36_0==Pluginslots||LA36_0==Implements||LA36_0==Parameter||LA36_0==Multiple||LA36_0==Plugins||LA36_0==Format||LA36_0==Base) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalRosParser.g:1514:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:1514:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:1515:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:1515:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:1516:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:1516:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:1517:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_35); 

                    					newLeafNode(otherlv_2, grammarAccess.getPluginSlotAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1540:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:1540:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:1541:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:1541:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:1542:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPluginSlotAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRosParser.g:1560:3: ( (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END ) | (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_BEGIN) ) {
                alt45=1;
            }
            else if ( (LA45_0==LeftCurlyBracket) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalRosParser.g:1561:4: (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END )
                    {
                    // InternalRosParser.g:1561:4: (this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END )
                    // InternalRosParser.g:1562:5: this_BEGIN_4= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) ) this_END_16= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_36); 

                    					newLeafNode(this_BEGIN_4, grammarAccess.getPluginSlotAccess().getBEGINTerminalRuleCall_2_0_0());
                    				
                    // InternalRosParser.g:1566:5: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) ) )
                    // InternalRosParser.g:1567:6: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) )
                    {
                    // InternalRosParser.g:1567:6: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?) )
                    // InternalRosParser.g:1568:7: ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?)
                    {
                     
                    						  getUnorderedGroupHelper().enter(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    						
                    // InternalRosParser.g:1571:7: ( ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?)
                    // InternalRosParser.g:1572:8: ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+ {...}?
                    {
                    // InternalRosParser.g:1572:8: ( ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) ) )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=6;
                        int LA37_0 = input.LA(1);

                        if ( LA37_0 == Base && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0) ) {
                            alt37=1;
                        }
                        else if ( LA37_0 == Parameter && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1) ) {
                            alt37=2;
                        }
                        else if ( LA37_0 == Format && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2) ) {
                            alt37=3;
                        }
                        else if ( LA37_0 == Multiple && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3) ) {
                            alt37=4;
                        }
                        else if ( LA37_0 == Default && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4) ) {
                            alt37=5;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalRosParser.g:1573:6: ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1573:6: ({...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    // InternalRosParser.g:1574:7: {...}? => ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0)");
                    	    }
                    	    // InternalRosParser.g:1574:113: ( ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) ) )
                    	    // InternalRosParser.g:1575:8: ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 0);
                    	    							
                    	    // InternalRosParser.g:1578:11: ({...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) ) )
                    	    // InternalRosParser.g:1578:12: {...}? => (otherlv_6= Base ( ( ruleQualifiedRef ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1578:21: (otherlv_6= Base ( ( ruleQualifiedRef ) ) )
                    	    // InternalRosParser.g:1578:22: otherlv_6= Base ( ( ruleQualifiedRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Base,FOLLOW_33); 

                    	    											newLeafNode(otherlv_6, grammarAccess.getPluginSlotAccess().getBaseKeyword_2_0_1_0_0());
                    	    										
                    	    // InternalRosParser.g:1582:11: ( ( ruleQualifiedRef ) )
                    	    // InternalRosParser.g:1583:12: ( ruleQualifiedRef )
                    	    {
                    	    // InternalRosParser.g:1583:12: ( ruleQualifiedRef )
                    	    // InternalRosParser.g:1584:13: ruleQualifiedRef
                    	    {

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    												

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getBasePluginBaseCrossReference_2_0_1_0_1_0());
                    	    												
                    	    pushFollow(FOLLOW_37);
                    	    ruleQualifiedRef();

                    	    state._fsp--;


                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRosParser.g:1604:6: ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1604:6: ({...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) ) )
                    	    // InternalRosParser.g:1605:7: {...}? => ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1)");
                    	    }
                    	    // InternalRosParser.g:1605:113: ( ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) ) )
                    	    // InternalRosParser.g:1606:8: ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 1);
                    	    							
                    	    // InternalRosParser.g:1609:11: ({...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) ) )
                    	    // InternalRosParser.g:1609:12: {...}? => (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1609:21: (otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) ) )
                    	    // InternalRosParser.g:1609:22: otherlv_8= Parameter ( (lv_parameter_9_0= ruleEString ) )
                    	    {
                    	    otherlv_8=(Token)match(input,Parameter,FOLLOW_7); 

                    	    											newLeafNode(otherlv_8, grammarAccess.getPluginSlotAccess().getParameterKeyword_2_0_1_1_0());
                    	    										
                    	    // InternalRosParser.g:1613:11: ( (lv_parameter_9_0= ruleEString ) )
                    	    // InternalRosParser.g:1614:12: (lv_parameter_9_0= ruleEString )
                    	    {
                    	    // InternalRosParser.g:1614:12: (lv_parameter_9_0= ruleEString )
                    	    // InternalRosParser.g:1615:13: lv_parameter_9_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_2_0_1_1_1_0());
                    	    												
                    	    pushFollow(FOLLOW_37);
                    	    lv_parameter_9_0=ruleEString();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"parameter",
                    	    														lv_parameter_9_0,
                    	    														"de.fraunhofer.ipa.ros.Ros.EString");
                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalRosParser.g:1638:6: ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1638:6: ({...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    // InternalRosParser.g:1639:7: {...}? => ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2)");
                    	    }
                    	    // InternalRosParser.g:1639:113: ( ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    // InternalRosParser.g:1640:8: ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 2);
                    	    							
                    	    // InternalRosParser.g:1643:11: ({...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) ) )
                    	    // InternalRosParser.g:1643:12: {...}? => (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1643:21: (otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) ) )
                    	    // InternalRosParser.g:1643:22: otherlv_10= Format ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Format,FOLLOW_38); 

                    	    											newLeafNode(otherlv_10, grammarAccess.getPluginSlotAccess().getFormatKeyword_2_0_1_2_0());
                    	    										
                    	    // InternalRosParser.g:1647:11: ( (lv_valueFormat_11_0= rulePluginSlotValueFormat ) )
                    	    // InternalRosParser.g:1648:12: (lv_valueFormat_11_0= rulePluginSlotValueFormat )
                    	    {
                    	    // InternalRosParser.g:1648:12: (lv_valueFormat_11_0= rulePluginSlotValueFormat )
                    	    // InternalRosParser.g:1649:13: lv_valueFormat_11_0= rulePluginSlotValueFormat
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_2_0_1_2_1_0());
                    	    												
                    	    pushFollow(FOLLOW_37);
                    	    lv_valueFormat_11_0=rulePluginSlotValueFormat();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"valueFormat",
                    	    														lv_valueFormat_11_0,
                    	    														"de.fraunhofer.ipa.ros.Ros.PluginSlotValueFormat");
                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalRosParser.g:1672:6: ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1672:6: ({...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) ) )
                    	    // InternalRosParser.g:1673:7: {...}? => ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3)");
                    	    }
                    	    // InternalRosParser.g:1673:113: ( ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) ) )
                    	    // InternalRosParser.g:1674:8: ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 3);
                    	    							
                    	    // InternalRosParser.g:1677:11: ({...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) ) )
                    	    // InternalRosParser.g:1677:12: {...}? => (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1677:21: (otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) ) )
                    	    // InternalRosParser.g:1677:22: otherlv_12= Multiple ( (lv_multiple_13_0= ruleboolean0 ) )
                    	    {
                    	    otherlv_12=(Token)match(input,Multiple,FOLLOW_39); 

                    	    											newLeafNode(otherlv_12, grammarAccess.getPluginSlotAccess().getMultipleKeyword_2_0_1_3_0());
                    	    										
                    	    // InternalRosParser.g:1681:11: ( (lv_multiple_13_0= ruleboolean0 ) )
                    	    // InternalRosParser.g:1682:12: (lv_multiple_13_0= ruleboolean0 )
                    	    {
                    	    // InternalRosParser.g:1682:12: (lv_multiple_13_0= ruleboolean0 )
                    	    // InternalRosParser.g:1683:13: lv_multiple_13_0= ruleboolean0
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getMultipleBoolean0ParserRuleCall_2_0_1_3_1_0());
                    	    												
                    	    pushFollow(FOLLOW_37);
                    	    lv_multiple_13_0=ruleboolean0();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"multiple",
                    	    														lv_multiple_13_0,
                    	    														"de.fraunhofer.ipa.ros.Basics.boolean0");
                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // InternalRosParser.g:1706:6: ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1706:6: ({...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) ) )
                    	    // InternalRosParser.g:1707:7: {...}? => ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4)");
                    	    }
                    	    // InternalRosParser.g:1707:113: ( ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) ) )
                    	    // InternalRosParser.g:1708:8: ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1(), 4);
                    	    							
                    	    // InternalRosParser.g:1711:11: ({...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) ) )
                    	    // InternalRosParser.g:1711:12: {...}? => (otherlv_14= Default ( ( ruleQualifiedRef ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1711:21: (otherlv_14= Default ( ( ruleQualifiedRef ) ) )
                    	    // InternalRosParser.g:1711:22: otherlv_14= Default ( ( ruleQualifiedRef ) )
                    	    {
                    	    otherlv_14=(Token)match(input,Default,FOLLOW_33); 

                    	    											newLeafNode(otherlv_14, grammarAccess.getPluginSlotAccess().getDefaultKeyword_2_0_1_4_0());
                    	    										
                    	    // InternalRosParser.g:1715:11: ( ( ruleQualifiedRef ) )
                    	    // InternalRosParser.g:1716:12: ( ruleQualifiedRef )
                    	    {
                    	    // InternalRosParser.g:1716:12: ( ruleQualifiedRef )
                    	    // InternalRosParser.g:1717:13: ruleQualifiedRef
                    	    {

                    	    													if (current==null) {
                    	    														current = createModelElement(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    												

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginPluginCrossReference_2_0_1_4_1_0());
                    	    												
                    	    pushFollow(FOLLOW_37);
                    	    ruleQualifiedRef();

                    	    state._fsp--;


                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1()) ) {
                        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canLeave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1())");
                    }

                    }


                    }

                     
                    						  getUnorderedGroupHelper().leave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_2_0_1());
                    						

                    }

                    this_END_16=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_16, grammarAccess.getPluginSlotAccess().getENDTerminalRuleCall_2_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1751:4: (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket )
                    {
                    // InternalRosParser.g:1751:4: (otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket )
                    // InternalRosParser.g:1752:5: otherlv_17= LeftCurlyBracket otherlv_18= Base ( ( ruleQualifiedRef ) ) (otherlv_20= Comma )? otherlv_21= Parameter ( (lv_parameter_22_0= ruleEString ) ) ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )? ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )? otherlv_32= RightCurlyBracket
                    {
                    otherlv_17=(Token)match(input,LeftCurlyBracket,FOLLOW_40); 

                    					newLeafNode(otherlv_17, grammarAccess.getPluginSlotAccess().getLeftCurlyBracketKeyword_2_1_0());
                    				
                    otherlv_18=(Token)match(input,Base,FOLLOW_33); 

                    					newLeafNode(otherlv_18, grammarAccess.getPluginSlotAccess().getBaseKeyword_2_1_1());
                    				
                    // InternalRosParser.g:1760:5: ( ( ruleQualifiedRef ) )
                    // InternalRosParser.g:1761:6: ( ruleQualifiedRef )
                    {
                    // InternalRosParser.g:1761:6: ( ruleQualifiedRef )
                    // InternalRosParser.g:1762:7: ruleQualifiedRef
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getPluginSlotRule());
                    							}
                    						

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getBasePluginBaseCrossReference_2_1_2_0());
                    						
                    pushFollow(FOLLOW_41);
                    ruleQualifiedRef();

                    state._fsp--;


                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRosParser.g:1776:5: (otherlv_20= Comma )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==Comma) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalRosParser.g:1777:6: otherlv_20= Comma
                            {
                            otherlv_20=(Token)match(input,Comma,FOLLOW_42); 

                            						newLeafNode(otherlv_20, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_3());
                            					

                            }
                            break;

                    }

                    otherlv_21=(Token)match(input,Parameter,FOLLOW_7); 

                    					newLeafNode(otherlv_21, grammarAccess.getPluginSlotAccess().getParameterKeyword_2_1_4());
                    				
                    // InternalRosParser.g:1786:5: ( (lv_parameter_22_0= ruleEString ) )
                    // InternalRosParser.g:1787:6: (lv_parameter_22_0= ruleEString )
                    {
                    // InternalRosParser.g:1787:6: (lv_parameter_22_0= ruleEString )
                    // InternalRosParser.g:1788:7: lv_parameter_22_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_2_1_5_0());
                    						
                    pushFollow(FOLLOW_43);
                    lv_parameter_22_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    							}
                    							set(
                    								current,
                    								"parameter",
                    								lv_parameter_22_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRosParser.g:1805:5: ( (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==Comma) ) {
                        int LA40_1 = input.LA(2);

                        if ( (LA40_1==Format) ) {
                            alt40=1;
                        }
                    }
                    else if ( (LA40_0==Format) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalRosParser.g:1806:6: (otherlv_23= Comma )? otherlv_24= Format ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) )
                            {
                            // InternalRosParser.g:1806:6: (otherlv_23= Comma )?
                            int alt39=2;
                            int LA39_0 = input.LA(1);

                            if ( (LA39_0==Comma) ) {
                                alt39=1;
                            }
                            switch (alt39) {
                                case 1 :
                                    // InternalRosParser.g:1807:7: otherlv_23= Comma
                                    {
                                    otherlv_23=(Token)match(input,Comma,FOLLOW_44); 

                                    							newLeafNode(otherlv_23, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_6_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_24=(Token)match(input,Format,FOLLOW_38); 

                            						newLeafNode(otherlv_24, grammarAccess.getPluginSlotAccess().getFormatKeyword_2_1_6_1());
                            					
                            // InternalRosParser.g:1816:6: ( (lv_valueFormat_25_0= rulePluginSlotValueFormat ) )
                            // InternalRosParser.g:1817:7: (lv_valueFormat_25_0= rulePluginSlotValueFormat )
                            {
                            // InternalRosParser.g:1817:7: (lv_valueFormat_25_0= rulePluginSlotValueFormat )
                            // InternalRosParser.g:1818:8: lv_valueFormat_25_0= rulePluginSlotValueFormat
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_2_1_6_2_0());
                            							
                            pushFollow(FOLLOW_45);
                            lv_valueFormat_25_0=rulePluginSlotValueFormat();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                            								}
                            								set(
                            									current,
                            									"valueFormat",
                            									lv_valueFormat_25_0,
                            									"de.fraunhofer.ipa.ros.Ros.PluginSlotValueFormat");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalRosParser.g:1836:5: ( (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) ) )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==Comma) ) {
                        int LA42_1 = input.LA(2);

                        if ( (LA42_1==Multiple) ) {
                            alt42=1;
                        }
                    }
                    else if ( (LA42_0==Multiple) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalRosParser.g:1837:6: (otherlv_26= Comma )? otherlv_27= Multiple ( (lv_multiple_28_0= ruleboolean0 ) )
                            {
                            // InternalRosParser.g:1837:6: (otherlv_26= Comma )?
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( (LA41_0==Comma) ) {
                                alt41=1;
                            }
                            switch (alt41) {
                                case 1 :
                                    // InternalRosParser.g:1838:7: otherlv_26= Comma
                                    {
                                    otherlv_26=(Token)match(input,Comma,FOLLOW_46); 

                                    							newLeafNode(otherlv_26, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_7_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_27=(Token)match(input,Multiple,FOLLOW_39); 

                            						newLeafNode(otherlv_27, grammarAccess.getPluginSlotAccess().getMultipleKeyword_2_1_7_1());
                            					
                            // InternalRosParser.g:1847:6: ( (lv_multiple_28_0= ruleboolean0 ) )
                            // InternalRosParser.g:1848:7: (lv_multiple_28_0= ruleboolean0 )
                            {
                            // InternalRosParser.g:1848:7: (lv_multiple_28_0= ruleboolean0 )
                            // InternalRosParser.g:1849:8: lv_multiple_28_0= ruleboolean0
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getMultipleBoolean0ParserRuleCall_2_1_7_2_0());
                            							
                            pushFollow(FOLLOW_47);
                            lv_multiple_28_0=ruleboolean0();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                            								}
                            								set(
                            									current,
                            									"multiple",
                            									lv_multiple_28_0,
                            									"de.fraunhofer.ipa.ros.Basics.boolean0");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalRosParser.g:1867:5: ( (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==Default||LA44_0==Comma) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalRosParser.g:1868:6: (otherlv_29= Comma )? otherlv_30= Default ( ( ruleQualifiedRef ) )
                            {
                            // InternalRosParser.g:1868:6: (otherlv_29= Comma )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==Comma) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // InternalRosParser.g:1869:7: otherlv_29= Comma
                                    {
                                    otherlv_29=(Token)match(input,Comma,FOLLOW_48); 

                                    							newLeafNode(otherlv_29, grammarAccess.getPluginSlotAccess().getCommaKeyword_2_1_8_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_30=(Token)match(input,Default,FOLLOW_33); 

                            						newLeafNode(otherlv_30, grammarAccess.getPluginSlotAccess().getDefaultKeyword_2_1_8_1());
                            					
                            // InternalRosParser.g:1878:6: ( ( ruleQualifiedRef ) )
                            // InternalRosParser.g:1879:7: ( ruleQualifiedRef )
                            {
                            // InternalRosParser.g:1879:7: ( ruleQualifiedRef )
                            // InternalRosParser.g:1880:8: ruleQualifiedRef
                            {

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getPluginSlotRule());
                            								}
                            							

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginPluginCrossReference_2_1_8_2_0());
                            							
                            pushFollow(FOLLOW_49);
                            ruleQualifiedRef();

                            state._fsp--;


                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_32=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

                    					newLeafNode(otherlv_32, grammarAccess.getPluginSlotAccess().getRightCurlyBracketKeyword_2_1_9());
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePluginSlot"


    // $ANTLR start "entryRuleAddedKeywordName"
    // InternalRosParser.g:1905:1: entryRuleAddedKeywordName returns [String current=null] : iv_ruleAddedKeywordName= ruleAddedKeywordName EOF ;
    public final String entryRuleAddedKeywordName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAddedKeywordName = null;


        try {
            // InternalRosParser.g:1905:56: (iv_ruleAddedKeywordName= ruleAddedKeywordName EOF )
            // InternalRosParser.g:1906:2: iv_ruleAddedKeywordName= ruleAddedKeywordName EOF
            {
             newCompositeNode(grammarAccess.getAddedKeywordNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddedKeywordName=ruleAddedKeywordName();

            state._fsp--;

             current =iv_ruleAddedKeywordName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:1912:1: ruleAddedKeywordName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple ) ;
    public final AntlrDatatypeRuleToken ruleAddedKeywordName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:1918:2: ( (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple ) )
            // InternalRosParser.g:1919:2: (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple )
            {
            // InternalRosParser.g:1919:2: (kw= Plugins | kw= Implements | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format | kw= Multiple )
            int alt46=7;
            switch ( input.LA(1) ) {
            case Plugins:
                {
                alt46=1;
                }
                break;
            case Implements:
                {
                alt46=2;
                }
                break;
            case Pluginslots:
                {
                alt46=3;
                }
                break;
            case Base:
                {
                alt46=4;
                }
                break;
            case Parameter:
                {
                alt46=5;
                }
                break;
            case Format:
                {
                alt46=6;
                }
                break;
            case Multiple:
                {
                alt46=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalRosParser.g:1920:3: kw= Plugins
                    {
                    kw=(Token)match(input,Plugins,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getPluginsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1926:3: kw= Implements
                    {
                    kw=(Token)match(input,Implements,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getImplementsKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:1932:3: kw= Pluginslots
                    {
                    kw=(Token)match(input,Pluginslots,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getPluginslotsKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:1938:3: kw= Base
                    {
                    kw=(Token)match(input,Base,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getBaseKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:1944:3: kw= Parameter
                    {
                    kw=(Token)match(input,Parameter,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getParameterKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:1950:3: kw= Format
                    {
                    kw=(Token)match(input,Format,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getFormatKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:1956:3: kw= Multiple
                    {
                    kw=(Token)match(input,Multiple,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getAddedKeywordNameAccess().getMultipleKeyword_6());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleEString"
    // InternalRosParser.g:1965:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRosParser.g:1965:47: (iv_ruleEString= ruleEString EOF )
            // InternalRosParser.g:1966:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:1972:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:1978:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library ) )
            // InternalRosParser.g:1979:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library )
            {
            // InternalRosParser.g:1979:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Class | kw= Library )
            int alt47=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt47=1;
                }
                break;
            case RULE_ID:
                {
                alt47=2;
                }
                break;
            case Class:
                {
                alt47=3;
                }
                break;
            case Library:
                {
                alt47=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalRosParser.g:1980:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1988:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:1996:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getClassKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:2002:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getLibraryKeyword_3());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleRosNames"
    // InternalRosParser.g:2011:1: entryRuleRosNames returns [String current=null] : iv_ruleRosNames= ruleRosNames EOF ;
    public final String entryRuleRosNames() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRosNames = null;


        try {
            // InternalRosParser.g:2011:48: (iv_ruleRosNames= ruleRosNames EOF )
            // InternalRosParser.g:2012:2: iv_ruleRosNames= ruleRosNames EOF
            {
             newCompositeNode(grammarAccess.getRosNamesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRosNames=ruleRosNames();

            state._fsp--;

             current =iv_ruleRosNames.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRosNames"


    // $ANTLR start "ruleRosNames"
    // InternalRosParser.g:2018:1: ruleRosNames returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleRosNames() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROS_CONVENTION_A_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:2024:2: ( (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library ) )
            // InternalRosParser.g:2025:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library )
            {
            // InternalRosParser.g:2025:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Class | kw= Library )
            int alt48=5;
            switch ( input.LA(1) ) {
            case RULE_ROS_CONVENTION_A:
                {
                alt48=1;
                }
                break;
            case RULE_ID:
                {
                alt48=2;
                }
                break;
            case Node:
                {
                alt48=3;
                }
                break;
            case Class:
                {
                alt48=4;
                }
                break;
            case Library:
                {
                alt48=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalRosParser.g:2026:3: this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A
                    {
                    this_ROS_CONVENTION_A_0=(Token)match(input,RULE_ROS_CONVENTION_A,FOLLOW_2); 

                    			current.merge(this_ROS_CONVENTION_A_0);
                    		

                    			newLeafNode(this_ROS_CONVENTION_A_0, grammarAccess.getRosNamesAccess().getROS_CONVENTION_ATerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2034:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getRosNamesAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:2042:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getNodeKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:2048:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getClassKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:2054:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getLibraryKeyword_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRosNames"


    // $ANTLR start "entryRuleExtensionKey"
    // InternalRosParser.g:2063:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRosParser.g:2063:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRosParser.g:2064:2: iv_ruleExtensionKey= ruleExtensionKey EOF
            {
             newCompositeNode(grammarAccess.getExtensionKeyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionKey=ruleExtensionKey();

            state._fsp--;

             current =iv_ruleExtensionKey.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:2070:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2076:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRosParser.g:2077:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRosParser.g:2077:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt49=31;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt49=1;
                }
                break;
            case RULE_STRING:
                {
                alt49=2;
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
                alt49=3;
                }
                break;
            case Node:
                {
                alt49=4;
                }
                break;
            case Class:
                {
                alt49=5;
                }
                break;
            case Library:
                {
                alt49=6;
                }
                break;
            case String:
                {
                alt49=7;
                }
                break;
            case Integer:
                {
                alt49=8;
                }
                break;
            case Double:
                {
                alt49=9;
                }
                break;
            case Boolean:
                {
                alt49=10;
                }
                break;
            case Base64:
                {
                alt49=11;
                }
                break;
            case Array:
                {
                alt49=12;
                }
                break;
            case List:
                {
                alt49=13;
                }
                break;
            case Struct:
                {
                alt49=14;
                }
                break;
            case Date:
                {
                alt49=15;
                }
                break;
            case Any:
                {
                alt49=16;
                }
                break;
            case Bool:
                {
                alt49=17;
                }
                break;
            case Int8:
                {
                alt49=18;
                }
                break;
            case Uint8:
                {
                alt49=19;
                }
                break;
            case Int16:
                {
                alt49=20;
                }
                break;
            case Uint16:
                {
                alt49=21;
                }
                break;
            case Int32:
                {
                alt49=22;
                }
                break;
            case Uint32:
                {
                alt49=23;
                }
                break;
            case Int64:
                {
                alt49=24;
                }
                break;
            case Uint64:
                {
                alt49=25;
                }
                break;
            case Float32:
                {
                alt49=26;
                }
                break;
            case Float64:
                {
                alt49=27;
                }
                break;
            case String_1:
                {
                alt49=28;
                }
                break;
            case Char:
                {
                alt49=29;
                }
                break;
            case Byte:
                {
                alt49=30;
                }
                break;
            case Header:
                {
                alt49=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalRosParser.g:2078:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2086:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:2094:3: this_KEYWORD_2= ruleKEYWORD
                    {

                    			newCompositeNode(grammarAccess.getExtensionKeyAccess().getKEYWORDParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_KEYWORD_2=ruleKEYWORD();

                    state._fsp--;


                    			current.merge(this_KEYWORD_2);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:2105:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:2111:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getClassKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:2117:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getLibraryKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:2123:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:2129:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:2135:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:2141:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:2147:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRosParser.g:2153:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRosParser.g:2159:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRosParser.g:2165:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRosParser.g:2171:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRosParser.g:2177:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRosParser.g:2183:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRosParser.g:2189:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRosParser.g:2195:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRosParser.g:2201:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRosParser.g:2207:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRosParser.g:2213:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRosParser.g:2219:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalRosParser.g:2225:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalRosParser.g:2231:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalRosParser.g:2237:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalRosParser.g:2243:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalRosParser.g:2249:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalRosParser.g:2255:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalRosParser.g:2261:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalRosParser.g:2267:3: kw= Header
                    {
                    kw=(Token)match(input,Header,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getHeaderKeyword_30());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleExtensionColonKey"
    // InternalRosParser.g:2276:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRosParser.g:2276:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRosParser.g:2277:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
            {
             newCompositeNode(grammarAccess.getExtensionColonKeyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionColonKey=ruleExtensionColonKey();

            state._fsp--;

             current =iv_ruleExtensionColonKey.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:2283:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:2289:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters ) )
            // InternalRosParser.g:2290:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters )
            {
            // InternalRosParser.g:2290:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters )
            int alt50=17;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt50=1;
                }
                break;
            case Type_1:
                {
                alt50=2;
                }
                break;
            case Value_1:
                {
                alt50=3;
                }
                break;
            case Default:
                {
                alt50=4;
                }
                break;
            case FromGitRepo:
                {
                alt50=5;
                }
                break;
            case Dependencies:
                {
                alt50=6;
                }
                break;
            case Msgs:
                {
                alt50=7;
                }
                break;
            case Srvs:
                {
                alt50=8;
                }
                break;
            case Actions:
                {
                alt50=9;
                }
                break;
            case Node_1:
                {
                alt50=10;
                }
                break;
            case Publishers:
                {
                alt50=11;
                }
                break;
            case Subscribers:
                {
                alt50=12;
                }
                break;
            case Serviceservers:
                {
                alt50=13;
                }
                break;
            case Serviceclients:
                {
                alt50=14;
                }
                break;
            case Actionservers:
                {
                alt50=15;
                }
                break;
            case Actionclients:
                {
                alt50=16;
                }
                break;
            case Parameters:
                {
                alt50=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalRosParser.g:2291:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2297:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:2303:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:2309:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:2315:3: kw= FromGitRepo
                    {
                    kw=(Token)match(input,FromGitRepo,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromGitRepoKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:2321:3: kw= Dependencies
                    {
                    kw=(Token)match(input,Dependencies,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDependenciesKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:2327:3: kw= Msgs
                    {
                    kw=(Token)match(input,Msgs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getMsgsKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:2333:3: kw= Srvs
                    {
                    kw=(Token)match(input,Srvs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSrvsKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:2339:3: kw= Actions
                    {
                    kw=(Token)match(input,Actions,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionsKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:2345:3: kw= Node_1
                    {
                    kw=(Token)match(input,Node_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodeKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:2351:3: kw= Publishers
                    {
                    kw=(Token)match(input,Publishers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPublishersKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRosParser.g:2357:3: kw= Subscribers
                    {
                    kw=(Token)match(input,Subscribers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubscribersKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRosParser.g:2363:3: kw= Serviceservers
                    {
                    kw=(Token)match(input,Serviceservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceserversKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRosParser.g:2369:3: kw= Serviceclients
                    {
                    kw=(Token)match(input,Serviceclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceclientsKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRosParser.g:2375:3: kw= Actionservers
                    {
                    kw=(Token)match(input,Actionservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionserversKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRosParser.g:2381:3: kw= Actionclients
                    {
                    kw=(Token)match(input,Actionclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionclientsKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRosParser.g:2387:3: kw= Parameters
                    {
                    kw=(Token)match(input,Parameters,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParametersKeyword_16());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRulePublisher"
    // InternalRosParser.g:2396:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // InternalRosParser.g:2396:50: (iv_rulePublisher= rulePublisher EOF )
            // InternalRosParser.g:2397:2: iv_rulePublisher= rulePublisher EOF
            {
             newCompositeNode(grammarAccess.getPublisherRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePublisher=rulePublisher();

            state._fsp--;

             current =iv_rulePublisher; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePublisher"


    // $ANTLR start "rulePublisher"
    // InternalRosParser.g:2403:1: rulePublisher returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
    public final EObject rulePublisher() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_namespace_8_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2409:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRosParser.g:2410:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRosParser.g:2410:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRosParser.g:2411:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRosParser.g:2411:3: ()
            // InternalRosParser.g:2412:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPublisherAccess().getPublisherAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2418:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Library||LA51_0==Class||(LA51_0>=RULE_ID && LA51_0<=RULE_STRING)) ) {
                alt51=1;
            }
            else if ( (LA51_0==Pluginslots||LA51_0==Implements||LA51_0==Parameter||LA51_0==Multiple||LA51_0==Plugins||LA51_0==Format||LA51_0==Base) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalRosParser.g:2419:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:2419:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:2420:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:2420:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:2421:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:2421:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:2422:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPublisherAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPublisherRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getPublisherAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2445:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:2445:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:2446:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:2446:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:2447:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPublisherRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_50); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getPublisherAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getPublisherAccess().getTypeKeyword_3());
            		
            // InternalRosParser.g:2473:3: ( ( ruleEString ) )
            // InternalRosParser.g:2474:4: ( ruleEString )
            {
            // InternalRosParser.g:2474:4: ( ruleEString )
            // InternalRosParser.g:2475:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPublisherRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPublisherAccess().getMessageTopicSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_51);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2489:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==Ns) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRosParser.g:2490:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getPublisherAccess().getNsKeyword_5_0());
                    			
                    // InternalRosParser.g:2494:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRosParser.g:2495:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2495:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRosParser.g:2496:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_8_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPublisherRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_8_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getPublisherAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePublisher"


    // $ANTLR start "entryRuleSubscriber"
    // InternalRosParser.g:2522:1: entryRuleSubscriber returns [EObject current=null] : iv_ruleSubscriber= ruleSubscriber EOF ;
    public final EObject entryRuleSubscriber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscriber = null;


        try {
            // InternalRosParser.g:2522:51: (iv_ruleSubscriber= ruleSubscriber EOF )
            // InternalRosParser.g:2523:2: iv_ruleSubscriber= ruleSubscriber EOF
            {
             newCompositeNode(grammarAccess.getSubscriberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubscriber=ruleSubscriber();

            state._fsp--;

             current =iv_ruleSubscriber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubscriber"


    // $ANTLR start "ruleSubscriber"
    // InternalRosParser.g:2529:1: ruleSubscriber returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
    public final EObject ruleSubscriber() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_namespace_8_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2535:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRosParser.g:2536:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRosParser.g:2536:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRosParser.g:2537:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRosParser.g:2537:3: ()
            // InternalRosParser.g:2538:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubscriberAccess().getSubscriberAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2544:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Library||LA53_0==Class||(LA53_0>=RULE_ID && LA53_0<=RULE_STRING)) ) {
                alt53=1;
            }
            else if ( (LA53_0==Pluginslots||LA53_0==Implements||LA53_0==Parameter||LA53_0==Multiple||LA53_0==Plugins||LA53_0==Format||LA53_0==Base) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalRosParser.g:2545:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:2545:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:2546:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:2546:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:2547:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:2547:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:2548:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getSubscriberAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getSubscriberRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getSubscriberAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2571:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:2571:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:2572:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:2572:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:2573:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubscriberRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_50); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getSubscriberAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getSubscriberAccess().getTypeKeyword_3());
            		
            // InternalRosParser.g:2599:3: ( ( ruleEString ) )
            // InternalRosParser.g:2600:4: ( ruleEString )
            {
            // InternalRosParser.g:2600:4: ( ruleEString )
            // InternalRosParser.g:2601:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubscriberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubscriberAccess().getMessageTopicSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_51);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2615:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==Ns) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRosParser.g:2616:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getSubscriberAccess().getNsKeyword_5_0());
                    			
                    // InternalRosParser.g:2620:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRosParser.g:2621:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2621:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRosParser.g:2622:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_8_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubscriberRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_8_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getSubscriberAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubscriber"


    // $ANTLR start "entryRuleServiceServer"
    // InternalRosParser.g:2648:1: entryRuleServiceServer returns [EObject current=null] : iv_ruleServiceServer= ruleServiceServer EOF ;
    public final EObject entryRuleServiceServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceServer = null;


        try {
            // InternalRosParser.g:2648:54: (iv_ruleServiceServer= ruleServiceServer EOF )
            // InternalRosParser.g:2649:2: iv_ruleServiceServer= ruleServiceServer EOF
            {
             newCompositeNode(grammarAccess.getServiceServerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceServer=ruleServiceServer();

            state._fsp--;

             current =iv_ruleServiceServer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceServer"


    // $ANTLR start "ruleServiceServer"
    // InternalRosParser.g:2655:1: ruleServiceServer returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
    public final EObject ruleServiceServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_namespace_8_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2661:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRosParser.g:2662:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRosParser.g:2662:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRosParser.g:2663:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRosParser.g:2663:3: ()
            // InternalRosParser.g:2664:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceServerAccess().getServiceServerAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2670:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==Library||LA55_0==Class||(LA55_0>=RULE_ID && LA55_0<=RULE_STRING)) ) {
                alt55=1;
            }
            else if ( (LA55_0==Pluginslots||LA55_0==Implements||LA55_0==Parameter||LA55_0==Multiple||LA55_0==Plugins||LA55_0==Format||LA55_0==Base) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalRosParser.g:2671:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:2671:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:2672:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:2672:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:2673:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:2673:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:2674:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getServiceServerAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getServiceServerRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getServiceServerAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2697:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:2697:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:2698:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:2698:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:2699:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceServerRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_50); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getServiceServerAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceServerAccess().getTypeKeyword_3());
            		
            // InternalRosParser.g:2725:3: ( ( ruleEString ) )
            // InternalRosParser.g:2726:4: ( ruleEString )
            {
            // InternalRosParser.g:2726:4: ( ruleEString )
            // InternalRosParser.g:2727:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceServerAccess().getServiceServiceSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_51);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2741:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==Ns) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRosParser.g:2742:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceServerAccess().getNsKeyword_5_0());
                    			
                    // InternalRosParser.g:2746:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRosParser.g:2747:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2747:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRosParser.g:2748:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_8_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceServerRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_8_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getServiceServerAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceServer"


    // $ANTLR start "entryRuleServiceClient"
    // InternalRosParser.g:2774:1: entryRuleServiceClient returns [EObject current=null] : iv_ruleServiceClient= ruleServiceClient EOF ;
    public final EObject entryRuleServiceClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceClient = null;


        try {
            // InternalRosParser.g:2774:54: (iv_ruleServiceClient= ruleServiceClient EOF )
            // InternalRosParser.g:2775:2: iv_ruleServiceClient= ruleServiceClient EOF
            {
             newCompositeNode(grammarAccess.getServiceClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceClient=ruleServiceClient();

            state._fsp--;

             current =iv_ruleServiceClient; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceClient"


    // $ANTLR start "ruleServiceClient"
    // InternalRosParser.g:2781:1: ruleServiceClient returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
    public final EObject ruleServiceClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_namespace_8_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2787:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRosParser.g:2788:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRosParser.g:2788:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRosParser.g:2789:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRosParser.g:2789:3: ()
            // InternalRosParser.g:2790:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceClientAccess().getServiceClientAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2796:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==Library||LA57_0==Class||(LA57_0>=RULE_ID && LA57_0<=RULE_STRING)) ) {
                alt57=1;
            }
            else if ( (LA57_0==Pluginslots||LA57_0==Implements||LA57_0==Parameter||LA57_0==Multiple||LA57_0==Plugins||LA57_0==Format||LA57_0==Base) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalRosParser.g:2797:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:2797:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:2798:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:2798:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:2799:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:2799:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:2800:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getServiceClientAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getServiceClientRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getServiceClientAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2823:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:2823:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:2824:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:2824:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:2825:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceClientRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_50); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getServiceClientAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getServiceClientAccess().getTypeKeyword_3());
            		
            // InternalRosParser.g:2851:3: ( ( ruleEString ) )
            // InternalRosParser.g:2852:4: ( ruleEString )
            {
            // InternalRosParser.g:2852:4: ( ruleEString )
            // InternalRosParser.g:2853:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceClientAccess().getServiceServiceSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_51);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2867:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Ns) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalRosParser.g:2868:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getServiceClientAccess().getNsKeyword_5_0());
                    			
                    // InternalRosParser.g:2872:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRosParser.g:2873:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2873:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRosParser.g:2874:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_8_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceClientRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_8_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getServiceClientAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceClient"


    // $ANTLR start "entryRuleActionServer"
    // InternalRosParser.g:2900:1: entryRuleActionServer returns [EObject current=null] : iv_ruleActionServer= ruleActionServer EOF ;
    public final EObject entryRuleActionServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionServer = null;


        try {
            // InternalRosParser.g:2900:53: (iv_ruleActionServer= ruleActionServer EOF )
            // InternalRosParser.g:2901:2: iv_ruleActionServer= ruleActionServer EOF
            {
             newCompositeNode(grammarAccess.getActionServerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionServer=ruleActionServer();

            state._fsp--;

             current =iv_ruleActionServer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionServer"


    // $ANTLR start "ruleActionServer"
    // InternalRosParser.g:2907:1: ruleActionServer returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
    public final EObject ruleActionServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_namespace_8_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2913:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRosParser.g:2914:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRosParser.g:2914:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRosParser.g:2915:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRosParser.g:2915:3: ()
            // InternalRosParser.g:2916:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionServerAccess().getActionServerAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2922:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==Library||LA59_0==Class||(LA59_0>=RULE_ID && LA59_0<=RULE_STRING)) ) {
                alt59=1;
            }
            else if ( (LA59_0==Pluginslots||LA59_0==Implements||LA59_0==Parameter||LA59_0==Multiple||LA59_0==Plugins||LA59_0==Format||LA59_0==Base) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalRosParser.g:2923:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:2923:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:2924:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:2924:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:2925:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:2925:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:2926:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getActionServerAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getActionServerRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getActionServerAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2949:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:2949:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:2950:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:2950:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:2951:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionServerRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_50); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getActionServerAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getActionServerAccess().getTypeKeyword_3());
            		
            // InternalRosParser.g:2977:3: ( ( ruleEString ) )
            // InternalRosParser.g:2978:4: ( ruleEString )
            {
            // InternalRosParser.g:2978:4: ( ruleEString )
            // InternalRosParser.g:2979:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionServerAccess().getActionActionSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_51);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2993:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==Ns) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalRosParser.g:2994:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getActionServerAccess().getNsKeyword_5_0());
                    			
                    // InternalRosParser.g:2998:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRosParser.g:2999:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2999:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRosParser.g:3000:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_8_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionServerRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_8_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getActionServerAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionServer"


    // $ANTLR start "entryRuleActionClient"
    // InternalRosParser.g:3026:1: entryRuleActionClient returns [EObject current=null] : iv_ruleActionClient= ruleActionClient EOF ;
    public final EObject entryRuleActionClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionClient = null;


        try {
            // InternalRosParser.g:3026:53: (iv_ruleActionClient= ruleActionClient EOF )
            // InternalRosParser.g:3027:2: iv_ruleActionClient= ruleActionClient EOF
            {
             newCompositeNode(grammarAccess.getActionClientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionClient=ruleActionClient();

            state._fsp--;

             current =iv_ruleActionClient; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionClient"


    // $ANTLR start "ruleActionClient"
    // InternalRosParser.g:3033:1: ruleActionClient returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) ;
    public final EObject ruleActionClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_namespace_8_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3039:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END ) )
            // InternalRosParser.g:3040:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            {
            // InternalRosParser.g:3040:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END )
            // InternalRosParser.g:3041:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN otherlv_5= Type_1 ( ( ruleEString ) ) (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )? this_END_9= RULE_END
            {
            // InternalRosParser.g:3041:3: ()
            // InternalRosParser.g:3042:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionClientAccess().getActionClientAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:3048:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==Library||LA61_0==Class||(LA61_0>=RULE_ID && LA61_0<=RULE_STRING)) ) {
                alt61=1;
            }
            else if ( (LA61_0==Pluginslots||LA61_0==Implements||LA61_0==Parameter||LA61_0==Multiple||LA61_0==Plugins||LA61_0==Format||LA61_0==Base) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalRosParser.g:3049:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:3049:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:3050:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:3050:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:3051:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:3051:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:3052:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getActionClientAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getActionClientRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getActionClientAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3075:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:3075:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:3076:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:3076:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:3077:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionClientRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_50); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getActionClientAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_5=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getActionClientAccess().getTypeKeyword_3());
            		
            // InternalRosParser.g:3103:3: ( ( ruleEString ) )
            // InternalRosParser.g:3104:4: ( ruleEString )
            {
            // InternalRosParser.g:3104:4: ( ruleEString )
            // InternalRosParser.g:3105:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionClientAccess().getActionActionSpecCrossReference_4_0());
            				
            pushFollow(FOLLOW_51);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:3119:3: (otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==Ns) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRosParser.g:3120:4: otherlv_7= Ns ( (lv_namespace_8_0= ruleNamespace ) )
                    {
                    otherlv_7=(Token)match(input,Ns,FOLLOW_52); 

                    				newLeafNode(otherlv_7, grammarAccess.getActionClientAccess().getNsKeyword_5_0());
                    			
                    // InternalRosParser.g:3124:4: ( (lv_namespace_8_0= ruleNamespace ) )
                    // InternalRosParser.g:3125:5: (lv_namespace_8_0= ruleNamespace )
                    {
                    // InternalRosParser.g:3125:5: (lv_namespace_8_0= ruleNamespace )
                    // InternalRosParser.g:3126:6: lv_namespace_8_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getNamespaceNamespaceParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_8_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionClientRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_8_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getActionClientAccess().getENDTerminalRuleCall_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionClient"


    // $ANTLR start "entryRuleDependency"
    // InternalRosParser.g:3152:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalRosParser.g:3152:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalRosParser.g:3153:2: iv_ruleDependency= ruleDependency EOF
            {
             newCompositeNode(grammarAccess.getDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDependency=ruleDependency();

            state._fsp--;

             current =iv_ruleDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDependency"


    // $ANTLR start "ruleDependency"
    // InternalRosParser.g:3159:1: ruleDependency returns [EObject current=null] : (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDependency_0 = null;

        EObject this_ExternalDependency_1 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3165:2: ( (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) )
            // InternalRosParser.g:3166:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            {
            // InternalRosParser.g:3166:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==Library||LA63_0==Class||(LA63_0>=RULE_ID && LA63_0<=RULE_STRING)) ) {
                alt63=1;
            }
            else if ( (LA63_0==ExternalDependency) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalRosParser.g:3167:3: this_PackageDependency_0= rulePackageDependency
                    {

                    			newCompositeNode(grammarAccess.getDependencyAccess().getPackageDependencyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PackageDependency_0=rulePackageDependency();

                    state._fsp--;


                    			current = this_PackageDependency_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3176:3: this_ExternalDependency_1= ruleExternalDependency
                    {

                    			newCompositeNode(grammarAccess.getDependencyAccess().getExternalDependencyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExternalDependency_1=ruleExternalDependency();

                    state._fsp--;


                    			current = this_ExternalDependency_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependency"


    // $ANTLR start "entryRulePackageDependency"
    // InternalRosParser.g:3188:1: entryRulePackageDependency returns [EObject current=null] : iv_rulePackageDependency= rulePackageDependency EOF ;
    public final EObject entryRulePackageDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDependency = null;


        try {
            // InternalRosParser.g:3188:58: (iv_rulePackageDependency= rulePackageDependency EOF )
            // InternalRosParser.g:3189:2: iv_rulePackageDependency= rulePackageDependency EOF
            {
             newCompositeNode(grammarAccess.getPackageDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDependency=rulePackageDependency();

            state._fsp--;

             current =iv_rulePackageDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDependency"


    // $ANTLR start "rulePackageDependency"
    // InternalRosParser.g:3195:1: rulePackageDependency returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject rulePackageDependency() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosParser.g:3201:2: ( ( ( ruleEString ) ) )
            // InternalRosParser.g:3202:2: ( ( ruleEString ) )
            {
            // InternalRosParser.g:3202:2: ( ( ruleEString ) )
            // InternalRosParser.g:3203:3: ( ruleEString )
            {
            // InternalRosParser.g:3203:3: ( ruleEString )
            // InternalRosParser.g:3204:4: ruleEString
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPackageDependencyRule());
            				}
            			

            				newCompositeNode(grammarAccess.getPackageDependencyAccess().getPackagePackageCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDependency"


    // $ANTLR start "entryRuleExternalDependency"
    // InternalRosParser.g:3221:1: entryRuleExternalDependency returns [EObject current=null] : iv_ruleExternalDependency= ruleExternalDependency EOF ;
    public final EObject entryRuleExternalDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDependency = null;


        try {
            // InternalRosParser.g:3221:59: (iv_ruleExternalDependency= ruleExternalDependency EOF )
            // InternalRosParser.g:3222:2: iv_ruleExternalDependency= ruleExternalDependency EOF
            {
             newCompositeNode(grammarAccess.getExternalDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalDependency=ruleExternalDependency();

            state._fsp--;

             current =iv_ruleExternalDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalDependency"


    // $ANTLR start "ruleExternalDependency"
    // InternalRosParser.g:3228:1: ruleExternalDependency returns [EObject current=null] : ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleExternalDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3234:2: ( ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalRosParser.g:3235:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalRosParser.g:3235:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            // InternalRosParser.g:3236:3: () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) )
            {
            // InternalRosParser.g:3236:3: ()
            // InternalRosParser.g:3237:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalDependencyAccess().getExternalDependencyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExternalDependency,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalDependencyAccess().getExternalDependencyKeyword_1());
            		
            // InternalRosParser.g:3247:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRosParser.g:3248:4: (lv_name_2_0= ruleEString )
            {
            // InternalRosParser.g:3248:4: (lv_name_2_0= ruleEString )
            // InternalRosParser.g:3249:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getExternalDependencyAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExternalDependencyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"de.fraunhofer.ipa.ros.Ros.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalDependency"


    // $ANTLR start "entryRuleNamespace"
    // InternalRosParser.g:3270:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRosParser.g:3270:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRosParser.g:3271:2: iv_ruleNamespace= ruleNamespace EOF
            {
             newCompositeNode(grammarAccess.getNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;

             current =iv_ruleNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3277:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3283:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRosParser.g:3284:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRosParser.g:3284:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt64=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt64=1;
                }
                break;
            case RelativeNamespace:
                {
                alt64=2;
                }
                break;
            case PrivateNamespace:
                {
                alt64=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalRosParser.g:3285:3: this_GlobalNamespace_0= ruleGlobalNamespace
                    {

                    			newCompositeNode(grammarAccess.getNamespaceAccess().getGlobalNamespaceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_GlobalNamespace_0=ruleGlobalNamespace();

                    state._fsp--;


                    			current = this_GlobalNamespace_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3294:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
                    {

                    			newCompositeNode(grammarAccess.getNamespaceAccess().getRelativeNamespace_ImplParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RelativeNamespace_Impl_1=ruleRelativeNamespace_Impl();

                    state._fsp--;


                    			current = this_RelativeNamespace_Impl_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:3303:3: this_PrivateNamespace_2= rulePrivateNamespace
                    {

                    			newCompositeNode(grammarAccess.getNamespaceAccess().getPrivateNamespaceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrivateNamespace_2=rulePrivateNamespace();

                    state._fsp--;


                    			current = this_PrivateNamespace_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3315:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRosParser.g:3315:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRosParser.g:3316:2: iv_ruleGraphName= ruleGraphName EOF
            {
             newCompositeNode(grammarAccess.getGraphNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGraphName=ruleGraphName();

            state._fsp--;

             current =iv_ruleGraphName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3322:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:3328:2: (kw= GraphName )
            // InternalRosParser.g:3329:2: kw= GraphName
            {
            kw=(Token)match(input,GraphName,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getGraphNameAccess().getGraphNameKeyword());
            	

            }


            	leaveRule();

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
    // InternalRosParser.g:3337:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRosParser.g:3337:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRosParser.g:3338:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
            {
             newCompositeNode(grammarAccess.getGlobalNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGlobalNamespace=ruleGlobalNamespace();

            state._fsp--;

             current =iv_ruleGlobalNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3344:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosParser.g:3350:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:3351:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:3351:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:3352:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:3352:3: ()
            // InternalRosParser.g:3353:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
            		
            // InternalRosParser.g:3363:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==LeftSquareBracket) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRosParser.g:3364:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRosParser.g:3368:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:3369:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:3369:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:3370:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


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

                    // InternalRosParser.g:3387:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==Comma) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // InternalRosParser.g:3388:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_54); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRosParser.g:3392:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosParser.g:3393:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosParser.g:3393:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosParser.g:3394:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getGlobalNamespaceAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3421:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRosParser.g:3421:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRosParser.g:3422:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
            {
             newCompositeNode(grammarAccess.getRelativeNamespace_ImplRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelativeNamespace_Impl=ruleRelativeNamespace_Impl();

            state._fsp--;

             current =iv_ruleRelativeNamespace_Impl; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3428:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosParser.g:3434:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:3435:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:3435:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:3436:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:3436:3: ()
            // InternalRosParser.g:3437:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
            		
            // InternalRosParser.g:3447:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==LeftSquareBracket) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRosParser.g:3448:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRosParser.g:3452:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:3453:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:3453:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:3454:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


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

                    // InternalRosParser.g:3471:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==Comma) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // InternalRosParser.g:3472:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_54); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRosParser.g:3476:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosParser.g:3477:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosParser.g:3477:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosParser.g:3478:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop67;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getRelativeNamespace_ImplAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3505:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRosParser.g:3505:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRosParser.g:3506:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
            {
             newCompositeNode(grammarAccess.getPrivateNamespaceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrivateNamespace=rulePrivateNamespace();

            state._fsp--;

             current =iv_rulePrivateNamespace; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3512:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosParser.g:3518:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:3519:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:3519:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:3520:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:3520:3: ()
            // InternalRosParser.g:3521:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
            		
            // InternalRosParser.g:3531:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==LeftSquareBracket) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRosParser.g:3532:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRosParser.g:3536:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:3537:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:3537:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:3538:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_parts_3_0=ruleGraphName();

                    state._fsp--;


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

                    // InternalRosParser.g:3555:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==Comma) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalRosParser.g:3556:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_54); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRosParser.g:3560:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosParser.g:3561:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosParser.g:3561:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosParser.g:3562:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_parts_5_0=ruleGraphName();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getPrivateNamespaceAccess().getRightSquareBracketKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3589:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRosParser.g:3589:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRosParser.g:3590:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3596:1: ruleParameter returns [EObject current=null] : ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) ;
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
            // InternalRosParser.g:3602:2: ( ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END ) )
            // InternalRosParser.g:3603:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            {
            // InternalRosParser.g:3603:2: ( () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END )
            // InternalRosParser.g:3604:3: () ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) ) this_BEGIN_4= RULE_BEGIN (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )? otherlv_7= Type_1 ( (lv_type_8_0= ruleParameterType ) ) (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )? this_END_11= RULE_END
            {
            // InternalRosParser.g:3604:3: ()
            // InternalRosParser.g:3605:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:3611:3: ( ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ) | ( (lv_name_3_0= ruleAddedKeywordName ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==Library||LA71_0==Class||(LA71_0>=RULE_ID && LA71_0<=RULE_STRING)) ) {
                alt71=1;
            }
            else if ( (LA71_0==Pluginslots||LA71_0==Implements||LA71_0==Parameter||LA71_0==Multiple||LA71_0==Plugins||LA71_0==Format||LA71_0==Base) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalRosParser.g:3612:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:3612:4: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon )
                    // InternalRosParser.g:3613:5: ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:3613:5: ( (lv_name_1_0= ruleEString ) )
                    // InternalRosParser.g:3614:6: (lv_name_1_0= ruleEString )
                    {
                    // InternalRosParser.g:3614:6: (lv_name_1_0= ruleEString )
                    // InternalRosParser.g:3615:7: lv_name_1_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getParameterRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_5); 

                    					newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3638:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:3638:4: ( (lv_name_3_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:3639:5: (lv_name_3_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:3639:5: (lv_name_3_0= ruleAddedKeywordName )
                    // InternalRosParser.g:3640:6: lv_name_3_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNameAddedKeywordNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_3_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_55); 

            			newLeafNode(this_BEGIN_4, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_2());
            		
            // InternalRosParser.g:3662:3: (otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==Ns) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalRosParser.g:3663:4: otherlv_5= Ns ( (lv_namespace_6_0= ruleNamespace ) )
                    {
                    otherlv_5=(Token)match(input,Ns,FOLLOW_52); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getNsKeyword_3_0());
                    			
                    // InternalRosParser.g:3667:4: ( (lv_namespace_6_0= ruleNamespace ) )
                    // InternalRosParser.g:3668:5: (lv_namespace_6_0= ruleNamespace )
                    {
                    // InternalRosParser.g:3668:5: (lv_namespace_6_0= ruleNamespace )
                    // InternalRosParser.g:3669:6: lv_namespace_6_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_50);
                    lv_namespace_6_0=ruleNamespace();

                    state._fsp--;


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
                    break;

            }

            otherlv_7=(Token)match(input,Type_1,FOLLOW_56); 

            			newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getTypeKeyword_4());
            		
            // InternalRosParser.g:3691:3: ( (lv_type_8_0= ruleParameterType ) )
            // InternalRosParser.g:3692:4: (lv_type_8_0= ruleParameterType )
            {
            // InternalRosParser.g:3692:4: (lv_type_8_0= ruleParameterType )
            // InternalRosParser.g:3693:5: lv_type_8_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_57);
            lv_type_8_0=ruleParameterType();

            state._fsp--;


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

            // InternalRosParser.g:3710:3: (otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==Value_1) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRosParser.g:3711:4: otherlv_9= Value_1 ( (lv_value_10_0= ruleParameterValue ) )
                    {
                    otherlv_9=(Token)match(input,Value_1,FOLLOW_58); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getValueKeyword_6_0());
                    			
                    // InternalRosParser.g:3715:4: ( (lv_value_10_0= ruleParameterValue ) )
                    // InternalRosParser.g:3716:5: (lv_value_10_0= ruleParameterValue )
                    {
                    // InternalRosParser.g:3716:5: (lv_value_10_0= ruleParameterValue )
                    // InternalRosParser.g:3717:6: lv_value_10_0= ruleParameterValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_value_10_0=ruleParameterValue();

                    state._fsp--;


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
                    break;

            }

            this_END_11=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_11, grammarAccess.getParameterAccess().getENDTerminalRuleCall_7());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3743:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRosParser.g:3743:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRosParser.g:3744:2: iv_ruleParameterType= ruleParameterType EOF
            {
             newCompositeNode(grammarAccess.getParameterTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterType=ruleParameterType();

            state._fsp--;

             current =iv_ruleParameterType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3750:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
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
            // InternalRosParser.g:3756:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRosParser.g:3757:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRosParser.g:3757:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt74=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt74=1;
                }
                break;
            case Struct:
                {
                alt74=2;
                }
                break;
            case Integer:
                {
                alt74=3;
                }
                break;
            case String:
                {
                alt74=4;
                }
                break;
            case Double:
                {
                alt74=5;
                }
                break;
            case Boolean:
                {
                alt74=6;
                }
                break;
            case Base64:
                {
                alt74=7;
                }
                break;
            case Array:
                {
                alt74=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalRosParser.g:3758:3: this_ParameterListType_0= ruleParameterListType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterListTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterListType_0=ruleParameterListType();

                    state._fsp--;


                    			current = this_ParameterListType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3767:3: this_ParameterStructType_1= ruleParameterStructType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStructTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterStructType_1=ruleParameterStructType();

                    state._fsp--;


                    			current = this_ParameterStructType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:3776:3: this_ParameterIntegerType_2= ruleParameterIntegerType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterIntegerTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterIntegerType_2=ruleParameterIntegerType();

                    state._fsp--;


                    			current = this_ParameterIntegerType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:3785:3: this_ParameterStringType_3= ruleParameterStringType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterStringTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterStringType_3=ruleParameterStringType();

                    state._fsp--;


                    			current = this_ParameterStringType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:3794:3: this_ParameterDoubleType_4= ruleParameterDoubleType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterDoubleTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterDoubleType_4=ruleParameterDoubleType();

                    state._fsp--;


                    			current = this_ParameterDoubleType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:3803:3: this_ParameterBooleanType_5= ruleParameterBooleanType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBooleanTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBooleanType_5=ruleParameterBooleanType();

                    state._fsp--;


                    			current = this_ParameterBooleanType_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:3812:3: this_ParameterBase64Type_6= ruleParameterBase64Type
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterBase64TypeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBase64Type_6=ruleParameterBase64Type();

                    state._fsp--;


                    			current = this_ParameterBase64Type_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:3821:3: this_ParameterArrayType_7= ruleParameterArrayType
                    {

                    			newCompositeNode(grammarAccess.getParameterTypeAccess().getParameterArrayTypeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterArrayType_7=ruleParameterArrayType();

                    state._fsp--;


                    			current = this_ParameterArrayType_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3833:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRosParser.g:3833:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRosParser.g:3834:2: iv_ruleParameterValue= ruleParameterValue EOF
            {
             newCompositeNode(grammarAccess.getParameterValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterValue=ruleParameterValue();

            state._fsp--;

             current =iv_ruleParameterValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3840:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
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
            // InternalRosParser.g:3846:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRosParser.g:3847:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRosParser.g:3847:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt75=7;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalRosParser.g:3848:3: this_ParameterString_0= ruleParameterString
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStringParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterString_0=ruleParameterString();

                    state._fsp--;


                    			current = this_ParameterString_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:3857:3: this_ParameterBase64_1= ruleParameterBase64
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBase64ParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBase64_1=ruleParameterBase64();

                    state._fsp--;


                    			current = this_ParameterBase64_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:3866:3: this_ParameterInteger_2= ruleParameterInteger
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterIntegerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterInteger_2=ruleParameterInteger();

                    state._fsp--;


                    			current = this_ParameterInteger_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:3875:3: this_ParameterDouble_3= ruleParameterDouble
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterDoubleParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterDouble_3=ruleParameterDouble();

                    state._fsp--;


                    			current = this_ParameterDouble_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:3884:3: this_ParameterBoolean_4= ruleParameterBoolean
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterBooleanParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterBoolean_4=ruleParameterBoolean();

                    state._fsp--;


                    			current = this_ParameterBoolean_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:3893:3: this_ParameterList_5= ruleParameterList
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterListParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterList_5=ruleParameterList();

                    state._fsp--;


                    			current = this_ParameterList_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:3902:3: this_ParameterStruct_6= ruleParameterStruct
                    {

                    			newCompositeNode(grammarAccess.getParameterValueAccess().getParameterStructParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParameterStruct_6=ruleParameterStruct();

                    state._fsp--;


                    			current = this_ParameterStruct_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3914:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRosParser.g:3914:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRosParser.g:3915:2: iv_ruleParameterListType= ruleParameterListType EOF
            {
             newCompositeNode(grammarAccess.getParameterListTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterListType=ruleParameterListType();

            state._fsp--;

             current =iv_ruleParameterListType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:3921:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosParser.g:3927:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosParser.g:3928:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosParser.g:3928:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosParser.g:3929:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosParser.g:3929:3: ()
            // InternalRosParser.g:3930:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,List,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_56); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRosParser.g:3944:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRosParser.g:3945:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRosParser.g:3945:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRosParser.g:3946:5: lv_sequence_3_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_sequence_3_0=ruleParameterType();

            state._fsp--;


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

            // InternalRosParser.g:3963:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==Comma) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalRosParser.g:3964:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_56); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRosParser.g:3968:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRosParser.g:3969:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRosParser.g:3969:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRosParser.g:3970:6: lv_sequence_5_0= ruleParameterType
            	    {

            	    						newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_sequence_5_0=ruleParameterType();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterListTypeAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:3996:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRosParser.g:3996:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRosParser.g:3997:2: iv_ruleParameterStructType= ruleParameterStructType EOF
            {
             newCompositeNode(grammarAccess.getParameterStructTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructType=ruleParameterStructType();

            state._fsp--;

             current =iv_ruleParameterStructType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4003:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosParser.g:4009:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosParser.g:4010:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosParser.g:4010:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosParser.g:4011:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosParser.g:4011:3: ()
            // InternalRosParser.g:4012:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRosParser.g:4026:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRosParser.g:4027:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRosParser.g:4027:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRosParser.g:4028:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_parameterstructypetmember_3_0=ruleParameterStructTypeMember();

            state._fsp--;


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

            // InternalRosParser.g:4045:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==Comma) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalRosParser.g:4046:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRosParser.g:4050:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRosParser.g:4051:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRosParser.g:4051:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRosParser.g:4052:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
            	    {

            	    						newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_parameterstructypetmember_5_0=ruleParameterStructTypeMember();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterStructTypeAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4078:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRosParser.g:4078:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRosParser.g:4079:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
            {
             newCompositeNode(grammarAccess.getParameterIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterIntegerType=ruleParameterIntegerType();

            state._fsp--;

             current =iv_ruleParameterIntegerType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4085:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4091:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRosParser.g:4092:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRosParser.g:4092:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRosParser.g:4093:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRosParser.g:4093:3: ()
            // InternalRosParser.g:4094:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
            		
            // InternalRosParser.g:4104:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==Default) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalRosParser.g:4105:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_60); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:4109:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRosParser.g:4110:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRosParser.g:4110:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRosParser.g:4111:6: lv_default_3_0= ruleParameterInteger
                    {

                    						newCompositeNode(grammarAccess.getParameterIntegerTypeAccess().getDefaultParameterIntegerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterInteger();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4133:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRosParser.g:4133:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRosParser.g:4134:2: iv_ruleParameterStringType= ruleParameterStringType EOF
            {
             newCompositeNode(grammarAccess.getParameterStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStringType=ruleParameterStringType();

            state._fsp--;

             current =iv_ruleParameterStringType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4140:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4146:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRosParser.g:4147:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRosParser.g:4147:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRosParser.g:4148:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRosParser.g:4148:3: ()
            // InternalRosParser.g:4149:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
            		
            // InternalRosParser.g:4159:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==Default) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalRosParser.g:4160:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:4164:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRosParser.g:4165:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRosParser.g:4165:5: (lv_default_3_0= ruleParameterString )
                    // InternalRosParser.g:4166:6: lv_default_3_0= ruleParameterString
                    {

                    						newCompositeNode(grammarAccess.getParameterStringTypeAccess().getDefaultParameterStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterString();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4188:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRosParser.g:4188:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRosParser.g:4189:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
            {
             newCompositeNode(grammarAccess.getParameterDoubleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterDoubleType=ruleParameterDoubleType();

            state._fsp--;

             current =iv_ruleParameterDoubleType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4195:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4201:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRosParser.g:4202:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRosParser.g:4202:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRosParser.g:4203:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRosParser.g:4203:3: ()
            // InternalRosParser.g:4204:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
            		
            // InternalRosParser.g:4214:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==Default) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalRosParser.g:4215:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_61); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:4219:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRosParser.g:4220:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRosParser.g:4220:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRosParser.g:4221:6: lv_default_3_0= ruleParameterDouble
                    {

                    						newCompositeNode(grammarAccess.getParameterDoubleTypeAccess().getDefaultParameterDoubleParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterDouble();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4243:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRosParser.g:4243:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRosParser.g:4244:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
            {
             newCompositeNode(grammarAccess.getParameterBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBooleanType=ruleParameterBooleanType();

            state._fsp--;

             current =iv_ruleParameterBooleanType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4250:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4256:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRosParser.g:4257:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRosParser.g:4257:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRosParser.g:4258:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRosParser.g:4258:3: ()
            // InternalRosParser.g:4259:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalRosParser.g:4269:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==Default) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalRosParser.g:4270:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_39); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:4274:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRosParser.g:4275:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRosParser.g:4275:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRosParser.g:4276:6: lv_default_3_0= ruleParameterBoolean
                    {

                    						newCompositeNode(grammarAccess.getParameterBooleanTypeAccess().getDefaultParameterBooleanParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBoolean();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4298:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRosParser.g:4298:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRosParser.g:4299:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
            {
             newCompositeNode(grammarAccess.getParameterBase64TypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64Type=ruleParameterBase64Type();

            state._fsp--;

             current =iv_ruleParameterBase64Type; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4305:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4311:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRosParser.g:4312:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRosParser.g:4312:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRosParser.g:4313:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRosParser.g:4313:3: ()
            // InternalRosParser.g:4314:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
            		
            // InternalRosParser.g:4324:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==Default) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalRosParser.g:4325:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_62); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:4329:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRosParser.g:4330:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRosParser.g:4330:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRosParser.g:4331:6: lv_default_3_0= ruleParameterBase64
                    {

                    						newCompositeNode(grammarAccess.getParameterBase64TypeAccess().getDefaultParameterBase64ParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleParameterBase64();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4353:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRosParser.g:4353:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRosParser.g:4354:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
            {
             newCompositeNode(grammarAccess.getParameterArrayTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterArrayType=ruleParameterArrayType();

            state._fsp--;

             current =iv_ruleParameterArrayType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4360:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
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
            // InternalRosParser.g:4366:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRosParser.g:4367:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRosParser.g:4367:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRosParser.g:4368:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
            		
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_56); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRosParser.g:4376:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRosParser.g:4377:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRosParser.g:4377:4: (lv_type_2_0= ruleParameterType )
            // InternalRosParser.g:4378:5: lv_type_2_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_63);
            lv_type_2_0=ruleParameterType();

            state._fsp--;


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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_59); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
            		
            // InternalRosParser.g:4399:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==Default) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalRosParser.g:4400:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                    			
                    // InternalRosParser.g:4404:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRosParser.g:4405:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRosParser.g:4405:5: (lv_default_5_0= ruleParameterList )
                    // InternalRosParser.g:4406:6: lv_default_5_0= ruleParameterList
                    {

                    						newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getDefaultParameterListParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_default_5_0=ruleParameterList();

                    state._fsp--;


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
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4428:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRosParser.g:4428:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRosParser.g:4429:2: iv_ruleParameterList= ruleParameterList EOF
            {
             newCompositeNode(grammarAccess.getParameterListRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;

             current =iv_ruleParameterList; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4435:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4441:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRosParser.g:4442:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRosParser.g:4442:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRosParser.g:4443:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRosParser.g:4443:3: ()
            // InternalRosParser.g:4444:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_58); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRosParser.g:4454:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosParser.g:4455:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosParser.g:4455:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosParser.g:4456:5: lv_value_2_0= ruleParameterValue
            {

            					newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_value_2_0=ruleParameterValue();

            state._fsp--;


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

            // InternalRosParser.g:4473:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==Comma) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalRosParser.g:4474:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_58); 

            	    				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRosParser.g:4478:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRosParser.g:4479:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRosParser.g:4479:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRosParser.g:4480:6: lv_value_4_0= ruleParameterValue
            	    {

            	    						newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_11);
            	    lv_value_4_0=ruleParameterValue();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getParameterListAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4506:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRosParser.g:4506:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRosParser.g:4507:2: iv_ruleParameterAny= ruleParameterAny EOF
            {
             newCompositeNode(grammarAccess.getParameterAnyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterAny=ruleParameterAny();

            state._fsp--;

             current =iv_ruleParameterAny; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4513:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4519:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRosParser.g:4520:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRosParser.g:4520:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRosParser.g:4521:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRosParser.g:4521:3: ()
            // InternalRosParser.g:4522:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_64); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
            		
            // InternalRosParser.g:4532:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==Value) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalRosParser.g:4533:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                    			
                    // InternalRosParser.g:4537:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRosParser.g:4538:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRosParser.g:4538:5: (lv_value_3_0= ruleEString )
                    // InternalRosParser.g:4539:6: lv_value_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getParameterAnyAccess().getValueEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterAnyRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4561:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRosParser.g:4561:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRosParser.g:4562:2: iv_ruleParameterString= ruleParameterString EOF
            {
             newCompositeNode(grammarAccess.getParameterStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterString=ruleParameterString();

            state._fsp--;

             current =iv_ruleParameterString; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4568:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4574:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRosParser.g:4575:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRosParser.g:4575:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRosParser.g:4576:3: (lv_value_0_0= ruleEString )
            {
            // InternalRosParser.g:4576:3: (lv_value_0_0= ruleEString )
            // InternalRosParser.g:4577:4: lv_value_0_0= ruleEString
            {

            				newCompositeNode(grammarAccess.getParameterStringAccess().getValueEStringParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleEString();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getParameterStringRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.fraunhofer.ipa.ros.Ros.EString");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4597:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRosParser.g:4597:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRosParser.g:4598:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
            {
             newCompositeNode(grammarAccess.getParameterBase64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBase64=ruleParameterBase64();

            state._fsp--;

             current =iv_ruleParameterBase64; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4604:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4610:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRosParser.g:4611:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRosParser.g:4611:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRosParser.g:4612:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRosParser.g:4612:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRosParser.g:4613:4: lv_value_0_0= ruleBase64Binary
            {

            				newCompositeNode(grammarAccess.getParameterBase64Access().getValueBase64BinaryParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleBase64Binary();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:4633:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRosParser.g:4633:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRosParser.g:4634:2: iv_ruleParameterInteger= ruleParameterInteger EOF
            {
             newCompositeNode(grammarAccess.getParameterIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterInteger=ruleParameterInteger();

            state._fsp--;

             current =iv_ruleParameterInteger; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4640:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4646:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRosParser.g:4647:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRosParser.g:4647:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRosParser.g:4648:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRosParser.g:4648:3: (lv_value_0_0= ruleInteger0 )
            // InternalRosParser.g:4649:4: lv_value_0_0= ruleInteger0
            {

            				newCompositeNode(grammarAccess.getParameterIntegerAccess().getValueInteger0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleInteger0();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:4669:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRosParser.g:4669:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRosParser.g:4670:2: iv_ruleParameterDouble= ruleParameterDouble EOF
            {
             newCompositeNode(grammarAccess.getParameterDoubleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterDouble=ruleParameterDouble();

            state._fsp--;

             current =iv_ruleParameterDouble; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4676:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4682:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRosParser.g:4683:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRosParser.g:4683:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRosParser.g:4684:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRosParser.g:4684:3: (lv_value_0_0= ruleDouble0 )
            // InternalRosParser.g:4685:4: lv_value_0_0= ruleDouble0
            {

            				newCompositeNode(grammarAccess.getParameterDoubleAccess().getValueDouble0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDouble0();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:4705:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRosParser.g:4705:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRosParser.g:4706:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
            {
             newCompositeNode(grammarAccess.getParameterBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterBoolean=ruleParameterBoolean();

            state._fsp--;

             current =iv_ruleParameterBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4712:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4718:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRosParser.g:4719:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRosParser.g:4719:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRosParser.g:4720:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRosParser.g:4720:3: (lv_value_0_0= ruleboolean0 )
            // InternalRosParser.g:4721:4: lv_value_0_0= ruleboolean0
            {

            				newCompositeNode(grammarAccess.getParameterBooleanAccess().getValueBoolean0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleboolean0();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:4741:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRosParser.g:4741:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRosParser.g:4742:2: iv_ruleParameterStruct= ruleParameterStruct EOF
            {
             newCompositeNode(grammarAccess.getParameterStructRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStruct=ruleParameterStruct();

            state._fsp--;

             current =iv_ruleParameterStruct; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4748:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4754:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRosParser.g:4755:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRosParser.g:4755:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRosParser.g:4756:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRosParser.g:4756:3: ()
            // InternalRosParser.g:4757:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:4763:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==LeftSquareBracket) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalRosParser.g:4764:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_65); 

                    				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                    			
                    // InternalRosParser.g:4772:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==Pluginslots||LA86_0==Implements||LA86_0==Parameter||LA86_0==Multiple||LA86_0==Plugins||LA86_0==Format||LA86_0==Library||LA86_0==Base||LA86_0==Class||(LA86_0>=RULE_ID && LA86_0<=RULE_STRING)) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // InternalRosParser.g:4773:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRosParser.g:4773:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRosParser.g:4774:6: lv_value_3_0= ruleParameterStructMember
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_65);
                    	    lv_value_3_0=ruleParameterStructMember();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop86;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterStructAccess().getRightSquareBracketKeyword_1_3());
                    			
                    this_END_5=(Token)match(input,RULE_END,FOLLOW_2); 

                    				newLeafNode(this_END_5, grammarAccess.getParameterStructAccess().getENDTerminalRuleCall_1_4());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:4804:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRosParser.g:4804:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRosParser.g:4805:2: iv_ruleParameterDate= ruleParameterDate EOF
            {
             newCompositeNode(grammarAccess.getParameterDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterDate=ruleParameterDate();

            state._fsp--;

             current =iv_ruleParameterDate; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4811:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4817:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRosParser.g:4818:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRosParser.g:4818:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRosParser.g:4819:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRosParser.g:4819:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRosParser.g:4820:4: lv_value_0_0= ruleDateTime0
            {

            				newCompositeNode(grammarAccess.getParameterDateAccess().getValueDateTime0ParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDateTime0();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:4840:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRosParser.g:4840:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRosParser.g:4841:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
            {
             newCompositeNode(grammarAccess.getParameterStructMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructMember=ruleParameterStructMember();

            state._fsp--;

             current =iv_ruleParameterStructMember; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4847:1: ruleParameterStructMember returns [EObject current=null] : ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4853:2: ( ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) ) )
            // InternalRosParser.g:4854:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            {
            // InternalRosParser.g:4854:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) ) )
            // InternalRosParser.g:4855:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) ) ( (lv_value_3_0= ruleParameterValue ) )
            {
            // InternalRosParser.g:4855:3: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ) | ( (lv_name_2_0= ruleAddedKeywordName ) ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==Library||LA88_0==Class||(LA88_0>=RULE_ID && LA88_0<=RULE_STRING)) ) {
                alt88=1;
            }
            else if ( (LA88_0==Pluginslots||LA88_0==Implements||LA88_0==Parameter||LA88_0==Multiple||LA88_0==Plugins||LA88_0==Format||LA88_0==Base) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalRosParser.g:4856:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    {
                    // InternalRosParser.g:4856:4: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon )
                    // InternalRosParser.g:4857:5: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon
                    {
                    // InternalRosParser.g:4857:5: ( (lv_name_0_0= ruleEString ) )
                    // InternalRosParser.g:4858:6: (lv_name_0_0= ruleEString )
                    {
                    // InternalRosParser.g:4858:6: (lv_name_0_0= ruleEString )
                    // InternalRosParser.g:4859:7: lv_name_0_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_name_0_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
                    							}
                    							set(
                    								current,
                    								"name",
                    								lv_name_0_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_1=(Token)match(input,Colon,FOLLOW_58); 

                    					newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_0_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:4882:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:4882:4: ( (lv_name_2_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:4883:5: (lv_name_2_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:4883:5: (lv_name_2_0= ruleAddedKeywordName )
                    // InternalRosParser.g:4884:6: lv_name_2_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameAddedKeywordNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_58);
                    lv_name_2_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterStructMemberRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRosParser.g:4902:3: ( (lv_value_3_0= ruleParameterValue ) )
            // InternalRosParser.g:4903:4: (lv_value_3_0= ruleParameterValue )
            {
            // InternalRosParser.g:4903:4: (lv_value_3_0= ruleParameterValue )
            // InternalRosParser.g:4904:5: lv_value_3_0= ruleParameterValue
            {

            					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleParameterValue();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:4925:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRosParser.g:4925:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRosParser.g:4926:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
            {
             newCompositeNode(grammarAccess.getParameterStructTypeMemberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterStructTypeMember=ruleParameterStructTypeMember();

            state._fsp--;

             current =iv_ruleParameterStructTypeMember; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4932:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4938:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRosParser.g:4939:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRosParser.g:4939:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRosParser.g:4940:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRosParser.g:4940:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosParser.g:4941:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosParser.g:4941:4: (lv_name_0_0= ruleEString )
            // InternalRosParser.g:4942:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_56);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterStructTypeMemberRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"de.fraunhofer.ipa.ros.Ros.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:4959:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRosParser.g:4960:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRosParser.g:4960:4: (lv_type_1_0= ruleParameterType )
            // InternalRosParser.g:4961:5: lv_type_1_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getTypeParameterTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleParameterType();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:4982:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRosParser.g:4982:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRosParser.g:4983:2: iv_ruleBase64Binary= ruleBase64Binary EOF
            {
             newCompositeNode(grammarAccess.getBase64BinaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBase64Binary=ruleBase64Binary();

            state._fsp--;

             current =iv_ruleBase64Binary.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:4989:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:4995:2: (this_BINARY_0= RULE_BINARY )
            // InternalRosParser.g:4996:2: this_BINARY_0= RULE_BINARY
            {
            this_BINARY_0=(Token)match(input,RULE_BINARY,FOLLOW_2); 

            		current.merge(this_BINARY_0);
            	

            		newLeafNode(this_BINARY_0, grammarAccess.getBase64BinaryAccess().getBINARYTerminalRuleCall());
            	

            }


            	leaveRule();

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
    // InternalRosParser.g:5006:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRosParser.g:5006:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRosParser.g:5007:2: iv_ruleboolean0= ruleboolean0 EOF
            {
             newCompositeNode(grammarAccess.getBoolean0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleboolean0=ruleboolean0();

            state._fsp--;

             current =iv_ruleboolean0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5013:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:5019:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRosParser.g:5020:2: this_BOOLEAN_0= RULE_BOOLEAN
            {
            this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

            		current.merge(this_BOOLEAN_0);
            	

            		newLeafNode(this_BOOLEAN_0, grammarAccess.getBoolean0Access().getBOOLEANTerminalRuleCall());
            	

            }


            	leaveRule();

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
    // InternalRosParser.g:5030:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRosParser.g:5030:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRosParser.g:5031:2: iv_ruleDouble0= ruleDouble0 EOF
            {
             newCompositeNode(grammarAccess.getDouble0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDouble0=ruleDouble0();

            state._fsp--;

             current =iv_ruleDouble0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5037:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:5043:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRosParser.g:5044:2: this_DOUBLE_0= RULE_DOUBLE
            {
            this_DOUBLE_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

            		current.merge(this_DOUBLE_0);
            	

            		newLeafNode(this_DOUBLE_0, grammarAccess.getDouble0Access().getDOUBLETerminalRuleCall());
            	

            }


            	leaveRule();

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
    // InternalRosParser.g:5054:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRosParser.g:5054:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRosParser.g:5055:2: iv_ruleInteger0= ruleInteger0 EOF
            {
             newCompositeNode(grammarAccess.getInteger0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteger0=ruleInteger0();

            state._fsp--;

             current =iv_ruleInteger0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5061:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:5067:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosParser.g:5068:2: this_DECINT_0= RULE_DECINT
            {
            this_DECINT_0=(Token)match(input,RULE_DECINT,FOLLOW_2); 

            		current.merge(this_DECINT_0);
            	

            		newLeafNode(this_DECINT_0, grammarAccess.getInteger0Access().getDECINTTerminalRuleCall());
            	

            }


            	leaveRule();

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
    // InternalRosParser.g:5078:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRosParser.g:5078:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRosParser.g:5079:2: iv_ruleDateTime0= ruleDateTime0 EOF
            {
             newCompositeNode(grammarAccess.getDateTime0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateTime0=ruleDateTime0();

            state._fsp--;

             current =iv_ruleDateTime0.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5085:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:5091:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRosParser.g:5092:2: this_DATE_TIME_0= RULE_DATE_TIME
            {
            this_DATE_TIME_0=(Token)match(input,RULE_DATE_TIME,FOLLOW_2); 

            		current.merge(this_DATE_TIME_0);
            	

            		newLeafNode(this_DATE_TIME_0, grammarAccess.getDateTime0Access().getDATE_TIMETerminalRuleCall());
            	

            }


            	leaveRule();

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


    // $ANTLR start "entryRuleMessagePart"
    // InternalRosParser.g:5102:1: entryRuleMessagePart returns [EObject current=null] : iv_ruleMessagePart= ruleMessagePart EOF ;
    public final EObject entryRuleMessagePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePart = null;


        try {
            // InternalRosParser.g:5102:52: (iv_ruleMessagePart= ruleMessagePart EOF )
            // InternalRosParser.g:5103:2: iv_ruleMessagePart= ruleMessagePart EOF
            {
             newCompositeNode(grammarAccess.getMessagePartRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessagePart=ruleMessagePart();

            state._fsp--;

             current =iv_ruleMessagePart; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessagePart"


    // $ANTLR start "ruleMessagePart"
    // InternalRosParser.g:5109:1: ruleMessagePart returns [EObject current=null] : ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) ;
    public final EObject ruleMessagePart() throws RecognitionException {
        EObject current = null;

        Token lv_Data_1_2=null;
        EObject lv_Type_0_0 = null;

        AntlrDatatypeRuleToken lv_Data_1_1 = null;

        AntlrDatatypeRuleToken lv_Data_1_3 = null;



        	enterRule();

        try {
            // InternalRosParser.g:5115:2: ( ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) )
            // InternalRosParser.g:5116:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            {
            // InternalRosParser.g:5116:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            // InternalRosParser.g:5117:3: ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            {
            // InternalRosParser.g:5117:3: ( (lv_Type_0_0= ruleAbstractType ) )
            // InternalRosParser.g:5118:4: (lv_Type_0_0= ruleAbstractType )
            {
            // InternalRosParser.g:5118:4: (lv_Type_0_0= ruleAbstractType )
            // InternalRosParser.g:5119:5: lv_Type_0_0= ruleAbstractType
            {

            					newCompositeNode(grammarAccess.getMessagePartAccess().getTypeAbstractTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_66);
            lv_Type_0_0=ruleAbstractType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMessagePartRule());
            					}
            					set(
            						current,
            						"Type",
            						lv_Type_0_0,
            						"de.fraunhofer.ipa.ros.Basics.AbstractType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:5136:3: ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            // InternalRosParser.g:5137:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            {
            // InternalRosParser.g:5137:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            // InternalRosParser.g:5138:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            {
            // InternalRosParser.g:5138:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            int alt89=3;
            switch ( input.LA(1) ) {
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
                alt89=1;
                }
                break;
            case RULE_MESSAGE_ASIGMENT:
                {
                alt89=2;
                }
                break;
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt89=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalRosParser.g:5139:6: lv_Data_1_1= ruleKEYWORD
                    {

                    						newCompositeNode(grammarAccess.getMessagePartAccess().getDataKEYWORDParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_Data_1_1=ruleKEYWORD();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMessagePartRule());
                    						}
                    						set(
                    							current,
                    							"Data",
                    							lv_Data_1_1,
                    							"de.fraunhofer.ipa.ros.Basics.KEYWORD");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:5155:6: lv_Data_1_2= RULE_MESSAGE_ASIGMENT
                    {
                    lv_Data_1_2=(Token)match(input,RULE_MESSAGE_ASIGMENT,FOLLOW_2); 

                    						newLeafNode(lv_Data_1_2, grammarAccess.getMessagePartAccess().getDataMESSAGE_ASIGMENTTerminalRuleCall_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMessagePartRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"Data",
                    							lv_Data_1_2,
                    							"de.fraunhofer.ipa.ros.Basics.MESSAGE_ASIGMENT");
                    					

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:5170:6: lv_Data_1_3= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getMessagePartAccess().getDataEStringParserRuleCall_1_0_2());
                    					
                    pushFollow(FOLLOW_2);
                    lv_Data_1_3=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMessagePartRule());
                    						}
                    						set(
                    							current,
                    							"Data",
                    							lv_Data_1_3,
                    							"de.fraunhofer.ipa.ros.Ros.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessagePart"


    // $ANTLR start "entryRuleAbstractType"
    // InternalRosParser.g:5192:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRosParser.g:5192:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRosParser.g:5193:2: iv_ruleAbstractType= ruleAbstractType EOF
            {
             newCompositeNode(grammarAccess.getAbstractTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractType=ruleAbstractType();

            state._fsp--;

             current =iv_ruleAbstractType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5199:1: ruleAbstractType returns [EObject current=null] : (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) ) ;
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
            // InternalRosParser.g:5205:2: ( (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) ) )
            // InternalRosParser.g:5206:2: (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) )
            {
            // InternalRosParser.g:5206:2: (this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray | (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? ) )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=Float32_1 && LA92_0<=Float64_1)||(LA92_0>=String_2 && LA92_0<=Uint64_1)||(LA92_0>=Int16_1 && LA92_0<=Int64_1)||LA92_0==Uint8_1||(LA92_0>=Bool_1 && LA92_0<=Char_1)||LA92_0==Int8_1) ) {
                alt92=1;
            }
            else if ( ((LA92_0>=Float32_2 && LA92_0<=Float64_2)||LA92_0==Duration||(LA92_0>=String_3 && LA92_0<=Uint64_2)||(LA92_0>=Float32 && LA92_0<=Float64)||(LA92_0>=Int16_2 && LA92_0<=Library)||LA92_0==Uint8_2||LA92_0==Header||(LA92_0>=Bool_2 && LA92_0<=Char_2)||LA92_0==Int8_2||(LA92_0>=String_1 && LA92_0<=Uint64)||(LA92_0>=Class && LA92_0<=Int64)||LA92_0==Uint8||(LA92_0>=Bool && LA92_0<=Char)||LA92_0==Int8||LA92_0==Time||(LA92_0>=RULE_ID && LA92_0<=RULE_STRING)) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalRosParser.g:5207:3: this_SizedPrimitiveArray_0= ruleSizedPrimitiveArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getSizedPrimitiveArrayParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SizedPrimitiveArray_0=ruleSizedPrimitiveArray();

                    state._fsp--;


                    			current = this_SizedPrimitiveArray_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:5216:3: (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? )
                    {
                    // InternalRosParser.g:5216:3: (this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )? )
                    // InternalRosParser.g:5217:4: this_ElementType_1= ruleElementType ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )?
                    {

                    				newCompositeNode(grammarAccess.getAbstractTypeAccess().getElementTypeParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_53);
                    this_ElementType_1=ruleElementType();

                    state._fsp--;


                    				current = this_ElementType_1;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalRosParser.g:5225:4: ( () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==LeftSquareBracket) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalRosParser.g:5226:5: () otherlv_3= LeftSquareBracket ( (lv_bounded_4_0= LessThanSignEqualsSign ) )? ( (lv_size_5_0= ruleArraySize ) ) otherlv_6= RightSquareBracket
                            {
                            // InternalRosParser.g:5226:5: ()
                            // InternalRosParser.g:5227:6: 
                            {

                            						current = forceCreateModelElementAndSet(
                            							grammarAccess.getAbstractTypeAccess().getSizedArrayElementAction_1_1_0(),
                            							current);
                            					

                            }

                            otherlv_3=(Token)match(input,LeftSquareBracket,FOLLOW_67); 

                            					newLeafNode(otherlv_3, grammarAccess.getAbstractTypeAccess().getLeftSquareBracketKeyword_1_1_1());
                            				
                            // InternalRosParser.g:5237:5: ( (lv_bounded_4_0= LessThanSignEqualsSign ) )?
                            int alt90=2;
                            int LA90_0 = input.LA(1);

                            if ( (LA90_0==LessThanSignEqualsSign) ) {
                                alt90=1;
                            }
                            switch (alt90) {
                                case 1 :
                                    // InternalRosParser.g:5238:6: (lv_bounded_4_0= LessThanSignEqualsSign )
                                    {
                                    // InternalRosParser.g:5238:6: (lv_bounded_4_0= LessThanSignEqualsSign )
                                    // InternalRosParser.g:5239:7: lv_bounded_4_0= LessThanSignEqualsSign
                                    {
                                    lv_bounded_4_0=(Token)match(input,LessThanSignEqualsSign,FOLLOW_67); 

                                    							newLeafNode(lv_bounded_4_0, grammarAccess.getAbstractTypeAccess().getBoundedLessThanSignEqualsSignKeyword_1_1_2_0());
                                    						

                                    							if (current==null) {
                                    								current = createModelElement(grammarAccess.getAbstractTypeRule());
                                    							}
                                    							setWithLastConsumed(current, "bounded", lv_bounded_4_0 != null, "<=");
                                    						

                                    }


                                    }
                                    break;

                            }

                            // InternalRosParser.g:5251:5: ( (lv_size_5_0= ruleArraySize ) )
                            // InternalRosParser.g:5252:6: (lv_size_5_0= ruleArraySize )
                            {
                            // InternalRosParser.g:5252:6: (lv_size_5_0= ruleArraySize )
                            // InternalRosParser.g:5253:7: lv_size_5_0= ruleArraySize
                            {

                            							newCompositeNode(grammarAccess.getAbstractTypeAccess().getSizeArraySizeParserRuleCall_1_1_3_0());
                            						
                            pushFollow(FOLLOW_63);
                            lv_size_5_0=ruleArraySize();

                            state._fsp--;


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

                            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                            					newLeafNode(otherlv_6, grammarAccess.getAbstractTypeAccess().getRightSquareBracketKeyword_1_1_4());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5280:1: entryRuleSizedPrimitiveArray returns [EObject current=null] : iv_ruleSizedPrimitiveArray= ruleSizedPrimitiveArray EOF ;
    public final EObject entryRuleSizedPrimitiveArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedPrimitiveArray = null;


        try {
            // InternalRosParser.g:5280:60: (iv_ruleSizedPrimitiveArray= ruleSizedPrimitiveArray EOF )
            // InternalRosParser.g:5281:2: iv_ruleSizedPrimitiveArray= ruleSizedPrimitiveArray EOF
            {
             newCompositeNode(grammarAccess.getSizedPrimitiveArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedPrimitiveArray=ruleSizedPrimitiveArray();

            state._fsp--;

             current =iv_ruleSizedPrimitiveArray; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5287:1: ruleSizedPrimitiveArray returns [EObject current=null] : ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket ) ;
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
            // InternalRosParser.g:5293:2: ( ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket ) )
            // InternalRosParser.g:5294:2: ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket )
            {
            // InternalRosParser.g:5294:2: ( ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket )
            // InternalRosParser.g:5295:3: ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) ) ( (lv_bounded_14_0= LessThanSignEqualsSign ) )? ( (lv_size_15_0= ruleArraySize ) ) otherlv_16= RightSquareBracket
            {
            // InternalRosParser.g:5295:3: ( ( (lv_element_0_0= ruleSizedBool ) ) | ( (lv_element_1_0= ruleSizedInt8 ) ) | ( (lv_element_2_0= ruleSizedUint8 ) ) | ( (lv_element_3_0= ruleSizedInt16 ) ) | ( (lv_element_4_0= ruleSizedUint16 ) ) | ( (lv_element_5_0= ruleSizedInt32 ) ) | ( (lv_element_6_0= ruleSizedUint32 ) ) | ( (lv_element_7_0= ruleSizedInt64 ) ) | ( (lv_element_8_0= ruleSizedUint64 ) ) | ( (lv_element_9_0= ruleSizedFloat32 ) ) | ( (lv_element_10_0= ruleSizedFloat64 ) ) | ( (lv_element_11_0= ruleSizedString ) ) | ( (lv_element_12_0= ruleSizedByte ) ) | ( (lv_element_13_0= ruleSizedChar ) ) )
            int alt93=14;
            switch ( input.LA(1) ) {
            case Bool_1:
                {
                alt93=1;
                }
                break;
            case Int8_1:
                {
                alt93=2;
                }
                break;
            case Uint8_1:
                {
                alt93=3;
                }
                break;
            case Int16_1:
                {
                alt93=4;
                }
                break;
            case Uint16_1:
                {
                alt93=5;
                }
                break;
            case Int32_1:
                {
                alt93=6;
                }
                break;
            case Uint32_1:
                {
                alt93=7;
                }
                break;
            case Int64_1:
                {
                alt93=8;
                }
                break;
            case Uint64_1:
                {
                alt93=9;
                }
                break;
            case Float32_1:
                {
                alt93=10;
                }
                break;
            case Float64_1:
                {
                alt93=11;
                }
                break;
            case String_2:
                {
                alt93=12;
                }
                break;
            case Byte_1:
                {
                alt93=13;
                }
                break;
            case Char_1:
                {
                alt93=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalRosParser.g:5296:4: ( (lv_element_0_0= ruleSizedBool ) )
                    {
                    // InternalRosParser.g:5296:4: ( (lv_element_0_0= ruleSizedBool ) )
                    // InternalRosParser.g:5297:5: (lv_element_0_0= ruleSizedBool )
                    {
                    // InternalRosParser.g:5297:5: (lv_element_0_0= ruleSizedBool )
                    // InternalRosParser.g:5298:6: lv_element_0_0= ruleSizedBool
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedBoolParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_0_0=ruleSizedBool();

                    state._fsp--;


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
                    break;
                case 2 :
                    // InternalRosParser.g:5316:4: ( (lv_element_1_0= ruleSizedInt8 ) )
                    {
                    // InternalRosParser.g:5316:4: ( (lv_element_1_0= ruleSizedInt8 ) )
                    // InternalRosParser.g:5317:5: (lv_element_1_0= ruleSizedInt8 )
                    {
                    // InternalRosParser.g:5317:5: (lv_element_1_0= ruleSizedInt8 )
                    // InternalRosParser.g:5318:6: lv_element_1_0= ruleSizedInt8
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt8ParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_1_0=ruleSizedInt8();

                    state._fsp--;


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
                    break;
                case 3 :
                    // InternalRosParser.g:5336:4: ( (lv_element_2_0= ruleSizedUint8 ) )
                    {
                    // InternalRosParser.g:5336:4: ( (lv_element_2_0= ruleSizedUint8 ) )
                    // InternalRosParser.g:5337:5: (lv_element_2_0= ruleSizedUint8 )
                    {
                    // InternalRosParser.g:5337:5: (lv_element_2_0= ruleSizedUint8 )
                    // InternalRosParser.g:5338:6: lv_element_2_0= ruleSizedUint8
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint8ParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_2_0=ruleSizedUint8();

                    state._fsp--;


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
                    break;
                case 4 :
                    // InternalRosParser.g:5356:4: ( (lv_element_3_0= ruleSizedInt16 ) )
                    {
                    // InternalRosParser.g:5356:4: ( (lv_element_3_0= ruleSizedInt16 ) )
                    // InternalRosParser.g:5357:5: (lv_element_3_0= ruleSizedInt16 )
                    {
                    // InternalRosParser.g:5357:5: (lv_element_3_0= ruleSizedInt16 )
                    // InternalRosParser.g:5358:6: lv_element_3_0= ruleSizedInt16
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt16ParserRuleCall_0_3_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_3_0=ruleSizedInt16();

                    state._fsp--;


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
                    break;
                case 5 :
                    // InternalRosParser.g:5376:4: ( (lv_element_4_0= ruleSizedUint16 ) )
                    {
                    // InternalRosParser.g:5376:4: ( (lv_element_4_0= ruleSizedUint16 ) )
                    // InternalRosParser.g:5377:5: (lv_element_4_0= ruleSizedUint16 )
                    {
                    // InternalRosParser.g:5377:5: (lv_element_4_0= ruleSizedUint16 )
                    // InternalRosParser.g:5378:6: lv_element_4_0= ruleSizedUint16
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint16ParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_4_0=ruleSizedUint16();

                    state._fsp--;


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
                    break;
                case 6 :
                    // InternalRosParser.g:5396:4: ( (lv_element_5_0= ruleSizedInt32 ) )
                    {
                    // InternalRosParser.g:5396:4: ( (lv_element_5_0= ruleSizedInt32 ) )
                    // InternalRosParser.g:5397:5: (lv_element_5_0= ruleSizedInt32 )
                    {
                    // InternalRosParser.g:5397:5: (lv_element_5_0= ruleSizedInt32 )
                    // InternalRosParser.g:5398:6: lv_element_5_0= ruleSizedInt32
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt32ParserRuleCall_0_5_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_5_0=ruleSizedInt32();

                    state._fsp--;


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
                    break;
                case 7 :
                    // InternalRosParser.g:5416:4: ( (lv_element_6_0= ruleSizedUint32 ) )
                    {
                    // InternalRosParser.g:5416:4: ( (lv_element_6_0= ruleSizedUint32 ) )
                    // InternalRosParser.g:5417:5: (lv_element_6_0= ruleSizedUint32 )
                    {
                    // InternalRosParser.g:5417:5: (lv_element_6_0= ruleSizedUint32 )
                    // InternalRosParser.g:5418:6: lv_element_6_0= ruleSizedUint32
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint32ParserRuleCall_0_6_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_6_0=ruleSizedUint32();

                    state._fsp--;


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
                    break;
                case 8 :
                    // InternalRosParser.g:5436:4: ( (lv_element_7_0= ruleSizedInt64 ) )
                    {
                    // InternalRosParser.g:5436:4: ( (lv_element_7_0= ruleSizedInt64 ) )
                    // InternalRosParser.g:5437:5: (lv_element_7_0= ruleSizedInt64 )
                    {
                    // InternalRosParser.g:5437:5: (lv_element_7_0= ruleSizedInt64 )
                    // InternalRosParser.g:5438:6: lv_element_7_0= ruleSizedInt64
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedInt64ParserRuleCall_0_7_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_7_0=ruleSizedInt64();

                    state._fsp--;


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
                    break;
                case 9 :
                    // InternalRosParser.g:5456:4: ( (lv_element_8_0= ruleSizedUint64 ) )
                    {
                    // InternalRosParser.g:5456:4: ( (lv_element_8_0= ruleSizedUint64 ) )
                    // InternalRosParser.g:5457:5: (lv_element_8_0= ruleSizedUint64 )
                    {
                    // InternalRosParser.g:5457:5: (lv_element_8_0= ruleSizedUint64 )
                    // InternalRosParser.g:5458:6: lv_element_8_0= ruleSizedUint64
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedUint64ParserRuleCall_0_8_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_8_0=ruleSizedUint64();

                    state._fsp--;


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
                    break;
                case 10 :
                    // InternalRosParser.g:5476:4: ( (lv_element_9_0= ruleSizedFloat32 ) )
                    {
                    // InternalRosParser.g:5476:4: ( (lv_element_9_0= ruleSizedFloat32 ) )
                    // InternalRosParser.g:5477:5: (lv_element_9_0= ruleSizedFloat32 )
                    {
                    // InternalRosParser.g:5477:5: (lv_element_9_0= ruleSizedFloat32 )
                    // InternalRosParser.g:5478:6: lv_element_9_0= ruleSizedFloat32
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedFloat32ParserRuleCall_0_9_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_9_0=ruleSizedFloat32();

                    state._fsp--;


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
                    break;
                case 11 :
                    // InternalRosParser.g:5496:4: ( (lv_element_10_0= ruleSizedFloat64 ) )
                    {
                    // InternalRosParser.g:5496:4: ( (lv_element_10_0= ruleSizedFloat64 ) )
                    // InternalRosParser.g:5497:5: (lv_element_10_0= ruleSizedFloat64 )
                    {
                    // InternalRosParser.g:5497:5: (lv_element_10_0= ruleSizedFloat64 )
                    // InternalRosParser.g:5498:6: lv_element_10_0= ruleSizedFloat64
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedFloat64ParserRuleCall_0_10_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_10_0=ruleSizedFloat64();

                    state._fsp--;


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
                    break;
                case 12 :
                    // InternalRosParser.g:5516:4: ( (lv_element_11_0= ruleSizedString ) )
                    {
                    // InternalRosParser.g:5516:4: ( (lv_element_11_0= ruleSizedString ) )
                    // InternalRosParser.g:5517:5: (lv_element_11_0= ruleSizedString )
                    {
                    // InternalRosParser.g:5517:5: (lv_element_11_0= ruleSizedString )
                    // InternalRosParser.g:5518:6: lv_element_11_0= ruleSizedString
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedStringParserRuleCall_0_11_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_11_0=ruleSizedString();

                    state._fsp--;


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
                    break;
                case 13 :
                    // InternalRosParser.g:5536:4: ( (lv_element_12_0= ruleSizedByte ) )
                    {
                    // InternalRosParser.g:5536:4: ( (lv_element_12_0= ruleSizedByte ) )
                    // InternalRosParser.g:5537:5: (lv_element_12_0= ruleSizedByte )
                    {
                    // InternalRosParser.g:5537:5: (lv_element_12_0= ruleSizedByte )
                    // InternalRosParser.g:5538:6: lv_element_12_0= ruleSizedByte
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedByteParserRuleCall_0_12_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_12_0=ruleSizedByte();

                    state._fsp--;


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
                    break;
                case 14 :
                    // InternalRosParser.g:5556:4: ( (lv_element_13_0= ruleSizedChar ) )
                    {
                    // InternalRosParser.g:5556:4: ( (lv_element_13_0= ruleSizedChar ) )
                    // InternalRosParser.g:5557:5: (lv_element_13_0= ruleSizedChar )
                    {
                    // InternalRosParser.g:5557:5: (lv_element_13_0= ruleSizedChar )
                    // InternalRosParser.g:5558:6: lv_element_13_0= ruleSizedChar
                    {

                    						newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getElementSizedCharParserRuleCall_0_13_0());
                    					
                    pushFollow(FOLLOW_67);
                    lv_element_13_0=ruleSizedChar();

                    state._fsp--;


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
                    break;

            }

            // InternalRosParser.g:5576:3: ( (lv_bounded_14_0= LessThanSignEqualsSign ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==LessThanSignEqualsSign) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalRosParser.g:5577:4: (lv_bounded_14_0= LessThanSignEqualsSign )
                    {
                    // InternalRosParser.g:5577:4: (lv_bounded_14_0= LessThanSignEqualsSign )
                    // InternalRosParser.g:5578:5: lv_bounded_14_0= LessThanSignEqualsSign
                    {
                    lv_bounded_14_0=(Token)match(input,LessThanSignEqualsSign,FOLLOW_67); 

                    					newLeafNode(lv_bounded_14_0, grammarAccess.getSizedPrimitiveArrayAccess().getBoundedLessThanSignEqualsSignKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSizedPrimitiveArrayRule());
                    					}
                    					setWithLastConsumed(current, "bounded", lv_bounded_14_0 != null, "<=");
                    				

                    }


                    }
                    break;

            }

            // InternalRosParser.g:5590:3: ( (lv_size_15_0= ruleArraySize ) )
            // InternalRosParser.g:5591:4: (lv_size_15_0= ruleArraySize )
            {
            // InternalRosParser.g:5591:4: (lv_size_15_0= ruleArraySize )
            // InternalRosParser.g:5592:5: lv_size_15_0= ruleArraySize
            {

            					newCompositeNode(grammarAccess.getSizedPrimitiveArrayAccess().getSizeArraySizeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_63);
            lv_size_15_0=ruleArraySize();

            state._fsp--;


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

            otherlv_16=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getSizedPrimitiveArrayAccess().getRightSquareBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5617:1: entryRuleSizedBool returns [EObject current=null] : iv_ruleSizedBool= ruleSizedBool EOF ;
    public final EObject entryRuleSizedBool() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedBool = null;


        try {
            // InternalRosParser.g:5617:50: (iv_ruleSizedBool= ruleSizedBool EOF )
            // InternalRosParser.g:5618:2: iv_ruleSizedBool= ruleSizedBool EOF
            {
             newCompositeNode(grammarAccess.getSizedBoolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedBool=ruleSizedBool();

            state._fsp--;

             current =iv_ruleSizedBool; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5624:1: ruleSizedBool returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleSizedBool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5630:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRosParser.g:5631:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRosParser.g:5631:2: ( () otherlv_1= Bool_1 )
            // InternalRosParser.g:5632:3: () otherlv_1= Bool_1
            {
            // InternalRosParser.g:5632:3: ()
            // InternalRosParser.g:5633:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedBoolAccess().getBoolAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Bool_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedBoolAccess().getBoolKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5647:1: entryRuleSizedInt8 returns [EObject current=null] : iv_ruleSizedInt8= ruleSizedInt8 EOF ;
    public final EObject entryRuleSizedInt8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt8 = null;


        try {
            // InternalRosParser.g:5647:50: (iv_ruleSizedInt8= ruleSizedInt8 EOF )
            // InternalRosParser.g:5648:2: iv_ruleSizedInt8= ruleSizedInt8 EOF
            {
             newCompositeNode(grammarAccess.getSizedInt8Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt8=ruleSizedInt8();

            state._fsp--;

             current =iv_ruleSizedInt8; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5654:1: ruleSizedInt8 returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleSizedInt8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5660:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRosParser.g:5661:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRosParser.g:5661:2: ( () otherlv_1= Int8_1 )
            // InternalRosParser.g:5662:3: () otherlv_1= Int8_1
            {
            // InternalRosParser.g:5662:3: ()
            // InternalRosParser.g:5663:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedInt8Access().getInt8Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int8_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedInt8Access().getInt8Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5677:1: entryRuleSizedUint8 returns [EObject current=null] : iv_ruleSizedUint8= ruleSizedUint8 EOF ;
    public final EObject entryRuleSizedUint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint8 = null;


        try {
            // InternalRosParser.g:5677:51: (iv_ruleSizedUint8= ruleSizedUint8 EOF )
            // InternalRosParser.g:5678:2: iv_ruleSizedUint8= ruleSizedUint8 EOF
            {
             newCompositeNode(grammarAccess.getSizedUint8Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint8=ruleSizedUint8();

            state._fsp--;

             current =iv_ruleSizedUint8; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5684:1: ruleSizedUint8 returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleSizedUint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5690:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRosParser.g:5691:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRosParser.g:5691:2: ( () otherlv_1= Uint8_1 )
            // InternalRosParser.g:5692:3: () otherlv_1= Uint8_1
            {
            // InternalRosParser.g:5692:3: ()
            // InternalRosParser.g:5693:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedUint8Access().getUint8Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint8_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedUint8Access().getUint8Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5707:1: entryRuleSizedInt16 returns [EObject current=null] : iv_ruleSizedInt16= ruleSizedInt16 EOF ;
    public final EObject entryRuleSizedInt16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt16 = null;


        try {
            // InternalRosParser.g:5707:51: (iv_ruleSizedInt16= ruleSizedInt16 EOF )
            // InternalRosParser.g:5708:2: iv_ruleSizedInt16= ruleSizedInt16 EOF
            {
             newCompositeNode(grammarAccess.getSizedInt16Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt16=ruleSizedInt16();

            state._fsp--;

             current =iv_ruleSizedInt16; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5714:1: ruleSizedInt16 returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleSizedInt16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5720:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRosParser.g:5721:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRosParser.g:5721:2: ( () otherlv_1= Int16_1 )
            // InternalRosParser.g:5722:3: () otherlv_1= Int16_1
            {
            // InternalRosParser.g:5722:3: ()
            // InternalRosParser.g:5723:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedInt16Access().getInt16Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int16_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedInt16Access().getInt16Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5737:1: entryRuleSizedUint16 returns [EObject current=null] : iv_ruleSizedUint16= ruleSizedUint16 EOF ;
    public final EObject entryRuleSizedUint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint16 = null;


        try {
            // InternalRosParser.g:5737:52: (iv_ruleSizedUint16= ruleSizedUint16 EOF )
            // InternalRosParser.g:5738:2: iv_ruleSizedUint16= ruleSizedUint16 EOF
            {
             newCompositeNode(grammarAccess.getSizedUint16Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint16=ruleSizedUint16();

            state._fsp--;

             current =iv_ruleSizedUint16; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5744:1: ruleSizedUint16 returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleSizedUint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5750:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRosParser.g:5751:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRosParser.g:5751:2: ( () otherlv_1= Uint16_1 )
            // InternalRosParser.g:5752:3: () otherlv_1= Uint16_1
            {
            // InternalRosParser.g:5752:3: ()
            // InternalRosParser.g:5753:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedUint16Access().getUint16Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint16_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedUint16Access().getUint16Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5767:1: entryRuleSizedInt32 returns [EObject current=null] : iv_ruleSizedInt32= ruleSizedInt32 EOF ;
    public final EObject entryRuleSizedInt32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt32 = null;


        try {
            // InternalRosParser.g:5767:51: (iv_ruleSizedInt32= ruleSizedInt32 EOF )
            // InternalRosParser.g:5768:2: iv_ruleSizedInt32= ruleSizedInt32 EOF
            {
             newCompositeNode(grammarAccess.getSizedInt32Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt32=ruleSizedInt32();

            state._fsp--;

             current =iv_ruleSizedInt32; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5774:1: ruleSizedInt32 returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleSizedInt32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5780:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRosParser.g:5781:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRosParser.g:5781:2: ( () otherlv_1= Int32_1 )
            // InternalRosParser.g:5782:3: () otherlv_1= Int32_1
            {
            // InternalRosParser.g:5782:3: ()
            // InternalRosParser.g:5783:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedInt32Access().getInt32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int32_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedInt32Access().getInt32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5797:1: entryRuleSizedUint32 returns [EObject current=null] : iv_ruleSizedUint32= ruleSizedUint32 EOF ;
    public final EObject entryRuleSizedUint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint32 = null;


        try {
            // InternalRosParser.g:5797:52: (iv_ruleSizedUint32= ruleSizedUint32 EOF )
            // InternalRosParser.g:5798:2: iv_ruleSizedUint32= ruleSizedUint32 EOF
            {
             newCompositeNode(grammarAccess.getSizedUint32Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint32=ruleSizedUint32();

            state._fsp--;

             current =iv_ruleSizedUint32; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5804:1: ruleSizedUint32 returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleSizedUint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5810:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRosParser.g:5811:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRosParser.g:5811:2: ( () otherlv_1= Uint32_1 )
            // InternalRosParser.g:5812:3: () otherlv_1= Uint32_1
            {
            // InternalRosParser.g:5812:3: ()
            // InternalRosParser.g:5813:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedUint32Access().getUint32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint32_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedUint32Access().getUint32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5827:1: entryRuleSizedInt64 returns [EObject current=null] : iv_ruleSizedInt64= ruleSizedInt64 EOF ;
    public final EObject entryRuleSizedInt64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedInt64 = null;


        try {
            // InternalRosParser.g:5827:51: (iv_ruleSizedInt64= ruleSizedInt64 EOF )
            // InternalRosParser.g:5828:2: iv_ruleSizedInt64= ruleSizedInt64 EOF
            {
             newCompositeNode(grammarAccess.getSizedInt64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedInt64=ruleSizedInt64();

            state._fsp--;

             current =iv_ruleSizedInt64; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5834:1: ruleSizedInt64 returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleSizedInt64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5840:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRosParser.g:5841:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRosParser.g:5841:2: ( () otherlv_1= Int64_1 )
            // InternalRosParser.g:5842:3: () otherlv_1= Int64_1
            {
            // InternalRosParser.g:5842:3: ()
            // InternalRosParser.g:5843:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedInt64Access().getInt64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int64_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedInt64Access().getInt64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5857:1: entryRuleSizedUint64 returns [EObject current=null] : iv_ruleSizedUint64= ruleSizedUint64 EOF ;
    public final EObject entryRuleSizedUint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedUint64 = null;


        try {
            // InternalRosParser.g:5857:52: (iv_ruleSizedUint64= ruleSizedUint64 EOF )
            // InternalRosParser.g:5858:2: iv_ruleSizedUint64= ruleSizedUint64 EOF
            {
             newCompositeNode(grammarAccess.getSizedUint64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedUint64=ruleSizedUint64();

            state._fsp--;

             current =iv_ruleSizedUint64; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5864:1: ruleSizedUint64 returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleSizedUint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5870:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRosParser.g:5871:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRosParser.g:5871:2: ( () otherlv_1= Uint64_1 )
            // InternalRosParser.g:5872:3: () otherlv_1= Uint64_1
            {
            // InternalRosParser.g:5872:3: ()
            // InternalRosParser.g:5873:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedUint64Access().getUint64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint64_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedUint64Access().getUint64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5887:1: entryRuleSizedFloat32 returns [EObject current=null] : iv_ruleSizedFloat32= ruleSizedFloat32 EOF ;
    public final EObject entryRuleSizedFloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedFloat32 = null;


        try {
            // InternalRosParser.g:5887:53: (iv_ruleSizedFloat32= ruleSizedFloat32 EOF )
            // InternalRosParser.g:5888:2: iv_ruleSizedFloat32= ruleSizedFloat32 EOF
            {
             newCompositeNode(grammarAccess.getSizedFloat32Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedFloat32=ruleSizedFloat32();

            state._fsp--;

             current =iv_ruleSizedFloat32; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5894:1: ruleSizedFloat32 returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject ruleSizedFloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5900:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRosParser.g:5901:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRosParser.g:5901:2: ( () otherlv_1= Float32_1 )
            // InternalRosParser.g:5902:3: () otherlv_1= Float32_1
            {
            // InternalRosParser.g:5902:3: ()
            // InternalRosParser.g:5903:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedFloat32Access().getFloat32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float32_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedFloat32Access().getFloat32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5917:1: entryRuleSizedFloat64 returns [EObject current=null] : iv_ruleSizedFloat64= ruleSizedFloat64 EOF ;
    public final EObject entryRuleSizedFloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedFloat64 = null;


        try {
            // InternalRosParser.g:5917:53: (iv_ruleSizedFloat64= ruleSizedFloat64 EOF )
            // InternalRosParser.g:5918:2: iv_ruleSizedFloat64= ruleSizedFloat64 EOF
            {
             newCompositeNode(grammarAccess.getSizedFloat64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedFloat64=ruleSizedFloat64();

            state._fsp--;

             current =iv_ruleSizedFloat64; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5924:1: ruleSizedFloat64 returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject ruleSizedFloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5930:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRosParser.g:5931:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRosParser.g:5931:2: ( () otherlv_1= Float64_1 )
            // InternalRosParser.g:5932:3: () otherlv_1= Float64_1
            {
            // InternalRosParser.g:5932:3: ()
            // InternalRosParser.g:5933:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedFloat64Access().getFloat64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float64_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedFloat64Access().getFloat64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5947:1: entryRuleSizedString returns [EObject current=null] : iv_ruleSizedString= ruleSizedString EOF ;
    public final EObject entryRuleSizedString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedString = null;


        try {
            // InternalRosParser.g:5947:52: (iv_ruleSizedString= ruleSizedString EOF )
            // InternalRosParser.g:5948:2: iv_ruleSizedString= ruleSizedString EOF
            {
             newCompositeNode(grammarAccess.getSizedStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedString=ruleSizedString();

            state._fsp--;

             current =iv_ruleSizedString; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5954:1: ruleSizedString returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject ruleSizedString() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5960:2: ( ( () otherlv_1= String_2 ) )
            // InternalRosParser.g:5961:2: ( () otherlv_1= String_2 )
            {
            // InternalRosParser.g:5961:2: ( () otherlv_1= String_2 )
            // InternalRosParser.g:5962:3: () otherlv_1= String_2
            {
            // InternalRosParser.g:5962:3: ()
            // InternalRosParser.g:5963:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedStringAccess().getStringAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedStringAccess().getStringKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:5977:1: entryRuleSizedByte returns [EObject current=null] : iv_ruleSizedByte= ruleSizedByte EOF ;
    public final EObject entryRuleSizedByte() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedByte = null;


        try {
            // InternalRosParser.g:5977:50: (iv_ruleSizedByte= ruleSizedByte EOF )
            // InternalRosParser.g:5978:2: iv_ruleSizedByte= ruleSizedByte EOF
            {
             newCompositeNode(grammarAccess.getSizedByteRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedByte=ruleSizedByte();

            state._fsp--;

             current =iv_ruleSizedByte; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:5984:1: ruleSizedByte returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject ruleSizedByte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5990:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRosParser.g:5991:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRosParser.g:5991:2: ( () otherlv_1= Byte_1 )
            // InternalRosParser.g:5992:3: () otherlv_1= Byte_1
            {
            // InternalRosParser.g:5992:3: ()
            // InternalRosParser.g:5993:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedByteAccess().getByteAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Byte_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedByteAccess().getByteKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6007:1: entryRuleSizedChar returns [EObject current=null] : iv_ruleSizedChar= ruleSizedChar EOF ;
    public final EObject entryRuleSizedChar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizedChar = null;


        try {
            // InternalRosParser.g:6007:50: (iv_ruleSizedChar= ruleSizedChar EOF )
            // InternalRosParser.g:6008:2: iv_ruleSizedChar= ruleSizedChar EOF
            {
             newCompositeNode(grammarAccess.getSizedCharRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizedChar=ruleSizedChar();

            state._fsp--;

             current =iv_ruleSizedChar; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6014:1: ruleSizedChar returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject ruleSizedChar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6020:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRosParser.g:6021:2: ( () otherlv_1= Char_1 )
            {
            // InternalRosParser.g:6021:2: ( () otherlv_1= Char_1 )
            // InternalRosParser.g:6022:3: () otherlv_1= Char_1
            {
            // InternalRosParser.g:6022:3: ()
            // InternalRosParser.g:6023:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSizedCharAccess().getChar0Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Char_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getSizedCharAccess().getCharKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6037:1: entryRuleArraySize returns [String current=null] : iv_ruleArraySize= ruleArraySize EOF ;
    public final String entryRuleArraySize() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArraySize = null;


        try {
            // InternalRosParser.g:6037:49: (iv_ruleArraySize= ruleArraySize EOF )
            // InternalRosParser.g:6038:2: iv_ruleArraySize= ruleArraySize EOF
            {
             newCompositeNode(grammarAccess.getArraySizeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArraySize=ruleArraySize();

            state._fsp--;

             current =iv_ruleArraySize.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6044:1: ruleArraySize returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleArraySize() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:6050:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosParser.g:6051:2: this_DECINT_0= RULE_DECINT
            {
            this_DECINT_0=(Token)match(input,RULE_DECINT,FOLLOW_2); 

            		current.merge(this_DECINT_0);
            	

            		newLeafNode(this_DECINT_0, grammarAccess.getArraySizeAccess().getDECINTTerminalRuleCall());
            	

            }


            	leaveRule();

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
    // InternalRosParser.g:6061:1: entryRuleElementType returns [EObject current=null] : iv_ruleElementType= ruleElementType EOF ;
    public final EObject entryRuleElementType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementType = null;


        try {
            // InternalRosParser.g:6061:52: (iv_ruleElementType= ruleElementType EOF )
            // InternalRosParser.g:6062:2: iv_ruleElementType= ruleElementType EOF
            {
             newCompositeNode(grammarAccess.getElementTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElementType=ruleElementType();

            state._fsp--;

             current =iv_ruleElementType; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6068:1: ruleElementType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
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
            // InternalRosParser.g:6074:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRosParser.g:6075:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRosParser.g:6075:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt95=33;
            alt95 = dfa95.predict(input);
            switch (alt95) {
                case 1 :
                    // InternalRosParser.g:6076:3: this_bool_0= rulebool
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getBoolParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_bool_0=rulebool();

                    state._fsp--;


                    			current = this_bool_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:6085:3: this_int8_1= ruleint8
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt8ParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8_1=ruleint8();

                    state._fsp--;


                    			current = this_int8_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:6094:3: this_uint8_2= ruleuint8
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint8ParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8_2=ruleuint8();

                    state._fsp--;


                    			current = this_uint8_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:6103:3: this_int16_3= ruleint16
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt16ParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16_3=ruleint16();

                    state._fsp--;


                    			current = this_int16_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:6112:3: this_uint16_4= ruleuint16
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint16ParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16_4=ruleuint16();

                    state._fsp--;


                    			current = this_uint16_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:6121:3: this_int32_5= ruleint32
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt32ParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32_5=ruleint32();

                    state._fsp--;


                    			current = this_int32_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:6130:3: this_uint32_6= ruleuint32
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint32ParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32_6=ruleuint32();

                    state._fsp--;


                    			current = this_uint32_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:6139:3: this_int64_7= ruleint64
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt64ParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64_7=ruleint64();

                    state._fsp--;


                    			current = this_int64_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:6148:3: this_uint64_8= ruleuint64
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint64ParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64_8=ruleuint64();

                    state._fsp--;


                    			current = this_uint64_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:6157:3: this_float32_9= rulefloat32
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat32ParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32_9=rulefloat32();

                    state._fsp--;


                    			current = this_float32_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:6166:3: this_float64_10= rulefloat64
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat64ParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64_10=rulefloat64();

                    state._fsp--;


                    			current = this_float64_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalRosParser.g:6175:3: this_string0_11= rulestring0
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getString0ParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0_11=rulestring0();

                    state._fsp--;


                    			current = this_string0_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalRosParser.g:6184:3: this_byte_12= rulebyte
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getByteParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_byte_12=rulebyte();

                    state._fsp--;


                    			current = this_byte_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalRosParser.g:6193:3: this_time_13= ruletime
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getTimeParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_time_13=ruletime();

                    state._fsp--;


                    			current = this_time_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalRosParser.g:6202:3: this_duration_14= ruleduration
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getDurationParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_duration_14=ruleduration();

                    state._fsp--;


                    			current = this_duration_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalRosParser.g:6211:3: this_Header_15= ruleHeader
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getHeaderParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_Header_15=ruleHeader();

                    state._fsp--;


                    			current = this_Header_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 17 :
                    // InternalRosParser.g:6220:3: this_boolArray_16= ruleboolArray
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getBoolArrayParserRuleCall_16());
                    		
                    pushFollow(FOLLOW_2);
                    this_boolArray_16=ruleboolArray();

                    state._fsp--;


                    			current = this_boolArray_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 18 :
                    // InternalRosParser.g:6229:3: this_int8Array_17= ruleint8Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt8ArrayParserRuleCall_17());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8Array_17=ruleint8Array();

                    state._fsp--;


                    			current = this_int8Array_17;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 19 :
                    // InternalRosParser.g:6238:3: this_uint8Array_18= ruleuint8Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint8ArrayParserRuleCall_18());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8Array_18=ruleuint8Array();

                    state._fsp--;


                    			current = this_uint8Array_18;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 20 :
                    // InternalRosParser.g:6247:3: this_int16Array_19= ruleint16Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt16ArrayParserRuleCall_19());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16Array_19=ruleint16Array();

                    state._fsp--;


                    			current = this_int16Array_19;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 21 :
                    // InternalRosParser.g:6256:3: this_uint16Array_20= ruleuint16Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint16ArrayParserRuleCall_20());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16Array_20=ruleuint16Array();

                    state._fsp--;


                    			current = this_uint16Array_20;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 22 :
                    // InternalRosParser.g:6265:3: this_int32Array_21= ruleint32Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt32ArrayParserRuleCall_21());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32Array_21=ruleint32Array();

                    state._fsp--;


                    			current = this_int32Array_21;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 23 :
                    // InternalRosParser.g:6274:3: this_uint32Array_22= ruleuint32Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint32ArrayParserRuleCall_22());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32Array_22=ruleuint32Array();

                    state._fsp--;


                    			current = this_uint32Array_22;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 24 :
                    // InternalRosParser.g:6283:3: this_int64Array_23= ruleint64Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getInt64ArrayParserRuleCall_23());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64Array_23=ruleint64Array();

                    state._fsp--;


                    			current = this_int64Array_23;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 25 :
                    // InternalRosParser.g:6292:3: this_uint64Array_24= ruleuint64Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getUint64ArrayParserRuleCall_24());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64Array_24=ruleuint64Array();

                    state._fsp--;


                    			current = this_uint64Array_24;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 26 :
                    // InternalRosParser.g:6301:3: this_float32Array_25= rulefloat32Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat32ArrayParserRuleCall_25());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32Array_25=rulefloat32Array();

                    state._fsp--;


                    			current = this_float32Array_25;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 27 :
                    // InternalRosParser.g:6310:3: this_float64Array_26= rulefloat64Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getFloat64ArrayParserRuleCall_26());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64Array_26=rulefloat64Array();

                    state._fsp--;


                    			current = this_float64Array_26;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 28 :
                    // InternalRosParser.g:6319:3: this_string0Array_27= rulestring0Array
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getString0ArrayParserRuleCall_27());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0Array_27=rulestring0Array();

                    state._fsp--;


                    			current = this_string0Array_27;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 29 :
                    // InternalRosParser.g:6328:3: this_byteArray_28= rulebyteArray
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getByteArrayParserRuleCall_28());
                    		
                    pushFollow(FOLLOW_2);
                    this_byteArray_28=rulebyteArray();

                    state._fsp--;


                    			current = this_byteArray_28;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 30 :
                    // InternalRosParser.g:6337:3: this_SpecBaseRef_29= ruleSpecBaseRef
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getSpecBaseRefParserRuleCall_29());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecBaseRef_29=ruleSpecBaseRef();

                    state._fsp--;


                    			current = this_SpecBaseRef_29;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 31 :
                    // InternalRosParser.g:6346:3: this_ArraySpecRef_30= ruleArraySpecRef
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getArraySpecRefParserRuleCall_30());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArraySpecRef_30=ruleArraySpecRef();

                    state._fsp--;


                    			current = this_ArraySpecRef_30;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 32 :
                    // InternalRosParser.g:6355:3: this_char_31= rulechar
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getCharParserRuleCall_31());
                    		
                    pushFollow(FOLLOW_2);
                    this_char_31=rulechar();

                    state._fsp--;


                    			current = this_char_31;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 33 :
                    // InternalRosParser.g:6364:3: this_charArray_32= rulecharArray
                    {

                    			newCompositeNode(grammarAccess.getElementTypeAccess().getCharArrayParserRuleCall_32());
                    		
                    pushFollow(FOLLOW_2);
                    this_charArray_32=rulecharArray();

                    state._fsp--;


                    			current = this_charArray_32;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6376:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRosParser.g:6376:45: (iv_rulebool= rulebool EOF )
            // InternalRosParser.g:6377:2: iv_rulebool= rulebool EOF
            {
             newCompositeNode(grammarAccess.getBoolRule()); 
            pushFollow(FOLLOW_1);
            iv_rulebool=rulebool();

            state._fsp--;

             current =iv_rulebool; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6383:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6389:2: ( ( () otherlv_1= Bool ) )
            // InternalRosParser.g:6390:2: ( () otherlv_1= Bool )
            {
            // InternalRosParser.g:6390:2: ( () otherlv_1= Bool )
            // InternalRosParser.g:6391:3: () otherlv_1= Bool
            {
            // InternalRosParser.g:6391:3: ()
            // InternalRosParser.g:6392:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolAccess().getBoolAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Bool,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolAccess().getBoolKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6406:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRosParser.g:6406:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRosParser.g:6407:2: iv_ruleint8= ruleint8 EOF
            {
             newCompositeNode(grammarAccess.getInt8Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint8=ruleint8();

            state._fsp--;

             current =iv_ruleint8; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6413:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6419:2: ( ( () otherlv_1= Int8 ) )
            // InternalRosParser.g:6420:2: ( () otherlv_1= Int8 )
            {
            // InternalRosParser.g:6420:2: ( () otherlv_1= Int8 )
            // InternalRosParser.g:6421:3: () otherlv_1= Int8
            {
            // InternalRosParser.g:6421:3: ()
            // InternalRosParser.g:6422:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt8Access().getInt8Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int8,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt8Access().getInt8Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6436:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRosParser.g:6436:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRosParser.g:6437:2: iv_ruleuint8= ruleuint8 EOF
            {
             newCompositeNode(grammarAccess.getUint8Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint8=ruleuint8();

            state._fsp--;

             current =iv_ruleuint8; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6443:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6449:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRosParser.g:6450:2: ( () otherlv_1= Uint8 )
            {
            // InternalRosParser.g:6450:2: ( () otherlv_1= Uint8 )
            // InternalRosParser.g:6451:3: () otherlv_1= Uint8
            {
            // InternalRosParser.g:6451:3: ()
            // InternalRosParser.g:6452:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint8Access().getUint8Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint8,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint8Access().getUint8Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6466:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRosParser.g:6466:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRosParser.g:6467:2: iv_ruleint16= ruleint16 EOF
            {
             newCompositeNode(grammarAccess.getInt16Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint16=ruleint16();

            state._fsp--;

             current =iv_ruleint16; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6473:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6479:2: ( ( () otherlv_1= Int16 ) )
            // InternalRosParser.g:6480:2: ( () otherlv_1= Int16 )
            {
            // InternalRosParser.g:6480:2: ( () otherlv_1= Int16 )
            // InternalRosParser.g:6481:3: () otherlv_1= Int16
            {
            // InternalRosParser.g:6481:3: ()
            // InternalRosParser.g:6482:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt16Access().getInt16Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int16,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt16Access().getInt16Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6496:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRosParser.g:6496:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRosParser.g:6497:2: iv_ruleuint16= ruleuint16 EOF
            {
             newCompositeNode(grammarAccess.getUint16Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint16=ruleuint16();

            state._fsp--;

             current =iv_ruleuint16; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6503:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6509:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRosParser.g:6510:2: ( () otherlv_1= Uint16 )
            {
            // InternalRosParser.g:6510:2: ( () otherlv_1= Uint16 )
            // InternalRosParser.g:6511:3: () otherlv_1= Uint16
            {
            // InternalRosParser.g:6511:3: ()
            // InternalRosParser.g:6512:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint16Access().getUint16Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint16,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint16Access().getUint16Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6526:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRosParser.g:6526:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRosParser.g:6527:2: iv_ruleint32= ruleint32 EOF
            {
             newCompositeNode(grammarAccess.getInt32Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint32=ruleint32();

            state._fsp--;

             current =iv_ruleint32; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6533:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6539:2: ( ( () otherlv_1= Int32 ) )
            // InternalRosParser.g:6540:2: ( () otherlv_1= Int32 )
            {
            // InternalRosParser.g:6540:2: ( () otherlv_1= Int32 )
            // InternalRosParser.g:6541:3: () otherlv_1= Int32
            {
            // InternalRosParser.g:6541:3: ()
            // InternalRosParser.g:6542:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt32Access().getInt32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int32,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt32Access().getInt32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6556:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRosParser.g:6556:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRosParser.g:6557:2: iv_ruleuint32= ruleuint32 EOF
            {
             newCompositeNode(grammarAccess.getUint32Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint32=ruleuint32();

            state._fsp--;

             current =iv_ruleuint32; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6563:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6569:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRosParser.g:6570:2: ( () otherlv_1= Uint32 )
            {
            // InternalRosParser.g:6570:2: ( () otherlv_1= Uint32 )
            // InternalRosParser.g:6571:3: () otherlv_1= Uint32
            {
            // InternalRosParser.g:6571:3: ()
            // InternalRosParser.g:6572:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint32Access().getUint32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint32,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint32Access().getUint32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6586:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRosParser.g:6586:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRosParser.g:6587:2: iv_ruleint64= ruleint64 EOF
            {
             newCompositeNode(grammarAccess.getInt64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint64=ruleint64();

            state._fsp--;

             current =iv_ruleint64; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6593:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6599:2: ( ( () otherlv_1= Int64 ) )
            // InternalRosParser.g:6600:2: ( () otherlv_1= Int64 )
            {
            // InternalRosParser.g:6600:2: ( () otherlv_1= Int64 )
            // InternalRosParser.g:6601:3: () otherlv_1= Int64
            {
            // InternalRosParser.g:6601:3: ()
            // InternalRosParser.g:6602:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt64Access().getInt64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int64,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt64Access().getInt64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6616:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRosParser.g:6616:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRosParser.g:6617:2: iv_ruleuint64= ruleuint64 EOF
            {
             newCompositeNode(grammarAccess.getUint64Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint64=ruleuint64();

            state._fsp--;

             current =iv_ruleuint64; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6623:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6629:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRosParser.g:6630:2: ( () otherlv_1= Uint64 )
            {
            // InternalRosParser.g:6630:2: ( () otherlv_1= Uint64 )
            // InternalRosParser.g:6631:3: () otherlv_1= Uint64
            {
            // InternalRosParser.g:6631:3: ()
            // InternalRosParser.g:6632:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint64Access().getUint64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint64,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint64Access().getUint64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6646:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRosParser.g:6646:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRosParser.g:6647:2: iv_rulefloat32= rulefloat32 EOF
            {
             newCompositeNode(grammarAccess.getFloat32Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat32=rulefloat32();

            state._fsp--;

             current =iv_rulefloat32; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6653:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6659:2: ( ( () otherlv_1= Float32 ) )
            // InternalRosParser.g:6660:2: ( () otherlv_1= Float32 )
            {
            // InternalRosParser.g:6660:2: ( () otherlv_1= Float32 )
            // InternalRosParser.g:6661:3: () otherlv_1= Float32
            {
            // InternalRosParser.g:6661:3: ()
            // InternalRosParser.g:6662:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat32Access().getFloat32Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float32,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat32Access().getFloat32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6676:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRosParser.g:6676:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRosParser.g:6677:2: iv_rulefloat64= rulefloat64 EOF
            {
             newCompositeNode(grammarAccess.getFloat64Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat64=rulefloat64();

            state._fsp--;

             current =iv_rulefloat64; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6683:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6689:2: ( ( () otherlv_1= Float64 ) )
            // InternalRosParser.g:6690:2: ( () otherlv_1= Float64 )
            {
            // InternalRosParser.g:6690:2: ( () otherlv_1= Float64 )
            // InternalRosParser.g:6691:3: () otherlv_1= Float64
            {
            // InternalRosParser.g:6691:3: ()
            // InternalRosParser.g:6692:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat64Access().getFloat64Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float64,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat64Access().getFloat64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6706:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRosParser.g:6706:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRosParser.g:6707:2: iv_rulestring0= rulestring0 EOF
            {
             newCompositeNode(grammarAccess.getString0Rule()); 
            pushFollow(FOLLOW_1);
            iv_rulestring0=rulestring0();

            state._fsp--;

             current =iv_rulestring0; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6713:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6719:2: ( ( () otherlv_1= String_1 ) )
            // InternalRosParser.g:6720:2: ( () otherlv_1= String_1 )
            {
            // InternalRosParser.g:6720:2: ( () otherlv_1= String_1 )
            // InternalRosParser.g:6721:3: () otherlv_1= String_1
            {
            // InternalRosParser.g:6721:3: ()
            // InternalRosParser.g:6722:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getString0Access().getStringAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String_1,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getString0Access().getStringKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6736:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRosParser.g:6736:45: (iv_rulechar= rulechar EOF )
            // InternalRosParser.g:6737:2: iv_rulechar= rulechar EOF
            {
             newCompositeNode(grammarAccess.getCharRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechar=rulechar();

            state._fsp--;

             current =iv_rulechar; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6743:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6749:2: ( ( () otherlv_1= Char ) )
            // InternalRosParser.g:6750:2: ( () otherlv_1= Char )
            {
            // InternalRosParser.g:6750:2: ( () otherlv_1= Char )
            // InternalRosParser.g:6751:3: () otherlv_1= Char
            {
            // InternalRosParser.g:6751:3: ()
            // InternalRosParser.g:6752:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharAccess().getChar0Action_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Char,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getCharAccess().getCharKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6766:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRosParser.g:6766:45: (iv_rulebyte= rulebyte EOF )
            // InternalRosParser.g:6767:2: iv_rulebyte= rulebyte EOF
            {
             newCompositeNode(grammarAccess.getByteRule()); 
            pushFollow(FOLLOW_1);
            iv_rulebyte=rulebyte();

            state._fsp--;

             current =iv_rulebyte; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6773:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6779:2: ( ( () otherlv_1= Byte ) )
            // InternalRosParser.g:6780:2: ( () otherlv_1= Byte )
            {
            // InternalRosParser.g:6780:2: ( () otherlv_1= Byte )
            // InternalRosParser.g:6781:3: () otherlv_1= Byte
            {
            // InternalRosParser.g:6781:3: ()
            // InternalRosParser.g:6782:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getByteAccess().getByteAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Byte,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getByteAccess().getByteKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6796:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRosParser.g:6796:45: (iv_ruletime= ruletime EOF )
            // InternalRosParser.g:6797:2: iv_ruletime= ruletime EOF
            {
             newCompositeNode(grammarAccess.getTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruletime=ruletime();

            state._fsp--;

             current =iv_ruletime; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6803:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6809:2: ( ( () otherlv_1= Time ) )
            // InternalRosParser.g:6810:2: ( () otherlv_1= Time )
            {
            // InternalRosParser.g:6810:2: ( () otherlv_1= Time )
            // InternalRosParser.g:6811:3: () otherlv_1= Time
            {
            // InternalRosParser.g:6811:3: ()
            // InternalRosParser.g:6812:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimeAccess().getTimeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Time,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTimeKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6826:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRosParser.g:6826:49: (iv_ruleduration= ruleduration EOF )
            // InternalRosParser.g:6827:2: iv_ruleduration= ruleduration EOF
            {
             newCompositeNode(grammarAccess.getDurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleduration=ruleduration();

            state._fsp--;

             current =iv_ruleduration; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6833:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6839:2: ( ( () otherlv_1= Duration ) )
            // InternalRosParser.g:6840:2: ( () otherlv_1= Duration )
            {
            // InternalRosParser.g:6840:2: ( () otherlv_1= Duration )
            // InternalRosParser.g:6841:3: () otherlv_1= Duration
            {
            // InternalRosParser.g:6841:3: ()
            // InternalRosParser.g:6842:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDurationAccess().getDurationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Duration,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getDurationAccess().getDurationKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6856:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRosParser.g:6856:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRosParser.g:6857:2: iv_ruleboolArray= ruleboolArray EOF
            {
             newCompositeNode(grammarAccess.getBoolArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleboolArray=ruleboolArray();

            state._fsp--;

             current =iv_ruleboolArray; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6863:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_2 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6869:2: ( ( () otherlv_1= Bool_2 ) )
            // InternalRosParser.g:6870:2: ( () otherlv_1= Bool_2 )
            {
            // InternalRosParser.g:6870:2: ( () otherlv_1= Bool_2 )
            // InternalRosParser.g:6871:3: () otherlv_1= Bool_2
            {
            // InternalRosParser.g:6871:3: ()
            // InternalRosParser.g:6872:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolArrayAccess().getBoolArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Bool_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getBoolArrayAccess().getBoolKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6886:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRosParser.g:6886:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRosParser.g:6887:2: iv_ruleint8Array= ruleint8Array EOF
            {
             newCompositeNode(grammarAccess.getInt8ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint8Array=ruleint8Array();

            state._fsp--;

             current =iv_ruleint8Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6893:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_2 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6899:2: ( ( () otherlv_1= Int8_2 ) )
            // InternalRosParser.g:6900:2: ( () otherlv_1= Int8_2 )
            {
            // InternalRosParser.g:6900:2: ( () otherlv_1= Int8_2 )
            // InternalRosParser.g:6901:3: () otherlv_1= Int8_2
            {
            // InternalRosParser.g:6901:3: ()
            // InternalRosParser.g:6902:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int8_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt8ArrayAccess().getInt8Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6916:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRosParser.g:6916:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRosParser.g:6917:2: iv_ruleuint8Array= ruleuint8Array EOF
            {
             newCompositeNode(grammarAccess.getUint8ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint8Array=ruleuint8Array();

            state._fsp--;

             current =iv_ruleuint8Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6923:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_2 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6929:2: ( ( () otherlv_1= Uint8_2 ) )
            // InternalRosParser.g:6930:2: ( () otherlv_1= Uint8_2 )
            {
            // InternalRosParser.g:6930:2: ( () otherlv_1= Uint8_2 )
            // InternalRosParser.g:6931:3: () otherlv_1= Uint8_2
            {
            // InternalRosParser.g:6931:3: ()
            // InternalRosParser.g:6932:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint8_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint8ArrayAccess().getUint8Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6946:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRosParser.g:6946:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRosParser.g:6947:2: iv_ruleint16Array= ruleint16Array EOF
            {
             newCompositeNode(grammarAccess.getInt16ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint16Array=ruleint16Array();

            state._fsp--;

             current =iv_ruleint16Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6953:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_2 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6959:2: ( ( () otherlv_1= Int16_2 ) )
            // InternalRosParser.g:6960:2: ( () otherlv_1= Int16_2 )
            {
            // InternalRosParser.g:6960:2: ( () otherlv_1= Int16_2 )
            // InternalRosParser.g:6961:3: () otherlv_1= Int16_2
            {
            // InternalRosParser.g:6961:3: ()
            // InternalRosParser.g:6962:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int16_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt16ArrayAccess().getInt16Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:6976:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRosParser.g:6976:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRosParser.g:6977:2: iv_ruleuint16Array= ruleuint16Array EOF
            {
             newCompositeNode(grammarAccess.getUint16ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint16Array=ruleuint16Array();

            state._fsp--;

             current =iv_ruleuint16Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:6983:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_2 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6989:2: ( ( () otherlv_1= Uint16_2 ) )
            // InternalRosParser.g:6990:2: ( () otherlv_1= Uint16_2 )
            {
            // InternalRosParser.g:6990:2: ( () otherlv_1= Uint16_2 )
            // InternalRosParser.g:6991:3: () otherlv_1= Uint16_2
            {
            // InternalRosParser.g:6991:3: ()
            // InternalRosParser.g:6992:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint16_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint16ArrayAccess().getUint16Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7006:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRosParser.g:7006:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRosParser.g:7007:2: iv_ruleint32Array= ruleint32Array EOF
            {
             newCompositeNode(grammarAccess.getInt32ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint32Array=ruleint32Array();

            state._fsp--;

             current =iv_ruleint32Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7013:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_2 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7019:2: ( ( () otherlv_1= Int32_2 ) )
            // InternalRosParser.g:7020:2: ( () otherlv_1= Int32_2 )
            {
            // InternalRosParser.g:7020:2: ( () otherlv_1= Int32_2 )
            // InternalRosParser.g:7021:3: () otherlv_1= Int32_2
            {
            // InternalRosParser.g:7021:3: ()
            // InternalRosParser.g:7022:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int32_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt32ArrayAccess().getInt32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7036:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRosParser.g:7036:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRosParser.g:7037:2: iv_ruleuint32Array= ruleuint32Array EOF
            {
             newCompositeNode(grammarAccess.getUint32ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint32Array=ruleuint32Array();

            state._fsp--;

             current =iv_ruleuint32Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7043:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_2 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7049:2: ( ( () otherlv_1= Uint32_2 ) )
            // InternalRosParser.g:7050:2: ( () otherlv_1= Uint32_2 )
            {
            // InternalRosParser.g:7050:2: ( () otherlv_1= Uint32_2 )
            // InternalRosParser.g:7051:3: () otherlv_1= Uint32_2
            {
            // InternalRosParser.g:7051:3: ()
            // InternalRosParser.g:7052:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint32_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint32ArrayAccess().getUint32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7066:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRosParser.g:7066:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRosParser.g:7067:2: iv_ruleint64Array= ruleint64Array EOF
            {
             newCompositeNode(grammarAccess.getInt64ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleint64Array=ruleint64Array();

            state._fsp--;

             current =iv_ruleint64Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7073:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_2 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7079:2: ( ( () otherlv_1= Int64_2 ) )
            // InternalRosParser.g:7080:2: ( () otherlv_1= Int64_2 )
            {
            // InternalRosParser.g:7080:2: ( () otherlv_1= Int64_2 )
            // InternalRosParser.g:7081:3: () otherlv_1= Int64_2
            {
            // InternalRosParser.g:7081:3: ()
            // InternalRosParser.g:7082:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int64_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInt64ArrayAccess().getInt64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7096:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRosParser.g:7096:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRosParser.g:7097:2: iv_ruleuint64Array= ruleuint64Array EOF
            {
             newCompositeNode(grammarAccess.getUint64ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleuint64Array=ruleuint64Array();

            state._fsp--;

             current =iv_ruleuint64Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7103:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_2 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7109:2: ( ( () otherlv_1= Uint64_2 ) )
            // InternalRosParser.g:7110:2: ( () otherlv_1= Uint64_2 )
            {
            // InternalRosParser.g:7110:2: ( () otherlv_1= Uint64_2 )
            // InternalRosParser.g:7111:3: () otherlv_1= Uint64_2
            {
            // InternalRosParser.g:7111:3: ()
            // InternalRosParser.g:7112:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint64_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUint64ArrayAccess().getUint64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7126:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRosParser.g:7126:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRosParser.g:7127:2: iv_rulefloat32Array= rulefloat32Array EOF
            {
             newCompositeNode(grammarAccess.getFloat32ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat32Array=rulefloat32Array();

            state._fsp--;

             current =iv_rulefloat32Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7133:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_2 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7139:2: ( ( () otherlv_1= Float32_2 ) )
            // InternalRosParser.g:7140:2: ( () otherlv_1= Float32_2 )
            {
            // InternalRosParser.g:7140:2: ( () otherlv_1= Float32_2 )
            // InternalRosParser.g:7141:3: () otherlv_1= Float32_2
            {
            // InternalRosParser.g:7141:3: ()
            // InternalRosParser.g:7142:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float32_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat32ArrayAccess().getFloat32Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7156:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRosParser.g:7156:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRosParser.g:7157:2: iv_rulefloat64Array= rulefloat64Array EOF
            {
             newCompositeNode(grammarAccess.getFloat64ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulefloat64Array=rulefloat64Array();

            state._fsp--;

             current =iv_rulefloat64Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7163:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_2 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7169:2: ( ( () otherlv_1= Float64_2 ) )
            // InternalRosParser.g:7170:2: ( () otherlv_1= Float64_2 )
            {
            // InternalRosParser.g:7170:2: ( () otherlv_1= Float64_2 )
            // InternalRosParser.g:7171:3: () otherlv_1= Float64_2
            {
            // InternalRosParser.g:7171:3: ()
            // InternalRosParser.g:7172:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float64_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloat64ArrayAccess().getFloat64Keyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7186:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRosParser.g:7186:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRosParser.g:7187:2: iv_rulestring0Array= rulestring0Array EOF
            {
             newCompositeNode(grammarAccess.getString0ArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulestring0Array=rulestring0Array();

            state._fsp--;

             current =iv_rulestring0Array; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7193:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_3 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7199:2: ( ( () otherlv_1= String_3 ) )
            // InternalRosParser.g:7200:2: ( () otherlv_1= String_3 )
            {
            // InternalRosParser.g:7200:2: ( () otherlv_1= String_3 )
            // InternalRosParser.g:7201:3: () otherlv_1= String_3
            {
            // InternalRosParser.g:7201:3: ()
            // InternalRosParser.g:7202:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getString0ArrayAccess().getStringArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String_3,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getString0ArrayAccess().getStringKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7216:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRosParser.g:7216:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRosParser.g:7217:2: iv_rulebyteArray= rulebyteArray EOF
            {
             newCompositeNode(grammarAccess.getByteArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulebyteArray=rulebyteArray();

            state._fsp--;

             current =iv_rulebyteArray; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7223:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_2 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7229:2: ( ( () otherlv_1= Byte_2 ) )
            // InternalRosParser.g:7230:2: ( () otherlv_1= Byte_2 )
            {
            // InternalRosParser.g:7230:2: ( () otherlv_1= Byte_2 )
            // InternalRosParser.g:7231:3: () otherlv_1= Byte_2
            {
            // InternalRosParser.g:7231:3: ()
            // InternalRosParser.g:7232:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getByteArrayAccess().getByteArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Byte_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getByteArrayAccess().getByteKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7246:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRosParser.g:7246:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRosParser.g:7247:2: iv_rulecharArray= rulecharArray EOF
            {
             newCompositeNode(grammarAccess.getCharArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecharArray=rulecharArray();

            state._fsp--;

             current =iv_rulecharArray; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7253:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_2 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7259:2: ( ( () otherlv_1= Char_2 ) )
            // InternalRosParser.g:7260:2: ( () otherlv_1= Char_2 )
            {
            // InternalRosParser.g:7260:2: ( () otherlv_1= Char_2 )
            // InternalRosParser.g:7261:3: () otherlv_1= Char_2
            {
            // InternalRosParser.g:7261:3: ()
            // InternalRosParser.g:7262:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharArrayAccess().getCharArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Char_2,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getCharArrayAccess().getCharKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7276:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRosParser.g:7276:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRosParser.g:7277:2: iv_ruleHeader= ruleHeader EOF
            {
             newCompositeNode(grammarAccess.getHeaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHeader=ruleHeader();

            state._fsp--;

             current =iv_ruleHeader; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7283:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7289:2: ( ( () otherlv_1= Header ) )
            // InternalRosParser.g:7290:2: ( () otherlv_1= Header )
            {
            // InternalRosParser.g:7290:2: ( () otherlv_1= Header )
            // InternalRosParser.g:7291:3: () otherlv_1= Header
            {
            // InternalRosParser.g:7291:3: ()
            // InternalRosParser.g:7292:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getHeaderAccess().getHeaderAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Header,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getHeaderAccess().getHeaderKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7306:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRosParser.g:7306:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRosParser.g:7307:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
            {
             newCompositeNode(grammarAccess.getSpecBaseRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSpecBaseRef=ruleSpecBaseRef();

            state._fsp--;

             current =iv_ruleSpecBaseRef; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7313:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosParser.g:7319:2: ( ( ( ruleEString ) ) )
            // InternalRosParser.g:7320:2: ( ( ruleEString ) )
            {
            // InternalRosParser.g:7320:2: ( ( ruleEString ) )
            // InternalRosParser.g:7321:3: ( ruleEString )
            {
            // InternalRosParser.g:7321:3: ( ruleEString )
            // InternalRosParser.g:7322:4: ruleEString
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getSpecBaseRefRule());
            				}
            			

            				newCompositeNode(grammarAccess.getSpecBaseRefAccess().getReferenceTopicSpecCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7339:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRosParser.g:7339:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRosParser.g:7340:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
            {
             newCompositeNode(grammarAccess.getArraySpecRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArraySpecRef=ruleArraySpecRef();

            state._fsp--;

             current =iv_ruleArraySpecRef; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7346:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7352:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRosParser.g:7353:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRosParser.g:7353:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRosParser.g:7354:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRosParser.g:7354:3: ( ( ruleEString ) )
            // InternalRosParser.g:7355:4: ( ruleEString )
            {
            // InternalRosParser.g:7355:4: ( ruleEString )
            // InternalRosParser.g:7356:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArraySpecRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
            				
            pushFollow(FOLLOW_68);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getArraySpecRefAccess().getLeftSquareBracketRightSquareBracketKeyword_1());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7378:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRosParser.g:7378:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRosParser.g:7379:2: iv_ruleKEYWORD= ruleKEYWORD EOF
            {
             newCompositeNode(grammarAccess.getKEYWORDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKEYWORD=ruleKEYWORD();

            state._fsp--;

             current =iv_ruleKEYWORD.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7385:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:7391:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRosParser.g:7392:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRosParser.g:7392:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt96=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt96=1;
                }
                break;
            case Message:
                {
                alt96=2;
                }
                break;
            case Result:
                {
                alt96=3;
                }
                break;
            case Feedback:
                {
                alt96=4;
                }
                break;
            case Name:
                {
                alt96=5;
                }
                break;
            case Value:
                {
                alt96=6;
                }
                break;
            case Service:
                {
                alt96=7;
                }
                break;
            case Type:
                {
                alt96=8;
                }
                break;
            case Action:
                {
                alt96=9;
                }
                break;
            case Duration:
                {
                alt96=10;
                }
                break;
            case Time:
                {
                alt96=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // InternalRosParser.g:7393:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7399:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:7405:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:7411:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:7417:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:7423:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:7429:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:7435:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:7441:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:7447:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:7453:3: kw= Time
                    {
                    kw=(Token)match(input,Time,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTimeKeyword_10());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleQualifiedRef"
    // InternalRosParser.g:7462:1: entryRuleQualifiedRef returns [String current=null] : iv_ruleQualifiedRef= ruleQualifiedRef EOF ;
    public final String entryRuleQualifiedRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedRef = null;


        try {
            // InternalRosParser.g:7462:52: (iv_ruleQualifiedRef= ruleQualifiedRef EOF )
            // InternalRosParser.g:7463:2: iv_ruleQualifiedRef= ruleQualifiedRef EOF
            {
             newCompositeNode(grammarAccess.getQualifiedRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedRef=ruleQualifiedRef();

            state._fsp--;

             current =iv_ruleQualifiedRef.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7469:1: ruleQualifiedRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) ;
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
            // InternalRosParser.g:7475:2: ( (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) ) )
            // InternalRosParser.g:7476:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            {
            // InternalRosParser.g:7476:2: (this_STRING_0= RULE_STRING | (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* ) )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_STRING) ) {
                alt99=1;
            }
            else if ( (LA99_0==RULE_ID) ) {
                alt99=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // InternalRosParser.g:7477:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getQualifiedRefAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7485:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    {
                    // InternalRosParser.g:7485:3: (this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )* )
                    // InternalRosParser.g:7486:4: this_ID_1= RULE_ID ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_69); 

                    				current.merge(this_ID_1);
                    			

                    				newLeafNode(this_ID_1, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_0());
                    			
                    // InternalRosParser.g:7493:4: ( (kw= FullStop this_ID_3= RULE_ID ) | (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? ) )*
                    loop98:
                    do {
                        int alt98=3;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==FullStop) ) {
                            alt98=1;
                        }
                        else if ( (LA98_0==RULE_DOUBLE) ) {
                            alt98=2;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // InternalRosParser.g:7494:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    {
                    	    // InternalRosParser.g:7494:5: (kw= FullStop this_ID_3= RULE_ID )
                    	    // InternalRosParser.g:7495:6: kw= FullStop this_ID_3= RULE_ID
                    	    {
                    	    kw=(Token)match(input,FullStop,FOLLOW_70); 

                    	    						current.merge(kw);
                    	    						newLeafNode(kw, grammarAccess.getQualifiedRefAccess().getFullStopKeyword_1_1_0_0());
                    	    					
                    	    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_69); 

                    	    						current.merge(this_ID_3);
                    	    					

                    	    						newLeafNode(this_ID_3, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_1_0_1());
                    	    					

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRosParser.g:7509:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    {
                    	    // InternalRosParser.g:7509:5: (this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )? )
                    	    // InternalRosParser.g:7510:6: this_DOUBLE_4= RULE_DOUBLE (this_ID_5= RULE_ID )?
                    	    {
                    	    this_DOUBLE_4=(Token)match(input,RULE_DOUBLE,FOLLOW_71); 

                    	    						current.merge(this_DOUBLE_4);
                    	    					

                    	    						newLeafNode(this_DOUBLE_4, grammarAccess.getQualifiedRefAccess().getDOUBLETerminalRuleCall_1_1_1_0());
                    	    					
                    	    // InternalRosParser.g:7517:6: (this_ID_5= RULE_ID )?
                    	    int alt97=2;
                    	    int LA97_0 = input.LA(1);

                    	    if ( (LA97_0==RULE_ID) ) {
                    	        alt97=1;
                    	    }
                    	    switch (alt97) {
                    	        case 1 :
                    	            // InternalRosParser.g:7518:7: this_ID_5= RULE_ID
                    	            {
                    	            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_69); 

                    	            							current.merge(this_ID_5);
                    	            						

                    	            							newLeafNode(this_ID_5, grammarAccess.getQualifiedRefAccess().getIDTerminalRuleCall_1_1_1_1());
                    	            						

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7533:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRosParser.g:7533:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRosParser.g:7534:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
            {
             newCompositeNode(grammarAccess.getExtensionBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionBlock=ruleExtensionBlock();

            state._fsp--;

             current =iv_ruleExtensionBlock; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7540:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
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
            // InternalRosParser.g:7546:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRosParser.g:7547:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRosParser.g:7547:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRosParser.g:7548:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRosParser.g:7548:3: ()
            // InternalRosParser.g:7549:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_70); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
            		
            // InternalRosParser.g:7559:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRosParser.g:7560:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRosParser.g:7560:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRosParser.g:7561:5: lv_name_2_0= ruleExtensionBlockName
            {

            					newCompositeNode(grammarAccess.getExtensionBlockAccess().getNameExtensionBlockNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleExtensionBlockName();

            state._fsp--;


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

            otherlv_3=(Token)match(input,Colon,FOLLOW_72); 

            			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
            		
            // InternalRosParser.g:7582:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt104=3;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==RULE_BEGIN) ) {
                alt104=1;
            }
            else if ( (LA104_0==LeftCurlyBracket) ) {
                alt104=2;
            }
            switch (alt104) {
                case 1 :
                    // InternalRosParser.g:7583:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRosParser.g:7583:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRosParser.g:7584:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_73); 

                    					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                    				
                    // InternalRosParser.g:7588:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt100=0;
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( ((LA100_0>=Serviceclients && LA100_0<=Dependencies)||(LA100_0>=FromGitRepo && LA100_0<=Parameter)||(LA100_0>=Multiple && LA100_0<=Feedback)||LA100_0==Plugins||(LA100_0>=Boolean && LA100_0<=Format)||(LA100_0>=Library && LA100_0<=Message)||LA100_0==Service||(LA100_0>=Base64 && LA100_0<=Action)||(LA100_0>=Result && LA100_0<=Uint64)||(LA100_0>=Value_1 && LA100_0<=Base)||(LA100_0>=Class && LA100_0<=Int64)||(LA100_0>=Msgs && LA100_0<=Node_1)||LA100_0==Srvs||(LA100_0>=Type_1 && LA100_0<=List)||(LA100_0>=Bool && LA100_0<=Node)||(LA100_0>=Time && LA100_0<=Ns)||(LA100_0>=RULE_ID && LA100_0<=RULE_STRING)) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // InternalRosParser.g:7589:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosParser.g:7589:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRosParser.g:7590:7: lv_entries_5_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_74);
                    	    lv_entries_5_0=ruleExtensionEntry();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    if ( cnt100 >= 1 ) break loop100;
                                EarlyExitException eee =
                                    new EarlyExitException(100, input);
                                throw eee;
                        }
                        cnt100++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7613:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRosParser.g:7613:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRosParser.g:7614:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_75); 

                    					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                    				
                    // InternalRosParser.g:7618:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt103=2;
                    int LA103_0 = input.LA(1);

                    if ( ((LA103_0>=Serviceclients && LA103_0<=Dependencies)||(LA103_0>=FromGitRepo && LA103_0<=Parameter)||(LA103_0>=Multiple && LA103_0<=Feedback)||LA103_0==Plugins||(LA103_0>=Boolean && LA103_0<=Format)||(LA103_0>=Library && LA103_0<=Message)||LA103_0==Service||(LA103_0>=Base64 && LA103_0<=Action)||(LA103_0>=Result && LA103_0<=Uint64)||(LA103_0>=Value_1 && LA103_0<=Base)||(LA103_0>=Class && LA103_0<=Int64)||(LA103_0>=Msgs && LA103_0<=Node_1)||LA103_0==Srvs||(LA103_0>=Type_1 && LA103_0<=List)||(LA103_0>=Bool && LA103_0<=Node)||(LA103_0>=Time && LA103_0<=Ns)||(LA103_0>=RULE_ID && LA103_0<=RULE_STRING)) ) {
                        alt103=1;
                    }
                    switch (alt103) {
                        case 1 :
                            // InternalRosParser.g:7619:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRosParser.g:7619:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRosParser.g:7620:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRosParser.g:7620:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRosParser.g:7621:8: lv_entries_8_0= ruleExtensionEntry
                            {

                            								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_76);
                            lv_entries_8_0=ruleExtensionEntry();

                            state._fsp--;


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

                            // InternalRosParser.g:7638:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop102:
                            do {
                                int alt102=2;
                                int LA102_0 = input.LA(1);

                                if ( ((LA102_0>=Serviceclients && LA102_0<=Dependencies)||(LA102_0>=FromGitRepo && LA102_0<=Parameter)||(LA102_0>=Multiple && LA102_0<=Feedback)||LA102_0==Plugins||(LA102_0>=Boolean && LA102_0<=Format)||(LA102_0>=Library && LA102_0<=Message)||LA102_0==Service||(LA102_0>=Base64 && LA102_0<=Action)||(LA102_0>=Result && LA102_0<=Uint64)||(LA102_0>=Value_1 && LA102_0<=Base)||(LA102_0>=Class && LA102_0<=Int64)||(LA102_0>=Msgs && LA102_0<=Node_1)||LA102_0==Srvs||(LA102_0>=Type_1 && LA102_0<=List)||(LA102_0>=Bool && LA102_0<=Node)||(LA102_0>=Time && LA102_0<=Ns)||LA102_0==Comma||(LA102_0>=RULE_ID && LA102_0<=RULE_STRING)) ) {
                                    alt102=1;
                                }


                                switch (alt102) {
                            	case 1 :
                            	    // InternalRosParser.g:7639:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRosParser.g:7639:7: (otherlv_9= Comma )?
                            	    int alt101=2;
                            	    int LA101_0 = input.LA(1);

                            	    if ( (LA101_0==Comma) ) {
                            	        alt101=1;
                            	    }
                            	    switch (alt101) {
                            	        case 1 :
                            	            // InternalRosParser.g:7640:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_73); 

                            	            								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalRosParser.g:7645:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRosParser.g:7646:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRosParser.g:7646:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRosParser.g:7647:9: lv_entries_10_0= ruleExtensionEntry
                            	    {

                            	    									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_76);
                            	    lv_entries_10_0=ruleExtensionEntry();

                            	    state._fsp--;


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
                            	    break;

                            	default :
                            	    break loop102;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

                    					newLeafNode(otherlv_11, grammarAccess.getExtensionBlockAccess().getRightCurlyBracketKeyword_4_1_2());
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7676:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRosParser.g:7676:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRosParser.g:7677:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
            {
             newCompositeNode(grammarAccess.getExtensionBlockNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionBlockName=ruleExtensionBlockName();

            state._fsp--;

             current =iv_ruleExtensionBlockName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7683:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRosParser.g:7689:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRosParser.g:7690:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRosParser.g:7690:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRosParser.g:7691:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_77); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRosParser.g:7698:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==FullStop) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // InternalRosParser.g:7699:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_70); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_77); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7716:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRosParser.g:7716:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRosParser.g:7717:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
            {
             newCompositeNode(grammarAccess.getExtensionEntryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionEntry=ruleExtensionEntry();

            state._fsp--;

             current =iv_ruleExtensionEntry; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7723:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        AntlrDatatypeRuleToken lv_key_4_0 = null;

        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:7729:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) ) )
            // InternalRosParser.g:7730:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            {
            // InternalRosParser.g:7730:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) ) )
            // InternalRosParser.g:7731:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) ) ( (lv_value_5_0= ruleExtensionValue ) )
            {
            // InternalRosParser.g:7731:3: ()
            // InternalRosParser.g:7732:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:7738:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) | ( (lv_key_4_0= ruleAddedKeywordName ) ) )
            int alt106=3;
            switch ( input.LA(1) ) {
            case Duration:
            case Feedback:
            case Boolean:
            case Integer:
            case Float32:
            case Float64:
            case Library:
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
            case Class:
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
                alt106=1;
                }
                break;
            case Serviceclients:
            case Serviceservers:
            case Actionclients:
            case Actionservers:
            case Dependencies:
            case FromGitRepo:
            case Subscribers:
            case Parameters:
            case Publishers:
            case Actions:
            case Default:
            case Value_1:
            case Msgs:
            case Node_1:
            case Srvs:
            case Type_1:
            case Ns:
                {
                alt106=2;
                }
                break;
            case Pluginslots:
            case Implements:
            case Parameter:
            case Multiple:
            case Plugins:
            case Format:
            case Base:
                {
                alt106=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // InternalRosParser.g:7739:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:7739:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRosParser.g:7740:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:7740:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRosParser.g:7741:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRosParser.g:7741:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRosParser.g:7742:7: lv_key_1_0= ruleExtensionKey
                    {

                    							newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionKeyParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_key_1_0=ruleExtensionKey();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
                    							}
                    							set(
                    								current,
                    								"key",
                    								lv_key_1_0,
                    								"de.fraunhofer.ipa.ros.Ros.ExtensionKey");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,Colon,FOLLOW_73); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7765:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRosParser.g:7765:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRosParser.g:7766:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRosParser.g:7766:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRosParser.g:7767:6: lv_key_3_0= ruleExtensionColonKey
                    {

                    						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_73);
                    lv_key_3_0=ruleExtensionColonKey();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
                    						}
                    						set(
                    							current,
                    							"key",
                    							lv_key_3_0,
                    							"de.fraunhofer.ipa.ros.Ros.ExtensionColonKey");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRosParser.g:7785:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    {
                    // InternalRosParser.g:7785:4: ( (lv_key_4_0= ruleAddedKeywordName ) )
                    // InternalRosParser.g:7786:5: (lv_key_4_0= ruleAddedKeywordName )
                    {
                    // InternalRosParser.g:7786:5: (lv_key_4_0= ruleAddedKeywordName )
                    // InternalRosParser.g:7787:6: lv_key_4_0= ruleAddedKeywordName
                    {

                    						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyAddedKeywordNameParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_73);
                    lv_key_4_0=ruleAddedKeywordName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtensionEntryRule());
                    						}
                    						set(
                    							current,
                    							"key",
                    							lv_key_4_0,
                    							"de.fraunhofer.ipa.ros.Ros.AddedKeywordName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRosParser.g:7805:3: ( (lv_value_5_0= ruleExtensionValue ) )
            // InternalRosParser.g:7806:4: (lv_value_5_0= ruleExtensionValue )
            {
            // InternalRosParser.g:7806:4: (lv_value_5_0= ruleExtensionValue )
            // InternalRosParser.g:7807:5: lv_value_5_0= ruleExtensionValue
            {

            					newCompositeNode(grammarAccess.getExtensionEntryAccess().getValueExtensionValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_5_0=ruleExtensionValue();

            state._fsp--;


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


            	leaveRule();

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


    // $ANTLR start "entryRuleExtensionValue"
    // InternalRosParser.g:7828:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRosParser.g:7828:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRosParser.g:7829:2: iv_ruleExtensionValue= ruleExtensionValue EOF
            {
             newCompositeNode(grammarAccess.getExtensionValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionValue=ruleExtensionValue();

            state._fsp--;

             current =iv_ruleExtensionValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7835:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRosParser.g:7841:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRosParser.g:7842:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRosParser.g:7842:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt107=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracketRightSquareBracket:
            case LeftSquareBracket:
                {
                alt107=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt107=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt107=3;
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
                alt107=4;
                }
                break;
            case Duration:
            case Feedback:
            case Boolean:
            case Integer:
            case Float32:
            case Float64:
            case Library:
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
            case Class:
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
                alt107=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // InternalRosParser.g:7843:3: this_ExtensionListValue_0= ruleExtensionListValue
                    {

                    			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionListValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExtensionListValue_0=ruleExtensionListValue();

                    state._fsp--;


                    			current = this_ExtensionListValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7852:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
                    {

                    			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionBraceMapValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExtensionBraceMapValue_1=ruleExtensionBraceMapValue();

                    state._fsp--;


                    			current = this_ExtensionBraceMapValue_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:7861:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
                    {

                    			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionIndentedMapValueParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExtensionIndentedMapValue_2=ruleExtensionIndentedMapValue();

                    state._fsp--;


                    			current = this_ExtensionIndentedMapValue_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:7870:3: this_ExtensionRefValue_3= ruleExtensionRefValue
                    {

                    			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionRefValueParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExtensionRefValue_3=ruleExtensionRefValue();

                    state._fsp--;


                    			current = this_ExtensionRefValue_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:7879:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
                    {

                    			newCompositeNode(grammarAccess.getExtensionValueAccess().getExtensionScalarValueParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExtensionScalarValue_4=ruleExtensionScalarValue();

                    state._fsp--;


                    			current = this_ExtensionScalarValue_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7891:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRosParser.g:7891:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRosParser.g:7892:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
            {
             newCompositeNode(grammarAccess.getExtensionListValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionListValue=ruleExtensionListValue();

            state._fsp--;

             current =iv_ruleExtensionListValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7898:1: ruleExtensionListValue returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) ) ;
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
            // InternalRosParser.g:7904:2: ( ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) ) )
            // InternalRosParser.g:7905:2: ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) )
            {
            // InternalRosParser.g:7905:2: ( () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) ) )
            // InternalRosParser.g:7906:3: () (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) )
            {
            // InternalRosParser.g:7906:3: ()
            // InternalRosParser.g:7907:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:7913:3: (otherlv_1= LeftSquareBracketRightSquareBracket | (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket ) )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==LeftSquareBracketRightSquareBracket) ) {
                alt111=1;
            }
            else if ( (LA111_0==LeftSquareBracket) ) {
                alt111=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // InternalRosParser.g:7914:4: otherlv_1= LeftSquareBracketRightSquareBracket
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracketRightSquareBracket,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketRightSquareBracketKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7919:4: (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket )
                    {
                    // InternalRosParser.g:7919:4: (otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket )
                    // InternalRosParser.g:7920:5: otherlv_2= LeftSquareBracket ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )? otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_78); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1_1_0());
                    				
                    // InternalRosParser.g:7924:5: ( ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )* )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( ((LA110_0>=Duration && LA110_0<=Feedback)||(LA110_0>=Boolean && LA110_0<=Float64)||(LA110_0>=Library && LA110_0<=Param)||LA110_0==Service||(LA110_0>=Base64 && LA110_0<=Action)||(LA110_0>=Result && LA110_0<=Uint64)||LA110_0==Array||(LA110_0>=Class && LA110_0<=Int64)||LA110_0==Pub||LA110_0==Sub||(LA110_0>=Uint8 && LA110_0<=Any)||LA110_0==LeftSquareBracketRightSquareBracket||LA110_0==LeftSquareBracket||LA110_0==LeftCurlyBracket||(LA110_0>=RULE_BOOLEAN && LA110_0<=RULE_DOUBLE)||(LA110_0>=RULE_ID && LA110_0<=RULE_INT)||LA110_0==RULE_BEGIN) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // InternalRosParser.g:7925:6: ( (lv_items_3_0= ruleExtensionValue ) ) ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )*
                            {
                            // InternalRosParser.g:7925:6: ( (lv_items_3_0= ruleExtensionValue ) )
                            // InternalRosParser.g:7926:7: (lv_items_3_0= ruleExtensionValue )
                            {
                            // InternalRosParser.g:7926:7: (lv_items_3_0= ruleExtensionValue )
                            // InternalRosParser.g:7927:8: lv_items_3_0= ruleExtensionValue
                            {

                            								newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_0_0());
                            							
                            pushFollow(FOLLOW_79);
                            lv_items_3_0=ruleExtensionValue();

                            state._fsp--;


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

                            // InternalRosParser.g:7944:6: ( (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) ) )*
                            loop109:
                            do {
                                int alt109=2;
                                int LA109_0 = input.LA(1);

                                if ( ((LA109_0>=Duration && LA109_0<=Feedback)||(LA109_0>=Boolean && LA109_0<=Float64)||(LA109_0>=Library && LA109_0<=Param)||LA109_0==Service||(LA109_0>=Base64 && LA109_0<=Action)||(LA109_0>=Result && LA109_0<=Uint64)||LA109_0==Array||(LA109_0>=Class && LA109_0<=Int64)||LA109_0==Pub||LA109_0==Sub||(LA109_0>=Uint8 && LA109_0<=Any)||(LA109_0>=LeftSquareBracketRightSquareBracket && LA109_0<=Comma)||LA109_0==LeftSquareBracket||LA109_0==LeftCurlyBracket||(LA109_0>=RULE_BOOLEAN && LA109_0<=RULE_DOUBLE)||(LA109_0>=RULE_ID && LA109_0<=RULE_INT)||LA109_0==RULE_BEGIN) ) {
                                    alt109=1;
                                }


                                switch (alt109) {
                            	case 1 :
                            	    // InternalRosParser.g:7945:7: (otherlv_4= Comma )? ( (lv_items_5_0= ruleExtensionValue ) )
                            	    {
                            	    // InternalRosParser.g:7945:7: (otherlv_4= Comma )?
                            	    int alt108=2;
                            	    int LA108_0 = input.LA(1);

                            	    if ( (LA108_0==Comma) ) {
                            	        alt108=1;
                            	    }
                            	    switch (alt108) {
                            	        case 1 :
                            	            // InternalRosParser.g:7946:8: otherlv_4= Comma
                            	            {
                            	            otherlv_4=(Token)match(input,Comma,FOLLOW_73); 

                            	            								newLeafNode(otherlv_4, grammarAccess.getExtensionListValueAccess().getCommaKeyword_1_1_1_1_0());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalRosParser.g:7951:7: ( (lv_items_5_0= ruleExtensionValue ) )
                            	    // InternalRosParser.g:7952:8: (lv_items_5_0= ruleExtensionValue )
                            	    {
                            	    // InternalRosParser.g:7952:8: (lv_items_5_0= ruleExtensionValue )
                            	    // InternalRosParser.g:7953:9: lv_items_5_0= ruleExtensionValue
                            	    {

                            	    									newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_1_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_79);
                            	    lv_items_5_0=ruleExtensionValue();

                            	    state._fsp--;


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
                            	    break;

                            	default :
                            	    break loop109;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                    					newLeafNode(otherlv_6, grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_1_1_2());
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:7982:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRosParser.g:7982:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRosParser.g:7983:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
            {
             newCompositeNode(grammarAccess.getExtensionBraceMapValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionBraceMapValue=ruleExtensionBraceMapValue();

            state._fsp--;

             current =iv_ruleExtensionBraceMapValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:7989:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:7995:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRosParser.g:7996:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRosParser.g:7996:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRosParser.g:7997:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRosParser.g:7997:3: ()
            // InternalRosParser.g:7998:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_75); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRosParser.g:8008:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( ((LA114_0>=Serviceclients && LA114_0<=Dependencies)||(LA114_0>=FromGitRepo && LA114_0<=Parameter)||(LA114_0>=Multiple && LA114_0<=Feedback)||LA114_0==Plugins||(LA114_0>=Boolean && LA114_0<=Format)||(LA114_0>=Library && LA114_0<=Message)||LA114_0==Service||(LA114_0>=Base64 && LA114_0<=Action)||(LA114_0>=Result && LA114_0<=Uint64)||(LA114_0>=Value_1 && LA114_0<=Base)||(LA114_0>=Class && LA114_0<=Int64)||(LA114_0>=Msgs && LA114_0<=Node_1)||LA114_0==Srvs||(LA114_0>=Type_1 && LA114_0<=List)||(LA114_0>=Bool && LA114_0<=Node)||(LA114_0>=Time && LA114_0<=Ns)||(LA114_0>=RULE_ID && LA114_0<=RULE_STRING)) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalRosParser.g:8009:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRosParser.g:8009:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRosParser.g:8010:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRosParser.g:8010:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRosParser.g:8011:6: lv_entries_2_0= ruleExtensionEntry
                    {

                    						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_76);
                    lv_entries_2_0=ruleExtensionEntry();

                    state._fsp--;


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

                    // InternalRosParser.g:8028:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( ((LA113_0>=Serviceclients && LA113_0<=Dependencies)||(LA113_0>=FromGitRepo && LA113_0<=Parameter)||(LA113_0>=Multiple && LA113_0<=Feedback)||LA113_0==Plugins||(LA113_0>=Boolean && LA113_0<=Format)||(LA113_0>=Library && LA113_0<=Message)||LA113_0==Service||(LA113_0>=Base64 && LA113_0<=Action)||(LA113_0>=Result && LA113_0<=Uint64)||(LA113_0>=Value_1 && LA113_0<=Base)||(LA113_0>=Class && LA113_0<=Int64)||(LA113_0>=Msgs && LA113_0<=Node_1)||LA113_0==Srvs||(LA113_0>=Type_1 && LA113_0<=List)||(LA113_0>=Bool && LA113_0<=Node)||(LA113_0>=Time && LA113_0<=Ns)||LA113_0==Comma||(LA113_0>=RULE_ID && LA113_0<=RULE_STRING)) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // InternalRosParser.g:8029:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRosParser.g:8029:5: (otherlv_3= Comma )?
                    	    int alt112=2;
                    	    int LA112_0 = input.LA(1);

                    	    if ( (LA112_0==Comma) ) {
                    	        alt112=1;
                    	    }
                    	    switch (alt112) {
                    	        case 1 :
                    	            // InternalRosParser.g:8030:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_73); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosParser.g:8035:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRosParser.g:8036:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosParser.g:8036:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRosParser.g:8037:7: lv_entries_4_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_76);
                    	    lv_entries_4_0=ruleExtensionEntry();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop113;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getExtensionBraceMapValueAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:8064:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRosParser.g:8064:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRosParser.g:8065:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
            {
             newCompositeNode(grammarAccess.getExtensionIndentedMapValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionIndentedMapValue=ruleExtensionIndentedMapValue();

            state._fsp--;

             current =iv_ruleExtensionIndentedMapValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:8071:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:8077:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRosParser.g:8078:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRosParser.g:8078:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRosParser.g:8079:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRosParser.g:8079:3: ()
            // InternalRosParser.g:8080:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_73); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalRosParser.g:8090:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt115=0;
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( ((LA115_0>=Serviceclients && LA115_0<=Dependencies)||(LA115_0>=FromGitRepo && LA115_0<=Parameter)||(LA115_0>=Multiple && LA115_0<=Feedback)||LA115_0==Plugins||(LA115_0>=Boolean && LA115_0<=Format)||(LA115_0>=Library && LA115_0<=Message)||LA115_0==Service||(LA115_0>=Base64 && LA115_0<=Action)||(LA115_0>=Result && LA115_0<=Uint64)||(LA115_0>=Value_1 && LA115_0<=Base)||(LA115_0>=Class && LA115_0<=Int64)||(LA115_0>=Msgs && LA115_0<=Node_1)||LA115_0==Srvs||(LA115_0>=Type_1 && LA115_0<=List)||(LA115_0>=Bool && LA115_0<=Node)||(LA115_0>=Time && LA115_0<=Ns)||(LA115_0>=RULE_ID && LA115_0<=RULE_STRING)) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // InternalRosParser.g:8091:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRosParser.g:8091:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRosParser.g:8092:5: lv_entries_2_0= ruleExtensionEntry
            	    {

            	    					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_74);
            	    lv_entries_2_0=ruleExtensionEntry();

            	    state._fsp--;


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
            	    break;

            	default :
            	    if ( cnt115 >= 1 ) break loop115;
                        EarlyExitException eee =
                            new EarlyExitException(115, input);
                        throw eee;
                }
                cnt115++;
            } while (true);

            this_END_3=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_3, grammarAccess.getExtensionIndentedMapValueAccess().getENDTerminalRuleCall_3());
            		

            }


            }


            	leaveRule();

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
    // InternalRosParser.g:8117:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRosParser.g:8117:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRosParser.g:8118:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
            {
             newCompositeNode(grammarAccess.getExtensionRefValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionRefValue=ruleExtensionRefValue();

            state._fsp--;

             current =iv_ruleExtensionRefValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:8124:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
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
            // InternalRosParser.g:8130:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRosParser.g:8131:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRosParser.g:8131:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRosParser.g:8132:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRosParser.g:8132:3: ()
            // InternalRosParser.g:8133:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:8139:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRosParser.g:8140:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRosParser.g:8140:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRosParser.g:8141:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRosParser.g:8141:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt116=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt116=1;
                }
                break;
            case Sub:
                {
                alt116=2;
                }
                break;
            case Ss:
                {
                alt116=3;
                }
                break;
            case Sc:
                {
                alt116=4;
                }
                break;
            case As:
                {
                alt116=5;
                }
                break;
            case Ac:
                {
                alt116=6;
                }
                break;
            case Param:
                {
                alt116=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // InternalRosParser.g:8142:6: lv_refKind_1_1= Pub
                    {
                    lv_refKind_1_1=(Token)match(input,Pub,FOLLOW_7); 

                    						newLeafNode(lv_refKind_1_1, grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:8153:6: lv_refKind_1_2= Sub
                    {
                    lv_refKind_1_2=(Token)match(input,Sub,FOLLOW_7); 

                    						newLeafNode(lv_refKind_1_2, grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:8164:6: lv_refKind_1_3= Ss
                    {
                    lv_refKind_1_3=(Token)match(input,Ss,FOLLOW_7); 

                    						newLeafNode(lv_refKind_1_3, grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:8175:6: lv_refKind_1_4= Sc
                    {
                    lv_refKind_1_4=(Token)match(input,Sc,FOLLOW_7); 

                    						newLeafNode(lv_refKind_1_4, grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:8186:6: lv_refKind_1_5= As
                    {
                    lv_refKind_1_5=(Token)match(input,As,FOLLOW_7); 

                    						newLeafNode(lv_refKind_1_5, grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:8197:6: lv_refKind_1_6= Ac
                    {
                    lv_refKind_1_6=(Token)match(input,Ac,FOLLOW_7); 

                    						newLeafNode(lv_refKind_1_6, grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_6, null);
                    					

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:8208:6: lv_refKind_1_7= Param
                    {
                    lv_refKind_1_7=(Token)match(input,Param,FOLLOW_7); 

                    						newLeafNode(lv_refKind_1_7, grammarAccess.getExtensionRefValueAccess().getRefKindParamKeyword_1_0_6());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_7, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalRosParser.g:8221:3: ( ( ruleEString ) )
            // InternalRosParser.g:8222:4: ( ruleEString )
            {
            // InternalRosParser.g:8222:4: ( ruleEString )
            // InternalRosParser.g:8223:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtensionRefValueRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExtensionRefValueAccess().getTargetEObjectCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

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
    // InternalRosParser.g:8241:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRosParser.g:8241:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRosParser.g:8242:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
            {
             newCompositeNode(grammarAccess.getExtensionScalarValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionScalarValue=ruleExtensionScalarValue();

            state._fsp--;

             current =iv_ruleExtensionScalarValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:8248:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:8254:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRosParser.g:8255:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRosParser.g:8255:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRosParser.g:8256:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRosParser.g:8256:3: ()
            // InternalRosParser.g:8257:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:8263:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRosParser.g:8264:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRosParser.g:8264:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRosParser.g:8265:5: lv_value_1_0= ruleExtensionScalarLiteral
            {

            					newCompositeNode(grammarAccess.getExtensionScalarValueAccess().getValueExtensionScalarLiteralParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleExtensionScalarLiteral();

            state._fsp--;


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


            	leaveRule();

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
    // InternalRosParser.g:8286:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRosParser.g:8286:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRosParser.g:8287:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
            {
             newCompositeNode(grammarAccess.getExtensionScalarLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtensionScalarLiteral=ruleExtensionScalarLiteral();

            state._fsp--;

             current =iv_ruleExtensionScalarLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalRosParser.g:8293:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRosParser.g:8299:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRosParser.g:8300:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRosParser.g:8300:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt117=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt117=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt117=2;
                }
                break;
            case RULE_DECINT:
                {
                alt117=3;
                }
                break;
            case RULE_INT:
                {
                alt117=4;
                }
                break;
            case Duration:
            case Feedback:
            case Boolean:
            case Integer:
            case Float32:
            case Float64:
            case Library:
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
            case Class:
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
                alt117=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }

            switch (alt117) {
                case 1 :
                    // InternalRosParser.g:8301:3: this_BOOLEAN_0= RULE_BOOLEAN
                    {
                    this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    			current.merge(this_BOOLEAN_0);
                    		

                    			newLeafNode(this_BOOLEAN_0, grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:8309:3: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_1);
                    		

                    			newLeafNode(this_DOUBLE_1, grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:8317:3: this_DECINT_2= RULE_DECINT
                    {
                    this_DECINT_2=(Token)match(input,RULE_DECINT,FOLLOW_2); 

                    			current.merge(this_DECINT_2);
                    		

                    			newLeafNode(this_DECINT_2, grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:8325:3: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_3);
                    		

                    			newLeafNode(this_INT_3, grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:8333:3: this_ExtensionKey_4= ruleExtensionKey
                    {

                    			newCompositeNode(grammarAccess.getExtensionScalarLiteralAccess().getExtensionKeyParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExtensionKey_4=ruleExtensionKey();

                    state._fsp--;


                    			current.merge(this_ExtensionKey_4);
                    		

                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

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


    // $ANTLR start "rulePluginSlotValueFormat"
    // InternalRosParser.g:8347:1: rulePluginSlotValueFormat returns [Enumerator current=null] : ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) ;
    public final Enumerator rulePluginSlotValueFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:8353:2: ( ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) )
            // InternalRosParser.g:8354:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            {
            // InternalRosParser.g:8354:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==Class) ) {
                alt118=1;
            }
            else if ( (LA118_0==Library) ) {
                alt118=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // InternalRosParser.g:8355:3: (enumLiteral_0= Class )
                    {
                    // InternalRosParser.g:8355:3: (enumLiteral_0= Class )
                    // InternalRosParser.g:8356:4: enumLiteral_0= Class
                    {
                    enumLiteral_0=(Token)match(input,Class,FOLLOW_2); 

                    				current = grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:8363:3: (enumLiteral_1= Library )
                    {
                    // InternalRosParser.g:8363:3: (enumLiteral_1= Library )
                    // InternalRosParser.g:8364:4: enumLiteral_1= Library
                    {
                    enumLiteral_1=(Token)match(input,Library,FOLLOW_2); 

                    				current = grammarAccess.getPluginSlotValueFormatAccess().getLIBRARYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPluginSlotValueFormatAccess().getLIBRARYEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePluginSlotValueFormat"

    // Delegated rules


    protected DFA75 dfa75 = new DFA75(this);
    protected DFA95 dfa95 = new DFA95(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\12\4\13\10\uffff";
    static final String dfa_3s = "\5\17\4\uffff\1\55\3\uffff";
    static final String dfa_4s = "\5\u0088\4\uffff\1\u0087\3\uffff";
    static final String dfa_5s = "\5\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\12\1\uffff\1\12\2\uffff\1\12\3\uffff\1\12\6\uffff\1\12\11\uffff\1\12\3\uffff\1\4\36\uffff\1\12\3\uffff\1\3\37\uffff\1\12\3\uffff\1\11\1\12\3\uffff\1\5\1\10\1\6\1\7\6\uffff\1\2\1\1\3\uffff\1\12",
            "\1\13\1\uffff\1\13\2\uffff\1\13\3\uffff\1\13\6\uffff\1\13\11\uffff\1\13\3\uffff\1\13\36\uffff\1\13\3\uffff\1\13\37\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\1\uffff\1\13\2\uffff\1\13\3\uffff\1\13\6\uffff\1\13\11\uffff\1\13\3\uffff\1\13\36\uffff\1\13\3\uffff\1\13\37\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\1\uffff\1\13\2\uffff\1\13\3\uffff\1\13\6\uffff\1\13\11\uffff\1\13\3\uffff\1\13\36\uffff\1\13\3\uffff\1\13\37\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\1\uffff\1\13\2\uffff\1\13\3\uffff\1\13\6\uffff\1\13\11\uffff\1\13\3\uffff\1\13\36\uffff\1\13\3\uffff\1\13\37\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "",
            "",
            "",
            "",
            "\1\14\42\uffff\1\14\37\uffff\1\14\3\uffff\2\14\3\uffff\4\14\6\uffff\2\14\2\uffff\1\12",
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

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3847:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_8s = "\46\uffff";
    static final String dfa_9s = "\36\uffff\4\45\4\uffff";
    static final String dfa_10s = "\1\26\35\uffff\4\33\4\uffff";
    static final String dfa_11s = "\1\u0084\35\uffff\4\u0086\4\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\4\uffff\1\40\1\41\1\37\1\36";
    static final String dfa_13s = "\46\uffff}>";
    static final String[] dfa_14s = {
            "\1\32\1\33\3\uffff\1\17\5\uffff\1\34\1\25\1\27\1\31\2\uffff\1\12\1\13\1\uffff\1\24\1\26\1\30\1\41\10\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\43\3\uffff\1\22\1\uffff\1\14\1\5\1\7\1\11\7\uffff\1\40\1\4\1\6\1\10\7\uffff\1\3\5\uffff\1\1\1\15\1\42\1\uffff\1\2\4\uffff\1\16\30\uffff\1\37\1\36",
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
            "\2\45\20\uffff\2\45\2\uffff\1\45\12\uffff\1\45\7\uffff\1\45\13\uffff\1\45\13\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\3\uffff\1\44\4\uffff\1\45\16\uffff\2\45\1\uffff\1\45",
            "\2\45\20\uffff\2\45\2\uffff\1\45\12\uffff\1\45\7\uffff\1\45\13\uffff\1\45\13\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\3\uffff\1\44\4\uffff\1\45\16\uffff\2\45\1\uffff\1\45",
            "\2\45\20\uffff\2\45\2\uffff\1\45\12\uffff\1\45\7\uffff\1\45\13\uffff\1\45\13\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\3\uffff\1\44\4\uffff\1\45\16\uffff\2\45\1\uffff\1\45",
            "\2\45\20\uffff\2\45\2\uffff\1\45\12\uffff\1\45\7\uffff\1\45\13\uffff\1\45\13\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\3\uffff\1\44\4\uffff\1\45\16\uffff\2\45\1\uffff\1\45",
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

    class DFA95 extends DFA {

        public DFA95(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 95;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "6075:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000220081128002L,0x0000008000011000L,0x0000000000000408L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002005000L,0x0000000001200000L,0x0000000000000100L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000200000000000L,0x0000000000010000L,0x0000000000000018L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002001000L,0x0000000001200000L,0x0000000000000100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000200000000010L,0x0000000000010000L,0x0000000000000018L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0021000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002000000L,0x0000000001200000L,0x0000000000000100L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0600200000000000L,0x0000000000010000L,0x0000000000000118L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000200000000000L,0x0000000000010000L,0x0000000000000118L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0xE27C3D9E68C00000L,0x0000042E081FE3EFL,0x0000000000000118L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xE27C3D9E68C00002L,0x0000042E081FE3EFL,0x0000000000000018L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000200000000000L,0x0000008000010000L,0x0000000000000408L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000000D8F02L,0x0008000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000220081128000L,0x0000008000011000L,0x0000000000000598L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000220081128000L,0x0040008000011000L,0x0000000000000598L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000000000D8F00L,0x0008000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020005100000L,0x0000000000001000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020005100000L,0x0000000000001000L,0x0000000000000100L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000200000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000100000L,0x0001000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020005000000L,0x0081000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000005000000L,0x0081000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000004000000L,0x0081000000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000200004000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0D80006000000000L,0x0000000040000800L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L,0x0000000000000100L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000200000000000L,0x1E10000000010000L,0x0000000000000018L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000220081128000L,0x1E30008000011000L,0x0000000000000418L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x1002600018000000L,0x00000C5010010010L,0x0000000000000058L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0800400000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x1002000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x1002000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x1F82E3E09F1FDF00L,0x1C50BFFFFFEF1DF0L,0x00000000000004B8L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x1F82E3E09F1FDF00L,0x1C50BFFFFFEF1DF0L,0x00000000000005B8L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x1F82E3E09F1FDF00L,0x1CD0BFFFFFEF1DF0L,0x00000000000004B8L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x1F82E3E09F1FDF00L,0x1CD1BFFFFFEF1DF0L,0x00000000000004B8L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x1F82E3E09F1FDF00L,0x1C70BFFFFFEF1DF0L,0x00000000000004B8L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x1F82E3E09F1FDF00L,0x1C71BFFFFFEF1DF0L,0x00000000000004B8L});

}
