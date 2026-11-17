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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ExternalDependency", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "Serviceclients", "Serviceservers", "Actionclients", "Actionservers", "Dependencies", "ParameterAny", "FromGitRepo", "Pluginslots", "Subscribers", "Implements", "Parameters", "Publishers", "Parameter", "GraphName", "Float32_1", "Float64_1", "Pluginlib", "Actions", "Default", "Duration", "External", "Feedback", "Plugins", "Response", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Float32", "Float64", "Format", "Int16_1", "Int32_1", "Int64_1", "Library", "Loader", "Message", "Param", "Request", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Int8_1", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Base", "Class", "Int16", "Int32", "Int64", "Msgs", "Node_1", "Pub", "Srvs", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Float32_1=22;
    public static final int Node=91;
    public static final int RULE_DATE_TIME=117;
    public static final int Uint64_1=35;
    public static final int Serviceclients=8;
    public static final int Pluginlib=24;
    public static final int String=54;
    public static final int Int16=70;
    public static final int Float32=38;
    public static final int Goal=88;
    public static final int Actionservers=11;
    public static final int Bool=85;
    public static final int Msgs=73;
    public static final int Uint16=63;
    public static final int Boolean=36;
    public static final int ExternalDependency=4;
    public static final int Sub=77;
    public static final int Uint8=79;
    public static final int Parameters=18;
    public static final int RULE_ID=118;
    public static final int Actions=25;
    public static final int RULE_DIGIT=107;
    public static final int GlobalNamespace=7;
    public static final int Node_1=74;
    public static final int Int16_1=41;
    public static final int Header=53;
    public static final int RULE_INT=120;
    public static final int Byte=86;
    public static final int RULE_ML_COMMENT=127;
    public static final int LeftSquareBracket=103;
    public static final int Pluginslots=15;
    public static final int Ac=83;
    public static final int Base64=51;
    public static final int Comma=99;
    public static final int As=84;
    public static final int RULE_MESSAGE_ASIGMENT=121;
    public static final int LeftSquareBracketRightSquareBracket=98;
    public static final int Int32=71;
    public static final int Char=87;
    public static final int Publishers=19;
    public static final int Srvs=76;
    public static final int RightCurlyBracket=106;
    public static final int RULE_DECINT=110;
    public static final int Uint32=64;
    public static final int Plugins=30;
    public static final int FromGitRepo=14;
    public static final int FullStop=100;
    public static final int RULE_HOUR=115;
    public static final int Int8=89;
    public static final int Default=26;
    public static final int Int8_1=60;
    public static final int CommercialAt=102;
    public static final int Uint16_1=33;
    public static final int Sc=92;
    public static final int Type=95;
    public static final int Float64=39;
    public static final int Int32_1=42;
    public static final int Parameter=20;
    public static final int RULE_BINARY=108;
    public static final int String_1=62;
    public static final int Subscribers=16;
    public static final int String_2=32;
    public static final int Ss=93;
    public static final int Actionclients=10;
    public static final int RULE_DAY=112;
    public static final int RULE_BEGIN=122;
    public static final int RULE_BOOLEAN=109;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=9;
    public static final int RULE_YEAR=114;
    public static final int Result=61;
    public static final int Name=90;
    public static final int RULE_MIN_SEC=116;
    public static final int Implements=17;
    public static final int Char_1=59;
    public static final int ParameterAny=13;
    public static final int List=82;
    public static final int Dependencies=12;
    public static final int RightSquareBracket=104;
    public static final int PrivateNamespace=6;
    public static final int GraphName=21;
    public static final int Byte_1=58;
    public static final int Float64_1=23;
    public static final int Duration=27;
    public static final int Uint32_1=34;
    public static final int Double=52;
    public static final int External=28;
    public static final int Type_1=78;
    public static final int Value=80;
    public static final int Class=69;
    public static final int Library=44;
    public static final int Uint64=65;
    public static final int Action=56;
    public static final int RULE_END=123;
    public static final int Message=46;
    public static final int Value_1=66;
    public static final int Loader=45;
    public static final int Time=94;
    public static final int RULE_STRING=119;
    public static final int Bool_1=57;
    public static final int Any=96;
    public static final int Struct=55;
    public static final int RULE_SL_COMMENT=124;
    public static final int Uint8_1=50;
    public static final int Format=40;
    public static final int RULE_DOUBLE=111;
    public static final int Feedback=29;
    public static final int RULE_ROS_CONVENTION_A=125;
    public static final int RULE_ROS_CONVENTION_PARAM=126;
    public static final int Colon=101;
    public static final int Pub=75;
    public static final int EOF=-1;
    public static final int Ns=97;
    public static final int RULE_WS=128;
    public static final int Int64_1=43;
    public static final int Request=48;
    public static final int LeftCurlyBracket=105;
    public static final int Service=49;
    public static final int RULE_ANY_OTHER=129;
    public static final int Base=68;
    public static final int Date=81;
    public static final int Response=31;
    public static final int Integer=37;
    public static final int Array=67;
    public static final int Int64=72;
    public static final int Param=47;
    public static final int RULE_MONTH=113;

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

                if ( (LA1_0==Pluginlib||LA1_0==External||LA1_0==Library||LA1_0==Class||LA1_0==Node||LA1_0==RULE_ID||LA1_0==RULE_ROS_CONVENTION_A) ) {
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
    // InternalRosParser.g:110:1: rulePackage_Impl returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END ) ;
    public final EObject rulePackage_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token this_BEGIN_13=null;
        Token this_END_15=null;
        Token otherlv_16=null;
        Token this_BEGIN_17=null;
        Token this_END_19=null;
        Token otherlv_20=null;
        Token this_BEGIN_21=null;
        Token this_END_23=null;
        Token this_END_24=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_fromGitRepo_5_0 = null;

        EObject lv_dependency_8_0 = null;

        EObject lv_dependency_10_0 = null;

        EObject lv_spec_14_0 = null;

        EObject lv_spec_18_0 = null;

        EObject lv_spec_22_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:116:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END ) )
            // InternalRosParser.g:117:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END )
            {
            // InternalRosParser.g:117:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END )
            // InternalRosParser.g:118:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END
            {
            // InternalRosParser.g:118:3: ()
            // InternalRosParser.g:119:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPackage_ImplAccess().getPackageAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:125:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRosParser.g:126:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRosParser.g:126:4: (lv_name_1_0= ruleRosNames )
            // InternalRosParser.g:127:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameRosNamesParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getPackage_ImplAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_6); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRosParser.g:152:3: (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==FromGitRepo) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalRosParser.g:153:4: otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,FromGitRepo,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getPackage_ImplAccess().getFromGitRepoKeyword_4_0());
                    			
                    // InternalRosParser.g:157:4: ( (lv_fromGitRepo_5_0= ruleEString ) )
                    // InternalRosParser.g:158:5: (lv_fromGitRepo_5_0= ruleEString )
                    {
                    // InternalRosParser.g:158:5: (lv_fromGitRepo_5_0= ruleEString )
                    // InternalRosParser.g:159:6: lv_fromGitRepo_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getFromGitRepoEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_fromGitRepo_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    						}
                    						set(
                    							current,
                    							"fromGitRepo",
                    							lv_fromGitRepo_5_0,
                    							"de.fraunhofer.ipa.ros.Ros.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalRosParser.g:177:3: (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Dependencies) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRosParser.g:178:4: otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Dependencies,FOLLOW_9); 

                    				newLeafNode(otherlv_6, grammarAccess.getPackage_ImplAccess().getDependenciesKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_10); 

                    				newLeafNode(otherlv_7, grammarAccess.getPackage_ImplAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalRosParser.g:186:4: ( (lv_dependency_8_0= ruleDependency ) )
                    // InternalRosParser.g:187:5: (lv_dependency_8_0= ruleDependency )
                    {
                    // InternalRosParser.g:187:5: (lv_dependency_8_0= ruleDependency )
                    // InternalRosParser.g:188:6: lv_dependency_8_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_dependency_8_0=ruleDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    						}
                    						add(
                    							current,
                    							"dependency",
                    							lv_dependency_8_0,
                    							"de.fraunhofer.ipa.ros.Ros.Dependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRosParser.g:205:4: (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==Comma) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalRosParser.g:206:5: otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_10); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getPackage_ImplAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalRosParser.g:210:5: ( (lv_dependency_10_0= ruleDependency ) )
                    	    // InternalRosParser.g:211:6: (lv_dependency_10_0= ruleDependency )
                    	    {
                    	    // InternalRosParser.g:211:6: (lv_dependency_10_0= ruleDependency )
                    	    // InternalRosParser.g:212:7: lv_dependency_10_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
                    	    lv_dependency_10_0=ruleDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependency",
                    	    								lv_dependency_10_0,
                    	    								"de.fraunhofer.ipa.ros.Ros.Dependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_12); 

                    				newLeafNode(otherlv_11, grammarAccess.getPackage_ImplAccess().getRightSquareBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalRosParser.g:235:3: ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )*
            loop8:
            do {
                int alt8=4;
                switch ( input.LA(1) ) {
                case Msgs:
                    {
                    alt8=1;
                    }
                    break;
                case Srvs:
                    {
                    alt8=2;
                    }
                    break;
                case Actions:
                    {
                    alt8=3;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // InternalRosParser.g:236:4: (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END )
            	    {
            	    // InternalRosParser.g:236:4: (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END )
            	    // InternalRosParser.g:237:5: otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END
            	    {
            	    otherlv_12=(Token)match(input,Msgs,FOLLOW_5); 

            	    					newLeafNode(otherlv_12, grammarAccess.getPackage_ImplAccess().getMsgsKeyword_6_0_0());
            	    				
            	    this_BEGIN_13=(Token)match(input,RULE_BEGIN,FOLLOW_13); 

            	    					newLeafNode(this_BEGIN_13, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_0_1());
            	    				
            	    // InternalRosParser.g:245:5: ( (lv_spec_14_0= ruleTopicSpec ) )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==Pluginlib||LA5_0==External||LA5_0==Library||(LA5_0>=Header && LA5_0<=String)||LA5_0==Class||(LA5_0>=RULE_ID && LA5_0<=RULE_STRING)) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalRosParser.g:246:6: (lv_spec_14_0= ruleTopicSpec )
            	    	    {
            	    	    // InternalRosParser.g:246:6: (lv_spec_14_0= ruleTopicSpec )
            	    	    // InternalRosParser.g:247:7: lv_spec_14_0= ruleTopicSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecTopicSpecParserRuleCall_6_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_13);
            	    	    lv_spec_14_0=ruleTopicSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_14_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.TopicSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);

            	    this_END_15=(Token)match(input,RULE_END,FOLLOW_12); 

            	    					newLeafNode(this_END_15, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosParser.g:270:4: (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END )
            	    {
            	    // InternalRosParser.g:270:4: (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END )
            	    // InternalRosParser.g:271:5: otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END
            	    {
            	    otherlv_16=(Token)match(input,Srvs,FOLLOW_5); 

            	    					newLeafNode(otherlv_16, grammarAccess.getPackage_ImplAccess().getSrvsKeyword_6_1_0());
            	    				
            	    this_BEGIN_17=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_17, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_1_1());
            	    				
            	    // InternalRosParser.g:279:5: ( (lv_spec_18_0= ruleServiceSpec ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==Pluginlib||LA6_0==External||LA6_0==Library||LA6_0==Class||(LA6_0>=RULE_ID && LA6_0<=RULE_STRING)) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalRosParser.g:280:6: (lv_spec_18_0= ruleServiceSpec )
            	    	    {
            	    	    // InternalRosParser.g:280:6: (lv_spec_18_0= ruleServiceSpec )
            	    	    // InternalRosParser.g:281:7: lv_spec_18_0= ruleServiceSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecServiceSpecParserRuleCall_6_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_spec_18_0=ruleServiceSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_18_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    this_END_19=(Token)match(input,RULE_END,FOLLOW_12); 

            	    					newLeafNode(this_END_19, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosParser.g:304:4: (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END )
            	    {
            	    // InternalRosParser.g:304:4: (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END )
            	    // InternalRosParser.g:305:5: otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END
            	    {
            	    otherlv_20=(Token)match(input,Actions,FOLLOW_5); 

            	    					newLeafNode(otherlv_20, grammarAccess.getPackage_ImplAccess().getActionsKeyword_6_2_0());
            	    				
            	    this_BEGIN_21=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_21, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_2_1());
            	    				
            	    // InternalRosParser.g:313:5: ( (lv_spec_22_0= ruleActionSpec ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==Pluginlib||LA7_0==External||LA7_0==Library||LA7_0==Class||(LA7_0>=RULE_ID && LA7_0<=RULE_STRING)) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalRosParser.g:314:6: (lv_spec_22_0= ruleActionSpec )
            	    	    {
            	    	    // InternalRosParser.g:314:6: (lv_spec_22_0= ruleActionSpec )
            	    	    // InternalRosParser.g:315:7: lv_spec_22_0= ruleActionSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecActionSpecParserRuleCall_6_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_spec_22_0=ruleActionSpec();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPackage_ImplRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"spec",
            	    	    								lv_spec_22_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionSpec");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);

            	    this_END_23=(Token)match(input,RULE_END,FOLLOW_12); 

            	    					newLeafNode(this_END_23, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_2_3());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            this_END_24=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_24, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_7());
            		

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
    // InternalRosParser.g:346:1: entryRuleTopicSpec returns [EObject current=null] : iv_ruleTopicSpec= ruleTopicSpec EOF ;
    public final EObject entryRuleTopicSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicSpec = null;


        try {
            // InternalRosParser.g:346:50: (iv_ruleTopicSpec= ruleTopicSpec EOF )
            // InternalRosParser.g:347:2: iv_ruleTopicSpec= ruleTopicSpec EOF
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
    // InternalRosParser.g:353:1: ruleTopicSpec returns [EObject current=null] : ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) ;
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
            // InternalRosParser.g:359:2: ( ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) )
            // InternalRosParser.g:360:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            {
            // InternalRosParser.g:360:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            // InternalRosParser.g:361:3: () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END
            {
            // InternalRosParser.g:361:3: ()
            // InternalRosParser.g:362:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTopicSpecAccess().getTopicSpecAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:368:3: ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) )
            // InternalRosParser.g:369:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            {
            // InternalRosParser.g:369:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            // InternalRosParser.g:370:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            {
            // InternalRosParser.g:370:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            int alt9=3;
            switch ( input.LA(1) ) {
            case Pluginlib:
            case External:
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt9=1;
                }
                break;
            case Header:
                {
                alt9=2;
                }
                break;
            case String:
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
                    // InternalRosParser.g:371:6: lv_name_1_1= ruleEString
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
                    // InternalRosParser.g:387:6: lv_name_1_2= Header
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
                    // InternalRosParser.g:398:6: lv_name_1_3= String
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
            		
            // InternalRosParser.g:419:3: (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_BEGIN) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRosParser.g:420:4: this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRosParser.g:424:4: ( (lv_message_5_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:425:5: (lv_message_5_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:425:5: (lv_message_5_0= ruleMessageDefinition )
                    // InternalRosParser.g:426:6: lv_message_5_0= ruleMessageDefinition
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
    // InternalRosParser.g:456:1: entryRuleServiceSpec returns [EObject current=null] : iv_ruleServiceSpec= ruleServiceSpec EOF ;
    public final EObject entryRuleServiceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceSpec = null;


        try {
            // InternalRosParser.g:456:52: (iv_ruleServiceSpec= ruleServiceSpec EOF )
            // InternalRosParser.g:457:2: iv_ruleServiceSpec= ruleServiceSpec EOF
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
    // InternalRosParser.g:463:1: ruleServiceSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) ;
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
            // InternalRosParser.g:469:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) )
            // InternalRosParser.g:470:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            {
            // InternalRosParser.g:470:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            // InternalRosParser.g:471:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END
            {
            // InternalRosParser.g:471:3: ()
            // InternalRosParser.g:472:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceSpecAccess().getServiceSpecAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:478:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:479:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:479:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:480:5: lv_name_1_0= ruleEString
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
            		
            // InternalRosParser.g:505:3: (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_BEGIN) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRosParser.g:506:4: this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRosParser.g:510:4: ( (lv_request_5_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:511:5: (lv_request_5_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:511:5: (lv_request_5_0= ruleMessageDefinition )
                    // InternalRosParser.g:512:6: lv_request_5_0= ruleMessageDefinition
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
            		
            // InternalRosParser.g:538:3: (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_BEGIN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalRosParser.g:539:4: this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRosParser.g:543:4: ( (lv_response_9_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:544:5: (lv_response_9_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:544:5: (lv_response_9_0= ruleMessageDefinition )
                    // InternalRosParser.g:545:6: lv_response_9_0= ruleMessageDefinition
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
    // InternalRosParser.g:575:1: entryRuleActionSpec returns [EObject current=null] : iv_ruleActionSpec= ruleActionSpec EOF ;
    public final EObject entryRuleActionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSpec = null;


        try {
            // InternalRosParser.g:575:51: (iv_ruleActionSpec= ruleActionSpec EOF )
            // InternalRosParser.g:576:2: iv_ruleActionSpec= ruleActionSpec EOF
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
    // InternalRosParser.g:582:1: ruleActionSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) ;
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
            // InternalRosParser.g:588:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) )
            // InternalRosParser.g:589:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            {
            // InternalRosParser.g:589:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            // InternalRosParser.g:590:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END
            {
            // InternalRosParser.g:590:3: ()
            // InternalRosParser.g:591:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionSpecAccess().getActionSpecAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:597:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:598:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:598:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:599:5: lv_name_1_0= ruleEString
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
            		
            // InternalRosParser.g:624:3: (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_BEGIN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRosParser.g:625:4: this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRosParser.g:629:4: ( (lv_goal_5_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:630:5: (lv_goal_5_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:630:5: (lv_goal_5_0= ruleMessageDefinition )
                    // InternalRosParser.g:631:6: lv_goal_5_0= ruleMessageDefinition
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
            		
            // InternalRosParser.g:657:3: (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_BEGIN) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRosParser.g:658:4: this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRosParser.g:662:4: ( (lv_result_9_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:663:5: (lv_result_9_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:663:5: (lv_result_9_0= ruleMessageDefinition )
                    // InternalRosParser.g:664:6: lv_result_9_0= ruleMessageDefinition
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
            		
            // InternalRosParser.g:690:3: (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_BEGIN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRosParser.g:691:4: this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END
                    {
                    this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

                    				newLeafNode(this_BEGIN_12, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_8_0());
                    			
                    // InternalRosParser.g:695:4: ( (lv_feedback_13_0= ruleMessageDefinition ) )
                    // InternalRosParser.g:696:5: (lv_feedback_13_0= ruleMessageDefinition )
                    {
                    // InternalRosParser.g:696:5: (lv_feedback_13_0= ruleMessageDefinition )
                    // InternalRosParser.g:697:6: lv_feedback_13_0= ruleMessageDefinition
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
    // InternalRosParser.g:727:1: entryRuleMessageDefinition returns [EObject current=null] : iv_ruleMessageDefinition= ruleMessageDefinition EOF ;
    public final EObject entryRuleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageDefinition = null;


        try {
            // InternalRosParser.g:727:58: (iv_ruleMessageDefinition= ruleMessageDefinition EOF )
            // InternalRosParser.g:728:2: iv_ruleMessageDefinition= ruleMessageDefinition EOF
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
    // InternalRosParser.g:734:1: ruleMessageDefinition returns [EObject current=null] : ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) ;
    public final EObject ruleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_MessagePart_1_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:740:2: ( ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) )
            // InternalRosParser.g:741:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            {
            // InternalRosParser.g:741:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            // InternalRosParser.g:742:3: () ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            {
            // InternalRosParser.g:742:3: ()
            // InternalRosParser.g:743:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMessageDefinitionAccess().getMessageDefinitionAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:749:3: ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=Float32_1 && LA16_0<=Pluginlib)||(LA16_0>=Duration && LA16_0<=External)||(LA16_0>=String_2 && LA16_0<=Uint64_1)||(LA16_0>=Float32 && LA16_0<=Float64)||(LA16_0>=Int16_1 && LA16_0<=Library)||LA16_0==Uint8_1||LA16_0==Header||(LA16_0>=Bool_1 && LA16_0<=Int8_1)||(LA16_0>=String_1 && LA16_0<=Uint64)||(LA16_0>=Class && LA16_0<=Int64)||LA16_0==Uint8||(LA16_0>=Bool && LA16_0<=Char)||LA16_0==Int8||LA16_0==Time||(LA16_0>=RULE_ID && LA16_0<=RULE_STRING)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalRosParser.g:750:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    {
            	    // InternalRosParser.g:750:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    // InternalRosParser.g:751:5: lv_MessagePart_1_0= ruleMessagePart
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
            	    break loop16;
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
    // InternalRosParser.g:772:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalRosParser.g:772:45: (iv_ruleNode= ruleNode EOF )
            // InternalRosParser.g:773:2: iv_ruleNode= ruleNode EOF
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
    // InternalRosParser.g:779:1: ruleNode returns [EObject current=null] : (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) ;
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
            // InternalRosParser.g:785:2: ( (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) )
            // InternalRosParser.g:786:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            {
            // InternalRosParser.g:786:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            // InternalRosParser.g:787:3: otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            {
            otherlv_0=(Token)match(input,Node_1,FOLLOW_28); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
            		
            // InternalRosParser.g:791:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRosParser.g:792:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRosParser.g:792:4: (lv_name_1_0= ruleRosNames )
            // InternalRosParser.g:793:5: lv_name_1_0= ruleRosNames
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

            // InternalRosParser.g:810:3: ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            loop25:
            do {
                int alt25=10;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt25=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt25=2;
                    }
                    break;
                case Serviceservers:
                    {
                    alt25=3;
                    }
                    break;
                case Serviceclients:
                    {
                    alt25=4;
                    }
                    break;
                case Actionservers:
                    {
                    alt25=5;
                    }
                    break;
                case Actionclients:
                    {
                    alt25=6;
                    }
                    break;
                case Parameters:
                    {
                    alt25=7;
                    }
                    break;
                case Pluginslots:
                    {
                    alt25=8;
                    }
                    break;
                case CommercialAt:
                    {
                    alt25=9;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // InternalRosParser.g:811:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    {
            	    // InternalRosParser.g:811:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    // InternalRosParser.g:812:5: otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END
            	    {
            	    otherlv_2=(Token)match(input,Publishers,FOLLOW_5); 

            	    					newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getPublishersKeyword_2_0_0());
            	    				
            	    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_3, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_0_1());
            	    				
            	    // InternalRosParser.g:820:5: ( (lv_publisher_4_0= rulePublisher ) )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==Pluginlib||LA17_0==External||LA17_0==Library||LA17_0==Class||(LA17_0>=RULE_ID && LA17_0<=RULE_STRING)) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // InternalRosParser.g:821:6: (lv_publisher_4_0= rulePublisher )
            	    	    {
            	    	    // InternalRosParser.g:821:6: (lv_publisher_4_0= rulePublisher )
            	    	    // InternalRosParser.g:822:7: lv_publisher_4_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPublisherPublisherParserRuleCall_2_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop17;
            	        }
            	    } while (true);

            	    this_END_5=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_5, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosParser.g:845:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    {
            	    // InternalRosParser.g:845:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    // InternalRosParser.g:846:5: otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END
            	    {
            	    otherlv_6=(Token)match(input,Subscribers,FOLLOW_5); 

            	    					newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getSubscribersKeyword_2_1_0());
            	    				
            	    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_7, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_1_1());
            	    				
            	    // InternalRosParser.g:854:5: ( (lv_subscriber_8_0= ruleSubscriber ) )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==Pluginlib||LA18_0==External||LA18_0==Library||LA18_0==Class||(LA18_0>=RULE_ID && LA18_0<=RULE_STRING)) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // InternalRosParser.g:855:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRosParser.g:855:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    // InternalRosParser.g:856:7: lv_subscriber_8_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getSubscriberSubscriberParserRuleCall_2_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop18;
            	        }
            	    } while (true);

            	    this_END_9=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_9, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosParser.g:879:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    {
            	    // InternalRosParser.g:879:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    // InternalRosParser.g:880:5: otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END
            	    {
            	    otherlv_10=(Token)match(input,Serviceservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getServiceserversKeyword_2_2_0());
            	    				
            	    this_BEGIN_11=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_11, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_2_1());
            	    				
            	    // InternalRosParser.g:888:5: ( (lv_serviceserver_12_0= ruleServiceServer ) )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==Pluginlib||LA19_0==External||LA19_0==Library||LA19_0==Class||(LA19_0>=RULE_ID && LA19_0<=RULE_STRING)) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // InternalRosParser.g:889:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRosParser.g:889:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    // InternalRosParser.g:890:7: lv_serviceserver_12_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceserverServiceServerParserRuleCall_2_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop19;
            	        }
            	    } while (true);

            	    this_END_13=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_13, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRosParser.g:913:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    {
            	    // InternalRosParser.g:913:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    // InternalRosParser.g:914:5: otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END
            	    {
            	    otherlv_14=(Token)match(input,Serviceclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getServiceclientsKeyword_2_3_0());
            	    				
            	    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_15, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_3_1());
            	    				
            	    // InternalRosParser.g:922:5: ( (lv_serviceclient_16_0= ruleServiceClient ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Pluginlib||LA20_0==External||LA20_0==Library||LA20_0==Class||(LA20_0>=RULE_ID && LA20_0<=RULE_STRING)) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // InternalRosParser.g:923:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRosParser.g:923:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    // InternalRosParser.g:924:7: lv_serviceclient_16_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceclientServiceClientParserRuleCall_2_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop20;
            	        }
            	    } while (true);

            	    this_END_17=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_17, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRosParser.g:947:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    {
            	    // InternalRosParser.g:947:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    // InternalRosParser.g:948:5: otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END
            	    {
            	    otherlv_18=(Token)match(input,Actionservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getActionserversKeyword_2_4_0());
            	    				
            	    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_19, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_4_1());
            	    				
            	    // InternalRosParser.g:956:5: ( (lv_actionserver_20_0= ruleActionServer ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Pluginlib||LA21_0==External||LA21_0==Library||LA21_0==Class||(LA21_0>=RULE_ID && LA21_0<=RULE_STRING)) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // InternalRosParser.g:957:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    {
            	    	    // InternalRosParser.g:957:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    // InternalRosParser.g:958:7: lv_actionserver_20_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionserverActionServerParserRuleCall_2_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop21;
            	        }
            	    } while (true);

            	    this_END_21=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_21, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRosParser.g:981:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    {
            	    // InternalRosParser.g:981:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    // InternalRosParser.g:982:5: otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END
            	    {
            	    otherlv_22=(Token)match(input,Actionclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getActionclientsKeyword_2_5_0());
            	    				
            	    this_BEGIN_23=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_23, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_5_1());
            	    				
            	    // InternalRosParser.g:990:5: ( (lv_actionclient_24_0= ruleActionClient ) )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Pluginlib||LA22_0==External||LA22_0==Library||LA22_0==Class||(LA22_0>=RULE_ID && LA22_0<=RULE_STRING)) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // InternalRosParser.g:991:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    {
            	    	    // InternalRosParser.g:991:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    // InternalRosParser.g:992:7: lv_actionclient_24_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionclientActionClientParserRuleCall_2_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop22;
            	        }
            	    } while (true);

            	    this_END_25=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_25, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRosParser.g:1015:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    {
            	    // InternalRosParser.g:1015:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    // InternalRosParser.g:1016:5: otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END
            	    {
            	    otherlv_26=(Token)match(input,Parameters,FOLLOW_5); 

            	    					newLeafNode(otherlv_26, grammarAccess.getNodeAccess().getParametersKeyword_2_6_0());
            	    				
            	    this_BEGIN_27=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_27, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_6_1());
            	    				
            	    // InternalRosParser.g:1024:5: ( (lv_parameter_28_0= ruleParameter ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==Pluginlib||LA23_0==External||LA23_0==Library||LA23_0==Class||(LA23_0>=RULE_ID && LA23_0<=RULE_STRING)) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1025:6: (lv_parameter_28_0= ruleParameter )
            	    	    {
            	    	    // InternalRosParser.g:1025:6: (lv_parameter_28_0= ruleParameter )
            	    	    // InternalRosParser.g:1026:7: lv_parameter_28_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getParameterParameterParserRuleCall_2_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop23;
            	        }
            	    } while (true);

            	    this_END_29=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_29, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRosParser.g:1049:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    {
            	    // InternalRosParser.g:1049:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    // InternalRosParser.g:1050:5: otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END
            	    {
            	    otherlv_30=(Token)match(input,Pluginslots,FOLLOW_5); 

            	    					newLeafNode(otherlv_30, grammarAccess.getNodeAccess().getPluginslotsKeyword_2_7_0());
            	    				
            	    this_BEGIN_31=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_31, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_7_1());
            	    				
            	    // InternalRosParser.g:1058:5: ( (lv_pluginSlots_32_0= rulePluginSlot ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Pluginlib||LA24_0==External||LA24_0==Library||LA24_0==Class||(LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1059:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    {
            	    	    // InternalRosParser.g:1059:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    // InternalRosParser.g:1060:7: lv_pluginSlots_32_0= rulePluginSlot
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPluginSlotsPluginSlotParserRuleCall_2_7_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
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
            	    	    break loop24;
            	        }
            	    } while (true);

            	    this_END_33=(Token)match(input,RULE_END,FOLLOW_29); 

            	    					newLeafNode(this_END_33, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_7_3());
            	    				

            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRosParser.g:1083:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRosParser.g:1083:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    // InternalRosParser.g:1084:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    {
            	    // InternalRosParser.g:1084:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    // InternalRosParser.g:1085:6: lv_extensions_34_0= ruleExtensionBlock
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
            	    break loop25;
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
    // InternalRosParser.g:1107:1: entryRulePlugin returns [EObject current=null] : iv_rulePlugin= rulePlugin EOF ;
    public final EObject entryRulePlugin() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlugin = null;


        try {
            // InternalRosParser.g:1107:47: (iv_rulePlugin= rulePlugin EOF )
            // InternalRosParser.g:1108:2: iv_rulePlugin= rulePlugin EOF
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
    // InternalRosParser.g:1114:1: rulePlugin returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END ) ;
    public final EObject rulePlugin() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_BEGIN_9=null;
        Token this_END_11=null;
        Token otherlv_12=null;
        Token this_BEGIN_13=null;
        Token this_END_15=null;
        Token otherlv_16=null;
        Token this_BEGIN_17=null;
        Token this_END_19=null;
        Token otherlv_20=null;
        Token this_BEGIN_21=null;
        Token this_END_23=null;
        Token otherlv_24=null;
        Token this_BEGIN_25=null;
        Token this_END_27=null;
        Token otherlv_28=null;
        Token this_BEGIN_29=null;
        Token this_END_31=null;
        Token otherlv_32=null;
        Token this_BEGIN_33=null;
        Token this_END_35=null;
        Token this_END_37=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_implements_5_0 = null;

        Enumerator lv_loader_7_0 = null;

        EObject lv_publisher_10_0 = null;

        EObject lv_subscriber_14_0 = null;

        EObject lv_serviceserver_18_0 = null;

        EObject lv_serviceclient_22_0 = null;

        EObject lv_actionserver_26_0 = null;

        EObject lv_actionclient_30_0 = null;

        EObject lv_parameter_34_0 = null;

        EObject lv_extensions_36_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:1120:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END ) )
            // InternalRosParser.g:1121:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END )
            {
            // InternalRosParser.g:1121:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END )
            // InternalRosParser.g:1122:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END
            {
            // InternalRosParser.g:1122:3: ()
            // InternalRosParser.g:1123:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginAccess().getPluginAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:1129:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRosParser.g:1130:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRosParser.g:1130:4: (lv_name_1_0= ruleRosNames )
            // InternalRosParser.g:1131:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getPluginAccess().getNameRosNamesParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getPluginAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_30); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRosParser.g:1156:3: ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )*
            loop33:
            do {
                int alt33=11;
                switch ( input.LA(1) ) {
                case Implements:
                    {
                    alt33=1;
                    }
                    break;
                case Loader:
                    {
                    alt33=2;
                    }
                    break;
                case Publishers:
                    {
                    alt33=3;
                    }
                    break;
                case Subscribers:
                    {
                    alt33=4;
                    }
                    break;
                case Serviceservers:
                    {
                    alt33=5;
                    }
                    break;
                case Serviceclients:
                    {
                    alt33=6;
                    }
                    break;
                case Actionservers:
                    {
                    alt33=7;
                    }
                    break;
                case Actionclients:
                    {
                    alt33=8;
                    }
                    break;
                case Parameters:
                    {
                    alt33=9;
                    }
                    break;
                case CommercialAt:
                    {
                    alt33=10;
                    }
                    break;

                }

                switch (alt33) {
            	case 1 :
            	    // InternalRosParser.g:1157:4: (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) )
            	    {
            	    // InternalRosParser.g:1157:4: (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) )
            	    // InternalRosParser.g:1158:5: otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,Implements,FOLLOW_7); 

            	    					newLeafNode(otherlv_4, grammarAccess.getPluginAccess().getImplementsKeyword_4_0_0());
            	    				
            	    // InternalRosParser.g:1162:5: ( (lv_implements_5_0= ruleEString ) )
            	    // InternalRosParser.g:1163:6: (lv_implements_5_0= ruleEString )
            	    {
            	    // InternalRosParser.g:1163:6: (lv_implements_5_0= ruleEString )
            	    // InternalRosParser.g:1164:7: lv_implements_5_0= ruleEString
            	    {

            	    							newCompositeNode(grammarAccess.getPluginAccess().getImplementsEStringParserRuleCall_4_0_1_0());
            	    						
            	    pushFollow(FOLLOW_30);
            	    lv_implements_5_0=ruleEString();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    							}
            	    							set(
            	    								current,
            	    								"implements",
            	    								lv_implements_5_0,
            	    								"de.fraunhofer.ipa.ros.Ros.EString");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRosParser.g:1183:4: (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) )
            	    {
            	    // InternalRosParser.g:1183:4: (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) )
            	    // InternalRosParser.g:1184:5: otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) )
            	    {
            	    otherlv_6=(Token)match(input,Loader,FOLLOW_31); 

            	    					newLeafNode(otherlv_6, grammarAccess.getPluginAccess().getLoaderKeyword_4_1_0());
            	    				
            	    // InternalRosParser.g:1188:5: ( (lv_loader_7_0= rulePluginLoader ) )
            	    // InternalRosParser.g:1189:6: (lv_loader_7_0= rulePluginLoader )
            	    {
            	    // InternalRosParser.g:1189:6: (lv_loader_7_0= rulePluginLoader )
            	    // InternalRosParser.g:1190:7: lv_loader_7_0= rulePluginLoader
            	    {

            	    							newCompositeNode(grammarAccess.getPluginAccess().getLoaderPluginLoaderEnumRuleCall_4_1_1_0());
            	    						
            	    pushFollow(FOLLOW_30);
            	    lv_loader_7_0=rulePluginLoader();

            	    state._fsp--;


            	    							if (current==null) {
            	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    							}
            	    							set(
            	    								current,
            	    								"loader",
            	    								lv_loader_7_0,
            	    								"de.fraunhofer.ipa.ros.Ros.PluginLoader");
            	    							afterParserOrEnumRuleCall();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRosParser.g:1209:4: (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END )
            	    {
            	    // InternalRosParser.g:1209:4: (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END )
            	    // InternalRosParser.g:1210:5: otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END
            	    {
            	    otherlv_8=(Token)match(input,Publishers,FOLLOW_5); 

            	    					newLeafNode(otherlv_8, grammarAccess.getPluginAccess().getPublishersKeyword_4_2_0());
            	    				
            	    this_BEGIN_9=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_9, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_2_1());
            	    				
            	    // InternalRosParser.g:1218:5: ( (lv_publisher_10_0= rulePublisher ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Pluginlib||LA26_0==External||LA26_0==Library||LA26_0==Class||(LA26_0>=RULE_ID && LA26_0<=RULE_STRING)) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1219:6: (lv_publisher_10_0= rulePublisher )
            	    	    {
            	    	    // InternalRosParser.g:1219:6: (lv_publisher_10_0= rulePublisher )
            	    	    // InternalRosParser.g:1220:7: lv_publisher_10_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getPublisherPublisherParserRuleCall_4_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_publisher_10_0=rulePublisher();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"publisher",
            	    	    								lv_publisher_10_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.Publisher");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);

            	    this_END_11=(Token)match(input,RULE_END,FOLLOW_30); 

            	    					newLeafNode(this_END_11, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRosParser.g:1243:4: (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END )
            	    {
            	    // InternalRosParser.g:1243:4: (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END )
            	    // InternalRosParser.g:1244:5: otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END
            	    {
            	    otherlv_12=(Token)match(input,Subscribers,FOLLOW_5); 

            	    					newLeafNode(otherlv_12, grammarAccess.getPluginAccess().getSubscribersKeyword_4_3_0());
            	    				
            	    this_BEGIN_13=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_13, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_3_1());
            	    				
            	    // InternalRosParser.g:1252:5: ( (lv_subscriber_14_0= ruleSubscriber ) )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==Pluginlib||LA27_0==External||LA27_0==Library||LA27_0==Class||(LA27_0>=RULE_ID && LA27_0<=RULE_STRING)) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1253:6: (lv_subscriber_14_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRosParser.g:1253:6: (lv_subscriber_14_0= ruleSubscriber )
            	    	    // InternalRosParser.g:1254:7: lv_subscriber_14_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getSubscriberSubscriberParserRuleCall_4_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_subscriber_14_0=ruleSubscriber();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"subscriber",
            	    	    								lv_subscriber_14_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.Subscriber");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop27;
            	        }
            	    } while (true);

            	    this_END_15=(Token)match(input,RULE_END,FOLLOW_30); 

            	    					newLeafNode(this_END_15, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRosParser.g:1277:4: (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END )
            	    {
            	    // InternalRosParser.g:1277:4: (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END )
            	    // InternalRosParser.g:1278:5: otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END
            	    {
            	    otherlv_16=(Token)match(input,Serviceservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_16, grammarAccess.getPluginAccess().getServiceserversKeyword_4_4_0());
            	    				
            	    this_BEGIN_17=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_17, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_4_1());
            	    				
            	    // InternalRosParser.g:1286:5: ( (lv_serviceserver_18_0= ruleServiceServer ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Pluginlib||LA28_0==External||LA28_0==Library||LA28_0==Class||(LA28_0>=RULE_ID && LA28_0<=RULE_STRING)) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1287:6: (lv_serviceserver_18_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRosParser.g:1287:6: (lv_serviceserver_18_0= ruleServiceServer )
            	    	    // InternalRosParser.g:1288:7: lv_serviceserver_18_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceserverServiceServerParserRuleCall_4_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_serviceserver_18_0=ruleServiceServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceserver",
            	    	    								lv_serviceserver_18_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop28;
            	        }
            	    } while (true);

            	    this_END_19=(Token)match(input,RULE_END,FOLLOW_30); 

            	    					newLeafNode(this_END_19, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRosParser.g:1311:4: (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END )
            	    {
            	    // InternalRosParser.g:1311:4: (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END )
            	    // InternalRosParser.g:1312:5: otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END
            	    {
            	    otherlv_20=(Token)match(input,Serviceclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_20, grammarAccess.getPluginAccess().getServiceclientsKeyword_4_5_0());
            	    				
            	    this_BEGIN_21=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_21, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_5_1());
            	    				
            	    // InternalRosParser.g:1320:5: ( (lv_serviceclient_22_0= ruleServiceClient ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Pluginlib||LA29_0==External||LA29_0==Library||LA29_0==Class||(LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1321:6: (lv_serviceclient_22_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRosParser.g:1321:6: (lv_serviceclient_22_0= ruleServiceClient )
            	    	    // InternalRosParser.g:1322:7: lv_serviceclient_22_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceclientServiceClientParserRuleCall_4_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_serviceclient_22_0=ruleServiceClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"serviceclient",
            	    	    								lv_serviceclient_22_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ServiceClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop29;
            	        }
            	    } while (true);

            	    this_END_23=(Token)match(input,RULE_END,FOLLOW_30); 

            	    					newLeafNode(this_END_23, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRosParser.g:1345:4: (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END )
            	    {
            	    // InternalRosParser.g:1345:4: (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END )
            	    // InternalRosParser.g:1346:5: otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END
            	    {
            	    otherlv_24=(Token)match(input,Actionservers,FOLLOW_5); 

            	    					newLeafNode(otherlv_24, grammarAccess.getPluginAccess().getActionserversKeyword_4_6_0());
            	    				
            	    this_BEGIN_25=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_25, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_6_1());
            	    				
            	    // InternalRosParser.g:1354:5: ( (lv_actionserver_26_0= ruleActionServer ) )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==Pluginlib||LA30_0==External||LA30_0==Library||LA30_0==Class||(LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1355:6: (lv_actionserver_26_0= ruleActionServer )
            	    	    {
            	    	    // InternalRosParser.g:1355:6: (lv_actionserver_26_0= ruleActionServer )
            	    	    // InternalRosParser.g:1356:7: lv_actionserver_26_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionserverActionServerParserRuleCall_4_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_actionserver_26_0=ruleActionServer();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionserver",
            	    	    								lv_actionserver_26_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionServer");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop30;
            	        }
            	    } while (true);

            	    this_END_27=(Token)match(input,RULE_END,FOLLOW_30); 

            	    					newLeafNode(this_END_27, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRosParser.g:1379:4: (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END )
            	    {
            	    // InternalRosParser.g:1379:4: (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END )
            	    // InternalRosParser.g:1380:5: otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END
            	    {
            	    otherlv_28=(Token)match(input,Actionclients,FOLLOW_5); 

            	    					newLeafNode(otherlv_28, grammarAccess.getPluginAccess().getActionclientsKeyword_4_7_0());
            	    				
            	    this_BEGIN_29=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_29, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_7_1());
            	    				
            	    // InternalRosParser.g:1388:5: ( (lv_actionclient_30_0= ruleActionClient ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Pluginlib||LA31_0==External||LA31_0==Library||LA31_0==Class||(LA31_0>=RULE_ID && LA31_0<=RULE_STRING)) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1389:6: (lv_actionclient_30_0= ruleActionClient )
            	    	    {
            	    	    // InternalRosParser.g:1389:6: (lv_actionclient_30_0= ruleActionClient )
            	    	    // InternalRosParser.g:1390:7: lv_actionclient_30_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionclientActionClientParserRuleCall_4_7_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_actionclient_30_0=ruleActionClient();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"actionclient",
            	    	    								lv_actionclient_30_0,
            	    	    								"de.fraunhofer.ipa.ros.Ros.ActionClient");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop31;
            	        }
            	    } while (true);

            	    this_END_31=(Token)match(input,RULE_END,FOLLOW_30); 

            	    					newLeafNode(this_END_31, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_7_3());
            	    				

            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRosParser.g:1413:4: (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END )
            	    {
            	    // InternalRosParser.g:1413:4: (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END )
            	    // InternalRosParser.g:1414:5: otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END
            	    {
            	    otherlv_32=(Token)match(input,Parameters,FOLLOW_5); 

            	    					newLeafNode(otherlv_32, grammarAccess.getPluginAccess().getParametersKeyword_4_8_0());
            	    				
            	    this_BEGIN_33=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            	    					newLeafNode(this_BEGIN_33, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_8_1());
            	    				
            	    // InternalRosParser.g:1422:5: ( (lv_parameter_34_0= ruleParameter ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Pluginlib||LA32_0==External||LA32_0==Library||LA32_0==Class||(LA32_0>=RULE_ID && LA32_0<=RULE_STRING)) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // InternalRosParser.g:1423:6: (lv_parameter_34_0= ruleParameter )
            	    	    {
            	    	    // InternalRosParser.g:1423:6: (lv_parameter_34_0= ruleParameter )
            	    	    // InternalRosParser.g:1424:7: lv_parameter_34_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getParameterParameterParserRuleCall_4_8_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_parameter_34_0=ruleParameter();

            	    	    state._fsp--;


            	    	    							if (current==null) {
            	    	    								current = createModelElementForParent(grammarAccess.getPluginRule());
            	    	    							}
            	    	    							add(
            	    	    								current,
            	    	    								"parameter",
            	    	    								lv_parameter_34_0,
            	    	    								"de.fraunhofer.ipa.ros.Basics.Parameter");
            	    	    							afterParserOrEnumRuleCall();
            	    	    						

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop32;
            	        }
            	    } while (true);

            	    this_END_35=(Token)match(input,RULE_END,FOLLOW_30); 

            	    					newLeafNode(this_END_35, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_8_3());
            	    				

            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalRosParser.g:1447:4: ( (lv_extensions_36_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRosParser.g:1447:4: ( (lv_extensions_36_0= ruleExtensionBlock ) )
            	    // InternalRosParser.g:1448:5: (lv_extensions_36_0= ruleExtensionBlock )
            	    {
            	    // InternalRosParser.g:1448:5: (lv_extensions_36_0= ruleExtensionBlock )
            	    // InternalRosParser.g:1449:6: lv_extensions_36_0= ruleExtensionBlock
            	    {

            	    						newCompositeNode(grammarAccess.getPluginAccess().getExtensionsExtensionBlockParserRuleCall_4_9_0());
            	    					
            	    pushFollow(FOLLOW_30);
            	    lv_extensions_36_0=ruleExtensionBlock();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPluginRule());
            	    						}
            	    						add(
            	    							current,
            	    							"extensions",
            	    							lv_extensions_36_0,
            	    							"de.fraunhofer.ipa.ros.Basics.ExtensionBlock");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            this_END_37=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_37, grammarAccess.getPluginAccess().getENDTerminalRuleCall_5());
            		

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
    // InternalRosParser.g:1475:1: entryRulePluginSlot returns [EObject current=null] : iv_rulePluginSlot= rulePluginSlot EOF ;
    public final EObject entryRulePluginSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginSlot = null;


        try {
            // InternalRosParser.g:1475:51: (iv_rulePluginSlot= rulePluginSlot EOF )
            // InternalRosParser.g:1476:2: iv_rulePluginSlot= rulePluginSlot EOF
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
    // InternalRosParser.g:1482:1: rulePluginSlot returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) ) ;
    public final EObject rulePluginSlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token this_END_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_base_6_0 = null;

        AntlrDatatypeRuleToken lv_parameter_8_0 = null;

        Enumerator lv_valueFormat_10_0 = null;

        AntlrDatatypeRuleToken lv_defaultPlugin_12_0 = null;

        AntlrDatatypeRuleToken lv_base_16_0 = null;

        AntlrDatatypeRuleToken lv_parameter_19_0 = null;

        Enumerator lv_valueFormat_22_0 = null;

        AntlrDatatypeRuleToken lv_defaultPlugin_25_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:1488:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) ) )
            // InternalRosParser.g:1489:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) )
            {
            // InternalRosParser.g:1489:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) )
            // InternalRosParser.g:1490:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) )
            {
            // InternalRosParser.g:1490:3: ()
            // InternalRosParser.g:1491:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginSlotAccess().getPluginSlotAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:1497:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:1498:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:1498:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:1499:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPluginSlotAccess().getNameEStringParserRuleCall_1_0());
            				
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getPluginSlotAccess().getColonKeyword_2());
            		
            // InternalRosParser.g:1520:3: ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_BEGIN) ) {
                alt40=1;
            }
            else if ( (LA40_0==LeftCurlyBracket) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalRosParser.g:1521:4: (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END )
                    {
                    // InternalRosParser.g:1521:4: (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END )
                    // InternalRosParser.g:1522:5: this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END
                    {
                    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_33); 

                    					newLeafNode(this_BEGIN_3, grammarAccess.getPluginSlotAccess().getBEGINTerminalRuleCall_3_0_0());
                    				
                    // InternalRosParser.g:1526:5: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) )
                    // InternalRosParser.g:1527:6: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
                    {
                    // InternalRosParser.g:1527:6: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
                    // InternalRosParser.g:1528:7: ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?)
                    {
                     
                    						  getUnorderedGroupHelper().enter(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    						
                    // InternalRosParser.g:1531:7: ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?)
                    // InternalRosParser.g:1532:8: ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?
                    {
                    // InternalRosParser.g:1532:8: ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=5;
                        int LA34_0 = input.LA(1);

                        if ( LA34_0 == Base && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0) ) {
                            alt34=1;
                        }
                        else if ( LA34_0 == Parameter && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1) ) {
                            alt34=2;
                        }
                        else if ( LA34_0 == Format && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2) ) {
                            alt34=3;
                        }
                        else if ( LA34_0 == Default && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3) ) {
                            alt34=4;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalRosParser.g:1533:6: ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1533:6: ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) )
                    	    // InternalRosParser.g:1534:7: {...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0)");
                    	    }
                    	    // InternalRosParser.g:1534:113: ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) )
                    	    // InternalRosParser.g:1535:8: ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0);
                    	    							
                    	    // InternalRosParser.g:1538:11: ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) )
                    	    // InternalRosParser.g:1538:12: {...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1538:21: (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) )
                    	    // InternalRosParser.g:1538:22: otherlv_5= Base ( (lv_base_6_0= ruleEString ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Base,FOLLOW_7); 

                    	    											newLeafNode(otherlv_5, grammarAccess.getPluginSlotAccess().getBaseKeyword_3_0_1_0_0());
                    	    										
                    	    // InternalRosParser.g:1542:11: ( (lv_base_6_0= ruleEString ) )
                    	    // InternalRosParser.g:1543:12: (lv_base_6_0= ruleEString )
                    	    {
                    	    // InternalRosParser.g:1543:12: (lv_base_6_0= ruleEString )
                    	    // InternalRosParser.g:1544:13: lv_base_6_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getBaseEStringParserRuleCall_3_0_1_0_1_0());
                    	    												
                    	    pushFollow(FOLLOW_34);
                    	    lv_base_6_0=ruleEString();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"base",
                    	    														lv_base_6_0,
                    	    														"de.fraunhofer.ipa.ros.Ros.EString");
                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalRosParser.g:1567:6: ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1567:6: ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) )
                    	    // InternalRosParser.g:1568:7: {...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1)");
                    	    }
                    	    // InternalRosParser.g:1568:113: ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) )
                    	    // InternalRosParser.g:1569:8: ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1);
                    	    							
                    	    // InternalRosParser.g:1572:11: ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) )
                    	    // InternalRosParser.g:1572:12: {...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1572:21: (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) )
                    	    // InternalRosParser.g:1572:22: otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) )
                    	    {
                    	    otherlv_7=(Token)match(input,Parameter,FOLLOW_7); 

                    	    											newLeafNode(otherlv_7, grammarAccess.getPluginSlotAccess().getParameterKeyword_3_0_1_1_0());
                    	    										
                    	    // InternalRosParser.g:1576:11: ( (lv_parameter_8_0= ruleEString ) )
                    	    // InternalRosParser.g:1577:12: (lv_parameter_8_0= ruleEString )
                    	    {
                    	    // InternalRosParser.g:1577:12: (lv_parameter_8_0= ruleEString )
                    	    // InternalRosParser.g:1578:13: lv_parameter_8_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_3_0_1_1_1_0());
                    	    												
                    	    pushFollow(FOLLOW_34);
                    	    lv_parameter_8_0=ruleEString();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"parameter",
                    	    														lv_parameter_8_0,
                    	    														"de.fraunhofer.ipa.ros.Ros.EString");
                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalRosParser.g:1601:6: ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1601:6: ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    // InternalRosParser.g:1602:7: {...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2)");
                    	    }
                    	    // InternalRosParser.g:1602:113: ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    // InternalRosParser.g:1603:8: ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2);
                    	    							
                    	    // InternalRosParser.g:1606:11: ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) )
                    	    // InternalRosParser.g:1606:12: {...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1606:21: (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) )
                    	    // InternalRosParser.g:1606:22: otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Format,FOLLOW_35); 

                    	    											newLeafNode(otherlv_9, grammarAccess.getPluginSlotAccess().getFormatKeyword_3_0_1_2_0());
                    	    										
                    	    // InternalRosParser.g:1610:11: ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) )
                    	    // InternalRosParser.g:1611:12: (lv_valueFormat_10_0= rulePluginSlotValueFormat )
                    	    {
                    	    // InternalRosParser.g:1611:12: (lv_valueFormat_10_0= rulePluginSlotValueFormat )
                    	    // InternalRosParser.g:1612:13: lv_valueFormat_10_0= rulePluginSlotValueFormat
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_3_0_1_2_1_0());
                    	    												
                    	    pushFollow(FOLLOW_34);
                    	    lv_valueFormat_10_0=rulePluginSlotValueFormat();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"valueFormat",
                    	    														lv_valueFormat_10_0,
                    	    														"de.fraunhofer.ipa.ros.Ros.PluginSlotValueFormat");
                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalRosParser.g:1635:6: ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRosParser.g:1635:6: ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) )
                    	    // InternalRosParser.g:1636:7: {...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3)");
                    	    }
                    	    // InternalRosParser.g:1636:113: ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) )
                    	    // InternalRosParser.g:1637:8: ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3);
                    	    							
                    	    // InternalRosParser.g:1640:11: ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) )
                    	    // InternalRosParser.g:1640:12: {...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRosParser.g:1640:21: (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) )
                    	    // InternalRosParser.g:1640:22: otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) )
                    	    {
                    	    otherlv_11=(Token)match(input,Default,FOLLOW_7); 

                    	    											newLeafNode(otherlv_11, grammarAccess.getPluginSlotAccess().getDefaultKeyword_3_0_1_3_0());
                    	    										
                    	    // InternalRosParser.g:1644:11: ( (lv_defaultPlugin_12_0= ruleEString ) )
                    	    // InternalRosParser.g:1645:12: (lv_defaultPlugin_12_0= ruleEString )
                    	    {
                    	    // InternalRosParser.g:1645:12: (lv_defaultPlugin_12_0= ruleEString )
                    	    // InternalRosParser.g:1646:13: lv_defaultPlugin_12_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginEStringParserRuleCall_3_0_1_3_1_0());
                    	    												
                    	    pushFollow(FOLLOW_34);
                    	    lv_defaultPlugin_12_0=ruleEString();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"defaultPlugin",
                    	    														lv_defaultPlugin_12_0,
                    	    														"de.fraunhofer.ipa.ros.Ros.EString");
                    	    													afterParserOrEnumRuleCall();
                    	    												

                    	    }


                    	    }


                    	    }


                    	    }

                    	     
                    	    								getUnorderedGroupHelper().returnFromSelection(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1()) ) {
                        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canLeave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1())");
                    }

                    }


                    }

                     
                    						  getUnorderedGroupHelper().leave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    						

                    }

                    this_END_13=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_13, grammarAccess.getPluginSlotAccess().getENDTerminalRuleCall_3_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1683:4: (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket )
                    {
                    // InternalRosParser.g:1683:4: (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket )
                    // InternalRosParser.g:1684:5: otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket
                    {
                    otherlv_14=(Token)match(input,LeftCurlyBracket,FOLLOW_36); 

                    					newLeafNode(otherlv_14, grammarAccess.getPluginSlotAccess().getLeftCurlyBracketKeyword_3_1_0());
                    				
                    otherlv_15=(Token)match(input,Base,FOLLOW_7); 

                    					newLeafNode(otherlv_15, grammarAccess.getPluginSlotAccess().getBaseKeyword_3_1_1());
                    				
                    // InternalRosParser.g:1692:5: ( (lv_base_16_0= ruleEString ) )
                    // InternalRosParser.g:1693:6: (lv_base_16_0= ruleEString )
                    {
                    // InternalRosParser.g:1693:6: (lv_base_16_0= ruleEString )
                    // InternalRosParser.g:1694:7: lv_base_16_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getBaseEStringParserRuleCall_3_1_2_0());
                    						
                    pushFollow(FOLLOW_37);
                    lv_base_16_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    							}
                    							set(
                    								current,
                    								"base",
                    								lv_base_16_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRosParser.g:1711:5: (otherlv_17= Comma )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==Comma) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalRosParser.g:1712:6: otherlv_17= Comma
                            {
                            otherlv_17=(Token)match(input,Comma,FOLLOW_38); 

                            						newLeafNode(otherlv_17, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_3());
                            					

                            }
                            break;

                    }

                    otherlv_18=(Token)match(input,Parameter,FOLLOW_7); 

                    					newLeafNode(otherlv_18, grammarAccess.getPluginSlotAccess().getParameterKeyword_3_1_4());
                    				
                    // InternalRosParser.g:1721:5: ( (lv_parameter_19_0= ruleEString ) )
                    // InternalRosParser.g:1722:6: (lv_parameter_19_0= ruleEString )
                    {
                    // InternalRosParser.g:1722:6: (lv_parameter_19_0= ruleEString )
                    // InternalRosParser.g:1723:7: lv_parameter_19_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_3_1_5_0());
                    						
                    pushFollow(FOLLOW_39);
                    lv_parameter_19_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    							}
                    							set(
                    								current,
                    								"parameter",
                    								lv_parameter_19_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRosParser.g:1740:5: ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==Comma) ) {
                        int LA37_1 = input.LA(2);

                        if ( (LA37_1==Format) ) {
                            alt37=1;
                        }
                    }
                    else if ( (LA37_0==Format) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalRosParser.g:1741:6: (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) )
                            {
                            // InternalRosParser.g:1741:6: (otherlv_20= Comma )?
                            int alt36=2;
                            int LA36_0 = input.LA(1);

                            if ( (LA36_0==Comma) ) {
                                alt36=1;
                            }
                            switch (alt36) {
                                case 1 :
                                    // InternalRosParser.g:1742:7: otherlv_20= Comma
                                    {
                                    otherlv_20=(Token)match(input,Comma,FOLLOW_40); 

                                    							newLeafNode(otherlv_20, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_6_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_21=(Token)match(input,Format,FOLLOW_35); 

                            						newLeafNode(otherlv_21, grammarAccess.getPluginSlotAccess().getFormatKeyword_3_1_6_1());
                            					
                            // InternalRosParser.g:1751:6: ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) )
                            // InternalRosParser.g:1752:7: (lv_valueFormat_22_0= rulePluginSlotValueFormat )
                            {
                            // InternalRosParser.g:1752:7: (lv_valueFormat_22_0= rulePluginSlotValueFormat )
                            // InternalRosParser.g:1753:8: lv_valueFormat_22_0= rulePluginSlotValueFormat
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_3_1_6_2_0());
                            							
                            pushFollow(FOLLOW_41);
                            lv_valueFormat_22_0=rulePluginSlotValueFormat();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                            								}
                            								set(
                            									current,
                            									"valueFormat",
                            									lv_valueFormat_22_0,
                            									"de.fraunhofer.ipa.ros.Ros.PluginSlotValueFormat");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalRosParser.g:1771:5: ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==Default||LA39_0==Comma) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalRosParser.g:1772:6: (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) )
                            {
                            // InternalRosParser.g:1772:6: (otherlv_23= Comma )?
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==Comma) ) {
                                alt38=1;
                            }
                            switch (alt38) {
                                case 1 :
                                    // InternalRosParser.g:1773:7: otherlv_23= Comma
                                    {
                                    otherlv_23=(Token)match(input,Comma,FOLLOW_42); 

                                    							newLeafNode(otherlv_23, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_7_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_24=(Token)match(input,Default,FOLLOW_7); 

                            						newLeafNode(otherlv_24, grammarAccess.getPluginSlotAccess().getDefaultKeyword_3_1_7_1());
                            					
                            // InternalRosParser.g:1782:6: ( (lv_defaultPlugin_25_0= ruleEString ) )
                            // InternalRosParser.g:1783:7: (lv_defaultPlugin_25_0= ruleEString )
                            {
                            // InternalRosParser.g:1783:7: (lv_defaultPlugin_25_0= ruleEString )
                            // InternalRosParser.g:1784:8: lv_defaultPlugin_25_0= ruleEString
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginEStringParserRuleCall_3_1_7_2_0());
                            							
                            pushFollow(FOLLOW_43);
                            lv_defaultPlugin_25_0=ruleEString();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                            								}
                            								set(
                            									current,
                            									"defaultPlugin",
                            									lv_defaultPlugin_25_0,
                            									"de.fraunhofer.ipa.ros.Ros.EString");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_26=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

                    					newLeafNode(otherlv_26, grammarAccess.getPluginSlotAccess().getRightCurlyBracketKeyword_3_1_8());
                    				

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


    // $ANTLR start "entryRuleEString"
    // InternalRosParser.g:1812:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRosParser.g:1812:47: (iv_ruleEString= ruleEString EOF )
            // InternalRosParser.g:1813:2: iv_ruleEString= ruleEString EOF
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
    // InternalRosParser.g:1819:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:1825:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library ) )
            // InternalRosParser.g:1826:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            {
            // InternalRosParser.g:1826:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            int alt41=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt41=1;
                }
                break;
            case RULE_ID:
                {
                alt41=2;
                }
                break;
            case Pluginlib:
                {
                alt41=3;
                }
                break;
            case External:
                {
                alt41=4;
                }
                break;
            case Class:
                {
                alt41=5;
                }
                break;
            case Library:
                {
                alt41=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalRosParser.g:1827:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1835:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:1843:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getPluginlibKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:1849:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getExternalKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:1855:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getClassKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:1861:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getLibraryKeyword_5());
                    		

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
    // InternalRosParser.g:1870:1: entryRuleRosNames returns [String current=null] : iv_ruleRosNames= ruleRosNames EOF ;
    public final String entryRuleRosNames() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRosNames = null;


        try {
            // InternalRosParser.g:1870:48: (iv_ruleRosNames= ruleRosNames EOF )
            // InternalRosParser.g:1871:2: iv_ruleRosNames= ruleRosNames EOF
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
    // InternalRosParser.g:1877:1: ruleRosNames returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleRosNames() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROS_CONVENTION_A_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:1883:2: ( (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library ) )
            // InternalRosParser.g:1884:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            {
            // InternalRosParser.g:1884:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            int alt42=7;
            switch ( input.LA(1) ) {
            case RULE_ROS_CONVENTION_A:
                {
                alt42=1;
                }
                break;
            case RULE_ID:
                {
                alt42=2;
                }
                break;
            case Node:
                {
                alt42=3;
                }
                break;
            case Pluginlib:
                {
                alt42=4;
                }
                break;
            case External:
                {
                alt42=5;
                }
                break;
            case Class:
                {
                alt42=6;
                }
                break;
            case Library:
                {
                alt42=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalRosParser.g:1885:3: this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A
                    {
                    this_ROS_CONVENTION_A_0=(Token)match(input,RULE_ROS_CONVENTION_A,FOLLOW_2); 

                    			current.merge(this_ROS_CONVENTION_A_0);
                    		

                    			newLeafNode(this_ROS_CONVENTION_A_0, grammarAccess.getRosNamesAccess().getROS_CONVENTION_ATerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1893:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getRosNamesAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:1901:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getNodeKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:1907:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getPluginlibKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:1913:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getExternalKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:1919:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getClassKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:1925:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getLibraryKeyword_6());
                    		

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
    // InternalRosParser.g:1934:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRosParser.g:1934:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRosParser.g:1935:2: iv_ruleExtensionKey= ruleExtensionKey EOF
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
    // InternalRosParser.g:1941:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRosParser.g:1947:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRosParser.g:1948:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRosParser.g:1948:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt43=33;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt43=1;
                }
                break;
            case RULE_STRING:
                {
                alt43=2;
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
                alt43=3;
                }
                break;
            case Node:
                {
                alt43=4;
                }
                break;
            case Pluginlib:
                {
                alt43=5;
                }
                break;
            case External:
                {
                alt43=6;
                }
                break;
            case Class:
                {
                alt43=7;
                }
                break;
            case Library:
                {
                alt43=8;
                }
                break;
            case String:
                {
                alt43=9;
                }
                break;
            case Integer:
                {
                alt43=10;
                }
                break;
            case Double:
                {
                alt43=11;
                }
                break;
            case Boolean:
                {
                alt43=12;
                }
                break;
            case Base64:
                {
                alt43=13;
                }
                break;
            case Array:
                {
                alt43=14;
                }
                break;
            case List:
                {
                alt43=15;
                }
                break;
            case Struct:
                {
                alt43=16;
                }
                break;
            case Date:
                {
                alt43=17;
                }
                break;
            case Any:
                {
                alt43=18;
                }
                break;
            case Bool:
                {
                alt43=19;
                }
                break;
            case Int8:
                {
                alt43=20;
                }
                break;
            case Uint8:
                {
                alt43=21;
                }
                break;
            case Int16:
                {
                alt43=22;
                }
                break;
            case Uint16:
                {
                alt43=23;
                }
                break;
            case Int32:
                {
                alt43=24;
                }
                break;
            case Uint32:
                {
                alt43=25;
                }
                break;
            case Int64:
                {
                alt43=26;
                }
                break;
            case Uint64:
                {
                alt43=27;
                }
                break;
            case Float32:
                {
                alt43=28;
                }
                break;
            case Float64:
                {
                alt43=29;
                }
                break;
            case String_1:
                {
                alt43=30;
                }
                break;
            case Char:
                {
                alt43=31;
                }
                break;
            case Byte:
                {
                alt43=32;
                }
                break;
            case Header:
                {
                alt43=33;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalRosParser.g:1949:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:1957:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:1965:3: this_KEYWORD_2= ruleKEYWORD
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
                    // InternalRosParser.g:1976:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:1982:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getPluginlibKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:1988:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getExternalKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:1994:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getClassKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:2000:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getLibraryKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:2006:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:2012:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:2018:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRosParser.g:2024:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRosParser.g:2030:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRosParser.g:2036:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRosParser.g:2042:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRosParser.g:2048:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRosParser.g:2054:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRosParser.g:2060:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRosParser.g:2066:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRosParser.g:2072:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRosParser.g:2078:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRosParser.g:2084:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRosParser.g:2090:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalRosParser.g:2096:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalRosParser.g:2102:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalRosParser.g:2108:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalRosParser.g:2114:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalRosParser.g:2120:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalRosParser.g:2126:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalRosParser.g:2132:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalRosParser.g:2138:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalRosParser.g:2144:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalRosParser.g:2150:3: kw= Header
                    {
                    kw=(Token)match(input,Header,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getHeaderKeyword_32());
                    		

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
    // InternalRosParser.g:2159:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRosParser.g:2159:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRosParser.g:2160:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
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
    // InternalRosParser.g:2166:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:2172:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format ) )
            // InternalRosParser.g:2173:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format )
            {
            // InternalRosParser.g:2173:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format )
            int alt44=24;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt44=1;
                }
                break;
            case Type_1:
                {
                alt44=2;
                }
                break;
            case Value_1:
                {
                alt44=3;
                }
                break;
            case Default:
                {
                alt44=4;
                }
                break;
            case FromGitRepo:
                {
                alt44=5;
                }
                break;
            case Dependencies:
                {
                alt44=6;
                }
                break;
            case Msgs:
                {
                alt44=7;
                }
                break;
            case Srvs:
                {
                alt44=8;
                }
                break;
            case Actions:
                {
                alt44=9;
                }
                break;
            case Node_1:
                {
                alt44=10;
                }
                break;
            case Publishers:
                {
                alt44=11;
                }
                break;
            case Subscribers:
                {
                alt44=12;
                }
                break;
            case Serviceservers:
                {
                alt44=13;
                }
                break;
            case Serviceclients:
                {
                alt44=14;
                }
                break;
            case Actionservers:
                {
                alt44=15;
                }
                break;
            case Actionclients:
                {
                alt44=16;
                }
                break;
            case Parameters:
                {
                alt44=17;
                }
                break;
            case Plugins:
                {
                alt44=18;
                }
                break;
            case Implements:
                {
                alt44=19;
                }
                break;
            case Loader:
                {
                alt44=20;
                }
                break;
            case Pluginslots:
                {
                alt44=21;
                }
                break;
            case Base:
                {
                alt44=22;
                }
                break;
            case Parameter:
                {
                alt44=23;
                }
                break;
            case Format:
                {
                alt44=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalRosParser.g:2174:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:2180:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:2186:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:2192:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:2198:3: kw= FromGitRepo
                    {
                    kw=(Token)match(input,FromGitRepo,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromGitRepoKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:2204:3: kw= Dependencies
                    {
                    kw=(Token)match(input,Dependencies,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDependenciesKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:2210:3: kw= Msgs
                    {
                    kw=(Token)match(input,Msgs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getMsgsKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:2216:3: kw= Srvs
                    {
                    kw=(Token)match(input,Srvs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSrvsKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:2222:3: kw= Actions
                    {
                    kw=(Token)match(input,Actions,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionsKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:2228:3: kw= Node_1
                    {
                    kw=(Token)match(input,Node_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodeKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:2234:3: kw= Publishers
                    {
                    kw=(Token)match(input,Publishers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPublishersKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRosParser.g:2240:3: kw= Subscribers
                    {
                    kw=(Token)match(input,Subscribers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubscribersKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRosParser.g:2246:3: kw= Serviceservers
                    {
                    kw=(Token)match(input,Serviceservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceserversKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRosParser.g:2252:3: kw= Serviceclients
                    {
                    kw=(Token)match(input,Serviceclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceclientsKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRosParser.g:2258:3: kw= Actionservers
                    {
                    kw=(Token)match(input,Actionservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionserversKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRosParser.g:2264:3: kw= Actionclients
                    {
                    kw=(Token)match(input,Actionclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionclientsKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRosParser.g:2270:3: kw= Parameters
                    {
                    kw=(Token)match(input,Parameters,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParametersKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRosParser.g:2276:3: kw= Plugins
                    {
                    kw=(Token)match(input,Plugins,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPluginsKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRosParser.g:2282:3: kw= Implements
                    {
                    kw=(Token)match(input,Implements,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getImplementsKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRosParser.g:2288:3: kw= Loader
                    {
                    kw=(Token)match(input,Loader,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getLoaderKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRosParser.g:2294:3: kw= Pluginslots
                    {
                    kw=(Token)match(input,Pluginslots,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPluginslotsKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRosParser.g:2300:3: kw= Base
                    {
                    kw=(Token)match(input,Base,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getBaseKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRosParser.g:2306:3: kw= Parameter
                    {
                    kw=(Token)match(input,Parameter,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParameterKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalRosParser.g:2312:3: kw= Format
                    {
                    kw=(Token)match(input,Format,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFormatKeyword_23());
                    		

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
    // InternalRosParser.g:2321:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // InternalRosParser.g:2321:50: (iv_rulePublisher= rulePublisher EOF )
            // InternalRosParser.g:2322:2: iv_rulePublisher= rulePublisher EOF
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
    // InternalRosParser.g:2328:1: rulePublisher returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject rulePublisher() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2334:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:2335:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:2335:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:2336:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:2336:3: ()
            // InternalRosParser.g:2337:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPublisherAccess().getPublisherAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2343:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:2344:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:2344:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:2345:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPublisherAccess().getNameEStringParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getPublisherAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_44); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPublisherAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getPublisherAccess().getTypeKeyword_4());
            		
            // InternalRosParser.g:2374:3: ( ( ruleEString ) )
            // InternalRosParser.g:2375:4: ( ruleEString )
            {
            // InternalRosParser.g:2375:4: ( ruleEString )
            // InternalRosParser.g:2376:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPublisherRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPublisherAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_45);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2390:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==Ns) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalRosParser.g:2391:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_46); 

                    				newLeafNode(otherlv_6, grammarAccess.getPublisherAccess().getNsKeyword_6_0());
                    			
                    // InternalRosParser.g:2395:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:2396:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2396:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:2397:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPublisherRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_8, grammarAccess.getPublisherAccess().getENDTerminalRuleCall_7());
            		

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
    // InternalRosParser.g:2423:1: entryRuleSubscriber returns [EObject current=null] : iv_ruleSubscriber= ruleSubscriber EOF ;
    public final EObject entryRuleSubscriber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscriber = null;


        try {
            // InternalRosParser.g:2423:51: (iv_ruleSubscriber= ruleSubscriber EOF )
            // InternalRosParser.g:2424:2: iv_ruleSubscriber= ruleSubscriber EOF
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
    // InternalRosParser.g:2430:1: ruleSubscriber returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleSubscriber() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2436:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:2437:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:2437:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:2438:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:2438:3: ()
            // InternalRosParser.g:2439:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubscriberAccess().getSubscriberAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2445:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:2446:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:2446:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:2447:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSubscriberAccess().getNameEStringParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getSubscriberAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_44); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getSubscriberAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getSubscriberAccess().getTypeKeyword_4());
            		
            // InternalRosParser.g:2476:3: ( ( ruleEString ) )
            // InternalRosParser.g:2477:4: ( ruleEString )
            {
            // InternalRosParser.g:2477:4: ( ruleEString )
            // InternalRosParser.g:2478:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubscriberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubscriberAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_45);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2492:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Ns) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalRosParser.g:2493:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_46); 

                    				newLeafNode(otherlv_6, grammarAccess.getSubscriberAccess().getNsKeyword_6_0());
                    			
                    // InternalRosParser.g:2497:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:2498:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2498:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:2499:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSubscriberRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_8, grammarAccess.getSubscriberAccess().getENDTerminalRuleCall_7());
            		

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
    // InternalRosParser.g:2525:1: entryRuleServiceServer returns [EObject current=null] : iv_ruleServiceServer= ruleServiceServer EOF ;
    public final EObject entryRuleServiceServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceServer = null;


        try {
            // InternalRosParser.g:2525:54: (iv_ruleServiceServer= ruleServiceServer EOF )
            // InternalRosParser.g:2526:2: iv_ruleServiceServer= ruleServiceServer EOF
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
    // InternalRosParser.g:2532:1: ruleServiceServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleServiceServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2538:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:2539:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:2539:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:2540:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:2540:3: ()
            // InternalRosParser.g:2541:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceServerAccess().getServiceServerAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2547:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:2548:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:2548:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:2549:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceServerAccess().getNameEStringParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getServiceServerAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_44); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceServerAccess().getTypeKeyword_4());
            		
            // InternalRosParser.g:2578:3: ( ( ruleEString ) )
            // InternalRosParser.g:2579:4: ( ruleEString )
            {
            // InternalRosParser.g:2579:4: ( ruleEString )
            // InternalRosParser.g:2580:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceServerAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_45);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2594:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Ns) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRosParser.g:2595:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_46); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRosParser.g:2599:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:2600:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2600:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:2601:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceServerRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_8, grammarAccess.getServiceServerAccess().getENDTerminalRuleCall_7());
            		

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
    // InternalRosParser.g:2627:1: entryRuleServiceClient returns [EObject current=null] : iv_ruleServiceClient= ruleServiceClient EOF ;
    public final EObject entryRuleServiceClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceClient = null;


        try {
            // InternalRosParser.g:2627:54: (iv_ruleServiceClient= ruleServiceClient EOF )
            // InternalRosParser.g:2628:2: iv_ruleServiceClient= ruleServiceClient EOF
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
    // InternalRosParser.g:2634:1: ruleServiceClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleServiceClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2640:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:2641:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:2641:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:2642:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:2642:3: ()
            // InternalRosParser.g:2643:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceClientAccess().getServiceClientAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2649:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:2650:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:2650:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:2651:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceClientAccess().getNameEStringParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getServiceClientAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_44); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceClientAccess().getTypeKeyword_4());
            		
            // InternalRosParser.g:2680:3: ( ( ruleEString ) )
            // InternalRosParser.g:2681:4: ( ruleEString )
            {
            // InternalRosParser.g:2681:4: ( ruleEString )
            // InternalRosParser.g:2682:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceClientAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_45);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2696:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==Ns) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalRosParser.g:2697:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_46); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRosParser.g:2701:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:2702:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2702:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:2703:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getServiceClientRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_8, grammarAccess.getServiceClientAccess().getENDTerminalRuleCall_7());
            		

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
    // InternalRosParser.g:2729:1: entryRuleActionServer returns [EObject current=null] : iv_ruleActionServer= ruleActionServer EOF ;
    public final EObject entryRuleActionServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionServer = null;


        try {
            // InternalRosParser.g:2729:53: (iv_ruleActionServer= ruleActionServer EOF )
            // InternalRosParser.g:2730:2: iv_ruleActionServer= ruleActionServer EOF
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
    // InternalRosParser.g:2736:1: ruleActionServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleActionServer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2742:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:2743:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:2743:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:2744:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:2744:3: ()
            // InternalRosParser.g:2745:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionServerAccess().getActionServerAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2751:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:2752:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:2752:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:2753:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionServerAccess().getNameEStringParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getActionServerAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_44); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getActionServerAccess().getTypeKeyword_4());
            		
            // InternalRosParser.g:2782:3: ( ( ruleEString ) )
            // InternalRosParser.g:2783:4: ( ruleEString )
            {
            // InternalRosParser.g:2783:4: ( ruleEString )
            // InternalRosParser.g:2784:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionServerAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_45);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2798:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Ns) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalRosParser.g:2799:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_46); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRosParser.g:2803:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:2804:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2804:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:2805:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionServerRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_8, grammarAccess.getActionServerAccess().getENDTerminalRuleCall_7());
            		

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
    // InternalRosParser.g:2831:1: entryRuleActionClient returns [EObject current=null] : iv_ruleActionClient= ruleActionClient EOF ;
    public final EObject entryRuleActionClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionClient = null;


        try {
            // InternalRosParser.g:2831:53: (iv_ruleActionClient= ruleActionClient EOF )
            // InternalRosParser.g:2832:2: iv_ruleActionClient= ruleActionClient EOF
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
    // InternalRosParser.g:2838:1: ruleActionClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
    public final EObject ruleActionClient() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_END_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_namespace_7_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2844:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRosParser.g:2845:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRosParser.g:2845:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRosParser.g:2846:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRosParser.g:2846:3: ()
            // InternalRosParser.g:2847:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionClientAccess().getActionClientAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:2853:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:2854:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:2854:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:2855:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionClientAccess().getNameEStringParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getActionClientAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_44); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getActionClientAccess().getTypeKeyword_4());
            		
            // InternalRosParser.g:2884:3: ( ( ruleEString ) )
            // InternalRosParser.g:2885:4: ( ruleEString )
            {
            // InternalRosParser.g:2885:4: ( ruleEString )
            // InternalRosParser.g:2886:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionClientAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_45);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRosParser.g:2900:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==Ns) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRosParser.g:2901:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_46); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRosParser.g:2905:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRosParser.g:2906:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRosParser.g:2906:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRosParser.g:2907:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_namespace_7_0=ruleNamespace();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getActionClientRule());
                    						}
                    						set(
                    							current,
                    							"namespace",
                    							lv_namespace_7_0,
                    							"de.fraunhofer.ipa.ros.Basics.Namespace");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            this_END_8=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_8, grammarAccess.getActionClientAccess().getENDTerminalRuleCall_7());
            		

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
    // InternalRosParser.g:2933:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalRosParser.g:2933:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalRosParser.g:2934:2: iv_ruleDependency= ruleDependency EOF
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
    // InternalRosParser.g:2940:1: ruleDependency returns [EObject current=null] : (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDependency_0 = null;

        EObject this_ExternalDependency_1 = null;



        	enterRule();

        try {
            // InternalRosParser.g:2946:2: ( (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) )
            // InternalRosParser.g:2947:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            {
            // InternalRosParser.g:2947:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Pluginlib||LA51_0==External||LA51_0==Library||LA51_0==Class||(LA51_0>=RULE_ID && LA51_0<=RULE_STRING)) ) {
                alt51=1;
            }
            else if ( (LA51_0==ExternalDependency) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalRosParser.g:2948:3: this_PackageDependency_0= rulePackageDependency
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
                    // InternalRosParser.g:2957:3: this_ExternalDependency_1= ruleExternalDependency
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
    // InternalRosParser.g:2969:1: entryRulePackageDependency returns [EObject current=null] : iv_rulePackageDependency= rulePackageDependency EOF ;
    public final EObject entryRulePackageDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDependency = null;


        try {
            // InternalRosParser.g:2969:58: (iv_rulePackageDependency= rulePackageDependency EOF )
            // InternalRosParser.g:2970:2: iv_rulePackageDependency= rulePackageDependency EOF
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
    // InternalRosParser.g:2976:1: rulePackageDependency returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject rulePackageDependency() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosParser.g:2982:2: ( ( ( ruleEString ) ) )
            // InternalRosParser.g:2983:2: ( ( ruleEString ) )
            {
            // InternalRosParser.g:2983:2: ( ( ruleEString ) )
            // InternalRosParser.g:2984:3: ( ruleEString )
            {
            // InternalRosParser.g:2984:3: ( ruleEString )
            // InternalRosParser.g:2985:4: ruleEString
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
    // InternalRosParser.g:3002:1: entryRuleExternalDependency returns [EObject current=null] : iv_ruleExternalDependency= ruleExternalDependency EOF ;
    public final EObject entryRuleExternalDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDependency = null;


        try {
            // InternalRosParser.g:3002:59: (iv_ruleExternalDependency= ruleExternalDependency EOF )
            // InternalRosParser.g:3003:2: iv_ruleExternalDependency= ruleExternalDependency EOF
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
    // InternalRosParser.g:3009:1: ruleExternalDependency returns [EObject current=null] : ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleExternalDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3015:2: ( ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalRosParser.g:3016:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalRosParser.g:3016:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            // InternalRosParser.g:3017:3: () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) )
            {
            // InternalRosParser.g:3017:3: ()
            // InternalRosParser.g:3018:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalDependencyAccess().getExternalDependencyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExternalDependency,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalDependencyAccess().getExternalDependencyKeyword_1());
            		
            // InternalRosParser.g:3028:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRosParser.g:3029:4: (lv_name_2_0= ruleEString )
            {
            // InternalRosParser.g:3029:4: (lv_name_2_0= ruleEString )
            // InternalRosParser.g:3030:5: lv_name_2_0= ruleEString
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
    // InternalRosParser.g:3051:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRosParser.g:3051:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRosParser.g:3052:2: iv_ruleNamespace= ruleNamespace EOF
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
    // InternalRosParser.g:3058:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3064:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRosParser.g:3065:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRosParser.g:3065:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt52=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt52=1;
                }
                break;
            case RelativeNamespace:
                {
                alt52=2;
                }
                break;
            case PrivateNamespace:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalRosParser.g:3066:3: this_GlobalNamespace_0= ruleGlobalNamespace
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
                    // InternalRosParser.g:3075:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
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
                    // InternalRosParser.g:3084:3: this_PrivateNamespace_2= rulePrivateNamespace
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
    // InternalRosParser.g:3096:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRosParser.g:3096:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRosParser.g:3097:2: iv_ruleGraphName= ruleGraphName EOF
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
    // InternalRosParser.g:3103:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:3109:2: (kw= GraphName )
            // InternalRosParser.g:3110:2: kw= GraphName
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
    // InternalRosParser.g:3118:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRosParser.g:3118:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRosParser.g:3119:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
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
    // InternalRosParser.g:3125:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosParser.g:3131:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:3132:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:3132:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:3133:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:3133:3: ()
            // InternalRosParser.g:3134:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
            		
            // InternalRosParser.g:3144:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==LeftSquareBracket) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRosParser.g:3145:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_48); 

                    				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRosParser.g:3149:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:3150:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:3150:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:3151:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRosParser.g:3168:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==Comma) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalRosParser.g:3169:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_48); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRosParser.g:3173:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosParser.g:3174:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosParser.g:3174:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosParser.g:3175:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop53;
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
    // InternalRosParser.g:3202:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRosParser.g:3202:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRosParser.g:3203:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
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
    // InternalRosParser.g:3209:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosParser.g:3215:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:3216:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:3216:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:3217:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:3217:3: ()
            // InternalRosParser.g:3218:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
            		
            // InternalRosParser.g:3228:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==LeftSquareBracket) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRosParser.g:3229:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_48); 

                    				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRosParser.g:3233:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:3234:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:3234:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:3235:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRosParser.g:3252:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==Comma) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalRosParser.g:3253:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_48); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRosParser.g:3257:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosParser.g:3258:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosParser.g:3258:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosParser.g:3259:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop55;
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
    // InternalRosParser.g:3286:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRosParser.g:3286:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRosParser.g:3287:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
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
    // InternalRosParser.g:3293:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRosParser.g:3299:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRosParser.g:3300:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRosParser.g:3300:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRosParser.g:3301:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRosParser.g:3301:3: ()
            // InternalRosParser.g:3302:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_47); 

            			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
            		
            // InternalRosParser.g:3312:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==LeftSquareBracket) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalRosParser.g:3313:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_48); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRosParser.g:3317:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRosParser.g:3318:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRosParser.g:3318:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRosParser.g:3319:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRosParser.g:3336:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==Comma) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalRosParser.g:3337:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_48); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRosParser.g:3341:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRosParser.g:3342:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRosParser.g:3342:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRosParser.g:3343:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop57;
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
    // InternalRosParser.g:3370:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRosParser.g:3370:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRosParser.g:3371:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRosParser.g:3377:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) ;
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
            // InternalRosParser.g:3383:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) )
            // InternalRosParser.g:3384:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            {
            // InternalRosParser.g:3384:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            // InternalRosParser.g:3385:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END
            {
            // InternalRosParser.g:3385:3: ()
            // InternalRosParser.g:3386:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:3392:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRosParser.g:3393:4: (lv_name_1_0= ruleEString )
            {
            // InternalRosParser.g:3393:4: (lv_name_1_0= ruleEString )
            // InternalRosParser.g:3394:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0());
            				
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

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_49); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRosParser.g:3419:3: (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==Ns) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRosParser.g:3420:4: otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) )
                    {
                    otherlv_4=(Token)match(input,Ns,FOLLOW_46); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getNsKeyword_4_0());
                    			
                    // InternalRosParser.g:3424:4: ( (lv_namespace_5_0= ruleNamespace ) )
                    // InternalRosParser.g:3425:5: (lv_namespace_5_0= ruleNamespace )
                    {
                    // InternalRosParser.g:3425:5: (lv_namespace_5_0= ruleNamespace )
                    // InternalRosParser.g:3426:6: lv_namespace_5_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_namespace_5_0=ruleNamespace();

                    state._fsp--;


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
                    break;

            }

            otherlv_6=(Token)match(input,Type_1,FOLLOW_50); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getTypeKeyword_5());
            		
            // InternalRosParser.g:3448:3: ( (lv_type_7_0= ruleParameterType ) )
            // InternalRosParser.g:3449:4: (lv_type_7_0= ruleParameterType )
            {
            // InternalRosParser.g:3449:4: (lv_type_7_0= ruleParameterType )
            // InternalRosParser.g:3450:5: lv_type_7_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_51);
            lv_type_7_0=ruleParameterType();

            state._fsp--;


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

            // InternalRosParser.g:3467:3: (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==Value_1) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalRosParser.g:3468:4: otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) )
                    {
                    otherlv_8=(Token)match(input,Value_1,FOLLOW_52); 

                    				newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getValueKeyword_7_0());
                    			
                    // InternalRosParser.g:3472:4: ( (lv_value_9_0= ruleParameterValue ) )
                    // InternalRosParser.g:3473:5: (lv_value_9_0= ruleParameterValue )
                    {
                    // InternalRosParser.g:3473:5: (lv_value_9_0= ruleParameterValue )
                    // InternalRosParser.g:3474:6: lv_value_9_0= ruleParameterValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_value_9_0=ruleParameterValue();

                    state._fsp--;


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
                    break;

            }

            this_END_10=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_10, grammarAccess.getParameterAccess().getENDTerminalRuleCall_8());
            		

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
    // InternalRosParser.g:3500:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRosParser.g:3500:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRosParser.g:3501:2: iv_ruleParameterType= ruleParameterType EOF
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
    // InternalRosParser.g:3507:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
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
            // InternalRosParser.g:3513:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRosParser.g:3514:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRosParser.g:3514:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt61=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt61=1;
                }
                break;
            case Struct:
                {
                alt61=2;
                }
                break;
            case Integer:
                {
                alt61=3;
                }
                break;
            case String:
                {
                alt61=4;
                }
                break;
            case Double:
                {
                alt61=5;
                }
                break;
            case Boolean:
                {
                alt61=6;
                }
                break;
            case Base64:
                {
                alt61=7;
                }
                break;
            case Array:
                {
                alt61=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalRosParser.g:3515:3: this_ParameterListType_0= ruleParameterListType
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
                    // InternalRosParser.g:3524:3: this_ParameterStructType_1= ruleParameterStructType
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
                    // InternalRosParser.g:3533:3: this_ParameterIntegerType_2= ruleParameterIntegerType
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
                    // InternalRosParser.g:3542:3: this_ParameterStringType_3= ruleParameterStringType
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
                    // InternalRosParser.g:3551:3: this_ParameterDoubleType_4= ruleParameterDoubleType
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
                    // InternalRosParser.g:3560:3: this_ParameterBooleanType_5= ruleParameterBooleanType
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
                    // InternalRosParser.g:3569:3: this_ParameterBase64Type_6= ruleParameterBase64Type
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
                    // InternalRosParser.g:3578:3: this_ParameterArrayType_7= ruleParameterArrayType
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
    // InternalRosParser.g:3590:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRosParser.g:3590:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRosParser.g:3591:2: iv_ruleParameterValue= ruleParameterValue EOF
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
    // InternalRosParser.g:3597:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
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
            // InternalRosParser.g:3603:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRosParser.g:3604:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRosParser.g:3604:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt62=7;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // InternalRosParser.g:3605:3: this_ParameterString_0= ruleParameterString
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
                    // InternalRosParser.g:3614:3: this_ParameterBase64_1= ruleParameterBase64
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
                    // InternalRosParser.g:3623:3: this_ParameterInteger_2= ruleParameterInteger
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
                    // InternalRosParser.g:3632:3: this_ParameterDouble_3= ruleParameterDouble
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
                    // InternalRosParser.g:3641:3: this_ParameterBoolean_4= ruleParameterBoolean
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
                    // InternalRosParser.g:3650:3: this_ParameterList_5= ruleParameterList
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
                    // InternalRosParser.g:3659:3: this_ParameterStruct_6= ruleParameterStruct
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
    // InternalRosParser.g:3671:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRosParser.g:3671:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRosParser.g:3672:2: iv_ruleParameterListType= ruleParameterListType EOF
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
    // InternalRosParser.g:3678:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosParser.g:3684:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosParser.g:3685:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosParser.g:3685:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosParser.g:3686:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosParser.g:3686:3: ()
            // InternalRosParser.g:3687:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,List,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_50); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRosParser.g:3701:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRosParser.g:3702:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRosParser.g:3702:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRosParser.g:3703:5: lv_sequence_3_0= ruleParameterType
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

            // InternalRosParser.g:3720:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==Comma) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalRosParser.g:3721:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_50); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRosParser.g:3725:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRosParser.g:3726:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRosParser.g:3726:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRosParser.g:3727:6: lv_sequence_5_0= ruleParameterType
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
            	    break loop63;
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
    // InternalRosParser.g:3753:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRosParser.g:3753:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRosParser.g:3754:2: iv_ruleParameterStructType= ruleParameterStructType EOF
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
    // InternalRosParser.g:3760:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRosParser.g:3766:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRosParser.g:3767:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRosParser.g:3767:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRosParser.g:3768:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRosParser.g:3768:3: ()
            // InternalRosParser.g:3769:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRosParser.g:3783:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRosParser.g:3784:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRosParser.g:3784:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRosParser.g:3785:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
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

            // InternalRosParser.g:3802:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==Comma) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalRosParser.g:3803:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_7); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRosParser.g:3807:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRosParser.g:3808:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRosParser.g:3808:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRosParser.g:3809:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
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
            	    break loop64;
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
    // InternalRosParser.g:3835:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRosParser.g:3835:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRosParser.g:3836:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
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
    // InternalRosParser.g:3842:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3848:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRosParser.g:3849:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRosParser.g:3849:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRosParser.g:3850:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRosParser.g:3850:3: ()
            // InternalRosParser.g:3851:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
            		
            // InternalRosParser.g:3861:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==Default) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRosParser.g:3862:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_54); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:3866:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRosParser.g:3867:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRosParser.g:3867:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRosParser.g:3868:6: lv_default_3_0= ruleParameterInteger
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
    // InternalRosParser.g:3890:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRosParser.g:3890:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRosParser.g:3891:2: iv_ruleParameterStringType= ruleParameterStringType EOF
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
    // InternalRosParser.g:3897:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3903:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRosParser.g:3904:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRosParser.g:3904:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRosParser.g:3905:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRosParser.g:3905:3: ()
            // InternalRosParser.g:3906:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
            		
            // InternalRosParser.g:3916:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==Default) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRosParser.g:3917:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:3921:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRosParser.g:3922:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRosParser.g:3922:5: (lv_default_3_0= ruleParameterString )
                    // InternalRosParser.g:3923:6: lv_default_3_0= ruleParameterString
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
    // InternalRosParser.g:3945:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRosParser.g:3945:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRosParser.g:3946:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
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
    // InternalRosParser.g:3952:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:3958:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRosParser.g:3959:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRosParser.g:3959:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRosParser.g:3960:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRosParser.g:3960:3: ()
            // InternalRosParser.g:3961:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
            		
            // InternalRosParser.g:3971:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Default) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalRosParser.g:3972:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_55); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:3976:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRosParser.g:3977:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRosParser.g:3977:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRosParser.g:3978:6: lv_default_3_0= ruleParameterDouble
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
    // InternalRosParser.g:4000:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRosParser.g:4000:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRosParser.g:4001:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
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
    // InternalRosParser.g:4007:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4013:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRosParser.g:4014:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRosParser.g:4014:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRosParser.g:4015:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRosParser.g:4015:3: ()
            // InternalRosParser.g:4016:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalRosParser.g:4026:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==Default) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalRosParser.g:4027:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_56); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:4031:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRosParser.g:4032:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRosParser.g:4032:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRosParser.g:4033:6: lv_default_3_0= ruleParameterBoolean
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
    // InternalRosParser.g:4055:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRosParser.g:4055:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRosParser.g:4056:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
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
    // InternalRosParser.g:4062:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4068:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRosParser.g:4069:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRosParser.g:4069:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRosParser.g:4070:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRosParser.g:4070:3: ()
            // InternalRosParser.g:4071:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_53); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
            		
            // InternalRosParser.g:4081:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==Default) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRosParser.g:4082:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_57); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRosParser.g:4086:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRosParser.g:4087:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRosParser.g:4087:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRosParser.g:4088:6: lv_default_3_0= ruleParameterBase64
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
    // InternalRosParser.g:4110:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRosParser.g:4110:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRosParser.g:4111:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
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
    // InternalRosParser.g:4117:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
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
            // InternalRosParser.g:4123:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRosParser.g:4124:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRosParser.g:4124:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRosParser.g:4125:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
            		
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_50); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRosParser.g:4133:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRosParser.g:4134:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRosParser.g:4134:4: (lv_type_2_0= ruleParameterType )
            // InternalRosParser.g:4135:5: lv_type_2_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_58);
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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_53); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
            		
            // InternalRosParser.g:4156:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==Default) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRosParser.g:4157:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_9); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                    			
                    // InternalRosParser.g:4161:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRosParser.g:4162:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRosParser.g:4162:5: (lv_default_5_0= ruleParameterList )
                    // InternalRosParser.g:4163:6: lv_default_5_0= ruleParameterList
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
    // InternalRosParser.g:4185:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRosParser.g:4185:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRosParser.g:4186:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRosParser.g:4192:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4198:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRosParser.g:4199:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRosParser.g:4199:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRosParser.g:4200:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRosParser.g:4200:3: ()
            // InternalRosParser.g:4201:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRosParser.g:4211:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosParser.g:4212:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosParser.g:4212:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosParser.g:4213:5: lv_value_2_0= ruleParameterValue
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

            // InternalRosParser.g:4230:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==Comma) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalRosParser.g:4231:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_52); 

            	    				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRosParser.g:4235:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRosParser.g:4236:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRosParser.g:4236:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRosParser.g:4237:6: lv_value_4_0= ruleParameterValue
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
            	    break loop71;
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
    // InternalRosParser.g:4263:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRosParser.g:4263:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRosParser.g:4264:2: iv_ruleParameterAny= ruleParameterAny EOF
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
    // InternalRosParser.g:4270:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4276:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRosParser.g:4277:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRosParser.g:4277:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRosParser.g:4278:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRosParser.g:4278:3: ()
            // InternalRosParser.g:4279:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
            		
            // InternalRosParser.g:4289:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==Value) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalRosParser.g:4290:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_7); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                    			
                    // InternalRosParser.g:4294:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRosParser.g:4295:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRosParser.g:4295:5: (lv_value_3_0= ruleEString )
                    // InternalRosParser.g:4296:6: lv_value_3_0= ruleEString
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
    // InternalRosParser.g:4318:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRosParser.g:4318:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRosParser.g:4319:2: iv_ruleParameterString= ruleParameterString EOF
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
    // InternalRosParser.g:4325:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4331:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRosParser.g:4332:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRosParser.g:4332:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRosParser.g:4333:3: (lv_value_0_0= ruleEString )
            {
            // InternalRosParser.g:4333:3: (lv_value_0_0= ruleEString )
            // InternalRosParser.g:4334:4: lv_value_0_0= ruleEString
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
    // InternalRosParser.g:4354:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRosParser.g:4354:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRosParser.g:4355:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
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
    // InternalRosParser.g:4361:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4367:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRosParser.g:4368:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRosParser.g:4368:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRosParser.g:4369:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRosParser.g:4369:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRosParser.g:4370:4: lv_value_0_0= ruleBase64Binary
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
    // InternalRosParser.g:4390:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRosParser.g:4390:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRosParser.g:4391:2: iv_ruleParameterInteger= ruleParameterInteger EOF
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
    // InternalRosParser.g:4397:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4403:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRosParser.g:4404:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRosParser.g:4404:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRosParser.g:4405:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRosParser.g:4405:3: (lv_value_0_0= ruleInteger0 )
            // InternalRosParser.g:4406:4: lv_value_0_0= ruleInteger0
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
    // InternalRosParser.g:4426:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRosParser.g:4426:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRosParser.g:4427:2: iv_ruleParameterDouble= ruleParameterDouble EOF
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
    // InternalRosParser.g:4433:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4439:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRosParser.g:4440:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRosParser.g:4440:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRosParser.g:4441:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRosParser.g:4441:3: (lv_value_0_0= ruleDouble0 )
            // InternalRosParser.g:4442:4: lv_value_0_0= ruleDouble0
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
    // InternalRosParser.g:4462:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRosParser.g:4462:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRosParser.g:4463:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
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
    // InternalRosParser.g:4469:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4475:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRosParser.g:4476:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRosParser.g:4476:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRosParser.g:4477:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRosParser.g:4477:3: (lv_value_0_0= ruleboolean0 )
            // InternalRosParser.g:4478:4: lv_value_0_0= ruleboolean0
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
    // InternalRosParser.g:4498:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRosParser.g:4498:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRosParser.g:4499:2: iv_ruleParameterStruct= ruleParameterStruct EOF
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
    // InternalRosParser.g:4505:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4511:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRosParser.g:4512:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRosParser.g:4512:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRosParser.g:4513:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRosParser.g:4513:3: ()
            // InternalRosParser.g:4514:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:4520:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==LeftSquareBracket) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRosParser.g:4521:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_60); 

                    				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                    			
                    // InternalRosParser.g:4529:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==Pluginlib||LA73_0==External||LA73_0==Library||LA73_0==Class||(LA73_0>=RULE_ID && LA73_0<=RULE_STRING)) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalRosParser.g:4530:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRosParser.g:4530:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRosParser.g:4531:6: lv_value_3_0= ruleParameterStructMember
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_60);
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
                    	    break loop73;
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
    // InternalRosParser.g:4561:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRosParser.g:4561:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRosParser.g:4562:2: iv_ruleParameterDate= ruleParameterDate EOF
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
    // InternalRosParser.g:4568:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4574:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRosParser.g:4575:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRosParser.g:4575:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRosParser.g:4576:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRosParser.g:4576:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRosParser.g:4577:4: lv_value_0_0= ruleDateTime0
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
    // InternalRosParser.g:4597:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRosParser.g:4597:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRosParser.g:4598:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
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
    // InternalRosParser.g:4604:1: ruleParameterStructMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4610:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) )
            // InternalRosParser.g:4611:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            {
            // InternalRosParser.g:4611:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            // InternalRosParser.g:4612:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) )
            {
            // InternalRosParser.g:4612:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosParser.g:4613:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosParser.g:4613:4: (lv_name_0_0= ruleEString )
            // InternalRosParser.g:4614:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0());
            				
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

            otherlv_1=(Token)match(input,Colon,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_1());
            		
            // InternalRosParser.g:4635:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRosParser.g:4636:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRosParser.g:4636:4: (lv_value_2_0= ruleParameterValue )
            // InternalRosParser.g:4637:5: lv_value_2_0= ruleParameterValue
            {

            					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getValueParameterValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleParameterValue();

            state._fsp--;


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
    // InternalRosParser.g:4658:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRosParser.g:4658:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRosParser.g:4659:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
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
    // InternalRosParser.g:4665:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4671:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRosParser.g:4672:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRosParser.g:4672:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRosParser.g:4673:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRosParser.g:4673:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRosParser.g:4674:4: (lv_name_0_0= ruleEString )
            {
            // InternalRosParser.g:4674:4: (lv_name_0_0= ruleEString )
            // InternalRosParser.g:4675:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_50);
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

            // InternalRosParser.g:4692:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRosParser.g:4693:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRosParser.g:4693:4: (lv_type_1_0= ruleParameterType )
            // InternalRosParser.g:4694:5: lv_type_1_0= ruleParameterType
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
    // InternalRosParser.g:4715:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRosParser.g:4715:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRosParser.g:4716:2: iv_ruleBase64Binary= ruleBase64Binary EOF
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
    // InternalRosParser.g:4722:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:4728:2: (this_BINARY_0= RULE_BINARY )
            // InternalRosParser.g:4729:2: this_BINARY_0= RULE_BINARY
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
    // InternalRosParser.g:4739:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRosParser.g:4739:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRosParser.g:4740:2: iv_ruleboolean0= ruleboolean0 EOF
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
    // InternalRosParser.g:4746:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:4752:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRosParser.g:4753:2: this_BOOLEAN_0= RULE_BOOLEAN
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
    // InternalRosParser.g:4763:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRosParser.g:4763:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRosParser.g:4764:2: iv_ruleDouble0= ruleDouble0 EOF
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
    // InternalRosParser.g:4770:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:4776:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRosParser.g:4777:2: this_DOUBLE_0= RULE_DOUBLE
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
    // InternalRosParser.g:4787:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRosParser.g:4787:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRosParser.g:4788:2: iv_ruleInteger0= ruleInteger0 EOF
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
    // InternalRosParser.g:4794:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:4800:2: (this_DECINT_0= RULE_DECINT )
            // InternalRosParser.g:4801:2: this_DECINT_0= RULE_DECINT
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
    // InternalRosParser.g:4811:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRosParser.g:4811:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRosParser.g:4812:2: iv_ruleDateTime0= ruleDateTime0 EOF
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
    // InternalRosParser.g:4818:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRosParser.g:4824:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRosParser.g:4825:2: this_DATE_TIME_0= RULE_DATE_TIME
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
    // InternalRosParser.g:4835:1: entryRuleMessagePart returns [EObject current=null] : iv_ruleMessagePart= ruleMessagePart EOF ;
    public final EObject entryRuleMessagePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePart = null;


        try {
            // InternalRosParser.g:4835:52: (iv_ruleMessagePart= ruleMessagePart EOF )
            // InternalRosParser.g:4836:2: iv_ruleMessagePart= ruleMessagePart EOF
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
    // InternalRosParser.g:4842:1: ruleMessagePart returns [EObject current=null] : ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) ;
    public final EObject ruleMessagePart() throws RecognitionException {
        EObject current = null;

        Token lv_Data_1_2=null;
        EObject lv_Type_0_0 = null;

        AntlrDatatypeRuleToken lv_Data_1_1 = null;

        AntlrDatatypeRuleToken lv_Data_1_3 = null;



        	enterRule();

        try {
            // InternalRosParser.g:4848:2: ( ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) )
            // InternalRosParser.g:4849:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            {
            // InternalRosParser.g:4849:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            // InternalRosParser.g:4850:3: ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            {
            // InternalRosParser.g:4850:3: ( (lv_Type_0_0= ruleAbstractType ) )
            // InternalRosParser.g:4851:4: (lv_Type_0_0= ruleAbstractType )
            {
            // InternalRosParser.g:4851:4: (lv_Type_0_0= ruleAbstractType )
            // InternalRosParser.g:4852:5: lv_Type_0_0= ruleAbstractType
            {

            					newCompositeNode(grammarAccess.getMessagePartAccess().getTypeAbstractTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_61);
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

            // InternalRosParser.g:4869:3: ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            // InternalRosParser.g:4870:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            {
            // InternalRosParser.g:4870:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            // InternalRosParser.g:4871:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            {
            // InternalRosParser.g:4871:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            int alt75=3;
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
                alt75=1;
                }
                break;
            case RULE_MESSAGE_ASIGMENT:
                {
                alt75=2;
                }
                break;
            case Pluginlib:
            case External:
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt75=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // InternalRosParser.g:4872:6: lv_Data_1_1= ruleKEYWORD
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
                    // InternalRosParser.g:4888:6: lv_Data_1_2= RULE_MESSAGE_ASIGMENT
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
                    // InternalRosParser.g:4903:6: lv_Data_1_3= ruleEString
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
    // InternalRosParser.g:4925:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRosParser.g:4925:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRosParser.g:4926:2: iv_ruleAbstractType= ruleAbstractType EOF
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
    // InternalRosParser.g:4932:1: ruleAbstractType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
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
            // InternalRosParser.g:4938:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRosParser.g:4939:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRosParser.g:4939:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt76=33;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalRosParser.g:4940:3: this_bool_0= rulebool
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_bool_0=rulebool();

                    state._fsp--;


                    			current = this_bool_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:4949:3: this_int8_1= ruleint8
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8_1=ruleint8();

                    state._fsp--;


                    			current = this_int8_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:4958:3: this_uint8_2= ruleuint8
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8_2=ruleuint8();

                    state._fsp--;


                    			current = this_uint8_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:4967:3: this_int16_3= ruleint16
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16_3=ruleint16();

                    state._fsp--;


                    			current = this_int16_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:4976:3: this_uint16_4= ruleuint16
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16_4=ruleuint16();

                    state._fsp--;


                    			current = this_uint16_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:4985:3: this_int32_5= ruleint32
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32_5=ruleint32();

                    state._fsp--;


                    			current = this_int32_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:4994:3: this_uint32_6= ruleuint32
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32_6=ruleuint32();

                    state._fsp--;


                    			current = this_uint32_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:5003:3: this_int64_7= ruleint64
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64_7=ruleint64();

                    state._fsp--;


                    			current = this_int64_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:5012:3: this_uint64_8= ruleuint64
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64_8=ruleuint64();

                    state._fsp--;


                    			current = this_uint64_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:5021:3: this_float32_9= rulefloat32
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32_9=rulefloat32();

                    state._fsp--;


                    			current = this_float32_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:5030:3: this_float64_10= rulefloat64
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64_10=rulefloat64();

                    state._fsp--;


                    			current = this_float64_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalRosParser.g:5039:3: this_string0_11= rulestring0
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0_11=rulestring0();

                    state._fsp--;


                    			current = this_string0_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalRosParser.g:5048:3: this_byte_12= rulebyte
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_byte_12=rulebyte();

                    state._fsp--;


                    			current = this_byte_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalRosParser.g:5057:3: this_time_13= ruletime
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getTimeParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_time_13=ruletime();

                    state._fsp--;


                    			current = this_time_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalRosParser.g:5066:3: this_duration_14= ruleduration
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getDurationParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_duration_14=ruleduration();

                    state._fsp--;


                    			current = this_duration_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 16 :
                    // InternalRosParser.g:5075:3: this_Header_15= ruleHeader
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getHeaderParserRuleCall_15());
                    		
                    pushFollow(FOLLOW_2);
                    this_Header_15=ruleHeader();

                    state._fsp--;


                    			current = this_Header_15;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 17 :
                    // InternalRosParser.g:5084:3: this_boolArray_16= ruleboolArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getBoolArrayParserRuleCall_16());
                    		
                    pushFollow(FOLLOW_2);
                    this_boolArray_16=ruleboolArray();

                    state._fsp--;


                    			current = this_boolArray_16;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 18 :
                    // InternalRosParser.g:5093:3: this_int8Array_17= ruleint8Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt8ArrayParserRuleCall_17());
                    		
                    pushFollow(FOLLOW_2);
                    this_int8Array_17=ruleint8Array();

                    state._fsp--;


                    			current = this_int8Array_17;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 19 :
                    // InternalRosParser.g:5102:3: this_uint8Array_18= ruleuint8Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint8ArrayParserRuleCall_18());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint8Array_18=ruleuint8Array();

                    state._fsp--;


                    			current = this_uint8Array_18;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 20 :
                    // InternalRosParser.g:5111:3: this_int16Array_19= ruleint16Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt16ArrayParserRuleCall_19());
                    		
                    pushFollow(FOLLOW_2);
                    this_int16Array_19=ruleint16Array();

                    state._fsp--;


                    			current = this_int16Array_19;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 21 :
                    // InternalRosParser.g:5120:3: this_uint16Array_20= ruleuint16Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint16ArrayParserRuleCall_20());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint16Array_20=ruleuint16Array();

                    state._fsp--;


                    			current = this_uint16Array_20;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 22 :
                    // InternalRosParser.g:5129:3: this_int32Array_21= ruleint32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt32ArrayParserRuleCall_21());
                    		
                    pushFollow(FOLLOW_2);
                    this_int32Array_21=ruleint32Array();

                    state._fsp--;


                    			current = this_int32Array_21;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 23 :
                    // InternalRosParser.g:5138:3: this_uint32Array_22= ruleuint32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint32ArrayParserRuleCall_22());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint32Array_22=ruleuint32Array();

                    state._fsp--;


                    			current = this_uint32Array_22;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 24 :
                    // InternalRosParser.g:5147:3: this_int64Array_23= ruleint64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getInt64ArrayParserRuleCall_23());
                    		
                    pushFollow(FOLLOW_2);
                    this_int64Array_23=ruleint64Array();

                    state._fsp--;


                    			current = this_int64Array_23;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 25 :
                    // InternalRosParser.g:5156:3: this_uint64Array_24= ruleuint64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getUint64ArrayParserRuleCall_24());
                    		
                    pushFollow(FOLLOW_2);
                    this_uint64Array_24=ruleuint64Array();

                    state._fsp--;


                    			current = this_uint64Array_24;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 26 :
                    // InternalRosParser.g:5165:3: this_float32Array_25= rulefloat32Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat32ArrayParserRuleCall_25());
                    		
                    pushFollow(FOLLOW_2);
                    this_float32Array_25=rulefloat32Array();

                    state._fsp--;


                    			current = this_float32Array_25;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 27 :
                    // InternalRosParser.g:5174:3: this_float64Array_26= rulefloat64Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getFloat64ArrayParserRuleCall_26());
                    		
                    pushFollow(FOLLOW_2);
                    this_float64Array_26=rulefloat64Array();

                    state._fsp--;


                    			current = this_float64Array_26;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 28 :
                    // InternalRosParser.g:5183:3: this_string0Array_27= rulestring0Array
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getString0ArrayParserRuleCall_27());
                    		
                    pushFollow(FOLLOW_2);
                    this_string0Array_27=rulestring0Array();

                    state._fsp--;


                    			current = this_string0Array_27;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 29 :
                    // InternalRosParser.g:5192:3: this_byteArray_28= rulebyteArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getByteArrayParserRuleCall_28());
                    		
                    pushFollow(FOLLOW_2);
                    this_byteArray_28=rulebyteArray();

                    state._fsp--;


                    			current = this_byteArray_28;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 30 :
                    // InternalRosParser.g:5201:3: this_SpecBaseRef_29= ruleSpecBaseRef
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getSpecBaseRefParserRuleCall_29());
                    		
                    pushFollow(FOLLOW_2);
                    this_SpecBaseRef_29=ruleSpecBaseRef();

                    state._fsp--;


                    			current = this_SpecBaseRef_29;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 31 :
                    // InternalRosParser.g:5210:3: this_ArraySpecRef_30= ruleArraySpecRef
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getArraySpecRefParserRuleCall_30());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArraySpecRef_30=ruleArraySpecRef();

                    state._fsp--;


                    			current = this_ArraySpecRef_30;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 32 :
                    // InternalRosParser.g:5219:3: this_char_31= rulechar
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getCharParserRuleCall_31());
                    		
                    pushFollow(FOLLOW_2);
                    this_char_31=rulechar();

                    state._fsp--;


                    			current = this_char_31;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 33 :
                    // InternalRosParser.g:5228:3: this_charArray_32= rulecharArray
                    {

                    			newCompositeNode(grammarAccess.getAbstractTypeAccess().getCharArrayParserRuleCall_32());
                    		
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
    // $ANTLR end "ruleAbstractType"


    // $ANTLR start "entryRulebool"
    // InternalRosParser.g:5240:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRosParser.g:5240:45: (iv_rulebool= rulebool EOF )
            // InternalRosParser.g:5241:2: iv_rulebool= rulebool EOF
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
    // InternalRosParser.g:5247:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5253:2: ( ( () otherlv_1= Bool ) )
            // InternalRosParser.g:5254:2: ( () otherlv_1= Bool )
            {
            // InternalRosParser.g:5254:2: ( () otherlv_1= Bool )
            // InternalRosParser.g:5255:3: () otherlv_1= Bool
            {
            // InternalRosParser.g:5255:3: ()
            // InternalRosParser.g:5256:4: 
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
    // InternalRosParser.g:5270:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRosParser.g:5270:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRosParser.g:5271:2: iv_ruleint8= ruleint8 EOF
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
    // InternalRosParser.g:5277:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5283:2: ( ( () otherlv_1= Int8 ) )
            // InternalRosParser.g:5284:2: ( () otherlv_1= Int8 )
            {
            // InternalRosParser.g:5284:2: ( () otherlv_1= Int8 )
            // InternalRosParser.g:5285:3: () otherlv_1= Int8
            {
            // InternalRosParser.g:5285:3: ()
            // InternalRosParser.g:5286:4: 
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
    // InternalRosParser.g:5300:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRosParser.g:5300:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRosParser.g:5301:2: iv_ruleuint8= ruleuint8 EOF
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
    // InternalRosParser.g:5307:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5313:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRosParser.g:5314:2: ( () otherlv_1= Uint8 )
            {
            // InternalRosParser.g:5314:2: ( () otherlv_1= Uint8 )
            // InternalRosParser.g:5315:3: () otherlv_1= Uint8
            {
            // InternalRosParser.g:5315:3: ()
            // InternalRosParser.g:5316:4: 
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
    // InternalRosParser.g:5330:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRosParser.g:5330:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRosParser.g:5331:2: iv_ruleint16= ruleint16 EOF
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
    // InternalRosParser.g:5337:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5343:2: ( ( () otherlv_1= Int16 ) )
            // InternalRosParser.g:5344:2: ( () otherlv_1= Int16 )
            {
            // InternalRosParser.g:5344:2: ( () otherlv_1= Int16 )
            // InternalRosParser.g:5345:3: () otherlv_1= Int16
            {
            // InternalRosParser.g:5345:3: ()
            // InternalRosParser.g:5346:4: 
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
    // InternalRosParser.g:5360:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRosParser.g:5360:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRosParser.g:5361:2: iv_ruleuint16= ruleuint16 EOF
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
    // InternalRosParser.g:5367:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5373:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRosParser.g:5374:2: ( () otherlv_1= Uint16 )
            {
            // InternalRosParser.g:5374:2: ( () otherlv_1= Uint16 )
            // InternalRosParser.g:5375:3: () otherlv_1= Uint16
            {
            // InternalRosParser.g:5375:3: ()
            // InternalRosParser.g:5376:4: 
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
    // InternalRosParser.g:5390:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRosParser.g:5390:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRosParser.g:5391:2: iv_ruleint32= ruleint32 EOF
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
    // InternalRosParser.g:5397:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5403:2: ( ( () otherlv_1= Int32 ) )
            // InternalRosParser.g:5404:2: ( () otherlv_1= Int32 )
            {
            // InternalRosParser.g:5404:2: ( () otherlv_1= Int32 )
            // InternalRosParser.g:5405:3: () otherlv_1= Int32
            {
            // InternalRosParser.g:5405:3: ()
            // InternalRosParser.g:5406:4: 
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
    // InternalRosParser.g:5420:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRosParser.g:5420:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRosParser.g:5421:2: iv_ruleuint32= ruleuint32 EOF
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
    // InternalRosParser.g:5427:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5433:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRosParser.g:5434:2: ( () otherlv_1= Uint32 )
            {
            // InternalRosParser.g:5434:2: ( () otherlv_1= Uint32 )
            // InternalRosParser.g:5435:3: () otherlv_1= Uint32
            {
            // InternalRosParser.g:5435:3: ()
            // InternalRosParser.g:5436:4: 
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
    // InternalRosParser.g:5450:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRosParser.g:5450:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRosParser.g:5451:2: iv_ruleint64= ruleint64 EOF
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
    // InternalRosParser.g:5457:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5463:2: ( ( () otherlv_1= Int64 ) )
            // InternalRosParser.g:5464:2: ( () otherlv_1= Int64 )
            {
            // InternalRosParser.g:5464:2: ( () otherlv_1= Int64 )
            // InternalRosParser.g:5465:3: () otherlv_1= Int64
            {
            // InternalRosParser.g:5465:3: ()
            // InternalRosParser.g:5466:4: 
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
    // InternalRosParser.g:5480:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRosParser.g:5480:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRosParser.g:5481:2: iv_ruleuint64= ruleuint64 EOF
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
    // InternalRosParser.g:5487:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5493:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRosParser.g:5494:2: ( () otherlv_1= Uint64 )
            {
            // InternalRosParser.g:5494:2: ( () otherlv_1= Uint64 )
            // InternalRosParser.g:5495:3: () otherlv_1= Uint64
            {
            // InternalRosParser.g:5495:3: ()
            // InternalRosParser.g:5496:4: 
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
    // InternalRosParser.g:5510:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRosParser.g:5510:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRosParser.g:5511:2: iv_rulefloat32= rulefloat32 EOF
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
    // InternalRosParser.g:5517:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5523:2: ( ( () otherlv_1= Float32 ) )
            // InternalRosParser.g:5524:2: ( () otherlv_1= Float32 )
            {
            // InternalRosParser.g:5524:2: ( () otherlv_1= Float32 )
            // InternalRosParser.g:5525:3: () otherlv_1= Float32
            {
            // InternalRosParser.g:5525:3: ()
            // InternalRosParser.g:5526:4: 
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
    // InternalRosParser.g:5540:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRosParser.g:5540:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRosParser.g:5541:2: iv_rulefloat64= rulefloat64 EOF
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
    // InternalRosParser.g:5547:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5553:2: ( ( () otherlv_1= Float64 ) )
            // InternalRosParser.g:5554:2: ( () otherlv_1= Float64 )
            {
            // InternalRosParser.g:5554:2: ( () otherlv_1= Float64 )
            // InternalRosParser.g:5555:3: () otherlv_1= Float64
            {
            // InternalRosParser.g:5555:3: ()
            // InternalRosParser.g:5556:4: 
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
    // InternalRosParser.g:5570:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRosParser.g:5570:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRosParser.g:5571:2: iv_rulestring0= rulestring0 EOF
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
    // InternalRosParser.g:5577:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5583:2: ( ( () otherlv_1= String_1 ) )
            // InternalRosParser.g:5584:2: ( () otherlv_1= String_1 )
            {
            // InternalRosParser.g:5584:2: ( () otherlv_1= String_1 )
            // InternalRosParser.g:5585:3: () otherlv_1= String_1
            {
            // InternalRosParser.g:5585:3: ()
            // InternalRosParser.g:5586:4: 
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
    // InternalRosParser.g:5600:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRosParser.g:5600:45: (iv_rulechar= rulechar EOF )
            // InternalRosParser.g:5601:2: iv_rulechar= rulechar EOF
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
    // InternalRosParser.g:5607:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5613:2: ( ( () otherlv_1= Char ) )
            // InternalRosParser.g:5614:2: ( () otherlv_1= Char )
            {
            // InternalRosParser.g:5614:2: ( () otherlv_1= Char )
            // InternalRosParser.g:5615:3: () otherlv_1= Char
            {
            // InternalRosParser.g:5615:3: ()
            // InternalRosParser.g:5616:4: 
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
    // InternalRosParser.g:5630:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRosParser.g:5630:45: (iv_rulebyte= rulebyte EOF )
            // InternalRosParser.g:5631:2: iv_rulebyte= rulebyte EOF
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
    // InternalRosParser.g:5637:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5643:2: ( ( () otherlv_1= Byte ) )
            // InternalRosParser.g:5644:2: ( () otherlv_1= Byte )
            {
            // InternalRosParser.g:5644:2: ( () otherlv_1= Byte )
            // InternalRosParser.g:5645:3: () otherlv_1= Byte
            {
            // InternalRosParser.g:5645:3: ()
            // InternalRosParser.g:5646:4: 
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
    // InternalRosParser.g:5660:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRosParser.g:5660:45: (iv_ruletime= ruletime EOF )
            // InternalRosParser.g:5661:2: iv_ruletime= ruletime EOF
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
    // InternalRosParser.g:5667:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5673:2: ( ( () otherlv_1= Time ) )
            // InternalRosParser.g:5674:2: ( () otherlv_1= Time )
            {
            // InternalRosParser.g:5674:2: ( () otherlv_1= Time )
            // InternalRosParser.g:5675:3: () otherlv_1= Time
            {
            // InternalRosParser.g:5675:3: ()
            // InternalRosParser.g:5676:4: 
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
    // InternalRosParser.g:5690:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRosParser.g:5690:49: (iv_ruleduration= ruleduration EOF )
            // InternalRosParser.g:5691:2: iv_ruleduration= ruleduration EOF
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
    // InternalRosParser.g:5697:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5703:2: ( ( () otherlv_1= Duration ) )
            // InternalRosParser.g:5704:2: ( () otherlv_1= Duration )
            {
            // InternalRosParser.g:5704:2: ( () otherlv_1= Duration )
            // InternalRosParser.g:5705:3: () otherlv_1= Duration
            {
            // InternalRosParser.g:5705:3: ()
            // InternalRosParser.g:5706:4: 
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
    // InternalRosParser.g:5720:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRosParser.g:5720:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRosParser.g:5721:2: iv_ruleboolArray= ruleboolArray EOF
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
    // InternalRosParser.g:5727:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5733:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRosParser.g:5734:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRosParser.g:5734:2: ( () otherlv_1= Bool_1 )
            // InternalRosParser.g:5735:3: () otherlv_1= Bool_1
            {
            // InternalRosParser.g:5735:3: ()
            // InternalRosParser.g:5736:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBoolArrayAccess().getBoolArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Bool_1,FOLLOW_2); 

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
    // InternalRosParser.g:5750:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRosParser.g:5750:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRosParser.g:5751:2: iv_ruleint8Array= ruleint8Array EOF
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
    // InternalRosParser.g:5757:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5763:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRosParser.g:5764:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRosParser.g:5764:2: ( () otherlv_1= Int8_1 )
            // InternalRosParser.g:5765:3: () otherlv_1= Int8_1
            {
            // InternalRosParser.g:5765:3: ()
            // InternalRosParser.g:5766:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt8ArrayAccess().getInt8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int8_1,FOLLOW_2); 

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
    // InternalRosParser.g:5780:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRosParser.g:5780:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRosParser.g:5781:2: iv_ruleuint8Array= ruleuint8Array EOF
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
    // InternalRosParser.g:5787:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5793:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRosParser.g:5794:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRosParser.g:5794:2: ( () otherlv_1= Uint8_1 )
            // InternalRosParser.g:5795:3: () otherlv_1= Uint8_1
            {
            // InternalRosParser.g:5795:3: ()
            // InternalRosParser.g:5796:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint8ArrayAccess().getUint8ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint8_1,FOLLOW_2); 

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
    // InternalRosParser.g:5810:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRosParser.g:5810:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRosParser.g:5811:2: iv_ruleint16Array= ruleint16Array EOF
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
    // InternalRosParser.g:5817:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5823:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRosParser.g:5824:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRosParser.g:5824:2: ( () otherlv_1= Int16_1 )
            // InternalRosParser.g:5825:3: () otherlv_1= Int16_1
            {
            // InternalRosParser.g:5825:3: ()
            // InternalRosParser.g:5826:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt16ArrayAccess().getInt16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int16_1,FOLLOW_2); 

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
    // InternalRosParser.g:5840:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRosParser.g:5840:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRosParser.g:5841:2: iv_ruleuint16Array= ruleuint16Array EOF
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
    // InternalRosParser.g:5847:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5853:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRosParser.g:5854:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRosParser.g:5854:2: ( () otherlv_1= Uint16_1 )
            // InternalRosParser.g:5855:3: () otherlv_1= Uint16_1
            {
            // InternalRosParser.g:5855:3: ()
            // InternalRosParser.g:5856:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint16ArrayAccess().getUint16ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint16_1,FOLLOW_2); 

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
    // InternalRosParser.g:5870:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRosParser.g:5870:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRosParser.g:5871:2: iv_ruleint32Array= ruleint32Array EOF
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
    // InternalRosParser.g:5877:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5883:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRosParser.g:5884:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRosParser.g:5884:2: ( () otherlv_1= Int32_1 )
            // InternalRosParser.g:5885:3: () otherlv_1= Int32_1
            {
            // InternalRosParser.g:5885:3: ()
            // InternalRosParser.g:5886:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt32ArrayAccess().getInt32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int32_1,FOLLOW_2); 

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
    // InternalRosParser.g:5900:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRosParser.g:5900:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRosParser.g:5901:2: iv_ruleuint32Array= ruleuint32Array EOF
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
    // InternalRosParser.g:5907:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5913:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRosParser.g:5914:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRosParser.g:5914:2: ( () otherlv_1= Uint32_1 )
            // InternalRosParser.g:5915:3: () otherlv_1= Uint32_1
            {
            // InternalRosParser.g:5915:3: ()
            // InternalRosParser.g:5916:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint32ArrayAccess().getUint32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint32_1,FOLLOW_2); 

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
    // InternalRosParser.g:5930:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRosParser.g:5930:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRosParser.g:5931:2: iv_ruleint64Array= ruleint64Array EOF
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
    // InternalRosParser.g:5937:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5943:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRosParser.g:5944:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRosParser.g:5944:2: ( () otherlv_1= Int64_1 )
            // InternalRosParser.g:5945:3: () otherlv_1= Int64_1
            {
            // InternalRosParser.g:5945:3: ()
            // InternalRosParser.g:5946:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInt64ArrayAccess().getInt64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Int64_1,FOLLOW_2); 

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
    // InternalRosParser.g:5960:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRosParser.g:5960:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRosParser.g:5961:2: iv_ruleuint64Array= ruleuint64Array EOF
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
    // InternalRosParser.g:5967:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:5973:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRosParser.g:5974:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRosParser.g:5974:2: ( () otherlv_1= Uint64_1 )
            // InternalRosParser.g:5975:3: () otherlv_1= Uint64_1
            {
            // InternalRosParser.g:5975:3: ()
            // InternalRosParser.g:5976:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUint64ArrayAccess().getUint64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Uint64_1,FOLLOW_2); 

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
    // InternalRosParser.g:5990:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRosParser.g:5990:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRosParser.g:5991:2: iv_rulefloat32Array= rulefloat32Array EOF
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
    // InternalRosParser.g:5997:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6003:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRosParser.g:6004:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRosParser.g:6004:2: ( () otherlv_1= Float32_1 )
            // InternalRosParser.g:6005:3: () otherlv_1= Float32_1
            {
            // InternalRosParser.g:6005:3: ()
            // InternalRosParser.g:6006:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat32ArrayAccess().getFloat32ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float32_1,FOLLOW_2); 

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
    // InternalRosParser.g:6020:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRosParser.g:6020:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRosParser.g:6021:2: iv_rulefloat64Array= rulefloat64Array EOF
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
    // InternalRosParser.g:6027:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6033:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRosParser.g:6034:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRosParser.g:6034:2: ( () otherlv_1= Float64_1 )
            // InternalRosParser.g:6035:3: () otherlv_1= Float64_1
            {
            // InternalRosParser.g:6035:3: ()
            // InternalRosParser.g:6036:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloat64ArrayAccess().getFloat64ArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Float64_1,FOLLOW_2); 

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
    // InternalRosParser.g:6050:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRosParser.g:6050:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRosParser.g:6051:2: iv_rulestring0Array= rulestring0Array EOF
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
    // InternalRosParser.g:6057:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6063:2: ( ( () otherlv_1= String_2 ) )
            // InternalRosParser.g:6064:2: ( () otherlv_1= String_2 )
            {
            // InternalRosParser.g:6064:2: ( () otherlv_1= String_2 )
            // InternalRosParser.g:6065:3: () otherlv_1= String_2
            {
            // InternalRosParser.g:6065:3: ()
            // InternalRosParser.g:6066:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getString0ArrayAccess().getStringArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String_2,FOLLOW_2); 

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
    // InternalRosParser.g:6080:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRosParser.g:6080:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRosParser.g:6081:2: iv_rulebyteArray= rulebyteArray EOF
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
    // InternalRosParser.g:6087:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6093:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRosParser.g:6094:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRosParser.g:6094:2: ( () otherlv_1= Byte_1 )
            // InternalRosParser.g:6095:3: () otherlv_1= Byte_1
            {
            // InternalRosParser.g:6095:3: ()
            // InternalRosParser.g:6096:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getByteArrayAccess().getByteArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Byte_1,FOLLOW_2); 

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
    // InternalRosParser.g:6110:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRosParser.g:6110:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRosParser.g:6111:2: iv_rulecharArray= rulecharArray EOF
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
    // InternalRosParser.g:6117:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6123:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRosParser.g:6124:2: ( () otherlv_1= Char_1 )
            {
            // InternalRosParser.g:6124:2: ( () otherlv_1= Char_1 )
            // InternalRosParser.g:6125:3: () otherlv_1= Char_1
            {
            // InternalRosParser.g:6125:3: ()
            // InternalRosParser.g:6126:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCharArrayAccess().getCharArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Char_1,FOLLOW_2); 

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
    // InternalRosParser.g:6140:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRosParser.g:6140:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRosParser.g:6141:2: iv_ruleHeader= ruleHeader EOF
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
    // InternalRosParser.g:6147:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6153:2: ( ( () otherlv_1= Header ) )
            // InternalRosParser.g:6154:2: ( () otherlv_1= Header )
            {
            // InternalRosParser.g:6154:2: ( () otherlv_1= Header )
            // InternalRosParser.g:6155:3: () otherlv_1= Header
            {
            // InternalRosParser.g:6155:3: ()
            // InternalRosParser.g:6156:4: 
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
    // InternalRosParser.g:6170:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRosParser.g:6170:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRosParser.g:6171:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
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
    // InternalRosParser.g:6177:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRosParser.g:6183:2: ( ( ( ruleEString ) ) )
            // InternalRosParser.g:6184:2: ( ( ruleEString ) )
            {
            // InternalRosParser.g:6184:2: ( ( ruleEString ) )
            // InternalRosParser.g:6185:3: ( ruleEString )
            {
            // InternalRosParser.g:6185:3: ( ruleEString )
            // InternalRosParser.g:6186:4: ruleEString
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
    // InternalRosParser.g:6203:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRosParser.g:6203:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRosParser.g:6204:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
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
    // InternalRosParser.g:6210:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:6216:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRosParser.g:6217:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRosParser.g:6217:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRosParser.g:6218:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRosParser.g:6218:3: ( ( ruleEString ) )
            // InternalRosParser.g:6219:4: ( ruleEString )
            {
            // InternalRosParser.g:6219:4: ( ruleEString )
            // InternalRosParser.g:6220:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArraySpecRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
            				
            pushFollow(FOLLOW_62);
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
    // InternalRosParser.g:6242:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRosParser.g:6242:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRosParser.g:6243:2: iv_ruleKEYWORD= ruleKEYWORD EOF
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
    // InternalRosParser.g:6249:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRosParser.g:6255:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRosParser.g:6256:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRosParser.g:6256:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt77=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt77=1;
                }
                break;
            case Message:
                {
                alt77=2;
                }
                break;
            case Result:
                {
                alt77=3;
                }
                break;
            case Feedback:
                {
                alt77=4;
                }
                break;
            case Name:
                {
                alt77=5;
                }
                break;
            case Value:
                {
                alt77=6;
                }
                break;
            case Service:
                {
                alt77=7;
                }
                break;
            case Type:
                {
                alt77=8;
                }
                break;
            case Action:
                {
                alt77=9;
                }
                break;
            case Duration:
                {
                alt77=10;
                }
                break;
            case Time:
                {
                alt77=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalRosParser.g:6257:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:6263:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:6269:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:6275:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:6281:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRosParser.g:6287:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRosParser.g:6293:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRosParser.g:6299:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRosParser.g:6305:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRosParser.g:6311:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRosParser.g:6317:3: kw= Time
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


    // $ANTLR start "entryRuleExtensionBlock"
    // InternalRosParser.g:6326:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRosParser.g:6326:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRosParser.g:6327:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
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
    // InternalRosParser.g:6333:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
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
            // InternalRosParser.g:6339:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRosParser.g:6340:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRosParser.g:6340:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRosParser.g:6341:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRosParser.g:6341:3: ()
            // InternalRosParser.g:6342:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_63); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
            		
            // InternalRosParser.g:6352:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRosParser.g:6353:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRosParser.g:6353:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRosParser.g:6354:5: lv_name_2_0= ruleExtensionBlockName
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

            otherlv_3=(Token)match(input,Colon,FOLLOW_64); 

            			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
            		
            // InternalRosParser.g:6375:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt82=3;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_BEGIN) ) {
                alt82=1;
            }
            else if ( (LA82_0==LeftCurlyBracket) ) {
                alt82=2;
            }
            switch (alt82) {
                case 1 :
                    // InternalRosParser.g:6376:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRosParser.g:6376:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRosParser.g:6377:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_65); 

                    					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                    				
                    // InternalRosParser.g:6381:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt78=0;
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( ((LA78_0>=Serviceclients && LA78_0<=Dependencies)||(LA78_0>=FromGitRepo && LA78_0<=Parameter)||(LA78_0>=Pluginlib && LA78_0<=Plugins)||(LA78_0>=Boolean && LA78_0<=Format)||(LA78_0>=Library && LA78_0<=Message)||LA78_0==Service||(LA78_0>=Base64 && LA78_0<=Action)||(LA78_0>=Result && LA78_0<=Node_1)||LA78_0==Srvs||(LA78_0>=Type_1 && LA78_0<=List)||(LA78_0>=Bool && LA78_0<=Node)||(LA78_0>=Time && LA78_0<=Ns)||(LA78_0>=RULE_ID && LA78_0<=RULE_STRING)) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalRosParser.g:6382:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosParser.g:6382:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRosParser.g:6383:7: lv_entries_5_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_66);
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
                    	    if ( cnt78 >= 1 ) break loop78;
                                EarlyExitException eee =
                                    new EarlyExitException(78, input);
                                throw eee;
                        }
                        cnt78++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:6406:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRosParser.g:6406:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRosParser.g:6407:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_67); 

                    					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                    				
                    // InternalRosParser.g:6411:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( ((LA81_0>=Serviceclients && LA81_0<=Dependencies)||(LA81_0>=FromGitRepo && LA81_0<=Parameter)||(LA81_0>=Pluginlib && LA81_0<=Plugins)||(LA81_0>=Boolean && LA81_0<=Format)||(LA81_0>=Library && LA81_0<=Message)||LA81_0==Service||(LA81_0>=Base64 && LA81_0<=Action)||(LA81_0>=Result && LA81_0<=Node_1)||LA81_0==Srvs||(LA81_0>=Type_1 && LA81_0<=List)||(LA81_0>=Bool && LA81_0<=Node)||(LA81_0>=Time && LA81_0<=Ns)||(LA81_0>=RULE_ID && LA81_0<=RULE_STRING)) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // InternalRosParser.g:6412:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRosParser.g:6412:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRosParser.g:6413:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRosParser.g:6413:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRosParser.g:6414:8: lv_entries_8_0= ruleExtensionEntry
                            {

                            								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_68);
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

                            // InternalRosParser.g:6431:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop80:
                            do {
                                int alt80=2;
                                int LA80_0 = input.LA(1);

                                if ( ((LA80_0>=Serviceclients && LA80_0<=Dependencies)||(LA80_0>=FromGitRepo && LA80_0<=Parameter)||(LA80_0>=Pluginlib && LA80_0<=Plugins)||(LA80_0>=Boolean && LA80_0<=Format)||(LA80_0>=Library && LA80_0<=Message)||LA80_0==Service||(LA80_0>=Base64 && LA80_0<=Action)||(LA80_0>=Result && LA80_0<=Node_1)||LA80_0==Srvs||(LA80_0>=Type_1 && LA80_0<=List)||(LA80_0>=Bool && LA80_0<=Node)||(LA80_0>=Time && LA80_0<=Ns)||LA80_0==Comma||(LA80_0>=RULE_ID && LA80_0<=RULE_STRING)) ) {
                                    alt80=1;
                                }


                                switch (alt80) {
                            	case 1 :
                            	    // InternalRosParser.g:6432:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRosParser.g:6432:7: (otherlv_9= Comma )?
                            	    int alt79=2;
                            	    int LA79_0 = input.LA(1);

                            	    if ( (LA79_0==Comma) ) {
                            	        alt79=1;
                            	    }
                            	    switch (alt79) {
                            	        case 1 :
                            	            // InternalRosParser.g:6433:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_65); 

                            	            								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalRosParser.g:6438:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRosParser.g:6439:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRosParser.g:6439:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRosParser.g:6440:9: lv_entries_10_0= ruleExtensionEntry
                            	    {

                            	    									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_68);
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
                            	    break loop80;
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
    // InternalRosParser.g:6469:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRosParser.g:6469:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRosParser.g:6470:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
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
    // InternalRosParser.g:6476:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRosParser.g:6482:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRosParser.g:6483:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRosParser.g:6483:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRosParser.g:6484:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_69); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRosParser.g:6491:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==FullStop) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // InternalRosParser.g:6492:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_63); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_69); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop83;
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
    // InternalRosParser.g:6509:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRosParser.g:6509:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRosParser.g:6510:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
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
    // InternalRosParser.g:6516:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:6522:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) )
            // InternalRosParser.g:6523:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            {
            // InternalRosParser.g:6523:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            // InternalRosParser.g:6524:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) )
            {
            // InternalRosParser.g:6524:3: ()
            // InternalRosParser.g:6525:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:6531:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==Pluginlib||(LA84_0>=Duration && LA84_0<=Feedback)||(LA84_0>=Boolean && LA84_0<=Float64)||LA84_0==Library||LA84_0==Message||LA84_0==Service||(LA84_0>=Base64 && LA84_0<=Action)||(LA84_0>=Result && LA84_0<=Uint64)||LA84_0==Array||(LA84_0>=Class && LA84_0<=Int64)||(LA84_0>=Uint8 && LA84_0<=List)||(LA84_0>=Bool && LA84_0<=Node)||(LA84_0>=Time && LA84_0<=Any)||(LA84_0>=RULE_ID && LA84_0<=RULE_STRING)) ) {
                alt84=1;
            }
            else if ( ((LA84_0>=Serviceclients && LA84_0<=Dependencies)||(LA84_0>=FromGitRepo && LA84_0<=Parameter)||(LA84_0>=Actions && LA84_0<=Default)||LA84_0==Plugins||LA84_0==Format||LA84_0==Loader||LA84_0==Value_1||LA84_0==Base||(LA84_0>=Msgs && LA84_0<=Node_1)||LA84_0==Srvs||LA84_0==Type_1||LA84_0==Ns) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // InternalRosParser.g:6532:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRosParser.g:6532:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRosParser.g:6533:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRosParser.g:6533:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRosParser.g:6534:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRosParser.g:6534:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRosParser.g:6535:7: lv_key_1_0= ruleExtensionKey
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_70); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:6558:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRosParser.g:6558:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRosParser.g:6559:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRosParser.g:6559:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRosParser.g:6560:6: lv_key_3_0= ruleExtensionColonKey
                    {

                    						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_70);
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

            }

            // InternalRosParser.g:6578:3: ( (lv_value_4_0= ruleExtensionValue ) )
            // InternalRosParser.g:6579:4: (lv_value_4_0= ruleExtensionValue )
            {
            // InternalRosParser.g:6579:4: (lv_value_4_0= ruleExtensionValue )
            // InternalRosParser.g:6580:5: lv_value_4_0= ruleExtensionValue
            {

            					newCompositeNode(grammarAccess.getExtensionEntryAccess().getValueExtensionValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleExtensionValue();

            state._fsp--;


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
    // InternalRosParser.g:6601:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRosParser.g:6601:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRosParser.g:6602:2: iv_ruleExtensionValue= ruleExtensionValue EOF
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
    // InternalRosParser.g:6608:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRosParser.g:6614:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRosParser.g:6615:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRosParser.g:6615:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt85=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt85=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt85=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt85=3;
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
                alt85=4;
                }
                break;
            case Pluginlib:
            case Duration:
            case External:
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
                alt85=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalRosParser.g:6616:3: this_ExtensionListValue_0= ruleExtensionListValue
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
                    // InternalRosParser.g:6625:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
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
                    // InternalRosParser.g:6634:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
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
                    // InternalRosParser.g:6643:3: this_ExtensionRefValue_3= ruleExtensionRefValue
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
                    // InternalRosParser.g:6652:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
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
    // InternalRosParser.g:6664:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRosParser.g:6664:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRosParser.g:6665:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
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
    // InternalRosParser.g:6671:1: ruleExtensionListValue returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleExtensionListValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_items_2_0 = null;

        EObject lv_items_4_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:6677:2: ( ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) )
            // InternalRosParser.g:6678:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            {
            // InternalRosParser.g:6678:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            // InternalRosParser.g:6679:3: () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket
            {
            // InternalRosParser.g:6679:3: ()
            // InternalRosParser.g:6680:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_71); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRosParser.g:6690:3: ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==Pluginlib||(LA88_0>=Duration && LA88_0<=Feedback)||(LA88_0>=Boolean && LA88_0<=Float64)||LA88_0==Library||(LA88_0>=Message && LA88_0<=Param)||LA88_0==Service||(LA88_0>=Base64 && LA88_0<=Action)||(LA88_0>=Result && LA88_0<=Uint64)||LA88_0==Array||(LA88_0>=Class && LA88_0<=Int64)||LA88_0==Pub||LA88_0==Sub||(LA88_0>=Uint8 && LA88_0<=Any)||LA88_0==LeftSquareBracket||LA88_0==LeftCurlyBracket||(LA88_0>=RULE_BOOLEAN && LA88_0<=RULE_DOUBLE)||(LA88_0>=RULE_ID && LA88_0<=RULE_INT)||LA88_0==RULE_BEGIN) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalRosParser.g:6691:4: ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    {
                    // InternalRosParser.g:6691:4: ( (lv_items_2_0= ruleExtensionValue ) )
                    // InternalRosParser.g:6692:5: (lv_items_2_0= ruleExtensionValue )
                    {
                    // InternalRosParser.g:6692:5: (lv_items_2_0= ruleExtensionValue )
                    // InternalRosParser.g:6693:6: lv_items_2_0= ruleExtensionValue
                    {

                    						newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_72);
                    lv_items_2_0=ruleExtensionValue();

                    state._fsp--;


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

                    // InternalRosParser.g:6710:4: ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==Pluginlib||(LA87_0>=Duration && LA87_0<=Feedback)||(LA87_0>=Boolean && LA87_0<=Float64)||LA87_0==Library||(LA87_0>=Message && LA87_0<=Param)||LA87_0==Service||(LA87_0>=Base64 && LA87_0<=Action)||(LA87_0>=Result && LA87_0<=Uint64)||LA87_0==Array||(LA87_0>=Class && LA87_0<=Int64)||LA87_0==Pub||LA87_0==Sub||(LA87_0>=Uint8 && LA87_0<=Any)||LA87_0==Comma||LA87_0==LeftSquareBracket||LA87_0==LeftCurlyBracket||(LA87_0>=RULE_BOOLEAN && LA87_0<=RULE_DOUBLE)||(LA87_0>=RULE_ID && LA87_0<=RULE_INT)||LA87_0==RULE_BEGIN) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // InternalRosParser.g:6711:5: (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) )
                    	    {
                    	    // InternalRosParser.g:6711:5: (otherlv_3= Comma )?
                    	    int alt86=2;
                    	    int LA86_0 = input.LA(1);

                    	    if ( (LA86_0==Comma) ) {
                    	        alt86=1;
                    	    }
                    	    switch (alt86) {
                    	        case 1 :
                    	            // InternalRosParser.g:6712:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_70); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosParser.g:6717:5: ( (lv_items_4_0= ruleExtensionValue ) )
                    	    // InternalRosParser.g:6718:6: (lv_items_4_0= ruleExtensionValue )
                    	    {
                    	    // InternalRosParser.g:6718:6: (lv_items_4_0= ruleExtensionValue )
                    	    // InternalRosParser.g:6719:7: lv_items_4_0= ruleExtensionValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_72);
                    	    lv_items_4_0=ruleExtensionValue();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,RightSquareBracket,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getExtensionListValueAccess().getRightSquareBracketKeyword_3());
            		

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
    // InternalRosParser.g:6746:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRosParser.g:6746:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRosParser.g:6747:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
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
    // InternalRosParser.g:6753:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:6759:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRosParser.g:6760:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRosParser.g:6760:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRosParser.g:6761:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRosParser.g:6761:3: ()
            // InternalRosParser.g:6762:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_67); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRosParser.g:6772:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( ((LA91_0>=Serviceclients && LA91_0<=Dependencies)||(LA91_0>=FromGitRepo && LA91_0<=Parameter)||(LA91_0>=Pluginlib && LA91_0<=Plugins)||(LA91_0>=Boolean && LA91_0<=Format)||(LA91_0>=Library && LA91_0<=Message)||LA91_0==Service||(LA91_0>=Base64 && LA91_0<=Action)||(LA91_0>=Result && LA91_0<=Node_1)||LA91_0==Srvs||(LA91_0>=Type_1 && LA91_0<=List)||(LA91_0>=Bool && LA91_0<=Node)||(LA91_0>=Time && LA91_0<=Ns)||(LA91_0>=RULE_ID && LA91_0<=RULE_STRING)) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalRosParser.g:6773:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRosParser.g:6773:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRosParser.g:6774:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRosParser.g:6774:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRosParser.g:6775:6: lv_entries_2_0= ruleExtensionEntry
                    {

                    						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_68);
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

                    // InternalRosParser.g:6792:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( ((LA90_0>=Serviceclients && LA90_0<=Dependencies)||(LA90_0>=FromGitRepo && LA90_0<=Parameter)||(LA90_0>=Pluginlib && LA90_0<=Plugins)||(LA90_0>=Boolean && LA90_0<=Format)||(LA90_0>=Library && LA90_0<=Message)||LA90_0==Service||(LA90_0>=Base64 && LA90_0<=Action)||(LA90_0>=Result && LA90_0<=Node_1)||LA90_0==Srvs||(LA90_0>=Type_1 && LA90_0<=List)||(LA90_0>=Bool && LA90_0<=Node)||(LA90_0>=Time && LA90_0<=Ns)||LA90_0==Comma||(LA90_0>=RULE_ID && LA90_0<=RULE_STRING)) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // InternalRosParser.g:6793:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRosParser.g:6793:5: (otherlv_3= Comma )?
                    	    int alt89=2;
                    	    int LA89_0 = input.LA(1);

                    	    if ( (LA89_0==Comma) ) {
                    	        alt89=1;
                    	    }
                    	    switch (alt89) {
                    	        case 1 :
                    	            // InternalRosParser.g:6794:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_65); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRosParser.g:6799:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRosParser.g:6800:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRosParser.g:6800:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRosParser.g:6801:7: lv_entries_4_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_68);
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
                    	    break loop90;
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
    // InternalRosParser.g:6828:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRosParser.g:6828:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRosParser.g:6829:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
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
    // InternalRosParser.g:6835:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:6841:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRosParser.g:6842:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRosParser.g:6842:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRosParser.g:6843:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRosParser.g:6843:3: ()
            // InternalRosParser.g:6844:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_65); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalRosParser.g:6854:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( ((LA92_0>=Serviceclients && LA92_0<=Dependencies)||(LA92_0>=FromGitRepo && LA92_0<=Parameter)||(LA92_0>=Pluginlib && LA92_0<=Plugins)||(LA92_0>=Boolean && LA92_0<=Format)||(LA92_0>=Library && LA92_0<=Message)||LA92_0==Service||(LA92_0>=Base64 && LA92_0<=Action)||(LA92_0>=Result && LA92_0<=Node_1)||LA92_0==Srvs||(LA92_0>=Type_1 && LA92_0<=List)||(LA92_0>=Bool && LA92_0<=Node)||(LA92_0>=Time && LA92_0<=Ns)||(LA92_0>=RULE_ID && LA92_0<=RULE_STRING)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // InternalRosParser.g:6855:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRosParser.g:6855:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRosParser.g:6856:5: lv_entries_2_0= ruleExtensionEntry
            	    {

            	    					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_66);
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
            	    if ( cnt92 >= 1 ) break loop92;
                        EarlyExitException eee =
                            new EarlyExitException(92, input);
                        throw eee;
                }
                cnt92++;
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
    // InternalRosParser.g:6881:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRosParser.g:6881:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRosParser.g:6882:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
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
    // InternalRosParser.g:6888:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
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
            // InternalRosParser.g:6894:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRosParser.g:6895:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRosParser.g:6895:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRosParser.g:6896:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRosParser.g:6896:3: ()
            // InternalRosParser.g:6897:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:6903:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRosParser.g:6904:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRosParser.g:6904:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRosParser.g:6905:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRosParser.g:6905:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt93=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt93=1;
                }
                break;
            case Sub:
                {
                alt93=2;
                }
                break;
            case Ss:
                {
                alt93=3;
                }
                break;
            case Sc:
                {
                alt93=4;
                }
                break;
            case As:
                {
                alt93=5;
                }
                break;
            case Ac:
                {
                alt93=6;
                }
                break;
            case Param:
                {
                alt93=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalRosParser.g:6906:6: lv_refKind_1_1= Pub
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
                    // InternalRosParser.g:6917:6: lv_refKind_1_2= Sub
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
                    // InternalRosParser.g:6928:6: lv_refKind_1_3= Ss
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
                    // InternalRosParser.g:6939:6: lv_refKind_1_4= Sc
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
                    // InternalRosParser.g:6950:6: lv_refKind_1_5= As
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
                    // InternalRosParser.g:6961:6: lv_refKind_1_6= Ac
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
                    // InternalRosParser.g:6972:6: lv_refKind_1_7= Param
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

            // InternalRosParser.g:6985:3: ( ( ruleEString ) )
            // InternalRosParser.g:6986:4: ( ruleEString )
            {
            // InternalRosParser.g:6986:4: ( ruleEString )
            // InternalRosParser.g:6987:5: ruleEString
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
    // InternalRosParser.g:7005:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRosParser.g:7005:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRosParser.g:7006:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
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
    // InternalRosParser.g:7012:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRosParser.g:7018:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRosParser.g:7019:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRosParser.g:7019:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRosParser.g:7020:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRosParser.g:7020:3: ()
            // InternalRosParser.g:7021:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
            					current);
            			

            }

            // InternalRosParser.g:7027:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRosParser.g:7028:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRosParser.g:7028:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRosParser.g:7029:5: lv_value_1_0= ruleExtensionScalarLiteral
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
    // InternalRosParser.g:7050:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRosParser.g:7050:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRosParser.g:7051:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
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
    // InternalRosParser.g:7057:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRosParser.g:7063:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRosParser.g:7064:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRosParser.g:7064:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt94=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt94=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt94=2;
                }
                break;
            case RULE_DECINT:
                {
                alt94=3;
                }
                break;
            case RULE_INT:
                {
                alt94=4;
                }
                break;
            case Pluginlib:
            case Duration:
            case External:
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
                alt94=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // InternalRosParser.g:7065:3: this_BOOLEAN_0= RULE_BOOLEAN
                    {
                    this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    			current.merge(this_BOOLEAN_0);
                    		

                    			newLeafNode(this_BOOLEAN_0, grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7073:3: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_1);
                    		

                    			newLeafNode(this_DOUBLE_1, grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRosParser.g:7081:3: this_DECINT_2= RULE_DECINT
                    {
                    this_DECINT_2=(Token)match(input,RULE_DECINT,FOLLOW_2); 

                    			current.merge(this_DECINT_2);
                    		

                    			newLeafNode(this_DECINT_2, grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRosParser.g:7089:3: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_3);
                    		

                    			newLeafNode(this_INT_3, grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRosParser.g:7097:3: this_ExtensionKey_4= ruleExtensionKey
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


    // $ANTLR start "rulePluginLoader"
    // InternalRosParser.g:7111:1: rulePluginLoader returns [Enumerator current=null] : ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) ) ;
    public final Enumerator rulePluginLoader() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7117:2: ( ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) ) )
            // InternalRosParser.g:7118:2: ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) )
            {
            // InternalRosParser.g:7118:2: ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==Pluginlib) ) {
                alt95=1;
            }
            else if ( (LA95_0==External) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalRosParser.g:7119:3: (enumLiteral_0= Pluginlib )
                    {
                    // InternalRosParser.g:7119:3: (enumLiteral_0= Pluginlib )
                    // InternalRosParser.g:7120:4: enumLiteral_0= Pluginlib
                    {
                    enumLiteral_0=(Token)match(input,Pluginlib,FOLLOW_2); 

                    				current = grammarAccess.getPluginLoaderAccess().getPLUGINLIBEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPluginLoaderAccess().getPLUGINLIBEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7127:3: (enumLiteral_1= External )
                    {
                    // InternalRosParser.g:7127:3: (enumLiteral_1= External )
                    // InternalRosParser.g:7128:4: enumLiteral_1= External
                    {
                    enumLiteral_1=(Token)match(input,External,FOLLOW_2); 

                    				current = grammarAccess.getPluginLoaderAccess().getEXTERNALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPluginLoaderAccess().getEXTERNALEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "rulePluginLoader"


    // $ANTLR start "rulePluginSlotValueFormat"
    // InternalRosParser.g:7138:1: rulePluginSlotValueFormat returns [Enumerator current=null] : ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) ;
    public final Enumerator rulePluginSlotValueFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRosParser.g:7144:2: ( ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) )
            // InternalRosParser.g:7145:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            {
            // InternalRosParser.g:7145:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==Class) ) {
                alt96=1;
            }
            else if ( (LA96_0==Library) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // InternalRosParser.g:7146:3: (enumLiteral_0= Class )
                    {
                    // InternalRosParser.g:7146:3: (enumLiteral_0= Class )
                    // InternalRosParser.g:7147:4: enumLiteral_0= Class
                    {
                    enumLiteral_0=(Token)match(input,Class,FOLLOW_2); 

                    				current = grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRosParser.g:7154:3: (enumLiteral_1= Library )
                    {
                    // InternalRosParser.g:7154:3: (enumLiteral_1= Library )
                    // InternalRosParser.g:7155:4: enumLiteral_1= Library
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


    protected DFA62 dfa62 = new DFA62(this);
    protected DFA76 dfa76 = new DFA76(this);
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\1\14\6\15\10\uffff";
    static final String dfa_3s = "\7\30\4\uffff\1\30\3\uffff";
    static final String dfa_4s = "\7\173\4\uffff\1\172\3\uffff";
    static final String dfa_5s = "\7\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_6s = "\17\uffff}>";
    static final String[] dfa_7s = {
            "\1\3\3\uffff\1\4\17\uffff\1\6\30\uffff\1\5\35\uffff\1\14\3\uffff\1\13\1\14\3\uffff\1\7\1\12\1\10\1\11\6\uffff\1\2\1\1\3\uffff\1\14",
            "\1\15\3\uffff\1\15\17\uffff\1\15\30\uffff\1\15\35\uffff\1\15\1\uffff\1\14\2\uffff\1\15\15\uffff\2\15\3\uffff\1\15",
            "\1\15\3\uffff\1\15\17\uffff\1\15\30\uffff\1\15\35\uffff\1\15\1\uffff\1\14\2\uffff\1\15\15\uffff\2\15\3\uffff\1\15",
            "\1\15\3\uffff\1\15\17\uffff\1\15\30\uffff\1\15\35\uffff\1\15\1\uffff\1\14\2\uffff\1\15\15\uffff\2\15\3\uffff\1\15",
            "\1\15\3\uffff\1\15\17\uffff\1\15\30\uffff\1\15\35\uffff\1\15\1\uffff\1\14\2\uffff\1\15\15\uffff\2\15\3\uffff\1\15",
            "\1\15\3\uffff\1\15\17\uffff\1\15\30\uffff\1\15\35\uffff\1\15\1\uffff\1\14\2\uffff\1\15\15\uffff\2\15\3\uffff\1\15",
            "\1\15\3\uffff\1\15\17\uffff\1\15\30\uffff\1\15\35\uffff\1\15\1\uffff\1\14\2\uffff\1\15\15\uffff\2\15\3\uffff\1\15",
            "",
            "",
            "",
            "",
            "\1\16\3\uffff\1\16\17\uffff\1\16\30\uffff\1\16\35\uffff\1\16\3\uffff\2\16\3\uffff\4\16\6\uffff\2\16\2\uffff\1\14",
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

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3604:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_8s = "\50\uffff";
    static final String dfa_9s = "\36\uffff\6\47\4\uffff";
    static final String dfa_10s = "\1\26\35\uffff\6\30\4\uffff";
    static final String dfa_11s = "\1\167\35\uffff\6\171\4\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\6\uffff\1\40\1\41\1\37\1\36";
    static final String dfa_13s = "\50\uffff}>";
    static final String[] dfa_14s = {
            "\1\32\1\33\1\40\2\uffff\1\17\1\41\3\uffff\1\34\1\25\1\27\1\31\2\uffff\1\12\1\13\1\uffff\1\24\1\26\1\30\1\43\5\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\45\1\22\1\uffff\1\14\1\5\1\7\1\11\3\uffff\1\42\1\4\1\6\1\10\6\uffff\1\3\5\uffff\1\1\1\15\1\44\1\uffff\1\2\4\uffff\1\16\27\uffff\1\37\1\36",
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
            "\1\47\2\uffff\3\47\16\uffff\1\47\1\uffff\1\47\2\uffff\1\47\6\uffff\1\47\4\uffff\1\47\7\uffff\1\47\12\uffff\1\47\7\uffff\1\47\1\uffff\1\47\3\uffff\2\47\2\uffff\1\46\23\uffff\2\47\1\uffff\1\47",
            "\1\47\2\uffff\3\47\16\uffff\1\47\1\uffff\1\47\2\uffff\1\47\6\uffff\1\47\4\uffff\1\47\7\uffff\1\47\12\uffff\1\47\7\uffff\1\47\1\uffff\1\47\3\uffff\2\47\2\uffff\1\46\23\uffff\2\47\1\uffff\1\47",
            "\1\47\2\uffff\3\47\16\uffff\1\47\1\uffff\1\47\2\uffff\1\47\6\uffff\1\47\4\uffff\1\47\7\uffff\1\47\12\uffff\1\47\7\uffff\1\47\1\uffff\1\47\3\uffff\2\47\2\uffff\1\46\23\uffff\2\47\1\uffff\1\47",
            "\1\47\2\uffff\3\47\16\uffff\1\47\1\uffff\1\47\2\uffff\1\47\6\uffff\1\47\4\uffff\1\47\7\uffff\1\47\12\uffff\1\47\7\uffff\1\47\1\uffff\1\47\3\uffff\2\47\2\uffff\1\46\23\uffff\2\47\1\uffff\1\47",
            "\1\47\2\uffff\3\47\16\uffff\1\47\1\uffff\1\47\2\uffff\1\47\6\uffff\1\47\4\uffff\1\47\7\uffff\1\47\12\uffff\1\47\7\uffff\1\47\1\uffff\1\47\3\uffff\2\47\2\uffff\1\46\23\uffff\2\47\1\uffff\1\47",
            "\1\47\2\uffff\3\47\16\uffff\1\47\1\uffff\1\47\2\uffff\1\47\6\uffff\1\47\4\uffff\1\47\7\uffff\1\47\12\uffff\1\47\7\uffff\1\47\1\uffff\1\47\3\uffff\2\47\2\uffff\1\46\23\uffff\2\47\1\uffff\1\47",
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

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "4939:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000100011000002L,0x2040000008000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002005000L,0x0800000000001200L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000100011000000L,0x00C0000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002001000L,0x0800000000001200L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000100011000010L,0x00C0000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000010800000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002000000L,0x0800000000001200L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0060100011000000L,0x08C0000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000100011000000L,0x08C0000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0C00000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0xDE241ECF19C00000L,0x08C0000042E081E3L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x2000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xDE241ECF19C00002L,0x00C0000042E081E3L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00001000110D8F00L,0x2040004008000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000000000D8F02L,0x0000004000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x00002000000F8F00L,0x0800004000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0400020000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010004100000L,0x0000000000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010004100000L,0x0800000000000010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000100000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000100000L,0x0000000800000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000010004000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000004000000L,0x0000040800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0800000200000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000200004000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x00D8003000000000L,0x0000000000040008L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000004L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000100011000000L,0x00C0F08000000020L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000100011000000L,0x00C0010000000020L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x2102500039000000L,0x02C00000C5010020L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0400020000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0xE1FA71F07F1FDF00L,0x00C00003CFE7D7FFL});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0xE1FA71F07F1FDF00L,0x08C00003CFE7D7FFL});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0xE1FA71F07F1FDF00L,0x00C00403CFE7D7FFL});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0xE1FA71F07F1FDF00L,0x00C0040BCFE7D7FFL});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0xE1FAD0F039000000L,0x05C0E281FFFFA9EBL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xE1FAD0F039000000L,0x05C0E381FFFFA9EBL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0xE1FAD0F039000000L,0x05C0E389FFFFA9EBL});

}
