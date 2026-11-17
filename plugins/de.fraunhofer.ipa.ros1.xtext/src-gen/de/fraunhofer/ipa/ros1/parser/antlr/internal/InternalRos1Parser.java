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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ExternalDependency", "RelativeNamespace", "PrivateNamespace", "GlobalNamespace", "Serviceclients", "Serviceservers", "Actionclients", "Actionservers", "Dependencies", "ParameterAny", "FromGitRepo", "Pluginslots", "Subscribers", "Implements", "Parameters", "Publishers", "Artifacts", "Parameter", "GraphName", "Float32_1", "Float64_1", "Pluginlib", "Actions", "Default", "Duration", "External", "Feedback", "Plugins", "Response", "String_2", "Uint16_1", "Uint32_1", "Uint64_1", "Boolean", "Integer", "Float32", "Float64", "Format", "Int16_1", "Int32_1", "Int64_1", "Library", "Loader", "Message", "Param", "Request", "Service", "Uint8_1", "Base64", "Double", "Header", "String", "Struct", "Action", "Bool_1", "Byte_1", "Char_1", "Int8_1", "Result", "String_1", "Uint16", "Uint32", "Uint64", "Value_1", "Array", "Base", "Class", "Int16", "Int32", "Int64", "Msgs", "Node_1", "Pub", "Srvs", "Sub", "Type_1", "Uint8", "Value", "Date", "List", "Ac", "As", "Bool", "Byte", "Char", "Goal", "Int8", "Name", "Node", "Sc", "Ss", "Time", "Type", "Any", "Ns", "LeftSquareBracketRightSquareBracket", "Comma", "FullStop", "Colon", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_DIGIT", "RULE_BINARY", "RULE_BOOLEAN", "RULE_DECINT", "RULE_DOUBLE", "RULE_DAY", "RULE_MONTH", "RULE_YEAR", "RULE_HOUR", "RULE_MIN_SEC", "RULE_DATE_TIME", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_MESSAGE_ASIGMENT", "RULE_BEGIN", "RULE_END", "RULE_SL_COMMENT", "RULE_ROS_CONVENTION_A", "RULE_ROS_CONVENTION_PARAM", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Float32_1=23;
    public static final int Node=92;
    public static final int RULE_DATE_TIME=118;
    public static final int Uint64_1=36;
    public static final int Serviceclients=8;
    public static final int Pluginlib=25;
    public static final int String=55;
    public static final int Int16=71;
    public static final int Float32=39;
    public static final int Goal=89;
    public static final int Actionservers=11;
    public static final int Bool=86;
    public static final int Msgs=74;
    public static final int Uint16=64;
    public static final int Boolean=37;
    public static final int ExternalDependency=4;
    public static final int Sub=78;
    public static final int Uint8=80;
    public static final int Parameters=18;
    public static final int RULE_ID=119;
    public static final int Actions=26;
    public static final int RULE_DIGIT=108;
    public static final int GlobalNamespace=7;
    public static final int Artifacts=20;
    public static final int Node_1=75;
    public static final int Int16_1=42;
    public static final int Header=54;
    public static final int RULE_INT=121;
    public static final int Byte=87;
    public static final int RULE_ML_COMMENT=128;
    public static final int LeftSquareBracket=104;
    public static final int Pluginslots=15;
    public static final int Ac=84;
    public static final int Base64=52;
    public static final int Comma=100;
    public static final int As=85;
    public static final int RULE_MESSAGE_ASIGMENT=122;
    public static final int LeftSquareBracketRightSquareBracket=99;
    public static final int Int32=72;
    public static final int Char=88;
    public static final int Publishers=19;
    public static final int Srvs=77;
    public static final int RightCurlyBracket=107;
    public static final int RULE_DECINT=111;
    public static final int Uint32=65;
    public static final int Plugins=31;
    public static final int FromGitRepo=14;
    public static final int FullStop=101;
    public static final int RULE_HOUR=116;
    public static final int Int8=90;
    public static final int Default=27;
    public static final int Int8_1=61;
    public static final int CommercialAt=103;
    public static final int Uint16_1=34;
    public static final int Sc=93;
    public static final int Type=96;
    public static final int Float64=40;
    public static final int Int32_1=43;
    public static final int Parameter=21;
    public static final int RULE_BINARY=109;
    public static final int String_1=63;
    public static final int Subscribers=16;
    public static final int String_2=33;
    public static final int Ss=94;
    public static final int Actionclients=10;
    public static final int RULE_DAY=113;
    public static final int RULE_BEGIN=123;
    public static final int RULE_BOOLEAN=110;
    public static final int RelativeNamespace=5;
    public static final int Serviceservers=9;
    public static final int RULE_YEAR=115;
    public static final int Result=62;
    public static final int Name=91;
    public static final int RULE_MIN_SEC=117;
    public static final int Implements=17;
    public static final int Char_1=60;
    public static final int ParameterAny=13;
    public static final int List=83;
    public static final int Dependencies=12;
    public static final int RightSquareBracket=105;
    public static final int PrivateNamespace=6;
    public static final int GraphName=22;
    public static final int Byte_1=59;
    public static final int Float64_1=24;
    public static final int Duration=28;
    public static final int Uint32_1=35;
    public static final int Double=53;
    public static final int External=29;
    public static final int Type_1=79;
    public static final int Value=81;
    public static final int Class=70;
    public static final int Library=45;
    public static final int Uint64=66;
    public static final int Action=57;
    public static final int RULE_END=124;
    public static final int Message=47;
    public static final int Value_1=67;
    public static final int Loader=46;
    public static final int Time=95;
    public static final int RULE_STRING=120;
    public static final int Bool_1=58;
    public static final int Any=97;
    public static final int Struct=56;
    public static final int RULE_SL_COMMENT=125;
    public static final int Uint8_1=51;
    public static final int Format=41;
    public static final int RULE_DOUBLE=112;
    public static final int Feedback=30;
    public static final int RULE_ROS_CONVENTION_A=126;
    public static final int RULE_ROS_CONVENTION_PARAM=127;
    public static final int Colon=102;
    public static final int Pub=76;
    public static final int EOF=-1;
    public static final int Ns=98;
    public static final int RULE_WS=129;
    public static final int Int64_1=44;
    public static final int Request=49;
    public static final int LeftCurlyBracket=106;
    public static final int Service=50;
    public static final int RULE_ANY_OTHER=130;
    public static final int Base=69;
    public static final int Date=82;
    public static final int Response=32;
    public static final int Integer=38;
    public static final int Array=68;
    public static final int Int64=73;
    public static final int Param=48;
    public static final int RULE_MONTH=114;

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

                        if ( (LA2_0==Pluginlib||LA2_0==External||LA2_0==Library||LA2_0==Class||LA2_0==Node||LA2_0==RULE_ID||LA2_0==RULE_ROS_CONVENTION_A) ) {
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

            	        if ( (LA9_0==Pluginlib||LA9_0==External||LA9_0==Library||(LA9_0>=Header && LA9_0<=String)||LA9_0==Class||(LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
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

            	        if ( (LA10_0==Pluginlib||LA10_0==External||LA10_0==Library||LA10_0==Class||(LA10_0>=RULE_ID && LA10_0<=RULE_STRING)) ) {
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

            	        if ( (LA11_0==Pluginlib||LA11_0==External||LA11_0==Library||LA11_0==Class||(LA11_0>=RULE_ID && LA11_0<=RULE_STRING)) ) {
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
            case Library:
            case Class:
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

                if ( ((LA20_0>=Float32_1 && LA20_0<=Pluginlib)||(LA20_0>=Duration && LA20_0<=External)||(LA20_0>=String_2 && LA20_0<=Uint64_1)||(LA20_0>=Float32 && LA20_0<=Float64)||(LA20_0>=Int16_1 && LA20_0<=Library)||LA20_0==Uint8_1||LA20_0==Header||(LA20_0>=Bool_1 && LA20_0<=Int8_1)||(LA20_0>=String_1 && LA20_0<=Uint64)||(LA20_0>=Class && LA20_0<=Int64)||LA20_0==Uint8||(LA20_0>=Bool && LA20_0<=Char)||LA20_0==Int8||LA20_0==Time||(LA20_0>=RULE_ID && LA20_0<=RULE_STRING)) ) {
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

                        if ( (LA22_0==Pluginlib||LA22_0==External||LA22_0==Library||LA22_0==Class||LA22_0==Node||LA22_0==RULE_ID||LA22_0==RULE_ROS_CONVENTION_A) ) {
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

            	        if ( (LA24_0==Pluginlib||LA24_0==External||LA24_0==Library||LA24_0==Class||(LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
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

            	        if ( (LA25_0==Pluginlib||LA25_0==External||LA25_0==Library||LA25_0==Class||(LA25_0>=RULE_ID && LA25_0<=RULE_STRING)) ) {
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

            	        if ( (LA26_0==Pluginlib||LA26_0==External||LA26_0==Library||LA26_0==Class||(LA26_0>=RULE_ID && LA26_0<=RULE_STRING)) ) {
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

            	        if ( (LA27_0==Pluginlib||LA27_0==External||LA27_0==Library||LA27_0==Class||(LA27_0>=RULE_ID && LA27_0<=RULE_STRING)) ) {
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

            	        if ( (LA28_0==Pluginlib||LA28_0==External||LA28_0==Library||LA28_0==Class||(LA28_0>=RULE_ID && LA28_0<=RULE_STRING)) ) {
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

            	        if ( (LA29_0==Pluginlib||LA29_0==External||LA29_0==Library||LA29_0==Class||(LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
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

            	        if ( (LA30_0==Pluginlib||LA30_0==External||LA30_0==Library||LA30_0==Class||(LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
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

            	        if ( (LA31_0==Pluginlib||LA31_0==External||LA31_0==Library||LA31_0==Class||(LA31_0>=RULE_ID && LA31_0<=RULE_STRING)) ) {
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

            	        if ( (LA33_0==Pluginlib||LA33_0==External||LA33_0==Library||LA33_0==Class||(LA33_0>=RULE_ID && LA33_0<=RULE_STRING)) ) {
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

            	        if ( (LA34_0==Pluginlib||LA34_0==External||LA34_0==Library||LA34_0==Class||(LA34_0>=RULE_ID && LA34_0<=RULE_STRING)) ) {
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

            	        if ( (LA35_0==Pluginlib||LA35_0==External||LA35_0==Library||LA35_0==Class||(LA35_0>=RULE_ID && LA35_0<=RULE_STRING)) ) {
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

            	        if ( (LA36_0==Pluginlib||LA36_0==External||LA36_0==Library||LA36_0==Class||(LA36_0>=RULE_ID && LA36_0<=RULE_STRING)) ) {
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

            	        if ( (LA37_0==Pluginlib||LA37_0==External||LA37_0==Library||LA37_0==Class||(LA37_0>=RULE_ID && LA37_0<=RULE_STRING)) ) {
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

            	        if ( (LA38_0==Pluginlib||LA38_0==External||LA38_0==Library||LA38_0==Class||(LA38_0>=RULE_ID && LA38_0<=RULE_STRING)) ) {
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

            	        if ( (LA39_0==Pluginlib||LA39_0==External||LA39_0==Library||LA39_0==Class||(LA39_0>=RULE_ID && LA39_0<=RULE_STRING)) ) {
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
    // InternalRos1Parser.g:1744:1: rulePluginSlot returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) ) ;
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
            // InternalRos1Parser.g:1750:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) ) )
            // InternalRos1Parser.g:1751:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) )
            {
            // InternalRos1Parser.g:1751:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) ) )
            // InternalRos1Parser.g:1752:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) )
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
            		
            // InternalRos1Parser.g:1782:3: ( (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END ) | (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_BEGIN) ) {
                alt47=1;
            }
            else if ( (LA47_0==LeftCurlyBracket) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalRos1Parser.g:1783:4: (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END )
                    {
                    // InternalRos1Parser.g:1783:4: (this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END )
                    // InternalRos1Parser.g:1784:5: this_BEGIN_3= RULE_BEGIN ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) ) this_END_13= RULE_END
                    {
                    this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_38); 

                    					newLeafNode(this_BEGIN_3, grammarAccess.getPluginSlotAccess().getBEGINTerminalRuleCall_3_0_0());
                    				
                    // InternalRos1Parser.g:1788:5: ( ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) ) )
                    // InternalRos1Parser.g:1789:6: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
                    {
                    // InternalRos1Parser.g:1789:6: ( ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?) )
                    // InternalRos1Parser.g:1790:7: ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?)
                    {
                     
                    						  getUnorderedGroupHelper().enter(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1());
                    						
                    // InternalRos1Parser.g:1793:7: ( ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?)
                    // InternalRos1Parser.g:1794:8: ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+ {...}?
                    {
                    // InternalRos1Parser.g:1794:8: ( ({...}? => ( ({...}? => (otherlv_5= Base ( (lv_base_6_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= Parameter ( (lv_parameter_8_0= ruleEString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) ) )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=5;
                        int LA41_0 = input.LA(1);

                        if ( LA41_0 == Base && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 0) ) {
                            alt41=1;
                        }
                        else if ( LA41_0 == Parameter && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 1) ) {
                            alt41=2;
                        }
                        else if ( LA41_0 == Format && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2) ) {
                            alt41=3;
                        }
                        else if ( LA41_0 == Default && getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3) ) {
                            alt41=4;
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
                    	    // InternalRos1Parser.g:1863:6: ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1863:6: ({...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1864:7: {...}? => ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2)");
                    	    }
                    	    // InternalRos1Parser.g:1864:113: ( ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) ) )
                    	    // InternalRos1Parser.g:1865:8: ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 2);
                    	    							
                    	    // InternalRos1Parser.g:1868:11: ({...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) ) )
                    	    // InternalRos1Parser.g:1868:12: {...}? => (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1868:21: (otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) ) )
                    	    // InternalRos1Parser.g:1868:22: otherlv_9= Format ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Format,FOLLOW_40); 

                    	    											newLeafNode(otherlv_9, grammarAccess.getPluginSlotAccess().getFormatKeyword_3_0_1_2_0());
                    	    										
                    	    // InternalRos1Parser.g:1872:11: ( (lv_valueFormat_10_0= rulePluginSlotValueFormat ) )
                    	    // InternalRos1Parser.g:1873:12: (lv_valueFormat_10_0= rulePluginSlotValueFormat )
                    	    {
                    	    // InternalRos1Parser.g:1873:12: (lv_valueFormat_10_0= rulePluginSlotValueFormat )
                    	    // InternalRos1Parser.g:1874:13: lv_valueFormat_10_0= rulePluginSlotValueFormat
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_3_0_1_2_1_0());
                    	    												
                    	    pushFollow(FOLLOW_39);
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
                    	    // InternalRos1Parser.g:1897:6: ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) )
                    	    {
                    	    // InternalRos1Parser.g:1897:6: ({...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) ) )
                    	    // InternalRos1Parser.g:1898:7: {...}? => ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "getUnorderedGroupHelper().canSelect(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3)");
                    	    }
                    	    // InternalRos1Parser.g:1898:113: ( ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) ) )
                    	    // InternalRos1Parser.g:1899:8: ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) )
                    	    {

                    	    								getUnorderedGroupHelper().select(grammarAccess.getPluginSlotAccess().getUnorderedGroup_3_0_1(), 3);
                    	    							
                    	    // InternalRos1Parser.g:1902:11: ({...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) ) )
                    	    // InternalRos1Parser.g:1902:12: {...}? => (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "rulePluginSlot", "true");
                    	    }
                    	    // InternalRos1Parser.g:1902:21: (otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) ) )
                    	    // InternalRos1Parser.g:1902:22: otherlv_11= Default ( (lv_defaultPlugin_12_0= ruleEString ) )
                    	    {
                    	    otherlv_11=(Token)match(input,Default,FOLLOW_6); 

                    	    											newLeafNode(otherlv_11, grammarAccess.getPluginSlotAccess().getDefaultKeyword_3_0_1_3_0());
                    	    										
                    	    // InternalRos1Parser.g:1906:11: ( (lv_defaultPlugin_12_0= ruleEString ) )
                    	    // InternalRos1Parser.g:1907:12: (lv_defaultPlugin_12_0= ruleEString )
                    	    {
                    	    // InternalRos1Parser.g:1907:12: (lv_defaultPlugin_12_0= ruleEString )
                    	    // InternalRos1Parser.g:1908:13: lv_defaultPlugin_12_0= ruleEString
                    	    {

                    	    													newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginEStringParserRuleCall_3_0_1_3_1_0());
                    	    												
                    	    pushFollow(FOLLOW_39);
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

                    this_END_13=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_13, grammarAccess.getPluginSlotAccess().getENDTerminalRuleCall_3_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:1945:4: (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket )
                    {
                    // InternalRos1Parser.g:1945:4: (otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket )
                    // InternalRos1Parser.g:1946:5: otherlv_14= LeftCurlyBracket otherlv_15= Base ( (lv_base_16_0= ruleEString ) ) (otherlv_17= Comma )? otherlv_18= Parameter ( (lv_parameter_19_0= ruleEString ) ) ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )? ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )? otherlv_26= RightCurlyBracket
                    {
                    otherlv_14=(Token)match(input,LeftCurlyBracket,FOLLOW_41); 

                    					newLeafNode(otherlv_14, grammarAccess.getPluginSlotAccess().getLeftCurlyBracketKeyword_3_1_0());
                    				
                    otherlv_15=(Token)match(input,Base,FOLLOW_6); 

                    					newLeafNode(otherlv_15, grammarAccess.getPluginSlotAccess().getBaseKeyword_3_1_1());
                    				
                    // InternalRos1Parser.g:1954:5: ( (lv_base_16_0= ruleEString ) )
                    // InternalRos1Parser.g:1955:6: (lv_base_16_0= ruleEString )
                    {
                    // InternalRos1Parser.g:1955:6: (lv_base_16_0= ruleEString )
                    // InternalRos1Parser.g:1956:7: lv_base_16_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getBaseEStringParserRuleCall_3_1_2_0());
                    						
                    pushFollow(FOLLOW_42);
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

                    // InternalRos1Parser.g:1973:5: (otherlv_17= Comma )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==Comma) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalRos1Parser.g:1974:6: otherlv_17= Comma
                            {
                            otherlv_17=(Token)match(input,Comma,FOLLOW_43); 

                            						newLeafNode(otherlv_17, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_3());
                            					

                            }
                            break;

                    }

                    otherlv_18=(Token)match(input,Parameter,FOLLOW_6); 

                    					newLeafNode(otherlv_18, grammarAccess.getPluginSlotAccess().getParameterKeyword_3_1_4());
                    				
                    // InternalRos1Parser.g:1983:5: ( (lv_parameter_19_0= ruleEString ) )
                    // InternalRos1Parser.g:1984:6: (lv_parameter_19_0= ruleEString )
                    {
                    // InternalRos1Parser.g:1984:6: (lv_parameter_19_0= ruleEString )
                    // InternalRos1Parser.g:1985:7: lv_parameter_19_0= ruleEString
                    {

                    							newCompositeNode(grammarAccess.getPluginSlotAccess().getParameterEStringParserRuleCall_3_1_5_0());
                    						
                    pushFollow(FOLLOW_44);
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

                    // InternalRos1Parser.g:2002:5: ( (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) ) )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==Comma) ) {
                        int LA44_1 = input.LA(2);

                        if ( (LA44_1==Format) ) {
                            alt44=1;
                        }
                    }
                    else if ( (LA44_0==Format) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalRos1Parser.g:2003:6: (otherlv_20= Comma )? otherlv_21= Format ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) )
                            {
                            // InternalRos1Parser.g:2003:6: (otherlv_20= Comma )?
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( (LA43_0==Comma) ) {
                                alt43=1;
                            }
                            switch (alt43) {
                                case 1 :
                                    // InternalRos1Parser.g:2004:7: otherlv_20= Comma
                                    {
                                    otherlv_20=(Token)match(input,Comma,FOLLOW_45); 

                                    							newLeafNode(otherlv_20, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_6_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_21=(Token)match(input,Format,FOLLOW_40); 

                            						newLeafNode(otherlv_21, grammarAccess.getPluginSlotAccess().getFormatKeyword_3_1_6_1());
                            					
                            // InternalRos1Parser.g:2013:6: ( (lv_valueFormat_22_0= rulePluginSlotValueFormat ) )
                            // InternalRos1Parser.g:2014:7: (lv_valueFormat_22_0= rulePluginSlotValueFormat )
                            {
                            // InternalRos1Parser.g:2014:7: (lv_valueFormat_22_0= rulePluginSlotValueFormat )
                            // InternalRos1Parser.g:2015:8: lv_valueFormat_22_0= rulePluginSlotValueFormat
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getValueFormatPluginSlotValueFormatEnumRuleCall_3_1_6_2_0());
                            							
                            pushFollow(FOLLOW_46);
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

                    // InternalRos1Parser.g:2033:5: ( (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==Default||LA46_0==Comma) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalRos1Parser.g:2034:6: (otherlv_23= Comma )? otherlv_24= Default ( (lv_defaultPlugin_25_0= ruleEString ) )
                            {
                            // InternalRos1Parser.g:2034:6: (otherlv_23= Comma )?
                            int alt45=2;
                            int LA45_0 = input.LA(1);

                            if ( (LA45_0==Comma) ) {
                                alt45=1;
                            }
                            switch (alt45) {
                                case 1 :
                                    // InternalRos1Parser.g:2035:7: otherlv_23= Comma
                                    {
                                    otherlv_23=(Token)match(input,Comma,FOLLOW_47); 

                                    							newLeafNode(otherlv_23, grammarAccess.getPluginSlotAccess().getCommaKeyword_3_1_7_0());
                                    						

                                    }
                                    break;

                            }

                            otherlv_24=(Token)match(input,Default,FOLLOW_6); 

                            						newLeafNode(otherlv_24, grammarAccess.getPluginSlotAccess().getDefaultKeyword_3_1_7_1());
                            					
                            // InternalRos1Parser.g:2044:6: ( (lv_defaultPlugin_25_0= ruleEString ) )
                            // InternalRos1Parser.g:2045:7: (lv_defaultPlugin_25_0= ruleEString )
                            {
                            // InternalRos1Parser.g:2045:7: (lv_defaultPlugin_25_0= ruleEString )
                            // InternalRos1Parser.g:2046:8: lv_defaultPlugin_25_0= ruleEString
                            {

                            								newCompositeNode(grammarAccess.getPluginSlotAccess().getDefaultPluginEStringParserRuleCall_3_1_7_2_0());
                            							
                            pushFollow(FOLLOW_48);
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
    // InternalRos1Parser.g:2074:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRos1Parser.g:2074:47: (iv_ruleEString= ruleEString EOF )
            // InternalRos1Parser.g:2075:2: iv_ruleEString= ruleEString EOF
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
    // InternalRos1Parser.g:2081:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2087:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library ) )
            // InternalRos1Parser.g:2088:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            {
            // InternalRos1Parser.g:2088:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            int alt48=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt48=1;
                }
                break;
            case RULE_ID:
                {
                alt48=2;
                }
                break;
            case Pluginlib:
                {
                alt48=3;
                }
                break;
            case External:
                {
                alt48=4;
                }
                break;
            case Class:
                {
                alt48=5;
                }
                break;
            case Library:
                {
                alt48=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalRos1Parser.g:2089:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2097:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2105:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getPluginlibKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2111:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getExternalKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2117:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEStringAccess().getClassKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2123:3: kw= Library
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
    // InternalRos1Parser.g:2132:1: entryRuleRosNames returns [String current=null] : iv_ruleRosNames= ruleRosNames EOF ;
    public final String entryRuleRosNames() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRosNames = null;


        try {
            // InternalRos1Parser.g:2132:48: (iv_ruleRosNames= ruleRosNames EOF )
            // InternalRos1Parser.g:2133:2: iv_ruleRosNames= ruleRosNames EOF
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
    // InternalRos1Parser.g:2139:1: ruleRosNames returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library ) ;
    public final AntlrDatatypeRuleToken ruleRosNames() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ROS_CONVENTION_A_0=null;
        Token this_ID_1=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2145:2: ( (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library ) )
            // InternalRos1Parser.g:2146:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            {
            // InternalRos1Parser.g:2146:2: (this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A | this_ID_1= RULE_ID | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library )
            int alt49=7;
            switch ( input.LA(1) ) {
            case RULE_ROS_CONVENTION_A:
                {
                alt49=1;
                }
                break;
            case RULE_ID:
                {
                alt49=2;
                }
                break;
            case Node:
                {
                alt49=3;
                }
                break;
            case Pluginlib:
                {
                alt49=4;
                }
                break;
            case External:
                {
                alt49=5;
                }
                break;
            case Class:
                {
                alt49=6;
                }
                break;
            case Library:
                {
                alt49=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalRos1Parser.g:2147:3: this_ROS_CONVENTION_A_0= RULE_ROS_CONVENTION_A
                    {
                    this_ROS_CONVENTION_A_0=(Token)match(input,RULE_ROS_CONVENTION_A,FOLLOW_2); 

                    			current.merge(this_ROS_CONVENTION_A_0);
                    		

                    			newLeafNode(this_ROS_CONVENTION_A_0, grammarAccess.getRosNamesAccess().getROS_CONVENTION_ATerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2155:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getRosNamesAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2163:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getNodeKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2169:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getPluginlibKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2175:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getExternalKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2181:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getRosNamesAccess().getClassKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2187:3: kw= Library
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
    // InternalRos1Parser.g:2196:1: entryRuleExtensionKey returns [String current=null] : iv_ruleExtensionKey= ruleExtensionKey EOF ;
    public final String entryRuleExtensionKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionKey = null;


        try {
            // InternalRos1Parser.g:2196:52: (iv_ruleExtensionKey= ruleExtensionKey EOF )
            // InternalRos1Parser.g:2197:2: iv_ruleExtensionKey= ruleExtensionKey EOF
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
    // InternalRos1Parser.g:2203:1: ruleExtensionKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) ;
    public final AntlrDatatypeRuleToken ruleExtensionKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:2209:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header ) )
            // InternalRos1Parser.g:2210:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            {
            // InternalRos1Parser.g:2210:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING | this_KEYWORD_2= ruleKEYWORD | kw= Node | kw= Pluginlib | kw= External | kw= Class | kw= Library | kw= String | kw= Integer | kw= Double | kw= Boolean | kw= Base64 | kw= Array | kw= List | kw= Struct | kw= Date | kw= Any | kw= Bool | kw= Int8 | kw= Uint8 | kw= Int16 | kw= Uint16 | kw= Int32 | kw= Uint32 | kw= Int64 | kw= Uint64 | kw= Float32 | kw= Float64 | kw= String_1 | kw= Char | kw= Byte | kw= Header )
            int alt50=33;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt50=1;
                }
                break;
            case RULE_STRING:
                {
                alt50=2;
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
                alt50=3;
                }
                break;
            case Node:
                {
                alt50=4;
                }
                break;
            case Pluginlib:
                {
                alt50=5;
                }
                break;
            case External:
                {
                alt50=6;
                }
                break;
            case Class:
                {
                alt50=7;
                }
                break;
            case Library:
                {
                alt50=8;
                }
                break;
            case String:
                {
                alt50=9;
                }
                break;
            case Integer:
                {
                alt50=10;
                }
                break;
            case Double:
                {
                alt50=11;
                }
                break;
            case Boolean:
                {
                alt50=12;
                }
                break;
            case Base64:
                {
                alt50=13;
                }
                break;
            case Array:
                {
                alt50=14;
                }
                break;
            case List:
                {
                alt50=15;
                }
                break;
            case Struct:
                {
                alt50=16;
                }
                break;
            case Date:
                {
                alt50=17;
                }
                break;
            case Any:
                {
                alt50=18;
                }
                break;
            case Bool:
                {
                alt50=19;
                }
                break;
            case Int8:
                {
                alt50=20;
                }
                break;
            case Uint8:
                {
                alt50=21;
                }
                break;
            case Int16:
                {
                alt50=22;
                }
                break;
            case Uint16:
                {
                alt50=23;
                }
                break;
            case Int32:
                {
                alt50=24;
                }
                break;
            case Uint32:
                {
                alt50=25;
                }
                break;
            case Int64:
                {
                alt50=26;
                }
                break;
            case Uint64:
                {
                alt50=27;
                }
                break;
            case Float32:
                {
                alt50=28;
                }
                break;
            case Float64:
                {
                alt50=29;
                }
                break;
            case String_1:
                {
                alt50=30;
                }
                break;
            case Char:
                {
                alt50=31;
                }
                break;
            case Byte:
                {
                alt50=32;
                }
                break;
            case Header:
                {
                alt50=33;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalRos1Parser.g:2211:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getExtensionKeyAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2219:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getExtensionKeyAccess().getSTRINGTerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2227:3: this_KEYWORD_2= ruleKEYWORD
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
                    // InternalRos1Parser.g:2238:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getNodeKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2244:3: kw= Pluginlib
                    {
                    kw=(Token)match(input,Pluginlib,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getPluginlibKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2250:3: kw= External
                    {
                    kw=(Token)match(input,External,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getExternalKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2256:3: kw= Class
                    {
                    kw=(Token)match(input,Class,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getClassKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:2262:3: kw= Library
                    {
                    kw=(Token)match(input,Library,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getLibraryKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:2268:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:2274:3: kw= Integer
                    {
                    kw=(Token)match(input,Integer,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getIntegerKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:2280:3: kw= Double
                    {
                    kw=(Token)match(input,Double,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDoubleKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:2286:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBooleanKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:2292:3: kw= Base64
                    {
                    kw=(Token)match(input,Base64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBase64Keyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:2298:3: kw= Array
                    {
                    kw=(Token)match(input,Array,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getArrayKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:2304:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getListKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:2310:3: kw= Struct
                    {
                    kw=(Token)match(input,Struct,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStructKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRos1Parser.g:2316:3: kw= Date
                    {
                    kw=(Token)match(input,Date,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getDateKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRos1Parser.g:2322:3: kw= Any
                    {
                    kw=(Token)match(input,Any,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getAnyKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRos1Parser.g:2328:3: kw= Bool
                    {
                    kw=(Token)match(input,Bool,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getBoolKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRos1Parser.g:2334:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt8Keyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRos1Parser.g:2340:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint8Keyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRos1Parser.g:2346:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt16Keyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRos1Parser.g:2352:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint16Keyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalRos1Parser.g:2358:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt32Keyword_23());
                    		

                    }
                    break;
                case 25 :
                    // InternalRos1Parser.g:2364:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint32Keyword_24());
                    		

                    }
                    break;
                case 26 :
                    // InternalRos1Parser.g:2370:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getInt64Keyword_25());
                    		

                    }
                    break;
                case 27 :
                    // InternalRos1Parser.g:2376:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getUint64Keyword_26());
                    		

                    }
                    break;
                case 28 :
                    // InternalRos1Parser.g:2382:3: kw= Float32
                    {
                    kw=(Token)match(input,Float32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat32Keyword_27());
                    		

                    }
                    break;
                case 29 :
                    // InternalRos1Parser.g:2388:3: kw= Float64
                    {
                    kw=(Token)match(input,Float64,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getFloat64Keyword_28());
                    		

                    }
                    break;
                case 30 :
                    // InternalRos1Parser.g:2394:3: kw= String_1
                    {
                    kw=(Token)match(input,String_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getStringKeyword_29());
                    		

                    }
                    break;
                case 31 :
                    // InternalRos1Parser.g:2400:3: kw= Char
                    {
                    kw=(Token)match(input,Char,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getCharKeyword_30());
                    		

                    }
                    break;
                case 32 :
                    // InternalRos1Parser.g:2406:3: kw= Byte
                    {
                    kw=(Token)match(input,Byte,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionKeyAccess().getByteKeyword_31());
                    		

                    }
                    break;
                case 33 :
                    // InternalRos1Parser.g:2412:3: kw= Header
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
    // InternalRos1Parser.g:2421:1: entryRuleExtensionColonKey returns [String current=null] : iv_ruleExtensionColonKey= ruleExtensionColonKey EOF ;
    public final String entryRuleExtensionColonKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionColonKey = null;


        try {
            // InternalRos1Parser.g:2421:57: (iv_ruleExtensionColonKey= ruleExtensionColonKey EOF )
            // InternalRos1Parser.g:2422:2: iv_ruleExtensionColonKey= ruleExtensionColonKey EOF
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
    // InternalRos1Parser.g:2428:1: ruleExtensionColonKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format ) ;
    public final AntlrDatatypeRuleToken ruleExtensionColonKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:2434:2: ( (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format ) )
            // InternalRos1Parser.g:2435:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format )
            {
            // InternalRos1Parser.g:2435:2: (kw= Ns | kw= Type_1 | kw= Value_1 | kw= Default | kw= FromGitRepo | kw= Dependencies | kw= Msgs | kw= Srvs | kw= Actions | kw= Node_1 | kw= Publishers | kw= Subscribers | kw= Serviceservers | kw= Serviceclients | kw= Actionservers | kw= Actionclients | kw= Parameters | kw= Plugins | kw= Implements | kw= Loader | kw= Pluginslots | kw= Base | kw= Parameter | kw= Format )
            int alt51=24;
            switch ( input.LA(1) ) {
            case Ns:
                {
                alt51=1;
                }
                break;
            case Type_1:
                {
                alt51=2;
                }
                break;
            case Value_1:
                {
                alt51=3;
                }
                break;
            case Default:
                {
                alt51=4;
                }
                break;
            case FromGitRepo:
                {
                alt51=5;
                }
                break;
            case Dependencies:
                {
                alt51=6;
                }
                break;
            case Msgs:
                {
                alt51=7;
                }
                break;
            case Srvs:
                {
                alt51=8;
                }
                break;
            case Actions:
                {
                alt51=9;
                }
                break;
            case Node_1:
                {
                alt51=10;
                }
                break;
            case Publishers:
                {
                alt51=11;
                }
                break;
            case Subscribers:
                {
                alt51=12;
                }
                break;
            case Serviceservers:
                {
                alt51=13;
                }
                break;
            case Serviceclients:
                {
                alt51=14;
                }
                break;
            case Actionservers:
                {
                alt51=15;
                }
                break;
            case Actionclients:
                {
                alt51=16;
                }
                break;
            case Parameters:
                {
                alt51=17;
                }
                break;
            case Plugins:
                {
                alt51=18;
                }
                break;
            case Implements:
                {
                alt51=19;
                }
                break;
            case Loader:
                {
                alt51=20;
                }
                break;
            case Pluginslots:
                {
                alt51=21;
                }
                break;
            case Base:
                {
                alt51=22;
                }
                break;
            case Parameter:
                {
                alt51=23;
                }
                break;
            case Format:
                {
                alt51=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalRos1Parser.g:2436:3: kw= Ns
                    {
                    kw=(Token)match(input,Ns,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:2442:3: kw= Type_1
                    {
                    kw=(Token)match(input,Type_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getTypeKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:2448:3: kw= Value_1
                    {
                    kw=(Token)match(input,Value_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getValueKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:2454:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDefaultKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:2460:3: kw= FromGitRepo
                    {
                    kw=(Token)match(input,FromGitRepo,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getFromGitRepoKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:2466:3: kw= Dependencies
                    {
                    kw=(Token)match(input,Dependencies,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getDependenciesKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:2472:3: kw= Msgs
                    {
                    kw=(Token)match(input,Msgs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getMsgsKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:2478:3: kw= Srvs
                    {
                    kw=(Token)match(input,Srvs,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSrvsKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:2484:3: kw= Actions
                    {
                    kw=(Token)match(input,Actions,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionsKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:2490:3: kw= Node_1
                    {
                    kw=(Token)match(input,Node_1,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getNodeKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:2496:3: kw= Publishers
                    {
                    kw=(Token)match(input,Publishers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPublishersKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalRos1Parser.g:2502:3: kw= Subscribers
                    {
                    kw=(Token)match(input,Subscribers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getSubscribersKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalRos1Parser.g:2508:3: kw= Serviceservers
                    {
                    kw=(Token)match(input,Serviceservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceserversKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalRos1Parser.g:2514:3: kw= Serviceclients
                    {
                    kw=(Token)match(input,Serviceclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getServiceclientsKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalRos1Parser.g:2520:3: kw= Actionservers
                    {
                    kw=(Token)match(input,Actionservers,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionserversKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalRos1Parser.g:2526:3: kw= Actionclients
                    {
                    kw=(Token)match(input,Actionclients,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getActionclientsKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalRos1Parser.g:2532:3: kw= Parameters
                    {
                    kw=(Token)match(input,Parameters,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParametersKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalRos1Parser.g:2538:3: kw= Plugins
                    {
                    kw=(Token)match(input,Plugins,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPluginsKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalRos1Parser.g:2544:3: kw= Implements
                    {
                    kw=(Token)match(input,Implements,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getImplementsKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalRos1Parser.g:2550:3: kw= Loader
                    {
                    kw=(Token)match(input,Loader,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getLoaderKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalRos1Parser.g:2556:3: kw= Pluginslots
                    {
                    kw=(Token)match(input,Pluginslots,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getPluginslotsKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalRos1Parser.g:2562:3: kw= Base
                    {
                    kw=(Token)match(input,Base,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getBaseKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalRos1Parser.g:2568:3: kw= Parameter
                    {
                    kw=(Token)match(input,Parameter,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getExtensionColonKeyAccess().getParameterKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalRos1Parser.g:2574:3: kw= Format
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
    // InternalRos1Parser.g:2583:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // InternalRos1Parser.g:2583:50: (iv_rulePublisher= rulePublisher EOF )
            // InternalRos1Parser.g:2584:2: iv_rulePublisher= rulePublisher EOF
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
    // InternalRos1Parser.g:2590:1: rulePublisher returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2596:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2597:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2597:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2598:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2598:3: ()
            // InternalRos1Parser.g:2599:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPublisherAccess().getPublisherAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2605:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2606:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2606:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2607:5: lv_name_1_0= ruleEString
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
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_49); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getPublisherAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getPublisherAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2636:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2637:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2637:4: ( ruleEString )
            // InternalRos1Parser.g:2638:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPublisherRule());
            					}
            				

            					newCompositeNode(grammarAccess.getPublisherAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2652:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==Ns) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalRos1Parser.g:2653:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_51); 

                    				newLeafNode(otherlv_6, grammarAccess.getPublisherAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2657:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2658:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2658:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2659:6: lv_namespace_7_0= ruleNamespace
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
    // InternalRos1Parser.g:2685:1: entryRuleSubscriber returns [EObject current=null] : iv_ruleSubscriber= ruleSubscriber EOF ;
    public final EObject entryRuleSubscriber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscriber = null;


        try {
            // InternalRos1Parser.g:2685:51: (iv_ruleSubscriber= ruleSubscriber EOF )
            // InternalRos1Parser.g:2686:2: iv_ruleSubscriber= ruleSubscriber EOF
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
    // InternalRos1Parser.g:2692:1: ruleSubscriber returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2698:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2699:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2699:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2700:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2700:3: ()
            // InternalRos1Parser.g:2701:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSubscriberAccess().getSubscriberAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2707:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2708:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2708:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2709:5: lv_name_1_0= ruleEString
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
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_49); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getSubscriberAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getSubscriberAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2738:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2739:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2739:4: ( ruleEString )
            // InternalRos1Parser.g:2740:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubscriberRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSubscriberAccess().getMessageTopicSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2754:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Ns) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalRos1Parser.g:2755:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_51); 

                    				newLeafNode(otherlv_6, grammarAccess.getSubscriberAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2759:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2760:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2760:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2761:6: lv_namespace_7_0= ruleNamespace
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
    // InternalRos1Parser.g:2787:1: entryRuleServiceServer returns [EObject current=null] : iv_ruleServiceServer= ruleServiceServer EOF ;
    public final EObject entryRuleServiceServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceServer = null;


        try {
            // InternalRos1Parser.g:2787:54: (iv_ruleServiceServer= ruleServiceServer EOF )
            // InternalRos1Parser.g:2788:2: iv_ruleServiceServer= ruleServiceServer EOF
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
    // InternalRos1Parser.g:2794:1: ruleServiceServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2800:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2801:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2801:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2802:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2802:3: ()
            // InternalRos1Parser.g:2803:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceServerAccess().getServiceServerAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2809:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2810:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2810:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2811:5: lv_name_1_0= ruleEString
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
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_49); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceServerAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2840:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2841:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2841:4: ( ruleEString )
            // InternalRos1Parser.g:2842:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceServerAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2856:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==Ns) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalRos1Parser.g:2857:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_51); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2861:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2862:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2862:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2863:6: lv_namespace_7_0= ruleNamespace
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
    // InternalRos1Parser.g:2889:1: entryRuleServiceClient returns [EObject current=null] : iv_ruleServiceClient= ruleServiceClient EOF ;
    public final EObject entryRuleServiceClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceClient = null;


        try {
            // InternalRos1Parser.g:2889:54: (iv_ruleServiceClient= ruleServiceClient EOF )
            // InternalRos1Parser.g:2890:2: iv_ruleServiceClient= ruleServiceClient EOF
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
    // InternalRos1Parser.g:2896:1: ruleServiceClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:2902:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:2903:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:2903:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:2904:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:2904:3: ()
            // InternalRos1Parser.g:2905:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getServiceClientAccess().getServiceClientAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:2911:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:2912:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:2912:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:2913:5: lv_name_1_0= ruleEString
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
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_49); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getServiceClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getServiceClientAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:2942:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:2943:4: ( ruleEString )
            {
            // InternalRos1Parser.g:2943:4: ( ruleEString )
            // InternalRos1Parser.g:2944:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getServiceClientAccess().getServiceServiceSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:2958:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==Ns) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalRos1Parser.g:2959:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_51); 

                    				newLeafNode(otherlv_6, grammarAccess.getServiceClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:2963:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:2964:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:2964:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:2965:6: lv_namespace_7_0= ruleNamespace
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
    // InternalRos1Parser.g:2991:1: entryRuleActionServer returns [EObject current=null] : iv_ruleActionServer= ruleActionServer EOF ;
    public final EObject entryRuleActionServer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionServer = null;


        try {
            // InternalRos1Parser.g:2991:53: (iv_ruleActionServer= ruleActionServer EOF )
            // InternalRos1Parser.g:2992:2: iv_ruleActionServer= ruleActionServer EOF
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
    // InternalRos1Parser.g:2998:1: ruleActionServer returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:3004:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:3005:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:3005:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:3006:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:3006:3: ()
            // InternalRos1Parser.g:3007:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionServerAccess().getActionServerAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3013:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:3014:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:3014:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:3015:5: lv_name_1_0= ruleEString
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
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_49); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionServerAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getActionServerAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:3044:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:3045:4: ( ruleEString )
            {
            // InternalRos1Parser.g:3045:4: ( ruleEString )
            // InternalRos1Parser.g:3046:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionServerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionServerAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:3060:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==Ns) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRos1Parser.g:3061:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_51); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionServerAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:3065:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3066:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3066:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:3067:6: lv_namespace_7_0= ruleNamespace
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
    // InternalRos1Parser.g:3093:1: entryRuleActionClient returns [EObject current=null] : iv_ruleActionClient= ruleActionClient EOF ;
    public final EObject entryRuleActionClient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionClient = null;


        try {
            // InternalRos1Parser.g:3093:53: (iv_ruleActionClient= ruleActionClient EOF )
            // InternalRos1Parser.g:3094:2: iv_ruleActionClient= ruleActionClient EOF
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
    // InternalRos1Parser.g:3100:1: ruleActionClient returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) ;
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
            // InternalRos1Parser.g:3106:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END ) )
            // InternalRos1Parser.g:3107:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            {
            // InternalRos1Parser.g:3107:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END )
            // InternalRos1Parser.g:3108:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN otherlv_4= Type_1 ( ( ruleEString ) ) (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )? this_END_8= RULE_END
            {
            // InternalRos1Parser.g:3108:3: ()
            // InternalRos1Parser.g:3109:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getActionClientAccess().getActionClientAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3115:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:3116:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:3116:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:3117:5: lv_name_1_0= ruleEString
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
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_49); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getActionClientAccess().getBEGINTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,Type_1,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getActionClientAccess().getTypeKeyword_4());
            		
            // InternalRos1Parser.g:3146:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:3147:4: ( ruleEString )
            {
            // InternalRos1Parser.g:3147:4: ( ruleEString )
            // InternalRos1Parser.g:3148:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionClientRule());
            					}
            				

            					newCompositeNode(grammarAccess.getActionClientAccess().getActionActionSpecCrossReference_5_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRos1Parser.g:3162:3: (otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==Ns) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalRos1Parser.g:3163:4: otherlv_6= Ns ( (lv_namespace_7_0= ruleNamespace ) )
                    {
                    otherlv_6=(Token)match(input,Ns,FOLLOW_51); 

                    				newLeafNode(otherlv_6, grammarAccess.getActionClientAccess().getNsKeyword_6_0());
                    			
                    // InternalRos1Parser.g:3167:4: ( (lv_namespace_7_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3168:5: (lv_namespace_7_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3168:5: (lv_namespace_7_0= ruleNamespace )
                    // InternalRos1Parser.g:3169:6: lv_namespace_7_0= ruleNamespace
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
    // InternalRos1Parser.g:3195:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalRos1Parser.g:3195:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalRos1Parser.g:3196:2: iv_ruleDependency= ruleDependency EOF
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
    // InternalRos1Parser.g:3202:1: ruleDependency returns [EObject current=null] : (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDependency_0 = null;

        EObject this_ExternalDependency_1 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3208:2: ( (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency ) )
            // InternalRos1Parser.g:3209:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            {
            // InternalRos1Parser.g:3209:2: (this_PackageDependency_0= rulePackageDependency | this_ExternalDependency_1= ruleExternalDependency )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Pluginlib||LA58_0==External||LA58_0==Library||LA58_0==Class||(LA58_0>=RULE_ID && LA58_0<=RULE_STRING)) ) {
                alt58=1;
            }
            else if ( (LA58_0==ExternalDependency) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalRos1Parser.g:3210:3: this_PackageDependency_0= rulePackageDependency
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
                    // InternalRos1Parser.g:3219:3: this_ExternalDependency_1= ruleExternalDependency
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
    // InternalRos1Parser.g:3231:1: entryRulePackageDependency returns [EObject current=null] : iv_rulePackageDependency= rulePackageDependency EOF ;
    public final EObject entryRulePackageDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDependency = null;


        try {
            // InternalRos1Parser.g:3231:58: (iv_rulePackageDependency= rulePackageDependency EOF )
            // InternalRos1Parser.g:3232:2: iv_rulePackageDependency= rulePackageDependency EOF
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
    // InternalRos1Parser.g:3238:1: rulePackageDependency returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject rulePackageDependency() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos1Parser.g:3244:2: ( ( ( ruleEString ) ) )
            // InternalRos1Parser.g:3245:2: ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:3245:2: ( ( ruleEString ) )
            // InternalRos1Parser.g:3246:3: ( ruleEString )
            {
            // InternalRos1Parser.g:3246:3: ( ruleEString )
            // InternalRos1Parser.g:3247:4: ruleEString
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
    // InternalRos1Parser.g:3264:1: entryRuleExternalDependency returns [EObject current=null] : iv_ruleExternalDependency= ruleExternalDependency EOF ;
    public final EObject entryRuleExternalDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDependency = null;


        try {
            // InternalRos1Parser.g:3264:59: (iv_ruleExternalDependency= ruleExternalDependency EOF )
            // InternalRos1Parser.g:3265:2: iv_ruleExternalDependency= ruleExternalDependency EOF
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
    // InternalRos1Parser.g:3271:1: ruleExternalDependency returns [EObject current=null] : ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleExternalDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3277:2: ( ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalRos1Parser.g:3278:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalRos1Parser.g:3278:2: ( () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) ) )
            // InternalRos1Parser.g:3279:3: () otherlv_1= ExternalDependency ( (lv_name_2_0= ruleEString ) )
            {
            // InternalRos1Parser.g:3279:3: ()
            // InternalRos1Parser.g:3280:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExternalDependencyAccess().getExternalDependencyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExternalDependency,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalDependencyAccess().getExternalDependencyKeyword_1());
            		
            // InternalRos1Parser.g:3290:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRos1Parser.g:3291:4: (lv_name_2_0= ruleEString )
            {
            // InternalRos1Parser.g:3291:4: (lv_name_2_0= ruleEString )
            // InternalRos1Parser.g:3292:5: lv_name_2_0= ruleEString
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
    // InternalRos1Parser.g:3313:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalRos1Parser.g:3313:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalRos1Parser.g:3314:2: iv_ruleNamespace= ruleNamespace EOF
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
    // InternalRos1Parser.g:3320:1: ruleNamespace returns [EObject current=null] : (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        EObject this_GlobalNamespace_0 = null;

        EObject this_RelativeNamespace_Impl_1 = null;

        EObject this_PrivateNamespace_2 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:3326:2: ( (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace ) )
            // InternalRos1Parser.g:3327:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            {
            // InternalRos1Parser.g:3327:2: (this_GlobalNamespace_0= ruleGlobalNamespace | this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl | this_PrivateNamespace_2= rulePrivateNamespace )
            int alt59=3;
            switch ( input.LA(1) ) {
            case GlobalNamespace:
                {
                alt59=1;
                }
                break;
            case RelativeNamespace:
                {
                alt59=2;
                }
                break;
            case PrivateNamespace:
                {
                alt59=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalRos1Parser.g:3328:3: this_GlobalNamespace_0= ruleGlobalNamespace
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
                    // InternalRos1Parser.g:3337:3: this_RelativeNamespace_Impl_1= ruleRelativeNamespace_Impl
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
                    // InternalRos1Parser.g:3346:3: this_PrivateNamespace_2= rulePrivateNamespace
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
    // InternalRos1Parser.g:3358:1: entryRuleGraphName returns [String current=null] : iv_ruleGraphName= ruleGraphName EOF ;
    public final String entryRuleGraphName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGraphName = null;


        try {
            // InternalRos1Parser.g:3358:49: (iv_ruleGraphName= ruleGraphName EOF )
            // InternalRos1Parser.g:3359:2: iv_ruleGraphName= ruleGraphName EOF
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
    // InternalRos1Parser.g:3365:1: ruleGraphName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= GraphName ;
    public final AntlrDatatypeRuleToken ruleGraphName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:3371:2: (kw= GraphName )
            // InternalRos1Parser.g:3372:2: kw= GraphName
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
    // InternalRos1Parser.g:3380:1: entryRuleGlobalNamespace returns [EObject current=null] : iv_ruleGlobalNamespace= ruleGlobalNamespace EOF ;
    public final EObject entryRuleGlobalNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalNamespace = null;


        try {
            // InternalRos1Parser.g:3380:56: (iv_ruleGlobalNamespace= ruleGlobalNamespace EOF )
            // InternalRos1Parser.g:3381:2: iv_ruleGlobalNamespace= ruleGlobalNamespace EOF
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
    // InternalRos1Parser.g:3387:1: ruleGlobalNamespace returns [EObject current=null] : ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3393:2: ( ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3394:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3394:2: ( () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3395:3: () otherlv_1= GlobalNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3395:3: ()
            // InternalRos1Parser.g:3396:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,GlobalNamespace,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getGlobalNamespaceAccess().getGlobalNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3406:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==LeftSquareBracket) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalRos1Parser.g:3407:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_53); 

                    				newLeafNode(otherlv_2, grammarAccess.getGlobalNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3411:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3412:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3412:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3413:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRos1Parser.g:3430:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==Comma) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3431:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_53); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getGlobalNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3435:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3436:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3436:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3437:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop60;
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
    // InternalRos1Parser.g:3464:1: entryRuleRelativeNamespace_Impl returns [EObject current=null] : iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF ;
    public final EObject entryRuleRelativeNamespace_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelativeNamespace_Impl = null;


        try {
            // InternalRos1Parser.g:3464:63: (iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF )
            // InternalRos1Parser.g:3465:2: iv_ruleRelativeNamespace_Impl= ruleRelativeNamespace_Impl EOF
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
    // InternalRos1Parser.g:3471:1: ruleRelativeNamespace_Impl returns [EObject current=null] : ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3477:2: ( ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3478:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3478:2: ( () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3479:3: () otherlv_1= RelativeNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3479:3: ()
            // InternalRos1Parser.g:3480:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,RelativeNamespace,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getRelativeNamespace_ImplAccess().getRelativeNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3490:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==LeftSquareBracket) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRos1Parser.g:3491:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_53); 

                    				newLeafNode(otherlv_2, grammarAccess.getRelativeNamespace_ImplAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3495:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3496:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3496:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3497:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRos1Parser.g:3514:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop62:
                    do {
                        int alt62=2;
                        int LA62_0 = input.LA(1);

                        if ( (LA62_0==Comma) ) {
                            alt62=1;
                        }


                        switch (alt62) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3515:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_53); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRelativeNamespace_ImplAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3519:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3520:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3520:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3521:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop62;
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
    // InternalRos1Parser.g:3548:1: entryRulePrivateNamespace returns [EObject current=null] : iv_rulePrivateNamespace= rulePrivateNamespace EOF ;
    public final EObject entryRulePrivateNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivateNamespace = null;


        try {
            // InternalRos1Parser.g:3548:57: (iv_rulePrivateNamespace= rulePrivateNamespace EOF )
            // InternalRos1Parser.g:3549:2: iv_rulePrivateNamespace= rulePrivateNamespace EOF
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
    // InternalRos1Parser.g:3555:1: rulePrivateNamespace returns [EObject current=null] : ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) ;
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
            // InternalRos1Parser.g:3561:2: ( ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? ) )
            // InternalRos1Parser.g:3562:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            {
            // InternalRos1Parser.g:3562:2: ( () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )? )
            // InternalRos1Parser.g:3563:3: () otherlv_1= PrivateNamespace (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            {
            // InternalRos1Parser.g:3563:3: ()
            // InternalRos1Parser.g:3564:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,PrivateNamespace,FOLLOW_52); 

            			newLeafNode(otherlv_1, grammarAccess.getPrivateNamespaceAccess().getPrivateNamespaceKeyword_1());
            		
            // InternalRos1Parser.g:3574:3: (otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==LeftSquareBracket) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRos1Parser.g:3575:4: otherlv_2= LeftSquareBracket ( (lv_parts_3_0= ruleGraphName ) ) (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )* otherlv_6= RightSquareBracket
                    {
                    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_53); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrivateNamespaceAccess().getLeftSquareBracketKeyword_2_0());
                    			
                    // InternalRos1Parser.g:3579:4: ( (lv_parts_3_0= ruleGraphName ) )
                    // InternalRos1Parser.g:3580:5: (lv_parts_3_0= ruleGraphName )
                    {
                    // InternalRos1Parser.g:3580:5: (lv_parts_3_0= ruleGraphName )
                    // InternalRos1Parser.g:3581:6: lv_parts_3_0= ruleGraphName
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

                    // InternalRos1Parser.g:3598:4: (otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==Comma) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalRos1Parser.g:3599:5: otherlv_4= Comma ( (lv_parts_5_0= ruleGraphName ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_53); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getPrivateNamespaceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalRos1Parser.g:3603:5: ( (lv_parts_5_0= ruleGraphName ) )
                    	    // InternalRos1Parser.g:3604:6: (lv_parts_5_0= ruleGraphName )
                    	    {
                    	    // InternalRos1Parser.g:3604:6: (lv_parts_5_0= ruleGraphName )
                    	    // InternalRos1Parser.g:3605:7: lv_parts_5_0= ruleGraphName
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
                    	    break loop64;
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
    // InternalRos1Parser.g:3632:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalRos1Parser.g:3632:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalRos1Parser.g:3633:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalRos1Parser.g:3639:1: ruleParameter returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) ;
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
            // InternalRos1Parser.g:3645:2: ( ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END ) )
            // InternalRos1Parser.g:3646:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            {
            // InternalRos1Parser.g:3646:2: ( () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END )
            // InternalRos1Parser.g:3647:3: () ( (lv_name_1_0= ruleEString ) ) otherlv_2= Colon this_BEGIN_3= RULE_BEGIN (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )? otherlv_6= Type_1 ( (lv_type_7_0= ruleParameterType ) ) (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )? this_END_10= RULE_END
            {
            // InternalRos1Parser.g:3647:3: ()
            // InternalRos1Parser.g:3648:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAccess().getParameterAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:3654:3: ( (lv_name_1_0= ruleEString ) )
            // InternalRos1Parser.g:3655:4: (lv_name_1_0= ruleEString )
            {
            // InternalRos1Parser.g:3655:4: (lv_name_1_0= ruleEString )
            // InternalRos1Parser.g:3656:5: lv_name_1_0= ruleEString
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
            		
            this_BEGIN_3=(Token)match(input,RULE_BEGIN,FOLLOW_54); 

            			newLeafNode(this_BEGIN_3, grammarAccess.getParameterAccess().getBEGINTerminalRuleCall_3());
            		
            // InternalRos1Parser.g:3681:3: (otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==Ns) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalRos1Parser.g:3682:4: otherlv_4= Ns ( (lv_namespace_5_0= ruleNamespace ) )
                    {
                    otherlv_4=(Token)match(input,Ns,FOLLOW_51); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getNsKeyword_4_0());
                    			
                    // InternalRos1Parser.g:3686:4: ( (lv_namespace_5_0= ruleNamespace ) )
                    // InternalRos1Parser.g:3687:5: (lv_namespace_5_0= ruleNamespace )
                    {
                    // InternalRos1Parser.g:3687:5: (lv_namespace_5_0= ruleNamespace )
                    // InternalRos1Parser.g:3688:6: lv_namespace_5_0= ruleNamespace
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getNamespaceNamespaceParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_49);
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

            otherlv_6=(Token)match(input,Type_1,FOLLOW_55); 

            			newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getTypeKeyword_5());
            		
            // InternalRos1Parser.g:3710:3: ( (lv_type_7_0= ruleParameterType ) )
            // InternalRos1Parser.g:3711:4: (lv_type_7_0= ruleParameterType )
            {
            // InternalRos1Parser.g:3711:4: (lv_type_7_0= ruleParameterType )
            // InternalRos1Parser.g:3712:5: lv_type_7_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_56);
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

            // InternalRos1Parser.g:3729:3: (otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Value_1) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalRos1Parser.g:3730:4: otherlv_8= Value_1 ( (lv_value_9_0= ruleParameterValue ) )
                    {
                    otherlv_8=(Token)match(input,Value_1,FOLLOW_57); 

                    				newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getValueKeyword_7_0());
                    			
                    // InternalRos1Parser.g:3734:4: ( (lv_value_9_0= ruleParameterValue ) )
                    // InternalRos1Parser.g:3735:5: (lv_value_9_0= ruleParameterValue )
                    {
                    // InternalRos1Parser.g:3735:5: (lv_value_9_0= ruleParameterValue )
                    // InternalRos1Parser.g:3736:6: lv_value_9_0= ruleParameterValue
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
    // InternalRos1Parser.g:3762:1: entryRuleParameterType returns [EObject current=null] : iv_ruleParameterType= ruleParameterType EOF ;
    public final EObject entryRuleParameterType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterType = null;


        try {
            // InternalRos1Parser.g:3762:54: (iv_ruleParameterType= ruleParameterType EOF )
            // InternalRos1Parser.g:3763:2: iv_ruleParameterType= ruleParameterType EOF
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
    // InternalRos1Parser.g:3769:1: ruleParameterType returns [EObject current=null] : (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) ;
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
            // InternalRos1Parser.g:3775:2: ( (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType ) )
            // InternalRos1Parser.g:3776:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            {
            // InternalRos1Parser.g:3776:2: (this_ParameterListType_0= ruleParameterListType | this_ParameterStructType_1= ruleParameterStructType | this_ParameterIntegerType_2= ruleParameterIntegerType | this_ParameterStringType_3= ruleParameterStringType | this_ParameterDoubleType_4= ruleParameterDoubleType | this_ParameterBooleanType_5= ruleParameterBooleanType | this_ParameterBase64Type_6= ruleParameterBase64Type | this_ParameterArrayType_7= ruleParameterArrayType )
            int alt68=8;
            switch ( input.LA(1) ) {
            case List:
                {
                alt68=1;
                }
                break;
            case Struct:
                {
                alt68=2;
                }
                break;
            case Integer:
                {
                alt68=3;
                }
                break;
            case String:
                {
                alt68=4;
                }
                break;
            case Double:
                {
                alt68=5;
                }
                break;
            case Boolean:
                {
                alt68=6;
                }
                break;
            case Base64:
                {
                alt68=7;
                }
                break;
            case Array:
                {
                alt68=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalRos1Parser.g:3777:3: this_ParameterListType_0= ruleParameterListType
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
                    // InternalRos1Parser.g:3786:3: this_ParameterStructType_1= ruleParameterStructType
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
                    // InternalRos1Parser.g:3795:3: this_ParameterIntegerType_2= ruleParameterIntegerType
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
                    // InternalRos1Parser.g:3804:3: this_ParameterStringType_3= ruleParameterStringType
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
                    // InternalRos1Parser.g:3813:3: this_ParameterDoubleType_4= ruleParameterDoubleType
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
                    // InternalRos1Parser.g:3822:3: this_ParameterBooleanType_5= ruleParameterBooleanType
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
                    // InternalRos1Parser.g:3831:3: this_ParameterBase64Type_6= ruleParameterBase64Type
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
                    // InternalRos1Parser.g:3840:3: this_ParameterArrayType_7= ruleParameterArrayType
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
    // InternalRos1Parser.g:3852:1: entryRuleParameterValue returns [EObject current=null] : iv_ruleParameterValue= ruleParameterValue EOF ;
    public final EObject entryRuleParameterValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterValue = null;


        try {
            // InternalRos1Parser.g:3852:55: (iv_ruleParameterValue= ruleParameterValue EOF )
            // InternalRos1Parser.g:3853:2: iv_ruleParameterValue= ruleParameterValue EOF
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
    // InternalRos1Parser.g:3859:1: ruleParameterValue returns [EObject current=null] : (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) ;
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
            // InternalRos1Parser.g:3865:2: ( (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct ) )
            // InternalRos1Parser.g:3866:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            {
            // InternalRos1Parser.g:3866:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )
            int alt69=7;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // InternalRos1Parser.g:3867:3: this_ParameterString_0= ruleParameterString
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
                    // InternalRos1Parser.g:3876:3: this_ParameterBase64_1= ruleParameterBase64
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
                    // InternalRos1Parser.g:3885:3: this_ParameterInteger_2= ruleParameterInteger
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
                    // InternalRos1Parser.g:3894:3: this_ParameterDouble_3= ruleParameterDouble
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
                    // InternalRos1Parser.g:3903:3: this_ParameterBoolean_4= ruleParameterBoolean
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
                    // InternalRos1Parser.g:3912:3: this_ParameterList_5= ruleParameterList
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
                    // InternalRos1Parser.g:3921:3: this_ParameterStruct_6= ruleParameterStruct
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
    // InternalRos1Parser.g:3933:1: entryRuleParameterListType returns [EObject current=null] : iv_ruleParameterListType= ruleParameterListType EOF ;
    public final EObject entryRuleParameterListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterListType = null;


        try {
            // InternalRos1Parser.g:3933:58: (iv_ruleParameterListType= ruleParameterListType EOF )
            // InternalRos1Parser.g:3934:2: iv_ruleParameterListType= ruleParameterListType EOF
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
    // InternalRos1Parser.g:3940:1: ruleParameterListType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRos1Parser.g:3946:2: ( ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos1Parser.g:3947:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos1Parser.g:3947:2: ( () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos1Parser.g:3948:3: () otherlv_1= List otherlv_2= LeftSquareBracket ( (lv_sequence_3_0= ruleParameterType ) ) (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos1Parser.g:3948:3: ()
            // InternalRos1Parser.g:3949:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListTypeAccess().getParameterListTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,List,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListTypeAccess().getListKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_55); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterListTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos1Parser.g:3963:3: ( (lv_sequence_3_0= ruleParameterType ) )
            // InternalRos1Parser.g:3964:4: (lv_sequence_3_0= ruleParameterType )
            {
            // InternalRos1Parser.g:3964:4: (lv_sequence_3_0= ruleParameterType )
            // InternalRos1Parser.g:3965:5: lv_sequence_3_0= ruleParameterType
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

            // InternalRos1Parser.g:3982:3: (otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==Comma) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalRos1Parser.g:3983:4: otherlv_4= Comma ( (lv_sequence_5_0= ruleParameterType ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_55); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterListTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos1Parser.g:3987:4: ( (lv_sequence_5_0= ruleParameterType ) )
            	    // InternalRos1Parser.g:3988:5: (lv_sequence_5_0= ruleParameterType )
            	    {
            	    // InternalRos1Parser.g:3988:5: (lv_sequence_5_0= ruleParameterType )
            	    // InternalRos1Parser.g:3989:6: lv_sequence_5_0= ruleParameterType
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
            	    break loop70;
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
    // InternalRos1Parser.g:4015:1: entryRuleParameterStructType returns [EObject current=null] : iv_ruleParameterStructType= ruleParameterStructType EOF ;
    public final EObject entryRuleParameterStructType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructType = null;


        try {
            // InternalRos1Parser.g:4015:60: (iv_ruleParameterStructType= ruleParameterStructType EOF )
            // InternalRos1Parser.g:4016:2: iv_ruleParameterStructType= ruleParameterStructType EOF
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
    // InternalRos1Parser.g:4022:1: ruleParameterStructType returns [EObject current=null] : ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // InternalRos1Parser.g:4028:2: ( ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket ) )
            // InternalRos1Parser.g:4029:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            {
            // InternalRos1Parser.g:4029:2: ( () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket )
            // InternalRos1Parser.g:4030:3: () otherlv_1= Struct otherlv_2= LeftSquareBracket ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) ) (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )* otherlv_6= RightSquareBracket
            {
            // InternalRos1Parser.g:4030:3: ()
            // InternalRos1Parser.g:4031:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructTypeAccess().getParameterStructTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Struct,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructTypeAccess().getStructKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterStructTypeAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalRos1Parser.g:4045:3: ( (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember ) )
            // InternalRos1Parser.g:4046:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            {
            // InternalRos1Parser.g:4046:4: (lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember )
            // InternalRos1Parser.g:4047:5: lv_parameterstructypetmember_3_0= ruleParameterStructTypeMember
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

            // InternalRos1Parser.g:4064:3: (otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==Comma) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalRos1Parser.g:4065:4: otherlv_4= Comma ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    {
            	    otherlv_4=(Token)match(input,Comma,FOLLOW_6); 

            	    				newLeafNode(otherlv_4, grammarAccess.getParameterStructTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalRos1Parser.g:4069:4: ( (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember ) )
            	    // InternalRos1Parser.g:4070:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    {
            	    // InternalRos1Parser.g:4070:5: (lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember )
            	    // InternalRos1Parser.g:4071:6: lv_parameterstructypetmember_5_0= ruleParameterStructTypeMember
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
            	    break loop71;
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
    // InternalRos1Parser.g:4097:1: entryRuleParameterIntegerType returns [EObject current=null] : iv_ruleParameterIntegerType= ruleParameterIntegerType EOF ;
    public final EObject entryRuleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterIntegerType = null;


        try {
            // InternalRos1Parser.g:4097:61: (iv_ruleParameterIntegerType= ruleParameterIntegerType EOF )
            // InternalRos1Parser.g:4098:2: iv_ruleParameterIntegerType= ruleParameterIntegerType EOF
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
    // InternalRos1Parser.g:4104:1: ruleParameterIntegerType returns [EObject current=null] : ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) ;
    public final EObject ruleParameterIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4110:2: ( ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? ) )
            // InternalRos1Parser.g:4111:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            {
            // InternalRos1Parser.g:4111:2: ( () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )? )
            // InternalRos1Parser.g:4112:3: () otherlv_1= Integer (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            {
            // InternalRos1Parser.g:4112:3: ()
            // InternalRos1Parser.g:4113:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterIntegerTypeAccess().getParameterIntegerTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Integer,FOLLOW_58); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterIntegerTypeAccess().getIntegerKeyword_1());
            		
            // InternalRos1Parser.g:4123:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==Default) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalRos1Parser.g:4124:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterInteger ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_59); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterIntegerTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4128:4: ( (lv_default_3_0= ruleParameterInteger ) )
                    // InternalRos1Parser.g:4129:5: (lv_default_3_0= ruleParameterInteger )
                    {
                    // InternalRos1Parser.g:4129:5: (lv_default_3_0= ruleParameterInteger )
                    // InternalRos1Parser.g:4130:6: lv_default_3_0= ruleParameterInteger
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
    // InternalRos1Parser.g:4152:1: entryRuleParameterStringType returns [EObject current=null] : iv_ruleParameterStringType= ruleParameterStringType EOF ;
    public final EObject entryRuleParameterStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStringType = null;


        try {
            // InternalRos1Parser.g:4152:60: (iv_ruleParameterStringType= ruleParameterStringType EOF )
            // InternalRos1Parser.g:4153:2: iv_ruleParameterStringType= ruleParameterStringType EOF
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
    // InternalRos1Parser.g:4159:1: ruleParameterStringType returns [EObject current=null] : ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) ;
    public final EObject ruleParameterStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4165:2: ( ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? ) )
            // InternalRos1Parser.g:4166:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            {
            // InternalRos1Parser.g:4166:2: ( () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )? )
            // InternalRos1Parser.g:4167:3: () otherlv_1= String (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            {
            // InternalRos1Parser.g:4167:3: ()
            // InternalRos1Parser.g:4168:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStringTypeAccess().getParameterStringTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,String,FOLLOW_58); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStringTypeAccess().getStringKeyword_1());
            		
            // InternalRos1Parser.g:4178:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==Default) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalRos1Parser.g:4179:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterString ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterStringTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4183:4: ( (lv_default_3_0= ruleParameterString ) )
                    // InternalRos1Parser.g:4184:5: (lv_default_3_0= ruleParameterString )
                    {
                    // InternalRos1Parser.g:4184:5: (lv_default_3_0= ruleParameterString )
                    // InternalRos1Parser.g:4185:6: lv_default_3_0= ruleParameterString
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
    // InternalRos1Parser.g:4207:1: entryRuleParameterDoubleType returns [EObject current=null] : iv_ruleParameterDoubleType= ruleParameterDoubleType EOF ;
    public final EObject entryRuleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDoubleType = null;


        try {
            // InternalRos1Parser.g:4207:60: (iv_ruleParameterDoubleType= ruleParameterDoubleType EOF )
            // InternalRos1Parser.g:4208:2: iv_ruleParameterDoubleType= ruleParameterDoubleType EOF
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
    // InternalRos1Parser.g:4214:1: ruleParameterDoubleType returns [EObject current=null] : ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) ;
    public final EObject ruleParameterDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4220:2: ( ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? ) )
            // InternalRos1Parser.g:4221:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            {
            // InternalRos1Parser.g:4221:2: ( () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )? )
            // InternalRos1Parser.g:4222:3: () otherlv_1= Double (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            {
            // InternalRos1Parser.g:4222:3: ()
            // InternalRos1Parser.g:4223:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterDoubleTypeAccess().getParameterDoubleTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Double,FOLLOW_58); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterDoubleTypeAccess().getDoubleKeyword_1());
            		
            // InternalRos1Parser.g:4233:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==Default) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalRos1Parser.g:4234:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterDouble ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_60); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterDoubleTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4238:4: ( (lv_default_3_0= ruleParameterDouble ) )
                    // InternalRos1Parser.g:4239:5: (lv_default_3_0= ruleParameterDouble )
                    {
                    // InternalRos1Parser.g:4239:5: (lv_default_3_0= ruleParameterDouble )
                    // InternalRos1Parser.g:4240:6: lv_default_3_0= ruleParameterDouble
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
    // InternalRos1Parser.g:4262:1: entryRuleParameterBooleanType returns [EObject current=null] : iv_ruleParameterBooleanType= ruleParameterBooleanType EOF ;
    public final EObject entryRuleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBooleanType = null;


        try {
            // InternalRos1Parser.g:4262:61: (iv_ruleParameterBooleanType= ruleParameterBooleanType EOF )
            // InternalRos1Parser.g:4263:2: iv_ruleParameterBooleanType= ruleParameterBooleanType EOF
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
    // InternalRos1Parser.g:4269:1: ruleParameterBooleanType returns [EObject current=null] : ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) ;
    public final EObject ruleParameterBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4275:2: ( ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? ) )
            // InternalRos1Parser.g:4276:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            {
            // InternalRos1Parser.g:4276:2: ( () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )? )
            // InternalRos1Parser.g:4277:3: () otherlv_1= Boolean (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            {
            // InternalRos1Parser.g:4277:3: ()
            // InternalRos1Parser.g:4278:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBooleanTypeAccess().getParameterBooleanTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Boolean,FOLLOW_58); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBooleanTypeAccess().getBooleanKeyword_1());
            		
            // InternalRos1Parser.g:4288:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==Default) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalRos1Parser.g:4289:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBoolean ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_61); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBooleanTypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4293:4: ( (lv_default_3_0= ruleParameterBoolean ) )
                    // InternalRos1Parser.g:4294:5: (lv_default_3_0= ruleParameterBoolean )
                    {
                    // InternalRos1Parser.g:4294:5: (lv_default_3_0= ruleParameterBoolean )
                    // InternalRos1Parser.g:4295:6: lv_default_3_0= ruleParameterBoolean
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
    // InternalRos1Parser.g:4317:1: entryRuleParameterBase64Type returns [EObject current=null] : iv_ruleParameterBase64Type= ruleParameterBase64Type EOF ;
    public final EObject entryRuleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64Type = null;


        try {
            // InternalRos1Parser.g:4317:60: (iv_ruleParameterBase64Type= ruleParameterBase64Type EOF )
            // InternalRos1Parser.g:4318:2: iv_ruleParameterBase64Type= ruleParameterBase64Type EOF
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
    // InternalRos1Parser.g:4324:1: ruleParameterBase64Type returns [EObject current=null] : ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) ;
    public final EObject ruleParameterBase64Type() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_default_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4330:2: ( ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? ) )
            // InternalRos1Parser.g:4331:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            {
            // InternalRos1Parser.g:4331:2: ( () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )? )
            // InternalRos1Parser.g:4332:3: () otherlv_1= Base64 (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            {
            // InternalRos1Parser.g:4332:3: ()
            // InternalRos1Parser.g:4333:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterBase64TypeAccess().getParameterBase64TypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,Base64,FOLLOW_58); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterBase64TypeAccess().getBase64Keyword_1());
            		
            // InternalRos1Parser.g:4343:3: (otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==Default) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalRos1Parser.g:4344:4: otherlv_2= Default ( (lv_default_3_0= ruleParameterBase64 ) )
                    {
                    otherlv_2=(Token)match(input,Default,FOLLOW_62); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterBase64TypeAccess().getDefaultKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4348:4: ( (lv_default_3_0= ruleParameterBase64 ) )
                    // InternalRos1Parser.g:4349:5: (lv_default_3_0= ruleParameterBase64 )
                    {
                    // InternalRos1Parser.g:4349:5: (lv_default_3_0= ruleParameterBase64 )
                    // InternalRos1Parser.g:4350:6: lv_default_3_0= ruleParameterBase64
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
    // InternalRos1Parser.g:4372:1: entryRuleParameterArrayType returns [EObject current=null] : iv_ruleParameterArrayType= ruleParameterArrayType EOF ;
    public final EObject entryRuleParameterArrayType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterArrayType = null;


        try {
            // InternalRos1Parser.g:4372:59: (iv_ruleParameterArrayType= ruleParameterArrayType EOF )
            // InternalRos1Parser.g:4373:2: iv_ruleParameterArrayType= ruleParameterArrayType EOF
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
    // InternalRos1Parser.g:4379:1: ruleParameterArrayType returns [EObject current=null] : (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) ;
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
            // InternalRos1Parser.g:4385:2: ( (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? ) )
            // InternalRos1Parser.g:4386:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            {
            // InternalRos1Parser.g:4386:2: (otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )? )
            // InternalRos1Parser.g:4387:3: otherlv_0= Array otherlv_1= LeftSquareBracket ( (lv_type_2_0= ruleParameterType ) ) otherlv_3= RightSquareBracket (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            {
            otherlv_0=(Token)match(input,Array,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterArrayTypeAccess().getArrayKeyword_0());
            		
            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_55); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterArrayTypeAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:4395:3: ( (lv_type_2_0= ruleParameterType ) )
            // InternalRos1Parser.g:4396:4: (lv_type_2_0= ruleParameterType )
            {
            // InternalRos1Parser.g:4396:4: (lv_type_2_0= ruleParameterType )
            // InternalRos1Parser.g:4397:5: lv_type_2_0= ruleParameterType
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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_58); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterArrayTypeAccess().getRightSquareBracketKeyword_3());
            		
            // InternalRos1Parser.g:4418:3: (otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==Default) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalRos1Parser.g:4419:4: otherlv_4= Default ( (lv_default_5_0= ruleParameterList ) )
                    {
                    otherlv_4=(Token)match(input,Default,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getParameterArrayTypeAccess().getDefaultKeyword_4_0());
                    			
                    // InternalRos1Parser.g:4423:4: ( (lv_default_5_0= ruleParameterList ) )
                    // InternalRos1Parser.g:4424:5: (lv_default_5_0= ruleParameterList )
                    {
                    // InternalRos1Parser.g:4424:5: (lv_default_5_0= ruleParameterList )
                    // InternalRos1Parser.g:4425:6: lv_default_5_0= ruleParameterList
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
    // InternalRos1Parser.g:4447:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalRos1Parser.g:4447:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalRos1Parser.g:4448:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalRos1Parser.g:4454:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4460:2: ( ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket ) )
            // InternalRos1Parser.g:4461:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            {
            // InternalRos1Parser.g:4461:2: ( () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket )
            // InternalRos1Parser.g:4462:3: () otherlv_1= LeftSquareBracket ( (lv_value_2_0= ruleParameterValue ) ) (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )* otherlv_5= RightSquareBracket
            {
            // InternalRos1Parser.g:4462:3: ()
            // InternalRos1Parser.g:4463:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterListAccess().getParameterSequenceAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_57); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:4473:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRos1Parser.g:4474:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRos1Parser.g:4474:4: (lv_value_2_0= ruleParameterValue )
            // InternalRos1Parser.g:4475:5: lv_value_2_0= ruleParameterValue
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

            // InternalRos1Parser.g:4492:3: (otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==Comma) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalRos1Parser.g:4493:4: otherlv_3= Comma ( (lv_value_4_0= ruleParameterValue ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_57); 

            	    				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalRos1Parser.g:4497:4: ( (lv_value_4_0= ruleParameterValue ) )
            	    // InternalRos1Parser.g:4498:5: (lv_value_4_0= ruleParameterValue )
            	    {
            	    // InternalRos1Parser.g:4498:5: (lv_value_4_0= ruleParameterValue )
            	    // InternalRos1Parser.g:4499:6: lv_value_4_0= ruleParameterValue
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
            	    break loop78;
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
    // InternalRos1Parser.g:4525:1: entryRuleParameterAny returns [EObject current=null] : iv_ruleParameterAny= ruleParameterAny EOF ;
    public final EObject entryRuleParameterAny() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterAny = null;


        try {
            // InternalRos1Parser.g:4525:53: (iv_ruleParameterAny= ruleParameterAny EOF )
            // InternalRos1Parser.g:4526:2: iv_ruleParameterAny= ruleParameterAny EOF
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
    // InternalRos1Parser.g:4532:1: ruleParameterAny returns [EObject current=null] : ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleParameterAny() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4538:2: ( ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? ) )
            // InternalRos1Parser.g:4539:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            {
            // InternalRos1Parser.g:4539:2: ( () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )? )
            // InternalRos1Parser.g:4540:3: () otherlv_1= ParameterAny (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            {
            // InternalRos1Parser.g:4540:3: ()
            // InternalRos1Parser.g:4541:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterAnyAccess().getParameterAnyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ParameterAny,FOLLOW_64); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAnyAccess().getParameterAnyKeyword_1());
            		
            // InternalRos1Parser.g:4551:3: (otherlv_2= Value ( (lv_value_3_0= ruleEString ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==Value) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalRos1Parser.g:4552:4: otherlv_2= Value ( (lv_value_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,Value,FOLLOW_6); 

                    				newLeafNode(otherlv_2, grammarAccess.getParameterAnyAccess().getValueKeyword_2_0());
                    			
                    // InternalRos1Parser.g:4556:4: ( (lv_value_3_0= ruleEString ) )
                    // InternalRos1Parser.g:4557:5: (lv_value_3_0= ruleEString )
                    {
                    // InternalRos1Parser.g:4557:5: (lv_value_3_0= ruleEString )
                    // InternalRos1Parser.g:4558:6: lv_value_3_0= ruleEString
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
    // InternalRos1Parser.g:4580:1: entryRuleParameterString returns [EObject current=null] : iv_ruleParameterString= ruleParameterString EOF ;
    public final EObject entryRuleParameterString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterString = null;


        try {
            // InternalRos1Parser.g:4580:56: (iv_ruleParameterString= ruleParameterString EOF )
            // InternalRos1Parser.g:4581:2: iv_ruleParameterString= ruleParameterString EOF
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
    // InternalRos1Parser.g:4587:1: ruleParameterString returns [EObject current=null] : ( (lv_value_0_0= ruleEString ) ) ;
    public final EObject ruleParameterString() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4593:2: ( ( (lv_value_0_0= ruleEString ) ) )
            // InternalRos1Parser.g:4594:2: ( (lv_value_0_0= ruleEString ) )
            {
            // InternalRos1Parser.g:4594:2: ( (lv_value_0_0= ruleEString ) )
            // InternalRos1Parser.g:4595:3: (lv_value_0_0= ruleEString )
            {
            // InternalRos1Parser.g:4595:3: (lv_value_0_0= ruleEString )
            // InternalRos1Parser.g:4596:4: lv_value_0_0= ruleEString
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
    // InternalRos1Parser.g:4616:1: entryRuleParameterBase64 returns [EObject current=null] : iv_ruleParameterBase64= ruleParameterBase64 EOF ;
    public final EObject entryRuleParameterBase64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBase64 = null;


        try {
            // InternalRos1Parser.g:4616:56: (iv_ruleParameterBase64= ruleParameterBase64 EOF )
            // InternalRos1Parser.g:4617:2: iv_ruleParameterBase64= ruleParameterBase64 EOF
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
    // InternalRos1Parser.g:4623:1: ruleParameterBase64 returns [EObject current=null] : ( (lv_value_0_0= ruleBase64Binary ) ) ;
    public final EObject ruleParameterBase64() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4629:2: ( ( (lv_value_0_0= ruleBase64Binary ) ) )
            // InternalRos1Parser.g:4630:2: ( (lv_value_0_0= ruleBase64Binary ) )
            {
            // InternalRos1Parser.g:4630:2: ( (lv_value_0_0= ruleBase64Binary ) )
            // InternalRos1Parser.g:4631:3: (lv_value_0_0= ruleBase64Binary )
            {
            // InternalRos1Parser.g:4631:3: (lv_value_0_0= ruleBase64Binary )
            // InternalRos1Parser.g:4632:4: lv_value_0_0= ruleBase64Binary
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
    // InternalRos1Parser.g:4652:1: entryRuleParameterInteger returns [EObject current=null] : iv_ruleParameterInteger= ruleParameterInteger EOF ;
    public final EObject entryRuleParameterInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterInteger = null;


        try {
            // InternalRos1Parser.g:4652:57: (iv_ruleParameterInteger= ruleParameterInteger EOF )
            // InternalRos1Parser.g:4653:2: iv_ruleParameterInteger= ruleParameterInteger EOF
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
    // InternalRos1Parser.g:4659:1: ruleParameterInteger returns [EObject current=null] : ( (lv_value_0_0= ruleInteger0 ) ) ;
    public final EObject ruleParameterInteger() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4665:2: ( ( (lv_value_0_0= ruleInteger0 ) ) )
            // InternalRos1Parser.g:4666:2: ( (lv_value_0_0= ruleInteger0 ) )
            {
            // InternalRos1Parser.g:4666:2: ( (lv_value_0_0= ruleInteger0 ) )
            // InternalRos1Parser.g:4667:3: (lv_value_0_0= ruleInteger0 )
            {
            // InternalRos1Parser.g:4667:3: (lv_value_0_0= ruleInteger0 )
            // InternalRos1Parser.g:4668:4: lv_value_0_0= ruleInteger0
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
    // InternalRos1Parser.g:4688:1: entryRuleParameterDouble returns [EObject current=null] : iv_ruleParameterDouble= ruleParameterDouble EOF ;
    public final EObject entryRuleParameterDouble() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDouble = null;


        try {
            // InternalRos1Parser.g:4688:56: (iv_ruleParameterDouble= ruleParameterDouble EOF )
            // InternalRos1Parser.g:4689:2: iv_ruleParameterDouble= ruleParameterDouble EOF
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
    // InternalRos1Parser.g:4695:1: ruleParameterDouble returns [EObject current=null] : ( (lv_value_0_0= ruleDouble0 ) ) ;
    public final EObject ruleParameterDouble() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4701:2: ( ( (lv_value_0_0= ruleDouble0 ) ) )
            // InternalRos1Parser.g:4702:2: ( (lv_value_0_0= ruleDouble0 ) )
            {
            // InternalRos1Parser.g:4702:2: ( (lv_value_0_0= ruleDouble0 ) )
            // InternalRos1Parser.g:4703:3: (lv_value_0_0= ruleDouble0 )
            {
            // InternalRos1Parser.g:4703:3: (lv_value_0_0= ruleDouble0 )
            // InternalRos1Parser.g:4704:4: lv_value_0_0= ruleDouble0
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
    // InternalRos1Parser.g:4724:1: entryRuleParameterBoolean returns [EObject current=null] : iv_ruleParameterBoolean= ruleParameterBoolean EOF ;
    public final EObject entryRuleParameterBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterBoolean = null;


        try {
            // InternalRos1Parser.g:4724:57: (iv_ruleParameterBoolean= ruleParameterBoolean EOF )
            // InternalRos1Parser.g:4725:2: iv_ruleParameterBoolean= ruleParameterBoolean EOF
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
    // InternalRos1Parser.g:4731:1: ruleParameterBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleboolean0 ) ) ;
    public final EObject ruleParameterBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4737:2: ( ( (lv_value_0_0= ruleboolean0 ) ) )
            // InternalRos1Parser.g:4738:2: ( (lv_value_0_0= ruleboolean0 ) )
            {
            // InternalRos1Parser.g:4738:2: ( (lv_value_0_0= ruleboolean0 ) )
            // InternalRos1Parser.g:4739:3: (lv_value_0_0= ruleboolean0 )
            {
            // InternalRos1Parser.g:4739:3: (lv_value_0_0= ruleboolean0 )
            // InternalRos1Parser.g:4740:4: lv_value_0_0= ruleboolean0
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
    // InternalRos1Parser.g:4760:1: entryRuleParameterStruct returns [EObject current=null] : iv_ruleParameterStruct= ruleParameterStruct EOF ;
    public final EObject entryRuleParameterStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStruct = null;


        try {
            // InternalRos1Parser.g:4760:56: (iv_ruleParameterStruct= ruleParameterStruct EOF )
            // InternalRos1Parser.g:4761:2: iv_ruleParameterStruct= ruleParameterStruct EOF
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
    // InternalRos1Parser.g:4767:1: ruleParameterStruct returns [EObject current=null] : ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) ;
    public final EObject ruleParameterStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_BEGIN_2=null;
        Token otherlv_4=null;
        Token this_END_5=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4773:2: ( ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? ) )
            // InternalRos1Parser.g:4774:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            {
            // InternalRos1Parser.g:4774:2: ( () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )? )
            // InternalRos1Parser.g:4775:3: () (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            {
            // InternalRos1Parser.g:4775:3: ()
            // InternalRos1Parser.g:4776:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getParameterStructAccess().getParameterStructAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:4782:3: (otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==LeftSquareBracket) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalRos1Parser.g:4783:4: otherlv_1= LeftSquareBracket this_BEGIN_2= RULE_BEGIN ( (lv_value_3_0= ruleParameterStructMember ) )* otherlv_4= RightSquareBracket this_END_5= RULE_END
                    {
                    otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getParameterStructAccess().getLeftSquareBracketKeyword_1_0());
                    			
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FOLLOW_65); 

                    				newLeafNode(this_BEGIN_2, grammarAccess.getParameterStructAccess().getBEGINTerminalRuleCall_1_1());
                    			
                    // InternalRos1Parser.g:4791:4: ( (lv_value_3_0= ruleParameterStructMember ) )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==Pluginlib||LA80_0==External||LA80_0==Library||LA80_0==Class||(LA80_0>=RULE_ID && LA80_0<=RULE_STRING)) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // InternalRos1Parser.g:4792:5: (lv_value_3_0= ruleParameterStructMember )
                    	    {
                    	    // InternalRos1Parser.g:4792:5: (lv_value_3_0= ruleParameterStructMember )
                    	    // InternalRos1Parser.g:4793:6: lv_value_3_0= ruleParameterStructMember
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
                    	    break loop80;
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
    // InternalRos1Parser.g:4823:1: entryRuleParameterDate returns [EObject current=null] : iv_ruleParameterDate= ruleParameterDate EOF ;
    public final EObject entryRuleParameterDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDate = null;


        try {
            // InternalRos1Parser.g:4823:54: (iv_ruleParameterDate= ruleParameterDate EOF )
            // InternalRos1Parser.g:4824:2: iv_ruleParameterDate= ruleParameterDate EOF
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
    // InternalRos1Parser.g:4830:1: ruleParameterDate returns [EObject current=null] : ( (lv_value_0_0= ruleDateTime0 ) ) ;
    public final EObject ruleParameterDate() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4836:2: ( ( (lv_value_0_0= ruleDateTime0 ) ) )
            // InternalRos1Parser.g:4837:2: ( (lv_value_0_0= ruleDateTime0 ) )
            {
            // InternalRos1Parser.g:4837:2: ( (lv_value_0_0= ruleDateTime0 ) )
            // InternalRos1Parser.g:4838:3: (lv_value_0_0= ruleDateTime0 )
            {
            // InternalRos1Parser.g:4838:3: (lv_value_0_0= ruleDateTime0 )
            // InternalRos1Parser.g:4839:4: lv_value_0_0= ruleDateTime0
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
    // InternalRos1Parser.g:4859:1: entryRuleParameterStructMember returns [EObject current=null] : iv_ruleParameterStructMember= ruleParameterStructMember EOF ;
    public final EObject entryRuleParameterStructMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructMember = null;


        try {
            // InternalRos1Parser.g:4859:62: (iv_ruleParameterStructMember= ruleParameterStructMember EOF )
            // InternalRos1Parser.g:4860:2: iv_ruleParameterStructMember= ruleParameterStructMember EOF
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
    // InternalRos1Parser.g:4866:1: ruleParameterStructMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) ;
    public final EObject ruleParameterStructMember() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4872:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) ) )
            // InternalRos1Parser.g:4873:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            {
            // InternalRos1Parser.g:4873:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) ) )
            // InternalRos1Parser.g:4874:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= Colon ( (lv_value_2_0= ruleParameterValue ) )
            {
            // InternalRos1Parser.g:4874:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRos1Parser.g:4875:4: (lv_name_0_0= ruleEString )
            {
            // InternalRos1Parser.g:4875:4: (lv_name_0_0= ruleEString )
            // InternalRos1Parser.g:4876:5: lv_name_0_0= ruleEString
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

            otherlv_1=(Token)match(input,Colon,FOLLOW_57); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterStructMemberAccess().getColonKeyword_1());
            		
            // InternalRos1Parser.g:4897:3: ( (lv_value_2_0= ruleParameterValue ) )
            // InternalRos1Parser.g:4898:4: (lv_value_2_0= ruleParameterValue )
            {
            // InternalRos1Parser.g:4898:4: (lv_value_2_0= ruleParameterValue )
            // InternalRos1Parser.g:4899:5: lv_value_2_0= ruleParameterValue
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
    // InternalRos1Parser.g:4920:1: entryRuleParameterStructTypeMember returns [EObject current=null] : iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF ;
    public final EObject entryRuleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterStructTypeMember = null;


        try {
            // InternalRos1Parser.g:4920:66: (iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF )
            // InternalRos1Parser.g:4921:2: iv_ruleParameterStructTypeMember= ruleParameterStructTypeMember EOF
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
    // InternalRos1Parser.g:4927:1: ruleParameterStructTypeMember returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) ;
    public final EObject ruleParameterStructTypeMember() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:4933:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) ) )
            // InternalRos1Parser.g:4934:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            {
            // InternalRos1Parser.g:4934:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) ) )
            // InternalRos1Parser.g:4935:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_type_1_0= ruleParameterType ) )
            {
            // InternalRos1Parser.g:4935:3: ( (lv_name_0_0= ruleEString ) )
            // InternalRos1Parser.g:4936:4: (lv_name_0_0= ruleEString )
            {
            // InternalRos1Parser.g:4936:4: (lv_name_0_0= ruleEString )
            // InternalRos1Parser.g:4937:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterStructTypeMemberAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_55);
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

            // InternalRos1Parser.g:4954:3: ( (lv_type_1_0= ruleParameterType ) )
            // InternalRos1Parser.g:4955:4: (lv_type_1_0= ruleParameterType )
            {
            // InternalRos1Parser.g:4955:4: (lv_type_1_0= ruleParameterType )
            // InternalRos1Parser.g:4956:5: lv_type_1_0= ruleParameterType
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
    // InternalRos1Parser.g:4977:1: entryRuleBase64Binary returns [String current=null] : iv_ruleBase64Binary= ruleBase64Binary EOF ;
    public final String entryRuleBase64Binary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBase64Binary = null;


        try {
            // InternalRos1Parser.g:4977:52: (iv_ruleBase64Binary= ruleBase64Binary EOF )
            // InternalRos1Parser.g:4978:2: iv_ruleBase64Binary= ruleBase64Binary EOF
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
    // InternalRos1Parser.g:4984:1: ruleBase64Binary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BINARY_0= RULE_BINARY ;
    public final AntlrDatatypeRuleToken ruleBase64Binary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BINARY_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:4990:2: (this_BINARY_0= RULE_BINARY )
            // InternalRos1Parser.g:4991:2: this_BINARY_0= RULE_BINARY
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
    // InternalRos1Parser.g:5001:1: entryRuleboolean0 returns [String current=null] : iv_ruleboolean0= ruleboolean0 EOF ;
    public final String entryRuleboolean0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleboolean0 = null;


        try {
            // InternalRos1Parser.g:5001:48: (iv_ruleboolean0= ruleboolean0 EOF )
            // InternalRos1Parser.g:5002:2: iv_ruleboolean0= ruleboolean0 EOF
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
    // InternalRos1Parser.g:5008:1: ruleboolean0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_BOOLEAN_0= RULE_BOOLEAN ;
    public final AntlrDatatypeRuleToken ruleboolean0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5014:2: (this_BOOLEAN_0= RULE_BOOLEAN )
            // InternalRos1Parser.g:5015:2: this_BOOLEAN_0= RULE_BOOLEAN
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
    // InternalRos1Parser.g:5025:1: entryRuleDouble0 returns [String current=null] : iv_ruleDouble0= ruleDouble0 EOF ;
    public final String entryRuleDouble0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDouble0 = null;


        try {
            // InternalRos1Parser.g:5025:47: (iv_ruleDouble0= ruleDouble0 EOF )
            // InternalRos1Parser.g:5026:2: iv_ruleDouble0= ruleDouble0 EOF
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
    // InternalRos1Parser.g:5032:1: ruleDouble0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DOUBLE_0= RULE_DOUBLE ;
    public final AntlrDatatypeRuleToken ruleDouble0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DOUBLE_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5038:2: (this_DOUBLE_0= RULE_DOUBLE )
            // InternalRos1Parser.g:5039:2: this_DOUBLE_0= RULE_DOUBLE
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
    // InternalRos1Parser.g:5049:1: entryRuleInteger0 returns [String current=null] : iv_ruleInteger0= ruleInteger0 EOF ;
    public final String entryRuleInteger0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInteger0 = null;


        try {
            // InternalRos1Parser.g:5049:48: (iv_ruleInteger0= ruleInteger0 EOF )
            // InternalRos1Parser.g:5050:2: iv_ruleInteger0= ruleInteger0 EOF
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
    // InternalRos1Parser.g:5056:1: ruleInteger0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECINT_0= RULE_DECINT ;
    public final AntlrDatatypeRuleToken ruleInteger0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECINT_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5062:2: (this_DECINT_0= RULE_DECINT )
            // InternalRos1Parser.g:5063:2: this_DECINT_0= RULE_DECINT
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
    // InternalRos1Parser.g:5073:1: entryRuleDateTime0 returns [String current=null] : iv_ruleDateTime0= ruleDateTime0 EOF ;
    public final String entryRuleDateTime0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDateTime0 = null;


        try {
            // InternalRos1Parser.g:5073:49: (iv_ruleDateTime0= ruleDateTime0 EOF )
            // InternalRos1Parser.g:5074:2: iv_ruleDateTime0= ruleDateTime0 EOF
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
    // InternalRos1Parser.g:5080:1: ruleDateTime0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DATE_TIME_0= RULE_DATE_TIME ;
    public final AntlrDatatypeRuleToken ruleDateTime0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DATE_TIME_0=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5086:2: (this_DATE_TIME_0= RULE_DATE_TIME )
            // InternalRos1Parser.g:5087:2: this_DATE_TIME_0= RULE_DATE_TIME
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
    // InternalRos1Parser.g:5097:1: entryRuleMessagePart returns [EObject current=null] : iv_ruleMessagePart= ruleMessagePart EOF ;
    public final EObject entryRuleMessagePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePart = null;


        try {
            // InternalRos1Parser.g:5097:52: (iv_ruleMessagePart= ruleMessagePart EOF )
            // InternalRos1Parser.g:5098:2: iv_ruleMessagePart= ruleMessagePart EOF
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
    // InternalRos1Parser.g:5104:1: ruleMessagePart returns [EObject current=null] : ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) ;
    public final EObject ruleMessagePart() throws RecognitionException {
        EObject current = null;

        Token lv_Data_1_2=null;
        EObject lv_Type_0_0 = null;

        AntlrDatatypeRuleToken lv_Data_1_1 = null;

        AntlrDatatypeRuleToken lv_Data_1_3 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:5110:2: ( ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) ) )
            // InternalRos1Parser.g:5111:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            {
            // InternalRos1Parser.g:5111:2: ( ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) ) )
            // InternalRos1Parser.g:5112:3: ( (lv_Type_0_0= ruleAbstractType ) ) ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            {
            // InternalRos1Parser.g:5112:3: ( (lv_Type_0_0= ruleAbstractType ) )
            // InternalRos1Parser.g:5113:4: (lv_Type_0_0= ruleAbstractType )
            {
            // InternalRos1Parser.g:5113:4: (lv_Type_0_0= ruleAbstractType )
            // InternalRos1Parser.g:5114:5: lv_Type_0_0= ruleAbstractType
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

            // InternalRos1Parser.g:5131:3: ( ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) ) )
            // InternalRos1Parser.g:5132:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            {
            // InternalRos1Parser.g:5132:4: ( (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString ) )
            // InternalRos1Parser.g:5133:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            {
            // InternalRos1Parser.g:5133:5: (lv_Data_1_1= ruleKEYWORD | lv_Data_1_2= RULE_MESSAGE_ASIGMENT | lv_Data_1_3= ruleEString )
            int alt82=3;
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
                alt82=1;
                }
                break;
            case RULE_MESSAGE_ASIGMENT:
                {
                alt82=2;
                }
                break;
            case Pluginlib:
            case External:
            case Library:
            case Class:
            case RULE_ID:
            case RULE_STRING:
                {
                alt82=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalRos1Parser.g:5134:6: lv_Data_1_1= ruleKEYWORD
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
                    // InternalRos1Parser.g:5150:6: lv_Data_1_2= RULE_MESSAGE_ASIGMENT
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
                    // InternalRos1Parser.g:5165:6: lv_Data_1_3= ruleEString
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
    // InternalRos1Parser.g:5187:1: entryRuleAbstractType returns [EObject current=null] : iv_ruleAbstractType= ruleAbstractType EOF ;
    public final EObject entryRuleAbstractType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractType = null;


        try {
            // InternalRos1Parser.g:5187:53: (iv_ruleAbstractType= ruleAbstractType EOF )
            // InternalRos1Parser.g:5188:2: iv_ruleAbstractType= ruleAbstractType EOF
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
    // InternalRos1Parser.g:5194:1: ruleAbstractType returns [EObject current=null] : (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) ;
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
            // InternalRos1Parser.g:5200:2: ( (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray ) )
            // InternalRos1Parser.g:5201:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            {
            // InternalRos1Parser.g:5201:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )
            int alt83=33;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // InternalRos1Parser.g:5202:3: this_bool_0= rulebool
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
                    // InternalRos1Parser.g:5211:3: this_int8_1= ruleint8
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
                    // InternalRos1Parser.g:5220:3: this_uint8_2= ruleuint8
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
                    // InternalRos1Parser.g:5229:3: this_int16_3= ruleint16
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
                    // InternalRos1Parser.g:5238:3: this_uint16_4= ruleuint16
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
                    // InternalRos1Parser.g:5247:3: this_int32_5= ruleint32
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
                    // InternalRos1Parser.g:5256:3: this_uint32_6= ruleuint32
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
                    // InternalRos1Parser.g:5265:3: this_int64_7= ruleint64
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
                    // InternalRos1Parser.g:5274:3: this_uint64_8= ruleuint64
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
                    // InternalRos1Parser.g:5283:3: this_float32_9= rulefloat32
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
                    // InternalRos1Parser.g:5292:3: this_float64_10= rulefloat64
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
                    // InternalRos1Parser.g:5301:3: this_string0_11= rulestring0
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
                    // InternalRos1Parser.g:5310:3: this_byte_12= rulebyte
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
                    // InternalRos1Parser.g:5319:3: this_time_13= ruletime
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
                    // InternalRos1Parser.g:5328:3: this_duration_14= ruleduration
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
                    // InternalRos1Parser.g:5337:3: this_Header_15= ruleHeader
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
                    // InternalRos1Parser.g:5346:3: this_boolArray_16= ruleboolArray
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
                    // InternalRos1Parser.g:5355:3: this_int8Array_17= ruleint8Array
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
                    // InternalRos1Parser.g:5364:3: this_uint8Array_18= ruleuint8Array
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
                    // InternalRos1Parser.g:5373:3: this_int16Array_19= ruleint16Array
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
                    // InternalRos1Parser.g:5382:3: this_uint16Array_20= ruleuint16Array
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
                    // InternalRos1Parser.g:5391:3: this_int32Array_21= ruleint32Array
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
                    // InternalRos1Parser.g:5400:3: this_uint32Array_22= ruleuint32Array
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
                    // InternalRos1Parser.g:5409:3: this_int64Array_23= ruleint64Array
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
                    // InternalRos1Parser.g:5418:3: this_uint64Array_24= ruleuint64Array
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
                    // InternalRos1Parser.g:5427:3: this_float32Array_25= rulefloat32Array
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
                    // InternalRos1Parser.g:5436:3: this_float64Array_26= rulefloat64Array
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
                    // InternalRos1Parser.g:5445:3: this_string0Array_27= rulestring0Array
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
                    // InternalRos1Parser.g:5454:3: this_byteArray_28= rulebyteArray
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
                    // InternalRos1Parser.g:5463:3: this_SpecBaseRef_29= ruleSpecBaseRef
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
                    // InternalRos1Parser.g:5472:3: this_ArraySpecRef_30= ruleArraySpecRef
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
                    // InternalRos1Parser.g:5481:3: this_char_31= rulechar
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
                    // InternalRos1Parser.g:5490:3: this_charArray_32= rulecharArray
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
    // InternalRos1Parser.g:5502:1: entryRulebool returns [EObject current=null] : iv_rulebool= rulebool EOF ;
    public final EObject entryRulebool() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebool = null;


        try {
            // InternalRos1Parser.g:5502:45: (iv_rulebool= rulebool EOF )
            // InternalRos1Parser.g:5503:2: iv_rulebool= rulebool EOF
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
    // InternalRos1Parser.g:5509:1: rulebool returns [EObject current=null] : ( () otherlv_1= Bool ) ;
    public final EObject rulebool() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5515:2: ( ( () otherlv_1= Bool ) )
            // InternalRos1Parser.g:5516:2: ( () otherlv_1= Bool )
            {
            // InternalRos1Parser.g:5516:2: ( () otherlv_1= Bool )
            // InternalRos1Parser.g:5517:3: () otherlv_1= Bool
            {
            // InternalRos1Parser.g:5517:3: ()
            // InternalRos1Parser.g:5518:4: 
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
    // InternalRos1Parser.g:5532:1: entryRuleint8 returns [EObject current=null] : iv_ruleint8= ruleint8 EOF ;
    public final EObject entryRuleint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8 = null;


        try {
            // InternalRos1Parser.g:5532:45: (iv_ruleint8= ruleint8 EOF )
            // InternalRos1Parser.g:5533:2: iv_ruleint8= ruleint8 EOF
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
    // InternalRos1Parser.g:5539:1: ruleint8 returns [EObject current=null] : ( () otherlv_1= Int8 ) ;
    public final EObject ruleint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5545:2: ( ( () otherlv_1= Int8 ) )
            // InternalRos1Parser.g:5546:2: ( () otherlv_1= Int8 )
            {
            // InternalRos1Parser.g:5546:2: ( () otherlv_1= Int8 )
            // InternalRos1Parser.g:5547:3: () otherlv_1= Int8
            {
            // InternalRos1Parser.g:5547:3: ()
            // InternalRos1Parser.g:5548:4: 
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
    // InternalRos1Parser.g:5562:1: entryRuleuint8 returns [EObject current=null] : iv_ruleuint8= ruleuint8 EOF ;
    public final EObject entryRuleuint8() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8 = null;


        try {
            // InternalRos1Parser.g:5562:46: (iv_ruleuint8= ruleuint8 EOF )
            // InternalRos1Parser.g:5563:2: iv_ruleuint8= ruleuint8 EOF
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
    // InternalRos1Parser.g:5569:1: ruleuint8 returns [EObject current=null] : ( () otherlv_1= Uint8 ) ;
    public final EObject ruleuint8() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5575:2: ( ( () otherlv_1= Uint8 ) )
            // InternalRos1Parser.g:5576:2: ( () otherlv_1= Uint8 )
            {
            // InternalRos1Parser.g:5576:2: ( () otherlv_1= Uint8 )
            // InternalRos1Parser.g:5577:3: () otherlv_1= Uint8
            {
            // InternalRos1Parser.g:5577:3: ()
            // InternalRos1Parser.g:5578:4: 
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
    // InternalRos1Parser.g:5592:1: entryRuleint16 returns [EObject current=null] : iv_ruleint16= ruleint16 EOF ;
    public final EObject entryRuleint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16 = null;


        try {
            // InternalRos1Parser.g:5592:46: (iv_ruleint16= ruleint16 EOF )
            // InternalRos1Parser.g:5593:2: iv_ruleint16= ruleint16 EOF
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
    // InternalRos1Parser.g:5599:1: ruleint16 returns [EObject current=null] : ( () otherlv_1= Int16 ) ;
    public final EObject ruleint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5605:2: ( ( () otherlv_1= Int16 ) )
            // InternalRos1Parser.g:5606:2: ( () otherlv_1= Int16 )
            {
            // InternalRos1Parser.g:5606:2: ( () otherlv_1= Int16 )
            // InternalRos1Parser.g:5607:3: () otherlv_1= Int16
            {
            // InternalRos1Parser.g:5607:3: ()
            // InternalRos1Parser.g:5608:4: 
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
    // InternalRos1Parser.g:5622:1: entryRuleuint16 returns [EObject current=null] : iv_ruleuint16= ruleuint16 EOF ;
    public final EObject entryRuleuint16() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16 = null;


        try {
            // InternalRos1Parser.g:5622:47: (iv_ruleuint16= ruleuint16 EOF )
            // InternalRos1Parser.g:5623:2: iv_ruleuint16= ruleuint16 EOF
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
    // InternalRos1Parser.g:5629:1: ruleuint16 returns [EObject current=null] : ( () otherlv_1= Uint16 ) ;
    public final EObject ruleuint16() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5635:2: ( ( () otherlv_1= Uint16 ) )
            // InternalRos1Parser.g:5636:2: ( () otherlv_1= Uint16 )
            {
            // InternalRos1Parser.g:5636:2: ( () otherlv_1= Uint16 )
            // InternalRos1Parser.g:5637:3: () otherlv_1= Uint16
            {
            // InternalRos1Parser.g:5637:3: ()
            // InternalRos1Parser.g:5638:4: 
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
    // InternalRos1Parser.g:5652:1: entryRuleint32 returns [EObject current=null] : iv_ruleint32= ruleint32 EOF ;
    public final EObject entryRuleint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32 = null;


        try {
            // InternalRos1Parser.g:5652:46: (iv_ruleint32= ruleint32 EOF )
            // InternalRos1Parser.g:5653:2: iv_ruleint32= ruleint32 EOF
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
    // InternalRos1Parser.g:5659:1: ruleint32 returns [EObject current=null] : ( () otherlv_1= Int32 ) ;
    public final EObject ruleint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5665:2: ( ( () otherlv_1= Int32 ) )
            // InternalRos1Parser.g:5666:2: ( () otherlv_1= Int32 )
            {
            // InternalRos1Parser.g:5666:2: ( () otherlv_1= Int32 )
            // InternalRos1Parser.g:5667:3: () otherlv_1= Int32
            {
            // InternalRos1Parser.g:5667:3: ()
            // InternalRos1Parser.g:5668:4: 
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
    // InternalRos1Parser.g:5682:1: entryRuleuint32 returns [EObject current=null] : iv_ruleuint32= ruleuint32 EOF ;
    public final EObject entryRuleuint32() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32 = null;


        try {
            // InternalRos1Parser.g:5682:47: (iv_ruleuint32= ruleuint32 EOF )
            // InternalRos1Parser.g:5683:2: iv_ruleuint32= ruleuint32 EOF
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
    // InternalRos1Parser.g:5689:1: ruleuint32 returns [EObject current=null] : ( () otherlv_1= Uint32 ) ;
    public final EObject ruleuint32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5695:2: ( ( () otherlv_1= Uint32 ) )
            // InternalRos1Parser.g:5696:2: ( () otherlv_1= Uint32 )
            {
            // InternalRos1Parser.g:5696:2: ( () otherlv_1= Uint32 )
            // InternalRos1Parser.g:5697:3: () otherlv_1= Uint32
            {
            // InternalRos1Parser.g:5697:3: ()
            // InternalRos1Parser.g:5698:4: 
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
    // InternalRos1Parser.g:5712:1: entryRuleint64 returns [EObject current=null] : iv_ruleint64= ruleint64 EOF ;
    public final EObject entryRuleint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64 = null;


        try {
            // InternalRos1Parser.g:5712:46: (iv_ruleint64= ruleint64 EOF )
            // InternalRos1Parser.g:5713:2: iv_ruleint64= ruleint64 EOF
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
    // InternalRos1Parser.g:5719:1: ruleint64 returns [EObject current=null] : ( () otherlv_1= Int64 ) ;
    public final EObject ruleint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5725:2: ( ( () otherlv_1= Int64 ) )
            // InternalRos1Parser.g:5726:2: ( () otherlv_1= Int64 )
            {
            // InternalRos1Parser.g:5726:2: ( () otherlv_1= Int64 )
            // InternalRos1Parser.g:5727:3: () otherlv_1= Int64
            {
            // InternalRos1Parser.g:5727:3: ()
            // InternalRos1Parser.g:5728:4: 
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
    // InternalRos1Parser.g:5742:1: entryRuleuint64 returns [EObject current=null] : iv_ruleuint64= ruleuint64 EOF ;
    public final EObject entryRuleuint64() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64 = null;


        try {
            // InternalRos1Parser.g:5742:47: (iv_ruleuint64= ruleuint64 EOF )
            // InternalRos1Parser.g:5743:2: iv_ruleuint64= ruleuint64 EOF
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
    // InternalRos1Parser.g:5749:1: ruleuint64 returns [EObject current=null] : ( () otherlv_1= Uint64 ) ;
    public final EObject ruleuint64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5755:2: ( ( () otherlv_1= Uint64 ) )
            // InternalRos1Parser.g:5756:2: ( () otherlv_1= Uint64 )
            {
            // InternalRos1Parser.g:5756:2: ( () otherlv_1= Uint64 )
            // InternalRos1Parser.g:5757:3: () otherlv_1= Uint64
            {
            // InternalRos1Parser.g:5757:3: ()
            // InternalRos1Parser.g:5758:4: 
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
    // InternalRos1Parser.g:5772:1: entryRulefloat32 returns [EObject current=null] : iv_rulefloat32= rulefloat32 EOF ;
    public final EObject entryRulefloat32() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32 = null;


        try {
            // InternalRos1Parser.g:5772:48: (iv_rulefloat32= rulefloat32 EOF )
            // InternalRos1Parser.g:5773:2: iv_rulefloat32= rulefloat32 EOF
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
    // InternalRos1Parser.g:5779:1: rulefloat32 returns [EObject current=null] : ( () otherlv_1= Float32 ) ;
    public final EObject rulefloat32() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5785:2: ( ( () otherlv_1= Float32 ) )
            // InternalRos1Parser.g:5786:2: ( () otherlv_1= Float32 )
            {
            // InternalRos1Parser.g:5786:2: ( () otherlv_1= Float32 )
            // InternalRos1Parser.g:5787:3: () otherlv_1= Float32
            {
            // InternalRos1Parser.g:5787:3: ()
            // InternalRos1Parser.g:5788:4: 
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
    // InternalRos1Parser.g:5802:1: entryRulefloat64 returns [EObject current=null] : iv_rulefloat64= rulefloat64 EOF ;
    public final EObject entryRulefloat64() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64 = null;


        try {
            // InternalRos1Parser.g:5802:48: (iv_rulefloat64= rulefloat64 EOF )
            // InternalRos1Parser.g:5803:2: iv_rulefloat64= rulefloat64 EOF
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
    // InternalRos1Parser.g:5809:1: rulefloat64 returns [EObject current=null] : ( () otherlv_1= Float64 ) ;
    public final EObject rulefloat64() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5815:2: ( ( () otherlv_1= Float64 ) )
            // InternalRos1Parser.g:5816:2: ( () otherlv_1= Float64 )
            {
            // InternalRos1Parser.g:5816:2: ( () otherlv_1= Float64 )
            // InternalRos1Parser.g:5817:3: () otherlv_1= Float64
            {
            // InternalRos1Parser.g:5817:3: ()
            // InternalRos1Parser.g:5818:4: 
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
    // InternalRos1Parser.g:5832:1: entryRulestring0 returns [EObject current=null] : iv_rulestring0= rulestring0 EOF ;
    public final EObject entryRulestring0() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0 = null;


        try {
            // InternalRos1Parser.g:5832:48: (iv_rulestring0= rulestring0 EOF )
            // InternalRos1Parser.g:5833:2: iv_rulestring0= rulestring0 EOF
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
    // InternalRos1Parser.g:5839:1: rulestring0 returns [EObject current=null] : ( () otherlv_1= String_1 ) ;
    public final EObject rulestring0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5845:2: ( ( () otherlv_1= String_1 ) )
            // InternalRos1Parser.g:5846:2: ( () otherlv_1= String_1 )
            {
            // InternalRos1Parser.g:5846:2: ( () otherlv_1= String_1 )
            // InternalRos1Parser.g:5847:3: () otherlv_1= String_1
            {
            // InternalRos1Parser.g:5847:3: ()
            // InternalRos1Parser.g:5848:4: 
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
    // InternalRos1Parser.g:5862:1: entryRulechar returns [EObject current=null] : iv_rulechar= rulechar EOF ;
    public final EObject entryRulechar() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechar = null;


        try {
            // InternalRos1Parser.g:5862:45: (iv_rulechar= rulechar EOF )
            // InternalRos1Parser.g:5863:2: iv_rulechar= rulechar EOF
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
    // InternalRos1Parser.g:5869:1: rulechar returns [EObject current=null] : ( () otherlv_1= Char ) ;
    public final EObject rulechar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5875:2: ( ( () otherlv_1= Char ) )
            // InternalRos1Parser.g:5876:2: ( () otherlv_1= Char )
            {
            // InternalRos1Parser.g:5876:2: ( () otherlv_1= Char )
            // InternalRos1Parser.g:5877:3: () otherlv_1= Char
            {
            // InternalRos1Parser.g:5877:3: ()
            // InternalRos1Parser.g:5878:4: 
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
    // InternalRos1Parser.g:5892:1: entryRulebyte returns [EObject current=null] : iv_rulebyte= rulebyte EOF ;
    public final EObject entryRulebyte() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyte = null;


        try {
            // InternalRos1Parser.g:5892:45: (iv_rulebyte= rulebyte EOF )
            // InternalRos1Parser.g:5893:2: iv_rulebyte= rulebyte EOF
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
    // InternalRos1Parser.g:5899:1: rulebyte returns [EObject current=null] : ( () otherlv_1= Byte ) ;
    public final EObject rulebyte() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5905:2: ( ( () otherlv_1= Byte ) )
            // InternalRos1Parser.g:5906:2: ( () otherlv_1= Byte )
            {
            // InternalRos1Parser.g:5906:2: ( () otherlv_1= Byte )
            // InternalRos1Parser.g:5907:3: () otherlv_1= Byte
            {
            // InternalRos1Parser.g:5907:3: ()
            // InternalRos1Parser.g:5908:4: 
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
    // InternalRos1Parser.g:5922:1: entryRuletime returns [EObject current=null] : iv_ruletime= ruletime EOF ;
    public final EObject entryRuletime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletime = null;


        try {
            // InternalRos1Parser.g:5922:45: (iv_ruletime= ruletime EOF )
            // InternalRos1Parser.g:5923:2: iv_ruletime= ruletime EOF
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
    // InternalRos1Parser.g:5929:1: ruletime returns [EObject current=null] : ( () otherlv_1= Time ) ;
    public final EObject ruletime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5935:2: ( ( () otherlv_1= Time ) )
            // InternalRos1Parser.g:5936:2: ( () otherlv_1= Time )
            {
            // InternalRos1Parser.g:5936:2: ( () otherlv_1= Time )
            // InternalRos1Parser.g:5937:3: () otherlv_1= Time
            {
            // InternalRos1Parser.g:5937:3: ()
            // InternalRos1Parser.g:5938:4: 
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
    // InternalRos1Parser.g:5952:1: entryRuleduration returns [EObject current=null] : iv_ruleduration= ruleduration EOF ;
    public final EObject entryRuleduration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleduration = null;


        try {
            // InternalRos1Parser.g:5952:49: (iv_ruleduration= ruleduration EOF )
            // InternalRos1Parser.g:5953:2: iv_ruleduration= ruleduration EOF
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
    // InternalRos1Parser.g:5959:1: ruleduration returns [EObject current=null] : ( () otherlv_1= Duration ) ;
    public final EObject ruleduration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5965:2: ( ( () otherlv_1= Duration ) )
            // InternalRos1Parser.g:5966:2: ( () otherlv_1= Duration )
            {
            // InternalRos1Parser.g:5966:2: ( () otherlv_1= Duration )
            // InternalRos1Parser.g:5967:3: () otherlv_1= Duration
            {
            // InternalRos1Parser.g:5967:3: ()
            // InternalRos1Parser.g:5968:4: 
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
    // InternalRos1Parser.g:5982:1: entryRuleboolArray returns [EObject current=null] : iv_ruleboolArray= ruleboolArray EOF ;
    public final EObject entryRuleboolArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleboolArray = null;


        try {
            // InternalRos1Parser.g:5982:50: (iv_ruleboolArray= ruleboolArray EOF )
            // InternalRos1Parser.g:5983:2: iv_ruleboolArray= ruleboolArray EOF
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
    // InternalRos1Parser.g:5989:1: ruleboolArray returns [EObject current=null] : ( () otherlv_1= Bool_1 ) ;
    public final EObject ruleboolArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:5995:2: ( ( () otherlv_1= Bool_1 ) )
            // InternalRos1Parser.g:5996:2: ( () otherlv_1= Bool_1 )
            {
            // InternalRos1Parser.g:5996:2: ( () otherlv_1= Bool_1 )
            // InternalRos1Parser.g:5997:3: () otherlv_1= Bool_1
            {
            // InternalRos1Parser.g:5997:3: ()
            // InternalRos1Parser.g:5998:4: 
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
    // InternalRos1Parser.g:6012:1: entryRuleint8Array returns [EObject current=null] : iv_ruleint8Array= ruleint8Array EOF ;
    public final EObject entryRuleint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint8Array = null;


        try {
            // InternalRos1Parser.g:6012:50: (iv_ruleint8Array= ruleint8Array EOF )
            // InternalRos1Parser.g:6013:2: iv_ruleint8Array= ruleint8Array EOF
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
    // InternalRos1Parser.g:6019:1: ruleint8Array returns [EObject current=null] : ( () otherlv_1= Int8_1 ) ;
    public final EObject ruleint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6025:2: ( ( () otherlv_1= Int8_1 ) )
            // InternalRos1Parser.g:6026:2: ( () otherlv_1= Int8_1 )
            {
            // InternalRos1Parser.g:6026:2: ( () otherlv_1= Int8_1 )
            // InternalRos1Parser.g:6027:3: () otherlv_1= Int8_1
            {
            // InternalRos1Parser.g:6027:3: ()
            // InternalRos1Parser.g:6028:4: 
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
    // InternalRos1Parser.g:6042:1: entryRuleuint8Array returns [EObject current=null] : iv_ruleuint8Array= ruleuint8Array EOF ;
    public final EObject entryRuleuint8Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint8Array = null;


        try {
            // InternalRos1Parser.g:6042:51: (iv_ruleuint8Array= ruleuint8Array EOF )
            // InternalRos1Parser.g:6043:2: iv_ruleuint8Array= ruleuint8Array EOF
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
    // InternalRos1Parser.g:6049:1: ruleuint8Array returns [EObject current=null] : ( () otherlv_1= Uint8_1 ) ;
    public final EObject ruleuint8Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6055:2: ( ( () otherlv_1= Uint8_1 ) )
            // InternalRos1Parser.g:6056:2: ( () otherlv_1= Uint8_1 )
            {
            // InternalRos1Parser.g:6056:2: ( () otherlv_1= Uint8_1 )
            // InternalRos1Parser.g:6057:3: () otherlv_1= Uint8_1
            {
            // InternalRos1Parser.g:6057:3: ()
            // InternalRos1Parser.g:6058:4: 
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
    // InternalRos1Parser.g:6072:1: entryRuleint16Array returns [EObject current=null] : iv_ruleint16Array= ruleint16Array EOF ;
    public final EObject entryRuleint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint16Array = null;


        try {
            // InternalRos1Parser.g:6072:51: (iv_ruleint16Array= ruleint16Array EOF )
            // InternalRos1Parser.g:6073:2: iv_ruleint16Array= ruleint16Array EOF
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
    // InternalRos1Parser.g:6079:1: ruleint16Array returns [EObject current=null] : ( () otherlv_1= Int16_1 ) ;
    public final EObject ruleint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6085:2: ( ( () otherlv_1= Int16_1 ) )
            // InternalRos1Parser.g:6086:2: ( () otherlv_1= Int16_1 )
            {
            // InternalRos1Parser.g:6086:2: ( () otherlv_1= Int16_1 )
            // InternalRos1Parser.g:6087:3: () otherlv_1= Int16_1
            {
            // InternalRos1Parser.g:6087:3: ()
            // InternalRos1Parser.g:6088:4: 
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
    // InternalRos1Parser.g:6102:1: entryRuleuint16Array returns [EObject current=null] : iv_ruleuint16Array= ruleuint16Array EOF ;
    public final EObject entryRuleuint16Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint16Array = null;


        try {
            // InternalRos1Parser.g:6102:52: (iv_ruleuint16Array= ruleuint16Array EOF )
            // InternalRos1Parser.g:6103:2: iv_ruleuint16Array= ruleuint16Array EOF
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
    // InternalRos1Parser.g:6109:1: ruleuint16Array returns [EObject current=null] : ( () otherlv_1= Uint16_1 ) ;
    public final EObject ruleuint16Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6115:2: ( ( () otherlv_1= Uint16_1 ) )
            // InternalRos1Parser.g:6116:2: ( () otherlv_1= Uint16_1 )
            {
            // InternalRos1Parser.g:6116:2: ( () otherlv_1= Uint16_1 )
            // InternalRos1Parser.g:6117:3: () otherlv_1= Uint16_1
            {
            // InternalRos1Parser.g:6117:3: ()
            // InternalRos1Parser.g:6118:4: 
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
    // InternalRos1Parser.g:6132:1: entryRuleint32Array returns [EObject current=null] : iv_ruleint32Array= ruleint32Array EOF ;
    public final EObject entryRuleint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint32Array = null;


        try {
            // InternalRos1Parser.g:6132:51: (iv_ruleint32Array= ruleint32Array EOF )
            // InternalRos1Parser.g:6133:2: iv_ruleint32Array= ruleint32Array EOF
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
    // InternalRos1Parser.g:6139:1: ruleint32Array returns [EObject current=null] : ( () otherlv_1= Int32_1 ) ;
    public final EObject ruleint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6145:2: ( ( () otherlv_1= Int32_1 ) )
            // InternalRos1Parser.g:6146:2: ( () otherlv_1= Int32_1 )
            {
            // InternalRos1Parser.g:6146:2: ( () otherlv_1= Int32_1 )
            // InternalRos1Parser.g:6147:3: () otherlv_1= Int32_1
            {
            // InternalRos1Parser.g:6147:3: ()
            // InternalRos1Parser.g:6148:4: 
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
    // InternalRos1Parser.g:6162:1: entryRuleuint32Array returns [EObject current=null] : iv_ruleuint32Array= ruleuint32Array EOF ;
    public final EObject entryRuleuint32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint32Array = null;


        try {
            // InternalRos1Parser.g:6162:52: (iv_ruleuint32Array= ruleuint32Array EOF )
            // InternalRos1Parser.g:6163:2: iv_ruleuint32Array= ruleuint32Array EOF
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
    // InternalRos1Parser.g:6169:1: ruleuint32Array returns [EObject current=null] : ( () otherlv_1= Uint32_1 ) ;
    public final EObject ruleuint32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6175:2: ( ( () otherlv_1= Uint32_1 ) )
            // InternalRos1Parser.g:6176:2: ( () otherlv_1= Uint32_1 )
            {
            // InternalRos1Parser.g:6176:2: ( () otherlv_1= Uint32_1 )
            // InternalRos1Parser.g:6177:3: () otherlv_1= Uint32_1
            {
            // InternalRos1Parser.g:6177:3: ()
            // InternalRos1Parser.g:6178:4: 
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
    // InternalRos1Parser.g:6192:1: entryRuleint64Array returns [EObject current=null] : iv_ruleint64Array= ruleint64Array EOF ;
    public final EObject entryRuleint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleint64Array = null;


        try {
            // InternalRos1Parser.g:6192:51: (iv_ruleint64Array= ruleint64Array EOF )
            // InternalRos1Parser.g:6193:2: iv_ruleint64Array= ruleint64Array EOF
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
    // InternalRos1Parser.g:6199:1: ruleint64Array returns [EObject current=null] : ( () otherlv_1= Int64_1 ) ;
    public final EObject ruleint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6205:2: ( ( () otherlv_1= Int64_1 ) )
            // InternalRos1Parser.g:6206:2: ( () otherlv_1= Int64_1 )
            {
            // InternalRos1Parser.g:6206:2: ( () otherlv_1= Int64_1 )
            // InternalRos1Parser.g:6207:3: () otherlv_1= Int64_1
            {
            // InternalRos1Parser.g:6207:3: ()
            // InternalRos1Parser.g:6208:4: 
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
    // InternalRos1Parser.g:6222:1: entryRuleuint64Array returns [EObject current=null] : iv_ruleuint64Array= ruleuint64Array EOF ;
    public final EObject entryRuleuint64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleuint64Array = null;


        try {
            // InternalRos1Parser.g:6222:52: (iv_ruleuint64Array= ruleuint64Array EOF )
            // InternalRos1Parser.g:6223:2: iv_ruleuint64Array= ruleuint64Array EOF
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
    // InternalRos1Parser.g:6229:1: ruleuint64Array returns [EObject current=null] : ( () otherlv_1= Uint64_1 ) ;
    public final EObject ruleuint64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6235:2: ( ( () otherlv_1= Uint64_1 ) )
            // InternalRos1Parser.g:6236:2: ( () otherlv_1= Uint64_1 )
            {
            // InternalRos1Parser.g:6236:2: ( () otherlv_1= Uint64_1 )
            // InternalRos1Parser.g:6237:3: () otherlv_1= Uint64_1
            {
            // InternalRos1Parser.g:6237:3: ()
            // InternalRos1Parser.g:6238:4: 
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
    // InternalRos1Parser.g:6252:1: entryRulefloat32Array returns [EObject current=null] : iv_rulefloat32Array= rulefloat32Array EOF ;
    public final EObject entryRulefloat32Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat32Array = null;


        try {
            // InternalRos1Parser.g:6252:53: (iv_rulefloat32Array= rulefloat32Array EOF )
            // InternalRos1Parser.g:6253:2: iv_rulefloat32Array= rulefloat32Array EOF
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
    // InternalRos1Parser.g:6259:1: rulefloat32Array returns [EObject current=null] : ( () otherlv_1= Float32_1 ) ;
    public final EObject rulefloat32Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6265:2: ( ( () otherlv_1= Float32_1 ) )
            // InternalRos1Parser.g:6266:2: ( () otherlv_1= Float32_1 )
            {
            // InternalRos1Parser.g:6266:2: ( () otherlv_1= Float32_1 )
            // InternalRos1Parser.g:6267:3: () otherlv_1= Float32_1
            {
            // InternalRos1Parser.g:6267:3: ()
            // InternalRos1Parser.g:6268:4: 
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
    // InternalRos1Parser.g:6282:1: entryRulefloat64Array returns [EObject current=null] : iv_rulefloat64Array= rulefloat64Array EOF ;
    public final EObject entryRulefloat64Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulefloat64Array = null;


        try {
            // InternalRos1Parser.g:6282:53: (iv_rulefloat64Array= rulefloat64Array EOF )
            // InternalRos1Parser.g:6283:2: iv_rulefloat64Array= rulefloat64Array EOF
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
    // InternalRos1Parser.g:6289:1: rulefloat64Array returns [EObject current=null] : ( () otherlv_1= Float64_1 ) ;
    public final EObject rulefloat64Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6295:2: ( ( () otherlv_1= Float64_1 ) )
            // InternalRos1Parser.g:6296:2: ( () otherlv_1= Float64_1 )
            {
            // InternalRos1Parser.g:6296:2: ( () otherlv_1= Float64_1 )
            // InternalRos1Parser.g:6297:3: () otherlv_1= Float64_1
            {
            // InternalRos1Parser.g:6297:3: ()
            // InternalRos1Parser.g:6298:4: 
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
    // InternalRos1Parser.g:6312:1: entryRulestring0Array returns [EObject current=null] : iv_rulestring0Array= rulestring0Array EOF ;
    public final EObject entryRulestring0Array() throws RecognitionException {
        EObject current = null;

        EObject iv_rulestring0Array = null;


        try {
            // InternalRos1Parser.g:6312:53: (iv_rulestring0Array= rulestring0Array EOF )
            // InternalRos1Parser.g:6313:2: iv_rulestring0Array= rulestring0Array EOF
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
    // InternalRos1Parser.g:6319:1: rulestring0Array returns [EObject current=null] : ( () otherlv_1= String_2 ) ;
    public final EObject rulestring0Array() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6325:2: ( ( () otherlv_1= String_2 ) )
            // InternalRos1Parser.g:6326:2: ( () otherlv_1= String_2 )
            {
            // InternalRos1Parser.g:6326:2: ( () otherlv_1= String_2 )
            // InternalRos1Parser.g:6327:3: () otherlv_1= String_2
            {
            // InternalRos1Parser.g:6327:3: ()
            // InternalRos1Parser.g:6328:4: 
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
    // InternalRos1Parser.g:6342:1: entryRulebyteArray returns [EObject current=null] : iv_rulebyteArray= rulebyteArray EOF ;
    public final EObject entryRulebyteArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulebyteArray = null;


        try {
            // InternalRos1Parser.g:6342:50: (iv_rulebyteArray= rulebyteArray EOF )
            // InternalRos1Parser.g:6343:2: iv_rulebyteArray= rulebyteArray EOF
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
    // InternalRos1Parser.g:6349:1: rulebyteArray returns [EObject current=null] : ( () otherlv_1= Byte_1 ) ;
    public final EObject rulebyteArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6355:2: ( ( () otherlv_1= Byte_1 ) )
            // InternalRos1Parser.g:6356:2: ( () otherlv_1= Byte_1 )
            {
            // InternalRos1Parser.g:6356:2: ( () otherlv_1= Byte_1 )
            // InternalRos1Parser.g:6357:3: () otherlv_1= Byte_1
            {
            // InternalRos1Parser.g:6357:3: ()
            // InternalRos1Parser.g:6358:4: 
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
    // InternalRos1Parser.g:6372:1: entryRulecharArray returns [EObject current=null] : iv_rulecharArray= rulecharArray EOF ;
    public final EObject entryRulecharArray() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecharArray = null;


        try {
            // InternalRos1Parser.g:6372:50: (iv_rulecharArray= rulecharArray EOF )
            // InternalRos1Parser.g:6373:2: iv_rulecharArray= rulecharArray EOF
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
    // InternalRos1Parser.g:6379:1: rulecharArray returns [EObject current=null] : ( () otherlv_1= Char_1 ) ;
    public final EObject rulecharArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6385:2: ( ( () otherlv_1= Char_1 ) )
            // InternalRos1Parser.g:6386:2: ( () otherlv_1= Char_1 )
            {
            // InternalRos1Parser.g:6386:2: ( () otherlv_1= Char_1 )
            // InternalRos1Parser.g:6387:3: () otherlv_1= Char_1
            {
            // InternalRos1Parser.g:6387:3: ()
            // InternalRos1Parser.g:6388:4: 
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
    // InternalRos1Parser.g:6402:1: entryRuleHeader returns [EObject current=null] : iv_ruleHeader= ruleHeader EOF ;
    public final EObject entryRuleHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHeader = null;


        try {
            // InternalRos1Parser.g:6402:47: (iv_ruleHeader= ruleHeader EOF )
            // InternalRos1Parser.g:6403:2: iv_ruleHeader= ruleHeader EOF
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
    // InternalRos1Parser.g:6409:1: ruleHeader returns [EObject current=null] : ( () otherlv_1= Header ) ;
    public final EObject ruleHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6415:2: ( ( () otherlv_1= Header ) )
            // InternalRos1Parser.g:6416:2: ( () otherlv_1= Header )
            {
            // InternalRos1Parser.g:6416:2: ( () otherlv_1= Header )
            // InternalRos1Parser.g:6417:3: () otherlv_1= Header
            {
            // InternalRos1Parser.g:6417:3: ()
            // InternalRos1Parser.g:6418:4: 
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
    // InternalRos1Parser.g:6432:1: entryRuleSpecBaseRef returns [EObject current=null] : iv_ruleSpecBaseRef= ruleSpecBaseRef EOF ;
    public final EObject entryRuleSpecBaseRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecBaseRef = null;


        try {
            // InternalRos1Parser.g:6432:52: (iv_ruleSpecBaseRef= ruleSpecBaseRef EOF )
            // InternalRos1Parser.g:6433:2: iv_ruleSpecBaseRef= ruleSpecBaseRef EOF
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
    // InternalRos1Parser.g:6439:1: ruleSpecBaseRef returns [EObject current=null] : ( ( ruleEString ) ) ;
    public final EObject ruleSpecBaseRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6445:2: ( ( ( ruleEString ) ) )
            // InternalRos1Parser.g:6446:2: ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:6446:2: ( ( ruleEString ) )
            // InternalRos1Parser.g:6447:3: ( ruleEString )
            {
            // InternalRos1Parser.g:6447:3: ( ruleEString )
            // InternalRos1Parser.g:6448:4: ruleEString
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
    // InternalRos1Parser.g:6465:1: entryRuleArraySpecRef returns [EObject current=null] : iv_ruleArraySpecRef= ruleArraySpecRef EOF ;
    public final EObject entryRuleArraySpecRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySpecRef = null;


        try {
            // InternalRos1Parser.g:6465:53: (iv_ruleArraySpecRef= ruleArraySpecRef EOF )
            // InternalRos1Parser.g:6466:2: iv_ruleArraySpecRef= ruleArraySpecRef EOF
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
    // InternalRos1Parser.g:6472:1: ruleArraySpecRef returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) ;
    public final EObject ruleArraySpecRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6478:2: ( ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket ) )
            // InternalRos1Parser.g:6479:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            {
            // InternalRos1Parser.g:6479:2: ( ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket )
            // InternalRos1Parser.g:6480:3: ( ( ruleEString ) ) otherlv_1= LeftSquareBracketRightSquareBracket
            {
            // InternalRos1Parser.g:6480:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:6481:4: ( ruleEString )
            {
            // InternalRos1Parser.g:6481:4: ( ruleEString )
            // InternalRos1Parser.g:6482:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getArraySpecRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getArraySpecRefAccess().getReferenceTopicSpecCrossReference_0_0());
            				
            pushFollow(FOLLOW_67);
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
    // InternalRos1Parser.g:6504:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalRos1Parser.g:6504:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalRos1Parser.g:6505:2: iv_ruleKEYWORD= ruleKEYWORD EOF
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
    // InternalRos1Parser.g:6511:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6517:2: ( (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time ) )
            // InternalRos1Parser.g:6518:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            {
            // InternalRos1Parser.g:6518:2: (kw= Goal | kw= Message | kw= Result | kw= Feedback | kw= Name | kw= Value | kw= Service | kw= Type | kw= Action | kw= Duration | kw= Time )
            int alt84=11;
            switch ( input.LA(1) ) {
            case Goal:
                {
                alt84=1;
                }
                break;
            case Message:
                {
                alt84=2;
                }
                break;
            case Result:
                {
                alt84=3;
                }
                break;
            case Feedback:
                {
                alt84=4;
                }
                break;
            case Name:
                {
                alt84=5;
                }
                break;
            case Value:
                {
                alt84=6;
                }
                break;
            case Service:
                {
                alt84=7;
                }
                break;
            case Type:
                {
                alt84=8;
                }
                break;
            case Action:
                {
                alt84=9;
                }
                break;
            case Duration:
                {
                alt84=10;
                }
                break;
            case Time:
                {
                alt84=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalRos1Parser.g:6519:3: kw= Goal
                    {
                    kw=(Token)match(input,Goal,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getGoalKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:6525:3: kw= Message
                    {
                    kw=(Token)match(input,Message,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMessageKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:6531:3: kw= Result
                    {
                    kw=(Token)match(input,Result,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getResultKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:6537:3: kw= Feedback
                    {
                    kw=(Token)match(input,Feedback,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFeedbackKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:6543:3: kw= Name
                    {
                    kw=(Token)match(input,Name,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNameKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalRos1Parser.g:6549:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getValueKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalRos1Parser.g:6555:3: kw= Service
                    {
                    kw=(Token)match(input,Service,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getServiceKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalRos1Parser.g:6561:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTypeKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalRos1Parser.g:6567:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getActionKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalRos1Parser.g:6573:3: kw= Duration
                    {
                    kw=(Token)match(input,Duration,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDurationKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalRos1Parser.g:6579:3: kw= Time
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
    // InternalRos1Parser.g:6588:1: entryRuleExtensionBlock returns [EObject current=null] : iv_ruleExtensionBlock= ruleExtensionBlock EOF ;
    public final EObject entryRuleExtensionBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBlock = null;


        try {
            // InternalRos1Parser.g:6588:55: (iv_ruleExtensionBlock= ruleExtensionBlock EOF )
            // InternalRos1Parser.g:6589:2: iv_ruleExtensionBlock= ruleExtensionBlock EOF
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
    // InternalRos1Parser.g:6595:1: ruleExtensionBlock returns [EObject current=null] : ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) ;
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
            // InternalRos1Parser.g:6601:2: ( ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? ) )
            // InternalRos1Parser.g:6602:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            {
            // InternalRos1Parser.g:6602:2: ( () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )? )
            // InternalRos1Parser.g:6603:3: () otherlv_1= CommercialAt ( (lv_name_2_0= ruleExtensionBlockName ) ) otherlv_3= Colon ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            {
            // InternalRos1Parser.g:6603:3: ()
            // InternalRos1Parser.g:6604:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBlockAccess().getExtensionBlockAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,CommercialAt,FOLLOW_68); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBlockAccess().getCommercialAtKeyword_1());
            		
            // InternalRos1Parser.g:6614:3: ( (lv_name_2_0= ruleExtensionBlockName ) )
            // InternalRos1Parser.g:6615:4: (lv_name_2_0= ruleExtensionBlockName )
            {
            // InternalRos1Parser.g:6615:4: (lv_name_2_0= ruleExtensionBlockName )
            // InternalRos1Parser.g:6616:5: lv_name_2_0= ruleExtensionBlockName
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

            otherlv_3=(Token)match(input,Colon,FOLLOW_69); 

            			newLeafNode(otherlv_3, grammarAccess.getExtensionBlockAccess().getColonKeyword_3());
            		
            // InternalRos1Parser.g:6637:3: ( (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END ) | (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket ) )?
            int alt89=3;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_BEGIN) ) {
                alt89=1;
            }
            else if ( (LA89_0==LeftCurlyBracket) ) {
                alt89=2;
            }
            switch (alt89) {
                case 1 :
                    // InternalRos1Parser.g:6638:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    {
                    // InternalRos1Parser.g:6638:4: (this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END )
                    // InternalRos1Parser.g:6639:5: this_BEGIN_4= RULE_BEGIN ( (lv_entries_5_0= ruleExtensionEntry ) )+ this_END_6= RULE_END
                    {
                    this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_70); 

                    					newLeafNode(this_BEGIN_4, grammarAccess.getExtensionBlockAccess().getBEGINTerminalRuleCall_4_0_0());
                    				
                    // InternalRos1Parser.g:6643:5: ( (lv_entries_5_0= ruleExtensionEntry ) )+
                    int cnt85=0;
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( ((LA85_0>=Serviceclients && LA85_0<=Dependencies)||(LA85_0>=FromGitRepo && LA85_0<=Publishers)||LA85_0==Parameter||(LA85_0>=Pluginlib && LA85_0<=Plugins)||(LA85_0>=Boolean && LA85_0<=Format)||(LA85_0>=Library && LA85_0<=Message)||LA85_0==Service||(LA85_0>=Base64 && LA85_0<=Action)||(LA85_0>=Result && LA85_0<=Node_1)||LA85_0==Srvs||(LA85_0>=Type_1 && LA85_0<=List)||(LA85_0>=Bool && LA85_0<=Node)||(LA85_0>=Time && LA85_0<=Ns)||(LA85_0>=RULE_ID && LA85_0<=RULE_STRING)) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // InternalRos1Parser.g:6644:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRos1Parser.g:6644:6: (lv_entries_5_0= ruleExtensionEntry )
                    	    // InternalRos1Parser.g:6645:7: lv_entries_5_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_0_1_0());
                    	    						
                    	    pushFollow(FOLLOW_71);
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
                    	    if ( cnt85 >= 1 ) break loop85;
                                EarlyExitException eee =
                                    new EarlyExitException(85, input);
                                throw eee;
                        }
                        cnt85++;
                    } while (true);

                    this_END_6=(Token)match(input,RULE_END,FOLLOW_2); 

                    					newLeafNode(this_END_6, grammarAccess.getExtensionBlockAccess().getENDTerminalRuleCall_4_0_2());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:6668:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    {
                    // InternalRos1Parser.g:6668:4: (otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket )
                    // InternalRos1Parser.g:6669:5: otherlv_7= LeftCurlyBracket ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )? otherlv_11= RightCurlyBracket
                    {
                    otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_72); 

                    					newLeafNode(otherlv_7, grammarAccess.getExtensionBlockAccess().getLeftCurlyBracketKeyword_4_1_0());
                    				
                    // InternalRos1Parser.g:6673:5: ( ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )* )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( ((LA88_0>=Serviceclients && LA88_0<=Dependencies)||(LA88_0>=FromGitRepo && LA88_0<=Publishers)||LA88_0==Parameter||(LA88_0>=Pluginlib && LA88_0<=Plugins)||(LA88_0>=Boolean && LA88_0<=Format)||(LA88_0>=Library && LA88_0<=Message)||LA88_0==Service||(LA88_0>=Base64 && LA88_0<=Action)||(LA88_0>=Result && LA88_0<=Node_1)||LA88_0==Srvs||(LA88_0>=Type_1 && LA88_0<=List)||(LA88_0>=Bool && LA88_0<=Node)||(LA88_0>=Time && LA88_0<=Ns)||(LA88_0>=RULE_ID && LA88_0<=RULE_STRING)) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // InternalRos1Parser.g:6674:6: ( (lv_entries_8_0= ruleExtensionEntry ) ) ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            {
                            // InternalRos1Parser.g:6674:6: ( (lv_entries_8_0= ruleExtensionEntry ) )
                            // InternalRos1Parser.g:6675:7: (lv_entries_8_0= ruleExtensionEntry )
                            {
                            // InternalRos1Parser.g:6675:7: (lv_entries_8_0= ruleExtensionEntry )
                            // InternalRos1Parser.g:6676:8: lv_entries_8_0= ruleExtensionEntry
                            {

                            								newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_0_0());
                            							
                            pushFollow(FOLLOW_73);
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

                            // InternalRos1Parser.g:6693:6: ( (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) ) )*
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( ((LA87_0>=Serviceclients && LA87_0<=Dependencies)||(LA87_0>=FromGitRepo && LA87_0<=Publishers)||LA87_0==Parameter||(LA87_0>=Pluginlib && LA87_0<=Plugins)||(LA87_0>=Boolean && LA87_0<=Format)||(LA87_0>=Library && LA87_0<=Message)||LA87_0==Service||(LA87_0>=Base64 && LA87_0<=Action)||(LA87_0>=Result && LA87_0<=Node_1)||LA87_0==Srvs||(LA87_0>=Type_1 && LA87_0<=List)||(LA87_0>=Bool && LA87_0<=Node)||(LA87_0>=Time && LA87_0<=Ns)||LA87_0==Comma||(LA87_0>=RULE_ID && LA87_0<=RULE_STRING)) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // InternalRos1Parser.g:6694:7: (otherlv_9= Comma )? ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    {
                            	    // InternalRos1Parser.g:6694:7: (otherlv_9= Comma )?
                            	    int alt86=2;
                            	    int LA86_0 = input.LA(1);

                            	    if ( (LA86_0==Comma) ) {
                            	        alt86=1;
                            	    }
                            	    switch (alt86) {
                            	        case 1 :
                            	            // InternalRos1Parser.g:6695:8: otherlv_9= Comma
                            	            {
                            	            otherlv_9=(Token)match(input,Comma,FOLLOW_70); 

                            	            								newLeafNode(otherlv_9, grammarAccess.getExtensionBlockAccess().getCommaKeyword_4_1_1_1_0());
                            	            							

                            	            }
                            	            break;

                            	    }

                            	    // InternalRos1Parser.g:6700:7: ( (lv_entries_10_0= ruleExtensionEntry ) )
                            	    // InternalRos1Parser.g:6701:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    {
                            	    // InternalRos1Parser.g:6701:8: (lv_entries_10_0= ruleExtensionEntry )
                            	    // InternalRos1Parser.g:6702:9: lv_entries_10_0= ruleExtensionEntry
                            	    {

                            	    									newCompositeNode(grammarAccess.getExtensionBlockAccess().getEntriesExtensionEntryParserRuleCall_4_1_1_1_1_0());
                            	    								
                            	    pushFollow(FOLLOW_73);
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
                            	    break loop87;
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
    // InternalRos1Parser.g:6731:1: entryRuleExtensionBlockName returns [String current=null] : iv_ruleExtensionBlockName= ruleExtensionBlockName EOF ;
    public final String entryRuleExtensionBlockName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionBlockName = null;


        try {
            // InternalRos1Parser.g:6731:58: (iv_ruleExtensionBlockName= ruleExtensionBlockName EOF )
            // InternalRos1Parser.g:6732:2: iv_ruleExtensionBlockName= ruleExtensionBlockName EOF
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
    // InternalRos1Parser.g:6738:1: ruleExtensionBlockName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleExtensionBlockName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:6744:2: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // InternalRos1Parser.g:6745:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // InternalRos1Parser.g:6745:2: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // InternalRos1Parser.g:6746:3: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_74); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRos1Parser.g:6753:3: (kw= FullStop this_ID_2= RULE_ID )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==FullStop) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalRos1Parser.g:6754:4: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_68); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getExtensionBlockNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_74); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getExtensionBlockNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop90;
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
    // InternalRos1Parser.g:6771:1: entryRuleExtensionEntry returns [EObject current=null] : iv_ruleExtensionEntry= ruleExtensionEntry EOF ;
    public final EObject entryRuleExtensionEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionEntry = null;


        try {
            // InternalRos1Parser.g:6771:55: (iv_ruleExtensionEntry= ruleExtensionEntry EOF )
            // InternalRos1Parser.g:6772:2: iv_ruleExtensionEntry= ruleExtensionEntry EOF
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
    // InternalRos1Parser.g:6778:1: ruleExtensionEntry returns [EObject current=null] : ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) ;
    public final EObject ruleExtensionEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_key_1_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6784:2: ( ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) ) )
            // InternalRos1Parser.g:6785:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            {
            // InternalRos1Parser.g:6785:2: ( () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) ) )
            // InternalRos1Parser.g:6786:3: () ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) ) ( (lv_value_4_0= ruleExtensionValue ) )
            {
            // InternalRos1Parser.g:6786:3: ()
            // InternalRos1Parser.g:6787:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionEntryAccess().getExtensionEntryAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:6793:3: ( ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon ) | ( (lv_key_3_0= ruleExtensionColonKey ) ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==Pluginlib||(LA91_0>=Duration && LA91_0<=Feedback)||(LA91_0>=Boolean && LA91_0<=Float64)||LA91_0==Library||LA91_0==Message||LA91_0==Service||(LA91_0>=Base64 && LA91_0<=Action)||(LA91_0>=Result && LA91_0<=Uint64)||LA91_0==Array||(LA91_0>=Class && LA91_0<=Int64)||(LA91_0>=Uint8 && LA91_0<=List)||(LA91_0>=Bool && LA91_0<=Node)||(LA91_0>=Time && LA91_0<=Any)||(LA91_0>=RULE_ID && LA91_0<=RULE_STRING)) ) {
                alt91=1;
            }
            else if ( ((LA91_0>=Serviceclients && LA91_0<=Dependencies)||(LA91_0>=FromGitRepo && LA91_0<=Publishers)||LA91_0==Parameter||(LA91_0>=Actions && LA91_0<=Default)||LA91_0==Plugins||LA91_0==Format||LA91_0==Loader||LA91_0==Value_1||LA91_0==Base||(LA91_0>=Msgs && LA91_0<=Node_1)||LA91_0==Srvs||LA91_0==Type_1||LA91_0==Ns) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // InternalRos1Parser.g:6794:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    {
                    // InternalRos1Parser.g:6794:4: ( ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon )
                    // InternalRos1Parser.g:6795:5: ( (lv_key_1_0= ruleExtensionKey ) ) otherlv_2= Colon
                    {
                    // InternalRos1Parser.g:6795:5: ( (lv_key_1_0= ruleExtensionKey ) )
                    // InternalRos1Parser.g:6796:6: (lv_key_1_0= ruleExtensionKey )
                    {
                    // InternalRos1Parser.g:6796:6: (lv_key_1_0= ruleExtensionKey )
                    // InternalRos1Parser.g:6797:7: lv_key_1_0= ruleExtensionKey
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

                    otherlv_2=(Token)match(input,Colon,FOLLOW_75); 

                    					newLeafNode(otherlv_2, grammarAccess.getExtensionEntryAccess().getColonKeyword_1_0_1());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:6820:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    {
                    // InternalRos1Parser.g:6820:4: ( (lv_key_3_0= ruleExtensionColonKey ) )
                    // InternalRos1Parser.g:6821:5: (lv_key_3_0= ruleExtensionColonKey )
                    {
                    // InternalRos1Parser.g:6821:5: (lv_key_3_0= ruleExtensionColonKey )
                    // InternalRos1Parser.g:6822:6: lv_key_3_0= ruleExtensionColonKey
                    {

                    						newCompositeNode(grammarAccess.getExtensionEntryAccess().getKeyExtensionColonKeyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_75);
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

            // InternalRos1Parser.g:6840:3: ( (lv_value_4_0= ruleExtensionValue ) )
            // InternalRos1Parser.g:6841:4: (lv_value_4_0= ruleExtensionValue )
            {
            // InternalRos1Parser.g:6841:4: (lv_value_4_0= ruleExtensionValue )
            // InternalRos1Parser.g:6842:5: lv_value_4_0= ruleExtensionValue
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
    // InternalRos1Parser.g:6863:1: entryRuleExtensionValue returns [EObject current=null] : iv_ruleExtensionValue= ruleExtensionValue EOF ;
    public final EObject entryRuleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionValue = null;


        try {
            // InternalRos1Parser.g:6863:55: (iv_ruleExtensionValue= ruleExtensionValue EOF )
            // InternalRos1Parser.g:6864:2: iv_ruleExtensionValue= ruleExtensionValue EOF
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
    // InternalRos1Parser.g:6870:1: ruleExtensionValue returns [EObject current=null] : (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) ;
    public final EObject ruleExtensionValue() throws RecognitionException {
        EObject current = null;

        EObject this_ExtensionListValue_0 = null;

        EObject this_ExtensionBraceMapValue_1 = null;

        EObject this_ExtensionIndentedMapValue_2 = null;

        EObject this_ExtensionRefValue_3 = null;

        EObject this_ExtensionScalarValue_4 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6876:2: ( (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue ) )
            // InternalRos1Parser.g:6877:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            {
            // InternalRos1Parser.g:6877:2: (this_ExtensionListValue_0= ruleExtensionListValue | this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue | this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue | this_ExtensionRefValue_3= ruleExtensionRefValue | this_ExtensionScalarValue_4= ruleExtensionScalarValue )
            int alt92=5;
            switch ( input.LA(1) ) {
            case LeftSquareBracket:
                {
                alt92=1;
                }
                break;
            case LeftCurlyBracket:
                {
                alt92=2;
                }
                break;
            case RULE_BEGIN:
                {
                alt92=3;
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
                alt92=4;
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
                alt92=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // InternalRos1Parser.g:6878:3: this_ExtensionListValue_0= ruleExtensionListValue
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
                    // InternalRos1Parser.g:6887:3: this_ExtensionBraceMapValue_1= ruleExtensionBraceMapValue
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
                    // InternalRos1Parser.g:6896:3: this_ExtensionIndentedMapValue_2= ruleExtensionIndentedMapValue
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
                    // InternalRos1Parser.g:6905:3: this_ExtensionRefValue_3= ruleExtensionRefValue
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
                    // InternalRos1Parser.g:6914:3: this_ExtensionScalarValue_4= ruleExtensionScalarValue
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
    // InternalRos1Parser.g:6926:1: entryRuleExtensionListValue returns [EObject current=null] : iv_ruleExtensionListValue= ruleExtensionListValue EOF ;
    public final EObject entryRuleExtensionListValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionListValue = null;


        try {
            // InternalRos1Parser.g:6926:59: (iv_ruleExtensionListValue= ruleExtensionListValue EOF )
            // InternalRos1Parser.g:6927:2: iv_ruleExtensionListValue= ruleExtensionListValue EOF
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
    // InternalRos1Parser.g:6933:1: ruleExtensionListValue returns [EObject current=null] : ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) ;
    public final EObject ruleExtensionListValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_items_2_0 = null;

        EObject lv_items_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:6939:2: ( ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket ) )
            // InternalRos1Parser.g:6940:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            {
            // InternalRos1Parser.g:6940:2: ( () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket )
            // InternalRos1Parser.g:6941:3: () otherlv_1= LeftSquareBracket ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )? otherlv_5= RightSquareBracket
            {
            // InternalRos1Parser.g:6941:3: ()
            // InternalRos1Parser.g:6942:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionListValueAccess().getExtensionListValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_76); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionListValueAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalRos1Parser.g:6952:3: ( ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )* )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==Pluginlib||(LA95_0>=Duration && LA95_0<=Feedback)||(LA95_0>=Boolean && LA95_0<=Float64)||LA95_0==Library||(LA95_0>=Message && LA95_0<=Param)||LA95_0==Service||(LA95_0>=Base64 && LA95_0<=Action)||(LA95_0>=Result && LA95_0<=Uint64)||LA95_0==Array||(LA95_0>=Class && LA95_0<=Int64)||LA95_0==Pub||LA95_0==Sub||(LA95_0>=Uint8 && LA95_0<=Any)||LA95_0==LeftSquareBracket||LA95_0==LeftCurlyBracket||(LA95_0>=RULE_BOOLEAN && LA95_0<=RULE_DOUBLE)||(LA95_0>=RULE_ID && LA95_0<=RULE_INT)||LA95_0==RULE_BEGIN) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalRos1Parser.g:6953:4: ( (lv_items_2_0= ruleExtensionValue ) ) ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    {
                    // InternalRos1Parser.g:6953:4: ( (lv_items_2_0= ruleExtensionValue ) )
                    // InternalRos1Parser.g:6954:5: (lv_items_2_0= ruleExtensionValue )
                    {
                    // InternalRos1Parser.g:6954:5: (lv_items_2_0= ruleExtensionValue )
                    // InternalRos1Parser.g:6955:6: lv_items_2_0= ruleExtensionValue
                    {

                    						newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_77);
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

                    // InternalRos1Parser.g:6972:4: ( (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==Pluginlib||(LA94_0>=Duration && LA94_0<=Feedback)||(LA94_0>=Boolean && LA94_0<=Float64)||LA94_0==Library||(LA94_0>=Message && LA94_0<=Param)||LA94_0==Service||(LA94_0>=Base64 && LA94_0<=Action)||(LA94_0>=Result && LA94_0<=Uint64)||LA94_0==Array||(LA94_0>=Class && LA94_0<=Int64)||LA94_0==Pub||LA94_0==Sub||(LA94_0>=Uint8 && LA94_0<=Any)||LA94_0==Comma||LA94_0==LeftSquareBracket||LA94_0==LeftCurlyBracket||(LA94_0>=RULE_BOOLEAN && LA94_0<=RULE_DOUBLE)||(LA94_0>=RULE_ID && LA94_0<=RULE_INT)||LA94_0==RULE_BEGIN) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // InternalRos1Parser.g:6973:5: (otherlv_3= Comma )? ( (lv_items_4_0= ruleExtensionValue ) )
                    	    {
                    	    // InternalRos1Parser.g:6973:5: (otherlv_3= Comma )?
                    	    int alt93=2;
                    	    int LA93_0 = input.LA(1);

                    	    if ( (LA93_0==Comma) ) {
                    	        alt93=1;
                    	    }
                    	    switch (alt93) {
                    	        case 1 :
                    	            // InternalRos1Parser.g:6974:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_75); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionListValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRos1Parser.g:6979:5: ( (lv_items_4_0= ruleExtensionValue ) )
                    	    // InternalRos1Parser.g:6980:6: (lv_items_4_0= ruleExtensionValue )
                    	    {
                    	    // InternalRos1Parser.g:6980:6: (lv_items_4_0= ruleExtensionValue )
                    	    // InternalRos1Parser.g:6981:7: lv_items_4_0= ruleExtensionValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionListValueAccess().getItemsExtensionValueParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_77);
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
                    	    break loop94;
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
    // InternalRos1Parser.g:7008:1: entryRuleExtensionBraceMapValue returns [EObject current=null] : iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF ;
    public final EObject entryRuleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionBraceMapValue = null;


        try {
            // InternalRos1Parser.g:7008:63: (iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF )
            // InternalRos1Parser.g:7009:2: iv_ruleExtensionBraceMapValue= ruleExtensionBraceMapValue EOF
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
    // InternalRos1Parser.g:7015:1: ruleExtensionBraceMapValue returns [EObject current=null] : ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleExtensionBraceMapValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_entries_2_0 = null;

        EObject lv_entries_4_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7021:2: ( ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket ) )
            // InternalRos1Parser.g:7022:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            {
            // InternalRos1Parser.g:7022:2: ( () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket )
            // InternalRos1Parser.g:7023:3: () otherlv_1= LeftCurlyBracket ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )? otherlv_5= RightCurlyBracket
            {
            // InternalRos1Parser.g:7023:3: ()
            // InternalRos1Parser.g:7024:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionBraceMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_72); 

            			newLeafNode(otherlv_1, grammarAccess.getExtensionBraceMapValueAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRos1Parser.g:7034:3: ( ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )* )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( ((LA98_0>=Serviceclients && LA98_0<=Dependencies)||(LA98_0>=FromGitRepo && LA98_0<=Publishers)||LA98_0==Parameter||(LA98_0>=Pluginlib && LA98_0<=Plugins)||(LA98_0>=Boolean && LA98_0<=Format)||(LA98_0>=Library && LA98_0<=Message)||LA98_0==Service||(LA98_0>=Base64 && LA98_0<=Action)||(LA98_0>=Result && LA98_0<=Node_1)||LA98_0==Srvs||(LA98_0>=Type_1 && LA98_0<=List)||(LA98_0>=Bool && LA98_0<=Node)||(LA98_0>=Time && LA98_0<=Ns)||(LA98_0>=RULE_ID && LA98_0<=RULE_STRING)) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalRos1Parser.g:7035:4: ( (lv_entries_2_0= ruleExtensionEntry ) ) ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    {
                    // InternalRos1Parser.g:7035:4: ( (lv_entries_2_0= ruleExtensionEntry ) )
                    // InternalRos1Parser.g:7036:5: (lv_entries_2_0= ruleExtensionEntry )
                    {
                    // InternalRos1Parser.g:7036:5: (lv_entries_2_0= ruleExtensionEntry )
                    // InternalRos1Parser.g:7037:6: lv_entries_2_0= ruleExtensionEntry
                    {

                    						newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_73);
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

                    // InternalRos1Parser.g:7054:4: ( (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) ) )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( ((LA97_0>=Serviceclients && LA97_0<=Dependencies)||(LA97_0>=FromGitRepo && LA97_0<=Publishers)||LA97_0==Parameter||(LA97_0>=Pluginlib && LA97_0<=Plugins)||(LA97_0>=Boolean && LA97_0<=Format)||(LA97_0>=Library && LA97_0<=Message)||LA97_0==Service||(LA97_0>=Base64 && LA97_0<=Action)||(LA97_0>=Result && LA97_0<=Node_1)||LA97_0==Srvs||(LA97_0>=Type_1 && LA97_0<=List)||(LA97_0>=Bool && LA97_0<=Node)||(LA97_0>=Time && LA97_0<=Ns)||LA97_0==Comma||(LA97_0>=RULE_ID && LA97_0<=RULE_STRING)) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // InternalRos1Parser.g:7055:5: (otherlv_3= Comma )? ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    {
                    	    // InternalRos1Parser.g:7055:5: (otherlv_3= Comma )?
                    	    int alt96=2;
                    	    int LA96_0 = input.LA(1);

                    	    if ( (LA96_0==Comma) ) {
                    	        alt96=1;
                    	    }
                    	    switch (alt96) {
                    	        case 1 :
                    	            // InternalRos1Parser.g:7056:6: otherlv_3= Comma
                    	            {
                    	            otherlv_3=(Token)match(input,Comma,FOLLOW_70); 

                    	            						newLeafNode(otherlv_3, grammarAccess.getExtensionBraceMapValueAccess().getCommaKeyword_2_1_0());
                    	            					

                    	            }
                    	            break;

                    	    }

                    	    // InternalRos1Parser.g:7061:5: ( (lv_entries_4_0= ruleExtensionEntry ) )
                    	    // InternalRos1Parser.g:7062:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    {
                    	    // InternalRos1Parser.g:7062:6: (lv_entries_4_0= ruleExtensionEntry )
                    	    // InternalRos1Parser.g:7063:7: lv_entries_4_0= ruleExtensionEntry
                    	    {

                    	    							newCompositeNode(grammarAccess.getExtensionBraceMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_73);
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
                    	    break loop97;
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
    // InternalRos1Parser.g:7090:1: entryRuleExtensionIndentedMapValue returns [EObject current=null] : iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF ;
    public final EObject entryRuleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionIndentedMapValue = null;


        try {
            // InternalRos1Parser.g:7090:66: (iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF )
            // InternalRos1Parser.g:7091:2: iv_ruleExtensionIndentedMapValue= ruleExtensionIndentedMapValue EOF
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
    // InternalRos1Parser.g:7097:1: ruleExtensionIndentedMapValue returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) ;
    public final EObject ruleExtensionIndentedMapValue() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token this_END_3=null;
        EObject lv_entries_2_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7103:2: ( ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END ) )
            // InternalRos1Parser.g:7104:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            {
            // InternalRos1Parser.g:7104:2: ( () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END )
            // InternalRos1Parser.g:7105:3: () this_BEGIN_1= RULE_BEGIN ( (lv_entries_2_0= ruleExtensionEntry ) )+ this_END_3= RULE_END
            {
            // InternalRos1Parser.g:7105:3: ()
            // InternalRos1Parser.g:7106:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionIndentedMapValueAccess().getExtensionMapValueAction_0(),
            					current);
            			

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_70); 

            			newLeafNode(this_BEGIN_1, grammarAccess.getExtensionIndentedMapValueAccess().getBEGINTerminalRuleCall_1());
            		
            // InternalRos1Parser.g:7116:3: ( (lv_entries_2_0= ruleExtensionEntry ) )+
            int cnt99=0;
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( ((LA99_0>=Serviceclients && LA99_0<=Dependencies)||(LA99_0>=FromGitRepo && LA99_0<=Publishers)||LA99_0==Parameter||(LA99_0>=Pluginlib && LA99_0<=Plugins)||(LA99_0>=Boolean && LA99_0<=Format)||(LA99_0>=Library && LA99_0<=Message)||LA99_0==Service||(LA99_0>=Base64 && LA99_0<=Action)||(LA99_0>=Result && LA99_0<=Node_1)||LA99_0==Srvs||(LA99_0>=Type_1 && LA99_0<=List)||(LA99_0>=Bool && LA99_0<=Node)||(LA99_0>=Time && LA99_0<=Ns)||(LA99_0>=RULE_ID && LA99_0<=RULE_STRING)) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // InternalRos1Parser.g:7117:4: (lv_entries_2_0= ruleExtensionEntry )
            	    {
            	    // InternalRos1Parser.g:7117:4: (lv_entries_2_0= ruleExtensionEntry )
            	    // InternalRos1Parser.g:7118:5: lv_entries_2_0= ruleExtensionEntry
            	    {

            	    					newCompositeNode(grammarAccess.getExtensionIndentedMapValueAccess().getEntriesExtensionEntryParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_71);
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
            	    if ( cnt99 >= 1 ) break loop99;
                        EarlyExitException eee =
                            new EarlyExitException(99, input);
                        throw eee;
                }
                cnt99++;
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
    // InternalRos1Parser.g:7143:1: entryRuleExtensionRefValue returns [EObject current=null] : iv_ruleExtensionRefValue= ruleExtensionRefValue EOF ;
    public final EObject entryRuleExtensionRefValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionRefValue = null;


        try {
            // InternalRos1Parser.g:7143:58: (iv_ruleExtensionRefValue= ruleExtensionRefValue EOF )
            // InternalRos1Parser.g:7144:2: iv_ruleExtensionRefValue= ruleExtensionRefValue EOF
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
    // InternalRos1Parser.g:7150:1: ruleExtensionRefValue returns [EObject current=null] : ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) ;
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
            // InternalRos1Parser.g:7156:2: ( ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) ) )
            // InternalRos1Parser.g:7157:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            {
            // InternalRos1Parser.g:7157:2: ( () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) ) )
            // InternalRos1Parser.g:7158:3: () ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) ) ( ( ruleEString ) )
            {
            // InternalRos1Parser.g:7158:3: ()
            // InternalRos1Parser.g:7159:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionRefValueAccess().getExtensionRefValueAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:7165:3: ( ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) ) )
            // InternalRos1Parser.g:7166:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            {
            // InternalRos1Parser.g:7166:4: ( (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param ) )
            // InternalRos1Parser.g:7167:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            {
            // InternalRos1Parser.g:7167:5: (lv_refKind_1_1= Pub | lv_refKind_1_2= Sub | lv_refKind_1_3= Ss | lv_refKind_1_4= Sc | lv_refKind_1_5= As | lv_refKind_1_6= Ac | lv_refKind_1_7= Param )
            int alt100=7;
            switch ( input.LA(1) ) {
            case Pub:
                {
                alt100=1;
                }
                break;
            case Sub:
                {
                alt100=2;
                }
                break;
            case Ss:
                {
                alt100=3;
                }
                break;
            case Sc:
                {
                alt100=4;
                }
                break;
            case As:
                {
                alt100=5;
                }
                break;
            case Ac:
                {
                alt100=6;
                }
                break;
            case Param:
                {
                alt100=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // InternalRos1Parser.g:7168:6: lv_refKind_1_1= Pub
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
                    // InternalRos1Parser.g:7179:6: lv_refKind_1_2= Sub
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
                    // InternalRos1Parser.g:7190:6: lv_refKind_1_3= Ss
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
                    // InternalRos1Parser.g:7201:6: lv_refKind_1_4= Sc
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
                    // InternalRos1Parser.g:7212:6: lv_refKind_1_5= As
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
                    // InternalRos1Parser.g:7223:6: lv_refKind_1_6= Ac
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
                    // InternalRos1Parser.g:7234:6: lv_refKind_1_7= Param
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

            // InternalRos1Parser.g:7247:3: ( ( ruleEString ) )
            // InternalRos1Parser.g:7248:4: ( ruleEString )
            {
            // InternalRos1Parser.g:7248:4: ( ruleEString )
            // InternalRos1Parser.g:7249:5: ruleEString
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
    // InternalRos1Parser.g:7267:1: entryRuleExtensionScalarValue returns [EObject current=null] : iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF ;
    public final EObject entryRuleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtensionScalarValue = null;


        try {
            // InternalRos1Parser.g:7267:61: (iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF )
            // InternalRos1Parser.g:7268:2: iv_ruleExtensionScalarValue= ruleExtensionScalarValue EOF
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
    // InternalRos1Parser.g:7274:1: ruleExtensionScalarValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) ;
    public final EObject ruleExtensionScalarValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7280:2: ( ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) ) )
            // InternalRos1Parser.g:7281:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            {
            // InternalRos1Parser.g:7281:2: ( () ( (lv_value_1_0= ruleExtensionScalarLiteral ) ) )
            // InternalRos1Parser.g:7282:3: () ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            {
            // InternalRos1Parser.g:7282:3: ()
            // InternalRos1Parser.g:7283:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtensionScalarValueAccess().getExtensionScalarValueAction_0(),
            					current);
            			

            }

            // InternalRos1Parser.g:7289:3: ( (lv_value_1_0= ruleExtensionScalarLiteral ) )
            // InternalRos1Parser.g:7290:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            {
            // InternalRos1Parser.g:7290:4: (lv_value_1_0= ruleExtensionScalarLiteral )
            // InternalRos1Parser.g:7291:5: lv_value_1_0= ruleExtensionScalarLiteral
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
    // InternalRos1Parser.g:7312:1: entryRuleExtensionScalarLiteral returns [String current=null] : iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF ;
    public final String entryRuleExtensionScalarLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExtensionScalarLiteral = null;


        try {
            // InternalRos1Parser.g:7312:62: (iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF )
            // InternalRos1Parser.g:7313:2: iv_ruleExtensionScalarLiteral= ruleExtensionScalarLiteral EOF
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
    // InternalRos1Parser.g:7319:1: ruleExtensionScalarLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) ;
    public final AntlrDatatypeRuleToken ruleExtensionScalarLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOLEAN_0=null;
        Token this_DOUBLE_1=null;
        Token this_DECINT_2=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_ExtensionKey_4 = null;



        	enterRule();

        try {
            // InternalRos1Parser.g:7325:2: ( (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey ) )
            // InternalRos1Parser.g:7326:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            {
            // InternalRos1Parser.g:7326:2: (this_BOOLEAN_0= RULE_BOOLEAN | this_DOUBLE_1= RULE_DOUBLE | this_DECINT_2= RULE_DECINT | this_INT_3= RULE_INT | this_ExtensionKey_4= ruleExtensionKey )
            int alt101=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt101=1;
                }
                break;
            case RULE_DOUBLE:
                {
                alt101=2;
                }
                break;
            case RULE_DECINT:
                {
                alt101=3;
                }
                break;
            case RULE_INT:
                {
                alt101=4;
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
                alt101=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // InternalRos1Parser.g:7327:3: this_BOOLEAN_0= RULE_BOOLEAN
                    {
                    this_BOOLEAN_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_2); 

                    			current.merge(this_BOOLEAN_0);
                    		

                    			newLeafNode(this_BOOLEAN_0, grammarAccess.getExtensionScalarLiteralAccess().getBOOLEANTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7335:3: this_DOUBLE_1= RULE_DOUBLE
                    {
                    this_DOUBLE_1=(Token)match(input,RULE_DOUBLE,FOLLOW_2); 

                    			current.merge(this_DOUBLE_1);
                    		

                    			newLeafNode(this_DOUBLE_1, grammarAccess.getExtensionScalarLiteralAccess().getDOUBLETerminalRuleCall_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalRos1Parser.g:7343:3: this_DECINT_2= RULE_DECINT
                    {
                    this_DECINT_2=(Token)match(input,RULE_DECINT,FOLLOW_2); 

                    			current.merge(this_DECINT_2);
                    		

                    			newLeafNode(this_DECINT_2, grammarAccess.getExtensionScalarLiteralAccess().getDECINTTerminalRuleCall_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalRos1Parser.g:7351:3: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_3);
                    		

                    			newLeafNode(this_INT_3, grammarAccess.getExtensionScalarLiteralAccess().getINTTerminalRuleCall_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalRos1Parser.g:7359:3: this_ExtensionKey_4= ruleExtensionKey
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
    // InternalRos1Parser.g:7373:1: rulePluginLoader returns [Enumerator current=null] : ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) ) ;
    public final Enumerator rulePluginLoader() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:7379:2: ( ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) ) )
            // InternalRos1Parser.g:7380:2: ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) )
            {
            // InternalRos1Parser.g:7380:2: ( (enumLiteral_0= Pluginlib ) | (enumLiteral_1= External ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==Pluginlib) ) {
                alt102=1;
            }
            else if ( (LA102_0==External) ) {
                alt102=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalRos1Parser.g:7381:3: (enumLiteral_0= Pluginlib )
                    {
                    // InternalRos1Parser.g:7381:3: (enumLiteral_0= Pluginlib )
                    // InternalRos1Parser.g:7382:4: enumLiteral_0= Pluginlib
                    {
                    enumLiteral_0=(Token)match(input,Pluginlib,FOLLOW_2); 

                    				current = grammarAccess.getPluginLoaderAccess().getPLUGINLIBEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPluginLoaderAccess().getPLUGINLIBEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7389:3: (enumLiteral_1= External )
                    {
                    // InternalRos1Parser.g:7389:3: (enumLiteral_1= External )
                    // InternalRos1Parser.g:7390:4: enumLiteral_1= External
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
    // InternalRos1Parser.g:7400:1: rulePluginSlotValueFormat returns [Enumerator current=null] : ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) ;
    public final Enumerator rulePluginSlotValueFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRos1Parser.g:7406:2: ( ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) ) )
            // InternalRos1Parser.g:7407:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            {
            // InternalRos1Parser.g:7407:2: ( (enumLiteral_0= Class ) | (enumLiteral_1= Library ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==Class) ) {
                alt103=1;
            }
            else if ( (LA103_0==Library) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // InternalRos1Parser.g:7408:3: (enumLiteral_0= Class )
                    {
                    // InternalRos1Parser.g:7408:3: (enumLiteral_0= Class )
                    // InternalRos1Parser.g:7409:4: enumLiteral_0= Class
                    {
                    enumLiteral_0=(Token)match(input,Class,FOLLOW_2); 

                    				current = grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPluginSlotValueFormatAccess().getCLASSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRos1Parser.g:7416:3: (enumLiteral_1= Library )
                    {
                    // InternalRos1Parser.g:7416:3: (enumLiteral_1= Library )
                    // InternalRos1Parser.g:7417:4: enumLiteral_1= Library
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


    protected DFA69 dfa69 = new DFA69(this);
    protected DFA83 dfa83 = new DFA83(this);
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\1\14\6\15\10\uffff";
    static final String dfa_3s = "\7\31\4\uffff\1\31\3\uffff";
    static final String dfa_4s = "\7\174\4\uffff\1\173\3\uffff";
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

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "3866:2: (this_ParameterString_0= ruleParameterString | this_ParameterBase64_1= ruleParameterBase64 | this_ParameterInteger_2= ruleParameterInteger | this_ParameterDouble_3= ruleParameterDouble | this_ParameterBoolean_4= ruleParameterBoolean | this_ParameterList_5= ruleParameterList | this_ParameterStruct_6= ruleParameterStruct )";
        }
    }
    static final String dfa_8s = "\50\uffff";
    static final String dfa_9s = "\36\uffff\6\46\4\uffff";
    static final String dfa_10s = "\1\27\35\uffff\6\31\4\uffff";
    static final String dfa_11s = "\1\170\35\uffff\6\172\4\uffff";
    static final String dfa_12s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\6\uffff\1\40\1\41\1\36\1\37";
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
            "\1\46\2\uffff\3\46\16\uffff\1\46\1\uffff\1\46\2\uffff\1\46\6\uffff\1\46\4\uffff\1\46\7\uffff\1\46\12\uffff\1\46\7\uffff\1\46\1\uffff\1\46\3\uffff\2\46\2\uffff\1\47\23\uffff\2\46\1\uffff\1\46",
            "\1\46\2\uffff\3\46\16\uffff\1\46\1\uffff\1\46\2\uffff\1\46\6\uffff\1\46\4\uffff\1\46\7\uffff\1\46\12\uffff\1\46\7\uffff\1\46\1\uffff\1\46\3\uffff\2\46\2\uffff\1\47\23\uffff\2\46\1\uffff\1\46",
            "\1\46\2\uffff\3\46\16\uffff\1\46\1\uffff\1\46\2\uffff\1\46\6\uffff\1\46\4\uffff\1\46\7\uffff\1\46\12\uffff\1\46\7\uffff\1\46\1\uffff\1\46\3\uffff\2\46\2\uffff\1\47\23\uffff\2\46\1\uffff\1\46",
            "\1\46\2\uffff\3\46\16\uffff\1\46\1\uffff\1\46\2\uffff\1\46\6\uffff\1\46\4\uffff\1\46\7\uffff\1\46\12\uffff\1\46\7\uffff\1\46\1\uffff\1\46\3\uffff\2\46\2\uffff\1\47\23\uffff\2\46\1\uffff\1\46",
            "\1\46\2\uffff\3\46\16\uffff\1\46\1\uffff\1\46\2\uffff\1\46\6\uffff\1\46\4\uffff\1\46\7\uffff\1\46\12\uffff\1\46\7\uffff\1\46\1\uffff\1\46\3\uffff\2\46\2\uffff\1\47\23\uffff\2\46\1\uffff\1\46",
            "\1\46\2\uffff\3\46\16\uffff\1\46\1\uffff\1\46\2\uffff\1\46\6\uffff\1\46\4\uffff\1\46\7\uffff\1\46\12\uffff\1\46\7\uffff\1\46\1\uffff\1\46\3\uffff\2\46\2\uffff\1\47\23\uffff\2\46\1\uffff\1\46",
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

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "5201:2: (this_bool_0= rulebool | this_int8_1= ruleint8 | this_uint8_2= ruleuint8 | this_int16_3= ruleint16 | this_uint16_4= ruleuint16 | this_int32_5= ruleint32 | this_uint32_6= ruleuint32 | this_int64_7= ruleint64 | this_uint64_8= ruleuint64 | this_float32_9= rulefloat32 | this_float64_10= rulefloat64 | this_string0_11= rulestring0 | this_byte_12= rulebyte | this_time_13= ruletime | this_duration_14= ruleduration | this_Header_15= ruleHeader | this_boolArray_16= ruleboolArray | this_int8Array_17= ruleint8Array | this_uint8Array_18= ruleuint8Array | this_int16Array_19= ruleint16Array | this_uint16Array_20= ruleuint16Array | this_int32Array_21= ruleint32Array | this_uint32Array_22= ruleuint32Array | this_int64Array_23= ruleint64Array | this_uint64Array_24= ruleuint64Array | this_float32Array_25= rulefloat32Array | this_float64Array_26= rulefloat64Array | this_string0Array_27= rulestring0Array | this_byteArray_28= rulebyteArray | this_SpecBaseRef_29= ruleSpecBaseRef | this_ArraySpecRef_30= ruleArraySpecRef | this_char_31= rulechar | this_charArray_32= rulecharArray )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000105000L,0x1000000000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000200022000000L,0x0180000000000040L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000101000L,0x1000000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000200022000000L,0x5080000010000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001000L,0x1000000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000200022000010L,0x0180000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000021000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004005000L,0x1000000000002400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004001000L,0x1000000000002400L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004000000L,0x1000000000002400L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00C0200022000000L,0x1180000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000200022000000L,0x1180000000000040L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x1800000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xBC483D9E33800000L,0x1180000085C103C7L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x4000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0xBC483D9E33800002L,0x0180000085C103C7L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000080000000L,0x1000000000000800L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000080000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000200022000000L,0x4080000010000040L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000000000D8F02L,0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00004000000F8F00L,0x1000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0800040000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020008200000L,0x0000000000000020L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000020008200000L,0x1000000000000020L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000200000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000200000L,0x0000001000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000020008000000L,0x0000081000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000008000000L,0x0000081000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x1000000400000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000400008000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x01B0006000000000L,0x0000000000080010L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000008L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000200022000000L,0x0181E10000000040L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000200022000000L,0x0180020000000040L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x4204A00072000000L,0x058000018A020040L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0800040000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0xC3F4E3E0FE2FDF00L,0x018000079FCFAFFFL});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xC3F4E3E0FE2FDF00L,0x118000079FCFAFFFL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0xC3F4E3E0FE2FDF00L,0x018008079FCFAFFFL});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0xC3F4E3E0FE2FDF00L,0x018008179FCFAFFFL});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0xC3F5A1E072000000L,0x0B81C503FFFF53D7L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0xC3F5A1E072000000L,0x0B81C703FFFF53D7L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0xC3F5A1E072000000L,0x0B81C713FFFF53D7L});

}
