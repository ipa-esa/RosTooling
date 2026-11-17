package de.fraunhofer.ipa.ros1.parser.antlr.internal;

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
import de.fraunhofer.ipa.ros1.services.Ros1GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRos1Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ExternalDependency", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "Serviceclients", "Serviceservers", "Actionclients", "Actionservers", "Dependencies", "ParameterAny", "FromGitRepo", "Pluginslots", "Subscribers", "Implements", "Parameters", "Publishers", "Artifacts", "Parameter", "GraphName", "Float32_1", "Float64_1", "Pluginlib", "Actions", "Default", "Duration", "External", "Feedback", "Plugins", "Response", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Float32", "Float64", "Int16_1", "Int32_1", "Int64_1", "Loader", "Message", "Param", "Request", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Int8_1", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Base", "Int16", "Int32", "Int64", "Msgs", "Node_1", "Pub", "Srvs", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Float32_1=23;
    public static final int Node=89;
    public static final int RULE_DATE_TIME=115;
    public static final int Uint64_1=36;
    public static final int Serviceclients=8;
    public static final int Pluginlib=25;
    public static final int String=53;
    public static final int Int16=68;
    public static final int Float32=39;
    public static final int Goal=86;
    public static final int Actionservers=11;
    public static final int Bool=83;
    public static final int Msgs=71;
    public static final int Uint16=62;
    public static final int Boolean=37;
    public static final int ExternalDependency=4;
    public static final int Sub=75;
    public static final int Uint8=77;
    public static final int Parameters=18;
    public static final int RULE_ID=116;
    public static final int Actions=26;
    public static final int RULE_DIGIT=105;
    public static final int GlobalNamespace=7;
    public static final int Artifacts=20;
    public static final int Node_1=72;
    public static final int Int16_1=41;
    public static final int Header=52;
    public static final int RULE_INT=118;
    public static final int Byte=84;
    public static final int RULE_ML_COMMENT=125;
    public static final int LeftSquareBracket=101;
    public static final int Pluginslots=15;
    public static final int Ac=81;
    public static final int Base64=50;
    public static final int Comma=97;
    public static final int As=82;
    public static final int RULE_MESSAGE_ASIGMENT=119;
    public static final int LeftSquareBracketRightSquareBracket=96;
    public static final int Int32=69;
    public static final int Char=85;
    public static final int Publishers=19;
    public static final int Srvs=74;
    public static final int RightCurlyBracket=104;
    public static final int RULE_DECINT=108;
    public static final int Uint32=63;
    public static final int Plugins=31;
    public static final int FromGitRepo=14;
    public static final int FullStop=98;
    public static final int RULE_HOUR=113;
    public static final int Int8=87;
    public static final int Default=27;
    public static final int Int8_1=59;
    public static final int CommercialAt=100;
    public static final int Uint16_1=34;
    public static final int Sc=90;
    public static final int Type=93;
    public static final int Float64=40;
    public static final int Int32_1=42;
    public static final int Parameter=21;
    public static final int RULE_BINARY=106;
    public static final int String_1=61;
    public static final int Subscribers=16;
    public static final int String_2=33;
    public static final int Ss=91;
    public static final int Actionclients=10;
    public static final int RULE_DAY=110;
    public static final int RULE_BEGIN=120;
    public static final int RULE_BOOLEAN=107;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=9;
    public static final int RULE_YEAR=112;
    public static final int Result=60;
    public static final int Name=88;
    public static final int RULE_MIN_SEC=114;
    public static final int Implements=17;
    public static final int Char_1=58;
    public static final int ParameterAny=13;
    public static final int List=80;
    public static final int Dependencies=12;
    public static final int RightSquareBracket=102;
    public static final int PrivateNamespace=6;
    public static final int GraphName=22;
    public static final int Byte_1=57;
    public static final int Float64_1=24;
    public static final int Duration=28;
    public static final int Uint32_1=35;
    public static final int Double=51;
    public static final int External=29;
    public static final int Type_1=76;
    public static final int Value=78;
    public static final int Uint64=64;
    public static final int Action=55;
    public static final int RULE_END=121;
    public static final int Message=45;
    public static final int Value_1=65;
    public static final int Loader=44;
    public static final int Time=92;
    public static final int RULE_STRING=117;
    public static final int Bool_1=56;
    public static final int Any=94;
    public static final int Struct=54;
    public static final int RULE_SL_COMMENT=122;
    public static final int Uint8_1=49;
    public static final int RULE_DOUBLE=109;
    public static final int Feedback=30;
    public static final int RULE_ROS_CONVENTION_A=123;
    public static final int RULE_ROS_CONVENTION_PARAM=124;
    public static final int Colon=99;
    public static final int Pub=73;
    public static final int EOF=-1;
    public static final int Ns=95;
    public static final int RULE_WS=126;
    public static final int Int64_1=43;
    public static final int Request=47;
    public static final int LeftCurlyBracket=103;
    public static final int Service=48;
    public static final int RULE_ANY_OTHER=127;
    public static final int Base=67;
    public static final int Date=79;
    public static final int Response=32;
    public static final int Integer=38;
    public static final int Array=66;
    public static final int Int64=70;
    public static final int Param=46;
    public static final int RULE_MONTH=111;

    // delegates
    // delegators


        public InternalRos1Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRos1Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRos1Parser.tokenNames; }
    public String getGrammarFileName() { return "InternalRos1Parser.g"; }



     	private Ros1GrammarAccess grammarAccess;

        public InternalRos1Parser(TokenStream input, Ros1GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Package";
       	}

       	@Override
       	protected Ros1GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulePackage"
    // InternalRos1Parser.g:58:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // InternalRos1Parser.g:58:48: (iv_rulePackage= rulePackage EOF )
            // InternalRos1Parser.g:59:2: iv_rulePackage= rulePackage EOF
            {
             newCompositeNode(grammarAccess.getPackageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackage=rulePackage();

            state._fsp--;

             current =iv_rulePackage; 
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
    // $ANTLR end "entryRulePackage"


    // $ANTLR start "rulePackage"
    // InternalRos1Parser.g:65:1: rulePackage returns [EObject current=null] : this_CatkinPackage_0= ruleCatkinPackage ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        EObject this_CatkinPackage_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:71:2: (this_CatkinPackage_0= ruleCatkinPackage )
            // InternalRos1Parser.g:72:2: this_CatkinPackage_0= ruleCatkinPackage
            {

            		newCompositeNode(grammarAccess.getPackageAccess().getCatkinPackageParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_CatkinPackage_0=ruleCatkinPackage();

            state._fsp--;


            		current = this_CatkinPackage_0;
            		afterParserOrEnumRuleCall();
            	

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
    // $ANTLR end "rulePackage"


    // $ANTLR start "entryRuleCatkinPackage"
    // InternalRos1Parser.g:83:1: entryRuleCatkinPackage returns [EObject current=null] : iv_ruleCatkinPackage= ruleCatkinPackage EOF ;
    public final EObject entryRuleCatkinPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatkinPackage = null;


        try {
            // InternalRos1Parser.g:83:54: (iv_ruleCatkinPackage= ruleCatkinPackage EOF )
            // InternalRos1Parser.g:84:2: iv_ruleCatkinPackage= ruleCatkinPackage EOF
            {
             newCompositeNode(grammarAccess.getCatkinPackageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatkinPackage=ruleCatkinPackage();

            state._fsp--;

             current =iv_ruleCatkinPackage; 
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
    // $ANTLR end "entryRuleCatkinPackage"


    // $ANTLR start "ruleCatkinPackage"
    // InternalRos1Parser.g:90:1: ruleCatkinPackage returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END ) ;
    public final EObject ruleCatkinPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token this_BEGIN_7=null;
        Token this_END_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token this_END_16=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_fromGitRepo_5_0 = null;

        EObject lv_artifact_8_0 = null;

        EObject lv_dependency_12_0 = null;

        EObject lv_dependency_14_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:96:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END ) )
            // InternalRos1Parser.g:97:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END )
            {
            // InternalRos1Parser.g:97:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END )
            // InternalRos1Parser.g:98:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )? (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )? this_END_16= RULE_END
            {
            // InternalRos1Parser.g:98:3: ()
            // InternalRos1Parser.g:99:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCatkinPackageAccess().getCatkinPackageAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:105:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos1Parser.g:106:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos1Parser.g:106:4: (lv_name_1_0= ruleRosNames )
            // InternalRos1Parser.g:107:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getCatkinPackageAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Ros.RosNames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getCatkinPackageAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_5); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getCatkinPackageAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos1Parser.g:132:3: (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==FromGitRepo) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalRos1Parser.g:133:4: otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,FromGitRepo,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getCatkinPackageAccess().getFromGitRepoKeyword_4_0());
                    			
                    // InternalRos1Parser.g:137:4: ( (lv_fromGitRepo_5_0= ruleEString ) )
                    // InternalRos1Parser.g:138:5: (lv_fromGitRepo_5_0= ruleEString )
                    {
                    // InternalRos1Parser.g:138:5: (lv_fromGitRepo_5_0= ruleEString )
                    // InternalRos1Parser.g:139:6: lv_fromGitRepo_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getCatkinPackageAccess().getFromGitRepoEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_fromGitRepo_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
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

            // InternalRos1Parser.g:157:3: (otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Artifacts) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalRos1Parser.g:158:4: otherlv_6= Artifacts this_BEGIN_7= RULE_BEGIN ( (lv_artifact_8_0= ruleArtifact ) )* this_END_9= RULE_END
                    {
                    otherlv_6=(Token)match(input,Artifacts,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getCatkinPackageAccess().getArtifactsKeyword_5_0());
                    			
                    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

                    				newLeafNode(this_BEGIN_7, grammarAccess.getCatkinPackageAccess().getBEGINTerminalRuleCall_5_1());
                    			
                    // InternalRos1Parser.g:166:4: ( (lv_artifact_8_0= ruleArtifact ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==Pluginlib||LA2_0==External||LA2_0==Node||LA2_0==RULE_ID||LA2_0==RULE_ROS_CONVENTION_A) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalRos1Parser.g:167:5: (lv_artifact_8_0= ruleArtifact )
                    	    {
                    	    // InternalRos1Parser.g:167:5: (lv_artifact_8_0= ruleArtifact )
                    	    // InternalRos1Parser.g:168:6: lv_artifact_8_0= ruleArtifact
                    	    {

                    	    						newCompositeNode(grammarAccess.getCatkinPackageAccess().getArtifactArtifactParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_8);
                    	    lv_artifact_8_0=ruleArtifact();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"artifact",
                    	    							lv_artifact_8_0,
                    	    							"de.fraunhofer.ipa.ros.Ros.Artifact");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    this_END_9=(Token)match(input,RULE_END,FOLLOW_9); 

                    				newLeafNode(this_END_9, grammarAccess.getCatkinPackageAccess().getENDTerminalRuleCall_5_3());
                    			

                    }
                    break;

            }

            // InternalRos1Parser.g:190:3: (otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Dependencies) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalRos1Parser.g:191:4: otherlv_10= Dependencies otherlv_11= LeftSquareBracket ( (lv_dependency_12_0= ruleDependency ) ) (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )* otherlv_15= RightSquareBracket
                    {
                    otherlv_10=(Token)match(input,Dependencies,FOLLOW_10); 

                    				newLeafNode(otherlv_10, grammarAccess.getCatkinPackageAccess().getDependenciesKeyword_6_0());
                    			
                    otherlv_11=(Token)match(input,LeftSquareBracket,FOLLOW_11); 

                    				newLeafNode(otherlv_11, grammarAccess.getCatkinPackageAccess().getLeftSquareBracketKeyword_6_1());
                    			
                    // InternalRos1Parser.g:199:4: ( (lv_dependency_12_0= ruleDependency ) )
                    // InternalRos1Parser.g:200:5: (lv_dependency_12_0= ruleDependency )
                    {
                    // InternalRos1Parser.g:200:5: (lv_dependency_12_0= ruleDependency )
                    // InternalRos1Parser.g:201:6: lv_dependency_12_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getCatkinPackageAccess().getDependencyDependencyParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_dependency_12_0=ruleDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
                    						}
                    						add(
                    							current,
                    							"dependency",
                    							lv_dependency_12_0,
                    							"de.fraunhofer.ipa.ros.Ros.Dependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRos1Parser.g:218:4: (otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==Comma) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalRos1Parser.g:219:5: otherlv_13= Comma ( (lv_dependency_14_0= ruleDependency ) )
                    	    {
                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_11); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getCatkinPackageAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalRos1Parser.g:223:5: ( (lv_dependency_14_0= ruleDependency ) )
                    	    // InternalRos1Parser.g:224:6: (lv_dependency_14_0= ruleDependency )
                    	    {
                    	    // InternalRos1Parser.g:224:6: (lv_dependency_14_0= ruleDependency )
                    	    // InternalRos1Parser.g:225:7: lv_dependency_14_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getCatkinPackageAccess().getDependencyDependencyParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_dependency_14_0=ruleDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCatkinPackageRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"dependency",
                    	    								lv_dependency_14_0,
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

                    otherlv_15=(Token)match(input,RightSquareBracket,FOLLOW_13); 

                    				newLeafNode(otherlv_15, grammarAccess.getCatkinPackageAccess().getRightSquareBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            this_END_16=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_16, grammarAccess.getCatkinPackageAccess().getENDTerminalRuleCall_7());
            		

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
    // $ANTLR end "ruleCatkinPackage"


    // $ANTLR start "entryRulePackage_Impl"
    // InternalRos1Parser.g:256:1: entryRulePackage_Impl returns [EObject current=null] : iv_rulePackage_Impl= rulePackage_Impl EOF ;
    public final EObject entryRulePackage_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage_Impl = null;


        try {
            // InternalRos1Parser.g:256:53: (iv_rulePackage_Impl= rulePackage_Impl EOF )
            // InternalRos1Parser.g:257:2: iv_rulePackage_Impl= rulePackage_Impl EOF
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
    // InternalRos1Parser.g:263:1: rulePackage_Impl returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END ) ;
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
            // InternalRos1Parser.g:269:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END ) )
            // InternalRos1Parser.g:270:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END )
            {
            // InternalRos1Parser.g:270:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END )
            // InternalRos1Parser.g:271:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )? (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )? ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )* this_END_24= RULE_END
            {
            // InternalRos1Parser.g:271:3: ()
            // InternalRos1Parser.g:272:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPackage_ImplAccess().getPackageAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:278:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos1Parser.g:279:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos1Parser.g:279:4: (lv_name_1_0= ruleRosNames )
            // InternalRos1Parser.g:280:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getPackage_ImplAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPackage_ImplAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_14); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos1Parser.g:305:3: (otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==FromGitRepo) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalRos1Parser.g:306:4: otherlv_4= FromGitRepo ( (lv_fromGitRepo_5_0= ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,FromGitRepo,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getPackage_ImplAccess().getFromGitRepoKeyword_4_0());
                    			
                    // InternalRos1Parser.g:310:4: ( (lv_fromGitRepo_5_0= ruleEString ) )
                    // InternalRos1Parser.g:311:5: (lv_fromGitRepo_5_0= ruleEString )
                    {
                    // InternalRos1Parser.g:311:5: (lv_fromGitRepo_5_0= ruleEString )
                    // InternalRos1Parser.g:312:6: lv_fromGitRepo_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getFromGitRepoEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_15);
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

            // InternalRos1Parser.g:330:3: (otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Dependencies) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRos1Parser.g:331:4: otherlv_6= Dependencies otherlv_7= LeftSquareBracket ( (lv_dependency_8_0= ruleDependency ) ) (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Dependencies,FOLLOW_10); 

                    				newLeafNode(otherlv_6, grammarAccess.getPackage_ImplAccess().getDependenciesKeyword_5_0());
                    			
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getPackage_ImplAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalRos1Parser.g:339:4: ( (lv_dependency_8_0= ruleDependency ) )
                    // InternalRos1Parser.g:340:5: (lv_dependency_8_0= ruleDependency )
                    {
                    // InternalRos1Parser.g:340:5: (lv_dependency_8_0= ruleDependency )
                    // InternalRos1Parser.g:341:6: lv_dependency_8_0= ruleDependency
                    {

                    						newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_12);
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

                    // InternalRos1Parser.g:358:4: (otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==Comma) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalRos1Parser.g:359:5: otherlv_9= Comma ( (lv_dependency_10_0= ruleDependency ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_11); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getPackage_ImplAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalRos1Parser.g:363:5: ( (lv_dependency_10_0= ruleDependency ) )
                    	    // InternalRos1Parser.g:364:6: (lv_dependency_10_0= ruleDependency )
                    	    {
                    	    // InternalRos1Parser.g:364:6: (lv_dependency_10_0= ruleDependency )
                    	    // InternalRos1Parser.g:365:7: lv_dependency_10_0= ruleDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getDependencyDependencyParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
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
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_16); 

                    				newLeafNode(otherlv_11, grammarAccess.getPackage_ImplAccess().getRightSquareBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            // InternalRos1Parser.g:388:3: ( (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END ) | (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END ) | (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END ) )*
            loop12:
            do {
                int alt12=4;
                switch ( input.LA(1) ) {
                case Msgs:
                    {
                    alt12=1;
                    }
                    break;
                case Srvs:
                    {
                    alt12=2;
                    }
                    break;
                case Actions:
                    {
                    alt12=3;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // InternalRos1Parser.g:389:4: (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END )
            	    {
            	    // InternalRos1Parser.g:389:4: (otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END )
            	    // InternalRos1Parser.g:390:5: otherlv_12= Msgs this_BEGIN_13= RULE_BEGIN ( (lv_spec_14_0= ruleTopicSpec ) )* this_END_15= RULE_END
            	    {
            	    otherlv_12=(Token)match(input,Msgs,FOLLOW_4); 

            	    					newLeafNode(otherlv_12, grammarAccess.getPackage_ImplAccess().getMsgsKeyword_6_0_0());
            	    				
            	    this_BEGIN_13=(Token)match(input,RULE_BEGIN,FOLLOW_17); 

            	    					newLeafNode(this_BEGIN_13, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_0_1());
            	    				
            	    // InternalRos1Parser.g:398:5: ( (lv_spec_14_0= ruleTopicSpec ) )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==Pluginlib||LA9_0==External||(LA9_0>=Header && LA9_0<=String)||(LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:399:6: (lv_spec_14_0= ruleTopicSpec )
            	    	    {
            	    	    // InternalRos1Parser.g:399:6: (lv_spec_14_0= ruleTopicSpec )
            	    	    // InternalRos1Parser.g:400:7: lv_spec_14_0= ruleTopicSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecTopicSpecParserRuleCall_6_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_17);
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
            	    	    break loop9;
            	        }
            	    } while (true);

            	    this_END_15=(Token)match(input,RULE_END,FOLLOW_16); 

            	    					newLeafNode(this_END_15, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos1Parser.g:423:4: (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END )
            	    {
            	    // InternalRos1Parser.g:423:4: (otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END )
            	    // InternalRos1Parser.g:424:5: otherlv_16= Srvs this_BEGIN_17= RULE_BEGIN ( (lv_spec_18_0= ruleServiceSpec ) )* this_END_19= RULE_END
            	    {
            	    otherlv_16=(Token)match(input,Srvs,FOLLOW_4); 

            	    					newLeafNode(otherlv_16, grammarAccess.getPackage_ImplAccess().getSrvsKeyword_6_1_0());
            	    				
            	    this_BEGIN_17=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_17, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_1_1());
            	    				
            	    // InternalRos1Parser.g:432:5: ( (lv_spec_18_0= ruleServiceSpec ) )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==Pluginlib||LA10_0==External||(LA10_0>=RULE_ID && LA10_0<=RULE_STRING)) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:433:6: (lv_spec_18_0= ruleServiceSpec )
            	    	    {
            	    	    // InternalRos1Parser.g:433:6: (lv_spec_18_0= ruleServiceSpec )
            	    	    // InternalRos1Parser.g:434:7: lv_spec_18_0= ruleServiceSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecServiceSpecParserRuleCall_6_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop10;
            	        }
            	    } while (true);

            	    this_END_19=(Token)match(input,RULE_END,FOLLOW_16); 

            	    					newLeafNode(this_END_19, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos1Parser.g:457:4: (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END )
            	    {
            	    // InternalRos1Parser.g:457:4: (otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END )
            	    // InternalRos1Parser.g:458:5: otherlv_20= Actions this_BEGIN_21= RULE_BEGIN ( (lv_spec_22_0= ruleActionSpec ) )* this_END_23= RULE_END
            	    {
            	    otherlv_20=(Token)match(input,Actions,FOLLOW_4); 

            	    					newLeafNode(otherlv_20, grammarAccess.getPackage_ImplAccess().getActionsKeyword_6_2_0());
            	    				
            	    this_BEGIN_21=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_21, grammarAccess.getPackage_ImplAccess().getBEGINTerminalRuleCall_6_2_1());
            	    				
            	    // InternalRos1Parser.g:466:5: ( (lv_spec_22_0= ruleActionSpec ) )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==Pluginlib||LA11_0==External||(LA11_0>=RULE_ID && LA11_0<=RULE_STRING)) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:467:6: (lv_spec_22_0= ruleActionSpec )
            	    	    {
            	    	    // InternalRos1Parser.g:467:6: (lv_spec_22_0= ruleActionSpec )
            	    	    // InternalRos1Parser.g:468:7: lv_spec_22_0= ruleActionSpec
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPackage_ImplAccess().getSpecActionSpecParserRuleCall_6_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop11;
            	        }
            	    } while (true);

            	    this_END_23=(Token)match(input,RULE_END,FOLLOW_16); 

            	    					newLeafNode(this_END_23, grammarAccess.getPackage_ImplAccess().getENDTerminalRuleCall_6_2_3());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalRos1Parser.g:499:1: entryRuleTopicSpec returns [EObject current=null] : iv_ruleTopicSpec= ruleTopicSpec EOF ;
    public final EObject entryRuleTopicSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicSpec = null;


        try {
            // InternalRos1Parser.g:499:50: (iv_ruleTopicSpec= ruleTopicSpec EOF )
            // InternalRos1Parser.g:500:2: iv_ruleTopicSpec= ruleTopicSpec EOF
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
    // InternalRos1Parser.g:506:1: ruleTopicSpec returns [EObject current=null] : ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) ;
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
            // InternalRos1Parser.g:512:2: ( ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END ) )
            // InternalRos1Parser.g:513:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            {
            // InternalRos1Parser.g:513:2: ( () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END )
            // InternalRos1Parser.g:514:3: () ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Message (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? this_END_7= RULE_END
            {
            // InternalRos1Parser.g:514:3: ()
            // InternalRos1Parser.g:515:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTopicSpecAccess().getTopicSpecAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:521:3: ( ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) ) )
            // InternalRos1Parser.g:522:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            {
            // InternalRos1Parser.g:522:4: ( (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String ) )
            // InternalRos1Parser.g:523:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            {
            // InternalRos1Parser.g:523:5: (lv_name_1_1= ruleEString | lv_name_1_2= Header | lv_name_1_3= String )
            int alt13=3;
            switch ( input.LA(1) ) {
            case Pluginlib:
            case External:
            case RULE_ID:
            case RULE_STRING:
                {
                alt13=1;
                }
                break;
            case Header:
                {
                alt13=2;
                }
                break;
            case String:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalRos1Parser.g:524:6: lv_name_1_1= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getTopicSpecAccess().getNameEStringParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_4);
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
                    // InternalRos1Parser.g:540:6: lv_name_1_2= Header
                    {
                    lv_name_1_2=(Token)match(input,Header,FOLLOW_4); 

                    						newLeafNode(lv_name_1_2, grammarAccess.getTopicSpecAccess().getNameHeaderKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTopicSpecRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:551:6: lv_name_1_3= String
                    {
                    lv_name_1_3=(Token)match(input,String,FOLLOW_4); 

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

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_19); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Message,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getTopicSpecAccess().getMessageKeyword_3());
            		
            // InternalRos1Parser.g:572:3: (this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_BEGIN) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalRos1Parser.g:573:4: this_BEGIN_4= RULE_BEGIN ( (lv_message_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getTopicSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos1Parser.g:577:4: ( (lv_message_5_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:578:5: (lv_message_5_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:578:5: (lv_message_5_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:579:6: lv_message_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getTopicSpecAccess().getMessageMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_13); 

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
    // InternalRos1Parser.g:609:1: entryRuleServiceSpec returns [EObject current=null] : iv_ruleServiceSpec= ruleServiceSpec EOF ;
    public final EObject entryRuleServiceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceSpec = null;


        try {
            // InternalRos1Parser.g:609:52: (iv_ruleServiceSpec= ruleServiceSpec EOF )
            // InternalRos1Parser.g:610:2: iv_ruleServiceSpec= ruleServiceSpec EOF
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
    // InternalRos1Parser.g:616:1: ruleServiceSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) ;
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
            // InternalRos1Parser.g:622:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END ) )
            // InternalRos1Parser.g:623:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            {
            // InternalRos1Parser.g:623:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END )
            // InternalRos1Parser.g:624:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Request (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Response (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? this_END_11= RULE_END
            {
            // InternalRos1Parser.g:624:3: ()
            // InternalRos1Parser.g:625:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceSpecAccess().getServiceSpecAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:631:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:632:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:632:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:633:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceSpecAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_22); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Request,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getServiceSpecAccess().getRequestKeyword_3());
            		
            // InternalRos1Parser.g:658:3: (this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_BEGIN) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRos1Parser.g:659:4: this_BEGIN_4= RULE_BEGIN ( (lv_request_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos1Parser.g:663:4: ( (lv_request_5_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:664:5: (lv_request_5_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:664:5: (lv_request_5_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:665:6: lv_request_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getServiceSpecAccess().getRequestMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_24); 

                    				newLeafNode(this_END_6, grammarAccess.getServiceSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,Response,FOLLOW_20); 

            			newLeafNode(otherlv_7, grammarAccess.getServiceSpecAccess().getResponseKeyword_5());
            		
            // InternalRos1Parser.g:691:3: (this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_BEGIN) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalRos1Parser.g:692:4: this_BEGIN_8= RULE_BEGIN ( (lv_response_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getServiceSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRos1Parser.g:696:4: ( (lv_response_9_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:697:5: (lv_response_9_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:697:5: (lv_response_9_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:698:6: lv_response_9_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getServiceSpecAccess().getResponseMessageDefinitionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_13); 

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
    // InternalRos1Parser.g:728:1: entryRuleActionSpec returns [EObject current=null] : iv_ruleActionSpec= ruleActionSpec EOF ;
    public final EObject entryRuleActionSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSpec = null;


        try {
            // InternalRos1Parser.g:728:51: (iv_ruleActionSpec= ruleActionSpec EOF )
            // InternalRos1Parser.g:729:2: iv_ruleActionSpec= ruleActionSpec EOF
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
    // InternalRos1Parser.g:735:1: ruleActionSpec returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) ;
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
            // InternalRos1Parser.g:741:2: ( ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END ) )
            // InternalRos1Parser.g:742:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            {
            // InternalRos1Parser.g:742:2: ( () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END )
            // InternalRos1Parser.g:743:3: () ( (lv_name_1_0= ruleEString ) ) this_BEGIN_2= RULE_BEGIN otherlv_3= Goal (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )? otherlv_7= Result (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )? otherlv_11= Feedback (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )? this_END_15= RULE_END
            {
            // InternalRos1Parser.g:743:3: ()
            // InternalRos1Parser.g:744:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionSpecAccess().getActionSpecAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:750:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:751:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:751:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:752:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionSpecAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_25); 

            			newLeafNode(this_BEGIN_2, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,Goal,FOLLOW_26); 

            			newLeafNode(otherlv_3, grammarAccess.getActionSpecAccess().getGoalKeyword_3());
            		
            // InternalRos1Parser.g:777:3: (this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_BEGIN) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRos1Parser.g:778:4: this_BEGIN_4= RULE_BEGIN ( (lv_goal_5_0= ruleMessageDefinition ) ) this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_4, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_4_0());
                    			
                    // InternalRos1Parser.g:782:4: ( (lv_goal_5_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:783:5: (lv_goal_5_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:783:5: (lv_goal_5_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:784:6: lv_goal_5_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getGoalMessageDefinitionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_27); 

                    				newLeafNode(this_END_6, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,Result,FOLLOW_28); 

            			newLeafNode(otherlv_7, grammarAccess.getActionSpecAccess().getResultKeyword_5());
            		
            // InternalRos1Parser.g:810:3: (this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_BEGIN) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalRos1Parser.g:811:4: this_BEGIN_8= RULE_BEGIN ( (lv_result_9_0= ruleMessageDefinition ) ) this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_8, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_6_0());
                    			
                    // InternalRos1Parser.g:815:4: ( (lv_result_9_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:816:5: (lv_result_9_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:816:5: (lv_result_9_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:817:6: lv_result_9_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getResultMessageDefinitionParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_29); 

                    				newLeafNode(this_END_10, grammarAccess.getActionSpecAccess().getENDTerminalRuleCall_6_2());
                    			

                    }
                    break;

            }

            otherlv_11=(Token)match(input,Feedback,FOLLOW_20); 

            			newLeafNode(otherlv_11, grammarAccess.getActionSpecAccess().getFeedbackKeyword_7());
            		
            // InternalRos1Parser.g:843:3: (this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_BEGIN) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalRos1Parser.g:844:4: this_BEGIN_12= RULE_BEGIN ( (lv_feedback_13_0= ruleMessageDefinition ) ) this_END_14= RULE_END
                    {
                    this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_21); 

                    				newLeafNode(this_BEGIN_12, grammarAccess.getActionSpecAccess().getBEGINTerminalRuleCall_8_0());
                    			
                    // InternalRos1Parser.g:848:4: ( (lv_feedback_13_0= ruleMessageDefinition ) )
                    // InternalRos1Parser.g:849:5: (lv_feedback_13_0= ruleMessageDefinition )
                    {
                    // InternalRos1Parser.g:849:5: (lv_feedback_13_0= ruleMessageDefinition )
                    // InternalRos1Parser.g:850:6: lv_feedback_13_0= ruleMessageDefinition
                    {

                    						newCompositeNode(grammarAccess.getActionSpecAccess().getFeedbackMessageDefinitionParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    this_END_14=(Token)match(input,RULE_END,FOLLOW_13); 

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
    // InternalRos1Parser.g:880:1: entryRuleMessageDefinition returns [EObject current=null] : iv_ruleMessageDefinition= ruleMessageDefinition EOF ;
    public final EObject entryRuleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessageDefinition = null;


        try {
            // InternalRos1Parser.g:880:58: (iv_ruleMessageDefinition= ruleMessageDefinition EOF )
            // InternalRos1Parser.g:881:2: iv_ruleMessageDefinition= ruleMessageDefinition EOF
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
    // InternalRos1Parser.g:887:1: ruleMessageDefinition returns [EObject current=null] : ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) ;
    public final EObject ruleMessageDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_MessagePart_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:893:2: ( ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* ) )
            // InternalRos1Parser.g:894:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            {
            // InternalRos1Parser.g:894:2: ( () ( (lv_MessagePart_1_0= ruleMessagePart ) )* )
            // InternalRos1Parser.g:895:3: () ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            {
            // InternalRos1Parser.g:895:3: ()
            // InternalRos1Parser.g:896:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMessageDefinitionAccess().getMessageDefinitionAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:902:3: ( (lv_MessagePart_1_0= ruleMessagePart ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=Float32_1 && LA20_0<=Pluginlib)||(LA20_0>=Duration && LA20_0<=External)||(LA20_0>=String_2 && LA20_0<=Uint64_1)||(LA20_0>=Float32 && LA20_0<=Int64_1)||LA20_0==Uint8_1||LA20_0==Header||(LA20_0>=Bool_1 && LA20_0<=Int8_1)||(LA20_0>=String_1 && LA20_0<=Uint64)||(LA20_0>=Int16 && LA20_0<=Int64)||LA20_0==Uint8||(LA20_0>=Bool && LA20_0<=Char)||LA20_0==Int8||LA20_0==Time||(LA20_0>=RULE_ID && LA20_0<=RULE_STRING)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalRos1Parser.g:903:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    {
            	    // InternalRos1Parser.g:903:4: (lv_MessagePart_1_0= ruleMessagePart )
            	    // InternalRos1Parser.g:904:5: lv_MessagePart_1_0= ruleMessagePart
            	    {

            	    					newCompositeNode(grammarAccess.getMessageDefinitionAccess().getMessagePartMessagePartParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_30);
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
            	    break loop20;
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


    // $ANTLR start "entryRuleArtifact"
    // InternalRos1Parser.g:925:1: entryRuleArtifact returns [EObject current=null] : iv_ruleArtifact= ruleArtifact EOF ;
    public final EObject entryRuleArtifact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtifact = null;


        try {
            // InternalRos1Parser.g:925:49: (iv_ruleArtifact= ruleArtifact EOF )
            // InternalRos1Parser.g:926:2: iv_ruleArtifact= ruleArtifact EOF
            {
             newCompositeNode(grammarAccess.getArtifactRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArtifact=ruleArtifact();

            state._fsp--;

             current =iv_ruleArtifact; 
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
    // $ANTLR end "entryRuleArtifact"


    // $ANTLR start "ruleArtifact"
    // InternalRos1Parser.g:932:1: ruleArtifact returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? (otherlv_5= Plugins this_BEGIN_6= RULE_BEGIN ( (lv_plugins_7_0= rulePlugin ) )* this_END_8= RULE_END )? this_END_9= RULE_END ) ;
    public final EObject ruleArtifact() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_5=null;
        Token this_BEGIN_6=null;
        Token this_END_8=null;
        Token this_END_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_node_4_0 = null;

        EObject lv_plugins_7_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:938:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? (otherlv_5= Plugins this_BEGIN_6= RULE_BEGIN ( (lv_plugins_7_0= rulePlugin ) )* this_END_8= RULE_END )? this_END_9= RULE_END ) )
            // InternalRos1Parser.g:939:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? (otherlv_5= Plugins this_BEGIN_6= RULE_BEGIN ( (lv_plugins_7_0= rulePlugin ) )* this_END_8= RULE_END )? this_END_9= RULE_END )
            {
            // InternalRos1Parser.g:939:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? (otherlv_5= Plugins this_BEGIN_6= RULE_BEGIN ( (lv_plugins_7_0= rulePlugin ) )* this_END_8= RULE_END )? this_END_9= RULE_END )
            // InternalRos1Parser.g:940:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (lv_node_4_0= ruleNode ) )? (otherlv_5= Plugins this_BEGIN_6= RULE_BEGIN ( (lv_plugins_7_0= rulePlugin ) )* this_END_8= RULE_END )? this_END_9= RULE_END
            {
            // InternalRos1Parser.g:940:3: ()
            // InternalRos1Parser.g:941:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getArtifactAccess().getArtifactAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:947:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos1Parser.g:948:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos1Parser.g:948:4: (lv_name_1_0= ruleRosNames )
            // InternalRos1Parser.g:949:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getArtifactAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_1_0=ruleRosNames();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArtifactRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.fraunhofer.ipa.ros.Ros.RosNames");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getArtifactAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_31); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getArtifactAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos1Parser.g:974:3: ( (lv_node_4_0= ruleNode ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Node_1) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalRos1Parser.g:975:4: (lv_node_4_0= ruleNode )
                    {
                    // InternalRos1Parser.g:975:4: (lv_node_4_0= ruleNode )
                    // InternalRos1Parser.g:976:5: lv_node_4_0= ruleNode
                    {

                    					newCompositeNode(grammarAccess.getArtifactAccess().getNodeNodeParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_32);
                    lv_node_4_0=ruleNode();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getArtifactRule());
                    					}
                    					set(
                    						current,
                    						"node",
                    						lv_node_4_0,
                    						"de.fraunhofer.ipa.ros.Ros.Node");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalRos1Parser.g:993:3: (otherlv_5= Plugins this_BEGIN_6= RULE_BEGIN ( (lv_plugins_7_0= rulePlugin ) )* this_END_8= RULE_END )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Plugins) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalRos1Parser.g:994:4: otherlv_5= Plugins this_BEGIN_6= RULE_BEGIN ( (lv_plugins_7_0= rulePlugin ) )* this_END_8= RULE_END
                    {
                    otherlv_5=(Token)match(input,Plugins,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getArtifactAccess().getPluginsKeyword_5_0());
                    			
                    this_BEGIN_6=(Token)match(input,RULE_BEGIN,FOLLOW_8); 

                    				newLeafNode(this_BEGIN_6, grammarAccess.getArtifactAccess().getBEGINTerminalRuleCall_5_1());
                    			
                    // InternalRos1Parser.g:1002:4: ( (lv_plugins_7_0= rulePlugin ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==Pluginlib||LA22_0==External||LA22_0==Node||LA22_0==RULE_ID||LA22_0==RULE_ROS_CONVENTION_A) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalRos1Parser.g:1003:5: (lv_plugins_7_0= rulePlugin )
                    	    {
                    	    // InternalRos1Parser.g:1003:5: (lv_plugins_7_0= rulePlugin )
                    	    // InternalRos1Parser.g:1004:6: lv_plugins_7_0= rulePlugin
                    	    {

                    	    						newCompositeNode(grammarAccess.getArtifactAccess().getPluginsPluginParserRuleCall_5_2_0());
                    	    					
                    	    pushFollow(FOLLOW_8);
                    	    lv_plugins_7_0=rulePlugin();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getArtifactRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"plugins",
                    	    							lv_plugins_7_0,
                    	    							"de.fraunhofer.ipa.ros.Ros.Plugin");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    this_END_8=(Token)match(input,RULE_END,FOLLOW_13); 

                    				newLeafNode(this_END_8, grammarAccess.getArtifactAccess().getENDTerminalRuleCall_5_3());
                    			

                    }
                    break;

            }

            this_END_9=(Token)match(input,RULE_END,FOLLOW_2); 

            			newLeafNode(this_END_9, grammarAccess.getArtifactAccess().getENDTerminalRuleCall_6());
            		

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
    // $ANTLR end "ruleArtifact"


    // $ANTLR start "entryRuleNode"
    // InternalRos1Parser.g:1034:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalRos1Parser.g:1034:45: (iv_ruleNode= ruleNode EOF )
            // InternalRos1Parser.g:1035:2: iv_ruleNode= ruleNode EOF
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
    // InternalRos1Parser.g:1041:1: ruleNode returns [EObject current=null] : (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) ;
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
            // InternalRos1Parser.g:1047:2: ( (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* ) )
            // InternalRos1Parser.g:1048:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            {
            // InternalRos1Parser.g:1048:2: (otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )* )
            // InternalRos1Parser.g:1049:3: otherlv_0= Node_1 ( (lv_name_1_0= ruleRosNames ) ) ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            {
            otherlv_0=(Token)match(input,Node_1,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0());
            		
            // InternalRos1Parser.g:1053:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos1Parser.g:1054:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos1Parser.g:1054:4: (lv_name_1_0= ruleRosNames )
            // InternalRos1Parser.g:1055:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getNodeAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_34);
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

            // InternalRos1Parser.g:1072:3: ( (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END ) | (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END ) | (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END ) | (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END ) | (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END ) | (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END ) | (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END ) | (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END ) | ( (lv_extensions_34_0= ruleExtensionBlock ) ) )*
            loop32:
            do {
                int alt32=10;
                switch ( input.LA(1) ) {
                case Publishers:
                    {
                    alt32=1;
                    }
                    break;
                case Subscribers:
                    {
                    alt32=2;
                    }
                    break;
                case Serviceservers:
                    {
                    alt32=3;
                    }
                    break;
                case Serviceclients:
                    {
                    alt32=4;
                    }
                    break;
                case Actionservers:
                    {
                    alt32=5;
                    }
                    break;
                case Actionclients:
                    {
                    alt32=6;
                    }
                    break;
                case Parameters:
                    {
                    alt32=7;
                    }
                    break;
                case Pluginslots:
                    {
                    alt32=8;
                    }
                    break;
                case CommercialAt:
                    {
                    alt32=9;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // InternalRos1Parser.g:1073:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1073:4: (otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END )
            	    // InternalRos1Parser.g:1074:5: otherlv_2= Publishers this_BEGIN_3= RULE_BEGIN ( (lv_publisher_4_0= rulePublisher ) )* this_END_5= RULE_END
            	    {
            	    otherlv_2=(Token)match(input,Publishers,FOLLOW_4); 

            	    					newLeafNode(otherlv_2, grammarAccess.getNodeAccess().getPublishersKeyword_2_0_0());
            	    				
            	    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_3, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_0_1());
            	    				
            	    // InternalRos1Parser.g:1082:5: ( (lv_publisher_4_0= rulePublisher ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Pluginlib||LA24_0==External||(LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1083:6: (lv_publisher_4_0= rulePublisher )
            	    	    {
            	    	    // InternalRos1Parser.g:1083:6: (lv_publisher_4_0= rulePublisher )
            	    	    // InternalRos1Parser.g:1084:7: lv_publisher_4_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPublisherPublisherParserRuleCall_2_0_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop24;
            	        }
            	    } while (true);

            	    this_END_5=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_5, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_0_3());
            	    				

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRos1Parser.g:1107:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1107:4: (otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END )
            	    // InternalRos1Parser.g:1108:5: otherlv_6= Subscribers this_BEGIN_7= RULE_BEGIN ( (lv_subscriber_8_0= ruleSubscriber ) )* this_END_9= RULE_END
            	    {
            	    otherlv_6=(Token)match(input,Subscribers,FOLLOW_4); 

            	    					newLeafNode(otherlv_6, grammarAccess.getNodeAccess().getSubscribersKeyword_2_1_0());
            	    				
            	    this_BEGIN_7=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_7, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_1_1());
            	    				
            	    // InternalRos1Parser.g:1116:5: ( (lv_subscriber_8_0= ruleSubscriber ) )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Pluginlib||LA25_0==External||(LA25_0>=RULE_ID && LA25_0<=RULE_STRING)) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1117:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRos1Parser.g:1117:6: (lv_subscriber_8_0= ruleSubscriber )
            	    	    // InternalRos1Parser.g:1118:7: lv_subscriber_8_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getSubscriberSubscriberParserRuleCall_2_1_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop25;
            	        }
            	    } while (true);

            	    this_END_9=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_9, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_1_3());
            	    				

            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalRos1Parser.g:1141:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1141:4: (otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END )
            	    // InternalRos1Parser.g:1142:5: otherlv_10= Serviceservers this_BEGIN_11= RULE_BEGIN ( (lv_serviceserver_12_0= ruleServiceServer ) )* this_END_13= RULE_END
            	    {
            	    otherlv_10=(Token)match(input,Serviceservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getServiceserversKeyword_2_2_0());
            	    				
            	    this_BEGIN_11=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_11, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_2_1());
            	    				
            	    // InternalRos1Parser.g:1150:5: ( (lv_serviceserver_12_0= ruleServiceServer ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Pluginlib||LA26_0==External||(LA26_0>=RULE_ID && LA26_0<=RULE_STRING)) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1151:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1151:6: (lv_serviceserver_12_0= ruleServiceServer )
            	    	    // InternalRos1Parser.g:1152:7: lv_serviceserver_12_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceserverServiceServerParserRuleCall_2_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop26;
            	        }
            	    } while (true);

            	    this_END_13=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_13, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRos1Parser.g:1175:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1175:4: (otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END )
            	    // InternalRos1Parser.g:1176:5: otherlv_14= Serviceclients this_BEGIN_15= RULE_BEGIN ( (lv_serviceclient_16_0= ruleServiceClient ) )* this_END_17= RULE_END
            	    {
            	    otherlv_14=(Token)match(input,Serviceclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_14, grammarAccess.getNodeAccess().getServiceclientsKeyword_2_3_0());
            	    				
            	    this_BEGIN_15=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_15, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_3_1());
            	    				
            	    // InternalRos1Parser.g:1184:5: ( (lv_serviceclient_16_0= ruleServiceClient ) )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==Pluginlib||LA27_0==External||(LA27_0>=RULE_ID && LA27_0<=RULE_STRING)) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1185:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1185:6: (lv_serviceclient_16_0= ruleServiceClient )
            	    	    // InternalRos1Parser.g:1186:7: lv_serviceclient_16_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getServiceclientServiceClientParserRuleCall_2_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop27;
            	        }
            	    } while (true);

            	    this_END_17=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_17, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRos1Parser.g:1209:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1209:4: (otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END )
            	    // InternalRos1Parser.g:1210:5: otherlv_18= Actionservers this_BEGIN_19= RULE_BEGIN ( (lv_actionserver_20_0= ruleActionServer ) )* this_END_21= RULE_END
            	    {
            	    otherlv_18=(Token)match(input,Actionservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_18, grammarAccess.getNodeAccess().getActionserversKeyword_2_4_0());
            	    				
            	    this_BEGIN_19=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_19, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_4_1());
            	    				
            	    // InternalRos1Parser.g:1218:5: ( (lv_actionserver_20_0= ruleActionServer ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Pluginlib||LA28_0==External||(LA28_0>=RULE_ID && LA28_0<=RULE_STRING)) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1219:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1219:6: (lv_actionserver_20_0= ruleActionServer )
            	    	    // InternalRos1Parser.g:1220:7: lv_actionserver_20_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionserverActionServerParserRuleCall_2_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop28;
            	        }
            	    } while (true);

            	    this_END_21=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_21, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRos1Parser.g:1243:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1243:4: (otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END )
            	    // InternalRos1Parser.g:1244:5: otherlv_22= Actionclients this_BEGIN_23= RULE_BEGIN ( (lv_actionclient_24_0= ruleActionClient ) )* this_END_25= RULE_END
            	    {
            	    otherlv_22=(Token)match(input,Actionclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_22, grammarAccess.getNodeAccess().getActionclientsKeyword_2_5_0());
            	    				
            	    this_BEGIN_23=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_23, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_5_1());
            	    				
            	    // InternalRos1Parser.g:1252:5: ( (lv_actionclient_24_0= ruleActionClient ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Pluginlib||LA29_0==External||(LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1253:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1253:6: (lv_actionclient_24_0= ruleActionClient )
            	    	    // InternalRos1Parser.g:1254:7: lv_actionclient_24_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getActionclientActionClientParserRuleCall_2_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop29;
            	        }
            	    } while (true);

            	    this_END_25=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_25, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRos1Parser.g:1277:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1277:4: (otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END )
            	    // InternalRos1Parser.g:1278:5: otherlv_26= Parameters this_BEGIN_27= RULE_BEGIN ( (lv_parameter_28_0= ruleParameter ) )* this_END_29= RULE_END
            	    {
            	    otherlv_26=(Token)match(input,Parameters,FOLLOW_4); 

            	    					newLeafNode(otherlv_26, grammarAccess.getNodeAccess().getParametersKeyword_2_6_0());
            	    				
            	    this_BEGIN_27=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_27, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_6_1());
            	    				
            	    // InternalRos1Parser.g:1286:5: ( (lv_parameter_28_0= ruleParameter ) )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==Pluginlib||LA30_0==External||(LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1287:6: (lv_parameter_28_0= ruleParameter )
            	    	    {
            	    	    // InternalRos1Parser.g:1287:6: (lv_parameter_28_0= ruleParameter )
            	    	    // InternalRos1Parser.g:1288:7: lv_parameter_28_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getParameterParameterParserRuleCall_2_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop30;
            	        }
            	    } while (true);

            	    this_END_29=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_29, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRos1Parser.g:1311:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1311:4: (otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END )
            	    // InternalRos1Parser.g:1312:5: otherlv_30= Pluginslots this_BEGIN_31= RULE_BEGIN ( (lv_pluginSlots_32_0= rulePluginSlot ) )* this_END_33= RULE_END
            	    {
            	    otherlv_30=(Token)match(input,Pluginslots,FOLLOW_4); 

            	    					newLeafNode(otherlv_30, grammarAccess.getNodeAccess().getPluginslotsKeyword_2_7_0());
            	    				
            	    this_BEGIN_31=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_31, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_2_7_1());
            	    				
            	    // InternalRos1Parser.g:1320:5: ( (lv_pluginSlots_32_0= rulePluginSlot ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Pluginlib||LA31_0==External||(LA31_0>=RULE_ID && LA31_0<=RULE_STRING)) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1321:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    {
            	    	    // InternalRos1Parser.g:1321:6: (lv_pluginSlots_32_0= rulePluginSlot )
            	    	    // InternalRos1Parser.g:1322:7: lv_pluginSlots_32_0= rulePluginSlot
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getNodeAccess().getPluginSlotsPluginSlotParserRuleCall_2_7_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop31;
            	        }
            	    } while (true);

            	    this_END_33=(Token)match(input,RULE_END,FOLLOW_34); 

            	    					newLeafNode(this_END_33, grammarAccess.getNodeAccess().getENDTerminalRuleCall_2_7_3());
            	    				

            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRos1Parser.g:1345:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRos1Parser.g:1345:4: ( (lv_extensions_34_0= ruleExtensionBlock ) )
            	    // InternalRos1Parser.g:1346:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    {
            	    // InternalRos1Parser.g:1346:5: (lv_extensions_34_0= ruleExtensionBlock )
            	    // InternalRos1Parser.g:1347:6: lv_extensions_34_0= ruleExtensionBlock
            	    {

            	    						newCompositeNode(grammarAccess.getNodeAccess().getExtensionsExtensionBlockParserRuleCall_2_8_0());
            	    					
            	    pushFollow(FOLLOW_34);
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
            	    break loop32;
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
    // InternalRos1Parser.g:1369:1: entryRulePlugin returns [EObject current=null] : iv_rulePlugin= rulePlugin EOF ;
    public final EObject entryRulePlugin() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlugin = null;


        try {
            // InternalRos1Parser.g:1369:47: (iv_rulePlugin= rulePlugin EOF )
            // InternalRos1Parser.g:1370:2: iv_rulePlugin= rulePlugin EOF
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
    // InternalRos1Parser.g:1376:1: rulePlugin returns [EObject current=null] : ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END ) ;
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
            // InternalRos1Parser.g:1382:2: ( ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END ) )
            // InternalRos1Parser.g:1383:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END )
            {
            // InternalRos1Parser.g:1383:2: ( () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END )
            // InternalRos1Parser.g:1384:3: () ( (lv_name_1_0= ruleRosNames ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )* this_END_37= RULE_END
            {
            // InternalRos1Parser.g:1384:3: ()
            // InternalRos1Parser.g:1385:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginAccess().getPluginAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:1391:3: ( (lv_name_1_0= ruleRosNames ) )
            // InternalRos1Parser.g:1392:4: (lv_name_1_0= ruleRosNames )
            {
            // InternalRos1Parser.g:1392:4: (lv_name_1_0= ruleRosNames )
            // InternalRos1Parser.g:1393:5: lv_name_1_0= ruleRosNames
            {

            					newCompositeNode(grammarAccess.getPluginAccess().getNameRosNamesParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPluginAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_35); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos1Parser.g:1418:3: ( (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) ) | (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) ) | (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END ) | (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END ) | (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END ) | (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END ) | (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END ) | (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END ) | (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END ) | ( (lv_extensions_36_0= ruleExtensionBlock ) ) )*
            loop40:
            do {
                int alt40=11;
                switch ( input.LA(1) ) {
                case Implements:
                    {
                    alt40=1;
                    }
                    break;
                case Loader:
                    {
                    alt40=2;
                    }
                    break;
                case Publishers:
                    {
                    alt40=3;
                    }
                    break;
                case Subscribers:
                    {
                    alt40=4;
                    }
                    break;
                case Serviceservers:
                    {
                    alt40=5;
                    }
                    break;
                case Serviceclients:
                    {
                    alt40=6;
                    }
                    break;
                case Actionservers:
                    {
                    alt40=7;
                    }
                    break;
                case Actionclients:
                    {
                    alt40=8;
                    }
                    break;
                case Parameters:
                    {
                    alt40=9;
                    }
                    break;
                case CommercialAt:
                    {
                    alt40=10;
                    }
                    break;

                }

                switch (alt40) {
            	case 1 :
            	    // InternalRos1Parser.g:1419:4: (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) )
            	    {
            	    // InternalRos1Parser.g:1419:4: (otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) ) )
            	    // InternalRos1Parser.g:1420:5: otherlv_4= Implements ( (lv_implements_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,Implements,FOLLOW_6); 

            	    					newLeafNode(otherlv_4, grammarAccess.getPluginAccess().getImplementsKeyword_4_0_0());
            	    				
            	    // InternalRos1Parser.g:1424:5: ( (lv_implements_5_0= ruleEString ) )
            	    // InternalRos1Parser.g:1425:6: (lv_implements_5_0= ruleEString )
            	    {
            	    // InternalRos1Parser.g:1425:6: (lv_implements_5_0= ruleEString )
            	    // InternalRos1Parser.g:1426:7: lv_implements_5_0= ruleEString
            	    {

            	    							newCompositeNode(grammarAccess.getPluginAccess().getImplementsEStringParserRuleCall_4_0_1_0());
            	    						
            	    pushFollow(FOLLOW_35);
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
            	    // InternalRos1Parser.g:1445:4: (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) )
            	    {
            	    // InternalRos1Parser.g:1445:4: (otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) ) )
            	    // InternalRos1Parser.g:1446:5: otherlv_6= Loader ( (lv_loader_7_0= rulePluginLoader ) )
            	    {
            	    otherlv_6=(Token)match(input,Loader,FOLLOW_36); 

            	    					newLeafNode(otherlv_6, grammarAccess.getPluginAccess().getLoaderKeyword_4_1_0());
            	    				
            	    // InternalRos1Parser.g:1450:5: ( (lv_loader_7_0= rulePluginLoader ) )
            	    // InternalRos1Parser.g:1451:6: (lv_loader_7_0= rulePluginLoader )
            	    {
            	    // InternalRos1Parser.g:1451:6: (lv_loader_7_0= rulePluginLoader )
            	    // InternalRos1Parser.g:1452:7: lv_loader_7_0= rulePluginLoader
            	    {

            	    							newCompositeNode(grammarAccess.getPluginAccess().getLoaderPluginLoaderEnumRuleCall_4_1_1_0());
            	    						
            	    pushFollow(FOLLOW_35);
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
            	    // InternalRos1Parser.g:1471:4: (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1471:4: (otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END )
            	    // InternalRos1Parser.g:1472:5: otherlv_8= Publishers this_BEGIN_9= RULE_BEGIN ( (lv_publisher_10_0= rulePublisher ) )* this_END_11= RULE_END
            	    {
            	    otherlv_8=(Token)match(input,Publishers,FOLLOW_4); 

            	    					newLeafNode(otherlv_8, grammarAccess.getPluginAccess().getPublishersKeyword_4_2_0());
            	    				
            	    this_BEGIN_9=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_9, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_2_1());
            	    				
            	    // InternalRos1Parser.g:1480:5: ( (lv_publisher_10_0= rulePublisher ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Pluginlib||LA33_0==External||(LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1481:6: (lv_publisher_10_0= rulePublisher )
            	    	    {
            	    	    // InternalRos1Parser.g:1481:6: (lv_publisher_10_0= rulePublisher )
            	    	    // InternalRos1Parser.g:1482:7: lv_publisher_10_0= rulePublisher
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getPublisherPublisherParserRuleCall_4_2_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop33;
            	        }
            	    } while (true);

            	    this_END_11=(Token)match(input,RULE_END,FOLLOW_35); 

            	    					newLeafNode(this_END_11, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_2_3());
            	    				

            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalRos1Parser.g:1505:4: (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1505:4: (otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END )
            	    // InternalRos1Parser.g:1506:5: otherlv_12= Subscribers this_BEGIN_13= RULE_BEGIN ( (lv_subscriber_14_0= ruleSubscriber ) )* this_END_15= RULE_END
            	    {
            	    otherlv_12=(Token)match(input,Subscribers,FOLLOW_4); 

            	    					newLeafNode(otherlv_12, grammarAccess.getPluginAccess().getSubscribersKeyword_4_3_0());
            	    				
            	    this_BEGIN_13=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_13, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_3_1());
            	    				
            	    // InternalRos1Parser.g:1514:5: ( (lv_subscriber_14_0= ruleSubscriber ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==Pluginlib||LA34_0==External||(LA34_0>=RULE_ID && LA34_0<=RULE_STRING)) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1515:6: (lv_subscriber_14_0= ruleSubscriber )
            	    	    {
            	    	    // InternalRos1Parser.g:1515:6: (lv_subscriber_14_0= ruleSubscriber )
            	    	    // InternalRos1Parser.g:1516:7: lv_subscriber_14_0= ruleSubscriber
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getSubscriberSubscriberParserRuleCall_4_3_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop34;
            	        }
            	    } while (true);

            	    this_END_15=(Token)match(input,RULE_END,FOLLOW_35); 

            	    					newLeafNode(this_END_15, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_3_3());
            	    				

            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalRos1Parser.g:1539:4: (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1539:4: (otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END )
            	    // InternalRos1Parser.g:1540:5: otherlv_16= Serviceservers this_BEGIN_17= RULE_BEGIN ( (lv_serviceserver_18_0= ruleServiceServer ) )* this_END_19= RULE_END
            	    {
            	    otherlv_16=(Token)match(input,Serviceservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_16, grammarAccess.getPluginAccess().getServiceserversKeyword_4_4_0());
            	    				
            	    this_BEGIN_17=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_17, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_4_1());
            	    				
            	    // InternalRos1Parser.g:1548:5: ( (lv_serviceserver_18_0= ruleServiceServer ) )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==Pluginlib||LA35_0==External||(LA35_0>=RULE_ID && LA35_0<=RULE_STRING)) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1549:6: (lv_serviceserver_18_0= ruleServiceServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1549:6: (lv_serviceserver_18_0= ruleServiceServer )
            	    	    // InternalRos1Parser.g:1550:7: lv_serviceserver_18_0= ruleServiceServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceserverServiceServerParserRuleCall_4_4_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop35;
            	        }
            	    } while (true);

            	    this_END_19=(Token)match(input,RULE_END,FOLLOW_35); 

            	    					newLeafNode(this_END_19, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_4_3());
            	    				

            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalRos1Parser.g:1573:4: (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1573:4: (otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END )
            	    // InternalRos1Parser.g:1574:5: otherlv_20= Serviceclients this_BEGIN_21= RULE_BEGIN ( (lv_serviceclient_22_0= ruleServiceClient ) )* this_END_23= RULE_END
            	    {
            	    otherlv_20=(Token)match(input,Serviceclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_20, grammarAccess.getPluginAccess().getServiceclientsKeyword_4_5_0());
            	    				
            	    this_BEGIN_21=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_21, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_5_1());
            	    				
            	    // InternalRos1Parser.g:1582:5: ( (lv_serviceclient_22_0= ruleServiceClient ) )*
            	    loop36:
            	    do {
            	        int alt36=2;
            	        int LA36_0 = input.LA(1);

            	        if ( (LA36_0==Pluginlib||LA36_0==External||(LA36_0>=RULE_ID && LA36_0<=RULE_STRING)) ) {
            	            alt36=1;
            	        }


            	        switch (alt36) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1583:6: (lv_serviceclient_22_0= ruleServiceClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1583:6: (lv_serviceclient_22_0= ruleServiceClient )
            	    	    // InternalRos1Parser.g:1584:7: lv_serviceclient_22_0= ruleServiceClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getServiceclientServiceClientParserRuleCall_4_5_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop36;
            	        }
            	    } while (true);

            	    this_END_23=(Token)match(input,RULE_END,FOLLOW_35); 

            	    					newLeafNode(this_END_23, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_5_3());
            	    				

            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalRos1Parser.g:1607:4: (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1607:4: (otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END )
            	    // InternalRos1Parser.g:1608:5: otherlv_24= Actionservers this_BEGIN_25= RULE_BEGIN ( (lv_actionserver_26_0= ruleActionServer ) )* this_END_27= RULE_END
            	    {
            	    otherlv_24=(Token)match(input,Actionservers,FOLLOW_4); 

            	    					newLeafNode(otherlv_24, grammarAccess.getPluginAccess().getActionserversKeyword_4_6_0());
            	    				
            	    this_BEGIN_25=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_25, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_6_1());
            	    				
            	    // InternalRos1Parser.g:1616:5: ( (lv_actionserver_26_0= ruleActionServer ) )*
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==Pluginlib||LA37_0==External||(LA37_0>=RULE_ID && LA37_0<=RULE_STRING)) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1617:6: (lv_actionserver_26_0= ruleActionServer )
            	    	    {
            	    	    // InternalRos1Parser.g:1617:6: (lv_actionserver_26_0= ruleActionServer )
            	    	    // InternalRos1Parser.g:1618:7: lv_actionserver_26_0= ruleActionServer
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionserverActionServerParserRuleCall_4_6_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop37;
            	        }
            	    } while (true);

            	    this_END_27=(Token)match(input,RULE_END,FOLLOW_35); 

            	    					newLeafNode(this_END_27, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_6_3());
            	    				

            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalRos1Parser.g:1641:4: (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1641:4: (otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END )
            	    // InternalRos1Parser.g:1642:5: otherlv_28= Actionclients this_BEGIN_29= RULE_BEGIN ( (lv_actionclient_30_0= ruleActionClient ) )* this_END_31= RULE_END
            	    {
            	    otherlv_28=(Token)match(input,Actionclients,FOLLOW_4); 

            	    					newLeafNode(otherlv_28, grammarAccess.getPluginAccess().getActionclientsKeyword_4_7_0());
            	    				
            	    this_BEGIN_29=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_29, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_7_1());
            	    				
            	    // InternalRos1Parser.g:1650:5: ( (lv_actionclient_30_0= ruleActionClient ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Pluginlib||LA38_0==External||(LA38_0>=RULE_ID && LA38_0<=RULE_STRING)) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1651:6: (lv_actionclient_30_0= ruleActionClient )
            	    	    {
            	    	    // InternalRos1Parser.g:1651:6: (lv_actionclient_30_0= ruleActionClient )
            	    	    // InternalRos1Parser.g:1652:7: lv_actionclient_30_0= ruleActionClient
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getActionclientActionClientParserRuleCall_4_7_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop38;
            	        }
            	    } while (true);

            	    this_END_31=(Token)match(input,RULE_END,FOLLOW_35); 

            	    					newLeafNode(this_END_31, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_7_3());
            	    				

            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalRos1Parser.g:1675:4: (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END )
            	    {
            	    // InternalRos1Parser.g:1675:4: (otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END )
            	    // InternalRos1Parser.g:1676:5: otherlv_32= Parameters this_BEGIN_33= RULE_BEGIN ( (lv_parameter_34_0= ruleParameter ) )* this_END_35= RULE_END
            	    {
            	    otherlv_32=(Token)match(input,Parameters,FOLLOW_4); 

            	    					newLeafNode(otherlv_32, grammarAccess.getPluginAccess().getParametersKeyword_4_8_0());
            	    				
            	    this_BEGIN_33=(Token)match(input,RULE_BEGIN,FOLLOW_18); 

            	    					newLeafNode(this_BEGIN_33, grammarAccess.getPluginAccess().getBEGINTerminalRuleCall_4_8_1());
            	    				
            	    // InternalRos1Parser.g:1684:5: ( (lv_parameter_34_0= ruleParameter ) )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==Pluginlib||LA39_0==External||(LA39_0>=RULE_ID && LA39_0<=RULE_STRING)) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // InternalRos1Parser.g:1685:6: (lv_parameter_34_0= ruleParameter )
            	    	    {
            	    	    // InternalRos1Parser.g:1685:6: (lv_parameter_34_0= ruleParameter )
            	    	    // InternalRos1Parser.g:1686:7: lv_parameter_34_0= ruleParameter
            	    	    {

            	    	    							newCompositeNode(grammarAccess.getPluginAccess().getParameterParameterParserRuleCall_4_8_2_0());
            	    	    						
            	    	    pushFollow(FOLLOW_18);
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
            	    	    break loop39;
            	        }
            	    } while (true);

            	    this_END_35=(Token)match(input,RULE_END,FOLLOW_35); 

            	    					newLeafNode(this_END_35, grammarAccess.getPluginAccess().getENDTerminalRuleCall_4_8_3());
            	    				

            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalRos1Parser.g:1709:4: ( (lv_extensions_36_0= ruleExtensionBlock ) )
            	    {
            	    // InternalRos1Parser.g:1709:4: ( (lv_extensions_36_0= ruleExtensionBlock ) )
            	    // InternalRos1Parser.g:1710:5: (lv_extensions_36_0= ruleExtensionBlock )
            	    {
            	    // InternalRos1Parser.g:1710:5: (lv_extensions_36_0= ruleExtensionBlock )
            	    // InternalRos1Parser.g:1711:6: lv_extensions_36_0= ruleExtensionBlock
            	    {

            	    						newCompositeNode(grammarAccess.getPluginAccess().getExtensionsExtensionBlockParserRuleCall_4_9_0());
            	    					
            	    pushFollow(FOLLOW_35);
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
            	    break loop40;
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
    // InternalRos1Parser.g:1737:1: entryRulePluginSlot returns [EObject current=null] : iv_rulePluginSlot= rulePluginSlot EOF ;
    public final EObject entryRulePluginSlot() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginSlot = null;


        try {
            // InternalRos1Parser.g:1737:51: (iv_rulePluginSlot= rulePluginSlot EOF )
            // InternalRos1Parser.g:1738:2: iv_rulePluginSlot= rulePluginSlot EOF
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
    // InternalRos1Parser.g:1744:1: rulePluginSlot returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END ) | (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket ) ) ) ;
    public final EObject rulePluginSlot() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_BEGIN_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token this_END_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_base_6_0 = null;

        AntlrDatatypeRuleToken lv_parameter_8_0 = null;

        AntlrDatatypeRuleToken lv_defaultPlugin_10_0 = null;

        AntlrDatatypeRuleToken lv_base_14_0 = null;

        AntlrDatatypeRuleToken lv_parameter_17_0 = null;

        AntlrDatatypeRuleToken lv_defaultPlugin_20_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:1750:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END ) | (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket ) ) ) )
            // InternalRos1Parser.g:1751:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END ) | (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket ) ) )
            {
            // InternalRos1Parser.g:1751:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END ) | (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket ) ) )
            // InternalRos1Parser.g:1752:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END ) | (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket ) )
            {
            // InternalRos1Parser.g:1752:3: ()
            // InternalRos1Parser.g:1753:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPluginSlotAccess().getPluginSlotAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:1759:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:1760:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:1760:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:1761:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPluginSlotAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getPluginSlotAccess().getColonKeyword_2());
            		
            // InternalRos1Parser.g:1782:3: ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END ) | (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket ) )
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
                    // InternalRos1Parser.g:1783:4: (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END )
                    {
                    // InternalRos1Parser.g:1783:4: (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END )
                    // InternalRos1Parser.g:1784:5: this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_11= RULE_END
                    {
                    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_38); 

                    					newLeafNode(this_BEGIN_3, grammarAccess.getPluginSlotAccess().getBEGINTerminalRuleCall_3_0_0());
                    				
                    // InternalRos1Parser.g:1788:5: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) )
                    // InternalRos1Parser.g:1789:6: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
                    {
                    // InternalRos1Parser.g:1789:6: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
                    // InternalRos1Parser.g:1790:7: ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?)
                    {
                     
                    						  getUnorderedGroupHelper().enter(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    						
                    // InternalRos1Parser.g:1793:7: ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?)
                    // InternalRos1Parser.g:1794:8: ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+ {...}?
                    {
                    // InternalRos1Parser.g:1794:8: ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) ) )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=4;
                        int LA41_0 = input.LA(1);

                        if ( LA41_0 == Base && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0) ) {
                            alt41=1;
                        }
                        else if ( LA41_0 == Parameter && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1) ) {
                            alt41=2;
                        }
                        else if ( LA41_0 == Default && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2) ) {
                            alt41=3;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalRos1Parser.g:1795:6: ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1795:6: ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1796:7: {...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0)");
                    	    }
                    	    // InternalRos1Parser.g:1796:113: ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) )
                    	    // InternalRos1Parser.g:1797:8: ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0);
                    	    							
                    	    // InternalRos1Parser.g:1800:11: ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) )
                    	    // InternalRos1Parser.g:1800:12: {...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1800:21: (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) )
                    	    // InternalRos1Parser.g:1800:22: otherlv_5= Base ( (lv_base_6_0= ruleEString ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Base,FOLLOW_6); 

                    	    											newLeafNode(otherlv_5, grammarAccess.getPluginSlotAccess().getBaseKeyword_3_0_1_0_0());
                    	    										
                    	    // InternalRos1Parser.g:1804:11: ( (lv_base_6_0= ruleEString ) )
                    	    // InternalRos1Parser.g:1805:12: (lv_base_6_0= ruleEString )
                    	    {
                    	    // InternalRos1Parser.g:1805:12: (lv_base_6_0= ruleEString )
                    	    // InternalRos1Parser.g:1806:13: lv_base_6_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getBaseEStringParserRuleCall_3_0_1_0_1_0());
                    	    												
                    	    pushFollow(FOLLOW_39);
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
                    	    // InternalRos1Parser.g:1829:6: ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1829:6: ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1830:7: {...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1)");
                    	    }
                    	    // InternalRos1Parser.g:1830:113: ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) )
                    	    // InternalRos1Parser.g:1831:8: ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1);
                    	    							
                    	    // InternalRos1Parser.g:1834:11: ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) )
                    	    // InternalRos1Parser.g:1834:12: {...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1834:21: (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) )
                    	    // InternalRos1Parser.g:1834:22: otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) )
                    	    {
                    	    otherlv_7=(Token)match(input,Parameter,FOLLOW_6); 

                    	    											newLeafNode(otherlv_7, grammarAccess.getPluginSlotAccess().getParameterKeyword_3_0_1_1_0());
                    	    										
                    	    // InternalRos1Parser.g:1838:11: ( (lv_parameter_8_0= ruleEString ) )
                    	    // InternalRos1Parser.g:1839:12: (lv_parameter_8_0= ruleEString )
                    	    {
                    	    // InternalRos1Parser.g:1839:12: (lv_parameter_8_0= ruleEString )
                    	    // InternalRos1Parser.g:1840:13: lv_parameter_8_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_3_0_1_1_1_0());
                    	    												
                    	    pushFollow(FOLLOW_39);
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
                    	    // InternalRos1Parser.g:1863:6: ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1863:6: ({...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1864:7: {...}? => ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2)");
                    	    }
                    	    // InternalRos1Parser.g:1864:113: ( ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) ) )
                    	    // InternalRos1Parser.g:1865:8: ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2);
                    	    							
                    	    // InternalRos1Parser.g:1868:11: ({...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) ) )
                    	    // InternalRos1Parser.g:1868:12: {...}? => (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1868:21: (otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) ) )
                    	    // InternalRos1Parser.g:1868:22: otherlv_9= Default ( (lv_defaultPlugin_10_0= ruleEString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Default,FOLLOW_6); 

                    	    											newLeafNode(otherlv_9, grammarAccess.getPluginSlotAccess().getDefaultKeyword_3_0_1_2_0());
                    	    										
                    	    // InternalRos1Parser.g:1872:11: ( (lv_defaultPlugin_10_0= ruleEString ) )
                    	    // InternalRos1Parser.g:1873:12: (lv_defaultPlugin_10_0= ruleEString )
                    	    {
                    	    // InternalRos1Parser.g:1873:12: (lv_defaultPlugin_10_0= ruleEString )
                    	    // InternalRos1Parser.g:1874:13: lv_defaultPlugin_10_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginEStringParserRuleCall_3_0_1_2_1_0());
                    	    												
                    	    pushFollow(FOLLOW_39);
                    	    lv_defaultPlugin_10_0=ruleEString();

                    	    state._fsp--;


                    	    													if (current==null) {
                    	    														current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    	    													}
                    	    													set(
                    	    														current,
                    	    														"defaultPlugin",
                    	    														lv_defaultPlugin_10_0,
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
                    	    if ( cnt41 >= 1 ) break loop41;
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1()) ) {
                        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canLeave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1())");
                    }

                    }


                    }

                     
                    						  getUnorderedGroupHelper().leave(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    						

                    }

                    this_END_11=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_11, grammarAccess.getPluginSlotAccess().getENDTerminalRuleCall_3_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:1911:4: (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket )
                    {
                    // InternalRos1Parser.g:1911:4: (otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket )
                    // InternalRos1Parser.g:1912:5: otherlv_12= LeftCurlyBracket otherlv_13= Base ( (lv_base_14_0= ruleEString ) ) (otherlv_15= Comma )? otherlv_16= Parameter ( (lv_parameter_17_0= ruleEString ) ) ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )? otherlv_21= RightCurlyBracket
                    {
                    otherlv_12=(Token)match(input,LeftCurlyBracket,FOLLOW_40); 

                    					newLeafNode(otherlv_12, grammarAccess.getPluginSlotAccess().getLeftCurlyBracketKeyword_3_1_0());
                    				
                    otherlv_13=(Token)match(input,Base,FOLLOW_6); 

                    					newLeafNode(otherlv_13, grammarAccess.getPluginSlotAccess().getBaseKeyword_3_1_1());
                    				
                    // InternalRos1Parser.g:1920:5: ( (lv_base_14_0= ruleEString ) )
                    // InternalRos1Parser.g:1921:6: (lv_base_14_0= ruleEString )
                    {
                    // InternalRos1Parser.g:1921:6: (lv_base_14_0= ruleEString )
                    // InternalRos1Parser.g:1922:7: lv_base_14_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getBaseEStringParserRuleCall_3_1_2_0());
                    						
                    pushFollow(FOLLOW_41);
                    lv_base_14_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    							}
                    							set(
                    								current,
                    								"base",
                    								lv_base_14_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRos1Parser.g:1939:5: (otherlv_15= Comma )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==Comma) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalRos1Parser.g:1940:6: otherlv_15= Comma
                            {
                            otherlv_15=(Token)match(input,Comma,FOLLOW_42); 

                            						newLeafNode(otherlv_15, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_3());
                            					

                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,Parameter,FOLLOW_6); 

                    					newLeafNode(otherlv_16, grammarAccess.getPluginSlotAccess().getParameterKeyword_3_1_4());
                    				
                    // InternalRos1Parser.g:1949:5: ( (lv_parameter_17_0= ruleEString ) )
                    // InternalRos1Parser.g:1950:6: (lv_parameter_17_0= ruleEString )
                    {
                    // InternalRos1Parser.g:1950:6: (lv_parameter_17_0= ruleEString )
                    // InternalRos1Parser.g:1951:7: lv_parameter_17_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_3_1_5_0());
                    						
                    pushFollow(FOLLOW_43);
                    lv_parameter_17_0=ruleEString();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                    							}
                    							set(
                    								current,
                    								"parameter",
                    								lv_parameter_17_0,
                    								"de.fraunhofer.ipa.ros.Ros.EString");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalRos1Parser.g:1968:5: ( (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==Default||LA44_0==Comma) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalRos1Parser.g:1969:6: (otherlv_18= Comma )? otherlv_19= Default ( (lv_defaultPlugin_20_0= ruleEString ) )
                            {
                            // InternalRos1Parser.g:1969:6: (otherlv_18= Comma )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==Comma) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // InternalRos1Parser.g:1970:7: otherlv_18= Comma
                                    {
                                    otherlv_18=(Token)match(input,Comma,FOLLOW_44); 

                                    							newLeafNode(otherlv_18, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_6_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_19=(Token)match(input,Default,FOLLOW_6); 

                            						newLeafNode(otherlv_19, grammarAccess.getPluginSlotAccess().getDefaultKeyword_3_1_6_1());
                            					
                            // InternalRos1Parser.g:1979:6: ( (lv_defaultPlugin_20_0= ruleEString ) )
                            // InternalRos1Parser.g:1980:7: (lv_defaultPlugin_20_0= ruleEString )
                            {
                            // InternalRos1Parser.g:1980:7: (lv_defaultPlugin_20_0= ruleEString )
                            // InternalRos1Parser.g:1981:8: lv_defaultPlugin_20_0= ruleEString
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginEStringParserRuleCall_3_1_6_2_0());
                            							
                            pushFollow(FOLLOW_45);
                            lv_defaultPlugin_20_0=ruleEString();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getPluginSlotRule());
                            								}
                            								set(
                            									current,
                            									"defaultPlugin",
                            									lv_defaultPlugin_20_0,
                            									"de.fraunhofer.ipa.ros.Ros.EString");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_21=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

                    					newLeafNode(otherlv_21, grammarAccess.getPluginSlotAccess().getRightCurlyBracketKeyword_3_1_7());
                    				

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
    // InternalRos1Parser.g:2009:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRos1Parser.g:2009:47: (iv_ruleEString= ruleEString EOF )
            // InternalRos1Parser.g:2010:2: iv_ruleEString= ruleEString EOF
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
    // InternalRos1Parser.g:2016:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2022:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External ) )
            // InternalRos1Parser.g:2023:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External )
            {
            // InternalRos1Parser.g:2023:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External )
            int alt46=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt46=1;
                }
                break;
            case RULE_ID:
                {
                alt46=2;
                }
                break;
            case Pluginlib:
                {
                alt46=3;
                }
                break;
            case External:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // InternalRos1Parser.g:2024:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2032:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2040:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getPluginlibKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2046:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getExternalKeyword_3());
                    		

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
    // InternalRos1Parser.g:2055:1: entryRuleRosNames returns [String current=null] : iv_ruleRosNames= ruleRosNames EOF ;
    public final String entryRuleRosNames() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRosNames = null;


        try {
            // InternalRos1Parser.g:2055:48: (iv_ruleRosNames= ruleRosNames EOF )
            // InternalRos1Parser.g:2056:2: iv_ruleRosNames= ruleRosNames EOF
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
    // InternalRos1Parser.g:2062:1: ruleRosNames returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External ) ;
    public final AntlrDatatypeRuleToken ruleRosNames() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROS_CONVENTION_A_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2068:2: ( (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External ) )
            // InternalRos1Parser.g:2069:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External )
            {
            // InternalRos1Parser.g:2069:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External )
            int alt47=5;
            switch ( input.LA(1) ) {
            case RULE_ROS_CONVENTION_A:
                {
                alt47=1;
                }
                break;
            case RULE_ID:
                {
                alt47=2;
                }
                break;
            case Node:
                {
                alt47=3;
                }
                break;
            case Pluginlib:
                {
                alt47=4;
                }
                break;
            case External:
                {
                alt47=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalRos1Parser.g:2070:3: this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A
                    {
                    this_ROS_CONVENTION_A_0=(Token)match(input,RULE_ROS_CONVENTION_A,FOLLOW_2); 

                    			current.merge(this_ROS_CONVENTION_A_0);
                    		

                    			newLeafNode(this_ROS_CONVENTION_A_0, grammarAccess.getRosNamesAccess().getROS_CONVENTION_ATerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2078:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getRosNamesAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2086:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getNodeKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2092:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getPluginlibKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2098:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getExternalKeyword_4());
                    		

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
    // InternalRos1Parser.g:2107:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRos1Parser.g:2107:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRos1Parser.g:2108:2: iv_ruleExtensionKey= ruleExtensionKey EOF
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
    // InternalRos1Parser.g:2114:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:2120:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRos1Parser.g:2121:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRos1Parser.g:2121:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt48=31;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt48=1;
                }
                break;
            case RULE_STRING:
                {
                alt48=2;
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
                alt48=3;
                }
                break;
            case Node:
                {
                alt48=4;
                }
                break;
            case Pluginlib:
                {
                alt48=5;
                }
                break;
            case External:
                {
                alt48=6;
                }
                break;
            case String:
                {
                alt48=7;
                }
                break;
            case Integer:
                {
                alt48=8;
                }
                break;
            case Double:
                {
                alt48=9;
                }
                break;
            case Boolean:
                {
                alt48=10;
                }
                break;
            case Base64:
                {
                alt48=11;
                }
                break;
            case Array:
                {
                alt48=12;
                }
                break;
            case List:
                {
                alt48=13;
                }
                break;
            case Struct:
                {
                alt48=14;
                }
                break;
            case Date:
                {
                alt48=15;
                }
                break;
            case Any:
                {
                alt48=16;
                }
                break;
            case Bool:
                {
                alt48=17;
                }
                break;
            case Int8:
                {
                alt48=18;
                }
                break;
            case Uint8:
                {
                alt48=19;
                }
                break;
            case Int16:
                {
                alt48=20;
                }
                break;
            case Uint16:
                {
                alt48=21;
                }
                break;
            case Int32:
                {
                alt48=22;
                }
                break;
            case Uint32:
                {
                alt48=23;
                }
                break;
            case Int64:
                {
                alt48=24;
                }
                break;
            case Uint64:
                {
                alt48=25;
                }
                break;
            case Float32:
                {
                alt48=26;
                }
                break;
            case Float64:
                {
                alt48=27;
                }
                break;
            case String_1:
                {
                alt48=28;
                }
                break;
            case Char:
                {
                alt48=29;
                }
                break;
            case Byte:
                {
                alt48=30;
                }
                break;
            case Header:
                {
                alt48=31;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalRos1Parser.g:2122:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2130:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2138:3: this_KEYWORD_2= ruleKEYWORD
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
                    // InternalRos1Parser.g:2149:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2155:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getPluginlibKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2161:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getExternalKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2167:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:2173:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:2179:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:2185:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:2191:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:2197:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:2203:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:2209:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:2215:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:2221:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRos1Parser.g:2227:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRos1Parser.g:2233:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRos1Parser.g:2239:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRos1Parser.g:2245:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRos1Parser.g:2251:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRos1Parser.g:2257:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRos1Parser.g:2263:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalRos1Parser.g:2269:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalRos1Parser.g:2275:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalRos1Parser.g:2281:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalRos1Parser.g:2287:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalRos1Parser.g:2293:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalRos1Parser.g:2299:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalRos1Parser.g:2305:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalRos1Parser.g:2311:3: kw= Header
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
    // InternalRos1Parser.g:2320:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRos1Parser.g:2320:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRos1Parser.g:2321:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
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
    // InternalRos1Parser.g:2327:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2333:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter ) )
            // InternalRos1Parser.g:2334:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter )
            {
            // InternalRos1Parser.g:2334:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter )
            int alt49=23;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt49=1;
                }
                break;
            case Type_1:
                {
                alt49=2;
                }
                break;
            case Value_1:
                {
                alt49=3;
                }
                break;
            case Default:
                {
                alt49=4;
                }
                break;
            case FromGitRepo:
                {
                alt49=5;
                }
                break;
            case Dependencies:
                {
                alt49=6;
                }
                break;
            case Msgs:
                {
                alt49=7;
                }
                break;
            case Srvs:
                {
                alt49=8;
                }
                break;
            case Actions:
                {
                alt49=9;
                }
                break;
            case Node_1:
                {
                alt49=10;
                }
                break;
            case Publishers:
                {
                alt49=11;
                }
                break;
            case Subscribers:
                {
                alt49=12;
                }
                break;
            case Serviceservers:
                {
                alt49=13;
                }
                break;
            case Serviceclients:
                {
                alt49=14;
                }
                break;
            case Actionservers:
                {
                alt49=15;
                }
                break;
            case Actionclients:
                {
                alt49=16;
                }
                break;
            case Parameters:
                {
                alt49=17;
                }
                break;
            case Plugins:
                {
                alt49=18;
                }
                break;
            case Implements:
                {
                alt49=19;
                }
                break;
            case Loader:
                {
                alt49=20;
                }
                break;
            case Pluginslots:
                {
                alt49=21;
                }
                break;
            case Base:
                {
                alt49=22;
                }
                break;
            case Parameter:
                {
                alt49=23;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalRos1Parser.g:2335:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2341:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2347:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2353:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2359:3: kw= FromGitRepo
                    {
                    kw=(Token)match(input,FromGitRepo,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromGitRepoKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2365:3: kw= Dependencies
                    {
                    kw=(Token)match(input,Dependencies,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDependenciesKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2371:3: kw= Msgs
                    {
                    kw=(Token)match(input,Msgs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getMsgsKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:2377:3: kw= Srvs
                    {
                    kw=(Token)match(input,Srvs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSrvsKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:2383:3: kw= Actions
                    {
                    kw=(Token)match(input,Actions,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionsKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:2389:3: kw= Node_1
                    {
                    kw=(Token)match(input,Node_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodeKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:2395:3: kw= Publishers
                    {
                    kw=(Token)match(input,Publishers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPublishersKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:2401:3: kw= Subscribers
                    {
                    kw=(Token)match(input,Subscribers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubscribersKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:2407:3: kw= Serviceservers
                    {
                    kw=(Token)match(input,Serviceservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceserversKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:2413:3: kw= Serviceclients
                    {
                    kw=(Token)match(input,Serviceclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceclientsKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:2419:3: kw= Actionservers
                    {
                    kw=(Token)match(input,Actionservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionserversKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:2425:3: kw= Actionclients
                    {
                    kw=(Token)match(input,Actionclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionclientsKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRos1Parser.g:2431:3: kw= Parameters
                    {
                    kw=(Token)match(input,Parameters,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParametersKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRos1Parser.g:2437:3: kw= Plugins
                    {
                    kw=(Token)match(input,Plugins,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPluginsKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRos1Parser.g:2443:3: kw= Implements
                    {
                    kw=(Token)match(input,Implements,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getImplementsKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRos1Parser.g:2449:3: kw= Loader
                    {
                    kw=(Token)match(input,Loader,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getLoaderKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRos1Parser.g:2455:3: kw= Pluginslots
                    {
                    kw=(Token)match(input,Pluginslots,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPluginslotsKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRos1Parser.g:2461:3: kw= Base
                    {
                    kw=(Token)match(input,Base,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getBaseKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRos1Parser.g:2467:3: kw= Parameter
                    {
                    kw=(Token)match(input,Parameter,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParameterKeyword_22());
                    		

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
    // InternalRos1Parser.g:2476:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // InternalRos1Parser.g:2476:50: (iv_rulePublisher= rulePublisher EOF )
            // InternalRos1Parser.g:2477:2: iv_rulePublisher= rulePublisher EOF
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
    // InternalRos1Parser.g:2483:1: rulePublisher returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2489:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2490:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2490:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2491:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2491:3: ()
            // InternalRos1Parser.g:2492:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPublisherAccess().getPublisherAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2498:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2499:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2499:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2500:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPublisherAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getPublisherAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_46); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPublisherAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getPublisherAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2529:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2530:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2530:4: ( ruleEString )
            // InternalRos1Parser.g:2531:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPublisherRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPublisherAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_47);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2545:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==Ns) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalRos1Parser.g:2546:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getPublisherAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2550:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2551:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2551:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2552:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getPublisherAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:2578:1: entryRuleSubscriber returns [EObject current=null] : iv_ruleSubscriber= ruleSubscriber EOF ;
    public final EObject entryRuleSubscriber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscriber = null;


        try {
            // InternalRos1Parser.g:2578:51: (iv_ruleSubscriber= ruleSubscriber EOF )
            // InternalRos1Parser.g:2579:2: iv_ruleSubscriber= ruleSubscriber EOF
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
    // InternalRos1Parser.g:2585:1: ruleSubscriber returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2591:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2592:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2592:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2593:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2593:3: ()
            // InternalRos1Parser.g:2594:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubscriberAccess().getSubscriberAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2600:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2601:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2601:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2602:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSubscriberAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getSubscriberAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_46); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getSubscriberAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getSubscriberAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2631:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2632:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2632:4: ( ruleEString )
            // InternalRos1Parser.g:2633:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubscriberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubscriberAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_47);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2647:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Ns) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalRos1Parser.g:2648:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getSubscriberAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2652:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2653:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2653:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2654:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getSubscriberAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:2680:1: entryRuleServiceServer returns [EObject current=null] : iv_ruleServiceServer= ruleServiceServer EOF ;
    public final EObject entryRuleServiceServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceServer = null;


        try {
            // InternalRos1Parser.g:2680:54: (iv_ruleServiceServer= ruleServiceServer EOF )
            // InternalRos1Parser.g:2681:2: iv_ruleServiceServer= ruleServiceServer EOF
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
    // InternalRos1Parser.g:2687:1: ruleServiceServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2693:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2694:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2694:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2695:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2695:3: ()
            // InternalRos1Parser.g:2696:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceServerAccess().getServiceServerAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2702:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2703:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2703:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2704:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceServerAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceServerAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_46); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceServerAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2733:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2734:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2734:4: ( ruleEString )
            // InternalRos1Parser.g:2735:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceServerAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_47);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2749:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==Ns) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRos1Parser.g:2750:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2754:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2755:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2755:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2756:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:2782:1: entryRuleServiceClient returns [EObject current=null] : iv_ruleServiceClient= ruleServiceClient EOF ;
    public final EObject entryRuleServiceClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceClient = null;


        try {
            // InternalRos1Parser.g:2782:54: (iv_ruleServiceClient= ruleServiceClient EOF )
            // InternalRos1Parser.g:2783:2: iv_ruleServiceClient= ruleServiceClient EOF
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
    // InternalRos1Parser.g:2789:1: ruleServiceClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2795:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2796:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2796:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2797:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2797:3: ()
            // InternalRos1Parser.g:2798:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceClientAccess().getServiceClientAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2804:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2805:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2805:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2806:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getServiceClientAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getServiceClientAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_46); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceClientAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2835:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2836:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2836:4: ( ruleEString )
            // InternalRos1Parser.g:2837:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceClientAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_47);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2851:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Ns) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalRos1Parser.g:2852:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2856:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2857:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2857:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2858:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getServiceClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:2884:1: entryRuleActionServer returns [EObject current=null] : iv_ruleActionServer= ruleActionServer EOF ;
    public final EObject entryRuleActionServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionServer = null;


        try {
            // InternalRos1Parser.g:2884:53: (iv_ruleActionServer= ruleActionServer EOF )
            // InternalRos1Parser.g:2885:2: iv_ruleActionServer= ruleActionServer EOF
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
    // InternalRos1Parser.g:2891:1: ruleActionServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2897:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2898:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2898:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2899:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2899:3: ()
            // InternalRos1Parser.g:2900:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionServerAccess().getActionServerAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2906:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2907:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2907:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2908:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionServerAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getActionServerAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_46); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getActionServerAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2937:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2938:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2938:4: ( ruleEString )
            // InternalRos1Parser.g:2939:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionServerAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_47);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2953:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==Ns) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRos1Parser.g:2954:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2958:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2959:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2959:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2960:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionServerAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:2986:1: entryRuleActionClient returns [EObject current=null] : iv_ruleActionClient= ruleActionClient EOF ;
    public final EObject entryRuleActionClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionClient = null;


        try {
            // InternalRos1Parser.g:2986:53: (iv_ruleActionClient= ruleActionClient EOF )
            // InternalRos1Parser.g:2987:2: iv_ruleActionClient= ruleActionClient EOF
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
    // InternalRos1Parser.g:2993:1: ruleActionClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2999:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:3000:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:3000:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:3001:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:3001:3: ()
            // InternalRos1Parser.g:3002:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionClientAccess().getActionClientAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3008:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:3009:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:3009:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:3010:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActionClientAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getActionClientAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_46); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getActionClientAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:3039:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:3040:4: ( ruleEString )
            {
            // InternalRos1Parser.g:3040:4: ( ruleEString )
            // InternalRos1Parser.g:3041:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionClientAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_47);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:3055:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==Ns) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalRos1Parser.g:3056:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_48); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:3060:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3061:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3061:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:3062:6: lv_namespace_7_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getActionClientAccess().getNamespaceNamespaceParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:3088:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalRos1Parser.g:3088:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalRos1Parser.g:3089:2: iv_ruleDependency= ruleDependency EOF
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
    // InternalRos1Parser.g:3095:1: ruleDependency returns [EObject current=null] : (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDependency_0 = null;

        EObject this_ExternalDependency_1 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3101:2: ( (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) )
            // InternalRos1Parser.g:3102:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            {
            // InternalRos1Parser.g:3102:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==Pluginlib||LA56_0==External||(LA56_0>=RULE_ID && LA56_0<=RULE_STRING)) ) {
                alt56=1;
            }
            else if ( (LA56_0==ExternalDependency) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalRos1Parser.g:3103:3: this_PackageDependency_0= rulePackageDependency
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
                    // InternalRos1Parser.g:3112:3: this_ExternalDependency_1= ruleExternalDependency
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
    // InternalRos1Parser.g:3124:1: entryRulePackageDependency returns [EObject current=null] : iv_rulePackageDependency= rulePackageDependency EOF ;
    public final EObject entryRulePackageDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDependency = null;


        try {
            // InternalRos1Parser.g:3124:58: (iv_rulePackageDependency= rulePackageDependency EOF )
            // InternalRos1Parser.g:3125:2: iv_rulePackageDependency= rulePackageDependency EOF
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
    // InternalRos1Parser.g:3131:1: rulePackageDependency returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject rulePackageDependency() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos1Parser.g:3137:2: ( ( ( ruleEString ) ) )
            // InternalRos1Parser.g:3138:2: ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:3138:2: ( ( ruleEString ) )
            // InternalRos1Parser.g:3139:3: ( ruleEString )
            {
            // InternalRos1Parser.g:3139:3: ( ruleEString )
            // InternalRos1Parser.g:3140:4: ruleEString
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
    // InternalRos1Parser.g:3157:1: entryRuleExternalDependency returns [EObject current=null] : iv_ruleExternalDependency= ruleExternalDependency EOF ;
    public final EObject entryRuleExternalDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDependency = null;


        try {
            // InternalRos1Parser.g:3157:59: (iv_ruleExternalDependency= ruleExternalDependency EOF )
            // InternalRos1Parser.g:3158:2: iv_ruleExternalDependency= ruleExternalDependency EOF
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
    // InternalRos1Parser.g:3164:1: ruleExternalDependency returns [EObject current=null] : ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleExternalDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3170:2: ( ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalRos1Parser.g:3171:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalRos1Parser.g:3171:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            // InternalRos1Parser.g:3172:3: () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) )
            {
            // InternalRos1Parser.g:3172:3: ()
            // InternalRos1Parser.g:3173:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalDependencyAccess().getExternalDependencyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExternalDependency,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalDependencyAccess().getExternalDependencyKeyword_1());
            		
            // InternalRos1Parser.g:3183:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRos1Parser.g:3184:4: (lv_name_2_0= ruleEString )
            {
            // InternalRos1Parser.g:3184:4: (lv_name_2_0= ruleEString )
            // InternalRos1Parser.g:3185:5: lv_name_2_0= ruleEString
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
    // InternalRos1Parser.g:3206:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRos1Parser.g:3206:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRos1Parser.g:3207:2: iv_ruleNamespace= ruleNamespace EOF
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
    // InternalRos1Parser.g:3213:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3219:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRos1Parser.g:3220:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRos1Parser.g:3220:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt57=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt57=1;
                }
                break;
            case RelativeNamespace:
                {
                alt57=2;
                }
                break;
            case PrivateNamespace:
                {
                alt57=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalRos1Parser.g:3221:3: this_GlobalNamespace_0= ruleGlobalNamespace
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
                    // InternalRos1Parser.g:3230:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
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
                    // InternalRos1Parser.g:3239:3: this_PrivateNamespace_2= rulePrivateNamespace
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
    // InternalRos1Parser.g:3251:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRos1Parser.g:3251:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRos1Parser.g:3252:2: iv_ruleGraphName= ruleGraphName EOF
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
    // InternalRos1Parser.g:3258:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:3264:2: (kw= GraphName )
            // InternalRos1Parser.g:3265:2: kw= GraphName
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
    // InternalRos1Parser.g:3273:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRos1Parser.g:3273:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRos1Parser.g:3274:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
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
    // InternalRos1Parser.g:3280:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3286:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3287:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3287:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3288:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3288:3: ()
            // InternalRos1Parser.g:3289:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3299:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==LeftSquareBracket) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRos1Parser.g:3300:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_50); 

                    				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3304:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3305:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3305:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3306:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
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

                    // InternalRos1Parser.g:3323:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==Comma) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3324:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_50); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3328:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3329:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3329:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3330:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getGlobalNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
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
                    	    break loop58;
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
    // InternalRos1Parser.g:3357:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRos1Parser.g:3357:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRos1Parser.g:3358:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
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
    // InternalRos1Parser.g:3364:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3370:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3371:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3371:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3372:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3372:3: ()
            // InternalRos1Parser.g:3373:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3383:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==LeftSquareBracket) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRos1Parser.g:3384:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_50); 

                    				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3388:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3389:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3389:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3390:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
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

                    // InternalRos1Parser.g:3407:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==Comma) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3408:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_50); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3412:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3413:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3413:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3414:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getRelativeNamespace_ImplAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
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
                    	    break loop60;
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
    // InternalRos1Parser.g:3441:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRos1Parser.g:3441:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRos1Parser.g:3442:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
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
    // InternalRos1Parser.g:3448:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3454:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3455:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3455:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3456:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3456:3: ()
            // InternalRos1Parser.g:3457:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_49); 

            			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3467:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==LeftSquareBracket) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRos1Parser.g:3468:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_50); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3472:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3473:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3473:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3474:6: lv_parts_3_0= ruleGraphName
                    {

                    						newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_12);
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

                    // InternalRos1Parser.g:3491:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==Comma) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3492:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_50); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3496:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3497:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3497:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3498:7: lv_parts_5_0= ruleGraphName
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrivateNamespaceAccess().getPartsGraphNameParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
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
                    	    break loop62;
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
    // InternalRos1Parser.g:3525:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRos1Parser.g:3525:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRos1Parser.g:3526:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRos1Parser.g:3532:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) ;
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
            // InternalRos1Parser.g:3538:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) )
            // InternalRos1Parser.g:3539:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            {
            // InternalRos1Parser.g:3539:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            // InternalRos1Parser.g:3540:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END
            {
            // InternalRos1Parser.g:3540:3: ()
            // InternalRos1Parser.g:3541:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3547:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:3548:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:3548:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:3549:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_51); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos1Parser.g:3574:3: (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==Ns) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalRos1Parser.g:3575:4: otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) )
                    {
                    otherlv_4=(Token)match(input,Ns,FOLLOW_48); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getNsKeyword_4_0());
                    			
                    // InternalRos1Parser.g:3579:4: ( (lv_namespace_5_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3580:5: (lv_namespace_5_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3580:5: (lv_namespace_5_0= ruleNamespace )
                    // InternalRos1Parser.g:3581:6: lv_namespace_5_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_46);
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

            otherlv_6=(Token)match(input,Type_1,FOLLOW_52); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getTypeKeyword_5());
            		
            // InternalRos1Parser.g:3603:3: ( (lv_type_7_0= ruleParameterType ) )
            // InternalRos1Parser.g:3604:4: (lv_type_7_0= ruleParameterType )
            {
            // InternalRos1Parser.g:3604:4: (lv_type_7_0= ruleParameterType )
            // InternalRos1Parser.g:3605:5: lv_type_7_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_53);
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

            // InternalRos1Parser.g:3622:3: (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==Value_1) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRos1Parser.g:3623:4: otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) )
                    {
                    otherlv_8=(Token)match(input,Value_1,FOLLOW_54); 

                    				newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getValueKeyword_7_0());
                    			
                    // InternalRos1Parser.g:3627:4: ( (lv_value_9_0= ruleParameterValue ) )
                    // InternalRos1Parser.g:3628:5: (lv_value_9_0= ruleParameterValue )
                    {
                    // InternalRos1Parser.g:3628:5: (lv_value_9_0= ruleParameterValue )
                    // InternalRos1Parser.g:3629:6: lv_value_9_0= ruleParameterValue
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getValueParameterValueParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
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
    // InternalRos1Parser.g:3655:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRos1Parser.g:3655:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRos1Parser.g:3656:2: iv_ruleParameterType= ruleParameterType EOF
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
    // InternalRos1Parser.g:3662:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
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
            // InternalRos1Parser.g:3668:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRos1Parser.g:3669:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRos1Parser.g:3669:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt66=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt66=1;
                }
                break;
            case Struct:
                {
                alt66=2;
                }
                break;
            case Integer:
                {
                alt66=3;
                }
                break;
            case String:
                {
                alt66=4;
                }
                break;
            case Double:
                {
                alt66=5;
                }
                break;
            case Boolean:
                {
                alt66=6;
                }
                break;
            case Base64:
                {
                alt66=7;
                }
                break;
            case Array:
                {
                alt66=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalRos1Parser.g:3670:3: this_ParameterListType_0= ruleParameterListType
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
                    // InternalRos1Parser.g:3679:3: this_ParameterStructType_1= ruleParameterStructType
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
                    // InternalRos1Parser.g:3688:3: this_ParameterIntegerType_2= ruleParameterIntegerType
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
                    // InternalRos1Parser.g:3697:3: this_ParameterStringType_3= ruleParameterStringType
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
                    // InternalRos1Parser.g:3706:3: this_ParameterDoubleType_4= ruleParameterDoubleType
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
                    // InternalRos1Parser.g:3715:3: this_ParameterBooleanType_5= ruleParameterBooleanType
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
                    // InternalRos1Parser.g:3724:3: this_ParameterBase64Type_6= ruleParameterBase64Type
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
                    // InternalRos1Parser.g:3733:3: this_ParameterArrayType_7= ruleParameterArrayType
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
    // InternalRos1Parser.g:3745:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRos1Parser.g:3745:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRos1Parser.g:3746:2: iv_ruleParameterValue= ruleParameterValue EOF
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
    // InternalRos1Parser.g:3752:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
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
            // InternalRos1Parser.g:3758:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRos1Parser.g:3759:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRos1Parser.g:3759:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt67=7;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // InternalRos1Parser.g:3760:3: this_ParameterString_0= ruleParameterString
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
                    // InternalRos1Parser.g:3769:3: this_ParameterBase64_1= ruleParameterBase64
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
                    // InternalRos1Parser.g:3778:3: this_ParameterInteger_2= ruleParameterInteger
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
                    // InternalRos1Parser.g:3787:3: this_ParameterDouble_3= ruleParameterDouble
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
                    // InternalRos1Parser.g:3796:3: this_ParameterBoolean_4= ruleParameterBoolean
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
                    // InternalRos1Parser.g:3805:3: this_ParameterList_5= ruleParameterList
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
                    // InternalRos1Parser.g:3814:3: this_ParameterStruct_6= ruleParameterStruct
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
    // InternalRos1Parser.g:3826:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRos1Parser.g:3826:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRos1Parser.g:3827:2: iv_ruleParameterListType= ruleParameterListType EOF
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
    // InternalRos1Parser.g:3833:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRos1Parser.g:3839:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos1Parser.g:3840:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos1Parser.g:3840:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos1Parser.g:3841:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos1Parser.g:3841:3: ()
            // InternalRos1Parser.g:3842:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,List,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos1Parser.g:3856:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRos1Parser.g:3857:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRos1Parser.g:3857:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRos1Parser.g:3858:5: lv_sequence_3_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalRos1Parser.g:3875:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==Comma) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalRos1Parser.g:3876:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_52); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos1Parser.g:3880:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRos1Parser.g:3881:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRos1Parser.g:3881:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRos1Parser.g:3882:6: lv_sequence_5_0= ruleParameterType
            	    {

            	    						newCompositeNode(grammarAccess.getParameterListTypeAccess().getSequenceParameterTypeParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	    break loop68;
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
    // InternalRos1Parser.g:3908:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRos1Parser.g:3908:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRos1Parser.g:3909:2: iv_ruleParameterStructType= ruleParameterStructType EOF
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
    // InternalRos1Parser.g:3915:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRos1Parser.g:3921:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos1Parser.g:3922:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos1Parser.g:3922:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos1Parser.g:3923:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos1Parser.g:3923:3: ()
            // InternalRos1Parser.g:3924:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos1Parser.g:3938:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRos1Parser.g:3939:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRos1Parser.g:3939:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRos1Parser.g:3940:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalRos1Parser.g:3957:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==Comma) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalRos1Parser.g:3958:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_6); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos1Parser.g:3962:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRos1Parser.g:3963:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRos1Parser.g:3963:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRos1Parser.g:3964:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
            	    {

            	    						newCompositeNode(grammarAccess.getParameterStructTypeAccess().getParameterstructypetmemberParameterStructTypeMemberParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	    break loop69;
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
    // InternalRos1Parser.g:3990:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRos1Parser.g:3990:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRos1Parser.g:3991:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
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
    // InternalRos1Parser.g:3997:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4003:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRos1Parser.g:4004:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRos1Parser.g:4004:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRos1Parser.g:4005:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRos1Parser.g:4005:3: ()
            // InternalRos1Parser.g:4006:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
            		
            // InternalRos1Parser.g:4016:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==Default) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRos1Parser.g:4017:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_56); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4021:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRos1Parser.g:4022:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRos1Parser.g:4022:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRos1Parser.g:4023:6: lv_default_3_0= ruleParameterInteger
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
    // InternalRos1Parser.g:4045:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRos1Parser.g:4045:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRos1Parser.g:4046:2: iv_ruleParameterStringType= ruleParameterStringType EOF
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
    // InternalRos1Parser.g:4052:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4058:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRos1Parser.g:4059:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRos1Parser.g:4059:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRos1Parser.g:4060:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRos1Parser.g:4060:3: ()
            // InternalRos1Parser.g:4061:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
            		
            // InternalRos1Parser.g:4071:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==Default) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalRos1Parser.g:4072:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4076:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRos1Parser.g:4077:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRos1Parser.g:4077:5: (lv_default_3_0= ruleParameterString )
                    // InternalRos1Parser.g:4078:6: lv_default_3_0= ruleParameterString
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
    // InternalRos1Parser.g:4100:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRos1Parser.g:4100:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRos1Parser.g:4101:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
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
    // InternalRos1Parser.g:4107:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4113:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRos1Parser.g:4114:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRos1Parser.g:4114:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRos1Parser.g:4115:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRos1Parser.g:4115:3: ()
            // InternalRos1Parser.g:4116:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
            		
            // InternalRos1Parser.g:4126:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==Default) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalRos1Parser.g:4127:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_57); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4131:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRos1Parser.g:4132:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRos1Parser.g:4132:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRos1Parser.g:4133:6: lv_default_3_0= ruleParameterDouble
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
    // InternalRos1Parser.g:4155:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRos1Parser.g:4155:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRos1Parser.g:4156:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
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
    // InternalRos1Parser.g:4162:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4168:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRos1Parser.g:4169:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRos1Parser.g:4169:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRos1Parser.g:4170:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRos1Parser.g:4170:3: ()
            // InternalRos1Parser.g:4171:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalRos1Parser.g:4181:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==Default) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRos1Parser.g:4182:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_58); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4186:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRos1Parser.g:4187:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRos1Parser.g:4187:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRos1Parser.g:4188:6: lv_default_3_0= ruleParameterBoolean
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
    // InternalRos1Parser.g:4210:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRos1Parser.g:4210:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRos1Parser.g:4211:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
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
    // InternalRos1Parser.g:4217:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4223:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRos1Parser.g:4224:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRos1Parser.g:4224:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRos1Parser.g:4225:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRos1Parser.g:4225:3: ()
            // InternalRos1Parser.g:4226:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
            		
            // InternalRos1Parser.g:4236:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==Default) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRos1Parser.g:4237:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_59); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4241:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRos1Parser.g:4242:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRos1Parser.g:4242:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRos1Parser.g:4243:6: lv_default_3_0= ruleParameterBase64
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
    // InternalRos1Parser.g:4265:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRos1Parser.g:4265:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRos1Parser.g:4266:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
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
    // InternalRos1Parser.g:4272:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
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
            // InternalRos1Parser.g:4278:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRos1Parser.g:4279:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRos1Parser.g:4279:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRos1Parser.g:4280:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
            		
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:4288:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRos1Parser.g:4289:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRos1Parser.g:4289:4: (lv_type_2_0= ruleParameterType )
            // InternalRos1Parser.g:4290:5: lv_type_2_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterArrayTypeAccess().getTypeParameterTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_60);
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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_55); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
            		
            // InternalRos1Parser.g:4311:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==Default) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalRos1Parser.g:4312:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                    			
                    // InternalRos1Parser.g:4316:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRos1Parser.g:4317:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRos1Parser.g:4317:5: (lv_default_5_0= ruleParameterList )
                    // InternalRos1Parser.g:4318:6: lv_default_5_0= ruleParameterList
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
    // InternalRos1Parser.g:4340:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRos1Parser.g:4340:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRos1Parser.g:4341:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRos1Parser.g:4347:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4353:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRos1Parser.g:4354:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRos1Parser.g:4354:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRos1Parser.g:4355:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRos1Parser.g:4355:3: ()
            // InternalRos1Parser.g:4356:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_54); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:4366:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRos1Parser.g:4367:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRos1Parser.g:4367:4: (lv_value_2_0= ruleParameterValue )
            // InternalRos1Parser.g:4368:5: lv_value_2_0= ruleParameterValue
            {

            					newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
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

            // InternalRos1Parser.g:4385:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==Comma) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalRos1Parser.g:4386:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_54); 

            	    				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRos1Parser.g:4390:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRos1Parser.g:4391:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRos1Parser.g:4391:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRos1Parser.g:4392:6: lv_value_4_0= ruleParameterValue
            	    {

            	    						newCompositeNode(grammarAccess.getParameterListAccess().getValueParameterValueParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
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
            	    break loop76;
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
    // InternalRos1Parser.g:4418:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRos1Parser.g:4418:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRos1Parser.g:4419:2: iv_ruleParameterAny= ruleParameterAny EOF
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
    // InternalRos1Parser.g:4425:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4431:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRos1Parser.g:4432:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRos1Parser.g:4432:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRos1Parser.g:4433:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRos1Parser.g:4433:3: ()
            // InternalRos1Parser.g:4434:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_61); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
            		
            // InternalRos1Parser.g:4444:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==Value) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalRos1Parser.g:4445:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4449:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRos1Parser.g:4450:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRos1Parser.g:4450:5: (lv_value_3_0= ruleEString )
                    // InternalRos1Parser.g:4451:6: lv_value_3_0= ruleEString
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
    // InternalRos1Parser.g:4473:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRos1Parser.g:4473:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRos1Parser.g:4474:2: iv_ruleParameterString= ruleParameterString EOF
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
    // InternalRos1Parser.g:4480:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4486:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRos1Parser.g:4487:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRos1Parser.g:4487:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRos1Parser.g:4488:3: (lv_value_0_0= ruleEString )
            {
            // InternalRos1Parser.g:4488:3: (lv_value_0_0= ruleEString )
            // InternalRos1Parser.g:4489:4: lv_value_0_0= ruleEString
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
    // InternalRos1Parser.g:4509:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRos1Parser.g:4509:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRos1Parser.g:4510:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
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
    // InternalRos1Parser.g:4516:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4522:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRos1Parser.g:4523:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRos1Parser.g:4523:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRos1Parser.g:4524:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRos1Parser.g:4524:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRos1Parser.g:4525:4: lv_value_0_0= ruleBase64Binary
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
    // InternalRos1Parser.g:4545:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRos1Parser.g:4545:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRos1Parser.g:4546:2: iv_ruleParameterInteger= ruleParameterInteger EOF
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
    // InternalRos1Parser.g:4552:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4558:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRos1Parser.g:4559:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRos1Parser.g:4559:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRos1Parser.g:4560:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRos1Parser.g:4560:3: (lv_value_0_0= ruleInteger0 )
            // InternalRos1Parser.g:4561:4: lv_value_0_0= ruleInteger0
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
    // InternalRos1Parser.g:4581:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRos1Parser.g:4581:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRos1Parser.g:4582:2: iv_ruleParameterDouble= ruleParameterDouble EOF
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
    // InternalRos1Parser.g:4588:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4594:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRos1Parser.g:4595:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRos1Parser.g:4595:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRos1Parser.g:4596:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRos1Parser.g:4596:3: (lv_value_0_0= ruleDouble0 )
            // InternalRos1Parser.g:4597:4: lv_value_0_0= ruleDouble0
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
    // InternalRos1Parser.g:4617:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRos1Parser.g:4617:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRos1Parser.g:4618:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
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
    // InternalRos1Parser.g:4624:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4630:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRos1Parser.g:4631:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRos1Parser.g:4631:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRos1Parser.g:4632:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRos1Parser.g:4632:3: (lv_value_0_0= ruleboolean0 )
            // InternalRos1Parser.g:4633:4: lv_value_0_0= ruleboolean0
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
    // InternalRos1Parser.g:4653:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRos1Parser.g:4653:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRos1Parser.g:4654:2: iv_ruleParameterStruct= ruleParameterStruct EOF
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
    // InternalRos1Parser.g:4660:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4666:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRos1Parser.g:4667:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRos1Parser.g:4667:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRos1Parser.g:4668:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRos1Parser.g:4668:3: ()
            // InternalRos1Parser.g:4669:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:4675:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==LeftSquareBracket) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalRos1Parser.g:4676:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_62); 

                    				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                    			
                    // InternalRos1Parser.g:4684:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==Pluginlib||LA78_0==External||(LA78_0>=RULE_ID && LA78_0<=RULE_STRING)) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // InternalRos1Parser.g:4685:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRos1Parser.g:4685:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRos1Parser.g:4686:6: lv_value_3_0= ruleParameterStructMember
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterStructAccess().getValueParameterStructMemberParserRuleCall_1_2_0());
                    	    					
                    	    pushFollow(FOLLOW_62);
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
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_13); 

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
    // InternalRos1Parser.g:4716:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRos1Parser.g:4716:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRos1Parser.g:4717:2: iv_ruleParameterDate= ruleParameterDate EOF
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
    // InternalRos1Parser.g:4723:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4729:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRos1Parser.g:4730:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRos1Parser.g:4730:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRos1Parser.g:4731:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRos1Parser.g:4731:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRos1Parser.g:4732:4: lv_value_0_0= ruleDateTime0
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
    // InternalRos1Parser.g:4752:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRos1Parser.g:4752:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRos1Parser.g:4753:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
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
    // InternalRos1Parser.g:4759:1: ruleParameterStructMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4765:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) )
            // InternalRos1Parser.g:4766:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            {
            // InternalRos1Parser.g:4766:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            // InternalRos1Parser.g:4767:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) )
            {
            // InternalRos1Parser.g:4767:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRos1Parser.g:4768:4: (lv_name_0_0= ruleEString )
            {
            // InternalRos1Parser.g:4768:4: (lv_name_0_0= ruleEString )
            // InternalRos1Parser.g:4769:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_1=(Token)match(input,Colon,FOLLOW_54); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_1());
            		
            // InternalRos1Parser.g:4790:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRos1Parser.g:4791:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRos1Parser.g:4791:4: (lv_value_2_0= ruleParameterValue )
            // InternalRos1Parser.g:4792:5: lv_value_2_0= ruleParameterValue
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
    // InternalRos1Parser.g:4813:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRos1Parser.g:4813:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRos1Parser.g:4814:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
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
    // InternalRos1Parser.g:4820:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4826:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRos1Parser.g:4827:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRos1Parser.g:4827:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRos1Parser.g:4828:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRos1Parser.g:4828:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRos1Parser.g:4829:4: (lv_name_0_0= ruleEString )
            {
            // InternalRos1Parser.g:4829:4: (lv_name_0_0= ruleEString )
            // InternalRos1Parser.g:4830:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_52);
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

            // InternalRos1Parser.g:4847:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRos1Parser.g:4848:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRos1Parser.g:4848:4: (lv_type_1_0= ruleParameterType )
            // InternalRos1Parser.g:4849:5: lv_type_1_0= ruleParameterType
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
    // InternalRos1Parser.g:4870:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRos1Parser.g:4870:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRos1Parser.g:4871:2: iv_ruleBase64Binary= ruleBase64Binary EOF
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
    // InternalRos1Parser.g:4877:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:4883:2: (this_BINARY_0= RULE_BINARY )
            // InternalRos1Parser.g:4884:2: this_BINARY_0= RULE_BINARY
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
    // InternalRos1Parser.g:4894:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRos1Parser.g:4894:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRos1Parser.g:4895:2: iv_ruleboolean0= ruleboolean0 EOF
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
    // InternalRos1Parser.g:4901:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:4907:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRos1Parser.g:4908:2: this_BOOLEAN_0= RULE_BOOLEAN
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
    // InternalRos1Parser.g:4918:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRos1Parser.g:4918:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRos1Parser.g:4919:2: iv_ruleDouble0= ruleDouble0 EOF
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
    // InternalRos1Parser.g:4925:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:4931:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRos1Parser.g:4932:2: this_DOUBLE_0= RULE_DOUBLE
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
    // InternalRos1Parser.g:4942:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRos1Parser.g:4942:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRos1Parser.g:4943:2: iv_ruleInteger0= ruleInteger0 EOF
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
    // InternalRos1Parser.g:4949:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:4955:2: (this_DECINT_0= RULE_DECINT )
            // InternalRos1Parser.g:4956:2: this_DECINT_0= RULE_DECINT
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
    // InternalRos1Parser.g:4966:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRos1Parser.g:4966:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRos1Parser.g:4967:2: iv_ruleDateTime0= ruleDateTime0 EOF
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
    // InternalRos1Parser.g:4973:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:4979:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRos1Parser.g:4980:2: this_DATE_TIME_0= RULE_DATE_TIME
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
    // InternalRos1Parser.g:4990:1: entryRuleMessagePart returns [EObject current=null] : iv_ruleMessagePart= ruleMessagePart EOF ;
    public final EObject entryRuleMessagePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePart = null;


        try {
            // InternalRos1Parser.g:4990:52: (iv_ruleMessagePart= ruleMessagePart EOF )
            // InternalRos1Parser.g:4991:2: iv_ruleMessagePart= ruleMessagePart EOF
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
    // InternalRos1Parser.g:4997:1: ruleMessagePart returns [EObject current=null] : ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) ;
    public final EObject ruleMessagePart() throws RecognitionException {
        EObject current = null;

        Token lv_Data_1_2=null;
        EObject lv_Type_0_0 = null;

        AntlrDatatypeRuleToken lv_Data_1_1 = null;

        AntlrDatatypeRuleToken lv_Data_1_3 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5003:2: ( ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) )
            // InternalRos1Parser.g:5004:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            {
            // InternalRos1Parser.g:5004:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            // InternalRos1Parser.g:5005:3: ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            {
            // InternalRos1Parser.g:5005:3: ( (lv_Type_0_0= ruleAbstractType ) )
            // InternalRos1Parser.g:5006:4: (lv_Type_0_0= ruleAbstractType )
            {
            // InternalRos1Parser.g:5006:4: (lv_Type_0_0= ruleAbstractType )
            // InternalRos1Parser.g:5007:5: lv_Type_0_0= ruleAbstractType
            {

            					newCompositeNode(grammarAccess.getMessagePartAccess().getTypeAbstractTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_63);
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

            // InternalRos1Parser.g:5024:3: ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            // InternalRos1Parser.g:5025:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            {
            // InternalRos1Parser.g:5025:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            // InternalRos1Parser.g:5026:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            {
            // InternalRos1Parser.g:5026:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            int alt80=3;
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
                alt80=1;
                }
                break;
            case RULE_MESSAGE_ASIGMENT:
                {
                alt80=2;
                }
                break;
            case Pluginlib:
            case External:
            case RULE_ID:
            case RULE_STRING:
                {
                alt80=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // InternalRos1Parser.g:5027:6: lv_Data_1_1= ruleKEYWORD
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
                    // InternalRos1Parser.g:5043:6: lv_Data_1_2= RULE_MESSAGE_ASIGMENT
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
                    // InternalRos1Parser.g:5058:6: lv_Data_1_3= ruleEString
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
    // InternalRos1Parser.g:5080:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRos1Parser.g:5080:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRos1Parser.g:5081:2: iv_ruleAbstractType= ruleAbstractType EOF
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
    // InternalRos1Parser.g:5087:1: ruleAbstractType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
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
            // InternalRos1Parser.g:5093:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRos1Parser.g:5094:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRos1Parser.g:5094:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt81=33;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // InternalRos1Parser.g:5095:3: this_bool_0= rulebool
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
                    // InternalRos1Parser.g:5104:3: this_int8_1= ruleint8
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
                    // InternalRos1Parser.g:5113:3: this_uint8_2= ruleuint8
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
                    // InternalRos1Parser.g:5122:3: this_int16_3= ruleint16
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
                    // InternalRos1Parser.g:5131:3: this_uint16_4= ruleuint16
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
                    // InternalRos1Parser.g:5140:3: this_int32_5= ruleint32
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
                    // InternalRos1Parser.g:5149:3: this_uint32_6= ruleuint32
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
                    // InternalRos1Parser.g:5158:3: this_int64_7= ruleint64
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
                    // InternalRos1Parser.g:5167:3: this_uint64_8= ruleuint64
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
                    // InternalRos1Parser.g:5176:3: this_float32_9= rulefloat32
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
                    // InternalRos1Parser.g:5185:3: this_float64_10= rulefloat64
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
                    // InternalRos1Parser.g:5194:3: this_string0_11= rulestring0
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
                    // InternalRos1Parser.g:5203:3: this_byte_12= rulebyte
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
                    // InternalRos1Parser.g:5212:3: this_time_13= ruletime
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
                    // InternalRos1Parser.g:5221:3: this_duration_14= ruleduration
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
                    // InternalRos1Parser.g:5230:3: this_Header_15= ruleHeader
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
                    // InternalRos1Parser.g:5239:3: this_boolArray_16= ruleboolArray
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
                    // InternalRos1Parser.g:5248:3: this_int8Array_17= ruleint8Array
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
                    // InternalRos1Parser.g:5257:3: this_uint8Array_18= ruleuint8Array
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
                    // InternalRos1Parser.g:5266:3: this_int16Array_19= ruleint16Array
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
                    // InternalRos1Parser.g:5275:3: this_uint16Array_20= ruleuint16Array
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
                    // InternalRos1Parser.g:5284:3: this_int32Array_21= ruleint32Array
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
                    // InternalRos1Parser.g:5293:3: this_uint32Array_22= ruleuint32Array
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
                    // InternalRos1Parser.g:5302:3: this_int64Array_23= ruleint64Array
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
                    // InternalRos1Parser.g:5311:3: this_uint64Array_24= ruleuint64Array
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
                    // InternalRos1Parser.g:5320:3: this_float32Array_25= rulefloat32Array
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
                    // InternalRos1Parser.g:5329:3: this_float64Array_26= rulefloat64Array
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
                    // InternalRos1Parser.g:5338:3: this_string0Array_27= rulestring0Array
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
                    // InternalRos1Parser.g:5347:3: this_byteArray_28= rulebyteArray
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
                    // InternalRos1Parser.g:5356:3: this_SpecBaseRef_29= ruleSpecBaseRef
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
                    // InternalRos1Parser.g:5365:3: this_ArraySpecRef_30= ruleArraySpecRef
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
                    // InternalRos1Parser.g:5374:3: this_char_31= rulechar
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
                    // InternalRos1Parser.g:5383:3: this_charArray_32= rulecharArray
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
    // InternalRos1Parser.g:5395:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRos1Parser.g:5395:45: (iv_rulebool= rulebool EOF )
            // InternalRos1Parser.g:5396:2: iv_rulebool= rulebool EOF
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
    // InternalRos1Parser.g:5402:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5408:2: ( ( () otherlv_1= Bool ) )
            // InternalRos1Parser.g:5409:2: ( () otherlv_1= Bool )
            {
            // InternalRos1Parser.g:5409:2: ( () otherlv_1= Bool )
            // InternalRos1Parser.g:5410:3: () otherlv_1= Bool
            {
            // InternalRos1Parser.g:5410:3: ()
            // InternalRos1Parser.g:5411:4: 
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
    // InternalRos1Parser.g:5425:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRos1Parser.g:5425:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRos1Parser.g:5426:2: iv_ruleint8= ruleint8 EOF
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
    // InternalRos1Parser.g:5432:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5438:2: ( ( () otherlv_1= Int8 ) )
            // InternalRos1Parser.g:5439:2: ( () otherlv_1= Int8 )
            {
            // InternalRos1Parser.g:5439:2: ( () otherlv_1= Int8 )
            // InternalRos1Parser.g:5440:3: () otherlv_1= Int8
            {
            // InternalRos1Parser.g:5440:3: ()
            // InternalRos1Parser.g:5441:4: 
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
    // InternalRos1Parser.g:5455:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRos1Parser.g:5455:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRos1Parser.g:5456:2: iv_ruleuint8= ruleuint8 EOF
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
    // InternalRos1Parser.g:5462:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5468:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRos1Parser.g:5469:2: ( () otherlv_1= Uint8 )
            {
            // InternalRos1Parser.g:5469:2: ( () otherlv_1= Uint8 )
            // InternalRos1Parser.g:5470:3: () otherlv_1= Uint8
            {
            // InternalRos1Parser.g:5470:3: ()
            // InternalRos1Parser.g:5471:4: 
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
    // InternalRos1Parser.g:5485:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRos1Parser.g:5485:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRos1Parser.g:5486:2: iv_ruleint16= ruleint16 EOF
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
    // InternalRos1Parser.g:5492:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5498:2: ( ( () otherlv_1= Int16 ) )
            // InternalRos1Parser.g:5499:2: ( () otherlv_1= Int16 )
            {
            // InternalRos1Parser.g:5499:2: ( () otherlv_1= Int16 )
            // InternalRos1Parser.g:5500:3: () otherlv_1= Int16
            {
            // InternalRos1Parser.g:5500:3: ()
            // InternalRos1Parser.g:5501:4: 
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
    // InternalRos1Parser.g:5515:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRos1Parser.g:5515:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRos1Parser.g:5516:2: iv_ruleuint16= ruleuint16 EOF
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
    // InternalRos1Parser.g:5522:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5528:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRos1Parser.g:5529:2: ( () otherlv_1= Uint16 )
            {
            // InternalRos1Parser.g:5529:2: ( () otherlv_1= Uint16 )
            // InternalRos1Parser.g:5530:3: () otherlv_1= Uint16
            {
            // InternalRos1Parser.g:5530:3: ()
            // InternalRos1Parser.g:5531:4: 
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
    // InternalRos1Parser.g:5545:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRos1Parser.g:5545:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRos1Parser.g:5546:2: iv_ruleint32= ruleint32 EOF
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
    // InternalRos1Parser.g:5552:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5558:2: ( ( () otherlv_1= Int32 ) )
            // InternalRos1Parser.g:5559:2: ( () otherlv_1= Int32 )
            {
            // InternalRos1Parser.g:5559:2: ( () otherlv_1= Int32 )
            // InternalRos1Parser.g:5560:3: () otherlv_1= Int32
            {
            // InternalRos1Parser.g:5560:3: ()
            // InternalRos1Parser.g:5561:4: 
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
    // InternalRos1Parser.g:5575:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRos1Parser.g:5575:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRos1Parser.g:5576:2: iv_ruleuint32= ruleuint32 EOF
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
    // InternalRos1Parser.g:5582:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5588:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRos1Parser.g:5589:2: ( () otherlv_1= Uint32 )
            {
            // InternalRos1Parser.g:5589:2: ( () otherlv_1= Uint32 )
            // InternalRos1Parser.g:5590:3: () otherlv_1= Uint32
            {
            // InternalRos1Parser.g:5590:3: ()
            // InternalRos1Parser.g:5591:4: 
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
    // InternalRos1Parser.g:5605:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRos1Parser.g:5605:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRos1Parser.g:5606:2: iv_ruleint64= ruleint64 EOF
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
    // InternalRos1Parser.g:5612:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5618:2: ( ( () otherlv_1= Int64 ) )
            // InternalRos1Parser.g:5619:2: ( () otherlv_1= Int64 )
            {
            // InternalRos1Parser.g:5619:2: ( () otherlv_1= Int64 )
            // InternalRos1Parser.g:5620:3: () otherlv_1= Int64
            {
            // InternalRos1Parser.g:5620:3: ()
            // InternalRos1Parser.g:5621:4: 
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
    // InternalRos1Parser.g:5635:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRos1Parser.g:5635:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRos1Parser.g:5636:2: iv_ruleuint64= ruleuint64 EOF
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
    // InternalRos1Parser.g:5642:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5648:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRos1Parser.g:5649:2: ( () otherlv_1= Uint64 )
            {
            // InternalRos1Parser.g:5649:2: ( () otherlv_1= Uint64 )
            // InternalRos1Parser.g:5650:3: () otherlv_1= Uint64
            {
            // InternalRos1Parser.g:5650:3: ()
            // InternalRos1Parser.g:5651:4: 
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
    // InternalRos1Parser.g:5665:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRos1Parser.g:5665:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRos1Parser.g:5666:2: iv_rulefloat32= rulefloat32 EOF
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
    // InternalRos1Parser.g:5672:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5678:2: ( ( () otherlv_1= Float32 ) )
            // InternalRos1Parser.g:5679:2: ( () otherlv_1= Float32 )
            {
            // InternalRos1Parser.g:5679:2: ( () otherlv_1= Float32 )
            // InternalRos1Parser.g:5680:3: () otherlv_1= Float32
            {
            // InternalRos1Parser.g:5680:3: ()
            // InternalRos1Parser.g:5681:4: 
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
    // InternalRos1Parser.g:5695:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRos1Parser.g:5695:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRos1Parser.g:5696:2: iv_rulefloat64= rulefloat64 EOF
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
    // InternalRos1Parser.g:5702:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5708:2: ( ( () otherlv_1= Float64 ) )
            // InternalRos1Parser.g:5709:2: ( () otherlv_1= Float64 )
            {
            // InternalRos1Parser.g:5709:2: ( () otherlv_1= Float64 )
            // InternalRos1Parser.g:5710:3: () otherlv_1= Float64
            {
            // InternalRos1Parser.g:5710:3: ()
            // InternalRos1Parser.g:5711:4: 
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
    // InternalRos1Parser.g:5725:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRos1Parser.g:5725:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRos1Parser.g:5726:2: iv_rulestring0= rulestring0 EOF
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
    // InternalRos1Parser.g:5732:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5738:2: ( ( () otherlv_1= String_1 ) )
            // InternalRos1Parser.g:5739:2: ( () otherlv_1= String_1 )
            {
            // InternalRos1Parser.g:5739:2: ( () otherlv_1= String_1 )
            // InternalRos1Parser.g:5740:3: () otherlv_1= String_1
            {
            // InternalRos1Parser.g:5740:3: ()
            // InternalRos1Parser.g:5741:4: 
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
    // InternalRos1Parser.g:5755:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRos1Parser.g:5755:45: (iv_rulechar= rulechar EOF )
            // InternalRos1Parser.g:5756:2: iv_rulechar= rulechar EOF
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
    // InternalRos1Parser.g:5762:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5768:2: ( ( () otherlv_1= Char ) )
            // InternalRos1Parser.g:5769:2: ( () otherlv_1= Char )
            {
            // InternalRos1Parser.g:5769:2: ( () otherlv_1= Char )
            // InternalRos1Parser.g:5770:3: () otherlv_1= Char
            {
            // InternalRos1Parser.g:5770:3: ()
            // InternalRos1Parser.g:5771:4: 
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
    // InternalRos1Parser.g:5785:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRos1Parser.g:5785:45: (iv_rulebyte= rulebyte EOF )
            // InternalRos1Parser.g:5786:2: iv_rulebyte= rulebyte EOF
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
    // InternalRos1Parser.g:5792:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5798:2: ( ( () otherlv_1= Byte ) )
            // InternalRos1Parser.g:5799:2: ( () otherlv_1= Byte )
            {
            // InternalRos1Parser.g:5799:2: ( () otherlv_1= Byte )
            // InternalRos1Parser.g:5800:3: () otherlv_1= Byte
            {
            // InternalRos1Parser.g:5800:3: ()
            // InternalRos1Parser.g:5801:4: 
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
    // InternalRos1Parser.g:5815:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRos1Parser.g:5815:45: (iv_ruletime= ruletime EOF )
            // InternalRos1Parser.g:5816:2: iv_ruletime= ruletime EOF
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
    // InternalRos1Parser.g:5822:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5828:2: ( ( () otherlv_1= Time ) )
            // InternalRos1Parser.g:5829:2: ( () otherlv_1= Time )
            {
            // InternalRos1Parser.g:5829:2: ( () otherlv_1= Time )
            // InternalRos1Parser.g:5830:3: () otherlv_1= Time
            {
            // InternalRos1Parser.g:5830:3: ()
            // InternalRos1Parser.g:5831:4: 
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
    // InternalRos1Parser.g:5845:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRos1Parser.g:5845:49: (iv_ruleduration= ruleduration EOF )
            // InternalRos1Parser.g:5846:2: iv_ruleduration= ruleduration EOF
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
    // InternalRos1Parser.g:5852:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5858:2: ( ( () otherlv_1= Duration ) )
            // InternalRos1Parser.g:5859:2: ( () otherlv_1= Duration )
            {
            // InternalRos1Parser.g:5859:2: ( () otherlv_1= Duration )
            // InternalRos1Parser.g:5860:3: () otherlv_1= Duration
            {
            // InternalRos1Parser.g:5860:3: ()
            // InternalRos1Parser.g:5861:4: 
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
    // InternalRos1Parser.g:5875:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRos1Parser.g:5875:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRos1Parser.g:5876:2: iv_ruleboolArray= ruleboolArray EOF
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
    // InternalRos1Parser.g:5882:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5888:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRos1Parser.g:5889:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRos1Parser.g:5889:2: ( () otherlv_1= Bool_1 )
            // InternalRos1Parser.g:5890:3: () otherlv_1= Bool_1
            {
            // InternalRos1Parser.g:5890:3: ()
            // InternalRos1Parser.g:5891:4: 
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
    // InternalRos1Parser.g:5905:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRos1Parser.g:5905:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRos1Parser.g:5906:2: iv_ruleint8Array= ruleint8Array EOF
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
    // InternalRos1Parser.g:5912:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5918:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRos1Parser.g:5919:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRos1Parser.g:5919:2: ( () otherlv_1= Int8_1 )
            // InternalRos1Parser.g:5920:3: () otherlv_1= Int8_1
            {
            // InternalRos1Parser.g:5920:3: ()
            // InternalRos1Parser.g:5921:4: 
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
    // InternalRos1Parser.g:5935:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRos1Parser.g:5935:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRos1Parser.g:5936:2: iv_ruleuint8Array= ruleuint8Array EOF
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
    // InternalRos1Parser.g:5942:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5948:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRos1Parser.g:5949:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRos1Parser.g:5949:2: ( () otherlv_1= Uint8_1 )
            // InternalRos1Parser.g:5950:3: () otherlv_1= Uint8_1
            {
            // InternalRos1Parser.g:5950:3: ()
            // InternalRos1Parser.g:5951:4: 
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
    // InternalRos1Parser.g:5965:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRos1Parser.g:5965:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRos1Parser.g:5966:2: iv_ruleint16Array= ruleint16Array EOF
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
    // InternalRos1Parser.g:5972:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5978:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRos1Parser.g:5979:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRos1Parser.g:5979:2: ( () otherlv_1= Int16_1 )
            // InternalRos1Parser.g:5980:3: () otherlv_1= Int16_1
            {
            // InternalRos1Parser.g:5980:3: ()
            // InternalRos1Parser.g:5981:4: 
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
    // InternalRos1Parser.g:5995:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRos1Parser.g:5995:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRos1Parser.g:5996:2: iv_ruleuint16Array= ruleuint16Array EOF
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
    // InternalRos1Parser.g:6002:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6008:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRos1Parser.g:6009:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRos1Parser.g:6009:2: ( () otherlv_1= Uint16_1 )
            // InternalRos1Parser.g:6010:3: () otherlv_1= Uint16_1
            {
            // InternalRos1Parser.g:6010:3: ()
            // InternalRos1Parser.g:6011:4: 
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
    // InternalRos1Parser.g:6025:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRos1Parser.g:6025:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRos1Parser.g:6026:2: iv_ruleint32Array= ruleint32Array EOF
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
    // InternalRos1Parser.g:6032:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6038:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRos1Parser.g:6039:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRos1Parser.g:6039:2: ( () otherlv_1= Int32_1 )
            // InternalRos1Parser.g:6040:3: () otherlv_1= Int32_1
            {
            // InternalRos1Parser.g:6040:3: ()
            // InternalRos1Parser.g:6041:4: 
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
    // InternalRos1Parser.g:6055:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRos1Parser.g:6055:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRos1Parser.g:6056:2: iv_ruleuint32Array= ruleuint32Array EOF
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
    // InternalRos1Parser.g:6062:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6068:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRos1Parser.g:6069:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRos1Parser.g:6069:2: ( () otherlv_1= Uint32_1 )
            // InternalRos1Parser.g:6070:3: () otherlv_1= Uint32_1
            {
            // InternalRos1Parser.g:6070:3: ()
            // InternalRos1Parser.g:6071:4: 
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
    // InternalRos1Parser.g:6085:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRos1Parser.g:6085:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRos1Parser.g:6086:2: iv_ruleint64Array= ruleint64Array EOF
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
    // InternalRos1Parser.g:6092:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6098:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRos1Parser.g:6099:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRos1Parser.g:6099:2: ( () otherlv_1= Int64_1 )
            // InternalRos1Parser.g:6100:3: () otherlv_1= Int64_1
            {
            // InternalRos1Parser.g:6100:3: ()
            // InternalRos1Parser.g:6101:4: 
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
    // InternalRos1Parser.g:6115:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRos1Parser.g:6115:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRos1Parser.g:6116:2: iv_ruleuint64Array= ruleuint64Array EOF
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
    // InternalRos1Parser.g:6122:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6128:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRos1Parser.g:6129:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRos1Parser.g:6129:2: ( () otherlv_1= Uint64_1 )
            // InternalRos1Parser.g:6130:3: () otherlv_1= Uint64_1
            {
            // InternalRos1Parser.g:6130:3: ()
            // InternalRos1Parser.g:6131:4: 
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
    // InternalRos1Parser.g:6145:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRos1Parser.g:6145:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRos1Parser.g:6146:2: iv_rulefloat32Array= rulefloat32Array EOF
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
    // InternalRos1Parser.g:6152:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6158:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRos1Parser.g:6159:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRos1Parser.g:6159:2: ( () otherlv_1= Float32_1 )
            // InternalRos1Parser.g:6160:3: () otherlv_1= Float32_1
            {
            // InternalRos1Parser.g:6160:3: ()
            // InternalRos1Parser.g:6161:4: 
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
    // InternalRos1Parser.g:6175:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRos1Parser.g:6175:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRos1Parser.g:6176:2: iv_rulefloat64Array= rulefloat64Array EOF
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
    // InternalRos1Parser.g:6182:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6188:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRos1Parser.g:6189:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRos1Parser.g:6189:2: ( () otherlv_1= Float64_1 )
            // InternalRos1Parser.g:6190:3: () otherlv_1= Float64_1
            {
            // InternalRos1Parser.g:6190:3: ()
            // InternalRos1Parser.g:6191:4: 
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
    // InternalRos1Parser.g:6205:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRos1Parser.g:6205:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRos1Parser.g:6206:2: iv_rulestring0Array= rulestring0Array EOF
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
    // InternalRos1Parser.g:6212:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6218:2: ( ( () otherlv_1= String_2 ) )
            // InternalRos1Parser.g:6219:2: ( () otherlv_1= String_2 )
            {
            // InternalRos1Parser.g:6219:2: ( () otherlv_1= String_2 )
            // InternalRos1Parser.g:6220:3: () otherlv_1= String_2
            {
            // InternalRos1Parser.g:6220:3: ()
            // InternalRos1Parser.g:6221:4: 
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
    // InternalRos1Parser.g:6235:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRos1Parser.g:6235:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRos1Parser.g:6236:2: iv_rulebyteArray= rulebyteArray EOF
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
    // InternalRos1Parser.g:6242:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6248:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRos1Parser.g:6249:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRos1Parser.g:6249:2: ( () otherlv_1= Byte_1 )
            // InternalRos1Parser.g:6250:3: () otherlv_1= Byte_1
            {
            // InternalRos1Parser.g:6250:3: ()
            // InternalRos1Parser.g:6251:4: 
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
    // InternalRos1Parser.g:6265:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRos1Parser.g:6265:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRos1Parser.g:6266:2: iv_rulecharArray= rulecharArray EOF
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
    // InternalRos1Parser.g:6272:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6278:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRos1Parser.g:6279:2: ( () otherlv_1= Char_1 )
            {
            // InternalRos1Parser.g:6279:2: ( () otherlv_1= Char_1 )
            // InternalRos1Parser.g:6280:3: () otherlv_1= Char_1
            {
            // InternalRos1Parser.g:6280:3: ()
            // InternalRos1Parser.g:6281:4: 
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
    // InternalRos1Parser.g:6295:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRos1Parser.g:6295:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRos1Parser.g:6296:2: iv_ruleHeader= ruleHeader EOF
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
    // InternalRos1Parser.g:6302:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6308:2: ( ( () otherlv_1= Header ) )
            // InternalRos1Parser.g:6309:2: ( () otherlv_1= Header )
            {
            // InternalRos1Parser.g:6309:2: ( () otherlv_1= Header )
            // InternalRos1Parser.g:6310:3: () otherlv_1= Header
            {
            // InternalRos1Parser.g:6310:3: ()
            // InternalRos1Parser.g:6311:4: 
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
    // InternalRos1Parser.g:6325:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRos1Parser.g:6325:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRos1Parser.g:6326:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
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
    // InternalRos1Parser.g:6332:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6338:2: ( ( ( ruleEString ) ) )
            // InternalRos1Parser.g:6339:2: ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:6339:2: ( ( ruleEString ) )
            // InternalRos1Parser.g:6340:3: ( ruleEString )
            {
            // InternalRos1Parser.g:6340:3: ( ruleEString )
            // InternalRos1Parser.g:6341:4: ruleEString
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
    // InternalRos1Parser.g:6358:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRos1Parser.g:6358:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRos1Parser.g:6359:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
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
    // InternalRos1Parser.g:6365:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6371:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRos1Parser.g:6372:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRos1Parser.g:6372:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRos1Parser.g:6373:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRos1Parser.g:6373:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:6374:4: ( ruleEString )
            {
            // InternalRos1Parser.g:6374:4: ( ruleEString )
            // InternalRos1Parser.g:6375:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArraySpecRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
            				
            pushFollow(FOLLOW_64);
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
    // InternalRos1Parser.g:6397:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRos1Parser.g:6397:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRos1Parser.g:6398:2: iv_ruleKEYWORD= ruleKEYWORD EOF
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
    // InternalRos1Parser.g:6404:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6410:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRos1Parser.g:6411:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRos1Parser.g:6411:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt82=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt82=1;
                }
                break;
            case Message:
                {
                alt82=2;
                }
                break;
            case Result:
                {
                alt82=3;
                }
                break;
            case Feedback:
                {
                alt82=4;
                }
                break;
            case Name:
                {
                alt82=5;
                }
                break;
            case Value:
                {
                alt82=6;
                }
                break;
            case Service:
                {
                alt82=7;
                }
                break;
            case Type:
                {
                alt82=8;
                }
                break;
            case Action:
                {
                alt82=9;
                }
                break;
            case Duration:
                {
                alt82=10;
                }
                break;
            case Time:
                {
                alt82=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalRos1Parser.g:6412:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:6418:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:6424:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:6430:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:6436:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:6442:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:6448:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:6454:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:6460:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:6466:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:6472:3: kw= Time
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
    // InternalRos1Parser.g:6481:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRos1Parser.g:6481:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRos1Parser.g:6482:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
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
    // InternalRos1Parser.g:6488:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
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
            // InternalRos1Parser.g:6494:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRos1Parser.g:6495:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRos1Parser.g:6495:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRos1Parser.g:6496:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRos1Parser.g:6496:3: ()
            // InternalRos1Parser.g:6497:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_65); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
            		
            // InternalRos1Parser.g:6507:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRos1Parser.g:6508:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRos1Parser.g:6508:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRos1Parser.g:6509:5: lv_name_2_0= ruleExtensionBlockName
            {

            					newCompositeNode(grammarAccess.getExtensionBlockAccess().getNameExtensionBlockNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
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

            otherlv_3=(Token)match(input,Colon,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
            		
            // InternalRos1Parser.g:6530:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt87=3;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_BEGIN) ) {
                alt87=1;
            }
            else if ( (LA87_0==LeftCurlyBracket) ) {
                alt87=2;
            }
            switch (alt87) {
                case 1 :
                    // InternalRos1Parser.g:6531:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRos1Parser.g:6531:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRos1Parser.g:6532:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_67); 

                    					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                    				
                    // InternalRos1Parser.g:6536:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt83=0;
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( ((LA83_0>=Serviceclients && LA83_0<=Dependencies)||(LA83_0>=FromGitRepo && LA83_0<=Publishers)||LA83_0==Parameter||(LA83_0>=Pluginlib && LA83_0<=Plugins)||(LA83_0>=Boolean && LA83_0<=Float64)||(LA83_0>=Loader && LA83_0<=Message)||LA83_0==Service||(LA83_0>=Base64 && LA83_0<=Action)||(LA83_0>=Result && LA83_0<=Node_1)||LA83_0==Srvs||(LA83_0>=Type_1 && LA83_0<=List)||(LA83_0>=Bool && LA83_0<=Node)||(LA83_0>=Time && LA83_0<=Ns)||(LA83_0>=RULE_ID && LA83_0<=RULE_STRING)) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // InternalRos1Parser.g:6537:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRos1Parser.g:6537:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRos1Parser.g:6538:7: lv_entries_5_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_68);
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
                    	    if ( cnt83 >= 1 ) break loop83;
                                EarlyExitException eee =
                                    new EarlyExitException(83, input);
                                throw eee;
                        }
                        cnt83++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:6561:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRos1Parser.g:6561:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRos1Parser.g:6562:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_69); 

                    					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                    				
                    // InternalRos1Parser.g:6566:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( ((LA86_0>=Serviceclients && LA86_0<=Dependencies)||(LA86_0>=FromGitRepo && LA86_0<=Publishers)||LA86_0==Parameter||(LA86_0>=Pluginlib && LA86_0<=Plugins)||(LA86_0>=Boolean && LA86_0<=Float64)||(LA86_0>=Loader && LA86_0<=Message)||LA86_0==Service||(LA86_0>=Base64 && LA86_0<=Action)||(LA86_0>=Result && LA86_0<=Node_1)||LA86_0==Srvs||(LA86_0>=Type_1 && LA86_0<=List)||(LA86_0>=Bool && LA86_0<=Node)||(LA86_0>=Time && LA86_0<=Ns)||(LA86_0>=RULE_ID && LA86_0<=RULE_STRING)) ) {
                        alt86=1;
                    }
                    switch (alt86) {
                        case 1 :
                            // InternalRos1Parser.g:6567:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRos1Parser.g:6567:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRos1Parser.g:6568:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRos1Parser.g:6568:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRos1Parser.g:6569:8: lv_entries_8_0= ruleExtensionEntry
                            {

                            								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_70);
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

                            // InternalRos1Parser.g:6586:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop85:
                            do {
                                int alt85=2;
                                int LA85_0 = input.LA(1);

                                if ( ((LA85_0>=Serviceclients && LA85_0<=Dependencies)||(LA85_0>=FromGitRepo && LA85_0<=Publishers)||LA85_0==Parameter||(LA85_0>=Pluginlib && LA85_0<=Plugins)||(LA85_0>=Boolean && LA85_0<=Float64)||(LA85_0>=Loader && LA85_0<=Message)||LA85_0==Service||(LA85_0>=Base64 && LA85_0<=Action)||(LA85_0>=Result && LA85_0<=Node_1)||LA85_0==Srvs||(LA85_0>=Type_1 && LA85_0<=List)||(LA85_0>=Bool && LA85_0<=Node)||(LA85_0>=Time && LA85_0<=Ns)||LA85_0==Comma||(LA85_0>=RULE_ID && LA85_0<=RULE_STRING)) ) {
                                    alt85=1;
                                }


                                switch (alt85) {
                            	case 1 :
                            	    // InternalRos1Parser.g:6587:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRos1Parser.g:6587:7: (otherlv_9= Comma )?
                            	    int alt84=2;
                            	    int LA84_0 = input.LA(1);

                            	    if ( (LA84_0==Comma) ) {
                            	        alt84=1;
                            	    }
                            	    switch (alt84) {
                            	        case 1 :
                            	            // InternalRos1Parser.g:6588:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_67); 

                            	            								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalRos1Parser.g:6593:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRos1Parser.g:6594:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRos1Parser.g:6594:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRos1Parser.g:6595:9: lv_entries_10_0= ruleExtensionEntry
                            	    {

                            	    									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_70);
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
                            	    break loop85;
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
    // InternalRos1Parser.g:6624:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRos1Parser.g:6624:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRos1Parser.g:6625:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
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
    // InternalRos1Parser.g:6631:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6637:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRos1Parser.g:6638:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRos1Parser.g:6638:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRos1Parser.g:6639:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_71); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRos1Parser.g:6646:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==FullStop) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // InternalRos1Parser.g:6647:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_65); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_71); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop88;
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
    // InternalRos1Parser.g:6664:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRos1Parser.g:6664:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRos1Parser.g:6665:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
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
    // InternalRos1Parser.g:6671:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6677:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) )
            // InternalRos1Parser.g:6678:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            {
            // InternalRos1Parser.g:6678:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            // InternalRos1Parser.g:6679:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) )
            {
            // InternalRos1Parser.g:6679:3: ()
            // InternalRos1Parser.g:6680:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:6686:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==Pluginlib||(LA89_0>=Duration && LA89_0<=Feedback)||(LA89_0>=Boolean && LA89_0<=Float64)||LA89_0==Message||LA89_0==Service||(LA89_0>=Base64 && LA89_0<=Action)||(LA89_0>=Result && LA89_0<=Uint64)||LA89_0==Array||(LA89_0>=Int16 && LA89_0<=Int64)||(LA89_0>=Uint8 && LA89_0<=List)||(LA89_0>=Bool && LA89_0<=Node)||(LA89_0>=Time && LA89_0<=Any)||(LA89_0>=RULE_ID && LA89_0<=RULE_STRING)) ) {
                alt89=1;
            }
            else if ( ((LA89_0>=Serviceclients && LA89_0<=Dependencies)||(LA89_0>=FromGitRepo && LA89_0<=Publishers)||LA89_0==Parameter||(LA89_0>=Actions && LA89_0<=Default)||LA89_0==Plugins||LA89_0==Loader||LA89_0==Value_1||LA89_0==Base||(LA89_0>=Msgs && LA89_0<=Node_1)||LA89_0==Srvs||LA89_0==Type_1||LA89_0==Ns) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalRos1Parser.g:6687:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:6687:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:6688:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:6688:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRos1Parser.g:6689:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRos1Parser.g:6689:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRos1Parser.g:6690:7: lv_key_1_0= ruleExtensionKey
                    {

                    							newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionKeyParserRuleCall_1_0_0_0());
                    						
                    pushFollow(FOLLOW_3);
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_72); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:6713:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRos1Parser.g:6713:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRos1Parser.g:6714:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRos1Parser.g:6714:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRos1Parser.g:6715:6: lv_key_3_0= ruleExtensionColonKey
                    {

                    						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_72);
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

            // InternalRos1Parser.g:6733:3: ( (lv_value_4_0= ruleExtensionValue ) )
            // InternalRos1Parser.g:6734:4: (lv_value_4_0= ruleExtensionValue )
            {
            // InternalRos1Parser.g:6734:4: (lv_value_4_0= ruleExtensionValue )
            // InternalRos1Parser.g:6735:5: lv_value_4_0= ruleExtensionValue
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
    // InternalRos1Parser.g:6756:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRos1Parser.g:6756:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRos1Parser.g:6757:2: iv_ruleExtensionValue= ruleExtensionValue EOF
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
    // InternalRos1Parser.g:6763:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6769:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRos1Parser.g:6770:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRos1Parser.g:6770:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt90=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt90=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt90=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt90=3;
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
                alt90=4;
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
                alt90=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalRos1Parser.g:6771:3: this_ExtensionListValue_0= ruleExtensionListValue
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
                    // InternalRos1Parser.g:6780:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
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
                    // InternalRos1Parser.g:6789:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
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
                    // InternalRos1Parser.g:6798:3: this_ExtensionRefValue_3= ruleExtensionRefValue
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
                    // InternalRos1Parser.g:6807:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
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
    // InternalRos1Parser.g:6819:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRos1Parser.g:6819:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRos1Parser.g:6820:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
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
    // InternalRos1Parser.g:6826:1: ruleExtensionListValue returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleExtensionListValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_items_2_0 = null;

        EObject lv_items_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6832:2: ( ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) )
            // InternalRos1Parser.g:6833:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            {
            // InternalRos1Parser.g:6833:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            // InternalRos1Parser.g:6834:3: () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket
            {
            // InternalRos1Parser.g:6834:3: ()
            // InternalRos1Parser.g:6835:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_73); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:6845:3: ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==Pluginlib||(LA93_0>=Duration && LA93_0<=Feedback)||(LA93_0>=Boolean && LA93_0<=Float64)||(LA93_0>=Message && LA93_0<=Param)||LA93_0==Service||(LA93_0>=Base64 && LA93_0<=Action)||(LA93_0>=Result && LA93_0<=Uint64)||LA93_0==Array||(LA93_0>=Int16 && LA93_0<=Int64)||LA93_0==Pub||LA93_0==Sub||(LA93_0>=Uint8 && LA93_0<=Any)||LA93_0==LeftSquareBracket||LA93_0==LeftCurlyBracket||(LA93_0>=RULE_BOOLEAN && LA93_0<=RULE_DOUBLE)||(LA93_0>=RULE_ID && LA93_0<=RULE_INT)||LA93_0==RULE_BEGIN) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalRos1Parser.g:6846:4: ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    {
                    // InternalRos1Parser.g:6846:4: ( (lv_items_2_0= ruleExtensionValue ) )
                    // InternalRos1Parser.g:6847:5: (lv_items_2_0= ruleExtensionValue )
                    {
                    // InternalRos1Parser.g:6847:5: (lv_items_2_0= ruleExtensionValue )
                    // InternalRos1Parser.g:6848:6: lv_items_2_0= ruleExtensionValue
                    {

                    						newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_74);
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

                    // InternalRos1Parser.g:6865:4: ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==Pluginlib||(LA92_0>=Duration && LA92_0<=Feedback)||(LA92_0>=Boolean && LA92_0<=Float64)||(LA92_0>=Message && LA92_0<=Param)||LA92_0==Service||(LA92_0>=Base64 && LA92_0<=Action)||(LA92_0>=Result && LA92_0<=Uint64)||LA92_0==Array||(LA92_0>=Int16 && LA92_0<=Int64)||LA92_0==Pub||LA92_0==Sub||(LA92_0>=Uint8 && LA92_0<=Any)||LA92_0==Comma||LA92_0==LeftSquareBracket||LA92_0==LeftCurlyBracket||(LA92_0>=RULE_BOOLEAN && LA92_0<=RULE_DOUBLE)||(LA92_0>=RULE_ID && LA92_0<=RULE_INT)||LA92_0==RULE_BEGIN) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // InternalRos1Parser.g:6866:5: (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) )
                    	    {
                    	    // InternalRos1Parser.g:6866:5: (otherlv_3= Comma )?
                    	    int alt91=2;
                    	    int LA91_0 = input.LA(1);

                    	    if ( (LA91_0==Comma) ) {
                    	        alt91=1;
                    	    }
                    	    switch (alt91) {
                    	        case 1 :
                    	            // InternalRos1Parser.g:6867:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_72); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRos1Parser.g:6872:5: ( (lv_items_4_0= ruleExtensionValue ) )
                    	    // InternalRos1Parser.g:6873:6: (lv_items_4_0= ruleExtensionValue )
                    	    {
                    	    // InternalRos1Parser.g:6873:6: (lv_items_4_0= ruleExtensionValue )
                    	    // InternalRos1Parser.g:6874:7: lv_items_4_0= ruleExtensionValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_74);
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
                    	    break loop92;
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
    // InternalRos1Parser.g:6901:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRos1Parser.g:6901:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRos1Parser.g:6902:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
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
    // InternalRos1Parser.g:6908:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6914:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRos1Parser.g:6915:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRos1Parser.g:6915:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRos1Parser.g:6916:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRos1Parser.g:6916:3: ()
            // InternalRos1Parser.g:6917:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRos1Parser.g:6927:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( ((LA96_0>=Serviceclients && LA96_0<=Dependencies)||(LA96_0>=FromGitRepo && LA96_0<=Publishers)||LA96_0==Parameter||(LA96_0>=Pluginlib && LA96_0<=Plugins)||(LA96_0>=Boolean && LA96_0<=Float64)||(LA96_0>=Loader && LA96_0<=Message)||LA96_0==Service||(LA96_0>=Base64 && LA96_0<=Action)||(LA96_0>=Result && LA96_0<=Node_1)||LA96_0==Srvs||(LA96_0>=Type_1 && LA96_0<=List)||(LA96_0>=Bool && LA96_0<=Node)||(LA96_0>=Time && LA96_0<=Ns)||(LA96_0>=RULE_ID && LA96_0<=RULE_STRING)) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalRos1Parser.g:6928:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRos1Parser.g:6928:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRos1Parser.g:6929:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRos1Parser.g:6929:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRos1Parser.g:6930:6: lv_entries_2_0= ruleExtensionEntry
                    {

                    						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_70);
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

                    // InternalRos1Parser.g:6947:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( ((LA95_0>=Serviceclients && LA95_0<=Dependencies)||(LA95_0>=FromGitRepo && LA95_0<=Publishers)||LA95_0==Parameter||(LA95_0>=Pluginlib && LA95_0<=Plugins)||(LA95_0>=Boolean && LA95_0<=Float64)||(LA95_0>=Loader && LA95_0<=Message)||LA95_0==Service||(LA95_0>=Base64 && LA95_0<=Action)||(LA95_0>=Result && LA95_0<=Node_1)||LA95_0==Srvs||(LA95_0>=Type_1 && LA95_0<=List)||(LA95_0>=Bool && LA95_0<=Node)||(LA95_0>=Time && LA95_0<=Ns)||LA95_0==Comma||(LA95_0>=RULE_ID && LA95_0<=RULE_STRING)) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // InternalRos1Parser.g:6948:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRos1Parser.g:6948:5: (otherlv_3= Comma )?
                    	    int alt94=2;
                    	    int LA94_0 = input.LA(1);

                    	    if ( (LA94_0==Comma) ) {
                    	        alt94=1;
                    	    }
                    	    switch (alt94) {
                    	        case 1 :
                    	            // InternalRos1Parser.g:6949:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_67); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRos1Parser.g:6954:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRos1Parser.g:6955:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRos1Parser.g:6955:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRos1Parser.g:6956:7: lv_entries_4_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_70);
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
                    	    break loop95;
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
    // InternalRos1Parser.g:6983:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRos1Parser.g:6983:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRos1Parser.g:6984:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
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
    // InternalRos1Parser.g:6990:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6996:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRos1Parser.g:6997:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRos1Parser.g:6997:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRos1Parser.g:6998:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRos1Parser.g:6998:3: ()
            // InternalRos1Parser.g:6999:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_67); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalRos1Parser.g:7009:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt97=0;
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( ((LA97_0>=Serviceclients && LA97_0<=Dependencies)||(LA97_0>=FromGitRepo && LA97_0<=Publishers)||LA97_0==Parameter||(LA97_0>=Pluginlib && LA97_0<=Plugins)||(LA97_0>=Boolean && LA97_0<=Float64)||(LA97_0>=Loader && LA97_0<=Message)||LA97_0==Service||(LA97_0>=Base64 && LA97_0<=Action)||(LA97_0>=Result && LA97_0<=Node_1)||LA97_0==Srvs||(LA97_0>=Type_1 && LA97_0<=List)||(LA97_0>=Bool && LA97_0<=Node)||(LA97_0>=Time && LA97_0<=Ns)||(LA97_0>=RULE_ID && LA97_0<=RULE_STRING)) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalRos1Parser.g:7010:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRos1Parser.g:7010:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRos1Parser.g:7011:5: lv_entries_2_0= ruleExtensionEntry
            	    {

            	    					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_68);
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
            	    if ( cnt97 >= 1 ) break loop97;
                        EarlyExitException eee =
                            new EarlyExitException(97, input);
                        throw eee;
                }
                cnt97++;
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
    // InternalRos1Parser.g:7036:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRos1Parser.g:7036:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRos1Parser.g:7037:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
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
    // InternalRos1Parser.g:7043:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
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
            // InternalRos1Parser.g:7049:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRos1Parser.g:7050:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRos1Parser.g:7050:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRos1Parser.g:7051:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:7051:3: ()
            // InternalRos1Parser.g:7052:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:7058:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRos1Parser.g:7059:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRos1Parser.g:7059:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRos1Parser.g:7060:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRos1Parser.g:7060:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt98=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt98=1;
                }
                break;
            case Sub:
                {
                alt98=2;
                }
                break;
            case Ss:
                {
                alt98=3;
                }
                break;
            case Sc:
                {
                alt98=4;
                }
                break;
            case As:
                {
                alt98=5;
                }
                break;
            case Ac:
                {
                alt98=6;
                }
                break;
            case Param:
                {
                alt98=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // InternalRos1Parser.g:7061:6: lv_refKind_1_1= Pub
                    {
                    lv_refKind_1_1=(Token)match(input,Pub,FOLLOW_6); 

                    						newLeafNode(lv_refKind_1_1, grammarAccess.getExtensionRefValueAccess().getRefKindPubKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7072:6: lv_refKind_1_2= Sub
                    {
                    lv_refKind_1_2=(Token)match(input,Sub,FOLLOW_6); 

                    						newLeafNode(lv_refKind_1_2, grammarAccess.getExtensionRefValueAccess().getRefKindSubKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:7083:6: lv_refKind_1_3= Ss
                    {
                    lv_refKind_1_3=(Token)match(input,Ss,FOLLOW_6); 

                    						newLeafNode(lv_refKind_1_3, grammarAccess.getExtensionRefValueAccess().getRefKindSsKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:7094:6: lv_refKind_1_4= Sc
                    {
                    lv_refKind_1_4=(Token)match(input,Sc,FOLLOW_6); 

                    						newLeafNode(lv_refKind_1_4, grammarAccess.getExtensionRefValueAccess().getRefKindScKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:7105:6: lv_refKind_1_5= As
                    {
                    lv_refKind_1_5=(Token)match(input,As,FOLLOW_6); 

                    						newLeafNode(lv_refKind_1_5, grammarAccess.getExtensionRefValueAccess().getRefKindAsKeyword_1_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:7116:6: lv_refKind_1_6= Ac
                    {
                    lv_refKind_1_6=(Token)match(input,Ac,FOLLOW_6); 

                    						newLeafNode(lv_refKind_1_6, grammarAccess.getExtensionRefValueAccess().getRefKindAcKeyword_1_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getExtensionRefValueRule());
                    						}
                    						setWithLastConsumed(current, "refKind", lv_refKind_1_6, null);
                    					

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:7127:6: lv_refKind_1_7= Param
                    {
                    lv_refKind_1_7=(Token)match(input,Param,FOLLOW_6); 

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

            // InternalRos1Parser.g:7140:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:7141:4: ( ruleEString )
            {
            // InternalRos1Parser.g:7141:4: ( ruleEString )
            // InternalRos1Parser.g:7142:5: ruleEString
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
    // InternalRos1Parser.g:7160:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRos1Parser.g:7160:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRos1Parser.g:7161:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
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
    // InternalRos1Parser.g:7167:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7173:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRos1Parser.g:7174:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRos1Parser.g:7174:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRos1Parser.g:7175:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRos1Parser.g:7175:3: ()
            // InternalRos1Parser.g:7176:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:7182:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRos1Parser.g:7183:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRos1Parser.g:7183:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRos1Parser.g:7184:5: lv_value_1_0= ruleExtensionScalarLiteral
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
    // InternalRos1Parser.g:7205:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRos1Parser.g:7205:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRos1Parser.g:7206:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
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
    // InternalRos1Parser.g:7212:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7218:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRos1Parser.g:7219:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRos1Parser.g:7219:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt99=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt99=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt99=2;
                }
                break;
            case RULE_DECINT:
                {
                alt99=3;
                }
                break;
            case RULE_INT:
                {
                alt99=4;
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
                alt99=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // InternalRos1Parser.g:7220:3: this_BOOLEAN_0= RULE_BOOLEAN
                    {
                    this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    			current.merge(this_BOOLEAN_0);
                    		

                    			newLeafNode(this_BOOLEAN_0, grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7228:3: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_1);
                    		

                    			newLeafNode(this_DOUBLE_1, grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:7236:3: this_DECINT_2= RULE_DECINT
                    {
                    this_DECINT_2=(Token)match(input,RULE_DECINT,FOLLOW_2); 

                    			current.merge(this_DECINT_2);
                    		

                    			newLeafNode(this_DECINT_2, grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:7244:3: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_3);
                    		

                    			newLeafNode(this_INT_3, grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:7252:3: this_ExtensionKey_4= ruleExtensionKey
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
    // InternalRos1Parser.g:7266:1: rulePluginLoader returns [Enumerator current=null] : ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) ) ;
    public final Enumerator rulePluginLoader() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:7272:2: ( ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) ) )
            // InternalRos1Parser.g:7273:2: ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) )
            {
            // InternalRos1Parser.g:7273:2: ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==Pluginlib) ) {
                alt100=1;
            }
            else if ( (LA100_0==External) ) {
                alt100=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // InternalRos1Parser.g:7274:3: (enumLiteral_0= Pluginlib )
                    {
                    // InternalRos1Parser.g:7274:3: (enumLiteral_0= Pluginlib )
                    // InternalRos1Parser.g:7275:4: enumLiteral_0= Pluginlib
                    {
                    enumLiteral_0=(Token)match(input,Pluginlib,FOLLOW_2); 

                    				current = grammarAccess.getPluginLoaderAccess().getPLUGINLIBEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPluginLoaderAccess().getPLUGINLIBEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7282:3: (enumLiteral_1= External )
                    {
                    // InternalRos1Parser.g:7282:3: (enumLiteral_1= External )
                    // InternalRos1Parser.g:7283:4: enumLiteral_1= External
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

    // Delegated rules


    protected DFA67 dfa67 = new DFA67(this);
    protected DFA81 dfa81 = new DFA81(this);
    static final String dfa_1s = "\15\uffff";
    static final String dfa_2s = "\1\12\4\13\10\uffff";
    static final String dfa_3s = "\5\31\4\uffff\1\31\3\uffff";
    static final String dfa_4s = "\5\171\4\uffff\1\170\3\uffff";
    static final String dfa_5s = "\5\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\1\1\6";
    static final String dfa_6s = "\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\3\3\uffff\1\4\103\uffff\1\12\3\uffff\1\11\1\12\3\uffff\1\5\1\10\1\6\1\7\6\uffff\1\2\1\1\3\uffff\1\12",
            "\1\13\3\uffff\1\13\103\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\3\uffff\1\13\103\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\3\uffff\1\13\103\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "\1\13\3\uffff\1\13\103\uffff\1\13\1\uffff\1\12\2\uffff\1\13\15\uffff\2\13\3\uffff\1\13",
            "",
            "",
            "",
            "",
            "\1\14\3\uffff\1\14\103\uffff\1\14\3\uffff\2\14\3\uffff\4\14\6\uffff\2\14\2\uffff\1\12",
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

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3759:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_8s = "\46\uffff";
    static final String dfa_9s = "\36\uffff\4\45\4\uffff";
    static final String dfa_10s = "\1\27\35\uffff\4\31\4\uffff";
    static final String dfa_11s = "\1\165\35\uffff\4\167\4\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\4\uffff\1\40\1\41\1\37\1\36";
    static final String dfa_13s = "\46\uffff}>";
    static final String[] dfa_14s = {
            "\1\32\1\33\1\40\2\uffff\1\17\1\41\3\uffff\1\34\1\25\1\27\1\31\2\uffff\1\12\1\13\1\24\1\26\1\30\5\uffff\1\23\2\uffff\1\20\3\uffff\1\21\1\35\1\43\1\22\1\uffff\1\14\1\5\1\7\1\11\3\uffff\1\4\1\6\1\10\6\uffff\1\3\5\uffff\1\1\1\15\1\42\1\uffff\1\2\4\uffff\1\16\27\uffff\1\37\1\36",
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
            "\1\45\2\uffff\3\45\16\uffff\1\45\2\uffff\1\45\6\uffff\1\45\4\uffff\1\45\21\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\2\uffff\1\44\23\uffff\2\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\16\uffff\1\45\2\uffff\1\45\6\uffff\1\45\4\uffff\1\45\21\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\2\uffff\1\44\23\uffff\2\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\16\uffff\1\45\2\uffff\1\45\6\uffff\1\45\4\uffff\1\45\21\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\2\uffff\1\44\23\uffff\2\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\16\uffff\1\45\2\uffff\1\45\6\uffff\1\45\4\uffff\1\45\21\uffff\1\45\7\uffff\1\45\1\uffff\1\45\3\uffff\2\45\2\uffff\1\44\23\uffff\2\45\1\uffff\1\45",
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

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "5094:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000105000L,0x0200000000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000022000000L,0x0030000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000101000L,0x0200000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000022000000L,0x0A10000002000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001000L,0x0200000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000022000010L,0x0030000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000004200000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004005000L,0x0200000000000480L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004001000L,0x0200000000000480L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000000L,0x0200000000000480L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0030000022000000L,0x0230000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000022000000L,0x0230000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0300000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xEF120F9E33800000L,0x0230000010B82071L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x1000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0xEF120F9E33800002L,0x0030000010B82071L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000080000000L,0x0200000000000100L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000080000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000022000000L,0x0810000002000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000000000D8F02L,0x0000001000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00001000000F8F00L,0x0200001000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0100008000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000008200000L,0x0000000000000008L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000008200000L,0x0200000000000008L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000200000L,0x0000000200000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000008000000L,0x0000010200000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0200000080000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000080001000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x006C006000000000L,0x0000000000010004L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000022000000L,0x00303C2000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000022000000L,0x0030004000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1081200072000000L,0x00B0000031404000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0100008000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0xF0FD31E0FE2FDF00L,0x00300000F3F9F5FFL});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0xF0FD31E0FE2FDF00L,0x02300000F3F9F5FFL});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0xF0FD31E0FE2FDF00L,0x00300100F3F9F5FFL});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0xF0FD31E0FE2FDF00L,0x00300102F3F9F5FFL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0xF0FD61E072000000L,0x017038A07FFFEA75L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0xF0FD61E072000000L,0x017038E07FFFEA75L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0xF0FD61E072000000L,0x017038E27FFFEA75L});

}
